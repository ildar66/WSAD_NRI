package com.hps.july.basestation.valueobject;

/**
 * ������. ������������ �� ���� ����� ������������ �������� � �����
 * � ��� �� ������ �������� ���� �������
 * � ������ ���������� �������������� ������ ��� ���������
 *
 * ������ ������ �������� ���� ������� ������������� ��� ���������� � �����
 * � �� ����� ���������� ����� ������ ��� ����������� � �����
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
