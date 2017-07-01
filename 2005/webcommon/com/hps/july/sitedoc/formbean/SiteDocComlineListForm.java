package com.hps.july.sitedoc.formbean;

import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.sitedoc.APPStates;
import com.hps.july.sitedoc.valueobject.EquipmentObject;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Форма списка связываемых линий связи
 */ 
public class SiteDocComlineListForm
	extends com.hps.july.web.util.BrowseForm
{
	private Integer sitedoc;

	private RegionsSelector regionsSelector = new RegionsSelector();
	
	private java.lang.String searchBy;
	private java.lang.String searchString;
	private int order;
	private Vector supregs;
	private String user;
	private boolean admin;

	private String comlinestate;
public SiteDocComlineListForm()
{
	regionsSelector.setAllNetzones(true);
	regionsSelector.setAllRegions(true);
	regionsSelector.setAllSuperregions(true);

    this.setFinderMethodName("1");
    order = 1;
//    netzonecodes = null;
        
    searchBy = EquipmentObject.SEARCH_ALL;
    searchString = "";
//    objectTypes=new String[]{};  
    
//    isAllSupregs=Boolean.TRUE;
//    isAllRegions=Boolean.TRUE;
//    isAllNetZones=Boolean.TRUE;
//    isAllObjectTypes=Boolean.FALSE;
}
public void checkRequest(HttpServletRequest request) {
	admin = request.isUserInRole("administrator");
	user = request.getRemoteUser();
	SiteDocForm siteDocForm = (SiteDocForm) request.getSession().getAttribute("SiteDocForm");
	sitedoc = new Integer(siteDocForm.getSitedoc());
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAddRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComlinestate() {
	return comlinestate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("siteProjector");
	roles.add("ArendaManager");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
public java.lang.Object[] getFilterParams()
{
	try {
		return new Object[] {
			new Boolean(regionsSelector.isAllNetzones()), 
			regionsSelector.getNetzonecodes(),
			new Boolean(regionsSelector.isAllRegions()),
			regionsSelector.getRegioncodes(),
            new Boolean(regionsSelector.isAllSuperregions()),
			regionsSelector.getSuperregioncodes(),
			getSearchBy(),
			getSearchString(),
			(comlinestate != null)?comlinestate:"",
			isAdmin(),
			user,
            sitedoc
		};
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        return null;
    }
}
public java.lang.String getFinderMethodName() {
	return "findComlineList";
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 11:02:54)
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 7:40:13)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getRegions() {
	return new Vector().elements();
}
/**
 * 
 * @return com.hps.july.siteinfo.valueobject.RegionsSelector
 */
public com.hps.july.siteinfo.valueobject.RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:23)
 * @return java.lang.String
 */
public java.lang.String getSearchBy() {
	return searchBy;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:40)
 * @return java.lang.String
 */
public java.lang.String getSearchString() {
	return searchString;
}
public Boolean isAdmin() {
	return new Boolean(admin);
}
/**
 * 
 * @param newComlinestate java.lang.String
 */
public void setComlinestate(java.lang.String newComlinestate) {
	comlinestate = newComlinestate;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 11:02:54)
 * @param newOrder int
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:23)
 * @param newSearchBy java.lang.String
 */
public void setSearchBy(java.lang.String newSearchBy) {
    searchBy = newSearchBy;
    /*
    if (searchBy.equals("G")) {
        super.setFinderMethodName("7");
    }
*/
    }
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:40)
 * @param newSearchString java.lang.String
 */
public void setSearchString(java.lang.String newSearchString) {
    searchString = newSearchString.trim();
    
    if ((getSearchBy().equals("D") || getSearchBy().equals("E"))
        && (!searchString.substring(searchString.length()-1).equals("*")   )) {
        searchString += "*";
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(org.apache.struts.action.ActionErrors errors)
    throws Exception {

    //sitedoc=new Integer(((SiteDocForm)request.getSession().getAttribute("SiteDocForm")).getSitedoc());
    /*
        if (!errors.empty())
            throw new com.hps.july.web.util.ValidationException();
    */
}
}
