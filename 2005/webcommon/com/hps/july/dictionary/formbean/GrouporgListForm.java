package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка организаций принадлежащих группе
 */
public class GrouporgListForm extends com.hps.july.web.util.BrowseForm {
	private int searchgroup;
	private java.lang.String searchgroupname;
	private int searchgroupping;
	private java.lang.String searchgrouppingname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public GrouporgListForm() {
	this.setFinderMethodName( "findOrganizationsByQBEAndGroup" );
	searchgroup = 0;
	searchgroupname = "";
	searchgroupping = 0;
	searchgrouppingname = "";
	}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictPartAdmin");
	roles.add("dictPartOperator");
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("ArendaManager");
	roles.add("ArendaMainManager");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { 
		Boolean.FALSE, "",
		Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
		Boolean.FALSE, "",
		new Integer(1),
		Boolean.TRUE, new Integer(searchgroup), new Integer(searchgroupping)
	};
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
 * Creation date: (14.06.2002 10:15:30)
 * @return int
 */
public int getSearchgroupping() {
	return searchgroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2002 10:15:47)
 * @return java.lang.String
 */
public java.lang.String getSearchgrouppingname() {
	return searchgrouppingname;
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
/**
 * Insert the method's description here.
 * Creation date: (14.06.2002 10:15:30)
 * @param newSearchgroupping int
 */
public void setSearchgroupping(int newSearchgroupping) {
	searchgroupping = newSearchgroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2002 10:15:47)
 * @param newSearchgrouppingname java.lang.String
 */
public void setSearchgrouppingname(java.lang.String newSearchgrouppingname) {
	searchgrouppingname = newSearchgrouppingname;
}
}
