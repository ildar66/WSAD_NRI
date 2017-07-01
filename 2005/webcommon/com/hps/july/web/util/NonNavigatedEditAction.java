package com.hps.july.web.util;

/**
 * Класс ведет себя также как родитель, толко без добавления в навигатор.
 * Creation date: (18.03.2004 18:13:44)
 * @author: Dmitry Dneprov
 */
public class NonNavigatedEditAction extends AbstractEditAction {
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
}
