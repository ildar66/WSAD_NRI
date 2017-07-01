package com.hps.july.project.actionbean;

import javax.servlet.*; 
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.project.APPStates;
import com.hps.july.project.formbean.*;
import com.hps.july.project.valueobject.*;
import com.hps.july.persistence.*;

/**
 * Обработчик lookup по выбору типового события проекта.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowProtoActionLookupAction extends com.hps.july.web.util.LookupBrowseAction {

public Object constructRowModelBean(Object o, ActionForm aform) {
	try {
		((ProtoActionAccessBean)o).refreshCopyHelper();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	ProtoObject ob = new ProtoObject();
	ob.setPosition(((ProtoActionLookupForm)aform).getPosition());
	ob.setProto((ProtoActionAccessBean)o);
	return ob; 
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ProtoActionAccessBean";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws java.io.IOException, ServletException {

    super.perform(mapping, form, request, response);
    ParamsParser.setState(request, Applications.PROJECT, APPStates.PROTOACTIONLOOKUP);
    return mapping.findForward("main");
}
}
