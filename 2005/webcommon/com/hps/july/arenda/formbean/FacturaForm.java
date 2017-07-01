package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import java.sql.Date;
import java.math.*;
import com.hps.july.persistence.*;
import com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма фактуры.
 * Creation date: (16.05.2003 14:37:54)
 * @author: Sergey Gourov
 */
public class FacturaForm extends com.hps.july.web.util.EditForm {
	private int leaseDocPosition;
	private java.lang.Boolean isInitialError;
	private java.lang.String errorMessage;
	private int idPosSchetFakt;
	private java.lang.String nameResource;
	private StringAndBigDecimalProperty sumFreeTax = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty rateNds = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty sumNds = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty sumWithTax = new StringAndBigDecimalProperty();
	private java.lang.String baseDocNumber;
	private StringAndSqlDateProperty baseDocDate = new StringAndSqlDateProperty();
	private int idCurrencycode;
	private int schetFact;
	private java.lang.String executorName;
	private java.lang.String executorAddress;
	private java.lang.String executorInn;
	private java.lang.String customerName;
	private java.lang.String customerAddress;
	private java.lang.String customerInn;
	private java.lang.String chiefName;
	private java.lang.String accounterName;
	private java.lang.String positions;
	private java.lang.String exec;
	private java.lang.String cust;
	
