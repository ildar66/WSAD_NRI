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
public class Report8Action extends com.hps.july.web.util.ReportAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.RPT8 );
	Report8ParamsForm frm = (Report8ParamsForm)request.getSession().getAttribute("Report8ParamsForm");
	frm.setAgregationType(0);
	try {
		String ser = frm.getSerial();
		StorageCardAccessBean sc = (new StorageCardAccessBean()).findBySerial(ser);
		AgregateContentAccessBean ac = new AgregateContentAccessBean();
		Enumeration en = sc.getAgregate();
		if(en.hasMoreElements()) {
			frm.setAgregationType(1); // Resource is unit
		} else {
			if(Boolean.TRUE.equals(frm.getShowAgregated())) {
				Enumeration eag = sc.getAgregateContent();
				if(eag.hasMoreElements()) {
					frm.setAgregationType(2); // Resource is agregate
				}
			}
		}
	} catch(Exception e) {
		// may be not found
		e.printStackTrace(System.out);
	}
	super.perform( mapping, form, request, response );
	return mapping.findForward( "main" );
}
}
