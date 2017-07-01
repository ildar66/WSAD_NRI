package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.siteinfo.TablesRef;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence2.CounterInfoAccessBean;
import com.hps.july.persistence2.CounterInfo;
import com.hps.july.persistence2.CounterAccessBean;
import com.hps.july.persistence2.Counter;

import com.hps.july.web.util.StringAndIntegerProperty;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;


/**
 * Класс, реализующий форму редактирования моделей электросчётчиков
 * Creation date: (19.08.2004 13:35:16)
 * @author: Vadim Glushkov
 */
public class ElectroCounterInfoForm extends EditForm {
	
	private java.lang.Integer id = null;
	private java.lang.String code = null;
	private java.lang.String name = null;
    private String verification_interFrm = null;
    private StringAndIntegerProperty verification_inter = new StringAndIntegerProperty();
	
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 13:42:15)
	 */
	public ElectroCounterInfoForm() {

		super();
		this.code = new String("");
		this.name = new String("");
		this.verification_inter.setString(new String("6"));
	}
	/**
	 * Метод вызывается после изменения основной записи.
	 * При нахождении существующих счетчиков изменяет дату следующей поверки
	 * в зависимости от введенного интервала поверки
	 * Creation date: (13.02.2002 10:21:31)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void afterUpdate(AbstractEntityAccessBean bean,
		javax.servlet.http.HttpServletRequest request) throws Exception {
			
		    GregorianCalendar calendar = new GregorianCalendar();
		    try {
			    CounterInfoAccessBean counterBean = (CounterInfoAccessBean)bean;
			    CDBCElectroCounterObject object = new CDBCElectroCounterObject();
			    
			    Integer verificationInterval = counterBean.getVerification_inter();
			    CDBCResultSet rs = object.findElectroCountersByCounterInfoId(new Integer(counterBean.getId()));
			    java.util.Iterator iterator = rs.listIterator();
			    while(iterator.hasNext()) {
				    CDBCRowObject ro = (CDBCRowObject)iterator.next();
				    if(ro != null) {
					    CDBCColumnObject co = ro.getColumn("counterid");
					    Integer id = new Integer(co.asString());
						try {
					        CounterAccessBean bean1 = new CounterAccessBean();
					        bean1.setInitKey_counterid(id.intValue());
					        calendar.setTime(bean1.getLast_verification());
					        calendar.add(Calendar.YEAR, verificationInterval.intValue());
					        bean1.setNext_verification(new java.sql.Date(calendar.getTime().getTime()));
					        bean1.commitCopyHelper();
					    } catch(Exception e) {}
				    }
			    }
		    } catch(Exception e) {}
		}
	/**
	 * Метод для создания новой записи.
	 * Creation date: (13.02.2002 10:20:36)
	 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
		throws Exception {
	        KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	        this.id = new Integer(keyGen.getNextKey(TablesRef.COUNTERS_INFO));
	        CounterInfoAccessBean bean = new CounterInfoAccessBean(
	                id.intValue());
	        setReturnParam(id.toString());
	        return bean;
	}
	/**
	 * Текущее приложение.
	 * Creation date: (19.08.2004 13:35:16)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.SITEINFO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 13:41:29)
	 * @return java.lang.String
	 */
	public java.lang.String getCode() {
		return code;
	}
	/**
	 * Метод для поиска текущей записи.
	 * Creation date: (13.02.2002 10:12:41)
	 */
	public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
		throws Exception {
	        CounterInfoAccessBean bean = new CounterInfoAccessBean();
	        bean.setInitKey_id(this.id.intValue());
	        return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 13:40:05)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getId() {
		return id;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 13:41:51)
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Текущее состояние приложения.
	 * Creation date: (19.08.2004 13:35:16)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.siteinfo.APPStates.ELECTRO_COUNTER_INFO_EDIT;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.08.2004 15:17:37)
	 * @return java.lang.Integer
	 */
	public Integer getVerification_inter() {
		return this.verification_inter.getInteger();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.08.2004 15:16:12)
	 * @return java.lang.String
	 */
	public String getVerification_interFrm() {
		return this.verification_inter.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 13:41:29)
	 * @param newCode java.lang.String
	 */
	public void setCode(java.lang.String newCode) {
		code = newCode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 13:40:05)
	 * @param newId java.lang.Integer
	 */
	public void setId(java.lang.Integer newId) {
		id = newId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 13:41:51)
	 * @param newName java.lang.String
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.08.2004 15:16:57)
	 * @param i java.lang.Integer
	 */
	public void setVerification_inter(Integer i) {
		this.verification_inter.setInteger(i);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.08.2004 15:15:17)
	 * @param s java.lang.String
	 */
	public void setVerification_interFrm(String s) {
		this.verification_inter.setString(s);
	}
	/**
	 * Метод для проверки правильности ввода значений в поля ввода.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException - 
	 * при этом исключении ошибки отображаются пользователю.
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if(!(this.code != null && this.code.length() > 0)) {
	        errors.add(ActionErrors.GLOBAL_ERROR,
	            new ActionError("error.empty.electrocounterinfo.empty_code"));
		}
	     if(this.verification_inter.getInteger() == null)
	        errors.add(
	            ActionErrors.GLOBAL_ERROR,
	            new ActionError("error.empty.electrocounterinfo.verification_interval"));

	    if(!errors.empty()) throw new ValidationException();		
	}
}
