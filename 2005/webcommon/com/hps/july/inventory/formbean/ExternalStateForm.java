package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * Форма изменения состояния документа "Внешний приходный ордер"
 */
public class ExternalStateForm extends com.hps.july.web.util.EditForm {
	private Boolean createMismatchAct;
	private java.lang.String documentState;
	private java.lang.String oldDocumentState;
	private int doc;
	private String blanknumber;
	private Integer blankindex;
	private StringAndSqlDateProperty blankdate;
	private Boolean warnProc;
public ExternalStateForm() {
	createMismatchAct = Boolean.FALSE;
	blankdate = new StringAndSqlDateProperty();
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	createMismatchAct = Boolean.FALSE;
	try {
		InwayBillAccessBean abean = (InwayBillAccessBean)bean;
		ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
		//abean.setDocumentState(documentState);
		if("1".equals(oldDocumentState) && "2".equals(documentState)) {
			//System.out.println("PROCESS# "+blankindex+","+blanknumber+" "+blankdate.getString()+" WARN:"+warnProc);
			boolean wp = warnProc != null && warnProc.booleanValue();
			processor.processDocument(new Integer(getDoc()),false,wp);
		} else
		if("2".equals(oldDocumentState) && "1".equals(documentState)) {
			processor.cancelDocument(new Integer(abean.getDocument()));
		}
		createMismatchAct = Boolean.TRUE;
	} catch(Exception e) {
		documentState = oldDocumentState;
		throw e;
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return null;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		InwayBillAccessBean abean = (InwayBillAccessBean)bean;
		documentState = abean.getDocumentState();
		blankdate.setSqlDate(abean.getBlankdate());
		blanknumber = abean.getBlanknumber();
		blankindex = new Integer(abean.getBlankindex());
	} catch(Exception e) {
		
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
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 20:54:04)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCreateMismatchAct() {
	return createMismatchAct;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	InwayBillAccessBean bean = new InwayBillAccessBean();
	bean.setInitKey_document(getDoc());
	return bean;
}
public int getDoc() {
	return doc;
}
public java.lang.String getNewDocumentState() {
	return documentState;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 18:30:29)
 * @return java.lang.String
 */
public java.lang.String getOldDocumentState() {
	return oldDocumentState;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEOST;
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
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 20:54:04)
 * @param newCreateMismatchAct java.lang.Boolean
 */
public void setCreateMismatchAct(java.lang.Boolean newCreateMismatchAct) {
	createMismatchAct = newCreateMismatchAct;
}
public void setDoc(int newDoc) {
	doc = newDoc;
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
	if (!"1".equals(documentState) && !"2".equals(documentState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
