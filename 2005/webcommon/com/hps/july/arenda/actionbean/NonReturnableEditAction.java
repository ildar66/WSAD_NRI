package com.hps.july.arenda.actionbean;

/**
 * Action-class.
 * специализированное действие
 */
 public class NonReturnableEditAction
	extends com.hps.july.web.util.AbstractEditAction
{
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
public boolean isReturnable() {
	return false;
}
}
