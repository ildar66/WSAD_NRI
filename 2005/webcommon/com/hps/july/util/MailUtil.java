/*
 * Created on 26.07.2006
 *
 * Отправка сообщений пользователям.
 */
package com.hps.july.util;

import java.sql.Timestamp;
import java.util.*;

import com.hps.april.auth.object.AuthInfo;
import com.hps.april.auth.object.AuthInfoImpl;
import com.hps.july.cdbc.objects.CDBC_MailMessageNri;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.mail.JulyMailServiceFactory;
import com.hps.july.mail.service.JulyMailService;
import com.hps.july.valueobject.MailMessageNri_VO;
import com.hps.july.valueobject.MailRecipient_VO;
import com.hps.july.valueobject.People_TO;

/**
 * @author IShaffigulin
 *
 * Отправка сообщения пользователям.
 */
public class MailUtil {
	/**
	 * Отправка сообщения пользователям NRI.
	 *
	 */
	public static final void sendMail(String princName, MailRecipient_VO recipient, MailMessageNri_VO messageVO) {
		AuthInfoImpl info = new AuthInfoImpl(princName);
		People_TO people_to = CDBC_MapFactory.getPeopleTO(princName);
		info.setPersonId(people_to.getVo().getMan());
		info.setOperatorId(people_to.getOperatorCode());
		info.setOperatorLogin(people_to.getRemoteUser());

		sendMail(recipient, messageVO, info);
	}
	/**
	 * Отправка сообщения пользователям NRI.
	 *
	 */
	public static final void sendMail(String princName, MailMessageNri_VO messageVO, long hour) {
		AuthInfoImpl info = new AuthInfoImpl(princName);
		People_TO people_to = CDBC_MapFactory.getPeopleTO(princName);
		info.setPersonId(people_to.getVo().getMan());
		info.setOperatorId(people_to.getOperatorCode());
		info.setOperatorLogin(people_to.getRemoteUser());
		long before = hour * (60 * 60 * 1000);
		Timestamp lastLoginTime = new Timestamp(System.currentTimeMillis() - before);
		System.out.println("lastLoginTime=" + lastLoginTime);
		List recipients = CDBC_MailMessageNri.findListMailRecipients(Boolean.TRUE, lastLoginTime, null);
		for (Iterator iter = recipients.iterator(); iter.hasNext();) {
			MailRecipient_VO recipient = (MailRecipient_VO) iter.next();
			System.out.println("recipient=" + recipient);
			sendMail(recipient, messageVO, info);
		}
	}
	/**
	 * 
	 * @param recipient
	 * @param messageVO
	 * @param info
	 */
	private static void sendMail(MailRecipient_VO recipient, MailMessageNri_VO messageVO, AuthInfo info) {
		HashMap prop = new HashMap();
		prop.put("text", messageVO.getText());
		prop.put("name", recipient.getName());

		ArrayList recipientList = new ArrayList();
		recipientList.add(recipient.getMail());

		JulyMailServiceFactory.createMailService().sendHTMLMailByTemplate(info, recipientList, messageVO.getTopic(), messageVO.getTemplateName(), prop, JulyMailService.ARENDA_SERVICE_NAME);
		//messageVO.getServiceName()
	}

}
