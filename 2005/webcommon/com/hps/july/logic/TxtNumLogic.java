package com.hps.july.logic;

import java.math.*;
/**
* ��������� ������������� �����.
* Creation date: (10.11.2004 15:46:34)
* @author: Shafigullin Ildar
*/
public class TxtNumLogic {
	public final static java.lang.String[] m1 = { "������", "�����������", "����������", "����������", "������������", "����������", "�����������", "����������", "������������", "������������" };
	public final static java.lang.String[] m2 = { "", "����", "���", "���", "������", "����", "�����", "����", "������", "������" };
	public final static java.lang.String[] m3 = { "", "����", "���", "���", "������", "����", "�����", "����", "������", "������" };
	public final static java.lang.String[] m4 = { "", "", "��������", "��������", "�����", "���������", "����������", "���������", "�����������", "���������" };
	public final static java.lang.String[] m5 = { "", "���", "������", "������", "���������", "�������", "��������", "�������", "���������", "���������" };
/**
 * cyfstr - �������������� ����� � ��������� �������������
 * p           int    * ������� �����
 * cyf         int    * ������� �����
 * cyfS        int    * ��������� �����
 * fem         boolean  * False-������� ���, True-�������
 * Creation date: (10.11.2004 17:57:57)
 * @return java.lang.string
 */
private static String cyfstr(int p, int cyf, int cyfS, boolean fem) {
	String str = "";
	//case p
	//of 0 orof 3 orof 6 orof 9 orof 12 orof 15
	if (p == 0 || p == 3 || p == 6 || p == 9 || p == 12 || p == 15) {
		if (cyfS == 1) {
			//execute Cyf+1
			str = m1[cyf];
		} else {
			//case p
			//of 3 ! p=3
			if (p == 3) {
				//execute Cyf+1
				str = m2[cyf];
			} else {
				//Execute Cyf+1
				str = m3[cyf];
				//If Fem then 
				if (fem) {
					//Execute Cyf+1
					switch (cyf) {
						case 0 :
							str = "";
							break;
						case 1 :
							str = "����";
							break;
						case 2 :
							str = "���";
							break;
					}
				}
			}
		}
		String str1 = "";
		//case p
		//  of 3
		if (p == 3) {
			if (cyfS == 1)
				str1 = "�����";
			else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "������";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "������";
				else
					str1 = "�����";
			}
		}
		//  of 6
		else if (p == 6) {
			if (cyfS == 1)
				str1 = "���������";
			else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "�������";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "��������";
				else
					str1 = "���������";
			}
		}
		//  of 9
		else if (p == 9) {
			if (cyfS == 1) {
				str1 = "����������";
			} else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "��������";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "���������";
				else
					str1 = "����������";
			}
		}
		//  of 12
		else if (p == 12) {
			if (cyfS == 1)
				str1 = "����������";
			else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "��������";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "���������";
				else
					str1 = "����������";
			}
		}
		//str = clip(str) & " " & str1;
		if (!str1.equals(""))
			str = str + " " + str1;
	}
	//of 1 orof 4 orof 7 orof 10 orof 13
	else if (p == 1 || p == 4 || p == 7 || p == 10 || p == 13) {
		//execute Cyf+1
		str = m4[cyf];
	}
	//of 2 orof 5 orof 8 orof 11 orof 14
	else if (p == 2 || p == 5 || p == 8 || p == 11 || p == 14) {
		//execute Cyf+1
		str = m5[cyf];
	}
	return str;
}
public static String getSuffix(long sum, String suffix) {
	long mod = sum % 10;
	String rubStr = String.valueOf(sum);
	char lastSymbol = rubStr.charAt(rubStr.length() - 1);
	if (sum == 0 || (sum >= 5 && sum <= 20)) {
		return suffix + "��";
	} else {
		if (mod == 1) {
			return suffix;
		} else if (mod == 0 || mod == 5 || mod == 6 || mod == 7 || mod == 8 || mod == 9) {
			return suffix + "��";
		} else if (mod == 2 || mod == 3 || mod == 4) {
			return suffix + "�";
		}

	}
	return "����������� ������ !!!";
}
/**
 * Txtch �/��������� �������������� ����� � �����
 * Txtch      function(Sum,i,d,Fem)
 * Sum  - �����
 * i    - �������� ������� �����-�, ������� ����� ����� ����� (����., '��.')
 * d    - �������� ������� �����-�, ������� ����� ������� ����� (����., '��.')
 * N    - ��� �������������� ������� �����
 * Fem  - ������� ��� ������� ��������� �������� ���� (����. �����)
 * Creation date: (11.11.2004 11:45:11)
 * @return java.lang.String
 * @param sum java.math.BigDecimal
 * @param i java.lang.String
 * @param d java.lang.String
 * @param fem boolean
 */
private static String txtCh(long sum, String suffix, boolean fem) {
	String rezStr = getSuffix(sum,suffix);
	long rub = sum;
	
	for (long p = 0, RubW = sum, Cyf = 0, CyfS = 0, RubWS = 0, RubWSS = 0, cyfss = 0; RubW > 0; p++) {
		RubW = rub / 10;
		Cyf = rub - 10 * RubW;
		rub = RubW;
		if (RubW > 0) { //    !�������� ��������� �����
			RubWS = RubW / 10;
			CyfS = RubW - 10 * RubWS;
		} else { //!��������� ����� ���
			CyfS = 0;
		}

		//   !������ ��� ����� � �������
		if (p == 3 || p == 6 || p == 9 || p == 12)
			//!������ ��� ����� ����� - ����
			if (Cyf == 0 && CyfS == 0) {
				if (RubWS > 0) { // !������ ����� ����� ����
					RubWSS = RubWS / 10;
					cyfss = RubWS - 10 * RubWSS; //   !������ �����
				} else
					cyfss = 0;
				if (cyfss == 0) { //!������ ����� ����� ���� ���� !!!!
					p += 2; //       !����� �� ��������
					rub = RubWSS;
					//cycle
					continue;
				}
			}

		//If Len(clip(CyfStr(P,Cyf,CyfS,LcFem)))>0 then
		//  RezStr = clip(CyfStr(P,Cyf,CyfS,LcFem))&' '&RezStr
		String str = cyfstr((int) p, (int) Cyf, (int) CyfS, fem);
		if (!str.equals(""))
			rezStr = str + " " + rezStr;
		// P += 1
		//END
	}
	return rezStr;

}
public static String txtNum(long sum, String suffix) {
	return txtCh(sum, suffix, false);
}
}
