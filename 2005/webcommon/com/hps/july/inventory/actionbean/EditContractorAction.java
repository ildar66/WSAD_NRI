package com.hps.july.inventory.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import com.hps.july.inventory.formbean.*;
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
 * ќбработчик формы редактировани€ позиции "¬нешнего приходного ордера"
 * ѕри добавлении нескольких серийных позиций осуществл€ет переход на 
 * форму редактировани€ серийных номеров.
 * ѕри удалении серийной позиции удал€ет все записи с номерами
 */
public class EditContractorAction extends com.hps.july.web.util.AbstractEditAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		super.perform( mapping, form, request, response );
		
		Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
		
		if(profile != null) {
			profile.setSystemParameter(Profile.MENU_STATUS,"1");
		}

	    return mapping.findForward( "main" );  
	    
	}
}
