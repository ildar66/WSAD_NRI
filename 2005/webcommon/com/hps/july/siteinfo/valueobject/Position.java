package com.hps.july.siteinfo.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import org.apache.struts.util.*;

/**
 * Класс для обработки списков позиций
 * @author: Alexander Shrago
 */
/** @deprecated 
 * В настоящее время используется com.hps.july.cdbc.objects.CDBCPositionObject
 */
public class Position extends JdbcObject {
	
private com.hps.july.persistence.PositionAccessBean bean;
	
    private int storageplace;
    private String dampsname;
    private Integer netzone;
    private Integer dampsid;
    private Integer gsmid;
    private Boolean inAction;
    private Integer dcsid;
    private Integer regionid;
//    private String planstate;
	private String posstate;
    private String name; //storageplaces
    private String address; //storageplaces
    private String zonecode; //netzones
    private String zonename; //netzones
    private String regionname; //Regions
    private String supregname; //Supregname
    private java.sql.Date datebeginbuild;
    private java.math.BigDecimal latitude;
    private java.math.BigDecimal longitude;
    private String positionid;
    private String details;
    private String renter_name; //organization
    private String rentervolume;
    private Integer renter_org; //organization
    private java.sql.Date accesslistexp;

    private String storageplaceName; //storageplaces
private boolean viewFact;
    private boolean viewPlan;
    private boolean editFact;
    private boolean editPlan;

    private static MessageResources messageResources = MessageResources.getMessageResources("com.hps.july.siteinfo.ApplicationResources");

    public final static String RENTER_NotNull = "NotNull";
    public final static String RENTER_Any = "any";
    public final static String RENTER_Specify = "specify";
//    public final static String PLANSTATE_All = "all";
    public final static String PLANSTATE_CHECK_Fact = "2";
//    public final static String PLANSTATE_CHECK_Plan = "1";
//    public final static String PLANSTATE_CHECK_Archive = "0";
//    public final static String PLANSTATE_Archive = "0";
    public final static String INACTION_CHECK_Y = "Y";
    public final static String INACTION_CHECK_N = "N";
    public final static String INACTION_All = "all";
    //public final static String BS_SearchType_

    public static final String QUERY_SELECT_Admin =
        "SELECT  p.date_beginbuild datebeginbuild,"
            + " p.storageplace, s.name storageplaceName, p.dampsname, p.netzone, p.dampsid, p.gsmid,"
            + " p.inaction inAction, p.dcsid, p.regionid, p.posstate, p.latitude,p.longitude,s.name,"
            + " s.address, n.zonecode,n.name zonename, r.regname regname,sr.supregname supregname,"
            + "o.organization renter_org, o.name renter_name,p.details details,"
            + "p.rentvolume rentervolume,p.accesslistexp accesslistexp,"
            + " 'Y' viewplan,"
            + " 'Y' viewfact,"
            + " 'Y' editplan,"
            + " 'Y' editfact"
            + " FROM positions p, storageplaces s, netzones n, Regions r,SuperRegions sr, OUTER organizations o"
            + " WHERE sr.supregid=r.supregid"
            + " AND s.storageplace = p.storageplace"
            + " AND n.netzone = p.netzone"
            + " AND r.regionid = p.regionid"
            + " AND o.organization=p.renter"
            + " AND r.regionid = p.regionid";

