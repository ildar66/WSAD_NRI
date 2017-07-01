/*
 * Created on 20.03.2007
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
public class ResourceCommonRow {
	private String resource;
	private String nfslist;
	private String manucode;
	private String model;
	private String name;
	private String unit;
	private String countpolicy;
	private String active;
	private String disablenfscodes;
	
	public ResourceCommonRow(CDBCRowObject row){
		if (row.hasColumn("resource")) setResource(row.getColumn("resource").asString());
		if (row.hasColumn("nfslist")) setNfslist(row.getColumn("nfslist").asString());
		if (row.hasColumn("manucode")) setManucode(row.getColumn("manucode").asString());
		if (row.hasColumn("model")) setModel(row.getColumn("model").asString());
		if (row.hasColumn("name")) setName(row.getColumn("name").asString());
		if (row.hasColumn("unit")) setUnit(row.getColumn("unit").asString());
		if (row.hasColumn("countpolicy")){
			String cp = row.getColumn("countpolicy").asString();
			switch (cp.charAt(0)){
				case 'S': setCountpolicy("Серийный"); break;
				case 'P': setCountpolicy("Партионный"); break;
				case 'B': setCountpolicy("Обычный"); break;
			} 
		}
		if (row.hasColumn("active")) setActive(row.getColumn("active").asString());
		if (row.hasColumn("disablenfscodes")) setDisablenfscodes(row.getColumn("disablenfscodes").asString());
	}
	public String getResource(){return resource;}
	public String getNfslist(){return nfslist;}
	public String getManucode(){return manucode;}
	public String getModel(){return model;}
	public String getName(){return name;}
	public String getUnit(){return unit;}
	public String getCountpolicy(){return countpolicy;}
	public String getActive(){return active;}
	public String getDisablenfscodes(){return disablenfscodes;}
	
	public void setResource(String newResource){resource = newResource;}
	public void setNfslist(String newNfslist){nfslist = newNfslist;}
	public void setManucode(String newManucode){manucode = newManucode;}
	public void setModel(String newModel){model = newModel;}
	public void setName(String newName){name = newName;}
	public void setUnit(String newUnit){unit = newUnit;}
	public void setCountpolicy(String newCountpolicy){countpolicy = newCountpolicy;}
	public void setActive(String newActive){active = newActive;}
	public void setDisablenfscodes(String newDisablenfscodes){disablenfscodes = newDisablenfscodes;}
}
