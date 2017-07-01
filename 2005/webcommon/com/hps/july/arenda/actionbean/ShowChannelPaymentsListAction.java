package com.hps.july.arenda.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * действие для канала "платежей"(лист) 
 * Creation date: (08.08.2002 18:17:16)
 * @author: Sergey Gourov
 */
public class ShowChannelPaymentsListAction extends ShowUsPaymentsListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.CHANNEL_PAYMENTS_LIST);
		return mapping.findForward("main");
	}
}
