package com.hps.july.arenda.formbean;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.objects.CDBC_OwnerContract2FilialNri_Object;

import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.persistence.*;
/**
 * Insert the type's description here.
 * Creation date: (14.10.2005 11:54:39)
 * @author: Shafigullin Ildar
 */
public class LoanContractDialogForm extends com.hps.july.web.util.EditForm {
    private int id;
    private boolean flagOperation;
    private com.hps.july.arenda.valueobject.LoanContractVO vo;
    private java.util.ArrayList currencies;
	private java.lang.Integer operatorCode;
	//Список заказчиков:
	private List executors;	
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 19:01:54)
 */
public LoanContractDialogForm() {
    initCurrencies();
}
/**
 * Текущее приложение.
 * Creation date: (14.10.2005 11:54:39)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 19:05:27)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getCurrencies() {
	return currencies;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 16:26:21)
 */
public String getDocdateStr() {
    if (vo != null && vo.getDocdate() != null) {
        StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
        sd.setSqlDate(vo.getDocdate());
        return sd.getString();
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2005 11:56:00)
 */
public String getEndDateStr() {
    if (vo != null && vo.getEndDate() != null) {
        StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
        sd.setSqlDate(vo.getEndDate());
        return sd.getString();
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 12:35:43)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2005 15:14:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperatorCode() {
	return operatorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 18:51:35)
 */
public String getPlanSumStr() {
	if (vo != null && vo.getPlanSum() != null)
		return vo.getPlanSum().toString();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2005 11:55:15)
 */
public String getStartDateStr() {
    if (vo != null && vo.getStartDate() != null) {
        StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
        sd.setSqlDate(vo.getStartDate());
        return sd.getString();
    }
    return null;
}
/**
 * Текущее состояние приложения.
 * Creation date: (14.10.2005 11:54:39)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.LOAN_CONTRACT_DIALOG;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 12:36:34)
 * @return com.hps.july.arenda.valueobject.LoanContractVO
 */
public com.hps.july.arenda.valueobject.LoanContractVO getVo() {
	return vo;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    setFlagOperation(false);
    if (getOperatorCode() == null)
        initOperatorCode(request);
	//Список :
	initExecutors(request);
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 19:02:34)
 */
private void initCurrencies() {
    try {
        ArrayList listCurrencies = new ArrayList();
        CurrencyAccessBean bean = new CurrencyAccessBean();
        Enumeration enum = bean.findAllOrderByNameAsc();
        while (enum.hasMoreElements()) {
            CurrencyAccessBean ab = (CurrencyAccessBean) enum.nextElement();
            CurrencyVO vo = new CurrencyVO(new Integer(ab.getCurrency()));
            vo.setName(ab.getName());
            listCurrencies.add(vo);
        }
        setCurrencies(listCurrencies);
    } catch (Exception e) {
        System.out.println("LoanContractDialogForm.initCurrencies(): Ошибка формирования листа валют!!!");
        e.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2005 15:14:42)
 */
private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
    setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    vo = new LoanContractVO();
    int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leasedocuments");
    getVo().setLeaseDocument(new Integer(key));
    setId(key);
    vo.setDocnumber(String.valueOf(key));
    vo.setDoctype("S");
    vo.setContractType("S");
    vo.setContractState("A");
    vo.setOrgCustomer(new OrganizationVO());
    vo.setOrgExecutor(new OrganizationVO()); //Вымпелком
    vo.setMainpositionVO(new StoragePlaceVO());
    vo.setManagerVO(new WorkerVO(new Integer(0)));
    vo.setEconomistVO(new WorkerVO(new Integer(0)));
    vo.setPlanCurrVO(new CurrencyVO(null));
    //для разделения по филиалам:
    Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
    vo.setRegionid(profile.getProfileAccess().getCurrRegion().getVo().getRegionid());
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 12:35:57)
 * @return boolean
 */
public boolean isFlagOperation() {
	return flagOperation;
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    vo = com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object.find(getId());
    if (vo.getMainpositionVO() == null)
        vo.setMainpositionVO(new StoragePlaceVO(0));
    if (vo.getManagerVO() == null)
        vo.setManagerVO(new WorkerVO(new Integer(0)));
    if (vo.getEconomistVO() == null)
        vo.setEconomistVO(new WorkerVO(new Integer(0)));
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2005 18:50:24)
 * @return java.lang.String
 */
private String process(javax.servlet.http.HttpServletRequest request, ActionErrors errors, String operation) {
    try {
        String errorStr = com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object.procedure(getVo(), getOperatorCode(), operation);
        if (errorStr != null) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            setFlagOperation(false);
        } else {
            setFlagOperation(true);
        }
    } catch (Exception e) {
        System.out.println("LoanContractDialogForm.process():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
        e.printStackTrace();
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors){
    return process(request, errors, "D");
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
    return process(request, errors, "I");
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
    return process(request, errors, "U");
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 19:05:27)
 * @param newCurrencies java.util.ArrayList
 */
public void setCurrencies(java.util.ArrayList newCurrencies) {
	currencies = newCurrencies;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 16:29:10)
 */
public void setDocdateStr(String newDocdateStr) {
	StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
	sd.setString(newDocdateStr);
	vo.setDocdate(sd.getSqlDate());
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2005 11:54:28)
 */
public void setEndDateStr(String newEndDateStr) {
    StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
    sd.setString(newEndDateStr);
    vo.setEndDate(sd.getSqlDate());
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 12:35:57)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 12:35:43)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2005 15:14:26)
 * @param newOperatorCode java.lang.Integer
 */
private void setOperatorCode(java.lang.Integer newOperatorCode) {
	operatorCode = newOperatorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 18:53:10)
 */
public void setPlanSumStr(String amountStr) {
	if (vo != null && !amountStr.equals(""))
		vo.setPlanSum(new java.math.BigDecimal(amountStr));
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2005 11:52:49)
 */
public void setStartDateStr(String newStartDateStr) {
    StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
    sd.setString(newStartDateStr);
    vo.setStartDate(sd.getSqlDate());
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 12:36:34)
 * @param newVo com.hps.july.arenda.valueobject.LoanContractVO
 */
public void setVo(com.hps.july.arenda.valueobject.LoanContractVO newVo) {
	vo = newVo;
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2005 17:21:24)
 */
private void initExecutors(HttpServletRequest request) {
	Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
	if (profile.getProfileAccess().getCurrRegion() != null) {
		Integer regionID = profile.getProfileAccess().getCurrRegion().getVo().getRegionid();
		//List custList = CDBC_OrganizationObject.findOurOrganizations(regionID, "nameOrg");
		List custList = CDBC_OwnerContract2FilialNri_Object.getList(regionID, "name");
		setExecutors(custList);
	} else {
		//throw new RuntimeException("нет текущего региона для аренды!!!");
		System.out.println("нет текущего региона для аренды!!!");
	}
}
	/**
	 * @return
	 */
	public List getExecutors() {
		return executors;
	}

	/**
	 * @param list
	 */
	private void setExecutors(List list) {
		executors = list;
	}

}
