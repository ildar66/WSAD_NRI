package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgAnten2SectorAccessBean
 * @generated
 */
public class CfgAnten2SectorAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgAnten2SectorAccessBeanData {
	/**
	 * @generated
	 */
	private CfgAnten2Sector __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_id_anten;
	/**
	 * @generated
	 */
	private int initKey_id_sect;
	/**
	 * getId_sect
	 * @generated
	 */
	public int getId_sect()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("id_sect")).intValue());
	}
	/**
	 * getDatasource
	 * @generated
	 */
	public java.lang.Integer getDatasource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("datasource")));
	}
	/**
	 * setDatasource
	 * @generated
	 */
	public void setDatasource(java.lang.Integer newValue) {
		__setCache("datasource", newValue);
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
	 * setInitKey_savconfigid
	 * @generated
	 */
	public void setInitKey_savconfigid(int newValue) {
		this.initKey_savconfigid = (newValue);
	}
	/**
	 * setInitKey_id_anten
	 * @generated
	 */
	public void setInitKey_id_anten(int newValue) {
		this.initKey_id_anten = (newValue);
	}
	/**
	 * setInitKey_id_sect
	 * @generated
	 */
	public void setInitKey_id_sect(int newValue) {
		this.initKey_id_sect = (newValue);
	}
	/**
	 * CfgAnten2SectorAccessBean
	 * @generated
	 */
	public CfgAnten2SectorAccessBean() {
		super();
	}
	/**
	 * CfgAnten2SectorAccessBean
	 * @generated
	 */
	public CfgAnten2SectorAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAnten2SectorHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAnten2SectorHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgAnten2SectorHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgAnten2SectorHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAnten2Sector ejbRef()
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
						.CfgAnten2Sector) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgAnten2Sector.class);

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

		com.hps.july.config.beans.CfgAnten2SectorKey key =
			keyFromFields(
				initKey_savconfigid,
				initKey_id_anten,
				initKey_id_sect);
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
			com.hps.july.config.beans.CfgAnten2SectorKey pKey =
				(com.hps.july.config.beans.CfgAnten2SectorKey) this.__getKey();
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
	private com.hps.july.config.beans.CfgAnten2SectorKey keyFromFields(
		int f0,
		int f1,
		int f2) {
		com.hps.july.config.beans.CfgAnten2SectorKey keyClass =
			new com.hps.july.config.beans.CfgAnten2SectorKey();
		keyClass.savconfigid = f0;
		keyClass.id_anten = f1;
		keyClass.id_sect = f2;
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
	 * CfgAnten2SectorAccessBean
	 * @generated
	 */
	public CfgAnten2SectorAccessBean(
		int savconfigid,
		int id_anten,
		int id_sect,
		int datasource,
		java.lang.String objectStatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				savconfigid,
				id_anten,
				id_sect,
				datasource,
				objectStatus);
	}
}
