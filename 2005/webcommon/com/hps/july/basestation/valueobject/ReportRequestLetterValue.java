package com.hps.july.basestation.valueobject;

import java.util.*;
/**
 * —лужебный класс дл€ документа "ѕисьмо-за€вка"
 */
public class ReportRequestLetterValue {
	private int quantity = 0; //  оличество пролетов в файле
	private Set models = new TreeSet(); // “ипы оборудовани€ из характеристик пролетов 
	private Set speeds = new TreeSet(); // —корости потока из характеристик пролетов
/**
 * ReportRequestLetterValue constructor comment.
 */
public ReportRequestLetterValue() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 17:30:01)
 * @param newModel java.lang.String
 */
public void addModel(String newModel) {
	models.add(newModel);
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 17:32:29)
 * @param newSpeed java.lang.String
 */
public void addSpeed(String newSpeed) {
	speeds.add(newSpeed);
}
/**
 * ¬озвращает две строки, которые будут использоватьс€ дл€
 * выбора из файла properties слов с правильными окончани€ми
 */
public String[] getEndings() {
	String[] strings = new String[2];
	int number = getQuantity();
//	int number = 4;
	if((number == 1) || ((number % 10) == 1)) {
		strings[0] = "rrl1";
		strings[1] = "interval1";
		return strings;
	}
	if((number % 10) >1  && (number % 10) < 5) {
		strings[0] = "rrl2";
		strings[1] = "interval2";
		return strings;
	}
	else {
		strings[0] = "rrl2";
		strings[1] = "interval3";
	}
	return strings;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 17:27:15)
 * @return java.util.Set
 */
private java.util.Set getModels() {
	return models;
}
/**
 * 
 */
public String getModelsString() {
	return getValuesString(getModels(), true);
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 17:12:26)
 * @return int
 */
public int getQuantity() {
	return quantity;
}
/**
 * ¬озвращает строки дл€ формировани€ буквенного написани€
 */
public String getQuantityString() {
	return com.hps.july.logic.TxtNumLogic.txtNum(getQuantity(),"радиорелейных интервал");
}
/**
 * ¬озвращает строки дл€ формировани€ буквенного написани€
 */
public String[] getQuantityStrings() {
	String[] strings = new String[2];
	int number = getQuantity();
//	int number = 4;
	if(number <= 20) {
		strings[0] = String.valueOf(number);
		return strings;
	} else if((number % 10) == 0) {
		strings[0] = String.valueOf(number);
		return strings;
	} else {
		int dozens = number / 10;
		strings[0] = String.valueOf(dozens * 10);
		number = number - dozens * 10;
		strings[1] = String.valueOf(number);
	}
	return strings;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 17:30:47)
 * @return java.util.Set
 */
private java.util.Set getSpeeds() {
	return speeds;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 19:45:00)
 * @return java.lang.String
 */
public String getSpeedsString() {
	return getValuesString(getSpeeds(), false);
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 19:42:38)
 * @return java.lang.String
 * @param values java.util.Set
 */
public String getValuesString(Set values, boolean usebrackets) {
	if(values.size() == 0)
		return null;
	StringBuffer valuesBuffer = new StringBuffer();
	Iterator it = values.iterator();
	String value = null;
	while(it.hasNext()) {
		value = (String)it.next();
		if(value == null || value.length() == 0)
			continue;
		if(usebrackets) {
			valuesBuffer.append("&laquo;");
		}
		valuesBuffer.append(value);
		if(usebrackets) {
			valuesBuffer.append("&raquo;");
		}
		valuesBuffer.append(", ");
	}
	return valuesBuffer.substring(0, valuesBuffer.length() - 2);
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 17:14:36)
 */
public void increaseQuantity() {
	this.quantity++;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2004 17:12:26)
 * @param newQuantity int
 */
public void setQuantity(int newQuantity) {
	quantity = newQuantity;
}
}
