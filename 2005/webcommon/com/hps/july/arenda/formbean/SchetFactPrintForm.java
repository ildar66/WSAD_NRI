package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.arenda.valueobject.*;
import java.util.*;
/**
 * Bean-form
 * Форма "печать счет-фактуры".
 * Creation date: (27.04.2004 11:27:15)
 * @author: Shafigullin Ildar
 */
public class SchetFactPrintForm extends ActionForm {
	private SchetFactHeaderValueObject header;
	private ArrayList positionsList;
	private java.lang.String type = "errorType";
	private java.lang.String code;
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 13:00:23)
 * @return java.lang.String
 */
public java.lang.String getCode() {
	return code;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 12:09:39)
 * @return com.hps.july.arenda.valueobject.SchetFactHeaderValueObject
 */
public SchetFactHeaderValueObject getHeader() {
	return header;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 12:12:13)
 * @return java.util.ArrayList
 */
public ArrayList getPositionsList() {
	return positionsList;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 12:39:03)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 13:00:23)
 * @param newCode java.lang.String
 */
public void setCode(java.lang.String newCode) {
	code = newCode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 12:09:39)
 * @param newHeader com.hps.july.arenda.valueobject.SchetFactHeaderValueObject
 */
public void setHeader(SchetFactHeaderValueObject newHeader) {
	header = newHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 12:12:13)
 * @param newPositionList java.util.ArrayList
 */
public void setPositionsList(ArrayList newPositionsList) {
	positionsList = newPositionsList;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 12:39:03)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
