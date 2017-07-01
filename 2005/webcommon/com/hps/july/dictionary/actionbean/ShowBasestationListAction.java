package com.hps.july.dictionary.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.dictionary.formbean.BasestationListForm;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.dictionary.APPStates;

/**
 * Обработчик формы списка базовых станций
 */
public class ShowBasestationListAction
	extends BrowseAction
{
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCResourcesObject";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	ParamsParser.setState(request, Applications.DICTIONARY, APPStates.BASESTATION_LIST);
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
}
