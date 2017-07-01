package com.hps.july.dictionary.formbean;

/**
 * Форма выбора дирекции
 */
public class DirectionLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Integer company;
	private java.lang.String companyname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public DirectionLookupListForm() {
	this.setFinderMethodName( "findByParentOrderByNameAsc" );
	company = new Integer(0);
	}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:46:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getCompany() {
	return company;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:00:53)
 * @return java.lang.String
 */
public java.lang.String getCompanyname() {
	return companyname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { company };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:46:32)
 * @param newCompany java.lang.Integer
 */
public void setCompany(java.lang.Integer newCompany) {
	company = newCompany;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:00:53)
 * @param newCompanyname java.lang.String
 */
public void setCompanyname(java.lang.String newCompanyname) {
	companyname = newCompanyname;
}
}
