package com.hps.july.arenda.actionbean;

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
 * Action-class.
 * действие для "редактирование платежей"
 */
public class PaymentEditAction
	extends AbstractEditAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	// Call navigated perform
	return super.perform(mapping, form, request, response);
/*
	System.out.println("PAY-EDIT: #1");
    EditForm editForm = (EditForm)form;
    if (editForm != null) {
		System.out.println("PAY-EDIT: #2");
	    editForm.setReturnPage("");
	    if (mapping.findForward( "errorgoback" ) != null)
		    editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());
		try {
			System.out.println("PAY-EDIT: #3");
			editForm.initCollections(request);  
			System.out.println("PAY-EDIT: #4");
		} catch ( Exception e) {   	
			System.out.println("PAY-EDIT: #5");
			e.printStackTrace(System.out);
		    ActionErrors errors = new ActionErrors();
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
	 	  	saveErrors(request, errors);
			return  mapping.findForward( "errorgoback" ); 
		}
		if( "Add".equals(editForm.getAction()) ) {
			try {
				editForm.initRecord(request);  
		  		ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
			} catch ( Exception e) {   	
				e.printStackTrace(System.out);
			    ActionErrors errors = new ActionErrors();
		        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
		 	  	saveErrors(request, errors);
				return  mapping.findForward( "errorgoback" ); 
			}
		} else if( "Edit".equals(editForm.getAction()) || "Delete".equals(editForm.getAction()) || "View".equals(editForm.getAction()) ) {
			try {
				System.out.println("PAY-EDIT: #6");
		    	AbstractEntityAccessBean bean = editForm.getDataBean(request);
				System.out.println("PAY-EDIT: #7");
	          	BeanUtils.copyProperties( editForm, bean ); 
				System.out.println("PAY-EDIT: #8");
	          	editForm.fillRecord( bean );
				System.out.println("PAY-EDIT: #9");
	  	      	ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
			} catch ( Exception e) {   
				System.out.println("PAY-EDIT: #10");
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
	*/
}
}
