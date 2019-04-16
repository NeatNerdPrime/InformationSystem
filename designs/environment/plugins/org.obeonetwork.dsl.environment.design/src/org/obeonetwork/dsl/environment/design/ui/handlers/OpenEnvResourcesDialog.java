package org.obeonetwork.dsl.environment.design.ui.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.tools.api.command.semantic.RemoveSemanticResourceCommand;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.design.internal.EnvironmentRow;
import org.obeonetwork.dsl.environment.design.ui.dialog.EnvironmentResourcesDialog;
import org.obeonetwork.dsl.environment.design.ui.dialog.EnvironmentUsedElementResourceWarning;
import org.obeonetwork.dsl.environment.util.ProvidedModelsService;

public class OpenEnvResourcesDialog extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		ModelingProject project = getModelingProject(event);
		if (project == null) {
			return null;
		}
		
		Session session = getSession(event, project);
		if (session == null) {
			return null;
		}
		
		// if session == null => session pas chargée.
		List<URI> alreadyPresentURIs = session.getSemanticResources().stream().map(Resource::getURI).collect(Collectors.toList());
		
		List<EnvironmentRow> environmentRows = getAllEnvironmentResources(alreadyPresentURIs);
		List<EnvironmentRow> selectedEnvironmentRows = environmentRows.stream().filter(env -> env.selected).collect(Collectors.toList());
		List<EnvironmentRow> nonSelectedEnvironmentRows = environmentRows.stream().filter(env -> !env.selected).collect(Collectors.toList());
		
		selectedEnvironmentRows.sort((er1, er2) -> er1.name.compareTo(er2.name));
		nonSelectedEnvironmentRows.sort((er1, er2) -> er1.name.compareTo(er2.name));
		
		List<EnvironmentRow> sortedEnvironmentRows = new ArrayList<>(selectedEnvironmentRows);
		sortedEnvironmentRows.addAll(nonSelectedEnvironmentRows);
		
		EnvironmentResourcesDialog dialog = new EnvironmentResourcesDialog(shell, sortedEnvironmentRows, project.getProject().getName());
		if (Window.OK == dialog.open()) {
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
			if (ted == null) {
				return null;
			}
			List<EnvironmentRow> newEnvironmentRows = dialog.getEnvironmentRows();
			for (EnvironmentRow row : newEnvironmentRows) {
				// For every environment resources we compare the state before and after the dialog
				if (row.selected && nonSelectedEnvironmentRows.contains(row)) {
					AddSemanticResourceCommand addSemanticResourceCommand = new AddSemanticResourceCommand(session, URI.createURI(row.uri), new NullProgressMonitor());
					ted.getCommandStack().execute(addSemanticResourceCommand);
				} else if (!row.selected && selectedEnvironmentRows.contains(row)) {
					Resource resource = ted.getResourceSet().getResource(URI.createURI(row.uri), false);
					// Find all elements using objects in the resource.
					Map<EObject, List<EObject>> usedTypes = findCrossReferences(session, resource);
					int handlingStatus = Window.OK;
					if (!usedTypes.isEmpty()) {
						handlingStatus = handleSemanticResourceUse(usedTypes, shell, resource.getURI().lastSegment());
					}
					if (Window.OK == handlingStatus) {
						RemoveSemanticResourceCommand removeSemanticResourceCommand = new RemoveSemanticResourceCommand(session, resource, new NullProgressMonitor(), false);
						ted.getCommandStack().execute(removeSemanticResourceCommand);
					}
				}
			}
		}
		return null;
	}

	private ModelingProject getModelingProject(ExecutionEvent event) {
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		Object element = selection.getFirstElement();
		if (element instanceof IFile) {
			element = ((IFile) element).getProject();
		}
		ModelingProject modelingProject = null;
		if (element instanceof IProject && ModelingProject.hasModelingProjectNature((IProject) element)) {
			Option<ModelingProject> modelingProjectOption = ModelingProject.asModelingProject((IProject) element);
			if (modelingProjectOption.some()) {
				modelingProject = modelingProjectOption.get();
			}
		}
		return modelingProject;
	}

	private int handleSemanticResourceUse(Map<EObject, List<EObject>> usedTypes, Shell parentShell, String resourceName) {
		List<EObject> crossReferences = usedTypes.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		List<Resource> roots = computeRoots(crossReferences);
		EnvironmentUsedElementResourceWarning environmentUsedElementResourceWarning = new EnvironmentUsedElementResourceWarning(parentShell, roots, crossReferences, resourceName);
		return environmentUsedElementResourceWarning.open();
	}

	private List<Resource> computeRoots(List<EObject> crossReferences) {
		List<Resource> rootList = new ArrayList<>();
		for (EObject eObject : crossReferences) {
			Resource eResource = eObject.eResource();
			if (!rootList.contains(eResource)) {
				rootList.add(eResource);
			}
		}
		return rootList;
	}

	// This can become very costly when session resources grow.
	private Map<EObject, List<EObject>> findCrossReferences(Session session, Resource resource) {
		Map<EObject, List<EObject>> eObject2CrossReference = new HashMap<>();
		ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
		TreeIterator<EObject> contents = resource.getAllContents();
		while(contents.hasNext()) {
			ArrayList<EObject> crossReferences = new ArrayList<>();
			EObject eObject = contents.next();
			Collection<Setting> references = crossReferencer.getInverseReferences(eObject);
			crossReferences.addAll(references.stream().map(Setting::getEObject).filter(eo -> {
				return !eo.eResource().equals(resource);
			}).collect(Collectors.toList()));
			if (!crossReferences.isEmpty()) {
				eObject2CrossReference.put(eObject, crossReferences);
			}
		}
		return eObject2CrossReference;
	}

	private List<EnvironmentRow> getAllEnvironmentResources(Collection<URI> alreadyPresentURIs) {
		List<EnvironmentRow> environmentRows = new ArrayList<>();
		for (IConfigurationElement configElement : ProvidedModelsService.getProvidedEnvironment()) {
			EnvironmentRow environmentRow = createEnvironmentRowFromConfigElement(configElement);
			environmentRow.selected = alreadyPresentURIs.contains(URI.createURI(environmentRow.uri));
			environmentRows.add(environmentRow);
		}
		return environmentRows;
	}
	
	private static EnvironmentRow createEnvironmentRowFromConfigElement(IConfigurationElement configElement) {
		EnvironmentRow environmentRow = new EnvironmentRow();
		environmentRow.name = configElement.getAttribute("name");
		environmentRow.uri = configElement.getAttribute("uri");
		return environmentRow;
	}

	private Session getSession(ExecutionEvent event, ModelingProject modelingProject) {
		Session session = modelingProject.getSession();
		if (session == null) {
			boolean confirmed = MessageDialog.openConfirm(HandlerUtil.getActiveShell(event), "Session not available", "The session seems closed, do you want to open it? (it might take some time)");
			if (confirmed && modelingProject != null) {
				Option<URI> representationsFileURI = modelingProject.getMainRepresentationsFileURI(new NullProgressMonitor());
				if (representationsFileURI.some()) {
					session = SessionManager.INSTANCE.getSession(representationsFileURI.get(), new NullProgressMonitor());
					if (!session.isOpen()) {
						session.open(new NullProgressMonitor());
						if (!session.isOpen()) {
							session = null;
						}
					}
				}
			}
		}
		return session;
	}
}
