/*
 * Created on 28.12.2006
 */
package com.hps.july.dictionary.formbean;

/**
 * @author irogachev
 */
public class ConfPowerSourcesUzoForm extends ConfPowerSourcesForm {
	
	public ConfPowerSourcesUzoForm() {
		setSearchLabel("Выбор комплекта \"Источник питания УЗО в сборе\"");
		setComplectLabel("Текущие комплекты источников питания УЗО");
		setStructLabel("Состав комплекта источника питания УЗО");
		setModelTypeCode("14");
		setComplectTypeCode("3");
		setResourceSetClassConst(new Integer(getModelTypeCode()));
	}

}
