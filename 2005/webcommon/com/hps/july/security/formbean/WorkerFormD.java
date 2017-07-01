package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * ‘орма редактировани€ работника подразделени€.
 * Creation date: (27.02.2002 16:51:44)
 * @author: Dmitry Dneprov
 */
public class WorkerFormD extends AbstractWorkerForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWRKD;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		super.initRecord(request);
		WorkerListDForm aform = (WorkerListDForm)request.getSession().getAttribute( "WorkerListDForm" );
		setDivisioncode(new Integer(aform.getDepartment()));
		setDivision(constructDivision());
	}
}
