/*
 * Created on 01.03.2006
 *
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.objects.CDBCOperatorObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.dictionary.formbean.NFSRes2NRIResForm;
import com.hps.july.web.util.ParamsParser;

/**
 * @author dima
 *
 */
public class NFSRes2NRIResAction extends Action {

	/**
	 * 
	 */
	public NFSRes2NRIResAction() {
		super();
	}
	
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		NFSRes2NRIResForm editForm = (NFSRes2NRIResForm)form;
		
		if ("Save".equals(editForm.getAction())) {
			editForm.setAction("Edit");
			ArrayList linkedResources = new ArrayList();
			if (editForm.getLinkedres() != null) {
				StringTokenizer st = new StringTokenizer(editForm.getLinkedres(), ",");
				while (st.hasMoreTokens()) {
					linkedResources.add(st.nextToken());
				}
				Integer oper = CDBCOperatorObject.findManByOperator(request.getRemoteUser());
				if (CDBCResourcesObject.setNFSLinkedResources(editForm.getResource(), linkedResources, oper))
					editForm.setAction("Close");
				else {
					// Show Errors
				}
			}
		}
		ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
		return mapping.findForward("main");	
	}

}
