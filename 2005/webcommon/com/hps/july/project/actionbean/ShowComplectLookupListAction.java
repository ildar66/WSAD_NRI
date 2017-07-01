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
 * ���������� lookup ������ ���������.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowComplectLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
public Object constructRowModelBean(Object o) {
	return new EquipmentValue((EquipmentSetAccessBean)o);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.EquipmentSetAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.PROJECT, APPStates.EQSETLOOKUP );
	  	ComplectLookupListForm oform = (ComplectLookupListForm) form;
	  	try {
	  		PositionAccessBean bean = new PositionAccessBean();
	  		bean.setInitKey_storageplace(oform.getPosition());
	  		bean.refreshCopyHelper();
	  		
			oform.setPosid("");
			if (bean.getGsmid() != null)
				oform.setPosid("D" + bean.getGsmid() + " ");
			if (bean.getDampsid() != null)
				oform.setPosid(oform.getPosid() + "A" + bean.getDampsid());
				
			oform.setPositionname(bean.getName());
			if ((bean.getDampsname() != null) && (bean.getDampsname().length() > 0) )
				oform.setPositionname(oform.getPositionname() + " / " + bean.getDampsname());
				
	  	} catch (Exception e) {
		    oform.setPosition(0);
		    oform.setPosid("");
		    oform.setPositionname("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
