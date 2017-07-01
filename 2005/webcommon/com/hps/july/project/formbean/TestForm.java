package com.hps.july.project.formbean;

/**
 * Тестовая форма. Не используется.
 * @deprecated
 * Creation date: (24.10.2002 16:33:13)
 * @author: Maksim Gerasimov
 */
public class TestForm extends org.apache.struts.action.ActionForm {
	private java.lang.String dateFrm;
	private java.lang.String action;
	public TestForm(){
		dateFrm = "123";
		action="Add";
	}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 18:47:10)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 16:34:09)
 * @return java.lang.String
 */
public java.lang.String getDateFrm() {
	return dateFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 18:47:10)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 16:34:09)
 * @param newDateFrm java.lang.String
 */
public void setDateFrm(java.lang.String newDateFrm) {
	dateFrm = newDateFrm;
}
}
