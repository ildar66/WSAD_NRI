package com.hps.july.inventory.formbean;

import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * Ѕазовый класс форм изменени€ состо€ни€ документа
 * —одержит основные пол€ формы и выполн€ет общую проверку при изменение состо€ни€
 * ¬ методе afterUpdate выполн€етс€ вызов ProcessorFacade.process или ProcessorFacade.cancel
 * в зависимости от направлени€ смены сото€ни€
 */
public abstract class AbstractDocumentStateForm extends com.hps.july.web.util.EditForm {
	private String documentState;
	private String oldDocumentState;
	private int doc;
	private String blanknumber;
	private Integer blankindex;
	private StringAndSqlDateProperty blankdate;
	private Boolean warnProc;
public AbstractDocumentStateForm() {
	blankdate = new StringAndSqlDateProperty();
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		//System.out.println("BEFORE PROCESS# "+blankindex+","+blanknumber+" from "+blankdate.getString());
		ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
		if("1".equals(oldDocumentState)) {
			//System.out.println("PROCESS# "+blankindex+","+blanknumber+" "+blankdate.getString()+" WARN:"+warnProc);
			boolean wp = warnProc != null && warnProc.booleanValue();
			processor.processDocument(new Integer(getDoc()),false,wp);
			warnProc = null;
		} else
		if("2".equals(oldDocumentState)) {
			//System.out.println("CANCELL# "+blankindex+","+blanknumber+" "+blankdate.getString()+" WARN:"+warnProc);
			processor.cancelDocument(new Integer(getDoc()));
		}
		//System.out.println("AFTER PROCESS# "+blankindex+","+blanknumber+" from "+blankdate.getString());
	} catch(Exception e) {
//		e.printStackTrace(System.out);
		documentState = oldDocumentState;
		throw e;
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return null;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		DocumentAccessBean abean = (DocumentAccessBean)bean;
		documentState = abean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	oldDocumentState = documentState;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public com.hps.july.web.util.StringAndSqlDateProperty getBlankdate() {
	return blankdate;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getBlankindex() {
	return blankindex;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	try {
		DocumentAccessBean bean = new DocumentAccessBean();
		bean.setInitKey_document(getDoc());
		bean.refreshCopyHelper();
		blankdate.setSqlDate(bean.getBlankdate());
		blanknumber = bean.getBlanknumber();
		blankindex = new Integer(bean.getBlankindex());
		//System.out.println("DOC# "+blankindex+","+blanknumber+" from "+blankdate.getString());
		return bean;
	} catch(Exception e) {
		DocumentAccessBean bean = new DocumentAccessBean();
		bean.setInitKey_document(getDoc());
		return bean;
	}
}
public int getDoc() {
	return doc;
}
/**
 * 
 * @return java.lang.String
 */
protected java.lang.String getDocumentState() {
	return documentState;
}
public java.lang.String getNewDocumentState() {
	return documentState;
}
public java.lang.String getOldDocumentState() {
	return oldDocumentState;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getWarnProc() {
	return warnProc;
}
/**
 * 
 * @param newBlankdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBlankdate(com.hps.july.web.util.StringAndSqlDateProperty newBlankdate) {
	blankdate = newBlankdate;
}
/**
 * 
 * @param newBlankindex java.lang.Integer
 */
public void setBlankindex(java.lang.Integer newBlankindex) {
	blankindex = newBlankindex;
}
/**
 * 
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
public void setDoc(int newDoc) {
	doc = newDoc;
}
/**
 * 
 * @param newDocumentState java.lang.String
 */
protected void setDocumentState(java.lang.String newDocumentState) {
	documentState = newDocumentState;
}
public void setNewDocumentState(java.lang.String newDocumentState) {
	documentState = newDocumentState;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 18:30:29)
 * @param newOldDocumentState java.lang.String
 */
public void setOldDocumentState(java.lang.String newOldDocumentState) {
	oldDocumentState = newOldDocumentState;
}
/**
 * 
 * @param newWarnProc java.lang.Boolean
 */
public void setWarnProc(java.lang.Boolean newWarnProc) {
	warnProc = newWarnProc;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	// check document!
	
	if (!"1".equals(documentState) && !"2".equals(documentState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
