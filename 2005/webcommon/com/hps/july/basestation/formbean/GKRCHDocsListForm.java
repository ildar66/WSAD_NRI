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

import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Базовая форма списка разрешений ГКРЧ
 */
public class GKRCHDocsListForm
	extends com.hps.july.web.util.BrowseForm
{
	private RegionsSelector regionsSelector = new RegionsSelector();
    private boolean byactivity;
    private boolean bynumber;
    private String number;
	private boolean byresource;
    private StringAndIntegerProperty resource = new StringAndIntegerProperty();
    private String resourcename;
    private String resourcemodel;
    private boolean bydate;
    private StringAndSqlDateProperty date = new StringAndSqlDateProperty();
    
	private String username;
	private boolean admin;

	private Integer order = new Integer(4);
public GKRCHDocsListForm() {
	super();
	setLastVisited(true);
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
/**
 * 
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public com.hps.july.web.util.StringAndSqlDateProperty getDate() {
	return date;
}
public String getDocumentRegions(Integer sitedoc)
{
	String result = "";
	
	try {
		CDBCSitedocsObject o = new CDBCSitedocsObject();
		CDBCResultSet rs = o.findGKRCHRegions(sitedoc);
		
		ListIterator li = rs.listIterator();

		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			result += ro.getColumn("regname").asString();
			if(li.hasNext()) {
				result += ", ";
			}
		}
	} catch(Exception e) {
		result = "?";
	}

	return result;
}
public String getDocumentResources(String sitedoc)
{
	String result = "";
	Integer sd = null;

	try {
		sd = new Integer(Integer.parseInt(sitedoc));
	} catch(Exception e) {
	}
	
	CDBCSitedocsObject o = new CDBCSitedocsObject();
	return o.findDocsResourcesString(sd,true);
}
public Object[] getFilterParams() {
	return new Object[] {
		new Boolean(!regionsSelector.isAllSuperregions()), regionsSelector.getSuperregioncodes(),
		new Boolean(!regionsSelector.isAllRegions()), regionsSelector.getRegioncodes(),
		new Boolean(byactivity),
		new Boolean(bynumber), number != null ? number : "",
		new Boolean(byresource), resource.getInteger() != null ? resource.getInteger() : new Integer(0),
		new Boolean(bydate), date.getSqlDate() != null ? date.getSqlDate() : new java.sql.Date(0),
		new Boolean(admin), username != null ? username : "",
		getOrder()
	};
}
public java.lang.String getFinderMethodName() {
	return "findGKRCHDocuments";
}
public Boolean getIsAdmin() {
	return Boolean.TRUE;
}
/**
 * 
 * @return java.lang.String
 */
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
public com.hps.july.siteinfo.valueobject.RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getResource() {
	return resource;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public String getResourcesFreqrange(String sitedoc)
{
	String result = "";
	Integer sd = null;

	try {
		sd = new Integer(Integer.parseInt(sitedoc));
	} catch(Exception e) {
	}
	
	CDBCSitedocsObject o = new CDBCSitedocsObject();
	return o.findDocsResfrequencyString(sd,true);
}
public int getState() {
	return com.hps.july.basestation.APPStates.GKRCH_LIST;
}
public java.lang.String getUsername() {
	return username;
}
public boolean isAdmin() {
	return admin;
}
/**
 * 
 * @return boolean
 */
public boolean isByactivity() {
	return byactivity;
}
/**
 * 
 * @return boolean
 */
public boolean isBydate() {
	return bydate;
}
/**
 * 
 * @return boolean
 */
public boolean isBynumber() {
	return bynumber;
}
/**
 * 
 * @return boolean
 */
public boolean isByresource() {
	return byresource;
}
public void setAdmin(boolean newAdmin) {
	admin = newAdmin;
}
/**
 * 
 * @param newByactivity boolean
 */
public void setByactivity(boolean newByactivity) {
	byactivity = newByactivity;
}
/**
 * 
 * @param newBydate boolean
 */
public void setBydate(boolean newBydate) {
	bydate = newBydate;
}
/**
 * 
 * @param newBynumber boolean
 */
public void setBynumber(boolean newBynumber) {
	bynumber = newBynumber;
}
/**
 * 
 * @param newByresource boolean
 */
public void setByresource(boolean newByresource) {
	byresource = newByresource;
}
/**
 * 
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * 
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * 
 * @param newResourcename java.lang.String
 */
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
