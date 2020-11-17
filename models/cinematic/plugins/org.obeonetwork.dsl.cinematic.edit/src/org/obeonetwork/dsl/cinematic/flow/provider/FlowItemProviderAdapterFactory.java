/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowItemProviderAdapterFactory extends FlowAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.Flow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowItemProvider flowItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.Flow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFlowAdapter() {
		if (flowItemProvider == null) {
			flowItemProvider = new FlowItemProvider(this);
		}

		return flowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.ActionState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionStateItemProvider actionStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.ActionState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActionStateAdapter() {
		if (actionStateItemProvider == null) {
			actionStateItemProvider = new ActionStateItemProvider(this);
		}

		return actionStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.ViewState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewStateItemProvider viewStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.ViewState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createViewStateAdapter() {
		if (viewStateItemProvider == null) {
			viewStateItemProvider = new ViewStateItemProvider(this);
		}

		return viewStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.DecisionState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecisionStateItemProvider decisionStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.DecisionState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDecisionStateAdapter() {
		if (decisionStateItemProvider == null) {
			decisionStateItemProvider = new DecisionStateItemProvider(this);
		}

		return decisionStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.SubflowState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubflowStateItemProvider subflowStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.SubflowState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubflowStateAdapter() {
		if (subflowStateItemProvider == null) {
			subflowStateItemProvider = new SubflowStateItemProvider(this);
		}

		return subflowStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.InitialState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitialStateItemProvider initialStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.InitialState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInitialStateAdapter() {
		if (initialStateItemProvider == null) {
			initialStateItemProvider = new InitialStateItemProvider(this);
		}

		return initialStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.FinalState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinalStateItemProvider finalStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.FinalState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFinalStateAdapter() {
		if (finalStateItemProvider == null) {
			finalStateItemProvider = new FinalStateItemProvider(this);
		}

		return finalStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.AsyncEventState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsyncEventStateItemProvider asyncEventStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.AsyncEventState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAsyncEventStateAdapter() {
		if (asyncEventStateItemProvider == null) {
			asyncEventStateItemProvider = new AsyncEventStateItemProvider(this);
		}

		return asyncEventStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.Transition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionItemProvider transitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransitionAdapter() {
		if (transitionItemProvider == null) {
			transitionItemProvider = new TransitionItemProvider(this);
		}

		return transitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.FlowAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowActionItemProvider flowActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.FlowAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFlowActionAdapter() {
		if (flowActionItemProvider == null) {
			flowActionItemProvider = new FlowActionItemProvider(this);
		}

		return flowActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.FlowEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowEventItemProvider flowEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.FlowEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFlowEventAdapter() {
		if (flowEventItemProvider == null) {
			flowEventItemProvider = new FlowEventItemProvider(this);
		}

		return flowEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.obeonetwork.dsl.cinematic.flow.AbortState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbortStateItemProvider abortStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.obeonetwork.dsl.cinematic.flow.AbortState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbortStateAdapter() {
		if (abortStateItemProvider == null) {
			abortStateItemProvider = new AbortStateItemProvider(this);
		}

		return abortStateItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (flowItemProvider != null) flowItemProvider.dispose();
		if (transitionItemProvider != null) transitionItemProvider.dispose();
		if (actionStateItemProvider != null) actionStateItemProvider.dispose();
		if (viewStateItemProvider != null) viewStateItemProvider.dispose();
		if (decisionStateItemProvider != null) decisionStateItemProvider.dispose();
		if (subflowStateItemProvider != null) subflowStateItemProvider.dispose();
		if (asyncEventStateItemProvider != null) asyncEventStateItemProvider.dispose();
		if (initialStateItemProvider != null) initialStateItemProvider.dispose();
		if (abortStateItemProvider != null) abortStateItemProvider.dispose();
		if (finalStateItemProvider != null) finalStateItemProvider.dispose();
		if (flowActionItemProvider != null) flowActionItemProvider.dispose();
		if (flowEventItemProvider != null) flowEventItemProvider.dispose();
	}

}
