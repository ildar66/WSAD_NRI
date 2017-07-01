package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Базовая форма редактирования группы организации
 */
public abstract class AbstractOrggroupForm extends com.hps.july.web.util.EditForm {
	private Integer searchgroup;
	private java.lang.String searchgroupname;
	private int org;
	private java.lang.String orgname;
	private Integer searchgroupping;
	private java.lang.String searchgrouppingname;
	private Integer order;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	OrggroupListForm aform = (OrggroupListForm)request.getSession().getAttribute( getFormName() );
	setOrg(aform.getOrganization());
	setOrder(new Integer(1));
	SearchesAccessBean bean = new SearchesAccessBean(
		getSearchgroup(),
		getSearchgroupping(),
		new Integer(getOrg()),
		order
	);
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 11:29:53)
 */
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
	try {
		SearchesAccessBean abean = (SearchesAccessBean)bean;
		setSearchgroupname(abean.getGroup().getName());
		setSearchgroupping(new Integer(abean.getGroupping().getSearchGroupping()));
		setSearchgrouppingname(abean.getGroupping().getName());
		setOrder(new Integer(abean.getOrder()));
	} catch(Exception e) {
	}
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
	OrggroupListForm aform = (OrggroupListForm)request.getSession().getAttribute( getFormName() );
	setOrg(aform.getOrganization());
	setOrgname(aform.getOrganizationname());
	setOrder(new Integer(1));
	SearchesAccessBean bean = new SearchesAccessBean();
	bean.setInitKey_group_searchgroup( getSearchgroup() );
	bean.setInitKey_organization_organization( new Integer(getOrg()) );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 17:26:35)
 * @return java.lang.String
 */
public abstract String getFormName();
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 12:53:17)
 * @return com.hps.july.persistence.SearchGroupping
 */
public SearchGroupping getGroupping() {
	try {
		SearchGrouppingAccessBean bean = new SearchGrouppingAccessBean();
		bean.setInitKey_searchGroupping(searchgroupping.intValue());
		bean.refreshCopyHelper();
		return (SearchGroupping)bean.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:22:43)
 * @return int
 */
public Integer getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:18:40)
 * @return int
 */
public int getOrg() {
	return org;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:18:52)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:17:45)
 * @return int
 */
public Integer getSearchgroup() {
	return searchgroup;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:18:01)
 * @return java.lang.String
 */
public java.lang.String getSearchgroupname() {
	return searchgroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:19:08)
 * @return int
 */
public Integer getSearchgroupping() {
	return searchgroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:19:25)
 * @return java.lang.String
 */
public java.lang.String getSearchgrouppingname() {
	return searchgrouppingname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITORGG;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 12:11:18)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	OrggroupListForm aform = (OrggroupListForm)request.getSession().getAttribute( getFormName() );
	setOrg(aform.getOrganization());
	setOrgname(aform.getOrganizationname());
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:22:43)
 * @param newOrder int
 */
public void setOrder(Integer newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:18:40)
 * @param newOrg int
 */
public void setOrg(int newOrg) {
	org = newOrg;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:18:52)
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:17:45)
 * @param newSearchgroup int
 */
public void setSearchgroup(Integer newSearchgroup) {
	searchgroup = newSearchgroup;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:18:01)
 * @param newSearchgroupname java.lang.String
 */
public void setSearchgroupname(java.lang.String newSearchgroupname) {
	searchgroupname = newSearchgroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:19:08)
 * @param newSearchgroupping int
 */
public void setSearchgroupping(Integer newSearchgroupping) {
	searchgroupping = newSearchgroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:19:25)
 * @param newSearchgrouppingname java.lang.String
 */
public void setSearchgrouppingname(java.lang.String newSearchgrouppingname) {
	searchgrouppingname = newSearchgrouppingname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		bean.setInitKey_organization(org);
		bean.refreshCopyHelper();
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.orggroup.org"));
	}
	
	if (searchgroup == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.orggroup.group"));
	}
	else {
		try {
			SearchGroupAccessBean bean = new SearchGroupAccessBean();
			bean.setInitKey_searchgroup(searchgroup.intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.orggroup.group"));
		}
		if("Add".equals(getAction())) {
			try {
				SearchesAccessBean sab = new SearchesAccessBean();
				sab.setInitKey_group_searchgroup(searchgroup);
				sab.setInitKey_organization_organization(new Integer(org));
				sab.refreshCopyHelper();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dup.orggroup.group"));
			} catch(Exception e) {
			}
		}
	}

	if (searchgroupping == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.orggroup.groupping"));
	}
	else {
		try {
			SearchGrouppingAccessBean bean = new SearchGrouppingAccessBean();
			bean.setInitKey_searchGroupping(searchgroupping.intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.orggroup.groupping"));
		}
	}

	/*
	if (order == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.orggroup.order"));
	}
	else {
		if (order.intValue() <= 0)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.orggroup.order"));
	}
	*/

	if (!errors.empty())
		throw new ValidationException();
}
}
