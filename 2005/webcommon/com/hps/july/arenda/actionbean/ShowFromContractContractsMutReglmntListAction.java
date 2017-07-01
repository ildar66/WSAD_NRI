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
 * действие для "Формы 'из регламента'".
 * Creation date: (05.12.2002 17:04:40)
 * @author: Sergey Gourov
 */
public class ShowFromContractContractsMutReglmntListAction extends ShowContractsMutReglmntListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_CONTRACTS_MUTREGLMNT_LIST);
		return mapping.findForward("main");
	}
}
