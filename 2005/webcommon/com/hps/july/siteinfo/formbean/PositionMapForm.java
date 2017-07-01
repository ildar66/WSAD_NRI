package com.hps.july.siteinfo.formbean;

/**
 * @deprecated
 */
public class PositionMapForm extends PositionForm {
/**
 * PositionMapForm constructor comment.
 */
public PositionMapForm() {
	super();
}
public int getState() {
	System.out.println("PositionMapForm.getState()");
	return com.hps.july.siteinfo.APPStates.EDITPOSMAP;
}
}
