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
 * ���������� ����� ������ ����� ��������� "��� ��������� ������ �� ������"
 */
public class ShowDAssactposListAction extends com.hps.july.web.util.BrowseAction {
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DocumentPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.DASSPLIST);
	DAssactposListForm aform = (DAssactposListForm)form;
    aform.setReadonly(Boolean.TRUE);
	if(aform.getDocument() != null) {
		try {
			AssemblingActAccessBean bean = new AssemblingActAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(aform,bean);
			aform.setOwner(new Integer(bean.getOwner().getOrganization()));
			aform.setOwnername(bean.getOwner().getName());
			aform.setStorage(new Integer(bean.getFrom().getStorageplace()));
			aform.setStoragename(bean.getFrom().getName());

			if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
				if(bean.getAgregateserial() != null && !"".equals(bean.getAgregateserial())) {
					try {
						StorageCardAccessBean sc = (new StorageCardAccessBean()).findBySerial(bean.getAgregateserial());
						aform.setAgregate(new Integer(sc.getStoragecard()));
						String s = sc.getResource().getName();
						if (sc.getResource().getModel() != null)
							s = s + ", " + sc.getResource().getModel();
						if (bean.getAgregat().getConfiguration() != null)
							s = s + ", " + bean.getAgregat().getConfiguration();
						s = s + ", � " + bean.getAgregat().getSerialnumber();
						aform.setAgregatename(s);
					} catch (Exception e) {
						e.printStackTrace(System.out);
					}
					
				}
			} else {
				aform.setAgregate(new Integer(bean.getAgregat().getStoragecard()));
				String s = bean.getAgregat().getResource().getName();
				if (bean.getAgregat().getResource().getModel() != null)
				  s = s + ", " + bean.getAgregat().getResource().getModel();
				if (bean.getAgregat().getConfiguration() != null)
				  s = s + ", " + bean.getAgregat().getConfiguration();
				s = s + ", � " + bean.getAgregat().getSerialnumber();
				aform.setAgregatename(s);
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
