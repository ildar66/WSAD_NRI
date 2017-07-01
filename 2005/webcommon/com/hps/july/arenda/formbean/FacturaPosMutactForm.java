package com.hps.july.arenda.formbean;

import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import java.sql.Date;
import java.math.*;
import com.hps.july.persistence.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма позиций фактуры.
 * Creation date: (16.05.2003 14:37:54)
 * @author: Sergey Gourov
 */
public class FacturaPosMutactForm extends com.hps.july.web.util.EditForm {
	private int idPosSchetFakt;
	private java.lang.String nameResource;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sumFreeTax = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal rateNds = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sumNds = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sumWithTax = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	private java.lang.String baseDocNumber;
	private StringAndSqlDateProperty baseDocDate = new StringAndSqlDateProperty();
	private int idCurrencycode;
	private java.lang.String executorName;
	private java.lang.String executorAddress;
	private java.lang.String executorInn;
	private java.lang.String customerName;
	private java.lang.String customerAddress;
	private java.lang.String customerInn;
	private java.lang.String exec;
	private java.lang.String cust;
	private int idSchetFakt;
	private int resourceNricode;
	private com.hps.july.persistence.ResourceAccessBean resourceNri;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	LeasePosSchetFaktAccessBean lpsfBean = (LeasePosSchetFaktAccessBean) bean;
	lpsfBean.setSumFreeTax(
		lpsfBean.getSumWithTax().subtract(lpsfBean.getSumNds()).setScale(2, BigDecimal.ROUND_HALF_UP));
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	setIdPosSchetFakt(new KeyGeneratorAccessBean().getNextKey("tables.leaseposschetfakt"));

/* @param argIdPosSchetFakt Integer
 * @param idSchetFakt Integer
 * @param argPosorder Integer
 * @param resourceNri Integer*/
	
	return new LeasePosSchetFaktAccessBean(new Integer(getIdPosSchetFakt()), new Integer(getIdSchetFakt()),
		new Integer(1), new Integer(getResourceNricode()));
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:56:14)
 * @return com.hps.july.persistence.ResourceAccessBean
 * @exception java.lang.Exception The exception description.
 */
