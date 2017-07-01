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
 * ќбработчик формы списка документов "¬нутренн€€ расходна€ накладна€"
 */
public class ShowInternalRPositionListAction
	extends BrowseAction
{
public Object constructRowModelBean(Object o) {
	return new com.hps.july.inventory.valueobject.InternalRPosValue(o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DocumentPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.IORPLIST);
	InternalRPositionListForm aform = (InternalRPositionListForm)form;
    aform.setReadonly(Boolean.TRUE);
	if(aform.getDocument() != null) {
		try {
			InternalOutBillAccessBean bean = new InternalOutBillAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(aform,bean);
			if(bean.getFixing() != null && bean.getFixing().booleanValue()) {
				aform.setBrokentype(0);
			} else {
				aform.setBrokentype(1);
			}
			aform.setOwner(new Integer(bean.getOwner().getOrganization()));
			aform.setOwnername(bean.getOwner().getName());
			aform.setStorage(new Integer(bean.getFrom().getStorageplace()));
			aform.setStoragename(bean.getFrom().getName());
			try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(bean.getTo().getStorageplace());
				exp.refreshCopyHelper();
				if(exp.getExpeditor() != null) {
					aform.setRenter(null);
					aform.setRentername(null);
					aform.setInsuranceact("");
					aform.setInsuranseMan("");
					aform.setInsurancedate(null);
					aform.setWorker(new Integer(exp.getExpeditor().getWorker()));
					aform.setWorkername(exp.getExpeditor().getMan().getFullName());
					aform.setWorkertitle(exp.getExpeditor().getPosition().getName());
					aform.setType("W");
				} else
				if(exp.getOrganization() != null) {
					aform.setRenter(new Integer(exp.getOrganization().getOrganization()));
					aform.setRentername(exp.getOrganization().getName());
					aform.setInsuranceact(bean.getInsuranceact());
					aform.setInsuranseMan(bean.getInsuranseMan());
					aform.setInsurancedate(bean.getInsurancedate());
					aform.setWorker(null);
					aform.setWorkername(null);
					aform.setWorkertitle(null);
					aform.setType("P");
				} else
				{
					aform.setType("?");
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
