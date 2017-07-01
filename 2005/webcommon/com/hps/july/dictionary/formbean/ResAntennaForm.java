/*
 * Created on 23.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.persistence2.ResourceGroupAccessBean;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.objects.CDBCResourceGroupsObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Форма редактирования связей групп оборудования с антеннами
 */
public class ResAntennaForm extends EditForm{
	private int resource;
	private String name;
	private String model;
	private String manufacturer; 
	private StringAndIntegerProperty groupid = new StringAndIntegerProperty();
	private String groupname;
	
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.EDIT_RESANTENNA;
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setResource(keyGen.getNextKey("tables.resources"));
		ResourceAccessBean bean = new ResourceAccessBean(getResource());
		return bean;
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		ResourceAccessBean bean = new ResourceAccessBean();
		bean.setInitKey_resource( getResource() );
		return bean;
	}
	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
		super.fillRecord(bean);
		groupname = CDBCResourcesObject.getGroupnameByGroupid(getGroupid());
	}
	public String getManufidStr(){
		if (getResource()!=0)
			return CDBCResourceGroupsObject.getManufidFromResource(new Integer(getResource()));
		else
			return "";
	}
	public int getResource() {
		return resource;
	}
	public java.lang.String getName() {
		return name;
	}
	public java.lang.String getModel() {
		return model;
	}
	public java.lang.String getManufacturer() {
		return manufacturer;
	}
	public Integer getGroupid() {
		return groupid.getInteger();
	}
	public String getGroupidFrm() {
		return groupid.getString();
	}
	public java.lang.String getGroupname() {
		return groupname;
	}
	public void setResource(int newResource) {
		resource = newResource;
	}
	public void setName(java.lang.String newName) {
		name = newName;
	}
	public void setModel(java.lang.String newModel) {
		model = newModel;
	}
	public void setManufacturer(java.lang.String newManufacturer) {
		manufacturer = newManufacturer;
	}
	public void setGroupid(Integer newGroupid) {
		groupid.setInteger(newGroupid);
	}
	public void setGroupidFrm(String newGroupid) {
		groupid.setString(newGroupid);
	}
	public void setGroupname(java.lang.String newGroupname) {
		groupname = newGroupname;
	}
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		if (getGroupid()!=null)
			if (!CDBCResourceGroupsObject.groupExists(getGroupid()))
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.grouporg.groupping"));
		if (!errors.empty())
			throw new ValidationException();
	}
}