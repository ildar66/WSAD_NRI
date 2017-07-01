package com.hps.july.basestation.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import com.hps.july.basestation.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик форм редактирования базовых станций
 */
public class EditEquipmentAction
	extends com.hps.july.web.util.AbstractEditAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
    ActionForward frw = null;
    BSEquipmentForm eForm = (BSEquipmentForm) form;
    eForm.setPath(mapping.getPath());

    eForm.prepareEdit(request);
    frw = super.perform(mapping, form, request, response);
    
    return frw;

}
}
