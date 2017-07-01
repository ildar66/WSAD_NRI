package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.ListIterator;
import java.util.Vector;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода акта монтажа блоков в виде сложного документа.
 * Creation date: (15.10.2004 17:26:12)
 * @author: Dmitry Dneprov
 */
public class AfsIndoorMountActForm extends com.hps.july.web.util.EditForm {
	private java.lang.String actdate;
	private java.lang.String posnumber;
	private java.lang.Integer ownercode;
	private int document;
	private java.lang.String providercode;
	private java.lang.String providername;
	private java.lang.String insuranceMan;
	private java.lang.String workercode;
	private java.lang.String workername;
	private java.lang.String workertitle;
	private java.lang.Integer complectcode;
	private java.lang.String complectname;
	private java.lang.String user;
	private boolean manycomplects;
	private java.lang.String oldposnumber;
	private java.lang.Boolean isAdmin;
	private int refreshFields;
	private java.lang.String sector;
	private java.lang.String eqtype;
	private java.lang.Integer[] repmodel;
	private java.lang.String[] repserial;
	private java.lang.String[] repcomment;
	private java.util.ArrayList antmodel;
	private java.util.ArrayList divmodel;
	private  java.util.ArrayList antserial;
	private  java.util.ArrayList divserial;
	private java.util.ArrayList antcable;
	private java.util.ArrayList divcable;
	private java.util.ArrayList antcablen;
	private java.util.ArrayList divcablen;
	private java.util.ArrayList antcomment;
	private java.util.ArrayList divcomment;
	private java.lang.Integer antmodeltmp;
	private java.lang.Integer divmodeltmp;
	private java.lang.Integer antcabletmp;
	private java.lang.Integer divcabletmp;
	private java.lang.String antcnttmp;
	private java.lang.String divcnttmp;
	private java.lang.String oldeqtype;
	private java.lang.Integer projectid;
	private java.lang.String projectname;
	private boolean needapprove;
	private java.lang.String readprjstatus;
	private boolean enableclosefkbs;
	
