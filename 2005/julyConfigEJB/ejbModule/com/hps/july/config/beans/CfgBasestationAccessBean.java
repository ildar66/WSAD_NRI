package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgBasestationAccessBean
 * @generated
 */
public class CfgBasestationAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgBasestationAccessBeanData {
	/**
	 * @generated
	 */
	private CfgBasestation __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_equipment;
	/**
	 * getState1800
	 * @generated
	 */
	public java.lang.String getState1800()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("state1800")));
	}
	/**
	 * setState1800
	 * @generated
	 */
	public void setState1800(java.lang.String newValue) {
		__setCache("state1800", newValue);
	}
	/**
	 * getPwr_val
	 * @generated
	 */
	public java.math.BigDecimal getPwr_val()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("pwr_val")));
	}
	/**
	 * setPwr_val
	 * @generated
	 */
	public void setPwr_val(java.math.BigDecimal newValue) {
		__setCache("pwr_val", newValue);
	}
	/**
	 * getPrefixcellid
	 * @generated
	 */
	public java.lang.Integer getPrefixcellid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("prefixcellid")));
	}
	/**
	 * setPrefixcellid
	 * @generated
	 */
	public void setPrefixcellid(java.lang.Integer newValue) {
		__setCache("prefixcellid", newValue);
	}
	/**
	 * getDate_bldbeg
	 * @generated
	 */
	public java.sql.Date getDate_bldbeg()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_bldbeg")));
	}
	/**
	 * setDate_bldbeg
	 * @generated
	 */
	public void setDate_bldbeg(java.sql.Date newValue) {
		__setCache("date_bldbeg", newValue);
	}
	/**
	 * getManufid
	 * @generated
	 */
	public java.lang.Integer getManufid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("manufid")));
	}
	/**
	 * setManufid
	 * @generated
	 */
	public void setManufid(java.lang.Integer newValue) {
		__setCache("manufid", newValue);
	}
	/**
	 * getDate_connect
	 * @generated
	 */
	public java.sql.Date getDate_connect()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_connect")));
	}
	/**
	 * setDate_connect
	 * @generated
	 */
	public void setDate_connect(java.sql.Date newValue) {
		__setCache("date_connect", newValue);
	}
	/**
	 * getPwr_cat
	 * @generated
	 */
	public java.lang.String getPwr_cat()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("pwr_cat")));
	}
	/**
	 * setPwr_cat
	 * @generated
	 */
	public void setPwr_cat(java.lang.String newValue) {
		__setCache("pwr_cat", newValue);
	}
	/**
	 * getApartmentid
	 * @generated
	 */
	public java.lang.Integer getApartmentid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("apartmentid")));
	}
	/**
	 * setApartmentid
	 * @generated
	 */
	public void setApartmentid(java.lang.Integer newValue) {
		__setCache("apartmentid", newValue);
	}
	/**
	 * getEquipcomment
	 * @generated
	 */
	public java.lang.String getEquipcomment()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("equipcomment")));
	}
	/**
	 * setEquipcomment
	 * @generated
	 */
	public void setEquipcomment(java.lang.String newValue) {
		__setCache("equipcomment", newValue);
	}
	/**
	 * getAntplaceid
	 * @generated
	 */
	public java.lang.Integer getAntplaceid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("antplaceid")));
	}
	/**
	 * setAntplaceid
	 * @generated
	 */
	public void setAntplaceid(java.lang.Integer newValue) {
		__setCache("antplaceid", newValue);
	}
	/**
	 * getDate_assemb_afs
	 * @generated
	 */
	public java.sql.Date getDate_assemb_afs()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_assemb_afs")));
	}
	/**
	 * setDate_assemb_afs
	 * @generated
	 */
	public void setDate_assemb_afs(java.sql.Date newValue) {
		__setCache("date_assemb_afs", newValue);
	}
	/**
	 * getDate_assemb2
	 * @generated
	 */
	public java.sql.Date getDate_assemb2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_assemb2")));
	}
	/**
	 * setDate_assemb2
	 * @generated
	 */
	public void setDate_assemb2(java.sql.Date newValue) {
		__setCache("date_assemb2", newValue);
	}
	/**
	 * getH_obj_ant
	 * @generated
	 */
	public java.math.BigDecimal getH_obj_ant()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("h_obj_ant")));
	}
	/**
	 * setH_obj_ant
	 * @generated
	 */
	public void setH_obj_ant(java.math.BigDecimal newValue) {
		__setCache("h_obj_ant", newValue);
	}
	/**
	 * getPwr_res_cat
	 * @generated
	 */
	public java.lang.String getPwr_res_cat()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("pwr_res_cat")));
	}
	/**
	 * setPwr_res_cat
	 * @generated
	 */
	public void setPwr_res_cat(java.lang.String newValue) {
		__setCache("pwr_res_cat", newValue);
	}
	/**
	 * getDate_pr
	 * @generated
	 */
	public java.sql.Date getDate_pr()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_pr")));
	}
	/**
	 * setDate_pr
	 * @generated
	 */
	public void setDate_pr(java.sql.Date newValue) {
		__setCache("date_pr", newValue);
	}
	/**
	 * getPwr_reserve
	 * @generated
	 */
	public java.lang.String getPwr_reserve()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("pwr_reserve")));
	}
	/**
	 * setPwr_reserve
	 * @generated
	 */
	public void setPwr_reserve(java.lang.String newValue) {
		__setCache("pwr_reserve", newValue);
	}
	/**
	 * getLogictypeid
	 * @generated
	 */
	public java.lang.Integer getLogictypeid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("logictypeid")));
	}
	/**
	 * setLogictypeid
	 * @generated
	 */
	public void setLogictypeid(java.lang.Integer newValue) {
		__setCache("logictypeid", newValue);
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
	 * getState900
	 * @generated
	 */
	public java.lang.String getState900()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("state900")));
	}
	/**
	 * setState900
	 * @generated
	 */
	public void setState900(java.lang.String newValue) {
		__setCache("state900", newValue);
	}
	/**
	 * getNet_stage
	 * @generated
	 */
	public java.lang.Short getNet_stage()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("net_stage")));
	}
	/**
	 * setNet_stage
	 * @generated
	 */
	public void setNet_stage(java.lang.Short newValue) {
		__setCache("net_stage", newValue);
	}
	/**
	 * getStand_resource
	 * @generated
	 */
	public java.lang.Integer getStand_resource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("stand_resource")));
	}
	/**
	 * setStand_resource
	 * @generated
	 */
	public void setStand_resource(java.lang.Integer newValue) {
		__setCache("stand_resource", newValue);
	}
	/**
	 * getSt_transp
	 * @generated
	 */
	public java.lang.String getSt_transp()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("st_transp")));
	}
	/**
	 * setSt_transp
	 * @generated
	 */
	public void setSt_transp(java.lang.String newValue) {
		__setCache("st_transp", newValue);
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
	 * getIsarendats
	 * @generated
	 */
	public java.lang.Boolean getIsarendats()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("isarendats")));
	}
	/**
	 * setIsarendats
	 * @generated
	 */
	public void setIsarendats(java.lang.Boolean newValue) {
		__setCache("isarendats", newValue);
	}
	/**
	 * getDate_test2
	 * @generated
	 */
	public java.sql.Date getDate_test2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_test2")));
	}
	/**
	 * setDate_test2
	 * @generated
	 */
	public void setDate_test2(java.sql.Date newValue) {
		__setCache("date_test2", newValue);
	}
	/**
	 * getNumdcspermit
	 * @generated
	 */
	public java.lang.String getNumdcspermit()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("numdcspermit")));
	}
	/**
	 * setNumdcspermit
	 * @generated
	 */
	public void setNumdcspermit(java.lang.String newValue) {
		__setCache("numdcspermit", newValue);
	}
	/**
	 * getOn_air
	 * @generated
	 */
	public java.lang.Boolean getOn_air()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("on_air")));
	}
	/**
	 * setOn_air
	 * @generated
	 */
	public void setOn_air(java.lang.Boolean newValue) {
		__setCache("on_air", newValue);
	}
	/**
	 * getDate_onair2
	 * @generated
	 */
	public java.sql.Date getDate_onair2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_onair2")));
	}
	/**
	 * setDate_onair2
	 * @generated
	 */
	public void setDate_onair2(java.sql.Date newValue) {
		__setCache("date_onair2", newValue);
	}
	/**
	 * getN_stoek
	 * @generated
	 */
	public java.lang.Short getN_stoek()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("n_stoek")));
	}
	/**
	 * setN_stoek
	 * @generated
	 */
	public void setN_stoek(java.lang.Short newValue) {
		__setCache("n_stoek", newValue);
	}
	/**
	 * getE1_qty
	 * @generated
	 */
	public java.lang.Short getE1_qty()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("e1_qty")));
	}
	/**
	 * setE1_qty
	 * @generated
	 */
	public void setE1_qty(java.lang.Short newValue) {
		__setCache("e1_qty", newValue);
	}
	/**
	 * getDate_onair
	 * @generated
	 */
	public java.sql.Date getDate_onair()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_onair")));
	}
	/**
	 * setDate_onair
	 * @generated
	 */
	public void setDate_onair(java.sql.Date newValue) {
		__setCache("date_onair", newValue);
	}
	/**
	 * isRepeater
	 * @generated
	 */
	public boolean isRepeater()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("repeater")).booleanValue());
	}
	/**
	 * setRepeater
	 * @generated
	 */
	public void setRepeater(boolean newValue) {
		__setCache("repeater", new Boolean(newValue));
	}
	/**
	 * getDate_pr2
	 * @generated
	 */
	public java.sql.Date getDate_pr2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_pr2")));
	}
	/**
	 * setDate_pr2
	 * @generated
	 */
	public void setDate_pr2(java.sql.Date newValue) {
		__setCache("date_pr2", newValue);
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
	 * getSoftversion
	 * @generated
	 */
	public java.lang.String getSoftversion()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("softversion")));
	}
	/**
	 * setSoftversion
	 * @generated
	 */
	public void setSoftversion(java.lang.String newValue) {
		__setCache("softversion", newValue);
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
	 * getDate_connect2
	 * @generated
	 */
	public java.sql.Date getDate_connect2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_connect2")));
	}
	/**
	 * setDate_connect2
	 * @generated
	 */
	public void setDate_connect2(java.sql.Date newValue) {
		__setCache("date_connect2", newValue);
	}
	/**
	 * getDate_test
	 * @generated
	 */
	public java.sql.Date getDate_test()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_test")));
	}
	/**
	 * setDate_test
	 * @generated
	 */
	public void setDate_test(java.sql.Date newValue) {
		__setCache("date_test", newValue);
	}
	/**
	 * getCon_type
	 * @generated
	 */
	public java.lang.String getCon_type()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("con_type")));
	}
	/**
	 * setCon_type
	 * @generated
	 */
	public void setCon_type(java.lang.String newValue) {
		__setCache("con_type", newValue);
	}
	/**
	 * getDate_bldbeg2
	 * @generated
	 */
	public java.sql.Date getDate_bldbeg2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_bldbeg2")));
	}
	/**
	 * setDate_bldbeg2
	 * @generated
	 */
	public void setDate_bldbeg2(java.sql.Date newValue) {
		__setCache("date_bldbeg2", newValue);
	}
	/**
	 * getDate_assemb
	 * @generated
	 */
	public java.sql.Date getDate_assemb()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_assemb")));
	}
	/**
	 * setDate_assemb
	 * @generated
	 */
	public void setDate_assemb(java.sql.Date newValue) {
		__setCache("date_assemb", newValue);
	}
	/**
	 * getController
	 * @generated
	 */
	public java.lang.Integer getController()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("controller")));
	}
	/**
	 * setController
	 * @generated
	 */
	public void setController(java.lang.Integer newValue) {
		__setCache("controller", newValue);
	}
	/**
	 * getDate_assemb_afs2
	 * @generated
	 */
	public java.sql.Date getDate_assemb_afs2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date_assemb_afs2")));
	}
	/**
	 * setDate_assemb_afs2
	 * @generated
	 */
	public void setDate_assemb_afs2(java.sql.Date newValue) {
		__setCache("date_assemb_afs2", newValue);
	}
	/**
	 * getTime_backup
	 * @generated
	 */
	public java.lang.String getTime_backup()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("time_backup")));
	}
	/**
	 * setTime_backup
	 * @generated
	 */
	public void setTime_backup(java.lang.String newValue) {
		__setCache("time_backup", newValue);
	}
	/**
	 * getNumgsmpermit
	 * @generated
	 */
	public java.lang.String getNumgsmpermit()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("numgsmpermit")));
	}
	/**
	 * setNumgsmpermit
	 * @generated
	 */
	public void setNumgsmpermit(java.lang.String newValue) {
		__setCache("numgsmpermit", newValue);
	}
	/**
	 * getNumber
	 * @generated
	 */
	public int getNumber()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("number")).intValue());
	}
	/**
	 * setNumber
	 * @generated
	 */
	public void setNumber(int newValue) {
		__setCache("number", new Integer(newValue));
	}
	/**
	 * getType
	 * @generated
	 */
	public java.lang.String getType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("type")));
	}
	/**
	 * setType
	 * @generated
	 */
	public void setType(java.lang.String newValue) {
		__setCache("type", newValue);
	}
	/**
	 * setInitKey_savconfigid
	 * @generated
	 */
	public void setInitKey_savconfigid(int newValue) {
		this.initKey_savconfigid = (newValue);
	}
	/**
	 * setInitKey_equipment
	 * @generated
	 */
	public void setInitKey_equipment(int newValue) {
		this.initKey_equipment = (newValue);
	}
	/**
	 * CfgBasestationAccessBean
	 * @generated
	 */
	public CfgBasestationAccessBean() {
		super();
	}
	/**
	 * CfgBasestationAccessBean
	 * @generated
	 */
	public CfgBasestationAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgBasestationHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgBasestationHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgBasestationHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgBasestationHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgBasestation ejbRef()
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
						.CfgBasestation) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgBasestation.class);

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

		com.hps.july.config.beans.CfgBasestationKey key =
			keyFromFields(initKey_savconfigid, initKey_equipment);
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
			com.hps.july.config.beans.CfgBasestationKey pKey =
				(com.hps.july.config.beans.CfgBasestationKey) this.__getKey();
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
	private com.hps.july.config.beans.CfgBasestationKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.config.beans.CfgBasestationKey keyClass =
			new com.hps.july.config.beans.CfgBasestationKey();
		keyClass.savconfigid = f0;
		keyClass.equipment = f1;
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
	 * CfgBasestationAccessBean
	 * @generated
	 */
	public CfgBasestationAccessBean(
		int argSavconfigid,
		int argEquipment,
		java.lang.String argType,
		boolean argRepeater,
		int argNumber,
		java.lang.String argName,
		java.lang.String argObjectStatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argSavconfigid,
				argEquipment,
				argType,
				argRepeater,
				argNumber,
				argName,
				argObjectStatus);
	}
}
