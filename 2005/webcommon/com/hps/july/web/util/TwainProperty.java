package com.hps.july.web.util;

/**
 *  ласс "двойное свойство" - дл€ удобного преобразовани€ значений из строк
 * в заданный тип.
 * Creation date: (24.04.2002 12:07:53)
 * @author: Oleg Gashnikov
 */
abstract public class TwainProperty {
	private boolean ok = true;
	
/**
 * ¬озврат признака наличи€ данных.
 * Creation date: (24.04.2002 12:11:56)
 * @param argOk boolean
 */
	abstract public boolean isEmpty();
/**
 * ¬озврат признака корректности внутреннего представлени€.
 * Creation date: (24.04.2002 12:11:56)
 * @param argOk boolean
 */
	public boolean isOk() {
		return ok;
	}
/**
 * ”становка признака корректности внутреннего представлени€.
 * Creation date: (24.04.2002 12:11:56)
 * @param argOk boolean
 */
protected void setOk(boolean argOk) {
	ok = argOk;
	}
}
