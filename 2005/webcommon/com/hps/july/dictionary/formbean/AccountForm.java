package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования счёта юр. лица
 */
public class AccountForm extends AbstractAccountForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITACC;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	AccountListForm aform = (AccountListForm)request.getSession().getAttribute( "AccountListForm" );
	setOrgcode(new Integer(aform.getOrganization()));
	setOrgname(aform.getOrgname());
}
}
