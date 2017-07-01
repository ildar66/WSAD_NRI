package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.ValidationException;
import org.apache.struts.action.ActionErrors;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма списка номеров BeeNet на позиции
 */
public class BeenetListForm
	extends com.hps.july.web.util.BrowseForm
{
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private int order;
public BeenetListForm() {
	this.setFinderMethodName( "findPositionBeeNets" );
	storageplace = 0;
	posname = "";
	posid = "";
	order = 1;
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCBeenetObject";
}
public java.util.ArrayList getBsRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteStation");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("siteProjector");
	return roles;
}
public java.util.ArrayList getComRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	roles.add("siteExploitor");
	roles.add("siteStation");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("siteProjector");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (Exception e) {
		DebugSupport.printlnTest("BeenetListForm order not found " + e.getMessage());
	}
	return new Object[] { new Integer(storageplace), new Integer(order) };
}
public java.lang.String getFinderMethodName() {
	return "findPositionBeeNets";
}
public int getOrder() {
	return order;
}
public java.util.ArrayList getOtherRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
public java.lang.String getPosid() {
	return posid;
}
public java.lang.String getPosname() {
	return posname;
}
public int getStorageplace() {
	return storageplace;
}
public void setOrder(int newOrder) {
	order = newOrder;
}
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
public String toString() {
	StringBuffer buf = new StringBuffer();
	buf.append("BeenetListForm: order="+order);
	buf.append("; posid="+posid);
	buf.append("; posname"+posname);
	buf.append("; storageplace="+storageplace);
	return buf.toString();
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (!errors.empty())
		throw new ValidationException();
}
}
