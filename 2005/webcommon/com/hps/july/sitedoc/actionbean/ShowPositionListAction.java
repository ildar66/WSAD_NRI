package com.hps.july.sitedoc.actionbean;

import java.lang.reflect.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
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
 * Обработчик формы списка позиций
 */
public class ShowPositionListAction extends BrowsePageAction {
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 12:02:58)
	 * @return java.lang.String
	 */
	public java.lang.String getBrowseBeanName() {
		return "com.hps.july.siteinfo.valueobject.Position";
	}

	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		SiteDocPositionListForm pForm=(SiteDocPositionListForm)form;
		pForm.checkRequest(request);
		//superPerform( mapping, form, request, response );
		super.perform( mapping, form, request, response );
		ParamsParser.setState( request, Applications.SITEDOC, APPStates.SiteDocPositionListForm );

		return mapping.findForward( "main" );
	}
	
	public ActionForward superPerform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	    System.out.println(new java.sql.Timestamp(System.currentTimeMillis()) + " BrowseAction superPerform started");
	    // Check if process action requested instead of browse
	    String s = request.getParameter(Constants.PROCESS_PROPERTY);
	    if ("1".equals(s)) {
	          return mapping.findForward("process");
	    }

	    //get form
	    SiteDocPositionListForm browseForm = (SiteDocPositionListForm) form;
	    ActionErrors errors = new ActionErrors(); //
	    Object collection = new Vector().elements();
	    try {
	        browseForm.validateValues(errors);
	        if (errors.empty()) {
	            //build full enumeration
	            Class cl = Class.forName(getBrowseBeanName());
	            Constructor cons = cl.getConstructor(new Class[] {});
	            Object bean = cons.newInstance(new Object[] {});
	            Object[] filterParams = browseForm.getFilterParams();
	            Class filterParamTypes[] = new Class[filterParams.length];
	            for (int i = 0; i < filterParams.length; i++) {
	                filterParamTypes[i] = filterParams[i].getClass();
	            }
	            Method finder = cl.getDeclaredMethod(browseForm.getFinderMethodName(), filterParamTypes);
	            System.out.println(new java.sql.Timestamp(System.currentTimeMillis()) + " finder.invoke() started");
	            collection = finder.invoke(bean, filterParams);
	            System.out.println(new java.sql.Timestamp(System.currentTimeMillis()) + " finder.invoke() finished");
	            if (collection instanceof Collection) {
	                collection = Collections.enumeration((Collection) collection);
	            }
	        }
	        AccessBeanTable table = new AccessBeanTable((Enumeration) collection);
	
	        //calculate new page
	        int pages = table.numberOfRows() / getRowsOnPage() + (((table.numberOfRows() % getRowsOnPage()) == 0) ? 0 : 1);
	        String action = browseForm.getBrowseAction();
	        int page = browseForm.getCurrentPage();
	        if (Constants.BROWSE_ACTION_BOTTOM.equals(action)) {
	            page = pages;
	            browseForm.setBrowseAction("");
	        } else if (Constants.BROWSE_ACTION_NEXT.equals(action)) {
	            page++;
	            browseForm.setBrowseAction("");
	        } else if (Constants.BROWSE_ACTION_PREV.equals(action)) {
		        page--;
		        browseForm.setBrowseAction("");
	        } else if (Constants.BROWSE_ACTION_TOP.equals(action)) {
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
	            this.getClass().getDeclaredMethod("constructRowModelBean", new Class[] { Object.class });
	
	            for (int i = (page - 1) * getRowsOnPage(); i < (page) * getRowsOnPage() && i < table.numberOfRows(); i++) {
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
	    System.out.println(new java.sql.Timestamp(System.currentTimeMillis()) + " BrowseAction superPerform finish");
	
	    return null;
	}
}
