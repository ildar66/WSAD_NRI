package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgEquipObjectsCfgAccessBean
 * @generated
 */
public class CfgEquipObjectsCfgAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgEquipObjectsCfgAccessBeanData {
	/**
	 * @generated
	 */
	private CfgEquipObjectsCfg __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_objcfgid;
	/**
	 * getObjectStatus
	 * @generated
	 */
	public java.lang.String getObjectStatus()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("objectStatus")));
	}
	/**
	 * setObjectStatus
	 * @generated
	 */
	public void setObjectStatus(java.lang.String newValue) {
		__setCache("objectStatus", newValue);
	}
	/**
	 * getParentobjcfgid
	 * @generated
	 */
	public java.lang.Integer getParentobjcfgid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("parentobjcfgid")));
	}
	/**
	 * setParentobjcfgid
	 * @generated
	 */
	public void setParentobjcfgid(java.lang.Integer newValue) {
		__setCache("parentobjcfgid", newValue);
	}
	/**
	 * getSavconfigid
	 * @generated
	 */
	public int getSavconfigid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("savconfigid")).intValue());
	}
	/**
	 * getEquipment
	 * @generated
	 */
	public int getEquipment()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("equipment")).intValue());
	}
	/**
	 * setEquipment
	 * @generated
	 */
	public void setEquipment(int newValue) {
		__setCache("equipment", new Integer(newValue));
	}
	/**
	 * getObjcfgid
	 * @generated
	 */
	public int getObjcfgid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("objcfgid")).intValue());
	}
	/**
	 * getStoragecard
	 * @generated
	 */
	public java.lang.Integer getStoragecard()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("storagecard")));
	}
	/**
	 * setStoragecard
	 * @generated
	 */
	public void setStoragecard(java.lang.Integer newValue) {
		__setCache("storagecard", newValue);
	}
	/**
	 * getQty
	 * @generated
	 */
	public java.math.BigDecimal getQty()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("qty")));
	}
	/**
	 * setQty
	 * @generated
	 */
	public void setQty(java.math.BigDecimal newValue) {
		__setCache("qty", newValue);
	}
	/**
	 * setInitKey_savconfigid
	 * @generated
	 */
	public void setInitKey_savconfigid(int newValue) {
		this.initKey_savconfigid = (newValue);
	}
	/**
	 * setInitKey_objcfgid
	 * @generated
	 */
	public void setInitKey_objcfgid(int newValue) {
		this.initKey_objcfgid = (newValue);
	}
	/**
	 * CfgEquipObjectsCfgAccessBean
	 * @generated
	 */
	public CfgEquipObjectsCfgAccessBean() {
		super();
	}
	/**
	 * CfgEquipObjectsCfgAccessBean
	 * @generated
	 */
	public CfgEquipObjectsCfgAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgEquipObjectsCfgHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgEquipObjectsCfgHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgEquipObjectsCfgHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgEquipObjectsCfgHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgEquipObjectsCfg ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.config
						.beans
						.CfgEquipObjectsCfg) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgEquipObjectsCfg.class);

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

		com.hps.july.config.beans.CfgEquipObjectsCfgKey key =
			keyFromFields(initKey_savconfigid, initKey_objcfgid);
		ejbRef = ejbHome().findByPrimaryKey(key);
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
			com.hps.july.config.beans.CfgEquipObjectsCfgKey pKey =
				(com.hps.july.config.beans.CfgEquipObjectsCfgKey) this
					.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * keyFromFields
	 * @generated
	 */
	private com.hps.july.config.beans.CfgEquipObjectsCfgKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.config.beans.CfgEquipObjectsCfgKey keyClass =
			new com.hps.july.config.beans.CfgEquipObjectsCfgKey();
		keyClass.savconfigid = f0;
		keyClass.objcfgid = f1;
		return keyClass;
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
	 * CfgEquipObjectsCfgAccessBean
	 * @generated
	 */
	public CfgEquipObjectsCfgAccessBean(
		int savconfigid,
		int objcfgid,
		int equipment,
		java.lang.String objectstatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(savconfigid, objcfgid, equipment, objectstatus);
	}
}
