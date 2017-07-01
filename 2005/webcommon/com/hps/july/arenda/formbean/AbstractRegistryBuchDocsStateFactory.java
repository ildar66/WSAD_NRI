/*
 * Created on 25.12.2006
 *
 * AbstractStateFactory - Формирование списка возможных состояний описи документов для различных регионов.
 */
package com.hps.july.arenda.formbean;

import java.util.ArrayList;
import java.util.List;

import com.hps.july.arenda.valueobject.RegistryBuchDocsState;

/**
 * @author IShaffigulin
 *
 * AbstractStateFactory - Формирование списка возможных состояний описи документов для различных регионов.
 */
public abstract class AbstractRegistryBuchDocsStateFactory {

	//флаги состояния:
	public final static String PREPARATION = "1"; //подготовка описи
	public final static String SEND_PURCHASER = "4"; //отправлена закупщику
	public final static String EDIT_PURCHASER = "5"; //обрабатывается закупщиком
	public final static String SEND_ACCOUNTANT = "2"; //отправлена бухгалтеру
	public final static String EDIT_ACCOUNTANT = "6"; //обрабатывается бухгалтером
	public final static String ACCEPTED_ACCOUNTANT = "3"; //принято бухгалт.
	public final static String SEND_INITIATOR = "7"; //передан инициатору.
	public final static String ACCEPTED_INITIATOR = "8"; //принята инициатором.

	//состояния:
	public final static RegistryBuchDocsState PREPARATION_STATE = new RegistryBuchDocsState("подготовка описи", PREPARATION);
	public final static RegistryBuchDocsState SEND_PURCHASER_STATE = new RegistryBuchDocsState("отправлена закупщику", SEND_PURCHASER);
	public final static RegistryBuchDocsState EDIT_PURCHASER_STATE = new RegistryBuchDocsState("обработка закупщиком", EDIT_PURCHASER);
	public final static RegistryBuchDocsState SEND_ACCOUNTANT_STATE = new RegistryBuchDocsState("отправлена бухгалтеру", SEND_ACCOUNTANT);
	public final static RegistryBuchDocsState EDIT_ACCOUNTANT_STATE = new RegistryBuchDocsState("обработка бухгалтером", EDIT_ACCOUNTANT);
	public final static RegistryBuchDocsState ACCEPTED_ACCOUNTANT_STATE = new RegistryBuchDocsState("принято бухгалтером", ACCEPTED_ACCOUNTANT);
	public final static RegistryBuchDocsState SEND_INITIATOR_STATE = new RegistryBuchDocsState("передан инициатору.", SEND_INITIATOR);
	public final static RegistryBuchDocsState ACCEPTED_INITIATOR_STATE = new RegistryBuchDocsState("принята инициатором.", ACCEPTED_INITIATOR);

	//группы пользователей:
	public final static String IG = "IG"; //группа инициаторов документов(экономисты).
	public final static String RG = "RG"; //группа проверяющих документы(бухгалтеры, закупщики).
	public final static String IRG = "IRG"; //группа IG+RG(бухгалтеры+экономисты, закупщики+экономисты).
	public final static String AG = "AG"; //бухгалтер(ACCOUNTANT).
	public final static String PG = "PG"; //закупщик(PURCHASER).

	/**
	 * список возможных состояний описи документов, который зависит от текущего состояния и от роли пользователя. 
	 * @param curState
	 * @return
	 */
	public abstract List getAvailableStateList(String curState, String group);

	/**
	 * 
	 * @param hasArendaPurchaser
	 * @return
	 */
	public static AbstractRegistryBuchDocsStateFactory getFactory(boolean hasArendaPurchaser) {
		if (hasArendaPurchaser) {
			return new RegistryBuchDocsStateFactoryHasArendaPurchaser();
		} else {
			return new RegistryBuchDocsStateFactoryNoArendaPurchaser();

		}
	}

	/**
	 * 
	 * @param curState
	 * @param group
	 * @return
	 */
	protected List getErrorStateList(String curState, String group) {
		//ошибка возможного состояния:
		ArrayList retList = new ArrayList();
		String errorName = "ошибка возм-го=" + curState + "(" + group + ") состояния для данного региона";
		retList.add(new RegistryBuchDocsState(errorName, curState));
		return retList;
	}

	/**
	 * 
	 * @param stateStr
	 * @return
	 */
	public final static RegistryBuchDocsState getState(String stateStr) {
		if (PREPARATION.equalsIgnoreCase(stateStr)) {
			return PREPARATION_STATE;
		} else if (SEND_PURCHASER.equalsIgnoreCase(stateStr)) {
			return SEND_PURCHASER_STATE;
		} else if (EDIT_PURCHASER.equalsIgnoreCase(stateStr)) {
			return EDIT_PURCHASER_STATE;
		} else if (SEND_ACCOUNTANT.equalsIgnoreCase(stateStr)) {
			return SEND_ACCOUNTANT_STATE;
		} else if (EDIT_ACCOUNTANT.equalsIgnoreCase(stateStr)) {
			return EDIT_ACCOUNTANT_STATE;
		} else if (ACCEPTED_ACCOUNTANT.equalsIgnoreCase(stateStr)) {
			return ACCEPTED_ACCOUNTANT_STATE;
		} else if (SEND_INITIATOR.equalsIgnoreCase(stateStr)) {
			return SEND_INITIATOR_STATE;
		} else if (ACCEPTED_INITIATOR.equalsIgnoreCase(stateStr)) {
			return ACCEPTED_INITIATOR_STATE;
		} else {
			return null;
		}

	}

}
