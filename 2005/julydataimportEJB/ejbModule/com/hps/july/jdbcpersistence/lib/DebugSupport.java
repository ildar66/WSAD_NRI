package com.hps.july.jdbcpersistence.lib;

import com.hps.july.persistence.NamedValueAccessBean;
/**
 * Класс для поддержки отладочной печати.
 * Creation date: (19.05.2002 12:28:01)
 * @author: Shrago
 */
public class DebugSupport {

public final static boolean isDebug=true;	
	
/**
 * DebugSupport constructor comment.
 */
public DebugSupport() {
	super();
	
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2003 11:05:49)
 * @return boolean
 */
public static boolean isDebug() {
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2003 19:36:33)
 * @return boolean
 */
public static boolean isOldVersion()  {
    try {
        NamedValueAccessBean v = new NamedValueAccessBean();
        v.setInitKey_id("VERSION");
        v.refreshCopyHelper();
        return !v.getCharvalue().trim().toUpperCase().equals("NEWSWITCH");

    } catch (javax.ejb.FinderException e) {
        //DebugSupport.printlnError(e);
        return true;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        return true;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public static void println(Object message) {
	/*
    System.out.println(
            java.util.Calendar.getInstance().getTime()
            + " "
            + message);
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public  static void println(Object message,String methodName,Object source) {
	/*
    System.out.println(
            java.util.Calendar.getInstance().getTime()
            +"type "+source.getClass().getName()+" method "+methodName
            + " "
            + message);
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public static void printlnError(Throwable error) {
    /*   
    	try {
           String Message = new String(error.getMessage().getBytes("UTF16"), "Cp1251");
       } catch (Exception e) {
           System.out.println(e);
       }
    */
    String message = java.util.Calendar.getInstance().getTime() + " " + error;

    if (error instanceof java.sql.SQLException) {
        message =
            message + " error code=" + ((java.sql.SQLException) error).getErrorCode();
    }
    //message = Brocker.convertToUnicode(message);

    System.out.println(message);
    System.err.println(java.util.Calendar.getInstance().getTime());
    
    error.printStackTrace(System.out);
    error.printStackTrace();
    return;

}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public static void printlnError(Throwable error,String mes) {
    /*   
    	try {
           String Message = new String(error.getMessage().getBytes("UTF16"), "Cp1251");
       } catch (Exception e) {
           System.out.println(e);
       }
    */
    String message = java.util.Calendar.getInstance().getTime() +" "+ mes+" " + error;

    if (error instanceof java.sql.SQLException) {
        message =
            message + " error code=" + ((java.sql.SQLException) error).getErrorCode();
    }
    //message = Brocker.convertToUnicode(message);

    System.out.println(message);
    System.err.println(java.util.Calendar.getInstance().getTime());
    error.printStackTrace();
    error.printStackTrace(System.out);
    return;

}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public static void printlnError(Throwable error, String methodName, Object source) {

    printlnError(error, methodName, source, "");

    return;

}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public static void printlnError(
    Throwable error,
    String methodName,
    Object source,
    String mess) {
    /*   
    	try {
           String Message = new String(error.getMessage().getBytes("UTF16"), "Cp1251");
       } catch (Exception e) {
           System.out.println(e);
       }
    */
    String message =
        java.util.Calendar.getInstance().getTime()
            + "type "
            + source.getClass().getName()
            + " method "
            + methodName
            + " "
            + mess
            + " "
            + error;

    if (error instanceof java.sql.SQLException) {
        message =
            message + " error code=" + ((java.sql.SQLException) error).getErrorCode();
    }
    //message = Brocker.convertToUnicode(message);

    System.out.println(message);
    error.printStackTrace(System.out);
    error.printStackTrace();
    return;

}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public static void printlnTest(Object message) {
	/*
    System.out.println("test_msg "+
        
            java.util.Calendar.getInstance().getTime()
            
            + " "
            + message);
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2002 12:29:27)
 * @param error java.lang.Throwable
 */
public  static void printlnTest(Object message,String methodName,Object source) {
	/*
    System.out.println("test_msg "+
        
            java.util.Calendar.getInstance().getTime()
            +"type "+source.getClass().getName()+" method "+methodName
            + " "
            + message);
	*/
}
}