    public static final String QUERY_SELECT =
        "SELECT UNIQUE p.date_beginbuild datebeginbuild,"
            + " p.storageplace, s.name storageplaceName, p.dampsname, p.netzone, p.dampsid, p.gsmid,"
            + " p.inaction inAction, p.dcsid, p.regionid, p.posstate, p.latitude,p.longitude,s.name,"
            + " s.address, n.zonecode,n.name zonename, r.regname regname,sr.supregname supregname,"
            + " org.organization renter_org, org.name renter_name,p.details details,"
            + " p.rentvolume rentervolume,p.accesslistexp accesslistexp,"
+" CASE"
+" (CASE ra.viewplan WHEN NULL THEN 'N' ELSE ra.viewplan END)"
+" ||(CASE sra.viewplan WHEN NULL THEN 'N' ELSE sra.viewplan END)"
+" WHEN 'NN' THEN 'N' ELSE 'Y' END viewplan,"

+" CASE"
+" (CASE ra.viewfact WHEN NULL THEN 'N' ELSE ra.viewfact END)"
+" ||(CASE sra.viewfact WHEN NULL THEN 'N' ELSE sra.viewfact END)"
+" WHEN 'NN' THEN 'N' ELSE 'Y' END viewfact,"

+" CASE"
+" (CASE ra.editplan WHEN NULL THEN 'N' ELSE ra.editplan END)"
+" ||(CASE sra.editplan WHEN NULL THEN 'N' ELSE sra.editplan END)"
+" WHEN 'NN' THEN 'N' ELSE 'Y' END editplan,"

+" CASE"
+" (CASE ra.editfact WHEN NULL THEN 'N' ELSE ra.editfact END)"
+" ||(CASE sra.editfact WHEN NULL THEN 'N' ELSE sra.editfact END)"
+" WHEN 'NN' THEN 'N' ELSE 'Y' END editfact"
            + " FROM positions p, storageplaces s, netzones n, Regions r,SuperRegions sr, OUTER organizations org,"
            + " OUTER RegionsAccess sra,OUTER RegionsAccess ra, operators o"
            + " WHERE sr.supregid=r.supregid"
            + " AND s.storageplace = p.storageplace"
            + " AND n.netzone = p.netzone"
            + " AND r.regionid = p.regionid"
            + " AND org.organization=p.renter"
                        
+" AND (p.planstate='2' AND (ra.viewfact='Y' OR ra.editfact='Y'  OR sra.viewfact='Y' OR sra.editfact='Y'))"
+" AND sra.accesstype='S'"
+" AND ra.accesstype='R'"
+" AND sra.supregionid=sr.supregid"
+" AND ra.regionid=r.regionid"
+" AND ra.operatorid=o.operator"
+" AND sra.operatorid=o.operator"
+" AND p.planstate <> 0 ";
/**
 * PositionObject constructor comment.
 */
public Position() throws Exception {
	super();
}
/**
 * PositionObject constructor comment.
 */
public Position(com.hps.july.persistence.PositionAccessBean bean)
    throws Exception {

    super();
    this.bean=bean;
/*
    try {

        storageplace = bean.getStorageplace();
        name = bean.getName();
        positionid =
            (bean.getGsmid() == null ? "" : getGsmid().toString())
                + (bean.getDampsid() == null ? "" : getDampsid().toString());
        regionname = bean.getRegion().getRegname();
        supregname = bean.getRegion().getSuperregion().getSupregname();
        
        latitude = bean.getLatitude();
        longitude = bean.getLongitude();
        datebeginbuild =
            new java.text.SimpleDateFormat("dd.MM.yyyy").format(bean.getDatebeginbuild());

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);

    }
*/
}
/**
 * PositionObject constructor comment.
 */
public Position(java.sql.ResultSet rs) throws Exception {

    super();
    /*    
    for (int i = 1; i <=rs.getMetaData().getColumnCount() ; i++){
    	System.out.println(i+" "+rs.getMetaData().getColumnName(i)+" "+rs.getMetaData().getColumnTypeName(i));
    }
    */

    try {
        storageplaceName = getString(rs, "storageplaceName");
        storageplace = rs.getInt("storageplace");
        //System.out.println(i+" "+rs.getMetaData().getColumnName(i)+" "+rs.getMetaData().getColumnTypeName(i)+);
        dampsname = getString(rs, "dampsname");
        netzone = getInteger(rs, "netzone");
        dampsid =
            rs.getObject("dampsid") != null ? (Integer) rs.getObject("dampsid") : null;
        gsmid = rs.getObject("gsmid") != null ? (Integer) rs.getObject("gsmid") : null;
        inAction = getBoolean(rs, "inaction", "Y");
        dcsid = rs.getObject("dcsid") != null ? (Integer) rs.getObject("dcsid") : null;
        regionid = getInteger(rs, "regionid");
//        planstate = getString(rs, "planstate");
		posstate = getString(rs, "posstate");
        name = getString(rs, "name"); //storageplaces
        address = getString(rs, "address"); //storageplaces
        zonecode = getString(rs, "zonecode"); //netzones
        regionname = getString(rs, "regname"); //Regions
        datebeginbuild = getDate(rs, "datebeginbuild");
        latitude = getBigDecimal(rs, "latitude");
        longitude = getBigDecimal(rs, "longitude");
        zonename = getString(rs, "zonename"); //netzones
        supregname = getString(rs, "supregname");

        renter_org = getInteger(rs, "renter_org");
        renter_name = getString(rs, "renter_name");
        details = getString(rs, "details");
        accesslistexp = getDate(rs, "accesslistexp");
        rentervolume = getString(rs, "rentervolume");

        viewFact = getString(rs, "viewfact").equals("Y");
        viewPlan = getString(rs, "viewplan").equals("Y");
        editFact = getString(rs, "editfact").equals("Y");
        editPlan = getString(rs, "editplan").equals("Y");

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);

    }

