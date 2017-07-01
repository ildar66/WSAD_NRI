package com.hps.july.dataimport.lib;

import java.util.*;
import java.io.*;
import jxl.*;
import org.apache.regexp.*;
import java.lang.reflect.*;
import java.text.MessageFormat;

/**
   * Вспомогательный класс импорта данных
*/

public class RowHandler {

    private RowDOMHandler domHandler;
    private Sheet sheet;

    private int numberOfSheet;
    private String sheetDescription;
public RowHandler(org.w3c.dom.Document doc, Sheet sheet, int sheetNum) {
    this.sheet = sheet;
    domHandler = new RowDOMHandler(doc, sheetNum);
    this.numberOfSheet = sheetNum - 1;
    sheetDescription = domHandler.getSheetDescription();
    if (sheetDescription.equals(""))
        sheetDescription = sheet.getName();
    process();
}
private String getParametersMessage(String[] names, Object[] val) {
    String mes = "";

    for (int i = 0; i < names.length; i++) {
        if (i > 0)
            mes += ",";
        mes += names[i] + "=" + val[i];
    }
    return mes;
}
private String getParamValue(int rowNumber, Properties cellProp)
    throws RESyntaxException {

    Cell[] cells = sheet.getRow(rowNumber);
    int i = Integer.parseInt(cellProp.getProperty("column"));
    String contents = "";

    try {
        contents = cells[i].getContents().trim();

    } catch (IndexOutOfBoundsException ex) {

    }

    String pattern = cellProp.getProperty("regexp");
    if (pattern == null)
        return contents;

    int r_num;
    String r_numStr = cellProp.getProperty("regexp_num");
    r_num = r_numStr == null ? 1 : Integer.parseInt(r_numStr);

    RE re = new RE(pattern);
    int index = 0;
    String res = "";
    for (int j = 0; j < r_num; j++) {
        res = "";
        if (re.match(contents, index))
            res = re.getParen(0);

        index = contents.indexOf(res, index) + res.length();
        if (index == -1)
            break;

    }

    return res.trim();
}
private Object handleDatabaseObject(
    String objectName,
    Class objectType,
    String finderName,
    Class[] finderArgTypes,
    Object[] finderArgValues,
    Class[] constructorArgTypes,
    Object[] constructorArgValues,
    String updaterName,
    Class[] updaterArgTypes,
    Object[] updaterArgValues)
    throws Exception {

    Object obj = objectType.newInstance();

    try {
        Method finder = objectType.getDeclaredMethod(finderName, finderArgTypes);
        finder.invoke(obj, finderArgValues);
        DebugSupport.getMessage(
            "message.finder",
            domHandler.getFinderArgumentsName(objectName),
            finderArgValues);

        Method updater = objectType.getDeclaredMethod(updaterName, updaterArgTypes);
        updater.invoke(obj, updaterArgValues);
        DebugSupport.getMessage(
            "message.updater",
            domHandler.getUpdaterArgumentsName(objectName),
            updaterArgValues);

    } catch (InvocationTargetException e) {

        if (e.getTargetException() instanceof javax.ejb.ObjectNotFoundException) {

            Constructor cons = objectType.getConstructor(constructorArgTypes);
            obj = cons.newInstance(constructorArgValues);
            DebugSupport.getMessage(
                "message.constructor",
                domHandler.getConstructorArgumentsName(objectName),
                constructorArgValues);

        } else
            throw new Exception(e.getMessage());

    } catch (Exception e) {

        throw new Exception(e.getMessage());

    }

    return obj;

}
private boolean handleObject(int rowNumber, String objectName)
    throws Exception {

    boolean b = handleParameters(rowNumber, objectName);

    if (!b)
        return false;

    String finderName = domHandler.getFinderName(objectName);
    Class[] finderTypes = domHandler.getFinderArgumentsType(objectName);
    Object[] finderValues = domHandler.getFinderArgumentsValue(objectName);

    Class[] constructorTypes = domHandler.getConstructorArgumentsType(objectName);
    Object[] constructorValues =
        domHandler.getConstructorArgumentsValues(objectName);

    String updaterName = domHandler.getUpdaterName(objectName);
    Class[] updaterTypes = domHandler.getUpdaterArgumentsType(objectName);
    Object[] updaterValues = domHandler.getUpdaterArgumentsValue(objectName);

    Class objectType = domHandler.getObjectType(objectName);

    Object obj =
        handleDatabaseObject(
            objectName,
            objectType,
            finderName,
            finderTypes,
            finderValues,
            constructorTypes,
            constructorValues,
            updaterName,
            updaterTypes,
            updaterValues);

    domHandler.setObject(objectName, obj);

    return true;
}
private boolean handleParameters(int rowNumber, String objectName)
    throws Exception {

    boolean b = domHandler.handleParameters(objectName);

    if (!b)
        return false;

    Enumeration enum = domHandler.getCellsData(objectName);

    while (enum.hasMoreElements()) {

        Properties prop = (Properties) enum.nextElement();
        String paramValue = getParamValue(rowNumber, prop);

        try {
            b = setParamValue(paramValue, objectName, prop);
            if (!b)
                return false;

        } catch (NumberFormatException e) {

            String[] info = { objectName, e.getMessage()};
            DebugSupport.getMessage("message.parameterNumberFormatException.row", info);
            return false;
        }

    }

    return b;

}
private boolean handleRow(int rowNumber) throws Exception {
    boolean b = true;
    refreshObjects();

    Enumeration en = domHandler.getObjectsOrder();

    while (en.hasMoreElements()) {
        String objectName = (String) en.nextElement();

        String[] objName = { objectName };
        DebugSupport.getMessage("message.object", objName);

        b = handleObject(rowNumber, objectName);
        if (!b)
            return false;

        DebugSupport.getMessage("message.endObject", objName);
    }

    return b;
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
public void process() {

    String[] sheetDescrip = { sheetDescription };
    try {
        DebugSupport.getMessage("message.sheet", sheetDescrip);

        boolean allSuccessf = true;
        int start = domHandler.getStartRow();

        for (int i = start - 1;; i++) {

            if (isFinish(i, domHandler.getFinish())) {
                if (allSuccessf)
                    DebugSupport.getMessage("message.endSheetSuccessfully", sheetDescrip);
                else
                    DebugSupport.getMessage("message.endSheet", sheetDescrip);

                break;
            }

            Integer[] currentRow = { new Integer(i + 1)};
            DebugSupport.getMessage("message.row", currentRow);

            boolean b = handleRow(i);

            if (b)
                DebugSupport.getMessage("message.endRowSuccessfully", currentRow);
            else {
                allSuccessf = false;
                DebugSupport.getMessage("message.endRow", currentRow);
            }

        }
    } catch (Exception ex) {
        try {
            DebugSupport.getException(ex, "message.endSheetFailed", sheetDescrip);
        } catch (MissingResourceException e) {
            DebugSupport.getException(ex);
            DebugSupport.getException(e);
        }
    }

}
private void refreshObjects() {
    domHandler.setObjectsTable(new Hashtable());
}
private boolean setParamValue(
    String paramValue,
    String objectName,
    Properties cellData)
    throws ClassNotFoundException {

    String parName = cellData.getProperty("name");

    try {
        return domHandler.setParameterValue(objectName, parName, paramValue);

    } catch (NumberFormatException e) {
        throw new NumberFormatException(parName);
    }
}
}
