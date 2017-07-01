package com.hps.july.dataimport.dataobjects;

import java.util.*;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
 
/**
 * Блок данных.
 * Creation date: (05.06.2003 18:38:57)
 * @author: Alexander Shrago
 */
public class BlockData extends Hashtable {

private Integer sessid;	
private int rowStart;
private int reccount;
private int errcount;	
	
	private Map prop;
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 20:01:53)
 */
public BlockData() {}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 20:01:53)
 */
public BlockData(int sessid,int rowStart,Map cellData,Map prop) {
	
	this.sessid=new Integer(sessid);
	this.rowStart=rowStart;
	putAll(cellData);
	//putAll(prop);
	this.prop=prop;
	}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 20:52:34)
 * @return int
 */
public int getErrcount() {
	return errcount;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:17:29)
 * @return java.util.Map
 */
public java.util.Map getProp() {
	return prop;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 20:52:34)
 * @return int
 */
public int getReccount() {
	return reccount;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:17:29)
 * @return int
 */
public int getRowStart() {
	return rowStart;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:17:29)
 * @return java.lang.Integer
 */
public java.lang.Integer getSessid() {
	return sessid;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 20:54:38)
 * @return int
 */
public int incErrcount() {
	return ++errcount;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 20:54:38)
 * @return int
 */
public int incReccount() {
	return ++reccount;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:17:29)
 * @param newProp java.util.Map
 */
public void setProp(java.util.Map newProp) {
	prop = newProp;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:17:29)
 * @param newRowStart int
 */
public void setRowStart(int newRowStart) {
	rowStart = newRowStart;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:17:29)
 * @param newSessid java.lang.Integer
 */
public void setSessid(java.lang.Integer newSessid) {
	sessid = newSessid;
}
}
