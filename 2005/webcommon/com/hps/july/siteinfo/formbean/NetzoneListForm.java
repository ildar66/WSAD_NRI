package com.hps.july.siteinfo.formbean;

import com.hps.july.siteinfo.valueobject.*;

/**
 * Форма списка зон сети
 */
public class NetzoneListForm
	extends com.hps.july.web.util.BrowseForm
{
	private RegionsSelector regionsSelector = new RegionsSelector();
	private boolean isadmin;
	private String username;

	private String searchBy;
	private String searchVal;
public NetzoneListForm() {
	regionsSelector.setAllNetzones(false);
	regionsSelector.setAllRegions(false);
	regionsSelector.setAllSuperregions(false);
	searchVal = "";
	searchBy = "name";
	this.setFinderMethodName( "findNetzonesByRegions" );
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		new Boolean(!regionsSelector.isAllSuperregions()), regionsSelector.getSuperregioncodes(),
		new Boolean(!regionsSelector.isAllRegions()), regionsSelector.getRegioncodes(),
		(searchBy != null ? searchBy : ""),
		(searchVal != null ? searchVal : ""),
		(username != null ? username : ""),
		new Boolean(isadmin),
		new Integer(1)
	};
}
public RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSearchBy() {
	return searchBy;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSearchVal() {
	return searchVal;
}
public void setRequestData(javax.servlet.http.HttpServletRequest request)
{
	username = request.getRemoteUser();
	isadmin = request.isUserInRole("administrator");
}
/**
 * 
 * @param newSearchBy java.lang.String
 */
public void setSearchBy(java.lang.String newSearchBy) {
	searchBy = newSearchBy;
}
/**
 * 
 * @param newSearchVal java.lang.String
 */
public void setSearchVal(java.lang.String newSearchVal) {
	searchVal = newSearchVal;
}
}
