package com.hps.july.inventory.actionbean;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

/**
 * Обработчик формы редактирования позиции для "Акта инвентаризации на позиции"
 * При добавлении осуществляет переход на форму редактирования шапки документа и
 * списка позиций
 */
public class ProcessPositionInventory
	extends AbstractProcessAction
{
public ActionForward processInsert(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws Exception
{
	ActionForward fwd = super.processInsert(mapping, request, errors, editForm);
	if(errors.empty()) {
		fwd = mapping.findForward("edit");
	}
/*if(fwd != null) {
System.out.println("PROCESS POSINV Forward:"+fwd.getPath());
} else {
System.out.println("PROCESS POSINV Forward: FWD is NULL");
}*/
	return fwd;
}
}
