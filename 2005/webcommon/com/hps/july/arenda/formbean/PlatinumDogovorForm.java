package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import java.sql.Timestamp;
import com.hps.july.arenda.sessionbean.*;
import java.math.*;
import java.util.*;
import java.sql.Date;
import com.hps.july.web.util.*;
import com.hps.july.arenda.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
/**
 * Bean-form
 * Форма "Договор платины".
 */
public class PlatinumDogovorForm extends com.hps.july.web.util.EditForm {
	private int leasedocument;
	private java.lang.String vendor;
	private java.lang.String name;
	private java.lang.Integer idbudjet;
	private java.lang.Integer idproject;
	private java.lang.Integer idexpense;
	private java.lang.Integer idsubexpence;
	private java.lang.String documentNumber;
	private com.hps.july.web.util.StringAndSqlDateProperty documentDate;
	private java.lang.String orgCustomername;
	private java.lang.String orgExecutorname;
	private com.hps.july.web.util.StringAndBigDecimalProperty summ1;
	private com.hps.july.web.util.StringAndBigDecimalProperty summ2;
	private java.lang.String currencyname1;
	private java.lang.String currencyname2;
	private com.hps.july.web.util.StringAndSqlDateProperty startDate;
	private com.hps.july.web.util.StringAndSqlDateProperty endDate;
	private java.lang.Integer iddirect;
	private java.lang.Integer iditem;
	private com.hps.july.web.util.StringAndSqlTimestampProperty datenritoplatinum;
	private com.hps.july.web.util.StringAndSqlTimestampProperty dateplatinum;
	private java.lang.String flagsync;
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 18:00:36)
 */
public PlatinumDogovorForm() {
	setDocumentNumber("");
	documentDate = new StringAndSqlDateProperty();
	startDate = new StringAndSqlDateProperty();
	endDate = new StringAndSqlDateProperty();

	setOrgCustomername("");
	setOrgExecutorname("");

	summ1 = new StringAndBigDecimalProperty();
	summ1.setBigDecimal(null);

	summ2 = new StringAndBigDecimalProperty();
	summ2.setBigDecimal(null);

	currencyname1 = new String("");
	currencyname2 = new String("");

	datenritoplatinum = new StringAndSqlTimestampProperty();
	dateplatinum = new StringAndSqlTimestampProperty();

	setFlagsync("0");
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	PIEDopInfoContrAccessBean bean = new PIEDopInfoContrAccessBean(getLeasedocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	setCertainValues();
}
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:29:44)
 * @return java.lang.String
 */
public java.lang.String getCurrencyname1() {
	return currencyname1;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:30:03)
 * @return java.lang.String
 */
public java.lang.String getCurrencyname2() {
	return currencyname2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	PIEDopInfoContrAccessBean bean = new PIEDopInfoContrAccessBean();
	bean.setInitKey_leasedocument(getLeasedocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:19:51)
 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public Timestamp getDatenritoplatinum() {
	return datenritoplatinum.getSqlTimestamp();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:19:51)
 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public String getDatenritoplatinumFrm() {
	return datenritoplatinum.getStringDate();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:23:12)
 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public Timestamp getDateplatinum() {
	return dateplatinum.getSqlTimestamp();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:23:12)
 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public String getDateplatinumFrm() {
	return dateplatinum.getStringDate();
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 16:42:39)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocumentDate() {
	return documentDate.getSqlDate();
}
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 16:34:39)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:56:32)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEndDate() {
	return endDate.getSqlDate();
}
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:29:04)
 * @return java.lang.String
 */
