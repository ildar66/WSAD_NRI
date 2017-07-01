package com.hps.july.arenda.formbean;

import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
/**
 * Form-Bean.
 * форма ввода "BEN".
 */
public class BenForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private StringAndIntegerProperty ben;
	private String ban;
	private short oben;
public BenForm() {
	ben = new StringAndIntegerProperty();
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws Exception
{
	try {
		LeaseAbonentBENAccessBean dben = new LeaseAbonentBENAccessBean();
		dben.setInitKey_ben(oben);
		dben.setInitKey_leaseabonentban_leaseDocument(new Integer(getLeaseDocument()));
		dben.refreshCopyHelper();
		dben.getEJBRef().remove();
	} catch(Exception e) {
	}
	LeaseAbonentBENAccessBean bean = new LeaseAbonentBENAccessBean(
		leaseDocument,
		ben.getInteger().shortValue()
	);
	return bean;
}
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBan() {
	return ban;
}
public Integer getBen() {
	return ben.getInteger();
}
public String getBenFrm() {
	return ben.getString();
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request)
{
	try {
		initRecord(request);
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	LeaseAbonentBENAccessBean bean = new LeaseAbonentBENAccessBean();
	bean.setInitKey_ben(ben.getInteger().shortValue());
	bean.setInitKey_leaseabonentban_leaseDocument(new Integer(getLeaseDocument()));
	return bean;
}
/**
 * 
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * 
 * @return short
 */
public short getOben() {
	return oben;
}
public int getState() {
	return com.hps.july.arenda.APPStates.BEN_EDIT;
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	BensListForm bens = (BensListForm)request.getSession().getAttribute("BensListForm");
	leaseDocument = bens.getLeaseDocument();
//	ben.setInteger(new Integer(oben));
}
/**
 * 
 * @param newBan java.lang.String
 */
public void setBan(java.lang.String newBan) {
	ban = newBan;
}
public void setBen(Integer newBan) {
	ben.setInteger(newBan);
}
public void setBenFrm(String newBan) {
	ben.setString(newBan);
}
/**
 * 
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * 
 * @param newOben short
 */
public void setOben(short newOben) {
	oben = newOben;
}
public void validateValues(ActionErrors errors) throws Exception {

	if (!ben.isEmpty() && !ben.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.bens.invalidben"));
	} else if (ben.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.bens.emptyben"));
	}  else if (ben.getInteger().intValue() < 1 || ben.getInteger().intValue() > 99) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.bens.invalidben2"));
	}

	if(leaseDocument <= 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.bens.invaliddoc"));
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