    /*    
     SELECT  p.storageplace,
        p.dampsname,
        p.netzone,
        p.dampsid,
        p.gsmid,
        p.inAction,
        p.dcsid,
        p.regionid,
        p.planstate,
        s.name,
        s.address,
        n.zonecode,
        r.regname
    FROM positions p, storageplaces s, netzones n, Regions r
    WHERE s.storageplace=p.storageplace
       AND n.netzone=p.netzone
       AND r.regionid=p.regionid
    */
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 18:04:20)
 * @return java.lang.String
 */
public Enumeration findByQBE3(
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
    java.lang.Integer order)
    throws Exception {

    Query query = null;

    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, DataUtil.RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, DataUtil.RESULT_JdbcObjectEnum);
    }

    /*
    String alias = getAlias(sb.toString(), "POSITIONS");
    String spAlias = getAlias(sb.toString(), "STORAGEPLACES");
    */
    //calculate where clause

    if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
        query.append("AND sr.supregid IN", argSupregs);
    }
    if (isRegions.booleanValue()) {
        query.append("AND p.regionid IN", argRegions);
    }
    if(argPosstate != null && !"*".equals(argPosstate)) {
        query.append("AND p.posstate=?", com.hps.july.cdbc.objects.CDBCPositionObject.getPosstateList(argPosstate));
    }
    if (isNetZone.booleanValue()) {
        query.append("AND p.netzone IN", argNetZones);
    }
    if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
        // Special case - find positions without base stations
        query.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
        if (isGsmId.booleanValue())
            if ((argGsmId == null) || ("".equals(argGsmId)))
                query.append("AND p.gsmid IS NOT NULL ");
            else {
                query.append("AND p.gsmid = ? ", argGsmId);

            }
        if (isDampsId.booleanValue())
            if ((argDampsId == null) || ("".equals(argDampsId)))
                query.append("AND p.dampsid IS NOT NULL ");
            else {
                query.append("AND p.dampsid = ? ", argDampsId);

            }
    }

    if (isName.booleanValue()) {
        query.append(
            "AND (upper(s.name) matches upper(?) or upper(p.dampsname) matches upper(?))",
            argName,
            argName);

    }
    if (isAddr.booleanValue()) {
        query.append("AND upper(s.address) matches upper(?)", argAddr);

    }
    if (argRenterSearchType.equals(RENTER_Specify)) {
        query.append("AND renter = ?", argRenter);
    } else
        if (argRenterSearchType.equals(RENTER_NotNull)) {
            query.append("AND renter IS NOT NULL");
        }

    if (isResponsableWorker.booleanValue()) {
        query.append(
            "AND exists (select w.* from WorkResponsibility w where s.storageplace=w.storageplace AND w.worker = ? )",
            argResponsableWorker);

    }
    if (!argInAction.equals(INACTION_All)) {
        query.append("AND p.inaction = ?", argInAction);
    }
    
    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=?", login);
    }
    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "p.storageplace asc";
            break;
        case 2 :
            orderBy = "p.storageplace desc";
            break;
        case 3 :
            orderBy = "s.name asc";
            break;
        case 4 :
            orderBy = "s.name desc";
            break;
        case 5 :
            orderBy = "p.gsmid asc";
            break;
        case 6 :
            orderBy = "p.gsmid desc";
            break;
        case 7 :
            orderBy = "p.dampsid asc";
            break;
        case 8 :
            orderBy = "p.dampsid desc";
            break;
    }
    query.append(" order by " + orderBy);

    return (Enumeration) find(query);

}
/**
 * Метод поиска позиций.
 * Creation date: (16.02.2003 18:04:20)
 * @return java.lang.String
 */
