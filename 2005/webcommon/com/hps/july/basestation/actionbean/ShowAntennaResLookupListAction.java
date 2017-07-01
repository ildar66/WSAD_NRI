package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.persistence.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.basestation.APPStates;
import org.apache.struts.util.MessageResources;

/**
 * Обработчик выбора оборудования антенн
 */
public class ShowAntennaResLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
public Object constructRowModelBean(Object o) {
	AntennaResourceAccessBean bean = (AntennaResourceAccessBean)o;
	AntenaValue valueObject = new AntenaValue(bean);
	return valueObject;
}
	public String getBrowseBeanName() {
		return "com.hps.july.persistence.AntennaResourceAccessBean";
	}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    

    super.perform(mapping, form, request, response);
    ParamsParser.setState(
        request,
        Applications.BASESTATION,
        APPStates.ANT_RES_LOOKUP);
    return mapping.findForward("main");
}
}
