/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen;

import org.junit.Test;

/**
 * Test the liquibase generator
 *
 */
public class LiquibaseGenTests extends AbstractLiquibaseTest {

	/**
	 * Test the generation on change that only contains a single AddIndex change
	 */
	@Test
	public void addIndex() {
		assertGenerationEquals("15-addIndex");
	}

}
