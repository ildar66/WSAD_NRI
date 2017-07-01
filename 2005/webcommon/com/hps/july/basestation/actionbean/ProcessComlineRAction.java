package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;

public class ProcessComlineRAction
	extends ProcessEquipmentPAction
{
/**
 * Метод, который вызывается в режиме изменения записи (action=Edit).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	String cpy = request.getParameter("cpy");
	if(cpy != null) {
		ComlineRForm frm = (ComlineRForm)editForm;
		if("fd".equals(cpy) || "df".equals(cpy)) {
			return processUpdate( request, errors, editForm);
		} else if("chD".equals(cpy)) {
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
			frm.setShowType("D");
			if(
				(!request.isUserInRole("FreqManager") &&
				!request.isUserInRole("administrator") &&
				!request.isUserInRole("supregAdmin") &&
				!request.isUserInRole("regionAdmin")) || request.isUserInRole("siteProjector")
			) {
				frm.setAction("View");
			} else {
				frm.setAction("Edit");
			}
			return mapping.findForward( "main" );
		} else if("chF".equals(cpy)) {
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
			frm.setShowType("F");
			if(
				(!request.isUserInRole("siteTransport") &&
				!request.isUserInRole("FreqManager") &&
				!request.isUserInRole("administrator") &&
				!request.isUserInRole("supregAdmin") &&
				!request.isUserInRole("regionAdmin")) || request.isUserInRole("siteProjector")
			) {
				frm.setAction("View");
			} else {
				frm.setAction("Edit");
			}
			return mapping.findForward( "main" );
		} else {
			return processUpdate( request, errors, editForm);
		}
	} else {
		return processUpdate( request, errors, editForm);
	}
}
}
