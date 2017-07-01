package com.hps.july.dataimport.lib;

import java.util.*;
import java.io.*;
import org.xml.sax.*;
//import org.apache.xerces.parsers.*;
import org.w3c.dom.*;
import org.apache.struts.util.*;
import java.lang.reflect.Constructor;
import java.text.MessageFormat;

/**
   * Вспомогательный класс импорта данных
*/

public class RowDOMHandler {
    private Hashtable objectsTable = new Hashtable();

    /*
    key for receive Object[] parameters from Hashtable objectTable
    key is represented as: objectName"_params" 
    */
    private String key;
    private Element elmSheet;

public RowDOMHandler(Document doc, int numberOfSheet) {

    NodeList sheetsList = doc.getElementsByTagName("worksheet");

    for (int i = 0; i < sheetsList.getLength(); i++) {

        Element elmSheetI = (Element) sheetsList.item(i);
        int numI = Integer.parseInt(elmSheetI.getAttribute("number"));

        if (numI == numberOfSheet) {
            elmSheet = elmSheetI;
            return;
        }
    }

}
private Object convert(String className, String paramValue) {
    if (className.equals("java.lang.String"))
        return paramValue;

    if (className.equals("java.lang.Integer"))
        return Integer.valueOf(paramValue);

    if (className.equals("java.sql.Date"))
        //obj =;
        ;

    return null;
}
private String[] getActionArgumentsName(String objectName, String actionName) {

    Element elmObj = getElement(objectName);
    NodeList ac = elmObj.getElementsByTagName(actionName);
    Element elmAction = (Element) ac.item(0);

    NodeList argList = elmAction.getElementsByTagName("argument");
    String[] names = new String[argList.getLength()];

    for (int i = 0; i < argList.getLength(); i++) {
        Element arg = (Element) argList.item(i);
        String paramName = arg.getAttribute("parameter");
        names[i] = paramName;
    }

    return names;
}
private Class[] getActionArgumentsType(String objectName, String actionName)
    throws ClassNotFoundException {
    Class[] clazz;

    Element elmObj = getElement(objectName);
    NodeList ac = elmObj.getElementsByTagName(actionName);
    Element action = (Element) ac.item(0);

    NodeList argList = action.getElementsByTagName("argument");
    clazz = new Class[argList.getLength()];
    for (int i = 0; i < argList.getLength(); i++) {

        Element arg = (Element) argList.item(i);
        String paramName = arg.getAttribute("parameter");
        clazz[i] = getParameterType(objectName, paramName);
    }
    return clazz;

}
private Object[] getActionArgumentsValue(
    String objectName,
    String actionName) {
    key = getKey(objectName);
    Hashtable params = (Hashtable) objectsTable.get(key);
    Object[] objects;

    Element elmObj = getElement(objectName);
    NodeList ac = elmObj.getElementsByTagName(actionName);
    Element action = (Element) ac.item(0);

    NodeList argList = action.getElementsByTagName("argument");
    objects = new Object[argList.getLength()];
    for (int i = 0; i < argList.getLength(); i++) {

        Element arg = (Element) argList.item(i);
        String paramName = arg.getAttribute("parameter");
        objects[i] = getParameterValue(params, paramName);
    }
    return objects;

}
private String getActionName(String objectName, String actionName) {
    Element elmObj = getElement(objectName);
    NodeList ac = elmObj.getElementsByTagName(actionName);
    Element elmAction = (Element)ac.item(0);
    
    return elmAction.getAttribute("name");
}
public Enumeration getCellsData(String objectName) {
    Element elmObj = getElement(objectName);
    NodeList paramList = elmObj.getElementsByTagName("parameter");

    Vector vct = new Vector();
    for (int i = 0; i < paramList.getLength(); i++) {

        Element elmParam = (Element) paramList.item(i);

        if (!elmParam.getAttribute("column").equals("")) {

            Properties cellData = new Properties();
            cellData.setProperty("name", elmParam.getAttribute("name"));
            cellData.setProperty("column", elmParam.getAttribute("column"));

            if (!elmParam.getAttribute("regexp").equals("")) {
                cellData.setProperty("regexp", elmParam.getAttribute("regexp"));

                if (!elmParam.getAttribute("regexp_num").equals(""))
                    cellData.setProperty("regexp_num", elmParam.getAttribute("regexp_num"));
            }
            vct.add(cellData);
        }
    }
    return vct.elements();
}
public String[] getConstructorArgumentsName(String objectName) throws ClassNotFoundException{
    
    return getActionArgumentsName(objectName,"constructor");
}
public Class[] getConstructorArgumentsType(String objectName) throws ClassNotFoundException{
    
    return getActionArgumentsType(objectName,"constructor");
}
public Object[] getConstructorArgumentsValues(String objectName) {
    return getActionArgumentsValue(objectName, "constructor");
}
public String getConstructorName(String objectName) {

    return getActionName(objectName, "constructor");
}
private Element getElement(String objectName) {
    NodeList objList = elmSheet.getElementsByTagName("object");
    for (int i = 0; i < objList.getLength(); i++) {

        Element elmObj = (Element) objList.item(i);
        if (elmObj.getAttribute("name").equals(objectName))
            return elmObj;

    }
    return null;
}
public String[] getFinderArgumentsName(String objectName)throws ClassNotFoundException {
     return getActionArgumentsName(objectName,"finder");
}
public Class[] getFinderArgumentsType(String objectName)throws ClassNotFoundException {
     return getActionArgumentsType(objectName,"finder");
}
public Object[] getFinderArgumentsValue(String objectName) {
    return getActionArgumentsValue(objectName,"finder");
}
public String getFinderName(String objectName) {
   return getActionName(objectName, "finder");
}
public String[] getFinish() {
    NodeList finishList = elmSheet.getElementsByTagName("finish_row");
    Element finishRow = (Element) finishList.item(0);

    String[] finishDate =
        { finishRow.getAttribute("column"), finishRow.getAttribute("value")};

    return finishDate;
}
/*
 return key for receive Object[] parameters from Hashtable objectTable

 key is represented as: objectName"_params" 
 */

private String getKey(String objectName) {

    return objectName + "_params";
}
public Enumeration getObjectsOrder() {
    NodeList objsList = elmSheet.getElementsByTagName("object");

    Vector vct = new Vector();
    for (int i = 0; i < objsList.getLength(); i++) {
        Element elmObj = (Element) objsList.item(i);
        vct.add(elmObj.getAttribute("name"));
    }
    return vct.elements();
}
public Hashtable getObjectsTable() {
    return objectsTable;
}
public Class getObjectType(String objectName) throws ClassNotFoundException {
    Element elmObj = getElement(objectName);
    String className = elmObj.getAttribute("class");

    return Class.forName(className);

}
private Class getParameterType(String objectName, String paramName)
    throws ClassNotFoundException {
    Element elmObj = getElement(objectName);
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
private Class getParameterType(Hashtable paramstable, String paramName) {
    Object param = paramstable.get(paramName);

    return param.getClass();
}
private Object getParameterValue(Hashtable paramstable, String paramName) {
    Object value = paramstable.get(paramName);

    try {
        if (value.equals(""))
            return null;

        return value;

    } catch (NullPointerException e) {
        throw new NullPointerException(DebugSupport.getArgFailed(paramName));
    }

}
public String getSheetDescription() {
    return elmSheet.getAttribute("description");
}
public int getStartRow() {
    NodeList startRowList = elmSheet.getElementsByTagName("start_row");
    Element elmStartRow = (Element) startRowList.item(0);

    return Integer.parseInt(elmStartRow.getAttribute("number"));
}
public String[] getUpdaterArgumentsName(String objectName)throws ClassNotFoundException {
    return getActionArgumentsName(objectName,"updater");
}
public Class[] getUpdaterArgumentsType(String objectName)throws ClassNotFoundException {
    return getActionArgumentsType(objectName,"updater");
}
public Object[] getUpdaterArgumentsValue(String objectName) {
    return getActionArgumentsValue(objectName,"updater");
}
public String getUpdaterName(String objectName) {
    return getActionName(objectName, "updater");
}
private boolean handleNull(String objectName, String paramName) {

    if (isNull(objectName, paramName))
        return true;

    else {
        String[] info = { objectName, paramName };
        DebugSupport.getMessage("message.parameterError.row", info);
        return false;
    }

}
private boolean handleNull(
    String objectName,
    String paramName,
    Element elmParam) {

    if (elmParam.getAttribute("isNull").equals("false")) {

        String[] info = { objectName, paramName };
        DebugSupport.getMessage("message.parameterError.row", info);
        return false;

    } else
        return true;

}
private boolean handleParameter(String objectName, Element elmParam)
    throws Exception {

    String paramName = elmParam.getAttribute("name");

    Object parameter = null;

    key = getKey(objectName);
    Hashtable params = (Hashtable) objectsTable.get(key);

    if (!elmParam.getAttribute("object").equals("")) {
        String obj_Name = elmParam.getAttribute("object");
        Object bean = objectsTable.get(obj_Name);

        if (bean == null) {
            params.put(paramName, "");
            return handleNull(objectName, paramName, elmParam);
        }

        if (elmParam.getAttribute("property").equals(""))
            parameter = bean;

        else {

            Object beanProperty =
                PropertyUtils.getProperty(bean, elmParam.getAttribute("property"));

            if (beanProperty == null) {
                params.put(paramName, "");
                return handleNull(objectName, paramName, elmParam);

            } else
                parameter = beanProperty;
        }

        params.put(paramName, parameter);
    }

    return true;
}
public boolean handleParameters(String objectName) throws Exception {
    Element elmObj = getElement(objectName);

    objectsTable.put(getKey(objectName), new Hashtable());

    NodeList parametersList = elmObj.getElementsByTagName("parameter");

    for (int i = 0; i < parametersList.getLength(); i++) {
        Element elmParam = (Element) parametersList.item(i);
        boolean b = handleParameter(objectName, elmParam);
        if (!b)
            return false;
    }
    return true;
}
private boolean isNull(String objectName, String paramName) {
    Element elmObj = getElement(objectName);
    NodeList parametersList = elmObj.getElementsByTagName("parameter");

    for (int i = 0; i < parametersList.getLength(); i++) {
        Element elmParam = (Element) parametersList.item(i);

        if (elmParam.getAttribute("name").equals(paramName)) {
            return Boolean.valueOf(elmParam.getAttribute("isNull")).booleanValue();
        }
    }
    return false;
}
public void setObject(String objectName, Object obj) {
    objectsTable.put(objectName, obj);
    return;
}
public void setObjectsTable(java.util.Hashtable newObjectsTable) {
	objectsTable = newObjectsTable;
}
public boolean setParameterValue(
    String objectName,
    String paramName,
    String paramValue)
    throws ClassNotFoundException {

    key = getKey(objectName);
    Hashtable params = (Hashtable) objectsTable.get(key);
    String className = getParameterType(objectName, paramName).getName();

    if (paramValue == null || paramValue.equals("")) {
        params.put(paramName, "");
        return handleNull(objectName, paramName);
    }

    Object obj = convert(className, paramValue);

    //DebugSupport.getMessage(
    //    DebugSupport.getParameterMessage(paramName, paramValue));

    params.put(paramName, obj);
    return true;
}
}
