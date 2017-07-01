package com.hps.july.arenda.formbean;

import com.hps.july.arenda.sessionbean.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import java.sql.Date;
import com.hps.july.web.util.*;

/**
 * Bean-form
 * Форма "платежи по контракту".
 * Creation date: (16.07.2003 15:52:08)
 * @author: Sergey Gourov
 */
public class GetPaysByContractForm extends com.hps.july.web.util.EditForm {
	private StringAndSqlDateProperty dateStart = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateFinish = new StringAndSqlDateProperty();
	private int leaseContract;
	private int operator;
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:56:49)
 */
public GetPaysByContractForm() {
	setAction("Add");
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	operator = 0; // only for wte!!! set operator = 0 for ws!!!
	try {
		operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 15:52:08)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 15:52:08)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 15:52:08)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:47:31)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDateFinish() {
	return dateFinish.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:47:31)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateFinishFrm() {
	return dateFinish.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:45:16)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDateStart() {
	return dateStart.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:45:16)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateStartFrm() {
	return dateStart.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:49:54)
 * @return int
 */
public int getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 15:52:08)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.GETPAYS_BYCONTRACT;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:47:31)
 * @param newDateFinish com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateFinish(Date newDateFinish) {
	dateFinish.setSqlDate(newDateFinish);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:47:31)
 * @param newDateFinish com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateFinishFrm(String newDateFinish) {
	dateFinish.setString(newDateFinish);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:45:16)
 * @param newDateStart com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateStart(Date newDateStart) {
	dateStart.setSqlDate(newDateStart);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:45:16)
 * @param newDateStart com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateStartFrm(String newDateStart) {
	dateStart.setString(newDateStart);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 17:49:54)
 * @param newLeaseContract int
 */
public void setLeaseContract(int newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	try {
		if (new ArendaDocumentProcessorAccessBean().makeQryGetPays(operator, new Integer(getLeaseContract()), null,
			getDateStart(), getDateFinish()) != 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.receive.paysbycontract"));
		}
	} catch (Exception e) {
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.receive.paysbycontract"));
	}
	
	if (!errors.empty()) throw new ValidationException();
}
}
