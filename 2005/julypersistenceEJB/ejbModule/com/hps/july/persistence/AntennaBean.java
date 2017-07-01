package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * �������
 */
public class AntennaBean implements EntityBean {
	public java.math.BigDecimal azant;
	private javax.ejb.EntityContext entityContext = null;
	public java.math.BigDecimal hset1;
	public int idanten;
	public String kindant;
	public java.math.BigDecimal kswn;
	public java.math.BigDecimal lencable;
	public java.math.BigDecimal nakl;
	public String numant;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public java.lang.Integer cableres_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink cableresLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink antena2sectorsLink = null;
	public java.lang.Integer equipment_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink equipmentLink = null;
	public String azvariation;
	public String naklvariation;
	public java.math.BigDecimal inputpower;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink antennaWorkBandsLink = null;
	private int operator;
	public java.lang.Integer operator_operator;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink operatorLink = null;
	private Integer tempOperator;
	private Operator operatorBean = null;
	public Boolean byhand;
	public Integer groundcnt;
	public java.lang.Integer groundresource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink groundresourceLink = null;
	public String locationtype;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink repitersLink = null;
	public Integer storagecard;
	public int datasource;
	public java.math.BigDecimal electricalTilt;
	public int planfacttype;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("azvariation", getAzvariation());
        h.put("azant", getAzant());
        h.put("operatorKey", getOperatorKey());
        h.put("cableresKey", getCableresKey());
        h.put("byhand", getByhand());
        h.put("datasource", new Integer(getDatasource()));
        h.put("hset1", getHset1());
        h.put("groundresourceKey", getGroundresourceKey());
        h.put("locationtype", getLocationtype());
        h.put("naklvariation", getNaklvariation());
        h.put("planfacttype", new Integer(getPlanfacttype()));
        h.put("kswn", getKswn());
        h.put("equipmentKey", getEquipmentKey());
        h.put("electricalTilt", getElectricalTilt());
        h.put("groundcnt", getGroundcnt());
        h.put("nakl", getNakl());
        h.put("kindant", getKindant());
        h.put("idanten", new Integer(getIdanten()));
        h.put("resourceKey", getResourceKey());
        h.put("inputpower", getInputpower());
        h.put("storagecard", getStoragecard());
        h.put("lencable", getLencable());
        h.put("numant", getNumant());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localAzvariation = (java.lang.String) h.get("azvariation");
        java.math.BigDecimal localAzant = (java.math.BigDecimal) h.get("azant");
        java.lang.Boolean localByhand = (java.lang.Boolean) h.get("byhand");
        Integer localDatasource = (Integer) h.get("datasource");
        java.math.BigDecimal localHset1 = (java.math.BigDecimal) h.get("hset1");
        java.lang.String localLocationtype = (java.lang.String) h.get("locationtype");
        java.lang.String localNaklvariation = (java.lang.String) h.get("naklvariation");
        Integer localPlanfacttype = (Integer) h.get("planfacttype");
        java.math.BigDecimal localKswn = (java.math.BigDecimal) h.get("kswn");
        java.math.BigDecimal localElectricalTilt = (java.math.BigDecimal) h.get("electricalTilt");
        java.lang.Integer localGroundcnt = (java.lang.Integer) h.get("groundcnt");
        java.math.BigDecimal localNakl = (java.math.BigDecimal) h.get("nakl");
        java.lang.String localKindant = (java.lang.String) h.get("kindant");
        java.math.BigDecimal localInputpower = (java.math.BigDecimal) h.get("inputpower");
        java.lang.Integer localStoragecard = (java.lang.Integer) h.get("storagecard");
        java.math.BigDecimal localLencable = (java.math.BigDecimal) h.get("lencable");
        java.lang.String localNumant = (java.lang.String) h.get("numant");

