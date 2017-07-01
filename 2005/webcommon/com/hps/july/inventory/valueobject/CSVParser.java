package com.hps.july.inventory.valueobject;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.upload.*;
import java.io.*;

/**
 * Служебный класс - парсер CSV файлов.
 * CSV файлы являются текстовыми с данными разделёнными запятой
 * CSVParser преобразовывает указанный файл в список элементов типа String[]
 * Где элемент
 *  [0] - Код производителя
 *  [1] - Серийный номер устройства
 *  [2] - Коментарий
 *
 * Преобразованные данные можно получить с помошью метода getData()
 */
public class CSVParser {
	private int document;
	private boolean checkManufacturerCode;
	private Vector data;
	private FormFile dataFile;
public CSVParser(int document, FormFile file, boolean checkManucode) {
	this.checkManufacturerCode = checkManucode;
	this.dataFile = file;
	this.document = document;
}
/**
 * 
 * @return java.util.Vector
 */
public java.util.Vector getData() {
	return data;
}
/**
 * 
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getDataFile() {
	return dataFile;
}
/**
 * 
 * @return int
 */
public int getDocument() {
	return document;
}
/**
 * 
 * @return boolean
 */
public boolean isCheckManufacturerCode() {
	return checkManufacturerCode;
}
public void parseFile()
	throws Exception
{
	if(data == null) { data = new Vector(); } else { data.clear(); }
	if(dataFile == null) throw new Exception();
	try {
		Reader r = new BufferedReader(new InputStreamReader(dataFile.getInputStream()));
		StreamTokenizer st = new StreamTokenizer(r);
		st.resetSyntax();
		st.eolIsSignificant(true);
		st.wordChars((int)' ',(int)'!');
		st.wordChars((int)'#',(int)'+');
		st.wordChars((int)'<',(int)'?');
		st.wordChars((int)'-',(int)'/');
		st.wordChars((int)'0',(int)'9');
		st.wordChars((int)'a',(int)'z');
		st.wordChars((int)'A',(int)'Z');
		st.wordChars(0x00A0,0x00FF);
		st.quoteChar('"');
		st.quoteChar('\'');

		try {
			int token;
			int arr = 0;
			String[] arrval = new String[3];
			boolean parsing = true;
			while(parsing) {
				token = st.nextToken();
				switch(token) {
					case 34: // "
					case 39: // '
					case StreamTokenizer.TT_WORD:
						if(arr < 3 && arrval[arr] == null && st.sval != null) {
							arrval[arr] = st.sval.trim();
						}
					break;
					case StreamTokenizer.TT_EOL:
					case StreamTokenizer.TT_EOF:
						arr++;
						data.add(arrval);
						arrval = new String[3];
						if(arr > 2) {
							arr = 0;
						}
						if(StreamTokenizer.TT_EOF == token) {
							parsing = false;
						}
					break;
					default: // any ordinary char
						arr++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		r.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
/**
 * 
 * @param newCheckManufacturerCode boolean
 */
public void setCheckManufacturerCode(boolean newCheckManufacturerCode) {
	checkManufacturerCode = newCheckManufacturerCode;
}
/**
 * 
 * @param newDataFile org.apache.struts.upload.FormFile
 */
public void setDataFile(org.apache.struts.upload.FormFile newDataFile) {
	dataFile = newDataFile;
}
/**
 * 
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
public void upload(ActionErrors errors)
	throws ValidationException
{
}
}
