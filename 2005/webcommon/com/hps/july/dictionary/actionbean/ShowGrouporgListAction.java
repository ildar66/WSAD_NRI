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
 * Обработчик формы списка юр. лиц входящих в группу
 */
public class ShowGrouporgListAction
	extends BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.OrganizationAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.DICTIONARY, APPStates.GRPOLIST );
		GrouppingListForm gform = (GrouppingListForm)request.getSession().getAttribute( "GrouppingListForm" );
	  	GrouporgListForm oform = (GrouporgListForm) form;
	  	oform.setSearchgroup(gform.getSearchgroup());
	  	oform.setSearchgroupname(gform.getSearchgroupname());
	  	try {
			SearchGrouppingAccessBean bean = new SearchGrouppingAccessBean();
			bean.setInitKey_searchGroupping(oform.getSearchgroupping());
			bean.refreshCopyHelper();
			oform.setSearchgrouppingname(bean.getName());
	  	} catch (Exception e) {
		    oform.setSearchgroupping(0);
		    oform.setSearchgrouppingname("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
