package com.hps.july.arenda.actionbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

/**
 * Action-class.
 * действие для "параметров регламента"
 * Creation date: (04.11.2003 10:58:11)
 * @author: Dmitry Dneprov
 */
public class ProcessMainParamsMutReglmntAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	super.processInsert( mapping, request, errors, editForm);
	return mapping.findForward("success");
}
}
