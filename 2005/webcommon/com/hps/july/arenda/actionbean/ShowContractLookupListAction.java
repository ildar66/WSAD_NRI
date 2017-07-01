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
 * действие поиск для "контрактов(лист)".
 * Creation date: (11.07.2002 15:35:27)
 * @author: Sergey Gourov
 */
public class ShowContractLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 15:35:27)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseContractAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
		ParamsParser.setState(request, Applications.ARENDA, APPStates.CONTRACT_LOOKUP);
		return mapping.findForward( "main" );
	}
}
