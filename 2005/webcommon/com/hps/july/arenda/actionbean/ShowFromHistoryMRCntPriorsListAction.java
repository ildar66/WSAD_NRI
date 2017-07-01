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
 * Действие для "Приоритеты зачета между договорами из контракта".
 * Creation date: (19.12.2002 5:09:01)
 * @author: Sergey Gourov
 */
public class ShowFromHistoryMRCntPriorsListAction extends ShowMRCntPriorsListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIORS_LIST);
		return mapping.findForward("main");
	}
}
