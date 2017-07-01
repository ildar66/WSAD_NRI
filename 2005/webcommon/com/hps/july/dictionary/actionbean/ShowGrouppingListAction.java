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
 * Обработчик формы списка группировок юр. лиц
 */
public class ShowGrouppingListAction
	extends BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.SearchGrouppingAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.DICTIONARY, APPStates.GRPPLIST );
	  	GrouppingListForm oform = (GrouppingListForm) form;
	  	try {
	  		SearchGroupAccessBean bean = new SearchGroupAccessBean();
	  		bean.setInitKey_searchgroup(oform.getSearchgroup());
	  		bean.refreshCopyHelper();
		    oform.setSearchgroupname(bean.getName());
	  	} catch (Exception e) {
		    oform.setSearchgroup(0);
		    oform.setSearchgroupname("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
