package com.hps.july.arenda.actionbean;

import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * действие для "регламент из контракта"(лист).
 * Creation date: (28.10.2002 17:26:40)
 * @author: Sergey Gourov
 */
public class ShowFromContractMutualReglamentsListAction extends ShowMutualReglamentsListAction {
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 17:05:42)
 */
public ShowFromContractMutualReglamentsListAction() {
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_MUTUAL_REGLMNTS_LIST);
		return mapping.findForward("main");
	}
}
