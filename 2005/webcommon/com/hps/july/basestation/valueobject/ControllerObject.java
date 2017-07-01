package com.hps.july.basestation.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;

/**
 * Служебный класс позволяющий получать информацию о контроллерах из БД
 */
public class ControllerObject extends JdbcObject implements Checks, SearchConstants {
	private int id; //PK   
	private Integer number;
	private String resourceName;
	private String name;
	private String address; //storageplaces
	private String zonecode; //netzone
	private boolean editRegion;
	private int positionId;
	
	private static final String QUERY_SELECT =
		"SELECT UNIQUE cntr.equipment id, " +
			"CASE p.planstate WHEN '1' THEN " +
				"(CASE(" +
				"(CASE ra.viewplan WHEN NULL THEN 'N' ELSE ra.viewplan END) || " +
				"(CASE sra.viewplan WHEN NULL THEN 'N' ELSE sra.viewplan END)) " +
				"WHEN 'NN' THEN 'N' ELSE 'Y' END) ELSE " +
				"(CASE(" +
				"(CASE ra.viewfact WHEN NULL THEN 'N' ELSE ra.viewfact END) || " +
				"(CASE sra.viewfact WHEN NULL THEN 'N' ELSE sra.viewfact END)) " +
				"WHEN 'NN' THEN 'N' ELSE 'Y' END) END editRegion, " +
			"res.model resourceName, cntr.number, s_eq.name, s_pos.address, n.zonecode, p.storageplace positionId, r.supregid supreg " +
		"FROM controllers cntr, equipment e, positions p, storageplaces s_eq, storageplaces s_pos, netzones n, Regions r, " +
			"SuperRegions sr, operators o, OUTER RegionsAccess sra, OUTER RegionsAccess ra, OUTER resources res " +
		"WHERE s_pos.storageplace = p.storageplace " +
			"AND cntr.resource = res.resource " +
			"AND s_eq.storageplace = e.equipment " +
			"AND e.equipment = cntr.equipment " +
			"AND e.position = p.storageplace " +
			"AND n.netzone = p.netzone " +
			"AND ((p.planstate = '1' AND (ra.viewplan = 'Y' OR sra.viewplan = 'Y')) OR (p.planstate = '2' AND (ra.viewfact = 'Y' OR sra.viewfact = 'Y'))) " +
			"AND sr.supregid = r.supregid " +
			"AND r.regionid = p.regionid " +
			"AND sra.accesstype = 'S' " +
			"AND ra.accesstype = 'R' " +
			"AND sra.supregionid = sr.supregid " +
			"AND ra.regionid = r.regionid " +
			"AND ra.operatorid = o.operator " +
			"AND sra.operatorid = o.operator " +
			"AND p.planstate <> 0";
		
