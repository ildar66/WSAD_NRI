package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 * Form-Bean.
 * "ѕозиции абонентского договора".
 * Creation date: (16.07.2002 9:47:19)
 * @author: Sergey Gourov
 */
public class ArendaPositionForm extends com.hps.july.web.util.EditForm {
	private com.hps.july.persistence.LeaseArendaAgreementNewAccessBean leaseDocument;
	private int leaseDocumentcode;
	private com.hps.july.persistence.PositionAccessBean position;
	private StringAndIntegerProperty positioncode;
	private java.lang.String positionname;
	protected java.lang.String listForm;
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 10:34:39)
 */
public ArendaPositionForm() {
	positioncode = new StringAndIntegerProperty();
	listForm = "ArendaPositionsListForm";
}
/**
 * ≈сли удаленна€ позици€ была главной - ставим "null" в LeaseDocument.setMainPosition.
 * Creation date: (13.02.2002 10:17:44)
 */
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception {
	LeaseArendaAgreementNew leaseDoc = getLeaseDocument();
	Position position = leaseDoc.getMainposition();
	if (position != null) {
		int storageplace = position.getStorageplace();
		if (storageplace == getPositioncode().intValue()) {
			leaseDoc.setMainposition(null); 
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:47:19)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {

/* @param argDocument java.lang.Integer
 * @param argPosition java.lang.Integer*/
 	
	return new LeaseOnPositionAccessBean(new Integer(getLeaseDocumentcode()), getPositioncode());
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:06:31)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseArendaAgreementNewAccessBean constructDocument() throws java.lang.Exception {
	if (leaseDocument == null) {
		if (leaseDocumentcode != 0) {
			leaseDocument = new LeaseArendaAgreementNewAccessBean();
			leaseDocument.setInitKey_leaseDocument(getLeaseDocumentcode());
			leaseDocument.refreshCopyHelper();
		}
	}
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:06:31)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 * @exception java.lang.Exception The exception description.
 */
private PositionAccessBean constructPosition() throws java.lang.Exception {
	if (position == null) {
		if (!positioncode.isEmpty() && positioncode.isOk()) {
			position = new PositionAccessBean();
			position.setInitKey_storageplace(getPositioncode().intValue());
			position.refreshCopyHelper();
		}
	}
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:47:19)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:47:19)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
    ArendaPositionsListForm form = (ArendaPositionsListForm) request.getSession().getAttribute(listForm);
	setLeaseDocumentcode(form.getLeaseDocument());

/*	try {
		LeaseContractAccessBean beanContract = new LeaseContractAccessBean();
		beanContract.setInitKey_leaseDocument(getLeaseDocumentcode().intValue());
		beanContract.refreshCopyHelper();

		setDocumentNumber(beanContract.getDocumentNumber());
		setDocumentDate(beanContract.getDocumentDate());
		setOrgCustomer(beanContract.getOrgCustomer().getName());
		setOrgExecutor(beanContract.getOrgExecutor().getName());
	} catch (Exception ex) {
		ex.printStackTrace();
		setDocumentNumber("");
		documentDate.setSqlDate(null);
		setOrgCustomer("");
		setOrgExecutor("");
	}*/
	
	LeaseOnPositionAccessBean bean = new LeaseOnPositionAccessBean();
	bean.setInitKey_leaseArendaAgreementNew_leaseDocument(new Integer(getLeaseDocumentcode()));
//	bean.setInitKey_leaseDocument_leaseDocument(new Integer(getLeaseDocumentcode()));
	bean.setInitKey_position_storageplace(getPositioncode());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:55:11)
 * @return com.hps.july.persistence.LeaseArendaAgreementAccessBean
 */
public LeaseArendaAgreementNew getLeaseDocument() throws Exception {
	LeaseArendaAgreementNewAccessBean bean = constructDocument();
    if (bean != null) {
        return (LeaseArendaAgreementNew) bean.getEJBRef();
    }
    else return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:57:09)
 * @return int
 */
public int getLeaseDocumentcode() {
	return leaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:58:24)
 * @return com.hps.july.persistence.PositionAccessBean
 */
public Position getPosition() throws Exception {
	PositionAccessBean bean = constructPosition();
    if (bean != null) {
        return (Position) bean.getEJBRef();
    }
    else return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:58:57)
 * @return int
 */
public Integer getPositioncode() {
	return positioncode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:58:57)
 * @return int
 */
public String getPositioncodeFrm() {
	return positioncode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 11:27:57)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:47:19)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ARENDA_POS_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    ArendaPositionsListForm form = (ArendaPositionsListForm) request.getSession().getAttribute(listForm);
	setLeaseDocumentcode(form.getLeaseDocument());
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:55:11)
 * @param newLeaseDocument com.hps.july.persistence.LeaseArendaAgreementAccessBean
 */
public void setLeaseDocument(com.hps.july.persistence.LeaseArendaAgreementNewAccessBean newLeaseDocument) throws Exception {
    if (newLeaseDocument == null) {
        setLeaseDocumentcode(0);
//		setDocumentNumber("");
//		setDocumentDate(null);
    } else {
        setLeaseDocumentcode(newLeaseDocument.getLeaseDocument());
//		setDocumentNumber(newLeaseDocument.getDocumentNumber());
//		setDocumentDate(newLeaseDocument.getDocumentDate());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:57:09)
 * @param newLeaseDocumentcode int
 */
public void setLeaseDocumentcode(int newLeaseDocumentcode) {
	leaseDocumentcode = newLeaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:58:24)
 * @param newPosition com.hps.july.persistence.PositionAccessBean
 */
public void setPosition(com.hps.july.persistence.PositionAccessBean newPosition) throws Exception {
    if (newPosition == null) {
        setPositioncode(new Integer(0));
		setPositionname("");
//		setDocumentDate(null);
    } else {
        setPositioncode(new Integer(newPosition.getStorageplace()));
		setPositionname(newPosition.getName());
//		setDocumentDate(newLeaseDocument.getDocumentDate());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:58:57)
 * @param newPositioncode int
 */
public void setPositioncode(Integer newPositioncode) {
	positioncode.setInteger(newPositioncode);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:58:57)
 * @param newPositioncode int
 */
public void setPositioncodeFrm(String newPositioncode) {
	positioncode.setString(newPositioncode);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 11:27:57)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (positioncode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.arendapos.contract"));
	} else if (!positioncode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.arendapos.contract"));
	} else {
		try {
			constructPosition();
		} catch(Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex))
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.arendapos.contract"));
			else throw ex;
		}
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
