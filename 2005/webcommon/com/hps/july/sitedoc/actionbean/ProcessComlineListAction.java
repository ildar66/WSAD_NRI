package com.hps.july.sitedoc.actionbean;

import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.trailcom.beans.*;
import java.lang.reflect.*;
import java.util.*;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.sitedoc.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик списка линий связи.
 * Связывает отмеченные линии с документом
 */
public class ProcessComlineListAction
	extends com.hps.july.web.util.BrowseAction
{
private void addComlines(HttpServletRequest request)
	throws Exception
{
    Sitedoc2HopsAccessBean bean = null;
    SiteDocForm docForm =
        (SiteDocForm) request.getSession().getAttribute("SiteDocForm");
    int sitedoc = docForm.getSitedoc();
    int id;
    String[] params = request.getParameterValues("check_add");
    if(params==null) {
	    return;
    }
    for (int i = 0; i < params.length; i++) {
        id = Integer.parseInt(params[i]);
        bean = new Sitedoc2HopsAccessBean(sitedoc, id);
    }
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.sitedoc.valueobject.ComlineObject";
}
public int getRowsOnPage() {
	try {
		NamedValueAccessBean v = new NamedValueAccessBean();
		v.setInitKey_id("SiteListPageLenght");
		v.refreshCopyHelper();
		return v.getIntvalue();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return super.getRowsOnPage();
	}
}
private boolean isAddComlines(HttpServletRequest request) {
    Enumeration enum = request.getParameterNames();
    String submitName = "submit_add";
    String name = null;
    while (enum.hasMoreElements()) {
        name = (String) enum.nextElement();
        DebugSupport.println("parameter " + name);
        if (name.length() > submitName.length()
            && name.substring(0, submitName.length()).equals(submitName)) {
            DebugSupport.println("isAddEquipments true");
            return true;
        }
    }
    DebugSupport.println("isAddEquipments false");
    return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	try {
		if (isAddComlines(request)) {
			addComlines(request);
			ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocForm);
			return mapping.findForward("success");
		} else {
			SiteDocComlineListForm pForm = (SiteDocComlineListForm) form;
			pForm.checkRequest(request);
			superPerform(mapping, form, request, response);
            ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocComlineListForm);
            navigate(mapping, form, request, response);
        }
        return mapping.findForward("main");
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);
    }

}
public ActionForward superPerform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	System.out.println(new java.sql.Timestamp(System.currentTimeMillis()) + " BrowseAction superPerform started");
    // Check if process action requested instead of browse
     String s = request.getParameter(Constants.PROCESS_PROPERTY);
    if ("1".equals(s)) {
          return mapping.findForward("process");
    }

    //get form
    BrowseForm browseForm = (BrowseForm) form;
    ActionErrors errors = new ActionErrors(); //
    Object collection = new Vector().elements();
    try {
        browseForm.validateValues(errors);
        if (errors.empty()) {
            //build full enumeration
            Class cl = Class.forName(getBrowseBeanName());
            java.lang.reflect.Constructor cons = cl.getConstructor(new Class[] {
            });
            Object bean = cons.newInstance(new Object[] {
            });
            Object[] filterParams = browseForm.getFilterParams();
            Class filterParamTypes[] = new Class[filterParams.length];
            for (int i = 0; i < filterParams.length; i++) {
	            System.out.println("FINDER PARAM("+i+"):"+filterParams[i]+" class:"+(filterParams[i]==null?"?":filterParams[i].getClass().getName()));
                filterParamTypes[i] = filterParams[i].getClass();
            }
            Method finder =
                cl.getDeclaredMethod(browseForm.getFinderMethodName(), filterParamTypes);
            System.out.println(
                new java.sql.Timestamp(System.currentTimeMillis())
                    + " finder.invoke() started");
            collection = finder.invoke(bean, filterParams);
            System.out.println(
                new java.sql.Timestamp(System.currentTimeMillis())
                    + " finder.invoke() finished");
            if (collection instanceof Collection) {
                collection = Collections.enumeration((Collection) collection);
            }
        }
        AccessBeanTable table = new AccessBeanTable((Enumeration) collection);

        //calculate new page
        int pages =
            table.numberOfRows() / getRowsOnPage()
                + (((table.numberOfRows() % getRowsOnPage()) == 0) ? 0 : 1);
        String action = browseForm.getBrowseAction();
        int page = browseForm.getCurrentPage();
        if (Constants.BROWSE_ACTION_BOTTOM.equals(action)) {
            page = pages;
            browseForm.setBrowseAction("");
        } else
            if (Constants.BROWSE_ACTION_NEXT.equals(action)) {
                page++;
                browseForm.setBrowseAction("");
            } else
                if (Constants.BROWSE_ACTION_PREV.equals(action)) {
                    page--;
                    browseForm.setBrowseAction("");
                } else
                    if (Constants.BROWSE_ACTION_TOP.equals(action)) {
                        page = 1;
                        browseForm.setBrowseAction("");
                    }
        page = (page <= pages) ? page : pages;
        page = (page >= 1) ? page : 1;
        browseForm.setCurrentPage(page);

        //building display list
        int nRecords = 1;
        if (table.numberOfRows() > 0) {
            nRecords = getRowsOnPage();
            int endRow = (page) * getRowsOnPage() - 1;
            if (endRow > table.numberOfRows()) {
                int startRow = (page - 1) * getRowsOnPage();
                nRecords = table.numberOfRows() - startRow;
            }
        }
        Object displayList[] = new Object[nRecords];
        int j = 0;

        try {
            this.getClass().getDeclaredMethod(
                "constructRowModelBean",
                new Class[] { Object.class });
            for (int i = (page - 1) * getRowsOnPage();
                i < (page) * getRowsOnPage() && i < table.numberOfRows();
                i++) {
                displayList[j++] = constructRowModelBean(table.getRow(i));
            }
            request.setAttribute("browseList", displayList);
        } catch (NoSuchMethodException e) {
            request.setAttribute("browseList", table.rows());
        }

        request.setAttribute("numberOfPages", new Integer(pages));
    } catch (Exception e) {
        if (!errors.empty()) {
            System.out.println("Error while check form:");
        } else {
            System.out.println("Error while constructing list:");
            e.printStackTrace(System.out);
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
        }

        /*    
            System.out.println("Error while constructing list:");
            e.printStackTrace(System.out);
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
            saveErrors(request, errors);
        */
        //throw new ServletException( "While constructing list: ", e );
    }
    saveErrors(request, errors);
    System.out.println(
        new java.sql.Timestamp(System.currentTimeMillis())
            + " BrowseAction superPerform finish");
    return null;
}
}
