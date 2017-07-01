package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.*;
import org.apache.struts.action.ActionForward;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
 
/**
 * Обработчик формы редактирования базовых станций.
 * Выполняет подготовку формы при создании компии БС
 */
public class EditCopyBaseStationAction
	extends com.hps.july.web.util.AbstractEditAction
{
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

    BaseStationForm bsForm = (BaseStationForm) form;
    bsForm.setAction("Edit");
    ActionForward forward = super.perform(mapping, form, request, response);
    bsForm.prepareCopy(request);
    bsForm.setAction("Add");
    try {
	    bsForm.getPositionForm().initCollections(request);
    } catch(Exception e) {
	    e.printStackTrace(System.out);
    }
	return forward;

    /*  
    EditForm editForm = (EditForm)form;
    if (editForm != null) {
    editForm.setReturnPage("");
    if (mapping.findForward( "errorgoback" ) != null)
        editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());
    try {
    	editForm.initCollections(request);  
    } catch ( Exception e) {   	
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
    	    ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
     	  	saveErrors(request, errors);
    		return  mapping.findForward( "errorgoback" ); 
    	}
    } else if( "Edit".equals(editForm.getAction()) || "Delete".equals(editForm.getAction()) || "View".equals(editForm.getAction()) ) {
    	try {
        	AbstractEntityAccessBean bean = editForm.getDataBean(request);
          	BeanUtils.copyProperties( editForm, bean ); 
          	editForm.fillRecord( bean );
    	      	ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
    	} catch ( Exception e) {   	
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
    ActionErrors errors = new ActionErrors();
    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
    	saveErrors(request, errors);
    return  mapping.findForward( "errorgoback" ); 
    }
    return  mapping.findForward( "main" );
    */
}
}
