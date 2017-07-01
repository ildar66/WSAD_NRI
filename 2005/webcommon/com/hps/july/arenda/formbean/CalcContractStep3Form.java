package com.hps.july.arenda.formbean;

import java.util.*;
import java.sql.Date;
/**
 * Form-Bean.
 * Расчет контракта - шаг 3
 * Creation date: (20.01.2003 12:43:51)
 * @author: Sergey Gourov
 */
public class CalcContractStep3Form extends com.hps.july.web.util.EditForm {
	private int leaseContract;
	private int resource;
	private Date beginDate;
	private Date endDate;
	private Boolean isShowdocpos;
	protected java.lang.String listForm;
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 18:03:50)
 */
public CalcContractStep3Form() {
	super();
	listForm = "CalcContractStep2Form";
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:43:52)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:43:52)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:43:52)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:46:35)
 * @return java.util.Map
 */
public java.util.Map getPrompts() {
	HashMap h = new HashMap();
	
	h.put("prompt0", new Integer(leaseContract));
	h.put("prompt1", new Integer(resource));
	
	GregorianCalendar c = new GregorianCalendar();
	c.setTime(beginDate);
	h.put("prompt2", "Date(" + c.get(Calendar.YEAR) + "," + (c.get(Calendar.MONTH) + 1) + "," + c.get(Calendar.DAY_OF_MONTH) + ")");
	
	c.setTime(endDate);
	h.put("prompt3", "Date(" + c.get(Calendar.YEAR) + "," + (c.get(Calendar.MONTH) + 1) + "," + c.get(Calendar.DAY_OF_MONTH) + ")");
	h.put("prompt4", isShowdocpos.booleanValue() ? "1" : "0");
	
	return h;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:43:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CALC_CONTRACT_STEP3;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	CalcContractStep2Form form = (CalcContractStep2Form) request.getSession().getAttribute(listForm);

	leaseContract = form.getLeaseContract();
	resource = form.getResource();
	beginDate = form.getUserbegindate();
	endDate = form.getUserenddate();
	isShowdocpos = form.getIsShowdocpos();
}
}
