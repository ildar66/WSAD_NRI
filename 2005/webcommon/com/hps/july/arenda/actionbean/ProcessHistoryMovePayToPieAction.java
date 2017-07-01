package com.hps.july.arenda.actionbean;

/**
 * Action-class.
 * действие для "передачи платежей к 'PIE'(история)"
 * Creation date: (07.04.2003 18:15:45)
 * @author: Sergey Gourov
 */
public class ProcessHistoryMovePayToPieAction extends ProcessMovePayToPieAction {
/**
 * Insert the method's description here.
 * Creation date: (01.08.2003 11:20:15)
 * @return java.lang.String
 */
String getErrorMovePayToPie() {
	return "errorHistoryMovePayToPie";
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 17:09:40)
 * @return java.lang.String
 */
public String getStateForPie() {
	return "historypaystate";
}
}
