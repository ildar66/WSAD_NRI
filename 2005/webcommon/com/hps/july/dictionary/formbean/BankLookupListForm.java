package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;
/**
 * Форма выбора банков
 */
public class BankLookupListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String bankname;
    private java.lang.Boolean isname;
    private java.lang.Boolean isbik;
    private java.lang.String bankbik;
    private java.lang.String sortBy;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public BankLookupListForm() {
	this.setFinderMethodName( "findListBanks" );
	isname = java.lang.Boolean.TRUE;
	bankname = "";
	isbik = java.lang.Boolean.FALSE;
	bankbik = "";
	sortBy = "name desc";
	}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	if (o == null) {
		return o;
	}
	if (!(o instanceof CDBCRowObject)) {
		System.out.println("BankLookupListForm: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	return new Bank_VO((CDBCRowObject)o);
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:44)
 * @return java.lang.String
 */
public java.lang.String getBankbik() {
	return bankbik;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @return java.lang.String
 */
public java.lang.String getBankname() {
	return bankname;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
    return "com.hps.july.arenda.cdbcobjects.CDBC_BankObject";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        isname.booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,
        bankname,
        isbik.booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,
        bankbik,
        getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:24)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsbik() {
	return isbik;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:39:55)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsname() {
	return isname;
}
/**
 * Insert the method's description here.
 * Creation date: (31.03.2005 16:59:53)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.BANKLOOKUP);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:44)
 * @param newBankbik java.lang.String
 */
public void setBankbik(java.lang.String newBankbik) {
	bankbik = newBankbik;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @param newName java.lang.String
 */
public void setBankname(java.lang.String newName) {
	bankname = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:24)
 * @param newIsbik java.lang.Boolean
 */
public void setIsbik(java.lang.Boolean newIsbik) {
	isbik = newIsbik;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:39:55)
 * @param newIsname java.lang.Boolean
 */
public void setIsname(java.lang.Boolean newIsname) {
	isname = newIsname;
}
/**
 * Insert the method's description here.
 * Creation date: (31.03.2005 16:59:53)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
}
