package com.hps.july.dictionary.formbean;

import org.apache.struts.action.*;

/**
 * Форма ввода и редактирования организации
 */
public class OrganizationFormM
	extends AbstractOrganizationForm
{
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITORGM;
}
}
