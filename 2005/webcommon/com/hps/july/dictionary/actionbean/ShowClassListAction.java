/*
 * Created on 14.03.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.actionbean;

import com.hps.july.dictionary.valueobject.CableValue;
import com.hps.july.persistence.*;
import com.hps.july.dictionary.formbean.CableListForm;
import com.hps.july.dictionary.formbean.ResourceClassForm;
import com.hps.july.dictionary.formbean.ResourceClassListForm;

import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.*;

import com.ibm.etools.archive.exception.ReopenException;
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
 * @author AAErmolov
 *
 * Обработчик формы списка классов ресурсов и комплектов
 */
public class ShowClassListAction extends BrowseAction{
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCResourcesObject";
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		ParamsParser.setState(request, Applications.DICTIONARY, APPStates.RESCLASS_LIST);
		super.perform(mapping, form, request, response);
		ResourceClassListForm listform = (ResourceClassListForm) form;
		if (listform.getClasstype().equalsIgnoreCase("C")) request.setAttribute("actionname","/EditResourcesetClass.do");
		else request.setAttribute("actionname","/EditResourceClass.do");
		return mapping.findForward("main");
	}
}