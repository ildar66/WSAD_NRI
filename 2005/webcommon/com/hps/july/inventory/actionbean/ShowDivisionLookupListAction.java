package com.hps.july.inventory.actionbean;

import com.hps.july.project.formbean.DivisionListForm;
import javax.servlet.*; 
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.inventory.APPStates;
import java.io.IOException;

/**
 * Обработчик формы выбора поразделений компании
 */
public class ShowDivisionLookupListAction
	extends BrowseAction
{
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.DivisionAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform( mapping, form, request, response );
  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.DIVLOOKUP );
	return mapping.findForward( "main" );
}
}