	public boolean getEnableclosefkbs(){
		return com.hps.july.inventory.formbean.CheckOldBS.isEnabledCloseFKBS();
	}
	
/**
 * Конструктор формы.
 * Creation date: (01.03.2005 13:57:23)
 */
public AfsIndoorMountActForm() {
	repmodel = new Integer[2];
	repserial = new String [2];
	repcomment = new String [2];
	eqtype = "A";
	antmodel = new  java.util.ArrayList();
	antserial = new  java.util.ArrayList();
	antcable = new  java.util.ArrayList();
	antcablen = new  java.util.ArrayList();
	antcomment = new  java.util.ArrayList();
	antcnttmp = "1";

	divmodel = new  java.util.ArrayList();
	divserial = new  java.util.ArrayList();
	divcable = new  java.util.ArrayList();
	divcablen = new  java.util.ArrayList();
	divcomment = new  java.util.ArrayList();
	divcnttmp = "1";
	
	// Debug
	//antserial.add("testserial");
	//divserial.add("testserial");
}

/**
 * Проверим нужно ли требовать согласование документа и есть ли проект.
 * Creation date: (15.12.2005 17:04:14)
 * @return boolean
 */

protected void checkProject(ActionErrors errors) {
	CDBCComProjectsObject cpob = new CDBCComProjectsObject();
	if (cpob.checkProject(getComplectcode())) {
		setProjectid(cpob.getProjectid());
		setProjectname(cpob.getProjectname());
		setNeedapprove(cpob.isNeedapprove());
	} else {
		setProjectid(cpob.getProjectid());
		setProjectname(cpob.getProjectname());
		setNeedapprove(cpob.isNeedapprove());
		errors.add("head", new ActionError("error.mountact2.invalid.project"));
	}
}

/**
 * ID проекта на строительство БС.
 * Creation date: (15.12.2005 16:54:28)
 * @return java.lang.Integer
 */
public java.lang.Integer getProjectid() {
	return projectid;
}

/**
 * Наименование проекта на строительство БС.
 * Creation date: (15.12.2005 16:54:54)
 * @return java.lang.String
 */
public java.lang.String getProjectname() {
	return projectname;
}

/**
 * Статус проекта на строительство БС (только чтение из БД)
 * Creation date: (15.12.2005 17:00:15)
 * @param newReadprjstatus java.lang.String
 */
public void setPrjstatus(java.lang.String newReadprjstatus) {
	readprjstatus = newReadprjstatus;
}

/**
 * Статус проекта на строительство БС (только чтение из БД)
 * @return
 */
public java.lang.String getReadprjstatus() {
	return readprjstatus;
}

/**
 * ID проекта на строительство БС
 * Creation date: (15.12.2005 16:54:28)
 * @param newProjectid java.lang.Integer
 */
public void setProjectid(java.lang.Integer newProjectid) {
	projectid = newProjectid;
}

/**
 * Наименование проекта на строительство БС
 * Creation date: (15.12.2005 16:54:54)
 * @param newProjectname java.lang.String
 */
public void setProjectname(java.lang.String newProjectname) {
	projectname = newProjectname;
}

/**
 * Документ требует согласования
 * Creation date: (15.12.2005 16:56:04)
 * @return boolean
 */
public boolean isNeedapprove() {
	return needapprove;
}

/**
 * Документ требует согласования
 * Creation date: (15.12.2005 16:56:04)
 * @param newNeedapprove boolean
 */
public void setNeedapprove(boolean newNeedapprove) {
	needapprove = newNeedapprove;
}

/**
 * Наименование статуса от проектировщиков
 * Creation date: (15.12.2005 16:56:04)
 * @param newNeedapprove boolean
 */
public String getPrjstatusname() {
	return CDBCComProjectsObject.formatProjectState(getReadprjstatus());
}

/**
 * Проверяет достаточность размера ArrayList перед установкой значения элемента с заданным индексом.
 * при необходимости добавляет элементов
 * Creation date: (01.03.2005 14:40:16)
 * @param arList java.util.ArrayList
 * @param index int
 */
private void checkSize(java.util.ArrayList arList, int index) {
	int asize = arList.size();
	//System.out.println("CheckSize: size=" + asize + ", index=" + index);
	if (asize < (index+1)) {
		for (int i=0; i < index+1 - asize; i++) {
			//System.out.println("CheckSize: add element");
			arList.add(null);
		}
	}
	//System.out.println("CheckSize before exit: size=" + arList.size() + ", index=" + index);
}
/**
 * Исключает пустые записи антенн.
 * при необходимости добавляет элементов
 * Creation date: (01.03.2005 14:40:16)
 * @param arList java.util.ArrayList
 * @param index int
 */
private void ExcludeEmptyAntennes() {
	int asize = antmodel.size();
	for (int i=0; i < asize; i++) {
		if ( (antmodel.get(i) == null) && (antserial.get(i) == null) &&
			(antcable.get(i) == null) && (antcablen.get(i) == null) && (antcomment.get(i) == null)) {
				antmodel.remove(i);
				antserial.remove(i);
				antcable.remove(i);
				antcablen.remove(i);
				antcomment.remove(i);
				asize = asize - 1;
				i = i - 1;
		}
	}
}
/**
 * Исключает пустые записи делителей.
 * при необходимости добавляет элементов
 * Creation date: (01.03.2005 14:40:16)
 * @param arList java.util.ArrayList
 * @param index int
 */
private void ExcludeEmptyDividers() {
	int asize = divmodel.size();
	for (int i=0; i < asize; i++) {
		if ( (divmodel.get(i) == null) && (divserial.get(i) == null) &&
			(divcable.get(i) == null) && (divcablen.get(i) == null) && (divcomment.get(i) == null)) {
				divmodel.remove(i);
				divserial.remove(i);
				divcable.remove(i);
				divcablen.remove(i);
				divcomment.remove(i);
				asize = asize - 1;
				i = i - 1;
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:32:15)
 * @return java.lang.String
 */
public java.lang.String getActdate() {
	return actdate;
}
/**
 * Получить модель кабеля антенны.
 * Creation date: (01.03.2005 14:24:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getAntcable(int index) {
	checkSize(antcable, index);
	return (Integer)antcable.get(index);
}
/**
 * Получить длину кабеля антенны.
 * Creation date: (01.03.2005 14:25:28)
 * @return java.lang.String
 */
public java.lang.String getAntcablen(int index) {
	checkSize(antcablen, index);
	return (String)antcablen.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2005 16:05:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getAntcabletmp() {
	return antcabletmp;
}
/**
 * Количество строк для добавления антенн.
 * Creation date: (01.03.2005 16:25:32)
 * @return java.lang.String
 */
public java.lang.String getAntcnttmp() {
	return antcnttmp;
}
/**
 * Получить комментарий к антенне.
 * Creation date: (01.03.2005 14:25:54)
 * @return java.lang.String
 */
public java.lang.String getAntcomment(int index) {
	checkSize(antcomment, index);
	return (String)antcomment.get(index);
}
/**
 * Возвращает количество записей об антеннах.
 * Creation date: (15.10.2004 17:47:06)
 * @return java.lang.Integer
 */
public int getAntcount() {
	int resSize = 0;
	if (antcable.size() > resSize)
		resSize = antcable.size();
	if (antcablen.size() > resSize)
		resSize = antcablen.size();
	if (antcomment.size() > resSize)
		resSize = antcomment.size();
	if (antmodel.size() > resSize)
		resSize = antmodel.size();
	if (antserial.size() > resSize)
		resSize = antserial.size();
	return resSize;
}
/**
 * Выдает список моделей антенн.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getAntennaModels() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResources(new Integer(40));
}
/**
 * Получить модель антенны.
 * Creation date: (01.03.2005 14:24:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getAntmodel(int index) {
	checkSize(antmodel, index);
	return (Integer)antmodel.get(index);
}
/**
 * Модель антенны для добавления строк.
 * Creation date: (01.03.2005 16:04:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getAntmodeltmp() {
	return antmodeltmp;
}
/**
 * Получить серийный номер антенны.
 * Creation date: (01.03.2005 14:24:32)
 * @return java.lang.String
 */
public java.lang.String getAntserial(int index) {
	checkSize(antserial, index);
	return (String)antserial.get(index);
}
/**
 * Текущее приложение.
 * Creation date: (15.10.2004 17:26:12)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Выдает список моделей кабелей.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCableModels() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResources(new Integer(42));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources(Integer argCategory) {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResources(argCategory);
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectcode() {
	return complectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:39)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * Выдает список комплектов оборудования с заданным номером GSM.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getComplects() {
			if ("A".equals(getEqtype())) {
				// Определим комплект оборудования - Базовая станция
				return new CDBCEquipmentObject().findBaseStations(
					Boolean.TRUE, null,
					CDBCEquipmentObject.TYPE_SEARCH_GSM,
					Boolean.TRUE, null,
					Boolean.TRUE,	null,
					CDBCEquipmentObject.SEARCHBY_NUMBER,
					getPosnumber(),
					Boolean.TRUE,	null,
					Boolean.TRUE,	null,
					Boolean.FALSE,	 "PMRTW",
					"PE",
					null,
					getIsAdmin(),
					getUser(),
					new Integer(CDBCEquipmentObject.ORDER_NAME_ASC)
				);
			} else if ("B".equals(getEqtype())) {
				// Определим комплект оборудования - репитер
				return new CDBCEquipmentObject().findRepeaterList(
					Boolean.TRUE, null,
					Boolean.TRUE, null,
					Boolean.TRUE, null,
					CDBCEquipmentObject.SEARCHBY_NUMBER, getPosnumber(),
					Boolean.TRUE, null,
					"*",
					getIsAdmin(), getUser(),
					new Integer(CDBCEquipmentObject.ORDER_NAME_ASC)
				);
		}
		return null;
}
/**
 * Получить модель кабеля делителя.
 * Creation date: (01.03.2005 14:24:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getDivcable(int index) {
	checkSize(divcable, index);
	return (Integer)divcable.get(index);
}
/**
 * Получить длину кабеля делителя.
 * Creation date: (01.03.2005 14:25:28)
 * @return java.lang.String
 */
public java.lang.String getDivcablen(int index) {
	checkSize(divcablen, index);
	return (String)divcablen.get(index);
}
/**
 * Тип кабеля для добавления строк.
 * Creation date: (01.03.2005 16:05:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getDivcabletmp() {
	return divcabletmp;
}
/**
 * Количество строк для добавления делителей.
 * Creation date: (01.03.2005 16:25:32)
 * @return java.lang.String
 */
public java.lang.String getDivcnttmp() {
	return divcnttmp;
}
/**
 * Получить комментарий к делителю.
 * Creation date: (01.03.2005 14:25:54)
 * @return java.lang.String
 */
public java.lang.String getDivcomment(int index) {
	checkSize(divcomment, index);
	return (String)divcomment.get(index);
}
/**
 * Возвращает количество записей о делителях.
 * Creation date: (15.10.2004 17:47:06)
 * @return java.lang.Integer
 */
public int getDivcount() {
	int resSize = 0;
	if (divcable.size() > resSize)
		resSize = divcable.size();
	if (divcablen.size() > resSize)
		resSize = divcablen.size();
	if (divcomment.size() > resSize)
		resSize = divcomment.size();
	if (divmodel.size() > resSize)
		resSize = divmodel.size();
	if (divserial.size() > resSize)
		resSize = divserial.size();
	return resSize;
}
/**
 * Выдает список моделей делителей.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getDividerModels() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResources(new Integer(41));
}
/**
 * Получить модель делителя.
 * Creation date: (01.03.2005 14:24:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getDivmodel(int index) {
	checkSize(divmodel, index);
	return (Integer)divmodel.get(index);
}
/**
 * Модель делителя для добавления строк.
 * Creation date: (01.03.2005 16:04:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getDivmodeltmp() {
	return divmodeltmp;
}
/**
 * Получить серийный номер делителя.
 * Creation date: (01.03.2005 14:24:32)
 * @return java.lang.String
 */
public java.lang.String getDivserial(int index) {
	checkSize(divserial, index);
	return (String)divserial.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 18:05:17)
 * @return int
 */
public int getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2005 18:01:47)
 * @return java.lang.String
 */
public java.lang.String getEqtype() {
	return eqtype;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:36)
 * @return java.lang.String
 */
public java.lang.String getInsuranceMan() {
	return insuranceMan;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 12:38:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAdmin() {
	return isAdmin;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2005 15:44:13)
 * @return java.lang.String
 */
public java.lang.String getOldeqtype() {
	return oldeqtype;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:41:33)
 * @return java.lang.String
 */
public java.lang.String getOldposnumber() {
	return oldposnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:47:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
/**
 * Список возможных владельцев.
 * Creation date: (19.06.2002 11:40:25)
 * @return java.util.Enumeration
 */
public Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:34:21)
 * @return java.lang.String
 */
public java.lang.String getPosnumber() {
	return posnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:32:55)
 * @return java.lang.String
 */
public java.lang.String getProvidercode() {
	return providercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:12)
 * @return java.lang.String
 */
public java.lang.String getProvidername() {
	return providername;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 14:51:13)
 * @return int
 */
public int getRefreshFields() {
	return refreshFields;
}
/**
 * Получить комментарий репитера.
 * Creation date: (01.03.2005 11:17:50)
 * @return java.lang.String[]
 */
public java.lang.String getRepcomment(int index) {
	return repcomment [index];
}
/**
 * Выдает список моделей репитеров.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getRepiterModels() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResources(new Integer(39));
}
/**
 * Возвращает модель репитера .
 * Creation date: (01.03.2005 11:16:56)
 * @return java.lang.Integer[]
 */
public java.lang.Integer getRepmodel(int index) {
	return repmodel [index];
}
/**
 * Возвращает серийный номер репитера.
 * Creation date: (01.03.2005 11:17:14)
 * @return java.lang.String[]
 */
public java.lang.String getRepserial(int index) {
	return repserial [index];
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2005 18:01:28)
 * @return java.lang.String
 */
public java.lang.String getSector() {
	return sector;
}
/**
 * Текущее состояние приложения.
 * Creation date: (15.10.2004 17:26:12)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.AFSINDOOR;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 18:20:28)
 * @return java.lang.String
 */
public java.lang.String getUser() {
	return user;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:09)
 * @return java.lang.String
 */
public java.lang.String getWorkercode() {
	return workercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:29)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:52)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setManycomplects(false);
	setComplectcode(null);
	setOldposnumber("");
	int defOwner = com.hps.july.util.AppUtils.getNamedValueInt("INVENTORY_DEFOWNER");
	if (defOwner != 0)
		setOwnercode(new Integer(defOwner));
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:08:46)
 * @return boolean
 */
public boolean isManycomplects() {
	return manycomplects;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:32:15)
 * @param newActdate java.lang.String
 */
public void setActdate(java.lang.String newActdate) {
	actdate = newActdate;
}
/**
 * Установить кабель антенны.
 * Creation date: (01.03.2005 14:24:49)
 * @param newAntcable java.lang.Integer
 */
public void setAntcable(int index, java.lang.Integer newAntcable) {
	checkSize(antcable, index);
	antcable.set(index, newAntcable);
}
/**
 * Установить длину кабеля антенны.
 * Creation date: (01.03.2005 14:25:28)
 * @param newAntcablen java.lang.String
 */
public void setAntcablen(int index, java.lang.String newAntcablen) {
	checkSize(antcablen, index);
	antcablen.set(index, newAntcablen);
}
/**
 * Установить тип кабеля для добавления антенн.
 * Creation date: (01.03.2005 16:05:03)
 * @param newAntcabletmp java.lang.Integer
 */
public void setAntcabletmp(java.lang.Integer newAntcabletmp) {
	antcabletmp = newAntcabletmp;
}
/**
 * Установить количество строк для добавления антенны.
 * Creation date: (01.03.2005 16:25:32)
 * @param newAntcnttmp java.lang.String
 */
public void setAntcnttmp(java.lang.String newAntcnttmp) {
	antcnttmp = newAntcnttmp;
}
/**
 * Установить комментарий к антенне.
 * Creation date: (01.03.2005 14:25:54)
 * @param newAntcomment java.lang.String
 */
public void setAntcomment(int index, java.lang.String newAntcomment) {
	checkSize(antcomment, index);
	antcomment.set(index, newAntcomment);
}
/**
 * Установить модель антенны.
 * Creation date: (01.03.2005 14:24:09)
 * @param newAntmodel java.lang.Integer
 */
public void setAntmodel(int index, java.lang.Integer newAntmodel) {
	checkSize(antmodel, index);
	antmodel.set(index, newAntmodel);
}
/**
 * Установить модель антенны для добавления строк.
 * Creation date: (01.03.2005 16:04:37)
 * @param newAntmodeltmp java.lang.Integer
 */
public void setAntmodeltmp(java.lang.Integer newAntmodeltmp) {
	antmodeltmp = newAntmodeltmp;
}
/**
 * Установить серийный номер антенны.
 * Creation date: (01.03.2005 14:24:32)
 * @param newAntserial java.lang.String
 */
public void setAntserial(int index, java.lang.String newAntserial) {
	checkSize(antserial, index);
	antserial.set(index, newAntserial);
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:20)
 * @param newComplectcode java.lang.Integer
 */
public void setComplectcode(java.lang.Integer newComplectcode) {
	complectcode = newComplectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:39)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Установить кабель делителя.
 * Creation date: (01.03.2005 14:24:49)
 * @param newAntcable java.lang.Integer
 */
public void setDivcable(int index, java.lang.Integer newDivcable) {
	checkSize(divcable, index);
	divcable.set(index, newDivcable);
}
/**
 * Установить длину кабеля делителя.
 * Creation date: (01.03.2005 14:25:28)
 * @param newAntcablen java.lang.String
 */
public void setDivcablen(int index, java.lang.String newDivcablen) {
	checkSize(divcablen, index);
	divcablen.set(index, newDivcablen);
}
/**
 * Установить тип кабеля для добавления делителя.
 * Creation date: (01.03.2005 16:05:03)
 * @param newAntcabletmp java.lang.Integer
 */
public void setDivcabletmp(java.lang.Integer newDivcabletmp) {
	divcabletmp = newDivcabletmp;
}
/**
 * Установить количество строк для добавления делителя.
 * Creation date: (01.03.2005 16:25:32)
 * @param newAntcnttmp java.lang.String
 */
public void setDivcnttmp(java.lang.String newDivcnttmp) {
	divcnttmp = newDivcnttmp;
}
/**
 * Установить комментарий к делителю.
 * Creation date: (01.03.2005 14:25:54)
 * @param newAntcomment java.lang.String
 */
public void setDivcomment(int index, java.lang.String newDivcomment) {
	checkSize(divcomment, index);
	divcomment.set(index, newDivcomment);
}
/**
 * Установить модель делителя.
 * Creation date: (01.03.2005 14:24:09)
 * @param newAntmodel java.lang.Integer
 */
public void setDivmodel(int index, java.lang.Integer newDivmodel) {
	checkSize(divmodel, index);
	divmodel.set(index, newDivmodel);
}
/**
 * Установить модель делителя для добавления строк.
 * Creation date: (01.03.2005 16:04:37)
 * @param newAntmodeltmp java.lang.Integer
 */
public void setDivmodeltmp(java.lang.Integer newDivmodeltmp) {
	divmodeltmp = newDivmodeltmp;
}
/**
 * Установить серийный номер делителя.
 * Creation date: (01.03.2005 14:24:32)
 * @param newAntserial java.lang.String
 */
public void setDivserial(int index, java.lang.String newDivserial) {
	checkSize(divserial, index);
	divserial.set(index, newDivserial);
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 18:05:17)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2005 18:01:47)
 * @param newEqtype java.lang.String
 */
public void setEqtype(java.lang.String newEqtype) {
	eqtype = newEqtype;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:36)
 * @param newInsuranceMan java.lang.String
 */
public void setInsuranceMan(java.lang.String newInsuranceMan) {
	insuranceMan = newInsuranceMan;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 12:38:21)
 * @param newIsAdmin java.lang.Boolean
 */
public void setIsAdmin(java.lang.Boolean newIsAdmin) {
	isAdmin = newIsAdmin;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:08:46)
 * @param newManycomplects boolean
 */
public void setManycomplects(boolean newManycomplects) {
	manycomplects = newManycomplects;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2005 15:44:13)
 * @param newOldeqtype java.lang.String
 */
public void setOldeqtype(java.lang.String newOldeqtype) {
	oldeqtype = newOldeqtype;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:41:33)
 * @param newOldposnumber java.lang.String
 */
public void setOldposnumber(java.lang.String newOldposnumber) {
	oldposnumber = newOldposnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:47:06)
 * @param newOwnercode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:34:21)
 * @param newPosnumber java.lang.String
 */
