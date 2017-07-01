package com.hps.july.cdbc.objects;

import java.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import javax.sql.*;

/**
 * Объект для работы с позициями.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCPositionObject {
	public final static String SEARCHBY_ALL = "A";
	public final static String SEARCHBY_BSGSM = "F";
	public final static String SEARCHBY_BSDAMPS = "G";
	public final static String SEARCHBY_NOBS = "H";
	public final static String SEARCHBY_GSMID = "B";
	public final static String SEARCHBY_DAMPSID = "C";
	public final static String SEARCHBY_NAME = "D";
	public final static String SEARCHBY_ADDR = "E";
	public final static String SEARCHBY_TRID = "I";
	public final static String SEARCHBY_TRALL = "K";
	public final static String SEARCHBY_TRRRL = "L";
	public final static String SEARCHBY_TRVOT = "M";

	public final static String RENTER_NOTNULL = "NotNull";
	public final static String RENTER_ANY = "any";
	public final static String RENTER_SPECIFY = "specify";
	public final static String INACTION_Y = "Y";
	public final static String INACTION_N = "N";
	public final static String INACTION_ALL = "all";
	public final static String GENPODR = "GENPODR";
	public final static String VCPODR = "VCPODR";

	private String POSITION_ADMIN_REQUEST = 
		"SELECT p.storageplace, p.dampsname, p.gsmid, p.dampsid, TRIM(sp.name) || NVL(', ' || TRIM(p.dampsname),'') posname, TRIM(sp.address) posaddress, nz.name zonecode, p.inaction, p.posstate, p.regionid, r.supregid, "+
		"getNumBsGsmOnPos(p.storageplace, 1) numgsm, " +
		"getNumBsDampsOnPos(p.storageplace, 1) numdamps, " +
		"getNumRepiterOnPos(p.storageplace, 1) numrep, " +
//		"(SELECT max(sdp.sitedoc) FROM sitedocs2splace sdp, sitedocs sd WHERE sdp.sitedoc = sd.sitedoc AND sd.sitedoctype = ? AND sdp.storageplace = p.storageplace) waymap, "+
//		"(SELECT max(sdp.sitedoc) FROM sitedocs2splace sdp, sitedocs sd WHERE sdp.sitedoc = sd.sitedoc AND sd.sitedoctype = ? AND sdp.storageplace = p.storageplace) passlist, "+
		" getActiveTerrabyteDoc(p.storageplace, 10, 'pos') waymap, "+
		" getActiveTerrabyteDoc(p.storageplace, 9, 'pos') passlist, "+
		"'Y' sr_editfact, 'Y' sr_editplan, 'Y' r_editfact, 'Y' r_editplan "+
		"FROM positions p, storageplaces sp, netzones nz, regions r  "+
		"WHERE p.storageplace = sp.storageplace AND sp.type='P' AND p.netzone = nz.netzone AND r.regionid = p.regionid AND p.planstate <> 0 ";
	private String POSITION_USER_REQUEST =
		"SELECT p.storageplace, p.dampsname, p.gsmid, p.dampsid, TRIM(sp.name) || NVL(', ' || TRIM(p.dampsname),'') posname, TRIM(sp.address) posaddress, nz.name zonecode, p.inaction, p.posstate, p.regionid, r.supregid, "+
		"getNumBsGsmOnPos(p.storageplace, 1) numgsm, " +
		"getNumBsDampsOnPos(p.storageplace, 1) numdamps, " +
		"getNumRepiterOnPos(p.storageplace, 1) numrep, " +
//		"(SELECT max(sdp.sitedoc) FROM sitedocs2splace sdp, sitedocs sd WHERE sdp.sitedoc = sd.sitedoc AND sd.sitedoctype = ? AND sdp.storageplace = p.storageplace) waymap, "+
//		"(SELECT max(sdp.sitedoc) FROM sitedocs2splace sdp, sitedocs sd WHERE sdp.sitedoc = sd.sitedoc AND sd.sitedoctype = ? AND sdp.storageplace = p.storageplace) passlist, "+
		" getActiveTerrabyteDoc(p.storageplace, 10, 'pos') waymap, "+
		" getActiveTerrabyteDoc(p.storageplace, 9, 'pos') passlist, "+
		"sra.editfact sr_editfact, sra.editplan sr_editplan, ra.editfact r_editfact, ra.editplan r_editplan "+
		"FROM positions p, storageplaces sp, netzones nz, operators o, regions r, outer regionsaccess sra, outer regionsaccess ra "+
		"WHERE p.storageplace = sp.storageplace AND sp.type='P' AND p.netzone = nz.netzone AND r.regionid = p.regionid "+
		"AND sra.accesstype = 'S' AND sra.supregionid = r.supregid AND sra.operatorid = o.operator "+
		"AND ra.accesstype = 'R' AND ra.regionid = r.regionid AND ra.operatorid = o.operator "+
		"AND ( "+
		"    (p.planstate='1' AND (p.regionid IN (SELECT r.regionid FROM regions r WHERE r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewplan = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewplan = 'Y' AND sra.operatorid = o.operator)))) "+
		"    OR "+
		"    (p.planstate='2' AND (p.regionid IN (SELECT r.regionid FROM regions r WHERE r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = o.operator)))) "+
		") "+
		"AND p.planstate <> 0 ";

	private String POSITION_ADMIN_REQUEST_LOOKUP =
		"SELECT p.storageplace, p.gsmid, p.dampsid, TRIM(sp.name) posname, TRIM(p.dampsname) dampsname, TRIM(sp.address) posaddress, nz.name zonecode, p.inaction, p.posstate, "+
		"getNumBsGsmOnPos(p.storageplace, 1) numgsm, " +
		"getNumBsDampsOnPos(p.storageplace, 1) numdamps, " +
		"getNumRepiterOnPos(p.storageplace, 1) numrep, " +
		"TRIM(sr.supregname) supregname, TRIM(r.regname) regionname, TRIM(nz.name) zonename, p.longitude longitude, p.latitude latitude, p.date_beginbuild datebeginbuild "+
		"FROM positions p, storageplaces sp, netzones nz, regions r, superregions sr "+
		"WHERE p.storageplace = sp.storageplace AND sp.type='P' AND p.netzone = nz.netzone AND p.regionid = r.regionid AND r.supregid = sr.supregid AND p.planstate <> 0 ";
	private String POSITION_USER_REQUEST_LOOKUP =
		"SELECT p.storageplace, p.gsmid, p.dampsid, TRIM(sp.name) posname, TRIM(p.dampsname) dampsname, TRIM(sp.address) posaddress, nz.name zonecode, p.inaction, p.posstate, "+
		"getNumBsGsmOnPos(p.storageplace, 1) numgsm, " +
		"getNumBsDampsOnPos(p.storageplace, 1) numdamps, " +
		"getNumRepiterOnPos(p.storageplace, 1) numrep, " +
		"TRIM(sr.supregname) supregname, TRIM(r.regname) regionname, TRIM(nz.name) zonename, p.longitude longitude, p.latitude latitude, p.date_beginbuild datebeginbuild "+
		"FROM positions p, storageplaces sp, netzones nz, operators o, regions r, superregions sr "+
		"WHERE p.storageplace = sp.storageplace AND sp.type='P' AND p.netzone = nz.netzone AND p.regionid = r.regionid AND r.supregid = sr.supregid "+
		"AND ( "+
		" (p.planstate='1' AND (p.regionid IN (SELECT r.regionid FROM regions r WHERE r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewplan = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewplan = 'Y' AND sra.operatorid = o.operator)))) "+
		" OR "+
		" (p.planstate='2' AND (p.regionid IN (SELECT r.regionid FROM regions r WHERE r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = o.operator)))) "+
		") "+
		"AND p.planstate <> 0 ";

/**
 * CDBCPositionObject constructor comment.
 */
