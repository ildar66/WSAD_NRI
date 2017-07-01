package com.hps.july.dictionary.actionbean;

import com.hps.july.dictionary.formbean.AntenaListForm;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.persistence.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.dictionary.APPStates;

/**
 * Обработчик формы списка антенн
 */
public class ShowAntenaListAction
	extends BrowseAction
{
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCResourcesObject";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	ParamsParser.setState(request, Applications.DICTIONARY, APPStates.ANTENA_LIST);
	/*
	try {
		AntenaListForm f = (AntenaListForm)form;
		if(!f.getRtype().isEmpty() && f.getRtype().isOk()) {
			ResourceTypeAccessBean rt = new ResourceTypeAccessBean();
			rt.setInitKey_resourcetype(f.getRtype().getInteger().intValue());
			rt.refreshCopyHelper();
			f.setRtypename(rt.getName());
		}
		if(!f.getRstype().isEmpty() && f.getRstype().isOk()) {
			ResourceSubTypeAccessBean rst = new ResourceSubTypeAccessBean();
			rst.setInitKey_resourcesubtype(f.getRstype().getInteger().intValue());
			rst.refreshCopyHelper();
			f.setRstypename(rst.getName());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	*/
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
}
