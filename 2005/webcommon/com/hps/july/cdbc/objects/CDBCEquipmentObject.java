package com.hps.july.cdbc.objects;

import java.util.LinkedList;
import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с оборудованием на позициях.
 * Содержит методы предостовляющие различные списки.
 * Creation date: (22.03.2004)
 * @author: Anthon Stefanov
 */
public class CDBCEquipmentObject {
	private static final String QUERY = 
		"SELECT e.equipment, sp.type, "+
		" CASE sp.type "+
		" WHEN 'W' THEN (SELECT CASE sw.type WHEN '1' THEN 11  WHEN '2' THEN 10 ELSE 12 END FROM switches sw WHERE sw.equipment = e.equipment) "+
		" WHEN 'O' THEN 20 "+
		" WHEN 'B' THEN (SELECT CASE bs.type WHEN 'D' THEN 33 WHEN 'S' THEN 30 WHEN 'C' THEN 31 WHEN 'G' THEN 32 ELSE 34 END FROM basestations bs WHERE bs.equipment = e.equipment)  "+
		" WHEN 'R' THEN 40 "+
		" WHEN 'C' THEN 50 "+
		" WHEN 'T' THEN 60 "+
		" WHEN 'L' THEN 70 "+
		" ELSE  80 "+
		" END typeorder, "+
		" 'equipment.type.' || NVL(LOWER(sp.type),'unknown') equtype, "+
		" CASE sp.type "+
		" WHEN 'B' THEN (SELECT CASE bs.type WHEN 'D' THEN 'label.equipment.stationdamps' WHEN 'S' THEN 'label.equipment.stationgsm' WHEN 'C' THEN 'label.equipment.stationdcs' WHEN 'G' THEN 'label.equipment.stationboth' ELSE '' END FROM basestations bs WHERE bs.equipment = e.equipment) "+
		" WHEN 'C' THEN (SELECT 'comequipment.type.' || NVL(UPPER(cm.type),'unknown') FROM comequipment cm WHERE cm.equipment = e.equipment) "+
		" WHEN 'O' THEN '' "+ 
		" WHEN 'W' THEN (SELECT CASE sw.type WHEN '1' THEN 'label.equipment.switchdamps' WHEN '2' THEN 'label.equipment.switchgsm' ELSE '' END FROM switches sw WHERE sw.equipment = e.equipment) "+
		" WHEN 'T' THEN (SELECT 'otherequipment.type.' || NVL(LOWER(oe.type),'unknown') FROM otherequipment oe WHERE oe.equipment = e.equipment) "+
		" WHEN 'R' THEN '' "+
		" WHEN 'L' THEN '' "+
		" ELSE NULL "+
		" END equsubtype, "+
		" CASE sp.type "+
		" WHEN 'B' THEN (SELECT bs.number FROM basestations bs WHERE bs.equipment = e.equipment) "+
		" WHEN 'C' THEN NULL "+
		" WHEN 'O' THEN (SELECT cn.number FROM controllers cn WHERE cn.equipment = e.equipment) "+
		" WHEN 'W' THEN (SELECT sw.number FROM switches sw WHERE sw.equipment = e.equipment) "+
		" WHEN 'L' THEN (SELECT wl.number FROM wlan wl WHERE wl.equipment = e.equipment) "+
		" WHEN 'R' THEN (SELECT rp.number FROM repiters rp WHERE rp.equipment = e.equipment) "+
		" ELSE NULL "+
		" END equnumber, "+
		" CASE sp.type "+
		" WHEN 'B' THEN (SELECT TRIM(bs.name) FROM basestations bs WHERE bs.equipment = e.equipment) "+
		" WHEN 'C' THEN (SELECT CASE cm.type WHEN 'O' THEN TRIM(sp.name) || NVL(' (' || TRIM(cm.osinvname) || ')','') ELSE TRIM(sp.name) END FROM comequipment cm WHERE cm.equipment = e.equipment) "+
		" WHEN 'O' THEN (SELECT TRIM(cn.name) FROM controllers cn WHERE cn.equipment = e.equipment) "+
		" WHEN 'W' THEN TRIM(sp.name) "+
		" WHEN 'T' THEN '' "+
		" WHEN 'R' THEN (SELECT TRIM(r.model) FROM repiters rp,resources r  WHERE rp.equipment = e.equipment AND rp.resource = r.resource) "+
		" WHEN 'L' THEN TRIM(sp.name) "+
		" ELSE TRIM(sp.name) "+
		" END equname, "+
		" 'label.equipment.state' || NVL(LOWER(e.state),'unknown') equstate, "+
		" TRIM(e.equipcomment) equipcomment, "+
		" (SELECT sum(sc.qty) FROM storagecards sc WHERE sc.storageplace = e.equipment AND sc.closed = 'N' AND  NOT EXISTS (SELECT agregate FROM agregatecontents agr WHERE agr.agregatepart = sc.storagecard)) agrcount "+
		" FROM equipment e, storageplaces sp "+
		" WHERE e.equipment = sp.storageplace ";

	public final static String SEARCH_ALL = "all";
    public final static String SEARCHBY_NUMBER = "number";
    public final static String SEARCHBY_NAME = "name";
    public final static String SEARCHBY_ADDRESS = "address";
	public final static String SEARCHBY_PREFCELLID = "prefcellid";
    public final static String TYPE_SEARCH_GSM = "gsm";
    public final static String TYPE_SEARCH_DAMPS = "damps";
    public final static String ONAIR_CHECK_Y = "Y";
    public final static String ONAIR_CHECK_N = "N";
    public final static int ORDER_NUMBER_ASC = 1;
    public final static int ORDER_NUMBER_DESC = 2;
    public final static int ORDER_NAME_ASC = 3;
    public final static int ORDER_NAME_DESC = 4;

