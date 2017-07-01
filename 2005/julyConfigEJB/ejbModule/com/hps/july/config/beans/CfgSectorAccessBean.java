package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgSectorAccessBean
 * @generated
 */
public class CfgSectorAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgSectorAccessBeanData {
	/**
	 * @generated
	 */
	private CfgSector __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_id_sect;
	/**
	 * getTx_pwr
	 * @generated
	 */
	public java.math.BigDecimal getTx_pwr()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("tx_pwr")));
	}
	/**
	 * setTx_pwr
	 * @generated
	 */
	public void setTx_pwr(java.math.BigDecimal newValue) {
		__setCache("tx_pwr", newValue);
	}
	/**
	 * getBand
	 * @generated
	 */
	public java.lang.Short getBand()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("band")));
	}
	/**
	 * setBand
	 * @generated
	 */
	public void setBand(java.lang.Short newValue) {
		__setCache("band", newValue);
	}
	/**
	 * getCellinfo
	 * @generated
	 */
	public java.lang.String getCellinfo()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("cellinfo")));
	}
	/**
	 * setCellinfo
	 * @generated
	 */
	public void setCellinfo(java.lang.String newValue) {
		__setCache("cellinfo", newValue);
	}
	/**
	 * getRac
	 * @generated
	 */
	public java.lang.Integer getRac()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("rac")));
	}
	/**
	 * setRac
	 * @generated
	 */
	public void setRac(java.lang.Integer newValue) {
		__setCache("rac", newValue);
	}
	/**
	 * getNum_sect
	 * @generated
	 */
	public java.lang.String getNum_sect()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("num_sect")));
	}
	/**
	 * setNum_sect
	 * @generated
	 */
	public void setNum_sect(java.lang.String newValue) {
		__setCache("num_sect", newValue);
	}
	/**
	 * getTrx_num
	 * @generated
	 */
	public java.lang.Integer getTrx_num()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("trx_num")));
	}
	/**
	 * setTrx_num
	 * @generated
	 */
	public void setTrx_num(java.lang.Integer newValue) {
		__setCache("trx_num", newValue);
	}
	/**
	 * getBcc
	 * @generated
	 */
	public java.lang.Short getBcc()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("bcc")));
	}
	/**
	 * setBcc
	 * @generated
	 */
	public void setBcc(java.lang.Short newValue) {
		__setCache("bcc", newValue);
	}
	/**
	 * getTx_set_pwr
	 * @generated
	 */
	public java.math.BigDecimal getTx_set_pwr()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("tx_set_pwr")));
	}
	/**
	 * setTx_set_pwr
	 * @generated
	 */
	public void setTx_set_pwr(java.math.BigDecimal newValue) {
		__setCache("tx_set_pwr", newValue);
	}
	/**
	 * getHas_buster
	 * @generated
	 */
	public java.lang.Boolean getHas_buster()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("has_buster")));
	}
	/**
	 * setHas_buster
	 * @generated
	 */
	public void setHas_buster(java.lang.Boolean newValue) {
		__setCache("has_buster", newValue);
	}
	/**
	 * getIs_hr
	 * @generated
	 */
	public java.lang.Boolean getIs_hr()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("is_hr")));
	}
	/**
	 * setIs_hr
	 * @generated
	 */
	public void setIs_hr(java.lang.Boolean newValue) {
		__setCache("is_hr", newValue);
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
	 * getHas_lna
	 * @generated
	 */
	public java.lang.Boolean getHas_lna()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("has_lna")));
	}
	/**
	 * setHas_lna
	 * @generated
	 */
	public void setHas_lna(java.lang.Boolean newValue) {
		__setCache("has_lna", newValue);
	}
	/**
	 * getCellname
	 * @generated
	 */
	public java.lang.Integer getCellname()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("cellname")));
	}
	/**
	 * setCellname
	 * @generated
	 */
	public void setCellname(java.lang.Integer newValue) {
		__setCache("cellname", newValue);
	}
	/**
	 * getPort_abis
	 * @generated
	 */
	public java.lang.Integer getPort_abis()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("port_abis")));
	}
	/**
	 * setPort_abis
	 * @generated
	 */
	public void setPort_abis(java.lang.Integer newValue) {
		__setCache("port_abis", newValue);
	}
	/**
	 * getTx_ovr_set_pwr
	 * @generated
	 */
	public java.math.BigDecimal getTx_ovr_set_pwr()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("tx_ovr_set_pwr")));
	}
	/**
	 * setTx_ovr_set_pwr
	 * @generated
	 */
	public void setTx_ovr_set_pwr(java.math.BigDecimal newValue) {
		__setCache("tx_ovr_set_pwr", newValue);
	}
	/**
	 * getHas_flt
	 * @generated
	 */
	public java.lang.Boolean getHas_flt()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("has_flt")));
	}
	/**
	 * setHas_flt
	 * @generated
	 */
	public void setHas_flt(java.lang.Boolean newValue) {
		__setCache("has_flt", newValue);
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
	 * getDdk
	 * @generated
	 */
	public java.lang.Boolean getDdk()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("ddk")));
	}
	/**
	 * setDdk
	 * @generated
	 */
	public void setDdk(java.lang.Boolean newValue) {
		__setCache("ddk", newValue);
	}
	/**
	 * getCap_gprs
	 * @generated
	 */
	public java.lang.Boolean getCap_gprs()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("cap_gprs")));
	}
	/**
	 * setCap_gprs
	 * @generated
	 */
	public void setCap_gprs(java.lang.Boolean newValue) {
		__setCache("cap_gprs", newValue);
	}
	/**
	 * getTx_pwr2
	 * @generated
	 */
	public java.math.BigDecimal getTx_pwr2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("tx_pwr2")));
	}
	/**
	 * setTx_pwr2
	 * @generated
	 */
	public void setTx_pwr2(java.math.BigDecimal newValue) {
		__setCache("tx_pwr2", newValue);
	}
	/**
	 * getAzimut
	 * @generated
	 */
	public java.math.BigDecimal getAzimut()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("azimut")));
	}
	/**
	 * setAzimut
	 * @generated
	 */
	public void setAzimut(java.math.BigDecimal newValue) {
		__setCache("azimut", newValue);
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
	 * getNum_po
	 * @generated
	 */
	public java.lang.String getNum_po()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("num_po")));
	}
	/**
	 * setNum_po
	 * @generated
	 */
	public void setNum_po(java.lang.String newValue) {
		__setCache("num_po", newValue);
	}
	/**
	 * getCon_abis
	 * @generated
	 */
	public java.lang.String getCon_abis()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("con_abis")));
	}
	/**
	 * setCon_abis
	 * @generated
	 */
	public void setCon_abis(java.lang.String newValue) {
		__setCache("con_abis", newValue);
	}
	/**
	 * getLac
	 * @generated
	 */
	public java.lang.Integer getLac()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("lac")));
	}
	/**
	 * setLac
	 * @generated
	 */
	public void setLac(java.lang.Integer newValue) {
		__setCache("lac", newValue);
	}
	/**
	 * getTrx_num2
	 * @generated
	 */
	public java.lang.Integer getTrx_num2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("trx_num2")));
	}
	/**
	 * setTrx_num2
	 * @generated
	 */
	public void setTrx_num2(java.lang.Integer newValue) {
		__setCache("trx_num2", newValue);
	}
	/**
	 * getConf
	 * @generated
	 */
	public java.lang.String getConf()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("conf")));
	}
	/**
	 * setConf
	 * @generated
	 */
	public void setConf(java.lang.String newValue) {
		__setCache("conf", newValue);
	}
	/**
	 * getTrx_ovr_num
	 * @generated
	 */
	public java.lang.Integer getTrx_ovr_num()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("trx_ovr_num")));
	}
	/**
	 * setTrx_ovr_num
	 * @generated
	 */
	public void setTrx_ovr_num(java.lang.Integer newValue) {
		__setCache("trx_ovr_num", newValue);
	}
	/**
	 * getName_sect
	 * @generated
	 */
	public java.lang.String getName_sect()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("name_sect")));
	}
	/**
	 * setName_sect
	 * @generated
	 */
	public void setName_sect(java.lang.String newValue) {
		__setCache("name_sect", newValue);
	}
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
	 * getStandid
	 * @generated
	 */
	public java.lang.Integer getStandid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("standid")));
	}
	/**
	 * setStandid
	 * @generated
	 */
	public void setStandid(java.lang.Integer newValue) {
		__setCache("standid", newValue);
	}
	/**
	 * getNcc
	 * @generated
	 */
	public java.lang.Short getNcc()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("ncc")));
	}
	/**
	 * setNcc
	 * @generated
	 */
	public void setNcc(java.lang.Short newValue) {
		__setCache("ncc", newValue);
	}
	/**
	 * getPower
	 * @generated
	 */
	public java.math.BigDecimal getPower()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("power")));
	}
	/**
	 * setPower
	 * @generated
	 */
	public void setPower(java.math.BigDecimal newValue) {
		__setCache("power", newValue);
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
	 * getBts_number
	 * @generated
	 */
	public java.lang.String getBts_number()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bts_number")));
	}
	/**
	 * setBts_number
	 * @generated
	 */
	public void setBts_number(java.lang.String newValue) {
		__setCache("bts_number", newValue);
	}
	/**
	 * setInitKey_savconfigid
	 * @generated
	 */
	public void setInitKey_savconfigid(int newValue) {
		this.initKey_savconfigid = (newValue);
	}
	/**
	 * setInitKey_id_sect
	 * @generated
	 */
	public void setInitKey_id_sect(int newValue) {
		this.initKey_id_sect = (newValue);
	}
	/**
	 * CfgSectorAccessBean
	 * @generated
	 */
	public CfgSectorAccessBean() {
		super();
	}
	/**
	 * CfgSectorAccessBean
	 * @generated
	 */
	public CfgSectorAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgSectorHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgSectorHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgSectorHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgSectorHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgSector ejbRef()
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
						.CfgSector) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgSector.class);

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

		com.hps.july.config.beans.CfgSectorKey key =
			keyFromFields(initKey_savconfigid, initKey_id_sect);
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
			com.hps.july.config.beans.CfgSectorKey pKey =
				(com.hps.july.config.beans.CfgSectorKey) this.__getKey();
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
	private com.hps.july.config.beans.CfgSectorKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.config.beans.CfgSectorKey keyClass =
			new com.hps.july.config.beans.CfgSectorKey();
		keyClass.savconfigid = f0;
		keyClass.id_sect = f1;
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
	 * CfgSectorAccessBean
	 * @generated
	 */
	public CfgSectorAccessBean(
		int savconfigid,
		int id_sect,
		int equipment,
		java.lang.String name_sect,
		short band,
		java.lang.String num_sect,
		int datasource,
		java.lang.String objectstatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				savconfigid,
				id_sect,
				equipment,
				name_sect,
				band,
				num_sect,
				datasource,
				objectstatus);
	}
}
