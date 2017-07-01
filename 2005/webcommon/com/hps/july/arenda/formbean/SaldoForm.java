package com.hps.july.arenda.formbean;

import com.hps.july.arenda.sessionbean.*;
import com.ibm.ivj.ejb.runtime.*;
import java.util.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import java.math.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.Date;
import com.hps.july.persistence.Currency;
/**
 * Bean-form
 * Форма "сальдо".
 * Creation date: (23.12.2002 13:09:52)
 * @author: Sergey Gourov
 */
public class SaldoForm extends com.hps.july.web.util.EditForm {
	private java.lang.Integer leaseContract;
	private com.hps.july.web.util.StringAndSqlDateProperty salDate;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private int resourcecode;
	private com.hps.july.persistence.CurrencyAccessBean maincurrency;
	private int maincurrencycode;
	private StringAndBigDecimal mainsum;
	private StringAndBigDecimal mainndssum;
	private com.hps.july.persistence.CurrencyAccessBean additionalcurrency;
	private int additionalcurrencycode;
	private StringAndBigDecimal additionalsum;
	private StringAndBigDecimal additionalndssum;
	private java.lang.String documentNumber;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private StringAndBigDecimalProperty currency1;
	private StringAndBigDecimalProperty currency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
	protected java.lang.String listForm;
	private java.lang.Boolean isAdd;
	private java.lang.String calctype;

	/* Поля добавленные по требованию Борцова */
	private String notes;
	private StringAndBigDecimal msumcalc;
	private StringAndBigDecimal mndscalc;
	private StringAndBigDecimal asumcalc;
	private StringAndBigDecimal andscalc;
	private StringAndInteger operator;
	private String operatorName;
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:29:44)
 */
