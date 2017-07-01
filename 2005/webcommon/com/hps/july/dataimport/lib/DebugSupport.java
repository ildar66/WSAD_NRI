package com.hps.july.dataimport.lib;

import java.util.*;
import java.text.MessageFormat;
/**
  * Вспомогательный класс для работы с ошибками и сообщениями
*/
public class DebugSupport {
	public  static String baseName;
	private  static ResourceBundle bundle;
public static String getArgFailed(String argName) {
    return "Argument " + argName;
}
public static void getException(Exception ex) {
   
    ex.printStackTrace();
}
public static void getException(Exception ex, String key, Object[] arguments) {
    getMessage(key, arguments);
    ex.printStackTrace();
}
public static void getMessage(String mes) {

    /*   if (bundle == null)
           bundle = ResourceBundle.getBundle(baseName);
    
       String pattern = bundle.getString(key);
       String message = MessageFormat.format(pattern, arguments); */

   // String mes = key + ":  ";
    
 //   println(mes);
    
  //  if (key.equals("message.reclog.err.end")||key.equals("message.sheet"))
        println(mes);
}
public static void getMessage(String key, Object[] arguments) {

    /*   if (bundle == null)
           bundle = ResourceBundle.getBundle(baseName);
    
       String pattern = bundle.getString(key);
       String message = MessageFormat.format(pattern, arguments); */

    String mes = key + ":  ";
    for (int i = 0; i < arguments.length; i++) {
        if (i > 0)
            mes += ":";
        mes += arguments[i];
    }

    println(mes);
    
    if (key.equals("message.reclog.err.end")||key.equals("message.sheet"))
        println("");
}
public static void getMessage(String key, String[] names, Object[] val) {
    String mes = "";

    for (int i = 0; i < names.length; i++) {
        if (i > 0)
            mes += ",";
        mes += names[i] + "=" + val[i];
    }

    String[] arguments = { mes };
    getMessage(key, arguments);

}
private static void print(String message) {
    System.out.print(message);
}
private static void println(String message) {
    System.out.println(message);
}
}
