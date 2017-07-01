package com.hps.july.arenda.formbean;

import java.util.*;
/**
 * Insert the type's description here.
 * Creation date: (07.11.2005 11:56:14)
 * @author: Shafigullin Ildar
 */
public class LoanAktGetPutListForm extends com.hps.july.web.util.EditForm {
    private java.lang.String sortBy;
    private List aktList;
	private int loanContract;
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 12:08:01)
 */
public LoanAktGetPutListForm() {
    setSortBy("dateAct desc");
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 12:05:23)
 * @return java.util.List
 */
public java.util.List getAktList() {
	return aktList;
}
/**
 * Текущее приложение.
 * Creation date: (07.11.2005 11:56:14)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 16:42:13)
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
 * Creation date: (07.11.2005 12:06:34)
 * @return int
 */
public int getLoanContract() {
	return loanContract;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 12:04:33)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Текущее состояние приложения.
 * Creation date: (07.11.2005 11:56:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.LOAN_AKT_GET_PUT_LIST;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    if (getLoanContract() != 0) {
        List list = com.hps.july.arenda.cdbcobjects.CDBC_LoanAktGetPut_Object.getList(getLoanContract(), getSortBy());
        setAktList(list);
        //System.out.println("list size=" + list.size());//temp
    } else {
        setAktList(Collections.EMPTY_LIST);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 12:05:23)
 * @param newAktList java.util.List
 */
public void setAktList(java.util.List newAktList) {
	aktList = newAktList;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 12:06:34)
 * @param newLoanContract int
 */
public void setLoanContract(int newLoanContract) {
	loanContract = newLoanContract;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 12:04:33)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
}
