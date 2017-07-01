/*
 * Created on 04.06.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.dictionary.formbean.CableListForm;
import com.hps.july.dictionary.formbean.ResourceClassForm;
import com.hps.july.dictionary.formbean.ResourceClassListForm;
import com.hps.july.dictionary.formbean.ResourcesCommonListForm;

import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.*;

import com.ibm.etools.archive.exception.ReopenException;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.dictionary.APPStates;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Обработчик формы отчета о ресурсах
 */
public class ShowResourceReportAction extends BrowseAction {
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCResourcesObject";
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		ParamsParser.setState(request, Applications.DICTIONARY, APPStates.RESOURCEREPORT);
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}