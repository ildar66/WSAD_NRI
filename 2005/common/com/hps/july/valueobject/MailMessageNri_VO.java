/*
 * Created on 26.07.2006
 *
 * �������� ��������� ������������� NRI.
 */
package com.hps.july.valueobject;

import java.util.*;

/**
 * @author IShaffigulin
 *
 * �������� ��������� ������������� NRI. 
 */
public class MailMessageNri_VO {
	private String templateName;//������ ���������
	private String text;//����� ���������
	private String topic;//���� ���������
	private String serviceName;//��� �������
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
