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
* Insert the type's description here.
* Creation date: (04.10.2005 11:37:58)
* @author: Shafigullin Ildar
*/
public class PersonListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String sortBy;
    private java.lang.Boolean isName;
    private java.lang.String name;
/**
 * PersonListForm constructor comment.
 */
public PersonListForm() {
    super();
    setFinderMethodName("findListPerson");
    isName = java.lang.Boolean.FALSE;
    name = "";
    sortBy = "lastname";
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	CDBCRowObject ro = (CDBCRowObject) o;
	Person_VO vo = new Person_VO(ro);
	vo.setName(ro.getColumn("name").asString());
    return vo;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
    return "com.hps.july.arenda.cdbcobjects.CDBC_Person_Object";
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (04.10.2005 11:37:58)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] { getIsName().booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE, getName(), getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2005 15:25:51)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsName() {
	return isName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2005 12:10:25)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2005 11:38:47)
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
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.PERSON_LIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2005 15:25:51)
 * @param newIsName java.lang.Boolean
 */
public void setIsName(java.lang.Boolean newIsName) {
	isName = newIsName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2005 12:10:25)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2005 11:38:47)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
}
