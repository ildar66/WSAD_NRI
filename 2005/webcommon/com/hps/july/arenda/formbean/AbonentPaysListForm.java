package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.sql.*;
/**
 * Form-Bean 
 * лист "абонентские платежи".
 */
public class AbonentPaysListForm extends com.hps.july.web.util.BrowseForm {
    private int leaseDocument;
    private java.lang.Boolean isDate;
    private StringAndSqlDateProperty fromDate;
    private StringAndSqlDateProperty toDate;
    private String ban;
    private String customername;
    private String customerinn;
    private java.lang.String searchState;
    private java.lang.Integer order;
    private java.lang.String customernameBill;
    private java.lang.String customerinnBill;
    private java.lang.String searchUsenri;
    private java.lang.String sortBy = "paydate desc"; //признак сортировки
    private int[] flagworknri;
	private java.util.ArrayList oldFlagworknri;
	private boolean group;
	private int taskcode;
/**
 * AbonentBillsListForm constructor comment.
 */
public AbonentPaysListForm() {
	super();
	setFinderMethodName("2");
	order = new Integer(1);

	setIsDate(new Boolean(false));
	
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	fromDate = new StringAndSqlDateProperty();
	fromDate.setSqlDate(date);
	toDate = new StringAndSqlDateProperty();
	toDate.setSqlDate(date);
	setSearchState("0");
	setSearchUsenri("0");
}
public java.lang.String getBan() {
	return ban;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @return java.lang.String
 */
public java.lang.String getCustomerinn() {
	return customerinn;
}
/**
 * Insert the method's description here.
 * Creation date: (08.10.2002 10:53:00)
 * @return java.lang.String
 */
public java.lang.String getCustomerinnBill() {
	return customerinnBill;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @return java.lang.String
 */
public java.lang.String getCustomername() {
	return customername;
}
/**
 * Insert the method's description here.
 * Creation date: (08.10.2002 10:53:00)
 * @return java.lang.String
 */
public java.lang.String getCustomernameBill() {
	return customernameBill;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("administrator");
	return roles;
}
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        new Integer(leaseDocument),
        Boolean.TRUE.equals(isDate) ? Boolean.FALSE : Boolean.TRUE,        fromDate.getSqlDate(),        toDate.getSqlDate(),
        getSearchUsenri().equals("0") ? Boolean.FALSE : Boolean.TRUE,        getSearchUsenri().equals("1") ? Boolean.TRUE : Boolean.FALSE,
        sortBy};
}
public java.lang.String getFinderMethodName() {
	return "findByDocumentQBE2";
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 18:33:18)
 * @return int[]
 */
public int[] getFlagworknri() {
	return flagworknri;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @return StringAndSqlDateProperty
 */
public Date getFromDate() {
	return fromDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @return StringAndSqlDateProperty
 */
public String getFromDateFrm() {
	return fromDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate() {
	return isDate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 17:26:58)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 18:41:34)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getOldFlagworknri() {
	return oldFlagworknri;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 17:36:12)
 * @return java.lang.String
 */
public java.lang.String getSearchState() {
	return searchState;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2003 14:35:06)
 * @return java.lang.String
 */
public java.lang.String getSearchUsenri() {
	return searchUsenri;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 14:19:26)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2005 11:49:49)
 * @return int
 */
public int getTaskcode() {
	return taskcode;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @return StringAndSqlDateProperty
 */
public Date getToDate() {
	return toDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @return StringAndSqlDateProperty
 */
public String getToDateFrm() {
	return toDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2005 11:34:20)
 * @return boolean
 */
public boolean isGroup() {
	return group;
}
/**
 * Reset all bean properties to their default state.  This method is
 * called before the properties are repopulated by the controller servlet.
 * <p>
 * The default implementation does nothing.  Subclasses should override
 * this method to reset all bean properties to default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 */
public void reset(org.apache.struts.action.ActionMapping mapping,  javax.servlet.http.HttpServletRequest request) {
    setGroup(false);
    flagworknri = new int[0];
    taskcode = 0;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newBan java.lang.String
 */
public void setBan(java.lang.String newBan) {
	ban = newBan;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newCustomerinn java.lang.String
 */
public void setCustomerinn(java.lang.String newCustomerinn) {
	customerinn = newCustomerinn;
}
/**
 * Insert the method's description here.
 * Creation date: (08.10.2002 10:53:00)
 * @param newCustomerinnBill java.lang.String
 */
public void setCustomerinnBill(java.lang.String newCustomerinnBill) {
	customerinnBill = newCustomerinnBill;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newCustomername java.lang.String
 */
public void setCustomername(java.lang.String newCustomername) {
	customername = newCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (08.10.2002 10:53:00)
 * @param newCustomernameBill java.lang.String
 */
public void setCustomernameBill(java.lang.String newCustomernameBill) {
	customernameBill = newCustomernameBill;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 18:33:18)
 * @param newFlagworknri int[]
 */
public void setFlagworknri(int[] newFlagworknri) {
	flagworknri = newFlagworknri;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newFromDate StringAndSqlDateProperty
 */
public void setFromDate(Date newFromDate) {
	fromDate.setSqlDate(newFromDate);
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newFromDate StringAndSqlDateProperty
 */
public void setFromDateFrm(String newFromDate) {
	fromDate.setString(newFromDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2005 11:34:20)
 * @param newGroup boolean
 */
public void setGroup(boolean newGroup) {
	group = newGroup;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newIsDate java.lang.Boolean
 */
public void setIsDate(java.lang.Boolean newIsDate) {
	isDate = newIsDate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 17:26:58)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 18:41:34)
 * @param newOldFlagworknri java.util.ArrayList
 */
public void setOldFlagworknri(java.util.ArrayList newOldFlagworknri) {
	oldFlagworknri = newOldFlagworknri;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 17:36:12)
 * @param newSearchState java.lang.String
 */
public void setSearchState(java.lang.String newSearchState) {
	searchState = newSearchState;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2003 14:35:06)
 * @param newSearchUsenri java.lang.String
 */
public void setSearchUsenri(java.lang.String newSearchUsenri) {
	searchUsenri = newSearchUsenri;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 14:19:26)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2005 11:49:49)
 * @param newTaskcode int
 */
public void setTaskcode(int newTaskcode) {
	taskcode = newTaskcode;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newToDate StringAndSqlDateProperty
 */
public void setToDate(Date newToDate) {
	toDate.setSqlDate(newToDate);
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 12:34:50)
 * @param newToDate StringAndSqlDateProperty
 */
public void setToDateFrm(String newToDate) {
	toDate.setString(newToDate);
}
}
