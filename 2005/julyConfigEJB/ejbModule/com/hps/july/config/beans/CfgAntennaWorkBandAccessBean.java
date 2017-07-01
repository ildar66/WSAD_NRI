package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgAntennaWorkBandAccessBean
 * @generated
 */
public class CfgAntennaWorkBandAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgAntennaWorkBandAccessBeanData {
	/**
	 * @generated
	 */
	private CfgAntennaWorkBand __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_idanten;
	/**
	 * @generated
	 */
	private short initKey_band;
	/**
	 * getKind_ant
	 * @generated
	 */
	public java.lang.String getKind_ant()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("kind_ant")));
	}
	/**
	 * setKind_ant
	 * @generated
	 */
	public void setKind_ant(java.lang.String newValue) {
		__setCache("kind_ant", newValue);
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
	 * getKswn
	 * @generated
	 */
	public java.math.BigDecimal getKswn()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("kswn")));
	}
	/**
	 * setKswn
	 * @generated
	 */
	public void setKswn(java.math.BigDecimal newValue) {
		__setCache("kswn", newValue);
	}
	/**
	 * getElectricangle
	 * @generated
	 */
	public java.math.BigDecimal getElectricangle()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("electricangle")));
	}
	/**
	 * setElectricangle
	 * @generated
	 */
	public void setElectricangle(java.math.BigDecimal newValue) {
		__setCache("electricangle", newValue);
	}
	/**
	 * setInitKey_savconfigid
	 * @generated
	 */
	public void setInitKey_savconfigid(int newValue) {
		this.initKey_savconfigid = (newValue);
	}
	/**
	 * setInitKey_idanten
	 * @generated
	 */
	public void setInitKey_idanten(int newValue) {
		this.initKey_idanten = (newValue);
	}
	/**
	 * setInitKey_band
	 * @generated
	 */
	public void setInitKey_band(short newValue) {
		this.initKey_band = (newValue);
	}
	/**
	 * CfgAntennaWorkBandAccessBean
	 * @generated
	 */
	public CfgAntennaWorkBandAccessBean() {
		super();
	}
	/**
	 * CfgAntennaWorkBandAccessBean
	 * @generated
	 */
	public CfgAntennaWorkBandAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAntennaWorkBandHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAntennaWorkBandHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgAntennaWorkBandHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgAntennaWorkBandHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAntennaWorkBand ejbRef()
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
						.CfgAntennaWorkBand) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgAntennaWorkBand.class);

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

		com.hps.july.config.beans.CfgAntennaWorkBandKey key =
			keyFromFields(initKey_savconfigid, initKey_idanten, initKey_band);
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
			com.hps.july.config.beans.CfgAntennaWorkBandKey pKey =
				(com.hps.july.config.beans.CfgAntennaWorkBandKey) this
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
	private com.hps.july.config.beans.CfgAntennaWorkBandKey keyFromFields(
		int f0,
		int f1,
		short f2) {
		com.hps.july.config.beans.CfgAntennaWorkBandKey keyClass =
			new com.hps.july.config.beans.CfgAntennaWorkBandKey();
		keyClass.savconfigid = f0;
		keyClass.idanten = f1;
		keyClass.band = f2;
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
	 * CfgAntennaWorkBandAccessBean
	 * @generated
	 */
	public CfgAntennaWorkBandAccessBean(
		int savconfigid,
		int idanten,
		short band,
		java.lang.String objectStatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(savconfigid, idanten, band, objectStatus);
	}
}
