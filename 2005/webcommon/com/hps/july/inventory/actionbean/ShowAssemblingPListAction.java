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
 * Обработчик списка документов "Акт монтажа на позиции"
 */
public class ShowAssemblingPListAction
	extends BrowseAction
{
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.InternalWayBillAccessBean";
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	com.hps.july.jdbcpersistence.lib.TimeCounter ts = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.INVENTORY.AssemblingPList");
	ts.start();
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.ASPLIST);
	AssemblingPListForm aform = (AssemblingPListForm)form;
	if(aform.getProvider() != null) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(aform.getProvider().intValue());
			bean.refreshCopyHelper();
			aform.setProvidername(bean.getName());
		} catch(Exception e) {
		}
	}
	if(aform.getWorker() != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(aform.getWorker().intValue());
			bean.refreshCopyHelper();
			aform.setWorkername(bean.getMan().getFullName());
			aform.setWorkertitle(bean.getPosition().getName());
		} catch(Exception e) {
		}
	}
	if(aform.getPositioncode() != null) {
		try {
			PositionAccessBean p = new PositionAccessBean();
			p.setInitKey_storageplace(aform.getPosition().intValue());
			p.refreshCopyHelper();
			aform.setPositionname(p.getName());
			String positionid = "";
			if(p.getGsmid() != null) {
				positionid = positionid + "D" + p.getGsmid();
			}
			positionid = positionid + " ";
			if(p.getDampsid() != null) {
				positionid = positionid + "A" + p.getDampsid();
			}
			aform.setPositionid(positionid);
		} catch(Exception e) {
		}
	}
	super.perform(mapping, form, request, response);
	ts.finish("action");
	return mapping.findForward("main");
}
}
