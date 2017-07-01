package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма редактирования работника компании.
 * Creation date: (27.02.2002 16:51:44)
 * @author: Dmitry Dneprov
 */
public class WorkerFormC extends AbstractWorkerForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWRKC;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		super.initRecord(request);
		WorkerListCForm aform = (WorkerListCForm)request.getSession().getAttribute( "WorkerListCForm" );
		setCompanycode(new Integer(aform.getCompany()));
		CompanyAccessBean bean = constructCompanies();
		if (bean != null)
			setCompanyname(bean.getName());
	}
}
