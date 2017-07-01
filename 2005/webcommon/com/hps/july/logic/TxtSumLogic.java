package com.hps.july.logic;

import java.math.*;
/**
* ��������� ������������� �����.
* Creation date: (10.11.2004 15:46:34)
* @author: Shafigullin Ildar
*/
public class TxtSumLogic {
	public final static int USD = 840;
	public final static int RUR = 810;
	public final static int EUR = 978;
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
/**
 * Insert the method's description here.
 * Creation date: (15.11.2004 12:17:14)
 * @return java.lang.String
 */
private static String getNameCurrency(long sum, int typeCurrency, boolean  higher) {
	String rubStr = String.valueOf(sum);
	char lastSymbol = rubStr.charAt(rubStr.length() - 1);
	if (sum == 0 || (sum >= 5 && sum <= 20)) {
		if (typeCurrency == USD)
			return  (higher)?"��������":"������";
		else if (typeCurrency == RUR)
			return (higher)?"������":"������";
		else if (typeCurrency == EUR)
			return (higher)?"����":"������";			
	} else {
		if (lastSymbol == '1') {
			if (typeCurrency == USD)
				return (higher)?"������":"����";
			else if (typeCurrency == RUR)
				return (higher)?"�����":"�������";
			else if (typeCurrency == EUR)
				return (higher)?"����":"����";
		} else if (lastSymbol == '0' || lastSymbol == '5' || lastSymbol == '6' || lastSymbol == '7' || lastSymbol == '8' || lastSymbol == '9') {
			if (typeCurrency == USD)
				return (higher)?"��������":"������";
			else if (typeCurrency == RUR)
				return (higher)?"������":"������";
			else if (typeCurrency == EUR)
				return (higher)?"����":"������";				
		} else if (lastSymbol == '2' || lastSymbol == '3' || lastSymbol == '4') {
			if (typeCurrency == USD)
				return (higher)?"�������":"�����";
			else if (typeCurrency == RUR)
				return (higher)?"�����":"�������";
			else if (typeCurrency == EUR)
				return (higher)?"����":"�����";				
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
private static String txtCh(BigDecimal sum, int typeCurrency,  int N, boolean fem) {
	//If Omitted(3) then d = '' else d = dp. 
	//IF OMITTED(4) THEN N=0 ELSE N = Np.                                                                                                                                                                                                                          
	//If Omitted(5) then LcFem = False Else LcFem = True. ! ���� ������� ������� �������� ���� (����� �����)

	//sum = sum1
	//Rub=int(sum)
	long rub = sum.longValue();
	//System.out.println("rub=" + rub); //temp
	/**
	IF N
	  kops#=round((sum-Rub)*10^N,1)
	  FORM=kops#
	  L#=LEN(LEFT(CLIP(FORM)))
	  IF L#<N
	     FORM=SUB('00000',1,N-L#)&FORM
	  .
	.
	*/
	long kops = Math.round((sum.doubleValue() - rub) * Math.pow(10, N));
	//System.out.println("kops=" + kops); //temp
    
	String rezStr = null;
	String d = getNameCurrency(kops, typeCurrency, false);
	String i = getNameCurrency(rub, typeCurrency, true);
	if (rub > 0) {
		if (kops != 0)
			rezStr = i  + " " + kops + " " + d;
		else
			rezStr = i;
	} else {
		rezStr = "" + kops + " " + d;
		return rezStr;
	}
	//System.out.println("rezStr=" + rezStr); //temp

	for (long p = 0, RubW = rub, Cyf = 0, CyfS = 0, RubWS = 0, RubWSS = 0, cyfss = 0; RubW > 0; p++) {
		RubW = rub / 10;
		Cyf = rub - 10 * RubW;
		rub = RubW;
		if (RubW > 0) { //    !�������� ��������� �����
			RubWS = RubW / 10;
			CyfS = RubW - 10 * RubWS;
		} else //!��������� ����� ���
			CyfS = 0;
		//System.out.println("Cyf=" + Cyf + " CyfS=" + CyfS + "     p=" + p); //temp			

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
/**
 * Insert the method's description here.
 * Creation date: (10.11.2004 16:04:57)
 */
public static String txtSum(java.math.BigDecimal sum, int typeCurrency) {
	long rub = sum.longValue();
	if (typeCurrency == USD)
		return txtCh(sum, typeCurrency, 2, false);
	else if (typeCurrency == RUR)
		return txtCh(sum, typeCurrency, 2, false);
	else if (typeCurrency == EUR)
		return txtCh(sum, typeCurrency, 2, false);		
	//I#=INSTRING(SUB(STR,1,1),"��������",1,1)
	//return(sub("��������",i#,1)&sub(str,2,200))
	else
		return "����������� ��� ������ !!!";
}
}
