/*
 * Created on 28.12.2006
 */
package com.hps.july.dictionary.formbean;

/**
 * @author irogachev
 */
public class ConfPowerSourcesElApForm extends ConfPowerSourcesForm {

	public ConfPowerSourcesElApForm() {
		setSearchLabel("����� ��������� \"�������� ������� � �����\"");
		setComplectLabel("������� ��������� ���������� �������");
		setStructLabel("������ ��������� ��������� �������");
		setModelTypeCode("6");
		setComplectTypeCode("1");
		setResourceSetClassConst(new Integer(getModelTypeCode()));
	}
	
}
