package com.hps.july.cdbc.objects;

import java.util.LinkedList;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с линиями связи.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCComlinesObject
	implements com.hps.july.jdbcpersistence.lib.SearchConstants
{
    public final static String SEARCHBY_GSMNUMBER="gsmnumber";
    public final static String SEARCHBY_DAMPSNUMBER="dampsnumber";
    public final static String SEARCHBY_HOPSNAME = "hopsname";
    public final static String SEARCHBY_BEENETID = "beenet";
/**
 * CDBCPositionObject constructor comment.
 */
public CDBCComlinesObject() {
	super();
}
public void addCommaList(StringBuffer sb, CDBCResultSet rs, String fieldname)
{
	java.util.Iterator it = rs.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		if(ro.getColumn("serialnumber").asObject() != null) {
			if(sb.length() > 1) {
				sb.append(", ");
			}
			sb.append(ro.getColumn("serialnumber").asString());
		}
	}
}
public static void appendIN(StringBuffer sb, String param, Integer[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		sb.append(param);
		sb.append(" IN (0) ");
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
/**
 * Выдаёт список ресурсов анетенн базовых станций
 */
public CDBCResultSet findComEquipmentComlines(Integer equipment, Integer position)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	String sp = (position == null)?"0":String.valueOf(position);
	String se = (equipment == null)?"0":String.valueOf(equipment);
	
	sqlb.append("SELECT	hops.hopsid hopsid, hl.hopsname hopsname, hops.beenetid, hops.hopstate, ");
	sqlb.append("CASE p1.storageplace WHEN "+sp+" THEN TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) ELSE TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) END otvposid, ");
	sqlb.append("CASE p1.storageplace WHEN "+sp+" THEN TRIM(s2.name) ELSE TRIM(s1.name) END otvposname,  ");
	sqlb.append("CASE p1.storageplace WHEN "+sp+" THEN TRIM(spe2.name) ELSE TRIM(spe1.name) END otvresource ");
	sqlb.append("FROM hops, ");
	sqlb.append("comequipment cm1, equipment e1, storageplaces spe1, positions p1, storageplaces s1, regions reg1, outer resources r1, ");
	sqlb.append("comequipment cm2, equipment e2, storageplaces spe2, positions p2, storageplaces s2, regions reg2, outer resources r2, ");
	sqlb.append("hopslabel hl ");
	sqlb.append("WHERE ");
	sqlb.append("s1.storageplace = p1.storageplace AND p1.storageplace = e1.position AND ");
	sqlb.append("e1.equipment = hops.equipmentid_enda AND cm1.equipment = e1.equipment AND ");
	sqlb.append("r1.resource = cm1.resource AND s2.storageplace = p2.storageplace AND "); 
	sqlb.append("p2.storageplace = e2.position AND e2.equipment = hops.equipmentid_endb AND ");
	sqlb.append("spe1.storageplace = e1.equipment AND spe2.storageplace = e2.equipment AND ");
	sqlb.append("cm2.equipment = e2.equipment AND ");
	sqlb.append("r2.resource = cm2.resource AND ");
	sqlb.append("hl.hopslabelid = (SELECT max(hopslabelid) FROM hopslabel hll WHERE hll.hopsid = hops.hopsid) AND ");
	sqlb.append("hl.hopsid = hops.hopsid AND ");
	sqlb.append("p1.regionid = reg1.regionid AND "); 
	sqlb.append("p2.regionid = reg2.regionid ");
	sqlb.append("AND (hops.equipmentid_enda = "+se+" OR hops.equipmentid_endb = "+se+") AND (e1.position = "+sp+" OR e2.position = "+sp+") ");
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findComlineList(
    Boolean isAllNetZones,
    Integer[] netZones,
    Boolean isAllRegions,
    Integer[] regions,
    Boolean isAllSupregs,
    Integer[] supregs,
    String searchBy,
    String searchValue,
    String hopsstate,
    Boolean isAdmin,
    String login
) throws Exception
{
	long t1 = System.currentTimeMillis();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	if (isAdmin.booleanValue()) {
		sqlb.append("SELECT h.hopsid, hl.hopsname, ");
		sqlb.append("h.hopstype, h.beenetid, h.hopstate, 'Y' editregion, ");
		sqlb.append("TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, sp1.name name1,  ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e1.equipment) equname1, p1.storageplace p1code, p1.regionid rg1, reg1.supregid srg1,  ");
		sqlb.append("TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, sp2.name name2, ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e2.equipment) equname2, p2.storageplace p2code, p2.regionid rg2, reg2.supregid srg2,  ");
		sqlb.append("(SELECT rh2.file_number FROM rrl_hops2 rh2 WHERE rh2.hopsid = h.hopsid) filenumber ");
		sqlb.append("FROM hops h, hopslabel hl, ");
		sqlb.append("equipment e1, positions p1, storageplaces sp1, regions reg1, ");
		sqlb.append("equipment e2, positions p2, storageplaces sp2, regions reg2 ");
		sqlb.append("WHERE hl.hopsid = h.hopsid ");
		sqlb.append("AND e1.equipment = h.equipmentid_enda ");
		sqlb.append("AND p1.storageplace = e1.position ");
		sqlb.append("AND sp1.storageplace = p1.storageplace ");
		sqlb.append("AND reg1.regionid = p1.regionid ");
		sqlb.append("AND e2.equipment = h.equipmentid_endb ");
		sqlb.append("AND p2.storageplace = e2.position ");
		sqlb.append("AND sp2.storageplace = p2.storageplace ");
		sqlb.append("AND reg2.regionid = p2.regionid ");
		sqlb.append("AND h.hopstype IN ('R','O') ");
    } else {
		sqlb.append("SELECT h.hopsid, hl.hopsname, ");
		sqlb.append("h.hopstype, h.beenetid, h.hopstate, 'Y' editregion, ");
		sqlb.append("TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, sp1.name name1,  ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e1.equipment) equname1, p1.storageplace p1code, p1.regionid rg1, reg1.supregid srg1,  ");
		sqlb.append("TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, sp2.name name2, ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e2.equipment) equname2, p2.storageplace p2code, p2.regionid rg2, reg2.supregid srg2,  ");
		sqlb.append("(SELECT rh2.file_number FROM rrl_hops2 rh2 WHERE rh2.hopsid = h.hopsid) filenumber ");
		sqlb.append("FROM hops h, hopslabel hl, ");
		sqlb.append("equipment e1, positions p1, storageplaces sp1, regions reg1, ");
		sqlb.append("equipment e2, positions p2, storageplaces sp2, regions reg2, regionsaccess ra ");
		sqlb.append("WHERE hl.hopsid = h.hopsid ");
		sqlb.append("AND e1.equipment = h.equipmentid_enda ");
		sqlb.append("AND p1.storageplace = e1.position ");
		sqlb.append("AND sp1.storageplace = p1.storageplace ");
		sqlb.append("AND reg1.regionid = p1.regionid ");
		sqlb.append("AND e2.equipment = h.equipmentid_endb ");
		sqlb.append("AND p2.storageplace = e2.position ");
		sqlb.append("AND sp2.storageplace = p2.storageplace ");
		sqlb.append("AND reg2.regionid = p2.regionid ");
		sqlb.append("AND h.hopstype IN ('R','O') ");
		sqlb.append("AND ra.operatorid = ? ");
		sqlb.append("AND ra.viewfact = 'Y' ");
		sqlb.append("AND ((reg1.regionid = ra.regionid OR reg1.supregid = ra.supregionid) OR (reg2.regionid = ra.regionid OR reg2.supregid = ra.supregionid)) ");
		Integer oc = OperatorObject.getOperatorCode(login);
		if(oc != null) {
			params.add(oc);
		} else {
			params.add(new Integer(-1));
		}
    }

    if (!isAllRegions.booleanValue()) {
	    sqlb.append("AND (");
	    appendIN(sqlb,"p1.regionid ", regions);
		appendIN(sqlb,"OR p1.regionid ", regions);
		sqlb.append(") ");
    } else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
	    sqlb.append("AND (");
	    appendIN(sqlb,"reg1.supregid ", supregs);
		appendIN(sqlb,"OR reg2.supregid ", supregs);
		sqlb.append(") ");
    }

    if (!isAllNetZones.booleanValue()) {
	    sqlb.append("AND (");
	    appendIN(sqlb,"p1.netzone ", netZones);
		appendIN(sqlb,"OR p2.netzone ", netZones);
		sqlb.append(") ");
    }

    if(searchValue == null) {
	    searchValue = "";
    } else {
	    searchValue = searchValue.toLowerCase();
    } 
	if(!"*".equals(searchValue)) {
		if (searchBy.equals(SEARCHBY_ADDRESS)) {
			sqlb.append("AND (LOWER(sp1.address) MATCHES ? OR LOWER(sp2.address) MATCHES ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_NAME)) {
			sqlb.append("AND (LOWER(sp1.name) MATCHES ? OR LOWER(sp2.name) MATCHES ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_HOPSNAME)) {
			sqlb.append("AND LOWER(hl.hopsname) MATCHES ? ");
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_GSMNUMBER)) {
			sqlb.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_DAMPSNUMBER)) {
			sqlb.append("AND (p1.dampsid = ? OR p2.dampsid = ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_BEENETID)) {
			sqlb.append("AND LOWER(h.beenetid) MATCHES ? ");
			params.add(searchValue);
		}
	}

	if(hopsstate != null && !"*".equals(hopsstate) && !"".equals(hopsstate)) {
		sqlb.append("AND h.hopstate = ? ");
		params.add(hopsstate);
	}

	sqlb.append(" ORDER BY hl.hopsname");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	long t2 = System.currentTimeMillis() - t1;

System.out.println("SQL(Time:"+t2+"):\n"+sqlb.toString()+"\n");
	
	return res;
}
public CDBCResultSet findComlineLookupList(
	Boolean isAllNetZones, 
	Integer[] netZones,  Boolean isAllRegions,
    Integer[] regions,  Boolean isAllSupregs,
    Integer[] supregs,
    String searchBy,
    String searchValue,
    String hopsstate,
    Boolean isAdmin,
    String login
) throws Exception
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();


	
	
	if(isAdmin.booleanValue()) {
		sqlb.append("SELECT h.hopsid, hl.hopsname, ");
		sqlb.append("h.hopstype, h.beenetid, h.hopstate, 'Y' editRegion, ");
		sqlb.append("TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, sp1.name name1,  ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e1.equipment) equname1, p1.regionid rg1, reg1.supregid srg1,  ");
		sqlb.append("TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, sp2.name name2, ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e2.equipment) equname2, p2.regionid rg2, reg2.supregid srg2,  ");
		sqlb.append("(SELECT rh2.file_number FROM rrl_hops2 rh2 WHERE rh2.hopsid = h.hopsid) filenumber ");
		sqlb.append("FROM hops h, hopslabel hl, ");
		sqlb.append("equipment e1, positions p1, storageplaces sp1, regions reg1, ");
		sqlb.append("equipment e2, positions p2, storageplaces sp2, regions reg2 ");
		sqlb.append("WHERE hl.hopsid = h.hopsid ");
		sqlb.append("AND e1.equipment = h.equipmentid_enda ");
		sqlb.append("AND p1.storageplace = e1.position ");
		sqlb.append("AND sp1.storageplace = p1.storageplace ");
		sqlb.append("AND reg1.regionid = p1.regionid ");
		sqlb.append("AND e2.equipment = h.equipmentid_endb ");
		sqlb.append("AND p2.storageplace = e2.position ");
		sqlb.append("AND sp2.storageplace = p2.storageplace ");
		sqlb.append("AND reg2.regionid = p2.regionid ");
		sqlb.append("AND h.hopstype IN ('R','O') ");
    } else {
		sqlb.append("SELECT h.hopsid, hl.hopsname, ");
		sqlb.append("h.hopstype, h.beenetid, h.hopstate, 'Y' editRegion, ");
		sqlb.append("TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, sp1.name name1,  ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e1.equipment) equname1, p1.regionid rg1, reg1.supregid srg1,  ");
		sqlb.append("TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, sp2.name name2, ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e2.equipment) equname2, p2.regionid rg2, reg2.supregid srg2,  ");
		sqlb.append("(SELECT rh2.file_number FROM rrl_hops2 rh2 WHERE rh2.hopsid = h.hopsid) filenumber ");
		sqlb.append("FROM hops h, hopslabel hl, ");
		sqlb.append("equipment e1, positions p1, storageplaces sp1, regions reg1, ");
		sqlb.append("equipment e2, positions p2, storageplaces sp2, regions reg2, regionsaccess ra ");
		sqlb.append("WHERE hl.hopsid = h.hopsid ");
		sqlb.append("AND e1.equipment = h.equipmentid_enda ");
		sqlb.append("AND p1.storageplace = e1.position ");
		sqlb.append("AND sp1.storageplace = p1.storageplace ");
		sqlb.append("AND reg1.regionid = p1.regionid ");
		sqlb.append("AND e2.equipment = h.equipmentid_endb ");
		sqlb.append("AND p2.storageplace = e2.position ");
		sqlb.append("AND sp2.storageplace = p2.storageplace ");
		sqlb.append("AND reg2.regionid = p2.regionid ");
		sqlb.append("AND h.hopstype IN ('R','O') ");
		sqlb.append("AND ra.operatorid = ? ");
		sqlb.append("AND ra.viewfact = 'Y' ");
		sqlb.append("AND ((reg1.regionid = ra.regionid OR reg1.supregid = ra.supregionid) OR (reg2.regionid = ra.regionid OR reg2.supregid = ra.supregionid)) ");
		Integer oc = OperatorObject.getOperatorCode(login);
		if(oc != null) {
			params.add(oc);
		} else {
			params.add(new Integer(-1));
		}
    }

    if (!isAllRegions.booleanValue()) {
	    sqlb.append("AND (");
	    appendIN(sqlb,"p1.regionid ", regions);
		appendIN(sqlb,"OR p1.regionid ", regions);
		sqlb.append(") ");
    } else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
	    sqlb.append("AND (");
	    appendIN(sqlb,"reg1.supregid ", regions);
		appendIN(sqlb,"OR reg2.supregid ", regions);
		sqlb.append(") ");
    }

    if (!isAllNetZones.booleanValue()) {
	    sqlb.append("AND (");
	    appendIN(sqlb,"p1.netzone ", regions);
		appendIN(sqlb,"OR p2.netzone ", regions);
		sqlb.append(") ");
    }

    if(searchValue == null) {
	    searchValue = "";
    } else {
	    searchValue = searchValue.toLowerCase();
    } 
	if(!"*".equals(searchValue)) {
		if (searchBy.equals(SEARCHBY_ADDRESS)) {
			sqlb.append("AND (LOWER(sp1.address) MATCHES ? OR LOWER(sp2.address) MATCHES ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_NAME)) {
			sqlb.append("AND (LOWER(sp1.name) MATCHES ? OR LOWER(sp2.name) MATCHES ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_HOPSNAME)) {
			sqlb.append("AND LOWER(hl.hopsname) MATCHES ? ");
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_GSMNUMBER)) {
			sqlb.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_DAMPSNUMBER)) {
			sqlb.append("AND (p1.dampsid = ? OR p2.dampsid = ?) ");
			params.add(searchValue);
			params.add(searchValue);
		} else if (searchBy.equals(SEARCHBY_BEENETID)) {
			sqlb.append("AND LOWER(h.beenetid) MATCHES ? ");
			params.add(searchValue);
		}
	}

	if(hopsstate != null && !"*".equals(hopsstate) && !"".equals(hopsstate)) {
		sqlb.append("AND h.hopstate = ? ");
		params.add(hopsstate);
	}

	sqlb.append(" ORDER BY hl.hopsname");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findComlinePositionList(
	Integer position,
    Boolean isAdmin,
    String login
) throws Exception
{
	long t1 = System.currentTimeMillis();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

System.out.println("IsAdMIN:"+isAdmin+", LOG:"+login);
	if (isAdmin.booleanValue()) {
		sqlb.append("SELECT h.hopsid, hl.hopsname, ");
		sqlb.append("h.hopstype, h.beenetid, h.hopstate, 'Y' editregion, ");
		sqlb.append("TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, sp1.name name1,  ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e1.equipment) equname1, p1.storageplace p1code, p1.regionid rg1, reg1.supregid srg1,  ");
		sqlb.append("TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, sp2.name name2, ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e2.equipment) equname2, p2.storageplace p2code, p2.regionid rg2, reg2.supregid srg2,  ");
		sqlb.append("(SELECT rh2.file_number FROM rrl_hops2 rh2 WHERE rh2.hopsid = h.hopsid) filenumber ");
		sqlb.append("FROM hops h, hopslabel hl, ");
		sqlb.append("equipment e1, positions p1, storageplaces sp1, regions reg1, ");
		sqlb.append("equipment e2, positions p2, storageplaces sp2, regions reg2 ");
		sqlb.append("WHERE hl.hopsid = h.hopsid ");
		sqlb.append("AND e1.equipment = h.equipmentid_enda ");
		sqlb.append("AND p1.storageplace = e1.position ");
		sqlb.append("AND sp1.storageplace = p1.storageplace ");
		sqlb.append("AND reg1.regionid = p1.regionid ");
		sqlb.append("AND e2.equipment = h.equipmentid_endb ");
		sqlb.append("AND p2.storageplace = e2.position ");
		sqlb.append("AND sp2.storageplace = p2.storageplace ");
		sqlb.append("AND reg2.regionid = p2.regionid ");
		sqlb.append("AND h.hopstype IN ('R','O') ");
    } else {
		sqlb.append("SELECT h.hopsid, hl.hopsname, ");
		sqlb.append("h.hopstype, h.beenetid, h.hopstate, 'Y' editregion, ");
		sqlb.append("TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, sp1.name name1,  ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e1.equipment) equname1, p1.storageplace p1code, p1.regionid rg1, reg1.supregid srg1,  ");
		sqlb.append("TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, sp2.name name2, ");
		sqlb.append("(SELECT emsp.name FROM storageplaces emsp WHERE emsp.storageplace = e2.equipment) equname2, p2.storageplace p2code, p2.regionid rg2, reg2.supregid srg2,  ");
		sqlb.append("(SELECT rh2.file_number FROM rrl_hops2 rh2 WHERE rh2.hopsid = h.hopsid) filenumber ");
		sqlb.append("FROM hops h, hopslabel hl, ");
		sqlb.append("equipment e1, positions p1, storageplaces sp1, regions reg1, ");
		sqlb.append("equipment e2, positions p2, storageplaces sp2, regions reg2, regionsaccess ra ");
		sqlb.append("WHERE hl.hopsid = h.hopsid ");
		sqlb.append("AND e1.equipment = h.equipmentid_enda ");
		sqlb.append("AND p1.storageplace = e1.position ");
		sqlb.append("AND sp1.storageplace = p1.storageplace ");
		sqlb.append("AND reg1.regionid = p1.regionid ");
		sqlb.append("AND e2.equipment = h.equipmentid_endb ");
		sqlb.append("AND p2.storageplace = e2.position ");
		sqlb.append("AND sp2.storageplace = p2.storageplace ");
		sqlb.append("AND reg2.regionid = p2.regionid ");
		sqlb.append("AND h.hopstype IN ('R','O') ");
		sqlb.append("AND ra.operatorid = ? ");
		sqlb.append("AND ra.viewfact = 'Y' ");
		sqlb.append("AND ((reg1.regionid = ra.regionid OR reg1.supregid = ra.supregionid) OR (reg2.regionid = ra.regionid OR reg2.supregid = ra.supregionid)) ");
		Integer oc = OperatorObject.getOperatorCode(login);
		if(oc != null) {
			params.add(oc);
		} else {
			params.add(new Integer(-1));
		}
    }

    if(position != null) {
	    sqlb.append("AND (e1.position = ? OR e2.position = ?) ");
	    params.add(position);
	    params.add(position);
    } else {
	    sqlb.append("AND (e1.position IS NULL OR e2.position IS NULL) ");
    }

	sqlb.append(" ORDER BY hl.hopsname");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	long t2 = System.currentTimeMillis() - t1;

System.out.println("SQL(Time:"+t2+"):\n"+sqlb.toString()+"\n");
	
	return res;
}
/**
 * Выдаёт список ресурсов анетенн базовых станций
 */
public CDBCResultSet findHopsName(String p1, String p2)
{

	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT hl.hopsname FROM hopslabel hl, hops h WHERE hl.hopsid = h.hopsid AND h.hopstype = 'R' AND hopstate IN ('A','B','C') ");
	sqlb.append("AND hopsname MATCHES '"+quoteForSQL(p1)+"?"+quoteForSQL(p2)+"' ");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findOtvEquipment(int equipment)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT h.beenetid,  ");
	sqlb.append("CASE ea.equipment WHEN "+equipment+" THEN  ");
	sqlb.append("  NVL('D' || pb.gsmid || ' ','') || TRIM(spb.name) || (SELECT CASE cm.type WHEN 'O' THEN NVL(' ' || TRIM(seb.name),'') || NVL(' (' || TRIM(cm.osinvname) || ')','') ELSE NVL(' ' || TRIM(seb.name),'') END FROM comequipment cm WHERE cm.equipment = eb.equipment) ");
	sqlb.append("ELSE ");
	sqlb.append("  NVL('D' || pa.gsmid || ' ','') || TRIM(spa.name) || (SELECT CASE cm.type WHEN 'O' THEN NVL(' ' || TRIM(sea.name),'') || NVL(' (' || TRIM(cm.osinvname) || ')','') ELSE NVL(' ' || TRIM(sea.name),'') END FROM comequipment cm WHERE cm.equipment = ea.equipment) ");
	sqlb.append("END otvetka, ");
	sqlb.append("CASE ea.equipment WHEN "+equipment+" THEN eb.equipment ELSE ea.equipment END eid ");
	sqlb.append("FROM hops h, rrl_hops2 rh2, ");
	sqlb.append("equipment ea, storageplaces sea, positions pa, storageplaces spa, ");
	sqlb.append("equipment eb, storageplaces seb, positions pb, storageplaces spb ");
	sqlb.append("WHERE (h.equipmentid_enda = "+equipment+" OR h.equipmentid_endb = "+equipment+") AND rh2.hopsid = h.hopsid ");
	sqlb.append("AND ea.equipment = h.equipmentid_enda AND sea.storageplace = ea.equipment AND spa.storageplace = ea.position AND pa.storageplace = ea.position ");
	sqlb.append("AND h.equipmentid_endb = eb.equipment AND seb.storageplace = eb.equipment AND spb.storageplace = eb.position AND pb.storageplace = eb.position ");
	sqlb.append("AND h.hopstate IN ('A','B','C') ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findOtvEquipment(Integer equ)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	int equipment = -1;
	if(equ != null) {
		equipment = equ.intValue();
	}
	
	sqlb.append("SELECT h.beenetid,  ");
	sqlb.append("CASE ea.equipment WHEN "+equipment+" THEN  ");
	sqlb.append("  NVL('D' || pb.gsmid || ' ','') || TRIM(spb.name) || (SELECT CASE cm.type WHEN 'O' THEN NVL(' ' || TRIM(seb.name),'') || NVL(' (' || TRIM(cm.osinvname) || ')','') ELSE NVL(' ' || TRIM(seb.name),'') END FROM comequipment cm WHERE cm.equipment = eb.equipment) ");
	sqlb.append("ELSE ");
	sqlb.append("  NVL('D' || pa.gsmid || ' ','') || TRIM(spa.name) || (SELECT CASE cm.type WHEN 'O' THEN NVL(' ' || TRIM(sea.name),'') || NVL(' (' || TRIM(cm.osinvname) || ')','') ELSE NVL(' ' || TRIM(sea.name),'') END FROM comequipment cm WHERE cm.equipment = ea.equipment) ");
	sqlb.append("END otvetka, ");
	sqlb.append("CASE ea.equipment WHEN "+equipment+" THEN eb.equipment ELSE ea.equipment END eid ");
	sqlb.append("FROM hops h, rrl_hops2 rh2, ");
	sqlb.append("equipment ea, storageplaces sea, positions pa, storageplaces spa, ");
	sqlb.append("equipment eb, storageplaces seb, positions pb, storageplaces spb ");
	sqlb.append("WHERE (h.equipmentid_enda = "+equipment+" OR h.equipmentid_endb = "+equipment+") AND rh2.hopsid = h.hopsid ");
	sqlb.append("AND ea.equipment = h.equipmentid_enda AND sea.storageplace = ea.equipment AND spa.storageplace = ea.position AND pa.storageplace = ea.position ");
	sqlb.append("AND h.equipmentid_endb = eb.equipment AND seb.storageplace = eb.equipment AND spb.storageplace = eb.position AND pb.storageplace = eb.position ");
	sqlb.append("AND h.hopstate IN ('A','B','C') ");
	if(equ == null) {
		sqlb.append("AND h.hopsid IS NULL ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet getFASPermission(int hopsid, int filenumber)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT fp.filenumber, e2h.hopsid, sd.blanknumber, sd.blankdate, sd.expiredate ");
	sqlb.append("FROM sitedocs2hops e2h, freqpermissions fp, sitedocs sd, etapdocs ed, etaptype et, namedvalues nv ");
	sqlb.append("WHERE e2h.sitedoc = sd.sitedoc AND sd.sitedoc = ed.sitedoc AND ed.etaptypeid = et.etaptypeid ");
	sqlb.append("AND fp.freqpermid = ed.freqpermid AND ed.etaptypeid = nv.intvalue AND nv.id = 'report_protocol_fasdoc' ");
	sqlb.append("AND fp.filenumber = ? AND e2h.hopsid = ? ");

	params.add(new Integer(filenumber));
	params.add(new Integer(hopsid));

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet getReportProtocol(int filenumber)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT ");
	sqlb.append("    fp.filenumber, h.hopsid, h.hopstate, ");
	sqlb.append("    pa.storageplace paid, pa.gsmid pagsm, spa.name paname, spa.address paaddress,  ");
	sqlb.append("      pa.latitude palat, pa.longitude palong, pa.linktogosnet_lat pagoslat, pa.linktogosnet_lon pagoslong, ");
	sqlb.append("      ra.model pamodel, rh2.frequency_a_doc pafreq, rh2.height_a_doc paheight, rh2.power_doc papower, ");
	sqlb.append("      pa.grchaddress pagrchaddr, rh2.comment_doc pacomment, ");
	sqlb.append("    pb.storageplace pbid, pb.gsmid pbgsm, spb.name pbname, spb.address pbaddress,  ");
	sqlb.append("      pb.latitude pblat, pb.longitude pblong, pb.linktogosnet_lat pbgoslat, pb.linktogosnet_lon pbgoslong, ");
	sqlb.append("      rb.model pbmodel, rh2.frequency_b_doc pbfreq, rh2.height_b_doc pbheight, rh2.power_doc pbpower, ");
	sqlb.append("      pb.grchaddress pbgrchaddr, rh2.comment_doc pbcomment, ");
	sqlb.append("    (SELECT rsp.radiationclass FROM rrl_hops2 r2, rrlspeedparams rsp WHERE r2.resource_doc = rsp.resource AND r2.speed_doc = rsp.streamspeed AND r2.hopsid = h.hopsid) emclass ");
	sqlb.append("FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh2, hops h,  ");
	sqlb.append("equipment ea, positions pa, storageplaces spa, outer resources ra, ");
	sqlb.append("equipment eb, positions pb, storageplaces spb, outer resources rb ");
	sqlb.append("WHERE h.hopsid = rh2.hopsid AND h.hopsid = p2h.hopsid  ");
	sqlb.append("AND h.equipmentid_enda = ea.equipment AND ea.position = pa.storageplace  ");
	sqlb.append("   AND pa.storageplace = spa.storageplace AND rh2.resource_doc = ra.resource ");
	sqlb.append("AND h.equipmentid_endb = eb.equipment AND eb.position = pb.storageplace  ");
	sqlb.append("   AND pb.storageplace = spb.storageplace AND rh2.resource_doc = rb.resource ");
	sqlb.append("AND p2h.freqpermid = fp.freqpermid AND fp.filenumber = ? ");

	params.add(new Integer(filenumber));
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet getReportProtocolSFO(String sfonumber)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT ");
	sqlb.append("    fp.filenumber, h.hopsid, h.hopstate, ");
	sqlb.append("    pa.storageplace paid, pa.gsmid pagsm, spa.name paname, spa.address paaddress,  ");
	sqlb.append("      pa.latitude palat, pa.longitude palong, pa.linktogosnet_lat pagoslat, pa.linktogosnet_lon pagoslong, ");
	sqlb.append("      ra.model pamodel, rh2.frequency_a_doc pafreq, rh2.height_a_doc paheight, rh2.power_doc papower, ");
	sqlb.append("      pa.grchaddress pagrchaddr, rh2.comment_doc pacomment, ");
	sqlb.append("    pb.storageplace pbid, pb.gsmid pbgsm, spb.name pbname, spb.address pbaddress,  ");
	sqlb.append("      pb.latitude pblat, pb.longitude pblong, pb.linktogosnet_lat pbgoslat, pb.linktogosnet_lon pbgoslong, ");
	sqlb.append("      rb.model pbmodel, rh2.frequency_b_doc pbfreq, rh2.height_b_doc pbheight, rh2.power_doc pbpower, ");
	sqlb.append("      pb.grchaddress pbgrchaddr, rh2.comment_doc pbcomment, ");
	sqlb.append("    (SELECT rsp.radiationclass FROM rrl_hops2 r2, rrlspeedparams rsp WHERE r2.resource_doc = rsp.resource AND r2.speed_doc = rsp.streamspeed AND r2.hopsid = h.hopsid) emclass ");
	sqlb.append("FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh2, hops h,  ");
	sqlb.append("equipment ea, positions pa, storageplaces spa, outer resources ra, ");
	sqlb.append("equipment eb, positions pb, storageplaces spb, outer resources rb ");
	sqlb.append("WHERE h.hopsid = rh2.hopsid AND h.hopsid = p2h.hopsid  ");
	sqlb.append("AND h.equipmentid_enda = ea.equipment AND ea.position = pa.storageplace  ");
	sqlb.append("   AND pa.storageplace = spa.storageplace AND rh2.resource_doc = ra.resource ");
	sqlb.append("AND h.equipmentid_endb = eb.equipment AND eb.position = pb.storageplace  ");
	sqlb.append("   AND pb.storageplace = spb.storageplace AND rh2.resource_doc = rb.resource ");
	sqlb.append("AND p2h.freqpermid = fp.freqpermid ");

	if(sfonumber != null) {	
		sqlb.append("AND rh2.sfonumber = ? ");
		params.add(sfonumber);
	} else {
		sqlb.append("AND rh2.sfonumber IS NULL ");
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public String getVendorids(int hopsid, int type)
{
	StringBuffer result = new StringBuffer();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT serial_for_sc(sc.storagecard) serialnumber ");
	sqlb.append("FROM hops h, storagecards sc, resources r ");
if(type == 1) {
	sqlb.append("WHERE h.hopsid = ? AND h.equipmentid_enda = sc.storageplace ");
} else if(type == 2) {
	sqlb.append("WHERE h.hopsid = ? AND h.equipmentid_endb = sc.storageplace ");
} else {
	return "";
}
	sqlb.append("AND sc.closed = 'N' AND r.resource = sc.resource ");
	sqlb.append("AND ( ");
	sqlb.append("(r.resourcesubtype >= 65 AND r.resourcesubtype <= 71) OR ");
	sqlb.append("(r.resourcesubtype >= 81 AND r.resourcesubtype <= 86) OR ");
	sqlb.append("(r.resourcesubtype >= 91 AND r.resourcesubtype <= 110) OR ");
	sqlb.append("(r.resourcesubtype IN (48,49,223,230)) ");
	sqlb.append(") ");

	params.add(new Integer(hopsid));
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	addCommaList(result,res,"serialnumber");
	return result.toString();
}
public static String quoteForSQL(String source) {
	int i = 0;
	int ip = 0;
	if(source == null) return "";
	if(source.indexOf("'") > 0) {
		StringBuffer result = new StringBuffer();
		while( (i = source.indexOf("'", ip)) > 0 ) {
			result.append(source.substring(ip,i));
			result.append("''");
			ip = i+1;
		}
		return result.toString();
	} else {
		return source;
	}
}
}
