package com.hps.july.logic;

import java.math.*;
/**
* “екстовое представление суммы.
* Creation date: (10.11.2004 15:46:34)
* @author: Shafigullin Ildar
*/
public class TxtNumLogic {
	public final static java.lang.String[] m1 = { "дес€ть", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "п€тнадцать", "шестнадцать", "семнадцать", "восемнадцать", "дев€тнадцать" };
	public final static java.lang.String[] m2 = { "", "одна", "две", "три", "четыре", "п€ть", "шесть", "семь", "восемь", "дев€ть" };
	public final static java.lang.String[] m3 = { "", "один", "два", "три", "четыре", "п€ть", "шесть", "семь", "восемь", "дев€ть" };
	public final static java.lang.String[] m4 = { "", "", "двадцать", "тридцать", "сорок", "п€тьдес€т", "шестьдес€т", "семьдес€т", "восемьдес€т", "дев€носто" };
	public final static java.lang.String[] m5 = { "", "сто", "двести", "триста", "четыреста", "п€тьсот", "шестьсот", "семьсот", "восемьсот", "дев€тьсот" };
/**
 * cyfstr - ѕреобразование цифры в прописное представление
 * p           int    * пор€док числа
 * cyf         int    * текуща€ цифра
 * cyfS        int    * следующа€ цифра
 * fem         boolean  * False-мужской род, True-женский
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
							str = "одна";
							break;
						case 2 :
							str = "две";
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
				str1 = "тыс€ч";
			else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "тыс€ча";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "тыс€чи";
				else
					str1 = "тыс€ч";
			}
		}
		//  of 6
		else if (p == 6) {
			if (cyfS == 1)
				str1 = "миллионов";
			else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "миллион";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "миллиона";
				else
					str1 = "миллионов";
			}
		}
		//  of 9
		else if (p == 9) {
			if (cyfS == 1) {
				str1 = "миллиардов";
			} else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "миллиард";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "миллиарда";
				else
					str1 = "миллиардов";
			}
		}
		//  of 12
		else if (p == 12) {
			if (cyfS == 1)
				str1 = "триллионов";
			else {
				//case cyf
				// of 1
				if (cyf == 1)
					str1 = "триллион";
				// of 2 orof 3 orof 4
				else if (cyf == 2 || cyf == 3 || cyf == 4)
					str1 = "триллиона";
				else
					str1 = "триллионов";
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
		return suffix + "ов";
	} else {
		if (mod == 1) {
			return suffix;
		} else if (mod == 0 || mod == 5 || mod == 6 || mod == 7 || mod == 8 || mod == 9) {
			return suffix + "ов";
		} else if (mod == 2 || mod == 3 || mod == 4) {
			return suffix + "а";
		}

	}
	return "неизвестна€ валюта !!!";
}
/**
 * Txtch п/программа преобразовани€ числа в текст
 * Txtch      function(Sum,i,d,Fem)
 * Sum  - число
 * i    - название единицы измер-€, клипуем после целой части (напр., 'кг.')
 * d    - название единицы измер-€, клипуем после дробной части (напр., 'гр.')
 * N    - ƒл€ форматировани€ дробной части
 * Fem  - ѕризнак что единица измерени€ женского рода (напр. штуки)
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
		if (RubW > 0) { //    !значение следующей цифры
			RubWS = RubW / 10;
			CyfS = RubW - 10 * RubWS;
		} else { //!следующей цифры нет
			CyfS = 0;
		}

		//   !только дл€ тыс€ч и лимонов
		if (p == 3 || p == 6 || p == 9 || p == 12)
			//!первые две цифры тыс€ч - нули
			if (Cyf == 0 && CyfS == 0) {
				if (RubWS > 0) { // !треть€ цифра может быть
					RubWSS = RubWS / 10;
					cyfss = RubWS - 10 * RubWSS; //   !треть€ цифра
				} else
					cyfss = 0;
				if (cyfss == 0) { //!треть€ цифра тыс€ч тоже ноль !!!!
					p += 2; //       !выход на миллионы
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
