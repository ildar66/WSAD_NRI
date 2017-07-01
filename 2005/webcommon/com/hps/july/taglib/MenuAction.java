package com.hps.july.taglib;

/**
 * Вспомогательный класс для действий меню.
 * Creation date: (06.05.2002 12:55:18)
 * @author: Dmitry Dneprov
 */
public class MenuAction {
	private int key;
	private java.lang.String action;
	private java.lang.String target = "0";
	private java.lang.String windowName = "newWindowObj";
/**
 * MenuAction constructor.
 */
public MenuAction() {
	super();
}
/**
 * MenuAction constructor.
 * Creation date: (06.05.2002 12:59:38)
 * @param argKey int
 * @param argAction java.lang.String
 */
public MenuAction(int argKey, String argAction) {
	key = argKey;
	action = argAction;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 13:02:20)
 * @param argKey int
 * @param argAction java.lang.String
 * @param target java.lang.String
 */
public MenuAction(int argKey, String argAction, String target) {
	key = argKey;
	action = argAction;
	this.target = target;
}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.10.2004 16:42:16)
	 * @param argKey int
	 * @param argAction java.lang.String
	 * @param target java.lang.String
	 * @param wn java.lang.String
	 */
	public MenuAction(int argKey, String argAction, String target, String wn) {
		key = argKey;
		action = argAction;
		this.target = target;
		this.windowName = wn;
	}
/**
 * Получить текущее действие пункта меню.
 * Creation date: (06.05.2002 12:56:51)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * Возвращает ключ пункта меню.
 * Creation date: (06.05.2002 12:56:36)
 * @return int
 */
public int getKey() {
	return key;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:59:23)
 * @return java.lang.String
 */
public java.lang.String getTarget() {
	return target;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 16:43:32)
 * @return java.lang.String
 */
public java.lang.String getWindowName() {
	return windowName;
}
/**
 * Устанавливает действие пункта меню.
 * Creation date: (06.05.2002 12:56:51)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * Устанавливает ключ пункта меню.
 * Creation date: (06.05.2002 12:56:36)
 * @param newKey int
 */
public void setKey(int newKey) {
	key = newKey;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:59:23)
 * @param newTarget java.lang.String
 */
public void setTarget(java.lang.String newTarget) {
	target = newTarget;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 16:43:32)
 * @param newWindowName java.lang.String
 */
public void setWindowName(java.lang.String newWindowName) {
	windowName = newWindowName;
}
}
