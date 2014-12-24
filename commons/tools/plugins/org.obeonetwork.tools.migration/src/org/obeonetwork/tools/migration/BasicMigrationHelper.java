package org.obeonetwork.tools.migration;

import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.ResourceHandler;

abstract public class BasicMigrationHelper implements IMigrationHelper {
	
	private boolean migrationNeeded = false;
	
	public boolean isMigrationNeeded() {
		return migrationNeeded;
	}

	public void setMigrationNeeded(boolean migrationNeeded) {
		this.migrationNeeded = migrationNeeded;
	}

	abstract public Map<String, EPackage> getOldURIToPackageMap();
	
	@Override
	public ExtendedMetaData getExtendedMetaData() {
		return new MigrationExtendedMetaData(this);
	}

	@Override
	public ResourceHandler getResourceHandler() {
		return new MigrationResourceHandler(this);
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		return null;
	}

	@Override
	public XMLHelper createXMLHelper(XMLResource resource) {
		return new MigrationXMLHelper(resource, this);
	}

	@Override
	public EPackage getPackage(String namespace) {
		for (Entry<String, EPackage> packageMapping : getOldURIToPackageMap().entrySet()) {
			if (packageMapping.getKey().equals(namespace)) {
				return packageMapping.getValue();
			}
		}
		return null;
	}

	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		return null;
	}

	@Override
	public String getNamespace(EPackage ePackage) {
		return null;
	}

	@Override
	public String getName(EClassifier eClassifier) {
		return null;
	}

	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		return null;
	}

	@Override
	public void preLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
	}

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream,	Map<?, ?> options) {
	}

	@Override
	public void handleUnknownFeaturesMixedValue(EObject owner, FeatureMap featureMap) {
	}

	@Override
	public void handleUnknownFeaturesAnyAttribute(EObject owner, FeatureMap featureMap) {
	}

	@Override
	public boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		return false;
	}

	@Override
	public EObject createObject(EFactory eFactory, EClassifier type, MigrationXMLHelper parentHelper) {
		return null;
	}

	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position, MigrationXMLHelper parentHelper) {
		return false;
	}

}