public CDBCPositionObject() {
	super();
}
public static void appendIN(StringBuffer sb, String param, char[] array)
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
			sb.append('\'');
			sb.append(array[i]);
			sb.append('\'');
		}
		sb.append(") ");
	}
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
/**
 * Удаляет все контейнеры с позиции
 */
public boolean deleteContainers(int argPosition) throws java.lang.Exception {
		boolean result = false;
		JdbcConnection jcon = new JdbcConnection();
		Connection con = jcon.getConnection();
		try {
			Statement st = con.createStatement();
			result = st.execute("DELETE FROM containers WHERE storageplace = " + argPosition);
		} finally {
			con.close();
		}
		return result;
}
/**
 * Возвращает список всех мест размещения антенн
 */
public CDBCResultSet findAllAntennPlaces() throws java.lang.Exception {
		
	Object[] args = null;

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT antplaceid, name, isvc ");
    sb.append("FROM antennplaces ");
    sb.append("ORDER BY name ");
    
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args);
	return res;
}
/**
 * Возвращает список всех мест размещения аппаратной
 */
public CDBCResultSet findAllApparatPlaces() throws java.lang.Exception {
		
	Object[] args = null;

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT applaceid, name ");
    sb.append("FROM apparatplaces ");
    sb.append("ORDER BY name ");
    
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args);
	return res;
}
/**
 * Возвращает список всех типов помещения аппаратной
 */
public CDBCResultSet findAllApparatPlaceTypes() throws java.lang.Exception {
		
	Object[] args = null;

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT applacetypeid, name ");
    sb.append("FROM applacetypes ");
    sb.append("ORDER BY name ");
    
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args);
	return res;
}
/**
 * Возвращает список всех типов аппаратной
 */
public CDBCResultSet findAllApparatTypes() throws java.lang.Exception {
		
	Object[] args = null;

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT aptypeid, name, aptype ");
    sb.append("FROM apparattypes ");
    sb.append("ORDER BY name ");
    
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args);
	return res;
}
/**
 * Возвращает список всех мест размещения опор
 */
public CDBCResultSet findAllOporaPlaces() throws java.lang.Exception {
		
	Object[] args = null;

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT oplaceid, name ");
    sb.append("FROM oporaplaces ");
    sb.append("ORDER BY name ");
    
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args);
	return res;
}
/**
 * Возвращает список контейнеров на позиции
 */
public CDBCResultSet findContainers(int argPosition) throws java.lang.Exception {
		
	Object[] args = null;

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT c.container, c.resource, TRIM(r.name) name,TRIM(r.model) model, c.contyear, c.contwidth, c.contheight, c.contlength ");
    sb.append("FROM containers c, resources r ");
    sb.append("WHERE r.resource = c.resource AND c.storageplace =  " + argPosition);
    sb.append(" ORDER BY c.container ");
    
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args);
	return res;
}
/**
 * Возвращает Ген. подрядчика 
 */
