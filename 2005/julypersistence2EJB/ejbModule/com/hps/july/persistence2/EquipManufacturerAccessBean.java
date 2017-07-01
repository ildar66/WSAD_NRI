package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * EquipManufacturerAccessBean
 * @generated
 */
public class EquipManufacturerAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.EquipManufacturerAccessBeanData {
	/**
	 * @generated
	 */
	private EquipManufacturer __ejbRef;
	/**
	 * @generated
	 */
	private java.lang.Integer init_primaryKey;
	/**
	 * getShortname
	 * @generated
	 */
	public java.lang.String getShortname()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("shortname")));
	}
	/**
	 * setShortname
	 * @generated
	 */
	public void setShortname(java.lang.String newValue) {
		__setCache("shortname", newValue);
	}
	/**
	 * getName
	 * @generated
	 */
	public java.lang.String getName()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("name")));
	}
	/**
	 * setName
	 * @generated
	 */
	public void setName(java.lang.String newValue) {
		__setCache("name", newValue);
	}
	/**
	 * getEquipcatalog
	 * @generated
	 */
	public java.lang.String getEquipcatalog()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("equipcatalog")));
	}
	/**
	 * setEquipcatalog
	 * @generated
	 */
	public void setEquipcatalog(java.lang.String newValue) {
		__setCache("equipcatalog", newValue);
	}
	/**
	 * getOfficialsite
	 * @generated
	 */
	public java.lang.String getOfficialsite()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("officialsite")));
	}
	/**
	 * setOfficialsite
	 * @generated
	 */
	public void setOfficialsite(java.lang.String newValue) {
		__setCache("officialsite", newValue);
	}
	/**
	 * getComment
	 * @generated
	 */
	public java.lang.String getComment()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("comment")));
	}
	/**
	 * setComment
	 * @generated
	 */
	public void setComment(java.lang.String newValue) {
		__setCache("comment", newValue);
	}
	/**
	 * setInit_primaryKey
	 * @generated
	 */
	public void setInit_primaryKey(java.lang.Integer newValue) {
		this.init_primaryKey = (newValue);
	}
	/**
	 * EquipManufacturerAccessBean
	 * @generated
	 */
	public EquipManufacturerAccessBean() {
		super();
	}
	/**
	 * EquipManufacturerAccessBean
	 * @generated
	 */
	public EquipManufacturerAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/EquipManufacturerHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.EquipManufacturerHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.EquipManufacturerHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.EquipManufacturerHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.EquipManufacturer ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.persistence2
						.EquipManufacturer) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.EquipManufacturer.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		ejbRef = ejbHome().findByPrimaryKey(init_primaryKey);
	}
	/**
	 * instantiateEJBByPrimaryKey
	 * @generated
	 */
	protected boolean instantiateEJBByPrimaryKey()
		throws
			javax.ejb.CreateException,
			java.rmi.RemoteException,
			javax.naming.NamingException {
		boolean result = false;

		if (ejbRef() != null)
			return true;

		try {
			java.lang.Integer pKey = (java.lang.Integer) this.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * refreshCopyHelper
	 * @generated
	 */
	public void refreshCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		refreshCopyHelper(ejbRef());
	}
	/**
	 * commitCopyHelper
	 * @generated
	 */
	public void commitCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		commitCopyHelper(ejbRef());
	}
	/**
	 * EquipManufacturerAccessBean
	 * @generated
	 */
	public EquipManufacturerAccessBean(
		java.lang.Integer manufid,
		java.lang.String name,
		java.lang.String shortname)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(manufid, name, shortname);
	}
}
