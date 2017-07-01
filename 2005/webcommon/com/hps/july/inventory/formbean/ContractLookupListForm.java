package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора контракта
 */
public class ContractLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private java.lang.Boolean alltypes;
	private java.lang.Integer supplytype;
	private java.lang.Boolean allowner;
	private java.lang.Integer owner;
	private java.lang.String ownername;
	private java.lang.Boolean allcontragent;
	private java.lang.Integer contragent;
	private java.lang.String contragentname;
	private java.lang.String name;
	private java.lang.Integer order;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ContractLookupListForm() {
	this.setFinderMethodName( "findContractByQBE2" );
	this.allcontragent = Boolean.TRUE;
	this.allowner = Boolean.TRUE;
	this.alltypes = Boolean.TRUE;
	this.contragent = new Integer(0);
	this.contragentname = "";
	this.owner = new Integer(0);
	this.name = "*";
	this.order = new Integer(5); // Order by contract number
	this.supplytype = new Integer(0);
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getAllcontragent() {
	return allcontragent;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getAllowner() {
	return allowner;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getAlltypes() {
	return alltypes;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getContragent() {
	return contragent;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @return java.lang.String
 */
public java.lang.String getContragentname() {
	return contragentname;
}
/**
 * Insert the method's description here.
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getAlltypes().booleanValue()?Boolean.FALSE:Boolean.TRUE,
		getSupplytype(),
		allowner.booleanValue()?Boolean.FALSE:Boolean.TRUE,
		(getOwner() != null)?getOwner():new Integer(0),
		allcontragent.booleanValue()?Boolean.FALSE:Boolean.TRUE,
		(getContragent() != null)?getContragent():new Integer(0),
		getName(),
		getOrder()
	};
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 */
public java.util.Enumeration getOrganizations() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwner() {
	return owner;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getSupplytype() {
	return supplytype;
}
/**
 * Insert the method's description here.
 */
public java.util.Enumeration getSupplytypes() {
	try {
		SupplyTypeAccessBean bean = new SupplyTypeAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @param newAllcontragent java.lang.Boolean
 */
public void setAllcontragent(java.lang.Boolean newAllcontragent) {
	allcontragent = newAllcontragent;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @param newAllowner java.lang.Boolean
 */
public void setAllowner(java.lang.Boolean newAllowner) {
	allowner = newAllowner;
}
/**
 * 
 * @param newAlltypes java.lang.Boolean
 */
public void setAlltypes(java.lang.Boolean newAlltypes) {
	alltypes = newAlltypes;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @param newContragent java.lang.Integer
 */
public void setContragent(java.lang.Integer newContragent) {
	contragent = newContragent;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @param newContragentname java.lang.String
 */
public void setContragentname(java.lang.String newContragentname) {
	contragentname = newContragentname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:06)
 * @param newOrder java.lang.Integer
 */
public void setOrder(java.lang.Integer newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @param newOwner java.lang.Integer
 */
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
}
/**
 * 
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 11:11:38)
 * @param newSupplytype java.lang.Integer
 */
public void setSupplytype(java.lang.Integer newSupplytype) {
	supplytype = newSupplytype;
}
}
