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
 * Действие для "регламент из истории контракта".
 * Creation date: (05.12.2002 17:08:50)
 * @author: Sergey Gourov
 */
public class ShowFromHistoryContractsMutReglmntListAction extends ShowContractsMutReglmntListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMHISTORY_CONTRACTS_MUTREGLMNT_LIST);
		return mapping.findForward("main");
	}
}
