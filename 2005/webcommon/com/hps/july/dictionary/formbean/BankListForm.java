package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.lib.*;
/**
 * Форма списка банков.
* Creation date: (23.03.2005 12:31:22)
* @author: Shafigullin Ildar
*/
public class BankListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String bankname;
    private java.lang.Boolean isname;
    private java.lang.Boolean isbik;
    private java.lang.String bankbik;
    private java.lang.String sortBy; //признак сортировки
/**
 * Форма для справочника банков
 */
public BankListForm() {
    super();
    this.setFinderMethodName("findListBanks");
    isname = java.lang.Boolean.FALSE;
    bankname = "";
    isbik = java.lang.Boolean.TRUE;
    bankbik = "";
    setLastVisited(true);
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
		System.out.println("BankListForm: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	return new Bank_VO((CDBCRowObject)o);
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:34:56)
 * @return java.lang.String
 */
public java.lang.String getBankbik() {
	return bankbik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:14)
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
 * Возвращает список ролей, которым разрешено редактирование.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictPartAdmin");
	return roles;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (23.03.2005 12:31:22)
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
 * Creation date: (23.03.2005 12:34:26)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsbik() {
	return isbik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:59)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsname() {
	return isname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:38:19)
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
    ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.BANKLIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:34:56)
 * @param newBankbik java.lang.String
 */
public void setBankbik(java.lang.String newBankbik) {
	bankbik = newBankbik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:14)
 * @param newBankname java.lang.String
 */
public void setBankname(java.lang.String newBankname) {
	bankname = newBankname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:34:26)
 * @param newIsbik java.lang.Boolean
 */
public void setIsbik(java.lang.Boolean newIsbik) {
	isbik = newIsbik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:59)
 * @param newIsname java.lang.Boolean
 */
public void setIsname(java.lang.Boolean newIsname) {
	isname = newIsname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:38:19)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
}
