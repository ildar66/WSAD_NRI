package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма редактирования работника.
 * Creation date: (27.02.2002 16:51:44)
 * @author: Dmitry Dneprov
 */
public class WorkerForm extends AbstractWorkerForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWRK;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	super.initRecord(request);
  	PeopleAccessBean bean = (PeopleAccessBean) request.getSession().getAttribute( "people" );
  	if (bean != null) {
		setMancode(new Integer(bean.getMan()));
		setManname(bean.getFullName());
  	}
}
}
