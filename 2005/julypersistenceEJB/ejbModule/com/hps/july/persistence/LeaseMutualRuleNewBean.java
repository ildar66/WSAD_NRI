package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ѕравило проведени€ акта взаимозачета
 */
public class LeaseMutualRuleNewBean implements EntityBean {
	public String chargedaterule;
	private javax.ejb.EntityContext entityContext = null;
	public String paydaterule;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer reglament_leaseDocument;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink reglamentLink = null;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public boolean dopchargdatrul;
	/**
	 * Implementation field for persistent attribute: rateType
	 */
	public java.lang.Integer rateType;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getReglamentLink());
	links.addElement(getResourceLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	reglamentLink = null;
	resourceLink = null;
}
/**
 * This method was generated for supporting the associations.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _removeLinks() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	java.util.Enumeration links = _getLinks().elements();
	while (links.hasMoreElements()) {
		try {
			((com.ibm.ivj.ejb.associations.interfaces.Link) (links.nextElement())).remove();
		}
		catch (javax.ejb.FinderException e) {} //Consume Finder error since I am going away
	}
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
}

/**
 * ejbCreate method for a CMP entity bean
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argReglament, Integer argResource,
	String argChargeDateRule, String argPayDateRule,
	boolean argDopChargeDateRule, int argRateType) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	reglament_leaseDocument = argReglament;
	resource_resource = argResource;
	chargedaterule = argChargeDateRule;
	paydaterule = argPayDateRule;
	dopchargdatrul = argDopChargeDateRule;
	rateType = new Integer(argRateType);
}

/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {}
/**
 * Getter method for chargedaterule
 * @return java.lang.String
 */
public java.lang.String getChargedaterule() {
	return chargedaterule;
}
/**
 * Getter method for dopchargdatrul
 */
public boolean getDopchargdatrul() {
	return dopchargdatrul;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for paydaterule
 * @return java.lang.String
 */
public java.lang.String getPaydaterule() {
	return paydaterule;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseMutualReglament getReglament() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseMutualReglament)this.getReglamentLink().value();
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getReglamentKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean reglament_NULLTEST = true;
	reglament_NULLTEST &= (reglament_leaseDocument == null);
	temp.leaseDocument = ((reglament_leaseDocument == null) ? 0 : reglament_leaseDocument.intValue());
	if (reglament_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getReglamentLink() {
	if (reglamentLink == null)
		reglamentLink = new LeaseMutualRuleNewToReglamentLink(this);
	return reglamentLink;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceLink().value();
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean resource_NULLTEST = true;
	resource_NULLTEST &= (resource_resource == null);
	temp.resource = ((resource_resource == null) ? 0 : resource_resource.intValue());
	if (resource_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new LeaseMutualRuleNewToResourceLink(this);
	return resourceLink;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetReglamentKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean reglament_NULLTEST = (inKey == null);
	if (reglament_NULLTEST) reglament_leaseDocument = null; else reglament_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * Setter method for chargedaterule
 * @param newValue java.lang.String
 */
public void setChargedaterule(java.lang.String newValue) {
	this.chargedaterule = newValue;
}
/**
 * Setter method for dopchargdatrul
 */
public void setDopchargdatrul(boolean newValue) {
	this.dopchargdatrul = newValue;
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * Setter method for paydaterule
 * @param newValue java.lang.String
 */
public void setPaydaterule(java.lang.String newValue) {
	this.paydaterule = newValue;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setReglament(com.hps.july.persistence.LeaseMutualReglament aReglament) throws java.rmi.RemoteException {
	this.getReglamentLink().set(aReglament);
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: rateType
	 */
	public java.lang.Integer getRateType() {
		return rateType;
	}
	/**
	 * Set accessor for persistent attribute: rateType
	 */
	public void setRateType(java.lang.Integer newRateType) {
		rateType = newRateType;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("rateType", getRateType());
		h.put("paydaterule", getPaydaterule());
		h.put("reglamentKey", getReglamentKey());
		h.put("chargedaterule", getChargedaterule());
		h.put("resourceKey", getResourceKey());
		h.put("dopchargdatrul", new Boolean(getDopchargdatrul()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Integer localRateType = (java.lang.Integer) h.get("rateType");
		java.lang.String localPaydaterule =
			(java.lang.String) h.get("paydaterule");
		java.lang.String localChargedaterule =
			(java.lang.String) h.get("chargedaterule");
		Boolean localDopchargdatrul = (Boolean) h.get("dopchargdatrul");

		if (h.containsKey("rateType"))
			setRateType((localRateType));
		if (h.containsKey("paydaterule"))
			setPaydaterule((localPaydaterule));
		if (h.containsKey("chargedaterule"))
			setChargedaterule((localChargedaterule));
		if (h.containsKey("dopchargdatrul"))
			setDopchargdatrul((localDopchargdatrul).booleanValue());
	}
}
