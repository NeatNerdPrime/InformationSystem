/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.ui.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.soa.gen.swagger.ui.handlers.messages"; //$NON-NLS-1$
	public static String GenerateComponentsSwaggerWizard_ResultDialog_Failure_message;
	public static String GenerateComponentsSwaggerWizard_ResultDialog_see_log_message;
	public static String GenerateComponentsSwaggerWizard_ResultDialog_Success_message;
	public static String GenerateComponentsSwaggerWizard_ResultDialog_Swagger_version;
	public static String GenerateComponentsSwaggerWizard_ResultDialog_Title;
	public static String GenerateComponentsSwaggerWizard_ResultDialog_Warning_message;
	public static String GenerateComponentsSwaggerWizard_Title;
	public static String ImportSwaggerHandler_ResultDialog_Failure_message;
	public static String ImportSwaggerHandler_ResultDialog_Success_message;
	public static String ImportSwaggerHandler_ResultDialog_Title;
	public static String ImportSwaggerHandler_ResultDialog_Warning_message;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
