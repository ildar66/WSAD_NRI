package com.hps.july.inventory.formbean;

/**
 * Заполнение позиции акта инвентаризации у работника по БД.
 * Creation date: (07.06.2005 10:08:49)
 * @author: Dmitry Dneprov
 */
public class WorkerInvActFillFromDBForm extends InvActFillFromDBForm {
/**
 * WorkerInvActFillFromDBForm constructor comment.
 */
public WorkerInvActFillFromDBForm() {
	super();
}
public int getState() {
	return com.hps.july.inventory.APPStates.WRKINVFILLDB ;
}
}
