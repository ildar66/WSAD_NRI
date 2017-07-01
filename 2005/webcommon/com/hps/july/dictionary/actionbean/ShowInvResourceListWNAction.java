package com.hps.july.dictionary.actionbean;

import com.hps.july.dictionary.formbean.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * ���������� ����� ������ ��������� �� �������
 */
public class ShowInvResourceListWNAction
	extends BrowseAction
{
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Integer category = new Integer(request.getParameter("category"));
			
		InvResourceListForm frm = (InvResourceListForm)form;
		frm.setCategory(category);
		
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.INVRESOURCE_LIST_WN );
		return mapping.findForward( "main" );
	}
}
