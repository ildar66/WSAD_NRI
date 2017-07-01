package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import java.util.Enumeration;
import org.apache.struts.action.*;
import java.sql.*;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Form-Bean.
 * "параметры регламента"
 * Creation date: (09.07.2002 10:47:35)
 * @author: Sergey Gourov
 */
public class MainParamsMutReglmntForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private StringAndSqlDateProperty documentDate;
	private String documentNumber;
	private String mutualPeriod;
	private Boolean commonRate;
	private String actType;
	private String calcRateType;
	private java.lang.String mutState;
	private int isShowMessage;
	private CurrencyAccessBean maincurrency;
	private int maincurrencycode;
	private java.lang.String dutyraterule;
	private StringAndSqlDateProperty startdate;
	private StringAndSqlDateProperty enddate;
	//private CurrencyAccessBean additionalCurrency;
	//private int additionalCurrencycode;
	//private java.lang.Boolean isAddcurrency;
	private StringAndSqlDateProperty minDate;
	private StringAndSqlDateProperty maxDate;
	//для контроля за ведением договора:
    private PeopleVO operatorVO;
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:53:52)
 */
public MainParamsMutReglmntForm() {
	Date date = new Date(System.currentTimeMillis());
	documentDate = new StringAndSqlDateProperty();
	documentDate.setSqlDate(date);
	startdate = new StringAndSqlDateProperty();
	startdate.setSqlDate(date);
	enddate = new StringAndSqlDateProperty();
	enddate.setSqlDate(date);
	
	//setActType("A");
	setActType("");
	setMutualPeriod("M");
	setCommonRate(new Boolean(false));
	setCalcRateType("B");
	setMutState("A");
	setDutyraterule("A");

	NamedValueAccessBean bean = new NamedValueAccessBean();
	minDate = new StringAndSqlDateProperty();
	try {
		bean.setInitKey_id("ARENDA_MIN_DATE");
		bean.refreshCopyHelper();
		minDate.setSqlDate(new Date(bean.getDatevalue().getTime()));
	} catch (Exception ex) {
		ex.printStackTrace();
	}

	bean = new NamedValueAccessBean();
	maxDate = new StringAndSqlDateProperty();
	try {
		bean.setInitKey_id("ARENDA_MAX_DATE");
		bean.refreshCopyHelper();
		maxDate.setSqlDate(new Date(bean.getDatevalue().getTime()));
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	LeaseMutualReglamentAccessBean lmrBean = (LeaseMutualReglamentAccessBean) bean;
	
	if (lmrBean.getMutState().equals("A")) {
		Enumeration e = new LeaseMutualContractsAccessBean().findLeaseMutualContractsByReglament(new LeaseDocumentKey(lmrBean.getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseMutualContractsAccessBean lmcBean = (LeaseMutualContractsAccessBean) e.nextElement();
			lmcBean.getEJBRef().remove();
		}		
		
		e = new LeaseMRCntPriorAccessBean().findLeaseMRCntPriorsByReglament(new LeaseDocumentKey(lmrBean.getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseMRCntPriorAccessBean lmrcpBean = (LeaseMRCntPriorAccessBean) e.nextElement();
			lmrcpBean.getEJBRef().remove();
		}
		
		e = new LeaseMutualRuleNewAccessBean().findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(new Integer(lmrBean.getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseMutualRuleNewAccessBean lmrnBean = (LeaseMutualRuleNewAccessBean) e.nextElement();
			lmrnBean.getEJBRef().remove();
		}
		
		e = new LeaseMutualPhoneAccessBean().findLeaseMutualPhoneByLeaseDocument(new LeaseDocumentKey(lmrBean.getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseMutualPhoneAccessBean lmpBean = (LeaseMutualPhoneAccessBean) e.nextElement();
			lmpBean.getEJBRef().remove();
		}
	}
}
/**
 * Метод вызывается перед изменением основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	LeaseMutualReglamentAccessBean abean = (LeaseMutualReglamentAccessBean)bean;
	//контроль доступа:
    if (getOperatorVO() != null) {
        abean.setModifiedby(getOperatorVO().getMan());
        abean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
    }
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.

private CurrencyAccessBean constructAdditionalcurrency() throws java.lang.Exception {
	if (getAdditionalCurrencycode() != 0) {
		additionalCurrency = new CurrencyAccessBean();
		additionalCurrency.setInitKey_currency(getAdditionalCurrencycode());
		additionalCurrency.refreshCopyHelper();
	}
	return additionalCurrency;
}
*/
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 10:47:35)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    setLeaseDocument(keyGen.getNextKey("tables.leasedocuments"));
    setDocumentNumber(Integer.toString(keyGen.getNextKey("tables.leasemutualrglmnt")));
    /* @param argLeaseDocument int
     * @param argDocDate java.sql.Date
     * @param argDocNumber java.lang.String
     * @param argMutualPeriod java.lang.String
     * @param argMainCurrency java.lang.Integer
     * @param argCommonRate java.lang.Boolean
     * @param argActType java.lang.String
     * @param argMutstate java.lang.String
     * @param argDutyraterule java.lang.String
     * @param argStartDate java.sql.Date
     * @param argEndDate java.sql.Date*/
    //System.out.println("REGL: Create(" + getLeaseDocument() + "," + getDocumentNumber() + ")");
    LeaseMutualReglamentAccessBean bean =
        new LeaseMutualReglamentAccessBean(
            getLeaseDocument(),
            getDocumentDate(),
            getDocumentNumber(),
            getMutualPeriod(),
            new Integer(getMaincurrencycode()),
            getCommonRate(),
            getActType(),
            getMutState(),
            getDutyraterule(),
            getStartdate(),
            getEnddate());
    //для разделения по филиалам:
    Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
    bean.setRegionid(profile.getProfileAccess().getCurrRegion().getVo().getRegionid().intValue());
    //контроль доступа:
    if (getOperatorVO() != null) {
        bean.setCreatedby(getOperatorVO().getMan());
        bean.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
        bean.setModifiedby(getOperatorVO().getMan());
        bean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));           
    }
    
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructMaincurrency() throws java.lang.Exception {
	if (getMaincurrencycode() != 0) {
		maincurrency = new CurrencyAccessBean();
		maincurrency.setInitKey_currency(getMaincurrencycode());
		maincurrency.refreshCopyHelper();
	}
	return maincurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:21:21)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 16:16:15)
 * @return com.hps.july.persistence.CurrencyAccessBean

public Currency getAdditionalCurrency() throws Exception {
	if (isAddcurrency.booleanValue()) {
		CurrencyAccessBean bean = constructAdditionalcurrency();
		return bean != null ? (Currency) bean.getEJBRef() : null;
	} else {
		return null;
	}
}
 */
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 16:21:36)
 * @return int