	private static final String BS_USER_QUERY =
		"SELECT DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') type, DECODE(bs.on_air,'Y','Y','') onair, "+
		"CASE(CASE ra.editfact WHEN NULL THEN 'N' ELSE ra.editfact END)||(CASE sra.editfact WHEN NULL THEN 'N' ELSE sra.editfact END) WHEN 'NN' THEN 'N' ELSE 'Y' END edit, "+
		"bs.equipment, bs.number, TRIM(bs.name) name, TRIM(s.address) address, TRIM(n.name) zonecode, p.storageplace positionid, e.state bsstate, CASE bs.type WHEN 'D' THEN '' ELSE NVL(bs.prefixcellid,'') END prefixcellid "+
		"FROM basestations bs,equipment e,positions p,storageplaces s,netzones n, "+
		"operators o, regions r, outer regionsaccess sra, outer regionsaccess ra "+
		"WHERE s.storageplace = p.storageplace AND n.netzone = p.netzone AND e.equipment = bs.equipment AND e.position = p.storageplace "+
		"AND r.regionid = p.regionid "+
		"AND sra.accesstype = 'S' AND sra.supregionid = r.supregid AND sra.operatorid = o.operator "+
		"AND ra.accesstype = 'R' AND ra.regionid = r.regionid AND ra.operatorid = o.operator "+
		"AND (r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = o.operator)) ";
	private static final String RP_USER_QUERY =
		"SELECT  "+
		"CASE(CASE ra.editfact WHEN NULL THEN 'N' ELSE ra.editfact END)||(CASE sra.editfact WHEN NULL THEN 'N' ELSE sra.editfact END) WHEN 'NN' THEN 'N' ELSE 'Y' END edit, "+
		"rp.equipment, rp.number, TRIM(s.name) name, TRIM(s.address) address, TRIM(n.name) zonecode, p.storageplace positionid, e.state rpstate  "+
		"FROM repiters rp,equipment e,positions p,storageplaces s,netzones n, "+
		"operators o, regions r, outer regionsaccess sra, outer regionsaccess ra "+
		"WHERE s.storageplace = p.storageplace AND n.netzone = p.netzone AND e.equipment = rp.equipment AND e.position = p.storageplace "+
		"AND r.regionid = p.regionid "+
		"AND sra.accesstype = 'S' AND sra.supregionid = r.supregid AND sra.operatorid = o.operator "+
		"AND ra.accesstype = 'R' AND ra.regionid = r.regionid AND ra.operatorid = o.operator "+
		"AND (r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = o.operator)) ";

	private static final String BS_ADMIN_QUERY =
		"SELECT DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') type, DECODE(bs.on_air,'Y','Y','') onair, "+
		"'Y' edit, "+
		"bs.equipment, bs.number, TRIM(bs.name) name, TRIM(s.address) address, TRIM(n.name) zonecode, p.storageplace positionid, e.state bsstate, CASE bs.type WHEN 'D' THEN '' ELSE NVL(bs.prefixcellid,'') END prefixcellid "+
		"FROM basestations bs,equipment e,positions p, storageplaces s, netzones n, regions r "+
		"WHERE s.storageplace = p.storageplace AND n.netzone = p.netzone AND e.equipment = bs.equipment AND e.position = p.storageplace "+
		"AND r.regionid = p.regionid ";
	private static final String RP_ADMIN_QUERY =
		"SELECT  "+
		"'Y' edit, "+
		"rp.equipment, rp.number, TRIM(s.name) name, TRIM(s.address) address, TRIM(n.name) zonecode, p.storageplace positionid, e.state rpstate  "+
		"FROM repiters rp,equipment e,positions p, storageplaces s, netzones n, regions r "+
		"WHERE s.storageplace = p.storageplace AND n.netzone = p.netzone AND e.equipment = rp.equipment AND e.position = p.storageplace "+
		"AND r.regionid = p.regionid ";

	private static final String[] NUMSECT2LETT =
		{ "O", "A", "B", "C", "D", "E", "F", "G", "H", "O", "O", "A", "B", "C", "D", "E", "F", "G", "H" };
/**
 * CDBCPositionObject constructor comment.
 */
public CDBCEquipmentObject() {
	super();
}
public static void appendIN(StringBuffer sb, String param, Integer[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		sb.append(param);
		sb.append(" IS NULL ");
	} else {
		sb.append(param);
		sb.append(" IN (");
		for(int i = 0; i < array.length; i++) {
			if(i > 0) sb.append(",");
			if(array[i] != null) {
				sb.append(array[i]);
			} else {
				sb.append(array[i]);
			}
		}
		sb.append(") ");
	}
}
public boolean deleteComEquipment2Beenet(Integer comequipment)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("DELETE FROM beenet2equip WHERE ");
	if(comequipment != null) {
		sqlb.append("equipment = ? ");
		params.add(comequipment);
	} else {
		sqlb.append("equipment IS NULL ");
	}

	CDBCResultSet res = new CDBCResultSet();
	boolean r = res.executeUpdate(sqlb.toString(), params.toArray());
	return r;
}
/**
 * Выбор контроллеров, находящихся на незакрытый позициях по параметрам фильтра
 * @TODO: Написать описание параметров
 *
 * Возвращаемые колонки:
 * contrcode		-
 * contrnumber		-
 * contrname		-
 * contrposname		-
 * equstate			-
 * swcode			-
 * swnumber			-
 * swname			-
 * swposname		-
 */
