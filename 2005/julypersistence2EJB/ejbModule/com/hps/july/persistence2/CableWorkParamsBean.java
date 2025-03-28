package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 */
public class CableWorkParamsBean implements EntityBean {
	public short band;
	private javax.ejb.EntityContext entityContext = null;
	public int id_anten;
	public int id_cable;
	public java.math.BigDecimal ksvn;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("band", new Short(getBand()));
        h.put("id_anten", new Integer(getId_anten()));
        h.put("ksvn", getKsvn());
        h.put("id_cable", new Integer(getId_cable()));
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.math.BigDecimal localKsvn = (java.math.BigDecimal) h.get("ksvn");

        if ( h.containsKey("ksvn") )
            setKsvn((localKsvn));

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
 * @param argBand short
 * @param argId_anten int
 * @param argId_cable int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(short argBand, int argId_anten, int argId_cable) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	band = argBand;
	id_anten = argId_anten;
	id_cable = argId_cable;
	ksvn = null;
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
 * @param argBand short
 * @param argId_anten int
 * @param argId_cable int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(short argBand, int argId_anten, int argId_cable) throws java.rmi.RemoteException {}
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
 * Insert the method's description here.
 * Creation date: (02.12.2004 13:14:21)
 * @return short
 */
public short getBand() {
	return band;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 13:14:21)
 * @return int
 */
public int getId_anten() {
	return id_anten;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 13:14:21)
 * @return int
 */
public int getId_cable() {
	return id_cable;
}
/**
 * Getter method for ksvn
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getKsvn() {
	return ksvn;
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
 * Setter method for ksvn
 * @param newValue java.math.BigDecimal
 */
public void setKsvn(java.math.BigDecimal newValue) {
	this.ksvn = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
