package com.hps.july.project.formbean;

import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.web.util.StringAndIntegerProperty;
import java.util.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.ValidationException;
import com.hps.july.project.*;

/**
 * Форма типового события проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class ProjectActionTypeForm extends com.hps.july.web.util.EditForm {
	private String name;
	private StringAndIntegerProperty projectactiontype;
	private String result;
	private Enumeration resptypes;
	private String divisionname;
	private StringAndIntegerProperty division;
	private Division bean;
	private java.lang.String equiptype;
	private ResponsibilityTypeAccessBean resptype;
	private int respcode;
public ProjectActionTypeForm(){
	projectactiontype = new StringAndIntegerProperty();
	projectactiontype.setInteger(new Integer(0));
	division = new StringAndIntegerProperty();
	equiptype = "0";
	resptype = null;
	resptypes = null;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {

	KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
	setProjectactiontype(new Integer(keygen.getNextKey("tables.projectActionType")));
	ProjectActionTypeAccessBean bean = new ProjectActionTypeAccessBean( 
		projectactiontype.getInteger().intValue(), 
		division.getInteger().intValue(),
		name, result, getEquiptype(), getRespcode());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 16:48:03)
 */
public void constructResponsibilityType() {
	try {
		if (resptype == null) {
			ResponsibilityTypeAccessBean rab = new ResponsibilityTypeAccessBean();
			rab.setInitKey_responsibilityType(getRespcode());
			rab.refreshCopyHelper();
			resptype = rab;
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
public Division getAction2division() {
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.PROJECT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {

	ProjectActionTypeAccessBean bean = new ProjectActionTypeAccessBean();
	bean.setInitKey_projectactiontype( projectactiontype.getInteger().intValue() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:53:27)
 * @return int
 */
public Integer getDivision() {
	return division.getInteger();
}
public Division getDivisionBean() {
	try{
		DivisionAccessBean dab = new DivisionAccessBean();
		dab.setInitKey_division(division.getInteger().intValue());
		dab.refreshCopyHelper();
		bean = (Division)dab.getEJBRef();
		return bean;
	}catch(Exception ex){
		pr(ex, "getDivisionBean");
	}
return null;
}
public String getDivisionFrm() {
	return division.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 15:06:59)
 * @return java.lang.String
 */
public java.lang.String getDivisionname() {
	return divisionname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:14:37)
 * @return java.lang.String
 */
public java.lang.String getEquiptype() {
	return equiptype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { projectactiontype.getInteger() };
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 17:05:34)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
public Integer getProjectactiontype() {
	return projectactiontype.getInteger();
}
public String getProjectactiontypeFrm() {
	return projectactiontype.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 16:47:18)
 * @return int
 */
public int getRespcode() {
	return respcode;
}
public ResponsibilityType getResponsibilitytype() throws Exception {
	constructResponsibilityType();
	if (resptype != null) 
		return (ResponsibilityType)resptype.getEJBRef();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 17:00:47)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getResptypes() {
	return resptypes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:53:27)
 * @return java.lang.String
 */
public java.lang.String getResult() {
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.TYPEPROJECTACTIONFORM;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	resptypes = new ResponsibilityTypeAccessBean().findAllOrderByCodeAsc();
}
void pr(Exception ex, String str) {
	System.out.println(new java.util.Date());
	System.out.println(ex.getClass().getName() + "in " + this.getClass().getName() +"."+ str + 
		". Message is:" + ex.getMessage());
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:53:27)
 * @param newDivision int
 */
public void setAction2division(DivisionAccessBean dab) {
    try {
        division.setInteger(new Integer(dab.getDivision()));
        divisionname = dab.getName();
    } catch (Exception ex) {
        pr(ex, "setAction2division");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:53:27)
 * @param newDivision int
 */
public void setDivision(Integer newDivision) {
	division.setInteger(newDivision);
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:53:27)
 * @param newDivision int
 */
public void setDivisionFrm(String newDivision) {
	division.setString(newDivision);
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 15:06:59)
 * @param newDivisionname java.lang.String
 */
public void setDivisionname(java.lang.String newDivisionname) {
	divisionname=newDivisionname;
	//divisionname = Util_Alex.convertString(newDivisionname);
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:14:37)
 * @param newEquiptype java.lang.String
 */
public void setEquiptype(java.lang.String newEquiptype) {
	equiptype = newEquiptype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 17:05:34)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name=newName;
	//name = Util_Alex.convertString(newName);
}
public void setProjectactiontype(Integer newProjectactiontype) {
	projectactiontype.setInteger(newProjectactiontype);
}
public void setProjectactiontypeFrm(String newProjectactiontype) {
	projectactiontype.setString(newProjectactiontype);
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 16:47:18)
 * @param newRespcode int
 */
public void setRespcode(int newRespcode) {
	respcode = newRespcode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:53:27)
 * @param newDivision int
 */
public void setResponsibilitytype(ResponsibilityTypeAccessBean rab) {
    try {
	    setRespcode(rab.getResponsibilityType());
    } catch (Exception ex) {
        pr(ex, "setResponsibilityType");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:53:27)
 * @param newResult java.lang.String
 */
public void setResult(java.lang.String newResult) {
 result=newResult;   
	//result = Util_Alex.convertString(newResult);
}
public void validateValues(ActionErrors errors) throws Exception {
	
	if ((name == null) || (name.length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.projectactiontype.name"));
	if ((result == null) || (result.length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.projectactiontype.result"));

	if (division.isEmpty())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.projectactiontype.division"));
	else if(!division.isOk())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.projectactiontype.divisionerror"));
	else if(getDivisionBean() == null)
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectactiontype.divisionerror2"));

	constructResponsibilityType();
	if (resptype == null)
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectactiontype.resptype"));

	if (!errors.empty())
		throw new ValidationException();
}
}
