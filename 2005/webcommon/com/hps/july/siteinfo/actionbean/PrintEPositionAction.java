package com.hps.july.siteinfo.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.siteinfo.formbean.*;
import com.hps.july.persistence.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Обработчик печати дополнительных параметров позиции
 */
public class PrintEPositionAction extends com.hps.july.web.util.AbstractEditAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException {

    EPositionPrintForm editForm = (EPositionPrintForm)form;
    if (editForm != null) {
	    try {
		    PositionResponsibleWorkersAccessBean abean = new PositionResponsibleWorkersAccessBean();
			request.setAttribute( "browseList", abean.findPositionResponsibleWorkersByPosition(new StoragePlaceKey(editForm.getStorageplace())));
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
	    }
    }
	return  super.perform( mapping, form, request, response ); 
}
}
