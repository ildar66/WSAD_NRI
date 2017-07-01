/*
 * Created on 08.08.2006
 *
 */
package com.hps.july.inventory.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.inventory.APPStates;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;
import com.hps.july.web.util.Profile;

/**
 * @author dima
 *
 */
public class ShowConfigFormAction extends NavigatedAction {
	/**
	 * Shows if to add current URL to history.
	 * Creation date: (08.10.2003 17:21:05)
	 * @return boolean
	 */
	public boolean isAddtoHistory() {
		return true;
	}
	/**
	 * Признак возврата на текущий режим.
	 * Creation date: (08.10.2003 17:21:05)
	 * @return boolean
	 */
	public boolean isReturnable() {
		return true;
	}
	
	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.INVENTORY, APPStates.CONFIG_EQUIPMENT_FORM);
		Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
		
		/*
		if(profile != null) {
			profile.setSystemParameter(Profile.MENU_STATUS,"1");
		}
		*/
    	
		return mapping.findForward("main");
	}

}
