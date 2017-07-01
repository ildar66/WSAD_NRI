package com.hps.july.web.util;

/**
 * Константы, используемые в библиотечных функциях.
 * Creation date: (22.01.2002 16:50:15)
 * @author: Administrator
 */
public interface Constants {
    java.lang.String BROWSE_ACTION_PREV = "PREVIOUS"; // Перейти к предыдущей странице
    java.lang.String BROWSE_ACTION_NEXT = "NEXT"; // Перейти к следующей странице
    java.lang.String BROWSE_ACTION_BOTTOM = "BOTTOM"; // Перейти к последней странице
    java.lang.String BROWSE_ACTION_TOP = "TOP"; // Перейти к первой странице
    public static final String PROCESS_PROPERTY = "action_process";
    public static final String PROCESS_PROPERTY_X = "action_process.x";
    boolean CHECK_ROLES = true; // If to check roles (false for WTE)
    boolean PRINT_INCOMPLETE = true; // Can user print incomplete documents

    public static final String CURRENT_URL = "CURRENT_URL"; //текущий урл
    public static final String MICROSTRATEGY_VISIBILITY = "MICROSTRATEGY_VISIBILITY"; //имя аттрибута отвечаючего за вывод в меню пункта Microstrategry
}
