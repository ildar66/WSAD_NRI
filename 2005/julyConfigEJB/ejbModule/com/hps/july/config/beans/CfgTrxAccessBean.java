package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgTrxAccessBean
 * @generated
 */
public class CfgTrxAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgTrxAccessBeanData {
	/**
	 * @generated
	 */
	private CfgTrx __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_trxid;
	/**
	 * getObjectstatus
	 * @generated
	 */
	public java.lang.String getObjectstatus()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("objectstatus")));
	}
	/**
	 * setObjectstatus
	 * @generated
	 */
	public void setObjectstatus(java.lang.String newValue) {
		__setCache("objectstatus", newValue);
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
	 * getResource
	 * @generated
	 */
	public int getResource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("resource")).intValue());
	}
	/**
	 * setResource
	 * @generated
	 */
	public void setResource(int newValue) {
		__setCache("resource", new Integer(newValue));
	}
	/**
	 * getStandid
	 * @generated
	 */
	public int getStandid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("standid")).intValue());
	}
	/**
	 * setStandid
	 * @generated
	 */
	public void setStandid(int newValue) {
		__setCache("standid", new Integer(newValue));
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
	 * setInitKey_trxid
	 * @generated
	 */
	public void setInitKey_trxid(int newValue) {
		this.initKey_trxid = (newValue);
	}
	/**
	 * CfgTrxAccessBean
	 * @generated
	 */
	public CfgTrxAccessBean() {
		super();
	}
	/**
	 * CfgTrxAccessBean
	 * @generated
	 */
	public CfgTrxAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgTrxHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgTrxHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com.hps.july.config.beans.CfgTrxHome) PortableRemoteObject.narrow(
			getHome(),
			com.hps.july.config.beans.CfgTrxHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgTrx ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(com.hps.july.config.beans.CfgTrx) PortableRemoteObject.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgTrx.class);

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

		com.hps.july.config.beans.CfgTrxKey key =
			keyFromFields(initKey_savconfigid, initKey_trxid);
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
			com.hps.july.config.beans.CfgTrxKey pKey =
				(com.hps.july.config.beans.CfgTrxKey) this.__getKey();
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
	private com.hps.july.config.beans.CfgTrxKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgTrxKey keyClass =
			new com.hps.july.config.beans.CfgTrxKey();
		keyClass.savconfigid = f0;
		keyClass.trxid = f1;
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
	 * getTrxid
	 * @generated
	 */
	public int getTrxid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("trxid")).intValue());
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
	 * CfgTrxAccessBean
	 * @generated
	 */
	public CfgTrxAccessBean(
		int argSavconfigid,
		int argEquipment,
		int argTrxid,
		int argResource,
		int argStandid,
		java.lang.String argObjectstatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argSavconfigid,
				argEquipment,
				argTrxid,
				argResource,
				argStandid,
				argObjectstatus);
	}
}
