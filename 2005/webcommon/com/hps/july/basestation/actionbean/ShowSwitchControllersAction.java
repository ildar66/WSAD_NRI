package com.hps.july.basestation.actionbean;

import com.hps.july.siteinfo.valueobject.*;
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
 * Обработчик формы списка контроллеров привязанных к коммутатору
 */
public class ShowSwitchControllersAction extends ShowEquipmentListAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//	ParamsParser.setState( request, Applications.BASESTATION, APPStates.SWCH_CONNECTED_CONTR);
	SwitchControllersListForm clForm = (SwitchControllersListForm) form;
	
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
}
