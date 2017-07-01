package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Форма списка документов "Акты замены/модернизации на позиции"
 */
public class ChangePListForm
	extends AbstractChangeListForm
{
	private Boolean isposition;
	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;
public ChangePListForm() {
	super();
	isposition = Boolean.FALSE;
	position = new StringAndIntegerProperty();
	positionname = "";
	positionid = "";
	this.setFinderMethodName( "listChangeActOnPositionDocuments" );
	setLastVisited(true);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("TechStuff");
	roles.add("siteExploitor");
	roles.add("siteStation");
	roles.add("siteTransport");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		Boolean.TRUE, getDatefrom(), getDateto(),
		Boolean.TRUE.equals(getIsowner())?Boolean.FALSE:Boolean.TRUE, (getOwner() == null)?new Integer(0):getOwner(),
		Boolean.TRUE.equals(getIsposition())?Boolean.FALSE:Boolean.TRUE, (getPosition() == null)?new Integer(0):getPosition(),
		(getActtype() != null)?new Character(getActtype().charAt(0)):new Character('A'),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listChangeActOnPositionDocuments";
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsposition() {
	return isposition;
}
public java.lang.Integer getPosition() {
	return position.getInteger();
}
public String getPositioncode() {
	return position.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.CHPLIST);
	if(getPosition() != null) {
		try {
			PositionAccessBean bean = new PositionAccessBean();
			bean.setInitKey_storageplace(getPosition().intValue());
			bean.refreshCopyHelper();
			setPositionname(bean.getName());
			setPositionid("");
			if(bean.getGsmid() != null) {
				setPositionid("D"+bean.getGsmid()+" ");
			}
			if(bean.getDampsid() != null) {
				setPositionid(getPositionid()+"A"+bean.getDampsid()+" ");
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return super.initBrowse(mapping,request,response);
}
/**
 * 
 * @param newIsposition java.lang.Boolean
 */
public void setIsposition(java.lang.Boolean newIsposition) {
	isposition = newIsposition;
}
public void setPosition(Integer number) {
	position.setInteger(number);
}
public void setPositioncode(String number) {
	position.setString(number);
}
/**
 * 
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
}
