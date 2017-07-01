package com.hps.july.siteinfo.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.siteinfo.valueobject.*;
import java.util.*;
import java.math.BigDecimal;
import com.hps.july.jdbcpersistence.lib.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.apptags.*;
import com.hps.july.siteinfo.actionbean.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * Форма отображения информации по организации.
 */
public class OrganizationPrintForm extends EditForm {
	private java.lang.String shortname;
	private java.lang.String name;
	private java.lang.String inn;
	private java.lang.String kpp;
	private java.lang.String managerposition;
	private java.lang.String managername;
	private String accountername;
	private java.lang.String billaddress;
	private java.lang.String phones;
	private java.lang.String contactinfo;
	private int organization;
/**
 * EPositionPrintForm constructor comment.
 */
public OrganizationPrintForm() {
	super();
}
/**
 * Создание объекта не поддерживается формой.
 * Creation date: (13.02.2002 10:20:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Заполнение полей для отображения.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	OrganizationAccessBean org = (OrganizationAccessBean)bean;
	try {
		setShortname(org.getShortname());
		setName(org.getName());
		setInn(org.getInn());
		setKpp(org.getKpp());
		setManagerposition(org.getBossPosition());
		setManagername(org.getDirectorinfo());
		setAccountername(org.getAccauntmanagerinfo());
		setBilladdress(org.getLegaladdress());
		setPhones(org.getPhone());
		setContactinfo(org.getContactList());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:27:27)
 * @return int
 */
public String getAccountername() {
	return accountername;
}
/**
 * Возвращает приложение.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:27:51)
 * @return java.lang.String
 */
public java.lang.String getBilladdress() {
	return billaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:28:24)
 * @return java.lang.String
 */
public java.lang.String getContactinfo() {
	return contactinfo;
}
/**
 * Возвращает bean организации.
 * Creation date: (13.02.2002 10:12:41)
 */
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	OrganizationAccessBean org = new OrganizationAccessBean();
	org.setInitKey_organization(getOrganization());
	return org;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:24:33)
 * @return java.lang.String
 */
public java.lang.String getInn() {
	return inn;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:25:18)
 * @return java.lang.String
 */
public java.lang.String getKpp() {
	return kpp;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:26:34)
 * @return java.lang.String
 */
public java.lang.String getManagername() {
	return managername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:26:22)
 * @return java.lang.String
 */
public java.lang.String getManagerposition() {
	return managerposition;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:23:08)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:37:18)
 * @return int
 */
public int getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:28:08)
 * @return java.lang.String
 */
public java.lang.String getPhones() {
	return phones;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:22:53)
 * @return java.lang.String
 */
public java.lang.String getShortname() {
	return shortname;
}
/**
 * Возвращает состояние, идентифицирующее данный режим.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.ORGPRINT;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:27:27)
 * @param newAccountername int
 */
public void setAccountername(String newAccountername) {
	accountername = newAccountername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:27:51)
 * @param newBilladdress java.lang.String
 */
public void setBilladdress(java.lang.String newBilladdress) {
	billaddress = newBilladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:28:24)
 * @param newContactinfo java.lang.String
 */
public void setContactinfo(java.lang.String newContactinfo) {
	contactinfo = newContactinfo;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:24:33)
 * @param newInn java.lang.String
 */
public void setInn(java.lang.String newInn) {
	inn = newInn;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:25:18)
 * @param newKpp java.lang.String
 */
public void setKpp(java.lang.String newKpp) {
	kpp = newKpp;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:26:34)
 * @param newManagername java.lang.String
 */
public void setManagername(java.lang.String newManagername) {
	managername = newManagername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:26:22)
 * @param newManagerposition java.lang.String
 */
public void setManagerposition(java.lang.String newManagerposition) {
	managerposition = newManagerposition;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:23:08)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:37:18)
 * @param newOrganization int
 */
public void setOrganization(int newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:28:08)
 * @param newPhones java.lang.String
 */
public void setPhones(java.lang.String newPhones) {
	phones = newPhones;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2004 16:22:53)
 * @param newShortname java.lang.String
 */
public void setShortname(java.lang.String newShortname) {
	shortname = newShortname;
}
}
