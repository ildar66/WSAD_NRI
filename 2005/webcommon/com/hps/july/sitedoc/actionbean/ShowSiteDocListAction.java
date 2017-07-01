package com.hps.july.sitedoc.actionbean;

import com.hps.july.sitedoc.valueobject.*;
import java.util.*;
import java.lang.reflect.*;
import com.hps.july.web.util.*;
import com.hps.july.sitedoc.formbean.*;
import com.hps.july.persistence.*;
import org.apache.struts.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.constants.*;
import com.hps.july.sitedoc.*;

/**
 * Обработчик формы списка документов
 */
public class ShowSiteDocListAction
	extends com.hps.july.web.util.BrowseAction
{
public String getBrowseBeanName() {
//	return "com.hps.july.sitedoc.valueobject.SiteDocObject";
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
public void initResources(ActionForm form)
{
	/*
	dForm.setBsResources(
		MessageResources.getMessageResources("com.hps.july.sitedoc.BsResources")
	);
	dForm.setSiteinfoResources(
		MessageResources.getMessageResources("com.hps.july.sitedoc.SiteinfoResources")
	);

    if (servlet.getServletContext().getAttribute("bsResources") == null) {
        servlet.getServletContext().setAttribute("bsResources", dForm.getBsResources());
    }
    if (servlet.getServletContext().getAttribute("siteinfoResources") == null) {
        servlet.getServletContext().setAttribute("siteinfoResources", dForm.getSiteinfoResources());
    }

    if (servlet.getServletContext().getAttribute("MenuResources") == null) {
        servlet.getServletContext().setAttribute("MenuResources", MessageResources.getMessageResources("com.hps.july.sitedoc.MenuResources"));
    }
    dForm.calculateObject();
    */
    TextResources.getBsResources(servlet.getServletContext());
    TextResources.getSiteinfoResources(servlet.getServletContext());
    TextResources.getMenuResources(servlet.getServletContext());
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
	initResources(form);

	SiteDocListForm dForm = (SiteDocListForm) form;
	dForm.initObjectDef(servlet.getServletContext(),request.getSession());
	
    super.perform(mapping, form, request, response);
    ParamsParser.setState(request, com.hps.july.constants.Applications.SITEDOC, APPStates.SiteDocListForm);
    return mapping.findForward("main");
}
}
