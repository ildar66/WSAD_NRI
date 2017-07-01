package com.hps.july.dataimport.lib;

import com.hps.july.commonbean.*;
import org.apache.xerces.parsers.*;
import org.w3c.dom.*;
import jxl.*;
import java.util.*;
import com.hps.july.commonbean.KeyGenerator.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.io.*;
import org.xml.sax.*;
/**
   * Основной класс, производящий импорт данных
*/
public class Importer {
    private Document document;
    private Workbook workbook;
    private LoggerHandler logHandler;
    private int sessionId; //=402003;
    private int fileSize;
    public final static String ERRACTION_BreakFile = "breakfile";
    public final static String ERRACTION_NextRow = "nextrow";
    public final static String ERRACTION_NextColumn = "nextcolumn";
    private Map parameters;
//for work

public Importer(String xls_filename, byte[] b, int taskId, int operId)
    throws Exception {
    try {
        fileSize = b.length;
        java.io.ByteArrayInputStream file = new ByteArrayInputStream(b);

        String xml_file = TaskImport.xmlFile(taskId);
        workbook = Workbook.getWorkbook(file);
        prepareAll(xls_filename, workbook, xml_file, taskId, operId);

    } catch (Exception e) {
        DebugSupport.getException(e);
        throw new Exception();
    }
}
//for work
public Importer(String xls_filename, byte[] b, int taskId, int operId, Map parameters)
	throws Exception
{
	try {
		fileSize = b.length;
		java.io.ByteArrayInputStream file = new ByteArrayInputStream(b);

//		String xml_file = TaskImport.xmlFileMy(taskId);
		String xml_file = TaskImport.xmlFile(taskId);

System.out.println("Import file '"+xls_filename+"' TaskId:"+taskId+" OperId:"+operId);
System.out.println("Import file length:"+(b != null?b.length:0));
		
		workbook = Workbook.getWorkbook(file);
		prepareAll(xls_filename, workbook, xml_file, taskId, operId);

		this.parameters = parameters;
	} catch (Exception e) {
		e.printStackTrace(System.out);
		throw new Exception();
	}
}
//for testing

public Importer(String xls_filename, int taskId,int operId) throws Exception {
    try {
        
        String xml_fileName = TaskImport.xmlFileName(taskId);
        workbook = Workbook.getWorkbook(new java.io.FileInputStream(xls_filename));
        prepareAll(xls_filename, workbook, xml_fileName, taskId, operId);

    } catch (Exception e) {
        DebugSupport.getException(e);
        throw new Exception();
    }
}
private String getHandler(int sheet) {
    NodeList sheetsList = document.getElementsByTagName("worksheet");
    Element elmSheet = (Element) sheetsList.item(sheet);

    NodeList handlerList = elmSheet.getElementsByTagName("block_handler");

    if (handlerList.getLength() != 0)
        return "block_handler";

    handlerList = elmSheet.getElementsByTagName("columns_handler");

    if (handlerList.getLength() != 0)
        return "columns_handler";

    return null;
}
private int getSheetNumber(int orderInXml) {
    NodeList sheetsList = document.getElementsByTagName("worksheet");
    Element elmSheet = (Element) sheetsList.item(orderInXml);
    return Integer.parseInt(elmSheet.getAttribute("number"));
}
private int getSheets() {
    NodeList sheetsList = document.getElementsByTagName("worksheet");
    return sheetsList.getLength();
}
private boolean hasLogSettings() {
    NodeList logList = document.getElementsByTagName("log_settings");
    Element elmLog = (Element) logList.item(0);

    if (elmLog == null)
        return false;

    return true;

}
public void parse(String file)
    throws org.xml.sax.SAXException, java.io.IOException {

    byte[] bt = file.getBytes();
    ByteArrayInputStream inpStream = new ByteArrayInputStream(bt);

    DOMParser parser = new DOMParser();

    parser.parse(new InputSource(inpStream));
    document = parser.getDocument();

}
private void prepareAll(
    String xls_fileName,
    Workbook workbook,
    String xml_file,
    int taskId,
    int operId)
    throws Exception {
    try {
        this.workbook = workbook;           

        parse(xml_file); 
        if (hasLogSettings()) {

            logHandler = new LoggerHandler(document);
            logHandler.prepareLogObject("session_logger");
            
            //logHandler.setValue("id", new Integer(sessionId), "session_logger", "message.seslog");
            logHandler.setValue("operator", new Integer(operId), "session_logger", "message.seslog");
            logHandler.setValue("excelFileName", xls_fileName, "session_logger", "message.seslog");
            logHandler.setValue("excelFileSize", new Integer(fileSize), "session_logger","message.seslog.excelFileSize");
            logHandler.setValue("excelFileCreateTime", "0", "session_logger", "message.seslog");
            logHandler.setValue("importStart", "", "session_logger", "message.seslog");
            logHandler.setValue("importTask", new Integer(taskId), "session_logger", "message.seslog");
            sessionId = logHandler.getSessionId();

        }
    } catch (Exception e) {
        DebugSupport.getException(e);
        throw new Exception();
    }
}
public int process() throws Exception {

     int recCount = 0;
    int errCount = 0;
    int number = 0;
    try {
        for (int n = 0; n < getSheets(); n++) {
            number = getSheetNumber(n);

            Sheet sheet = workbook.getSheet(number - 1);
            com.hps.july.jdbcpersistence.lib.DebugSupport.printlnTest(
                "######!!!!!   DataImport process number=" + number);

            if (getHandler(n).equals("block_handler")) {
                logHandler.check("session_logger");
                BlockHandler blockHandler =
                    new BlockHandler(document, sheet, number, sessionId, parameters);
                blockHandler.setLogHandler(logHandler);
                blockHandler.process();

                recCount += blockHandler.getRecCount();
                errCount += blockHandler.getErrCount();
            }

            if (getHandler(n).equals("columns_handler")) {

                logHandler.check("session_logger", "record_logger");
                ColumnHandler colHandler = new ColumnHandler(document, sheet, number);
                colHandler.setLogHandler(logHandler);
                colHandler.process();

                recCount += colHandler.getRecCount();
                errCount += colHandler.getErrCount();
            }

        }

        if (logHandler != null) {

            logHandler.setValue(
                "recCount",
                new Integer(recCount),
                "session_logger",
                "message.seslog");
            logHandler.setValue(
                "errCount",
                new Integer(errCount),
                "session_logger",
                "message.seslog");
            logHandler.setValue("importEnd", "", "session_logger", "message.seslog.end");
            logHandler.commitLogObject("session_logger");
        }
    } catch (Exception e) {
        com.hps.july.jdbcpersistence.lib.DebugSupport.printlnTest(
            "######!!!!!error   DataImport process number=" + number);
        com.hps.july.jdbcpersistence.lib.DebugSupport.printlnError(e);
        throw e;
    }
    return logHandler.getSessionId();
}
}
