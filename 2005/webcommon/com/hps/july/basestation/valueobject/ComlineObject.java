package com.hps.july.basestation.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;
import com.hps.july.basestation.formbean.ComlineListForm;

/**
 * Служебный класс позволяющий получать данные по линии связи из БД
 */
public class ComlineObject
	extends JdbcObject
	implements Checks, SearchConstants
{
	private Integer id; //PK   
	private String number;
	private String number2;
	private String resourceName;
	private String name;
	private String name2;
	private Integer p1;
	private Integer p2; 
	private boolean editRegion;
	private String beenetid;
	private String resourcea;
	private String resourceb;
	private String comlinetype;
	private String filenumber;

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
		"	hops.hopstype, TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, s1.name name1, TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, "+
		"	s2.name name2, r1.resource resource1, r2.resource resource2, r1.name rname1, r2.name rname2, cm2sp.name equname2, cm1sp.name equname1, "+
		"	p1.storageplace p1code, p2.storageplace p2code, hops.beenetid, "+
		"	p1.regionid p1reg, p2.regionid p2reg, reg1.supregid p1supreg, reg2.supregid p2supreg, "+
		"   (SELECT file_number FROM rrl_hops2 WHERE hopsid = hops.hopsid) filenumber "+
		"FROM "+
		"	hops, comequipment cm1, equipment e1, positions p1, storageplaces s1, regions reg1, superregions sreg1, "+
		"   storageplaces cm1sp, storageplaces cm2sp, "+
		"	outer resources r1, comequipment cm2, equipment e2, positions p2, storageplaces s2, regions reg2, superregions sreg2, "+
		"	outer resources r2, hopslabel hl, operators o, "+
		"	outer regionsaccess sreg1a, outer regionsaccess reg1a, outer regionsaccess sreg2a, outer regionsaccess reg2a "+
		"WHERE "+
		"	s1.storageplace = p1.storageplace AND "+
		"	p1.storageplace = e1.position AND "+
		"	e1.equipment = hops.equipmentid_enda AND "+
		"	cm1.equipment = e1.equipment AND "+
		"   cm1sp.storageplace = cm1.equipment AND "+
		"   r1.resource = cm1.resource AND "+
		"   s2.storageplace = p2.storageplace AND "+
		"   p2.storageplace = e2.position AND "+
		"   e2.equipment = hops.equipmentid_endb AND "+
		"   cm2.equipment = e2.equipment AND "+
		"   cm2sp.storageplace = cm2.equipment AND "+
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
		"	hops.hopsid hopsid, hl.hopsname hopsname, hops.hopstate, 'Y' editRegion, hops.hopstype, TRIM(NVL('D'||p1.gsmid,'') || ' ' || NVL('A'||p1.dampsid,'')) id1, s1.name name1, TRIM(NVL('D'||p2.gsmid,'') || ' ' || NVL('A'||p2.dampsid,'')) id2, "+
		"	s2.name name2, r1.resource resource1, r2.resource resource2, r1.name rname1, r2.name rname2, cm2sp.name equname2, cm1sp.name equname1, "+
		"	p1.storageplace p1code, p2.storageplace p2code, hops.beenetid, "+
		"	p1.regionid p1reg, p2.regionid p2reg,  reg1.supregid p1supreg, reg2.supregid p2supreg, "+
		"   (SELECT file_number FROM rrl_hops2 WHERE hopsid = hops.hopsid) filenumber "+
		"FROM "+
		"	hops, comequipment cm1, equipment e1, positions p1, storageplaces s1, regions reg1,  outer resources r1, "+
		"	comequipment cm2, equipment e2, positions p2, storageplaces s2, regions reg2, outer resources r2, "+
		"   storageplaces cm1sp, storageplaces cm2sp, "+
		"	hopslabel hl "+
		"WHERE "+
		"	s1.storageplace = p1.storageplace AND "+
		"	p1.storageplace = e1.position AND "+
		"	e1.equipment = hops.equipmentid_enda AND "+
		"	cm1.equipment = e1.equipment AND "+
		"   cm1sp.storageplace = cm1.equipment AND "+
		"	r1.resource = cm1.resource AND "+
		"	s2.storageplace = p2.storageplace AND "+
		"	p2.storageplace = e2.position AND "+
		"	e2.equipment = hops.equipmentid_endb AND "+
		"	cm2.equipment = e2.equipment AND "+
		"   cm2sp.storageplace = cm2.equipment AND "+
		"	r2.resource = cm2.resource AND "+
		"	hl.hopslabelid = (SELECT max(hopslabelid) FROM hopslabel hll WHERE hll.hopsid = hops.hopsid) AND "+
		"	hl.hopsid = hops.hopsid AND "+
		"	p1.regionid = reg1.regionid AND "+
		"	p2.regionid = reg2.regionid ";

	private java.lang.String prolet;
	private java.lang.Integer p1region = null;
	private java.lang.Integer p2region = null;
	private java.lang.Integer p1supreg = null;
	private java.lang.Integer p2supreg = null;

	private String equname1;
	private String equname2;
    /**
     * PositionObject constructor comment.
     */
    public ComlineObject() throws Exception {
        super();
    }
public ComlineObject(java.sql.ResultSet rs) throws Exception {
    super();

    try {
        id = new Integer(rs.getInt("hopsid"));
        prolet = getString(rs, "hopsname");
        hopstate = getString(rs, "hopstate");
        number = getString(rs, "id1");
        number2 = getString(rs, "id2");
        name = getString(rs, "name1"); 
        name2 = getString(rs, "name2");
        comlinetype = getString(rs, "hopstype");
        editRegion = getString(rs, "editRegion").equals("Y");
        p1 = new Integer(rs.getInt("p1code"));
        p2 = new Integer(rs.getInt("p2code"));
        p1region = new Integer(rs.getInt("p1reg"));
        p2region = new Integer(rs.getInt("p2reg"));
        p1supreg = new Integer(rs.getInt("p1supreg"));
        p2supreg = new Integer(rs.getInt("p2supreg"));
        beenetid = getString(rs, "beenetid");
        int res1 = rs.getInt("resource1");
        int res2 = rs.getInt("resource2");
        resourcea = getString(rs, "rname1");
        resourceb = getString(rs, "rname2");
        equname1 = getString(rs, "equname1");
        equname2 = getString(rs, "equname2");
		filenumber = getString(rs, "filenumber");
        resourceName = "";
        if(resourcea != null && !"".equals(resourcea)) {
	        resourceName = resourcea;
	        if(resourceb != null && !"".equals(resourceb)) {
		        resourceName += " / " + resourceb;
	        }
        } else {
	        resourceName = resourceb;
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 18:04:20)
 * @return java.lang.String
 */
public Enumeration findComlineList(
    Boolean isAllNetZones,
    Integer[] netZones,
    Boolean isAllRegions,
    Integer[] regions,
    Boolean isAllSupregs,
    Integer[] supregs,
    String searchBy,
    String searchValue,
    Boolean isAdmin,
    String login)
    throws Exception {

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
		query.append("AND (LOWER(s1.address) MATCHES LOWER(?) OR LOWER(s2.address) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NAME)) {
		query.append("AND (LOWER(s1.name) MATCHES LOWER(?) OR LOWER(s2.name) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_HOPSNAME)) {
		query.append("AND LOWER(hl.hopsname) MATCHES LOWER(?) ",searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_GSMNUMBER)) {
		query.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_DAMPSNUMBER)) {
		query.append("AND (p1.dampsid = ? OR p2.dampsid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_BEENETID)) {
		query.append("AND LOWER(hops.beenetid) MATCHES LOWER(?) ",searchValue);
	}

    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=? ", login);
    }
    query.append(" ORDER BY hopsname");

    return findEnumeration(query);
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 18:04:20)
 * @return java.lang.String
 */
public Enumeration findComlineList(
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
    String login)
    throws Exception {

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
		query.append("AND (LOWER(s1.address) MATCHES LOWER(?) OR LOWER(s2.address) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NAME)) {
		query.append("AND (LOWER(s1.name) MATCHES LOWER(?) OR LOWER(s2.name) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_HOPSNAME)) {
		query.append("AND LOWER(hl.hopsname) MATCHES LOWER(?) ",searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_GSMNUMBER)) {
		query.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_DAMPSNUMBER)) {
		query.append("AND (p1.dampsid = ? OR p2.dampsid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_BEENETID)) {
		query.append("AND LOWER(hops.beenetid) MATCHES LOWER(?) ",searchValue);
	}

	if(hopsstate != null && !"*".equals(hopsstate) && !"".equals(hopsstate)) {
		query.append("AND hops.hopstate = ? ",hopsstate);
	}

    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=? ", login);
    }
    query.append(" ORDER BY hopsname");

    return findEnumeration(query);
}
public Enumeration findComlineLookupList(
    Boolean isAllNetZones,
    Integer[] netZones,
    Boolean isAllRegions,
    Integer[] regions,
    Boolean isAllSupregs,
    Integer[] supregs,
    String searchBy,
    String searchValue,
    Boolean isAdmin,
    String login)
    throws Exception {

    Query query;
    
    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, RESULT_JdbcObjectEnum);
    }

    query.append("AND hops.hopstype = 'R' ");
    
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
		query.append("AND (LOWER(s1.address) MATCHES LOWER(?) OR LOWER(s2.address) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NAME)) {
		query.append("AND (LOWER(s1.name) MATCHES LOWER(?) OR LOWER(s2.name) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_HOPSNAME)) {
		query.append("AND LOWER(hl.hopsname) MATCHES LOWER(?) ",searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_GSMNUMBER)) {
		query.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_DAMPSNUMBER)) {
		query.append("AND (p1.dampsid = ? OR p2.dampsid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_BEENETID)) {
		query.append("AND LOWER(hops.beenetid) MATCHES LOWER(?) ",searchValue);
	}

    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=? ", login);
    }
    query.append(" ORDER BY hopsname");

    return findEnumeration(query);
}
public Enumeration findComlineLookupList(
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
    String login)
    throws Exception {

    Query query;
    
    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, RESULT_JdbcObjectEnum);
    }

    query.append("AND hops.hopstype = 'R' ");
    
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
		query.append("AND (LOWER(s1.address) MATCHES LOWER(?) OR LOWER(s2.address) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(SEARCHBY_NAME)) {
		query.append("AND (LOWER(s1.name) MATCHES LOWER(?) OR LOWER(s2.name) MATCHES LOWER(?)) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_HOPSNAME)) {
		query.append("AND LOWER(hl.hopsname) MATCHES LOWER(?) ",searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_GSMNUMBER)) {
		query.append("AND (p1.gsmid = ? OR p2.gsmid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_DAMPSNUMBER)) {
		query.append("AND (p1.dampsid = ? OR p2.dampsid = ?) ",searchValue,searchValue);
	} else if (searchBy.equals(ComlineListForm.SEARCHBY_BEENETID)) {
		query.append("AND LOWER(hops.beenetid) MATCHES LOWER(?) ",searchValue);
	}

	if(hopsstate != null && !"*".equals(hopsstate) && !"".equals(hopsstate)) {
		query.append("AND hops.hopstate = ? ",hopsstate);
	}

    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=? ", login);
    }
    query.append(" ORDER BY hopsname");

    return findEnumeration(query);
}
public Enumeration findComlinePositionList(Integer positionid, Boolean isAdmin, String login)
    throws Exception
{
    Query query;
    
    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, RESULT_JdbcObjectEnum);
    }

    query.append("AND hops.hopstype IN ('R','O') ");
    
	query.append("AND (p1.storageplace = ? OR p2.storageplace = ?) ",positionid,positionid);

	if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=? ", login);
    }
 
	query.append(" ORDER BY hopsname");

    return findEnumeration(query);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBeenetid() {
	return beenetid;
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
public java.lang.String getEquname1() {
	return equname1;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEquname2() {
	return equname2;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFilenumber() {
	return filenumber;
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
 * 
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNumber2() {
	return number2;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getP1() {
	return p1;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 17:41:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getP1region() {
	return p1region;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 13:53:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getP1supreg() {
	return p1supreg;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getP2() {
	return p2;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 17:42:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getP2region() {
	return p2region;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 13:53:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getP2supreg() {
	return p2supreg;
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
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcea() {
	return resourcea;
}
public java.lang.String getResourceb() {
	return resourceb;
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
 * Creation date: (11.05.2003 20:37:29)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 * @param baseStation com.hps.july.persistence.BaseStationAccessBean
 */
public static boolean hasAccess(
    HttpServletRequest request,
    int baseStationId)throws Exception {

    if (request.isUserInRole("administrator"))
        return true;
    try {
        BaseStationAccessBean baseStation = new BaseStationAccessBean();
        baseStation.setInitKey_storageplace(baseStationId);
        baseStation.refreshCopyHelper();

        OperatorAccessBean operator =
            new OperatorAccessBean().findByLogin(request.getRemoteUser());

        RegionAccAccessBeanTable table = new RegionAccAccessBeanTable();
        table.setRegionAccAccessBean(
            new RegionAccAccessBean().findRegionAccsByOperator(
                (OperatorKey) operator.__getKey()));
        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getRegionAccAccessBean(i).getRegionKey().regionid == baseStation.getPosition().getRegionKey().regionid && table.getRegionAccAccessBean(i).getEditfact()) {
                return true;
            }

        }

        return false;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
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
 * @param newBeenetid java.lang.String
 */
public void setBeenetid(java.lang.String newBeenetid) {
	beenetid = newBeenetid;
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
 * @param newEquname1 java.lang.String
 */
public void setEquname1(java.lang.String newEquname1) {
	equname1 = newEquname1;
}
/**
 * 
 * @param newEquname2 java.lang.String
 */
public void setEquname2(java.lang.String newEquname2) {
	equname2 = newEquname2;
}
/**
 * 
 * @param newFilenumber java.lang.String
 */
public void setFilenumber(java.lang.String newFilenumber) {
	filenumber = newFilenumber;
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
 * 
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * 
 * @param newNumber2 java.lang.String
 */
public void setNumber2(java.lang.String newNumber2) {
	number2 = newNumber2;
}
/**
 * 
 * @param newP1 java.lang.Integer
 */
public void setP1(java.lang.Integer newP1) {
	p1 = newP1;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 17:41:50)
 * @param newP1region java.lang.Integer
 */
public void setP1region(java.lang.Integer newP1region) {
	p1region = newP1region;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 13:53:30)
 * @param newP1supreg java.lang.Integer
 */
public void setP1supreg(java.lang.Integer newP1supreg) {
	p1supreg = newP1supreg;
}
/**
 * 
 * @param newP2 java.lang.Integer
 */
public void setP2(java.lang.Integer newP2) {
	p2 = newP2;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 17:42:12)
 * @param newP2region java.lang.Integer
 */
public void setP2region(java.lang.Integer newP2region) {
	p2region = newP2region;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 13:53:50)
 * @param newP2supreg java.lang.Integer
 */
public void setP2supreg(java.lang.Integer newP2supreg) {
	p2supreg = newP2supreg;
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
 * 
 * @param newResourcea java.lang.String
 */
public void setResourcea(java.lang.String newResourcea) {
	resourcea = newResourcea;
}
/**
 * 
 * @param newResourceb java.lang.String
 */
public void setResourceb(java.lang.String newResourceb) {
	resourceb = newResourceb;
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
