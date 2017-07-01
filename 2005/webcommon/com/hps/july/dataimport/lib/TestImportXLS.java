package com.hps.july.dataimport.lib;

import java.rmi.*;
import java.util.*;
import java.io.*;
import org.apache.xerces.parsers.*;
import org.w3c.dom.*;
import jxl.*;

/**
 * Класс для тестирования импорта данных.
 * Creation date: (11.04.2003 13:20:10)
 * @author: Alexander Shrago
 */
public class TestImportXLS {
public static void main(String[] args)
{
    try {
	    File f = new File("c:\\test.xls");
	    int l = (int)f.length();
	    byte[] b = new byte[l];
		FileInputStream is = new FileInputStream(f);
		is.read(b);
		Importer importer = new Importer("test.xls", b, 3, 1);
		//System.out.println(importer.process());
		System.out.println("OK!!!!!!!!");
    } catch (Exception e) {
		System.out.println("from DataImportBean process");
		e.printStackTrace(System.out);
    }

/*	try {
		WorkbookSettings ws = new WorkbookSettings();
		FileInputStream is = new FileInputStream("d:/temp/LoadData/book2.xls");
		jxl.read.biff.File dataFile = new jxl.read.biff.File(is, ws);
		dataFile.close();
		Workbook workbook = Workbook.getWorkbook(is);
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
*/
}
}
