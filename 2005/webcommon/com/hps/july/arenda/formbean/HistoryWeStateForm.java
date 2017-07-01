package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "История состояний дог."
 * Creation date: (07.08.2002 10:28:02)
 * @author: Sergey Gourov
 */
public class HistoryWeStateForm extends WeStateForm {
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 17:00:15)
 */
public HistoryWeStateForm() {
	forMove2pie = "historystate";
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2002 10:28:02)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_STATE_WEARENDA_EDIT;
}
}
