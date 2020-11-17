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
package org.obeonetwork.dsl.database.compare.extensions.builders;

import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

public class TypeInstanceChangeBuilder extends ChangeBuilder {

	public TypeInstanceChangeBuilder() {
		super(TypesLibraryPackage.eINSTANCE.getTypeInstance());
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		return null;
		
	}
	
	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		return null;
	}
	
	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		return null;
	}
	
	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		return null;
	}
	
	@Override
	protected Diff handleAlterChange(ReferenceChange change) {
		return null;
	}
}
