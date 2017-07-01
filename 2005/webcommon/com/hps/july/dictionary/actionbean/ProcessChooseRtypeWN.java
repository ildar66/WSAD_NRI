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
 * Обработчик формы выбора работника по фамилии
 */
public class ProcessChooseRtypeWN
	extends NavigatedAction
{
public boolean isAddtoHistory() {
	return false;
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );

		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();
		
		ChooseRtypeForm frm = (ChooseRtypeForm)form;
		if("basestation".equals(frm.getRtype())) {
			ParamsParser.setState( request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.BASESTATION_RES_EDIT_WN );
		} else if("antenna".equals(frm.getRtype())) {
			ParamsParser.setState( request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.ANTENA_RES_EDIT_WN );
		} else if("cable".equals(frm.getRtype())) {
			ParamsParser.setState( request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.CABLE_RES_EDIT_WN );
		} else if("repeater".equals(frm.getRtype())) {
			ParamsParser.setState( request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.REPEATER_RES_EDIT_WN );
		} else {
			ParamsParser.setState( request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.EDITRES_WN );
		}	

		if("basestation".equals(frm.getRtype())) {
			retVal = mapping.findForward( "basestation" ); 
		} else if("antenna".equals(frm.getRtype())) {
			retVal = mapping.findForward( "antenna" );
		} else if("cable".equals(frm.getRtype())) {
			retVal = mapping.findForward( "cable" );
		} else if("repeater".equals(frm.getRtype())) {
			retVal = mapping.findForward( "repeater" );
		} else {
			retVal = mapping.findForward( "other" );
		}

		return retVal; 
		/*return mapping.findForward( "main" );*/
	}
}
