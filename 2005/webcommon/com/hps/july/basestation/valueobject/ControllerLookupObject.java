package com.hps.july.basestation.valueobject;

import java.util.*;
import java.sql.*;

/**
 * —лужебный класс-контейнер с параметрами контроллера
 * »спользуетс€ в форме выбора контроллера
 */
public class ControllerLookupObject {
	private int contrcode;
	private Integer contrnumber;
	private String contrname;
	private String contrposname;

//	private String planstate;
	
	private Integer swcode;
	private Integer swnumber;
	private String swname;
	private String swposname;
public ControllerLookupObject() {
	super();
}
public ControllerLookupObject(ResultSet rs)
	throws Exception
{
	contrcode = rs.getInt("contrcode");
	contrname = rs.getString("contrname");
	contrnumber = getInteger(rs,"contrnumber");
	contrposname = rs.getString("contrposname");
//	planstate = rs.getString("planstate");
	swcode = getInteger(rs,"swcode");
	swnumber = getInteger(rs,"swnumber");
	swname = rs.getString("swname");
	swposname = rs.getString("swposname");
}
/**
 * 
 * @return int
 */
public int getContrcode() {
	return contrcode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getContrname() {
	return contrname;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getContrnumber() {
	return contrnumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getContrposname() {
	return contrposname;
}
public Integer getInteger(ResultSet rs, String fname)
	throws java.lang.Exception
{
	int i = rs.getInt(fname);
	if(rs.wasNull()) {
		return null;
	} else {
		return new Integer(i);
	}
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getSwcode() {
	return swcode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSwname() {
	return swname;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getSwnumber() {
	return swnumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSwposname() {
	return swposname;
}
/**
 * 
 * @param newContrcode int
 */
public void setContrcode(int newContrcode) {
	contrcode = newContrcode;
}
/**
 * 
 * @param newContrname java.lang.String
 */
public void setContrname(java.lang.String newContrname) {
	contrname = newContrname;
}
/**
 * 
 * @param newContrnumber java.lang.Integer
 */
public void setContrnumber(java.lang.Integer newContrnumber) {
	contrnumber = newContrnumber;
}
/**
 * 
 * @param newContrposname java.lang.String
 */
public void setContrposname(java.lang.String newContrposname) {
	contrposname = newContrposname;
}
/**
 * 
 * @param newSwcode java.lang.Integer
 */
public void setSwcode(java.lang.Integer newSwcode) {
	swcode = newSwcode;
}
/**
 * 
 * @param newSwname java.lang.String
 */
public void setSwname(java.lang.String newSwname) {
	swname = newSwname;
}
/**
 * 
 * @param newSwnumber java.lang.Integer
 */
public void setSwnumber(java.lang.Integer newSwnumber) {
	swnumber = newSwnumber;
}
/**
 * 
 * @param newSwposname java.lang.String
 */
public void setSwposname(java.lang.String newSwposname) {
	swposname = newSwposname;
}
}
