package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import javax.servlet.http.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import org.apache.struts.util.*;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Базовая форма списка разрешений ГКРЧ
 */
public class RRLDocsListForm
	extends com.hps.july.web.util.BrowseForm
{
    private boolean byactivity;
    private boolean bynumber;
    private String number;
	private boolean byresource;
	private boolean byorg;
    private StringAndIntegerProperty resource = new StringAndIntegerProperty();
    private String resourcename;
    private String resourcemodel;
    private boolean bydate;
    private StringAndSqlDateProperty date = new StringAndSqlDateProperty();
    
	private String username;
	private boolean admin;
	private StringAndIntegerProperty org = new StringAndIntegerProperty();
	private String orgname;

	private Integer order = new Integer(4);
public RRLDocsListForm() {
	super();
	setLastVisited(true);
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
public com.hps.july.web.util.StringAndSqlDateProperty getDate() {
	return date;
}
public String getDocumentResources(String sitedoc)
{
	String result = "";
	Integer sd = null;

	try {
		sd = new Integer(Integer.parseInt(sitedoc));
	} catch(Exception e) {
	}
	
System.out.println("Sitedoc:"+sd);
	CDBCSitedocsObject o = new CDBCSitedocsObject();
	return o.findDocsResourcesString(sd,true);
}
public Object[] getFilterParams() {
	return new Object[] {
		new Boolean(byactivity),
		new Boolean(bynumber), number != null ? number : "",
		new Boolean(byresource), resource.getInteger() != null ? resource.getInteger() : new Integer(0),
		new Boolean(bydate), date.getSqlDate() != null ? date.getSqlDate() : new java.sql.Date(0),
		new Boolean(byorg), org.getInteger() != null ? org.getInteger() : new Integer(0),
		getOrder()
	};
}
public java.lang.String getFinderMethodName() {
	return "findRRLDocuments";
}
public Boolean getIsAdmin() {
	return Boolean.TRUE;
}
public java.lang.String getNumber() {
	return number;
}
public Integer getOrder() {
	try {
		Integer o = new Integer(Integer.parseInt(super.getFinderMethodName()));
		order = o;
	} catch(Exception e) {
	}
	return order;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getOrg() {
	return org;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
public com.hps.july.web.util.StringAndIntegerProperty getResource() {
	return resource;
}
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
public java.lang.String getResourcename() {
	return resourcename;
}
public int getState() {
	return com.hps.july.basestation.APPStates.RRL_LIST;
}
public java.lang.String getUsername() {
	return username;
}
public boolean isAdmin() {
	return admin;
}
public boolean isByactivity() {
	return byactivity;
}
public boolean isBydate() {
	return bydate;
}
public boolean isBynumber() {
	return bynumber;
}
/**
 * 
 * @return boolean
 */
public boolean isByorg() {
	return byorg;
}
public boolean isByresource() {
	return byresource;
}
public void setAdmin(boolean newAdmin) {
	admin = newAdmin;
}
public void setByactivity(boolean newByactivity) {
	byactivity = newByactivity;
}
public void setBydate(boolean newBydate) {
	bydate = newBydate;
}
public void setBynumber(boolean newBynumber) {
	bynumber = newBynumber;
}
/**
 * 
 * @param newByorg boolean
 */
public void setByorg(boolean newByorg) {
	byorg = newByorg;
}
public void setByresource(boolean newByresource) {
	byresource = newByresource;
}
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * 
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setUsername(java.lang.String newUsername) {
	username = newUsername;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	if(byresource) {
		// Апдейт наименования ресурса
		try {
			ResourceAccessBean res = new ResourceAccessBean();
			res.setInitKey_resource(resource.getInteger().intValue());
			res.refreshCopyHelper();
			resourcename = res.getName();
			resourcemodel = res.getModel();
		} catch(Exception e) {
			resourcename = "";
			resourcemodel = "";
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
