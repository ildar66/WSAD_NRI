package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgAntennaCableAccessBean
 * @generated
 */
public class CfgAntennaCableAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgAntennaCableAccessBeanData {
	/**
	 * @generated
	 */
	private CfgAntennaCable __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_idCable;
	/**
	 * getDatasource
	 * @generated
	 */
	public int getDatasource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("datasource")).intValue());
	}
	/**
	 * setDatasource
	 * @generated
	 */
	public void setDatasource(int newValue) {
		__setCache("datasource", new Integer(newValue));
	}
	/**
	 * getGroundresource
	 * @generated
	 */
	public java.lang.Integer getGroundresource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("groundresource")));
	}
	/**
	 * setGroundresource
	 * @generated
	 */
	public void setGroundresource(java.lang.Integer newValue) {
		__setCache("groundresource", newValue);
	}
	/**
	 * getLenCable
	 * @generated
	 */
	public java.math.BigDecimal getLenCable()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("lenCable")));
	}
	/**
	 * setLenCable
	 * @generated
	 */
	public void setLenCable(java.math.BigDecimal newValue) {
		__setCache("lenCable", newValue);
	}
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
	 * getId_anten
	 * @generated
	 */
	public int getId_anten()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("id_anten")).intValue());
	}
	/**
	 * setId_anten
	 * @generated
	 */
	public void setId_anten(int newValue) {
		__setCache("id_anten", new Integer(newValue));
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
	 * getCableres
	 * @generated
	 */
	public int getCableres()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("cableres")).intValue());
	}
	/**
	 * setCableres
	 * @generated
	 */
	public void setCableres(int newValue) {
		__setCache("cableres", new Integer(newValue));
	}
	/**
	 * getGroundcnt
	 * @generated
	 */
	public java.lang.Integer getGroundcnt()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("groundcnt")));
	}
	/**
	 * setGroundcnt
	 * @generated
	 */
	public void setGroundcnt(java.lang.Integer newValue) {
		__setCache("groundcnt", newValue);
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
	 * setInitKey_idCable
	 * @generated
	 */
	public void setInitKey_idCable(int newValue) {
		this.initKey_idCable = (newValue);
	}
	/**
	 * CfgAntennaCableAccessBean
	 * @generated
	 */
	public CfgAntennaCableAccessBean() {
		super();
	}
	/**
	 * CfgAntennaCableAccessBean
	 * @generated
	 */
	public CfgAntennaCableAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAntennaCableHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAntennaCableHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgAntennaCableHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgAntennaCableHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAntennaCable ejbRef()
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
						.CfgAntennaCable) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgAntennaCable.class);

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

		com.hps.july.config.beans.CfgAntennaCableKey key =
			keyFromFields(initKey_savconfigid, initKey_idCable);
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
			com.hps.july.config.beans.CfgAntennaCableKey pKey =
				(com.hps.july.config.beans.CfgAntennaCableKey) this.__getKey();
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
	private com.hps.july.config.beans.CfgAntennaCableKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.config.beans.CfgAntennaCableKey keyClass =
			new com.hps.july.config.beans.CfgAntennaCableKey();
		keyClass.savconfigid = f0;
		keyClass.idCable = f1;
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
	 * CfgAntennaCableAccessBean
	 * @generated
	 */
	public CfgAntennaCableAccessBean(
		int argSavconfigid,
		int argIdCable,
		int argIdAnten,
		int argCableres,
		java.math.BigDecimal argCableLen,
		int argDataSource,
		java.lang.String argObjectStatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argSavconfigid,
				argIdCable,
				argIdAnten,
				argCableres,
				argCableLen,
				argDataSource,
				argObjectStatus);
	}
}
