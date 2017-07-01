package com.hps.july.dataimport.lib;

import java.util.*;
import java.io.*;
import org.xml.sax.*;
import org.apache.xerces.parsers.*;
import org.w3c.dom.*;
import org.apache.struts.util.*;
import java.lang.reflect.Constructor;

/**
  * Обработчик XML данных типа DOM
*/
public class DOMHandler {

    private Element elmSheet;
//   private org.w3c.dom.Document document;

public DOMHandler(Document doc, int sheetNum) {

    NodeList sheetsList = doc.getElementsByTagName("worksheet");

    for (int i = 0; i < sheetsList.getLength(); i++) {

        Element elmSheetI = (Element) sheetsList.item(i);
        int numI = Integer.parseInt(elmSheetI.getAttribute("number"));

        if (numI == sheetNum) {
            elmSheet = elmSheetI;
            return;
        }
    }
}
private String[] getActionArgNames(String actionName)
    throws ClassNotFoundException {

    Element elmObj = getElementObject();

    NodeList acs = elmObj.getElementsByTagName(actionName);
    Element elmAction = (Element) acs.item(0);

    NodeList argList = elmAction.getElementsByTagName("argument");

    String[] names = new String[argList.getLength()];

    for (int i = 0; i < argList.getLength(); i++) {
        Element elmArg = (Element) argList.item(i);
        names[i] = elmArg.getAttribute("parameter");

    }

    return names;

}
private Class[] getActionArgTypes(String actionName)
    throws ClassNotFoundException {

    Element elmObj = getElementObject();

    NodeList acs = elmObj.getElementsByTagName(actionName);
    Element elmAction = (Element) acs.item(0);

    NodeList argList = elmAction.getElementsByTagName("argument");

    Class[] classes = new Class[argList.getLength()];

    for (int i = 0; i < argList.getLength(); i++) {
        Element elmArg = (Element) argList.item(i);
        String paramName = elmArg.getAttribute("parameter");
        classes[i] = getParameterType(paramName);

    }

    return classes;

}
private String getActionName( String actionName) {
    Element elmObj = getElementObject();
    NodeList ac = elmObj.getElementsByTagName(actionName);
    Element elmAction = (Element)ac.item(0);
    
    return elmAction.getAttribute("name");
}
public String[] getConstructorArgNames() throws ClassNotFoundException {

    return getActionArgNames("constructor");
}
public Class[] getConstructorArgTypes() throws ClassNotFoundException {

    return getActionArgTypes("constructor");
}
public String getDefaultErrAction() {
    NodeList defActList = elmSheet.getElementsByTagName("default_action");
    Element elmDefAct = (Element) defActList.item(0);

    if (elmDefAct == null)
        return null;
    else
        return elmDefAct.getAttribute("value");
}
private Element getElementObject() {
    NodeList objList = elmSheet.getElementsByTagName("object");
    return (Element) objList.item(0);

}
public String getErrorKey(String type) {
    NodeList mesList = elmSheet.getElementsByTagName("error_message");
    for (int i = 0; i < mesList.getLength(); i++) {
        Element elmErrmes = (Element) mesList.item(i);

        if (elmErrmes.getAttribute("type").equals(type))
            return elmErrmes.getAttribute("key");
    }

    return null;

}
public String[] getFinderArgNames() throws ClassNotFoundException {
    return getActionArgNames("finder");
}
public Class[] getFinderArgTypes() throws ClassNotFoundException {
    return getActionArgTypes("finder");
}
public String getFinderName() {
   return getActionName( "finder");
}
public String[] getFinish() {
    NodeList finishList = elmSheet.getElementsByTagName("finish_row");
    Element finishRow = (Element) finishList.item(0);

    String[] finishDate =
        { finishRow.getAttribute("column"), finishRow.getAttribute("value")};

    return finishDate;
}
public String getObjectClassName() {
    Element elmObj = getElementObject();
    return elmObj.getAttribute("class");

}
public Class getObjectType(String objectName) throws ClassNotFoundException {
 /*   Element elmObj = getElement(objectName);
    String className = elmObj.getAttribute("class");

    return Class.forName(className);*/
    return null;

}
public Hashtable getParametersDatas() {
    Element elmObj = getElementObject();
    NodeList paramList = elmObj.getElementsByTagName("parameter");
    Hashtable data = new Hashtable();

    for (int i = 0; i < paramList.getLength(); i++) {
        Element elmParam = (Element) paramList.item(i);
        String paramName = elmParam.getAttribute("name");
        Properties prop = new Properties();
        prop.setProperty("type", elmParam.getAttribute("type"));
        prop.setProperty("errorlabel", elmParam.getAttribute("errorlabel"));
        prop.setProperty("emptylabel", elmParam.getAttribute("emptylabel"));

        if (!elmParam.getAttribute("column").equals("")) {

            prop.setProperty("row", elmParam.getAttribute("row"));
            prop.setProperty("column", elmParam.getAttribute("column"));
            prop.setProperty("isNull", elmParam.getAttribute("isNull"));
            prop.setProperty("description", elmParam.getAttribute("description"));
            prop.setProperty("erroraction", elmParam.getAttribute("erroraction"));
        }
        data.put(paramName, prop);
    }
    return data;
}
private Class getParameterType(String paramName)
    throws ClassNotFoundException {
    Element elmObj = getElementObject();
    NodeList parametersList = elmObj.getElementsByTagName("parameter");

    for (int i = 0; i < parametersList.getLength(); i++) {
        Element elmParam = (Element) parametersList.item(i);

        if (elmParam.getAttribute("name").equals(paramName)) {
            String className = elmParam.getAttribute("type");
            return Class.forName(className);
        }
    }
    return null;
}
public String getParameterValue(String paramName) {
    Element elmObject = getElementObject();

    NodeList paramList = elmObject.getElementsByTagName("parameter");

    for (int i = 0; i < paramList.getLength(); i++) {
        Element elmParam = (Element) paramList.item(i);

        if (elmParam.getAttribute("name").equals(paramName)) {
	        
            if (elmParam.getAttribute("value").equals(""))
                return null;
            else
                return elmParam.getAttribute("value");

        }

    }
    return null;

}
public String getSheetDescription() {
    return elmSheet.getAttribute("description");
}
public int getStartColumn() {
    NodeList startColList = elmSheet.getElementsByTagName("start_column");
    Element elmStartColumn = (Element) startColList.item(0);

    return Integer.parseInt(elmStartColumn.getAttribute("number"));
}
public int getStartRow() {
    NodeList startRowList = elmSheet.getElementsByTagName("start_row");
    Element elmStartRow = (Element) startRowList.item(0);

    return Integer.parseInt(elmStartRow.getAttribute("number"));
}
public String[] getUpdaterArgNames() throws ClassNotFoundException {
    return getActionArgNames("updater");
}
public Class[] getUpdaterArgTypes()throws ClassNotFoundException {
    return getActionArgTypes("updater");
}
public String getUpdaterName() {
    return getActionName( "updater");
}
}
