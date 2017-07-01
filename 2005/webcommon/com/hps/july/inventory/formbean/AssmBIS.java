package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;

public class AssmBIS {
	private Integer type;
	private StringAndIntegerProperty count = new StringAndIntegerProperty();
	private String sn;
	private String note;
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getCount() {
	return count;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNote() {
	return note;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSn() {
	return sn;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getType() {
	return type;
}
/**
 * 
 * @param newNote java.lang.String
 */
public void setNote(java.lang.String newNote) {
	note = newNote;
}
/**
 * 
 * @param newSn java.lang.String
 */
public void setSn(java.lang.String newSn) {
	sn = newSn;
}
/**
 * 
 * @param newType java.lang.Integer
 */
public void setType(java.lang.Integer newType) {
	//System.out.println("**set type: " + newType);
	type = newType;
}
}