        if ( h.containsKey("azvariation") )
            setAzvariation((localAzvariation));
        if ( h.containsKey("azant") )
            setAzant((localAzant));
        if ( h.containsKey("byhand") )
            setByhand((localByhand));
        if ( h.containsKey("datasource") )
            setDatasource((localDatasource).intValue());
        if ( h.containsKey("hset1") )
            setHset1((localHset1));
        if ( h.containsKey("locationtype") )
            setLocationtype((localLocationtype));
        if ( h.containsKey("naklvariation") )
            setNaklvariation((localNaklvariation));
        if ( h.containsKey("planfacttype") )
            setPlanfacttype((localPlanfacttype).intValue());
        if ( h.containsKey("kswn") )
            setKswn((localKswn));
        if ( h.containsKey("electricalTilt") )
            setElectricalTilt((localElectricalTilt));
        if ( h.containsKey("groundcnt") )
            setGroundcnt((localGroundcnt));
        if ( h.containsKey("nakl") )
            setNakl((localNakl));
        if ( h.containsKey("kindant") )
            setKindant((localKindant));
        if ( h.containsKey("inputpower") )
            setInputpower((localInputpower));
        if ( h.containsKey("storagecard") )
            setStoragecard((localStoragecard));
        if ( h.containsKey("lencable") )
            setLencable((localLencable));
        if ( h.containsKey("numant") )
            setNumant((localNumant));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getCableresLink());
	links.addElement(getResourceLink());
	links.addElement(getAntennaWorkBandsLink());
	links.addElement(getOperatorLink());
	links.addElement(getAntena2sectorsLink());
	links.addElement(getEquipmentLink());
	links.addElement(getGroundresourceLink());
	links.addElement(getRepitersLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	cableresLink = null;
	resourceLink = null;
	antennaWorkBandsLink = null;
	operatorLink = null;
	antena2sectorsLink = null;
	equipmentLink = null;
	groundresourceLink = null;
	repitersLink = null;
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
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException {
	this.getRepitersLink().addElement(aRepiters);
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
 * @param argIdanten int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argIdanten, int argResource, String argNumant,
		String argKindant, java.math.BigDecimal argNakl, java.math.BigDecimal argAzant,
		java.math.BigDecimal argHset1, java.math.BigDecimal argLencable,
		int argEquipment) 
			throws javax.ejb.CreateException, java.rmi.RemoteException {

				ejbCreate(argIdanten, argResource, argNumant,	argKindant, argNakl, argAzant,
					argHset1, argLencable, argEquipment, Boolean.TRUE);

				storagecard = null;
				electricalTilt = null;
				planfacttype = 1;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argIdanten int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argIdanten, int argResource, String argNumant,
		String argKindant, java.math.BigDecimal argNakl, java.math.BigDecimal argAzant,
		java.math.BigDecimal argHset1, java.math.BigDecimal argLencable,
		int argEquipment, Boolean argByhand) 
			throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idanten = argIdanten;
	resource_resource = new Integer(argResource);
	numant = argNumant;
	kindant = argKindant;
	nakl = argNakl;
	azant = argAzant;
	hset1 = argHset1;
	lencable = argLencable;
	kswn = null;
	cableres_resource = null;
	equipment_storageplace = new Integer(argEquipment);
	byhand = argByhand;
	locationtype = "O";
	storagecard = null;
	datasource = 0;
	electricalTilt = null;
	planfacttype = 1;
	
	setOperator();
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();

	setOperator();	
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argIdanten int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdanten) throws java.rmi.RemoteException {

	//System.out.println("ejbPostCreate");
	//log(ChangesLogger.CREATE);
	
}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();

	//System.out.println("ejbRemove");
	//log(ChangesLogger.REMOVE);
	
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {

	if(tempOperator == null) {
		System.out.println("ejbStore_Antenna �� ��������� �������� !!!");
		setOperator(null);
	}
	else
		setOperator(operatorBean);
}
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntena2sectors() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAntena2sectorsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAntena2sectorsLink() {
	if (antena2sectorsLink == null)
		antena2sectorsLink = new AntennaToAntena2sectorsLink(this);
	return antena2sectorsLink;
}
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennaWorkBands() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAntennaWorkBandsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAntennaWorkBandsLink() {
	if (antennaWorkBandsLink == null)
		antennaWorkBandsLink = new AntennaToAntennaWorkBandsLink(this);
	return antennaWorkBandsLink;
}
/**
 * Getter method for azant
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAzant() {
	return azant;
}
/**
 * Getter method for azvariation
 */
public java.lang.String getAzvariation() {
	return azvariation;
}
/**
 * Getter method for byhand
 */
