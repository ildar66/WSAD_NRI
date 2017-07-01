package com.hps.july.web.util;

/**
 * ����� "������� ��������" - ��� �������� �������������� �������� �� �����
 * � �������� ���.
 * Creation date: (24.04.2002 12:07:53)
 * @author: Oleg Gashnikov
 */
abstract public class TwainProperty {
	private boolean ok = true;
	
/**
 * ������� �������� ������� ������.
 * Creation date: (24.04.2002 12:11:56)
 * @param argOk boolean
 */
	abstract public boolean isEmpty();
/**
 * ������� �������� ������������ ����������� �������������.
 * Creation date: (24.04.2002 12:11:56)
 * @param argOk boolean
 */
	public boolean isOk() {
		return ok;
	}
/**
 * ��������� �������� ������������ ����������� �������������.
 * Creation date: (24.04.2002 12:11:56)
 * @param argOk boolean
 */
protected void setOk(boolean argOk) {
	ok = argOk;
	}
}
