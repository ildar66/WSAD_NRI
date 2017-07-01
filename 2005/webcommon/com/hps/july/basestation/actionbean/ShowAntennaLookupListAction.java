package com.hps.july.basestation.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.basestation.*;

/**
 * Обработчик выбора антенн сектора
 */
public class ShowAntennaLookupListAction
	extends com.hps.july.web.util.LookupBrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (03.09.2003 18:56:39)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.Antena2sectorAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.BASESTATION, APPStates.ANTENNA_LOOKUP);
	return mapping.findForward("main");
}
}
