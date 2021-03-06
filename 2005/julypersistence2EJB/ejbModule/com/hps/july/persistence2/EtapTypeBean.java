package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * ���� ������ ��������� ����������
 * This is an Entity Bean class with CMP fields
 */
public class EtapTypeBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public int etaptypeid;
	public String ettypename;
	public boolean haveendtime;
	private final static long serialVersionUID = 3206093459760846163L;
	public boolean havehopslink;
	public boolean havepaycheck;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("haveendtime", new Boolean(getHaveendtime()));
        h.put("havepaycheck", new Boolean(getHavepaycheck()));
        h.put("ettypename", getEttypename());
        h.put("havehopslink", new Boolean(getHavehopslink()));
        h.put("etaptypeid", new Integer(getEtaptypeid()));
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        Boolean localHaveendtime = (Boolean) h.get("haveendtime");
        Boolean localHavepaycheck = (Boolean) h.get("havepaycheck");
        java.lang.String localEttypename = (java.lang.String) h.get("ettypename");
        Boolean localHavehopslink = (Boolean) h.get("havehopslink");

        if ( h.containsKey("haveendtime") )
            setHaveendtime((localHaveendtime).booleanValue());
        if ( h.containsKey("havepaycheck") )
            setHavepaycheck((localHavepaycheck).booleanValue());
        if ( h.containsKey("ettypename") )
            setEttypename((localEttypename));
        if ( h.containsKey("havehopslink") )
            setHavehopslink((localHavehopslink).booleanValue());

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
 * @param argEtaptypeid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argEtaptypeid, String argEttypename, boolean argHaveEndTime) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	etaptypeid = argEtaptypeid;
	ettypename = argEttypename;
	haveendtime = argHaveEndTime;
	havehopslink = false;
	havepaycheck = false;
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
 * @param argEtaptypeid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argEtaptypeid) throws java.rmi.RemoteException {}
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
 * Insert the method's description here.
 * Creation date: (28.06.2004 16:14:28)
 * @return int
 */
public int getEtaptypeid() {
	return etaptypeid;
}
/**
 * Getter method for ettypename
 * @return java.lang.String
 */
public java.lang.String getEttypename() {
	return ettypename;
}
/**
 * Getter method for haveendtime
 * @return boolean
 */
public boolean getHaveendtime() {
	return haveendtime;
}
/**
 * Getter method for havehopslink
 */
public boolean getHavehopslink() {
	return havehopslink;
}
/**
 * Getter method for havepaycheck
 */
public boolean getHavepaycheck() {
	return havepaycheck;
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
 * Setter method for ettypename
 * @param newValue java.lang.String
 */
public void setEttypename(java.lang.String newValue) {
	this.ettypename = newValue;
}
/**
 * Setter method for haveendtime
 * @param newValue boolean
 */
public void setHaveendtime(boolean newValue) {
	this.haveendtime = newValue;
}
/**
 * Setter method for havehopslink
 */
public void setHavehopslink(boolean newValue) {
	this.havehopslink = newValue;
}
/**
 * Setter method for havepaycheck
 */
public void setHavepaycheck(boolean newValue) {
	this.havepaycheck = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
