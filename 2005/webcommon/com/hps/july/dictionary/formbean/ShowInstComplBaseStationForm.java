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
		setSearchLabel("Выбор комплекта \"Инсталляционный комплекты БС в сборе\"");
		setComplectLabel("Текущие комплекты ИК БС");
		setStructLabel("Состав комплекта ИК БС");
		setModelTypeCode("-9999"); // позже нужно будет ввести логику в SQL 
		setComplectTypeCode("2");
		setResourceSetClassConst(new Integer(getModelTypeCode()));
		setUnitInt(false);
	}

	public List getSearchParameterList() {
		List locSearchParamList = new ArrayList();
		//
		OptionEntry oe = new OptionEntry();
		oe.setKey(ConfPowerSourcesForm.SRC_CMPL);
		oe.setValue("коду комплекта");
		locSearchParamList.add(oe);
		//
		oe = new OptionEntry();
		oe.setKey(ConfPowerSourcesForm.CMPL_TITLE);
		oe.setValue("наименованию");
		locSearchParamList.add(oe);
		//
		return locSearchParamList;
	}

}
