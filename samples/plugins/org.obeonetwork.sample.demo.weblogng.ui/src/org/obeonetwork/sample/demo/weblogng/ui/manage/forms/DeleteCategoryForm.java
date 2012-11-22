package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>DeleteCategory Form</strong>
 * Scenario : Manage
 *
 */
public class DeleteCategoryForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection categoryDescription = new ArrayList();		

	/**
	 * Return categoryDescription
	 * @return 
	 */
	 public Collection getCategoryDescription() {
		return categoryDescription;
	}
	
	/**
	 * Set a value to parameter categoryDescription.
	 * @param categoryDescription 
	 */
	 public void setCategoryDescription(Collection categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.categoryDescription.clear();
	}

// Start of user code for other methods  	
// End of user code
	
}