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
import com.hps.july.web.util.ProfileAccessHelper;

/**
 * @author IShaffigulin
 *
 * Поставщики LookupListForm.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class VendorLookupListForm extends VendorListForm {
	private java.lang.String formname = null;
	private java.lang.String fieldnames = null;
	private String onMySelect = null;
	/**
	 * 
	 */
	public VendorLookupListForm() {
		super();
		setLastVisited(false);
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
		ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.VENDOR_LOOKUP_LIST);
		setRegionID(ProfileAccessHelper.getCurrentRegionID(request));
		setVendorFormView(RegionFactoryAbstract.getFactory(getRegionID().intValue()).getVendorFormView());		
		return null;
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

}
