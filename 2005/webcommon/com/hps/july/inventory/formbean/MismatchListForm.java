package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Форма списка документов "Акты рассогласования"
 */
public class MismatchListForm extends ExternalListForm {
public MismatchListForm() {
	super();
	java.util.Calendar c = java.util.Calendar.getInstance();
	c.setTime(new java.util.Date());
	c.set(java.util.Calendar.DAY_OF_MONTH,1);
	setDatefrom(new java.sql.Date(c.getTime().getTime()));
}
public java.lang.Object[] getFilterParams() {
	return getFilterParams(Boolean.TRUE);
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	ActionForward afw = super.initBrowse(mapping,request,response);
	ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.MISLIST);
	return afw;
}
}
