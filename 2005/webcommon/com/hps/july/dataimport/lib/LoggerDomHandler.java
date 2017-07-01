package com.hps.july.dataimport.lib;

//import org.apache.xerces.parsers.*;
import org.w3c.dom.*;
import java.util.*;

/**
   * Вспомогательный класс импорта данных
*/

public class LoggerDomHandler  {
    private Document document;
/**
 * LoggerDomHandler constructor comment.
 */
public LoggerDomHandler() {
	super();
}
/**
 * LoggerDomHandler constructor comment.
 */
public LoggerDomHandler(Document doc) {
    this.document = doc;
}
public String getLoggerClassName(String tagName) {
    NodeList nl = document.getElementsByTagName(tagName);
    Element elmLogger = (Element) nl.item(0);
    return elmLogger.getAttribute("type");
}
public Properties getLoggerProperties(String tagName) {
    NodeList nl = document.getElementsByTagName(tagName);
    Element elmLogger = (Element) nl.item(0);

    NodeList recList = elmLogger.getElementsByTagName("record");
    Properties logProp = new Properties();
    for (int i = 0; i < recList.getLength(); i++) {
	    
        Element elmRec = (Element) recList.item(i);
        logProp.setProperty(
            elmRec.getAttribute("name"),
            elmRec.getAttribute("property"));
    }

    return logProp;
}
public Properties getLoggerSetMethodsData(String logName) {
    NodeList nl = document.getElementsByTagName(logName);
    Element elmLogger = (Element) nl.item(0);

    NodeList recList = elmLogger.getElementsByTagName("record");
    Properties methodsProp = new Properties();
    for (int i = 0; i < recList.getLength(); i++) {

        Element elmRec = (Element) recList.item(i);
        methodsProp.setProperty(
            elmRec.getAttribute("property"),
            elmRec.getAttribute("type"));
    }

    return methodsProp;
}
}
