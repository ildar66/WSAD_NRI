package com.hps.july.web.util;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;


/**
 * Типовой Action, вызываемый перед редактированием записи.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class AbstractEditAction extends NavigatedAction {
    /**
     * Основной метод обработки запроса.
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet exception occurs
     */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException {

	// Call navigated perform
	super.perform(mapping, form, request, response);

	//System.out.println("ABS-EDIT: #1");
    EditForm editForm = (EditForm)form;
    if (editForm != null) {
		//System.out.println("ABS-EDIT: #2");
	    editForm.setReturnPage("");
	    if (mapping.findForward( "errorgoback" ) != null) {
	    	String returnPage = mapping.findForward("errorgoback").getPath();
	    	String anchor = getAnchor(returnPage, request);
	    	if(anchor != null) {
		    	returnPage = (returnPage + anchor);
	    	}
		    editForm.setReturnPage(returnPage);
	    }
		try {
			//System.out.println("ABS-EDIT: #3");
			editForm.initCollections(request);  
			//System.out.println("ABS-EDIT: #4");
		} catch ( Exception e) {   	
			//System.out.println("ABS-EDIT: #5");
			e.printStackTrace(System.out);
		    ActionErrors errors = new ActionErrors();
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
	 	  	saveErrors(request, errors);
			return  mapping.findForward( "errorgoback" ); 
		}
		if( "Add".equals(editForm.getAction()) ) {
			try {
				editForm.initRecord(request);  
		  		ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
			} catch ( Exception e) {   	
				e.printStackTrace(System.out);
			    ActionErrors errors = new ActionErrors();
		        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
		 	  	saveErrors(request, errors);
				return  mapping.findForward( "errorgoback" ); 
			}
		} else if( "Edit".equals(editForm.getAction()) || "Delete".equals(editForm.getAction()) || "View".equals(editForm.getAction()) ) {
			try {
				editForm.loadRecord(request);
	  	      	ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
			} catch ( Exception e) {   
				//System.out.println("ABS-EDIT: #10");
				e.printStackTrace(System.out);
			    ActionErrors errors = new ActionErrors();
		        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.absent"));
		 	  	saveErrors(request, errors);
				return  mapping.findForward( "errorgoback" ); 
			}
		} else {
			System.out.println("Unknown action=" + editForm.getAction());
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
		}
    } else {
	    System.out.println("Edit form IS NULL");
	    ActionErrors errors = new ActionErrors();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
 	  	saveErrors(request, errors);
		return  mapping.findForward( "errorgoback" ); 
    }
	return  mapping.findForward( "main" ); 
}
}
