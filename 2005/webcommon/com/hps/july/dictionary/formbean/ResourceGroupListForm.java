/*
 * Created on 26.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.web.util.*;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Форма списка групп оборудования
 * 
 */
public class ResourceGroupListForm extends BrowseForm {
	private Boolean findemptygroups;
	private Boolean usesearch;
	private StringAndIntegerProperty code1 = new StringAndIntegerProperty();
	private StringAndIntegerProperty code2 = new StringAndIntegerProperty();
	private String model1;
	private String model2;
	private String manucode1;
	private String manucode2;

	public ResourceGroupListForm() {
		//this.setFinderMethodName("findAntennaEquipmentGroups");
		setLastVisited(true);
		setFindemptygroups(Boolean.FALSE);
		setUsesearch(Boolean.FALSE);
		setCode1Frm("");
		setCode2Frm("");
		setModel1("");
		setModel2("");
		setManucode1("");
		setManucode1("");
	}

	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("developer");
		roles.add("confResAdmin");
		return roles;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		if (usesearch.booleanValue()){
			return new Object[] {
				(code1.getInteger()!=null) ? code1.getInteger() : new Integer(0),
				(code2.getInteger()!=null) ? code2.getInteger() : new Integer(0),
				model1,	model2,	manucode1, manucode2
			};
		}
		else
			return new Object[] {findemptygroups};
	}
	public void setFindemptygroups(Boolean newFindemptygroups){
		findemptygroups = newFindemptygroups;
	}
	public Boolean getFindemptygroups(){
		return findemptygroups;
	}
	public void setUsesearch(Boolean newUsesearch){
		usesearch = newUsesearch;
	}
	public Boolean getUsesearch(){
		return usesearch;
	}
	public void setCode1(Integer newCode1){
		if (newCode1 != null) {
			code1.setInteger(newCode1);
		} else {
			setCode1Frm("");
		}
	}
	public void setCode1Frm(String newCode1){
		code1.setString(newCode1);
	}
	public Integer getCode1(){
		if (code1.getInteger() == null)
			return null;
		else
			return code1.getInteger();
	}
	public String getCode1Frm(){
		return code1.getString();
	}
	public void setCode2(Integer newCode2){
		if (newCode2 != null) {
			code2.setInteger(newCode2);
		} else {
			code2.setInteger(new Integer(0));
		}
	}
	public void setCode2Frm(String newCode2){
		code2.setString(newCode2);
	}
	public Integer getCode2(){
		if (code2.getInteger() == null)
			return null;
		else
			return code2.getInteger();
	}
	public String getCode2Frm(){
		return code2.getString();
	}
	public void setModel1(String newModel1){
		model1 = newModel1;
	}
	public String getModel1(){
		return model1;
	}
	public void setModel2(String newModel2){
		model2 = newModel2;
	}
	public String getModel2(){
		return model2;
	}
	public void setManucode1(String newManucode1){
		manucode1 = newManucode1;
	}
	public String getManucode1(){
		return manucode1;
	}
	public void setManucode2(String newManucode2){
		manucode2 = newManucode2;
	}
	public String getManucode2(){
		return manucode2;
	}
	public void validateValues(org.apache.struts.action.ActionErrors errors) throws Exception {
		if (usesearch.booleanValue()) 
			this.setFinderMethodName("findAntennaGroupsByAccessories");
		else
			this.setFinderMethodName("findAntennaEquipmentGroups");
		if(!code1.isEmpty()) {
			if(!code1.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sysconst.decimalvalue"));
				setCode1(null);
			}
		}
		if(!code2.isEmpty()) {
			if(!code2.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sysconst.decimalvalue"));
				setCode2(null);
			}
		}
		if (!errors.empty())
			throw new ValidationException();
	}
}