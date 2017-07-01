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
 * Действие для "старт акт лист из контракта".
 * Creation date: (10.01.2003 16:52:31)
 * @author: Sergey Gourov
 */
public class ShowFromContractStartActListAction extends ShowStartActListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_START_ACT_LIST);
		return mapping.findForward("main");
	}
}
