package com.hps.july.web.util;

import java.util.Enumeration;
import java.util.ArrayList;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
//import org.apache.struts.util.PropertyUtils;
/**
 * Action, который позволяет делегировать обработку форме.
 * Creation date: (10.02.2004 12:49:52)
 * @author: Shafigullin Ildar
 */
public class FormProcessAction extends AbstractProcessAction {
/**
 * Передает обработку удаления в форму.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processDelete( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	String forwardName = editForm.processDelete(request,errors);
	if(!errors.empty()) {
		throw new ValidationException();
	}
	if(forwardName != null) {
		return mapping.findForward(forwardName);
	} else {
		return null;
	}
}
/**
 * Передает обработку добавления в форму.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.validateValues(errors);
	String forwardName = editForm.processInsert(request,errors);
	if(!errors.empty()) {
		throw new ValidationException();
	}
	if(forwardName != null) {
		return mapping.findForward(forwardName);
	} else {
		return null;
	}
}
/**
 * Передает обработку обновления в форму.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.validateValues(errors);
	String forwardName = editForm.processUpdate(request,errors);
	if(!errors.empty()) {
		throw new ValidationException();
	}
	if(forwardName != null) {
		return mapping.findForward(forwardName);
	} else {
		return null;
	}
}
}
