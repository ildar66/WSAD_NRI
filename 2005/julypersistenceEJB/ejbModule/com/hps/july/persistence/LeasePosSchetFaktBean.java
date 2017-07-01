package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������� �����-������� ������
 */
public class LeasePosSchetFaktBean implements EntityBean {
	public String country;
	public String edizm;
	private javax.ejb.EntityContext entityContext = null;
	public java.math.BigDecimal excise;
	public int idPosSchetFakt;
	public String nameResource;
	public String numGTD;
	public int posorder;
	public java.math.BigDecimal price;
	public java.math.BigDecimal qty;
	public java.math.BigDecimal rateNds;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal sumFreeTax;
	public java.math.BigDecimal sumNds;
	public java.math.BigDecimal sumWithTax;
	public java.lang.Integer idSchetFakt_idSchetFakt;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink idSchetFaktLink = null;
	public java.lang.Integer resourceNri_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceNriLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("qty", getQty());
        h.put("sumNds", getSumNds());
        h.put("country", getCountry());
        h.put("sumFreeTax", getSumFreeTax());
        h.put("nameResource", getNameResource());
        h.put("excise", getExcise());
        h.put("rateNds", getRateNds());
        h.put("posorder", new Integer(getPosorder()));
        h.put("edizm", getEdizm());
        h.put("resourceNriKey", getResourceNriKey());
        h.put("idSchetFaktKey", getIdSchetFaktKey());
        h.put("price", getPrice());
        h.put("idPosSchetFakt", new Integer(getIdPosSchetFakt()));
        h.put("sumWithTax", getSumWithTax());
        h.put("numGTD", getNumGTD());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
        java.math.BigDecimal localSumNds = (java.math.BigDecimal) h.get("sumNds");
        java.lang.String localCountry = (java.lang.String) h.get("country");
        java.math.BigDecimal localSumFreeTax = (java.math.BigDecimal) h.get("sumFreeTax");
        java.lang.String localNameResource = (java.lang.String) h.get("nameResource");
        java.math.BigDecimal localExcise = (java.math.BigDecimal) h.get("excise");
        java.math.BigDecimal localRateNds = (java.math.BigDecimal) h.get("rateNds");
        Integer localPosorder = (Integer) h.get("posorder");
        java.lang.String localEdizm = (java.lang.String) h.get("edizm");
        java.math.BigDecimal localPrice = (java.math.BigDecimal) h.get("price");
        Integer localIdPosSchetFakt = (Integer) h.get("idPosSchetFakt");
        java.math.BigDecimal localSumWithTax = (java.math.BigDecimal) h.get("sumWithTax");
        java.lang.String localNumGTD = (java.lang.String) h.get("numGTD");

        if ( h.containsKey("qty") )
            setQty((localQty));
        if ( h.containsKey("sumNds") )
            setSumNds((localSumNds));
        if ( h.containsKey("country") )
            setCountry((localCountry));
        if ( h.containsKey("sumFreeTax") )
            setSumFreeTax((localSumFreeTax));
        if ( h.containsKey("nameResource") )
            setNameResource((localNameResource));
        if ( h.containsKey("excise") )
            setExcise((localExcise));
        if ( h.containsKey("rateNds") )
            setRateNds((localRateNds));
        if ( h.containsKey("posorder") )
            setPosorder((localPosorder).intValue());
        if ( h.containsKey("edizm") )
            setEdizm((localEdizm));
        if ( h.containsKey("price") )
            setPrice((localPrice));
        if ( h.containsKey("idPosSchetFakt") )
            setIdPosSchetFakt((localIdPosSchetFakt).intValue());
        if ( h.containsKey("sumWithTax") )
            setSumWithTax((localSumWithTax));
        if ( h.containsKey("numGTD") )
            setNumGTD((localNumGTD));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getIdSchetFaktLink());
	links.addElement(getResourceNriLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	idSchetFaktLink = null;
	resourceNriLink = null;
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
 * @param argIdPosSchetFakt int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argIdPosSchetFakt, Integer idSchetFakt, Integer argPosorder, Integer resourceNri) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idPosSchetFakt = argIdPosSchetFakt.intValue();
	idSchetFakt_idSchetFakt = idSchetFakt;
	posorder = argPosorder.intValue();
	resourceNri_resource = resourceNri;
	country = null;
	edizm = null;
	excise = null;
	nameResource = null;
	numGTD = null;
	price = null;
	qty = null;
	rateNds = null;
	sumFreeTax = null;
	sumNds = null;
	sumWithTax = null;
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
 * @param argIdPosSchetFakt int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdPosSchetFakt) throws java.rmi.RemoteException {}
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
 * Getter method for country
 * @return java.lang.String
 */
public java.lang.String getCountry() {
	return country;
}
/**
 * Getter method for edizm
 * @return java.lang.String
 */