	private static final String QUERY_SELECT_Admin =
		"SELECT UNIQUE cntr.equipment id, " +
			"'Y' editRegion, cntr.number, s_eq.name, s_pos.address, res.model resourceName, n.zonecode, p.storageplace positionId, r.supregid supreg " +
		"FROM controllers cntr, equipment e, positions p, storageplaces s_eq, storageplaces s_pos, netzones n, " +
			"Regions r,SuperRegions sr, OUTER resources res " +
		"WHERE s_pos.storageplace = p.storageplace " +
			"AND cntr.resource = res.resource " +
			"AND s_eq.storageplace = e.equipment " +
			"AND e.equipment=cntr.equipment " +
			"AND e.position=p.storageplace " +
			"AND n.netzone = p.netzone " +
			"AND sr.supregid=r.supregid " +
			"AND r.regionid = p.regionid " +
			"AND p.planstate <> 0";
	private java.lang.Integer supreg = null;
    /**
     * PositionObject constructor comment.
     */
    public ControllerObject() throws Exception {
        super();
    }
/**
 * PositionObject constructor comment.
 */
public ControllerObject(java.sql.ResultSet rs) throws Exception {
    //"SELECT DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') type ,DECODE(bs.on_air,'Y','Э','') on_air,bs.number,bs.name,s.address,n.zonecode, e.planstate FROM basestations bs,equipment e, positions p, storageplaces s, netzones n, Regions r WHERE s.storageplace = p.storageplace AND n.netzone = p.netzone AND r.regionid = p.regionid AND e.equipment=bs.equipment AND e.position=p.storageplace"
    try {
        id = rs.getInt("id");
        positionId = rs.getInt("positionId");
        name = getString(rs, "name"); //storageplace 
        address = getString(rs, "address"); //storageplace 
        zonecode = getString(rs, "zonecode"); //netzone
        number = (Integer) rs.getObject("number");
        resourceName = getString(rs,"resourceName");
        editRegion = getString(rs, "editRegion").equals("Y");
        this.supreg = getInteger(rs, "supreg");
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
public Enumeration findControllerList(
	Boolean isAllNetZones, Integer[] netZones,
	Boolean isAllRegions, Integer[] regions,
	Boolean isAllSupregs, Integer[] supregs,
	String searchBy, String searchValue,
	Boolean isSwitch, Integer switchcode,
	String state, String planState,
	Boolean isAdmin,
	String login
	) throws Exception {
	
	Query query;
	
    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, RESULT_JdbcObjectEnum);
    }

    if(state != null && !"*".equals(state)) {
		query.append("AND e.state = ? ", state);
    }

    if (!isAllRegions.booleanValue()) {
        query.append("AND p.regionid IN", regions);
    } else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
        query.append("AND sr.supregid IN", supregs);
    }

    if (!planState.equals(SEARCH_ALL)) {
        query.append("AND p.planstate=?", planState);
    }

    if (!isAllNetZones.booleanValue()) {
        query.append("AND p.netzone IN", netZones);
    }
	
	String field = null;
	if (searchBy.equals(SEARCHBY_ADDRESS))
		field = "s_pos.address";
	else if (searchBy.equals(SEARCHBY_NAME))
		field = "s_eq.name";
	else if (searchBy.equals(SEARCHBY_NUMBER)) {
		field = "cntr.number";
		try {
			Integer.decode(searchValue);
		} catch (NumberFormatException e) {
			searchValue = "";
		}
	}
	
	if (field != null)
        query.append(
            "AND " + field + (field.equals("cntr.number") ? "=" : " MATCHES ") + "?",
            searchValue);
	
	if (!isSwitch.booleanValue()) {
		query.append("AND cntr.switch=?", switchcode);
	}

    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=?", login);
    }

    
    query.append(" order by cntr.number");

    return findEnumeration(query);
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return int
 */
public int getId() {
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
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 18:42:03)
 * @return int
 */
public int getPositionId() {
	return positionId;
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
 * Creation date: (07.12.2004 14:42:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getSupreg() {
	return supreg;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.String
 */
public java.lang.String getZonecode() {
	return zonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (11.05.2003 20:37:29)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 * @param baseStation com.hps.july.persistence.BaseStationAccessBean
 */
public static boolean hasAccess(HttpServletRequest request, int baseStationId) throws Exception {
    if (request.isUserInRole("administrator")) return true;
    
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
            if (table.getRegionAccAccessBean(i).getRegionKey().regionid
                == baseStation.getPosition().getRegionKey().regionid
                && table.getRegionAccAccessBean(i).getEditfact()) {
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
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
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
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newId int
 */
public void setId(int newId) {
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
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 18:42:03)
 * @param newPositionId int
 */
public void setPositionId(int newPositionId) {
	positionId = newPositionId;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newResourceName java.lang.String
 */
public void setResourceName(java.lang.String newResourceName) {
	resourceName = newResourceName;
}
/**
 * Insert the method's description here.
 * Creation date: (07.12.2004 14:42:37)
 * @param newSupreg java.lang.Integer
 */
public void setSupreg(java.lang.Integer newSupreg) {
	supreg = newSupreg;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newZonecode java.lang.String
 */
public void setZonecode(java.lang.String newZonecode) {
	zonecode = newZonecode;
}
}
