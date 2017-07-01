package com.hps.july.security.formbean;

/**
 * Форма редактирования автомашины службы.
 * Creation date: (22.07.2003 11:59:54)
 * @author: Sergey Gourov
 */
public class ServiceCarForm extends DirectionCarForm {
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:56:48)
 * @return java.lang.String
 */
String getListForm() {
	return "ServiceCarsList";
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:35:04)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.SERVICE_CAR_EDIT;
}
}
