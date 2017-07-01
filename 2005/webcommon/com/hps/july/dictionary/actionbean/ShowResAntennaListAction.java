/*
 * Created on 30.01.2007
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
public class ShowResAntennaListAction extends BrowseAction{
	public java.lang.String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCResourceGroupsObject";
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
		ParamsParser.setState( request, Applications.DICTIONARY, APPStates.RESANTENNA_LIST );
		return mapping.findForward( "main" );
	}
}