/*
 * Created on 16.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ResourceGroupRow {
	private Integer groupid;
	private String name;
	
	public ResourceGroupRow(Integer groupid, String name){
		setGroupid(groupid);
		setName(name);
	}
	
	public Integer getGroupid(){
		return groupid;	
	}
	public void setGroupid(Integer newGroupid){
		groupid = newGroupid;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
}
