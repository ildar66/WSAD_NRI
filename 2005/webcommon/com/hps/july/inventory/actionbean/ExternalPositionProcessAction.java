package com.hps.july.inventory.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import com.hps.july.inventory.formbean.*;
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
public class ExternalPositionProcessAction extends com.hps.july.web.util.AbstractProcessAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

		//is canceled
		if( isCancelled(request) ) {
			return  mapping.findForward( "success" ); 
		}

  		//process actions
  		AbstractEntityAccessBean bean = null;
		ExternalPositionForm editForm = (ExternalPositionForm)form;
	    try { 
		    editForm.setReturnPage("");
		    if (mapping.findForward( "errorgoback" ) != null) {
			    editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());
		    } else if (mapping.findForward( "success" ) != null) {
			    editForm.setReturnPage(mapping.findForward( "success" ).getPath());
		    }
	  		
			if( editForm.getAction().equals("Delete") ) {
				bean = editForm.getDataBean(request);
		      	bean.refreshCopyHelper();
		      	editForm.beforeDelete(bean,request);
				OuterDocPositionAccessBean pos = (OuterDocPositionAccessBean)bean;
				InWayBillProcessorAccessBean proc = new InWayBillProcessorAccessBean();
				proc.dropOuterDocPosition(new Integer(pos.getOuterDocPosition()));
		      	editForm.afterDelete(request);
			} else if( editForm.getAction().equals("Add") ) {
				editForm.validateValues(errors);
				bean = editForm.constructBean( request );
          		BeanUtils.copyProperties( bean, editForm ); 
		        editForm.beforeUpdate( bean, request );
		        bean.commitCopyHelper(); 
		        editForm.afterUpdate( bean, request );
			} else if( editForm.getAction().equals("Edit") ) {
				editForm.validateValues(errors);
		        bean = editForm.getDataBean(request);
          		BeanUtils.copyProperties( bean, editForm ); 
		        editForm.beforeUpdate( bean, request );
		        bean.commitCopyHelper();
		        editForm.afterUpdate( bean, request );
			}
			if(editForm.isManySerial() && "Add".equals(editForm.getAction())) {
				retVal = mapping.findForward( "seriallist" );
				retVal = new ActionForward(retVal.getPath()+"?outerDocPosition="+editForm.getOuterDocPositionstr(),retVal.getRedirect());
			} else {
				retVal = mapping.findForward( "success" );
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

	    return retVal;    
	}
}
