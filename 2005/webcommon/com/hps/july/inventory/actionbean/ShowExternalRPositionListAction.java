package com.hps.july.inventory.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import com.hps.july.inventory.valueobject.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;

/**
 * ќбработчик формы списка строк документа "¬нешн€€ расходна€ накладна€"
 */
public class ShowExternalRPositionListAction
	extends com.hps.july.web.util.BrowseAction
{
public Object constructRowModelBean(Object o) {
	return new ExternalRPosValue(o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DocumentPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.EORPLIST);
	ExternalRPositionListForm aform = (ExternalRPositionListForm)form;
    aform.setReadonly(Boolean.TRUE);
	if(aform.getDocument() != null) {
		try {
			OutWayBillAccessBean bean = new OutWayBillAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(aform,bean);
			aform.setOwner(new Integer(bean.getOwner().getOrganization()));
			aform.setOwnername(bean.getOwner().getName());
			aform.setStorage(new Integer(bean.getFrom().getStorageplace()));
			aform.setStoragename(bean.getFrom().getName());
			aform.setRecipientname(bean.getContragent().getName());
			aform.setInsuranceact(bean.getInsuranceact());
			aform.setInsuranseMan(bean.getInsuranseMan());
			aform.setInsurancedate(bean.getInsurancedate());
			aform.setCurrencyshortname(bean.getCurrency().getShortname());
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
