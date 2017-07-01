package com.hps.july.basestation.actionbean;

import org.apache.struts.action.ActionForward;
import com.hps.july.persistence.*;
import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
 
/**
 * Обработчик входа в формы редактирования базовых станций при просмотре и редактировании
 */
public class EditViewBaseStationAction
	extends AbstractEditAction
{
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException
{
	navigate(mapping,form,request,response);

	//processImport();
	try {
		DebugSupport.printlnTest("!!!EditViewBaseStationAction started");

		Integer basestation = null;

		BaseStationForm eForm = (BaseStationForm) form;
		eForm.setAction("View");
		eForm.setPath(mapping.getPath());

//		basestation = new Integer(eForm.getBasestation());
//		new DebugSupport().println("basestation=" + basestation);
//		request.setAttribute("basestation", basestation);

//		request.setAttribute("sectors", findSectors(basestation));
//		request.setAttribute("antennes", findAntennes(basestation));

		try {
			eForm.getPositionForm().initCollections(request);
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}

        ActionForward frw = superPerform(mapping, form, request, response);

        String par = request.getParameter(AppConstants.APP_HOME);

        if (par != null
            && par.equals(com.hps.july.constants.Applications.SITEINFO + "")) {
            request.getSession().setAttribute(
                AppConstants.APP_HOME,
                new Integer(request.getParameter(AppConstants.APP_HOME)));
        }
        int atr = request.getSession().getAttribute(AppConstants.APP_HOME) != null
                ? ((Integer) request.getSession().getAttribute(AppConstants.APP_HOME)).intValue()
                : com.hps.july.constants.Applications.BASESTATION;

        if (atr == com.hps.july.constants.Applications.SITEINFO) {
            request.getSession().setAttribute("positionId", String.valueOf(eForm.getPositionForm().getStorageplace()));
            DebugSupport.printlnTest("!!!EditViewBaseStationAction  appHome="+request.getSession().getAttribute(AppConstants.APP_HOME)+" positionId="+request.getSession().getAttribute("positionId"));

            String serverBase = "http://" + request.getServerName() + ":" + request.getServerPort();
            String positionBase = AppConstants.BASE_POSITION;
            String equipmentLink = serverBase + positionBase + "/ShowEquipmentList.do";

            DebugSupport.printlnTest("!!!return page="+equipmentLink);

            eForm.setReturnPage(equipmentLink);

            if (frw.equals(mapping.findForward("errorgoback"))) {
                response.sendRedirect(equipmentLink);
                return null;
            }
        }
        //eForm.getPositionForm().setRequest(request);
        DebugSupport.printlnTest("!!!!!Application=" + eForm.getApplication() + " APPState=" + eForm.getState());
        return frw;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 17:04:11)
 */
private void processImport()  {

    try {
        DebugSupport.printlnTest("processImport started");
	    //int res=com.hps.july.dataimport.dataobjects.Ex3Program.process();
        //DebugSupport.printlnTest("processImport finished sessid="+res);    
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }

}
public ActionForward superPerform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException
{

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
		    	com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean = editForm.getDataBean(request);
	          	com.hps.july.util.BeanUtils.copyProperties( editForm, bean ); 
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
}
}
