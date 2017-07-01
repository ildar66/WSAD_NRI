/*
 * Created on 06.04.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.formbean.RegionFactoryAbstract;
import com.hps.july.constants.Applications;
import com.hps.july.web.util.ParamsParser;
import com.hps.july.web.util.Profile;
import com.hps.july.web.util.ProfileAccessHelper;

/**
 * @author IShaffigulin
 *
 * Отделения поставщиков LookupListForm.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class VendorSiteLookupListForm extends VendorSiteListForm {
	private java.lang.String formname;
	private java.lang.String fieldnames;
	private String onMySelect = null;
	
	/**
	 * 
	 */
	public VendorSiteLookupListForm() {
		this.setFinderMethodName("findLookupList");
		setFilter(1);
		setSearchString("");
		setSortBy("vs.name desc");
	
		setIsRecordStatus(Boolean.TRUE);
		setIsUseInNri(Boolean.TRUE);		
	}

	/**
	 * @return
	 */
	public java.lang.String getFieldnames() {
		return fieldnames;
	}

	/**
	 * @return
	 */
	public java.lang.String getFormname() {
		return formname;
	}

	/**
	 * @param string
	 */
	public void setFieldnames(java.lang.String string) {
		fieldnames = string;
	}

	/**
	 * @param string
	 */
	public void setFormname(java.lang.String string) {
		formname = string;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.VENDOR_SITE_LOOKUP_LIST);
		setRegionID(ProfileAccessHelper.getCurrentRegionID(request));
		setVendorFormView(RegionFactoryAbstract.getFactory(getRegionID().intValue()).getVendorFormView());		
		return null;
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (23.03.2005 12:31:22)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] {
			Boolean.FALSE,	new Integer(getIdVendor()),
			new Integer(getFilter()),	getSearchString(),
			getIsUseInNri(),
			getIsRecordStatus(),
			getIsRegionID(),  getRegionID(),
			getSortBy()};
	}


	/**
	 * @return
	 */
	public String getOnMySelect() {
		return onMySelect;
	}

	/**
	 * @param string
	 */
	public void setOnMySelect(String string) {
		onMySelect = string;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		setOnMySelect(null);
	}

}
