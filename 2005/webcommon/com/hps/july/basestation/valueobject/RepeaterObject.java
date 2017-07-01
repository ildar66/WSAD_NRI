package com.hps.july.basestation.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;
import java.math.*;

/**
 * Служебный класс позволяющий получать информацию о репитерах из БД
 */
public class RepeaterObject extends JdbcObject implements Checks, SearchConstants {
	private int id; //PK !
	private int positionId; // !
	
	private String posname; // !
	private String resourcename; // !
	private String repiterclass; // !
	private BigDecimal reppower; // !
	private BigDecimal bandwidthOrNumchanals; // !
	private String donortype; // !
	private boolean editRegion; // !
	private int number;
	
	
	private static final String QUERY_SELECT =
		"SELECT UNIQUE rep.equipment id, rep.number, " +
		"CASE( (CASE ra.viewfact WHEN NULL THEN 'N' ELSE ra.viewfact END) || (CASE sra.viewfact WHEN NULL THEN 'N' ELSE sra.viewfact END) ) " +
		"WHEN 'NN' THEN 'N' ELSE 'Y' END editRegion, " +
			"res.model resourceName, NVL('D'||p.gsmid||' ','') || NVL('A'||p.dampsid||' ','')||TRIM(s_pos.name) name, p.storageplace positionId, rep.repiter_class, rep.reppower, " +
			"rep.bandwidth, rep.numchanals, rep.donor_type, r.supregid supreg " +
		"FROM repiters rep, sectors, basestations, equipment e, positions p, storageplaces s_eq, storageplaces s_pos, netzones n, Regions r, " +
			"SuperRegions sr, operators o, OUTER RegionsAccess sra, OUTER RegionsAccess ra, OUTER resources res " +
		"WHERE s_pos.storageplace = p.storageplace " +
			"AND rep.resource = res.resource " +
			"AND s_eq.storageplace = e.equipment " +
			"AND e.equipment = rep.equipment " +
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
			"AND sectors.id_sect = rep.donor_sect " +
			"AND sectors.equipment = basestations.equipment";
		
