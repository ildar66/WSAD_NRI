package com.hps.july.arenda.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.arenda.formbean.PaymentForm;
import com.hps.july.cdbc.objects.CDBCLeasePaymentObject;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * действие для "процесса платежей"
 */
public class PaymentProcessAction
	extends AbstractProcessAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	return super.perform(mapping,form,request,response);
/*
		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();


	    // Determine back URL
		// Temproraly exclude some applications from navigation
		boolean include = false;
		StateNavigator nav = null;
		StateNavigatorObject prevstate = null;
		try {
			String app = request.getContextPath();
			if ( (app.indexOf("basestation") > 0) || (app.indexOf("project") > 0) || (app.indexOf("sitedoc") > 0) || (app.indexOf("siteinfo") > 0) || (app.indexOf("arenda") > 0) )
			{
					include = true;
					nav = (StateNavigator)request.getSession().getAttribute(StateNavigator.NAVIGATOR_PARAM);
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}


		//is canceled

		if( isCancelled(request) ) {
			ActionForward ret = mapping.findForward( "success" );
			if (include) {
				if (nav.getPrevState().getContext().equals(request.getContextPath())) {
					String returnPath = nav.makeActionUrl(nav.getPrevState());
					ret.setPath(returnPath);
				} else {
					String returnPath = "http://" + request.getServerName() + nav.makeLinkUrl(nav.getPrevState());
					response.sendRedirect(returnPath);
					return null;
				}
			}
			return ret;
		}
		
  		//process actions
  		AbstractEntityAccessBean bean = null;
  		EditForm editForm = (EditForm)form;
  		if (editForm != null) {
			if (!include) {
			    editForm.setReturnPage("");
			    if (mapping.findForward( "errorgoback" ) != null)
				    editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());
			    else if (mapping.findForward( "success" ) != null)
				    editForm.setReturnPage(mapping.findForward( "success" ).getPath());
			} else {
				String returnPath = nav.makeActionUrl(nav.getPrevState());
				editForm.setReturnPage(returnPath);
			}
	  		
		    try { 
				if( editForm.getAction().equals("Delete") ) {
					retVal = processDelete( mapping, request, errors, editForm);
				} else if( editForm.getAction().equals("Add") ) {
					retVal = processInsert( mapping, request, errors, editForm);
				} else if( editForm.getAction().equals("Edit") ) {
					retVal = processUpdate( mapping, request, errors, editForm);
				}
				if (retVal == null) {
					retVal = mapping.findForward( "success" );
					if (include && (nav.getPrevState() != null)) {
						//System.out.println("ABS-PROCESS #1: prev context='" + nav.getPrevState().getContext() + "', " +
						//	"req context = '" + request.getContextPath() + "'");
						if (nav.getPrevState().getContext().equals(request.getContextPath())) {
							String returnPath = nav.makeActionUrl(nav.getPrevState());
							//System.out.println("ABS-PROCESS #2: before path='" + retVal.getPath() + "'");
							retVal.setPath(returnPath);
							//System.out.println("ABS-PROCESS #3: after path='" + retVal.getPath() + "'");
						} else {
							String returnPath = "http://" + request.getServerName() + nav.makeLinkUrl(nav.getPrevState());
							//System.out.println("ABS-PROCESS #4: before send redirect path='" + returnPath + "'");
							response.sendRedirect(returnPath);
							return null;
						}
					}
				}
				return retVal;
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
		  	    try {
					editForm.initCollections(request);
		  	    } catch (Exception e) {
			    	e.printStackTrace(System.out);
		  	    }
		  	    retVal = mapping.findForward( "main" ); 
		    }
  		} else {
	  		System.out.println("WEB.UTIL.ERROR: edit form is NULL");
			ActionForward ret = mapping.findForward( "success" );
			if (include) {
				if (nav.getPrevState().getContext().equals(request.getContextPath())) {
					String returnPath = nav.makeActionUrl(nav.getPrevState());
					ret.setPath(returnPath);
				} else {
					String returnPath = "http://" + request.getServerName() + nav.makeLinkUrl(nav.getPrevState());
					response.sendRedirect(returnPath);
					return null;
				}
			}
			return ret;
  		}

	    return retVal;
*/
}
public ActionForward processDelete( HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws Exception
{
	PaymentForm iForm = (PaymentForm)editForm;
	Integer idPayNfs = CDBCLeasePaymentObject.isPaymentFromNfs(iForm.getLeaseDocPosition());
	if(idPayNfs != null){
		String errorTxt = CDBCLeasePaymentObject.movePayNfs2Nri(request.getRemoteUser(), idPayNfs.intValue(), iForm.getLeaseContractcode().intValue(), CDBCLeasePaymentObject.ACTION_FROM_NRI);
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
			throw new ValidationException();
		}		
		return null;
	}else{
		return super.processDelete(request,errors,editForm);		
	}
/*
  		AbstractEntityAccessBean bean = null;
		bean = editForm.getDataBean(request);
      	bean.refreshCopyHelper();
      	editForm.beforeDelete( bean, request ); 
      	bean.getEJBRef().remove(); 
      	editForm.afterDelete(request);
      	return null;
*/
}
public ActionForward processInsert( HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws Exception
{
	return super.processInsert(request,errors,editForm);
/*
  		AbstractEntityAccessBean bean = null;
		editForm.validateValues(errors);
		bean = editForm.constructBean( request );
		//System.out.println("AbstractProcessAction: BEFORE COPY PROPERTIES");
		BeanUtils.copyProperties( bean, editForm ); 
		//System.out.println("AbstractProcessAction: AFTER COPY PROPERTIES");
        editForm.beforeUpdate( bean, request );
        bean.commitCopyHelper(); 
        editForm.afterUpdate( bean, request );
      	return null;
*/
}
public ActionForward processUpdate(HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws Exception
{
	return super.processUpdate(request,errors,editForm);
	/*
  		AbstractEntityAccessBean bean = null;
		editForm.validateValues(errors);
        bean = editForm.getDataBean(request);
        BeanUtils.copyProperties( bean, editForm ); 
        editForm.beforeUpdate( bean, request );
        bean.commitCopyHelper();
        editForm.afterUpdate( bean, request );
      	return null;
	*/
}
}
