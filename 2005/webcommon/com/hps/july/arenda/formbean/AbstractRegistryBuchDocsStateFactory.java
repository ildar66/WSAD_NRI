/*
 * Created on 25.12.2006
 *
 * AbstractStateFactory - ������������ ������ ��������� ��������� ����� ���������� ��� ��������� ��������.
 */
package com.hps.july.arenda.formbean;

import java.util.ArrayList;
import java.util.List;

import com.hps.july.arenda.valueobject.RegistryBuchDocsState;

/**
 * @author IShaffigulin
 *
 * AbstractStateFactory - ������������ ������ ��������� ��������� ����� ���������� ��� ��������� ��������.
 */
public abstract class AbstractRegistryBuchDocsStateFactory {

	//����� ���������:
	public final static String PREPARATION = "1"; //���������� �����
	public final static String SEND_PURCHASER = "4"; //���������� ���������
	public final static String EDIT_PURCHASER = "5"; //�������������� ����������
	public final static String SEND_ACCOUNTANT = "2"; //���������� ����������
	public final static String EDIT_ACCOUNTANT = "6"; //�������������� �����������
	public final static String ACCEPTED_ACCOUNTANT = "3"; //������� �������.
	public final static String SEND_INITIATOR = "7"; //������� ����������.
	public final static String ACCEPTED_INITIATOR = "8"; //������� �����������.

	//���������:
	public final static RegistryBuchDocsState PREPARATION_STATE = new RegistryBuchDocsState("���������� �����", PREPARATION);
	public final static RegistryBuchDocsState SEND_PURCHASER_STATE = new RegistryBuchDocsState("���������� ���������", SEND_PURCHASER);
	public final static RegistryBuchDocsState EDIT_PURCHASER_STATE = new RegistryBuchDocsState("��������� ����������", EDIT_PURCHASER);
	public final static RegistryBuchDocsState SEND_ACCOUNTANT_STATE = new RegistryBuchDocsState("���������� ����������", SEND_ACCOUNTANT);
	public final static RegistryBuchDocsState EDIT_ACCOUNTANT_STATE = new RegistryBuchDocsState("��������� �����������", EDIT_ACCOUNTANT);
	public final static RegistryBuchDocsState ACCEPTED_ACCOUNTANT_STATE = new RegistryBuchDocsState("������� �����������", ACCEPTED_ACCOUNTANT);
	public final static RegistryBuchDocsState SEND_INITIATOR_STATE = new RegistryBuchDocsState("������� ����������.", SEND_INITIATOR);
	public final static RegistryBuchDocsState ACCEPTED_INITIATOR_STATE = new RegistryBuchDocsState("������� �����������.", ACCEPTED_INITIATOR);

	//������ �������������:
	public final static String IG = "IG"; //������ ����������� ����������(����������).
	public final static String RG = "RG"; //������ ����������� ���������(����������, ���������).
	public final static String IRG = "IRG"; //������ IG+RG(����������+����������, ���������+����������).
	public final static String AG = "AG"; //���������(ACCOUNTANT).
	public final static String PG = "PG"; //��������(PURCHASER).

	/**
	 * ������ ��������� ��������� ����� ����������, ������� ������� �� �������� ��������� � �� ���� ������������. 
	 * @param curState
	 * @return
	 */
	public abstract List getAvailableStateList(String curState, String group);

	/**
	 * 
	 * @param hasArendaPurchaser
	 * @return
	 */
	public static AbstractRegistryBuchDocsStateFactory getFactory(boolean hasArendaPurchaser) {
		if (hasArendaPurchaser) {
			return new RegistryBuchDocsStateFactoryHasArendaPurchaser();
		} else {
			return new RegistryBuchDocsStateFactoryNoArendaPurchaser();

		}
	}

	/**
	 * 
	 * @param curState
	 * @param group
	 * @return
	 */
	protected List getErrorStateList(String curState, String group) {
		//������ ���������� ���������:
		ArrayList retList = new ArrayList();
		String errorName = "������ ����-��=" + curState + "(" + group + ") ��������� ��� ������� �������";
		retList.add(new RegistryBuchDocsState(errorName, curState));
		return retList;
	}

	/**
	 * 
	 * @param stateStr
	 * @return
	 */
	public final static RegistryBuchDocsState getState(String stateStr) {
		if (PREPARATION.equalsIgnoreCase(stateStr)) {
			return PREPARATION_STATE;
		} else if (SEND_PURCHASER.equalsIgnoreCase(stateStr)) {
			return SEND_PURCHASER_STATE;
		} else if (EDIT_PURCHASER.equalsIgnoreCase(stateStr)) {
			return EDIT_PURCHASER_STATE;
		} else if (SEND_ACCOUNTANT.equalsIgnoreCase(stateStr)) {
			return SEND_ACCOUNTANT_STATE;
		} else if (EDIT_ACCOUNTANT.equalsIgnoreCase(stateStr)) {
			return EDIT_ACCOUNTANT_STATE;
		} else if (ACCEPTED_ACCOUNTANT.equalsIgnoreCase(stateStr)) {
			return ACCEPTED_ACCOUNTANT_STATE;
		} else if (SEND_INITIATOR.equalsIgnoreCase(stateStr)) {
			return SEND_INITIATOR_STATE;
		} else if (ACCEPTED_INITIATOR.equalsIgnoreCase(stateStr)) {
			return ACCEPTED_INITIATOR_STATE;
		} else {
			return null;
		}

	}

}
