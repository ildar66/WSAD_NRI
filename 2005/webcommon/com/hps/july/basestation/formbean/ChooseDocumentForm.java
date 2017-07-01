/*
 * Created on 25.05.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.basestation.formbean;

import org.apache.struts.action.ActionForm;

import com.hps.july.basestation.actionbean.ChooseDocumentFormConstants;

/**
 * @author ria
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChooseDocumentForm extends ActionForm {

	private Integer idDoc;
	private String docTypeCode;
	private Integer visualType;
	private String state; // статус документа 1-в работе, 2-обсчитан
	private String isAutoDoc; // автоматически созданный документ Y / N

	/**
	 * @return
	 */
	public String getDocTypeCode() {
		return docTypeCode;
	}

	/**
	 * @return
	 */
	public Integer getIdDoc() {
		return idDoc;
	}

	/**
	 * @param string
	 */
	public void setDocTypeCode(String string) {
		docTypeCode = string;
	}

	/**
	 * @param integer
	 */
	public void setIdDoc(Integer integer) {
		idDoc = integer;
	}

	/**
	 * @return
	 */
	public Integer getVisualType() {
		return visualType;
	}

	/**
	 * @param integer
	 */
	public void setVisualType(Integer integer) {
		visualType = integer;
	}

	/**
	 * @return
	 */
	public String getIsAutoDoc() {
		return isAutoDoc;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param string
	 */
	public void setIsAutoDoc(String string) {
		isAutoDoc = string;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}

}
