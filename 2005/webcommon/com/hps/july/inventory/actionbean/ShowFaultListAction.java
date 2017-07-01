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
 * Обработчик формы списка документов "Fault Report"
 */
public class ShowFaultListAction extends com.hps.july.web.util.BrowseAction {
	
/*	
public Object constructRowModelBean(Object o) {
	return new com.hps.july.inventory.valueobject.FaultValue(o);
}
*/

public java.lang.String getBrowseBeanName() {
	// return "com.hps.july.persistence.FaultReportAccessBean";
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.FLTLIST);

    FaultListForm frm = (FaultListForm)form;
	if(frm.getDivision() != null) {
    	try {
			DivisionAccessBean d = new DivisionAccessBean();
			d.setInitKey_division(frm.getDivision().intValue());
			d.refreshCopyHelper();
			frm.setDivisionname(d.getName());
	    } catch(Exception e) {
		    e.printStackTrace(System.out);
 		}
	}
	if(frm.getWorker() != null) {
    	try {
			WorkerAccessBean d = new WorkerAccessBean();
			d.setInitKey_worker(frm.getWorker().intValue());
			d.refreshCopyHelper();
			frm.setWorkername(d.getMan().getFullName());
			frm.setWorkertitle(d.getPosition().getName());
	    } catch(Exception e) {
 		}
	}
	if(frm.getWorker() != null) {
    	try {
			WorkerAccessBean d = new WorkerAccessBean();
			d.setInitKey_worker(frm.getWorker().intValue());
			d.refreshCopyHelper();
			frm.setWorkername(d.getMan().getFullName());
			frm.setWorkertitle(d.getPosition().getName());
	    } catch(Exception e) {
 		}
	}
	if(frm.getPosition() != null) {
    	try {
			PositionAccessBean d = new PositionAccessBean();
			d.setInitKey_storageplace(frm.getPosition().intValue());
			d.refreshCopyHelper();
			frm.setPositionname(d.getName());
			frm.setPositionid(((d.getGsmid()!=null)?("D"+d.getGsmid()+" "):"") + ((d.getDampsid()!= null)?("A"+d.getDampsid()):""));
	    } catch(Exception e) {
 		}
	}
	if(frm.getResource() != null) {
    	try {
			ResourceAccessBean d = new ResourceAccessBean();
			d.setInitKey_resource(frm.getResource().intValue());
			d.refreshCopyHelper();
			frm.setResourcename(d.getName());
			frm.setResourcemodel(d.getModel());
	    } catch(Exception e) {
 		}
	}
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
