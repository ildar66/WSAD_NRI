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
 * Обработчик отчёта "Наличие оборудования"
 */
public class Report1Action
	extends ReportProcessAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ActionForward forward = super.perform( mapping, form, request, response );
	//ParamsParser.setState( request, Applications.INVENTORY, APPStates.RPT1 );
	if(forward==null){
		return mapping.findForward( "excel" );
	}else{
		return forward;
	}
	
}
}
