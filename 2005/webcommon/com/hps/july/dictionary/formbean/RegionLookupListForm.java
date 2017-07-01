/*
 * Created on 24.01.2006
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

import com.hps.july.constants.Applications;
import com.hps.july.web.util.ParamsParser;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RegionLookupListForm extends RegionListForm {
	private java.lang.String formname;
	private java.lang.String fieldnames;
	/**
	 * 
	 */
	public RegionLookupListForm() {
		super();
		setLastVisited(false);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		computeHistory();
		ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.REGION_LOOKUP_LIST);
		return null;
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

}
