package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования группировки юр. лиц
 */
public class GrouppingForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private int group;
	private int searchgroupping;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	GrouppingListForm aform = (GrouppingListForm)request.getSession().getAttribute( "GrouppingListForm" );
	setGroup(aform.getSearchgroup());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setSearchgroupping(keyGen.getNextKey("tables.searchgroupping"));
    SearchGrouppingAccessBean bean = new SearchGrouppingAccessBean(getSearchgroupping(), new Integer(getGroup()), getName());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	SearchGrouppingAccessBean bean = new SearchGrouppingAccessBean();
	bean.setInitKey_searchGroupping( getSearchgroupping() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 12:00:04)
 * @return int
 */
public int getGroup() {
	return group;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @return int
 */
public int getSearchgroupping() {
	return searchgroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITGRPP;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 12:00:04)
 * @param newResourcetype int
 */
public void setGroup(int newGroup) {
	group = newGroup;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @param newResourcesubtype int
 */
public void setSearchgroupping(int newSearchgroupping) {
	searchgroupping = newSearchgroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getName() == null) || (getName().length() == 0))
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.groupping.name"));

	if (!errors.empty())
		throw new ValidationException();
}
}
