package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Акт замены/модернизации на позиции"
 */
public class ChangePPositionListForm
	extends AbstractChangePositionListForm
{
	private String positionname;
	private String positionid;
	private String complectname;
	private int position;
	private int complect;
public ChangePPositionListForm() {
	positionname = null;
	positionid = null;
	complectname = null;
}
/**
 * 
 * @return int
 */
public int getComplect() {
	return complect;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
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
/**
 * 
 * @return int
 */
public int getPosition() {
	return position;
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
/**
 * 
 * @param newComplect int
 */
public void setComplect(int newComplect) {
	complect = newComplect;
}
/**
 * 
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * 
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
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
