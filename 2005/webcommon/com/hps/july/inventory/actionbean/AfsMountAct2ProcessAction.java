package com.hps.july.inventory.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import com.hps.july.inventory.formbean.*;
import com.hps.july.logic.VisualDocTypes;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * ќбработчик формы редактировани€ позиции "¬нешнего приходного ордера"
 * ѕри добавлении нескольких серийных позиций осуществл€ет переход на 
 * форму редактировани€ серийных номеров.
 * ѕри удалении серийной позиции удал€ет все записи с номерами
 */
public class AfsMountAct2ProcessAction extends com.hps.july.web.util.AbstractProcessAction {
	
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

		//is canceled
		if( isCancelled(request) ) {
			return  mapping.findForward( "errorgoback" ); 
		}

  		//process actions
  		AbstractEntityAccessBean bean = null;
		AfsMountAct2Form editForm = (AfsMountAct2Form)form;
	    try { 
			editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());

			editForm.setUser(request.getRemoteUser());
			if (request.isUserInRole("administrator"))
				editForm.setIsAdmin(Boolean.TRUE);
			else
				editForm.setIsAdmin(Boolean.FALSE);
	  		
			String reqState = editForm.getProcessState();
			if( editForm.getAction().equals("Add") ) {
				editForm.validateValues(errors);
				String sc = mapping.findForward( "success" ).getPath();
				int ind = sc.indexOf("?");
				if ( ind > 0)
					sc = sc.substring(0, ind);
				sc = sc + "?action=Add&visualtype=" + VisualDocTypes.AFS_MOUNT_ACT_1800_900;
	  	    	retVal = new ActionForward(sc, true); 
			} else if( editForm.getAction().equals("Edit") ) {
				editForm.validateValues(errors);
				String sc = mapping.findForward( "success" ).getPath();
				int ind = sc.indexOf("?");
				if ( ind > 0)
					sc = sc.substring(0, ind);
				if ("2".equals(editForm.getDState())) {
					sc = sc + "?action=View&visualtype=" + VisualDocTypes.AFS_MOUNT_ACT_1800_900 + 
						"&document=" + editForm.getDocument() + "&processState=" + editForm.getProcessState();
				} else {
					sc = sc + "?action=Edit&visualtype=" + VisualDocTypes.AFS_MOUNT_ACT_1800_900 + 
						"&document=" + editForm.getDocument() + "&processState=" + editForm.getProcessState();
				}
				retVal = new ActionForward(sc, true);
			} 
	    } catch( ValidationException e ) {
		    if (e instanceof UpdateValidationException)
		    	ErrorProcessor.processException( errors, e );
		    // do nothing 
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" ); 
	    } catch( Exception e ) {
		    e.printStackTrace(System.out);
		    ErrorProcessor.processException( errors, e );
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" );
	  	    retVal = processException( errors, e, editForm, bean, retVal );
	    }
	    
		//process errors
	    if( !errors.empty() ) {
	 	  	saveErrors(request, errors);
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" ); 
	    }

	   /* if (retVal != null)
	    	System.out.println("RetVal=" + retVal.getPath());
	    else
	    	System.out.println("RetVal=null");*/
	    return retVal;    
	}
}
