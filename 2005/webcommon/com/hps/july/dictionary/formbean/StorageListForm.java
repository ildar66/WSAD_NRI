package com.hps.july.dictionary.formbean;

import com.hps.july.siteinfo.valueobject.*;

/**
 * Форма списка складов
 */
public class StorageListForm
	extends com.hps.july.web.util.BrowseForm
{
	private RegionsSelector regionsSelector = new RegionsSelector();

	private boolean _isadmin;
	private String _username;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public StorageListForm() {
	this.setFinderMethodName( "findAllOrderByNameAsc" );
	setLastVisited(true);
	}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDictionaryObject";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		new Boolean(!regionsSelector.isAllSuperregions()), regionsSelector.getSuperregioncodes(),
		new Boolean(!regionsSelector.isAllRegions()), regionsSelector.getRegioncodes(),
		Boolean.FALSE, "",
		Boolean.FALSE, "",
		new Boolean(_isadmin), (_username != null?_username:""),
		new Integer(1)
	};
}
public String getFinderMethodName() {
	return "findStorages";
}
public RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
public org.apache.struts.action.ActionForward initBrowse(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException
{
	_username = request.getRemoteUser();
	_isadmin = request.isUserInRole("administrator");
  	com.hps.july.web.util.ParamsParser.setState( request, com.hps.july.constants.Applications.DICTIONARY, com.hps.july.dictionary.APPStates.STRGLIST );
	return super.initBrowse(mapping,request,response);
}
public void setRequestData(javax.servlet.http.HttpServletRequest request)
{
}
}
