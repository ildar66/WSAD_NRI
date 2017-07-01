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
 * Обработчик формы выбора агрегатов оборудования
 */
public class ShowAgregateLookupListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 12:02:15)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	if(o instanceof DocumentPositionAccessBean) {
		DocumentPositionAccessBean ab = (DocumentPositionAccessBean)o;
		try {
			I13nActPositionAccessBean bean = new I13nActPositionAccessBean();
			bean.setInitKey_docposition( ab.getDocposition() );
			bean.refreshCopyHelper();
			return bean;
		} catch(Exception e) {
			return super.constructRowModelBean(o);
		}
	} else {
		return super.constructRowModelBean(o);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DocumentPositionAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.AGRLOOKUP );
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
