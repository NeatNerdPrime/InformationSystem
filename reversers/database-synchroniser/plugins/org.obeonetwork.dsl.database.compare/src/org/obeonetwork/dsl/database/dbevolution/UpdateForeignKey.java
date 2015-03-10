/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Match;
import org.obeonetwork.dsl.database.ForeignKey;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Update Foreign Key</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey#getNewForeignKey <em>New Foreign Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateForeignKey()
 * @model
 * @generated
 */
public interface UpdateForeignKey extends ForeignKeyChange {

	/**
	 * Returns the value of the '<em><b>New Foreign Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Foreign Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Foreign Key</em>' reference.
	 * @see #setNewForeignKey(ForeignKey)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateForeignKey_NewForeignKey()
	 * @model required="true"
	 * @generated
	 */
	ForeignKey getNewForeignKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey#getNewForeignKey <em>New Foreign Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Foreign Key</em>' reference.
	 * @see #getNewForeignKey()
	 * @generated
	 */
	void setNewForeignKey(ForeignKey value);
} // UpdateForeignKey
