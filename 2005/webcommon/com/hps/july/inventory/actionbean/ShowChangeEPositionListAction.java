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

/**
 * Обработчик формы списка позиций документа "Акт замены при ремонте"
 */
public class ShowChangeEPositionListAction
	extends BrowseAction
{
public Object constructRowModelBean(Object o) {
	return new com.hps.july.inventory.valueobject.ChangePositionValue(o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ChangeActPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.CHEPLIST);
	ChangeEPositionListForm aform = (ChangeEPositionListForm)form;
    aform.setReadonly(Boolean.TRUE);
	if(aform.getDocument() != null) {
		try {
			ChangeActAccessBean bean = new ChangeActAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			aform.setOwnername(bean.getOwner().getName());
			aform.setBlankindex(bean.getBlankindex());
			aform.setBlanknumber(bean.getBlanknumber());
			aform.setBlankdate(bean.getBlankdate());
			try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(bean.getFrom().getStorageplace());
				exp.refreshCopyHelper();
				aform.setExpedition(exp.getStorageplace());
				if(exp.getExpeditor() != null) {
					aform.setWorkername(exp.getExpeditor().getMan().getFullName());
					aform.setWorkertitle(exp.getExpeditor().getPosition().getName());
					aform.setOrganizationname(null);
					aform.setType("W");
				} else
				if(exp.getOrganization() != null) {
					aform.setOrganizationname(exp.getOrganization().getName());
					aform.setType("P");
					aform.setWorkername(null);
					aform.setWorkertitle(null);
				} else {
					aform.setOrganizationname(null);
					aform.setWorkername(null);
					aform.setWorkertitle(null);
					aform.setType("?");
				}
			} catch(Exception e) {
			}
/*
			OrganizationAccessBean org = bean.getContragent();
			if(org != null) {
				aform.setOrganizationname(org.getName());
			} else {
				aform.setOrganizationname(null);
			}
*/
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
