package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик отчёта "Текущее местоположение"
 * Поиск размещения объекта и его составных частей по серийному номеру
 */
public class ProcessExportFileAction extends AbstractEditAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	//super.perform( mapping, form, request, response ); 
	System.err.println("***User:" +request.getRemoteUser());
  	
	ExportFileForm eform = (ExportFileForm)form;
	ActionForward retVal = null;
	ActionErrors errors = new ActionErrors();
	try{
		eform.validateValues(errors);
		retVal = mapping.findForward( "export" );
	}catch( ValidationException e ) {	
		//ErrorProcessor.processException( errors, e );
	}

	 if( !errors.empty() ) {
	 	 // saveErrors(request, errors);
	  	  retVal = mapping.findForward( "errorgoback" ); 
	 }
	
	return retVal;


	
}
}