public java.lang.Boolean getByhand() {
	return byhand;
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CableResource getCableres() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.CableResource)this.getCableresLink().value();
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getCableresKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean cableres_NULLTEST = true;
	cableres_NULLTEST &= (cableres_resource == null);
	temp.resource = ((cableres_resource == null) ? 0 : cableres_resource.intValue());
	if (cableres_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCableresLink() {
	if (cableresLink == null)
		cableresLink = new AntennaToCableresLink(this);
	return cableresLink;
}
/**
 * Getter method for datasource
 */
public int getDatasource() {
	return datasource;
}
/**
 * Getter method for electricalTilt
 */
public java.math.BigDecimal getElectricalTilt() {
	return electricalTilt;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.EquipmentSet getEquipment() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.EquipmentSet)this.getEquipmentLink().value();
}
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getEquipmentKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean equipment_NULLTEST = true;
	equipment_NULLTEST &= (equipment_storageplace == null);
	temp.storageplace = ((equipment_storageplace == null) ? 0 : equipment_storageplace.intValue());
	if (equipment_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getEquipmentLink() {
	if (equipmentLink == null)
		equipmentLink = new AntennaToEquipmentLink(this);
	return equipmentLink;
}
/**
 * Getter method for groundcnt
 */
public java.lang.Integer getGroundcnt() {
	return groundcnt;
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getGroundresource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getGroundresourceLink().value();
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getGroundresourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean groundresource_NULLTEST = true;
	groundresource_NULLTEST &= (groundresource_resource == null);
	temp.resource = ((groundresource_resource == null) ? 0 : groundresource_resource.intValue());
	if (groundresource_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getGroundresourceLink() {
	if (groundresourceLink == null)
		groundresourceLink = new AntennaToGroundresourceLink(this);
	return groundresourceLink;
}
/**
 * Getter method for hset1
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getHset1() {
	return hset1;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2003 17:33:28)
 * @return int
 */
public int getIdanten() {
	return idanten;
}
/**
 * Getter method for inputpower
 */
public java.math.BigDecimal getInputpower() {
	return inputpower;
}
/**
 * Getter method for kindant
 * @return java.lang.String
 */
public java.lang.String getKindant() {
	return kindant;
}
/**
 * Getter method for kswn
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getKswn() {
	return kswn;
}
/**
 * Getter method for lencable
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLencable() {
	return lencable;
}
/**
 * Getter method for locationtype
 */
public java.lang.String getLocationtype() {
	return locationtype;
}
/**
 * Getter method for nakl
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNakl() {
	return nakl;
}
/**
 * Getter method for naklvariation
 */
public java.lang.String getNaklvariation() {
	return naklvariation;
}
/**
 * Getter method for numant
 * @return java.lang.String
 */
public java.lang.String getNumant() {
	return numant;
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Operator getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Operator)this.getOperatorLink().value();
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OperatorKey getOperatorKey() {
	com.hps.july.persistence.OperatorKey temp = null;
	temp = new com.hps.july.persistence.OperatorKey();
	boolean operator_NULLTEST = true;
	operator_NULLTEST &= (operator_operator == null);
	temp.operator = ((operator_operator == null) ? 0 : operator_operator.intValue());
	if (operator_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOperatorLink() {
	if (operatorLink == null)
		operatorLink = new AntennaToOperatorLink(this);
	return operatorLink;
}
/**
 * Getter method for planfacttype
 */
public int getPlanfacttype() {
	return planfacttype;
}
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRepiters() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getRepitersLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getRepitersLink() {
	if (repitersLink == null)
		repitersLink = new AntennaToRepitersLink(this);
	return repitersLink;
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AntennaResource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.AntennaResource)this.getResourceLink().value();
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
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
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new AntennaToResourceLink(this);
	return resourceLink;
}
/**
 * Getter method for storagecard
 */
public java.lang.Integer getStoragecard() {
	return storagecard;
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCableresKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean cableres_NULLTEST = (inKey == null);
	if (cableres_NULLTEST) cableres_resource = null; else cableres_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetEquipmentKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean equipment_NULLTEST = (inKey == null);
	if (equipment_NULLTEST) equipment_storageplace = null; else equipment_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetGroundresourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean groundresource_NULLTEST = (inKey == null);
	if (groundresource_NULLTEST) groundresource_resource = null; else groundresource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) {
	boolean operator_NULLTEST = (inKey == null);
	if (operator_NULLTEST) operator_operator = null; else operator_operator = (new Integer(inKey.operator));
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException {
	this.getRepitersLink().removeElement(aRepiters);
}
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntena2sectors(com.hps.july.persistence.Antena2sector anAntena2sectors) {
	this.getAntena2sectorsLink().secondaryAddElement(anAntena2sectors);
}
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennaWorkBands(com.hps.july.persistence.AntennaWorkBand anAntennaWorkBands) {
	this.getAntennaWorkBandsLink().secondaryAddElement(anAntennaWorkBands);
}
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRepiters(com.hps.july.persistence.Repiter aRepiters) {
	this.getRepitersLink().secondaryAddElement(aRepiters);
}
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntena2sectors(com.hps.july.persistence.Antena2sector anAntena2sectors) {
	this.getAntena2sectorsLink().secondaryRemoveElement(anAntena2sectors);
}
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennaWorkBands(com.hps.july.persistence.AntennaWorkBand anAntennaWorkBands) {
	this.getAntennaWorkBandsLink().secondaryRemoveElement(anAntennaWorkBands);
}
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRepiters(com.hps.july.persistence.Repiter aRepiters) {
	this.getRepitersLink().secondaryRemoveElement(aRepiters);
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCableres(com.hps.july.persistence.CableResource aCableres) throws java.rmi.RemoteException {
	this.getCableresLink().secondarySet(aCableres);
}
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException {
	this.getEquipmentLink().secondarySet(anEquipment);
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException {
	this.getGroundresourceLink().secondarySet(aGroundresource);
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException {
	this.getOperatorLink().secondarySet(anOperator);
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetResource(com.hps.july.persistence.AntennaResource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().secondarySet(aResource);
}
/**
 * Setter method for azant
 * @param newValue java.math.BigDecimal
 */
public void setAzant(java.math.BigDecimal newValue) {
	this.azant = newValue;
}
/**
 * Setter method for azvariation
 */
public void setAzvariation(java.lang.String newValue) {
	this.azvariation = newValue;
}
/**
 * Setter method for byhand
 */
public void setByhand(java.lang.Boolean newValue) {
	this.byhand = newValue;
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCableres(com.hps.july.persistence.CableResource aCableres) throws java.rmi.RemoteException {
	this.getCableresLink().set(aCableres);
}
/**
 * Setter method for datasource
 */
public void setDatasource(int newValue) {
	this.datasource = newValue;
}
/**
 * Setter method for electricalTilt
 */
public void setElectricalTilt(java.math.BigDecimal newValue) {
	this.electricalTilt = newValue;
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
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException {
	this.getEquipmentLink().set(anEquipment);
}
/**
 * Setter method for groundcnt
 */
public void setGroundcnt(java.lang.Integer newValue) {
	this.groundcnt = newValue;
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException {
	this.getGroundresourceLink().set(aGroundresource);
}
/**
 * Setter method for hset1
 * @param newValue java.math.BigDecimal
 */
public void setHset1(java.math.BigDecimal newValue) {
	this.hset1 = newValue;
}
/**
 * Setter method for inputpower
 */
public void setInputpower(java.math.BigDecimal newValue) {
	this.inputpower = newValue;
}
/**
 * Setter method for kindant
 * @param newValue java.lang.String
 */
public void setKindant(java.lang.String newValue) {
	this.kindant = newValue;
}
/**
 * Setter method for kswn
 * @param newValue java.math.BigDecimal
 */
public void setKswn(java.math.BigDecimal newValue) {
	this.kswn = newValue;
}
/**
 * Setter method for lencable
 * @param newValue java.math.BigDecimal
 */
public void setLencable(java.math.BigDecimal newValue) {
	this.lencable = newValue;
}
/**
 * Setter method for locationtype
 */
public void setLocationtype(java.lang.String newValue) {
	this.locationtype = newValue;
}
/**
 * Setter method for nakl
 * @param newValue java.math.BigDecimal
 */
public void setNakl(java.math.BigDecimal newValue) {
	this.nakl = newValue;
}
/**
 * Setter method for naklvariation
 */
public void setNaklvariation(java.lang.String newValue) {
	this.naklvariation = newValue;
}
/**
 * Setter method for numant
 * @param newValue java.lang.String
 */
public void setNumant(java.lang.String newValue) {
	this.numant = newValue;
}
private void setOperator() throws java.rmi.RemoteException{
		String operatorName = entityContext.getCallerIdentity().getName();
		tempOperator = OperatorObject.getOperatorCode(operatorName);
		operatorBean = null;
		if (tempOperator != null) {
			try {
				OperatorAccessBean oBean = new OperatorAccessBean();
				oBean.setInitKey_operator(tempOperator.intValue());
				oBean.refreshCopyHelper();

				operatorBean = (Operator)oBean.getEJBRef();
				setOperator(operatorBean);
			} catch (Exception e) {
				System.out.println("Antenna. ���������� ���������� ���������");
				e.printStackTrace(System.out);
				setOperator(null);
			}
		} else {
			setOperator(null);
		}
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException {
	this.getOperatorLink().set(anOperator);
}
/**
 * Setter method for planfacttype
 */
public void setPlanfacttype(int newValue) {
	this.planfacttype = newValue;
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.AntennaResource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * Setter method for storagecard
 */
public void setStoragecard(java.lang.Integer newValue) {
	this.storagecard = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}