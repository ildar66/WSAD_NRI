/*
 * Created on 04.12.2006
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.constants.Applications;
import com.hps.july.dictionary.APPStates;
import com.hps.july.web.util.EditForm;

/**
 * @author irogachev
 */
public class NRIResLookupForm extends EditForm {

	private String nriCode;
	private String nriName;
	private String nriModel;
	private String nriUnit;
	private String searchby;
	private String searchparam;

	public int getApplication() {
		return Applications.DICTIONARY;
	}

	public int getState() {
		return APPStates.NRI_RES_LOOKUP;
	}

	/**
	 * @return
	 */
	public String getNriCode() {
		return nriCode;
	}

	/**
	 * @return
	 */
	public String getNriModel() {
		return nriModel;
	}

	/**
	 * @return
	 */
	public String getNriName() {
		return nriName;
	}

	/**
	 * @param string
	 */
	public void setNriCode(String string) {
		nriCode = string;
	}

	/**
	 * @param string
	 */
	public void setNriModel(String string) {
		nriModel = string;
	}

	/**
	 * @param string
	 */
	public void setNriName(String string) {
		nriName = string;
	}

	/**
	 * @return
	 */
	public String getSearchby() {
		return searchby;
	}

	/**
	 * @return
	 */
	public String getSearchparam() {
		return searchparam;
	}

	/**
	 * @param string
	 */
	public void setSearchby(String string) {
		searchby = string;
	}

	/**
	 * @param string
	 */
	public void setSearchparam(String string) {
		searchparam = string;
	}

	/**
	 * @return
	 */
	public String getNriUnit() {
		return nriUnit;
	}

	/**
	 * @param string
	 */
	public void setNriUnit(String string) {
		nriUnit = string;
	}

}
