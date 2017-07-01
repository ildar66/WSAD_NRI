/*
 * Created on 15.03.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

import com.hps.july.cdbc.lib.CDBCRowObject;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ResourceclassRow {
	private String classid;
	private String classname;
	
	public ResourceclassRow(CDBCRowObject row){
		if (row.hasColumn("classid")) setClassid(row.getColumn("classid").asString());
		if (row.hasColumn("classname")) setClassname(row.getColumn("classname").asString());
	}
	public String getClassid(){
		return classid;
	}
	public String getClassname(){
		return classname;
	}
	public void setClassid(String newClassid){
		classid = newClassid;
	}
	public void setClassname(String newClassname){
		classname = newClassname;
	}
}