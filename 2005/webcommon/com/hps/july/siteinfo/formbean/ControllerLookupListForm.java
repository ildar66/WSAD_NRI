package com.hps.july.siteinfo.formbean;

/**
 * Форма выбора контроллера
 */
public class ControllerLookupListForm 
	extends com.hps.july.web.util.BrowseForm 
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ControllerLookupListForm() {
	this.setFinderMethodName( "findAllOrderByNameAsc" );
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
