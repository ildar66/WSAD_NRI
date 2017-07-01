package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "Местоположение оборудования"
 */
public class Report2ParamsForm extends ReportForm {
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private String searchon;
	private String stateType;
	private StringAndSqlDateProperty stateDate;
	private Boolean group;
	private Boolean showAgregated;
	private Boolean showOncard;
public Report2ParamsForm() {
	group = Boolean.FALSE;
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	searchon = "1";
	showAgregated = Boolean.FALSE;
	showOncard = Boolean.FALSE;
	stateDate = new StringAndSqlDateProperty();
	stateDate.setSqlDate(new java.sql.Date((new java.util.Date()).getTime()));
	stateType = "C";
}
public java.lang.Boolean getGroup() {
	return group;
}
public String getResourcecode() {
	return resource.getString();
}
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
public java.lang.String getResourcename() {
	return resourcename;
}
public java.lang.String getSearchon() {
	return searchon;
}
public java.lang.Boolean getShowAgregated() {
	return showAgregated;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowOncard() {
	return showOncard;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT2PARAMS;
}
public java.sql.Date getStateDate() {
	return stateDate.getSqlDate();
}
public String getStateDateFrm() {
	return stateDate.getString();
}
public java.lang.String getStateType() {
	return stateType;
}
/**
 * 
 * @param newGroup java.lang.Boolean
 */
public void setGroup(java.lang.Boolean newGroup) {
	group = newGroup;
}
public void setResourcecode(String newResource) {
	resource.setString(newResource);
}
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setSearchon(java.lang.String newSearchon) {
	searchon = newSearchon;
}
/**
 * 
 * @param newShowAgregated java.lang.Boolean
 */
public void setShowAgregated(java.lang.Boolean newShowAgregated) {
	showAgregated = newShowAgregated;
}
/**
 * 
 * @param newShowOncard java.lang.Boolean
 */
public void setShowOncard(java.lang.Boolean newShowOncard) {
	showOncard = newShowOncard;
}
public void setStateDate(java.sql.Date newStateDate) {
	stateDate.setSqlDate(newStateDate);
}
public void setStateDateFrm(String newStateDate) {
	stateDate.setString(newStateDate);
}
public void setStateType(java.lang.String newStateType) {
	stateType = newStateType;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.resource"));
	} else {
		try {
			ResourceAccessBean r = new ResourceAccessBean();
			r.setInitKey_resource(resource.getInteger().intValue());
			r.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.changepos.resource"));
		}
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
