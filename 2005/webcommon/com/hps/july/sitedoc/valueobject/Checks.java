package com.hps.july.sitedoc.valueobject;

/**
 *  онстанты дл€ использовани€ в JSP и формах
 */
public interface Checks {
    String Switch_Damps = "1";
    String Switch_Gsm = "2";

    public final static String OBJECT_BS_GSM = "bsGsm";
    public final static String OBJECT_BS_DAMPS = "bsDamps";
    public final static String OBJECT_ComEquipment_Optic = "comEquipmentOptic";
    public final static String OBJECT_ComEquipment_Radio = "comEquipmentRadio";
    public final static String OBJECT_ComEquipment_Other = "comEquipmentOther";
    public final static String OBJECT_OtherEquipment = "otherEquipment";
    public final static String OBJECT_Switch = "switch";
    public final static String OBJECT_Controller = "controller";
    public final static String OBJECT_Repeater = "repeater";

    String ComEquipment_Optic = "O";
    String ComEquipment_Radio = "R";
    String ComEquipment_Other = "A";
    String Other_A = "A";
    String Other_B = "B";
    String Other_C = "C";
    String Other_D = "D";
    String TYPE_CHECK_DAMPS_D = "D";
    String TYPE_CHECK_GSM_S = "S";
    String TYPE_CHECK_GSM_G = "G";
    String TYPE_CHECK_DCS_C = "C";
    String BS_DAMPS_D = "D";
    String BS_GSM_S = "S";
    String BS_GSM_G = "G";
    String BS_DCS_C = "C";
    String PLANSTATE_Fact = "2";
    String PLANSTATE_Plan = "1";
    String PLANSTATE_Archive = "0";
    String ONAIR_Y = "Y";
    String ONAIR_N = "N";
    short BAND_CHECK_DAMPS_800 = 800;
    short BAND_CHECK_GSM_900 = 900;
    short BAND_CHECK_GSM_1800 = 1800;

    String Storageplace_Type_BS = "B";
    String Storageplace_Type_Switch = "W";
    String Storageplace_Type_Controller = "O";
    String Storageplace_Type_ComEquipment = "C";
    String Storageplace_Type_OtherEquipment = "T";
    String Storageplace_Type_Repeater = "R";

}
