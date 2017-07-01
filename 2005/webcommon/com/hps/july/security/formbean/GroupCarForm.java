package com.hps.july.security.formbean;

/**
 * Форма редактирования автомашины группы.
 * Creation date: (22.07.2003 12:00:27)
 * @author: Sergey Gourov
 */
public class GroupCarForm extends DirectionCarForm {
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:56:48)
 * @return java.lang.String
 */
String getListForm() {
	return "GroupCarsList";
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:35:04)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.GROUP_CAR_EDIT;
}
}
