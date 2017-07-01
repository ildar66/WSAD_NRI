package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "История перемещений"
 */
public class Report9ParamsForm extends ReportForm {
	private String serial;
public Report9ParamsForm() {
}
public java.lang.String getSerial() {
	return serial;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT9PARAMS;
}
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
}
