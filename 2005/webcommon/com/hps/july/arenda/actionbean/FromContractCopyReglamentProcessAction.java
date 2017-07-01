package com.hps.july.arenda.actionbean;

/**
 * Action-class.
 * действие для "Контракты-регламенты."
 * Creation date: (09.12.2002 10:21:50)
 * @author: Sergey Gourov
 */
public class FromContractCopyReglamentProcessAction extends CopyReglamentProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 10:24:26)
 * @return java.lang.String
 */
protected String getWhereForm() {
	return "FromContract";
}
}
