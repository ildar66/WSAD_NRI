package com.hps.july.dictionary.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.dictionary.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Обработчик формы выбора класса добавляемого оборудования
 * Осуществляет переход на соответствующую форму
 */
public class ProcessChooseRtype
	extends NavigatedAction
{
public boolean isAddtoHistory() {
	return false;
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

	    ChooseRtypeForm frm = (ChooseRtypeForm)form;

	    frm.setAction("Add");
	    
		if("basestation".equals(frm.getRtype())) {
			retVal = mapping.findForward( "basestation" ); 
		} else if("antenna".equals(frm.getRtype())) {
			retVal = mapping.findForward( "antenna" );
		} else if("cable".equals(frm.getRtype())) {
			retVal = mapping.findForward( "cable" );
		} else if("repeater".equals(frm.getRtype())) {
			retVal = mapping.findForward( "repeater" );
		} else if("donorunit".equals(frm.getRtype())) {
			retVal = mapping.findForward( "donorunit" );
		} else {
			retVal = mapping.findForward( "other" );
		}

		return retVal;    
	}
}
