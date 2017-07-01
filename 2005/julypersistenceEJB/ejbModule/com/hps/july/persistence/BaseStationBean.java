package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������� �������
 */
public class BaseStationBean extends EquipmentSetBean {
	public int number;
	public Boolean repeater;
	private final static long serialVersionUID = 3206093459760846163L;
	public String stationName;
	public String stationType;
	public java.lang.Integer controller_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink controllerLink = null;
	public java.lang.Integer switch_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink switchLink = null;
	public Short nstoek;
	public String sttransp;
	public String timebackup;
	public java.sql.Date dateassembafs;
	public java.sql.Date dateassembafs2;
	public java.sql.Date dateconnect;
	public java.sql.Date dateconnect2;
	public java.sql.Date dateonair;
	public java.sql.Date dateonair2;
	public Short netstage;
	public String contype;
	public Short e1qty;
	public Boolean onair;
	public java.sql.Date datebldbeg2;
	public java.sql.Date dateassemb2;
	public java.sql.Date datetest2;
	public java.sql.Date datepr2;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink sectorsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink chanalPowersLink = null;
	public Integer prefixcellid;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("pwrval", getPwrval());
        h.put("dateconnect", getDateconnect());
        h.put("contype", getContype());
        h.put("datebldbeg", getDatebldbeg());
        h.put("createdby", getCreatedby());
        h.put("dateonair2", getDateonair2());
        h.put("storageplace", new Integer(getStorageplace()));
        h.put("dateconnect2", getDateconnect2());
        h.put("datasource", new Integer(getDatasource()));
        h.put("controllerKey", getControllerKey());
        h.put("dateonair", getDateonair());
        h.put("address", getAddress());
        h.put("number", new Integer(getNumber()));
        h.put("closedate", getClosedate());
        h.put("dateassemb", getDateassemb());
        h.put("pwrreserve", getPwrreserve());
        h.put("dateassembafs2", getDateassembafs2());
        h.put("datepr2", getDatepr2());
        h.put("onair", getOnair());
        h.put("datebldbeg2", getDatebldbeg2());
        h.put("created", getCreated());
        h.put("stationType", getStationType());
        h.put("modifiedby", getModifiedby());
        h.put("stationName", getStationName());
        h.put("nstoek", getNstoek());
        h.put("prefixcellid", getPrefixcellid());
        h.put("datepr", getDatepr());
        h.put("positionKey", getPositionKey());
        h.put("timebackup", getTimebackup());
        h.put("operator", getOperator());
        h.put("divisionKey", getDivisionKey());
        h.put("dateassembafs", getDateassembafs());
        h.put("datetest", getDatetest());
        h.put("switchKey", getSwitchKey());
        h.put("equipcomment", getEquipcomment());
        h.put("pwrrescat", getPwrrescat());
        h.put("netstage", getNetstage());
        h.put("pwrcat", getPwrcat());
        h.put("modified", getModified());
        h.put("equipmentState", getEquipmentState());
        h.put("repeater", getRepeater());
        h.put("dateassemb2", getDateassemb2());
        h.put("sttransp", getSttransp());
        h.put("datetest2", getDatetest2());
        h.put("e1qty", getE1qty());
        h.put("name", getName());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.math.BigDecimal localPwrval = (java.math.BigDecimal) h.get("pwrval");
        java.sql.Date localDateconnect = (java.sql.Date) h.get("dateconnect");
        java.lang.String localContype = (java.lang.String) h.get("contype");
        java.sql.Date localDatebldbeg = (java.sql.Date) h.get("datebldbeg");
        java.lang.Integer localCreatedby = (java.lang.Integer) h.get("createdby");
        java.sql.Date localDateonair2 = (java.sql.Date) h.get("dateonair2");
        Integer localStorageplace = (Integer) h.get("storageplace");
        java.sql.Date localDateconnect2 = (java.sql.Date) h.get("dateconnect2");
        Integer localDatasource = (Integer) h.get("datasource");
        java.sql.Date localDateonair = (java.sql.Date) h.get("dateonair");
        java.lang.String localAddress = (java.lang.String) h.get("address");
        Integer localNumber = (Integer) h.get("number");
        java.sql.Date localClosedate = (java.sql.Date) h.get("closedate");
        java.sql.Date localDateassemb = (java.sql.Date) h.get("dateassemb");
        java.lang.Boolean localPwrreserve = (java.lang.Boolean) h.get("pwrreserve");
        java.sql.Date localDateassembafs2 = (java.sql.Date) h.get("dateassembafs2");
        java.sql.Date localDatepr2 = (java.sql.Date) h.get("datepr2");
        java.lang.Boolean localOnair = (java.lang.Boolean) h.get("onair");
        java.sql.Date localDatebldbeg2 = (java.sql.Date) h.get("datebldbeg2");
        java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
        java.lang.String localStationType = (java.lang.String) h.get("stationType");
        java.lang.Integer localModifiedby = (java.lang.Integer) h.get("modifiedby");
        java.lang.String localStationName = (java.lang.String) h.get("stationName");
        java.lang.Short localNstoek = (java.lang.Short) h.get("nstoek");
        java.lang.Integer localPrefixcellid = (java.lang.Integer) h.get("prefixcellid");
        java.sql.Date localDatepr = (java.sql.Date) h.get("datepr");
        java.lang.String localTimebackup = (java.lang.String) h.get("timebackup");
        java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
        java.sql.Date localDateassembafs = (java.sql.Date) h.get("dateassembafs");
        java.sql.Date localDatetest = (java.sql.Date) h.get("datetest");
        java.lang.String localEquipcomment = (java.lang.String) h.get("equipcomment");
        java.lang.String localPwrrescat = (java.lang.String) h.get("pwrrescat");
        java.lang.Short localNetstage = (java.lang.Short) h.get("netstage");
        java.lang.String localPwrcat = (java.lang.String) h.get("pwrcat");
        java.sql.Timestamp localModified = (java.sql.Timestamp) h.get("modified");
        java.lang.String localEquipmentState = (java.lang.String) h.get("equipmentState");
        java.lang.Boolean localRepeater = (java.lang.Boolean) h.get("repeater");
        java.sql.Date localDateassemb2 = (java.sql.Date) h.get("dateassemb2");
        java.lang.String localSttransp = (java.lang.String) h.get("sttransp");
        java.sql.Date localDatetest2 = (java.sql.Date) h.get("datetest2");
        java.lang.Short localE1qty = (java.lang.Short) h.get("e1qty");
        java.lang.String localName = (java.lang.String) h.get("name");

