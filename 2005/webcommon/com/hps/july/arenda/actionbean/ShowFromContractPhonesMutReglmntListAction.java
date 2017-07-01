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
 * действие для "телефоны из контракта"(лист).
 * Creation date: (15.11.2002 12:01:06)
 * @author: Sergey Gourov
 */
public class ShowFromContractPhonesMutReglmntListAction extends ShowPhonesMutReglmntListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_PHONES_MUTREGLMNT_LIST);
		return mapping.findForward("main");
	}
}
