package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма редактирования работника дирекции.
 * Creation date: (27.02.2002 16:51:44)
 * @author: Dmitry Dneprov
 */
public class WorkerFormDr extends AbstractWorkerForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWRKDR;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		super.initRecord(request);
		WorkerListDrForm aform = (WorkerListDrForm)request.getSession().getAttribute( "WorkerListDrForm" );
		setDivisioncode(new Integer(aform.getDirection()));
		setDivision(constructDivision());
	}
}