public SaldoForm() {
	super();
	salDate = new StringAndSqlDateProperty();
	mainsum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	mainndssum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	additionalsum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	additionalndssum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	startDate = new StringAndSqlDateProperty();
	endDate = new StringAndSqlDateProperty();
	currency1 = new StringAndBigDecimalProperty();
	currency2 = new StringAndBigDecimalProperty();
	setIsAdd(new Boolean(false));
	listForm = "SaldoListForm";

	notes = "";
	msumcalc = new StringAndBigDecimal(15,2);
	mndscalc = new StringAndBigDecimal(15,2);
	asumcalc = new StringAndBigDecimal(15,2);
	andscalc = new StringAndBigDecimal(15,2);
	operator = new StringAndInteger();

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,javax.servlet.http.HttpServletRequest request) throws Exception {
	if (isInitialSaldo()) {
		Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(getLeaseContract(), new Integer(getResourcecode()));
		if (e.hasMoreElements()) {
			LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) e.nextElement();
			
			if (lsBean.getSalDate().compareTo(getSalDate()) > 0) {
				throw new UpdateValidationException("error.saldo.notdelete");
			}
		}
		
		LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) getDataBean(null);
		lsBean.refreshCopyHelper();
		
		if (lsBean.getAct() != null) {
			throw new UpdateValidationException("error.saldo.hasact.notdelete");
		}		
	} else {
		throw new UpdateValidationException("error.saldo.notinitial");
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	LeaseSaldoAccessBean saldo = (LeaseSaldoAccessBean)bean;
	// set operator on every action
	String login = request.getRemoteUser();
	try {
		OperatorAccessBean ab = (new OperatorAccessBean()).findByLogin(login);
		saldo.setOperator(new Integer(ab.getOperator()));
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.saldo.cannotsetuser");
	}
	saldo.setNotes(getNotes());
	try {
		double msumcalcv = (msumcalc.getBigDecimal() != null)?msumcalc.getBigDecimal().doubleValue():0.0d;
		double mndscalcv = (mndscalc.getBigDecimal() != null)?mndscalc.getBigDecimal().doubleValue():0.0d;
		double asumcalcv = (asumcalc.getBigDecimal() != null)?asumcalc.getBigDecimal().doubleValue():0.0d;
		double andscalcv = (mndscalc.getBigDecimal() != null)?mndscalc.getBigDecimal().doubleValue():0.0d;
		
		double msumv = (mainsum.getBigDecimal() != null)?mainsum.getBigDecimal().doubleValue():0.0d;
		double mndsv = (mainndssum.getBigDecimal() != null)?mainndssum.getBigDecimal().doubleValue():0.0d;
		double asumv = (additionalsum.getBigDecimal() != null)?additionalsum.getBigDecimal().doubleValue():0.0d;
		double andsv = (additionalndssum.getBigDecimal() != null)?additionalndssum.getBigDecimal().doubleValue():0.0d;
		// Update manual correction
		if(msumcalcv != msumv) {
			saldo.setSaldobyhand(true);
		}
		if(mndscalcv != mndsv) {
			saldo.setSaldobyhand(true);
		}
		if(asumcalcv != asumv) {
			saldo.setSaldobyhand(true);
		}
		if(andscalcv != andsv) {
			saldo.setSaldobyhand(true);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
//	if(saldo.getSaldobyhand()) {
//		if(notes == null || "".equals(notes)) {
//			throw new UpdateValidationException("error.saldo.nonotes");
//		}
//	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructAdditionalcurrency() throws java.lang.Exception {
	if (additionalcurrency == null) {
		if (getAdditionalcurrencycode() != 0) {
			additionalcurrency = new CurrencyAccessBean();
			additionalcurrency.setInitKey_currency(getAdditionalcurrencycode());
			additionalcurrency.refreshCopyHelper();
		}
	}
	return additionalcurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:09:52)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {

/* @param argLeaseContract java.lang.Integer
 * @param argSalDate java.sql.Date
 * @param argResource java.lang.Integer
 * @param argMainCurrency java.lang.Integer
 * @param argMainSum java.math.BigDecimal
 * @param argMainNdsSum java.math.BigDecimal
 * @param argIsTemp java.lang.Boolean*/
 
	return new LeaseSaldoAccessBean(getLeaseContract(), getSalDate(), new Integer(getResourcecode()), new Integer(getMaincurrencycode()),
		getMainsum(), getMainndssum(), new Boolean(false));
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructMaincurrency() throws java.lang.Exception {
	if (maincurrency == null) {
		if (getMaincurrencycode() != 0) {
			maincurrency = new CurrencyAccessBean();
			maincurrency.setInitKey_currency(getMaincurrencycode());
			maincurrency.refreshCopyHelper();
		}
	}
	return maincurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:56:14)
 * @return com.hps.july.persistence.ResourceAccessBean
 * @exception java.lang.Exception The exception description.
 */
private ResourceAccessBean constructResource() throws java.lang.Exception {
	if (resource == null) {
		if (resourcecode != 0) {
			resource = new ResourceAccessBean();
			resource.setInitKey_resource(resourcecode);
			resource.refreshCopyHelper();
		}
	}
	return resource;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		LeaseSaldoAccessBean saldo = (LeaseSaldoAccessBean)bean;
		Integer op = saldo.getOperator();
		OperatorAccessBean oper = new OperatorAccessBean();
		oper.setInitKey_operator(op.intValue());
		oper.refreshCopyHelper();
		operatorName = oper.getMan().getFullName();
	} catch(Exception e) {
		operatorName = "???";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getAdditionalcurrency() throws Exception {
	if (getAdditionalsum() != null || getAdditionalndssum() != null) {
		CurrencyAccessBean bean = constructAdditionalcurrency();
		return bean != null ? (Currency) bean.getEJBRef() : null;
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:38:37)
 * @return int
 */
public int getAdditionalcurrencycode() {
	return additionalcurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getAdditionalndssum() {
	return additionalndssum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getAdditionalndssumFrm() {
	return additionalndssum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getAdditionalsum() {
	return additionalsum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getAdditionalsumFrm() {
	return additionalsum.getString();
}
public String getAndscalcFrm() {
	return andscalc.getString();
}
public BigDecimal getAndscalcV() {
	return andscalc.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:09:52)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
public String getAsumcalcFrm() {
	return asumcalc.getString();
}
public BigDecimal getAsumcalcV() {
	return asumcalc.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 17:19:56)
 * @return java.lang.String
 */
public java.lang.String getCalctype() {
	return calctype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:13:17)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:13:17)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
public java.util.Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:19:48)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getCurrency1Frm() {
	return currency1.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:21:43)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getCurrency2Frm() {
	return currency2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:09:52)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseSaldoAccessBean bean = new LeaseSaldoAccessBean();
	bean.setInitKey_leaseContract(getLeaseContract());
	bean.setInitKey_resource_resource(new Integer(getResourcecode()));
	bean.setInitKey_SalDate(getSalDate());
	try {
		bean.refreshCopyHelper();
		setMsumcalcV(bean.getMsumcalc());
		setMndscalcV(bean.getMndscalc());
		setAsumcalcV(bean.getAsumcalc());
		setAndscalcV(bean.getAndscalc());
		if(bean.getAdditionalcurrency() == null) {
			setIsAdd(Boolean.FALSE);
		} else {
			setIsAdd(Boolean.TRUE);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}	
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:11:33)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
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
 * Creation date: (13.12.2002 14:56:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 12:18:38)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAdd() {
	return isAdd;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:13:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:29:04)
 * @return java.lang.String
 */
public java.lang.String getListForm() {
	return listForm;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getMaincurrency() throws Exception {
	CurrencyAccessBean bean = constructMaincurrency();
	return bean != null ? (Currency) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:14:58)
 * @return int
 */
public int getMaincurrencycode() {
	return maincurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:31:40)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getMainndssum() {
	return mainndssum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:31:40)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getMainndssumFrm() {
	return mainndssum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:24:34)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getMainsum() {
	return mainsum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:24:34)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getMainsumFrm() {
	return mainsum.getString();
}
public String getMndscalcFrm() {
	return mndscalc.getString();
}
public BigDecimal getMndscalcV() {
	return mndscalc.getBigDecimal();
}
public String getMsumcalcFrm() {
	return msumcalc.getString();
}
public BigDecimal getMsumcalcV() {
	return msumcalc.getBigDecimal();
}
public String getNotes() {
	return notes;
}
public Integer getOperator() {
	return operator.getInteger();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOperatorName() {
	return operatorName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:12:54)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:12:54)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @return com.hps.july.persistence.ResourceAccessBean
 */
public Resource getResource() throws Exception {
    ResourceAccessBean bean = constructResource();
    return bean != null ? (Resource) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 14:36:27)
 * @return int
 */
public int getResourcecode() {
	return resourcecode;
}
public java.util.Enumeration getResources() {
	try {
		Vector v = new Vector();
		v.addElement(getLeaseContract());
		return new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:14:30)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getSalDate() {
	return salDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:14:30)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getSalDateFrm() {
	return salDate.getString();
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
 * Creation date: (23.12.2002 13:09:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.SALDO_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    SaldoListForm form = (SaldoListForm) request.getSession().getAttribute(listForm);
    setDocumentNumber(form.getDocumentNumber());
    setOrgCustomer(form.getOrgCustomer());
    setOrgExecutor(form.getOrgExecutor());
    setStartDate(form.getStartDate());
    setEndDate(form.getEndDate());
	if (form.getCurrency1() != null) {
	    currency1.setBigDecimal(form.getCurrency1());
	    setCurr1(form.getCurr1());
	} else {
		currency1.setBigDecimal(null);
	}
	if (form.getCurrency2() != null) {
	    currency2.setBigDecimal(form.getCurrency2());
	    setCurr2(form.getCurr2());
	} else {
		currency2.setBigDecimal(null);
	}
	setLeaseContract(new Integer(form.getLeaseContract()));
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	LeaseContractAccessBean bean = new LeaseContractAccessBean();
	bean.setInitKey_leaseDocument(getLeaseContract().intValue());
	bean.refreshCopyHelper();
	
	GregorianCalendar c = new GregorianCalendar();
	c.setTime(bean.getStartDate());
	c.add(Calendar.DAY_OF_MONTH, -1);
	setSalDate(new Date(c.getTime().getTime()));

	setSum2Zero();

	String login = request.getRemoteUser();
	try {
		OperatorAccessBean ab = (new OperatorAccessBean()).findByLogin(login);
		operatorName = ab.getMan().getFullName();
	} catch(Exception e) {
		operatorName = "???";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 12:18:22)
 * @return boolean
 */
private boolean isInitialSaldo() {
	return true;
	/*try {
		LeaseContractAccessBean bean = new LeaseContractAccessBean();
		bean.setInitKey_leaseDocument(getLeaseContract().intValue());
		bean.refreshCopyHelper();
		
		if (bean.getContractType().equals("C")) {
			return true;
		}
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(bean.getStartDate());
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		if (getSalDate().compareTo(c.getTime()) == 0 && act == null) {
			return true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;*/
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @param newCurrency1 com.hps.july.persistence.CurrencyAccessBean
 */
public void setAdditionalcurrency(com.hps.july.persistence.CurrencyAccessBean newCurrency1) throws Exception {
    if (newCurrency1 == null) {
        additionalcurrencycode = 0;
    } else {
        additionalcurrencycode = newCurrency1.getCurrency();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:38:37)
 * @param newAdditionalcurrencycode int
 */
public void setAdditionalcurrencycode(int newAdditionalcurrencycode) {
	additionalcurrencycode = newAdditionalcurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @param newAdditionalndssum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setAdditionalndssum(BigDecimal newAdditionalndssum) {
	additionalndssum.setBigDecimal(newAdditionalndssum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @param newAdditionalndssum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setAdditionalndssumFrm(String newAdditionalndssum) {
	additionalndssum.setString(newAdditionalndssum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @param newAdditionalsum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setAdditionalsum(BigDecimal newAdditionalsum) {
	additionalsum.setBigDecimal(newAdditionalsum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:43:40)
 * @param newAdditionalsum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setAdditionalsumFrm(String newAdditionalsum) {
	additionalsum.setString(newAdditionalsum);
}
public void setAndscalcFrm(String newValue) {
	andscalc.setString(newValue);
}
public void setAndscalcV(BigDecimal newValue) {
	andscalc.setBigDecimal(newValue);
}
public void setAsumcalcFrm(String newValue) {
	asumcalc.setString(newValue);
}
public void setAsumcalcV(BigDecimal newValue) {
	asumcalc.setBigDecimal(newValue);
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 17:19:56)
 * @param newCalctype java.lang.String
 */
public void setCalctype(java.lang.String newCalctype) {
	calctype = newCalctype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:13:17)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:13:17)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:19:48)
 * @param newCurrency1 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setCurrency1Frm(String newCurrency1) {
	currency1.setString(newCurrency1);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:21:43)
 * @param newCurrency2 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setCurrency2Frm(String newCurrency2) {
	currency2.setString(newCurrency2);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:11:33)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
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
 * Creation date: (13.12.2002 14:56:33)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 12:18:38)
 * @param newIsAdd java.lang.Boolean
 */
public void setIsAdd(java.lang.Boolean newIsAdd) {
	isAdd = newIsAdd;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:13:35)
 * @param newLeaseContract java.lang.Integer
 */
public void setLeaseContract(java.lang.Integer newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:29:04)
 * @param newListForm java.lang.String
 */
public void setListForm(java.lang.String newListForm) {
	listForm = newListForm;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @param newCurrency1 com.hps.july.persistence.CurrencyAccessBean
 */
public void setMaincurrency(com.hps.july.persistence.CurrencyAccessBean newCurrency1) throws Exception {
    if (newCurrency1 == null) {
        maincurrencycode = 0;
    } else {
        maincurrencycode = newCurrency1.getCurrency();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:14:58)
 * @param newMaincurrencycode int
 */
public void setMaincurrencycode(int newMaincurrencycode) {
	maincurrencycode = newMaincurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:31:40)
 * @param newMainndssum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setMainndssum(BigDecimal newMainndssum) {
	mainndssum.setBigDecimal(newMainndssum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:31:40)
 * @param newMainndssum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setMainndssumFrm(String newMainndssum) {
	mainndssum.setString(newMainndssum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:24:34)
 * @param newMainsum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setMainsum(BigDecimal newMainsum) {
	mainsum.setBigDecimal(newMainsum);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 15:24:34)
 * @param newMainsum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setMainsumFrm(String newMainsum) {
	mainsum.setString(newMainsum);
}
public void setMndscalcFrm(String newValue) {
	mndscalc.setString(newValue);
}
public void setMndscalcV(BigDecimal newValue) {
	mndscalc.setBigDecimal(newValue);
}
public void setMsumcalcFrm(String newValue) {
	msumcalc.setString(newValue);
}
public void setMsumcalcV(BigDecimal newValue) {
	msumcalc.setBigDecimal(newValue);
}
public void setNotes(String newValue) {
	notes = newValue;
}
public void setOperator(Integer newValue) {
	operator.setInteger(newValue);
}
/**
 * 
 * @param newOperatorName java.lang.String
 */
public void setOperatorName(java.lang.String newOperatorName) {
	operatorName = newOperatorName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:12:54)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:12:54)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @param newResource com.hps.july.persistence.ResourceAccessBean
 */
public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) throws Exception {
    if (newResource == null) {
        resourcecode = 0;
    } else {
        resourcecode = newResource.getResource();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 14:36:27)
 * @param newResourcecode int
 */
public void setResourcecode(int newResourcecode) {
	resourcecode = newResourcecode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:14:30)
 * @param newSalDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setSalDate(Date newSalDate) {
	salDate.setSqlDate(newSalDate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:14:30)
 * @param newSalDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setSalDateFrm(String newSalDate) {
	salDate.setString(newSalDate);
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
protected void setSum2Zero() {
	setMainsum(new BigDecimal(0));
	setMainndssum(new BigDecimal(0));
	setAdditionalsum(new BigDecimal(0));
	setAdditionalndssum(new BigDecimal(0));
	setAndscalcFrm("");
	setMndscalcFrm("");
	setAsumcalcFrm("");
	setMsumcalcFrm("");
	setNotes("");
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (getCalctype().equals("N")) {
		if (getSalDate() != null && getMainsum() != null && getResourcecode() != 0) {
			setMainndssum(new ArendaDocumentTransactionMethodAccessBean().calcNds(new Integer(getResourcecode()), getSalDate(), getMainsum(), "1"));
		}
		throw new ValidationException();
	}
	
	if (getCalctype().equals("NA")) {
		if (getIsAdd().booleanValue() && getSalDate() != null && getAdditionalsum() != null && getResourcecode() != 0) {
			setAdditionalndssum(new ArendaDocumentTransactionMethodAccessBean().calcNds(new Integer(getResourcecode()), getSalDate(), getAdditionalsum(), "1"));
		}
		throw new ValidationException();
	}

	
	if (isInitialSaldo()) {
	
		if (salDate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.saldo.saldate"));
		}
		
		boolean[] v = new boolean[4];
		boolean[] b = new boolean[4];
		
		if (mainsum.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.saldo.mainsum"));
		} else if (!mainsum.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.saldo.mainsum"));
		} else {
			if (mainsum.getBigDecimal().signum() == -1) {
				b[0] = true;
			} else if (mainsum.getBigDecimal().signum() == 1) {
				v[0] = true;
				b[0] = true;
			}
		}
		
		if (!additionalsum.isEmpty()) {
			if (!additionalsum.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.saldo.addsum"));
			} else {
				if (additionalsum.getBigDecimal().signum() == -1) {
					b[1] = true;
				} else if (additionalsum.getBigDecimal().signum() == 1) {
					v[1] = true;
					b[1] = true;
				}
			}
		}
		
		if (mainndssum.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.saldo.mainndssum"));
		} else if (!mainndssum.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.saldo.mainndssum"));
		} else {
			if (mainndssum.getBigDecimal().signum() == -1) {
				b[2] = true;
			} else if (mainndssum.getBigDecimal().signum() == 1) {
				v[2] = true;
				b[2] = true;
			}
		}
		
		if (!additionalndssum.isEmpty()) {
			if (!additionalndssum.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.saldo.addndssum"));
			} else {
				if (additionalndssum.getBigDecimal().signum() == -1) {
					b[3] = true;
				} else if (additionalndssum.getBigDecimal().signum() == 1) {
					v[3] = true;
					b[3] = true;
				}
			}
		}
		
		Vector vector = new Vector();
		for (int i = 0; i < 4; ++i) {
			if (b[i]) {
				vector.addElement(new Boolean(v[i]));
			}
		}
		
		for (int i = 0; i < vector.size() - 1; i++) {
			if (((Boolean) vector.elementAt(i)).booleanValue() != ((Boolean) vector.elementAt(i + 1)).booleanValue()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.sign"));
				break;
			}
		}
		
		if ((!additionalsum.isEmpty() && additionalndssum.isEmpty()) ||(additionalsum.isEmpty() && !additionalndssum.isEmpty())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.needadd"));
		}
		
		if (!additionalsum.isEmpty() || !additionalndssum.isEmpty()) {
			// одна из валют должна быть рубль
			NamedValueAccessBean namedValue = new NamedValueAccessBean();
			namedValue.setInitKey_id("BASE_CURRENCY_ARENDA");
			namedValue.refreshCopyHelper();
			
			if ((getMaincurrencycode() != namedValue.getIntvalue() && getAdditionalcurrencycode() != namedValue.getIntvalue()) ||
				getMaincurrencycode() == getAdditionalcurrencycode()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.onerur"));
			}
		}

		boolean saldoByAct = false;

		/*
			Определяем создано ли сальдо по акту (потом пригодится)
		*/	
		if ("Edit".equals(getAction())) {
			LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) getDataBean(null);
			lsBean.refreshCopyHelper();
			
			if (lsBean.getAct() != null) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.hasact.notedit"));
				saldoByAct = true;
			}
		}
		
		/*
			Производится проверка на возможность редактировать сальдо.
			Любое последнее сальдо редактировать можно.
		*/
		if (getAction().equals("Add")) {
			Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(getLeaseContract(), new Integer(getResourcecode()));
			if (e.hasMoreElements()) {
				LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) e.nextElement();
				if(lsBean.getSalDate().compareTo(getSalDate()) > 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.notadd"));
				}
			}
		} else if(getAction().equals("Edit")) {
			Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(getLeaseContract(), new Integer(getResourcecode()));
			if (e.hasMoreElements()) {
				LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) e.nextElement();
				if (lsBean.getSalDate().compareTo(getSalDate()) > 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.notedit"));
				}
//				if(!saldoByAct && lsBean.getSalDate().compareTo(getSalDate()) == 0) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.hasact.notedit"));
//				}
			}
		}
		
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.notinitial"));
	}

	// Manual correction flag
	// @TODO: move this code to some another place and use it here and at beforeUpdate!!!
	boolean byh = false;
	try {
		double msumcalcv = (msumcalc.getBigDecimal() != null)?msumcalc.getBigDecimal().doubleValue():0.0d;
		double mndscalcv = (mndscalc.getBigDecimal() != null)?mndscalc.getBigDecimal().doubleValue():0.0d;
		double asumcalcv = (asumcalc.getBigDecimal() != null)?asumcalc.getBigDecimal().doubleValue():0.0d;
		double andscalcv = (mndscalc.getBigDecimal() != null)?mndscalc.getBigDecimal().doubleValue():0.0d;
		
		double msumv = (mainsum.getBigDecimal() != null)?mainsum.getBigDecimal().doubleValue():0.0d;
		double mndsv = (mainndssum.getBigDecimal() != null)?mainndssum.getBigDecimal().doubleValue():0.0d;
		double asumv = (additionalsum.getBigDecimal() != null)?additionalsum.getBigDecimal().doubleValue():0.0d;
		double andsv = (additionalndssum.getBigDecimal() != null)?additionalndssum.getBigDecimal().doubleValue():0.0d;
		// Update manual correction
		if(msumcalcv != msumv) { byh = true; }
		if(mndscalcv != mndsv) { byh = true; }
		if(asumcalcv != asumv) { byh = true; }
		if(andscalcv != andsv) { byh = true; }
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	if(byh &&(notes == null || "".equals(notes))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.saldo.nonotes"));
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
