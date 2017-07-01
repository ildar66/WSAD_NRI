/*
 * Created on 07.05.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author AAErmolov
 *
 * ‘орма выбора производителей оборудовани€
 *
 */
public class EquipmanufLookupListForm extends com.hps.july.web.util.BrowseForm {
	private Boolean bymanufid;
	private Boolean byname;
	private Boolean byshortname;
	private Boolean byequipcatalog;
	private Boolean byofficialsite;

	private StringAndIntegerProperty manufid = new StringAndIntegerProperty();
	private String name = "";
	private String shortname = "";
	private String equipcatalog = "";
	private String officialsite = "";
	
	public EquipmanufLookupListForm(){
		this.setFinderMethodName( "findAllEquipmanuf" );
		setBymanufid(Boolean.FALSE);
		setByname(Boolean.TRUE);
		setByshortname(Boolean.FALSE);
		setByequipcatalog(Boolean.FALSE);
		setByofficialsite(Boolean.FALSE);
	}
	public java.lang.Object[] getFilterParams() {
		return new Object[] { 
			bymanufid,
			(getManufid()!=null) ? getManufid() : new Integer(0),
			byname,
			name,
			byshortname,		
			shortname,
			byequipcatalog,
			equipcatalog,
			byofficialsite,
			officialsite
		};
	}
	public void setBymanufid(Boolean newBymanufid){
		bymanufid = newBymanufid;
	}
	public Boolean getBymanufid(){
		return bymanufid;
	}
	public void setByname(Boolean newByname){
		byname = newByname;
	}
	public Boolean getByname(){
		return byname;
	}
	public void setByshortname(Boolean newByshortname){
		byshortname = newByshortname;
	}
	public Boolean getByshortname(){
		return byshortname;
	}
	public void setByequipcatalog(Boolean newByequipcatalog){
		byequipcatalog = newByequipcatalog;
	}
	public Boolean getByequipcatalog(){
		return byequipcatalog;
	}
	public void setByofficialsite(Boolean newByofficialsite){
		byofficialsite = newByofficialsite;
	}
	public Boolean getByofficialsite(){
		return byofficialsite;
	}
	public void setManufidFrm(String newManufid){
		manufid.setString(newManufid);
	}
	public String getManufidFrm(){
		return manufid.getString();
	}
	public void setManufid(Integer newManufid){
		manufid.setInteger(newManufid);
	}
	public Integer getManufid(){
		return manufid.getInteger();
	}
	public void setName(String newName){
		name = newName;
	}
	public String getName(){
		return name;
	}
	public void setShortname(String newShortname){
		shortname = newShortname;
	}
	public String getShortname(){
		return shortname;
	}
	public void setEquipcatalog(String newEquipcatalog){
		equipcatalog = newEquipcatalog;
	}
	public String getEquipcatalog(){
		return equipcatalog;
	}
	public void setOfficialsite(String newOfficialsite){
		officialsite = newOfficialsite;
	}
	public String getOfficialsite(){
		return officialsite;
	}
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		if (!manufid.isOk())
			setManufid(null);
		if (!errors.empty())
			throw new ValidationException();
	}	
}


