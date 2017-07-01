package com.hps.july.basestation.actionbean;

import com.hps.july.siteinfo.valueobject.*;
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
 * Обработчик списка элементов оборудования
 */
public class ShowEquipdetListAction
	extends com.hps.july.web.util.BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	return new StoragecardObject((StorageCardAccessBean)o);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.StorageCardAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.BASESTATION, APPStates.EQDETLIST );
	  	EquipdetListForm oform = (EquipdetListForm) form;
	  	try {
		  	oform.calculateObject();//alex	
		  	EquipmentSetAccessBean eqb = new EquipmentSetAccessBean();
		  	eqb.setInitKey_storageplace(oform.getStorageplace());
		  	eqb.refreshCopyHelper();
			oform.setComplectname(eqb.getName());
			oform.setEqobj(new EquipmentObject(eqb));
			
	  		PositionAccessBean bean = new PositionAccessBean();
	  		bean.setInitKey_storageplace(eqb.getPosition().getStorageplace());
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
