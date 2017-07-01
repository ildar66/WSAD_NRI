package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.BaseStationForm;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.io.IOException;
import javax.servlet.ServletException;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;

/**
 * Обработчик формы редактирования базовых станций.
 * Выполняет переход на форму редактирования и вызывает загрузку данных
 */
public class EditBaseStationAction
	extends com.hps.july.web.util.AbstractEditAction
{
public int getRootApp(HttpSession session) {
	int rootApp = 0;
	try {
		rootApp = Integer.parseInt( (String)session.getAttribute( ParamsParser.ROOTAPP_PARAM_NAME ) );
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return rootApp;
}
public boolean isReturnable() {
	return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	navigate(mapping,form,request,response);

	ActionForward frw = null;
	BaseStationForm eForm = (BaseStationForm) form;
	DebugSupport.printlnTest("!!EditBaseStationAction started");

	String par = request.getParameter(AppConstants.APP_HOME);
	DebugSupport.printlnTest("!!!EditBaseStationAction  request.getParameter(AppConstants.APP_HOME)=" + par);
	if (par != null && par.equals(com.hps.july.constants.Applications.SITEINFO + "")) {
		request.getSession().setAttribute(AppConstants.APP_HOME, new Integer(par));
	}

	int appHome = getRootApp(request.getSession());
	DebugSupport.printlnTest("!!!!!EditBaseStationAction appHome=" + appHome);
    try {
	    eForm.getPositionForm().initCollections(request);
    } catch(Exception e) {
	    e.printStackTrace(System.out);
    }
	frw = super.perform(mapping, form, request, response);

    if (appHome == Applications.SITEINFO) {
	    if(request.getParameter(AppConstants.APP_HOME) != null) {
		    ParamsParser.setRootApp(request,request.getParameter(AppConstants.APP_HOME));
	    }
		request.getSession().setAttribute("positionId", eForm.getPositionForm().getStorageplace() + "");
        DebugSupport.printlnTest("!!!EditBaseStationAction  appHome="+appHome+" positionId="+ request.getSession().getAttribute("positionId"));
		String serverBase = "http://"+request.getServerName()+":"+request.getServerPort();
		String positionBase = AppConstants.BASE_POSITION;
		String equipmentLink = serverBase+positionBase + "/ShowEquipmentList.do";
		eForm.setReturnPage(equipmentLink);
		if (frw.equals(mapping.findForward("errorgoback"))) {
			response.sendRedirect(equipmentLink);
			return null;
		}
	}
	return frw;
}
}
