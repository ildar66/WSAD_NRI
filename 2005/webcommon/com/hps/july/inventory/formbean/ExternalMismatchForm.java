package com.hps.july.inventory.formbean;

/**
 * ����� ����� � ��������� ���� ��������������� �������������� �
 * ��������� "������� ��������� �����".
 * ����� ���������� �� ������ ���������� "������� ��������� ������"
 */
public class ExternalMismatchForm
	extends MismatchForm
{
/**
 * ExternalMismatchForm constructor comment.
 */
public ExternalMismatchForm() {
	super();
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEOM;
}
}
