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
 * действие дл€ "ѕравила из контракта"(лист).
 * Creation date: (06.12.2002 12:16:50)
 * @author: Sergey Gourov
 */
public class ShowFromContractMutualRulesListAction extends ShowMutualRulesListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_MUTUAL_RULES_LIST);
		return mapping.findForward("main");
	}
}
