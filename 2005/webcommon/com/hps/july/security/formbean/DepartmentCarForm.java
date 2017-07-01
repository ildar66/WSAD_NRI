package com.hps.july.security.formbean;

/**
 * ‘орма редактировани€ автомашины подразделени€.
 * Creation date: (22.07.2003 12:00:13)
 * @author: Sergey Gourov
 */
public class DepartmentCarForm extends DirectionCarForm {
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:56:48)
 * @return java.lang.String
 */
String getListForm() {
	return "DepartmentCarsList";
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:35:04)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.DEPARTMENT_CAR_EDIT;
}
}
