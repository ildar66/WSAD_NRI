package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования счёта юр. лица компании
 */
public class AccountFormC extends AbstractAccountForm {
	private java.lang.String compname;
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:52:34)
 * @return java.lang.String
 */
public java.lang.String getCompname() {
	return compname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITACCC;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	AccountListCForm aform = (AccountListCForm)request.getSession().getAttribute( "AccountListCForm" );
	setOrgcode(new Integer(aform.getOrganization()));
	setOrgname(aform.getOrgname());
	setCompname(aform.getCompname());
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:52:34)
 * @param newCompname java.lang.String
 */
public void setCompname(java.lang.String newCompname) {
	compname = newCompname;
}
}
