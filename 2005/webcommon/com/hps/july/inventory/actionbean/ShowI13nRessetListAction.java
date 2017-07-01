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
 * Обработчик списка набора оборудования для актов инвентаризации на позиции
 */
public class ShowI13nRessetListAction
	extends BrowseAction
{
public Object constructRowModelBean(Object o) {
	return super.constructRowModelBean(o);
}
/**
 * Insert the method's description here.
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.I13nActResourceSetAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.IRSLIST);
	I13nRessetListForm oform = (I13nRessetListForm) form;
    try {
	    I13nActAccessBean bean = new I13nActAccessBean();
	    bean.setInitKey_document(oform.getDocument());
        bean.refreshCopyHelper();
        oform.setBlankdate(bean.getBlankdate());
        oform.setBlanknumber(bean.getBlanknumber());
        oform.setBlankindex(bean.getBlankindex());
        oform.setOwner(new Integer(bean.getOwner().getOrganization()));
        oform.setOwnername(bean.getOwner().getName());
        if("1".equals(bean.getDocumentState())) {
	        oform.setReadonly(false);
        } else {
	        oform.setReadonly(true);
        }
        if(bean.getFrom() != null) {
	        oform.setComplect(new Integer(bean.getFrom().getStorageplace()));
 	    	EquipmentSetAccessBean equip = new EquipmentSetAccessBean();
 	    	equip.setInitKey_storageplace(bean.getFrom().getStorageplace());
			equip.refreshCopyHelper();
 	    	oform.setComplectname(com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(equip));
			oform.setPosition(new Integer(equip.getPosition().getStorageplace()));
			oform.setPositionname(equip.getPosition().getName());
        }
    }
    catch (Exception e) {
    }
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
