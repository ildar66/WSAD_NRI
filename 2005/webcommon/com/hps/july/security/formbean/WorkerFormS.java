package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма редактирования работника службы.
 * Creation date: (27.02.2002 16:51:44)
 * @author: Dmitry Dneprov
 */
public class WorkerFormS extends AbstractWorkerForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWRKS;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		super.initRecord(request);
		WorkerListSForm aform = (WorkerListSForm)request.getSession().getAttribute( "WorkerListSForm" );
		setDivisioncode(new Integer(aform.getService()));
		setDivision(constructDivision());
	}
}