public void setPosnumber(java.lang.String newPosnumber) {
	posnumber = newPosnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:32:55)
 * @param newProvidercode java.lang.String
 */
public void setProvidercode(java.lang.String newProvidercode) {
	providercode = newProvidercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:12)
 * @param newProvidername java.lang.String
 */
public void setProvidername(java.lang.String newProvidername) {
	providername = newProvidername;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 14:51:13)
 * @param newRefreshFields int
 */
public void setRefreshFields(int newRefreshFields) {
	refreshFields = newRefreshFields;
}
/**
 * Установка комментария репитера.
 * Creation date: (01.03.2005 11:17:50)
 * @param newRepcomment java.lang.String[]
 */
public void setRepcomment(int index, java.lang.String newRepcomment) {
	repcomment [index] = newRepcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2005 11:16:56)
 * @param newRepmodel java.lang.Integer[]
 */
public void setRepmodel(java.lang.Integer[] newRepmodel) {
	repmodel = newRepmodel;
}
/**
 * Устанавливает значение модели репитера.
 * Creation date: (01.03.2005 11:16:56)
 * @param newRepmodel java.lang.Integer[]
 */
public void setRepmodel(int index, java.lang.Integer newRepmodel) {
	repmodel [index] = newRepmodel;
}
/**
 * Устанавливает серийный номер репитера.
 * Creation date: (01.03.2005 11:17:14)
 * @param newRepserial java.lang.String[]
 */
