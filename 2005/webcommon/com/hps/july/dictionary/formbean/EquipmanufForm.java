/*
 * Created on 04.05.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence2.EquipManufacturerAccessBean;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EquipmanufForm extends EditForm {
	private StringAndIntegerProperty manufid = new StringAndIntegerProperty();
	private String name;
	private String shortname;
	private String equipcatalog;
	private String officialsite;
	private String comment;
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
		return com.hps.july.dictionary.APPStates.EDIT_EQUIPMANUF;
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
	public void setComment(String newComment){
		comment = newComment;
	}
	public String getComment(){
		return comment;
	}	
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		EquipManufacturerAccessBean bean = new EquipManufacturerAccessBean(
			getManufid(),
			getName(),
			getShortname()
		);
		return bean;
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		EquipManufacturerAccessBean bean = new EquipManufacturerAccessBean();
		bean.setInit_primaryKey( getManufid() );
		return bean;
	}	
	public void initRecord(javax.servlet.http.HttpServletRequest request){
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		try{
			setManufid(new Integer(keyGen.getNextKey("tables.equipmanuf")));
		}
		catch (Exception e){
		}
	}	
	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
		super.fillRecord(bean);
	}
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		if(name.equalsIgnoreCase("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.name"));
		}
		if(shortname.equalsIgnoreCase("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.shortname"));
		}
		if (!errors.empty())
			throw new ValidationException();
	}	
}
