package com.hps.july.jdbcpersistence.lib;

/**
 * Значения check-ов в базе данных в виде констант.
 * Creation date: (14.07.2003 16:30:02)
 * @author: Alexander Shrago
 */
public interface Checks {
    public final static String EQUIPMENT_STATE_PLAN_P = "P";
    public final static String EQUIPMENT_STATE_MOUNT_M = "M";
    public final static String EQUIPMENT_STATE_READY_R = "R";
    public final static String EQUIPMENT_STATE_TEST_T = "T";
    public final static String EQUIPMENT_STATE_WORK_W = "W";

    public final static String POSITION_PLANSTATE_Fact = "2";
    public final static String POSITION_PLANSTATE_Plan = "1";
    public final static String POSITION_PLANSTATE_Archive = "0";

    public static final String SWITCH_TYPE_Damps = "1";
    public static final String SWITCH_TYPE_Gsm = "2";

    public final static String BS_TYPE_DAMPS_D = "D";
    public final static String BS_TYPE_GSM_S = "S";
    public final static String BS_TYPE_GSM_G = "G";
    public final static String BS_TYPE_DCS_C = "C";

    public final static String ANTENNA_LOCATIONTYPE_OUTDOOR_O="O";
    public final static String ANTENNA_LOCATIONTYPE_INDOOR_I="I";
    
    

}