public void setRepserial(int index, java.lang.String newRepserial) {
	repserial [index] = newRepserial;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2005 18:01:28)
 * @param newSector java.lang.String
 */
public void setSector(java.lang.String newSector) {
	sector = newSector;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 18:20:28)
 * @param newUser java.lang.String
 */
public void setUser(java.lang.String newUser) {
	user = newUser;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:09)
 * @param newWorkercode java.lang.String
 */
public void setWorkercode(java.lang.String newWorkercode) {
	workercode = newWorkercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:29)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:52)
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
/**
 * Проверяет заполнение полей в коллекции.
 * Creation date: (01.03.2005 14:40:16)
 * @param arList java.util.ArrayList
 */
private void validateDecimalCollection(java.util.ArrayList arList, String errorName, ActionErrors errors, String errorText) {
	int asize = arList.size();
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal si = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 2);
	for (int i=0; i < asize; i++) {
		String val = (String)arList.get(i);
		si.setString(val);
		if ( !si.isOkAndNotEmpty() ) {
			String editPos = errorName + "[" + i + "]";
			errors.add(editPos, new ActionError(errorText));
		}
	}
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateResource(Integer argResource, String argSerial, String argQty, String argMsgKey, ActionErrors errors) {
	
	String editPos = "resource" + argMsgKey;
	
	// Проверим заполнение обоих полей или что оба незаполнены
	if  (argResource == null)
		return;

	String policy = "";
	// Проверим ресурс			
	try {
		int bi = argResource.intValue();
		ResourceAccessBean res = new ResourceAccessBean();
		res.setInitKey_resource(bi);
		res.refreshCopyHelper();
		policy = res.getCountpolicy();
	} catch (Exception e) {
		errors.add(editPos, new ActionError("error.mountact2.bad.resource"));
	}

	if ("S".equals(policy)) {
		editPos = "serial" + argMsgKey;
		if  ( (argSerial == null) || (argSerial.trim().length() == 0) ) 
			errors.add(editPos, new ActionError("error.mountact2.empty.serial"));
	} else if ("P".equals(policy)) {
		editPos = "serial" + argMsgKey;
		if  ( (argSerial == null) || (argSerial.trim().length() == 0) ) 
			errors.add(editPos, new ActionError("error.mountact2.empty.party"));
	} else if ("B".equals(policy)) {
		editPos = "serial" + argMsgKey;
		if  ( (argQty == null) || (argQty.trim().length() == 0) )
			errors.add(editPos, new ActionError("error.mountact2.empty.qty"));
		else {
			// Проверим количество
			com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sb = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 3);
			sb.setString(argQty);
			if (!sb.isOk())
				errors.add(editPos, new ActionError("error.mountact2.bad.qty"));
		}
	}
}
/**
 * Проверяет заполнение полей в коллекции.
 * Creation date: (01.03.2005 14:40:16)
 * @param arList java.util.ArrayList
 */
