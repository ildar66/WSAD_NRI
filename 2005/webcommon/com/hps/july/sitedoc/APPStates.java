package com.hps.july.sitedoc;

/**
 * �������������� ��������� ������
 */
public interface APPStates
{
	/** ������� ����� */
	int MAIN						=	1;
	/** ����� ����� � ������� */
	int LOGIN						=	2;
	/** ����� ������ �� ������� */
	int LOGOUT						=	3;

	/** ����� ������ ���������� */
	int SiteDocListForm				=	11;
	/** ����� �������������� ��������� */
	int SiteDocForm					=	12;
	/** ����� ������ ��� �������� ��������� � �������� */
	int SiteDocPositionListForm		=	13;
	/** ����� ������ ��� �������� ��������� � ������������ */
	int SiteDocEquipmentListForm	=	14;
	/** ����� ������������� ����� � ��������� */
	int SiteDocFileForm				=	15;
	/** ����� ������ ����� ��������� */
	int SiteDocTypeListForm			=	16;
	/** ����� �������������� ���� ��������� */
	int SiteDocTypeForm				=	17;
	/** ����� ������ ��� �������� ��������� � ������ ����� */
	int SiteDocComlineListForm		=	18;

	int REGION_DOCUMENTS		=	34;
	
}
