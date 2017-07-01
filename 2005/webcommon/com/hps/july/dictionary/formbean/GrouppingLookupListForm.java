package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора группировки
 */
public class GrouppingLookupListForm extends com.hps.july.web.util.BrowseForm {
	private int searchgroup;
	private java.lang.String searchgroupname;
	private int searchgroupping;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public GrouppingLookupListForm() {
	this.setFinderMethodName( "findSearchGrouppingBySearchGroup" );
	searchgroup = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new SearchGroupKey(searchgroup) };
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:39:06)
 * @return java.lang.Integer
 */
public int getSearchgroup() {
	return searchgroup;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:46:21)
 * @return java.lang.String
 */
public java.lang.String getSearchgroupname() {
	return searchgroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 16:00:01)
 * @return int
 */
public int getSearchgroupping() {
	return searchgroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:39:06)
 * @param newResourcetype java.lang.Integer
 */
public void setSearchgroup(int newSearchgroup) {
	searchgroup = newSearchgroup;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:46:21)
 * @param newResourcetypename java.lang.String
 */
public void setSearchgroupname(java.lang.String newSearchgroupname) {
	searchgroupname = newSearchgroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 16:00:01)
 * @param newResourcesubtype int
 */
public void setSearchgroupping(int newSearchgroupping) {
	searchgroupping = newSearchgroupping;
}
}