private void validateStringCollection(java.util.ArrayList arList, String errorName, ActionErrors errors, String errorText) {
	int asize = arList.size();
	for (int i=0; i < asize; i++) {
		String val = (String)arList.get(i);
		if ( (val == null) || ("".equals(val.trim())) ) {
			String editPos = errorName + "[" + i + "]";
			errors.add(editPos, new ActionError(errorText));
		}
	}
}
/**
 * Метод для проверки правильности ввода значений в поля ввода.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * при этом исключении ошибки отображаются пользователю.
 */
public void validateValues(ActionErrors errors) throws Exception {


	ExcludeEmptyAntennes();
	ExcludeEmptyDividers();
	
	StringAndIntegerProperty si = new StringAndIntegerProperty();
	
	// Проверим номер позиции
	si.setString(getPosnumber());
	if (si.isEmpty())
		errors.add("head", new ActionError("error.mountact2.empty.posnumber"));
	else
		if (!si.isOk())
			errors.add("head", new ActionError("error.mountact2.bad.posnumber"));
		else {
			if (!getPosnumber().equals(getOldposnumber()) || !getEqtype().equals(getOldeqtype())) {
				setComplectcode(null);
				setComplectname("");
			}
			if (getComplectcode() == null) {
					// Определим комплект оборудования
					CDBCResultSet res = getComplects();
					if (res.getRowsCount() > 1) {
						setManycomplects(true);
						errors.add("head", new ActionError("error.mountact2.toomany.complect"));
					} else if (res.getRowsCount() < 1) {
						setManycomplects(true);
						errors.add("head", new ActionError("error.mountact2.empty.complect"));
					} else {
						setManycomplects(false);
						java.util.ListIterator it = res.listIterator();
						CDBCRowObject ro = (CDBCRowObject)it.next();
						setComplectcode((Integer)ro.getColumn("equipment").asObject());
						setComplectname(ro.getColumn("name").asString());
					}
			}
		}

	setOldposnumber(getPosnumber());
	setOldeqtype(getEqtype());
	checkProject(errors);
	
	if (getRefreshFields() == 1)
		throw new ValidationException();
		
	//validateResource(getResource10(), getSerial10(), getQty10(), "10", errors);

	// Проверим подрядчика
	si.setString(getProvidercode());
	if (si.isEmpty())
		errors.add("podr", new ActionError("error.mountact2.empty.podrcode"));
	else
		if (!si.isOk())
			errors.add("podr", new ActionError("error.mountact2.bad.podrcode"));
		else {
			try {
				OrganizationAccessBean org = new OrganizationAccessBean();
				org.setInitKey_organization(si.getInteger().intValue());
				org.refreshCopyHelper();
				setProvidername(org.getName());
			} catch (Exception ee) {
				errors.add("podr", new ActionError("error.mountact2.bad.podrcode"));
			}
		}

	// Проверим ФИО подрядчика
	if ( (getInsuranceMan() == null) || (getInsuranceMan().trim().length() == 0) )
		errors.add("insman", new ActionError("error.mountact2.empty.insuranceman"));

	// Проверим сотрудника
	si.setString(getWorkercode());
	if (si.isEmpty())
		errors.add("worker", new ActionError("error.mountact2.empty.worker"));
	else	if (!si.isOk())
			errors.add("worker", new ActionError("error.mountact2.bad.worker"));
		else {
			try {
				WorkerAccessBean wrk = new WorkerAccessBean();
				wrk.setInitKey_worker(si.getInteger().intValue());
				wrk.refreshCopyHelper();
				PeopleAccessBean ppl = wrk.getMan();
				setWorkername(ppl.getLastname() + " " + ppl.getFirstname() + " " + ppl.getMiddlename());
				setWorkertitle(wrk.getPosition().getName());
			} catch (Exception ee) {
				errors.add("worker", new ActionError("error.mountact2.bad.worker"));
			}
		}

	validateStringCollection(antserial, "antserial", errors, "error.mountact2.empty.serial");
	validateDecimalCollection(antcablen, "antcablen", errors, "error.mountact2.empty.qty");
	validateStringCollection(divserial, "divserial", errors, "error.mountact2.empty.serial");
	validateDecimalCollection(divcablen, "divcablen", errors, "error.mountact2.empty.qty");
	
	if (!errors.empty()) {
		// Для вывода общего сообщения об ошибках
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountact2.haveerrors"));
		throw new ValidationException();
	}
}
}
