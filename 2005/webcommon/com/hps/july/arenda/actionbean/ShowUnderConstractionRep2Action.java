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
 * Действие для "Under constraction" rep2.
 * Creation date: (04.10.2002 17:48:19)
 * @author: Sergey Gourov
 */
public class ShowUnderConstractionRep2Action extends com.hps.july.web.util.NavigatedAction {
    public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.UNDER_CONSTRACTION_REP2);
		return mapping.findForward("main");
    }
}
