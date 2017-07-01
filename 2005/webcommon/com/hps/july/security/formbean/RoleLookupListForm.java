package com.hps.july.security.formbean;

/**
 * Форма lookup по выбору роли.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class RoleLookupListForm extends com.hps.july.web.util.BrowseForm {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public RoleLookupListForm() {
	this.setFinderMethodName( "findAll" );
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
}
