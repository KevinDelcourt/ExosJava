/**
 */
package org.lpdql.automaton;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.lpdql.automaton.Transition#getEvent <em>Event</em>}</li>
 *   <li>{@link org.lpdql.automaton.Transition#getAction <em>Action</em>}</li>
 *   <li>{@link org.lpdql.automaton.Transition#getOrigine <em>Origine</em>}</li>
 *   <li>{@link org.lpdql.automaton.Transition#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @see org.lpdql.automaton.AutomatonPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(Input)
	 * @see org.lpdql.automaton.AutomatonPackage#getTransition_Event()
	 * @model
	 * @generated
	 */
	Input getEvent();

	/**
	 * Sets the value of the '{@link org.lpdql.automaton.Transition#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Input value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference list.
	 * The list contents are of type {@link org.lpdql.automaton.Output}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference list.
	 * @see org.lpdql.automaton.AutomatonPackage#getTransition_Action()
	 * @model
	 * @generated
	 */
	EList<Output> getAction();

	/**
	 * Returns the value of the '<em><b>Origine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origine</em>' reference.
	 * @see #setOrigine(State)
	 * @see org.lpdql.automaton.AutomatonPackage#getTransition_Origine()
	 * @model
	 * @generated
	 */
	State getOrigine();

	/**
	 * Sets the value of the '{@link org.lpdql.automaton.Transition#getOrigine <em>Origine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origine</em>' reference.
	 * @see #getOrigine()
	 * @generated
	 */
	void setOrigine(State value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(State)
	 * @see org.lpdql.automaton.AutomatonPackage#getTransition_Destination()
	 * @model
	 * @generated
	 */
	State getDestination();

	/**
	 * Sets the value of the '{@link org.lpdql.automaton.Transition#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(State value);

} // Transition
