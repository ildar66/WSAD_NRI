/*
 * Created on 29.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

import com.hps.july.cdbc.lib.CDBCRowObject;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NFSResourceRow {
	private String segment1="";
	private String manucode="";
	private String model="";
	private String shortname="";
	private String name="";
	
	public NFSResourceRow(CDBCRowObject row){
		if (row.hasColumn("segment1")) setSegment1(row.getColumn("segment1").asString());
		if (row.hasColumn("manucode")) setManucode(row.getColumn("manucode").asString());
		if (row.hasColumn("model")) setModel(row.getColumn("model").asString());
		if (row.hasColumn("shortname")) setShortname(row.getColumn("shortname").asString());
		if (row.hasColumn("name")) setName(row.getColumn("name").asString());
		if (getSegment1()=="") setSegment1("-");
		if (getManucode()=="") setManucode("-");
		if (getModel()=="") setModel("-");
		if (getShortname()=="") setShortname("-");
		if (getName()=="") setName("-");
	}
	public String getSegment1(){
		return segment1;
	}
	public String getManucode(){
		return manucode;
	}
	public String getModel(){
		return model;
	}
	public String getShortname(){
		return shortname;
	}
	public String getName(){
		return name;
	}
	public void setSegment1(String newSegment1){
		segment1 = newSegment1;
	}
	public void setManucode(String newManucode){
		manucode = newManucode;
	}
	public void setModel(String newModel){
		model = newModel;
	}
	public void setShortname(String newShortname){
		shortname = newShortname;
	}
	public void setName(String newName){
		name = newName;
	}

}