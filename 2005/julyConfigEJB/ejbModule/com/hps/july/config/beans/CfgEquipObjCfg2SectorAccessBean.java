package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgEquipObjCfg2SectorAccessBean
 * @generated
 */
public class CfgEquipObjCfg2SectorAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgEquipObjCfg2SectorAccessBeanData {
	/**
	 * @generated
	 */
	private CfgEquipObjCfg2Sector __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_objcfgid;
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
	 * setInitKey_id_sect
	 * @generated
	 */
	public void setInitKey_id_sect(int newValue) {
		this.initKey_id_sect = (newValue);
	}
	/**
	 * CfgEquipObjCfg2SectorAccessBean
	 * @generated
	 */
	public CfgEquipObjCfg2SectorAccessBean() {
		super();
	}
	/**
	 * CfgEquipObjCfg2SectorAccessBean
	 * @generated
	 */
	public CfgEquipObjCfg2SectorAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgEquipObjCfg2SectorHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgEquipObjCfg2SectorHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgEquipObjCfg2SectorHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgEquipObjCfg2SectorHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgEquipObjCfg2Sector ejbRef()
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
						.CfgEquipObjCfg2Sector) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgEquipObjCfg2Sector.class);

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

		com.hps.july.config.beans.CfgEquipObjCfg2SectorKey key =
			keyFromFields(
				initKey_savconfigid,
				initKey_objcfgid,
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
			com.hps.july.config.beans.CfgEquipObjCfg2SectorKey pKey =
				(com.hps.july.config.beans.CfgEquipObjCfg2SectorKey) this
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
	private com.hps.july.config.beans.CfgEquipObjCfg2SectorKey keyFromFields(
		int f0,
		int f1,
		int f2) {
		com.hps.july.config.beans.CfgEquipObjCfg2SectorKey keyClass =
			new com.hps.july.config.beans.CfgEquipObjCfg2SectorKey();
		keyClass.savconfigid = f0;
		keyClass.objcfgid = f1;
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
	 * CfgEquipObjCfg2SectorAccessBean
	 * @generated
	 */
	public CfgEquipObjCfg2SectorAccessBean(
		int savconfigid,
		int objcfgid,
		int id_sect,
		java.lang.String objectStatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(savconfigid, objcfgid, id_sect, objectStatus);
	}
}
