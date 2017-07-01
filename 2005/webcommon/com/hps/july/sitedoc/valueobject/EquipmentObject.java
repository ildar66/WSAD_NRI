package com.hps.july.sitedoc.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;

/**
 * Служебный класс для определения параметров отображаемого оборудования
 */
public class EquipmentObject
    extends JdbcObject
    implements Checks {

    private int id; //PK 1   
    private String posName; //2
    private String address; //3
    private String typeName; //4
    private String number; //5
    private String name; //6
    private int typeOrder; //7
    private int numberOrder; //8

    public final static String SEARCH_ALL = "all";

    public final static String SEARCHBY_NUMBER = "number";
    public final static String SEARCHBY_NAME = "name";
    public final static String SEARCHBY_ADDRESS = "address";

    public final static int ORDER_TYPE_NUMBER_ASC = 1;
    public final static int ORDER_TYPE_NUMBER_DESC = 2;
    public final static int ORDER_NAME_ASC = 3;
    public final static int ORDER_NAME_DESC = 4;

    public final static String[] objectAllTypes =
        new String[] {
            OBJECT_BS_DAMPS,
            OBJECT_BS_GSM,
            
            OBJECT_ComEquipment_Optic,
            
            OBJECT_ComEquipment_Radio,
            OBJECT_ComEquipment_Other,
            
            OBJECT_Controller,
            
            OBJECT_OtherEquipment,
            
            OBJECT_Switch,
            
            OBJECT_Repeater 
            };

    /**
     * PositionObject constructor comment.
     */
    public EquipmentObject() throws Exception {
        super();
    }
/**
 * PositionObject constructor comment.
 */
public EquipmentObject(java.sql.ResultSet rs) throws Exception {
    super();

    try {
        id = rs.getInt(1);
        posName = getString(rs, 2);
        address=getString(rs,3);
        typeName = getString(rs, 4);
        number = getString(rs, 5);
        name = getString(rs, 6);
        typeOrder=rs.getInt(7);
        numberOrder=rs.getInt(8);

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;

    }

}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2003 21:00:42)
 * @return com.hps.july.jdbcpersistence.lib.Query
 * @param type java.lang.String
 */
