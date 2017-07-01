package com.hps.july.sitedoc.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.sitedoc.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * ���������� ������ ����� ����������
 */
public class ShowSiteDocTypeListAction extends com.hps.july.web.util.BrowseAction {
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.SiteDocTypeAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	super.perform( mapping, form, request, response );
  	ParamsParser.setState( request, Applications.SITEDOC, APPStates.SiteDocTypeListForm );
	return mapping.findForward( "main" );
}
}