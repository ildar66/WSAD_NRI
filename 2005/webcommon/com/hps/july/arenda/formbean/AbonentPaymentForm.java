package com.hps.july.arenda.formbean;

import com.hps.july.platinum.sessionbean.*;
import com.hps.july.arenda.sessionbean.*;
import java.util.Enumeration;
import org.apache.struts.action.*;
import com.hps.july.commonbean.*;
import com.ibm.ivj.ejb.runtime.*;
import java.sql.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.math.*;
import com.hps.july.arenda.*;
import com.hps.july.jdbcpersistence.lib.*;
/**
 * Form-Bean 
 * "абонентские оплаты".
 */
public class AbonentPaymentForm
	extends com.hps.july.web.util.EditForm
{
	private String costcurrency1;
	private String costcurrency2;
	private String curr1;
	private String curr2;
	private Integer currencycode;
	private CurrencyAccessBean currency;
	private StringAndSqlDateProperty date;
	private String documentNumber;
	private StringAndSqlDateProperty documentDate;
	private String docNumber;
	private StringAndSqlDateProperty endDate;
	private LeaseContractAccessBean leaseContract;
	private Integer leaseContractcode;
	private int leaseDocPosition;
	private StringAndBigDecimal sumnds;
	private String orgCustomerContract;
	private String orgExecutorContract;
	private String paymentstate;
	private String paymentType;
	private String source;
	private StringAndSqlDateProperty startDate;
	private StringAndBigDecimal summ;
	protected StringAndBigDecimal sumRub;
	private String docposvid;
	private StringAndSqlDateProperty begindate;
	private StringAndSqlDateProperty enddate;
	private ResourceAccessBean resource;
	private int resourcecode;
	private StringAndBigDecimal payrate;
	private StringAndBigDecimal ndsRub;
	private LeaseMutualActNewAccessBean act;
	private int actcode;
	private String calctype;
	private StringAndSqlDateProperty ratedate;
	private StringAndSqlDateProperty ratedatecalc;
	private int rur;
	private int fromcalc;
	private Date saldate = null;
	private String stateOfContract;
	private String ratecalcrule;
	private java.math.BigDecimal ratedelta;
	private Integer ratecalcruleday;
	private Integer usedinactcode;

	private String calcNdsRate;
	private String positionName;
	private StringAndBigDecimalProperty ndsRate;

	protected java.lang.String listForm;
	//Признак оплаты НДС:
	private Boolean flagOplNds = null;	
	
public AbonentPaymentForm() {
	super();
	listForm = "AbonentPaymentsListForm";

	date = new StringAndSqlDateProperty();
	endDate = new StringAndSqlDateProperty();
	documentDate = new StringAndSqlDateProperty();
	sumnds = new StringAndBigDecimal(15, 2);
	startDate = new StringAndSqlDateProperty();
	summ = new StringAndBigDecimal(15, 2);
	payrate = new StringAndBigDecimal(15, 4);
	sumRub = new StringAndBigDecimal(15, 2);
	ndsRub = new StringAndBigDecimal(15, 2);
	begindate = new StringAndSqlDateProperty();
	enddate = new StringAndSqlDateProperty();
	ratedate = new StringAndSqlDateProperty();
	ratedatecalc = new StringAndSqlDateProperty();

	setPaymentstate("G");
	setPaymentType("P");
	setSource("M");
	setDocposvid("N");

	ndsRate = new StringAndBigDecimalProperty();
	setFlagOplNds(Boolean.FALSE);
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {

	String payState;
	if(bean instanceof LeasePayOrderAccessBean){
		payState = ((LeasePayOrderAccessBean)bean).getPaymentstate();
	} else {
		payState = ((LeasePaymentAccessBean)bean).getPaymentstate();
	}
	
	if(!payState.equals("G"))
	{	//Разрешаем для удаления платежи в состоянии редактируется
		if (!checkOpenPeriod())
		{	//Проверяем, чтобы платеж небыл в открытом периоде
			throw new UpdateValidationException("error.payment.notopenperiod");
		}
	}
	
	if (!((getSource().equals("M") || getSource().equals("A")) && getDocposvid().equals("N"))) {
		throw new UpdateValidationException("error.invalid.payment.source");
	}

	if (!checkLink2Pay()) {
		throw new UpdateValidationException("error.payment.haspay");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	if (getCurrencycode().intValue() == getRur()) {
		LeasePaymentAccessBean lpBean = (LeasePaymentAccessBean) bean;
		lpBean.setSumRub(lpBean.getSumm());
		lpBean.setNdsRub(lpBean.getSumnds());
		lpBean.setPayrate(new BigDecimal(1));
	}
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
public boolean checkOpenPeriod() throws Exception { // scope "public" - use in jsp
	Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
		getLeaseContractcode(), new Integer(getResourcecode()));
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
		saldate = bean.getSalDate();
		return getDate().after(saldate) ? true : false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:20:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
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
 * @param argPaymentType java.lang.String
 * @param argPaymentState java.lang.String
 */

/*
	setSumnds(new ArendaDocumentProcessorAccessBean().calcNds(new Integer(getResourcecode()), getDate(), getSumm(), "1"));
	if (getSumRub() != null) {
		setNdsRub(new ArendaDocumentProcessorAccessBean().calcNds(new Integer(getResourcecode()), getDate(), getSumRub(), "1"));
	} else {
		setNdsRub(null);
	}
*/

	setLeaseDocPosition(new KeyGeneratorAccessBean().getNextKey("tables.leasedocpositions"));
	return 
		new LeasePaymentAccessBean(
			getLeaseDocPosition(),
			getDate(),
			getLeaseContractcode(),
			getSource(),
			getDocposvid(),
			getBegindate(),
			getEnddate(),
			new Integer(getResourcecode()),
			getSumm(),
			getCurrencycode(),
			getSumnds(),
			getPaymentType(),
			getPaymentstate()
		);
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
		if (resourcecode != 0) {
			resource = new ResourceAccessBean();
			resource.setInitKey_resource(resourcecode);
			resource.refreshCopyHelper();
		}
	}
	return resource;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	LeasePaymentAccessBean abean = null;
	LeasePayOrderAccessBean bbean = null;
	LeaseContractAccessBean acontr = null;
	if (bean instanceof LeasePaymentAccessBean) {
		abean = (LeasePaymentAccessBean)bean;
		try {
			acontr = abean.getLeaseContract();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} else if (bean instanceof LeasePayOrderAccessBean) {
		bbean = (LeasePayOrderAccessBean)bean;
		try {
			acontr = bbean.getLeaseContract();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	try {
		setLeaseContractcode(new Integer(acontr.getLeaseDocument()));
		setStateOfContract(acontr.getContractState());
	    setDocumentNumber(acontr.getDocumentNumber());
	    setDocumentDate(acontr.getDocumentDate());
	    setOrgCustomerContract(acontr.getOrgCustomer().getName());
	    setOrgExecutorContract(acontr.getOrgExecutor().getName());
	    setStartDate(acontr.getStartDate());
	    setEndDate(acontr.getEndDate());
//		if (acontr.getCurrency1() != null) {
//		    setCostcurrency1(acontr.getSumm1().toString());
//		    setCurr1(acontr.getCurrency1().getShortname());
//		} else {
//			setCostcurrency1("");
//			setCurr1("");
//		}
//		if (acontr.getCurrency2() != null) {
//		    setCostcurrency2(acontr.getSumm2().toString());
//		    setCurr2(acontr.getCurrency2().getShortname());
//		} else {
//			setCostcurrency2("");
//			setCurr2("");
//		}

		setRatecalcrule(acontr.getRatecalcrule());
		if(acontr.getRatecalcruleday() != null) {
			setRatecalcruleday(new Integer(acontr.getRatecalcruleday().intValue()));
		}
		setRatedelta(acontr.getRatedelta());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
public String findPositionName(int leaseDocument) {
	String result = "";
	try {
		//System.out.println("{:-} FindPositionName:"+leaseDocument);
		LeaseOnPositionAccessBean lopaf = new LeaseOnPositionAccessBean();
		Enumeration en = lopaf.findLeaseonpositionsByLeaseArendaAgreementNew(new LeaseDocumentKey(leaseDocument));
		//System.out.println("{:-} FindPositionName:EN:"+en.hasMoreElements());
		if(en.hasMoreElements()) {
			LeaseOnPositionAccessBean lopa = (LeaseOnPositionAccessBean)en.nextElement();
			//System.out.println("{:-} FindPositionName:LOPA:"+lopa);
			PositionAccessBean pos = lopa.getPosition();
			//System.out.println("{:-} FindPositionName:POS:"+pos);
			if(pos != null) {
				/*
				if(pos.getGsmid() != null) {
					result += "D"+pos.getGsmid()+" ";
				}
				if(pos.getDampsid() != null) {
					result += "A"+pos.getDampsid()+" ";
				}
				*/
				result += pos.getName();
			}
			//System.out.println("{:-} FindPositionName:RESULT:"+result);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		result = "";
	}
	return result;
}
//private String formatSalDate(){
//	SimpleDateFormat ff = new SimpleDateFormat("dd.MM.yyyy");
//	return ff.format(saldate);
//}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 16:25:15)
 * @return int
 */
public int getActcode() {
	return actcode;
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
 * Creation date: (17.12.2002 12:43:00)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getBegindate() {
	return begindate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:43:00)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getBegindateFrm() {
	return begindate.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCalcNdsRate() {
	return calcNdsRate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 16:08:47)
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
 * Creation date: (06.08.2002 15:23:48)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:24:02)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
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
 * Creation date: (13.02.2002 10:12:41)
 */
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeasePaymentAccessBean bean = new LeasePaymentAccessBean();
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
 * Creation date: (06.08.2002 19:39:22)
 * @return java.lang.String
 */
public java.lang.String getDocNumber() {
	return docNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:42:00)
 * @return java.lang.String
 */
public java.lang.String getDocposvid() {
	return docposvid;
}
public java.sql.Date getDocumentDate() {
	return documentDate.getSqlDate();
}
public java.lang.String getDocumentDateFrm() {
	return documentDate.getString();
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
 * RETURN:
 *   0 - No edit permitted. If payment is used in act
 *   1 - Edit all. If payment is not used in act and paymentstate = 'G' (Editing)
 *   2 - Edit partially (period and service_resource). If paymentstate != 'G' and payment is not used in act
 */
public int getEditState() {
	if(usedinactcode != null) {
		return 0;
	} else {
		if("G".equals(getPaymentstate())) {
			return 1;
		} else {
			return 2;
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:45:19)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEnddate() {
	return enddate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEndDate() {
	return endDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:45:19)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEnddateFrm() {
	return enddate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 15:00:46)
 * @return int
 */
public int getFromcalc() {
	return fromcalc;
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
 * Creation date: (13.01.2004 13:31:23)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdsRate() {
	return ndsRate.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2004 13:31:23)
 * @return java.math.BigDecimal
 */
public String getNdsRateFrm() {
	return ndsRate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:15:50)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getNdsRub() {
	return ndsRub.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:15:50)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getNdsRubFrm() {
	return ndsRub.getString();
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
 * Creation date: (25.07.2002 10:58:55)
 * @return java.lang.String
 */
public java.lang.String getPaymentstate() {
	return paymentstate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 10:37:33)
 * @return java.lang.String
 */
public java.lang.String getPaymentType() {
	return paymentType;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:10:06)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getPayrate() {
	return payrate.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:10:06)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getPayrateFrm() {
	return payrate.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionName() {
	return positionName;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 11:45:34)
 * @return java.lang.String
 */
public java.lang.String getRatecalcrule() {
	return ratecalcrule;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 11:48:22)
 * @return java.lang.Integer
 */
public java.lang.Integer getRatecalcruleday() {
	return ratecalcruleday;
}
public java.sql.Date getRatedate() {
	return ratedate.getSqlDate();
}
public java.sql.Date getRatedatecalc() {
	return ratedatecalc.getSqlDate();
}
public String getRatedatecalcFrm() {
	return ratedatecalc.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 17:59:15)
 * @return java.sql.Date
 */
public String getRatedateFrm() {
	return ratedate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 11:47:51)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRatedelta() {
	return ratedelta;
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
 * Creation date: (17.12.2002 12:51:11)
 * @return int
 */
public int getResourcecode() {
	return resourcecode;
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return (new ResourceAccessBean()).findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 14:50:41)
 * @return int
 */
public int getRur() {
	return rur;
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
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_PAYMENT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2003 14:28:15)
 * @return java.lang.String
 */
public java.lang.String getStateOfContract() {
	return stateOfContract;
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
 * Creation date: (25.07.2002 10:36:16)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumRub() {
	return sumRub.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 10:36:16)
 * @return java.math.BigDecimal
 */
public String getSumRubFrm() {
	return sumRub.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2003 16:14:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getUsedinactcode() {
	return usedinactcode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	try {
	    PaymentsListForm form = (PaymentsListForm) request.getSession().getAttribute(listForm);
	    if (form != null) {
			setStateOfContract(form.getStateOfContract());
		    setDocumentNumber(form.getDocumentNumber());
		    setDocumentDate(form.getDocumentDate());
		    setOrgCustomerContract(form.getOrgCustomer());
		    setOrgExecutorContract(form.getOrgExecutor());
		    setStartDate(form.getStartDate());
		    setEndDate(form.getEndDate());
			if (form.getCurrency1() != null) {
			    setCostcurrency1(form.getCurrency1().toString());
			    setCurr1(form.getCurr1());
			} else {
				setCostcurrency1("");
			}
			if (form.getCurrency2() != null) {
			    setCostcurrency2(form.getCurrency2().toString());
			    setCurr2(form.getCurr2());
			} else {
				setCostcurrency2("");
			}
			setLeaseContractcode(new Integer(form.getLeaseContract()));
			setPositionName(findPositionName(form.getLeaseContract()));
	    }
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	setRur(com.hps.july.util.AppUtils.getNamedValueInt("RUR"));

	// For NDS calculation in form
	java.math.BigDecimal aval = com.hps.july.util.AppUtils.getNamedValueBigDecimal(com.hps.july.util.AppUtils.DEFAULT_RATE_NDS);
	setCalcNdsRate(aval.toString());
	
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setDate(null);
	setBegindate(null);
	setEnddate(null);
	setFlagOplNds(Boolean.FALSE);

	try {
		LeaseContractAccessBean acontr = new LeaseContractAccessBean();
		acontr.setInitKey_leaseDocument(getLeaseContractcode().intValue());
		acontr.refreshCopyHelper();
		
		setRatecalcrule(acontr.getRatecalcrule());
		if (acontr.getRatecalcruleday() != null)
			setRatecalcruleday(new Integer(acontr.getRatecalcruleday().intValue()));
		setRatedelta(acontr.getRatedelta());
		setNdsRateFrm(getCalcNdsRate());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
public static boolean isInAct(int payment)
{
	boolean result = false;
	try {
		LeaseDocPositionAccessBean p = new LeaseDocPositionAccessBean ();
		p.setInitKey_leaseDocPosition(payment);
		p.refreshCopyHelper();
		result = (p.getUsedinact() != null);
		p = null;
	} catch(javax.ejb.ObjectNotFoundException onf) {
		System.out.println("IS IN ACT: NotFound by "+payment);
	} catch(Exception e) {
		System.out.println("IS IN ACT: Exception "+e.getClass().getName());
	}
	return result;
}
private boolean isSYNCNRIPLATINARENDA (){
	try {
		NamedValueAccessBean ab = new NamedValueAccessBean();
		ab.setInitKey_id("SYNCNRIPLATINARENDA");
		ab.refreshCopyHelper();
		return ab.getIntvalue() == 1;
	} catch (Exception e) {
		System.out.println("Error in UsPaymentForm.isSYNCNRIPLATINARENDA()");
		e.printStackTrace(System.out);
	}
	return false;
}
public void processCalcOptions(ActionErrors errors)
	throws java.lang.Exception
{
	if("N".equals(getCalctype())) {
		if(begindate.isEmpty()){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.begindate.empty"));
		} 
		if(summ.isEmpty()){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.sum.empty"));
		} else if (!summ.isOk()){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.sum.error"));
		}
		
		if (!begindate.isEmpty() && !summ.isEmpty() && summ.isOk()) {
			setSumnds(new ArendaDocumentTransactionMethodAccessBean().calcNds(new Integer(getResourcecode()), getBegindate(), getSumm(), "1"));
		}
		setFromcalc(1);
		throw new ValidationException();
	}
	if("NR".equals(getCalctype())) {
		if (getBegindate() != null && getSumRub() != null) {
			setNdsRub(new ArendaDocumentTransactionMethodAccessBean().calcNds(new Integer(getResourcecode()), getBegindate(), getSumRub(), "1"));
		}
		setFromcalc(1);
		throw new ValidationException();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 16:27:42)
 * @param newAct com.hps.july.persistence.LeaseMutualActNewAccessBean
 * @exception java.lang.Exception The exception description.
 */
public void setAct(LeaseMutualActNewAccessBean newAct) throws java.lang.Exception {
	try {
	    if (newAct == null) {
	        actcode = 0;
	    } else {
	        actcode = newAct.getLeaseDocument();
	    }
	} catch (Exception e) {
		e.printStackTrace(System.out);
	    actcode = 0;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 16:25:15)
 * @param newActcode int
 */
public void setActcode(int newActcode) {
	actcode = newActcode;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:43:00)
 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBegindate(Date newBegindate) {
	begindate.setSqlDate(newBegindate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:43:00)
 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBegindateFrm(String newBegindate) {
	begindate.setString(newBegindate);
}
/**
 * 
 * @param newCalcNdsRate java.lang.String
 */
public void setCalcNdsRate(java.lang.String newCalcNdsRate) {
	calcNdsRate = newCalcNdsRate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 16:08:47)
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
 * Creation date: (06.08.2002 15:23:48)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:24:02)
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
	try {
		if (newCurrency == null) {
			currencycode = new Integer(0);
		}
		else {
			currencycode = new Integer(newCurrency.getCurrency());
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
		currencycode = new Integer(0);
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
 * Creation date: (06.08.2002 19:39:22)
 * @param newDocNumber java.lang.String
 */
public void setDocNumber(java.lang.String newDocNumber) {
	docNumber = newDocNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:42:00)
 * @param newDocposvid java.lang.String
 */
public void setDocposvid(java.lang.String newDocposvid) {
	docposvid = newDocposvid;
}
public void setDocumentDate(java.sql.Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
public void setDocumentNumber(String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:45:19)
 * @param newEnddate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEnddate(Date newEnddate) {
	enddate.setSqlDate(newEnddate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDate(Date newEndDate) {
	endDate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:45:19)
 * @param newEnddate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEnddateFrm(String newEnddate) {
	enddate.setString(newEnddate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 15:00:46)
 * @param newFromcalc int
 */
public void setFromcalc(int newFromcalc) {
	fromcalc = newFromcalc;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:05:33)
 * @param newLeaseContract com.hps.july.persistence.LeaseContractAccessBean
 */
public void setLeaseContract(com.hps.july.persistence.LeaseContractAccessBean newLeaseContract) throws Exception {
	try {
	    if (newLeaseContract == null) {
			leaseContractcode = null;
	    } else {
	        leaseContractcode = new Integer(newLeaseContract.getLeaseDocument());
	    }
	} catch (Exception e) {
		e.printStackTrace(System.out);
		leaseContractcode = null;
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
 * Creation date: (13.01.2004 13:31:23)
 * @param newNdsRate java.math.BigDecimal
 */
public void setNdsRate(java.math.BigDecimal newNdsRate) {
	ndsRate.setBigDecimal(newNdsRate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2004 13:31:23)
 * @param newNdsRate String
 */
public void setNdsRateFrm(String newNdsRateStr) {
	ndsRate.setString(newNdsRateStr);
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:15:50)
 * @param newNdsRub com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setNdsRub(BigDecimal newNdsRub) {
	ndsRub.setBigDecimal(newNdsRub);
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:15:50)
 * @param newNdsRub com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setNdsRubFrm(String newNdsRub) {
	ndsRub.setString(newNdsRub);
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
 * Creation date: (25.07.2002 10:58:55)
 * @param newPaymentsState java.lang.String
 */
public void setPaymentstate(java.lang.String newPaymentsState) {
	paymentstate = newPaymentsState;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 10:37:33)
 * @param newPaymentType java.lang.String
 */
public void setPaymentType(java.lang.String newPaymentType) {
	paymentType = newPaymentType;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:10:06)
 * @param newPayrate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setPayrate(BigDecimal newPayrate) {
	payrate.setBigDecimal(newPayrate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 15:10:06)
 * @param newPayrate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setPayrateFrm(String newPayrate) {
	payrate.setString(newPayrate);
}
/**
 * 
 * @param newPositionName java.lang.String
 */
public void setPositionName(java.lang.String newPositionName) {
	positionName = newPositionName;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 11:45:34)
 * @param newRatecalcrule java.lang.String
 */
public void setRatecalcrule(java.lang.String newRatecalcrule) {
	ratecalcrule = newRatecalcrule;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 11:48:22)
 * @param newRatecalcruleday java.lang.Integer
 */
public void setRatecalcruleday(java.lang.Integer newRatecalcruleday) {
	ratecalcruleday = newRatecalcruleday;
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 17:59:15)
 * @param newRatedate java.sql.Date
 */
public void setRatedate(java.sql.Date newRatedate) {
	ratedate.setSqlDate(newRatedate);
}
public void setRatedatecalc(java.sql.Date newRatedate) {
	ratedatecalc.setSqlDate(newRatedate);
}
public void setRatedatecalcFrm(String newRatedate) {
	ratedatecalc.setString(newRatedate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 17:59:15)
 * @param newRatedate java.sql.Date
 */
public void setRatedateFrm(String newRatedate) {
	ratedate.setString(newRatedate);
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 11:47:51)
 * @param newRatedelta java.math.BigDecimal
 */
public void setRatedelta(java.math.BigDecimal newRatedelta) {
	ratedelta = newRatedelta;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @param newResource com.hps.july.persistence.ResourceAccessBean
 */
public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) throws Exception {
	try {
	    if (newResource == null) {
	        resourcecode = 0;
	    } else {
	        resourcecode = newResource.getResource();
	    }
	} catch (Exception e) {
		e.printStackTrace(System.out);
	    resourcecode = 0;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:51:11)
 * @param newResourcecode int
 */
public void setResourcecode(int newResourcecode) {
	resourcecode = newResourcecode;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 14:50:41)
 * @param newRur int
 */
public void setRur(int newRur) {
	rur = newRur;
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
 * Creation date: (06.11.2003 14:28:15)
 * @param newStateOfContract java.lang.String
 */
public void setStateOfContract(java.lang.String newStateOfContract) {
	stateOfContract = newStateOfContract;
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
public void setSumnds(BigDecimal newNds) {
	sumnds.setBigDecimal(newNds);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:43:41)
 * @param newNdSum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumndsFrm(String newNds) {
	sumnds.setString(newNds);
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 10:36:16)
 * @param newSumRub java.math.BigDecimal
 */
public void setSumRub(java.math.BigDecimal newSumRub) {
	sumRub.setBigDecimal(newSumRub);
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 10:36:16)
 * @param newSumRub java.math.BigDecimal
 */
public void setSumRubFrm(String newSumRub) {
	sumRub.setString(newSumRub);
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2003 16:14:07)
 * @param newUsedinactcode java.lang.Integer
 */
public void setUsedinact(java.lang.Integer newUsedinactcode) {
	setUsedinactcode(newUsedinactcode);
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2003 16:14:07)
 * @param newUsedinactcode java.lang.Integer
 */
public void setUsedinactcode(java.lang.Integer newUsedinactcode) {
	usedinactcode = newUsedinactcode;
}
public void validateValues(ActionErrors errors) throws Exception {
	processCalcOptions(errors);

	if (!((getState() == APPStates.PAYMENT_EDIT || getState() == APPStates.HISTORY_PAYMENT_EDIT) && new ArendaPlatinumProcessorAccessBean().isProcessingEnabled())) {
		if (date.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.date"));
		} else if (!date.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.date"));
		}
	}
	
	boolean isBegindate = false;
	boolean isEnddate = false;
	
	if (begindate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.begindate"));
	} else if (!begindate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.begindate"));
	} else {
		isBegindate = true;
	}
	
	if (enddate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.enddate"));
	} else if (!enddate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.enddate"));
	} else {
		isEnddate = true;
	}
	
	if (isBegindate && isEnddate && getBegindate().compareTo(getEnddate()) > 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.period"));
	}
		
	if (resourcecode == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.resource"));
	} else {
		try {
			constructResource();
		} catch (Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.resource"));
			}
		}
	}
	
	boolean isPayrate = false;
	boolean isSumrub = false;
	
	if (summ.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.sum"));
	} else if (!summ.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.sum"));
	}
	
	if (sumnds.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.ndsum"));
	} else if (!sumnds.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.ndsum"));
	}
	
	if (!payrate.isEmpty()) {
		if (payrate.isOk()) {
			isPayrate = true;
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.payrate"));
		}
	}
	
	if (!sumRub.isEmpty()) {
		if (sumRub.isOk()) {
			isSumrub = true;
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.sumrub"));
		}
	}
	
	if (isPayrate && isSumrub && (sumRub.getBigDecimal().compareTo(payrate.getBigDecimal().multiply(summ.getBigDecimal()).setScale(2, BigDecimal.ROUND_HALF_UP)) != 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.calcsum"));
	}
	
	if (!ndsRub.isEmpty() && !ndsRub.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.ndsrub"));
	}
	//
	if(isInAct(getLeaseDocPosition())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.applied"));
	}
	/*
	if (!isSYNCNRIPLATINARENDA() && !date.isEmpty() && date.isOk() && !checkOpenPeriod()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
			"error.payment.notopenperiod2", formatSalDate()));
	}
	*/
	
	if (!((getSource().equals("M") || getSource().equals("A")) && getDocposvid().equals("N"))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.source"));
	}
	
	if (!getAction().equals("Add") && !checkLink2Pay()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.haspay"));
	}
	
	if (getState() == com.hps.july.arenda.APPStates.US_PAYMENT_EDIT && getState() == com.hps.july.arenda.APPStates.CHANNEL_PAYMENT_EDIT && !errors.empty()) {
		throw new ValidationException();
	}
}
	/**
	 * @return
	 */
	public Boolean getFlagOplNds() {
		return flagOplNds;
	}

	/**
	 * @param boolean1
	 */
	public void setFlagOplNds(Boolean boolean1) {
		flagOplNds = boolean1;
	}

}
