/*
 * Created on 15.03.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence2.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Форма редактирования класса комплекта
 */
public class ResourcesetClassForm extends com.hps.july.web.util.EditForm{
	private int classid;
	private java.lang.String classname;

	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		ResourceSetClassAccessBean bean = new ResourceSetClassAccessBean(getClassid(), getClassname() );	
		return bean;
	}
	public void initRecord(javax.servlet.http.HttpServletRequest request){
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		try{
			setClassid(keyGen.getNextKey("tables.resourcesetclasses"));
		}
		catch (Exception e){
		}
	}

	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		ResourceSetClassAccessBean bean = new ResourceSetClassAccessBean();
		bean.setInitKey_classid( getClassid() );
		return bean;
	}
	public java.lang.String getClassname() {
		return classname;
	}
	public int getState() {
		return com.hps.july.dictionary.APPStates.EDIT_RESSETCLASS;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassname(java.lang.String newClassname) {
		classname = newClassname;
	}
	public void setClassid(int newClassid) {
		classid = newClassid;
	}
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		if ((getClassname() == null) || (getClassname().length() == 0))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.unit.shortname"));
		if (!errors.empty())
			throw new ValidationException();
	}
}