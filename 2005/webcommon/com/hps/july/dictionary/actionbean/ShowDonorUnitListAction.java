/*
 * Created on 13.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.dictionary.APPStates;
import com.hps.july.web.util.BrowseAction;
import com.hps.july.web.util.ParamsParser;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowDonorUnitListAction extends BrowseAction {
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCResourcesObject";
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		ParamsParser.setState(request, Applications.DICTIONARY, APPStates.DONOR_UNIT_LIST);
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}