package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * действие для "процедурное"
 * Creation date: (20.08.2002 18:26:37)
 * @author: Sergey Gourov
 */
public class ProcedureProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.validateValues(errors);
	return mapping.findForward("success");
}
}
