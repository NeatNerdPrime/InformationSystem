package org.obeonetwork.dsl.is.design.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.internal.edit.parts.DEdgeBeginNameEditPart;
import org.eclipse.sirius.diagram.internal.edit.parts.DEdgeEndNameEditPart;
import org.eclipse.sirius.diagram.part.SiriusVisualIDRegistry;
import org.eclipse.sirius.diagram.tools.api.command.GMFCommandWrapper;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.is.design.service.EnvironmentService;

public class EnvironmentEditPartProvider  extends AbstractEditPartProvider {
	
	@Override
	public IGraphicalEditPart createGraphicEditPart(View view) {
		switch (SiriusVisualIDRegistry.getVisualID(view)) {

		case DEdgeBeginNameEditPart.VISUAL_ID:
			DEdgeBeginNameEditPart dEdgePart = new DEdgeBeginNameEditPart(view) {

				@Override
				protected boolean isDirectEditEnabled() {
					return true;
				}

			};
			dEdgePart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT, new EnvironmentDirectEditForBeginRole());
			return dEdgePart;

		case DEdgeEndNameEditPart.VISUAL_ID:
			DEdgeEndNameEditPart dEdgeEndPart = new DEdgeEndNameEditPart(view) {
				@Override
				protected boolean isDirectEditEnabled() {
					return true;
				}

			};
			dEdgeEndPart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT, new EnvironmentDirectEditForEndRole());
			return dEdgeEndPart;
		}
		return null;
	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();
			if (view.getElement() instanceof DSemanticDecorator) {
				if (((DSemanticDecorator)view.getElement()).getTarget() instanceof Reference) {
					switch (SiriusVisualIDRegistry.getVisualID(view)) {

						case DEdgeBeginNameEditPart.VISUAL_ID:
							return true;

						case DEdgeEndNameEditPart.VISUAL_ID:
							return true;
					}
				}
			}

		}
		return false;
	}
	
	class EnvironmentDirectEditForBeginRole extends LabelDirectEditPolicy {

		protected org.eclipse.gef.commands.Command getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest edit) {
			final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)getHost()).resolveSemanticElement();
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			final String labelText = (String)edit.getCellEditor().getValue();
			RecordingCommand cmd = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (element instanceof DSemanticDecorator) {
						EObject target = ((DSemanticDecorator)element).getTarget();
						if (target instanceof Reference) {
							Reference reference = (Reference)target;
							Reference oppositeReference = reference.getOppositeOf();
							if (oppositeReference != null) {
								String name = EnvironmentService.getRefNameFromString(oppositeReference, labelText);
								MultiplicityKind multiplicity = EnvironmentService.getMultKindFromString(oppositeReference, labelText);
								oppositeReference.setName(name);
								oppositeReference.setMultiplicity(multiplicity);
							}
						}
					}
				}
			};
			return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

		};

	}
	
	class EnvironmentDirectEditForEndRole extends LabelDirectEditPolicy {

		protected org.eclipse.gef.commands.Command getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest edit) {
			final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)getHost()).resolveSemanticElement();
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			final String labelText = (String)edit.getCellEditor().getValue();
			RecordingCommand cmd = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (element instanceof DSemanticDecorator) {
						EObject target = ((DSemanticDecorator)element).getTarget();
						if (target instanceof Reference) {
							Reference reference = (Reference)target;
							String name = EnvironmentService.getRefNameFromString(reference, labelText);
							MultiplicityKind multiplicity = EnvironmentService.getMultKindFromString(reference, labelText);
							reference.setName(name);
							reference.setMultiplicity(multiplicity);
						}
					}
				}
			};
			return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

		};

	}
}
