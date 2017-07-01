package com.hps.july.basestation.formbean;

import javax.servlet.http.*;
import com.hps.july.basestation.valueobject.Validator;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import java.math.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма редактирования эксплуатационных характеристик контроллера
 */
public class ControllerDescForm
	extends com.hps.july.web.util.EditForm
{
	private StringAndSqlDateProperty act_date = new StringAndSqlDateProperty();
	private int controllercode;
	private Vector actdates = new Vector();
	private java.lang.String load_max_day;
	private java.lang.String load_max_hour;
	private StringAndBigDecimal koef_kk = new StringAndBigDecimal(6,2);
	private StringAndInteger traf_aint = new StringAndInteger();
	private StringAndBigDecimal load_aint_percent = new StringAndBigDecimal(6,2);
	private StringAndBigDecimal ss7_load_avg = new StringAndBigDecimal(6,2);
	private StringAndInteger acc_load = new StringAndInteger();
	private StringAndBigDecimal cap_use_percent = new StringAndBigDecimal(6,2);
	private StringAndBigDecimal bad_cunsr_percent = new StringAndBigDecimal(6,2);
	private StringAndBigDecimal bad_cunssr_percent = new StringAndBigDecimal(6,2);
	private StringAndInteger conn_lost_avg = new StringAndInteger();

	private boolean editable;
	private int positionid;
	private String positionname;
	private String regionname;
	private String zonename;
	private String address;
	private String controllername;
public void afterDelete(HttpServletRequest request)
	throws Exception
{
	act_date.setSqlDate(null);
	initRecord(request);
}
public void beforeDelete(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	ContrParamsAccessBean cp = new ContrParamsAccessBean();

	Enumeration en = cp.findByEquipmentAndActdateOrderByParamlevelAsc(new Integer(controllercode),act_date.getSqlDate());
	while(en.hasMoreElements()) {
		ContrParamsAccessBean s = (ContrParamsAccessBean)en.nextElement();
		s.getEJBRef().remove();
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return new ContrAddInfoAccessBean(new Integer(getControllercode()), getAct_date());
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:31:43)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getAcc_load() {
	return acc_load.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:31:43)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getAcc_loadFrm() {
	return acc_load.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 18:48:37)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getAct_date() {
	return act_date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 18:48:37)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getAct_dateFrm() {
	return act_date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 12:05:07)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getActdates() {
	return actdates.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 17:50:25)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:43:54)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getBad_cunsr_percent() {
	return bad_cunsr_percent.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:43:54)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getBad_cunsr_percentFrm() {
	return bad_cunsr_percent.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:50:24)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getBad_cunssr_percent() {
	return bad_cunssr_percent.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:50:24)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getBad_cunssr_percentFrm() {
	return bad_cunssr_percent.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:36:00)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getCap_use_percent() {
	return cap_use_percent.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:36:00)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getCap_use_percentFrm() {
	return cap_use_percent.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:52:58)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getConn_lost_avg() {
	return conn_lost_avg.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:52:58)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getConn_lost_avgFrm() {
	return conn_lost_avg.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 18:51:22)
 * @return int
 */
public int getControllercode() {
	return controllercode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:38:20)
 * @return java.lang.String
 */
public java.lang.String getControllername() {
	return controllername;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	if (getAct_date() != null) {
		try {
			ContrAddInfoAccessBean bean = new ContrAddInfoAccessBean();
			bean.setInitKey_act_date(getAct_date());
			bean.setInitKey_controller_storageplace(new Integer(getControllercode()));
			bean.refreshCopyHelper();
			
			return bean;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		}
	} else return null;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 14:50:32)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getKoef_kk() {
	return koef_kk.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 14:50:32)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getKoef_kkFrm() {
	return koef_kk.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 11:56:08)
 * @return java.util.Enumeration
 */
public Enumeration getKsos() {
	return getParams(3);
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 11:56:08)
 * @return java.util.Enumeration
 */
public Enumeration getKsot() {
	return getParams(2);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:08:22)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getLoad_aint_percent() {
	return load_aint_percent.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:08:22)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getLoad_aint_percentFrm() {
	return load_aint_percent.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 12:11:18)
 * @return java.lang.String
 */
public java.lang.String getLoad_max_day() {
	return load_max_day;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 13:00:09)
 * @return int
 */
public String getLoad_max_hour() {
	return load_max_hour;
}
private Enumeration getParams(int id) {
	try {
		return new ContrParamsAccessBean().findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
			new Integer(getControllercode()), getAct_date(), new Integer(id));
	} catch(Exception e) {
		return new Vector().elements();
	}
}
/**
 * 
 * @return int
 */
public int getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @return java.lang.String
 */
