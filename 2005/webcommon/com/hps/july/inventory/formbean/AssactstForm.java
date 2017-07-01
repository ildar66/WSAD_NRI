package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * Форма изменения состояния документа "Акт монтажа блоков на складе"
 */
public class AssactstForm extends com.hps.july.web.util.EditForm {
	private java.lang.String documentState;
	private java.lang.String oldDocumentState;
	private int doc;
	private java.lang.String oldConfiguration;
	private java.lang.String newConfiguration;
	private java.lang.String agregatename;
	private java.lang.String agregateserial;
	private StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
	private java.lang.String blanknumber;
	private int blankindex;
	private Boolean warnProc;
public AssactstForm() {
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		AssemblingActAccessBean abean = (AssemblingActAccessBean)bean;
		ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
		//abean.setDocumentState(documentState);
		if("1".equals(oldDocumentState) && "2".equals(documentState)) {
			processor.processDocument(new Integer(abean.getDocument()),false,warnProc != null && warnProc.booleanValue());
		} else
		if("2".equals(oldDocumentState) && "1".equals(documentState)) {
			processor.cancelDocument(new Integer(abean.getDocument()));
		}
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
		AssemblingActAccessBean abean = (AssemblingActAccessBean)bean;
		oldDocumentState = abean.getDocumentState();
		// Revert new document state
		if ("1".equals(oldDocumentState)) {
			documentState = "2";
			oldConfiguration = abean.getAgregat().getConfiguration();
			newConfiguration = oldConfiguration;
		}
		if ("2".equals(oldDocumentState)) {
			documentState = "1";
			newConfiguration = abean.getAgregat().getConfiguration();
		}
		String s = abean.getAgregat().getResource().getName();
		if (abean.getAgregat().getResource().getModel() != null)
			s = s + ", " + abean.getAgregat().getResource().getModel();
		agregatename = s;
		agregateserial = abean.getAgregat().getSerialnumber();
	} catch(Exception e) {
		
	}

			
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 16:02:39)
 * @return java.lang.String
 */
public java.lang.String getAgregatename() {
	return agregatename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 16:04:52)
 * @return java.lang.String
 */
public java.lang.String getAgregateserial() {
	return agregateserial;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public StringAndSqlDateProperty getBlankdate() {
	return blankdate;
}
/**
 * 
 * @return int
 */
public int getBlankindex() {
	return blankindex;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 16:23:58)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	AssemblingActAccessBean bean = new AssemblingActAccessBean();
	bean.setInitKey_document(getDoc());
	try {
		blankdate.setSqlDate(bean.getBlankdate());
		setBlanknumber(bean.getBlanknumber());
		setBlankindex(bean.getBlankindex());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return bean;
}
public int getDoc() {
	return doc;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 15:53:20)
 * @return java.lang.String
 */
public java.lang.String getNewConfiguration() {
	return newConfiguration;
}
public java.lang.String getNewDocumentState() {
	return documentState;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 15:53:01)
 * @return java.lang.String
 */
public java.lang.String getOldConfiguration() {
	return oldConfiguration;
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
	return com.hps.july.inventory.APPStates.EDITASSST;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getWarnProc() {
	return warnProc;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 16:02:39)
 * @param newAgregatename java.lang.String
 */
public void setAgregatename(java.lang.String newAgregatename) {
	agregatename = newAgregatename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 16:04:52)
 * @param newAgregateserial java.lang.String
 */
public void setAgregateserial(java.lang.String newAgregateserial) {
	agregateserial = newAgregateserial;
}
/**
 * 
 * @param newBlankindex int
 */
public void setBlankindex(int newBlankindex) {
	blankindex = newBlankindex;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 16:23:58)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
public void setDoc(int newDoc) {
	doc = newDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 15:53:20)
 * @param newNewConfiguration java.lang.String
 */
public void setNewConfiguration(java.lang.String newNewConfiguration) {
	newConfiguration = newNewConfiguration;
}
public void setNewDocumentState(java.lang.String newDocumentState) {
	documentState = newDocumentState;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 15:53:01)
 * @param newOldConfiguration java.lang.String
 */
public void setOldConfiguration(java.lang.String newOldConfiguration) {
	oldConfiguration = newOldConfiguration;
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
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assact.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
