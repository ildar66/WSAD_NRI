package com.hps.july.sitedoc.formbean;

import com.hps.july.sitedoc.valueobject.DocObjectDef;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;
 
/**
 * ‘орма списка св€зываемых с документом позиций
 */ 
public class SiteDocPositionListForm
	extends com.hps.july.web.util.BrowseForm
{
	public final static String SEARCH_ALL = "all";
	private java.lang.String searchBy;
	private java.lang.String searchString;
	private int order;
		
	private Vector supregs;

	private RegionsSelector regionsSelector = new RegionsSelector();
    private Integer siteDocId;
	private String user;
	private boolean admin;

	private int[] kodPosition;

	private String posstate = "PE";
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public SiteDocPositionListForm()
{
    this.setFinderMethodName("5");
    order = 1;
    
//    isNetZone = java.lang.Boolean.FALSE;
//    dampsId = new com.hps.july.web.util.StringAndIntegerProperty();
//    gsmId = new com.hps.july.web.util.StringAndIntegerProperty();
//    dampsId.setInteger(new java.lang.Integer(0));
//    gsmId.setInteger(new java.lang.Integer(0));
//    name = "";
//    addr = "";
    searchBy = "B";
    searchString = "";
    
    //kodPosition = new int[0];

	regionsSelector.setAllSuperregions(true);
	regionsSelector.setAllRegions(true);
	regionsSelector.setAllNetzones(true);
}
public void checkRequest(HttpServletRequest request)
{
	admin = request.isUserInRole("administrator");
	user = request.getRemoteUser();
//	DocObjectDef def = DocObjectDef.getDef(request.getSession());
//	siteDocId = def.getS
	SiteDocForm siteDocForm =
		(SiteDocForm) request.getSession().getAttribute("SiteDocForm");
		siteDocId = new Integer(siteDocForm.getSitedoc());
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
public java.lang.Object[] getFilterParams() {
	try {
		if(posstate == null || "".equals(posstate.trim())) {
			posstate = "*";
		}

        return new Object[] {
			(siteDocId == null)?new Integer(0):siteDocId,
			new Boolean(!regionsSelector.isAllNetzones()), regionsSelector.getNetzonecodes(),
            new Boolean(!regionsSelector.isAllRegions()), regionsSelector.getRegioncodes(),
            new Boolean(!regionsSelector.isAllSuperregions()), regionsSelector.getSuperregioncodes(),
			new Boolean(admin), (user == null)?"":user,
			(searchBy == null)?"A":searchBy, (searchString == null)?"":searchString,
			posstate,
			new Integer(order)
		};
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
public java.lang.String getFinderMethodName() {
	return "findPossibleSiteDocPositions";
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2002 14:49:02)
 * @return int[]
 */
public int[] getKodPosition() {
	return kodPosition;
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
 * 
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
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
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getSiteDocId() {
	return siteDocId;
}
public Boolean isAdmin() {
	return new Boolean(admin);
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2002 14:49:02)
 * @param newKodPosition int[]
 */
public void setKodPosition(int[] newKodPosition) {
	kodPosition = newKodPosition;
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
 * 
 * @param newPosstate java.lang.String
 */
public void setPosstate(java.lang.String newPosstate) {
	posstate = newPosstate;
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
 * 
 * @param newSiteDocId java.lang.Integer
 */
public void setSiteDocId(java.lang.Integer newSiteDocId) {
	siteDocId = newSiteDocId;
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