public Enumeration findByQBE4(
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
    Boolean isTranspID, java.lang.String argTranspId,
    java.lang.Integer order)
    throws Exception {

    Query query = null;

    if (!isAdmin.booleanValue()) {
        query = new Query(QUERY_SELECT, DataUtil.RESULT_JdbcObjectEnum);
    } else {
        query = new Query(QUERY_SELECT_Admin, DataUtil.RESULT_JdbcObjectEnum);
    }

    /*
    String alias = getAlias(sb.toString(), "POSITIONS");
    String spAlias = getAlias(sb.toString(), "STORAGEPLACES");
    */
    //calculate where clause

	if (isTranspAll.booleanValue()) {
		query.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment)");
    }
    if (isTranspRRL.booleanValue()) {
        query.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='R')");
    }
    if (isTranspVOT.booleanValue()) {
        query.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 WHERE ce1.equipment = e1.equipment AND ce1.type='O')");
    }
    if (isTranspID.booleanValue()) {
        query.append("AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND upper(sp1.name) matches upper(?))", argTranspId);
	}
    if (isSupregs.booleanValue() && !isRegions.booleanValue()) {
        query.append("AND sr.supregid IN", argSupregs);
    }
    if (isRegions.booleanValue()) {
        query.append("AND p.regionid IN", argRegions);
    }
    if(argPosstate != null && !"*".equals(argPosstate)) {
        query.append("AND p.posstate=?", com.hps.july.cdbc.objects.CDBCPositionObject.getPosstateList(argPosstate));
    }
    if (isNetZone.booleanValue()) {
        query.append("AND p.netzone IN", argNetZones);
    }
    if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
        // Special case - find positions without base stations
        query.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
    } else {
        if (isGsmId.booleanValue())
            if ((argGsmId == null) || ("".equals(argGsmId)))
                query.append("AND p.gsmid IS NOT NULL ");
            else {
                query.append("AND p.gsmid = ? ", argGsmId);

            }
        if (isDampsId.booleanValue())
            if ((argDampsId == null) || ("".equals(argDampsId)))
                query.append("AND p.dampsid IS NOT NULL ");
            else {
                query.append("AND p.dampsid = ? ", argDampsId);

            }
    }

	if (isName.booleanValue()) {
		query.append("AND (upper(s.name) matches upper(?) or upper(p.dampsname) matches upper(?))", argName, argName);
	}
	if (isAddr.booleanValue()) {
		query.append("AND upper(s.address) matches upper(?)", argAddr);
	}
	if (argRenterSearchType.equals(RENTER_Specify)) {
		query.append("AND renter = ?", argRenter);
    } else
        if (argRenterSearchType.equals(RENTER_NotNull)) {
            query.append("AND renter IS NOT NULL");
        }

    if (isResponsableWorker.booleanValue()) {
        query.append(
            "AND exists (select w.* from WorkResponsibility w where s.storageplace=w.storageplace AND w.worker = ? )",
            argResponsableWorker);

    }
    if (!argInAction.equals(INACTION_All)) {
        query.append("AND p.inaction = ?", argInAction);
    }
    
    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=?", login);
    }
    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "p.storageplace asc";
            break;
        case 2 :
            orderBy = "p.storageplace desc";
            break;
        case 3 :
            orderBy = "s.name asc";
            break;
        case 4 :
            orderBy = "s.name desc";
            break;
        case 5 :
            orderBy = "p.gsmid asc";
            break;
        case 6 :
            orderBy = "p.gsmid desc";
            break;
        case 7 :
            orderBy = "p.dampsid asc";
            break;
        case 8 :
            orderBy = "p.dampsid desc";
            break;
    }
    query.append(" order by " + orderBy);

    return (Enumeration) find(query);

}
public Enumeration findPossibleSiteDocLinks(
    Integer sitedoc,
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
    Boolean isRegions,
    Integer[] argRegions,
    Boolean isSupregs,
    Integer[] argSupregs,
/*Boolean isAdmin,*/
/*String login,*/ java.lang.Integer order) throws Exception {
    Query query;

    try {
        query =
            new Query("SELECT  p.date_beginbuild datebeginbuild,"
                    + " p.storageplace, s.name storageplaceName, p.dampsname, p.netzone, p.dampsid, p.gsmid,"
                    + " p.inaction inAction, p.dcsid, p.regionid, p.posstate, p.latitude,p.longitude,s.name,"
                    + " s.address, n.zonecode,n.name zonename, r.regname regname,sr.supregname supregname,"
                    + "o.organization renter_org, o.name renter_name,p.details details,"
                    + "p.rentvolume rentervolume,p.accesslistexp accesslistexp"
                    + " FROM positions p, storageplaces s, netzones n, Regions r,SuperRegions sr, OUTER organizations o"
                    + " WHERE sr.supregid=r.supregid"
                    + " AND s.storageplace = p.storageplace"
                    + " AND n.netzone = p.netzone"
                    + " AND r.regionid = p.regionid"
                    + " AND o.organization=p.renter"
                    + " AND r.regionid = p.regionid");
//                    + " AND p.planstate = "
//                    + PLANSTATE_CHECK_Fact);

        /*
        String alias = getAlias(sb.toString(), "POSITIONS");
        String spAlias = getAlias(sb.toString(), "STORAGEPLACES");
        */
        //calculate where clause

        if (isSupregs.booleanValue() && !isRegions.booleanValue()) {

            query.append("AND sr.supregid IN", argSupregs);

        }
        if (isRegions.booleanValue()) {

            query.append("AND p.regionid IN", argRegions);

        }
        /*
        if (!argPlanState.equals(PLANSTATE_All)) {
            query.append("AND p.planstate=?", argPlanState);
        
        }
        */
        if (isNetZone.booleanValue()) {
            query.append("AND p.netzone IN", argNetZones);

        }
        if (isGsmId.booleanValue() && isDampsId.booleanValue()) {
            // Special case - find positions without base stations
            query.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
        } else {
            if (isGsmId.booleanValue())
                if ((argGsmId == null) || ("".equals(argGsmId)))
                    query.append("AND p.gsmid IS NOT NULL ");
                else {
                    query.append("AND p.gsmid = ? ", argGsmId);

                }
            if (isDampsId.booleanValue())
                if ((argDampsId == null) || ("".equals(argDampsId)))
                    query.append("AND p.dampsid IS NOT NULL ");
                else {
                    query.append("AND p.dampsid = ? ", argDampsId);

                }
        }

        if (isName.booleanValue()) {
            query.append(
                "AND (upper(s.name) matches upper(?) or upper(p.dampsname) matches upper(?))",
                argName,
                argName);

        }
        if (isAddr.booleanValue()) {
            query.append("AND upper(s.address) matches upper(?)", argAddr);

        }
        query.append("AND NOT EXISTS");
        query.append(
            "(SELECT * FROM sitedocs2splace link WHERE p.storageplace=link.storageplace AND link.sitedoc=?)",
            sitedoc);
        /*
        if (argRenterSearchType.equals(RENTER_Specify)) {
            query.append("AND renter = ?", argRenter);
        } else if (argRenterSearchType.equals(RENTER_NotNull)) {
            query.append("AND renter IS NOT NULL");
        }
        
        if (isResponsableWorker.booleanValue()) {
            query.append(
                "AND exists (select w.* from WorkResponsibility w where s.storageplace=w.storageplace AND w.worker = ? )",
                argResponsableWorker);
        
        }
        if (!argInAction.equals(INACTION_All)) {
            query.append("AND p.inaction = ?", argInAction);
        }
        
        if (!isAdmin.booleanValue()) {
            query.append("AND o.loiginid=?", login);
        }
        */
        //append order by clause
        String orderBy = null;
        switch (order.intValue()) {
            case 1 :
                orderBy = "p.storageplace asc";
                break;
            case 2 :
                orderBy = "p.storageplace desc";
                break;
            case 3 :
                orderBy = "s.name asc";
                break;
            case 4 :
                orderBy = "s.name desc";
                break;
            case 5 :
                orderBy = "p.gsmid asc";
                break;
            case 6 :
                orderBy = "p.gsmid desc";
                break;
            case 7 :
                orderBy = "p.dampsid asc";
                break;
            case 8 :
                orderBy = "p.dampsid desc";
                break;
        }
        query.append(" order by " + orderBy);
    } catch (Exception e) {
        DebugSupport.printlnTest("!!Exception in finder");
        DebugSupport.printlnError(e);
        throw e;
    }
    return  findEnumeration(query);

}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @return java.sql.Date
 */
