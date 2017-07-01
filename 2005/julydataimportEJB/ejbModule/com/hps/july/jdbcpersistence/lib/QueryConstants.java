package com.hps.july.jdbcpersistence.lib;

/**
 * Константы для работы с JDBC запросами.
 * Creation date: (01.07.2003 21:04:52)
 * @author: Alexander Shrago
 */
public interface QueryConstants {
    public static int INPUT_QUERY = 1;
    public static int INPUT_PROCEDURE = 2;
    public static int RESULT_JdbcObjectEnum = 3;
    public static int RESULT_JdbcObject = 4;
    public static int RESULT_JdbcObjectVector = 5;

    public static int RESULT_NONE = 9;

    public static int RESULT_OBJECT = 10;
    /*   
    public static int RESULT_PROCEDURE_XML = 11;
        public static int RESULT_Int = 12;
    */
    public static int RESULT_LastSerial = 13;

    public static String QUERY_SelectLastSerial =
        "SELECT DISTINCT dbinfo('sqlca.sqlerrd1') FROM systables";

}
