package com.hps.july.arenda.actionbean;

/**
 * Action-class.
 * действие дл€ "истории  онтракты-регламенты."
 * Creation date: (09.12.2002 10:26:00)
 * @author: Sergey Gourov
 */
public class FromHistoryCopyReglamentProcessAction extends CopyReglamentProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 10:24:26)
 * @return java.lang.String
 */
protected String getWhereForm() {
	return "FromHistory";
}
}
