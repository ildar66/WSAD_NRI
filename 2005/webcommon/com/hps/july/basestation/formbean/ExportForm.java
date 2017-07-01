package com.hps.july.basestation.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.util.ListIterator;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.constants.*;
import com.hps.july.jdbcpersistence.lib.*;


/**
 * Форма загрузки данных
 */
public class ExportForm extends com.hps.july.web.util.EditForm{
	private java.util.Vector regions;
	private StringAndInteger regioncode = new StringAndInteger();
	private java.lang.String proc;
	private String merid;
	private boolean recountCoord;
public ExportForm(){	
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 11:14:39)
 * @return java.lang.String
 */
public String getAction() {
	return "Edit";
}
public int getApplication() {
return Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 17:32:01)
 * @return com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public String getMerid() {
	return merid;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 17:19:28)
 * @return java.lang.String
 */
public java.lang.String getProc() {
	return proc;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 17:35:02)
 * @return java.lang.String
 */
public boolean getRecountCoord() {
	return recountCoord;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 16:34:59)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getRegioncode() throws Exception{
	return getRegionProp().getString();
}
public StringAndInteger getRegionProp() throws Exception {
	DebugSupport.printlnTest("getRegioncode started");
	if(regioncode==null){
		ListIterator li = getRegions().listIterator();
		if (li.hasNext()) {
			com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)li.next();
			Integer id=(Integer)(ro.getColumn("regionid").asObject());
			DebugSupport.printlnTest("getRegioncode id="+id);
			regioncode=new StringAndInteger();
			regioncode.setInteger(id);
		}
	}
	return regioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 16:16:46)
 * @return java.util.Vector
 */
public com.hps.july.cdbc.lib.CDBCResultSet getRegions() throws Exception {
    try {
	    com.hps.july.cdbc.lib.CDBCResultSet vec = null;	    
        vec = new com.hps.july.cdbc.objects.CDBCRegionsObject().findAllRegions(null, true);       
        return vec;
    } catch (Exception e) {	   
	    DebugSupport.printlnError(e);
        throw e;
    }
}
public int getState(){
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 17:32:01)
 * @param newMerid com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public void setMerid(String newMerid) {
	merid = newMerid;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 17:19:28)
 * @param newProc java.lang.String
 */
public void setProc(java.lang.String newProc) {
	proc = newProc;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 17:35:02)
 * @param newRecountCoord java.lang.String
 */
public void setRecountCoord(boolean newRecountCoord) {
	recountCoord = newRecountCoord;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2005 16:34:59)
 * @param newRegioncode com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setRegioncode(String newRegioncode) {
	regioncode.setString(newRegioncode);
}
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception{
	return null;
}
}
