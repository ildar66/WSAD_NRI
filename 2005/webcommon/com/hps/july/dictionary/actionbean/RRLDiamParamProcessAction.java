package com.hps.july.dictionary.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.dictionary.formbean.RRLDiamParamForm;
/**
 *  Action для добавления, редактирования, удаления из таблицы данных по диаметрам ррл антенн
 * Creation date: (16.07.2004 17:40:31)
 */
public class RRLDiamParamProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 12:45:46)
 * @return org.apache.struts.action.ActionForward
 * @param mapping org.apache.struts.action.ActionMapping
 * @param form org.apache.struts.action.ActionForm
 * @param request javax.servlet.http.HttpServletRequest
 * @param response javax.servlet.http.HttpServletResponse
 * @exception javax.servlet.ServletException The exception description.
 * @exception java.io.IOException The exception description.
 */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
	System.out.println("RRLDiamParamProcessAction");
	ActionForward retVal = null;
	retVal = super.perform(mapping, form, request, response);
	if(retVal.getPath().equals(mapping.findForward( "main" ).getPath())) {
		System.out.println("!!!!!!!!!!! main");
		return retVal;
	}
	//System.out.println("path = " + retVal.getPath());
	StringBuffer path = new StringBuffer(retVal.getPath());
	int parameterstart = 0;
	parameterstart = path.toString().indexOf("?");
	if(parameterstart > 0) {
		path = new StringBuffer(path.substring(0, parameterstart));
	}
	path.append("?action=Edit&resource=");
	path.append(((RRLDiamParamForm)form).getResource());
	retVal.setPath(path.toString());
    return retVal;    
}
}
