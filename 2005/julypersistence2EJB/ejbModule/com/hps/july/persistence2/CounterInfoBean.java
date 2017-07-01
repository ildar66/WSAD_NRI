package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * ���������� �� ����������������
 * This is an Entity Bean class with CMP fields
 */
public class CounterInfoBean implements EntityBean {
	public String code;
	private javax.ejb.EntityContext entityContext = null;
	public int id;
	public String name;
	private final static long serialVersionUID = 3206093459760846163L;
	public Integer verification_inter;
	private Integer tempOperator;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("code", getCode());
        h.put("id", new Integer(getId()));
        h.put("verification_inter", getVerification_inter());
        h.put("name", getName());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localCode = (java.lang.String) h.get("code");
        java.lang.Integer localVerification_inter = (java.lang.Integer) h.get("verification_inter");
        java.lang.String localName = (java.lang.String) h.get("name");

        if ( h.containsKey("code") )
            setCode((localCode));
        if ( h.containsKey("verification_inter") )
            setVerification_inter((localVerification_inter));
        if ( h.containsKey("name") )
            setName((localName));

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
 * @param argId int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argId) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	id = argId;
	code = null;
	name = null;
	verification_inter = null;
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
 * @param argId int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argId) throws java.rmi.RemoteException {}
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
 * Getter method for code
 * @return java.lang.String
 */
public java.lang.String getCode() {
	return code;
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
 * Creation date: (04.08.2004 17:21:32)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Getter method for name
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Getter method for verification_inter
 */
public java.lang.Integer getVerification_inter() {
	return verification_inter;
}
/**
 * Setter method for code
 * @param newValue java.lang.String
 */
public void setCode(java.lang.String newValue) {
	this.code = newValue;
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
 * Setter method for name
 * @param newValue java.lang.String
 */
public void setName(java.lang.String newValue) {
	this.name = newValue;
}
/**
 * Setter method for verification_inter
 */
public void setVerification_inter(java.lang.Integer newValue) {
	this.verification_inter = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}