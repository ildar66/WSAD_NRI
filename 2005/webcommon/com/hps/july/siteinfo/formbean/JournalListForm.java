package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import java.util.*;
import com.hps.july.persistence.*;

/**
 * Форма просмотра журнала изменений
 */
public class JournalListForm extends com.hps.july.web.util.BrowseForm {
	private String objecttype;
	private Integer objectid;
	private String objecttypename;
	private String objectname;
	private Boolean isPeriod;
	private StringAndSqlDateProperty datestart;
	private StringAndSqlDateProperty dateend;
	private StringAndIntegerProperty user;
	private String userfullname;
public JournalListForm() {
	datestart = new StringAndSqlDateProperty();
	dateend = new StringAndSqlDateProperty();
	isPeriod = Boolean.TRUE;
	objectid = new Integer(0);
	objecttype = "0";
	user = new StringAndIntegerProperty();
	this.setFinderMethodName( "findByQBE" );
}
public java.sql.Date getDateend() {
	return dateend.getSqlDate();
}
public String getDateendFrm() {
	return dateend.getString();
}
public java.sql.Date getDatestart() {
	return datestart.getSqlDate();
}
public String getDatestartFrm() {
	return datestart.getString();
}
public java.lang.Object[] getFilterParams() {
	if(objecttype == null) {
		objecttype = "0";
	}
	return new Object[] {
		Boolean.TRUE, new Short(objecttype),
        Boolean.TRUE, objectid,
//		(isPeriod.booleanValue())?Boolean.FALSE:Boolean.TRUE,
		Boolean.FALSE,
		(datestart.isEmpty())?new java.sql.Timestamp(0):new java.sql.Timestamp(datestart.getSqlDate().getTime()),
		(dateend.isEmpty())?new java.sql.Timestamp(System.currentTimeMillis()):new java.sql.Timestamp(dateend.getSqlDate().getTime()),
		Boolean.FALSE, (user.getInteger() != null)?user.getInteger():new Integer(0),
		Boolean.FALSE, "",
		new Integer(4)
	};
}
public java.lang.Boolean getIsPeriod() {
	return isPeriod;
}
public java.lang.Integer getObjectid() {
	return objectid;
}
public java.lang.String getObjectname() {
	return objectname;
}
public java.lang.String getObjecttype() {
	return objecttype;
}
public java.lang.String getObjecttypename() {
	return objecttypename;
}
public java.lang.Integer getUser() {
	return user.getInteger();
}
public String getUserFrm() {
	return user.getString();
}
public java.lang.String getUserfullname() {
	return userfullname;
}
public void setDateend(java.sql.Date newDate) {
	dateend.setSqlDate(newDate);
}
public void setDateendFrm(String newDate) {
	dateend.setString(newDate);
}
public void setDatestart(java.sql.Date newDate) {
	datestart.setSqlDate(newDate);
}
public void setDatestartFrm(String newDate) {
	datestart.setString(newDate);
}
public void setIsPeriod(java.lang.Boolean newIsPeriod) {
	isPeriod = newIsPeriod;
}
public void setObjectid(java.lang.Integer newObjectid) {
	objectid = newObjectid;
}
public void setObjectname(java.lang.String newObjectname) {
	objectname = newObjectname;
}
public void setObjecttype(java.lang.String newObjecttype) {
	objecttype = newObjecttype;
}
public void setObjecttypename(java.lang.String newObjecttypename) {
	objecttypename = newObjecttypename;
}
public void setUser(Integer newUser) {
	user.setInteger(newUser);
}
public void setUserFrm(String newUser) {
	user.setString(newUser);
}
public void setUserfullname(java.lang.String newUserfullname) {
	userfullname = newUserfullname;
}
}
