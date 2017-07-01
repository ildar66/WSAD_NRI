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
 * Обработчик формы списка содержимого набора оборудования
 */
public class ShowComplectContentListAction
	extends BrowseAction
{
/**
 * Insert the method's description here.
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ResourceSetPartAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, APPStates.CPCLIST);

    ComplectContentListForm oform = (ComplectContentListForm) form;
    try {
        ResourceSetAccessBean bean = new ResourceSetAccessBean();
        bean.setInitKey_resourceset(oform.getResourceset());
        bean.refreshCopyHelper();
        oform.setResourcesetname(bean.getName());
    }
    catch (Exception e) {
        oform.setResourceset(0);
        oform.setResourcesetname("");
    }
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
