package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка группировок юр. лиц
 */
public class GrouppingListForm extends com.hps.july.web.util.BrowseForm {
	private int searchgroup;
	private java.lang.String searchgroupname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public GrouppingListForm() {
	this.setFinderMethodName( "findSearchGrouppingBySearchGroup" );
	searchgroup = 0;
	}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictPartAdmin");
	roles.add("ArendaMainEconomist");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.SearchGroupKey(searchgroup) };
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:25:56)
 * @return int
 */
public int getSearchgroup() {
	return searchgroup;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:25:24)
 * @return java.lang.String
 */
public java.lang.String getSearchgroupname() {
	return searchgroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:25:56)
 * @param newCompany int
 */
public void setSearchgroup(int newSearchgroup) {
	searchgroup = newSearchgroup;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:25:24)
 * @param newResourcetypename java.lang.String
 */
public void setSearchgroupname(java.lang.String newSearchgroupname) {
	searchgroupname = newSearchgroupname;
}
}
