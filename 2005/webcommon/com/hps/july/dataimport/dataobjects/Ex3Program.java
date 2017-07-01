package com.hps.july.dataimport.dataobjects;

import com.hps.july.siteinfo.valueobject.Position;
import java.util.*;
import com.hps.july.dataimport.lib.*;
//import com.hps.july.dataimport.beans.DataImportAccessBean;

/**
  * Класс для тестирования импорта данных
*/
public class Ex3Program {
public static void main(java.lang.String[] args) throws Exception {

    //process1();
     process3();

}
public static int process1() throws Exception {

    //Importer imr = new Importer("EMS0.xls", "chanalPower2Wte.xml", 3046900, 21003);
    // Importer imr = new Importer("Libr4b.xls", "chanalPower3a.xml",40002,2);

    java.io.File file = new java.io.File("c:\\Development\\Excel_Test\\sun_basestation.xls");
     //java.io.File file = new java.io.File("c:\\Development\\test.xls");
    long l = file.length();
    byte[] bt = new byte[new Long(l).intValue()];
    java.io.FileInputStream fInpstream = new java.io.FileInputStream(file);
     int res = fInpstream.read(bt);

    Importer imr = new Importer("sun_basestation.xls", bt, 1, 72);
    return imr.process();

    // System.out.println("\n" + i);
    

}
public static int process3() throws Exception {

    //Importer imr = new Importer("EMS0.xls", "chanalPower2Wte.xml", 3046900, 21003);
    // Importer imr = new Importer("Libr4b.xls", "chanalPower3a.xml",40002,2);

    Hashtable params = new Hashtable();
    params.put(BsBlockHandler.KEY_REGION, new Integer(52));
//    params.put(BsBlockHandler.KEY_PLANSTATE, Position.PLANSTATE_CHECK_Fact);

    java.io.File file = new java.io.File("c:\\Development\\Excel\\test_one.xls");
    //java.io.File file = new java.io.File("c:\\Development\\test.xls");
    long l = file.length();
    byte[] bt = new byte[new Long(l).intValue()];
    java.io.FileInputStream fInpstream = new java.io.FileInputStream(file);
    int res = fInpstream.read(bt);

    //DataImportAccessBean bean=new DataImportAccessBean();
    //return bean.processBs("BsImport.xls", bt, 3, 1,params);
    Importer imr = new Importer("test_one.xls", bt, 3, 1,params);
    return imr.process();

    // System.out.println("\n" + i);

}
}
