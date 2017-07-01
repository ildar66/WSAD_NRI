package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма "платежи по ответственному".
 * Creation date: (09.01.2004 13:00)
 * @author: Anthon Stefanov
 */
public class RespPaysListForm
	extends com.hps.july.web.util.BrowseForm
{
	private java.lang.Integer contract;

	// Дополнительный флаг для выполнения действий перед просмотром
	//!\\ Может не понадобиться
	private String adAction = ""; // Set on 'C' by default for first time recalc

	// Ответственный
	private StringAndIntegerProperty operator = new StringAndIntegerProperty();
	private String operatorName;

	// Период оплаты
	private boolean periodMonth = true;
	private boolean periodQuartal = true;
	private boolean periodYear = true;

	// Требование оплатить: 'A'll - все, 'H'ot - требующие оплаты
	private String payreq = "A";

	// Тип оплаты
	private boolean typeAvans = true; // Аванс
	private boolean typeByend = true; // По окончании
	private boolean typeBybill = true; // По счёту

	private StringAndSqlDateProperty rdateFrom = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty rdateTill = new StringAndSqlDateProperty();

	private String loginid;

	private String order;
public RespPaysListForm() {
	super();
	order = "posname ASC";
	setLastVisited(true);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAdAction() {
	return adAction;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getContract() {
	return contract;
}
public java.lang.Object[] getFilterParams() {
/*
	String loginid,
	Boolean periodMonth, Boolean periodQuartal, Boolean periodYear,
	String payreq,
	Boolean typeAvans, Boolean typeBybill, Boolean typeByend,
	Integer order
*/
	String order = getOrder();
	return new Object[] {
		loginid != null ? loginid : "",
		new Boolean(periodMonth), new Boolean(periodQuartal), new Boolean(periodYear),
		payreq != null ? payreq : "",
		new Boolean(typeAvans), new Boolean(typeBybill), new Boolean(typeByend),
		(order != null)?order:""
	};
}
public java.lang.String getFinderMethodName() {
	return "findByQBE";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLoginid() {
	return loginid;
}
public Integer getOperator() {
	return operator.getInteger();
}
public java.lang.String getOperatorFrm() {
	return operator.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOperatorName() {
	return operatorName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrder() {
	return order;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPayreq() {
	return payreq;
}
public java.sql.Date getRdateFrom() {
	return rdateFrom.getSqlDate();
}
public String getRdateFromFrm() {
	return rdateFrom.getString();
}
public java.sql.Date getRdateTill() {
	return rdateTill.getSqlDate();
}
public String getRdateTillFrm() {
	return rdateTill.getString();
}
public void initCollections() {
	/*
	try {
		java.util.Vector v = new java.util.Vector();
		v.addElement(getContract());
		
		java.util.Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(new Integer(getMaincontract()), 
			new Boolean(false), null,
			new Boolean(false), null, new Integer(1));
		while (e.hasMoreElements()) {
			LeaseArendaAgreementNewAccessBean laanBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			v.addElement(new Integer(laanBean.getLeaseDocument()));
		}

		java.util.Enumeration enr = new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
		ArrayList res = new ArrayList();
		boolean resInCollection = false;
		while (enr.hasMoreElements()) {
			ResourceAccessBean o = (ResourceAccessBean)enr.nextElement();
			res.add(o);
			if (o.getResource() == getResource().intValue())
				resInCollection = true;
		}

		// Selected resource not in current list - select first resource
		if (!resInCollection) {
			ResourceAccessBean rbean = (ResourceAccessBean)res.get(0);
			setResource( new Integer(rbean.getResource()) );
			setResname(rbean.getName());
		}

		// Check for more than 1 resource
		if (res.size() > 1)
			setManyresources(true);
		else
			setManyresources(false);
		
		resources = Collections.enumeration(res);
		
	} catch(Exception e) {
		e.printStackTrace();
		resources = (new java.util.Vector()).elements();	
	}
	*/
}
/**
 * 
 * @return boolean
 */
public boolean isPeriodMonth() {
	return periodMonth;
}
/**
 * 
 * @return boolean
 */
public boolean isPeriodQuartal() {
	return periodQuartal;
}
/**
 * 
 * @return boolean
 */
public boolean isPeriodYear() {
	return periodYear;
}
/**
 * 
 * @return boolean
 */
public boolean isTypeAvans() {
	return typeAvans;
}
/**
 * 
 * @return boolean
 */
public boolean isTypeBybill() {
	return typeBybill;
}
/**
 * 
 * @return boolean
 */
public boolean isTypeByend() {
	return typeByend;
}
/**
 * 
 * @param newAdAction java.lang.String
 */
public void setAdAction(java.lang.String newAdAction) {
	adAction = newAdAction;
}
/**
 * 
 * @param newContract java.lang.Integer
 */
public void setContract(java.lang.Integer newContract) {
	contract = newContract;
}
/**
 * 
 * @param newLoginid java.lang.String
 */
public void setLoginid(java.lang.String newLoginid) {
	loginid = newLoginid;
}
public void setOperator(Integer newOperator) {
	operator.setInteger(newOperator);
}
public void setOperatorFrm(java.lang.String newOperator) {
	operator.setString(newOperator);
}
/**
 * 
 * @param newOperatorName java.lang.String
 */
public void setOperatorName(java.lang.String newOperatorName) {
	operatorName = newOperatorName;
}
/**
 * 
 * @param newOrder java.lang.String
 */
public void setOrder(java.lang.String newOrder) {
	order = newOrder;
}
/**
 * 
 * @param newPayreq java.lang.String
 */
public void setPayreq(java.lang.String newPayreq) {
	payreq = newPayreq;
}
/**
 * 
 * @param newPeriodMonth boolean
 */
public void setPeriodMonth(boolean newPeriodMonth) {
	periodMonth = newPeriodMonth;
}
/**
 * 
 * @param newPeriodQuartal boolean
 */
public void setPeriodQuartal(boolean newPeriodQuartal) {
	periodQuartal = newPeriodQuartal;
}
/**
 * 
 * @param newPeriodYear boolean
 */
public void setPeriodYear(boolean newPeriodYear) {
	periodYear = newPeriodYear;
}
public void setRdateFrom(java.sql.Date newDate) {
	rdateFrom.setSqlDate(newDate);
}
public void setRdateFromFrm(String newDate) {
	rdateFrom.setString(newDate);
}
public void setRdateTill(java.sql.Date newDate) {
	rdateTill.setSqlDate(newDate);
}
public void setRdateTillFrm(String newDate) {
	rdateTill.setString(newDate);
}
/**
 * 
 * @param newTypeAvans boolean
 */
public void setTypeAvans(boolean newTypeAvans) {
	typeAvans = newTypeAvans;
}
/**
 * 
 * @param newTypeBybill boolean
 */
public void setTypeBybill(boolean newTypeBybill) {
	typeBybill = newTypeBybill;
}
/**
 * 
 * @param newTypeByend boolean
 */
public void setTypeByend(boolean newTypeByend) {
	typeByend = newTypeByend;
}
}
