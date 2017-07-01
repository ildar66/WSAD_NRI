package com.hps.july.project.actionbean;

import com.hps.july.project.formbean.DivisionListForm;
import javax.servlet.*; 
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.project.APPStates;
import java.io.IOException;

/**
 * Обработчик lookup для выбора подразделения.
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class ShowDivisionListAction extends com.hps.july.web.util.LookupBrowseAction{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DivisionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.PROJECT, APPStates.DIVISION );
		return mapping.findForward( "main" );
}
}
