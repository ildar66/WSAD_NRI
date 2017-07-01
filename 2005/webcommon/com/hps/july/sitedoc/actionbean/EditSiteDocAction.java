package com.hps.july.sitedoc.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.util.BeanUtils;
import com.hps.july.sitedoc.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.sitedoc.valueobject.*;

/**
 * Обработчик входа в форму редактирования документа
 */
public class EditSiteDocAction
	extends com.hps.july.jdbcpersistence.lib.EditAction
{
public void initResources()
{
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
    TextResources.getBsResources(servlet.getServletContext());
    TextResources.getSiteinfoResources(servlet.getServletContext());
    TextResources.getMenuResources(servlet.getServletContext());
	SiteDocForm editForm = (SiteDocForm) form;
    return super.perform(mapping,form,request,response);
}
}
