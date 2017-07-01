package com.hps.july.basestation.actionbean;

import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.hps.july.basestation.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.constants.Applications;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.*;
import com.hps.july.basestation.formbean.*;
import org.apache.struts.upload.FormFile;
//import com.hps.july.dataimport.beans.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик инициализации формы загрузки данных.
 * Вызывается при входе в форму из меню
 */
public class InitLoadXls
	extends NavigatedAction
{
public ActionForward perform( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	navigate(mapping,form,request,response);
	try{
		request.getSession().setAttribute("task", new Integer(1));
	    LoadXlsForm aform = (LoadXlsForm) form;
	    if (request.getParameter("maxReport") == null) {
            aform.setMaxReport(false);
        }	
	    boolean maxReport = aform.isMaxReport();
	}catch(Exception e){
		e.printStackTrace(System.out);
	}
	ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
	return mapping.findForward("main");
}
}
