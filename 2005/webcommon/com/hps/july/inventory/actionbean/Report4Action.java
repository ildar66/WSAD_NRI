package com.hps.july.inventory.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * ���������� ������ "������ �� ������"
 */
public class Report4Action
	extends ReportAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform( mapping, form, request, response );
  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.RPT4 );
	return mapping.findForward( "main" );
}
}
