package com.hps.july.basestation.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import com.hps.july.basestation.formbean.*;

/**
 * Обработчик формы редактирования параметров эксплуатационных характеристик.
 * Вызывается при сохранении изменений параметра
 */
public class ParamsProcessAction
	extends Action
{
public ActionForward perform(ActionMapping mapping, ActionForm aform, HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	ActionForward retVal = null;
	ActionErrors errors = new ActionErrors();
	try {
		ParamsEditForm form = (ParamsEditForm)aform;
		form.setReturnPage("");
		if (mapping.findForward( "errorgoback" ) != null) {
			form.setReturnPage(mapping.findForward( "errorgoback" ).getPath());
		} else if (mapping.findForward( "success" ) != null) {
			    form.setReturnPage(mapping.findForward( "success" ).getPath());
		}
		if(form != null) {
			try {
				form.doSave(request,response,errors);
				retVal = mapping.findForward( "success" );
		    } catch(ValidationException e) {
		  	    ParamsParser.setState( request, form.getApplication(), form.getState() );
		  	    retVal = mapping.findForward( "main" );
		    } catch(Exception e) {
				e.printStackTrace(System.out);
				ErrorProcessor.processException(errors,e);
				ParamsParser.setState( request, form.getApplication(), form.getState() );
				retVal = mapping.findForward( "main" );
		    }
		    if( !errors.empty() ) {
		 	  	saveErrors(request, errors);
		  	    ParamsParser.setState( request, form.getApplication(), form.getState() );
		  	    retVal = mapping.findForward( "main" ); 
			}
  		} else {
	  		System.out.println("WEB.UTIL.ERROR: edit form is NULL");
			retVal = mapping.findForward( "success" );
  		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.params.formcast"));
		saveErrors(request, errors);
	}
	return retVal;    
}
}
