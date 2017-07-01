package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.io.IOException;

import com.hps.july.cdbc.lib.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
/**
* Информация о доставке счетов.
* Creation date: (20.01.2005 11:26:21)
* @author: Shafigullin Ildar
*/
public class CourierDeliveryListForm extends com.hps.july.web.util.BrowseForm {
    private int leaseDocument;
    private java.lang.String sortBy = "delivery_date";
    private java.lang.Boolean isDate;
    private StringAndSqlDateProperty fromDate;
    private StringAndSqlDateProperty toDate;
    private java.lang.Boolean isDocument_No;
    private java.lang.String searchString = "";
/**
 * CourierDeliveryListForm constructor comment.
 */
public CourierDeliveryListForm() {
    super();
    setFinderMethodName("findListCourierDelivery");

    setIsDate(Boolean.FALSE);
    setIsDocument_No(Boolean.FALSE);
    
    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
    toDate = new StringAndSqlDateProperty();
    toDate.setSqlDate(date);
    fromDate = new StringAndSqlDateProperty();
    fromDate.setSqlDate(date);
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
        System.out.println("CourierDelivery_LIST: CLASS_CAST: " + o.getClass().getName());
        return o;
    }
    return new com.hps.july.arenda.valueobject.CourierDelivery_VO((CDBCRowObject) o);
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.arenda.cdbcobjects.CDBC_CourierDelivery_Object";
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (20.01.2005 11:26:21)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        new Integer(getLeaseDocument()),
        getIsDocument_No(),        getSearchString(),
        getIsDate(),        getFromDate(),        getToDate(),
        getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:54:31)
 */
private java.sql.Date getFromDate() {
	return fromDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:56:59)
 */
public String getFromDateFrm() {
	return fromDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 12:59:25)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate() {
	return isDate;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:33:32)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDocument_No() {
	return isDocument_No;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:29:22)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:47:02)
 * @return java.lang.String
 */
public java.lang.String getSearchString() {
	return searchString;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:30:16)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:54:44)
 */
private java.sql.Date getToDate() {
	return toDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:56:27)
 */
public String getToDateFrm() {
	return toDate.getString();
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.COURIER_DELIVERY_LIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:58:17)
 */
public void setFromDateFrm(String newFromDate) {
	fromDate.setString(newFromDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 12:59:25)
 * @param newIsDate java.lang.Boolean
 */
public void setIsDate(java.lang.Boolean newIsDate) {
	isDate = newIsDate;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:33:32)
 * @param newIsDocument_No java.lang.Boolean
 */
public void setIsDocument_No(java.lang.Boolean newIsDocument_No) {
	isDocument_No = newIsDocument_No;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:29:22)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:47:02)
 * @param newSearchString java.lang.String
 */
public void setSearchString(java.lang.String newSearchString) {
	searchString = newSearchString;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:30:16)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 14:58:49)
 */
public void setToDate(java.sql.Date newToDate) {
	toDate.setSqlDate(newToDate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2005 11:24:50)
 */
public void setToDateFrm(String newToDate) {
	toDate.setString(newToDate);
}
}
