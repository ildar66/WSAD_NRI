package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.valueobject.AntennaObject;
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
 * Обработчик выбора антены донорной базовой станции
 */
public class ShowBSAntennaLookupListAction
	extends LookupBrowseAction
{
public Object constructRowModelBean(Object o) {
	try {
		Antena2sectorAccessBean bean = (Antena2sectorAccessBean)o;
		AntennaAccessBean a = bean.getAntenna();
//		AntennaObject v = new AntennaObject(bean.getAntenna());
		return a;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
public String getBrowseBeanName()
{
	return "com.hps.july.persistence.Antena2sectorAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.BSANTENNA_LOOKUP);
	BSAntennaLookupListForm oform = (BSAntennaLookupListForm)form;
	oform.refreshFilter();
	super.perform( mapping, form, request, response );
	return mapping.findForward( "main" );
}
}
