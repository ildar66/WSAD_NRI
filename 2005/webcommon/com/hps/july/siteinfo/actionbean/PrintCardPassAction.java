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
 * Формирует карту прохода в Word
 * Форм бина нет, переходит на cardPassWord.jsp
 * @author: Maksim Gerasimov
 */
public class PrintCardPassAction extends org.apache.struts.action.Action {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException {

	try{
		int storageplace = Integer.parseInt(request.getParameter("storageplace"));
		PositionAccessBean ab = new PositionAccessBean();
		ab.setInitKey_storageplace(storageplace);
		ab.refreshCopyHelper();

		//PositionBLOBAccessBean blob = new PositionBLOBAccessBean();
		//blob.setInitKey_storagePlace(storageplace);
		//blob.refreshCopyHelper();

		PositionResponsibleWorkersAccessBean resp = new PositionResponsibleWorkersAccessBean();
		Enumeration enum = resp.findPositionResponsibleWorkersByPosition(new StoragePlaceKey(storageplace));
		
		request.setAttribute("EPositionPrintForm", ab);
		//request.setAttribute("blob", blob);
		request.setAttribute("browseList", enum);
	
		return mapping.findForward("cardPass");
	}catch(Exception e){
		e.printStackTrace(System.out);
	}
	return null;
}
}
