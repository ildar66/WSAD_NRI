package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Bean-form
 * Форма "Лист позиций".
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class PositionMultiListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Integer netzone;
	private int searchmode;
	private java.lang.String searchstr;
	private java.lang.Boolean isnetzone;
	private java.lang.Integer order;
	private java.lang.Boolean isWorker;
	private java.lang.Integer worker;
	private java.lang.String workername;
	private java.lang.Boolean isRenter;
	private java.lang.Integer organization;
	private java.lang.String orgname;
	private java.lang.String inaction;
	private int[] selectedPos;
	private int leaseDocumentcode;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public PositionMultiListForm() {
	this.setFinderMethodName( "1" );
	order = new Integer(1);
	isnetzone = Boolean.TRUE;
	netzone = new Integer(0);
	order = new Integer(3); // Order by name asc
	searchmode = 3; // Show all
	searchstr = "";
	worker = new java.lang.Integer(0);
	organization = new java.lang.Integer(0);
	workername = "";
	orgname = "";
	isWorker = java.lang.Boolean.TRUE;
	isRenter = java.lang.Boolean.TRUE;
	inaction = "A";
	selectedPos = new int [0];
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	Boolean isGsm;
	String argGsm;
	Boolean isDamps;
	String argDamps;
	Boolean isName;
	String argName;
	Boolean isAddr;
	String argAddr;

	switch(searchmode) {
	case 1: // GSM id
		isGsm = Boolean.TRUE; argGsm = searchstr;
		isDamps = Boolean.FALSE; argDamps = "";
		isName = Boolean.FALSE; argName = "";
		isAddr = Boolean.FALSE; argAddr = "";
		break;
	case 2: // DAMPS id
		isGsm = Boolean.FALSE; argGsm = "";
		isDamps = Boolean.TRUE; argDamps = searchstr;
		isName = Boolean.FALSE; argName = "";
		isAddr = Boolean.FALSE; argAddr = "";
		break;
	case 3: // Name
		isGsm = Boolean.FALSE; argGsm = "";
		isDamps = Boolean.FALSE; argDamps = "";
		isName = Boolean.TRUE; argName = searchstr;
		isAddr = Boolean.FALSE; argAddr = "";
		break;
	case 4: // Address
		isGsm = Boolean.FALSE; argGsm = "";
		isDamps = Boolean.FALSE; argDamps = "";
		isName = Boolean.FALSE; argName = "";
		isAddr = Boolean.TRUE; argAddr = searchstr;
		break;
	default:
		searchmode = 0;
		isGsm = Boolean.FALSE; argGsm = "";
		isDamps = Boolean.FALSE; argDamps = "";
		isName = Boolean.FALSE; argName = "";
		isAddr = Boolean.FALSE; argAddr = "";
	}
	try {
	  order = new Integer(Integer.parseInt(super.getFinderMethodName()));
	} catch (NumberFormatException e) {
	}
	
	Boolean isInAction = Boolean.FALSE;
	String inAct = "";

	if ("A".equals(getInaction())) {
		isInAction = Boolean.FALSE;
		inAct = "";
	}
	if ("B".equals(getInaction())) {
		isInAction = Boolean.TRUE;
		inAct = "Y";
	}
	if ("C".equals(getInaction())) {
		isInAction = Boolean.TRUE;
		inAct = "N";
	}
	
	return new Object[] { isnetzone.booleanValue()?Boolean.FALSE:Boolean.TRUE, netzone, 
		isGsm, argGsm, isDamps, argDamps, isName, argName, isAddr, argAddr, 
		isRenter.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, organization,
		isWorker.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, worker,
		isInAction, inAct, 
		order };
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE3";
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2002 16:10:43)
 * @return java.lang.String
 */
public java.lang.String getInaction() {
	return inaction;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:39:25)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsnetzone() {
	return isnetzone;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:28:37)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsRenter() {
	return isRenter;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:27:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsWorker() {
	return isWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 13:04:12)
 * @return int
 */
public int getLeaseDocumentcode() {
	return leaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:12:41)
 * @return java.lang.Integer
 */
public java.lang.Integer getNetzone() {
	return netzone;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:40:27)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getNetzones() {
	try {
		NetZoneAccessBean bean = new NetZoneAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:43:34)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:28:52)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:29:06)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 */
public int getSearchmode() {
	return searchmode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:13:46)
 * @return java.lang.String
 */
public java.lang.String getSearchstr() {
	return searchstr;
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2002 12:41:05)
 * @return int[]
 */
public int[] getSelectedPos() {
	return selectedPos;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:27:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorker() {
	return worker;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:28:14)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2002 16:10:43)
 * @param newInaction java.lang.String
 */
public void setInaction(java.lang.String newInaction) {
	inaction = newInaction;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:39:25)
 * @param newIsnetzone java.lang.Boolean
 */
public void setIsnetzone(java.lang.Boolean newIsnetzone) {
	isnetzone = newIsnetzone;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:28:37)
 * @param newIsRenter java.lang.Boolean
 */
public void setIsRenter(java.lang.Boolean newIsRenter) {
	isRenter = newIsRenter;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:27:42)
 * @param newIsWorker java.lang.Boolean
 */
public void setIsWorker(java.lang.Boolean newIsWorker) {
	isWorker = newIsWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 13:04:12)
 * @param newLeaseDocumentcode int
 */
public void setLeaseDocumentcode(int newLeaseDocumentcode) {
	leaseDocumentcode = newLeaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:12:41)
 * @param newNetzone java.lang.Integer
 */
public void setNetzone(java.lang.Integer newNetzone) {
	netzone = newNetzone;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:43:34)
 * @param newOrder java.lang.Integer
 */
public void setOrder(java.lang.Integer newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:28:52)
 * @param newOrganization java.lang.Integer
 */
public void setOrganization(java.lang.Integer newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:29:06)
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
/**
 * Insert the method's description here.
 */
public void setSearchmode(int newSearchmode) {
	searchmode = newSearchmode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 10:13:46)
 * @param newSearchstr java.lang.String
 */
public void setSearchstr(java.lang.String newSearchstr) {
	searchstr = newSearchstr;
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2002 12:41:05)
 * @param newSelectedPos int[]
 */
public void setSelectedPos(int[] newSelectedPos) {
	selectedPos = newSelectedPos;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:27:59)
 * @param newWorker java.lang.Integer
 */
public void setWorker(java.lang.Integer newWorker) {
	worker = newWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 10:28:14)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
}
