/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Diff;
import org.obeonetwork.dsl.database.Table;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Table Change</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.TableChange#getTable <em>Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getTableChange()
 * @model abstract="true"
 * @generated
 */
public interface TableChange extends DBDiff {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getTableChange_Table()
	 * @model required="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.TableChange#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

} // TableChange
