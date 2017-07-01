/*
 * Created on 07.06.2007
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
 * Форма выбора групп аксессуаров
 *
 */
public class ResourceGroupLookupListForm extends com.hps.july.web.util.BrowseForm {
	private Boolean bygroupid;
	private Boolean byname;

	private StringAndIntegerProperty groupid = new StringAndIntegerProperty();
	private String name = "";
	
	public ResourceGroupLookupListForm(){
		this.setFinderMethodName( "findAllResourceGroups" );
		setBygroupid(Boolean.FALSE);
		setByname(Boolean.TRUE);
	}
	public java.lang.Object[] getFilterParams() {
		return new Object[] { 
			bygroupid,
			(getGroupid()!=null) ? getGroupid() : new Integer(0),
			byname,
			name,
		};
	}
	public void setBygroupid(Boolean newBygroupid){
		bygroupid = newBygroupid;
	}
	public Boolean getBygroupid(){
		return bygroupid;
	}
	public void setByname(Boolean newByname){
		byname = newByname;
	}
	public Boolean getByname(){
		return byname;
	}
	public void setGroupidFrm(String newGroupid){
		groupid.setString(newGroupid);
	}
	public String getGroupidFrm(){
		return groupid.getString();
	}
	public void setGroupid(Integer newGroupid){
		groupid.setInteger(newGroupid);
	}
	public Integer getGroupid(){
		return groupid.getInteger();
	}
	public void setName(String newName){
		name = newName;
	}
	public String getName(){
		return name;
	}
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		if (!groupid.isOk())
			setGroupid(null);
		if (!errors.empty())
			throw new ValidationException();
	}	
}