	private StringAndIntegerProperty currency = new StringAndIntegerProperty();
	private java.lang.String type = "A";
	private int idContract;
public FacturaForm() {
	setAction("Edit");
}
public void afterUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	request.getSession().setAttribute("schetFact", new Integer(getSchetFact()));
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	if(!"Add".equals(getAction())) {
		LeasePosSchetFaktAccessBean lpsfBean = (LeasePosSchetFaktAccessBean) bean;
		lpsfBean.setSumFreeTax(lpsfBean.getSumWithTax().subtract(lpsfBean.getSumNds()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		LeaseSchetFaktAccessBean lsfBean = new LeaseSchetFaktAccessBean();
		lsfBean.setInitKey_idSchetFakt(((LeasePosSchetFaktAccessBean) getDataBean(request)).getIdSchetFaktKey().idSchetFakt);
		lsfBean.refreshCopyHelper();
		
		lsfBean.setBaseDocNumber(getBaseDocNumber());
		lsfBean.setBaseDocDate(getBaseDocDate());
		
		CurrencyAccessBean cBean = new CurrencyAccessBean();
		cBean.setInitKey_currency(getIdCurrencycode());
		cBean.refreshCopyHelper();
		lsfBean.setIdCurrency((Currency) cBean.getEJBRef());
		
		lsfBean.commitCopyHelper();
	}
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws Exception
{
	LeasePosSchetFaktAccessBean lpsfBean = (LeasePosSchetFaktAccessBean) getDataBean(request);
	lpsfBean.refreshCopyHelper();
	
	return lpsfBean;
}
public void createFactura(ActionErrors errors)
	throws Exception
{
	// check currency and leaseDocPosition here
	// if errors throw Validate exception and add a record to errors collection
	System.out.println("FACTURA: Curr:"+getCurrency());
		
	if (getLeaseDocPosition() != 0) {
		setIsInitialError(new Boolean(false));
		Object[] values = { new Integer(0), "" };
			
		try {
			values = new ArendaDocumentProcessorAccessBean().prepareShetFact(getLeaseDocPosition(), getCurrency());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
			
		if (((Integer) values[0]).intValue() == 0) {
			setIsInitialError(new Boolean(true));
			setErrorMessage((String) values[1]);
		} else {
			setIdPosSchetFakt(((Integer) values[0]).intValue());
		}
	}
	
	System.out.println("FACTURA: End of call!!! InitialError:"+getIsInitialError());

	if(getIsInitialError() != null && getIsInitialError().booleanValue()) {
		throw new ValidationException();
	}
}
public void fillRecord(AbstractEntityAccessBean abean) {
	try {
		LeasePosSchetFaktAccessBean lpsfBean = (LeasePosSchetFaktAccessBean)abean;
		lpsfBean.refreshCopyHelper();
		
		LeaseSchetFaktAccessBean lsfBean = lpsfBean.getIdSchetFakt();
		setBaseDocNumber(lsfBean.getBaseDocNumber());
		setBaseDocDate(lsfBean.getBaseDocDate());
		setIdCurrencycode(lsfBean.getIdCurrencyKey().currency);
		setSchetFact(lsfBean.getIdSchetFakt());
		
		setPositions("");
		java.util.Enumeration e = new LeaseOnPositionAccessBean().findLeaseonpositionsByLeaseArendaAgreementNew(lsfBean.getIdContractKey());
		while (e.hasMoreElements()) {
			LeaseOnPositionAccessBean bean = (LeaseOnPositionAccessBean) e.nextElement();
			setPositions(getPositions() + (getPositions().equals("") ? "" : "; ") + bean.getPosition().getName());
		}
		setExecutorName(lsfBean.getIdContract().getOrgExecutor().getName());
		setExecutorAddress(lsfBean.getIdContract().getOrgCustomer().getLegaladdress());
		setExecutorInn(lsfBean.getIdContract().getOrgExecutor().getInn());
		setCustomerName(lsfBean.getIdContract().getOrgCustomer().getName());
		setCustomerAddress(lsfBean.getIdContract().getOrgCustomer().getLegaladdress());
		setCustomerInn(lsfBean.getIdContract().getOrgCustomer().getInn());
		setExec(getExecutorName() + " " + getExecutorAddress());
		setCust(getCustomerName() + " " + getCustomerAddress());
		setChiefName(lsfBean.getIdContract().getOrgExecutor().getDirectorinfo());
		setAccounterName(lsfBean.getIdContract().getOrgExecutor().getAccauntmanagerinfo());
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:38:23)
 * @return java.lang.String
 */
public java.lang.String getAccounterName() {
	return accounterName;
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
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:36:47)
 * @return java.lang.String
 */
public java.lang.String getChiefName() {
	return chiefName;
}
public java.util.Enumeration getCurrencies() {
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch(Exception e) {
		return new java.util.Vector().elements();	
	}	
}
public Integer getCurrency() {
	return currency.getInteger();
}
public String getCurrencyFrm() {
	return currency.getString();
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
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	System.out.println("FACTURA: IdFact:"+getIdPosSchetFakt());
	LeasePosSchetFaktAccessBean bean = new LeasePosSchetFaktAccessBean();
	bean.setInitKey_idPosSchetFakt(getIdPosSchetFakt());
	return bean;
}
public java.lang.String getErrorMessage() {
	return errorMessage;
}
public java.lang.String getExec() {
	return exec;
}
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
 * Creation date: (16.05.2003 15:17:54)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsInitialError() {
	return isInitialError;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 15:11:58)
 * @return int
 */
public int getLeaseDocPosition() {
	return leaseDocPosition;
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
 * Creation date: (22.05.2003 9:42:40)
 * @return java.lang.String
 */
public java.lang.String getPositions() {
	return positions;
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
 * Creation date: (21.05.2003 19:31:06)
 * @return int
 */
public int getSchetFact() {
	return schetFact;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FACTURA_EDIT;
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
 * Creation date: (30.04.2004 11:26:45)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
public void initCollections(HttpServletRequest request) throws Exception {
/*
		if (getLeaseDocPosition() != 0) {
			setIsInitialError(new Boolean(false));
			Object[] values = { new Integer(0), "" };
			
			try {
				values = new ArendaDocumentProcessorAccessBean().prepareShetFact(getLeaseDocPosition(), getCurrency());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (((Integer) values[0]).intValue() == 0) {
				setIsInitialError(new Boolean(true));
				setErrorMessage((String) values[1]);
			} else {
				setIdPosSchetFakt(((Integer) values[0]).intValue());
			}
		}
*/		
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 9:38:23)
 * @param newAccounterName java.lang.String
 */
public void setAccounterName(java.lang.String newAccounterName) {
	accounterName = newAccounterName;
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
 * Creation date: (22.05.2003 9:36:47)
 * @param newChiefName java.lang.String
 */
public void setChiefName(java.lang.String newChiefName) {
	chiefName = newChiefName;
}
public void setCurrency(Integer newCurrency) {
	currency.setInteger(newCurrency);
}
public void setCurrencyFrm(String newCurrency) {
	currency.setString(newCurrency);
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
 * Creation date: (16.05.2003 17:56:55)
 * @param newErrorMessage java.lang.String
 */
public void setErrorMessage(java.lang.String newErrorMessage) {
	errorMessage = newErrorMessage;
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
 * Creation date: (16.05.2003 15:17:54)
 * @param newIsInitialError java.lang.Boolean
 */
public void setIsInitialError(java.lang.Boolean newIsInitialError) {
	isInitialError = newIsInitialError;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 15:11:58)
 * @param newLeaseDocPosition int
 */
public void setLeaseDocPosition(int newLeaseDocPosition) {
	leaseDocPosition = newLeaseDocPosition;
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
 * Creation date: (22.05.2003 9:42:40)
 * @param newPositions java.lang.String
 */
public void setPositions(java.lang.String newPositions) {
	positions = newPositions;
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
 * Creation date: (21.05.2003 19:31:06)
 * @param newSchetFact int
 */
public void setSchetFact(int newSchetFact) {
	schetFact = newSchetFact;
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
 * Creation date: (30.04.2004 11:26:45)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void validateValues(ActionErrors errors) throws Exception {
	if (!sumFreeTax.isEmpty() && !sumFreeTax.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumfreetax"));
	}
		
	if (!rateNds.isEmpty() && !rateNds.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.ratends"));
	}

	if (!sumNds.isEmpty() && !sumNds.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumnds"));
	}

	if (!sumWithTax.isEmpty() && !sumWithTax.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumwithtax"));
	}

	if (!errors.empty()) throw new ValidationException();
}
/**
 * 
 * @param errors
 * @throws Exception
 */
public void createFactura(ActionErrors errors, Integer operatorCode)
	throws Exception
{
	// check currency and leaseDocPosition here
	// if errors throw Validate exception and add a record to errors collection
	System.out.println("FACTURA: Curr:"+getCurrency());
		
	if (getLeaseDocPosition() != 0) {
		setIsInitialError(new Boolean(false));
		Object[] values = { new Integer(0), "" };
			
		try {
			//values = new ArendaDocumentProcessorAccessBean().prepareShetFact(getLeaseDocPosition(), getCurrency());
			values = CDBC_SchetFact_Object.prepareShetFact(getLeaseDocPosition(), getCurrency().intValue(), operatorCode.intValue());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
			
		if (((Integer) values[0]).intValue() != 0) {
			setIsInitialError(new Boolean(true));
			setErrorMessage((String) values[1]);
		} else {
			setIdPosSchetFakt(((Integer) values[2]).intValue());
			setIdContract(((Integer) values[3]).intValue());
		}
	}
	
	System.out.println("FACTURA: End of call!!! InitialError:"+getIsInitialError());

	if(getIsInitialError() != null && getIsInitialError().booleanValue()) {
		throw new ValidationException();
	}
}
	/**
	 * @return
	 */
	public int getIdContract() {
		return idContract;
	}

	/**
	 * @param i
	 */
	public void setIdContract(int i) {
		idContract = i;
	}

}
