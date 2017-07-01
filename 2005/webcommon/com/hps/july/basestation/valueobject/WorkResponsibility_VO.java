package com.hps.july.basestation.valueobject;

/**
 * Ответственные за позицию(VO).
 * Creation date: (05.08.2005 11:15:39)
 * @author: Shafigullin Ildar
 */
public class WorkResponsibility_VO {
    /**
    	*Таблица содержит перечень ответственных за позиции сотрудников 
    	*и  организаций-подрядчиков
    */
    private java.lang.Integer worker; //Ссылка на сотрудника
    private java.lang.Integer idresponsibility; //Тип ответственности(key)
    private java.lang.Integer storageplace; //Ссылка на позицию(key)
    private java.lang.String resptype; //Тип ответственного(W-worker; O-organization)(key)
    private java.lang.Integer organization; //Ссылка на организацию
    private java.lang.Integer operator; //Оператор для журналирования
/**
 * WorkResponsibility_VO constructor comment.
 */
public WorkResponsibility_VO(Integer idResponsibility, Integer storagePlace, String respType) {
	super();
	idresponsibility=idResponsibility;
	storageplace=storagePlace;
	resptype= respType;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:17:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdresponsibility() {
	return idresponsibility;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:20:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:20:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:19:04)
 * @return java.lang.String
 */
public java.lang.String getResptype() {
	return resptype;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:17:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:16:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorker() {
	return worker;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:17:25)
 * @param newIdresponsibility java.lang.Integer
 */
public void setIdresponsibility(java.lang.Integer newIdresponsibility) {
	idresponsibility = newIdresponsibility;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:20:38)
 * @param newOperator java.lang.Integer
 */
public void setOperator(java.lang.Integer newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:20:07)
 * @param newOrganization java.lang.Integer
 */
public void setOrganization(java.lang.Integer newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:19:04)
 * @param newResptype java.lang.String
 */
public void setResptype(java.lang.String newResptype) {
	resptype = newResptype;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:17:56)
 * @param newStorageplace java.lang.Integer
 */
public void setStorageplace(java.lang.Integer newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:16:20)
 * @param newWorker java.lang.Integer
 */
public void setWorker(java.lang.Integer newWorker) {
	worker = newWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 16:09:18)
 * @return java.lang.String
 */
public String toString() {
	//super.toString();
	return "WorkResponsibility_VO respID=" + getResptype() + "; storagePlace= " + getStorageplace()+"; respType= " + getResptype();
}
}
