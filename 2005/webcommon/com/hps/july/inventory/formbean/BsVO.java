package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;

public class BsVO {
	private String name;
	private Integer type;
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getName() {
	return name;
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
 * @param newSn java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
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
