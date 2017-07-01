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
 * Обработчик формы списка строк документа "Акт инвентаризации на складе"
 */
public class ShowInvActPosListAction
	extends BrowseAction
{
public Object constructRowModelBean(Object o) {
	return new com.hps.july.inventory.valueobject.I13nActPosValue(o);
}
/**
 * Insert the method's description here.
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DocumentPositionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.IVAPLIST);
	InvActPosListForm oform = (InvActPosListForm) form;
    try {
	    I13nActAccessBean bean = new I13nActAccessBean();
	    bean.setInitKey_document(oform.getDocument());
        bean.refreshCopyHelper();
        oform.setBlankdate(bean.getBlankdate());
        oform.setBlanknumber(bean.getBlanknumber());
        oform.setBlankindex(bean.getBlankindex());
        oform.setType(bean.getType());
        oform.setOwner(new Integer(bean.getOwner().getOrganization()));
        oform.setOwnername(bean.getOwner().getName());
        try {
	        oform.setAgregate( new Integer(bean.getAgregate().getStoragecard()) );
	        oform.setAgregatename( bean.getAgregate().getResource().getName() );
	        oform.setAgregatemodel( bean.getAgregate().getResource().getModel() );
        } catch(Exception e) {
	        oform.setAgregate( null );
	        oform.setAgregatename("");
	        oform.setAgregatemodel("");
        }
        if("1".equals(bean.getDocumentState())) {
	        oform.setReadonly(false);
        } else {
	        oform.setReadonly(true);
        }
        if(bean.getFrom() != null) {
	        oform.setStorage(new Integer(bean.getFrom().getStorageplace()));
 	    	oform.setStoragename(bean.getFrom().getName());
        }
    }
    catch (Exception e) {
    }
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
