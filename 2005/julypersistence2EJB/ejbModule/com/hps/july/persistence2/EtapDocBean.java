package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * ��������� �� ����� ��������� ���������� ���
 * This is an Entity Bean class with CMP fields
 */
public class EtapDocBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public int etaptypeid;
	public int freqpermid;
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedoc;
	public String equiplink;
	public Boolean havepay;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("sitedoc", new Integer(getSitedoc()));
        h.put("havepay", getHavepay());
        h.put("freqpermid", new Integer(getFreqpermid()));
        h.put("etaptypeid", new Integer(getEtaptypeid()));
        h.put("equiplink", getEquiplink());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.Boolean localHavepay = (java.lang.Boolean) h.get("havepay");
        Integer localFreqpermid = (Integer) h.get("freqpermid");
        Integer localEtaptypeid = (Integer) h.get("etaptypeid");
        java.lang.String localEquiplink = (java.lang.String) h.get("equiplink");

        if ( h.containsKey("havepay") )
            setHavepay((localHavepay));
        if ( h.containsKey("freqpermid") )
            setFreqpermid((localFreqpermid).intValue());
        if ( h.containsKey("etaptypeid") )
            setEtaptypeid((localEtaptypeid).intValue());
        if ( h.containsKey("equiplink") )
            setEquiplink((localEquiplink));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {}
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
 * @param argSitedoc int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argSitedoc, int argEtapTypeId, int argFreqPermId) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	sitedoc = argSitedoc;
	etaptypeid = argEtapTypeId;
	freqpermid = argFreqPermId;
	equiplink = null;
	havepay = null;
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
 * @param argSitedoc int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argSitedoc) throws java.rmi.RemoteException {}
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
 * Getter method for equiplink
 */
public java.lang.String getEquiplink() {
	return equiplink;
}
/**
 * Getter method for etaptypeid
 * @return int
 */
public int getEtaptypeid() {
	return etaptypeid;
}
/**
 * Getter method for freqpermid
 * @return int
 */
public int getFreqpermid() {
	return freqpermid;
}
/**
 * Getter method for havepay
 */
public java.lang.Boolean getHavepay() {
	return havepay;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2004 16:21:01)
 * @return int
 */
public int getSitedoc() {
	return sitedoc;
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
 * Setter method for equiplink
 */
public void setEquiplink(java.lang.String newValue) {
	this.equiplink = newValue;
}
/**
 * Setter method for etaptypeid
 * @param newValue int
 */
public void setEtaptypeid(int newValue) {
	this.etaptypeid = newValue;
}
/**
 * Setter method for freqpermid
 * @param newValue int
 */
public void setFreqpermid(int newValue) {
	this.freqpermid = newValue;
}
/**
 * Setter method for havepay
 */
public void setHavepay(java.lang.Boolean newValue) {
	this.havepay = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
