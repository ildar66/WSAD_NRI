package com.hps.july.arenda.valueobject;

/**
 * Ссудные договора(контейнер).
 * Creation date: (12.10.2005 15:55:23)
 * @author: Shafigullin Ildar
 */
public class LoanContractVO extends LeaseContractVO {
    private java.lang.String reason; //причина выдачи
    private java.math.BigDecimal planSum; //планируемая стоимость выданного оборудования
    private StoragePlaceVO mainpositionVO;
	private CurrencyVO planCurrVO;
/**
 * LoanContractVO constructor comment.
 */
public LoanContractVO() {
	super();
}
/**
 * LoanContractVO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LoanContractVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
    super(ro);
    setReason(ro.getColumn("reason").asString());
    setPlanSum((java.math.BigDecimal) ro.getColumn("plansum").asObject());
    setPlanCurrVO(com.hps.july.arenda.cdbcobjects.CDBC_Helper.initCurrencyVO(ro, "plancurr", "plancurrname"));
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 16:46:52)
 */
public java.lang.String getContractStateColor() {
    if (getContractState().equalsIgnoreCase("A"))
        return "red";
    else if (getContractState().equalsIgnoreCase("B"))
        return "green";
    else if (getContractState().equalsIgnoreCase("C"))
        return "gray";
    else
        return "black";
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 16:29:21)
 */
public java.lang.String getContractStateStr() {
    if (getContractState().equalsIgnoreCase("A"))
        return "Вводится";
    else if (getContractState().equalsIgnoreCase("B"))
        return "Исполняется";
    else if (getContractState().equalsIgnoreCase("C"))
        return "Закрыт";
    else
        return getContractState();
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 19:17:06)
 * @return com.hps.july.arenda.valueobject.StoragePlaceVO
 */
public StoragePlaceVO getMainpositionVO() {
	return mainpositionVO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2005 15:55:19)
 * @return com.hps.july.arenda.valueobject.CurrencyVO
 */
public CurrencyVO getPlanCurrVO() {
	return planCurrVO;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:00:05)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPlanSum() {
	return planSum;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 15:58:05)
 * @return java.lang.String
 */
public java.lang.String getReason() {
	return reason;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 19:17:06)
 * @param newMainpositionVO com.hps.july.arenda.valueobject.StoragePlaceVO
 */
public void setMainpositionVO(StoragePlaceVO newMainpositionVO) {
	mainpositionVO = newMainpositionVO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2005 15:55:19)
 * @param newPlanCurrVO com.hps.july.arenda.valueobject.CurrencyVO
 */
public void setPlanCurrVO(CurrencyVO newPlanCurrVO) {
	planCurrVO = newPlanCurrVO;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:00:05)
 * @param newPlanSum java.math.BigDecimal
 */
public void setPlanSum(java.math.BigDecimal newPlanSum) {
	planSum = newPlanSum;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 15:58:05)
 * @param newReason java.lang.String
 */
public void setReason(java.lang.String newReason) {
	reason = newReason;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	String str = "LoanContract: PlanSum=" + getPlanSum() + "; mainposition=" + getMainpositionVO().getStorageplace();
	// This implementation forwards the message to super. You may replace or supplement this.
	return  str + " " +super.toString();
}
}
