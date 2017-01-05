/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.interaction.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.parts.CombinedFragmentPropertiesEditionPart;
import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class CombinedFragmentPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The CombinedFragment part
	 * 
	 */
	private CombinedFragmentPropertiesEditionPart combinedFragmentPart;

	/**
	 * The CombinedFragmentCombinedFragmentPropertiesEditionComponent sub component
	 * 
	 */
	protected CombinedFragmentCombinedFragmentPropertiesEditionComponent combinedFragmentCombinedFragmentPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param combinedFragment the EObject to edit
	 * 
	 */
	public CombinedFragmentPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject combinedFragment, String editing_mode) {
		super(editingContext, editing_mode);
		if (combinedFragment instanceof CombinedFragment) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(combinedFragment, PropertiesEditingProvider.class);
			combinedFragmentCombinedFragmentPropertiesEditionComponent = (CombinedFragmentCombinedFragmentPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, CombinedFragmentCombinedFragmentPropertiesEditionComponent.COMBINEDFRAGMENT_PART, CombinedFragmentCombinedFragmentPropertiesEditionComponent.class);
			addSubComponent(combinedFragmentCombinedFragmentPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(combinedFragment, PropertiesEditingProvider.class);
			metadataCptPropertiesEditionComponent = (MetadataCptPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, MetadataCptPropertiesEditionComponent.METADATAS_PART, MetadataCptPropertiesEditionComponent.class);
			addSubComponent(metadataCptPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (CombinedFragmentCombinedFragmentPropertiesEditionComponent.COMBINEDFRAGMENT_PART.equals(key)) {
			combinedFragmentPart = (CombinedFragmentPropertiesEditionPart)combinedFragmentCombinedFragmentPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)combinedFragmentPart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Object, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Object key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (InteractionViewsRepository.CombinedFragment.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			combinedFragmentPart = (CombinedFragmentPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Object key, int kind, EObject element, ResourceSet allResource) {
		if (key == InteractionViewsRepository.CombinedFragment.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
