/*
 * Created on 24.11.2006
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.dictionary.APPStates;

/**
 * @author irogachev
 */
public class NFSResLookupForm extends NFSRes2NRIResForm {

 	private String nfsId;
	private String nfsCode;
	private String nfsDescr;

	public NFSResLookupForm() {
		super();
	}

	public int getState() {
		return APPStates.NFS_RES_LOOKUP; // NFSRES2NRIRES;
	}

	/**
	 * @return
	 */
	public String getNfsCode() {
		return nfsCode;
	}

	/**
	 * @return
	 */
	public String getNfsDescr() {
		return nfsDescr;
	}

	/**
	 * @return
	 */
	public String getNfsId() {
		return nfsId;
	}

	/**
	 * @param string
	 */
	public void setNfsCode(String string) {
		nfsCode = string;
	}

	/**
	 * @param string
	 */
	public void setNfsDescr(String string) {
		nfsDescr = string;
	}

	/**
	 * @param string
	 */
	public void setNfsId(String string) {
		nfsId = string;
	}

}
