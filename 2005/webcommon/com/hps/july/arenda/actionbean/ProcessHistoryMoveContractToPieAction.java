package com.hps.july.arenda.actionbean;

/**
 * Action-class.
 * действие для "контракта(истории)"
 * Creation date: (07.04.2003 17:10:45)
 * @author: Sergey Gourov
 */
public class ProcessHistoryMoveContractToPieAction extends ProcessMoveContractToPieAction {
/**
 * Insert the method's description here.
 * Creation date: (01.08.2003 11:20:15)
 * @return java.lang.String
 */
String getErrorMoveContractToPie() {
	return "errorHistoryMoveContractToPie";
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 17:09:40)
 * @return java.lang.String
 */
public String getStateForPie() {
	return "historystate";
}
}
