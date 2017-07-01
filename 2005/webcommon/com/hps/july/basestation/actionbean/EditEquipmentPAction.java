package com.hps.july.basestation.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import com.hps.july.basestation.*;
import com.hps.july.basestation.formbean.BaseStationForm;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.io.IOException;
import javax.servlet.ServletException;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.constants.*;

/**
 * Базовый обработчик входа в форму редактирования оборудования
 */
public class EditEquipmentPAction
	extends com.hps.july.web.util.AbstractEditAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
	ActionForward frw = null;
	EquipmentPForm eForm = (EquipmentPForm) form;
	eForm.getPositionForm().setRequestData(request);

	frw = super.perform(mapping, form, request, response); /////

    return frw;
}
}
