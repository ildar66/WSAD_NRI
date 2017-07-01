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
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик списка состава элемента оборудования
 */
public class ShowEquipsdetListAction
	extends com.hps.july.web.util.BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.StorageCardAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		DebugSupport.printlnTest("ShowEquipsdetListAction perform started");
		ParamsParser.setState( request, Applications.BASESTATION, APPStates.EQSDETLIST );
	  	EquipsdetListForm oform = (EquipsdetListForm) form;
	  	DebugSupport.printlnTest("ShowEquipsdetListAction perform 1");
	  	try {
		  	StorageCardAccessBean scb = new StorageCardAccessBean();
		  	scb.setInitKey_storagecard(oform.getStoragecard());
		  	scb.refreshCopyHelper();
		  	oform.setCardname(
			  	(scb.getResource().getName()==null?"":scb.getResource().getName())
			  	+ " " +
			  	(scb.getResource().getModel()==null?"":scb.getResource().getModel())
			  	+ " " + 
			  	(scb.getConfiguration()==null?"":scb.getConfiguration())
			  	);
		  	
		  	EquipmentSetAccessBean eqb = new EquipmentSetAccessBean();
		  	eqb.setInitKey_storageplace(scb.getCurrentstorage().getStorageplace());
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
		  	e.printStackTrace(System.out);
		    oform.setStorageplace(0);
		    oform.setPosid("");
		    oform.setPosname("");
	  	}
	  	DebugSupport.printlnTest("ShowEquipsdetListAction perform 2");
		super.perform( mapping, form, request, response );
		DebugSupport.printlnTest("ShowEquipsdetListAction finished");
		return mapping.findForward( "main" );
	}
}
