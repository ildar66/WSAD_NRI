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
 * Обработчик отчёта "Текущее местоположение"
 * Поиск размещения объекта и его составных частей по серийному номеру
 */
public class ReportExcelAction extends org.apache.struts.action.Action {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	super.perform( mapping, form, request, response );
	//ParamsParser.setState( request, Applications.INVENTORY, com.hps.july.inventory.APPStates.RPTXLS);
	ReportExcelForm rform = (ReportExcelForm)form;
	rform.loadData();
	return mapping.findForward( "excel" );
}
}
