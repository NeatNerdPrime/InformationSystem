/*******************************************************************************
 * Copyright (c) 2014, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.ui.selector;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.cdo.common.protocol.CDOProtocolConstants;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelector;
import org.eclipse.sirius.table.metamodel.table.DTable;
import org.eclipse.sirius.tree.DTree;

/**
 * A {@link DAnalysisSelector} to have {@link DRepresentation} creation done
 * only on remote DAnalysis expect for {@link DTable} and {@link DTree}, which will be created
 * locally .
 * 
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 */
public class CreateTablesAndTreesLocallyDAnalysisSelector implements DAnalysisSelector {

    private DAnalysisSelector originalDAnalysisSelector;

    /**
     * Default constructor.
     * 
     * @param originalDAnalysisSelector
     *            the original {@link DAnalysisSelector}
     * @param mainDAnalysis
     *            the main {@link DAnalysis} the {@link DAnalysis} of the root
     *            local session resource
     */
    public CreateTablesAndTreesLocallyDAnalysisSelector(DAnalysisSelector originalDAnalysisSelector) {
        this.originalDAnalysisSelector = originalDAnalysisSelector;
    }

    /**
     * Overridden to delegate {@link DAnalysis} selection to the original
     * {@link DAnalysisSelector}.
     * 
     * {@inheritDoc}
     */
    public DAnalysis selectSmartlyAnalysisForAddedResource(Resource resource, Collection<DAnalysis> allAnalysis) {
        return originalDAnalysisSelector.selectSmartlyAnalysisForAddedResource(resource, allAnalysis);
    }

    /**
     * Overridden to restrict {@link DAnalysis} selection for
     * {@link DRepresentation} creation only on remote {@link DAnalysis} if
     * {@link CDOViewpointPreferenceKeys#PREF_ENABLE_LOCAL_REPRESENTATION_CREATION}
     * preference is at false.
     * 
     * {@inheritDoc}
     */
    public DAnalysis selectSmartlyAnalysisForAddedRepresentation(DRepresentation createdDRepresentation, Collection<DAnalysis> allDAnalysis) {
        // Tables and trees are created locally
    	if (createdDRepresentation instanceof DTable || createdDRepresentation instanceof DTree) {
    		DAnalysis selectedDAnalysis = null;
    		Collection<DAnalysis> localDAnalysis = getAllLocalDAnalyses(allDAnalysis);
    		if (localDAnalysis.size() == 1) {
                selectedDAnalysis = localDAnalysis.iterator().next();
            } else {
                selectedDAnalysis = originalDAnalysisSelector.selectSmartlyAnalysisForAddedRepresentation(createdDRepresentation, localDAnalysis);
            }
    		return selectedDAnalysis;
    	} else {
    		// other representations are created as before
    		return originalDAnalysisSelector.selectSmartlyAnalysisForAddedRepresentation(createdDRepresentation, allDAnalysis);
    	}
    }
    
    /**
     * Filter analyses to keep only local ones
     * @param allAnalyses
     * @return
     */
    private Collection<DAnalysis> getAllLocalDAnalyses(Collection<DAnalysis> allAnalyses) {
    	Collection<DAnalysis> localAnalyses = new ArrayList<DAnalysis>();
    	for (DAnalysis dAnalysis : allAnalyses) {
            if (!CDOProtocolConstants.PROTOCOL_NAME.equals(dAnalysis.eResource().getURI().scheme())) {
            	localAnalyses.add(dAnalysis);
            }
    	}
    	return localAnalyses;
    }
}
