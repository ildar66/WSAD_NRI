package com.hps.july.inventory.formbean;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.constants.Applications;
import com.hps.july.web.util.ParamsParser;
import com.hps.july.inventory.*;

/**
 * Форма выбора функционального комплекта на позиции
 */
public class ComplectBSLookupListForm
	extends ComplectLookupListForm
{
public ComplectBSLookupListForm() {
	super();
	this.setFinderMethodName( "findPositionBS" );
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws java.io.IOException, ServletException
{
  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.BSSETLOOKUP );
  	return null;
}
}
