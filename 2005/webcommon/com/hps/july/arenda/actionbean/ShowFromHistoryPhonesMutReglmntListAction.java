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
 * Действие для "телефоны из истории контракта"(лист).
 * Creation date: (15.11.2002 14:40:35)
 * @author: Sergey Gourov
 */
public class ShowFromHistoryPhonesMutReglmntListAction extends ShowPhonesMutReglmntListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMHISTORY_PHONES_MUTREGLMNT_LIST);
		return mapping.findForward("main");
	}
}
