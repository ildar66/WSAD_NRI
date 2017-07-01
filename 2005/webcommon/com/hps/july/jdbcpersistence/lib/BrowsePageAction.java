package com.hps.july.jdbcpersistence.lib;

import java.lang.reflect.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
  * Класс вывода списка с нестандартным количеством строк на странице
*/

public abstract class BrowsePageAction extends com.hps.july.web.util.BrowseAction {
	private static int rowOnPage = 0;	
public int getRowsOnPage() {
    try {
        if (rowOnPage == 0) {
            NamedValueAccessBean v = new NamedValueAccessBean();
            //v.setInitKey_id("SiteListPageLength");
            v.setInitKey_id("SiteListPageLenght");
            v.refreshCopyHelper();
            //DebugSupport.printlnTest("!!!rowsOnPage=" + v.getIntvalue());
            rowOnPage = v.getIntvalue();
            DebugSupport.printlnTest("!!BrowsePageAction rowOnPage="+rowOnPage);
        }
    } catch (Exception e) {
        e.printStackTrace(System.out);
		rowOnPage = super.getRowsOnPage();
    }
	return rowOnPage;
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException
{
	return super.perform(mapping,form,request,response);
}
}
