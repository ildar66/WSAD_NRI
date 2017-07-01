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
 * Обработчик формы списка строк документа "Требование"
 */
public class ShowReqPositionListAction
	extends LookupBrowseAction
{
public Object constructRowModelBean(Object o) {
	return new com.hps.july.inventory.valueobject.ReqPosValue(o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DocumentPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.REQPLIST);
	ReqPositionListForm aform = (ReqPositionListForm)form;
    aform.setReadonly(Boolean.TRUE);
    aform.setType("?");
	if(aform.getDocument() != null) {
		try {
			RequestAccessBean bean = new RequestAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(aform,bean);
			aform.setOwner(new Integer(bean.getOwner().getOrganization()));
			aform.setOwnername(bean.getOwner().getName());
			aform.setStorage(new Integer(bean.getTo().getStorageplace()));
			aform.setStoragename(bean.getTo().getName());
			try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(bean.getFrom().getStorageplace());
				exp.refreshCopyHelper();
				if((exp.getOrganization() != null) && (exp.getExpeditor() == null)) {
					aform.setOrganization(new Integer(exp.getOrganization().getOrganization()));
					aform.setOrganizationname(exp.getOrganization().getName());
					aform.setInsuranseMan(bean.getInsuranseMan());
					aform.setNAvto(bean.getNAvto());
					aform.setWorker(null);
					aform.setWorkername(null);
					aform.setWorkertitle(null);
					aform.setType("P");
				} else
				if((exp.getOrganization() == null) && (exp.getExpeditor() != null)) {
					aform.setOrganization(null);
					aform.setOrganizationname(null);
					aform.setInsuranseMan("");
					aform.setWorker(new Integer(exp.getExpeditor().getWorker()));
					aform.setWorkername(exp.getExpeditor().getMan().getFullName());
					aform.setWorkertitle(exp.getExpeditor().getPosition().getName());
					aform.setType("W");
				}
			} catch(Exception e) {
			}	

			PositionAccessBean pos = bean.getPosition();
			if(pos != null) {
				aform.setPositionname(pos.getName());
			} else {
				aform.setPositionname(null);
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
