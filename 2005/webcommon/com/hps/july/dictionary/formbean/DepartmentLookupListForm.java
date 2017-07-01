package com.hps.july.dictionary.formbean;

/**
 * Форма выбора департамента
 */
public class DepartmentLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Integer service;
	private java.lang.String servicename;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public DepartmentLookupListForm() {
	this.setFinderMethodName( "findByParentOrderByNameAsc" );
	service = new Integer(0);
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { service };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:51:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getService() {
	return service;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:16:19)
 * @return java.lang.String
 */
public java.lang.String getServicename() {
	return servicename;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:51:20)
 * @param newService java.lang.Integer
 */
public void setService(java.lang.Integer newService) {
	service = newService;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:16:19)
 * @param newServicename java.lang.String
 */
public void setServicename(java.lang.String newServicename) {
	servicename = newServicename;
}
}
