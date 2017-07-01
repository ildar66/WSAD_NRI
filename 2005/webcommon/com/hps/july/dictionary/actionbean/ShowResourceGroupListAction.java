/*
 * Created on 26.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;

import com.hps.july.web.util.BrowseAction;

import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.dictionary.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.dictionary.formbean.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowResourceGroupListAction extends BrowseAction {
	public java.lang.String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCResourceGroupsObject";
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
		ParamsParser.setState( request, Applications.DICTIONARY, APPStates.RESOURCEGROUP_LIST );
		return mapping.findForward( "main" );
	}
}