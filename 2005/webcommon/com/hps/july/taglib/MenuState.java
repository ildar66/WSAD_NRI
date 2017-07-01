package com.hps.july.taglib;

/**
 * ��������������� ����� - ������ ��������� ����.
 * Creation date: (06.05.2002 12:55:18)
 * @author: Dmitry Dneprov
 */
public class MenuState {
	private int key;
	private int state;
/**
 * MenuState constructor.
 */
public MenuState() {
	super();
}
/**
 * MenuState constructor.
 * Creation date: (06.05.2002 12:59:38)
 * @param argKey int
 * @param argState int
 */
public MenuState(int argKey, int argState) {
	key = argKey;
	state = argState;
}
/**
 * ���������� ���� ������ ����.
 * Creation date: (06.05.2002 12:56:36)
 * @return int
 */
public int getKey() {
	return key;
}
/**
 * ���������� state, ��������������� ������ ����.
 * Creation date: (09.07.2002 13:51:52)
 * @return int
 */
public int getState() {
	return state;
}
/**
 * ������������� ���� ������ ����.
 * Creation date: (06.05.2002 12:56:36)
 * @param newKey int
 */
public void setKey(int newKey) {
	key = newKey;
}
/**
 * ������������� state, ��������������� ������ ����.
 * Creation date: (09.07.2002 13:51:52)
 * @param newState int
 */
public void setState(int newState) {
	state = newState;
}
}
