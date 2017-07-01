package com.hps.july.basestation.actionbean;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.web.util.EditForm;
import com.hps.july.constants.*;

/**
 * Обработчик изменения данных базовой станции
 */
public class ProcessBaseStationAction 
	extends AbstractJournalTransProcessAction
{
private int getAppHome(HttpServletRequest request) {

    String requestParam = request.getParameter(AppConstants.APP_HOME);
    Object sessionAttr = request.getSession().getAttribute(AppConstants.APP_HOME);

    int appHome;
    /*
    DebugSupport.printlnTest(
        "!!!EditEquipmentPAction  request.getParameter(AppConstants.APP_HOME)=" + par);
    */

    if (requestParam == null && sessionAttr == null) {
        appHome = Applications.BASESTATION;
    } else if (requestParam == null) {
        appHome = ((Integer) sessionAttr).intValue();
    } else {
        appHome = Integer.parseInt(requestParam);
    }
    return appHome;

}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
    try {
        ActionForward frw = null;
        frw = super.perform(mapping, form, request, response);
        if (getAppHome(request) == com.hps.july.constants.Applications.SITEINFO) {
            if (frw.equals(mapping.findForward("success"))
                && !((EditForm) form).getAction().equals("Edit")) {
                String serverBase = "http://" + request.getServerName() + ":" + request.getServerPort();
                String positionBase = serverBase + AppConstants.BASE_POSITION;
                String equipmentLink = positionBase + "/ShowEquipmentList.do";
                response.sendRedirect(equipmentLink);
                return null;
            }
        }

        return frw;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);
    }
}
}
