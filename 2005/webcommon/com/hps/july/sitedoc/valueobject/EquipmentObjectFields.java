package com.hps.july.sitedoc.valueobject;

/**
 * Служебный класс-контейнер с параметрами оборудования
 */
public class EquipmentObjectFields implements Checks {
	public String value_type;
	public String table;
    public String field_typeOrder;
    public String field_typeName;
    public String field_name;
    public String field_address;
    public String field_number;
    public String field_pk;
	public String field_numberOrder;
	public String specConditional="";
/**
 * EquipmentFields constructor comment.
 */
public EquipmentObjectFields() {
	super();
}
/**
 * EquipmentFields constructor comment.
 */
public EquipmentObjectFields(String type) {
    super();

    field_address = "s_pos.address";

    if (type.equals(EquipmentObject.OBJECT_BS_DAMPS)
        || type.equals(EquipmentObject.OBJECT_BS_GSM)) {
        table = "basestations bs";
        value_type = Storageplace_Type_BS;
        /*
        field_typeOrder =
            " CASE bs.type WHEN "
                + BS_DAMPS_D
                + " THEN 310"
                + " ELSE 320"
                + " END typeOrder";
        */
        field_typeName =
            " 'Базовая станция '"
                + " ||DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') typeName";
        field_name = "bs.name";
        field_number = "cast(bs.number as CHAR(40))";
        field_numberOrder = "bs.number";
        field_pk = "bs.equipment";
        if (type.equals(EquipmentObject.OBJECT_BS_DAMPS)) {
            field_typeOrder = "310 typeOrder";
            specConditional = "bs.type='" + BS_DAMPS_D + "'";
        } else {
            field_typeOrder = "320 typeOrder";
            specConditional = "bs.type<>'" + BS_DAMPS_D + "'";
        }

    } else if (
        type.equals(EquipmentObject.OBJECT_ComEquipment_Optic)
            || type.equals(EquipmentObject.OBJECT_ComEquipment_Radio)
            || type.equals(EquipmentObject.OBJECT_ComEquipment_Other)) {
        table = "comequipment ce";
        value_type = Storageplace_Type_ComEquipment;
        /*
        field_typeOrder =
            "CASE ce.type WHEN "
                + ComEquipment_Optic
                + " THEN 410"
                + " WHEN "
                + ComEquipment_Radio
                + " THEN 420 END typeOrder";
        */
        field_typeName =
            "'Коммуникационное оборудование '"
                + "||DECODE(ce.type,'R','RRL','O','Оптика','Прочее') typeName";
        field_name = "s_eq.name";
        field_number = "''";
        field_numberOrder = "9999999";
        field_pk = "ce.equipment";

        if (type.equals(EquipmentObject.OBJECT_ComEquipment_Other)) {
            field_typeOrder = "430 typeOrder";
            specConditional = "ce.type='" + ComEquipment_Other + "'";
        } else if (type.equals(EquipmentObject.OBJECT_ComEquipment_Optic)) {
            field_typeOrder = "410 typeOrder";
            specConditional = "ce.type='" + ComEquipment_Optic + "'";
        } else if (type.equals(EquipmentObject.OBJECT_ComEquipment_Radio)) {
            field_typeOrder = "420 typeOrder";
            specConditional = "ce.type='" + ComEquipment_Radio + "'";
        }

    } else if (type.equals(EquipmentObject.OBJECT_Controller)) {
        table = "controllers con";
        value_type = Storageplace_Type_Controller;
        field_typeOrder = "200 typeOrder";
        field_typeName = "'Контроллер' typeName";
        field_name = "con.name";
        field_number = "cast(con.number as CHAR(40))";
        field_numberOrder = "con.number";
        field_pk = "con.equipment";

    } else if (type.equals(EquipmentObject.OBJECT_OtherEquipment)) {
        table = "otherequipment oe";
        value_type = Storageplace_Type_OtherEquipment;
        field_typeOrder =
            "CASE oe.type WHEN '"
                + Other_A
                + "' THEN 500"
                + "WHEN '"
                + Other_B
                + "' THEN 510"
                + " WHEN '"
                + Other_C
                + "' THEN 520 "
                + " WHEN '"
                + Other_D
                + "' THEN 530"
                + " END typeOrder";
        field_typeName =
            "CASE oe.type"
                + " WHEN 'A' THEN 'Сооружения (контейнеры, мачты, опоры)'"
                + " WHEN 'B' THEN 'Оборудование техническое (электропитания, охлаждение, сигнализация, пожаротушение, огни ВОЗ)'"
                + " WHEN 'C' THEN 'Хозяйственное оборудование'"
                + " WHEN 'D' THEN 'Прочее оборудование'"
                + " END typeName";
        field_name = "s_eq.name";
        field_number = "''";
        field_numberOrder = "9999999";
        field_pk = "oe.equipment";

    } else if (type.equals(EquipmentObject.OBJECT_Switch)) {
        table = "switches sw";
        value_type = Storageplace_Type_Switch;
        field_typeOrder =
            "CASE sw.type WHEN "
                + Switch_Damps
                + " THEN 110"
                + " WHEN "
                + Switch_Gsm
                + " THEN 120 END typeOrder";
        field_typeName =
            "'Коммутатор '" + " ||DECODE(sw.type,'1','DAMPS','2','GSM/DCS','?') typeName";
        field_name = "s_eq.name";
        field_number = "cast(sw.number as CHAR(40))";
        field_numberOrder = "sw.number";
        field_pk = "sw.equipment";

    } else if (type.equals(EquipmentObject.OBJECT_Repeater)) {
        table = "repiters re";
        value_type = Storageplace_Type_Repeater;
        field_typeOrder =
            "1000 typeOrder";
        field_typeName =
            "'Репитер'";
        field_name = "''";
        field_number = "''";
        field_numberOrder = "9999999";
        field_pk = "re.equipment";

    }

}
}
