package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "Оплаты начислений".
 * Creation date: (24.01.2003 14:29:15)
 * @author: Sergey Gourov
 */
public class ShowUsChargeDnopListAction extends ShowChargeDnopListAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 17:31:34)
 * @return java.lang.String
 */
protected String getListForm() {
	return "UsChargesListForm";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.US_CHARGE_DNOP_LIST);
		return mapping.findForward("main");
	}
}