public java.lang.String getFlagsync() {
	return flagsync;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:31:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdbudjet() {
	return idbudjet;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 20:26:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getIddirect() {
	return iddirect;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:47:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdexpense() {
	return idexpense;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 20:32:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getIditem() {
	return iditem;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:39:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdproject() {
	return idproject;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:55:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdsubexpence() {
	return idsubexpence;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:43:45)
 * @return int
 */
public int getLeasedocument() {
	return leasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:53:38)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:01:23)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomername() {
	return orgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:04:59)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutorname() {
	return orgExecutorname;
}
public java.util.Enumeration getOurBudjets() {
	try {
		// owner = customer from base contract
		LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
		lcBean.setInitKey_leaseDocument(getLeasedocument());
		lcBean.refreshCopyHelper();
		
		return new PIEBudjetAccessBean().findByOwnerAndRecordstatusOrderByNameAsc(new Integer(lcBean.getOrgCustomerKey().organization), "A");
	} catch (Exception e) {
		e.printStackTrace();
		return new Vector().elements();
	}
}
public Enumeration getOurExpences() {
	try {
		LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
		lcBean.setInitKey_leaseDocument(getLeasedocument());
		lcBean.refreshCopyHelper();
		
		return new PIEExpenceAccessBean().findByOwnerAndRecordstatusOrderByNameAsc(new Integer(lcBean.getOrgCustomerKey().organization), "A");
	} catch(Exception e) {
		e.printStackTrace();
		return new Vector().elements();	
	}		
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:52:27)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartDate() {
	return startDate.getSqlDate();
}
  public String getStartDateFrm() {
	return startDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.PLATINUM_DOGOVOR_FORM;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:09:57)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumm1() {
	return summ1.getBigDecimal();
}
public String getSumm1Frm() {
	return summ1.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:13:22)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumm2() {
	return summ2.getBigDecimal();
}
public String getSumm2Frm() {
	return summ2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:44:02)
 * @return java.lang.String
 */
public java.lang.String getVendor() {
	return vendor;
}
public int getVendor_length() {
	try {
		NamedValueAccessBean nv = new NamedValueAccessBean();
		nv.setInitKey_id("VENDORLENGTH");
		nv.refreshCopyHelper();
		return nv.getIntvalue();
	} catch(Exception e) {
		return 12;
	}
}
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	setLeasedocument(new LeaseArendaAgreementProcessorAccessBean().getBaseContract(getLeasedocument()));
	
	LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
	lcBean.setInitKey_leaseDocument(getLeasedocument());
	lcBean.refreshCopyHelper();
	
	setDocumentNumber(lcBean.getDocumentNumber());
	setDocumentDate(lcBean.getDocumentDate());
	setOrgCustomername(lcBean.getOrgCustomer().getName());
	setOrgExecutorname(lcBean.getOrgExecutor().getName());
	setSumm1(lcBean.getSumm1());
	setSumm2(lcBean.getSumm2());
	setCurrencyname1(lcBean.getCurrency1().getName());
	setCurrencyname2(lcBean.getCurrency2() != null ? lcBean.getCurrency2().getName() : "");
	setStartDate(lcBean.getStartDate());
	setEndDate(lcBean.getEndDate());
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setCertainValues();
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2003 11:52:49)
 */
private void setCertainValues() {
	try {
		LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
		lcBean.setInitKey_leaseDocument(getLeasedocument());
		lcBean.refreshCopyHelper();

		if (getIdbudjet() == null) {
			setIdbudjet(new Integer(new ArendaDocumentProcessorAccessBean().getDefaultBudjet(lcBean.getOrgCustomerKey().organization)));
		}
		if (getIdexpense() == null) {
			setIdexpense(new Integer(new ArendaDocumentProcessorAccessBean().getDefaultExpence(lcBean.getOrgCustomerKey().organization)));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:29:44)
 * @param newCurrencyname1 java.lang.String
 */
public void setCurrencyname1(java.lang.String newCurrencyname1) {
	currencyname1 = newCurrencyname1;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:30:03)
 * @param newCurrencyname2 java.lang.String
 */
public void setCurrencyname2(java.lang.String newCurrencyname2) {
	currencyname2 = newCurrencyname2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:19:51)
 * @param newDatenritoplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public void setDatenritoplatinum(Timestamp newDatenritoplatinum) {
	datenritoplatinum.setSqlTimestamp(newDatenritoplatinum);
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:19:51)
 * @param newDatenritoplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public void setDatenritoplatinumFrm(String newDatenritoplatinum) {
	datenritoplatinum.setString(newDatenritoplatinum);
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:23:12)
 * @param newDateplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public void setDateplatinum(Timestamp newDateplatinum) {
	dateplatinum.setSqlTimestamp(newDateplatinum);
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:23:12)
 * @param newDateplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
 */
public void setDateplatinumFrm(String newDateplatinum) {
	dateplatinum.setString(newDateplatinum);
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 16:42:39)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 16:34:39)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:56:32)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDate(Date newEndDate) {
	endDate.setSqlDate(newEndDate);
}
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 11:29:04)
 * @param newFlagsync java.lang.String
 */
public void setFlagsync(java.lang.String newFlagsync) {
	flagsync = newFlagsync;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:31:05)
 * @param newIdbudjet java.lang.Integer
 */
public void setIdbudjet(java.lang.Integer newIdbudjet) {
	idbudjet = newIdbudjet;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 20:26:39)
 * @param newIddirect java.lang.Integer
 */
public void setIddirect(java.lang.Integer newIddirect) {
	iddirect = newIddirect;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:47:13)
 * @param newIdexpense java.lang.Integer
 */
public void setIdexpense(java.lang.Integer newIdexpense) {
	idexpense = newIdexpense;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 20:32:56)
 * @param newIditem java.lang.Integer
 */
public void setIditem(java.lang.Integer newIditem) {
	iditem = newIditem;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:39:12)
 * @param newIdproject java.lang.Integer
 */
public void setIdproject(java.lang.Integer newIdproject) {
	idproject = newIdproject;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:55:32)
 * @param newIdsubexpence java.lang.Integer
 */
public void setIdsubexpence(java.lang.Integer newIdsubexpence) {
	idsubexpence = newIdsubexpence;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:43:45)
 * @param newLeasedocument int
 */
public void setLeasedocument(int newLeasedocument) {
	leasedocument = newLeasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:53:38)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:01:23)
 * @param newOrgCustomername java.lang.String
 */
public void setOrgCustomername(java.lang.String newOrgCustomername) {
	orgCustomername = newOrgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:04:59)
 * @param newOrgExecutorname java.lang.String
 */
public void setOrgExecutorname(java.lang.String newOrgExecutorname) {
	orgExecutorname = newOrgExecutorname;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:52:27)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDate(Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
public void setStartDateFrm(String newStartDate) {
	startDate.setString(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:09:57)
 * @param newSumm1 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumm1(BigDecimal newSumm1) {
	summ1.setBigDecimal(newSumm1);
}
public void setSumm1Frm(String newSumm1) {
	summ1.setString(newSumm1);
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 17:13:22)
 * @param newSumm2 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumm2(BigDecimal newSumm2) {
	summ2.setBigDecimal(newSumm2);
}
public void setSumm2Frm(String newSumm2) {
	summ2.setString(newSumm2);
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:44:02)
 * @param newVendor java.lang.String
 */
public void setVendor(java.lang.String newVendor) {
	vendor = newVendor;
}
public void validateValues(ActionErrors errors)
	throws Exception
{
	//vendor must be entered
	if(vendor == null || "".equals(vendor)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinumdogovor.vendor"));
	} else {
		int vl = getVendor_length();
		if(vendor.length() > vl) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinumdogovor.vendor",new Integer(vl)));
		}
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
