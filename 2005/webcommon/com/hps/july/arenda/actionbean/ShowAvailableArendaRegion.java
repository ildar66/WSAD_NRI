
package com.hps.july.arenda.actionbean;

import java.util.ArrayList;
import java.util.List;

import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * @author vglushkov
 * ќбработчик выбора доступного региона в модуле аренды 
 */
public class ShowAvailableArendaRegion extends NavigatedAction {

	/**
	 * Shows if to add current URL to history.
	 * Creation date: (08.10.2003 17:21:05)
	 * @return boolean
	 */
	public boolean isAddtoHistory() {
		return false;
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.CHOOSE_AVAILABLE_REGION);
		AvailableRegionForm arForm = (AvailableRegionForm)form;
		arForm.setAvailableRegions(getRegionAccessList(request));
		setCurRegion(request, arForm);
		return mapping.findForward("main");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.11.2005 16:17:31)
	 */
	private void setCurRegion(HttpServletRequest request, AvailableRegionForm arForm) {
		String curRegID = request.getParameter("curRegID");
		Profile profile = getProfile(request);
		if (curRegID != null) {
			//команда на изменение региона:
			boolean ok = profile.getProfileAccess().setCurrRegionID(new Integer(curRegID));
			if (!ok)
				System.out.println("“екущий регион с curRegID=" + curRegID + " не установлен");
		} else {
			//просмотр списка:
			arForm.setCurRegId(profile.getProfileAccess().getCurrRegion().getVo().getRegionid());
		}
	}
	
	private List getRegionAccessList(HttpServletRequest request) {
		Profile profile = getProfile(request);
		return (profile != null)?profile.getProfileAccess().getRegionAccessList():null;
	}
	
	private Profile getProfile(HttpServletRequest request) {
		return  (Profile) request.getSession().getAttribute(Profile.PROFILE);

	}

}
