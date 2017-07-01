package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.valueobject.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик выбора коммуникационного оборудования
 */
public class ShowComEquipmentLookupListAction
	extends com.hps.july.web.util.LookupBrowseAction
{
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ComEquipmentAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.BASESTATION, APPStates.COMEQU_LOOKUP );
	  	ComEquipmentLookupListForm oform = (ComEquipmentLookupListForm) form;
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
