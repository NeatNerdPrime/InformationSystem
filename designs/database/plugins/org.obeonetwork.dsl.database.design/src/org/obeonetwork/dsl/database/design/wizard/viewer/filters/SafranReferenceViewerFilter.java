package org.obeonetwork.dsl.database.design.wizard.viewer.filters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.eef.ide.ui.ext.widgets.reference.api.IEEFExtReferenceViewerFilterProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.sirius.ext.emf.edit.EditingDomainServices;

public class SafranReferenceViewerFilter implements IEEFExtReferenceViewerFilterProvider {

	@Override
	public List<ViewerFilter> getViewerFilters(ContextKind contextKind) {
		final EditingDomainServices domainServices = new EditingDomainServices();
		List<ViewerFilter> viewerFilters = new ArrayList<ViewerFilter>();
		
		ViewerFilter viewerFilter = new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof EObject) {
					List<IItemPropertyDescriptor> propertyDescriptors = domainServices.getPropertyDescriptors((EObject) element);
					return true;
				} else {
					return true;
				}
			}
		};
		
		viewerFilters.add(viewerFilter);
		return viewerFilters;
	}

}
