package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * действие для "акт из контракта"(лист).
 * Creation date: (11.12.2002 11:08:18)
 * @author: Sergey Gourov
 */
public class ShowFromContractMutualActsListAction extends ShowMutualActsListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_MUTACTS_LIST);
		return mapping.findForward("main");
	}
}
