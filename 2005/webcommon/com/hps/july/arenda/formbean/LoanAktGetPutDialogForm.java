package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
/**
 * Insert the type's description here.
 * Creation date: (08.11.2005 14:14:24)
 * @author: Shafigullin Ildar
 */
public class LoanAktGetPutDialogForm extends com.hps.july.web.util.EditForm {
    private int id;
    private boolean flagOperation;
    private com.hps.july.arenda.valueobject.LoanAktGetPut_TO to;
    private int loanContract;
    private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 12:43:01)
 */
public LoanAktGetPutDialogForm() {}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2005 12:27:28)
 */
public int getAbonentContract() {
    LoanContractVO voLC = com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object.find(loanContract);
    Integer orgKey = voLC.getOrgCustomer().getOrganization();
    int abonentContract;
    if (com.hps.july.arenda.cdbcobjects.CDBC_Person_Object.find(orgKey.intValue()) != null) {
        abonentContract = com.hps.july.util.AppUtils.getNamedValueInt("LOANBANMAN");
    } else {
        abonentContract = com.hps.july.util.AppUtils.getNamedValueInt("LOANBANORG");
    }
    if (abonentContract == 0)
        System.out.println("Определите переменные - LOANBANMAN и LOANBANORG");
    return abonentContract;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2005 12:44:32)
 */
public String getAktAbonentBillInfo() {
    if (to.getVo() != null && to.getVo().getIdLeasebill() != null) {
        CDBCRowObject ro = CDBC_AbonentBills_Object.findAbonentBill(to.getVo().getIdLeasebill().intValue());
        AbonentBill_VO vo = new AbonentBill_VO(ro);
        return "№ " + vo.getBillnumber() + " от " + format.format(vo.getBilldate());
    }
    return "";
}
/**
 * Текущее приложение.
 * Creation date: (08.11.2005 14:14:24)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 16:23:53)
 * @return java.lang.String
 */
public java.lang.String getDateActStr() {
    if (to != null && to.getVo() != null && to.getVo().getDateAct() != null) {
        return format.format(new java.util.Date(to.getVo().getDateAct().getTime()));
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:50:19)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:59:41)
 * @return int
 */
public int getLoanContract() {
	return loanContract;
}
/**
 * Текущее состояние приложения.
 * Creation date: (08.11.2005 14:14:24)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.LOAN_AKT_GET_PUT_DIALOG;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:50:19)
 * @return com.hps.july.arenda.valueobject.LoanAktGetPut_VO
 */
public com.hps.july.arenda.valueobject.LoanAktGetPut_TO getTo() {
	return to;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    setFlagOperation(false);
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.loanActsGetPut");
    setId(key);
    to = new LoanAktGetPut_TO(new LoanAktGetPut_VO(new Integer(key), new Integer(getLoanContract())));
    to.getVo().setNumberAct(String.valueOf(key));
	LoanContractVO voLC = com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object.find(getLoanContract());
	to.getVo().setOtherMan(voLC.getOrgCustomer().getName());
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:50:19)
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
    to = com.hps.july.arenda.cdbcobjects.CDBC_LoanAktGetPut_Object.find(getId());
    setLoanContract(to.getVo().getLoanContract().intValue());
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 12:24:59)
 * @return java.lang.String
 * @param flag boolean
 */
private String process(boolean ok, ActionErrors errors) {
    if (!ok) {
        String errorStr = "Ошибка CRUD операции : LoanAktGetPut:id" + to.getVo().getIdAct();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
    boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LoanAktGetPut_Object.delete(to.getVo());
    return process(flag, errors);
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
    boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LoanAktGetPut_Object.add(to.getVo());
    return process(flag, errors);
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
    boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LoanAktGetPut_Object.edit(to.getVo());
    return process(flag, errors);
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 16:23:53)
 * @param newDateActStr java.lang.String
 */
public void setDateActStr(java.lang.String newDateActStr) throws java.text.ParseException {
    if (newDateActStr == null || newDateActStr.trim().length() == 0) {
        to.getVo().setDateAct(null);
    } else {
        java.util.Date d = format.parse(newDateActStr);
        to.getVo().setDateAct(new java.sql.Date(d.getTime()));
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:50:19)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:50:19)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:59:41)
 * @param newLoanContract int
 */
public void setLoanContract(int newLoanContract) {
	loanContract = newLoanContract;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 15:50:19)
 * @param newVo com.hps.july.arenda.valueobject.LoanAktGetPut_VO
 */
public void setTo(com.hps.july.arenda.valueobject.LoanAktGetPut_TO newTo) {
	to = newTo;
}
}
