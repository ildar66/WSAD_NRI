package com.hps.july.dictionary.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.dictionary.formbean.RRLAntenaForm;
import com.hps.july.persistence2.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Action, вызываемый пл действию в форме редактирования скорости потока и т.п. параметров антенн ррл
 * Creation date: (14.07.2004 12:44:09)
 */
 
public class RRLAntenaProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 11:08:30)
 * @return org.apache.struts.action.ActionForward
 */
public ActionForward processDelete( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	RRLAntenaForm antenaform = (RRLAntenaForm)editForm;
	RRLResourceFacadeBean bean = new RRLResourceFacadeBean();
	bean.deleteRRLAntena(antenaform.getResource());
   	return null;
}
/**
 * Метод, который вызывается в режиме добавления записи (action=Add).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	ActionForward forward = super.processInsert(mapping, request, errors, editForm);
	if (forward == null) {
		forward = mapping.findForward("successandedit");
		StringBuffer path = new StringBuffer(forward.getPath());
		int parameterstart = 0;
		parameterstart = path.toString().indexOf("?");
		if(parameterstart > 0) {
			path = new StringBuffer(path.substring(0, parameterstart));
		}
		path.append("?action=Edit&resource=");
		path.append(((RRLAntenaForm)editForm).getResource());
		forward.setPath(path.toString());
	}
	return forward;
}
}