public int getAdditionalCurrencycode() {
	return additionalCurrencycode;
}
 */
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 10:47:35)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:27:14)
 * @return java.lang.String
 */
public String getCalcRateType() {
	return getCommonRate().booleanValue() ? calcRateType : null;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:20:22)
 * @return java.lang.String
 */
public Boolean getCommonRate() {
	return commonRate;
}
public java.util.Enumeration getCurrencies() {
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch(Exception e) {
		return new java.util.Vector().elements();	
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
    //System.out.println("REGL: GetData(" + getLeaseDocument() + ")");
    LeaseMutualReglamentAccessBean bean = new LeaseMutualReglamentAccessBean();
    bean.setInitKey_leaseDocument(getLeaseDocument());
    
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:15:21)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:15:21)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:17:51)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:25:15)
 * @return java.lang.String
 */
public java.lang.String getDutyraterule() {
	return dutyraterule;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("administrator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:30:26)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEnddate() {
	return enddate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:30:26)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEnddateFrm() {
	return enddate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 18:25:01)
 * @return java.lang.Boolean

public java.lang.Boolean getIsAddcurrency() {
	return isAddcurrency;
}
 */
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 10:55:44)
 * @return boolean
 */
public boolean getIsExistPriority() {
	try {
		if (!"S".equals(getActType())) {
			int i = 0;
			Enumeration e = new LeaseMutualContractsAccessBean().findLeaseMutualContractsByReglament(new LeaseDocumentKey(getLeaseDocument()));
			while (e.hasMoreElements()) {
				e.nextElement();
				if (++i > 1) return true;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 16:54:15)
 * @return int
 */
public int getIsShowMessage() {
	return isShowMessage;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:14:10)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:06:06)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getMaincurrency() throws Exception {
	CurrencyAccessBean bean = constructMaincurrency();
	return bean != null ? (Currency) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:11:51)
 * @return int
 */
public int getMaincurrencycode() {
	return maincurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 11:01:22)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public long getMaxDateFrm() {
	return maxDate.getSqlDate().getTime()/86400000 + 25570;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 11:01:22)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getMaxDateFrmToo() {
	return maxDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 10:59:32)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public long getMinDateFrm() {
	return minDate.getSqlDate().getTime()/86400000 + 25570;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 10:59:32)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getMinDateFrmToo() {
	return minDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 17:47:30)
 * @return java.lang.String
 */
public java.lang.String getMutState() {
	return mutState;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:19:37)
 * @return java.lang.String
 */
public java.lang.String getMutualPeriod() {
	return mutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2005 13:34:50)
 * @return com.hps.july.arenda.valueobject.PeopleVO
 */
private com.hps.july.arenda.valueobject.PeopleVO getOperatorVO() {
	return operatorVO;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:28:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartdate() {
	return startdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:28:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getStartdateFrm() {
	return startdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 10:47:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.MAINPARAMS_MUTREGLMNT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	//для контроля доступа:
    if (operatorVO == null) {
        operatorVO = com.hps.july.arenda.cdbcobjects.CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
    }
    	
	if (getAction().equals("View")) {
		Enumeration e = new LeaseMutualContractsAccessBean().findLeaseMutualContractsByReglament(new LeaseDocumentKey(getLeaseDocument()));
		if (e.hasMoreElements()) {
			request.setAttribute("contractsList", e);
		}		
		
		e = new LeaseMRCntPriorAccessBean().findLeaseMRCntPriorsByReglament(new LeaseDocumentKey(getLeaseDocument()));
		if (e.hasMoreElements()) {
			request.setAttribute("priorityList", e);
		}
		
		e = new LeaseMutualRuleNewAccessBean().findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(new Integer(getLeaseDocument()));
		if (e.hasMoreElements()) {
			request.setAttribute("mutualrulesList", e);
		}

		e = new LeaseMutualPhoneAccessBean().findLeaseMutualPhoneByLeaseDocument(new LeaseDocumentKey(getLeaseDocument()));
		if (e.hasMoreElements()) {
			request.setAttribute("phonesList", e);
		}
	}
}
public void initForm(javax.servlet.http.HttpServletRequest request) throws Exception {
	Date date = new Date(System.currentTimeMillis());
	documentDate.setSqlDate(date);
	
	setDocumentNumber("");
	setActType("");
	setMutualPeriod("M");
	setCommonRate(new Boolean(false));
	setCalcRateType("B");
	setMutState("A");
	setMaincurrencycode(0);
	//setAdditionalCurrencycode(0);
}
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	initForm(request);
	
    MutualReglamentsListForm form = (MutualReglamentsListForm) request.getSession().getAttribute("MutualReglamentsListForm");

    setStartDateByContract(form.getLeaseContract(), form.getStartDate());
    
	if (!form.getIsDocdate().booleanValue()) {
		setDocumentDate(form.getDocdate());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:21:21)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 16:16:15)
 * @param newAdditionalCurrency com.hps.july.persistence.CurrencyAccessBean

public void setAdditionalCurrency(com.hps.july.persistence.CurrencyAccessBean newAdditionalCurrency) throws Exception {
	if (newAdditionalCurrency == null) {
		additionalCurrencycode = 0;
	} else {
		additionalCurrencycode = newAdditionalCurrency.getCurrency();
	}
}
 */
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 16:21:36)
 * @param newAdditionalcurrencycode int

public void setAdditionalCurrencycode(int newAdditionalCurrencycode) {
	additionalCurrencycode = newAdditionalCurrencycode;
}
 */
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:27:14)
 * @param newCalcRateType java.lang.String
 */
public void setCalcRateType(String newCalcRateType) {
	calcRateType = newCalcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:20:22)
 * @param newCommonRate java.lang.String
 */
public void setCommonRate(Boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:15:21)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(com.hps.july.web.util.StringAndSqlDateProperty newDocumentDate) {
	documentDate = newDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:15:21)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:15:21)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:17:51)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:25:15)
 * @param newDutyraterule java.lang.String
 */
