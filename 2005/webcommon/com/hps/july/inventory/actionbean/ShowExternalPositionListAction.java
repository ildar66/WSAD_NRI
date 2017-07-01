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
 * Обработчик формы списка строк документа "Внешний приходный ордер"
 */
public class ShowExternalPositionListAction
	extends BrowseAction
{
public Object constructRowModelBean(Object o) {
	if(o instanceof OuterDocPositionAccessBean) {
		OuterDocPositionAccessBean ab = (OuterDocPositionAccessBean)o;
		OuterDocPositionValue value = new OuterDocPositionValue(
			ab,
			0,
			new java.math.BigDecimal(0.0d),
			new java.math.BigDecimal(0.0d)
		);
		try {
			value.setOrder(ab.getOrder());
			InWayBillPositionAccessBean bean = new InWayBillPositionAccessBean();
			Enumeration en = bean.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(ab.getOuterDocPosition()));
			while(en.hasMoreElements()) {
				InWayBillPositionAccessBean pos = (InWayBillPositionAccessBean)en.nextElement();
				value.add(pos.getQty(),pos.getSourcePrice());
			}
		} catch(Exception e) {
		}
		return value;
	}
	return super.constructRowModelBean(o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.OuterDocPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.EOPLIST);
    ExternalPositionListForm aform = (ExternalPositionListForm)form;
    aform.setReadonly(Boolean.TRUE);
	aform.setBydocsumstr("0.00");
	aform.setByfactsumstr("0.00");
	if(aform.getDocument() != null) {
		try {
			InwayBillAccessBean bean = new InwayBillAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(aform,bean);
			aform.setOwner(new Integer(bean.getOwner().getOrganization()));
			aform.setOwnername(bean.getOwner().getName());
			aform.setStorage(new Integer(bean.getTo().getStorageplace()));
			aform.setStoragename(bean.getTo().getName());
			aform.setSupplier(new Integer(bean.getContragent().getOrganization()));
			aform.setSuppliername(bean.getContragent().getName());
			aform.setCurrency(new Integer(bean.getCurrency().getCurrency()));
			aform.setCurrencyshortname(bean.getCurrency().getShortname());
			if("1".equals(bean.getDocumentState())) {
				aform.setReadonly(Boolean.FALSE);
			}
			// Calculate overal sum by fact
			java.math.BigDecimal facsum = new java.math.BigDecimal(0.0d);
			try {
				InWayBillPositionAccessBean links = new InWayBillPositionAccessBean();
				Enumeration en = links.findDocPositionsByDocOrderByOrderDesc(aform.getDocument());
				while(en.hasMoreElements()) {
					InWayBillPositionAccessBean b = (InWayBillPositionAccessBean)en.nextElement();
					if(b.getSourcePrice() != null)
						facsum = facsum.add(b.getQty().multiply(b.getSourcePrice()).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				aform.setByfactsumstr(facsum.setScale(2).toString());
			}
			// Calculate overal sum by fact
			java.math.BigDecimal docsum = new java.math.BigDecimal(0.0d);
			try {
				OuterDocPositionAccessBean links = new OuterDocPositionAccessBean();
				Enumeration en = links.findOuterDocPositionByInWayBill(new DocumentKey(aform.getDocument().intValue()));
				while(en.hasMoreElements()) {
					OuterDocPositionAccessBean link = (OuterDocPositionAccessBean)en.nextElement();
					if(link.getOuterPrice() != null)
						docsum = docsum.add(link.getOuterQty().multiply(link.getOuterPrice()).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				aform.setBydocsumstr(docsum.setScale(2).toString());
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