public Enumeration findEquipmentChoiceList(
    Integer sitedoc,
    java.lang.Boolean isAllNetZones,
    java.lang.Integer[] netZones,
    Boolean isAllObjectTypes,
    String[] objectTypes,
    Boolean isAllRegions,
    Integer[] regions,
    Boolean isAllSupregs,
    Integer[] supregs,
    String searchBy,
    String searchValue,
    Integer order)
    throws Exception {

    Query query = new Query();
    String[] types;
DebugSupport.printlnTest("!!!types="+objectTypes);
    if (!isAllObjectTypes.booleanValue()) {
        types = objectTypes;
        if (types==null||types.length == 0) {
            return new Vector().elements();
        }
    } else {
        types = objectAllTypes;

    }

    for (int i = 0; i < types.length; i++) {
        query.append(
            queryEquipmentChoice(
                sitedoc,
                isAllNetZones,
                netZones,
                types[i],
                isAllRegions,
                regions,
                isAllSupregs,
                supregs,
                searchBy,
                searchValue));
        if (i + 1 < types.length)
            query.append("UNION");
    }

    query.append(orderString(order.intValue()));

    return findEnumeration(query);
}
public Vector findPositionEquipmentByDocList(Integer sitedoc,Integer storageplace)
    throws Exception {
    try {
        Query query = queryPositionByDoc(sitedoc,storageplace);
        query.append("UNION");

        for (int i = 0; i < objectAllTypes.length; i++) {
            query.append(queryEquipmentByDoc(sitedoc,storageplace ,objectAllTypes[i]));
            if (i + 1 < objectAllTypes.length)
                query.append("UNION");
        }
        query.append(orderString(ORDER_TYPE_NUMBER_ASC));
        return findVector(query);
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:46:33)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @return java.lang.String
 */
public java.lang.String getPosName() {
	return posName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @return java.lang.String
 */
public java.lang.String getTypeName() {
	return typeName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @return int
 */
public int getTypeOrder() {
	return typeOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2003 21:00:42)
 * @return com.hps.july.jdbcpersistence.lib.Query
 * @param type java.lang.String
 */
private String orderString(int order) throws Exception {

    switch (order) {
        case ORDER_TYPE_NUMBER_ASC :
            {
                return "ORDER BY 7,8";
            }
        case ORDER_TYPE_NUMBER_DESC :
            {
                return "ORDER BY 7 DESC, 8 DESC";
            }
        case ORDER_NAME_ASC :
            {
                return "ORDER BY 6 ASC";
            }
        case ORDER_NAME_DESC :
            {
                return "ORDER BY 6 DESC";
            }

    }
    return "";

}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2003 21:00:42)
 * @return com.hps.july.jdbcpersistence.lib.Query
 * @param type java.lang.String
 */
private Query queryEquipmentByDoc(Integer sitedoc, Integer storageplace,String objectType) {

    EquipmentObjectFields obj = new EquipmentObjectFields(objectType);
    Query query = new Query();

    query.append(
        "SELECT"
            + " e.equipment id,"
            + " (CASE p.gsmid WHEN null THEN '' ELSE 'D' || p.gsmid||' ' END"
            + " ||"
            + " CASE p.dampsid WHEN null THEN '' ELSE 'A' || p.dampsid||' ' END"
            + " || s_pos.name) posName,");
    query.append(obj.field_address + ",");
    query.append(obj.field_typeName + ",");
    query.append(obj.field_number + ",");
    query.append(obj.field_name + ",");
    query.append(obj.field_typeOrder+",");
    query.append(obj.field_numberOrder);

    query.append(
        "FROM"
            + " equipment e,"
            + " positions p,"
            + " storageplaces s_eq,"
            + " storageplaces s_pos,");
    query.append(obj.table);

    query.append(
        " WHERE"
            + " p.storageplace=s_pos.storageplace"
            + " AND e.equipment=s_eq.storageplace"
            + " AND e.position=p.storageplace"
            + " AND p.planstate='2'");
    query.append("AND " + obj.field_pk + "=e.equipment");
    query.append("AND s_eq.type='" + obj.value_type+"'");
    query.append(
        !obj.specConditional.equals("") ? "AND " + obj.specConditional : "");

    query.append("AND EXISTS");
    query.append(
        "(SELECT * FROM sitedocs2splace link WHERE e.equipment=link.storageplace AND link.sitedoc=? AND link.storageplace<>?)",
        sitedoc,storageplace);

    return query;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2003 21:00:42)
 * @return com.hps.july.jdbcpersistence.lib.Query
 * @param type java.lang.String
 */
private Query queryEquipmentChoice(
    Integer sitedoc,
    java.lang.Boolean isAllNetZones,
    java.lang.Integer[] netZones,
    String objectType,
    Boolean isAllRegions,
    Integer[] regions,
    Boolean isAllSupregs,
    Integer[] supregs,
    String searchBy,
    String searchValue) {

    EquipmentObjectFields obj = new EquipmentObjectFields(objectType);
    Query query = new Query();

    query.append("SELECT" + " e.equipment id,");
    query.append(
        " (CASE p.gsmid WHEN null THEN '' ELSE 'D' || p.gsmid||' ' END"
            + " ||"
            + " CASE p.dampsid WHEN null THEN '' ELSE 'A' || p.dampsid||' ' END"
            + " || s_pos.name) posName,");
    query.append(obj.field_address + ",");
    query.append(obj.field_typeName + ",");
    query.append(obj.field_number + ",");
    query.append(obj.field_name + ",");
    query.append(obj.field_typeOrder+",");
    query.append(obj.field_numberOrder);
    query.append(
        "FROM"
            + " equipment e,"
            + " positions p,"
            + " storageplaces s_eq,"
            + " storageplaces s_pos,"
            + " netzones n,"
            + " Regions r,"
            + " SuperRegions sr,");
    query.append(obj.table);

    query.append(
        " WHERE"
            + " p.storageplace=s_pos.storageplace"
            + " AND e.equipment=s_eq.storageplace"
            + " AND sr.supregid=r.supregid"
            + " AND n.netzone = p.netzone"
            + " AND r.regionid = p.regionid"
            + " AND e.position=p.storageplace"
            + " AND p.planstate='2'");
    query.append("AND " + obj.field_pk + "=e.equipment");
    query.append("AND s_eq.type='" + obj.value_type + "'");
    query.append(
        !obj.specConditional.equals("") ? "AND " + obj.specConditional : "");

    query.append("AND NOT EXISTS");
    query.append(
        " (SELECT * FROM sitedocs2splace link WHERE e.equipment=link.storageplace AND link.sitedoc=?)",
        sitedoc);

    if (!isAllRegions.booleanValue()) {

        query.append("AND p.regionid IN", regions);

    } else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {

        query.append("AND sr.supregid IN", supregs);

    }
    if (!isAllNetZones.booleanValue()) {
        query.append("AND p.netzone IN", netZones);

    }

    String field = null;
    if (searchBy.equals(SEARCHBY_ADDRESS))
        field = obj.field_address;
    else if (searchBy.equals(SEARCHBY_NAME))
        field = obj.field_name;
    else if (searchBy.equals(SEARCHBY_NUMBER))
        field = obj.field_number;

    if (field != null)
        query.append(
            "AND " + field + (field.equals(obj.field_number) ? "=" : " MATCHES ") + "?",
            searchValue);

    return query;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2003 21:00:42)
 * @return com.hps.july.jdbcpersistence.lib.Query
 * @param type java.lang.String
 */
private Query queryPositionByDoc(Integer sitedoc,Integer storageplace) {

    Query query = new Query();

    query.append("SELECT" + " p.storageplace id,");
    query.append("'' posName,");

    query.append("'' address" + ",");

    query.append("'Позиция' typeName,");
    query.append("'' number,");

    query.append(
        " (CASE p.gsmid WHEN null THEN '' ELSE 'D' || p.gsmid||' ' END"
            + " ||"
            + " CASE p.dampsid WHEN null THEN '' ELSE 'A' || p.dampsid||' ' END"
            + " || s_pos.name) name,");

    query.append("0 typeOrder,");
    query.append("9999999");

    query.append(
        "FROM" + " positions p," +  " storageplaces s_pos");

    query.append(
        " WHERE" + " p.storageplace=s_pos.storageplace" + " AND p.planstate='2'");
    
    query.append("AND EXISTS");
    query.append(
        "(SELECT * FROM sitedocs2splace link WHERE p.storageplace=link.storageplace AND link.sitedoc=? AND link.storageplace<>?)",
        sitedoc,storageplace);

    return query;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @param newPosName java.lang.String
 */
public void setPosName(java.lang.String newPosName) {
	posName = newPosName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @param newTypeName java.lang.String
 */
public void setTypeName(java.lang.String newTypeName) {
	typeName = newTypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2003 11:41:50)
 * @param newTypeOrder int
 */
public void setTypeOrder(int newTypeOrder) {
	typeOrder = newTypeOrder;
}
}
