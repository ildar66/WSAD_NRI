package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgBsstandsAccessBean
 * @generated
 */
public class CfgBsstandsAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgBsstandsAccessBeanData {
	/**
	 * @generated
	 */
	private CfgBsstands __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_standid;
	/**
	 * getStnomer
	 * @generated
	 */
	public java.lang.String getStnomer()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("stnomer")));
	}
	/**
	 * setStnomer
	 * @generated
	 */
	public void setStnomer(java.lang.String newValue) {
		__setCache("stnomer", newValue);
	}
	/**
	 * getResource
	 * @generated
	 */
	public java.lang.Integer getResource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("resource")));
	}
	/**
	 * setResource
	 * @generated
	 */
	public void setResource(java.lang.Integer newValue) {
		__setCache("resource", newValue);
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
	 * setInitKey_standid
	 * @generated
	 */
	public void setInitKey_standid(int newValue) {
		this.initKey_standid = (newValue);
	}
	/**
	 * CfgBsstandsAccessBean
	 * @generated
	 */
	public CfgBsstandsAccessBean() {
		super();
	}
	/**
	 * CfgBsstandsAccessBean
	 * @generated
	 */
	public CfgBsstandsAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgBsstandsHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgBsstandsHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgBsstandsHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgBsstandsHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgBsstands ejbRef()
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
						.CfgBsstands) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgBsstands.class);

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

		com.hps.july.config.beans.CfgBsstandsKey key =
			keyFromFields(initKey_savconfigid, initKey_standid);
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
			com.hps.july.config.beans.CfgBsstandsKey pKey =
				(com.hps.july.config.beans.CfgBsstandsKey) this.__getKey();
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
	private com.hps.july.config.beans.CfgBsstandsKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.config.beans.CfgBsstandsKey keyClass =
			new com.hps.july.config.beans.CfgBsstandsKey();
		keyClass.savconfigid = f0;
		keyClass.standid = f1;
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
	 * CfgBsstandsAccessBean
	 * @generated
	 */
	public CfgBsstandsAccessBean(
		int savconfigid,
		int standid,
		int equipment,
		java.lang.String objectstatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(savconfigid, standid, equipment, objectstatus);
	}
}
