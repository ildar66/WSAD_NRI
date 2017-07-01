package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * ‘орма списка содержимого набора оборудовани€
 */
public class ComplectContentListForm extends com.hps.july.web.util.BrowseForm {
	private int resourceset;
	private java.lang.String resourcesetname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ComplectContentListForm() {
	this.setFinderMethodName( "findSetPartsBySet" );
	resourceset = 0;
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	//roles.add("dictResOperator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new ResourceSetKey(getResourceset()) };
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:21)
 * @return int
 */
public int getResourceset() {
	return resourceset;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 13:57:37)
 * @return java.lang.String
 */
public java.lang.String getResourcesetname() {
	return resourcesetname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:21)
 * @param newResource int
 */
public void setResourceset(int newResourceset) {
	resourceset = newResourceset;
}
/**
 * Insert the method's description here.
 */
public void setResourcesetname(String newResourcesetname) {
	resourcesetname = newResourcesetname;
}
}
