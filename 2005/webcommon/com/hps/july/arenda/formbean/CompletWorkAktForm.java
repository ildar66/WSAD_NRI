package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.action.*;

import com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object;
import com.hps.july.arenda.valueobject.*;
import java.math.*;
import com.hps.july.persistence.*;
/**
 * Insert the type's description here.
 * Creation date: (29.10.2004 12:47:50)
 * @author: Shafigullin Ildar
 */
public class CompletWorkAktForm extends EditForm {
    private int idcwacode;
    private CompletWorkAct_VO completWorkActVO;
    private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
    private int idContract;
    private boolean flagByHand;
    private BigDecimal ndsRate;
    private PeopleVO operatorVO;
/**
 * Insert the method's description here.
 * Creation date: (15.11.2004 15:06:24)
 */
private void calsRateNds() {
	if (getCompletWorkActVO() == null && (getCompletWorkActVO().getActSum() == null || getCompletWorkActVO().getActNds() == null)) {
		setNdsRate(null);
		return;
	}
	double summ = getCompletWorkActVO().getActSum().doubleValue();
	double sumNds = getCompletWorkActVO().getActNds().doubleValue();
	double nds = 100 * sumNds / (summ - sumNds);
	if ((nds > 19) || (nds < 21))
		setNdsRate(new BigDecimal("20"));
	if ((nds > 17) || (nds < 19))
		setNdsRate(new BigDecimal("18"));
	setNdsRate(new BigDecimal(Math.round(nds)));
}
/**
 * Текущее приложение.
 * Creation date: (29.10.2004 12:47:50)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 11:05:34)
 */
public String getCompletWorkActActEndDateStr() {
	if (completWorkActVO != null && completWorkActVO.getActenddate() != null)
		return format.format(new java.util.Date(completWorkActVO.getActenddate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 15:35:19)
 */
public String getCompletWorkActActNdsStr() {
	if (completWorkActVO != null && completWorkActVO.getActNds() != null)
		return completWorkActVO.getActNds().toString();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 11:06:52)
 */
public String getCompletWorkActActStartDateStr() {
	if (completWorkActVO != null && completWorkActVO.getActstartdate() != null)
		return format.format(new java.util.Date(completWorkActVO.getActstartdate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 15:33:03)
 */
public String getCompletWorkActActSumStr() {
	if (completWorkActVO != null && completWorkActVO.getActSum() != null)
		return completWorkActVO.getActSum().toString();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 11:01:57)
 */
public String getCompletWorkActDocDateStr() {
	if (completWorkActVO != null && completWorkActVO.getDocdate() != null)
		return format.format(new java.util.Date(completWorkActVO.getDocdate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 16:49:58)
 * @return com.hps.july.arenda.valueobject.CompletWorkAct_VO
 */
public com.hps.july.arenda.valueobject.CompletWorkAct_VO getCompletWorkActVO() {
	return completWorkActVO;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 17:31:56)
 * @return int
 */
public int getIdContract() {
	return idContract;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 12:48:51)
 * @return int
 */
public int getIdcwacode() {
	return idcwacode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2004 14:29:15)
 * @return java.math.BigDecimal
 */
public BigDecimal getNdsRate() {
	return ndsRate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 10:01:57)
 * @return com.hps.july.arenda.valueobject.PeopleVO
 */
public com.hps.july.arenda.valueobject.PeopleVO getOperatorVO() {
	return operatorVO;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 9:59:41)
 */
private PeopleVO getPeopleVO_fromOperatorCode(javax.servlet.http.HttpServletRequest request) {
	//инициализируем исполнителя:
	PeopleVO peopleVO = null;
	try {
		Integer oper = OperatorObject.getOperatorCode(request.getRemoteUser());
		OperatorAccessBean oab = new OperatorAccessBean();
		oab.setInitKey_operator(oper.intValue());
		oab.refreshCopyHelper();
		int man = oab.getManKey().man;
		PeopleAccessBean pab = new PeopleAccessBean();
		pab.setInitKey_man(man);
		peopleVO = new PeopleVO(new Integer(man));
		peopleVO.setName(pab.getFullName());
	} catch (Exception e) {
		System.out.println("Cannot determine operator");
		e.printStackTrace(System.out);
	}
	return peopleVO;
}
/**
 * Текущее состояние приложения.
 * Creation date: (29.10.2004 12:47:50)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.COMPLET_WORK_AKT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 17:35:18)
 */
private void init() {
	completWorkActVO  = new com.hps.july.arenda.valueobject.CompletWorkAct_VO();
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    initConstants();
    if (operatorVO == null)
        operatorVO = getPeopleVO_fromOperatorCode(request);
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2004 12:06:28)
 */
private void initConstants() {
	flagByHand = com.hps.july.util.AppUtils.getNamedValueInt("CALC_SUM_ACT_COMPLET_WORK") == 1;
/**	
	// For NDS calculation in form
	java.math.BigDecimal aval =
		com.hps.july.util.AppUtils.getNamedValueBigDecimal(com.hps.july.util.AppUtils.DEFAULT_RATE_NDS);
	setNdsRate(aval);
*/	
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception { //стандартная инициализация:
    init();
    com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
    int key = keyGen.getNextKey("tables.CompletWorkActs");
    //System.out.println("key=" + key); //temp
    setIdcwacode(key);
    getCompletWorkActVO().setIdcwacode(new Integer(key));
    getCompletWorkActVO().setIdContract(new Integer(getIdContract()));
    //getCompletWorkActVO().setDocnumber(String.valueOf(key));
    getCompletWorkActVO().setActstate("O");
    CDBC_CompletWorkActs_Object.initCompletWorkAct(getCompletWorkActVO());
    //устанавливаем ставку НДС:
    setNdsRate(getCompletWorkActVO().getNdsRate());

    //устанавливаем валюту:
    CurrencyVO currencyVO = new CurrencyVO(getCompletWorkActVO().getCurrency());
    //currencyVO.setShortname("RUR");//??? позже
    getCompletWorkActVO().setCurrencyVO(currencyVO);
    //пока так:
    getCompletWorkActVO().setCreated(new java.sql.Timestamp(System.currentTimeMillis()));    
    if (getOperatorVO() != null) {
        getCompletWorkActVO().setCreatedBy(getOperatorVO().getMan());
        //getCompletWorkActVO().setCreatedName(getOperatorVO().getName());
    } else {
        System.err.println("CompletWorkActForm: код оператора не инициализирован");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2004 12:45:22)
 * @return boolean
 */
public boolean isFlagByHand() {
	return flagByHand;
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	CDBCRowObject ro = CDBC_CompletWorkActs_Object.findCompletWorkAct(getIdcwacode());
	if (ro != null) {
		completWorkActVO = new CompletWorkAct_VO(ro);
		setIdContract(completWorkActVO.getIdContract().intValue());
		//устанавливаем ставку НДС:
		calsRateNds();
	} else {
		System.out.println("Нет записи CompletWorkAct с idcwacode=" + getIdcwacode());
		throw new Exception("Нет записи CompletWorkAct с idcwacode=" + getIdcwacode());
	}
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	try {
		boolean ok = CDBC_CompletWorkActs_Object.addCompletWorkAct(getCompletWorkActVO());
		if (!ok) {
			String errorStr = "Ошибка добаления записи: CompletWorkAct с idcwacode" + completWorkActVO.getIdcwacode();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
		}
	} catch (Exception e) {
		System.out.println("CompletWorkActForm.processInsert():errorTxt: " + e);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
		e.printStackTrace();
	}
	return null;
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	try {
        getCompletWorkActVO().setModified(new java.sql.Timestamp(System.currentTimeMillis()));
        //пока так:
        if (getOperatorVO() != null) {
            getCompletWorkActVO().setModifiedBy(getOperatorVO().getMan());
         } else {
            System.err.println("CompletWorkActForm: код оператора не инициализирован");
        }		
		boolean ok = CDBC_CompletWorkActs_Object.editCompletWorkAct(getCompletWorkActVO());
		if (!ok) {
			String errorStr = "Ошибка редактирования записи: CompletWorkAkt:Idcwacode" + completWorkActVO.getIdcwacode();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
		}
	} catch (Exception e) {
		System.out.println("CompletWorkAktForm.processUpdate():errorTxt: " + e);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
		e.printStackTrace();
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 15:22:24)
 * @param dateStr java.lang.String
 */
public void setCompletWorkActActEndDateStr(String dateStr) throws java.text.ParseException {
	if (completWorkActVO != null && dateStr != null && !dateStr.equals("")) {
		java.util.Date d = format.parse(dateStr);
		java.sql.Date data = new java.sql.Date(d.getTime());
		completWorkActVO.setActenddate(data);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 15:36:16)
 */
public void setCompletWorkActActNdsStr(String actNdsStr) {
	/**	
		if (completWorkActVO != null && !actNdsStr.equals("")) {
			try {
				completWorkActVO.setActNds(new java.math.BigDecimal(actNdsStr));
			} catch (NumberFormatException e) {
				completWorkActVO.setActNds(null);
			}
		}
	*/
	StringAndBigDecimalProperty strBD = new StringAndBigDecimalProperty();
	strBD.setString(actNdsStr);
	completWorkActVO.setActNds(strBD.getBigDecimal());
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 15:25:20)
 */
public void setCompletWorkActActStartDateStr(String dateStr) throws java.text.ParseException {
	if (completWorkActVO != null && dateStr != null && !dateStr.equals("")) {
		java.util.Date d = format.parse(dateStr);
		java.sql.Date data = new java.sql.Date(d.getTime());
		completWorkActVO.setActstartdate(data);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 15:29:55)
 */
public void setCompletWorkActActSumStr(String actSumStr) {
/**	
	if (completWorkActVO != null && !actSumStr.equals("")) {
		try {
			completWorkActVO.setActSum(new java.math.BigDecimal(actSumStr));
		} catch (NumberFormatException e) {
			completWorkActVO.setActSum(null);
		}
	}
*/
    StringAndBigDecimalProperty strBD = new StringAndBigDecimalProperty();
    strBD.setString(actSumStr);
	completWorkActVO.setActSum(strBD.getBigDecimal());
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 15:27:01)
 * @param dateStr java.lang.String
 */
public void setCompletWorkActDocDateStr(String dateStr) throws java.text.ParseException {
	if (completWorkActVO != null && dateStr != null && !dateStr.equals("")) {
		java.util.Date d = format.parse(dateStr);
		java.sql.Date data = new java.sql.Date(d.getTime());
		completWorkActVO.setDocdate(data);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 16:49:58)
 * @param newCompletWorkActVO com.hps.july.arenda.valueobject.CompletWorkAct_VO
 */
public void setCompletWorkActVO(com.hps.july.arenda.valueobject.CompletWorkAct_VO newCompletWorkActVO) {
	completWorkActVO = newCompletWorkActVO;
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2004 12:45:22)
 * @param newFlagByHand boolean
 */
public void setFlagByHand(boolean newFlagByHand) {
	flagByHand = newFlagByHand;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 17:31:56)
 * @param newIdContract int
 */
public void setIdContract(int newIdContract) {
	idContract = newIdContract;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 12:48:51)
 * @param newIdcwacode int
 */
public void setIdcwacode(int newIdcwacode) {
	idcwacode = newIdcwacode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2004 14:29:15)
 * @param newNdsRate java.math.BigDecimal
 */
private void setNdsRate(BigDecimal newNdsRate) {
	ndsRate = newNdsRate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 10:01:57)
 * @param newOperatorVO com.hps.july.arenda.valueobject.PeopleVO
 */
private void setOperatorVO(com.hps.july.arenda.valueobject.PeopleVO newOperatorVO) {
	operatorVO = newOperatorVO;
}
/**
 * Метод для проверки правильности ввода значений в поля ввода.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * при этом исключении ошибки отображаются пользователю.
 */
public void validateValues(ActionErrors errors) throws Exception {
	String errorTxt;
	if (!getCompletWorkActVO().isEditByHand()) {
		getCompletWorkActVO().setActSum(new BigDecimal("0.00"));
		getCompletWorkActVO().setActNds(new BigDecimal("0.00"));
	}
	if (getCompletWorkActVO().getDocnumber() == null || getCompletWorkActVO().getDocnumber().equals("")) {
		errorTxt = "Введите номер документа!!!";
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
	}
	if (getCompletWorkActVO().getActSum() == null) {
		errorTxt = "Введите сумму!!!";
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
	}
	if (getCompletWorkActVO().getActNds() == null) {
		errorTxt = "Введите ндс!!!";
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
	}
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
