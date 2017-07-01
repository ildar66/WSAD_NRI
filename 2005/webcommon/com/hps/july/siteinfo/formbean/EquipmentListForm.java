package com.hps.july.siteinfo.formbean;

import java.util.*;
import com.hps.july.web.util.ValidationException;
import org.apache.struts.action.ActionErrors;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма списка оборудования установленного на позиции
 */
public class EquipmentListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private int order;
public EquipmentListForm() {
	this.setFinderMethodName( "findPositionEquipment" );
	storageplace = 0;
	posname = "";
	posid = "";
	order = EquipmentObject.ORDER_TYPE_ASC;
}
public static String getBeenetListString(String equstr) {
	Integer equipment = null;
	try {
		equipment = new Integer(Integer.parseInt(equstr));
	} catch(Exception e) {
	}
	
	if(equipment == null) return "";
	com.hps.july.cdbc.lib.CDBCResultSet rs = (new com.hps.july.cdbc.objects.CDBCBeenetObject()).findEquipmentBeeNets(equipment,new Integer(1));
	
	Iterator it = rs.listIterator();
	String result = "";
	while(it.hasNext()) {
		com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
		if(ro.getColumn("beenetid").asObject() != null) {
			result += org.apache.struts.util.ResponseUtils.filter(ro.getColumn("beenetid").asString());
			if(it.hasNext()) {
				result += ", ";
			}
		}
	}
	return result;
}
public static String getBeenetListStringBR(String equstr) {
	Integer equipment = null;
	try {
		equipment = new Integer(Integer.parseInt(equstr));
	} catch(Exception e) {
	}
	
	if(equipment == null) return "";
	com.hps.july.cdbc.lib.CDBCResultSet rs = (new com.hps.july.cdbc.objects.CDBCBeenetObject()).findEquipmentBeeNets(equipment,new Integer(1));
	
	Iterator it = rs.listIterator();
	String result = "";
	while(it.hasNext()) {
		com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
		if(ro.getColumn("beenetid").asObject() != null) {
			result += org.apache.struts.util.ResponseUtils.filter(ro.getColumn("beenetid").asString());
			if(it.hasNext()) {
				result += ", ";
				result += "<BR>";
			}
		}
	}
	return result;
}
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.siteinfo.valueobject.EquipmentObject";
	return "com.hps.july.cdbc.objects.CDBCEquipmentObject";
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
		DebugSupport.printlnTest("EquipmentListForm order not found " + e.getMessage());
	}
	return new Object[] { new Integer(storageplace), new Integer(order) };
}
public java.lang.String getFinderMethodName() {
	return "findPositionEquipment";
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
public static String[] getOtv(String equstr)
{
	String[] result = { "", "" };
	Integer equipment = null;
	try {
		equipment = new Integer(Integer.parseInt(equstr));
	} catch(Exception e) {
	}
	
	if(equipment == null) return result;
	com.hps.july.cdbc.lib.CDBCResultSet rs = (new com.hps.july.cdbc.objects.CDBCComlinesObject()).findOtvEquipment(equipment);
	
	java.util.Iterator it = rs.listIterator();
	while(it.hasNext()) {
		com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
		if(ro.getColumn("beenetid").asObject() != null) {
			result[0] += org.apache.struts.util.ResponseUtils.filter(ro.getColumn("beenetid").asString());
			if(it.hasNext()) {
				result[0] += ", ";
				result[0] += "<BR>";
			}
		}
		if(ro.getColumn("otvetka").asObject() != null) {
			if(ro.getColumn("eid").asObject() != null) {
				String eid = ro.getColumn("eid").asString();
				result[1] += getBeenetListString(eid);
			}
			result[1] += " "+org.apache.struts.util.ResponseUtils.filter(ro.getColumn("otvetka").asString());
			if(it.hasNext()) {
				result[1] += ", ";
				result[1] += "<BR>";
			}
		}
	}
	return result;
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
	buf.append("order="+order);
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
