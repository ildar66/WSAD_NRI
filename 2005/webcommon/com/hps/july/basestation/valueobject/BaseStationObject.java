package com.hps.july.basestation.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;

/**
 * Служебный класс позволяющий получать данные по базовым станциям из БД
 */
public class BaseStationObject
	extends JdbcObject
{
	private int equipment;
	private int positionId;

	private Integer number;
	private String type;
	private String name;
	private String address;
	private String zonecode;
	private String onair;
	private String posstate;
    private boolean edit;
    private boolean view;

    public final static String SEARCH_ALL = "all";

    public final static String SEARCHBY_NUMBER = SearchConstants.SEARCHBY_NUMBER;
    public final static String SEARCHBY_NAME = SearchConstants.SEARCHBY_NAME;
    public final static String SEARCHBY_ADDRESS = SearchConstants.SEARCHBY_ADDRESS;

    public final static String ONAIR_CHECK_Y = "Y";
    public final static String ONAIR_CHECK_N = "N";
    public final static String TYPE_SEARCH_GSM = "gsm";
    public final static String TYPE_SEARCH_DAMPS = "damps";
    public final static String TYPE_CHECK_DAMPS_D = "D";
    public final static String TYPE_CHECK_GSM_S = "S";
    public final static String TYPE_CHECK_GSM_G = "G";
    public final static String TYPE_CHECK_DCS_C = "C";

    public final static String TYPE_VALUE_DAMPS_D = "DAMPS";
    public final static String TYPE_VALUE_GSM_S = "GSM 900";
    public final static String TYPE_VALUE_GSM_G = "GSM 900/1800";
    public final static String TYPE_VALUE_DCS_C = "DCS 1800";

    public final static String STATE_CHECK_PLAN_P = "P";
    public final static String STATE_CHECK_MOUNT_M = "M";
    public final static String STATE_CHECK_READY_R = "R";
    public final static String STATE_CHECK_TEST_T = "T";
    public final static String STATE_CHECK_WORK_W = "W";
    public final static String STATE_CHECK_DEMOUNT_D = "D";

    public final static String PLANSTATE_CHECK_Fact = "2";
    public final static String CONTYPE_CHECK_RADIO = "R";
    public final static String CONTYPE_CHECK_OPTIC = "O";

    public final static int ORDER_NUMBER_ASC = 1;
    public final static int ORDER_NUMBER_DESC = 2;
    public final static int ORDER_NAME_ASC = 3;
    public final static int ORDER_NAME_DESC = 4;

    public final static short BAND_CHECK_DAMPS_800 = 800;
    public final static short BAND_CHECK_GSM_900 = 900;
    public final static short BAND_CHECK_GSM_1800 = 1800;

    public static final String QUERY_SELECT =
        "SELECT UNIQUE p.posstate,"
            + " DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') type,"
            + " DECODE(bs.on_air,'Y','Y','') onair,"
            + " CASE"
            + " (CASE ra.viewplan WHEN NULL THEN 'N' ELSE ra.viewplan END)"
            + " ||(CASE sra.viewplan WHEN NULL THEN 'N' ELSE sra.viewplan END)"
            + " WHEN 'NN' THEN 'N' ELSE 'Y' END viewplan,"
            + " CASE"
            + " (CASE ra.viewfact WHEN NULL THEN 'N' ELSE ra.viewfact END)"
            + " ||(CASE sra.viewfact WHEN NULL THEN 'N' ELSE sra.viewfact END)"
            + " WHEN 'NN' THEN 'N' ELSE 'Y' END viewfact,"
            + " CASE"
            + " (CASE ra.editplan WHEN NULL THEN 'N' ELSE ra.editplan END)"
            + " ||(CASE sra.editplan WHEN NULL THEN 'N' ELSE sra.editplan END)"
            + " WHEN 'NN' THEN 'N' ELSE 'Y' END editplan,"
            + " CASE"
            + " (CASE ra.editfact WHEN NULL THEN 'N' ELSE ra.editfact END)"
            + " ||(CASE sra.editfact WHEN NULL THEN 'N' ELSE sra.editfact END)"
            + " WHEN 'NN' THEN 'N' ELSE 'Y' END editfact,"
            + " bs.equipment, bs.number,bs.name,s.address,n.zonecode,p.storageplace positionId, p.regionid regionId "
            + " FROM basestations bs,equipment e,positions p,storageplaces s,netzones n,"
            + " Regions r,SuperRegions sr,  operators o, OUTER RegionsAccess sra, OUTER  RegionsAccess ra"
            + " WHERE sr.supregid=r.supregid"
            + " AND s.storageplace = p.storageplace AND n.netzone = p.netzone"
            + " AND e.equipment=bs.equipment AND e.position=p.storageplace"
            + " AND (ra.viewfact='Y' OR ra.editfact='Y'  OR sra.viewfact='Y' OR sra.editfact='Y')"
            + " AND r.regionid = p.regionid"
            + " AND sra.accesstype='S'"
            + " AND ra.accesstype='R'"
            + " AND sra.supregionid=sr.supregid"
            + " AND ra.regionid=r.regionid"
            + " AND ra.operatorid=o.operator"
            + " AND sra.operatorid=o.operator";

    public static final String QUERY_SELECT_Admin =
			"SELECT p.posstate posstate, "
            + " DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') type,"
            + " DECODE(bs.on_air,'Y','Э','') onair,"
            + " 'Y' viewplan,"
            + " 'Y' viewfact,"
            + " 'Y' editplan,"
            + " 'Y' editfact,"
            + " bs.equipment,bs.number,bs.name,s.address,n.zonecode,p.storageplace positionId, p.regionid regionId "
            + " FROM basestations bs,equipment e,positions p,storageplaces s,netzones n,Regions r,SuperRegions sr"
            + " WHERE sr.supregid=r.supregid"
            + " AND s.storageplace = p.storageplace"
            + " AND n.netzone = p.netzone"
            + " AND r.regionid = p.regionid"
            + " AND e.equipment=bs.equipment"
            + " AND e.position=p.storageplace ";
	private java.lang.Integer regionId = null;
public BaseStationObject() throws Exception {
	super();
}
public BaseStationObject(java.sql.ResultSet rs) throws Exception {
	super();
	//"SELECT DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') type ,DECODE(bs.on_air,'Y','Э','') on_air,bs.number,bs.name,s.address,n.zonecode, e.planstate FROM basestations bs,equipment e, positions p, storageplaces s, netzones n, Regions r WHERE s.storageplace = p.storageplace AND n.netzone = p.netzone AND r.regionid = p.regionid AND e.equipment=bs.equipment AND e.position=p.storageplace"
	try {
		equipment=rs.getInt("equipment");
		positionId=rs.getInt("positionId");
		posstate = getString(rs, "posstate");
		name = getString(rs, "name"); 
		address = getString(rs, "address"); 
		zonecode = getString(rs, "zonecode");
		number = (Integer)rs.getObject("number");
		this.regionId = new Integer(rs.getInt("regionId"));
		onair = getString(rs,"onair");
		type=getString(rs,"type");
		//storageplace=(Integer)rs.getObject("storageplace");
		edit = getString(rs,"edit").equals("Y");
		view = getString(rs,"view").equals("Y");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 18:04:20)
 * @return java.lang.String
 */
public Enumeration findByQBE(
    java.lang.Boolean isAllNetZones,
    java.lang.Integer[] netZones,
    String type,
    Boolean isAllRegions,
    Integer[] regions,
    Boolean isAllSupregs,
    Integer[] supregs,
    String searchBy,
    String searchValue,
    Boolean isAllSwitches,
    Integer switch_,
    Boolean isAllControllers,
    Integer controller,
    Boolean isAllStates,
    String state,
    String posstate,
    String onair,
    Boolean isAdmin,
    String login,
    java.lang.Integer order)
    throws Exception {

    Query query;

    //get generic query string
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

    if (!isAllStates.booleanValue()) {
        query.append("AND e.state=?", state);

    }

    if (!isAllRegions.booleanValue()) {
		query.append("AND p.regionid IN", regions);
	} else if (isAllRegions.booleanValue() && !isAllSupregs.booleanValue()) {
		query.append("AND sr.supregid IN", supregs);
	}

	if (posstate != null && !"*".equals(posstate)) {
		query.append("AND p.posstate IN ", getPosstateList(posstate));
	}

    if (!isAllNetZones.booleanValue()) {
        query.append("AND p.netzone IN", netZones);

    }
    String field = null;
    if (searchBy.equals(SEARCHBY_ADDRESS))
        field = "s.address";
    else if (searchBy.equals(SEARCHBY_NAME))
        field = "bs.name";
    else if (searchBy.equals(SEARCHBY_NUMBER))
        field = "bs.number";

    if (field != null)
        query.append(
            "AND " + field + (field.equals("bs.number") ? "=" : " MATCHES ") + "?",
            searchValue);

    if (type.equals(TYPE_SEARCH_DAMPS))
        query.append("AND bs.type = ?", TYPE_CHECK_DAMPS_D);
    else if (!type.equals(SearchConstants.SEARCH_ALL))
        query.append("AND bs.type <> ?", TYPE_CHECK_DAMPS_D);

    if (!isAllControllers.booleanValue()) {
        query.append("AND bs.controller=?", controller);
    }
    if (!isAllSwitches.booleanValue()) {
        query.append("AND bs.switch=?", switch_);
    }
    if (onair.equals(BaseStationObject.ONAIR_CHECK_Y)) {
        query.append("AND bs.on_air=?", onair);
    } else if (onair.equals(BaseStationObject.ONAIR_CHECK_N)) {
        query.append("AND (bs.on_air=? OR bs.on_air IS NULL)", onair);
    }
    if (!isAdmin.booleanValue()) {
        query.append("AND o.loiginid=?", login);
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case ORDER_NUMBER_ASC :
            orderBy = "bs.number asc";
            break;
        case ORDER_NUMBER_DESC :
            orderBy = "bs.number desc";
            break;
        case ORDER_NAME_ASC :
            orderBy = "bs.name asc";
            break;
        case ORDER_NAME_DESC :
            orderBy = "bs.name desc";
            break;

    }
    query.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + query.buf.toString());

    return findEnumeration(query);
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
 * Creation date: (06.03.2003 20:22:28)
 * @return int
 */
public int getEquipment() {
	return equipment;
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
 * Creation date: (05.03.2003 19:36:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @return java.lang.String
 */
public java.lang.String getOnair() {
	return onair;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 22:01:03)
 * @return int
 */
public int getPositionId() {
	return positionId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
}
/**
 * 
 * @return java.lang.String[]
 * @param agrPosstate java.lang.String
 */
public static String[] getPosstateList(String argPosstate) {
	if(argPosstate == null) {
		return null;
	}
	String[] res = new String[argPosstate.length()];
	for(int i = 0; i < argPosstate.length(); i++) {
		res[i] = String.valueOf(Character.toUpperCase(argPosstate.charAt(i)));
	}
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2004 15:49:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionId() {
	return regionId;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
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
public static boolean hasAccess(HttpServletRequest request, int baseStationId)
	throws Exception
{
    if (request.isUserInRole("administrator")) return true;
    try {
		BaseStationAccessBean baseStation = new BaseStationAccessBean();
		baseStation.setInitKey_storageplace(baseStationId);
		baseStation.refreshCopyHelper();

        OperatorAccessBean operator = new OperatorAccessBean().findByLogin(request.getRemoteUser());

		RegionAccAccessBeanTable table = new RegionAccAccessBeanTable();
		table.setRegionAccAccessBean(new RegionAccAccessBean().findRegionAccsByOperator((OperatorKey) operator.__getKey()));
        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getRegionAccAccessBean(i).getRegionKey().regionid == baseStation.getPosition().getRegionKey().regionid
				&& table.getRegionAccAccessBean(i).getEditfact())
			{
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
     * Creation date: (17.02.2003 14:46:06)
     */
    public void initDataUtil() {
    }
/**
 * 
 * @return boolean
 */
public boolean isEdit() {
	return edit;
}
/**
 * 
 * @return boolean
 */
public boolean isView() {
	return view;
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
 * 
 * @param newEdit boolean
 */
public void setEdit(boolean newEdit) {
	edit = newEdit;
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
 * Creation date: (05.03.2003 19:36:20)
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @param newOnair java.lang.String
 */
public void setOnair(java.lang.String newOnair) {
	onair = newOnair;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 22:01:03)
 * @param newPositionId int
 */
public void setPositionId(int newPositionId) {
	positionId = newPositionId;
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
 * Creation date: (28.10.2004 15:49:03)
 * @param newRegionId java.lang.Integer
 */
public void setRegionId(java.lang.Integer newRegionId) {
	regionId = newRegionId;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
/**
 * 
 * @param newView boolean
 */
public void setView(boolean newView) {
	view = newView;
}
/**
 * Insert the method's description here.
 * Creation date: (05.03.2003 19:36:20)
 * @param newZonecode java.lang.String
 */
public void setZonecode(java.lang.String newZonecode) {
	zonecode = newZonecode;
}
}
