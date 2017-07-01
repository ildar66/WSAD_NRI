package com.hps.july.arenda.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * Действие для "истории позиций"(лист).
 * Creation date: (30.09.2002 14:18:42)
 * @author: Sergey Gourov
 */
public class ShowHistoryPositionMultiListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 14:18:42)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.PositionAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_POS_MULTI);
		ActionForward retVal = super.perform(mapping, form, request, response);
		if (retVal == null) {
			retVal = mapping.findForward("main");
		}
		return retVal;
	}
}
