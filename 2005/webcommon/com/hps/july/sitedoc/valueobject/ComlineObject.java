package com.hps.july.sitedoc.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;

/**
 * Класс используемый для получения списка линий связи с помощью JDBC
 * Объекты этого класса так же используются для вывода данных списка
 */
public class ComlineObject
    extends JdbcObject
    implements Checks, SearchConstants {

    private Integer id; //PK   
    private Integer number;
    private Integer number2;
    private String resourceName;
    private String name;
    private String name2;
    private String comlinetype;
    //private String onair;
    private boolean editRegion;

    private String hopstate;

    public static final String QUERY_SELECT =
    	"SELECT "+
		"	hops.hopsid hopsid, hl.hopsname hopsname, hops.hopstate, "+
		"CASE sreg1a.editfact WHEN 'Y' THEN 'Y' ELSE "+
		"	CASE sreg2a.editfact WHEN 'Y' THEN 'Y' ELSE "+
		"		CASE reg1a.editfact WHEN 'Y' THEN 'Y' ELSE "+
		"			CASE reg2a.editfact WHEN 'Y' THEN 'Y' ELSE 'N' END "+
		"		END "+
		"	END "+
		"END editRegion, "+
		"	hops.hopstype, p1.gsmid id1, s1.name name1, p2.gsmid id2, "+
		"	s2.name name2, r1.resource resource1, r2.resource resource2, r1.model rname1, r2.model rname2 "+
		"FROM "+
		"	hops, comequipment cm1, equipment e1, positions p1, storageplaces s1, regions reg1, superregions sreg1, "+
		"	outer resources r1, comequipment cm2, equipment e2, positions p2, storageplaces s2, regions reg2, superregions sreg2, "+
		"	outer resources r2,  outer hopslabel hl, operators o, "+
		"	outer regionsaccess sreg1a, outer regionsaccess reg1a, outer regionsaccess sreg2a, outer regionsaccess reg2a "+
		"WHERE "+
		"	s1.storageplace = p1.storageplace AND "+
		"	p1.storageplace = e1.position AND "+
		"	e1.equipment = hops.equipmentid_enda AND "+
		"	cm1.equipment = e1.equipment AND "+
		"   r1.resource = cm1.resource AND "+
		"   s2.storageplace = p2.storageplace AND "+
		"   p2.storageplace = e2.position AND "+
		"   e2.equipment = hops.equipmentid_endb AND "+
		"   cm2.equipment = e2.equipment AND "+
		"   r2.resource = cm2.resource AND "+
		"   hl.hopslabelid = (SELECT max(hopslabelid) FROM hopslabel hll WHERE hll.hopsid = hops.hopsid) AND "+
		"   hl.hopsid = hops.hopsid AND "+
		"   p1.regionid = reg1.regionid AND "+
		"   reg1.supregid = sreg1.supregid AND "+
		"   p2.regionid = reg2.regionid AND "+
		"   reg2.supregid = sreg2.supregid AND "+
		"   reg1a.regionid = reg1.regionid AND "+
		"   reg1a.accesstype='R' AND "+
		"   reg1a.operatorid = o.operator AND "+
		"   sreg1a.supregionid = sreg1.supregid AND "+
		"   sreg1a.accesstype='S' AND "+
		"   sreg1a.operatorid = o.operator AND "+
		"   reg2a.regionid = reg2.regionid AND "+
		"   reg2a.operatorid = o.operator AND "+
		"   reg2a.accesstype='R' AND "+
		"   sreg2a.operatorid = o.operator AND "+
		"   sreg2a.supregionid = sreg2.supregid AND "+
		"   sreg2a.accesstype='S' AND "+
		"   ((reg1a.viewfact = 'Y' OR sreg1a.viewfact = 'Y') OR (reg2a.viewfact = 'Y' OR sreg2a.viewfact = 'Y')) ";
//		    o.loiginid='dima' 

	public static final String QUERY_SELECT_Admin =
		"SELECT	"+
		"    hops.hopsid hopsid, hl.hopsname hopsname, hops.hopstate, 'Y' editRegion, hops.hopstype, p1.gsmid id1, s1.name name1, p2.gsmid id2, "+
		"    s2.name name2, r1.resource resource1, r2.resource resource2, r1.model rname1, r2.model rname2 "+
		"FROM "+
		"    hops, comequipment cm1, equipment e1, positions p1, storageplaces s1, regions reg1,  outer resources r1, "+
		"    comequipment cm2, equipment e2, positions p2, storageplaces s2, regions reg2, outer resources r2, "+
		"    outer hopslabel hl "+
		"WHERE "+
		"    s1.storageplace = p1.storageplace AND "+
		"    p1.storageplace = e1.position AND "+
		"    e1.equipment = hops.equipmentid_enda AND "+
		"    cm1.equipment = e1.equipment AND "+
		"    r1.resource = cm1.resource AND "+
		"    s2.storageplace = p2.storageplace AND "+
		"    p2.storageplace = e2.position AND "+
		"    e2.equipment = hops.equipmentid_endb AND "+
		"    cm2.equipment = e2.equipment AND "+
		"    r2.resource = cm2.resource AND "+
		"    hl.hopslabelid = (SELECT max(hopslabelid) FROM hopslabel hll WHERE hll.hopsid = hops.hopsid) AND "+
		"    hl.hopsid = hops.hopsid AND "+
		"    p1.regionid = reg1.regionid AND "+
		"    p2.regionid = reg2.regionid ";

	private java.lang.String prolet;
    /**
     * PositionObject constructor comment.
     */
    public ComlineObject() throws Exception {
        super();
    }
/**
 * PositionObject constructor comment.
 */
public ComlineObject(java.sql.ResultSet rs) throws Exception {
    super();

    try {
        id = new Integer(rs.getInt("hopsid"));
        prolet = getString(rs, "hopsname"); 
        number = (Integer) rs.getObject("id1");
        number2 = (Integer) rs.getObject("id2");
        name = getString(rs, "name1"); 
        name2 = getString(rs, "name2"); 
        comlinetype = getString(rs, "hopstype");
        editRegion = getString(rs, "editRegion").equals("Y");
        int res1 = rs.getInt("resource1");
        int res2 = rs.getInt("resource2");
        if (res1 != res2) 
	        resourceName = getString(rs, "rname1") + " / " + getString(rs, "rname1");
        else
        	resourceName = getString(rs, "rname1");

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }

}
public Enumeration findComlineList(Boolean isAllNetZones, Integer[] netZones, Boolean isAllRegions, Integer[] regions, Boolean isAllSupregs, Integer[] supregs, String searchBy, String searchValue, Boolean isAdmin, String login, Integer sitedoc)
	throws Exception
{
    Query query;
    
    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, RESULT_JdbcObjectEnum);
    }

    query.append("AND hops.hopstype IN ('R','O') ");

    if (!isAllRegions.booleanValue()) {
        query.append("AND p1.regionid IN", regions);
        query.append("AND p2.regionid IN", regions);
    } else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
        query.append("AND reg1.supregid IN", supregs);
        query.append("AND reg2.supregid IN", supregs);
    }

    if (!isAllNetZones.booleanValue()) {
        query.append("AND p1.netzone IN", netZones);
        query.append("AND p2.netzone IN", netZones);
    }
    
	if (searchBy.equals(SEARCHBY_ADDRESS)) {
		query.append("AND (s1.address MATCHES ? OR s2.address MATCHES ?) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NAME)) {
		query.append("AND (s1.name MATCHES ? OR s2.name MATCHES ?) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NUMBER)) {
		query.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ",searchValue,searchValue);
	}

    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=? ", login);
    }
    query.append("AND hops.hopsid NOT IN (SELECT hopsid FROM sitedocs2hops WHERE sitedoc = ?) ",sitedoc);
    query.append(" ORDER BY hopsname");

//System.out.println("SQL Comline:\n\n"+query.getQueryString()+"\n\n");

    return findEnumeration(query);
}
public Enumeration findComlineList(Boolean isAllNetZones, Integer[] netZones, Boolean isAllRegions, Integer[] regions, Boolean isAllSupregs, Integer[] supregs, String searchBy, String searchValue, String comlinestate, Boolean isAdmin, String login, Integer sitedoc)
	throws Exception
{
    Query query;
    
    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, RESULT_JdbcObjectEnum);
    }

    query.append("AND hops.hopstype IN ('R','O') ");

    if (!isAllRegions.booleanValue()) {
        query.append("AND p1.regionid IN", regions);
        query.append("AND p2.regionid IN", regions);
    } else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
        query.append("AND reg1.supregid IN", supregs);
        query.append("AND reg2.supregid IN", supregs);
    }

    if (!isAllNetZones.booleanValue()) {
        query.append("AND p1.netzone IN", netZones);
        query.append("AND p2.netzone IN", netZones);
    }
    
	if (searchBy.equals(SEARCHBY_ADDRESS)) {
		query.append("AND (s1.address MATCHES ? OR s2.address MATCHES ?) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NAME)) {
		query.append("AND (s1.name MATCHES ? OR s2.name MATCHES ?) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NUMBER)) {
		query.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ",searchValue,searchValue);
	}

	if(comlinestate != null && !"".equals(comlinestate) && !"*".equals(comlinestate)) {
		query.append("AND hops.hopstate = ? ",comlinestate);
	}

    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=? ", login);
    }
    query.append("AND hops.hopsid NOT IN (SELECT hopsid FROM sitedocs2hops WHERE sitedoc = ?) ",sitedoc);
    query.append(" ORDER BY hopsname");

System.out.println("SQL Comline:\n\n"+query.getQueryString()+"\n\n");

    return findEnumeration(query);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComlinetype() {
	return comlinetype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHopstate() {
	return hopstate;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return int
 */
public Integer getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.String
 */
public java.lang.String getName2() {
	return name2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber2() {
	return number2;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 13:27:40)
 * @return java.lang.String
 */
public java.lang.String getProlet() {
	return prolet;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.String
 */
public java.lang.String getResourceName() {
	return resourceName;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return boolean
 */
public boolean isEditRegion() {
	return editRegion;
}
/**
 * 
 * @param newComlinetype java.lang.String
 */
public void setComlinetype(java.lang.String newComlinetype) {
	comlinetype = newComlinetype;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newEditRegion boolean
 */
public void setEditRegion(boolean newEditRegion) {
	editRegion = newEditRegion;
}
/**
 * 
 * @param newHopstate java.lang.String
 */
public void setHopstate(java.lang.String newHopstate) {
	hopstate = newHopstate;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newId int
 */
public void setId(Integer newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newName java.lang.String
 */
public void setName2(java.lang.String newName) {
	name2 = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newNumber java.lang.Integer
 */
public void setNumber2(java.lang.Integer newNumber) {
	number2 = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 13:27:40)
 * @param newProlet java.lang.String
 */
public void setProlet(java.lang.String newProlet) {
	prolet = newProlet;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newResourceName java.lang.String
 */
public void setResourceName(java.lang.String newResourceName) {
	resourceName = newResourceName;
}
}
