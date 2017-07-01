package com.hps.july.inventory.formbean;

/**
 * Форма ввода и просмотра акта рассогласования прикрепляемого к
 * документу "Внешний приходный ордер".
 * Форма вызывается из списка документов "Внешние приходные ордера"
 */
public class ExternalMismatchForm
	extends MismatchForm
{
/**
 * ExternalMismatchForm constructor comment.
 */
public ExternalMismatchForm() {
	super();
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEOM;
}
}
