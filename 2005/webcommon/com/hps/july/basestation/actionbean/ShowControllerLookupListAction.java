package com.hps.july.basestation.actionbean;

import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import com.hps.july.basestation.valueobject.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик выбора контроллера
 */
public class ShowControllerLookupListAction
	extends com.hps.july.web.util.LookupBrowseAction
{
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.BASESTATION, APPStates.CNTRLOOKUP );
		return mapping.findForward( "main" );
	}
}