public java.lang.String getEdizm() {
	return edizm;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for excise
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getExcise() {
	return excise;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 20:02:50)
 * @return int
 */
public int getIdPosSchetFakt() {
	return idPosSchetFakt;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseSchetFakt getIdSchetFakt() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseSchetFakt)this.getIdSchetFaktLink().value();
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseSchetFaktKey getIdSchetFaktKey() {
	com.hps.july.persistence.LeaseSchetFaktKey temp = null;
	temp = new com.hps.july.persistence.LeaseSchetFaktKey();
	boolean idSchetFakt_NULLTEST = true;
	idSchetFakt_NULLTEST &= (idSchetFakt_idSchetFakt == null);
	temp.idSchetFakt = ((idSchetFakt_idSchetFakt == null) ? 0 : idSchetFakt_idSchetFakt.intValue());
	if (idSchetFakt_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getIdSchetFaktLink() {
	if (idSchetFaktLink == null)
		idSchetFaktLink = new LeasePosSchetFaktToIdSchetFaktLink(this);
	return idSchetFaktLink;
}
/**
 * Getter method for nameResource
 * @return java.lang.String
 */
public java.lang.String getNameResource() {
	return nameResource;
}
/**
 * Getter method for numGTD
 * @return java.lang.String
 */
public java.lang.String getNumGTD() {
	return numGTD;
}
/**
 * Getter method for posorder
 * @return int
 */
public int getPosorder() {
	return posorder;
}
/**
 * Getter method for price
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Getter method for qty
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
/**
 * Getter method for rateNds
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateNds() {
	return rateNds;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResourceNri() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceNriLink().value();
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceNriKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean resourceNri_NULLTEST = true;
	resourceNri_NULLTEST &= (resourceNri_resource == null);
	temp.resource = ((resourceNri_resource == null) ? 0 : resourceNri_resource.intValue());
	if (resourceNri_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceNriLink() {
	if (resourceNriLink == null)
		resourceNriLink = new LeasePosSchetFaktToResourceNriLink(this);
	return resourceNriLink;
}
/**
 * Getter method for sumFreeTax
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumFreeTax() {
	return sumFreeTax;
}
/**
 * Getter method for sumNds
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumNds() {
	return sumNds;
}
/**
 * Getter method for sumWithTax
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumWithTax() {
	return sumWithTax;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetIdSchetFaktKey(com.hps.july.persistence.LeaseSchetFaktKey inKey) {
	boolean idSchetFakt_NULLTEST = (inKey == null);
	if (idSchetFakt_NULLTEST) idSchetFakt_idSchetFakt = null; else idSchetFakt_idSchetFakt = (new Integer(inKey.idSchetFakt));
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceNriKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resourceNri_NULLTEST = (inKey == null);
	if (resourceNri_NULLTEST) resourceNri_resource = null; else resourceNri_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetIdSchetFakt(com.hps.july.persistence.LeaseSchetFakt anIdSchetFakt) throws java.rmi.RemoteException {
	this.getIdSchetFaktLink().secondarySet(anIdSchetFakt);
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetResourceNri(com.hps.july.persistence.Resource aResourceNri) throws java.rmi.RemoteException {
	this.getResourceNriLink().secondarySet(aResourceNri);
}
/**
 * Setter method for country
 * @param newValue java.lang.String
 */
public void setCountry(java.lang.String newValue) {
	this.country = newValue;
}
/**
 * Setter method for edizm
 * @param newValue java.lang.String
 */
public void setEdizm(java.lang.String newValue) {
	this.edizm = newValue;
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
 * Setter method for excise
 * @param newValue java.math.BigDecimal
 */
public void setExcise(java.math.BigDecimal newValue) {
	this.excise = PersistenceUtil.dec(newValue,2);
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 20:02:50)
 * @param newIdPosSchetFakt int
 */
public void setIdPosSchetFakt(int newIdPosSchetFakt) {
	idPosSchetFakt = newIdPosSchetFakt;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setIdSchetFakt(com.hps.july.persistence.LeaseSchetFakt anIdSchetFakt) throws java.rmi.RemoteException {
	this.getIdSchetFaktLink().set(anIdSchetFakt);
}
/**
 * Setter method for nameResource
 * @param newValue java.lang.String
 */
public void setNameResource(java.lang.String newValue) {
	this.nameResource = newValue;
}
/**
 * Setter method for numGTD
 * @param newValue java.lang.String
 */
public void setNumGTD(java.lang.String newValue) {
	this.numGTD = newValue;
}
/**
 * Setter method for posorder
 * @param newValue int
 */
public void setPosorder(int newValue) {
	this.posorder = newValue;
}
/**
 * Setter method for price
 * @param newValue java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newValue) {
	this.price = PersistenceUtil.dec(newValue, 2);
}
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newValue) {
	this.qty = PersistenceUtil.dec(newValue, 3);
}
/**
 * Setter method for rateNds
 * @param newValue java.math.BigDecimal
 */
public void setRateNds(java.math.BigDecimal newValue) {
	this.rateNds = PersistenceUtil.dec(newValue, 2);
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResourceNri(com.hps.july.persistence.Resource aResourceNri) throws java.rmi.RemoteException {
	this.getResourceNriLink().set(aResourceNri);
}
/**
 * Setter method for sumFreeTax
 * @param newValue java.math.BigDecimal
 */
public void setSumFreeTax(java.math.BigDecimal newValue) {
	this.sumFreeTax = PersistenceUtil.dec(newValue, 2);
}
/**
 * Setter method for sumNds
 * @param newValue java.math.BigDecimal
 */
public void setSumNds(java.math.BigDecimal newValue) {
	this.sumNds = PersistenceUtil.dec(newValue, 2);
}
/**
 * Setter method for sumWithTax
 * @param newValue java.math.BigDecimal
 */
public void setSumWithTax(java.math.BigDecimal newValue) {
	this.sumWithTax = PersistenceUtil.dec(newValue, 2);
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}