public void setDutyraterule(java.lang.String newDutyraterule) {
	dutyraterule = newDutyraterule;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:30:26)
 * @param newEnddate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEnddate(Date newEnddate) {
	enddate.setSqlDate(newEnddate);
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:30:26)
 * @param newEnddate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEnddateFrm(String newEnddate) {
	enddate.setString(newEnddate);
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 18:25:01)
 * @param newIsAddcurrency java.lang.Boolean

public void setIsAddcurrency(java.lang.Boolean newIsAddcurrency) {
	isAddcurrency = newIsAddcurrency;
}
 */
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 16:54:15)
 * @param newIsShowMessage int
 */
public void setIsShowMessage(int newIsShowMessage) {
	isShowMessage = newIsShowMessage;
}
public void setLeaseDocument(int newLeaseDocument) {
	//System.out.println("REGL: SetLeaseDocument("+newLeaseDocument+")");
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:06:06)
 * @param newMaincurrency com.hps.july.persistence.CurrencyAccessBean
 */
public void setMaincurrency(com.hps.july.persistence.CurrencyAccessBean newMaincurrency) throws Exception {
	if (newMaincurrency == null) {
		maincurrencycode = 0;
	} else {
		maincurrencycode = newMaincurrency.getCurrency();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:11:51)
 * @param newCurrencycode int
 */
public void setMaincurrencycode(int newMaincurrencycode) {
	maincurrencycode = newMaincurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 17:47:30)
 * @param newMutState java.lang.String
 */
public void setMutState(java.lang.String newMutState) {
	mutState = newMutState;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 15:19:37)
 * @param newMutualPeriod java.lang.String
 */
public void setMutualPeriod(java.lang.String newMutualPeriod) {
	mutualPeriod = newMutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2005 13:34:50)
 * @param newOperatorVO com.hps.july.arenda.valueobject.PeopleVO
 */
private void setOperatorVO(com.hps.july.arenda.valueobject.PeopleVO newOperatorVO) {
	operatorVO = newOperatorVO;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:28:12)
 * @param newStartdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartdate(Date newStartdate) {
	startdate.setSqlDate(newStartdate);
}
public void setStartDateByContract(Integer lc, Date startDate)
{
	if(lc != null) {
		try {
			LeaseMutualReglamentAccessBean lmf = new LeaseMutualReglamentAccessBean();
			Enumeration en = lmf.findByQBE(
				Boolean.FALSE, new java.sql.Date(0), 
				Boolean.FALSE, "", 
				Boolean.TRUE, lc, 
				Boolean.FALSE, 
				Boolean.FALSE, 
				Boolean.FALSE, 
				Boolean.FALSE, "", 
				new Integer(1)
			);
			if(!en.hasMoreElements()) {
				setStartdate(startDate);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 15:28:12)
 * @param newStartdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartdateFrm(String newStartdate) {
	startdate.setString(newStartdate);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	/*if (getDocumentNumber() == null || getDocumentNumber().equals("")) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mutualreglmnts.docnumber"));
	}*/
	if(getActType() == null ||(getActType() != null && getActType().length() == 0)){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.type"));
	}

	if  (getMaincurrencycode() == 0)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.maincurr"));
/*
	if (getIsAddcurrency().booleanValue()) {
		if  (getAdditionalCurrencycode() == 0)
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.addcurr"));
	}

	if ( getIsAddcurrency().booleanValue() && (getMaincurrencycode() != 0) && (getAdditionalCurrencycode() != 0) ) {
		// одна из валют должна быть рубль
		NamedValueAccessBean namedValue = new NamedValueAccessBean();
		namedValue.setInitKey_id("BASE_CURRENCY_ARENDA");
		namedValue.refreshCopyHelper();
		
		if (getMaincurrencycode() != namedValue.getIntvalue() && getAdditionalCurrencycode() != namedValue.getIntvalue()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.onerur"));
		}
	}
*/		
	
	if (getCommonRate().booleanValue() && (getCalcRateType() == null || getCalcRateType().equals(""))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mutualreglmnts.calcratetype"));
	}

	if (getMutState().equals("B") || getMutState().equals("C")) {
		Enumeration e = new LeaseMutualReglamentAccessBean().findConcurentReglamentsByReglament(new Integer(getLeaseDocument()));
		if (e.hasMoreElements()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.double"));
		}
		
		e = new LeaseMutualActNewAccessBean().findLeaseMutualActNewByLeaseMutualReglament(new LeaseDocumentKey(getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseMutualActNewAccessBean bean = (LeaseMutualActNewAccessBean) e.nextElement();
			if (bean.getActstartdate().compareTo(getStartdate()) < 0 ||	
				bean.getActstartdate().compareTo(getEnddate()) > 0 ||
				bean.getActenddate().compareTo(getStartdate()) < 0 || 
				bean.getActenddate().compareTo(getEnddate()) > 0)
			{
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.haswrongactperiod"));
				break;
			}
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
