package com.hps.july.arenda.actionbean;

import javax.servlet.http.*;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * действие для "отчетов аренды"
 */
public class ReportProcessAction extends AbstractProcessAction {
public ActionForward processDelete(HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.beforeDelete(null, request);
	editForm.validateValues(errors);
	editForm.afterDelete(request);
	return null;
}
public ActionForward processInsert( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.beforeUpdate(null,request);
	editForm.validateValues(errors);
	editForm.afterUpdate(null,request);
	return null;
}
public ActionForward processUpdate( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.beforeUpdate(null,request);
	editForm.validateValues(errors);
	editForm.afterUpdate(null,request);
	return null;
}
}
