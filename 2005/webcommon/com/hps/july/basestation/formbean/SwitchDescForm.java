package com.hps.july.basestation.formbean;

import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.servlet.http.*;
import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.basestation.valueobject.Validator;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма редактирования эксплуатационных характеристик коммутатора
 */
public class SwitchDescForm
	extends EditForm
{
	private Vector actDates = new Vector();

	private boolean editable;

	private int positionid;
	private String positionname;
	private String regionname;
	private String zonename;
	private String address;
	private String switchname;
	
	private Integer equipment;
	
	private StringAndSqlDateProperty date = new StringAndSqlDateProperty();
	private String load_max_day;
	
	private String load_max_hour_all;
	private StringAndInteger traf_all = new StringAndInteger();
	private StringAndInteger traf_bss_all = new StringAndInteger();
	private StringAndInteger traf_nss_all = new StringAndInteger();
	private String load_max_hour_bss;
	private StringAndInteger traf_bss_bss = new StringAndInteger();
	private StringAndInteger abon_qty_bss = new StringAndInteger();
	private StringAndBigDecimal abon_act_bss = new StringAndBigDecimal(15,2);
	private String load_max_hour_nss;
	private StringAndInteger traf_nss_nss = new StringAndInteger();
	private StringAndInteger tryqty_mobile_all = new StringAndInteger();
	private StringAndInteger load_mobile = new StringAndInteger();
	private StringAndInteger tryqty_transit_all = new StringAndInteger();
	private StringAndInteger load_transit = new StringAndInteger();
	private StringAndInteger tryqty_sms_all = new StringAndInteger();
	private StringAndBigDecimal load_sms_percent = new StringAndBigDecimal(6,2);
	private StringAndBigDecimal load_event_percent = new StringAndBigDecimal(6,2);
	private StringAndBigDecimal load_all_percent = new StringAndBigDecimal(6,2);
	private StringAndBigDecimal koeff_kn = new StringAndBigDecimal(6,2);
public void afterDelete(HttpServletRequest request)
	throws Exception
{
	date.setSqlDate(null);
	initRecord(request);
}
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request)
throws Exception 
{
	SwitchParamsAccessBean sp = new SwitchParamsAccessBean();

	Enumeration en = sp.findByEquipmentAndActdateOrderByParamlevelAsc(equipment,date.getSqlDate());
	while(en.hasMoreElements()) {
		SwitchParamsAccessBean s = (SwitchParamsAccessBean)en.nextElement();
		s.getEJBRef().remove();
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	SwitchAddInfoAccessBean desc = (SwitchAddInfoAccessBean)bean;
	desc.setLoad_max_day(load_max_day);
	desc.setLoad_max_hour_all(load_max_hour_all);
	desc.setTraf_all(traf_all.getInteger());
	desc.setTraf_bss_all(traf_bss_all.getInteger());
	desc.setTraf_nss_all(traf_nss_all.getInteger());
	desc.setLoad_max_hour_bss(load_max_hour_bss);
	desc.setTraf_bss_bss(traf_bss_bss.getInteger());
	desc.setAbon_qty_bss(abon_qty_bss.getInteger());
	desc.setAbon_act_bss(abon_act_bss.getBigDecimal());
	desc.setLoad_max_hour_nss(load_max_hour_nss);
	desc.setTraf_nss_nss(traf_nss_nss.getInteger());
	desc.setTryqty_mobile_all(tryqty_mobile_all.getInteger());
	desc.setLoad_mobile(load_mobile.getInteger());
	desc.setTryqty_transit_all(tryqty_transit_all.getInteger());
	desc.setLoad_transit(load_transit.getInteger());
	desc.setTryqty_sms_all(tryqty_sms_all.getInteger());
	desc.setLoad_sms_percent(load_sms_percent.getBigDecimal());
	desc.setLoad_event_percent(load_event_percent.getBigDecimal());
	desc.setLoad_all_percent(load_all_percent.getBigDecimal());
	desc.setKoeff_kn(koeff_kn.getBigDecimal());
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws Exception
{
	SwitchAddInfoAccessBean bean = new SwitchAddInfoAccessBean(
		equipment,
		date.getSqlDate()
	);
	return bean;
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean)
{
	try {
		SwitchAddInfoAccessBean desc = (SwitchAddInfoAccessBean)bean;
		date.setSqlDate(desc.getAct_date());
		load_max_day = desc.getLoad_max_day();
		load_max_hour_all = desc.getLoad_max_hour_all();
		traf_all.setInteger(desc.getTraf_all());
		traf_bss_all.setInteger(desc.getTraf_bss_all());
		traf_nss_all.setInteger(desc.getTraf_nss_all());
		load_max_hour_bss = desc.getLoad_max_hour_bss();
		traf_bss_bss.setInteger(desc.getTraf_bss_bss());
		abon_qty_bss.setInteger(desc.getAbon_qty_bss());
		abon_act_bss.setBigDecimal(desc.getAbon_act_bss());
		load_max_hour_nss = desc.getLoad_max_hour_nss();
		traf_nss_nss.setInteger(desc.getTraf_nss_nss());
		tryqty_mobile_all.setInteger(desc.getTryqty_mobile_all());
		load_mobile.setInteger(desc.getLoad_mobile());
		tryqty_transit_all.setInteger(desc.getTryqty_transit_all());
		load_transit.setInteger(desc.getLoad_transit());
		tryqty_sms_all.setInteger(desc.getTryqty_sms_all());
		load_sms_percent.setBigDecimal(desc.getLoad_sms_percent());
		load_event_percent.setBigDecimal(desc.getLoad_event_percent());
		load_all_percent.setBigDecimal(desc.getLoad_all_percent());
		koeff_kn.setBigDecimal(desc.getKoeff_kn());
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getAbon_act_bss() {
	return abon_act_bss;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getAbon_qty_bss() {
	return abon_qty_bss;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
public Enumeration getAint_overload() {
	return getParams(3);
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public Enumeration getBsscerl() {
	return getParams(1);
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request)
{
	// correct date set's
	try {
		SwitchAddInfoAccessBean bean = new SwitchAddInfoAccessBean();
		bean.setInitKey_switch_storageplace(equipment);
		bean.setInitKey_act_date(date.getSqlDate());
		bean.refreshCopyHelper();
		return bean;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		System.out.println("SwitchAddInfo["+equipment+","+date.getString()+"] Not Found. Return null");
		date.setString("");
		try {
			initRecord(request);
		} catch(Exception ee) {
		}
		return null;
	}
}
public com.hps.july.web.util.StringAndSqlDateProperty getDate() {
	return date;
}
public Enumeration getDates() {
	return actDates.elements();
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getEquipment() {
	return equipment;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getKoeff_kn() {
	return koeff_kn;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getLoad_all_percent() {
	return load_all_percent;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getLoad_event_percent() {
	return load_event_percent;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLoad_max_day() {
	return load_max_day;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLoad_max_hour_all() {
	return load_max_hour_all;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLoad_max_hour_bss() {
	return load_max_hour_bss;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLoad_max_hour_nss() {
	return load_max_hour_nss;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getLoad_mobile() {
	return load_mobile;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getLoad_sms_percent() {
	return load_sms_percent;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getLoad_transit() {
	return load_transit;
}
public Enumeration getNsscerl() {
	return getParams(2);
}
public Enumeration getParams(int id) {
	try {
		SwitchParamsAccessBean bf = new SwitchParamsAccessBean();
		return bf.findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
			equipment,date.getSqlDate(),new Integer(id)
		);
	} catch(Exception e) {
		return (new Vector()).elements();
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
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRegionname() {
	return regionname;
}
public Enumeration getSs7_load() {
	return getParams(6);
}
public int getState() {
    return getAction().equals("View")
        ? com.hps.july.basestation.APPStates.SWCH_VIEW
        : com.hps.july.basestation.APPStates.SWCH_EDIT;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSwitchname() {
	return switchname;
}
public Enumeration getTkg_overload() {
	return getParams(4);
}
public Enumeration getTkgcsr_overload() {
	return getParams(5);
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTraf_all() {
	return traf_all;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTraf_bss_all() {
	return traf_bss_all;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTraf_bss_bss() {
	return traf_bss_bss;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTraf_nss_all() {
	return traf_nss_all;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTraf_nss_nss() {
	return traf_nss_nss;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTryqty_mobile_all() {
	return tryqty_mobile_all;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTryqty_sms_all() {
	return tryqty_sms_all;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getTryqty_transit_all() {
	return tryqty_transit_all;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getZonename() {
	return zonename;
}
public void initCollections(HttpServletRequest request)
	throws Exception
{
	try {
		SwitchAccessBean swch = new SwitchAccessBean();
		swch.setInitKey_storageplace(equipment.intValue());
		swch.refreshCopyHelper();
		
		switchname = swch.getName() + ", "+swch.getNumber();

		PositionAccessBean p = swch.getPosition();
		positionid = p.getStorageplace();
		positionname = ""+p.getStorageplace()+", ";
		if(p.getGsmid() != null) {
			positionname += "D"+p.getGsmid()+" ";
		}
		if(p.getDampsid() != null) {
			positionname += "A"+p.getDampsid()+" ";
		}
		positionname += p.getName();
		
		regionname = p.getRegion().getRegname();

		zonename = p.getNetZone().getName();

		address = p.getAddress();
		
		SwitchAddInfoAccessBean bean = new SwitchAddInfoAccessBean();
		Enumeration en = bean.findByEquipmentOrderByActdateAsc(equipment);
		actDates.clear();
		while(en.hasMoreElements()) {
			SwitchAddInfoAccessBean b = (SwitchAddInfoAccessBean)en.nextElement();
			actDates.add(b.getAct_date());
		}
		if(actDates.size() > 0) {
			if(date.getSqlDate() == null) {
				date.setSqlDate((java.sql.Date)actDates.get(0));
			}
		} else {
			date.setString("");
		}

		editable = com.hps.july.apptags.HasRegionAccessTag.isRegionAccessible(p.getRegionKey().regionid,"Edit",request.getRemoteUser(),request.isUserInRole("administrator"));
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	load_max_day = "";
	load_max_hour_all = "";
	traf_all.setString("");
	traf_bss_all.setString("");
	traf_nss_all.setString("");
	load_max_hour_bss = "";
	traf_bss_bss.setString("");
	abon_qty_bss.setString("");
	abon_act_bss.setString("");
	load_max_hour_nss = "";
	traf_nss_nss.setString("");
	tryqty_mobile_all.setString("");
	load_mobile.setString("");
	tryqty_transit_all.setString("");
	load_transit.setString("");
	tryqty_sms_all.setString("");
	load_sms_percent.setString("");
	load_event_percent.setString("");
	load_all_percent.setString("");
	koeff_kn.setString("");
}
/**
 * 
 * @return boolean
 */
public boolean isEditable() {
	return editable;
}
/**
 * 
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * 
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDate(com.hps.july.web.util.StringAndSqlDateProperty newDate) {
	date = newDate;
}
public void setEquipment(java.lang.Integer newEquipment) {
	equipment = newEquipment;
	// populate equipment and position information
}
/**
 * 
 * @param newLoad_max_day java.lang.String
 */
public void setLoad_max_day(java.lang.String newLoad_max_day) {
	load_max_day = newLoad_max_day;
}
/**
 * 
 * @param newLoad_max_hour_all java.lang.String
 */
public void setLoad_max_hour_all(java.lang.String newLoad_max_hour_all) {
	load_max_hour_all = newLoad_max_hour_all;
}
/**
 * 
 * @param newLoad_max_hour_bss java.lang.String
 */
public void setLoad_max_hour_bss(java.lang.String newLoad_max_hour_bss) {
	load_max_hour_bss = newLoad_max_hour_bss;
}
/**
 * 
 * @param newLoad_max_hour_nss java.lang.String
 */
public void setLoad_max_hour_nss(java.lang.String newLoad_max_hour_nss) {
	load_max_hour_nss = newLoad_max_hour_nss;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * 
 * @param newRegionname java.lang.String
 */
public void setRegionname(java.lang.String newRegionname) {
	regionname = newRegionname;
}
/**
 * 
 * @param newSwitchname java.lang.String
 */
public void setSwitchname(java.lang.String newSwitchname) {
	switchname = newSwitchname;
}
/**
 * 
 * @param newZonename java.lang.String
 */
public void setZonename(java.lang.String newZonename) {
	zonename = newZonename;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	Validator v = new Validator("error.swd", null, errors);

	v.checkDate("date", date, true);

	if("Add".equals(getAction())) {
		try {
			SwitchAddInfoAccessBean bf = new SwitchAddInfoAccessBean();
			bf.setInitKey_act_date(date.getSqlDate());
			bf.setInitKey_switch_storageplace(equipment);
			bf.refreshCopyHelper();
			errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swd.notunique"));
		} catch(Exception e) {
		}
	}
	
	v.checkString("load_max_day", load_max_day, 20, false);
	
	v.checkString("load_max_hour_all", load_max_hour_all, 20, false);
	v.checkInteger("traf_all", traf_all, false);
	v.checkInteger("traf_bss_all", traf_bss_all, false);
	v.checkInteger("traf_nss_all", traf_nss_all, false);
	v.checkString("load_max_hour_bss", load_max_hour_bss, 20, false);
	v.checkInteger("traf_bss_bss", traf_bss_bss, false);
	v.checkInteger("abon_qty_bss", abon_qty_bss, false);
	v.checkBigDecimal("abon_act_bss", abon_act_bss, false);
	v.checkString("load_max_hour_nss", load_max_hour_nss, 20, false);
	v.checkInteger("traf_nss_nss", traf_nss_nss, false);
	v.checkInteger("tryqty_mobile_all", tryqty_mobile_all, false);
	v.checkInteger("load_mobile", load_mobile, false);
	v.checkInteger("tryqty_transit_all", tryqty_transit_all, false);
	v.checkInteger("load_transit", load_transit, false);
	v.checkInteger("tryqty_sms_all", tryqty_sms_all, false);
	v.checkBigDecimal("load_sms_percent", load_sms_percent, false);
	v.checkBigDecimal("load_event_percent", load_event_percent, false);
	v.checkBigDecimal("load_all_percent", load_all_percent, false);
	v.checkBigDecimal("koeff_kn", koeff_kn, false);

	v.finishCheck();
}
}