	private static final String QUERY_SELECT_Admin =
		"SELECT UNIQUE rep.equipment id, rep.number, " +
			"'Y' editRegion, res.model resourceName,  NVL('D'||p.gsmid||' ','') || NVL('A'||p.dampsid||' ','')||TRIM(s_pos.name) name, p.storageplace positionId, rep.repiter_class, rep.reppower, " +
			"rep.bandwidth, rep.numchanals, rep.donor_type, r.supregid supreg " +
		"FROM repiters rep, sectors, basestations, equipment e, positions p, storageplaces s_eq, storageplaces s_pos, netzones n, " +
			"Regions r, SuperRegions sr, OUTER resources res " +
		"WHERE s_pos.storageplace = p.storageplace " +
			"AND rep.resource = res.resource " +
			"AND s_eq.storageplace = e.equipment " +
			"AND e.equipment = rep.equipment " +
			"AND e.position = p.storageplace " +
			"AND n.netzone = p.netzone " +
			"AND sr.supregid = r.supregid " +
			"AND r.regionid = p.regionid " +
			"AND sectors.id_sect = rep.donor_sect " +
			"AND sectors.equipment = basestations.equipment";
	private java.lang.Integer supreg = null;
    /**
     * PositionObject constructor comment.
     */
    public RepeaterObject() throws Exception {
        super();
    }
/**
 * PositionObject constructor comment.
 */
public RepeaterObject(java.sql.ResultSet rs) throws Exception {
/*		
	BigDecimal bandwidthOrNumchanals; // !
*/
    try {
		id = rs.getInt("id");
		positionId = rs.getInt("positionId");
		number = rs.getInt("number");
		editRegion = getString(rs, "editRegion").equals("Y");
		posname = getString(rs, "name");
		resourcename = getString(rs, "resourceName");
		repiterclass = getString(rs, "repiter_class");
		reppower = getBigDecimal(rs, "reppower");
		donortype = getString(rs, "donor_type");
		this.supreg = getInteger(rs, "supreg");
        
        if (repiterclass.equals("A") || repiterclass.equals("D") || repiterclass.equals("E")) {
	        bandwidthOrNumchanals = rs.getBigDecimal("bandwidth");
        } else if (repiterclass.equals("B") || repiterclass.equals("C")) {
	        bandwidthOrNumchanals = rs.getBigDecimal("numchanals");
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }
}
public Enumeration findRepeaterList(
	Boolean isAllNetZones, Integer[] netZones,
	Boolean isAllRegions, Integer[] regions,
	Boolean isAllSupregs, Integer[] supregs,
	String type,
	String searchBy, String searchValue,
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
	    query.append("AND e.state=?", state);
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
	
	if ("damps".equals(type)) query.append("AND basestations.type = ?", "D");
	else if (!type.equals(SearchConstants.SEARCH_ALL)) query.append("AND basestations.type <> ?", "D");
	
	String field = null;
	if ("numberbs".equals(searchBy)) {
		field = "basestations.number";
		try {
			Integer.decode(searchValue);
		} catch (NumberFormatException e) {
			searchValue = "";
		}
	} else if ("namepos".equals(searchBy)) field = "s_pos.name";
	else if ("addresspos".equals(searchBy)) field = "s_pos.address";
	else if ("numbersector".equals(searchBy)) field = "sectors.num_sect";
	
	if (field != null) query.append("AND " + field + (field.equals("basestations.number") ? "=" : " MATCHES ") + "?", searchValue);
	
	if (!isAdmin.booleanValue()) {
		query.append("AND o.loiginid=?", login);
	}

	query.append("order by name");
	
	return findEnumeration(query);
}
public Enumeration findSectorRepeaterList(Integer sector, String state, Boolean isAdmin, String login)
	throws Exception
{
	Query query;

	if (!isAdmin.booleanValue()) {
		query = new Query(QUERY_SELECT, RESULT_JdbcObjectEnum);
	} else {
		query = new Query(QUERY_SELECT_Admin, RESULT_JdbcObjectEnum);
	}

	if(state != null && !"*".equals(state)) {
	    query.append("AND e.state=?", state);
	}
	
	query.append("AND sectors.id_sect = ? ", sector);

	if (!isAdmin.booleanValue()) {
		query.append("AND o.loiginid=?", login);
	}

	query.append("order by name");

	return findEnumeration(query);
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2003 14:13:43)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBandwidthOrNumchanals() {
	return bandwidthOrNumchanals;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2003 14:13:43)
 * @return java.lang.String
 */
public java.lang.String getDonortype() {
	return donortype;
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
 * 
 * @return int
 */
public int getNumber() {
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
 * Creation date: (30.08.2003 14:13:43)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2003 14:13:43)
 * @return java.lang.String
 */
public java.lang.String getRepiterclass() {
	return repiterclass;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2003 14:13:43)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getReppower() {
	return reppower;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 14:08:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getSupreg() {
	return supreg;
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
 * Creation date: (30.08.2003 14:13:43)
 * @param newBandwidthOrNumchanals java.math.BigDecimal
 */
public void setBandwidthOrNumchanals(java.math.BigDecimal newBandwidthOrNumchanals) {
	bandwidthOrNumchanals = newBandwidthOrNumchanals;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2003 14:13:43)
 * @param newDonortype java.lang.String
 */
public void setDonortype(java.lang.String newDonortype) {
	donortype = newDonortype;
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
 * 
 * @param newNumber int
 */
public void setNumber(int newNumber) {
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
 * Creation date: (30.08.2003 14:13:43)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2003 14:13:43)
 * @param newRepiterclass java.lang.String
 */
public void setRepiterclass(java.lang.String newRepiterclass) {
	repiterclass = newRepiterclass;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2003 14:13:43)
 * @param newReppower java.math.BigDecimal
 */
public void setReppower(java.math.BigDecimal newReppower) {
	reppower = newReppower;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2003 21:45:18)
 * @param newResourceName java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2004 14:08:00)
 * @param newSupreg java.lang.Integer
 */
public void setSupreg(java.lang.Integer newSupreg) {
	supreg = newSupreg;
}
}
