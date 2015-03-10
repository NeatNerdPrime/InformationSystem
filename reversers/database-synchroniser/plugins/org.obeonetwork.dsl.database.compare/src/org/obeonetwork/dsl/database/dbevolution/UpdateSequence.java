/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.obeonetwork.dsl.database.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.UpdateSequence#getNewSequence <em>New Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateSequence()
 * @model
 * @generated
 */
public interface UpdateSequence extends SequenceChange {

	/**
	 * Returns the value of the '<em><b>New Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Sequence</em>' reference.
	 * @see #setNewSequence(Sequence)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateSequence_NewSequence()
	 * @model required="true"
	 * @generated
	 */
	Sequence getNewSequence();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.UpdateSequence#getNewSequence <em>New Sequence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Sequence</em>' reference.
	 * @see #getNewSequence()
	 * @generated
	 */
	void setNewSequence(Sequence value);

} // UpdateSequence
