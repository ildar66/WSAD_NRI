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
 * Обработчик формы выбора набора оборудования для актов инвентаризации всех видов
 */
public class ShowI13nRessetLookupListAction
	extends BrowseAction
{
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.I13nActResourceSetAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.IRSLOOKUP );
		I13nRessetLookupListForm oform = (I13nRessetLookupListForm)form;
	  	try {
		  	I13nActAccessBean bean = new I13nActAccessBean();
	  		bean.setInitKey_document(oform.getDocument());
	  		bean.refreshCopyHelper();
	  		oform.setBlanknumber(bean.getBlanknumber());
	  		oform.setBlankindex(bean.getBlankindex());
	  		oform.setBlankdate(bean.getBlankdate());
	  		oform.setOwnername(bean.getOwner().getName());
	  	} catch (Exception e) {
		  	oform.setBlanknumber("?");
		  	oform.setBlankdatestr(null);
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