private ResourceAccessBean constructResource() throws java.lang.Exception {
	if (resourceNri == null) {
		if (resourceNricode != 0) {
			resourceNri = new ResourceAccessBean();
			resourceNri.setInitKey_resource(resourceNricode);
			resourceNri.refreshCopyHelper();
		}
	}
	return resourceNri;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getBaseDocDate() {
	return baseDocDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getBaseDocDateFrm() {
	return baseDocDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:03)
 * @return java.lang.String
 */
public java.lang.String getBaseDocNumber() {
	return baseDocNumber;
}
public java.util.Enumeration getCurrencies() {
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:55:56)
 * @return java.lang.String
 */
public java.lang.String getCust() {
	return cust;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:34:08)
 * @return java.lang.String
 */
public java.lang.String getCustomerAddress() {
	return customerAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:34:59)
 * @return java.lang.String
 */
public java.lang.String getCustomerInn() {
	return customerInn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:32:38)
 * @return java.lang.String
 */
public java.lang.String getCustomerName() {
	return customerName;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeasePosSchetFaktAccessBean bean = new LeasePosSchetFaktAccessBean();
	bean.setInitKey_idPosSchetFakt(getIdPosSchetFakt());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:55:34)
 * @return java.lang.String
 */
public java.lang.String getExec() {
	return exec;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:28:57)
 * @return java.lang.String
 */
public java.lang.String getExecutorAddress() {
	return executorAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:30:53)
 * @return java.lang.String
 */
public java.lang.String getExecutorInn() {
	return executorInn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:26:59)
 * @return java.lang.String
 */
public java.lang.String getExecutorName() {
	return executorName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:57:41)
 * @return int
 */
public int getIdCurrencycode() {
	return idCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:04:59)
 * @return int
 */
public int getIdPosSchetFakt() {
	return idPosSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 11:58:02)
 * @return int
 */
public int getIdSchetFakt() {
	return idSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 11:37:39)
 * @return java.lang.String
 */
String getListForm() {
	return "FacturaPosMutactList";
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:11:21)
 * @return java.lang.String
 */
public java.lang.String getNameResource() {
	return nameResource;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getRateNds() {
	return rateNds.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getRateNdsFrm() {
	return rateNds.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 12:52:45)
 * @return com.hps.july.persistence.ResourceAccessBean
 */
public Resource getResourceNri() throws Exception {
    ResourceAccessBean bean = constructResource();
    return bean != null ? (Resource) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 12:50:14)
 * @return int
 */
public int getResourceNricode() {
	return resourceNricode;
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FACTURA_POS_MUTACT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumFreeTax() {
	return sumFreeTax.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumFreeTaxFrm() {
	return sumFreeTax.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumNds() {
	return sumNds.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumNdsFrm() {
	return sumNds.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumWithTax() {
	return sumWithTax.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumWithTaxFrm() {
	return sumWithTax.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	FacturaPosMutactList fp = (FacturaPosMutactList) request.getSession().getAttribute(getListForm());
	setIdSchetFakt(fp.getIdSchetFact());
	
	LeaseSchetFaktAccessBean lsfBean = new LeaseSchetFaktAccessBean();
	lsfBean.setInitKey_idSchetFakt(fp.getIdSchetFact());
	lsfBean.refreshCopyHelper();
	
	setBaseDocNumber(lsfBean.getBaseDocNumber());
	setBaseDocDate(lsfBean.getBaseDocDate());
	setIdCurrencycode(lsfBean.getIdCurrencyKey().currency);
	
	setExecutorName(lsfBean.getIdContract().getOrgExecutor().getName());
	setExecutorAddress(lsfBean.getIdContract().getOrgExecutor().getLegaladdress());
	setExecutorInn(lsfBean.getIdContract().getOrgExecutor().getInn());
	setCustomerName(lsfBean.getIdContract().getOrgCustomer().getName());
	setCustomerAddress(lsfBean.getIdContract().getOrgCustomer().getLegaladdress());
	setCustomerInn(lsfBean.getIdContract().getOrgCustomer().getInn());
	setExec(getExecutorName() + " " + getExecutorAddress());
	setCust(getCustomerName() + " " + getCustomerAddress());
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @param newBaseDocDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBaseDocDate(Date newBaseDocDate) {
	baseDocDate.setSqlDate(newBaseDocDate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @param newBaseDocDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBaseDocDateFrm(String newBaseDocDate) {
	baseDocDate.setString(newBaseDocDate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:03)
 * @param newBaseDocNumber java.lang.String
 */
public void setBaseDocNumber(java.lang.String newBaseDocNumber) {
	baseDocNumber = newBaseDocNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:55:56)
 * @param newCust java.lang.String
 */
public void setCust(java.lang.String newCust) {
	cust = newCust;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:34:08)
 * @param newCustomerAddress java.lang.String
 */
public void setCustomerAddress(java.lang.String newCustomerAddress) {
	customerAddress = newCustomerAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:34:59)
 * @param newCustomerInn java.lang.String
 */
public void setCustomerInn(java.lang.String newCustomerInn) {
	customerInn = newCustomerInn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:32:38)
 * @param newCustomerName java.lang.String
 */
public void setCustomerName(java.lang.String newCustomerName) {
	customerName = newCustomerName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:55:34)
 * @param newExec java.lang.String
 */
public void setExec(java.lang.String newExec) {
	exec = newExec;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:28:57)
 * @param newExecutorAddress java.lang.String
 */
public void setExecutorAddress(java.lang.String newExecutorAddress) {
	executorAddress = newExecutorAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:30:53)
 * @param newExecutorInn java.lang.String
 */
public void setExecutorInn(java.lang.String newExecutorInn) {
	executorInn = newExecutorInn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:26:59)
 * @param newExecutorName java.lang.String
 */
public void setExecutorName(java.lang.String newExecutorName) {
	executorName = newExecutorName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:57:41)
 * @param newIdCurrencycode int
 */
public void setIdCurrencycode(int newIdCurrencycode) {
	idCurrencycode = newIdCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:04:59)
 * @param newIdPosSchetFakt int
 */
public void setIdPosSchetFakt(int newIdPosSchetFakt) {
	idPosSchetFakt = newIdPosSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 11:58:02)
 * @param newIdSchetFakt int
 */
public void setIdSchetFakt(int newIdSchetFakt) {
	idSchetFakt = newIdSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:11:21)
 * @param newNameResource java.lang.String
 */
public void setNameResource(java.lang.String newNameResource) {
	nameResource = newNameResource;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @param newRateNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRateNds(BigDecimal newRateNds) {
	rateNds.setBigDecimal(newRateNds);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @param newRateNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRateNdsFrm(String newRateNds) {
	rateNds.setString(newRateNds);
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 12:52:45)
 * @param newResourceNri com.hps.july.persistence.ResourceAccessBean
 */
public void setResourceNri(com.hps.july.persistence.ResourceAccessBean newResourceNri) throws Exception {
	setResourceNricode(newResourceNri == null ? 0 : newResourceNri.getResource());
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 12:50:14)
 * @param newResourceNricode int
 */
public void setResourceNricode(int newResourceNricode) {
	resourceNricode = newResourceNricode;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @param newSumFreeTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumFreeTax(BigDecimal newSumFreeTax) {
	sumFreeTax.setBigDecimal(newSumFreeTax);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @param newSumFreeTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumFreeTaxFrm(String newSumFreeTax) {
	sumFreeTax.setString(newSumFreeTax);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @param newSumNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumNds(BigDecimal newSumNds) {
	sumNds.setBigDecimal(newSumNds);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @param newSumNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumNdsFrm(String newSumNds) {
	sumNds.setString(newSumNds);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @param newSumWithTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumWithTax(BigDecimal newSumWithTax) {
	sumWithTax.setBigDecimal(newSumWithTax);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @param newSumWithTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumWithTaxFrm(String newSumWithTax) {
	sumWithTax.setString(newSumWithTax);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {

	if (sumFreeTax.isEmpty() || (!sumFreeTax.isEmpty() && !sumFreeTax.isOk())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumfreetax"));
	}
	
	if (rateNds.isEmpty() || (!rateNds.isEmpty() && !rateNds.isOk())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.ratends"));
	}

	if (sumNds.isEmpty() || (!sumNds.isEmpty() && !sumNds.isOk())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumnds"));
	}

	if (sumWithTax.isEmpty() || (!sumWithTax.isEmpty() && !sumWithTax.isOk())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumwithtax"));
	}

	if (!errors.empty()) throw new ValidationException();
}
}
