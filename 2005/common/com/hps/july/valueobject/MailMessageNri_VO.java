/*
 * Created on 26.07.2006
 *
 * Отправка сообщений пользователям NRI.
 */
package com.hps.july.valueobject;

import java.util.*;

/**
 * @author IShaffigulin
 *
 * Отправка сообщений пользователям NRI. 
 */
public class MailMessageNri_VO {
	private String templateName;//шаблон сообщения
	private String text;//текст сообщения
	private String topic;//тема сообщения
	private String serviceName;//тип сервиса
	/**
	 * @return
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param string
	 */
	public void setTemplateName(String string) {
		templateName = string;
	}

	/**
	 * @param string
	 */
	public void setText(String string) {
		text = string;
	}

	/**
	 * @param string
	 */
	public void setTopic(String string) {
		topic = string;
	}

	/**
	 * @return
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param string
	 */
	public void setServiceName(String string) {
		serviceName = string;
	}

}
