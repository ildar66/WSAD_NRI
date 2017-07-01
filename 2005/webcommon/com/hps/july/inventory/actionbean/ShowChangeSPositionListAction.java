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
 * Обработчик формы списка строк документа "Акт замены/модернизации на складе"
 */
public class ShowChangeSPositionListAction
	extends BrowseAction
{
public Object constructRowModelBean(Object o) {
	return new com.hps.july.inventory.valueobject.ChangePositionValue(o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ChangeActPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.CHSPLIST);
	ChangeSPositionListForm aform = (ChangeSPositionListForm)form;
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
				StorageAccessBean exp = new StorageAccessBean();
				exp.setInitKey_storageplace(bean.getFrom().getStorageplace());
				exp.refreshCopyHelper();
				aform.setStorage(exp.getStorageplace());
				aform.setStoragename(exp.getName());
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