public java.lang.String getRegionname() {
	return regionname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:18:15)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSs7_load_avg() {
	return ss7_load_avg.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:18:15)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSs7_load_avgFrm() {
	return ss7_load_avg.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 17:50:25)
 * @return int
 */
public int getState() {
    return getAction().equals("View")
        ? com.hps.july.basestation.APPStates.CONTROLLER_DESC_VIEW
        : com.hps.july.basestation.APPStates.CONTROLLER_DESC_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 11:56:08)
 * @return java.util.Enumeration
 */
public Enumeration getTer() {
	return getParams(1);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:04:47)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getTraf_aint() {
	return traf_aint.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:04:47)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getTraf_aintFrm() {
	return traf_aint.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @return java.lang.String
 */
public java.lang.String getZonename() {
	return zonename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	boolean isExistDates = false;
	actdates.clear();
	
	Enumeration e = new ContrAddInfoAccessBean().findByEquipmentOrderByActdateAsc(new Integer(getControllercode()));
	while (e.hasMoreElements()) {
		ContrAddInfoAccessBean caiBean = (ContrAddInfoAccessBean) e.nextElement();
		if (!isExistDates) {
			isExistDates = true;
			if (getAct_date() == null) setAct_date(caiBean.getAct_date());
		}
		actdates.addElement(caiBean.getAct_date());
	}
	
	if (!actdates.contains(getAct_date()) && actdates.size() != 0) setAct_date((Date) actdates.get(0));
	if (actdates.size() == 0) setAct_date(null);
	
	ControllerAccessBean controllerBean = new ControllerAccessBean();
	controllerBean.setInitKey_storageplace(getControllercode());
	controllerBean.refreshCopyHelper();
	
	setControllername(controllerBean.getName() + ", " + controllerBean.getNumber());
	
	PositionAccessBean posBean = controllerBean.getPosition();

	positionid = posBean.getStorageplace();
	positionname = ""; //posBean.getStorageplace() + ", ";
	if (posBean.getGsmid() != null) {
		positionname += "D" + posBean.getGsmid() + " ";
	}
	if (posBean.getDampsid() != null) {
		positionname += "A" + posBean.getDampsid() + " ";
	}
	positionname += posBean.getName();
	
	setRegionname(posBean.getRegion().getRegname());
	setZonename(posBean.getNetZone().getName());
	setAddress(posBean.getAddress());

	try {
		editable = com.hps.july.apptags.HasRegionAccessTag.isRegionAccessible(posBean.getRegionKey().regionid,"Edit",request.getRemoteUser(),request.isUserInRole("administrator"));
	} catch(Exception ee) {
		ee.printStackTrace(System.out);
	}
	/*
	setLoad_max_day(null);
	setLoad_max_hour(null);
	setKoef_kk(null);
	setTraf_aint(null);
	setLoad_aint_percent(null);
	setSs7_load_avg(null);
	setAcc_load(null);
	setCap_use_percent(null);
	setBad_cunsr_percent(null);
	setBad_cunssr_percent(null);
	setConn_lost_avg(null);
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setAct_date(null);
	setLoad_max_day("");
	setLoad_max_hour("");
	setKoef_kk(null);
	setTraf_aint(null);
	setLoad_aint_percent(null);
	setSs7_load_avg(null);
	setAcc_load(null);
	setCap_use_percent(null);
	setBad_cunsr_percent(null);
	setBad_cunssr_percent(null);
	setConn_lost_avg(null);
}
/**
 * 
 * @return boolean
 */
public boolean isEditable() {
	return editable;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:31:43)
 * @param newAcc_load com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAcc_load(Integer newAcc_load) {
	acc_load.setInteger(newAcc_load);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:31:43)
 * @param newAcc_load com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAcc_loadFrm(String newAcc_load) {
	acc_load.setString(newAcc_load);
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 18:48:37)
 * @param newAct_date com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setAct_date(Date newAct_date) {
	act_date.setSqlDate(newAct_date);
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 18:48:37)
 * @param newAct_date com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setAct_dateFrm(String newAct_date) {
	act_date.setString(newAct_date);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:43:54)
 * @param newBad_cunsr_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBad_cunsr_percent(BigDecimal newBad_cunsr_percent) {
	bad_cunsr_percent.setBigDecimal(newBad_cunsr_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:43:54)
 * @param newBad_cunsr_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBad_cunsr_percentFrm(String newBad_cunsr_percent) {
	bad_cunsr_percent.setString(newBad_cunsr_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:50:24)
 * @param newBad_cunssr_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBad_cunssr_percent(BigDecimal newBad_cunssr_percent) {
	bad_cunssr_percent.setBigDecimal(newBad_cunssr_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:50:24)
 * @param newBad_cunssr_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBad_cunssr_percentFrm(String newBad_cunssr_percent) {
	bad_cunssr_percent.setString(newBad_cunssr_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:36:00)
 * @param newCap_use_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setCap_use_percent(BigDecimal newCap_use_percent) {
	cap_use_percent.setBigDecimal(newCap_use_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:36:00)
 * @param newCap_use_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setCap_use_percentFrm(String newCap_use_percent) {
	cap_use_percent.setString(newCap_use_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:52:58)
 * @param newConn_lost_avg com.hps.july.web.util.StringAndIntegerProperty
 */
public void setConn_lost_avg(Integer newConn_lost_avg) {
	conn_lost_avg.setInteger(newConn_lost_avg);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:52:58)
 * @param newConn_lost_avg com.hps.july.web.util.StringAndIntegerProperty
 */
public void setConn_lost_avgFrm(String newConn_lost_avg) {
	conn_lost_avg.setString(newConn_lost_avg);
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 18:51:22)
 * @param newControllercode int
 */
public void setControllercode(int newControllercode) {
	controllercode = newControllercode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:38:20)
 * @param newControllername java.lang.String
 */
public void setControllername(java.lang.String newControllername) {
	controllername = newControllername;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 14:50:32)
 * @param newKoef_kk com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setKoef_kk(BigDecimal newKoef_kk) {
	koef_kk.setBigDecimal(newKoef_kk);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 14:50:32)
 * @param newKoef_kk com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setKoef_kkFrm(String newKoef_kk) {
	koef_kk.setString(newKoef_kk);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:08:22)
 * @param newLoad_aint_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setLoad_aint_percent(BigDecimal newLoad_aint_percent) {
	load_aint_percent.setBigDecimal(newLoad_aint_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:08:22)
 * @param newLoad_aint_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setLoad_aint_percentFrm(String newLoad_aint_percent) {
	load_aint_percent.setString(newLoad_aint_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 12:11:18)
 * @param newLoad_max_day java.lang.String
 */
public void setLoad_max_day(java.lang.String newLoad_max_day) {
	load_max_day = newLoad_max_day;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 13:00:09)
 * @param newLoad_max_hour int
 */
public void setLoad_max_hour(String newLoad_max_hour) {
	load_max_hour = newLoad_max_hour;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @param newRegionname java.lang.String
 */
public void setRegionname(java.lang.String newRegionname) {
	regionname = newRegionname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:18:15)
 * @param newSs7_load_avg com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSs7_load_avg(BigDecimal newSs7_load_avg) {
	ss7_load_avg.setBigDecimal(newSs7_load_avg);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:18:15)
 * @param newSs7_load_avg com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSs7_load_avgFrm(String newSs7_load_avg) {
	ss7_load_avg.setString(newSs7_load_avg);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:04:47)
 * @param newTraf_aint com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTraf_aint(Integer newTraf_aint) {
	traf_aint.setInteger(newTraf_aint);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2003 15:04:47)
 * @param newTraf_aint com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTraf_aintFrm(String newTraf_aint) {
	traf_aint.setString(newTraf_aint);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2003 18:37:21)
 * @param newZonename java.lang.String
 */
public void setZonename(java.lang.String newZonename) {
	zonename = newZonename;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	Validator v = new Validator("error.cwd", null, errors);

	v.checkDate("date", act_date, true);

	if("Add".equals(getAction())) {
		try {
			ContrAddInfoAccessBean bf = new ContrAddInfoAccessBean();
			bf.setInitKey_act_date(act_date.getSqlDate());
			bf.setInitKey_controller_storageplace(new Integer(controllercode));
			bf.refreshCopyHelper();
			errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.cwd.notunique"));
		} catch(Exception e) {
		}
	}
	
	v.checkString("load_max_day", load_max_day, 20, false);
	v.checkString("load_max_hour", load_max_hour, 20, false);
	v.checkBigDecimal("koef_kk", koef_kk, false);
	v.checkInteger("traf_aint", traf_aint, false);
	v.checkBigDecimal("load_aint_percent", load_aint_percent, false);
	v.checkBigDecimal("ss7_load_avg", ss7_load_avg, false);
	v.checkInteger("acc_load", acc_load, false);
	v.checkBigDecimal("cap_use_percent", cap_use_percent, false);
	v.checkBigDecimal("bad_cunsr_percent", bad_cunsr_percent, false);
	v.checkBigDecimal("bad_cunssr_percent", bad_cunssr_percent, false);
	v.checkInteger("conn_lost_avg", conn_lost_avg, false);
	
	v.finishCheck();
}
}