public CDBCRowObject findPodrOrganization(int argPosition, String argPodrType)  {
		
	Object[] args = null;

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT o.organization, TRIM(o.name) name, TRIM(o.shortname) shortname ");
    sb.append("FROM organizations o ");
    sb.append("WHERE organization IN (SELECT w.organization FROM workresponsibility w WHERE ");
    sb.append("w.storageplace = " + argPosition + " AND w.resptype = 'O' AND ");
    sb.append("w.idresponsibility IN (SELECT n.intvalue FROM namedvalues n WHERE n.id='" + argPodrType + "') ");
    sb.append(") ");
    sb.append("ORDER BY o.organization ");
    
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args);
	ListIterator it = res.listIterator();
	if (it.hasNext()) {
		CDBCRowObject rores = (CDBCRowObject)it.next();
		return rores;
	}
	return null;
}
public CDBCResultSet findPositionBsDAMPSNumbers(int argPosition)
{
	StringBuffer sb = new StringBuffer();

	sb.append("SELECT 'A' || bs.number number ");
	sb.append("FROM equipment equ, storageplaces sp, basestations bs ");
	sb.append("WHERE sp.storageplace = equ.equipment AND bs.equipment = equ.equipment AND equ.position = ? AND sp.type = 'B' AND bs.type = 'D' ");
	sb.append("ORDER BY number ");
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), new Object[] { new Integer(argPosition) });
	return res;
}
public CDBCResultSet findPositionBsGSMNumbers(int argPosition)
{
	StringBuffer sb = new StringBuffer();

	sb.append("SELECT 'D' || bs.number number ");
	sb.append("FROM equipment equ, storageplaces sp, basestations bs ");
	sb.append("WHERE sp.storageplace = equ.equipment AND bs.equipment = equ.equipment AND equ.position = ? AND sp.type = 'B' AND bs.type IN ('G','C','S') ");
	sb.append("ORDER BY number ");
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), new Object[] { new Integer(argPosition) });
	return res;
}
public CDBCResultSet findPositionControllerNumbers(int argPosition)
{
	StringBuffer sb = new StringBuffer();

	sb.append("SELECT 'K' || cl.number number ");
	sb.append("FROM equipment equ, storageplaces sp, controllers cl ");
	sb.append("WHERE sp.storageplace = equ.equipment AND cl.equipment = equ.equipment AND equ.position = ? AND sp.type = 'O' ");
	sb.append("ORDER BY number ");
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), new Object[] { new Integer(argPosition) });
	return res;
}
/**
 * Выбор позиций
 * Creation date: (24.03.2004)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public CDBCResultSet findPositions(
	java.lang.Boolean isNetZone,
	java.lang.Integer[] argNetZones,
    java.lang.Boolean isGsmId,
    java.lang.String argGsmId,
    java.lang.Boolean isDampsId,
    java.lang.String argDampsId,
    java.lang.Boolean isName,
    java.lang.String argName,
    java.lang.Boolean isBeenetid,
    java.lang.String argBeenetid,
    java.lang.Boolean isAddr,
    java.lang.String argAddr,
    java.lang.String argRenterSearchType,
    java.lang.Integer argRenter,
    Boolean isResponsableWorker,
    Integer argResponsableWorker,
    String argInAction,
    String argPosstate,
    Boolean isRegions,
    Integer[] argRegions,
    Boolean isSupregs,
    Integer[] argSupregs,
    Boolean isAdmin,
    String login,
    Boolean isTranspAll,
    Boolean isTranspRRL,
    Boolean isTranspVOT,
    Boolean isTranspID,
    java.lang.String argTranspId,
    Boolean isController, String argControllerNumber,
    Boolean isWLAN, String argWLANNumber,
    Boolean isRepeater, String argRepNumber,
    java.lang.Integer order
) {
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(POSITION_ADMIN_REQUEST);
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType")));
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType")));
	} else {
		sb.append(POSITION_USER_REQUEST);
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType")));
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType")));
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}

	if (isTranspAll.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment) ");
    }
    
    if (isTranspRRL.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
    }
    
    if (isTranspVOT.booleanValue()) {
        sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
    }
    
    if (isTranspID.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND (upper(sp1.name) matches upper(?) OR upper(ce1.osinvname) matches upper(?))) ");
		params.add(argTranspId);
		params.add(argTranspId);
	}

    if (isController != null && isController.booleanValue()) {
	    sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, controllers c1 WHERE c1.equipment = e1.equipment  AND ''||c1.number matches upper(?)) ");
	    params.add(argControllerNumber);
    }

    if (isWLAN != null && isWLAN.booleanValue()) {
	    sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, wlan w1 WHERE w1.equipment = e1.equipment  AND ''||w1.number matches upper(?)) ");
	    params.add(argWLANNumber);
    }

    if (isRepeater != null && isRepeater.booleanValue()) {
	    sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, repiters r1 WHERE r1.equipment = e1.equipment AND ''||r1.number matches ?) ");
	    params.add(argRepNumber);
    }

	if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
		appendIN(sb, "AND r.supregid ", argSupregs);
	}

	if (isRegions.booleanValue()) {
		appendIN(sb, "AND p.regionid ", argRegions);
	}

	if (argPosstate != null && !"*".equals(argPosstate)) {
		appendIN(sb, "AND p.posstate ", getPosstateList(argPosstate));
	}

	if (isNetZone.booleanValue()) {
		appendIN(sb, "AND p.netzone ", argNetZones);
	}

	if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
		// Special case - find positions without base stations
		sb.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
		if (isGsmId.booleanValue()) {
			if ((argGsmId == null) || ("".equals(argGsmId))) {
				sb.append("AND p.gsmid IS NOT NULL ");
			} else {
				if(argGsmId != null) {
					sb.append("AND p.gsmid = ? ");
					params.add(argGsmId);
				} else {
					sb.append("AND p.gsmid IS NULL ");
				}
			}
		}
		if (isDampsId.booleanValue()) {
			if ((argDampsId == null) || ("".equals(argDampsId))) {
				sb.append("AND p.dampsid IS NOT NULL ");
			} else {
				if(argDampsId != null) {
					sb.append("AND p.dampsid = ? ");
					params.add(argDampsId);
				} else {
					sb.append("AND p.dampsid IS NULL ");
				}
			}
		}
	}

	if (isName.booleanValue()) {
		sb.append("AND (upper(sp.name) matches upper(?) or upper(p.dampsname) matches upper(?)) ");
		params.add(argName);
		params.add(argName);
	}

	if (isBeenetid != null && isBeenetid.booleanValue()) {
		if(argBeenetid != null) {
			sb.append("AND p.storageplace IN (SELECT position FROM beenetobjects WHERE LOWER(beenetid) MATCHES ?) ");
			params.add(argBeenetid.toLowerCase());
		} else {
			sb.append("AND p.storageplace IN (SELECT position FROM beenetobjects WHERE beenetid IS NULL) ");
		}
	}

	if (isAddr.booleanValue()) {
		sb.append("AND upper(sp.address) matches upper(?) ");
		params.add(argAddr);
	}

	if (argRenterSearchType.equals(RENTER_SPECIFY)) {
		if(argRenter != null) {
			sb.append("AND p.renter = ? ");
			params.add(argRenter);
		} else {
			sb.append("AND p.renter IS NULL ");
		}
	} else if (argRenterSearchType.equals(RENTER_NOTNULL)) {
		sb.append("AND p.renter IS NOT NULL ");
	}

	if (isResponsableWorker.booleanValue()) {
		sb.append("AND exists (select w.worker from workresponsibility w where w.storageplace = sp.storageplace AND w.worker = ?) ");
		params.add(argResponsableWorker);
	}

	if (!argInAction.equals(INACTION_ALL)) {
		sb.append("AND p.inaction = ? ");
		params.add(argInAction);
    }
    
    //append order by clause
    String orderBy = null;
	switch (order.intValue()) {
	case 1 :
		sb.append("ORDER BY p.storageplace ASC ");
		break;
	case 2 :
		sb.append("ORDER BY p.storageplace DESC ");
		break;
	case 3 :
		sb.append("ORDER BY posname ASC ");
		break;
	case 4 :
		sb.append("ORDER BY posname DESC ");
		break;
	case 5 :
		sb.append("ORDER BY p.gsmid ASC ");
		break;
	case 6 :
		sb.append("ORDER BY p.gsmid DESC ");
		break;
	case 7 :
		sb.append("ORDER BY p.dampsid ASC ");
		break;
	case 8 :
		sb.append("ORDER BY p.dampsid DESC ");
		break;
	}
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
//System.out.println("POSSQL: " + sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор позиций
 * Creation date: (24.03.2004)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public CDBCResultSet findPositions(
	java.lang.Boolean isNetZone,
	java.lang.Integer[] argNetZones,
    java.lang.Boolean isGsmId,
    java.lang.String argGsmId,
    java.lang.Boolean isDampsId,
    java.lang.String argDampsId,
    java.lang.Boolean isName,
    java.lang.String argName,
    java.lang.Boolean isBeenetid,
    java.lang.String argBeenetid,
    java.lang.Boolean isAddr,
    java.lang.String argAddr,
    java.lang.String argRenterSearchType,
    java.lang.Integer argRenter,
    Boolean isResponsableWorker,
    Integer argResponsableWorker,
    String argInAction,
    String argPosstate,
    Boolean isRegions,
    Integer[] argRegions,
    Boolean isSupregs,
    Integer[] argSupregs,
    Boolean isAdmin,
    String login,
    Boolean isTranspAll,
    Boolean isTranspRRL,
    Boolean isTranspVOT,
    Boolean isTranspID,
    java.lang.String argTranspId,
    java.lang.Integer order
) {
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(POSITION_ADMIN_REQUEST);
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType")));
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType")));
	} else {
		sb.append(POSITION_USER_REQUEST);
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType")));
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType")));
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}

	if (isTranspAll.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment) ");
    }
    
    if (isTranspRRL.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
    }
    
    if (isTranspVOT.booleanValue()) {
        sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
    }
    
    if (isTranspID.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND (upper(sp1.name) matches upper(?) OR upper(ce1.osinvname) matches upper(?))) ");
		params.add(argTranspId);
		params.add(argTranspId);
	}

	if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
		appendIN(sb, "AND r.supregid ", argSupregs);
	}

	if (isRegions.booleanValue()) {
		appendIN(sb, "AND p.regionid ", argRegions);
	}

	if (argPosstate != null && !"*".equals(argPosstate)) {
		appendIN(sb, "AND p.posstate ", getPosstateList(argPosstate));
	}

	if (isNetZone.booleanValue()) {
		appendIN(sb, "AND p.netzone ", argNetZones);
	}

	if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
		// Special case - find positions without base stations
		sb.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
		if (isGsmId.booleanValue()) {
			if ((argGsmId == null) || ("".equals(argGsmId))) {
				sb.append("AND p.gsmid IS NOT NULL ");
			} else {
				if(argGsmId != null) {
					sb.append("AND p.gsmid = ? ");
					params.add(argGsmId);
				} else {
					sb.append("AND p.gsmid IS NULL ");
				}
			}
		}
		if (isDampsId.booleanValue()) {
			if ((argDampsId == null) || ("".equals(argDampsId))) {
				sb.append("AND p.dampsid IS NOT NULL ");
			} else {
				if(argDampsId != null) {
					sb.append("AND p.dampsid = ? ");
					params.add(argDampsId);
				} else {
					sb.append("AND p.dampsid IS NULL ");
				}
			}
		}
	}

	if (isName.booleanValue()) {
		sb.append("AND (upper(sp.name) matches upper(?) or upper(p.dampsname) matches upper(?)) ");
		params.add(argName);
		params.add(argName);
	}

	if (isBeenetid != null && isBeenetid.booleanValue()) {
		if(argBeenetid != null) {
			sb.append("AND p.storageplace IN (SELECT e.position FROM beenet2equip b2e, equipment e WHERE b2e.equipment = e.equipment AND b2e.beenetid MATCHES ?) ");
			params.add(argBeenetid);
		} else {
			sb.append("AND p.storageplace IN (SELECT e.position FROM beenet2equip b2e, equipment e WHERE b2e.equipment = e.equipment AND b2e.beenetid IS NULL) ");
		}
	}

	if (isAddr.booleanValue()) {
		sb.append("AND upper(sp.address) matches upper(?) ");
		params.add(argAddr);
	}

	if (argRenterSearchType.equals(RENTER_SPECIFY)) {
		if(argRenter != null) {
			sb.append("AND p.renter = ? ");
			params.add(argRenter);
		} else {
			sb.append("AND p.renter IS NULL ");
		}
	} else if (argRenterSearchType.equals(RENTER_NOTNULL)) {
		sb.append("AND p.renter IS NOT NULL ");
	}

	if (isResponsableWorker.booleanValue()) {
		sb.append("AND exists (select w.worker from workresponsibility w where w.storageplace = sp.storageplace AND w.worker = ?) ");
		params.add(argResponsableWorker);
	}

	if (!argInAction.equals(INACTION_ALL)) {
		sb.append("AND p.inaction = ? ");
		params.add(argInAction);
    }
    
    //append order by clause
    String orderBy = null;
	switch (order.intValue()) {
	case 1 :
		sb.append("ORDER BY p.storageplace ASC ");
		break;
	case 2 :
		sb.append("ORDER BY p.storageplace DESC ");
		break;
	case 3 :
		sb.append("ORDER BY posname ASC ");
		break;
	case 4 :
		sb.append("ORDER BY posname DESC ");
		break;
	case 5 :
		sb.append("ORDER BY p.gsmid ASC ");
		break;
	case 6 :
		sb.append("ORDER BY p.gsmid DESC ");
		break;
	case 7 :
		sb.append("ORDER BY p.dampsid ASC ");
		break;
	case 8 :
		sb.append("ORDER BY p.dampsid DESC ");
		break;
	}
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	//System.out.println("POSSQL: " + sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор позиций
 * Creation date: (24.03.2004)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public CDBCResultSet findPositions(
	java.lang.Boolean isNetZone,
	java.lang.Integer[] argNetZones,
    java.lang.Boolean isGsmId,
    java.lang.String argGsmId,
    java.lang.Boolean isDampsId,
    java.lang.String argDampsId,
    java.lang.Boolean isName,
    java.lang.String argName,
    java.lang.Boolean isAddr,
    java.lang.String argAddr,
    java.lang.String argRenterSearchType,
    java.lang.Integer argRenter,
    Boolean isResponsableWorker,
    Integer argResponsableWorker,
    String argInAction,
    String argPosstate,
    Boolean isRegions,
    Integer[] argRegions,
    Boolean isSupregs,
    Integer[] argSupregs,
    Boolean isAdmin,
    String login,
    Boolean isTranspAll,
    Boolean isTranspRRL,
    Boolean isTranspVOT,
    Boolean isTranspID,
    java.lang.String argTranspId,
    java.lang.Integer order
) {
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(POSITION_ADMIN_REQUEST);
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType")));
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType")));
	} else {
		sb.append(POSITION_USER_REQUEST);
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType")));
		//params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType")));
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}

	if (isTranspAll.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment) ");
    }
    
    if (isTranspRRL.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
    }
    
    if (isTranspVOT.booleanValue()) {
        sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
    }
    
    if (isTranspID.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND (upper(sp1.name) matches upper(?) OR upper(ce1.osinvname) matches upper(?))) ");
		params.add(argTranspId);
		params.add(argTranspId);
	}

	if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
		appendIN(sb, "AND r.supregid ", argSupregs);
	}

	if (isRegions.booleanValue()) {
		appendIN(sb, "AND p.regionid ", argRegions);
	}

	if (argPosstate != null && !"*".equals(argPosstate)) {
		appendIN(sb, "AND p.posstate ", getPosstateList(argPosstate));
	}

	if (isNetZone.booleanValue()) {
		appendIN(sb, "AND p.netzone ", argNetZones);
	}

	if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
		// Special case - find positions without base stations
		sb.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
		if (isGsmId.booleanValue()) {
			if ((argGsmId == null) || ("".equals(argGsmId))) {
				sb.append("AND p.gsmid IS NOT NULL ");
			} else {
				if(argGsmId != null) {
					sb.append("AND p.gsmid = ? ");
					params.add(argGsmId);
				} else {
					sb.append("AND p.gsmid IS NULL ");
				}
			}
		}
		if (isDampsId.booleanValue()) {
			if ((argDampsId == null) || ("".equals(argDampsId))) {
				sb.append("AND p.dampsid IS NOT NULL ");
			} else {
				if(argDampsId != null) {
					sb.append("AND p.dampsid = ? ");
					params.add(argDampsId);
				} else {
					sb.append("AND p.dampsid IS NULL ");
				}
			}
		}
	}

	if (isName.booleanValue()) {
		sb.append("AND (upper(sp.name) matches upper(?) or upper(p.dampsname) matches upper(?)) ");
		params.add(argName);
		params.add(argName);
	}

	if (isAddr.booleanValue()) {
		sb.append("AND upper(sp.address) matches upper(?) ");
		params.add(argAddr);
	}

	if (argRenterSearchType.equals(RENTER_SPECIFY)) {
		if(argRenter != null) {
			sb.append("AND p.renter = ? ");
			params.add(argRenter);
		} else {
			sb.append("AND p.renter IS NULL ");
		}
	} else if (argRenterSearchType.equals(RENTER_NOTNULL)) {
		sb.append("AND p.renter IS NOT NULL ");
	}

	if (isResponsableWorker.booleanValue()) {
		sb.append("AND exists (select w.worker from workresponsibility w where w.storageplace = sp.storageplace AND w.worker = ?) ");
		params.add(argResponsableWorker);
	}

	if (!argInAction.equals(INACTION_ALL)) {
		sb.append("AND p.inaction = ? ");
		params.add(argInAction);
    }
    
    //append order by clause
    String orderBy = null;
	switch (order.intValue()) {
	case 1 :
		sb.append("ORDER BY p.storageplace ASC ");
		break;
	case 2 :
		sb.append("ORDER BY p.storageplace DESC ");
		break;
	case 3 :
		sb.append("ORDER BY posname ASC ");
		break;
	case 4 :
		sb.append("ORDER BY posname DESC ");
		break;
	case 5 :
		sb.append("ORDER BY p.gsmid ASC ");
		break;
	case 6 :
		sb.append("ORDER BY p.gsmid DESC ");
		break;
	case 7 :
		sb.append("ORDER BY p.dampsid ASC ");
		break;
	case 8 :
		sb.append("ORDER BY p.dampsid DESC ");
		break;
	}
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	//System.out.println("POSSQL: " + sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet findPositionsByGSMid(Integer argGsmid)
{
	StringBuffer sb = new StringBuffer();
	/*

	sb.append("SELECT 'K' || cl.number number ");
	sb.append("FROM equipment equ, storageplaces sp, controllers cl ");
	sb.append("WHERE sp.storageplace = equ.equipment AND cl.equipment = equ.equipment AND equ.position = ? AND sp.type = 'O' ");
	sb.append("ORDER BY number ");
	*/
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), new Object[] { argGsmid });
	return res;
}
/**
 * Выбор позиций
 * Creation date: (24.03.2004)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public CDBCResultSet findPositionsLookup(
	java.lang.Boolean isNetZone,
	java.lang.Integer[] argNetZones,
    java.lang.Boolean isGsmId,
    java.lang.String argGsmId,
    java.lang.Boolean isDampsId,
    java.lang.String argDampsId,
    java.lang.Boolean isName,
    java.lang.String argName,
    java.lang.Boolean isBeenetid,
    java.lang.String argBeenetid,
    java.lang.Boolean isAddr,
    java.lang.String argAddr,
    java.lang.String argRenterSearchType,
    java.lang.Integer argRenter,
    Boolean isResponsableWorker,
    Integer argResponsableWorker,
    String argInAction,
    String argPosstate,
    Boolean isRegions,
    Integer[] argRegions,
    Boolean isSupregs,
    Integer[] argSupregs,
    Boolean isAdmin,
    String login,
    Boolean isTranspAll,
    Boolean isTranspRRL,
    Boolean isTranspVOT,
    Boolean isTranspID,
    java.lang.String argTranspId,
    Boolean isController, String argControllerNumber,
    Boolean isWLAN, String argWLANNumber,
    Boolean isRepeater, String argRepNumber,
    java.lang.Integer order
) {
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(POSITION_ADMIN_REQUEST_LOOKUP);
	} else {
		sb.append(POSITION_USER_REQUEST_LOOKUP);
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}

	if (isTranspAll.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment) ");
    }
    
    if (isTranspRRL.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
    }
    
    if (isTranspVOT.booleanValue()) {
        sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
    }
    
    if (isTranspID.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND (upper(sp1.name) matches upper(?) OR upper(ce1.osinvname) matches upper(?))) ");
		params.add(argTranspId);
		params.add(argTranspId);
	}

    if (isController != null && isController.booleanValue()) {
	    sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, controllers c1 WHERE c1.equipment = e1.equipment  AND ''||c1.number matches upper(?)) ");
	    params.add(argControllerNumber);
    }

    if (isWLAN != null && isWLAN.booleanValue()) {
	    sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, wlan w1 WHERE w1.equipment = e1.equipment  AND ''||w1.number matches upper(?)) ");
	    params.add(argWLANNumber);
    }

    if (isRepeater != null && isRepeater.booleanValue()) {
	    sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, repiters r1 WHERE r1.equipment = e1.equipment AND ''||r1.number matches ?) ");
	    params.add(argRepNumber);
    }

	if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
		appendIN(sb, "AND r.supregid ", argSupregs);
	}

	if (isRegions.booleanValue()) {
		appendIN(sb, "AND p.regionid ", argRegions);
	}

	if (argPosstate != null && !"*".equals(argPosstate)) {
		appendIN(sb, "AND p.posstate ", getPosstateList(argPosstate));
	}

	if (isNetZone.booleanValue()) {
		appendIN(sb, "AND p.netzone ", argNetZones);
	}

	if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
		// Special case - find positions without base stations
		sb.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
		if (isGsmId.booleanValue()) {
			if ((argGsmId == null) || ("".equals(argGsmId))) {
				sb.append("AND p.gsmid IS NOT NULL ");
			} else {
				if(argGsmId != null) {
					sb.append("AND ( ");					sb.append("  (p.gsmid = ?) ");					sb.append(" OR ");
					sb.append("  (p.storagePlace in "); 
					sb.append("     (select e.position from basestations b, equipment e ");
					sb.append("       where e.equipment = b.equipment ");
					sb.append("       and b.number = ? ");
					sb.append("       and b.type in ('S', 'C', 'G'))) ");					sb.append(" OR  ");
					sb.append("  (p.storagePlace in "); 
					sb.append("     (select e.position from repiters r, equipment e ");
					sb.append("       where e.equipment = r.equipment ");
					sb.append("       and r.number = ?)) ");
					sb.append(" ) "); 
					params.add(argGsmId);
					params.add(argGsmId);
					params.add(argGsmId);
				} else {
					sb.append("AND p.gsmid IS NULL ");
				}
			}
		}
		if (isDampsId.booleanValue()) {
			if ((argDampsId == null) || ("".equals(argDampsId))) {
				sb.append("AND p.dampsid IS NOT NULL ");
			} else {
				if(argDampsId != null) {
					sb.append("AND ( ");
					sb.append("  (p.dampsid = ?) ");
					sb.append(" OR ");
					sb.append("  (p.storagePlace in "); 
					sb.append("     (select e.position from basestations b, equipment e ");
					sb.append("       where e.equipment = b.equipment ");
					sb.append("       and b.number = ? ");
					sb.append("       and b.type in ('D'))) ");
					sb.append(" ) ");
					params.add(argDampsId);
					params.add(argDampsId);
				} else {
					sb.append("AND p.dampsid IS NULL ");
				}
			}
		}
	}

	if (isName.booleanValue()) {
		sb.append("AND (upper(sp.name) matches upper(?) or upper(p.dampsname) matches upper(?)) ");
		params.add(argName);
		params.add(argName);
	}

	if (isBeenetid != null && isBeenetid.booleanValue()) {
		if(argBeenetid != null) {
			sb.append("AND p.storageplace IN (SELECT position FROM beenetobjects WHERE LOWER(beenetid) MATCHES ?) ");
			params.add(argBeenetid.toLowerCase());
		} else {
			sb.append("AND p.storageplace IN (SELECT position FROM beenetobjects WHERE beenetid IS NULL) ");
		}
	}

	if (isAddr.booleanValue()) {
		sb.append("AND upper(sp.address) matches upper(?) ");
		params.add(argAddr);
	}

	if (argRenterSearchType.equals(RENTER_SPECIFY)) {
		if(argRenter != null) {
			sb.append("AND p.renter = ? ");
			params.add(argRenter);
		} else {
			sb.append("AND p.renter IS NULL ");
		}
	} else if (argRenterSearchType.equals(RENTER_NOTNULL)) {
		sb.append("AND p.renter IS NOT NULL ");
	}

	if (isResponsableWorker.booleanValue()) {
		sb.append("AND exists (select w.worker from workresponsibility w where w.storageplace = sp.storageplace AND w.worker = ?) ");
		params.add(argResponsableWorker);
	}

	if (!argInAction.equals(INACTION_ALL)) {
		sb.append("AND p.inaction = ? ");
		params.add(argInAction);
    }
    
    //append order by clause
    String orderBy = null;
	switch (order.intValue()) {
	case 1 :
		sb.append("ORDER BY p.storageplace ASC ");
		break;
	case 2 :
		sb.append("ORDER BY p.storageplace DESC ");
		break;
	case 3 :
		sb.append("ORDER BY posname ASC ");
		break;
	case 4 :
		sb.append("ORDER BY posname DESC ");
		break;
	case 5 :
		sb.append("ORDER BY p.gsmid ASC ");
		break;
	case 6 :
		sb.append("ORDER BY p.gsmid DESC ");
		break;
	case 7 :
		sb.append("ORDER BY p.dampsid ASC ");
		break;
	case 8 :
		sb.append("ORDER BY p.dampsid DESC ");
		break;
	}
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор позиций
 * Creation date: (24.03.2004)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public CDBCResultSet findPositionsLookup(
	java.lang.Boolean isNetZone,
	java.lang.Integer[] argNetZones,
    java.lang.Boolean isGsmId,
    java.lang.String argGsmId,
    java.lang.Boolean isDampsId,
    java.lang.String argDampsId,
    java.lang.Boolean isName,
    java.lang.String argName,
    java.lang.Boolean isBeenetid,
    java.lang.String argBeenetid,
    java.lang.Boolean isAddr,
    java.lang.String argAddr,
    java.lang.String argRenterSearchType,
    java.lang.Integer argRenter,
    Boolean isResponsableWorker,
    Integer argResponsableWorker,
    String argInAction,
    String argPosstate,
    Boolean isRegions,
    Integer[] argRegions,
    Boolean isSupregs,
    Integer[] argSupregs,
    Boolean isAdmin,
    String login,
    Boolean isTranspAll,
    Boolean isTranspRRL,
    Boolean isTranspVOT,
    Boolean isTranspID,
    java.lang.String argTranspId,
    java.lang.Integer order
) {
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(POSITION_ADMIN_REQUEST_LOOKUP);
	} else {
		sb.append(POSITION_USER_REQUEST_LOOKUP);
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}

	if (isTranspAll.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment) ");
    }
    
    if (isTranspRRL.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
    }
    
    if (isTranspVOT.booleanValue()) {
        sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
    }
    
    if (isTranspID.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND (upper(sp1.name) matches upper(?) OR upper(ce1.osinvname) matches upper(?))) ");
		params.add(argTranspId);
		params.add(argTranspId);
	}

	if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
		appendIN(sb, "AND r.supregid ", argSupregs);
	}

	if (isRegions.booleanValue()) {
		appendIN(sb, "AND p.regionid ", argRegions);
	}

	if (argPosstate != null && !"*".equals(argPosstate)) {
		appendIN(sb, "AND p.posstate ", getPosstateList(argPosstate));
	}

	if (isNetZone.booleanValue()) {
		appendIN(sb, "AND p.netzone ", argNetZones);
	}

	if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
		// Special case - find positions without base stations
		sb.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
		if (isGsmId.booleanValue()) {
			if ((argGsmId == null) || ("".equals(argGsmId))) {
				sb.append("AND p.gsmid IS NOT NULL ");
			} else {
				if(argGsmId != null) {
					sb.append("AND p.gsmid = ? ");
					params.add(argGsmId);
				} else {
					sb.append("AND p.gsmid IS NULL ");
				}
			}
		}
		if (isDampsId.booleanValue()) {
			if ((argDampsId == null) || ("".equals(argDampsId))) {
				sb.append("AND p.dampsid IS NOT NULL ");
			} else {
				if(argDampsId != null) {
					sb.append("AND p.dampsid = ? ");
					params.add(argDampsId);
				} else {
					sb.append("AND p.dampsid IS NULL ");
				}
			}
		}
	}

	if (isName.booleanValue()) {
		sb.append("AND (upper(sp.name) matches upper(?) or upper(p.dampsname) matches upper(?)) ");
		params.add(argName);
		params.add(argName);
	}

	if (isBeenetid != null && isBeenetid.booleanValue()) {
		if(argBeenetid != null) {
			sb.append("AND p.storageplace IN (SELECT e.position FROM beenet2equip b2e, equipment e WHERE b2e.equipment = e.equipment AND b2e.beenetid MATCHES ?) ");
			params.add(argBeenetid);
		} else {
			sb.append("AND p.storageplace IN (SELECT e.position FROM beenet2equip b2e, equipment e WHERE b2e.equipment = e.equipment AND b2e.beenetid IS NULL) ");
		}
	}

	if (isAddr.booleanValue()) {
		sb.append("AND upper(sp.address) matches upper(?) ");
		params.add(argAddr);
	}

	if (argRenterSearchType.equals(RENTER_SPECIFY)) {
		if(argRenter != null) {
			sb.append("AND p.renter = ? ");
			params.add(argRenter);
		} else {
			sb.append("AND p.renter IS NULL ");
		}
	} else if (argRenterSearchType.equals(RENTER_NOTNULL)) {
		sb.append("AND p.renter IS NOT NULL ");
	}

	if (isResponsableWorker.booleanValue()) {
		sb.append("AND exists (select w.worker from workresponsibility w where w.storageplace = sp.storageplace AND w.worker = ?) ");
		params.add(argResponsableWorker);
	}

	if (!argInAction.equals(INACTION_ALL)) {
		sb.append("AND p.inaction = ? ");
		params.add(argInAction);
    }
    
    //append order by clause
    String orderBy = null;
	switch (order.intValue()) {
	case 1 :
		sb.append("ORDER BY p.storageplace ASC ");
		break;
	case 2 :
		sb.append("ORDER BY p.storageplace DESC ");
		break;
	case 3 :
		sb.append("ORDER BY posname ASC ");
		break;
	case 4 :
		sb.append("ORDER BY posname DESC ");
		break;
	case 5 :
		sb.append("ORDER BY p.gsmid ASC ");
		break;
	case 6 :
		sb.append("ORDER BY p.gsmid DESC ");
		break;
	case 7 :
		sb.append("ORDER BY p.dampsid ASC ");
		break;
	case 8 :
		sb.append("ORDER BY p.dampsid DESC ");
		break;
	}
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * Выбор позиций
 * Creation date: (24.03.2004)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public CDBCResultSet findPositionsLookup(
	java.lang.Boolean isNetZone,
	java.lang.Integer[] argNetZones,
    java.lang.Boolean isGsmId,
    java.lang.String argGsmId,
    java.lang.Boolean isDampsId,
    java.lang.String argDampsId,
    java.lang.Boolean isName,
    java.lang.String argName,
    java.lang.Boolean isAddr,
    java.lang.String argAddr,
    java.lang.String argRenterSearchType,
    java.lang.Integer argRenter,
    Boolean isResponsableWorker,
    Integer argResponsableWorker,
    String argInAction,
    String argPosstate,
    Boolean isRegions,
    Integer[] argRegions,
    Boolean isSupregs,
    Integer[] argSupregs,
    Boolean isAdmin,
    String login,
    Boolean isTranspAll,
    Boolean isTranspRRL,
    Boolean isTranspVOT,
    Boolean isTranspID,
    java.lang.String argTranspId,
    java.lang.Integer order
) {
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(POSITION_ADMIN_REQUEST_LOOKUP);
	} else {
		sb.append(POSITION_USER_REQUEST_LOOKUP);
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}

	if (isTranspAll.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment) ");
    }
    
    if (isTranspRRL.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
    }
    
    if (isTranspVOT.booleanValue()) {
        sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
    }
    
    if (isTranspID.booleanValue()) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND (upper(sp1.name) matches upper(?) OR upper(ce1.osinvname) matches upper(?))) ");
		params.add(argTranspId);
		params.add(argTranspId);
	}

	if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
		appendIN(sb, "AND r.supregid ", argSupregs);
	}

	if (isRegions.booleanValue()) {
		appendIN(sb, "AND p.regionid ", argRegions);
	}

	if (argPosstate != null && !"*".equals(argPosstate)) {
		appendIN(sb, "AND p.posstate ", getPosstateList(argPosstate));
	}

	if (isNetZone.booleanValue()) {
		appendIN(sb, "AND p.netzone ", argNetZones);
	}

	if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
		// Special case - find positions without base stations
		sb.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
		if (isGsmId.booleanValue()) {
			if ((argGsmId == null) || ("".equals(argGsmId))) {
				sb.append("AND p.gsmid IS NOT NULL ");
			} else {
				if(argGsmId != null) {
					sb.append("AND p.gsmid = ? ");
					params.add(argGsmId);
				} else {
					sb.append("AND p.gsmid IS NULL ");
				}
			}
		}
		if (isDampsId.booleanValue()) {
			if ((argDampsId == null) || ("".equals(argDampsId))) {
				sb.append("AND p.dampsid IS NOT NULL ");
			} else {
				if(argDampsId != null) {
					sb.append("AND p.dampsid = ? ");
					params.add(argDampsId);
				} else {
					sb.append("AND p.dampsid IS NULL ");
				}
			}
		}
	}

	if (isName.booleanValue()) {
		sb.append("AND (upper(sp.name) matches upper(?) or upper(p.dampsname) matches upper(?)) ");
		params.add(argName);
		params.add(argName);
	}

	if (isAddr.booleanValue()) {
		sb.append("AND upper(sp.address) matches upper(?) ");
		params.add(argAddr);
	}

	if (argRenterSearchType.equals(RENTER_SPECIFY)) {
		if(argRenter != null) {
			sb.append("AND p.renter = ? ");
			params.add(argRenter);
		} else {
			sb.append("AND p.renter IS NULL ");
		}
	} else if (argRenterSearchType.equals(RENTER_NOTNULL)) {
		sb.append("AND p.renter IS NOT NULL ");
	}

	if (isResponsableWorker.booleanValue()) {
		sb.append("AND exists (select w.worker from workresponsibility w where w.storageplace = sp.storageplace AND w.worker = ?) ");
		params.add(argResponsableWorker);
	}

	if (!argInAction.equals(INACTION_ALL)) {
		sb.append("AND p.inaction = ? ");
		params.add(argInAction);
    }
    
    //append order by clause
    String orderBy = null;
	switch (order.intValue()) {
	case 1 :
		sb.append("ORDER BY p.storageplace ASC ");
		break;
	case 2 :
		sb.append("ORDER BY p.storageplace DESC ");
		break;
	case 3 :
		sb.append("ORDER BY posname ASC ");
		break;
	case 4 :
		sb.append("ORDER BY posname DESC ");
		break;
	case 5 :
		sb.append("ORDER BY p.gsmid ASC ");
		break;
	case 6 :
		sb.append("ORDER BY p.gsmid DESC ");
		break;
	case 7 :
		sb.append("ORDER BY p.dampsid ASC ");
		break;
	case 8 :
		sb.append("ORDER BY p.dampsid DESC ");
		break;
	}
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findPositionSwitchNumbers(int argPosition)
{
	StringBuffer sb = new StringBuffer();

	sb.append("SELECT 'K' || sw.number number ");
	sb.append("FROM equipment equ, storageplaces sp, switches sw ");
	sb.append("WHERE sp.storageplace = equ.equipment AND sw.equipment = equ.equipment AND equ.position = ? AND sp.type = 'W' ");
	sb.append("ORDER BY number ");
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), new Object[] { new Integer(argPosition) });
	return res;
}
public CDBCResultSet findPositionWLANNumbers(int argPosition)
{
	StringBuffer sb = new StringBuffer();

	sb.append("SELECT wl.number number ");
	sb.append("FROM equipment equ, storageplaces sp, wlan wl ");
	sb.append("WHERE sp.storageplace = equ.equipment AND wl.equipment = equ.equipment AND equ.position = ? AND sp.type = 'L' ");
	sb.append("ORDER BY number ");
/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), new Object[] { new Integer(argPosition) });
	return res;
}
/**
 * Выбор позиций для связей с документами
 * Creation date: (24.03.2004)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public CDBCResultSet findPossibleSiteDocPositions(
	Integer sitedoc,
	Boolean isNetZone, Integer[] argNetZones,
    Boolean isRegions, Integer[] argRegions,
    Boolean isSupregs, Integer[] argSupregs,
    Boolean isAdmin, String login,
    String searchBy,
    String searchValue,
    String posstate,
    java.lang.Integer order
) {
	TimeCounter tc = new TimeCounter("CDBC Position findPossibleSiteDocPositions");
	tc.start();
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	com.hps.july.web.util.StringAndIntegerProperty iprop = new com.hps.july.web.util.StringAndIntegerProperty();
	iprop.setString(searchValue);

	if (isAdmin != null && isAdmin.booleanValue()) {
		sb.append(POSITION_ADMIN_REQUEST_LOOKUP);
	} else {
		sb.append(POSITION_USER_REQUEST_LOOKUP);
		if(login != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(login);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
	}

	if(sitedoc != null) {
		sb.append("AND NOT EXISTS ");
		sb.append("(SELECT link.storageplace FROM sitedocs2splace link WHERE p.storageplace = link.storageplace AND link.sitedoc = ?) ");
		params.add(sitedoc);
	}
	
	if(SEARCHBY_TRALL.equals(searchBy)) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment) ");
    } else
    if(SEARCHBY_TRRRL.equals(searchBy)) {
		sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
    } else 
    if(SEARCHBY_TRVOT.equals(searchBy)) {
        sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
    } else 
    if(SEARCHBY_TRID.equals(searchBy)) {
		if(iprop.getInteger() != null) {
			sb.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND upper(sp1.name) matches upper(?)) ");
			params.add(iprop.getInteger());
		}
	} else
	if(SEARCHBY_GSMID.equals(searchBy)) {
		if(iprop.getInteger() != null) {
			sb.append("AND p.gsmid = ? ");
			params.add(iprop.getInteger());
		} else {
			sb.append("AND 1 = 0 ");
		}
	} else
	if(SEARCHBY_BSGSM.equals(searchBy)) {
		sb.append("AND p.gsmid IS NOT NULL ");
	} else
	if(SEARCHBY_DAMPSID.equals(searchBy)) {
		if(iprop.getInteger() != null) {
			sb.append("AND p.dampsid = ? ");
			params.add(iprop.getInteger());
		} else {
			sb.append("AND 1 = 0 ");
		}
	} else
	if(SEARCHBY_BSDAMPS.equals(searchBy)) {
		sb.append("AND p.dampsid IS NOT NULL ");
	} else
	if(SEARCHBY_NOBS.equals(searchBy)) {
		sb.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
	} else
	if(SEARCHBY_NAME.equals(searchBy)) {
		sb.append("AND (upper(sp.name) matches upper(?) or upper(p.dampsname) matches upper(?)) ");
		if(searchValue != null) {
			params.add(searchValue);
			params.add(searchValue);
		} else {
			params.add("");
			params.add("");
		}
	} else
	if(SEARCHBY_ADDR.equals(searchBy)) {
		sb.append("AND upper(sp.address) matches upper(?) ");
		params.add(searchValue);
	}
    
	if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
		appendIN(sb, "AND r.supregid ", argSupregs);
	}
	if (isRegions.booleanValue()) {
		appendIN(sb, "AND p.regionid ", argRegions);
	}
	if (isNetZone.booleanValue()) {
		appendIN(sb, "AND p.netzone ", argNetZones);
	}
	if (posstate != null && !"*".equals(posstate)) {
		appendIN(sb, "AND p.posstate ", getPosstateList(posstate));
	}

    //append order by clause
    String orderBy = null;
	switch (order.intValue()) {
	case 1 :
		sb.append("ORDER BY p.storageplace ASC ");
		break;
	case 2 :
		sb.append("ORDER BY p.storageplace DESC ");
		break;
	case 3 :
		sb.append("ORDER BY posname ASC ");
		break;
	case 4 :
		sb.append("ORDER BY posname DESC ");
		break;
	case 5 :
		sb.append("ORDER BY p.gsmid ASC ");
		break;
	case 6 :
		sb.append("ORDER BY p.gsmid DESC ");
		break;
	case 7 :
		sb.append("ORDER BY p.dampsid ASC ");
		break;
	case 8 :
		sb.append("ORDER BY p.dampsid DESC ");
		break;
	}

/*
	System.out.println("\n\n"+sb.toString()+"\n\n");
	Iterator it = params.iterator();
	while(it.hasNext()) {
		System.out.println("P:"+it.next());
	}
*/

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	tc.finish("[find]");
	return res;
}
/**
 * 
 * @return java.lang.String[]
 * @param agrPosstate java.lang.String
 */
public static char[] getPosstateList(String argPosstate) {
	if(argPosstate == null) {
		return null;
	}
	char[] res = new char[argPosstate.length()];
	for(int i = 0; i < argPosstate.length(); i++) {
		res[i] = Character.toUpperCase(argPosstate.charAt(i));
	}
	return res;
}
}
