package com.hps.july.dictionary.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.dictionary.formbean.RRLSpeedParamForm;
/**
 * Action для добавления, редактирования, удаления из таблицы данных по скоростям ррл антенн через jdbc
 * Creation date: (20.07.2004 18:06:10)
 */
public class RRLSpeedParamProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 18:08:49)
 * @return org.apache.struts.action.ActionForward
 */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
	ActionForward retVal = null;	
    ActionErrors errors = new ActionErrors();
    System.out.println("RRLSpeedParamProcessAction");

	RRLSpeedParamForm paramsform = (RRLSpeedParamForm)form;
	System.out.println("!!!!!!!!!!! resource = " + paramsform.getResource());
    
	retVal = super.perform(mapping, form, request, response);
    if(retVal.getPath().equals(mapping.findForward( "main" ).getPath()))
		return retVal;
	StringBuffer path = new StringBuffer(retVal.getPath());
	int parameterstart = 0;
	parameterstart = path.toString().indexOf("?");
	if(parameterstart > 0) {
		path = new StringBuffer(path.substring(0, parameterstart));
	}
	path.append("?action=Edit&resource=");
	path.append(paramsform.getResource());
	retVal.setPath(path.toString());
	return retVal;
}
}
