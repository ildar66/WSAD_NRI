package com.hps.july.arenda.formbean;

import com.hps.july.commonbean.*;
import com.hps.july.arenda.sessionbean.*;
import java.sql.Timestamp;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.web.util.*;
import java.sql.Date;
/**
 * Form-Bean.
 * Расчет контракта - шаг 2
 * Creation date: (26.12.2002 17:29:05)
 * @author: Sergey Gourov
 */
public class CalcContractStep2Form extends CalcContractStep1Form {
	private com.hps.july.web.util.StringAndSqlDateProperty lastsaldodate;
	private com.hps.july.web.util.StringAndSqlDateProperty userbegindate;
	private com.hps.july.web.util.StringAndSqlDateProperty userenddate;
	private com.hps.july.web.util.StringAndSqlDateProperty lastsaldodatetemp;
	private com.hps.july.web.util.StringAndSqlTimestampProperty lastsaldocalctemp;
	private com.hps.july.web.util.StringAndSqlDateProperty calcfordate;
	private java.lang.String actionType;
	private java.lang.Boolean isShowdocpos;
	private java.lang.String actionForm;
	private java.lang.Boolean isExistReglament;
	private java.lang.Boolean isCalctemp;
	private int actCode;
	private int reglamentCode;
	protected java.lang.String listForm2;
/**
 * CalcContractStep2Form constructor comment.
 */
public CalcContractStep2Form() {
	super();
	lastsaldodate = new StringAndSqlDateProperty();
	userbegindate = new StringAndSqlDateProperty();
	userenddate = new StringAndSqlDateProperty();
	lastsaldodatetemp = new StringAndSqlDateProperty();
	lastsaldocalctemp = new StringAndSqlTimestampProperty();
	calcfordate = new StringAndSqlDateProperty();
	setActionType("A");
	setIsShowdocpos(new Boolean(false));
	setActionForm("A");
	setIsExistReglament(new Boolean(false));
	listForm2 = "CalcContractStep1Form";
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:50:30)
 * @return java.lang.String
 */
public java.lang.String getActionForm() {
	return actionForm;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:46:03)
 * @return java.lang.String
 */
public java.lang.String getActionType() {
	return actionType;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:43:30)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getCalcfordate() {
	return calcfordate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:43:30)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getCalcfordateFrm() {
	return calcfordate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2002 11:12:16)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsCalctemp() {
	return isCalctemp;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 21:07:40)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsExistReglament() {
	return isExistReglament;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:48:07)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsShowdocpos() {
	return isShowdocpos;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:15:00)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Timestamp getLastsaldocalctemp() {
	return lastsaldocalctemp.getSqlTimestamp();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:15:00)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getLastsaldocalctempFrm() {
	return lastsaldocalctemp.getStringDate();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:40:57)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getLastsaldodate() {
	return lastsaldodate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:40:57)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getLastsaldodateFrm() {
	return lastsaldodate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:04:52)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getLastsaldodatetemp() {
	return lastsaldodatetemp.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:04:52)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getLastsaldodatetempFrm() {
	return lastsaldodatetemp.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:54:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CALC_CONTRACT_STEP2;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:48:50)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getUserbegindate() {
	return userbegindate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:48:50)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getUserbegindateFrm() {
	return userbegindate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:50:58)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getUserenddate() {
	return userenddate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:50:58)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getUserenddateFrm() {
	return userenddate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	super.initCollections(request);
	actCode = 0;
	CalcContractStep1Form form = (CalcContractStep1Form) request.getSession().getAttribute(listForm2);
	setLeaseContract(form.getLeaseContract());
	setResource(form.getResource());
	setBegindate(form.getBegindate());
	setEnddate(form.getEnddate());
	
	setUserbegindate(form.getUserbegindate());
	setUserenddate(form.getUserenddate());
	
	setLastsaldodate(form.getLastsaldodate());
	setIsCalctemp(new Boolean(false));
	
	Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
		new Integer(getLeaseContract()), new Integer(getResource()));
	while (e.hasMoreElements()) {
		LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
		if (bean.getIstemp().booleanValue()) {
			setLastsaldodatetemp(bean.getSalDate());
			if (bean.getAct() != null) {
				actCode = bean.getAct().getLeaseDocument();
				LeaseMutualActInfoAccessBean lmaiBean = new LeaseMutualActInfoAccessBean();
				lmaiBean.setInitKey_leasedocument(actCode);
				lmaiBean.refreshCopyHelper();
				setLastsaldocalctemp(lmaiBean.getLastcalctime());
				setIsCalctemp(new Boolean(true));
			}
			break;
		}
	}
	
	GregorianCalendar start = new GregorianCalendar();
	start.setTime(getLastsaldodate());
	start.add(Calendar.DAY_OF_MONTH, 1);
	
