/*
 * Created on 04.08.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.basestation.formbean;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EquipmentStatusConstants {

	private final static String stateEqValues[] = { "-", "P", "W", "M", "D"};
	private final static String stateBsLabels[] = { "---", "Строительство", "В эфире (тестирование)", "Коммерческая эксплуатация", "Демонтирована"};
	private final static String stateEqLabels[] = { "---", "Планируется", "Запущено в работу", "Модернизируется", "Демонтировано"};

	/**
	 * @return
	 */
	public static String[] getStateEqLabels() {
		return stateEqLabels;
	}

	/**
	 * @return
	 */
	public static String[] getStateEqValues() {
		return stateEqValues;
	}

	public static String getStateEqLabel(String inValue) {
		String outStr = "";
		for (int i = 0; i < stateEqValues.length; i++) {
			if (stateEqValues[i].equals(inValue)) {
				outStr = stateEqLabels[i];
				break;
			}
		}
		return outStr;
	}

	public static String getStateBsLabel(String inValue) {
		String outStr = "";
		for (int i = 0; i < stateEqValues.length; i++) {
			if (stateEqValues[i].equals(inValue)) {
				outStr = stateBsLabels[i];
				break;
			}
		}
		return outStr;
	}

	/**
	 * @return
	 */
	public static String[] getStateBsLabels() {
		return stateBsLabels;
	}

}
