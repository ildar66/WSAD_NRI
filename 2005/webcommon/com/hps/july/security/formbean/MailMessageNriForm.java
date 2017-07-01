/*
 * Created on 26.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.security.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.util.MailUtil;
import com.hps.july.valueobject.MailMessageNri_VO;
import com.hps.july.web.util.EditForm;

/**
 * @author IShaffigulin
 *
 * "Рассылка оповещения пользователям NRI" EditForm
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MailMessageNriForm extends EditForm {
	private MailMessageNri_VO vo = null;
	private String principalName;
	private int hour = 2 * 24; //Кол-во часов, в течении который пользователи были активны

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.SECURITY;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.security.APPStates.MAIL_MASSAGE_NRI;
	}

	/**
	 * @return
	 */
	public MailMessageNri_VO getVo() {
		return vo;
	}

	/**
	 * @param nri_VO
	 */
	public void setVo(MailMessageNri_VO nri_VO) {
		vo = nri_VO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		//super.loadRecord(request);
		setVo(new MailMessageNri_VO());
		//шаблон письма:
		getVo().setTemplateName("com/hps/july/mail/template/NriMailTemplate.message");
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processUpdate(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processUpdate(HttpServletRequest request, ActionErrors errors) throws Exception {
		//return super.processUpdate(request, errors);

		return null;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		String errorTxt = "Сообщение отправлено";
		MailUtil.sendMail(getPrincipalName(), getVo(), hour);
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
		} //"org.apache.struts.action.GLOBAL_WARNING"
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setPrincipalName(request.getRemoteUser());
	}

	/**
	 * @return
	 */
	private String getPrincipalName() {
		return principalName;
	}

	/**
	 * @param string
	 */
	private void setPrincipalName(String string) {
		principalName = string;
	}

	/**
	 * @return
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param i
	 */
	public void setHour(int i) {
		hour = i;
	}

}
