package com.hps.july.siteinfo.applets;

import java.io.*;

/**
 * Запись в log-файл на компьютере пользователя. Используется для отладки
 * Creation date: (19.08.2003 16:43:19)
 * @author: Maxim Gerasimov
 */
public class Log {
    private static String path =
        System.getProperty("user.home")
        +System.getProperty("file.separator")
        +"applets_log.txt";

/**
 * Log constructor comment.
 */
public Log() {
	super();
}
    static void log(String msg, Exception ee){
        PrintWriter out = null;
        try{
            out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(path, true)));
            out.print("////////////////////////////////////////");
            out.print(new java.util.Date(System.currentTimeMillis()));
            out.print(msg);
            ee.printStackTrace(out);
            out.flush();
        }catch(Exception e){
            System.out.println("Error in Log.log");
            e.printStackTrace(System.out);
        } finally {
            try{if(out != null) out.close();}catch(Exception e){e.printStackTrace(System.out);}
        }
    }
}
