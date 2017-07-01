package com.hps.july.inventory.formbean;

import org.apache.struts.action.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "Текущее местоположение"
 */
public class Report8ParamsForm extends ReportForm {
	private String serial;
	private Boolean showAgregated;
	private int agregationType;
	private java.lang.Boolean isSerial;
	private java.lang.Boolean isManuf;
public Report8ParamsForm() {
	isSerial = Boolean.FALSE;
	isManuf = Boolean.FALSE;
	showAgregated = Boolean.FALSE;
}
public int getAgregationType() {
	return agregationType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:46:31)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManuf() {
	return isManuf;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:46:10)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSerial() {
	return isSerial;
}
public java.lang.String getSerial() {
	return serial;
}
public java.lang.Boolean getShowAgregated() {
	return showAgregated;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT8PARAMS;
}
public void setAgregationType(int newAgregationType) {
	agregationType = newAgregationType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:46:31)
 * @param newIsManuf java.lang.Boolean
 */
public void setIsManuf(java.lang.Boolean newIsManuf) {
	isManuf = newIsManuf;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:46:10)
 * @param newIsSerial java.lang.Boolean
 */
public void setIsSerial(java.lang.Boolean newIsSerial) {
	isSerial = newIsSerial;
}
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
public void setShowAgregated(java.lang.Boolean newShowAgregated) {
	showAgregated = newShowAgregated;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if(!isSerial.booleanValue() && !isManuf.booleanValue()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.resource"));
	} 
	
	if (!errors.empty())
		throw new ValidationException();
}
}
