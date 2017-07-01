package com.hps.july.basestation.actionbean;

import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.basestation.formbean.*;
import com.hps.july.basestation.valueobject.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик списка контролелров
 */
public class ShowControllerListAction
	extends ShowEquipmentListAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ControllerListForm clForm = (ControllerListForm) form;
	if (!clForm.getIsSwitch()) {
		clForm.setSwitchname("");
		try {
			System.out.println("CONTRFORM:"+clForm.getSwitchId());
			SwitchAccessBean switchById = SwitchModel.getSwitchById(clForm.getSwitchId());
			System.out.println("CONTRFORM:switchById:"+switchById);
			SwitchAccessBean switchByNumber = SwitchModel.getSwitchByNumber(clForm.getSwitchcode());
			System.out.println("CONTRFORM:switchByNumber:"+switchByNumber);
			if(switchById != null) {
				if(switchByNumber != null) {
					if(switchById.getNumber() == switchByNumber.getNumber()) {
						System.out.println("CONTRFORM:numbers id equal!");
						setSwitchParams(switchById,clForm);
					} else {
						setSwitchParams(switchByNumber,clForm);
					}
				} else {
					setSwitchParams(switchById,clForm);
				}
			} else {
				if(switchByNumber != null) {
					setSwitchParams(switchByNumber,clForm);
				} else {
					setSwitchParams(null,clForm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
public void setSwitchParams(SwitchAccessBean bean, ControllerListForm form)
	throws Exception
{
	if(bean != null) {
		form.setSwitchname(PositionModel.getPositionFullName(bean.getPosition()));
		form.setSwitchId(bean.getStorageplace());
		form.setSwitchcode(new Integer(bean.getNumber()));
	} else {
		form.setSwitchname("");
		form.setSwitchId(0);
		form.setSwitchcodeFrm("");
	}
}
}
