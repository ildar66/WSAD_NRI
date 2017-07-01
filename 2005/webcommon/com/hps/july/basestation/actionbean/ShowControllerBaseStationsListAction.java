package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик списка контроллеров базовой станции
 */
public class ShowControllerBaseStationsListAction
	extends ShowEquipmentListAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ControllerBaseStationsList clForm = (ControllerBaseStationsList) form;
	clForm.fillFilter();
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
}
