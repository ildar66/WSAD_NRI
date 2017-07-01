package com.hps.july.sitedoc.formbean;

import com.hps.july.web.util.*;

/**
 * Форма списка типов документов
 */ 
public class SiteDocTypeListForm extends BrowseForm {
	private String returnPage;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public SiteDocTypeListForm() {
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
/**
 * Insert the method's description here.
 * Creation date: (05.07.2003 12:33:03)
 * @return java.lang.String
 */
public java.lang.String getReturnPage() {
	return returnPage;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2003 12:33:03)
 * @param newReturnPage java.lang.String
 */
public void setReturnPage(java.lang.String newReturnPage) {
	returnPage = newReturnPage;
}
}
