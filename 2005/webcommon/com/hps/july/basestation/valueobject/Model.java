package com.hps.july.basestation.valueobject;

/**
 * ћодель. ѕредставл€ет из себ€ класс группирующий свойства в форме
 * а так же методы проверки этик свойств
 * и метода обновлени€ дополнительных данных дл€ просмотра
 *
 * ќбычно модель содержит ключ который редактируетс€ или выбираетс€ в форме
 * и по ключу происходит поиск данных дл€ отображени€ в форме
 */
public abstract class Model {
	private boolean formatError;
	private boolean notExist;
	private boolean empty;
public boolean isEmpty() {
	return empty;
}
public boolean isFormatError() {
	return formatError;
}
public boolean isNotExist() {
	return notExist;
}
protected void setEmpty(boolean newEmpty) {
	empty = newEmpty;
}
protected void setFormatError(boolean newFormatError) {
	formatError = newFormatError;
}
protected void setNotExist(boolean newNotExist) {
	notExist = newNotExist;
}
}
