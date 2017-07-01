package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgAntennaAccessBean
 * @generated
 */
public class CfgAntennaAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgAntennaAccessBeanData {
	/**
	 * @generated
	 */
	private CfgAntenna __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_id_anten;
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
	 * getByhand
	 * @generated
	 */
	public java.lang.Boolean getByhand()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("byhand")));
	}
	/**
	 * setByhand
	 * @generated
	 */
	public void setByhand(java.lang.Boolean newValue) {
		__setCache("byhand", newValue);
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
	 * getNakl
	 * @generated
	 */
	public java.math.BigDecimal getNakl()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("nakl")));
	}
	/**
	 * setNakl
	 * @generated
	 */
	public void setNakl(java.math.BigDecimal newValue) {
		__setCache("nakl", newValue);
	}
	/**
	 * getAz_variation
	 * @generated
	 */
	public java.lang.String getAz_variation()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("az_variation")));
	}
	/**
	 * setAz_variation
	 * @generated
	 */
	public void setAz_variation(java.lang.String newValue) {
		__setCache("az_variation", newValue);
	}
	/**
	 * getNakl_variation
	 * @generated
	 */
	public java.lang.String getNakl_variation()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("nakl_variation")));
	}
	/**
	 * setNakl_variation
	 * @generated
	 */
	public void setNakl_variation(java.lang.String newValue) {
		__setCache("nakl_variation", newValue);
	}
	/**
	 * getElectricaltilt
	 * @generated
	 */
	public java.math.BigDecimal getElectricaltilt()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("electricaltilt")));
	}
	/**
	 * setElectricaltilt
	 * @generated
	 */
	public void setElectricaltilt(java.math.BigDecimal newValue) {
		__setCache("electricaltilt", newValue);
	}
	/**
	 * getNum_ant
	 * @generated
	 */
	public java.lang.String getNum_ant()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("num_ant")));
	}
	/**
	 * setNum_ant
	 * @generated
	 */
	public void setNum_ant(java.lang.String newValue) {
		__setCache("num_ant", newValue);
	}
	/**
	 * getLocationtype
	 * @generated
	 */
	public java.lang.String getLocationtype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("locationtype")));
	}
	/**
	 * setLocationtype
	 * @generated
	 */
	public void setLocationtype(java.lang.String newValue) {
		__setCache("locationtype", newValue);
	}
	/**
	 * getCableres
	 * @generated
	 */
	public java.lang.Integer getCableres()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("cableres")));
	}
	/**
	 * setCableres
	 * @generated
	 */
	public void setCableres(java.lang.Integer newValue) {
		__setCache("cableres", newValue);
	}
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
	 * getOperator
	 * @generated
	 */
	public java.lang.Integer getOperator()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("operator")));
	}
	/**
	 * setOperator
	 * @generated
	 */
	public void setOperator(java.lang.Integer newValue) {
		__setCache("operator", newValue);
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
	 * getInput_power
	 * @generated
	 */
	public java.math.BigDecimal getInput_power()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("input_power")));
	}
	/**
	 * setInput_power
	 * @generated
	 */
	public void setInput_power(java.math.BigDecimal newValue) {
		__setCache("input_power", newValue);
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
	 * getCommcable
	 * @generated
	 */
	public java.lang.Boolean getCommcable()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("commcable")));
	}
	/**
	 * setCommcable
	 * @generated
	 */
	public void setCommcable(java.lang.Boolean newValue) {
		__setCache("commcable", newValue);
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
	 * getLen_cable
	 * @generated
	 */
	public java.math.BigDecimal getLen_cable()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("len_cable")));
	}
	/**
	 * setLen_cable
	 * @generated
	 */
	public void setLen_cable(java.math.BigDecimal newValue) {
		__setCache("len_cable", newValue);
	}
	/**
	 * getStorageCard
	 * @generated
	 */
	public java.lang.Integer getStorageCard()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("storageCard")));
	}
	/**
	 * setStorageCard
	 * @generated
	 */
	public void setStorageCard(java.lang.Integer newValue) {
		__setCache("storageCard", newValue);
	}
	/**
	 * getH_set1
	 * @generated
	 */
	public java.math.BigDecimal getH_set1()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("h_set1")));
	}
	/**
	 * setH_set1
	 * @generated
	 */
	public void setH_set1(java.math.BigDecimal newValue) {
		__setCache("h_set1", newValue);
	}
	/**
	 * getAz_ant
	 * @generated
	 */
	public java.math.BigDecimal getAz_ant()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("az_ant")));
	}
	/**
	 * setAz_ant
	 * @generated
	 */
	public void setAz_ant(java.math.BigDecimal newValue) {
		__setCache("az_ant", newValue);
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
	 * CfgAntennaAccessBean
	 * @generated
	 */
	public CfgAntennaAccessBean() {
		super();
	}
	/**
	 * CfgAntennaAccessBean
	 * @generated
	 */
	public CfgAntennaAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAntennaHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAntennaHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgAntennaHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgAntennaHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgAntenna ejbRef()
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
						.CfgAntenna) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgAntenna.class);

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

		com.hps.july.config.beans.CfgAntennaKey key =
			keyFromFields(initKey_savconfigid, initKey_id_anten);
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
			com.hps.july.config.beans.CfgAntennaKey pKey =
				(com.hps.july.config.beans.CfgAntennaKey) this.__getKey();
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
	private com.hps.july.config.beans.CfgAntennaKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.config.beans.CfgAntennaKey keyClass =
			new com.hps.july.config.beans.CfgAntennaKey();
		keyClass.savconfigid = f0;
		keyClass.id_anten = f1;
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
	 * CfgAntennaAccessBean
	 * @generated
	 */
	public CfgAntennaAccessBean(
		int savconfigid,
		int id_anten,
		int resource,
		java.lang.String num_ant,
		java.lang.String kind_ant,
		java.math.BigDecimal nakl,
		java.math.BigDecimal az_ant,
		java.math.BigDecimal h_set1,
		java.math.BigDecimal len_cable,
		int equipment,
		boolean byhand,
		java.lang.String locationtype,
		int datasource,
		java.lang.String objectstatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				savconfigid,
				id_anten,
				resource,
				num_ant,
				kind_ant,
				nakl,
				az_ant,
				h_set1,
				len_cable,
				equipment,
				byhand,
				locationtype,
				datasource,
				objectstatus);
	}
}
