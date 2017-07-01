/*
 * Created on 09.08.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.web.util;

import javax.servlet.http.*;

import com.hps.july.valueobject.Currency_VO;

/**
 * @author IShaffigulin
 *
 * Работа с профайлом
 */
public class ProfileAccessHelper {
	/**
	 * 
	 * @param request
	 * @return
	 */
	public final static ProfileAccess getProfileAccess(HttpServletRequest request){
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		if(profile == null){
			throw new RuntimeException("Error:Profile = null");
		}
		ProfileAccess profileAccess= profile.getProfileAccess();
		if(profileAccess == null){
			throw new RuntimeException("Error:profile.getProfileAccess() = null");
		}
		return profileAccess;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 17:21:24)
	 */
	public final static Integer getCurrentRegionID(HttpServletRequest request) {
		Integer curRegionID = null;
		ProfileAccess profileAccess = getProfileAccess(request);
		if (profileAccess.getCurrRegion() != null) {
			curRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
		} else {
			//throw new RuntimeException("нет текущего региона для аренды!!!");
			System.out.println("нет текущего региона для оператора!!!");
		}
		return curRegionID;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 17:21:24)
	 */
	public final static Currency_VO getNationalCurrency_VO(HttpServletRequest request) {
		Currency_VO nationalCurrency_VO = null;
		ProfileAccess profileAccess = getProfileAccess(request);
		if (profileAccess.getCurrRegion() != null) {
			nationalCurrency_VO = profileAccess.getCurrRegion().getNationalCurrVO();
		} else {
			//throw new RuntimeException("нет национальной валюты для региона!!!");
			System.out.println("нет национальной валюты для региона!!!");
		}
		return nationalCurrency_VO;
	}
}
