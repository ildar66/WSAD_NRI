/*
 * Created on 26.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.persistence2.ResourceGroupAccessBean;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourceGroupsObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.math.BigDecimal;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Форма редактирования группы оборудования
 */
///*
public class ResourceGroupForm extends EditForm {
	private int groupid;
	private java.lang.String name;
	private int classid;
	
	private static ResourceGroupItemRow[] antaccessories;
	
	private Boolean donotcommit=Boolean.FALSE;
	
	public ResourceGroupForm(){
	}
	
	public void setDonotcommit(Boolean newDonotcommit){
		donotcommit = newDonotcommit;
	}
	
	public Boolean getDonotcommit(){
		return donotcommit;
	}
	
	public ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("conResAdmin");
		roles.add("conResOperator");
		return roles;
	}

	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}

	public int getState() {
		return com.hps.july.dictionary.APPStates.EDIT_RESOURCEGROUP;
	}
	public boolean getAntAccessory(int index){
		return antaccessories[index].getChecked();
	}
	public String getAntAccessoryStr(int index){
		return antaccessories[index].getCheckedStr();
	}
	public void setAntAccessoryStr(int index, String value){
		antaccessories[index].setCheckedStr(value);
	}
	public ResourceGroupItemRow getAntAccessoryInfo(int index){
		return antaccessories[index];
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		ResourceGroupAccessBean bean = new ResourceGroupAccessBean(getGroupid());
		bean.setName(getName());
		bean.setClassid(getClassid());
		return bean;
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		ResourceGroupAccessBean bean = new ResourceGroupAccessBean();
		bean.setInitKey_groupid( getGroupid() );
		return bean;
	}
	public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		CDBCResourceGroupsObject.dropGroupLinks(new Integer(getGroupid()));
		CDBCResourceGroupsObject.setGroupAccessoryLinks(new Integer(getGroupid()), antaccessories);
	}
	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
		super.fillRecord(bean);
		antaccessories = getAccessoriesFromDB();
	}
	public java.lang.String getName() {
		return name;
	}
	public int getGroupid() {
		return groupid;
	}
	public int getClassid() {
		return classid;
	}
	public void initRecord(javax.servlet.http.HttpServletRequest request){
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		try{
			setGroupid(keyGen.getNextKey("tables.resgroups"));
		}
		catch (Exception e){
		}
		antaccessories = getAccessoriesFromDB();
		setClassid(3);
	}
	public void setName(java.lang.String newName) {
		name = newName;
	}
	public void setGroupid(int newGroupid) {
		groupid = newGroupid;
	}
	public void setClassid(int newClassid) {
		classid = newClassid;
	}
	public boolean accessoryChecked(ResourceGroupItemRow[] accessories, int index){
		return accessories[index].getChecked();
	}
	public int getAccessoryCount(ResourceGroupItemRow[] accessories, int index){
		return accessories[index].getQuantity().intValue();
	}
	public int getAccessoriesCount(){
		return antaccessories.length;
	}
	public boolean quantitiesCorrect(ResourceGroupItemRow[] accessories){
		boolean result = true;
		for (int i=0; i<accessories.length; i++)
			if (accessories[i].getChecked())
				if (getAccessoryCount(accessories,i)<=0)
					result = false; 
		return result;
	}
	public String getAccessoryQuantity(int index){
		return antaccessories[index].getQuantityStr();
	}
	public void setAccessoryQuantity(int index, String value){
		antaccessories[index].setQuantityStr(value);
	}
	public ResourceGroupItemRow[] getAccessoriesFromDB(){
		Integer accessorykey = new Integer(0);
		boolean checked;
		CDBCResultSet antaccessoriesset = CDBCResourceGroupsObject.findAllAntennaAccessories();
		ListIterator it = antaccessoriesset.listIterator();
		int index = 0;
		ResourceGroupItemRow[] antaccessoriesarray = new ResourceGroupItemRow[antaccessoriesset.getRowsCount()];
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			if (row.hasColumn("resource"))
				accessorykey = new Integer(Integer.parseInt(row.getColumn("resource").asString()));
			if (CDBCResourceGroupsObject.isAccessoryInGroup(new Integer(getGroupid()), accessorykey)) 
				checked=true;
			else checked=false;
			antaccessoriesarray[index] = new ResourceGroupItemRow(new Integer(getGroupid()), row, checked);  
			index++;
		}
		sortAntAccessories(antaccessoriesarray);
		return antaccessoriesarray;
	}
	public int getCheckedCount(ResourceGroupItemRow[] accessories){
		int count = 0;
		for (int i=0; i<accessories.length; i++){
			if (accessories[i].getChecked())
				count++;
		}
		return count;
	}
	public void sortAntAccessories(ResourceGroupItemRow[] accessories){
		LinkedList checked = new LinkedList();
		LinkedList unchecked = new LinkedList();
		ResourceGroupItemRow temp;
		dropUnchecked(accessories);
		for (int m=accessories.length; m>1; m--)
			for (int n=0; n<m-1; n++)
				if (accessories[n].getResource().intValue()>accessories[n+1].getResource().intValue()){
					temp = accessories[n];
					accessories[n] = accessories[n+1];
					accessories[n+1] = temp;
				}
		for (int i=0; i<accessories.length; i++)
			if (accessories[i].getChecked())
				checked.add(accessories[i]);
			else unchecked.add(accessories[i]);
		checked.addAll(unchecked);
		ListIterator it = checked.listIterator();
		int index = 0;
		while (it.hasNext()){
			ResourceGroupItemRow row = (ResourceGroupItemRow) it.next();
			accessories[index] = row;
			index++;
		}
	}
	public void dropUnchecked(ResourceGroupItemRow[] accessories){
		for (int i=0; i<accessories.length; i++)
			if (!accessories[i].getChecked())
				accessories[i].setQuantity(new BigDecimal(0));	
	}
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		if (donotcommit==Boolean.TRUE){
			donotcommit=Boolean.FALSE;
			sortAntAccessories(antaccessories);
			throw new ValidationException();
		}
		if (!quantitiesCorrect(antaccessories))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.accessory.qty"));		
		if ((getName() == null) || (getName().length() == 0))
		  	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.group.name"));
	  
		if (!errors.empty()){
			sortAntAccessories(antaccessories);
			throw new ValidationException();
		}
	}
}