public java.sql.Date getAccesslistexp() {
	return accesslistexp;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2003 22:04:41)
 * @return com.hps.july.persistence.PositionAccessBean
 */
public com.hps.july.persistence.PositionAccessBean getBean() {
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getDampsid() throws Exception{
	return bean==null?dampsid:bean.getDampsid();
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.String
 */
public java.lang.String getDampsname() {
	return dampsname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @return java.lang.String
 */
public java.sql.Date getDatebeginbuild() {
	return datebeginbuild;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @return java.lang.String
 */
public String getDatebeginbuildStr() {
	
	com.hps.july.web.util.StringAndSqlDateProperty dp=new com.hps.july.web.util.StringAndSqlDateProperty();
	dp.setSqlDate(getDatebeginbuild());
	return dp.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getDcsid() {
	return dcsid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @return java.lang.String
 */
public java.lang.String getDetails() {
	return details;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2003 17:07:01)
 * @return java.lang.String
 */
public String  getFullName() throws Exception{
    String gsm = getGsmid() != null ? "D" + getGsmid() : "";
    String damps = getDampsid() != null ? "A" + getDampsid() : "";

    String positionName =
        gsm
            + (gsm.length() > 0 && damps.length() > 0 ? " " : "")
            + damps
            + (gsm.length() > 0 || damps.length() > 0 ? " " : "")
            + getName();
    return positionName;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getGsmid() throws Exception{
	return bean==null?gsmid:bean.getGsmid();
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getInAction() {
	return inAction;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLatitude() {
	return latitude;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLongitude() {
	return longitude;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.String
 */
public java.lang.String getName() throws Exception {
	return bean==null?name:bean.getName();
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getNetzone() {
	return netzone;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.String
 */
public java.lang.String getRegionname() {
	return regionname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @return java.lang.String
 */
public java.lang.String getRenter_name() {
	return renter_name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @return java.lang.Integer
 */
public java.lang.Integer getRenter_org() {
	return renter_org;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @return java.lang.String
 */
public java.lang.String getRentervolume() {
	return rentervolume;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 18:00:17)
 * @return java.lang.String
 */
public java.lang.String getStorageplaceName() {
	return storageplaceName;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 11:47:44)
 * @return java.lang.String
 */
public java.lang.String getSupregname() {
	return supregname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @return java.lang.String
 */
public java.lang.String getZonecode() {
	return zonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @return java.lang.String
 */
public java.lang.String getZonename() {
	return zonename;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:46:06)
 */
public void initDataUtil() {}
public boolean isEdit() {
	return isEditFact();
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 16:38:23)
 * @return boolean
 */
public boolean isEditFact() {
	return editFact;
}
public boolean isView() {
	return isViewFact();
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 16:38:23)
 * @return boolean
 */
public boolean isViewFact() {
	return viewFact;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @param newAccesslistexp java.sql.Date
 */
public void setAccesslistexp(java.sql.Date newAccesslistexp) {
	accesslistexp = newAccesslistexp;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2003 22:04:41)
 * @param newBean com.hps.july.persistence.PositionAccessBean
 */
public void setBean(com.hps.july.persistence.PositionAccessBean newBean) {
	bean = newBean;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newDampsid java.lang.Integer
 */
public void setDampsid(java.lang.Integer newDampsid) {
	dampsid = newDampsid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newDampsname java.lang.String
 */
public void setDampsname(java.lang.String newDampsname) {
	dampsname = newDampsname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @param newDatebeginbuild java.lang.String
 */
public void setDatebeginbuild(java.sql.Date newDatebeginbuild) {
	datebeginbuild = newDatebeginbuild;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @return java.lang.String
 */
public void setDatebeginbuildStr(String s) {}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newDcsid java.lang.Integer
 */
public void setDcsid(java.lang.Integer newDcsid) {
	dcsid = newDcsid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @param newDetails java.lang.String
 */
public void setDetails(java.lang.String newDetails) {
	details = newDetails;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newGsmid java.lang.Integer
 */
public void setGsmid(java.lang.Integer newGsmid) {
	gsmid = newGsmid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newInAction java.lang.Boolean
 */
public void setInAction(java.lang.Boolean newInAction) {
	inAction = newInAction;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @param newLatitude java.math.BigDecimal
 */
public void setLatitude(java.math.BigDecimal newLatitude) {
	latitude = newLatitude;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @param newLongitude java.math.BigDecimal
 */
public void setLongitude(java.math.BigDecimal newLongitude) {
	longitude = newLongitude;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newNetzone java.lang.Integer
 */
public void setNetzone(java.lang.Integer newNetzone) {
	netzone = newNetzone;
}
/**
 * 
 * @param newPosstate java.lang.String
 */
public void setPosstate(java.lang.String newPosstate) {
	posstate = newPosstate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newRegionid java.lang.Integer
 */
public void setRegionid(java.lang.Integer newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newRegionname java.lang.String
 */
public void setRegionname(java.lang.String newRegionname) {
	regionname = newRegionname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @param newRenter_name java.lang.String
 */
public void setRenter_name(java.lang.String newRenter_name) {
	renter_name = newRenter_name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @param newRenter_org java.lang.Integer
 */
public void setRenter_org(java.lang.Integer newRenter_org) {
	renter_org = newRenter_org;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 19:46:22)
 * @param newRentervolume java.lang.String
 */
public void setRentervolume(java.lang.String newRentervolume) {
	rentervolume = newRentervolume;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 18:00:17)
 * @param newStorageplaceName java.lang.String
 */
public void setStorageplaceName(java.lang.String newStorageplaceName) {
	storageplaceName = newStorageplaceName;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 11:47:44)
 * @param newSupregname java.lang.String
 */
public void setSupregname(java.lang.String newSupregname) {
	supregname = newSupregname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 17:10:55)
 * @param newZonecode java.lang.String
 */
public void setZonecode(java.lang.String newZonecode) {
	zonecode = newZonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2003 19:36:52)
 * @param newZonename java.lang.String
 */
public void setZonename(java.lang.String newZonename) {
	zonename = newZonename;
}
}
