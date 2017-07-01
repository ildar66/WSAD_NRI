package com.hps.july.siteinfo.actionbean;

import com.hps.july.jdbcpersistence.lib.TimeCounter;
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

/**
 * Обработчик списка состава оборудования на позиции
 */
public class ShowEquipdetMultiListAction	
	extends com.hps.july.web.util.BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.StorageCardAccessBean";
	return "com.hps.july.cdbc.objects.CDBCEquipmentObject";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		TimeCounter t = new TimeCounter("PERF.SITEINFO.EquipdetMultiList");
		t.start();
		ParamsParser.setState( request, Applications.SITEINFO, APPStates.EQDETMLIST );
	  	EquipdetMultiListForm oform = (EquipdetMultiListForm) form;
	  	try {
	  		PositionAccessBean bean = new PositionAccessBean();
	  		bean.setInitKey_storageplace(oform.getPosition());
	  		bean.refreshCopyHelper();
	  		
			oform.setPosid("");
			if (bean.getGsmid() != null) {
				oform.setPosid("D" + bean.getGsmid() + " ");
			}
			if (bean.getDampsid() != null) {
				oform.setPosid(oform.getPosid() + "A" + bean.getDampsid());
			}
				
			oform.setPosname(bean.getName());
			if((bean.getDampsname() != null) && (bean.getDampsname().length() > 0)) {
				oform.setPosname(oform.getPosname() + " / " + bean.getDampsname());
			}
		
	  	} catch (Exception e) {
		    oform.setPosition(0);
		    oform.setPosid("");
		    oform.setPosname("");
	  	}
		super.perform( mapping, form, request, response );
		t.finish("action");
		return mapping.findForward( "main" );
	}
}
