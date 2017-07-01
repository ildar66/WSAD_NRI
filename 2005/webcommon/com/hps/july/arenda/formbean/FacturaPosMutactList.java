package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма позиций фактуры(список).
 * Creation date: (25.05.2003 15:35:19)
 * @author: Sergey Gourov
 */
public class FacturaPosMutactList extends com.hps.july.web.util.BrowseForm {
	private int idSchetFact;
	private java.lang.String numberSchetFakt;
	private java.sql.Date dateSchetFakt;
	private java.lang.String executor;
	private java.lang.String customer;
	private java.math.BigDecimal sum;
	private java.lang.String currency;
/**
 * FacturaPosMutactList constructor comment.
 */
public FacturaPosMutactList() {
	setFinderMethodName("findByIdSchetFaktOrderByPosorderAsc");
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:11:10)
 * @return java.lang.String
 */
public java.lang.String getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:08:03)
 * @return java.lang.String
 */
public java.lang.String getCustomer() {
	return customer;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:06:12)
 * @return java.sql.Date
 */
public java.sql.Date getDateSchetFakt() {
	return dateSchetFakt;
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
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:07:50)
 * @return java.lang.String
 */
public java.lang.String getExecutor() {
	return executor;
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2003 15:35:19)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(getIdSchetFact()) };
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2003 15:43:00)
 * @return int
 */
public int getIdSchetFact() {
	return idSchetFact;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:05:02)
 * @return java.lang.String
 */
public java.lang.String getNumberSchetFakt() {
	return numberSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:08:49)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:11:10)
 * @param newCurrency java.lang.String
 */
public void setCurrency(java.lang.String newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:08:03)
 * @param newCustomer java.lang.String
 */
public void setCustomer(java.lang.String newCustomer) {
	customer = newCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:06:12)
 * @param newDateSchetFakt java.sql.Date
 */
public void setDateSchetFakt(java.sql.Date newDateSchetFakt) {
	dateSchetFakt = newDateSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:07:50)
 * @param newExecutor java.lang.String
 */
public void setExecutor(java.lang.String newExecutor) {
	executor = newExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2003 15:43:00)
 * @param newIdSchetFact int
 */
public void setIdSchetFact(int newIdSchetFact) {
	idSchetFact = newIdSchetFact;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:05:02)
 * @param newNumberSchetFakt java.lang.String
 */
public void setNumberSchetFakt(java.lang.String newNumberSchetFakt) {
	numberSchetFakt = newNumberSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 10:08:49)
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum = newSum;
}
}
