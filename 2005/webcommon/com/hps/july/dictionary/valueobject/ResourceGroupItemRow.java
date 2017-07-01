/*
 * Created on 20.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

import java.math.BigDecimal;

import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourceGroupsObject;
import com.hps.july.web.util.StringAndBigDecimalProperty;
import com.hps.july.web.util.StringAndIntegerProperty;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ResourceGroupItemRow {
	private StringAndIntegerProperty resource = new StringAndIntegerProperty();
	private String resourcesubtype="";
	private String unit="";
	private String name="";
	private String model="";
	private String notes="";
	private String complect="";
	private String countpolicy="";
	private String boxable="";
	private String pricable="";
	private String complectpart="";
	private String actualcode="";
	private String active="";
	//private String manufacturer="";
	private String manucode="";
	private String resourceclass="";
	private String resourceclass2="";
	private String groupid="";
	private String manufid="";
	private String shortname="";
	private boolean checked;
	private StringAndBigDecimalProperty quantity = new StringAndBigDecimalProperty();
	
	public ResourceGroupItemRow(Integer groupid, CDBCRowObject newRow, boolean isChecked){
		if (newRow.hasColumn("resource")) setResourceStr(newRow.getColumn("resource").asString());
		if (newRow.hasColumn("resourcesubtype")) setResourcesubtype(newRow.getColumn("resourcesubtype").asString());
		if (newRow.hasColumn("unit")) setUnit(newRow.getColumn("unit").asString());
		if (newRow.hasColumn("name")) setName(newRow.getColumn("name").asString());
		if (newRow.hasColumn("model")) setModel(newRow.getColumn("model").asString());
		if (newRow.hasColumn("notes")) setNotes(newRow.getColumn("notes").asString());
		if (newRow.hasColumn("complect")) setComplect(newRow.getColumn("complect").asString());
		if (newRow.hasColumn("countpolicy")) setCountpolicy(newRow.getColumn("countpolicy").asString());
		if (newRow.hasColumn("boxable")) setBoxable(newRow.getColumn("boxable").asString());
		if (newRow.hasColumn("pricable")) setPricable(newRow.getColumn("pricable").asString());
		if (newRow.hasColumn("complectpart")) setComplectpart(newRow.getColumn("complectpart").asString());
		if (newRow.hasColumn("actualcode")) setActualcode(newRow.getColumn("actualcode").asString());
		if (newRow.hasColumn("active")) setActive(newRow.getColumn("active").asString());
		//if (newRow.hasColumn("manufacturer")) setManufacturer(newRow.getColumn("manufacturer").asString());
		if (newRow.hasColumn("manucode")) setManucode(newRow.getColumn("manucode").asString());
		if (newRow.hasColumn("resourceclass")) setResourceclass(newRow.getColumn("resourceclass").asString());
		if (newRow.hasColumn("resourceclass2")) setResourceclass2(newRow.getColumn("resourceclass2").asString());
		if (newRow.hasColumn("groupid")) setGroupid(newRow.getColumn("groupid").asString());
		if (newRow.hasColumn("manufid")) setManufid(newRow.getColumn("manufid").asString());
		if (newRow.hasColumn("shortname")) setShortname(newRow.getColumn("shortname").asString());
		setChecked(isChecked);
		setQuantity(CDBCResourceGroupsObject.getAccessoryQuantity(groupid,getResource()));
	}
	
	public Integer getResource(){return resource.getInteger();}
	public String getResourceStr(){return resource.getString();}
	public String getResourcesubtype(){return resourcesubtype;}
	public String getUnit(){return unit;}
	public String getName(){return name;}
	public String getModel(){return model;}
	public String getNotes(){return notes;}
	public String getComplect(){return complect;}
	public String getCountpolicy(){return countpolicy;}
	public String getBoxable(){return boxable;}
	public String getPricable(){return pricable;}
	public String getComplectpart(){return complectpart;}
	public String getActualcode(){return actualcode;}
	public String getActive(){return active;}
	//public String getManufacturer(){return manufacturer;}
	public String getManucode(){return manucode;}
	public String getResourceclass(){return resourceclass;}
	public String getResourceclass2(){return resourceclass2;}
	public String getGroupid(){return groupid;}
	public String getManufid(){return manufid;}
	public String getShortname(){return shortname;}
	public boolean getChecked(){return checked;}
	public String getCheckedStr(){return checked ? "true" : "false";}
	public BigDecimal getQuantity(){return quantity.getBigDecimal();}
	public String getQuantityStr(){return quantity.getString();}
	
	public void setResource(Integer newResource){ resource.setInteger(newResource); }
	public void setResourceStr(String newResource){ resource.setString(newResource); }
	public void setResourcesubtype(String newResourcesubtype){ resourcesubtype = newResourcesubtype; }
	public void setUnit(String newUnit){ unit = newUnit; }
	public void setName(String newName){ name = newName; }
	public void setModel(String newModel){ model = newModel; }
	public void setNotes(String newNotes){ notes = newNotes; }
	public void setComplect(String newComplect){ complect = newComplect; }
	public void setCountpolicy(String newCountpolicy){ countpolicy = newCountpolicy; }
	public void setBoxable(String newBoxable){ boxable = newBoxable; }
	public void setPricable(String newPricable){ pricable = newPricable; }
	public void setComplectpart(String newComplectpart){ complectpart = newComplectpart; }
	public void setActualcode(String newActualcode){ actualcode = newActualcode; }
	public void setActive(String newActive){ active = newActive; }
	//public void setManufacturer(String newManufacturer){ manufacturer = newManufacturer; }
	public void setManucode(String newManucode){ manucode = newManucode; }
	public void setResourceclass(String newResourceclass){ resourceclass = newResourceclass; }
	public void setResourceclass2(String newResourceclass2){ resourceclass2 = newResourceclass2; }
	public void setGroupid(String newGroupid){ groupid = newGroupid; }
	public void setManufid(String newManufid){ manufid = newManufid; }
	public void setShortname(String newShortname){ shortname = newShortname; }
	public void setChecked(boolean newChecked){ checked = newChecked; }
	public void setCheckedStr(String newChecked){ checked = (newChecked.equalsIgnoreCase("true") || newChecked.equalsIgnoreCase("on")) ? true : false; }
	public void setQuantity(BigDecimal newQuantity){ quantity.setBigDecimal(newQuantity); }
	public void setQuantityStr(String newQuantity){ quantity.setString(newQuantity); }
}