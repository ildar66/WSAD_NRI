package com.hps.july.siteinfo.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик журнала изменений по позиции
 */
public class ShowJournalListAction extends com.hps.july.web.util.BrowseAction {
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ChangeLogAccessBean";
}
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	ParamsParser.setState( request, Applications.SITEINFO, APPStates.JOURNAL_LIST );
  	JournalListForm jf = (JournalListForm)form;
  	jf.setObjecttypename(JournalForm.getObjecttypeName(jf.getObjecttype()));
  	if(jf.getObjectid() != null) {
	  	jf.setObjectname(JournalForm.getObjectName(jf.getObjecttype(),jf.getObjectid().intValue()));
  	} else {
	  	jf.setObjecttypename("Не указан код объекта");
  	}
	super.perform( mapping, form, request, response );
	return mapping.findForward( "main" );
}
}
