package com.hps.july.basestation.formbean;

import com.hps.july.siteinfo.valueobject.*;

/**
 * Форма выбора линий связи
 */
public class ComlineLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private RegionsSelector regionsSelector = new RegionsSelector();
	private String searchBy = "all";
	private String searchString;
	private String comlinestate;

	private boolean admin;
	private String username;
public ComlineLookupListForm() {
	this.setFinderMethodName( "findControllerLookup" );
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.basestation.valueobject.ComlineObject";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComlinestate() {
	return comlinestate;
}
public java.lang.Object[] getFilterParams() {
    try {
		return new Object[] {
			new Boolean(getRegionsSelector().isAllNetzones()),
			getRegionsSelector().getNetzonecodes(),
			new Boolean(getRegionsSelector().isAllRegions()),
			getRegionsSelector().getRegioncodes(),
			new Boolean(getRegionsSelector().isAllSuperregions()),
			getRegionsSelector().getSuperregioncodes(),
			(getSearchBy() != null)?getSearchBy():"",
			(getSearchString() != null)?getSearchString():"",
			(comlinestate != null?comlinestate:""),
			new Boolean(isAdmin()),
			getUsername()
		};
    } catch (Exception e) {
		e.printStackTrace(System.out);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findComlineLookupList";
}
/**
 * 
 * @return com.hps.july.siteinfo.valueobject.RegionsSelector
 */
public com.hps.july.siteinfo.valueobject.RegionsSelector getRegionsSelector() {
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
public java.lang.String getSearchString() {
	return searchString;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getUsername() {
	return username;
}
/**
 * 
 * @return boolean
 */
public boolean isAdmin() {
	return admin;
}
/**
 * 
 * @param newComlinestate java.lang.String
 */
public void setComlinestate(java.lang.String newComlinestate) {
	comlinestate = newComlinestate;
}
public void setRequestParams(javax.servlet.http.HttpServletRequest request)
{
	admin = request.isUserInRole("administrator");
	username = request.getRemoteUser();
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
 * @param newSearchString java.lang.String
 */
public void setSearchString(java.lang.String newSearchString) {
	searchString = newSearchString;
}
/**
 * 
 * @param newUsername java.lang.String
 */
public void setUsername(java.lang.String newUsername) {
	username = newUsername;
}
}
