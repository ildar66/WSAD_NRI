package com.hps.july.web.util;

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
 * Типовой Action, вызываемый по действию в форме.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class AbstractProcessAction extends NavigatedAction {
/**
 * Признак добавления текущего URL в историю (навигации).
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
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
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

	    //System.gc();

	    // Determine back URL
		// Temproraly exclude some applications from navigation
		boolean include = false;
		StateNavigator nav = null;
		StateNavigatorObject prevstate = null;
		try {
			String app = request.getContextPath();
			if ( (app.indexOf("basestation") > 0) || (app.indexOf("project") > 0) || (app.indexOf("sitedoc") > 0) || (app.indexOf("siteinfo") > 0) || (app.indexOf("arenda") > 0) || (app.indexOf("dict") > 0)) {
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
			    if (mapping.findForward( "errorgoback" ) != null) {
			    	String returnPage = mapping.findForward("errorgoback").getPath();
			    	String anchor = getAnchor(returnPage, request);
			    	if(anchor != null) {
				    	returnPage = (returnPage + anchor);
			    	}
				    editForm.setReturnPage(returnPage);
			    }
			    else if (mapping.findForward( "success" ) != null) {
			    	String returnPage = mapping.findForward("success").getPath();
			    	String anchor = getAnchor(returnPage, request);
			    	if(anchor != null) {
				    	returnPage = (returnPage + anchor);
			    	}
				    editForm.setReturnPage(returnPage);
			    }
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
				Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
				if (retVal == null) {
					retVal = mapping.findForward( "success" );
					if (include && (nav.getPrevState() != null)) {
						//System.out.println("ABS-PROCESS #1: prev context='" + nav.getPrevState().getContext() + "', " +
						// "req context = '" + request.getContextPath() + "'");
						StringBuffer anchor = null;
						if(profile != null) {
							if(editForm.getAction().equals("Delete")) {
								String anchorName = profile.getSelectableAnchor(nav.getPrevState().getContext() + nav.getPrevState().getUrl());
								String paramName = profile.getSelectableParamName(nav.getPrevState().getContext() + nav.getPrevState().getUrl());
								if(paramName != null) {
									String prevParam = profile.getSelectableNextParameter(nav.getPrevState().getContext() + nav.getPrevState().getUrl(), paramName);
									if(anchor == null) anchor = new StringBuffer("");
									anchor.append("#");
									anchor.append(anchorName);
									anchor.append(prevParam);
									profile.setSelectableCurrentParameter(nav.getPrevState().getContext() + nav.getPrevState().getUrl(), paramName, prevParam);
									nav.getPrevState().setAnchor(anchor.toString());
								}
							}
							if(editForm.getAction().equals("Add")) {
								String anchorName = profile.getSelectableAnchor(nav.getPrevState().getContext() + nav.getPrevState().getUrl());
								String paramName = profile.getSelectableParamName(nav.getPrevState().getContext() + nav.getPrevState().getUrl());
								//System.out.println("AbstractProcessAction:Add:paramName: ["+paramName+"]");
								if(paramName != null) {
									String newParam = editForm.getReturnParam();
									//System.out.println("AbstractProcessAction:Add:newParam: ["+newParam+"]");
									profile.setSelectableCurrentParameter(nav.getPrevState().getContext() + nav.getPrevState().getUrl(), paramName, newParam);
									if(anchor == null) anchor = new StringBuffer("");
									anchor.append("#");
									anchor.append(anchorName);
									anchor.append(newParam);
									nav.getPrevState().setAnchor(anchor.toString());
								}
							}
						}

						if (nav.getPrevState().getContext().equals(request.getContextPath())) {
							String returnPath = nav.makeActionUrl(nav.getPrevState());
							//System.out.println("ABS-PROCESS #2: before path='" + retVal.getPath() + "'");
							int c = returnPath.indexOf("#");
							if(c == returnPath.length()-1){
								returnPath = returnPath.substring(0, c);
							}
							retVal.setPath(returnPath);
							//System.out.println("ABS-PROCESS #3: after path='" + retVal.getPath() + "'");
						} else {
							String returnPath = "http://" + request.getServerName() + nav.makeLinkUrl(nav.getPrevState());
							//System.out.println("ABS-PROCESS #4: before send redirect path='" + returnPath + "'");
							response.sendRedirect(returnPath);
							return null;
						}
					}
				} else {
					if(profile != null) {
						String previousURL = profile.getPreviousURL();
						//System.out.println("AbstractProcessAction:ELSE:prevURL: ["+previousURL+"]");
						if(editForm.getAction().equals("Delete")) {
							String paramName = profile.getSelectableParamName(previousURL);
							if(paramName != null) {
								String prevParam = profile.getSelectableNextParameter(previousURL, paramName);
								profile.setSelectableCurrentParameter(previousURL, paramName, prevParam);
							}
						}
						if(editForm.getAction().equals("Add")) {
							String paramName = profile.getSelectableParamName(previousURL);
							//System.out.println("AbstractProcessAction:Add:ELSE:paramName: ["+paramName+"]");
							if(paramName != null) {
								String newParam = editForm.getReturnParam();
								//System.out.println("AbstractProcessAction:Add:ELSE:newParam: ["+newParam+"]");
								profile.setSelectableCurrentParameter(previousURL, paramName, newParam);
							}
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
	}
/**
 * Метод, который вызывается в режиме удаления записи (action=Delete).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processDelete( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
  		AbstractEntityAccessBean bean = null;
		bean = editForm.getDataBean(request);
      	bean.refreshCopyHelper();
      	editForm.beforeDelete( bean, request ); 
      	bean.getEJBRef().remove(); 
      	editForm.afterDelete(request);
      	return null;
}
/**
 * Метод, который вызывается в режиме удаления записи (action=Delete).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processDelete( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	return processDelete( request, errors, editForm);
}
/**
 * Метод обработки исключения, можно перекрыть для реализации своей обработки.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processException( ActionErrors errors, Exception e, EditForm editForm, 
	AbstractEntityAccessBean bean, ActionForward retVal ) {
	return retVal;
}
/**
 * Метод, который вызывается в режиме добавления записи (action=Add).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
  		AbstractEntityAccessBean bean = null;
		editForm.validateValues(errors);
		bean = editForm.constructBean( request );
		//System.out.println("AbstractProcessAction: BEFORE COPY PROPERTIES");
        BeanUtils.copyProperties( bean, editForm ); 
		//System.out.println("AbstractProcessAction: AFTER COPY PROPERTIES");
        editForm.beforeUpdate( bean, request );
        if (bean != null)
        	bean.commitCopyHelper(); 
        editForm.afterUpdate( bean, request );
      	return null;
}
/**
 * Метод, который вызывается в режиме добавления записи (action=Add).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	return processInsert( request, errors, editForm);
}
/**
 * Метод, который вызывается в режиме изменения записи (action=Edit).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
  		AbstractEntityAccessBean bean = null;
		editForm.validateValues(errors);
        bean = editForm.getDataBean(request);
        BeanUtils.copyProperties( bean, editForm ); 
        editForm.beforeUpdate( bean, request );
        if (bean != null)
        	bean.commitCopyHelper();
        editForm.afterUpdate( bean, request );
      	return null;
}
/**
 * Метод, который вызывается в режиме изменения записи (action=Edit).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	return processUpdate( request, errors, editForm);
}
}
