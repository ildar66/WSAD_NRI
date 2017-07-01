package com.hps.july.dataimport.lib;

import java.lang.reflect.Method;
import java.util.*;
import org.apache.struts.util.*;

/**
   * Вспомогательный класс импорта данных
*/

public class LoggerHandler {
    private Object sesLogger;
    private Object recLogger;
    private Properties recLoggerProp;
    private Properties sesLoggerProp;
    private LoggerDomHandler domLogger;

    private boolean isVal_toString = false;
    
    private int sessionId = -1;

public LoggerHandler(org.w3c.dom.Document doc) throws Exception {
    domLogger = new LoggerDomHandler(doc);
   // check();

}
private void check() throws Exception {

    check("session_logger");
    check("record_logger");

}
public void check(String logname) throws Exception {

    String className = domLogger.getLoggerClassName(logname);
    Class loggerType = Class.forName(className);
    Object logger = loggerType.newInstance();

    Properties setMethodPr = domLogger.getLoggerSetMethodsData(logname);
    Enumeration enum = setMethodPr.keys();

    while (enum.hasMoreElements()) {
        String methodName = (String) enum.nextElement();
        String argtype = setMethodPr.getProperty(methodName);
        Class[] arg = { Class.forName(argtype)};
        String firstCh = methodName.substring(0, 1).toUpperCase();
        methodName = "set" + firstCh + methodName.substring(1);
        loggerType.getDeclaredMethod(methodName, arg);

    }

    loggerType.getDeclaredMethod("commit", new Class[] {
    });

}
public void check(String logname1, String logname2) throws Exception {

    check(logname1);
    check(logname2);

}
public void commitLogObject(String name) throws Exception {

    String className = domLogger.getLoggerClassName(name);
    Class objectType = Class.forName(className);
    Object logger = null;

    if (name.equals("session_logger"))
        logger = sesLogger;

    if (name.equals("record_logger"))
        logger = recLogger;

    Method commit = objectType.getDeclaredMethod("commit", new Class[] {
    });
    commit.invoke(logger, new Object[] {
    });

}
public final static String convertHCoord(int num) {

	
    char c1 = 0;
    char c2 = 0;
    int dx = 'A';
    int mod = 'Z' - 'A'+1;
    
    int i = 0;
    if ((num-1) / (mod) >= 1 && (num-1) / (mod) < mod) {
        char[] arr = new char[2];
        i = (num-1) / (mod);
        arr[0] = (char) (i+dx-1);
        i = (num-1) % (mod);
        arr[1] = (char) (i+dx);
        return new String(arr);
    } else
        if ((num-1) / (mod) < 1) {
            return (char)(num+dx-1) + "";
        } else {
            return num + "";
        }
}
private void debugSupportGetErrorMessage(
    String key,
    Object value,
    String prop,
    String messageKey) {
    if (key.indexOf("error") != -1) {

        if (isVal_toString)
            value = value.toString();

        Object[] args = { prop, value };
        DebugSupport.getMessage(messageKey, args);
    }
}
private void debugSupportGetMessage(
    Object value,
    String prop,
    String messageKey) {

    if (isVal_toString)
        value = value.toString();

    Object[] args = { prop, value };
    DebugSupport.getMessage(messageKey, args);
}
private String finderArgValuesToString(Object[] finderArgValues) {

    String string_offFinderArgVals = "";

    for (int i = 0; i < finderArgValues.length; i++) {
        if (i > 0)
            string_offFinderArgVals += ":";

        string_offFinderArgVals += finderArgValues[i];

    }

    return string_offFinderArgVals;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 23:02:49)
 * @return int
 */
public int getSessionId() throws Exception {
    if (sessionId == -1) {
        String prop = sesLoggerProp.getProperty("id");
        Object value = PropertyUtils.getProperty(sesLogger, prop);
        Integer session_id = (Integer) value;
        this.sessionId = session_id.intValue();
    }
    return sessionId;
}
private Object handleValue(String key, Object value) throws Exception {

    if (key.equals("excelFileSize") && value instanceof String) {
        java.io.File file = new java.io.File((String) value);
        int size = new Long(file.length()).intValue();
        value = new Integer(size);

    } else
        if (key.equals("excelFileCreateTime")) {
            long time = 0;
            if (!value.equals("0")) {
                java.io.File file = new java.io.File((String) value);
                time = file.lastModified();
            }
            value = new java.sql.Timestamp(time);
            isVal_toString = true;

        } else
            if (key.equals("importStart")
                || key.equals("importEnd")
                || key.equals("endTime")) {
                value = new java.sql.Timestamp(System.currentTimeMillis());
                isVal_toString = true;

            } else
                if (key.equals("sessionLoggerId")) {
                    String prop = sesLoggerProp.getProperty("id");
                    value = PropertyUtils.getProperty(sesLogger, prop);
                    Integer session_id = (Integer) value;
                    setSessionId(session_id.intValue());

                }
    return value;
}
public void prepareLogObject(String name) throws Exception {

    String className = domLogger.getLoggerClassName(name);
    Class objectType = Class.forName(className);
    Object logger = objectType.newInstance();

    Properties loggerProp = domLogger.getLoggerProperties(name);

    if (name.equals("session_logger")) {
        sesLogger = logger;
        sesLoggerProp = loggerProp;
    }

    if (name.equals("record_logger")) {
        recLogger = logger;
        recLoggerProp = loggerProp;
    }

}
private void setSessionId(int newSessionId) {
    sessionId = newSessionId;
}
public void setValue(
    String key,
    Object[] finderArgValues,
    String loggerName,
    String messageKey)
    throws Exception {

    setValue(key, finderArgValuesToString(finderArgValues), loggerName, messageKey);

}
public void setValue(
    String key,
    int col,
    int row,
    String loggerName,
    String messageKey)
    throws Exception {

     setValue(
         key,
        "(" + convertHCoord(col) + "," + row + ")",
        loggerName,
        messageKey);

}
public void setValue(
    String key,
    Object value,
    String loggerName,
    String messageKey)
    throws Exception {

    isVal_toString = false;
    value = handleValue(key, value);

     String prop = null;
    if (loggerName.equals("session_logger")) {

        prop = sesLoggerProp.getProperty(key);
        PropertyUtils.setProperty(sesLogger, prop, value);
    }
    if (loggerName.equals("record_logger")) {

        prop = recLoggerProp.getProperty(key);
        PropertyUtils.setProperty(recLogger, prop, value);
    }

    if (loggerName.equals("session_logger"))
        debugSupportGetMessage(value, prop, messageKey);
    else
        debugSupportGetErrorMessage(key, value, prop, messageKey);

}
}
