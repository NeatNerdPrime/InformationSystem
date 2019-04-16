package org.obeonetwork.dsl.environment.design.ui.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;

public class IsModelingPrjOrAirdPropertyTester extends PropertyTester {
	
	private static final String KEY = "isModelingPrjOrAird";

	public IsModelingPrjOrAirdPropertyTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		boolean displayAction = false;
		if (KEY.equals(property)) {
			if (receiver instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) receiver;
				if (selection.size() != 1) {
					return false;
				}
				Object element = selection.getFirstElement();
				displayAction |= isModelingProject(element);
				displayAction |= isAirdFile(element);
			}
		}
		return displayAction;
	}

	private boolean isAirdFile(Object element) {
		return element instanceof IFile && "aird".equals(((IFile) element).getFileExtension());
	}

	private boolean isModelingProject(Object element) {
		return element instanceof IProject && ModelingProject.hasModelingProjectNature((IProject) element);
	}
}
