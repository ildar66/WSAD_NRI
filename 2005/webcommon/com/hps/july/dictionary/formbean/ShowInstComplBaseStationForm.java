/*
 * Created on 06.02.2007
 */
package com.hps.july.dictionary.formbean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author irogachev
 */
public class ShowInstComplBaseStationForm extends ConfPowerSourcesForm {

	public ShowInstComplBaseStationForm() {
		setSearchLabel("����� ��������� \"��������������� ��������� �� � �����\"");
		setComplectLabel("������� ��������� �� ��");
		setStructLabel("������ ��������� �� ��");
		setModelTypeCode("-9999"); // ����� ����� ����� ������ ������ � SQL 
		setComplectTypeCode("2");
		setResourceSetClassConst(new Integer(getModelTypeCode()));
		setUnitInt(false);
	}

	public List getSearchParameterList() {
		List locSearchParamList = new ArrayList();
		//
		OptionEntry oe = new OptionEntry();
		oe.setKey(ConfPowerSourcesForm.SRC_CMPL);
		oe.setValue("���� ���������");
		locSearchParamList.add(oe);
		//
		oe = new OptionEntry();
		oe.setKey(ConfPowerSourcesForm.CMPL_TITLE);
		oe.setValue("������������");
		locSearchParamList.add(oe);
		//
		return locSearchParamList;
	}

}
