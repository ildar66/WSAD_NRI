package com.hps.july.organizer.actionbean;

import com.hps.july.organizer.valueobject.OperatorTask;
import com.hps.july.commonbean.OrganizerAccessBean;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.organizer.*;
import com.hps.july.constants.*;
import com.hps.july.commonbean.*;
import com.hps.july.web.util.*;
import com.hps.july.organizer.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import java.util.*;


/**
 * Режим отображения списка задач, доступных пользователю.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowTaskListAction extends com.hps.july.web.util.NavigatedAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );

		ActionErrors errors = new ActionErrors();

		CDBCOrganizerObject bean = new CDBCOrganizerObject();
		CDBCResultSet tasksRes = bean.findOperatorTasks(request.getRemoteUser());
		//System.out.println("#1, tasksRes.getRowsCount()="+ tasksRes.getRowsCount());
		if (tasksRes.getRowsCount() > 0) {
			OperatorTask[] tasks = new OperatorTask [tasksRes.getRowsCount()];
			ListIterator it = tasksRes.listIterator();
			int i = 0;
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				//System.out.println("#2, ="+ ((Integer)(ro.getColumn("task").asObject())).intValue() + ", " + ro.getColumn("taskname").asString() +
				//	", " + ro.getColumn("context").asString());
				tasks [i] = new OperatorTask(((Integer)(ro.getColumn("task").asObject())).intValue(), ro.getColumn("taskname").asString(), "", 
					ro.getColumn("context").asString());
				i++;
			}
		  	request.setAttribute( "tasksList", tasks );
		}

		
		/*  Old Algorithm  -- deprecated
		OrganizerAccessBean bean = new OrganizerAccessBean();

		try {
		  System.out.println("ShowTaskListAction: Calling getOperatorTasks with user: '" + request.getRemoteUser() + "'");
		  tasks = bean.getOperatorTasks(request.getRemoteUser());
		  System.out.println("ShowTaskListAction: after return records(): " + tasks.length);
		  request.setAttribute( "tasksList", tasks );
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notasks"));
	    }

	    */
	    
		//process errors
	    if( !errors.empty() ) {
	 	  	saveErrors(request, errors);
	    }

	  	ParamsParser.setState( request, Applications.ORGANIZER, APPStates.TASKLIST );
		return mapping.findForward( "main" );
	}
}
