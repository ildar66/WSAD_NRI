package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма ввода организации компании
 */
public class OrganizationFormC extends AbstractOrganizationForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITORGC;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	OrganizationListCForm aform = (OrganizationListCForm)request.getSession().getAttribute( "OrganizationListCForm" );
	setCompanycode(new Integer(aform.getCompany()));
	CompanyAccessBean bean = constructCompanies();
	if (bean != null)
		setCompanyname(bean.getName());
}
}
