package org.obeonetwork.dsl.database.compare.extensions.builders;

//import org.eclipse.emf.compare.diff.metamodel.DiffElement;
//import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
//import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
//import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
//import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.dbevolution.AddView;
import org.obeonetwork.dsl.database.dbevolution.AlterView;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveView;
import org.obeonetwork.dsl.database.dbevolution.RenameViewChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange;

public class ViewChangeBuilder extends ChangeBuilder {
	
	public ViewChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getView());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		Comparison comparison = change.getMatch().getComparison();
		TableContainer tableContainer = (TableContainer)change.getMatch().getRight();
		View view = (View) change.getValue();
		return createAddView(comparison, tableContainer, view, change);
	}

	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		View view = (View) change.getValue();
		return createRemoveView(view, change);
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		AlterView alterView = DbevolutionFactory.eINSTANCE.createAlterView();
		alterView.setView((View)change.getRight());
		alterView.setTarget(change.getRight());
		return alterView;
	}
	
	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(change.getAttribute())) {
			return createRenameViewChange(change);
		}
		if (DatabasePackage.eINSTANCE.getView_Query().equals(change.getAttribute())) {
			return createRenameViewChange(change);
		}
		if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(change.getAttribute())) {
			return createUpdateViewCommentChange(change);
		}
		return super.handleAlterChange(change);
	}

	protected AddView createAddView(Comparison comparison, TableContainer tableContainer, View view, ReferenceChange change) {
		
		AddView addView = DbevolutionFactory.eINSTANCE.createAddView();
		addView.setView(view);
		
		fillDBDiff(addView, change);
		
		return addView;
	}
	
	protected RemoveView createRemoveView(View view, ReferenceChange change) {		
		RemoveView removeView = DbevolutionFactory.eINSTANCE.createRemoveView();
		removeView.setView(view);
		
		fillDBDiff(removeView, change);
		
		return removeView;
	}
	
	protected RenameViewChange createRenameViewChange(AttributeChange change) {
		RenameViewChange renameViewChange = DbevolutionFactory.eINSTANCE.createRenameViewChange();
		renameViewChange.setNewView((View)change.getMatch().getLeft());	
		renameViewChange.setView((View)change.getMatch().getRight());
		return renameViewChange;
	}
	
	protected UpdateViewCommentChange createUpdateViewCommentChange(AttributeChange change) {
		UpdateViewCommentChange updateViewCommentChange = DbevolutionFactory.eINSTANCE.createUpdateViewCommentChange();	
		updateViewCommentChange.setNewView((View) change.getMatch().getLeft());			
		updateViewCommentChange.setView((View)change.getMatch().getRight());
		return updateViewCommentChange;
	}
	
}
