/*
 * Created on 30.03.2007
 *
 * История изменения описей EditForm.
 */
package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocsHistory_Object;
import com.hps.july.web.util.EditForm;

/**
 * @author IShaffigulin
 *
 * История изменения описей EditForm.
 */
public class RegistryBuchDocsHistoryForm extends EditForm {
	private Integer idRegistryDoc = null;
	private String sortBy = "actionTime desc";

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_HISTORY;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		java.util.List historyList = CDBC_LeaseRegistryBuchDocsHistory_Object.getList(getIdRegistryDoc(), getSortBy());
		request.setAttribute("historyList", historyList);
	}

	/**
	 * @return
	 */
	public Integer getIdRegistryDoc() {
		return idRegistryDoc;
	}

	/**
	 * @return
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * @param i
	 */
	public void setIdRegistryDoc(Integer i) {
		idRegistryDoc = i;
	}

	/**
	 * @param string
	 */
	public void setSortBy(String string) {
		sortBy = string;
	}

}