        if ( h.containsKey("pwrval") )
            setPwrval((localPwrval));
        if ( h.containsKey("dateconnect") )
            setDateconnect((localDateconnect));
        if ( h.containsKey("contype") )
            setContype((localContype));
        if ( h.containsKey("datebldbeg") )
            setDatebldbeg((localDatebldbeg));
        if ( h.containsKey("createdby") )
            setCreatedby((localCreatedby));
        if ( h.containsKey("dateonair2") )
            setDateonair2((localDateonair2));
        if ( h.containsKey("storageplace") )
            setStorageplace((localStorageplace).intValue());
        if ( h.containsKey("dateconnect2") )
            setDateconnect2((localDateconnect2));
        if ( h.containsKey("datasource") )
            setDatasource((localDatasource).intValue());
        if ( h.containsKey("dateonair") )
            setDateonair((localDateonair));
        if ( h.containsKey("address") )
            setAddress((localAddress));
        if ( h.containsKey("number") )
            setNumber((localNumber).intValue());
        if ( h.containsKey("closedate") )
            setClosedate((localClosedate));
        if ( h.containsKey("dateassemb") )
            setDateassemb((localDateassemb));
        if ( h.containsKey("pwrreserve") )
            setPwrreserve((localPwrreserve));
        if ( h.containsKey("dateassembafs2") )
            setDateassembafs2((localDateassembafs2));
        if ( h.containsKey("datepr2") )
            setDatepr2((localDatepr2));
        if ( h.containsKey("onair") )
            setOnair((localOnair));
        if ( h.containsKey("datebldbeg2") )
            setDatebldbeg2((localDatebldbeg2));
        if ( h.containsKey("created") )
            setCreated((localCreated));
        if ( h.containsKey("stationType") )
            setStationType((localStationType));
        if ( h.containsKey("modifiedby") )
            setModifiedby((localModifiedby));
        if ( h.containsKey("stationName") )
            setStationName((localStationName));
        if ( h.containsKey("nstoek") )
            setNstoek((localNstoek));
        if ( h.containsKey("prefixcellid") )
            setPrefixcellid((localPrefixcellid));
        if ( h.containsKey("datepr") )
            setDatepr((localDatepr));
        if ( h.containsKey("timebackup") )
            setTimebackup((localTimebackup));
        if ( h.containsKey("operator") )
            setOperator((localOperator));
        if ( h.containsKey("dateassembafs") )
            setDateassembafs((localDateassembafs));
        if ( h.containsKey("datetest") )
            setDatetest((localDatetest));
        if ( h.containsKey("equipcomment") )
            setEquipcomment((localEquipcomment));
        if ( h.containsKey("pwrrescat") )
            setPwrrescat((localPwrrescat));
        if ( h.containsKey("netstage") )
            setNetstage((localNetstage));
        if ( h.containsKey("pwrcat") )
            setPwrcat((localPwrcat));
        if ( h.containsKey("modified") )
            setModified((localModified));
        if ( h.containsKey("equipmentState") )
            setEquipmentState((localEquipmentState));
        if ( h.containsKey("repeater") )
            setRepeater((localRepeater));
        if ( h.containsKey("dateassemb2") )
            setDateassemb2((localDateassemb2));
        if ( h.containsKey("sttransp") )
            setSttransp((localSttransp));
        if ( h.containsKey("datetest2") )
            setDatetest2((localDatetest2));
        if ( h.containsKey("e1qty") )
            setE1qty((localE1qty));
        if ( h.containsKey("name") )
            setName((localName));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getSwitchLink());
	links.addElement(getControllerLink());
	links.addElement(getSectorsLink());
	links.addElement(getChanalPowersLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	switchLink = null;
	controllerLink = null;
	sectorsLink = null;
	chanalPowersLink = null;
}
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addSectors(com.hps.july.persistence.Sector aSectors) throws java.rmi.RemoteException {
	this.getSectorsLink().addElement(aSectors);
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, Integer argDivision, String argName, 
	String argAddress, Integer argPosition ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate( argStorageplace, argDivision, argName, argAddress );
	_initLinks();
	// All CMP fields should be initialized here.
	position_storageplace = argPosition;
	prefixcellid = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, Integer argDivision, String argName, 
	String argAddress, Integer argPosition, String argType, Boolean argRepeater, Integer argNumber, String argSName ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate( argStorageplace, argDivision, argName, argAddress, argPosition );
	_initLinks();
	// All CMP fields should be initialized here.
	controller_storageplace = null;
	switch_storageplace = null;
	
	stationType = argType;
	repeater = argRepeater;
	number = argNumber.intValue();
	stationName = argSName;
	nstoek = null;
	sttransp = null;
	timebackup = null;
	dateassembafs = null;
	dateassembafs2 = null;
	dateconnect = null;
	dateconnect2 = null;
	dateonair = null;
	dateonair2 = null;
	netstage = null;
	contype = null;
	e1qty = null;
	onair = null;
	datebldbeg2 = null;
	dateassemb2 = null;
	datetest2 = null;
	datepr2 = null;
	prefixcellid = null;
}
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getChanalPowers() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getChanalPowersLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getChanalPowersLink() {
	if (chanalPowersLink == null)
		chanalPowersLink = new BaseStationToChanalPowersLink(this);
	return chanalPowersLink;
}
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Controller getController() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Controller)this.getControllerLink().value();
}
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getControllerKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean controller_NULLTEST = true;
	controller_NULLTEST &= (controller_storageplace == null);
	temp.storageplace = ((controller_storageplace == null) ? 0 : controller_storageplace.intValue());
	if (controller_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getControllerLink() {
	if (controllerLink == null)
		controllerLink = new BaseStationToControllerLink(this);
	return controllerLink;
}
/**
 * Getter method for contype
 */
public java.lang.String getContype() {
	return contype;
}
/**
 * Getter method for dateassemb2
 */
public java.sql.Date getDateassemb2() {
	return dateassemb2;
}
/**
 * Getter method for dateassembafs
 */
public java.sql.Date getDateassembafs() {
	return dateassembafs;
}
/**
 * Getter method for dateassembafs2
 */
public java.sql.Date getDateassembafs2() {
	return dateassembafs2;
}
/**
 * Getter method for datebldbeg2
 */
public java.sql.Date getDatebldbeg2() {
	return datebldbeg2;
}
/**
 * Getter method for dateconnect
 */
public java.sql.Date getDateconnect() {
	return dateconnect;
}
/**
 * Getter method for dateconnect2
 */
public java.sql.Date getDateconnect2() {
	return dateconnect2;
}
/**
 * Getter method for dateonair
 */
public java.sql.Date getDateonair() {
	return dateonair;
}
/**
 * Getter method for dateonair2
 */
public java.sql.Date getDateonair2() {
	return dateonair2;
}
/**
 * Getter method for datepr2
 */
public java.sql.Date getDatepr2() {
	return datepr2;
}
/**
 * Getter method for datetest2
 */
public java.sql.Date getDatetest2() {
	return datetest2;
}
/**
 * Getter method for e1qty
 */
public java.lang.Short getE1qty() {
	return e1qty;
}
/**
 * Getter method for netstage
 */
public java.lang.Short getNetstage() {
	return netstage;
}
/**
 * Getter method for nstoek
 */
public java.lang.Short getNstoek() {
	return nstoek;
}
/**
 * Getter method for number
 * @return int
 */
public int getNumber() {
	return number;
}
/**
 * Getter method for onair
 */
public java.lang.Boolean getOnair() {
	return onair;
}
/**
 * Getter method for prefixcellid
 */
public java.lang.Integer getPrefixcellid() {
	return prefixcellid;
}
/**
 * Getter method for repeater
 * @return java.lang.Boolean
 */
public java.lang.Boolean getRepeater() {
	return repeater;
}
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSectors() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getSectorsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getSectorsLink() {
	if (sectorsLink == null)
		sectorsLink = new BaseStationToSectorsLink(this);
	return sectorsLink;
}
/**
 * Getter method for stationName
 * @return java.lang.String
 */
public java.lang.String getStationName() {
	return stationName;
}
/**
 * Getter method for stationType
 * @return java.lang.String
 */
public java.lang.String getStationType() {
	return stationType;
}
/**
 * Getter method for sttransp
 */
public java.lang.String getSttransp() {
	return sttransp;
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Switch getSwitch() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Switch)this.getSwitchLink().value();
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getSwitchKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean switch_NULLTEST = true;
	switch_NULLTEST &= (switch_storageplace == null);
	temp.storageplace = ((switch_storageplace == null) ? 0 : switch_storageplace.intValue());
	if (switch_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getSwitchLink() {
	if (switchLink == null)
		switchLink = new BaseStationToSwitchLink(this);
	return switchLink;
}
/**
 * Getter method for timebackup
 */
public java.lang.String getTimebackup() {
	return timebackup;
}
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetControllerKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean controller_NULLTEST = (inKey == null);
	if (controller_NULLTEST) controller_storageplace = null; else controller_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSwitchKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean switch_NULLTEST = (inKey == null);
	if (switch_NULLTEST) switch_storageplace = null; else switch_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddChanalPowers(com.hps.july.persistence.ChanalPower aChanalPowers) {
	this.getChanalPowersLink().secondaryAddElement(aChanalPowers);
}
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSectors(com.hps.july.persistence.Sector aSectors) {
	this.getSectorsLink().secondaryAddElement(aSectors);
}
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveChanalPowers(com.hps.july.persistence.ChanalPower aChanalPowers) {
	this.getChanalPowersLink().secondaryRemoveElement(aChanalPowers);
}
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSectors(com.hps.july.persistence.Sector aSectors) {
	this.getSectorsLink().secondaryRemoveElement(aSectors);
}
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetController(com.hps.july.persistence.Controller aController) throws java.rmi.RemoteException {
	this.getControllerLink().secondarySet(aController);
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSwitch(com.hps.july.persistence.Switch aSwitch) throws java.rmi.RemoteException {
	this.getSwitchLink().secondarySet(aSwitch);
}
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setController(com.hps.july.persistence.Controller aController) throws java.rmi.RemoteException {
	this.getControllerLink().set(aController);
}
/**
 * Setter method for contype
 */
public void setContype(java.lang.String newValue) {
	this.contype = newValue;
}
/**
 * Setter method for dateassemb2
 */
public void setDateassemb2(java.sql.Date newValue) {
	this.dateassemb2 = newValue;
}
/**
 * Setter method for dateassembafs
 */
public void setDateassembafs(java.sql.Date newValue) {
	this.dateassembafs = newValue;
}
/**
 * Setter method for dateassembafs2
 */
public void setDateassembafs2(java.sql.Date newValue) {
	this.dateassembafs2 = newValue;
}
/**
 * Setter method for datebldbeg2
 */
public void setDatebldbeg2(java.sql.Date newValue) {
	this.datebldbeg2 = newValue;
}
/**
 * Setter method for dateconnect
 */
public void setDateconnect(java.sql.Date newValue) {
	this.dateconnect = newValue;
}
/**
 * Setter method for dateconnect2
 */
public void setDateconnect2(java.sql.Date newValue) {
	this.dateconnect2 = newValue;
}
/**
 * Setter method for dateonair
 */
public void setDateonair(java.sql.Date newValue) {
	this.dateonair = newValue;
}
/**
 * Setter method for dateonair2
 */
public void setDateonair2(java.sql.Date newValue) {
	this.dateonair2 = newValue;
}
/**
 * Setter method for datepr2
 */
public void setDatepr2(java.sql.Date newValue) {
	this.datepr2 = newValue;
}
/**
 * Setter method for datetest2
 */
public void setDatetest2(java.sql.Date newValue) {
	this.datetest2 = newValue;
}
/**
 * Setter method for e1qty
 */
public void setE1qty(java.lang.Short newValue) {
	this.e1qty = newValue;
}
/**
 * Setter method for netstage
 */
public void setNetstage(java.lang.Short newValue) {
	this.netstage = newValue;
}
/**
 * Setter method for nstoek
 */
public void setNstoek(java.lang.Short newValue) {
	this.nstoek = newValue;
}
/**
 * Setter method for number
 * @param newValue int
 */
public void setNumber(int newValue) {
	this.number = newValue;
}
/**
 * Setter method for onair
 */
public void setOnair(java.lang.Boolean newValue) {
	this.onair = newValue;
}
/**
 * Setter method for prefixcellid
 */
public void setPrefixcellid(java.lang.Integer newValue) {
	this.prefixcellid = newValue;
}
/**
 * Setter method for repeater
 * @param newValue java.lang.Boolean
 */
public void setRepeater(java.lang.Boolean newValue) {
	this.repeater = newValue;
}
/**
 * Setter method for stationName
 * @param newValue java.lang.String
 */
public void setStationName(java.lang.String newValue) {
	this.stationName = newValue;
}
/**
 * Setter method for stationType
 * @param newValue java.lang.String
 */
public void setStationType(java.lang.String newValue) {
	this.stationType = newValue;
}
/**
 * Setter method for sttransp
 */
public void setSttransp(java.lang.String newValue) {
	this.sttransp = newValue;
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSwitch(com.hps.july.persistence.Switch aSwitch) throws java.rmi.RemoteException {
	this.getSwitchLink().set(aSwitch);
}
/**
 * Setter method for timebackup
 */
public void setTimebackup(java.lang.String newValue) {
	this.timebackup = newValue;
}
}