/*
 * Created on 07.03.2007
 *
 * "Информация об абонентском договоре"
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * @author IShaffigulin
 *
 * "Информация об абонентском договоре"
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AbonentInfoForm extends AbonentBanForm {

	/**
	 * конструктор "Информация об абонентском договоре"
	 */
	public AbonentInfoForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		//super.initCollections(request);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.ABONENT_INFO;
	}

}
