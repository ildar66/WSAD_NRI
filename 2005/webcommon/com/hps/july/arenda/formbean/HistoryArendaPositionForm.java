package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "история позиций аренды".
 * Creation date: (08.08.2002 10:01:41)
 * @author: Sergey Gourov
 */
public class HistoryArendaPositionForm extends ArendaPositionForm {
/**
 * HistoryArendaPositionForm constructor comment.
 */
public HistoryArendaPositionForm() {
	super();
	listForm = "HistoryArendaPositionsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 9:47:19)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_ARENDA_POS_EDIT;
}
}
