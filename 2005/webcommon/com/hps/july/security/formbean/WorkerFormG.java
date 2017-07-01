package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма редактирования работника группы.
 * Creation date: (27.02.2002 16:51:44)
 * @author: Dmitry Dneprov
 */
public class WorkerFormG extends AbstractWorkerForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWRKG;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		super.initRecord(request);
		WorkerListGForm aform = (WorkerListGForm)request.getSession().getAttribute( "WorkerListGForm" );
		setDivisioncode(new Integer(aform.getGroup()));
		setDivision(constructDivision());
	}
}
