package com.hps.july.dataimport.lib;

import java.util.*;
import java.io.*;
import jxl.*;
import org.apache.regexp.*;
import java.lang.reflect.*;
import java.text.MessageFormat;

/**
  * Обработчик колонки
*/

public class ColumnHandler {

    private DOMHandler domHandler;
    private Sheet sheet;

    private Hashtable parametersData;
    private Hashtable paramValues;
    private String objectClassName;
    private String finderName;
    private String updaterName;
    private Class[] finderArgTypes;
    private Class[] constructorArgTypes;
    private Class[] updaterArgTypes;
    private String[] finderArgNames;
    private String[] constructorArgNames;
    private String[] updaterArgNames;

    // private int numberOfSheet;
    private String sheetDescription;

    private int recCount = 0;
    private int errCount = 0;

    private LoggerHandler logHandler;
    private String errKey;
    private String errLabel;
    private RecordLoggerTargetException logEx;
    private String errParam;
    private boolean isNextColumn;
    private boolean isNextRow;
    private boolean isBreakFile;
    private final String ErrAction_Default = Importer.ERRACTION_NextColumn;
    private static  String defErrAction;
public ColumnHandler(
    org.w3c.dom.Document doc,
    Sheet sheet,
    int numberOfSheet) {

    this.sheet = sheet;
    domHandler = new DOMHandler(doc, numberOfSheet);

    sheetDescription = domHandler.getSheetDescription();
    if (sheetDescription.equals(""))
        sheetDescription = sheet.getName();

    // process();

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
private Object[] getConstructorArgValues() {
    Object[] argValues = new Object[constructorArgNames.length];

    for (int i = 0; i < constructorArgNames.length; i++) {

        Object value = paramValues.get(constructorArgNames[i]);

        try {
            argValues[i] = value.equals("") ? null : value;

        } catch (NullPointerException e) {
            throw new NullPointerException(
                DebugSupport.getArgFailed(constructorArgNames[i]));
        }

    }

    return argValues;
}
public static java.lang.String getDefErrAction() {
	return defErrAction;
}
public int getErrCount() {
    return errCount;
}
private Object[] getFinderArgValues() {
    Object[] argValues = new Object[finderArgNames.length];

    for (int i = 0; i < finderArgNames.length; i++) {

        Object value = paramValues.get(finderArgNames[i]);

        try {
            argValues[i] = value.equals("") ? null : value;

        } catch (NullPointerException e) {
            throw new NullPointerException(DebugSupport.getArgFailed(finderArgNames[i]));
        }
        
    }

    return argValues;
}
public int getRecCount() {
    return recCount;
}
private Object[] getUpdaterArgValues() {
    Object[] argValues = new Object[updaterArgNames.length];

    for (int i = 0; i < updaterArgNames.length; i++) {

        Object value = paramValues.get(updaterArgNames[i]);
        try {
            argValues[i] = value.equals("") ? null : value;

        } catch (NullPointerException e) {
            throw new NullPointerException(DebugSupport.getArgFailed(updaterArgNames[i]));
        }

    }

    return argValues;
}
private void handleDatabaseObject(
    Object[] finderArgValues,
    Object[] constructorArgValues,
    Object[] updaterArgValues)
    throws Exception {

    Class objectType = Class.forName(objectClassName);
    Object obj = objectType.newInstance();
    String methFailed = finderName;

    try {
        logHandler.setValue("keyFields", finderArgValues, "record_logger", "message.reclog");

        boolean hasNoErr = isFinderParamsValid();

        if (hasNoErr) {

            Method finder = objectType.getDeclaredMethod(finderName, finderArgTypes);
            Boolean b = (Boolean) finder.invoke(obj, finderArgValues);
            boolean isfind = b.booleanValue();

            if (isfind)
                logHandler.setValue("action", "U", "record_logger", "message.reclog");
            else
                logHandler.setValue("action", "I", "record_logger", "message.reclog");

            if (errKey == null) {

                if (isfind) {
                    methFailed = updaterName;

                    Method updater = objectType.getDeclaredMethod(updaterName, updaterArgTypes);
                    updater.invoke(obj, updaterArgValues);
                    logHandler.setValue("result", "S", "record_logger", "message.reclog");

                } else {
                    methFailed = "constructor";

                    Constructor cons = objectType.getConstructor(constructorArgTypes);
                    obj = cons.newInstance(constructorArgValues);
                    logHandler.setValue("result", "S", "record_logger", "message.reclog");
                }

            }
        }
        if (errKey != null || !hasNoErr)
            logHandler.setValue("result", "E", "record_logger", "message.reclog");

    } catch (InvocationTargetException tarEx) {

        logHandler.setValue("result", "E", "record_logger", "message.reclog");

        try {
            logEx = (RecordLoggerTargetException) tarEx.getTargetException();
            errKey = logEx.getErrorLabel();
            
            String errAction = logEx.getErrorAction();
            if(errAction!=null)
                handleErrAction(errAction);
        } catch (Exception e) {
            errKey = domHandler.getErrorKey("error.record");
            DebugSupport.getException(e);
        }

    } catch (Exception e) {

        logHandler.setValue("result", "E", "record_logger", "message.reclog");
        errKey = domHandler.getErrorKey("error.record");
        DebugSupport.getException(e);
    }

}
private void handleErrAction(String errAction) {
    if (errAction.equals(Importer.ERRACTION_NextColumn)) {
        isNextColumn = true;
        return;
    }
    if (errAction.equals(Importer.ERRACTION_NextRow)) {
        isNextRow = true;
        return;
    }
    if (errAction.equals(Importer.ERRACTION_BreakFile))
        isBreakFile = true;

}
private void handleError(int row, int col) throws Exception {

    logHandler.setValue("errorLabel", errKey, "record_logger", "message.reclog.err");

    if (logEx != null) {
        String[] errPars = logEx.getParameters();
        int len = errPars.length;
        String keyMes = "";

        for (int i = 0; i < len; i++) {
            if (i == len - 1)
                keyMes = "message.reclog.err.end";

            else
                keyMes = "message.reclog.err";

            logHandler.setValue("errorParam" + (i + 1), errPars[i], "record_logger", keyMes);
        }

    } else {
        if (errKey.equals("error.record"))
            logHandler.setValue("errorParam1", col, row, "record_logger","message.reclog.err.end");

        else {

            if (errLabel.startsWith("empty") )
                logHandler.setValue("errorParam1", col, row, "record_logger","message.reclog.err.end");

            else {
                logHandler.setValue("errorParam1", errParam, "record_logger", "message.reclog.err");
                logHandler.setValue("errorParam2", col, row, "record_logger","message.reclog.err.end");
            }
        }
    }
}
private void handleRow(int row) throws Exception {
 
    //   Integer[] currentRow = { new Integer(row - 2)};
    //    DebugSupport.getMessage("message.row", currentRow);
 
    int startCol = domHandler.getStartColumn();
 
    for (int i = startCol - 1; i < sheet.getRow(3 - 1).length; i++) {
 
        logHandler.prepareLogObject("record_logger");
        logHandler.setValue("sessionLoggerId", "", "record_logger", "message.reclog");
 
        receiveParamValues(row, i);
 
        //   if (isNextRow)
        //       break;
 
        Object[] finderValues = getFinderArgValues();
        Object[] constructorValues = getConstructorArgValues();
        Object[] updaterValues = getUpdaterArgValues();
 
        handleDatabaseObject(finderValues, constructorValues, updaterValues);
 
        if (isBreakFile)
            break;
 
        if (errKey == null) {
            logHandler.setValue("endTime", "", "record_logger", "message.reclog.end");
            if (isNextRow || isNextColumn)
                errCount++;
 
        } else {
 
            logHandler.setValue("endTime", "", "record_logger", "message.reclog");
            handleError(row + 1, i + 1);
            errCount++;
 
        }
 
        logHandler.commitLogObject("record_logger");
        recCount++;
        
        if (isNextRow)
            break;
    }
    //    DebugSupport.getMessage("message.endRow", currentRow);
 
}
private boolean isFinderParamsValid() {

    for (int i = 0; i < finderArgNames.length; i++) {
        String paramValue = paramValues.get(finderArgNames[i]).toString();

        Properties paramProp = (Properties) parametersData.get(finderArgNames[i]);
        String className = paramProp.getProperty("type");

        try {
            convert(className, paramValue);

        } catch (NumberFormatException e) {
            return false;
        }

        String isNull = paramProp.getProperty("isNull");
        if (paramValue.equals("") && isNull.equals("false"))
            return false;

    }
    return true;
}
private boolean isFinish(int rowNumber, String[] finish) {

    int i = Integer.parseInt(finish[0]) - 1;
    String value = finish[1];

    try {
        Cell[] cells = sheet.getRow(rowNumber);
        if (cells[i].getContents().equals(value))
            return true;
        return false;

    } catch (IndexOutOfBoundsException ex) {

        if (value.equals(""))
            return true;
        else
            return false; 

    }
}
private void prepare() throws Exception {

    defErrAction = domHandler.getDefaultErrAction();
    if (defErrAction == null || defErrAction.equals(""))
        defErrAction = ErrAction_Default;

    logHandler.prepareLogObject("record_logger");
    logHandler.setValue("sessionLoggerId", "", "record_logger", "message.reclog");

    objectClassName = domHandler.getObjectClassName();

    parametersData = domHandler.getParametersDatas();

    finderName = domHandler.getFinderName();
    finderArgTypes = domHandler.getFinderArgTypes();
    finderArgNames = domHandler.getFinderArgNames();

    //  constructorName = domHandler.getConstructorName();
    constructorArgTypes = domHandler.getConstructorArgTypes();
    constructorArgNames = domHandler.getConstructorArgNames();

    updaterName = domHandler.getUpdaterName();
    updaterArgTypes = domHandler.getUpdaterArgTypes();
    updaterArgNames = domHandler.getUpdaterArgNames();

    Class objectType = Class.forName(objectClassName);
    Object obj = objectType.newInstance();

    Method finder = objectType.getDeclaredMethod(finderName, finderArgTypes);
    Method updater = objectType.getDeclaredMethod(updaterName, updaterArgTypes);
    Constructor cons = objectType.getConstructor(constructorArgTypes);

    return;
}
public void process() {

    String[] sheetDescrip = { sheetDescription };
    try {
        DebugSupport.getMessage("message.sheet", sheetDescrip);
        prepare();

        int start = domHandler.getStartRow();
        for (int i = start - 1;; i++) {
            if (isFinish(i, domHandler.getFinish())) {
                if (errCount == 0)
                    DebugSupport.getMessage("message.endSheetSuccessfully", sheetDescrip);
                else
                    DebugSupport.getMessage("message.endSheet", sheetDescrip);
                break;
            }

            handleRow(i);
            
            if (isBreakFile)
                break;

        }

    } catch (Exception ex) {
        errKey = domHandler.getErrorKey( "error.session");
        try {
            logHandler.setValue("errorLabel", errKey,  "record_logger", "message.reclog.err");
            DebugSupport.getException(ex, "error.session", sheetDescrip);
        } catch (Exception e) {
            DebugSupport.getException(ex);
            DebugSupport.getException(e);
        }
    }

}
private String receiveParamValue(
    String paramName,
    int currentRow,
    int currentCol) {

    Cell[] cells;
    Properties prop = (Properties) parametersData.get(paramName);
    String row = prop.getProperty("row");
    String col = prop.getProperty("column");

    if (row.equals("*"))
        cells = sheet.getRow(currentRow);
    else
        cells = sheet.getRow(Integer.parseInt(row) - 1);

    try {
        if (col.equals("*"))
            return cells[currentCol].getContents().trim();
        else
            return cells[Integer.parseInt(col) - 1].getContents().trim();

    } catch (IndexOutOfBoundsException ex) {
        return "";
    }

}
private boolean receiveParamValues(int currentRow, int currentCol) {

    paramValues = new Hashtable();
    errKey = null;
    errLabel = null;
    logEx = null;
    errParam = null;
    isNextRow = false;
    isNextColumn = false;
    String paramValue = "";
    Enumeration names = parametersData.keys();

    while (names.hasMoreElements()) {
        String paramName = (String) names.nextElement();
        Properties paramProp = (Properties) parametersData.get(paramName);

        if (paramProp.getProperty("column") != null) {
            // receive value from exel
            paramValue = receiveParamValue(paramName, currentRow, currentCol);

            if (paramValue.equals("")) {

                paramValues.put(paramName, "");

                if (paramProp.getProperty("isNull").equals("false"))
                    setErrkeyAndParamfailed("null", paramName);

            } else {
                String className = paramProp.getProperty("type");
                try {
                    paramValues.put(paramName, convert(className, paramValue));

                } catch (NumberFormatException e) {

                    paramValues.put(paramName, paramValue);
                    setErrkeyAndParamfailed("typeFailed", paramName);
                }
            }

            //---------------------------------------------------------------------
            //---------------------------------------------------------------------            

        } else {
            //receive value from xml
            paramValue = domHandler.getParameterValue(paramName);
            paramValues.put(paramName, paramValue);
        }
    }

    //---------------------------------------------------------------------
    if (errKey != null)
        return false;
    return true;

}
private void setErrkeyAndParamfailed(String errEvent, String paramName) {
    if (errKey != null)
        return;

    Properties pr = (Properties) parametersData.get(paramName);

    if (errEvent.equals("null")) {

        errLabel = "emptylabel";
        errKey = pr.getProperty(errLabel);

    } else {

        errLabel = "errorlabel";
        errKey = pr.getProperty(errLabel);
        errParam = (String) paramValues.get(paramName);

    }

    String errAction = pr.getProperty("erroraction");
    if (errAction.equals(Importer.ERRACTION_NextRow))
        isNextRow = true;

    errKey = errKey == null ? "" : errKey;

}
public void setLogHandler(LoggerHandler newLogHandler) {
	logHandler = newLogHandler;
}
}
