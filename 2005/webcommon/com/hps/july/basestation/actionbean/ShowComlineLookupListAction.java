package com.hps.july.basestation.actionbean;

import java.lang.reflect.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик формы выбора линий связи
 */
public class ShowComlineLookupListAction extends LookupBrowseAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	ComlineLookupListForm pForm=(ComlineLookupListForm)form;
	pForm.setRequestParams(request); 
	super.perform(mapping, form, request, response);
    ParamsParser.setState(request, Applications.BASESTATION, com.hps.july.basestation.APPStates.COMLINE_LOOKUP);
    return mapping.findForward("main");
}
}
