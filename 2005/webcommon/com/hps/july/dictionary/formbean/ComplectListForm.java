package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.lib.*;

/**
 * Форма списка наборов оборудования
 */
public class ComplectListForm extends BrowseForm {
/*
	private Boolean isResourcetype;	
	private StringAndIntegerProperty resourcetype;
	private String resourcetypename;
	
	private Boolean isResourcesubtype;	
	private StringAndIntegerProperty resourcesubtype;
	private String resourcesubtypename;
*/
	private String type;
	private String searchstr;

public ComplectListForm() {
	setFinderMethodName("findResourceSets");
/*
	setFinderMethodName( "findResourceSetsBySubtype" );

	isResourcetype = Boolean.TRUE;
	isResourcesubtype = Boolean.TRUE;
	
	resourcetype = new StringAndIntegerProperty();
	resourcetypename = "";
	
	resourcesubtypename = "";
	resourcesubtype = new StringAndIntegerProperty();
*/
	setLastVisited(true);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDictionaryObject";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	//roles.add("dictResOperator");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
	//	new Integer(getResourcesubtypeInt())
		(type == null)?"1":type,
		(searchstr == null)?"*":searchstr,
		new Integer(1)
	};
}
public String getSearchstr() {
	return searchstr;
}
public String getType() {
	return type;
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	super.initBrowse(mapping, request, response );
	ParamsParser.setState( request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.CPLIST );
    return null;
}
public void setSearchstr(String newSearchstr) {
	searchstr = newSearchstr;
}
public void setType(String newType) {
	type = newType;
}
public void validateValues(ActionErrors errors)
	throws ValidationException
{
	/*
	// update filter here
  	try {
		ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
		bean.setInitKey_resourcesubtype(getResourcesubtypeInt());
		bean.refreshCopyHelper();
		setResourcesubtypename(bean.getName());
		ResourceTypeAccessBean rtbean = bean.getResourcetype();
		getResourcetype().setInteger(new Integer(rtbean.getResourcetype()));
		setResourcetypename(rtbean.getName());
  	} catch (Exception e) {
		getResourcesubtype().setString("");
		setResourcesubtypename("");
		getResourcetype().setString("");
		setResourcetypename("");
  	}
  	*/
}
}
