package com.hps.july.siteinfo.actionbean;

import com.hps.july.siteinfo.formbean.*;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.siteinfo.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.constants.*;

/**
 * Обработчик входа в форму редактирования оборудования на позиции
 * @author: Alexander Shrago
 */
public class EditEquipmentAction
	extends com.hps.july.web.util.AbstractEditAction
{
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return true;
}
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isReturnable() {
	return false;
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    try {

        EquipmentForm eForm = (EquipmentForm) form;
        DebugSupport.printlnTest("!!EditEquipmentAction eForm.getComplectType()=" + eForm.getComplectType());

        if (eForm.getComplectType().equals(EquipmentObject.TYPE_BS)
            || (eForm.getComplectType().equals(EquipmentObject.TYPE_Repeater)
                && !DebugSupport.isOldVersion())
            || (eForm.getComplectType().equals(EquipmentObject.TYPE_Switch)
                && !DebugSupport.isOldVersion())
            || (eForm.getComplectType().equals(EquipmentObject.TYPE_Controller)
                && !DebugSupport.isOldVersion())) {

            String actionUrl = null;
            //String serverBase = "http://infbeeline.informix.ru";
            String serverBase =
                "http://" + request.getServerName() + ":" + request.getServerPort();
            //String basestationBase = AppConstants.BASE_BASESTATION;
            PositionForm positionForm =
                (PositionForm) (PositionForm) request.getSession().getAttribute("PositionForm");
            String positionId = positionForm.getStorageplaceFrm();

            if (eForm.getComplectType().equals(EquipmentObject.TYPE_BS)) {
				actionUrl = "/Edit_AddDeleteFactBaseStation.do";
                actionUrl =
                    serverBase
                        + AppConstants.BASE_BASESTATION
                        + actionUrl
                        + "?action=Add&"
                        + AppConstants.APP_HOME
                        + "="
                        + Applications.SITEINFO
                        + "&position="
                        + positionId;
            } else if (eForm.getComplectType().equals(EquipmentObject.TYPE_Switch)) {
                actionUrl = "/EditSwitch.do";
                actionUrl =
                    serverBase
                        + AppConstants.BASE_BASESTATION
                        + actionUrl
                        + "?action=Add&"
                        + AppConstants.APP_HOME
                        + "="
                        + Applications.SITEINFO
                        + "&positionIdFrm="
                        + positionId;
            } else if (eForm.getComplectType().equals(EquipmentObject.TYPE_Controller)) {
                actionUrl = "/EditController.do";
                actionUrl =
                    serverBase
                        + AppConstants.BASE_BASESTATION
                        + actionUrl
                        + "?action=Add&"
                        + AppConstants.APP_HOME
                        + "="
                        + Applications.SITEINFO
                        + "&positionIdFrm="
                        + positionId;
            } else if (eForm.getComplectType().equals(EquipmentObject.TYPE_Repeater)) {
                actionUrl = "/EditRepeater.do";
                actionUrl =
                    serverBase
                        + AppConstants.BASE_BASESTATION
                        + actionUrl
                        + "?action=Add&"
                        + AppConstants.APP_HOME
                        + "="
                        + Applications.SITEINFO
                        + "&positionIdFrm="
                        + positionId;
            }
            //actionUrl = actionUrl + "&" + sm.getParameterString();
            response.sendRedirect(actionUrl);
            eForm.setComplectType("N");//mm
            return null;

        } else {
            return super.perform(mapping, form, request, response);
        }
    } catch (Exception e) {
        throw new ServletException(e);
    }
}
}
