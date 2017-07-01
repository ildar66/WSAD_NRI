package com.hps.july.inventory.actionbean;

import com.hps.july.inventory.formbean.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Обработчик формы редактирования позиции для "Акта инвентаризации на позиции"
 * При добавлении осуществляет переход на форму редактирования шапки документа и
 * списка позиций
 */
public class ProcessContractorInventory
	extends FormProcessAction
{
public ActionForward processDelete(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws Exception
{	
	String act = request.getParameter("act");
	ContractorInventoryForm cform = (ContractorInventoryForm)editForm;
	cform.setAct(act);
	ActionForward fwd = super.processDelete(mapping, request, errors, cform);
	
	fwd = mapping.findForward("success");
	
	
	return fwd;
}
public ActionForward processInsert(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws Exception
{	
	
	ActionForward fwd = super.processInsert(mapping, request, errors, editForm);
	if(errors.empty()) {
		fwd = mapping.findForward("edit");
	}
	/*if(fwd != null) {
	System.out.println(">>>>>PROCESS CONTRINV Forward:"+fwd.getPath());
	} else {
	System.out.println(">>>>>PROCESS CONTRINV Forward: FWD is NULL");
	}*/
	return fwd;
}
public ActionForward processUpdate(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws Exception
{
	ContractorInventoryForm form = (ContractorInventoryForm)editForm;
	
	ActionForward fwd = super.processUpdate(mapping, request, errors, editForm);
	if(errors.empty()) {
		if("P".equals(form.getProcessState())){
			fwd = mapping.findForward("view");
		}else{
			fwd = mapping.findForward("edit");
		}
	}	
	return fwd;
}
}
