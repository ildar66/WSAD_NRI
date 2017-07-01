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
import java.sql.*;
/**
 * Form-Bean "Счета по абоненстским договорам"
 * Creation date: (16.09.2004 17:19:54)
 * @author: Shafigullin Ildar
 */
public class AbonentBillLookupListForm extends BrowseForm {
	private java.lang.String sortBy = "billnumber";
	private java.lang.String billType = "*";
	private java.lang.String formname = "";
	private java.lang.String fieldnames = "";
	private int leaseDocument;
	private boolean isBillNumber;
	private java.lang.String billNumber = "";
	private boolean isBillDate;
	private StringAndSqlDateProperty fromBillDate;
	private StringAndSqlDateProperty toBillDate;
/**
 * AbonentBill constructor comment.
 */
public AbonentBillLookupListForm() {
	super();
	setFinderMethodName("findListAbonentBills");
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	fromBillDate = new StringAndSqlDateProperty();
	fromBillDate.setSqlDate(date);
	toBillDate = new StringAndSqlDateProperty();
	toBillDate.setSqlDate(date);	
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
		System.out.println("AbonentBillLookupListForm: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	AbonentBill_VO vo = new AbonentBill_VO((CDBCRowObject) o);
	return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 18:01:35)
 * @return java.lang.String
 */
public java.lang.String getBillNumber() {
	return billNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:29:03)
 * @return java.lang.String
 */
public java.lang.String getBillType() {
	return billType;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_AbonentBills_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:30:06)
 * @return java.lang.String
 */
public java.lang.String getFieldnames() {
	return fieldnames;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (16.09.2004 17:19:54)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		Boolean.TRUE, new Integer(getLeaseDocument()),
		new Boolean(isIsBillNumber()), getBillNumber(),
		new Boolean(isIsBillDate()), getFromBillDate(), getToBillDate(),
		getBillType().equals("*") ? Boolean.FALSE : Boolean.TRUE, getBillType(),
		getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:29:33)
 * @return java.lang.String
 */
public java.lang.String getFormname() {
	return formname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 18:03:27)
 * @return java.sql.Date
 */
public Date getFromBillDate() {
	return fromBillDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (17.09.2004 12:46:48)
 */
public String getFromBillDateStr() {
	return fromBillDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:32:10)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:26:02)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 18:03:48)
 * @return java.sql.Date
 */
public java.sql.Date getToBillDate() {
	return toBillDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (17.09.2004 12:47:49)
 */
public String getToBillDateStr() {
	return toBillDate.getString();
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILL_LOOKUP_LIST);
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:58:35)
 * @return boolean
 */
public boolean isIsBillDate() {
	return isBillDate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:59:08)
 * @return boolean
 */
public boolean isIsBillNumber() {
	return isBillNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 18:01:35)
 * @param newBillNumber java.lang.String
 */
public void setBillNumber(java.lang.String newBillNumber) {
	billNumber = newBillNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:29:03)
 * @param newBilltype java.lang.String
 */
public void setBillType(java.lang.String newBillType) {
	billType = newBillType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:30:06)
 * @param newFieldnames java.lang.String
 */
public void setFieldnames(java.lang.String newFieldnames) {
	fieldnames = newFieldnames;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:29:33)
 * @param newFormname java.lang.String
 */
public void setFormname(java.lang.String newFormname) {
	formname = newFormname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 18:03:27)
 * @param newFromBillDate java.sql.Date
 */
public void setFromBillDate(Date newFromBillDate) {
	fromBillDate.setSqlDate(newFromBillDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.09.2004 16:13:13)
 */
public void setFromBillDateStr(String newFromBillDateStr) {
	fromBillDate.setString(newFromBillDateStr);
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:58:35)
 * @param newIsBillDate boolean
 */
public void setIsBillDate(boolean newIsBillDate) {
	isBillDate = newIsBillDate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:59:08)
 * @param newIsBillNumber boolean
 */
public void setIsBillNumber(boolean newIsBillNumber) {
	isBillNumber = newIsBillNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:32:10)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 17:26:02)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 18:03:48)
 * @param newToBillDate java.sql.Date
 */
public void setToBillDate(java.sql.Date newToBillDate) {
	toBillDate.setSqlDate(newToBillDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.09.2004 16:14:14)
 */
public void setToBillDateStr(String newToBillDateStr) {
	toBillDate.setString(newToBillDateStr);
}
}
