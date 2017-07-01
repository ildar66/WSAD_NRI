package com.hps.july.basestation.actionbean;

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

/**
 * Обработчик выбора сектора базовой станции
 */
public class ShowBSSectorLookupListAction
	extends LookupBrowseAction
{
public String getBrowseBeanName()
{
	return "com.hps.july.persistence.SectorAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.BSSECTOR_LOOKUP);
	BSSectorLookupListForm oform = (BSSectorLookupListForm)form;
	oform.getBs().refresh();
	super.perform( mapping, form, request, response );
	return mapping.findForward( "main" );
}
}
