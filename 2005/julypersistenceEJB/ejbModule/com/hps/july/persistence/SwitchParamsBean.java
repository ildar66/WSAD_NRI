package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ��������� �����������
 */
public class SwitchParamsBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public java.math.BigDecimal param_level;
	public java.math.BigDecimal param_value;
	public int paramid;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.sql.Date switchaddinfo_act_date;
	public java.lang.Integer switchaddinfo_switch_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink switchaddinfoLink = null;
	public int param_type;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("param_level", getParam_level());
        h.put("paramid", new Integer(getParamid()));
        h.put("param_type", new Integer(getParam_type()));
        h.put("param_value", getParam_value());
        h.put("switchaddinfoKey", getSwitchaddinfoKey());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.math.BigDecimal localParam_level = (java.math.BigDecimal) h.get("param_level");
        Integer localParam_type = (Integer) h.get("param_type");
        java.math.BigDecimal localParam_value = (java.math.BigDecimal) h.get("param_value");

        if ( h.containsKey("param_level") )
            setParam_level((localParam_level));
        if ( h.containsKey("param_type") )
            setParam_type((localParam_type).intValue());
        if ( h.containsKey("param_value") )
            setParam_value((localParam_value));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getSwitchaddinfoLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	switchaddinfoLink = null;
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
 * @param argParamid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argParamid, int argEquipment, java.sql.Date argActDate,
			java.math.BigDecimal argParamLevel, java.math.BigDecimal argParamValue, int argParam_type) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	paramid = argParamid;
	switchaddinfo_switch_storageplace = new Integer(argEquipment);
	switchaddinfo_act_date = argActDate;
	param_level = argParamLevel;
	param_value = argParamValue;
	param_type = argParam_type;
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
 * @param argParamid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argParamid) throws java.rmi.RemoteException {}
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
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for param_level
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getParam_level() {
	return param_level;
}
/**
 * Getter method for param_type
 */
public int getParam_type() {
	return param_type;
}
/**
 * Getter method for param_value
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getParam_value() {
	return param_value;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2003 17:40:20)
 * @return int
 */
public int getParamid() {
	return paramid;
}
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SwitchAddInfo getSwitchaddinfo() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.SwitchAddInfo)this.getSwitchaddinfoLink().value();
}
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SwitchAddInfoKey getSwitchaddinfoKey() {
	com.hps.july.persistence.SwitchAddInfoKey temp = null;
	temp = new com.hps.july.persistence.SwitchAddInfoKey();
	boolean switchaddinfo_NULLTEST = true;
	switchaddinfo_NULLTEST &= (switchaddinfo_act_date == null);
	temp.act_date = switchaddinfo_act_date;
	switchaddinfo_NULLTEST &= (switchaddinfo_switch_storageplace == null);
	temp.switch_storageplace = switchaddinfo_switch_storageplace;
	if (switchaddinfo_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getSwitchaddinfoLink() {
	if (switchaddinfoLink == null)
		switchaddinfoLink = new SwitchParamsToSwitchaddinfoLink(this);
	return switchaddinfoLink;
}
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSwitchaddinfoKey(com.hps.july.persistence.SwitchAddInfoKey inKey) {
	boolean switchaddinfo_NULLTEST = (inKey == null);
	if (switchaddinfo_NULLTEST) switchaddinfo_act_date = null; else switchaddinfo_act_date = inKey.act_date;
	if (switchaddinfo_NULLTEST) switchaddinfo_switch_storageplace = null; else switchaddinfo_switch_storageplace = inKey.switch_storageplace;
}
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSwitchaddinfo(com.hps.july.persistence.SwitchAddInfo aSwitchaddinfo) throws java.rmi.RemoteException {
	this.getSwitchaddinfoLink().secondarySet(aSwitchaddinfo);
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
 * Setter method for param_level
 * @param newValue java.math.BigDecimal
 */
public void setParam_level(java.math.BigDecimal newValue) {
	this.param_level = newValue;
}
/**
 * Setter method for param_type
 */
public void setParam_type(int newValue) {
	this.param_type = newValue;
}
/**
 * Setter method for param_value
 * @param newValue java.math.BigDecimal
 */
public void setParam_value(java.math.BigDecimal newValue) {
	this.param_value = newValue;
}
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSwitchaddinfo(com.hps.july.persistence.SwitchAddInfo aSwitchaddinfo) throws java.rmi.RemoteException {
	this.getSwitchaddinfoLink().set(aSwitchaddinfo);
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
