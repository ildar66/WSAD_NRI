package com.hps.july.basestation.valueobject;

/**
 * Вспомогательный класс для преобразования LAC значений в различные формы.
 */
public class LACConverter {
	private static final char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
public static String toHdx(int dec) {
	if(dec == 0) {
		return "0";
	}
	int hdxh = dec / 0x100;
	int hdxd = dec % 0x100;
	String s = "";
	s += hexChar[(hdxh / 16) % 16];
	s += hexChar[hdxh % 16];
	s += hexChar[(hdxd / 100) % 10];
	s += hexChar[(hdxd / 10) % 10];
	s += hexChar[hdxd % 10];
	return s;
}
public static String toHex(int dec) {
	return Integer.toHexString(dec).toUpperCase();
/*
	if(dec == 0) {
		return "0";
	}
	String s = "";
	while(dec > 0) {
		s = hexChar[dec % 16] + s;
		dec = dec / 16;
	}
	return s;
*/
}
}
