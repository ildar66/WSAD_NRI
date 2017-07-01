package com.hps.july.arenda.formbean;

import java.text.SimpleDateFormat;
import com.hps.july.arenda.sessionbean.*;
import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.commonbean.*;
import com.hps.july.web.util.*;
import java.sql.*;
import java.math.*;
import com.hps.july.arenda.*;
import com.hps.july.util.*;

/**
 * form-bean
 * форма для начислений
 * Creation date: (05.07.2002 14:02:29)
 * @author: Sergey Gourov
 */
public class ChargeForm extends com.hps.july.web.util.EditForm {
	private java.lang.String documentNumber;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private java.lang.String orgCustomerContract;
	private java.lang.String orgExecutorContract;
	private String costcurrency1;
	private String costcurrency2;
	private com.hps.july.web.util.StringAndIntegerProperty resourcecode;
	private java.lang.Integer currencycode;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal summ;
	private java.lang.String resourcename;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private com.hps.july.persistence.CurrencyAccessBean currency;
	private int leaseDocPosition;
	private StringAndSqlDateProperty date;
	private com.hps.july.persistence.LeaseContractAccessBean leaseContract;
	private java.lang.Integer leaseContractcode;
	private java.lang.String source;

	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sumnds;
	private java.lang.String curr1;
	private java.lang.String curr2;
	protected java.lang.String listForm;
	private java.lang.String docposvid;
	private com.hps.july.web.util.StringAndSqlDateProperty begindate;
	private com.hps.july.web.util.StringAndSqlDateProperty enddate;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal remaindersum;
	private java.lang.Boolean byhandraterur;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal remainderrate2rur;
	private java.lang.String billnumber;
	private java.lang.String calctype;
	private java.lang.Boolean isCorrection;
	private com.hps.july.web.util.StringAndSqlDateProperty billdate;
	private java.util.Date saldate = null;
	private java.lang.String mainPosition;
	//ставка НДС:
	private StringAndBigDecimalProperty ndsRate;
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:03:45)
 */
