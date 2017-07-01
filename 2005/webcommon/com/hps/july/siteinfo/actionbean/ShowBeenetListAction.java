package com.hps.july.siteinfo.actionbean;

import java.lang.reflect.*;
import java.util.*;
import com.hps.july.siteinfo.valueobject.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;


/**
 * Обработчик списка номеров BeeNet на позиции
 */
public class ShowBeenetListAction
	extends com.hps.july.web.util.BrowseAction
{
public ActionForward perform(ActionMapping mapping,	ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	TimeCounter t = new TimeCounter("RERF.SITEINFO.BeenetList");
	t.start();
	ParamsParser.setState(request, Applications.SITEINFO, APPStates.BEENETLIST);
	BeenetListForm oform = (BeenetListForm) form;
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
		if ((bean.getDampsname() != null) && (bean.getDampsname().length() > 0))
			oform.setPosname(oform.getPosname() + " / " + bean.getDampsname());

	} catch (Exception e) {
		System.out.println("Error in ShowBeenetListAction.perform");
		e.printStackTrace(System.out);
		oform.setStorageplace(0);
		oform.setPosid("");
		oform.setPosname("");
	}
	super.perform(mapping, form, request, response);  //mm
	System.out.println("2BeenetListForm="+oform.toString());
	t.finish("action");
	return mapping.findForward("main");
}
}
