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
 * ‘орма списка банков.
* Creation date: (21.03.2006 12:31:22)
* @author: Shafigullin Ildar
*/
public class BanksListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String name;
    private java.lang.Boolean isName;
    private java.lang.Boolean isBik;
    private java.lang.String bik;
    private java.lang.String sortBy; //признак сортировки
/**
 * ‘орма дл€ справочника банков
 */
public BanksListForm() {
    super();
    this.setFinderMethodName("findList");
    isName = java.lang.Boolean.FALSE;
    name = "";
    isBik = java.lang.Boolean.TRUE;
    bik = "";
    setLastVisited(true);
    sortBy = "name desc";
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:34:56)
 * @return java.lang.String
 */
public java.lang.String getBik() {
	return bik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:14)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * ¬озвращает им€ bean дл€ броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_Banks_Object";
}
/**
 * ¬озвращает список ролей, которым разрешено редактирование.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("developer");
	roles.add("editBank");
	return roles;
}
/**
 * ¬озвращает параметры, которые будут подставл€тс€ в метод поиска данных.
 * Creation date: (23.03.2005 12:31:22)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        isName.booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,
        name,
        isBik.booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,
        bik,
        getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:34:26)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsBik() {
	return isBik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:59)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsName() {
	return isName;
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
 * »нициализаци€ режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.BANKS_LIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:34:56)
 * @param newBankbik java.lang.String
 */
public void setBik(java.lang.String newBankbik) {
	bik = newBankbik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:14)
 * @param newBankname java.lang.String
 */
public void setName(java.lang.String newBankname) {
	name = newBankname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:34:26)
 * @param newIsbik java.lang.Boolean
 */
public void setIsBik(java.lang.Boolean newIsbik) {
	isBik = newIsbik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:33:59)
 * @param newIsname java.lang.Boolean
 */
public void setIsName(java.lang.Boolean newIsname) {
	isName = newIsname;
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
