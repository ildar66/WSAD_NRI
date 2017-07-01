package com.hps.july.project.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.project.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.project.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * Обработчик lookup по выбору ответственного.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowWorkresponsibilityListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.PositionResponsibleWorkersAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.PROJECT, APPStates.WRSPLIST );
	  	WorkresponsibilityListForm oform = (WorkresponsibilityListForm) form;
	  	try {
	  		PositionAccessBean bean = new PositionAccessBean();
	  		bean.setInitKey_storageplace(oform.getStorageplace());
	  		bean.refreshCopyHelper();
			oform.setPosid("");
			if (bean.getGsmid() != null)
				oform.setPosid("D" + bean.getGsmid() + " ");
			if (bean.getDampsid() != null)
				oform.setPosid(oform.getPosid() + "A" + bean.getDampsid());
				
			oform.setPosname(bean.getName());
			if ((bean.getDampsname() != null) && (bean.getDampsname().length() > 0) )
				oform.setPosname(oform.getPosname() + " / " + bean.getDampsname());
				
	  	} catch (Exception e) {
		    oform.setStorageplace(0);
		    oform.setPosid("");
		    oform.setPosname("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
