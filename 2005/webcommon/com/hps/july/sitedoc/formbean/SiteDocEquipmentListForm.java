package com.hps.july.sitedoc.formbean;

import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.sitedoc.APPStates;
import com.hps.july.sitedoc.valueobject.EquipmentObject;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Форма списка связываемого с документом оборудования
 */ 
public class SiteDocEquipmentListForm 
	extends com.hps.july.web.util.BrowseForm 
{
	private Integer sitedoc;
	private RegionsSelector regionsSelector = new RegionsSelector();

	private Boolean isAllObjectTypes;

	private java.lang.String searchBy;
	private java.lang.String searchString;

	private String[] objectTypes;
	
	private int order;
		
	private Vector supregs;

	private String user;
	private boolean admin;
public SiteDocEquipmentListForm() {
    this.setFinderMethodName("1");
    order = 1;
        
    searchBy = EquipmentObject.SEARCH_ALL;
    searchString = "";
    objectTypes=new String[]{};  

    regionsSelector.setAllNetzones(true);
    regionsSelector.setAllRegions(true);
    regionsSelector.setAllSuperregions(true);
//    isAllObjectTypes=Boolean.FALSE;
}
public void checkRequest(HttpServletRequest request) {
	admin = request.isUserInRole("administrator");
	user = request.getRemoteUser();
    if (request.getParameterValues("objectTypes") == null || request.getParameterValues("objectTypes").length == 0) {
        setObjectTypes(new String[] {});
    }
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
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {

    try {
	    /*
        SiteDocForm siteDocForm =
            (SiteDocForm) request.getSession().getAttribute("SiteDocForm");
        Integer sitedoc = new Integer(siteDocForm.getSitedoc());
		*/
        try {
	        DebugSupport.println("!!!super.getFinderMethodName()=" + super.getFinderMethodName());
            order = Integer.parseInt(super.getFinderMethodName());
        } catch (NumberFormatException e) {
        DebugSupport.printlnError(e);
	        }
        DebugSupport.println("!!!getFilterParams() order=" + order);

        return new Object[] {
			sitedoc,
			new Boolean(regionsSelector.isAllNetzones()), regionsSelector.getNetzonecodes(),
            getIsAllObjectTypes(),
            getObjectTypes(),
			new Boolean(regionsSelector.isAllRegions()),
			regionsSelector.getRegioncodes(),
            new Boolean(regionsSelector.isAllSuperregions()),
			regionsSelector.getSuperregioncodes(),
            getSearchBy(),
            getSearchString(),
            new Integer(order)};


    } catch (Exception e) {
        DebugSupport.printlnError(e);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findEquipmentChoiceList";
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2003 16:50:32)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllObjectTypes() {
	if(isAllObjectTypes == null) {
		isAllObjectTypes = Boolean.FALSE;
	}
	return isAllObjectTypes;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2003 16:47:59)
 * @return java.lang.String[]
 */
public java.lang.String[] getObjectTypes() {
	return objectTypes;
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
 * Insert the method's description here.
 * Creation date: (04.07.2003 16:50:32)
 * @param newIsAllObjectTypes java.lang.Boolean
 */
public void setIsAllObjectTypes(java.lang.Boolean newIsAllObjectTypes) {
	isAllObjectTypes = newIsAllObjectTypes;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2003 16:47:59)
 * @param newObjectTypes java.lang.String[]
 */
public void setObjectTypes(java.lang.String[] newObjectTypes) {
	objectTypes = newObjectTypes;
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
    throws Exception
{
    //sitedoc=new Integer(((SiteDocForm)request.getSession().getAttribute("SiteDocForm")).getSitedoc());
    /*
        if (!errors.empty())
            throw new com.hps.july.web.util.ValidationException();
    */
}
}
