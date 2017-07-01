package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.cdbc.lib.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Form-Bean "Соответствие между ресурсами Billing & NRI".
 * Creation date: (09.09.2004 14:52:44)
 * @author: Shafigullin Ildar
 */
public class LeaseResBil2nriLookupListForm extends BrowseForm {
	private int stateFilter = 1;
	private java.lang.String sortBy = "idresbilling";
	private java.lang.String filter = "";
	private java.lang.String typeRes = "*";//тип записи ('E' - оборудование, 'S' - услуги, 'C' - карты связи)
	private java.lang.String formname = "";
	private java.lang.String fieldnames = "";
/**
 * LeaseResBil2nriLookupListForm constructor comment.
 */
public LeaseResBil2nriLookupListForm() {
	super();
	setFinderMethodName("findListLeaseResBil2nri");
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
		System.out.println("LeaseResBil2nriLookupListForm: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	LeaseResBil2nri_VO vo = new LeaseResBil2nri_VO((CDBCRowObject) o);
	return vo;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_LeaseResBil2nri_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:58:31)
 * @return java.lang.String
 */
public java.lang.String getFieldnames() {
	return fieldnames;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:29:16)
 * @return java.lang.String
 */
public java.lang.String getFilter() {
	return filter;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (09.09.2004 14:52:44)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getStateFilter() == 0 ? Boolean.TRUE : Boolean.FALSE,
		getFilter(),
		getStateFilter() == 1 ? Boolean.TRUE : Boolean.FALSE,
		getFilter(),
		getTypeRes().equals("*") ? Boolean.FALSE : Boolean.TRUE ,
		getTypeRes(),
		getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:58:09)
 * @return java.lang.String
 */
public java.lang.String getFormname() {
	return formname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:28:06)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:27:33)
 * @return int
 */
public int getStateFilter() {
	return stateFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:37:48)
 * @return java.lang.String
 */
public java.lang.String getTypeRes() {
	return typeRes;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.LEASE_RES_BIL_2NRI_LOOKUP_LIST);
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:58:31)
 * @param newFieldnames java.lang.String
 */
public void setFieldnames(java.lang.String newFieldnames) {
	fieldnames = newFieldnames;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:29:16)
 * @param newFilter java.lang.String
 */
public void setFilter(java.lang.String newFilter) {
	filter = newFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:58:09)
 * @param newFormname java.lang.String
 */
public void setFormname(java.lang.String newFormname) {
	formname = newFormname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:28:06)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:27:33)
 * @param newStateFilter int
 */
public void setStateFilter(int newStateFilter) {
	stateFilter = newStateFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 15:37:48)
 * @param newTypeRes java.lang.String
 */
public void setTypeRes(java.lang.String newTypeRes) {
	typeRes = newTypeRes;
}
}
