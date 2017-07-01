package com.hps.july.inventory.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;

/**
 * Обработчик формы списка строк документа "Акт замены/модернизации на позиции"
 */
public class ShowChangePPositionListAction
	extends BrowseAction
{
public Object constructRowModelBean(Object o) {
	return new com.hps.july.inventory.valueobject.ChangePositionValue(o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ChangeActPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.CHPPLIST);
	ChangePPositionListForm aform = (ChangePPositionListForm)form;
    aform.setReadonly(Boolean.TRUE);
	if(aform.getDocument() != null) {
		try {
			ChangeActAccessBean bean = new ChangeActAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			aform.setOwnername(bean.getOwner().getName());
			aform.setBlankdate(bean.getBlankdate());
			aform.setBlankindex(bean.getBlankindex());
			aform.setBlanknumber(bean.getBlanknumber());
			aform.setActtype(bean.getActtype());
			try {
				EquipmentSetAccessBean exp = new EquipmentSetAccessBean();
				exp.setInitKey_storageplace(bean.getFrom().getStorageplace());
				exp.refreshCopyHelper();
				aform.setComplect(exp.getStorageplace());
				aform.setComplectname(com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(exp));
				aform.setPosition(exp.getPosition().getStorageplace());
				aform.setPositionname(exp.getPosition().getName());
				aform.setPositionid("");
				if(exp.getPosition().getGsmid() != null) {
					aform.setPositionid(aform.getPositionid()+"D"+exp.getPosition().getGsmid()+" ");
				}
				if(exp.getPosition().getDampsid() != null) {
					aform.setPositionid(aform.getPositionid()+"A"+exp.getPosition().getDampsid()+" ");
				}
			} catch(Exception e) {
			}
			if("1".equals(bean.getDocumentState())) {
				aform.setReadonly(Boolean.FALSE);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