	e = new LeaseMutualReglamentAccessBean().findByResourceContractDates(new Integer(getResource()),
		new Integer(getLeaseContract()), new Date(start.getTime().getTime()), getUserenddate());
	if (e.hasMoreElements()) {
		LeaseMutualReglamentAccessBean lmrBean = (LeaseMutualReglamentAccessBean) e.nextElement();
		reglamentCode = lmrBean.getLeaseDocument();
		setIsExistReglament(new Boolean(true));
	} else {
		setIsExistReglament(new Boolean(false));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:50:30)
 * @param newActionForm java.lang.String
 */
public void setActionForm(java.lang.String newActionForm) {
	actionForm = newActionForm;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:46:03)
 * @param newActionType java.lang.String
 */
public void setActionType(java.lang.String newActionType) {
	actionType = newActionType;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:43:30)
 * @param newCalcfordate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setCalcfordate(Date newCalcfordate) {
	calcfordate.setSqlDate(newCalcfordate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:43:30)
 * @param newCalcfordate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setCalcfordateFrm(String newCalcfordate) {
	calcfordate.setString(newCalcfordate);
}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2002 11:12:16)
 * @param newIsCalctemp java.lang.Boolean
 */
public void setIsCalctemp(java.lang.Boolean newIsCalctemp) {
	isCalctemp = newIsCalctemp;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 21:07:40)
 * @param newIsExistReglament java.lang.Boolean
 */
public void setIsExistReglament(java.lang.Boolean newIsExistReglament) {
	isExistReglament = newIsExistReglament;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:48:07)
 * @param newIsShowdocpos java.lang.Boolean
 */
public void setIsShowdocpos(java.lang.Boolean newIsShowdocpos) {
	isShowdocpos = newIsShowdocpos;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:15:00)
 * @param newLastsaldocalctemp com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setLastsaldocalctemp(Timestamp newLastsaldocalctemp) {
	lastsaldocalctemp.setSqlTimestamp(newLastsaldocalctemp);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:15:00)
 * @param newLastsaldocalctemp com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setLastsaldocalctempFrm(String newLastsaldocalctemp) {
	lastsaldocalctemp.setString(newLastsaldocalctemp);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:40:57)
 * @param newLastsaldodate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setLastsaldodate(Date newLastsaldodate) {
	lastsaldodate.setSqlDate(newLastsaldodate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:40:57)
 * @param newLastsaldodate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setLastsaldodateFrm(String newLastsaldodate) {
	lastsaldodate.setString(newLastsaldodate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:04:52)
 * @param newLastsaldodatetemp com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setLastsaldodatetemp(Date newLastsaldodatetemp) {
	lastsaldodatetemp.setSqlDate(newLastsaldodatetemp);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 11:04:52)
 * @param newLastsaldodatetemp com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setLastsaldodatetempFrm(String newLastsaldodatetemp) {
	lastsaldodatetemp.setString(newLastsaldodatetemp);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:48:50)
 * @param newUserbegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setUserbegindate(Date newUserbegindate) {
	userbegindate.setSqlDate(newUserbegindate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:48:50)
 * @param newUserbegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setUserbegindateFrm(String newUserbegindate) {
	userbegindate.setString(newUserbegindate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:50:58)
 * @param newUserenddate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setUserenddate(Date newUserenddate) {
	userenddate.setSqlDate(newUserenddate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:50:58)
 * @param newUserenddate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setUserenddateFrm(String newUserenddate) {
	userenddate.setString(newUserenddate);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (!getIsExistReglament().booleanValue()) {
		return;
	}
	
	if (getActionType().equals("A") || getActionType().equals("B")) {
		LeaseMutualActNewAccessBean bean = null;
		if (actCode == 0) {
			//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.calccontract.noact"));
			//
		} else {
			new ArendaTransactionMethodAccessBean().rollbackCalcAct(new Integer(actCode));
			
			bean = new LeaseMutualActNewAccessBean();
			bean.setInitKey_leaseDocument(actCode);
			bean.refreshCopyHelper();
			bean.getEJBRef().remove();
		}
		
		if (getActionType().equals("B")) {
			GregorianCalendar start = new GregorianCalendar();
			start.setTime(getLastsaldodate());
			start.add(Calendar.DAY_OF_MONTH, 1);
			
			bean = new LeaseMutualActNewAccessBean(
				actCode = new KeyGeneratorAccessBean().getNextKey("tables.leasedocuments"),	// argLeaseDocument int
				new Date(new GregorianCalendar().getTime().getTime()),		// argDocDate java.sql.Date
				"temp_" + actCode,											// argDocNumber java.lang.String
				new Integer(reglamentCode),									// argLeaseMutualReglament java.lang.Integer
				"O",														// argState java.lang.String
				new Date(start.getTime().getTime()),						// actstartdate java.sql.Date
				getUserenddate(),											// actenddate java.sql.Date
				true														// argIsTemp boolean
			);
			bean.setFooter("");
			bean.setHeader("");
			bean.commitCopyHelper();
			
			new CalculateArendaActAccessBean().calcAct(new Integer(actCode), 1, new Integer(1));
		}
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