public CDBCResultSet findActiveControllerByBS(Integer bsnumber, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT c.equipment contrcode, c.number contrnumber, TRIM(c.name) contrname, bs.number bsnum, NVL('D'  || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) contrposname, e.state equstate ");
	sb.append("FROM basestations bs, controllers c, equipment e, positions p, storageplaces sp ");
	sb.append("WHERE c.equipment = e.equipment AND c.equipment = bs.controller AND e.position = p.storageplace AND p.posstate IN ('P','E') AND p.storageplace = sp.storageplace ");

	if(bsnumber != null) {
		sb.append("AND bs.number  = ? ");
		params.add(bsnumber);
	} else {
		sb.append("AND bs.number IS NULL ");
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY contrnumber ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY contrnumber DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY contrname ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY contrname DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findActiveControllerByGSMID(Integer gsmid, Integer order)
{
/*
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT c.equipment contrcode, c.number contrnumber, TRIM(c.name) contrname, bs.number bsnum, NVL('D'  || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) contrposname, e.state equstate ");
	sb.append("FROM basestations bs, controllers c, equipment e, positions p, storageplaces sp ");
	sb.append("WHERE c.equipment = e.equipment AND c.equipment = bs.controller AND e.position = p.storageplace AND p.posstate IN ('P','E') AND p.storageplace = sp.storageplace ");

	if(bsnumber != null) {
		sb.append("AND bs.number  = ? ");
		params.add(bsnumber);
	} else {
		sb.append("AND bs.number IS NULL ");
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY contrnumber ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY contrnumber DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY contrname ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY contrname DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
*/
	return null;
}
/**
 * Выбор контроллеров, находящихся на незакрытый позициях по параметрам фильтра
 * @TODO: Написать описание параметров
 *
 * Возвращаемые колонки:
 * contrcode		-
 * contrnumber		-
 * contrname		-
 * contrposname		-
 * equstate			-
 * swcode			-
 * swnumber			-
 * swname			-
 * swposname		-
 */
public CDBCResultSet findActiveControllerLookup(
	Boolean useNumber, Integer number, 
	Boolean usepos, Integer posid,
	Boolean useControllerid, Integer contrid,
	Integer order
) {
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT p.storageplace storagepl, p.gsmid gsm, TRIM(sp.name) || NVL(', ' || TRIM(p.dampsname),'') posname,c.equipment contrcode, c.number contrnumber, TRIM(c.name) contrname, NVL('D'  || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) contrposname, e.state equstate, ");
	sb.append("c.switch swcode, sw.number swnumber, TRIM(swsp.name) swname, NVL('D'  || swp.gsmid || ' ','') ||  NVL('A' || swp.dampsid || ' ','') || TRIM(swpsp.name) swposname ");
	sb.append("FROM controllers c, equipment e, positions p, storageplaces sp, outer (switches sw, equipment swe, storageplaces swsp, positions swp, storageplaces swpsp) ");
	sb.append("WHERE c.equipment = e.equipment AND e.position = p.storageplace AND p.storageplace = sp.storageplace ");
	sb.append(" AND p.posstate IN ('P', 'E') ");
	sb.append("AND c.switch = sw.equipment AND swe.equipment = sw.equipment AND sw.equipment = swsp.storageplace AND swe.position = swp.storageplace AND swp.storageplace = swpsp.storageplace ");

	if(usepos != null && usepos.booleanValue()) {
		if(posid != null) {
			sb.append("AND p.storageplace = ? ");
			params.add(posid);
		} else {
			sb.append("AND p.storageplace IS NULL ");
		}
	}

	if(useControllerid != null && useControllerid.booleanValue()) {
		if(contrid != null) {
			sb.append("AND c.equipment = ? ");
			params.add(contrid);
		} else {
			sb.append("AND c.equipment IS NULL ");
		}
	} else
	if(useNumber != null && useNumber.booleanValue()) {
		if(number != null) {
			sb.append("AND c.number = ? ");
			params.add(number);
		} else {
			sb.append("AND c.number IS NULL ");
		}
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY contrnumber ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY contrnumber DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY contrname ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY contrname DESC ");
			break;
	    }
	}

System.out.println("SQL:\n"+sb.toString());
for(int i = 0; i < params.size(); i++) {
System.out.println("PARAM[i]:"+params.get(i));
}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор контроллеров, находящихся на незакрытый позициях по параметрам фильтра
 * @TODO: Написать описание параметров
 *
 * Возвращаемые колонки:
 * contrcode		-
 * contrnumber		-
 * contrname		-
 * contrposname		-
 * equstate			-
 * swcode			-
 * swnumber			-
 * swname			-
 * swposname		-
 */
public CDBCResultSet findActiveControllerLookup(Boolean useNumber, Integer number, Boolean usepos, Integer posid, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT c.equipment contrcode, c.number contrnumber, TRIM(c.name) contrname, NVL('D'  || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) contrposname, e.state equstate, ");
	sb.append("c.switch swcode, sw.number swnumber, TRIM(swsp.name) swname, NVL('D'  || swp.gsmid || ' ','') ||  NVL('A' || swp.dampsid || ' ','') || TRIM(swpsp.name) swposname ");
	sb.append("FROM controllers c, equipment e, positions p, storageplaces sp, outer (switches sw, equipment swe, storageplaces swsp, positions swp, storageplaces swpsp) ");
	sb.append("WHERE c.equipment = e.equipment AND e.position = p.storageplace AND p.storageplace = sp.storageplace ");
	sb.append(" AND p.posstate IN ('P', 'E') ");
	sb.append("AND c.switch = sw.equipment AND swe.equipment = sw.equipment AND sw.equipment = swsp.storageplace AND swe.position = swp.storageplace AND swp.storageplace = swpsp.storageplace ");

	if(useNumber != null && useNumber.booleanValue()) {
		if(number != null) {
			sb.append("AND c.number = ? ");
			params.add(number);
		} else {
			sb.append("AND c.number IS NULL ");
		}
	}

	if(usepos != null && usepos.booleanValue()) {
		if(posid != null) {
			sb.append("AND p.storageplace = ? ");
			params.add(posid);
		} else {
			sb.append("AND p.storageplace IS NULL ");
		}
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY contrnumber ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY contrnumber DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY contrname ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY contrname DESC ");
			break;
	    }
	}

System.out.println("SQL:\n"+sb.toString());
for(int i = 0; i < params.size(); i++) {
System.out.println("PARAM[i]:"+params.get(i));
}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор контроллеров, находящихся на незакрытый позициях по параметрам фильтра
 * @TODO: Написать описание параметров
 *
 * Возвращаемые колонки:
 * contrcode		-
 * contrnumber		-
 * contrname		-
 * contrposname		-
 * equstate			-
 * swcode			-
 * swnumber			-
 * swname			-
 * swposname		-
 */
public CDBCResultSet findActiveControllerLookup(Boolean useNumber, Integer number, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT c.equipment contrcode, c.number contrnumber, TRIM(c.name) contrname, NVL('D'  || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) contrposname, e.state equstate, ");
	sb.append("c.switch swcode, sw.number swnumber, TRIM(swsp.name) swname, NVL('D'  || swp.gsmid || ' ','') ||  NVL('A' || swp.dampsid || ' ','') || TRIM(swpsp.name) swposname ");
	sb.append("FROM controllers c, equipment e, positions p, storageplaces sp, outer (switches sw, equipment swe, storageplaces swsp, positions swp, storageplaces swpsp) ");
	sb.append("WHERE c.equipment = e.equipment AND e.position = p.storageplace AND p.storageplace = sp.storageplace ");
	sb.append(" AND p.posstate IN ('P', 'E') ");
	sb.append("AND c.switch = sw.equipment AND swe.equipment = sw.equipment AND sw.equipment = swsp.storageplace AND swe.position = swp.storageplace AND swp.storageplace = swpsp.storageplace ");

	if(useNumber != null && useNumber.booleanValue()) {
		if(number != null) {
			sb.append("AND c.number = ? ");
			params.add(number);
		} else {
			sb.append("AND c.number IS NULL ");
		}
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY contrnumber ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY contrnumber DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY contrname ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY contrname DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор базовых станций по параметрам фильтра
 * @TODO: Написать описание параметров
 *
 * Возвращаемые колонки:
 * contrcode		-
 * contrnumber		-
 * contrname		-
 * contrposname		-
 * equstate			-
 * swcode			-
 * swnumber			-
 * swname			-
 * swposname		-
 */
public CDBCResultSet findBaseStationAntennes(Integer baseStation, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT s.id_sect, TRIM(s.num_sect) num_sect, TRIM(s.name_sect) name_sect, s.band, s.trx_num, ");
	sb.append("s.trx_num2, s.trx_num, s.trx_ovr_num, TRIM(s.bts_number) btsnumber, bs.type, ");
	sb.append("CASE bs.type ");
	sb.append("WHEN 'D' THEN NVL(s.trx_num2 || 'A','') || NVL('/' || s.trx_num || 'D','') || NVL('/' || s.trx_ovr_num || 'O','') ");
	sb.append("ELSE NVL(s.trx_num, '') ");
	sb.append("END trxstring ");
	sb.append("FROM sectors s, basestations bs ");
	sb.append("WHERE s.equipment = bs.equipment ");

	if(baseStation != null) {
		sb.append("AND s.equipment = ? ");
		params.add(baseStation);
	} else {
		sb.append("AND s.equipment IS NULL ");
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case 1:
			sb.append("ORDER BY name_sect ASC, num_sect ASC ");
			break;
		case 2:
			sb.append("ORDER BY name_sect DESC, num_sect DESC ");
			break;
		case 3:
			sb.append("ORDER BY num_sect ASC, name_sect ASC ");
			break;
		case 4:
			sb.append("ORDER BY num_sect DESC, name_sect DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор базовых станций по параметрам фильтра
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findBaseStations(
	Boolean isAllNetZones,
	Integer[] netZones,
	String type,
	Boolean isAllRegions,
	Integer[] regions,
	Boolean isAllSupregs,
	Integer[] supregs,
	String searchBy,
	String searchValue,
	Boolean isAllSwitches,
	Integer aSwitch,
	Boolean isAllControllers,
	Integer aController,
	Boolean isAllStates,
	String state,
	String posstate,
	String onair,
	Boolean isAdmin,
	String login,
	Integer order
)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(BS_ADMIN_QUERY);
	} else {
		sb.append(BS_USER_QUERY);
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}
	
    if (!isAllStates.booleanValue()) {
	    if(state != null) {
			CDBCPositionObject.appendIN(sb, " AND e.state ", CDBCPositionObject.getPosstateList(state));
			//sb.append("AND e.state = ? ");
			//params.add(state);
	    } else {
		    sb.append("AND e.state IS NULL ");
	    }
    }

    if (!isAllRegions.booleanValue()) {
		CDBCPositionObject.appendIN(sb,"AND p.regionid ",regions);
	} else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
		CDBCPositionObject.appendIN(sb,"AND r.supregid ", supregs);
	}

	if (isAllNetZones != null && !isAllNetZones.booleanValue()) {
		CDBCPositionObject.appendIN(sb, "AND p.netzone ", netZones);
	}

	if (posstate != null && !"*".equals(posstate)) {
		CDBCPositionObject.appendIN(sb, "AND p.posstate ", CDBCPositionObject.getPosstateList(posstate));
	}

    String field = null;
	if(searchBy.equals(SEARCHBY_ADDRESS)) {
		sb.append("AND s.address MATCHES ? ");
		params.add(searchValue);
    } else if(searchBy.equals(SEARCHBY_NAME)) {
		sb.append("AND bs.name MATCHES ? ");
		params.add(searchValue);
	} else if(searchBy.equals(SEARCHBY_NUMBER)) {
		sb.append("AND bs.number = ? ");
		params.add(searchValue);
    } else if(searchBy.equals(SEARCHBY_PREFCELLID)) {
	    sb.append("AND bs.prefixcellid = ? ");
	    params.add(searchValue);
    }

	if(type.equals(TYPE_SEARCH_DAMPS)) {
		sb.append("AND bs.type = 'D' ");
	} else if (type.equals(TYPE_SEARCH_GSM)) {
		sb.append("AND bs.type IN ('C','S','G') ");
	}

	if(!isAllControllers.booleanValue()) {
		sb.append("AND bs.controller = ? ");
		params.add(aController);
	}
	if(!isAllSwitches.booleanValue()) {
		sb.append("AND bs.switch = ? ");
		params.add(aSwitch);
	}

	if (ONAIR_CHECK_Y.equals(onair)) {
		sb.append("AND bs.on_air = 'Y' ");
	} else if (ONAIR_CHECK_N.equals(onair)) {
		sb.append("AND (bs.on_air = 'N' OR bs.on_air IS NULL) ");
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY bs.number ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY bs.number DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY name ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY name DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	//System.out.println("CDBCEquipment: " + sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор базовых станций по параметрам фильтра
 * @TODO: Написать описание параметров
 *
 * Возвращаемые колонки:
 * contrcode		-
 * contrnumber		-
 * contrname		-
 * contrposname		-
 * equstate			-
 * swcode			-
 * swnumber			-
 * swname			-
 * swposname		-
 */
public CDBCResultSet findBaseStationSectors(Integer baseStation, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT s.id_sect, TRIM(s.num_sect) num_sect, TRIM(s.name_sect) name_sect, s.band, s.trx_num, ");
	sb.append("s.trx_num2, s.trx_num, s.trx_ovr_num, TRIM(s.bts_number) btsnumber, bs.type, ");
	sb.append("CASE bs.type ");
	sb.append("WHEN 'D' THEN NVL(s.trx_num2 || 'A','') || NVL('/' || s.trx_num || 'D','') || NVL('/' || s.trx_ovr_num || 'O','') ");
	sb.append("ELSE NVL(s.trx_num, '') ");
	sb.append("END trxstring, ");
	sb.append("s.lac ");
	sb.append("FROM sectors s, basestations bs ");
	sb.append("WHERE s.equipment = bs.equipment ");

	if(baseStation != null) {
		sb.append("AND s.equipment = ? ");
		params.add(baseStation);
	} else {
		sb.append("AND s.equipment IS NULL ");
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case 1:
			sb.append("ORDER BY name_sect ASC, num_sect ASC ");
			break;
		case 2:
			sb.append("ORDER BY name_sect DESC, num_sect DESC ");
			break;
		case 3:
			sb.append("ORDER BY num_sect ASC, name_sect ASC ");
			break;
		case 4:
			sb.append("ORDER BY num_sect DESC, name_sect DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор базовых станций по параметрам фильтра
 * @TODO: Написать описание параметров
 *
 * Возвращаемые колонки:
 * contrcode		-
 * contrnumber		-
 * contrname		-
 * contrposname		-
 * equstate			-
 * swcode			-
 * swnumber			-
 * swname			-
 * swposname		-
 */
public CDBCResultSet findControllerLookup(Boolean useNumber, Integer number, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT c.equipment contrcode, c.number contrnumber, TRIM(c.name) contrname, NVL('D'  || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) contrposname, e.state equstate, ");
	sb.append("c.switch swcode, sw.number swnumber, TRIM(swsp.name) swname, NVL('D'  || swp.gsmid || ' ','') ||  NVL('A' || swp.dampsid || ' ','') || TRIM(swpsp.name) swposname ");
	sb.append("FROM controllers c, equipment e, positions p, storageplaces sp, outer (switches sw, equipment swe, storageplaces swsp, positions swp, storageplaces swpsp) ");
	sb.append("WHERE c.equipment = e.equipment AND e.position = p.storageplace AND p.storageplace = sp.storageplace ");
	sb.append("AND c.switch = sw.equipment AND swe.equipment = sw.equipment AND sw.equipment = swsp.storageplace AND swe.position = swp.storageplace AND swp.storageplace = swpsp.storageplace ");

	if(useNumber != null && useNumber.booleanValue()) {
		if(number != null) {
			sb.append("AND c.number = ? ");
			params.add(number);
		} else {
			sb.append("AND c.number IS NULL ");
		}
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY contrnumber ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY contrnumber DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY contrname ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY contrname DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findEquipmentAgregateContents(Integer storagecard, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT sc.storagecard, sc.comment, TRIM(r.name) name, TRIM(r.model) model, sc.policy, sc.isfictserial, serial_for_sc(sc.storagecard) sn, sc.qty, TRIM(sc.place) place ");
	sb.append("FROM agregatecontents agc, storagecards sc, resources r ");
	sb.append("WHERE agc.agregatepart = sc.storagecard AND sc.closed = 'N' AND sc.resource = r.resource ");

	if(storagecard != null) {
		sb.append("AND agc.agregate = ? ");
		params.add(storagecard);
	} else {
		sb.append("AND agc.agregate IS NULL ");
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case 1:
			sb.append("ORDER BY name ASC, model ASC ");
			break;
		case 2:
			sb.append("ORDER BY name DESC, model DESC ");
			break;
		case 3:
			sb.append("ORDER BY sn ASC ");
			break;
		case 4:
			sb.append("ORDER BY sn DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findEquipmentAgregates(Integer storageplace, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT sc.storagecard, TRIM(r.name) name, TRIM(r.model) model, ");
	sb.append("sc.policy, sc.isfictserial, serial_for_sc(sc.storagecard) sn, sc.qty, ");
	sb.append("(SELECT sum(qty) FROM agregatecontents WHERE agregate = sc.storagecard) contents, ");
	sb.append("sc.place, sc.comment ");
	sb.append("FROM storagecards sc, resources r ");
	sb.append("WHERE sc.closed = 'N' AND sc.resource = r.resource ");
	sb.append("AND NOT EXISTS (SELECT agregate FROM agregatecontents WHERE agregatepart = sc.storagecard) ");

	if(storageplace != null) {
		sb.append("AND sc.storageplace = ? ");
		params.add(storageplace);
	} else {
		sb.append("AND sc.storageplace IS NULL ");
	}

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case 1:
			sb.append("ORDER BY name ASC, model ASC ");
			break;
		case 2:
			sb.append("ORDER BY name DESC, model DESC ");
			break;
		case 3:
			sb.append("ORDER BY sn ASC ");
			break;
		case 4:
			sb.append("ORDER BY sn DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findEquipmentAgregatesList(Integer[] storageplace, Integer order)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT sc.storageplace, sc.storagecard, ");
	sb.append("CASE sp.type ");
	sb.append("WHEN 'P' THEN (SELECT NVL('A'||p.dampsid||' ','') || NVL('D' || p.gsmid || ' ', '') || TRIM(s.name) FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) ");
	sb.append("WHEN 'S' THEN sp.name ");
	sb.append("WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) FROM expedition e, outer organizations o, outer (workers w, people p) WHERE o.organization = e.organization AND e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace) ");
	sb.append("WHEN 'E' THEN sp.name ");
	sb.append("WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = sp.storageplace) ");
	sb.append("WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(sp.name) FROM comequipment ce WHERE ce.equipment = sp.storageplace) ");
	sb.append("WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = sp.storageplace) ");
	sb.append("WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM(sp.name) FROM switches s WHERE s.equipment = sp.storageplace) ");
	sb.append("WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = sp.storageplace) ");
	sb.append("WHEN 'R' THEN (SELECT 'Репитер ' || TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = sp.storageplace AND rp.resource = r.resource) ");
	sb.append("WHEN 'L' THEN (SELECT 'WLAN ' || TRIM(sp.name) || NVL(' '||w.number,'') FROM wlan w  WHERE w.equipment = sp.storageplace) ");
	sb.append("END complectname, ");
	sb.append("TRIM(r.name) name, TRIM(r.model) model, ");
	sb.append("sc.policy, sc.isfictserial, serial_for_sc(sc.storagecard) sn, sc.qty, ");
	sb.append("(SELECT sum(qty) FROM agregatecontents WHERE agregate = sc.storagecard) contents, ");
	sb.append("sc.place, sc.comment ");
	sb.append("FROM storagecards sc, resources r, storageplaces sp ");
	sb.append("WHERE sc.closed = 'N' AND sc.resource = r.resource AND sp.storageplace = sc.storageplace ");
	sb.append("AND NOT EXISTS (SELECT agregate FROM agregatecontents WHERE agregatepart = sc.storagecard) ");

	appendIN(sb,"AND sc.storageplace ",storageplace);

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case 1:
			sb.append("ORDER BY complectname ASC, name ASC, model ASC ");
			break;
		case 2:
			sb.append("ORDER BY complectname DESC, name DESC, model DESC ");
			break;
		case 3:
			sb.append("ORDER BY sn ASC ");
			break;
		case 4:
			sb.append("ORDER BY sn DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findPositionBS(Integer position, Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(QUERY);

	sqlb.append("AND sp.type = 'B' ");
	
	if(position != null) {
		sqlb.append("AND e.position = ? ");
		params.add(position);
	} else {
		sqlb.append("AND e.position IS NULL ");
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY typeorder ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY typeorder DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY equnumber ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY equnumber DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY equname ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY equname DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findPositionComEquipment(Integer position, Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT e.equipment, sp.type, ");
	sqlb.append("'comequipment.type.' || NVL(UPPER(ce.type),'unknown') equsubtype, ");
	sqlb.append("TRIM(sp.name) equname, ");
	sqlb.append("'label.equipment.state' || NVL(LOWER(e.state),'unknown') equstate, ");
	sqlb.append("TRIM(e.equipcomment) equipcomment, ");
	sqlb.append("(SELECT sum(sc.qty) FROM storagecards sc WHERE sc.storageplace = e.equipment AND sc.closed = 'N' AND  NOT EXISTS (SELECT agregate FROM agregatecontents agr WHERE agr.agregatepart = sc.storagecard)) agrcount ");
	sqlb.append("FROM equipment e, comequipment ce, storageplaces sp ");
	sqlb.append("WHERE e.equipment = sp.storageplace AND e.equipment = ce.equipment ");

	if(position != null) {
		sqlb.append("AND e.position = ? ");
		params.add(position);
	} else {
		sqlb.append("AND e.position IS NULL ");
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY equname ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY equname DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findPositionEquipment(Integer position, Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(QUERY);

	if(position != null) {
		sqlb.append("AND e.position = ? ");
		params.add(position);
	} else {
		sqlb.append("AND e.position IS NULL ");
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY typeorder ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY typeorder DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY equnumber ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY equnumber DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY equname ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY equname DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findRepeaterList(
	Boolean isAllNetZones, Integer[] netZones,
	Boolean isAllRegions, Integer[] regions,
	Boolean isAllSupregs, Integer[] supregs,
	String searchBy, String searchValue,
	Boolean isAllStates, String state,
	String posstate,
	Boolean isAdmin,	String login,
	Integer order
)  {
	
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(RP_ADMIN_QUERY);
	} else {
		sb.append(RP_USER_QUERY);
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}
	
    if (!isAllStates.booleanValue()) {
	    if(state != null) {
			sb.append("AND e.state = ? ");
			params.add(state);
	    } else {
		    sb.append("AND e.state IS NULL ");
	    }
    }

    if (!isAllRegions.booleanValue()) {
		CDBCPositionObject.appendIN(sb,"AND p.regionid ",regions);
	} else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
		CDBCPositionObject.appendIN(sb,"AND r.supregid ", supregs);
	}

	if (isAllNetZones != null && !isAllNetZones.booleanValue()) {
		CDBCPositionObject.appendIN(sb, "AND p.netzone ", netZones);
	}

	if (posstate != null && !"*".equals(posstate)) {
		CDBCPositionObject.appendIN(sb, "AND p.posstate ", CDBCPositionObject.getPosstateList(posstate));
	}

    String field = null;
	if(searchBy.equals(SEARCHBY_ADDRESS)) {
		sb.append("AND s.address MATCHES ? ");
		params.add(searchValue);
    } else if(searchBy.equals(SEARCHBY_NAME)) {
		sb.append("AND s.name MATCHES ? ");
		params.add(searchValue);
	} else if(searchBy.equals(SEARCHBY_NUMBER)) {
		sb.append("AND rp.number = ? ");
		params.add(searchValue);
    }

	/*
	if(type.equals(TYPE_SEARCH_DAMPS)) {
		sb.append("AND bs.type = 'D' ");
	} else if (type.equals(TYPE_SEARCH_GSM)) {
		sb.append("AND bs.type IN ('C','S','G') ");
	}
	*/

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case ORDER_NUMBER_ASC :
			sb.append("ORDER BY rp.number ASC ");
			break;
		case ORDER_NUMBER_DESC :
			sb.append("ORDER BY rp.number DESC ");
			break;
		case ORDER_NAME_ASC :
			sb.append("ORDER BY name ASC ");
			break;
		case ORDER_NAME_DESC :
			sb.append("ORDER BY name DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
	//System.out.println("REPITER SQL: " + sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
	
}
public String getAntennesSectorLetters(Integer antenna)
{
	String result = "";
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT s.band, s.num_sect FROM antennes an, anten2sectors a2s, sectors s WHERE a2s.id_anten = an.id_anten AND s.id_sect = a2s.id_sect ");
	if(antenna != null) {
		sb.append("AND an.id_anten = ? ");
		params.add(antenna);
	} else {
		sb.append("AND an.id_anten IS NULL ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		String num_sect = ro.getColumn("num_sect").asString();
		Object o = ro.getColumn("band").asObject();
		if(o == null || !(o instanceof Number)) {
			continue;
		}
		int band = ((Number)o).intValue();
		int num = 0;
		if(num_sect != null && num_sect.length() > 0) {
			if(num_sect.length() > 1) {
				num_sect = num_sect.substring(num_sect.length()-1,num_sect.length());
			}
			try {
				num = Integer.parseInt(num_sect);
			} catch(Exception e) {
				continue;
			}
			switch(band) {
			case 800:
				result += NUMSECT2LETT[num+10];
				if(it.hasNext()) { result += ","; }
				break;
			case 900:
				result += NUMSECT2LETT[num];
				if(it.hasNext()) { result += ","; }
				break;
			case 1800:
				result += NUMSECT2LETT[num];
				if(it.hasNext()) { result += ","; }
				break;
			}
		}
	}
	return result;
}
public CDBCResultSet listBSRepeaters(Integer donorbs)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append("SELECT er.equipment, 'D' || bs.number || ' ' || bs.name bsname, bs.equipment bsequ, rg.supregid, ");
	sb.append("CASE sec.band ");
	sb.append("WHEN 800 THEN DECODE(SUBSTR(num_sect,1,1), '0','O', '1','A', '2','B', '3','C', '4','D', '5','E', '6','F', '7','G', '?') ");
	sb.append("WHEN 900 THEN DECODE(SUBSTR(num_sect,1,1), '5','E', '6','F', '7','G', '8','H', '9','O', '?') ");
	sb.append("WHEN 1800 THEN DECODE(SUBSTR(num_sect,1,1), '0','O', '1','A', '2','B', '3','C', '4','D', '?') ");
	sb.append("END sectorname, rp.number, r.model reptype, rp.repiter_class, rp.donor_type, ");
	sb.append("rp.reppower, rp.bandwidth, rp.numchanals, p.storageplace positionid, ");
	sb.append("NVL('D'||p.gsmid||' ','') || NVL('A'||p.dampsid||' ','') || TRIM(spp.name) posname ");
	sb.append("FROM repiters rp, equipment er, storageplaces spr, positions p, storageplaces spp, resources r, ");
	sb.append("sectors sec, basestations bs, netzones n, regions rg ");
	sb.append("WHERE rp.equipment = er.equipment AND er.equipment = spr.storageplace ");
	sb.append("AND p.storageplace = er.position AND spp.storageplace = p.storageplace AND r.resource = rp.resource ");
	sb.append("AND sec.id_sect = rp.donor_sect AND sec.equipment = bs.equipment ");
	sb.append("AND n.netzone = p.netzone AND rg.regionid = p.regionid ");

	if(donorbs != null) {
		sb.append("AND bs.equipment = ? ");
		params.add(donorbs);
	} else {
		sb.append("AND bs.equipment IS NULL ");
	}

	sb.append("ORDER BY rp.number ASC ");

	CDBCResultSet res = new CDBCResultSet();
System.out.println("BS REPITER SQL: " + sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
	
}
public CDBCResultSet listRepeaters(
	Boolean isAllNetZones, Integer[] netZones,
	Boolean isAllRegions, Integer[] regions,
	Boolean isAllSupregs, Integer[] supregs,
	String type,
	String searchBy, String searchValue,
	String state,
	Boolean isAdmin, String login,
	Integer order
)  {
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append("SELECT er.equipment, 'D' || bs.number || ' ' || bs.name bsname, bs.equipment bsequ, rg.supregid, ");
		sb.append("CASE sec.band ");
		sb.append("WHEN 800 THEN DECODE(SUBSTR(num_sect,1,1), '0','O', '1','A', '2','B', '3','C', '4','D', '5','E', '6','F', '7','G', '?') ");
		sb.append("WHEN 900 THEN DECODE(SUBSTR(num_sect,1,1), '5','E', '6','F', '7','G', '8','H', '9','O', '?') ");
		sb.append("WHEN 1800 THEN DECODE(SUBSTR(num_sect,1,1), '0','O', '1','A', '2','B', '3','C', '4','D', '?') ");
		sb.append("END sectorname, rp.number, r.model reptype, rp.repiter_class, rp.donor_type, ");
		sb.append("rp.reppower, rp.bandwidth, rp.numchanals, p.storageplace positionid, ");
		sb.append("NVL('D'||p.gsmid||' ','') || NVL('A'||p.dampsid||' ','') || TRIM(spp.name) posname ");
		sb.append("FROM repiters rp, equipment er, storageplaces spr, positions p, storageplaces spp, outer resources r, ");
		sb.append("sectors sec, basestations bs, netzones n, regions rg ");
		sb.append("WHERE rp.equipment = er.equipment AND er.equipment = spr.storageplace ");
		sb.append("AND p.storageplace = er.position AND spp.storageplace = p.storageplace AND r.resource = rp.resource ");
		sb.append("AND sec.id_sect = rp.donor_sect AND sec.equipment = bs.equipment ");
		sb.append("AND n.netzone = p.netzone AND rg.regionid = p.regionid ");
	} else {
		sb.append("SELECT er.equipment, 'D' || bs.number || ' ' || bs.name bsname, bs.equipment bsequ, rg.supregid, ");
		sb.append("CASE sec.band ");
		sb.append("WHEN 800 THEN DECODE(SUBSTR(num_sect,1,1), '0','O', '1','A', '2','B', '3','C', '4','D', '5','E', '6','F', '7','G', '?') ");
		sb.append("WHEN 900 THEN DECODE(SUBSTR(num_sect,1,1), '5','E', '6','F', '7','G', '8','H', '9','O', '?') ");
		sb.append("WHEN 1800 THEN DECODE(SUBSTR(num_sect,1,1), '0','O', '1','A', '2','B', '3','C', '4','D', '?') ");
		sb.append("END sectorname, rp.number, r.model reptype, rp.repiter_class, rp.donor_type, ");
		sb.append("rp.reppower, rp.bandwidth, rp.numchanals, p.storageplace positionid, ");
		sb.append("NVL('D'||p.gsmid||' ','') || NVL('A'||p.dampsid||' ','') || TRIM(spp.name) posname ");
		sb.append("FROM repiters rp, equipment er, storageplaces spr, positions p, storageplaces spp, outer resources r, ");
		sb.append("sectors sec, basestations bs, netzones n, regions rg, ");
		sb.append("operators o, outer regionsaccess sra, outer regionsaccess ra ");
		sb.append("WHERE rp.equipment = er.equipment AND er.equipment = spr.storageplace ");
		sb.append("AND p.storageplace = er.position AND spp.storageplace = p.storageplace AND r.resource = rp.resource ");
		sb.append("AND sec.id_sect = rp.donor_sect AND sec.equipment = bs.equipment ");
		sb.append("AND n.netzone = p.netzone AND rg.regionid = p.regionid ");

		sb.append("AND sra.accesstype = 'S' AND sra.supregionid = rg.supregid AND sra.operatorid = o.operator ");
		sb.append("AND ra.accesstype = 'R' AND ra.regionid = rg.regionid AND ra.operatorid = o.operator ");
		sb.append("AND (rg.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = o.operator) OR rg.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = o.operator)) ");
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}
	
    if(state != null && !"*".equals(state)) {
		sb.append("AND er.state = ? ");
		params.add(state);
    } else {
	    //sb.append("AND er.state IS NULL ");
    }

    if (!isAllRegions.booleanValue()) {
		CDBCPositionObject.appendIN(sb,"AND p.regionid ",regions);
	} else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
		CDBCPositionObject.appendIN(sb,"AND rg.supregid ", supregs);
	}

	if (isAllNetZones != null && !isAllNetZones.booleanValue()) {
		CDBCPositionObject.appendIN(sb, "AND p.netzone ", netZones);
	}

	if(type != null && "damps".equals(type)) {
		sb.append("AND bs.type = 'D' ");
	} else {
		sb.append("AND bs.type <> 'D' ");
	}
	
    String field = null;
	if(searchBy.equals("addresspos")) {
		sb.append("AND LOWER(spp.address) MATCHES ? ");
		if(searchValue != null) {
			params.add(searchValue.toLowerCase());
		} else {
			params.add("");
		}
    } else if(searchBy.equals("namepos")) {
		sb.append("AND LOWER(spp.name) MATCHES ? ");
		if(searchValue != null) {
			params.add(searchValue.toLowerCase());
		} else {
			params.add("");
		}
	} else if(searchBy.equals("numberbs")) {
		sb.append("AND bs.number = ? ");
		params.add(searchValue);
    } else if(searchBy.equals("numbersector")) {
	    sb.append("AND sec.num_sect MATCHES ? ");
		if(searchValue != null) {
			params.add(searchValue.toLowerCase());
		} else {
			params.add("");
		}
    }

	//append order by clause
	if(order != null) {
		switch (order.intValue()) {
		case 1 :
			sb.append("ORDER BY rp.number ASC ");
			break;
		case 2 :
			sb.append("ORDER BY rp.number DESC ");
			break;
		case 3 :
			sb.append("ORDER BY name ASC ");
			break;
		case 4 :
			sb.append("ORDER BY name DESC ");
			break;
	    }
	}

	CDBCResultSet res = new CDBCResultSet();
System.out.println("REPITER SQL: " + sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
	
}
}
