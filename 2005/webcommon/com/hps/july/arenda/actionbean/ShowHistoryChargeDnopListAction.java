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
 * Действие для "История Оплаты начислений"(лист).
 * Creation date: (24.01.2003 14:28:01)
 * @author: Sergey Gourov
 */
public class ShowHistoryChargeDnopListAction extends ShowChargeDnopListAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 17:31:34)
 * @return java.lang.String
 */
protected String getListForm() {
	return "HistoryChargesListForm";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_CHARGE_DNOP_LIST);
		return mapping.findForward("main");
	}
}
