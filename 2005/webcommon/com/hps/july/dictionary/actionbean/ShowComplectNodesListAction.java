package com.hps.july.dictionary.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.dictionary.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.dictionary.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы списка узлов оборудовани
 */
public class ShowComplectNodesListAction
	extends BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ComplectAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.DICTIONARY, APPStates.CPFCLIST );
	  	ComplectNodesListForm lform = (ComplectNodesListForm)form;
	  	try {
	  		ResourceAccessBean bean = new ResourceAccessBean();
	  		bean.setInitKey_resource(lform.getResource());
	  		bean.refreshCopyHelper();
		    lform.setResourcename(bean.getName());
		    lform.setResourcemodel(bean.getModel());
	  	} catch (Exception e) {
		    lform.setResourcename("");
		    lform.setResourcemodel("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
