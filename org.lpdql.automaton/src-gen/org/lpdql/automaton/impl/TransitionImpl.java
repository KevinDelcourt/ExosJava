/**
 */
package org.lpdql.automaton.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.lpdql.automaton.AutomatonPackage;
import org.lpdql.automaton.Input;
import org.lpdql.automaton.Output;
import org.lpdql.automaton.State;
import org.lpdql.automaton.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.lpdql.automaton.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.lpdql.automaton.impl.TransitionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.lpdql.automaton.impl.TransitionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.lpdql.automaton.impl.TransitionImpl#getOrigine <em>Origine</em>}</li>
 *   <li>{@link org.lpdql.automaton.impl.TransitionImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected Input event;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Output> action;

	/**
	 * The cached value of the '{@link #getOrigine() <em>Origine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigine()
	 * @generated
	 * @ordered
	 */
	protected State origine;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected State destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AutomatonPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomatonPackage.TRANSITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input getEvent() {
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject) event;
			event = (Input) eResolveProxy(oldEvent);
			if (event != oldEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AutomatonPackage.TRANSITION__EVENT,
							oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input basicGetEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(Input newEvent) {
		Input oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomatonPackage.TRANSITION__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Output> getAction() {
		if (action == null) {
			action = new EObjectResolvingEList<Output>(Output.class, this, AutomatonPackage.TRANSITION__ACTION);
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getOrigine() {
		if (origine != null && origine.eIsProxy()) {
			InternalEObject oldOrigine = (InternalEObject) origine;
			origine = (State) eResolveProxy(oldOrigine);
			if (origine != oldOrigine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AutomatonPackage.TRANSITION__ORIGINE,
							oldOrigine, origine));
			}
		}
		return origine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetOrigine() {
		return origine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigine(State newOrigine) {
		State oldOrigine = origine;
		origine = newOrigine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomatonPackage.TRANSITION__ORIGINE, oldOrigine,
					origine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (State) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AutomatonPackage.TRANSITION__DESTINATION,
							oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(State newDestination) {
		State oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomatonPackage.TRANSITION__DESTINATION,
					oldDestination, destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AutomatonPackage.TRANSITION__NAME:
			return getName();
		case AutomatonPackage.TRANSITION__EVENT:
			if (resolve)
				return getEvent();
			return basicGetEvent();
		case AutomatonPackage.TRANSITION__ACTION:
			return getAction();
		case AutomatonPackage.TRANSITION__ORIGINE:
			if (resolve)
				return getOrigine();
			return basicGetOrigine();
		case AutomatonPackage.TRANSITION__DESTINATION:
			if (resolve)
				return getDestination();
			return basicGetDestination();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case AutomatonPackage.TRANSITION__NAME:
			setName((String) newValue);
			return;
		case AutomatonPackage.TRANSITION__EVENT:
			setEvent((Input) newValue);
			return;
		case AutomatonPackage.TRANSITION__ACTION:
			getAction().clear();
			getAction().addAll((Collection<? extends Output>) newValue);
			return;
		case AutomatonPackage.TRANSITION__ORIGINE:
			setOrigine((State) newValue);
			return;
		case AutomatonPackage.TRANSITION__DESTINATION:
			setDestination((State) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case AutomatonPackage.TRANSITION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case AutomatonPackage.TRANSITION__EVENT:
			setEvent((Input) null);
			return;
		case AutomatonPackage.TRANSITION__ACTION:
			getAction().clear();
			return;
		case AutomatonPackage.TRANSITION__ORIGINE:
			setOrigine((State) null);
			return;
		case AutomatonPackage.TRANSITION__DESTINATION:
			setDestination((State) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case AutomatonPackage.TRANSITION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case AutomatonPackage.TRANSITION__EVENT:
			return event != null;
		case AutomatonPackage.TRANSITION__ACTION:
			return action != null && !action.isEmpty();
		case AutomatonPackage.TRANSITION__ORIGINE:
			return origine != null;
		case AutomatonPackage.TRANSITION__DESTINATION:
			return destination != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
