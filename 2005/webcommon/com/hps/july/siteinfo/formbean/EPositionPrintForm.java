package com.hps.july.siteinfo.formbean;

/**
 * Форма печати дополнительных характеристик позиции
 * Creation date: (18.07.2002 11:50:43)
 * @author: Dmitry Dneprov
 */
public class EPositionPrintForm
	extends EPositionForm
{
/**
 * EPositionPrintForm constructor comment.
 */
public EPositionPrintForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.EPOSPRINT;
}
}
