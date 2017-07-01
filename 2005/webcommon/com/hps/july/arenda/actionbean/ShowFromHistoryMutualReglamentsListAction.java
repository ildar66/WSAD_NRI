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
 * Действие для "акты из истории".
 * Creation date: (28.10.2002 17:26:40)
 * @author: Sergey Gourov
 */
public class ShowFromHistoryMutualReglamentsListAction extends ShowMutualReglamentsListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMHISTORY_MUTUAL_REGLMNTS_LIST);
		return mapping.findForward("main");
	}
}
