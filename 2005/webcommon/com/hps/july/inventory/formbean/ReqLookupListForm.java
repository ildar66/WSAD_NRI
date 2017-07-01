package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма выбора документа "Требование" для указания в расходной накладной
 */
public class ReqLookupListForm extends com.hps.july.web.util.BrowseForm {
	private static final Integer NULL_INT = new Integer(0);
	private static final java.sql.Date NULL_DATE = new java.sql.Date(0);
	
	private Boolean isposition;
	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;
public ReqLookupListForm() {
	this.setFinderMethodName( "findByQBE" );
	position = new StringAndIntegerProperty();
	positionname = "";
	positionid = "";
	isposition = Boolean.TRUE;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		Boolean.FALSE, NULL_DATE, NULL_DATE,
		Boolean.FALSE, NULL_INT,
		isposition.booleanValue()?Boolean.FALSE:Boolean.TRUE, (position.getInteger() != null)?position.getInteger():new Integer(0),
		"", // Request Type
		Boolean.FALSE, NULL_INT,
		Boolean.FALSE, NULL_INT,
		Boolean.TRUE
	};
}
public java.lang.Boolean getIsposition() {
	return isposition;
}
public Integer getPosition() {
	return position.getInteger();
}
public String getPositioncode() {
	return position.getString();
}
public java.lang.String getPositionid() {
	return positionid;
}
public java.lang.String getPositionname() {
	return positionname;
}
public void setIsposition(java.lang.Boolean newIsposition) {
	isposition = newIsposition;
}
public void setPosition(Integer newPosition) {
	position.setInteger(newPosition);
}
public void setPosition(String newPosition) {
	position.setString(newPosition);
}
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
}
