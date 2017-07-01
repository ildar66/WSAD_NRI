package com.hps.july.web.util;

/**
 * Action, от которого надо наследовать action в lookup. Хождение по страницам.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
 
 public class LookupBrowseAction extends BrowseAction {
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
}