public ChargeForm() {
	Date currdate = new Date(System.currentTimeMillis());

	startDate = new StringAndSqlDateProperty();
	startDate.setSqlDate(currdate);
	
	endDate = new StringAndSqlDateProperty();
	endDate.setSqlDate(currdate);

	begindate = new StringAndSqlDateProperty();
	begindate.setSqlDate(currdate);
	enddate = new StringAndSqlDateProperty();
	enddate.setSqlDate(currdate);

	date = new StringAndSqlDateProperty();
	date.setSqlDate(currdate);

	resourcecode = new StringAndIntegerProperty();
	resourcecode.setInteger(new Integer(0));

	summ = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	sumnds = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	remaindersum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	remainderrate2rur = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);
	billdate = new StringAndSqlDateProperty();

	setSource("M");
	setDocposvid("N");
	
	costcurrency1 = "";
	costcurrency2 = "";

	listForm = "ChargesListForm";
	ndsRate = new StringAndBigDecimalProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
    throws Exception {
/**
 * закоментарено 17.01.2005 по заявке Борцова
    if (!checkOpenPeriod()) {
        throw new UpdateValidationException("error.charge.notopenperiod");
    }
*/
    if (!((getSource().equals("M") || getSource().equals("A")) && getDocposvid().equals("N"))) {
        throw new UpdateValidationException("error.invalid.charge.source");
    }
    
    // проверка использования в актах:
    LeaseChargesAccessBean abean = (LeaseChargesAccessBean) bean;
    if (abean.getUsedinact() != null)
        throw new UpdateValidationException("error.charge.applied.mutualact");
    if (abean.getUsedincwact() != null)
        throw new UpdateValidationException("error.charge.applied.cwact");
    if (!checkLink2Pay()) {
        throw new UpdateValidationException("error.charge.haspay");
    }

    if (getSource().equals("B")
        || getSource().equals("P")
        || getDocposvid().equals("Q")
        || getDocposvid().equals("K")
        || getDocposvid().equals("Z")) {
        throw new UpdateValidationException("error.invalid.charge.wrong");
    }

    //удаляем все курсы:
    Enumeration e =
        new LeaseCalcRateAccessBean().findLeaseCalcRatesByDocposition(new LeaseDocPositionKey(getLeaseDocPosition()));
    while (e.hasMoreElements()) {
        LeaseCalcRateAccessBean lcrBean = (LeaseCalcRateAccessBean) e.nextElement();
        lcrBean.getEJBRef().remove();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2004 16:38:12)
 */
public void calsRateNds() {
	if (getSumm() == null || getSumnds() == null)
		return;
	double summ = getSumm().doubleValue();
	double sumNds = getSumnds().doubleValue();
	double nds = 100 * sumNds / (summ - sumNds);
	if ((nds > 19) || (nds < 21))
		setNdsRate(new BigDecimal("20"));
	if ((nds > 17) || (nds < 19))
		setNdsRate(new BigDecimal("18"));
	setNdsRate(new BigDecimal(Math.round(nds)));
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 19:11:33)
 * @exception java.lang.Exception The exception description.
 */
private boolean checkLink2Pay() throws java.lang.Exception {
	Enumeration e = new LeaseDNOPAccessBean().findLeaseDNOPByLeaseCharge(new LeaseDocPositionKey(getLeaseDocPosition()));
	if (e.hasMoreElements()) {
		return false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 16:34:54)
 * @return boolean
 */
private boolean checkOpenPeriod() throws Exception {
	Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(getLeaseContractcode(), getResourcecode());
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
		saldate = bean.getSalDate();
		return getDate().after(saldate) ? true : false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setLeaseDocPosition(keyGen.getNextKey("tables.leasedocpositions"));
	setRemaindersum(getSumm());

/* @param argLeaseDocPosition int
 * @param argDate java.sql.Date
 * @param argLeaseContract java.lang.Integer
 * @param argSource java.lang.String
 * @param argVid java.lang.String
 * @param argSDate java.sql.Date
 * @param argEDate java.sql.Date
 * @param argResource java.lang.Integer
 * @param argSumm java.math.BigDecimal
 * @param argCurrency java.lang.Integer
 * @param argSumNds java.math.BigDecimal
 * @param argRemainderSum java.math.BigDecimal
 * @param argByHandRateRur java.lang.Boolean*/
 
 	
	return new LeaseChargesAccessBean(getLeaseDocPosition(), getDate(), getLeaseContractcode(), 
		getSource(), getDocposvid(), getBegindate(), getEnddate(), getResourcecode(), getSumm(),
		getCurrencycode(), getSumnds(), getRemaindersum(), getByhandraterur());
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 15:34:33)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructCurrency() throws java.lang.Exception {
	if (currency == null) {
		if (getCurrencycode() != null) {
			currency = new CurrencyAccessBean();
			currency.setInitKey_currency(getCurrencycode().intValue());
			currency.refreshCopyHelper();
		}
	}
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 15:34:33)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseContractAccessBean constructLeaseContract() throws java.lang.Exception {
	if (leaseContract == null) {
		if (getLeaseContractcode() != null) {
			leaseContract = new LeaseContractAccessBean();
			leaseContract.setInitKey_leaseDocument(getLeaseContractcode().intValue());
			leaseContract.refreshCopyHelper();
		}
	}
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:56:14)
 * @return com.hps.july.persistence.ResourceAccessBean
 * @exception java.lang.Exception The exception description.
 */
private ResourceAccessBean constructResource() throws java.lang.Exception {
	if (resource == null) {
		if (!resourcecode.isEmpty() && resourcecode.isOk()) {
			resource = new ResourceAccessBean();
			resource.setInitKey_resource(resourcecode.getInteger().intValue());
			resource.refreshCopyHelper();
		}
	}
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	setIsCorrection(getDocposvid().equals("C") ? new Boolean(true) : new Boolean(false));
	LeaseChargesAccessBean abean = (LeaseChargesAccessBean)bean;
	try {
		LeaseContractAccessBean acontr = abean.getLeaseContract();
		setDocumentNumber(acontr.getDocumentNumber());
		setOrgCustomerContract(acontr.getOrgCustomer().getName());
		setOrgExecutorContract(acontr.getOrgExecutor().getName());
		setStartDate(acontr.getStartDate());
		setEndDate(acontr.getEndDate());
//		if (acontr.getCurrency1() != null) {
//		    setCostcurrency1(acontr.getSumm1().toString());
//		    setCurr1(acontr.getCurrency1().getShortname());
//		}
//		if (acontr.getCurrency2() != null) {
//		    setCostcurrency2(acontr.getSumm2().toString());
//		    setCurr2(acontr.getCurrency2().getShortname());
//		}
		setLeaseContractcode(new Integer(acontr.getLeaseDocument()));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	calsRateNds();
}
private String formatSalDate(){
	SimpleDateFormat ff = new SimpleDateFormat("dd.MM.yyyy");
	return ff.format(saldate);
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getBegindate() {
	return begindate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getBegindateFrm() {
	return begindate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.03.2003 15:43:17)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getBilldate() {
	return billdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (03.03.2003 15:43:17)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getBilldateFrm() {
	return billdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2003 10:36:51)
 * @return java.lang.String
 */
public java.lang.String getBillnumber() {
	return billnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 15:14:34)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getByhandraterur() {
	return byhandraterur;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 16:22:24)
 * @return java.lang.String
 */
public java.lang.String getCalctype() {
	return calctype;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 17:14:54)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency1() {
	return costcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 17:14:54)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency2() {
	return costcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 14:47:06)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:11:27)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
public java.util.Enumeration getCurrencies() {
	/*	
		try {
			LeaseContractAccessBean bean = new LeaseContractAccessBean();
			bean.setInitKey_leaseDocument(getLeaseContractcode().intValue());
			bean.refreshCopyHelper();
			
			java.util.Vector v = new java.util.Vector();
			v.addElement(bean.getCurrency1());
			
			if (bean.getCurrency2() != null && bean.getCurrency1().getCurrency() != bean.getCurrency2().getCurrency()) {
				v.addElement(bean.getCurrency2());
			}
	
			// Always add RUR code if it is not there
			int rurCode = AppUtils.getNamedValueInt(AppUtils.RUR_CODE);
			if ( !(( (bean.getCurrency1Key() != null) && (bean.getCurrency1Key().currency == rurCode) ) ||
				 ( (bean.getCurrency2Key() != null) && (bean.getCurrency2Key().currency == rurCode) ) ) ) {
					CurrencyAccessBean cBean = new CurrencyAccessBean();
					cBean.setInitKey_currency(rurCode);
					cBean.refreshCopyHelper();
					v.addElement(cBean);
			}
			
			return v.elements();
		} catch(Exception e) {
			e.printStackTrace();
			return (new java.util.Vector()).elements();	
		}
	*/
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch (Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 15:32:41)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getCurrency() throws Exception {
	CurrencyAccessBean bean = constructCurrency();
	if (bean != null)
		return (Currency) bean.getEJBRef();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:32:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrencycode() {
	return currencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	setRemaindersum(getSumm());
	LeaseChargesAccessBean bean = new LeaseChargesAccessBean();
	bean.setInitKey_leaseDocPosition(getLeaseDocPosition());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:58:23)
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:58:23)
 * @return java.sql.Date
 */
public String getDateFrm() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:47:41)
 * @return java.lang.String
 */
public java.lang.String getDocposvid() {
	return docposvid;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 15:38:36)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Используеться тагом "canedit" для разрешения просмотра(редактирования) полей и пр.
 * Creation date: (12.04.2004 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEnddate() {
	return enddate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEndDate() {
	return endDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEnddateFrm() {
	return enddate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.03.2003 11:28:11)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsCorrection() {
	return isCorrection;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:05:33)
 * @return com.hps.july.persistence.LeaseContractAccessBean
 */
public com.hps.july.persistence.LeaseContract getLeaseContract() throws Exception {
    LeaseContractAccessBean bean = constructLeaseContract();
    if (bean != null) {
        return (LeaseContract) bean.getEJBRef();
    } else {
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:07:34)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseContractcode() {
	return leaseContractcode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:55:00)
 * @return int
 */
public int getLeaseDocPosition() {
	return leaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2004 14:37:42)
 * @return java.lang.String
 */
public java.lang.String getMainPosition() {
	return mainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2004 15:26:59)
 */
public java.math.BigDecimal getNdsRate() {
	return ndsRate.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2004 15:27:33)
 */
public String getNdsRateFrm() {
	return ndsRate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 12:33:54)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomerContract() {
	return orgCustomerContract;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 12:33:54)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutorContract() {
	return orgExecutorContract;
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 12:18:15)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getRemainderrate2rur() {
	return getByhandraterur().booleanValue() ? remainderrate2rur.getBigDecimal() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 12:18:15)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getRemainderrate2rurFrm() {
	return remainderrate2rur.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 15:10:50)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getRemaindersum() {
	return remaindersum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 15:10:50)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getRemaindersumFrm() {
	return remaindersum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @return com.hps.july.persistence.ResourceAccessBean
 */
public Resource getResource() throws Exception {
    ResourceAccessBean bean = constructResource();
    if (bean != null)
        return (Resource) bean.getEJBRef();
    else
        return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getResourcecode() {
	return resourcecode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getResourcecodeFrm() {
	return resourcecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:47:54)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public java.util.Enumeration getResources() {
	try {
		java.util.Vector v = new java.util.Vector();
		v.addElement(getLeaseContractcode());
		
		Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(getLeaseContractcode(), new Boolean(false), null,
			new Boolean(false), null, new Integer(1));
		while (e.hasMoreElements()) {
			LeaseArendaAgreementNewAccessBean laanBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			v.addElement(new Integer(laanBean.getLeaseDocument()));
		}
		
		return new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:22:20)
 * @return java.lang.String
 */
public java.lang.String getSource() {
	return source;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartDate() {
	return startDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getStartDateFrm() {
	return startDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHARGE_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:34:24)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm() {
	return summ.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:34:24)
 * @return java.math.BigDecimal
 */
public String getSummFrm() {
	return summ.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:43:41)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumnds() {
	return sumnds.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:43:41)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumndsFrm() {
	return sumnds.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	ChargesListForm form = (ChargesListForm) request.getSession().getAttribute(listForm);
	if (form != null) {
		setMainPosition(form.getMainPosition());
		setDocumentNumber(form.getDocumentNumber());
		setOrgCustomerContract(form.getOrgCustomer());
		setOrgExecutorContract(form.getOrgExecutor());
		setStartDate(form.getStartDate());
		setEndDate(form.getEndDate());
		if (form.getCurrency1() != null) {
			setCostcurrency1(form.getCurrency1().toString());
			setCurr1(form.getCurr1());
		}
		if (form.getCurrency2() != null) {
			setCostcurrency2(form.getCurrency2().toString());
			setCurr2(form.getCurr2());
		}
		setLeaseContractcode(new Integer(form.getLeaseContract()));
	}
	// For NDS calculation in form
	java.math.BigDecimal aval =
		com.hps.july.util.AppUtils.getNamedValueBigDecimal(com.hps.july.util.AppUtils.DEFAULT_RATE_NDS);
	setNdsRate(aval);
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setDate(null);
	setBegindate(null);
	setEnddate(null);
	setIsCorrection(new Boolean(false));
}
public static boolean isInAct(int charge)
{
	boolean result = false;
	try {
		LeaseDocPositionAccessBean p = new LeaseDocPositionAccessBean();
		p.setInitKey_leaseDocPosition(charge);
		p.refreshCopyHelper();
		result = (p.getUsedinact() != null);
		p = null;
	} catch(javax.ejb.ObjectNotFoundException onf) {
		System.out.println("IS_IN_ACT: NotFound by "+charge);
	} catch(Exception e) {
		System.out.println("IS_IN_ACT: Exception "+e.getClass().getName());
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBegindate(Date newBegindate) {
	begindate.setSqlDate(newBegindate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBegindateFrm(String newBegindate) {
	begindate.setString(newBegindate);
}
/**
 * Insert the method's description here.
 * Creation date: (03.03.2003 15:43:17)
 * @param newBilldate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBilldate(Date newBilldate) {
	billdate.setSqlDate(newBilldate);
}
/**
 * Insert the method's description here.
 * Creation date: (03.03.2003 15:43:17)
 * @param newBilldate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBilldateFrm(String newBilldate) {
	billdate.setString(newBilldate);
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2003 10:36:51)
 * @param newBillnumber java.lang.String
 */
public void setBillnumber(java.lang.String newBillnumber) {
	billnumber = newBillnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 15:14:34)
 * @param newByhandraterur java.lang.Boolean
 */
public void setByhandraterur(java.lang.Boolean newByhandraterur) {
	byhandraterur = newByhandraterur;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 16:22:24)
 * @param newCalctype java.lang.String
 */
public void setCalctype(java.lang.String newCalctype) {
	calctype = newCalctype;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 17:14:54)
 * @param newCostcurrency1 java.lang.String
 */
public void setCostcurrency1(java.lang.String newCostcurrency1) {
	costcurrency1 = newCostcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 17:14:54)
 * @param newCostcurrency2 java.lang.String
 */
public void setCostcurrency2(java.lang.String newCostcurrency2) {
	costcurrency2 = newCostcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 14:47:06)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:11:27)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 15:32:41)
 * @param newCurency com.hps.july.persistence.CurrencyAccessBean
 */
public void setCurrency(com.hps.july.persistence.CurrencyAccessBean newCurrency) throws Exception {
	if (newCurrency == null) {
		currencycode = new Integer(0);
	}
	else {
		currencycode = new Integer(newCurrency.getCurrency());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:32:59)
 * @param newCurrencycode java.lang.Integer
 */
public void setCurrencycode(java.lang.Integer newCurrencycode) {
	currencycode = newCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:58:23)
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:58:23)
 * @param newDate java.sql.Date
 */
public void setDateFrm(String newDate) {
	date.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:47:41)
 * @param newDocposvid java.lang.String
 */
public void setDocposvid(java.lang.String newDocposvid) {
	docposvid = newDocposvid;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 15:38:36)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEnddate(Date newEndDate) {
	enddate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDate(Date newEndDate) {
	endDate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEnddateFrm(String newEndDate) {
	enddate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (03.03.2003 11:28:11)
 * @param newIsCorrection java.lang.Boolean
 */
public void setIsCorrection(java.lang.Boolean newIsCorrection) {
	isCorrection = newIsCorrection;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:05:33)
 * @param newLeaseContract com.hps.july.persistence.LeaseContractAccessBean
 */
public void setLeaseContract(com.hps.july.persistence.LeaseContractAccessBean newLeaseContract) throws Exception {
    if (newLeaseContract == null) {
		leaseContractcode = null;
    } else {
        leaseContractcode = new Integer(newLeaseContract.getLeaseDocument());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:07:34)
 * @param newLeaseContractcode java.lang.Integer
 */
public void setLeaseContractcode(java.lang.Integer newLeaseContractcode) {
	leaseContractcode = newLeaseContractcode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:55:00)
 * @param newLeaseDocPosition int
 */
public void setLeaseDocPosition(int newLeaseDocPosition) {
	leaseDocPosition = newLeaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2004 14:37:42)
 * @param newMainPosition java.lang.String
 */
public void setMainPosition(java.lang.String newMainPosition) {
	mainPosition = newMainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2004 15:28:48)
 */
public void setNdsRate(java.math.BigDecimal newNdsRate) {
	ndsRate.setBigDecimal(newNdsRate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2004 15:29:31)
 */
public void setNdsRateFrm(String newNdsRateStr) {
	ndsRate.setString(newNdsRateStr);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 12:33:54)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomerContract(java.lang.String newOrgCustomerContract) {
	orgCustomerContract = newOrgCustomerContract;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 12:33:54)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutorContract(java.lang.String newOrgExecutorContract) {
	orgExecutorContract = newOrgExecutorContract;
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 12:18:15)
 * @param newRemainderrate2rur com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRemainderrate2rur(BigDecimal newRemainderrate2rur) {
	remainderrate2rur.setBigDecimal(newRemainderrate2rur);
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 12:18:15)
 * @param newRemainderrate2rur com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRemainderrate2rurFrm(String newRemainderrate2rur) {
	remainderrate2rur.setString(newRemainderrate2rur);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 15:10:50)
 * @param newRemaindersum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRemaindersum(BigDecimal newRemaindersum) {
	remaindersum.setBigDecimal(newRemaindersum);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 15:10:50)
 * @param newRemaindersum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRemaindersumFrm(String newRemaindersum) {
	remaindersum.setString(newRemaindersum);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @param newResource com.hps.july.persistence.ResourceAccessBean
 */
public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) throws Exception {
    if (newResource == null) {
        resourcecode.setInteger(null);
        resourcename = "";
    } else {
        resourcecode.setInteger(new Integer(newResource.getResource()));
        resourcename = newResource.getName();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @param newResourcecode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setResourcecode(Integer newResourcecode) {
	resourcecode.setInteger(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @param newResourcecode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setResourcecodeFrm(String newResourcecode) {
	resourcecode.setString(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:47:54)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:22:20)
 * @param newSource java.lang.String
 */
public void setSource(java.lang.String newSource) {
	source = newSource;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDate(Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDateFrm(String newStartDate) {
	startDate.setString(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:34:24)
 * @param newSum java.math.BigDecimal
 */
public void setSumm(BigDecimal newSum) {
	summ.setBigDecimal(newSum);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:34:24)
 * @param newSum java.math.BigDecimal
 */
public void setSummFrm(String newSum) {
	summ.setString(newSum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:43:41)
 * @param newNdSum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumnds(BigDecimal newNdSum) {
	sumnds.setBigDecimal(newNdSum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:43:41)
 * @param newNdSum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumndsFrm(String newNdSum) {
	sumnds.setString(newNdSum);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {

	//Рассчитываем НДС
	if (getCalctype().equals("N")) {
		if (summ.isOkAndNotEmpty() 
			&& !begindate.isEmpty() 
			&& !(summ.getBigDecimal().doubleValue() <= 0)) {
				setSumnds(new ArendaDocumentTransactionMethodAccessBean().calcNds(
					getResourcecode(), getBegindate(), getSumm(), "1"));
		} else {
			if (summ.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.sum2"));
			} else if (!summ.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.sum2"));
			} else if (summ.getBigDecimal().doubleValue() <= 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.sum.sign2"));
			}
			if(begindate.isEmpty()){
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.begindate.empty"));
			}
		}
		throw new ValidationException();
	}
	
	if (date.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.date"));
	} else if (!date.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.date"));
	}

	boolean isBegin = false, isEnd = false;
	
	if (begindate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.begindate"));
	} else if (!begindate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.begindate"));
	} else isBegin = true;
	
	if (enddate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.enddate"));
	} else if (!enddate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.enddate"));
	} else isEnd = true;
	
	if (isBegin && isEnd && enddate.getSqlDate().compareTo(begindate.getSqlDate()) < 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.dates"));
	}
	
	if (resourcecode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.resource"));
	} else if (!resourcecode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.resource"));
	} else {
		try {
			constructResource();
		} catch (Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.resource"));
			}
		}
	}
	
	if (summ.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.sum"));
	} else if (!summ.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.sum"));
	} else if (summ.getBigDecimal().doubleValue() <= 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.sum.sign"));
	}
	
	if (currencycode == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.currency"));
	} else {
		try {
			constructCurrency();
		} catch(Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.currency"));
			}
		}
	}
	
	if (sumnds.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.ndsum"));
	} else if (!sumnds.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.ndsum"));
	} else if(sumnds.getBigDecimal().compareTo(new BigDecimal(0)) < 0){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.ndsum2"));
	}
	
	if (getByhandraterur().booleanValue()) {
		if (remainderrate2rur.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.rate"));
		} else if (!remainderrate2rur.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.rate"));
		} else if(remainderrate2rur.getBigDecimal().compareTo(new BigDecimal(0)) < 0){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.rate2"));
		}
	}

	////1
	
	if (!((getSource().equals("M") || getSource().equals("A")) && getDocposvid().equals("N"))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.source"));
	}
	
	if (getSource().equals("B") || getSource().equals("P") || 
		getDocposvid().equals("Q") || getDocposvid().equals("K") || getDocposvid().equals("Z")) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.wrong"));
	}
	
	if (!getAction().equals("Add") && !checkLink2Pay()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.haspay"));
	}
	
	if (getState() == APPStates.CHARGE_EDIT || getState() == APPStates.HISTORY_CHARGE_EDIT) {
		if (!getIsCorrection().booleanValue()) {
			Enumeration e = new LeaseArendaAgreementNewAccessBean().findByContractAndResource(getLeaseContractcode(), 
				getResourcecode(), new Integer(2));
			if (e.hasMoreElements()) {
				LeaseArendaAgreementNewAccessBean laanBeen = (LeaseArendaAgreementNewAccessBean) e.nextElement();
				
				LeaseChargeRuleAccessBean lcrBean = null;
				int i = 0;
				
				Enumeration n = new LeaseChargeRuleAccessBean().findByLeaseDocumentAndResource(getLeaseContractcode(), getResourcecode(),
					new Integer(1));
				while (n.hasMoreElements()) {
					lcrBean = (LeaseChargeRuleAccessBean) n.nextElement();
					i++;
				}
				
				switch (i) {
					case 0: 
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.hasnochargerule"));
						break;
					case 1: 
						if (lcrBean.getChargeDateRule().equals("S")) {
							setDate(getBegindate());
						} else if (lcrBean.getChargeDateRule().equals("E")) {
							setDate(getEnddate());
						}
						break;
					default: errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.hasmuchchargerule"));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.hasnochargerule"));
			}
		}
	} else {
		setDate(getEnddate());
	}
	///2
	/* Вместо этой проверки сделать проверку по UsedInAct
	if (!date.isEmpty() && date.isOk() && !checkOpenPeriod()) {
		
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
			"error.charge.notopenperiod2", formatSalDate()));
	}
	*/
	if(isInAct(getLeaseDocPosition())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.applied"));
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
	
	setDocposvid(getIsCorrection().booleanValue() ? "C" : "N");
}
}
