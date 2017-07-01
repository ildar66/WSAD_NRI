package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 * Form-Bean.
 * лист "BEN"-ов.
 */
public class BensListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseDocument;
	private String ban;
	
public BensListForm() {
	super();
	setFinderMethodName("findLeaseAbonentBENsByLeaseabonentban");
}
public String getBan() {
	return ban;
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
	return new Object[] { new LeaseDocumentKey(leaseDocument) };
}
/**
 * 
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
public void setBan(String newBan) {
	ban = newBan;
}
/**
 * 
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
}
