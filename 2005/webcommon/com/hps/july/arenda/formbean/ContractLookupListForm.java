package com.hps.july.arenda.formbean;

/**
 * Поиск контрактов.
 * Creation date: (11.07.2002 15:38:37)
 * @author: Sergey Gourov
 */
public class ContractLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String contracttype;
//	private java.lang.Boolean isCustomer;
//	private Integer customercode;
//	private java.lang.String customername;
//	private java.lang.Boolean isExecutor;
//	private Integer executorcode;
//	private java.lang.String executorname;
	private Boolean isOrg;
	private Integer orgcode;
	private String orgname;
	private java.lang.Boolean isEconomist;
	private Integer economistcode;
	private java.lang.String economistname;
	private java.lang.Boolean isDocnumber;
	private java.lang.String docnumber;
	private java.lang.Boolean isOnlyWe;
/**
 * ContractLookupListForm constructor comment.
 */
public ContractLookupListForm() {
	super();
	setFinderMethodName("findByQBE");

	setContracttype("A");
	
	setIsOrg(Boolean.TRUE);
	setOrgcode(new Integer(0));
	setOrgname("");

	setIsEconomist(new Boolean(true));
	setEconomistcode(new Integer(0));
	setEconomistname("");

	setIsDocnumber(new Boolean(false));
	setDocnumber("");
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 15:46:28)
 * @return java.lang.String
 */
public java.lang.String getContracttype() {
	return contracttype;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @return java.lang.String
 */
public java.lang.String getDocnumber() {
	return docnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @return java.lang.Integer
 */
public java.lang.Integer getEconomistcode() {
	return economistcode;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @return java.lang.String
 */
public java.lang.String getEconomistname() {
	return economistname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 15:38:37)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
/*
	String contractType,
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Integer order
*/

	/* Если тип договора Аренда и указана организация то подставляем в исполнителя */
	boolean exec = "A".equals(getContracttype()) && !getIsOrg().booleanValue();
	/* Если тип договора Аб.Договор и указана организация то подставляем в заказчика */
	boolean cust = "C".equals(getContracttype()) && !getIsOrg().booleanValue();

	return new Object[] {
		getContracttype(), 
		new Boolean(cust), (getOrgcode() != null)?getOrgcode():new Integer(0),
		new Boolean(exec), (getOrgcode() != null)?getOrgcode():new Integer(0),
		getIsEconomist().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getEconomistcode(),
		getIsDocnumber().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getDocnumber(),
		new Integer(1)
	};
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDocnumber() {
	return isDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsEconomist() {
	return isEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 16:08:12)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsOnlyWe() {
	return isOnlyWe;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsOrg() {
	return isOrg;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getOrgcode() {
	return orgcode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 15:46:28)
 * @param newContracttype java.lang.String
 */
public void setContracttype(java.lang.String newContracttype) {
	contracttype = newContracttype;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @param newDocnumber java.lang.String
 */
public void setDocnumber(java.lang.String newDocnumber) {
	docnumber = newDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @param newEconomistcode java.lang.Integer
 */
public void setEconomistcode(java.lang.Integer newEconomistcode) {
	economistcode = newEconomistcode;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @param newEconomistname java.lang.String
 */
public void setEconomistname(java.lang.String newEconomistname) {
	economistname = newEconomistname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @param newIsDocnumber java.lang.Boolean
 */
public void setIsDocnumber(java.lang.Boolean newIsDocnumber) {
	isDocnumber = newIsDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 16:06:51)
 * @param newIsEconomist java.lang.Boolean
 */
public void setIsEconomist(java.lang.Boolean newIsEconomist) {
	isEconomist = newIsEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 16:08:12)
 * @param newIsOnlyWe java.lang.Boolean
 */
public void setIsOnlyWe(java.lang.Boolean newIsOnlyWe) {
	isOnlyWe = newIsOnlyWe;
}
/**
 * 
 * @param newIsOrg java.lang.Boolean
 */
public void setIsOrg(java.lang.Boolean newIsOrg) {
	isOrg = newIsOrg;
}
/**
 * 
 * @param newOrgcode java.lang.Integer
 */
public void setOrgcode(java.lang.Integer newOrgcode) {
	orgcode = newOrgcode;
}
/**
 * 
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
}
