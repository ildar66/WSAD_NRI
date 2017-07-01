package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ �� �������� ������
 */
public class LeaseSaldoBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public java.sql.Date SalDate;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public Integer leaseContract;
	public java.math.BigDecimal mainsum;
	public java.math.BigDecimal additionalsum;
	public java.math.BigDecimal mainndssum;
	public java.math.BigDecimal additionalndssum;
	public Boolean istemp;
	public java.lang.Integer maincurrency_currency;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink maincurrencyLink = null;
	public java.lang.Integer additionalcurrency_currency;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink additionalcurrencyLink = null;
	public java.lang.Integer act_leaseDocument;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink actLink = null;
	public boolean saldobyhand;
	public String notes;
	public java.math.BigDecimal msumcalc;
	public java.math.BigDecimal mndscalc;
	public java.math.BigDecimal asumcalc;
	public java.math.BigDecimal andscalc;
	public Integer operator;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("mndscalc", getMndscalc());
        h.put("mainsum", getMainsum());
        h.put("andscalc", getAndscalc());
        h.put("maincurrencyKey", getMaincurrencyKey());
        h.put("mainndssum", getMainndssum());
        h.put("actKey", getActKey());
        h.put("salDate", getSalDate());
        h.put("additionalcurrencyKey", getAdditionalcurrencyKey());
        h.put("additionalndssum", getAdditionalndssum());
        h.put("operator", getOperator());
        h.put("msumcalc", getMsumcalc());
        h.put("notes", getNotes());
        h.put("asumcalc", getAsumcalc());
        h.put("additionalsum", getAdditionalsum());
        h.put("resourceKey", getResourceKey());
        h.put("istemp", getIstemp());
        h.put("resource_resource", getResource_resource());
        h.put("leaseContract", getLeaseContract());
        h.put("saldobyhand", new Boolean(getSaldobyhand()));
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.math.BigDecimal localMndscalc = (java.math.BigDecimal) h.get("mndscalc");
        java.math.BigDecimal localMainsum = (java.math.BigDecimal) h.get("mainsum");
        java.math.BigDecimal localAndscalc = (java.math.BigDecimal) h.get("andscalc");
        java.math.BigDecimal localMainndssum = (java.math.BigDecimal) h.get("mainndssum");
        java.sql.Date localSalDate = (java.sql.Date) h.get("salDate");
        java.math.BigDecimal localAdditionalndssum = (java.math.BigDecimal) h.get("additionalndssum");
        java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
        java.math.BigDecimal localMsumcalc = (java.math.BigDecimal) h.get("msumcalc");
        java.lang.String localNotes = (java.lang.String) h.get("notes");
        java.math.BigDecimal localAsumcalc = (java.math.BigDecimal) h.get("asumcalc");
        java.math.BigDecimal localAdditionalsum = (java.math.BigDecimal) h.get("additionalsum");
        java.lang.Boolean localIstemp = (java.lang.Boolean) h.get("istemp");
        java.lang.Integer localResource_resource = (java.lang.Integer) h.get("resource_resource");
        Boolean localSaldobyhand = (Boolean) h.get("saldobyhand");

        if ( h.containsKey("mndscalc") )
            setMndscalc((localMndscalc));
        if ( h.containsKey("mainsum") )
            setMainsum((localMainsum));
        if ( h.containsKey("andscalc") )
            setAndscalc((localAndscalc));
        if ( h.containsKey("mainndssum") )
            setMainndssum((localMainndssum));
        if ( h.containsKey("salDate") )
            setSalDate((localSalDate));
        if ( h.containsKey("additionalndssum") )
            setAdditionalndssum((localAdditionalndssum));
        if ( h.containsKey("operator") )
            setOperator((localOperator));
        if ( h.containsKey("msumcalc") )
            setMsumcalc((localMsumcalc));
        if ( h.containsKey("notes") )
            setNotes((localNotes));
        if ( h.containsKey("asumcalc") )
            setAsumcalc((localAsumcalc));
        if ( h.containsKey("additionalsum") )
            setAdditionalsum((localAdditionalsum));
        if ( h.containsKey("istemp") )
            setIstemp((localIstemp));
        if ( h.containsKey("resource_resource") )
            setResource_resource((localResource_resource));
        if ( h.containsKey("saldobyhand") )
            setSaldobyhand((localSaldobyhand).booleanValue());

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getResourceLink());
	links.addElement(getMaincurrencyLink());
	links.addElement(getAdditionalcurrencyLink());
	links.addElement(getActLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	resourceLink = null;
	maincurrencyLink = null;
	additionalcurrencyLink = null;
	actLink = null;
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
 * @param argSalDate java.sql.Date
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argLeaseContract, java.sql.Date argSalDate, Integer argResource, 
	Integer argMainCurrency,  
	java.math.BigDecimal argMainSum, java.math.BigDecimal argMainNdsSum, Boolean argIsTemp ) 
  	  throws javax.ejb.CreateException, java.rmi.RemoteException {
		
	_initLinks();
	// All CMP fields should be initialized here.
	leaseContract = argLeaseContract;
	SalDate = argSalDate;
	mainsum = PersistenceUtil.dec(argMainSum, 2);
	mainndssum = PersistenceUtil.dec(argMainNdsSum, 2);
	istemp = argIsTemp;
	maincurrency_currency = argMainCurrency;
	additionalcurrency_currency = null;
	resource_resource = argResource;
	act_leaseDocument = null;
	additionalsum = null;
	additionalndssum = null;
	saldobyhand = false;
	notes = null;
	msumcalc = null;
	mndscalc = null;
	asumcalc = null;
	andscalc = null;
	operator = null;
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
 * @param argSalDate java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(java.sql.Date argSalDate) throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argSalDate java.sql.Date
 * @param argResource com.hps.july.persistence.ResourceKey
 * @param argLeaseContract java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(java.sql.Date argSalDate, ResourceKey argResource, java.lang.Integer argLeaseContract) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseMutualActNew getAct() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseMutualActNew)this.getActLink().value();
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getActKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean act_NULLTEST = true;
	act_NULLTEST &= (act_leaseDocument == null);
	temp.leaseDocument = ((act_leaseDocument == null) ? 0 : act_leaseDocument.intValue());
	if (act_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getActLink() {
	if (actLink == null)
		actLink = new LeaseSaldoToActLink(this);
	return actLink;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getAdditionalcurrency() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getAdditionalcurrencyLink().value();
}
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getAdditionalcurrencyKey() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean additionalcurrency_NULLTEST = true;
	additionalcurrency_NULLTEST &= (additionalcurrency_currency == null);
	temp.currency = ((additionalcurrency_currency == null) ? 0 : additionalcurrency_currency.intValue());
	if (additionalcurrency_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAdditionalcurrencyLink() {
	if (additionalcurrencyLink == null)
		additionalcurrencyLink = new LeaseSaldoToAdditionalcurrencyLink(this);
	return additionalcurrencyLink;
}
/**
 * Getter method for additionalndssum
 */
public java.math.BigDecimal getAdditionalndssum() {
	return additionalndssum;
}
/**
 * Getter method for additionalsum
 */
public java.math.BigDecimal getAdditionalsum() {
	return additionalsum;
}
/**
 * Getter method for andscalc
 */
public java.math.BigDecimal getAndscalc() {
	return andscalc;
}
/**
 * Getter method for asumcalc
 */
public java.math.BigDecimal getAsumcalc() {
	return asumcalc;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for istemp
 */
public java.lang.Boolean getIstemp() {
	return istemp;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 11:04:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseContract() {
	return leaseContract;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getMaincurrency() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getMaincurrencyLink().value();
}
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getMaincurrencyKey() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean maincurrency_NULLTEST = true;
	maincurrency_NULLTEST &= (maincurrency_currency == null);
	temp.currency = ((maincurrency_currency == null) ? 0 : maincurrency_currency.intValue());
	if (maincurrency_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getMaincurrencyLink() {
	if (maincurrencyLink == null)
		maincurrencyLink = new LeaseSaldoToMaincurrencyLink(this);
	return maincurrencyLink;
}
/**
 * Getter method for mainndssum
 */
public java.math.BigDecimal getMainndssum() {
	return mainndssum;
}
/**
 * Getter method for mainsum
 */
public java.math.BigDecimal getMainsum() {
	return mainsum;
}
/**
 * Getter method for mndscalc
 */
public java.math.BigDecimal getMndscalc() {
	return mndscalc;
}
/**
 * Getter method for msumcalc
 */
public java.math.BigDecimal getMsumcalc() {
	return msumcalc;
}
/**
 * Getter method for notes
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Getter method for operator
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceLink().value();
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 10:08:57)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource_resource() {
	return resource_resource;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
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
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new LeaseSaldoToResourceLink(this);
	return resourceLink;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 10:08:57)
 * @return java.sql.Date
 */
public java.sql.Date getSalDate() {
	return SalDate;
}
/**
 * Getter method for saldobyhand
 */
public boolean getSaldobyhand() {
	return saldobyhand;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetActKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean act_NULLTEST = (inKey == null);
	if (act_NULLTEST) act_leaseDocument = null; else act_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAdditionalcurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean additionalcurrency_NULLTEST = (inKey == null);
	if (additionalcurrency_NULLTEST) additionalcurrency_currency = null; else additionalcurrency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMaincurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean maincurrency_NULLTEST = (inKey == null);
	if (maincurrency_NULLTEST) maincurrency_currency = null; else maincurrency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAct(com.hps.july.persistence.LeaseMutualActNew anAct) throws java.rmi.RemoteException {
	this.getActLink().secondarySet(anAct);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAdditionalcurrency(com.hps.july.persistence.Currency anAdditionalcurrency) throws java.rmi.RemoteException {
	this.getAdditionalcurrencyLink().secondarySet(anAdditionalcurrency);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMaincurrency(com.hps.july.persistence.Currency aMaincurrency) throws java.rmi.RemoteException {
	this.getMaincurrencyLink().secondarySet(aMaincurrency);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAct(com.hps.july.persistence.LeaseMutualActNew anAct) throws java.rmi.RemoteException {
	this.getActLink().set(anAct);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAdditionalcurrency(com.hps.july.persistence.Currency anAdditionalcurrency) throws java.rmi.RemoteException {
	this.getAdditionalcurrencyLink().set(anAdditionalcurrency);
}
/**
 * Setter method for additionalndssum
 */
public void setAdditionalndssum(java.math.BigDecimal newValue) {
	this.additionalndssum = newValue;
}
/**
 * Setter method for additionalsum
 */
public void setAdditionalsum(java.math.BigDecimal newValue) {
	this.additionalsum = newValue;
}
/**
 * Setter method for andscalc
 */
public void setAndscalc(java.math.BigDecimal newValue) {
	this.andscalc = newValue;
}
/**
 * Setter method for asumcalc
 */
public void setAsumcalc(java.math.BigDecimal newValue) {
	this.asumcalc = newValue;
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
 * Setter method for istemp
 */
public void setIstemp(java.lang.Boolean newValue) {
	this.istemp = newValue;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMaincurrency(com.hps.july.persistence.Currency aMaincurrency) throws java.rmi.RemoteException {
	this.getMaincurrencyLink().set(aMaincurrency);
}
/**
 * Setter method for mainndssum
 */
public void setMainndssum(java.math.BigDecimal newValue) {
	this.mainndssum = newValue;
}
/**
 * Setter method for mainsum
 */
public void setMainsum(java.math.BigDecimal newValue) {
	this.mainsum = newValue;
}
/**
 * Setter method for mndscalc
 */
public void setMndscalc(java.math.BigDecimal newValue) {
	this.mndscalc = newValue;
}
/**
 * Setter method for msumcalc
 */
public void setMsumcalc(java.math.BigDecimal newValue) {
	this.msumcalc = newValue;
}
/**
 * Setter method for notes
 */
public void setNotes(java.lang.String newValue) {
	this.notes = newValue;
}
/**
 * Setter method for operator
 */
public void setOperator(java.lang.Integer newValue) {
	this.operator = newValue;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 10:08:57)
 * @param newResource_resource java.lang.Integer
 */
public void setResource_resource(java.lang.Integer newResource_resource) {
	resource_resource = newResource_resource;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 10:08:57)
 * @param newSalDate java.sql.Date
 */
public void setSalDate(java.sql.Date newSalDate) {
	SalDate = newSalDate;
}
/**
 * Setter method for saldobyhand
 */
public void setSaldobyhand(boolean newValue) {
	this.saldobyhand = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
