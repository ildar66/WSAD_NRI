package com.hps.july.inventory.valueobject;

import java.io.*;
import java.util.*;

/**
 * Парсер INV файлов
 *
 * INV файл представляет из себя текстовый файл с результатами опроса оборудования
 * на выходе парсер выдаёт список элементов типа String[]
 * Где
 *  [0] - Мнемоническое обозначение оборудования
 *  [1] - Серийный номер оборудования
 *  [2] - Номер производителя
 *  [3] - Посадочное место
 *  [4] - Номер строки файла описывающей оборудование
 *
 * С помощью метода isErrors() возможна проверка на существование ошибок
 * опроса оборудования или ошибок парсера
 * Список ошибок можно получить с помощью метода getErrors()
 * Где
 *  [0] - Номер строки с ошибкой
 *  [1] - Строка вызвавшая ошибку
 */
public class INVParser {
	private boolean errors = false;
	private boolean gothead = false;
	private Vector data = new Vector(); // array of Strings[4]
	private Vector errlist = new Vector(); // array of Strings[2]
	private String headMnemonic = null;
	private String headSerialnumber = null;
	private String headManucode = null;
	private int sid = 0;
	private String bts = null;
	private String bsc = null;
	private int lineCnt = 0;
public INVParser(InputStream stream) {
	try {
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		parse(in);
	} catch(Exception e) {
		errors = true;
		e.printStackTrace();
	}
}
public INVParser(String filename) {
	try {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		parse(in);
	} catch(Exception e) {
		errors = true;
		e.printStackTrace();
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBsc() {
	return bsc;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBts() {
	return bts;
}
/**
 * 
 * @return java.util.Vector
 */
public java.util.Vector getData() {
	return data;
}
public Vector getErrors() {
	return errlist;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHeadManucode() {
	return headManucode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHeadMnemonic() {
	return headMnemonic;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHeadSerialnumber() {
	return headSerialnumber;
}
public int getSid() {
	return sid;
}
/**
 * 
 * @return boolean
 */
public boolean isErrors() {
	return errors;
}
/**
 * 
 * @return boolean
 */
public boolean isGothead() {
	return gothead;
}
private void parse(BufferedReader in)
	throws Exception
{
	String line;
	try {
		sid = 0;
		boolean repeate = true;
		lineCnt = 0;
		while(repeate) {
			line = in.readLine();
			lineCnt++;
			if(line == null || line.startsWith("E")) {
				break;
			}
			if(line.length() < 1) {
				continue;
			}
			char fchar = (char)line.charAt(0);
			switch(fchar) {
			case 'C':
				parseComment(line);
				break;
			case '1':
				if(!gothead) {
					parseHead(line);
				} else {
					parseBlock(line);
				}
				break;
			case '2':
			case '3':
				parseBlock(line);
				break;
			default:
			}
		}
	} finally {
		in.close();
	}
}
private void parseBlock(String line) {
	if(line.length() < 107) {
		errors = true;
		return;
	}
	//String[] bp = new String[]; // MNEMONIC, SERIAL, MANUCODE, PLACE;
	String mnemonic = trimnull(line.substring(48,55));
	String serialnumber = trimnull(line.substring(72,83));
	String manucode = trimnull(line.substring(88,107));
	String place = "R"+trimnull(line.substring(29,33))+"Sh"+trimnull(line.substring(36,40))+"Sl"+trimnull(line.substring(42,46));
	data.add(new String[] {mnemonic, serialnumber, removeWhiteSpaces(manucode), place, ""+lineCnt });
}
private void parseComment(String line) {
	if(line.toUpperCase().startsWith("C-ERR")) {
		errors = true;
		errlist.add(new String[] { ""+lineCnt, trimnull(line.substring(5,line.length())) });
	} else if(
		line.startsWith("C-OrderData-Comments") ||
		line.startsWith("C-OrderData-Location")
	) {
		// find SID and BSC or BTS
		String sids = null;
		int sidi = line.indexOf("SID");
		if(sidi > 0) {
			int btsi = line.indexOf("BTS");
			int bsci = line.indexOf("BSC");
			if(btsi > 0) {
				sids = trimnull(line.substring(sidi+3,btsi-1));
				bts = trimnull(line.substring(btsi+3,line.length()));
			}
			if(bsci > 0) {
				sids = trimnull(line.substring(sidi+3,bsci-1));
				bts = trimnull(line.substring(bsci+3,line.length()));
			}
			if(sid <= 0) {
				try {
					sid = Integer.parseInt(sids);
				} catch(Exception e) {
					sid = 0;
				}
			}
		}
	}
}
private void parseHead(String line) {
	if(line.length() < 107) {
		errors = true;
		return;
	}
	headMnemonic = trimnull(line.substring(48,55));
	headSerialnumber = trimnull(line.substring(72,83));
	headManucode = removeWhiteSpaces(trimnull(line.substring(88,107)));
	gothead = true;
}
private String removeWhiteSpaces(String str) {
	if(str == null || str.length() < 1) {
		return "";
	}
	char[] chars = str.toCharArray();
	StringBuffer sb = new StringBuffer();
	for(int i = 0; i < chars.length; i++) {
		if(
			(chars[i] >= '0' && chars[i] <= '9') ||
			(chars[i] >= 'A' && chars[i] <= 'Z') ||
			(chars[i] >= 'a' && chars[i] <= 'z')
		) {
			sb.append(chars[i]);
		}
	}
	return sb.toString();
}
/**
 * 
 * @param newBsc java.lang.String
 */
public void setBsc(java.lang.String newBsc) {
	bsc = newBsc;
}
/**
 * 
 * @param newBts java.lang.String
 */
public void setBts(java.lang.String newBts) {
	bts = newBts;
}
/**
 * 
 * @param newData java.util.Vector
 */
public void setData(java.util.Vector newData) {
	data = newData;
}
/**
 * 
 * @param newErrors boolean
 */
public void setErrors(boolean newErrors) {
	errors = newErrors;
}
/**
 * 
 * @param newGothead boolean
 */
public void setGothead(boolean newGothead) {
	gothead = newGothead;
}
/**
 * 
 * @param newHeadManucode java.lang.String
 */
public void setHeadManucode(java.lang.String newHeadManucode) {
	headManucode = newHeadManucode;
}
/**
 * 
 * @param newHeadMnemonic java.lang.String
 */
public void setHeadMnemonic(java.lang.String newHeadMnemonic) {
	headMnemonic = newHeadMnemonic;
}
/**
 * 
 * @param newHeadSerialnumber java.lang.String
 */
public void setHeadSerialnumber(java.lang.String newHeadSerialnumber) {
	headSerialnumber = newHeadSerialnumber;
}
public void setSid(int newSid) {
	sid = newSid;
}
private String trimnull(String str) {
	if(str == null) {
		return "";
	} else {
		return str.trim();
	}
}
}
