/*
 * Created on 28.12.2006
 */
package com.hps.july.dictionary.formbean;

/**
 * @author irogachev
 */
public class ConfPowerSourcesElApForm extends ConfPowerSourcesForm {

	public ConfPowerSourcesElApForm() {
		setSearchLabel("Выбор комплекта \"Источник питания в сборе\"");
		setComplectLabel("Текущие комплекты источников питания");
		setStructLabel("Состав комплекта источника питания");
		setModelTypeCode("6");
		setComplectTypeCode("1");
		setResourceSetClassConst(new Integer(getModelTypeCode()));
	}
	
}
