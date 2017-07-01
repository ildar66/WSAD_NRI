package com.hps.july.security.formbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.constants.*;
/**
 * Форма списка должностей.
 * Creation date: (15.01.2002 14:06:31)
 * @author: ildar
 */
public class WorkPositionListForm extends WorkPositionLookupListForm {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkPositionListForm() {
    super();
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        new Boolean(true),        getName(),
        "ALL".equals(getActivestate()) ? new Boolean(false) : new Boolean(true),        getActivestate(),
        getOrderBy()};
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.SECURITY, APPStates.WPOSLIST);
    return null;
}
}
