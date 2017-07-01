package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.*;
/**
 * Доступ по регинам(филиалам).
 * Creation date: (21.11.2005 14:33:03)
 * @author: Shafigullin Ildar
 */
public class CDBC_RegionsAccess_Object {
    private static final String _createString =
        "INSERT INTO regionsaccess (accessid, editfact, editplan, viewfact, viewplan, viewarenda, editarenda, operatorid, regionid, accesstype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String _removeString = "DELETE FROM regionsaccess  WHERE accessid = ?";
    private static final String _storeString =
        "UPDATE regionsaccess  SET editfact = ?, editplan = ?, viewfact = ?, viewplan = ?, operatorid = ?, regionid = ?, accesstype = ? WHERE accessid = ?";
    private static final String _loadString =
        "SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.operatorid, T1.regionid, T1.accesstype FROM regionsaccess  T1 WHERE T1.accesstype = \'R\' AND T1.accessid = ?";
    private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
    private static final String findRegionAccsByOperator =
        "SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.operatorid, T1.regionid, T1.supregionid, T1.accesstype, T1.viewarenda, T1.editarenda, T2.regname, T2.hasArendaPurchaser, T3.currency, T3.name, T3.shortname "
            + "FROM regionsaccess T1, regions T2, currencies T3  "
            + "WHERE T1.accesstype = \'R\' AND  T1.regionid = T2.regionid AND T2.nationalCurr = T3.currency AND  T1.operatorid = ? "
            + "AND (T1.viewarenda = \'Y\' OR T1.editarenda = \'Y\') ";
    private static final String findAccessByOperator =
        "SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.operatorid, T1.regionid, T1.supregionid, T1.accesstype, T1.viewarenda, T1.editarenda, T2.regname, T2.hasArendaPurchaser, T3.supregname "
            + "FROM regionsaccess T1, regions T2, superregions T3  "
            + "WHERE T1.accesstype = \'R\' AND  T1.regionid = T2.regionid  AND  T2.supregid = T3.supregid  AND  T1.operatorid = ? ";
    private static final String deleteAccessByOperator = "DELETE FROM regionsaccess  WHERE accesstype = \'R\' AND operatorid = ? ";
	private static final String findLicenceRegionAccsByOperator =
		"SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.operatorid, T1.regionid, T1.supregionid, T1.accesstype, T1.viewarenda, T1.editarenda, T2.regname, T2.hasArendaPurchaser "
			+ "FROM regionsaccess T1, regions T2  "
			+ "WHERE T1.accesstype = \'R\' AND  T1.regionid = T2.regionid  AND  T1.operatorid = ? "
			+ "AND (T1.editfact = \'Y\' OR T1.viewfact = \'Y\') ";

/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 17:05:08)
 */
public final static void addAccessByOperator(java.util.Collection accessColl) {
    CDBCResultSet res = new CDBCResultSet();
    java.util.Iterator iter = accessColl.iterator();
    while (iter.hasNext()) {
        RegionsAccess_VO vo = (RegionsAccess_VO) iter.next();
        Object[] params =
            {
                vo.getAccessid(),
                vo.getEditfact(),
                vo.getEditplan(),
                vo.getViewfact(),
                vo.getViewplan(),
                vo.getViewarenda(),
                vo.getEditarenda(),
                vo.getOperatorid(),
                vo.getRegionid(),
                vo.getAccesstype()};
        res.executeUpdate(_createString, params);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 17:06:23)
 * @return boolean
 * @param operatorKey java.lang.Integer
 */
public final static boolean deleteAccessByOperator(Integer operatorKey) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { operatorKey };
    return res.executeUpdate(deleteAccessByOperator, params);
}
/**
 * Права доступа для оператора.
 * Creation date: (08.12.2005 12:06:50)
 */
public final static java.util.List findAccessByOperator(Integer operatorKey, String orderBy) {
    if (operatorKey == null) {
        System.out.println("Error from CDBC_RegionAccess.findAccessByOperator:  operatorKey=" + operatorKey);
        return Collections.EMPTY_LIST;
    }
    CDBCResultSet res = new CDBCResultSet();
    ArrayList params = new ArrayList();
    List ret = new ArrayList();
    StringBuffer sb = new StringBuffer(findAccessByOperator);
    //calculate where clause:
    params.add(operatorKey);
    //append order by clause:
    if (orderBy != null)
        sb.append(" order by " + orderBy);
    //System.out.println("sb.toString()="+sb.toString());    //temp
    res.executeQuery(sb.toString(), params.toArray());
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        RegionsAccess_VO vo = CDBC_MapFactory.createRegionsAccess(ro);
        RegionsAccess_TO to = new RegionsAccess_TO(vo);
        to.setRegionName(ro.getColumn("regname").asString());
		to.setSupRegName(ro.getColumn("supregname").asString());
        ret.add(to);
    }
    return ret;
}
/**
 * доступные Права доступа для оператора.
 * Creation date: (12.12.2005 15:06:03)
 */
public final static java.util.List findListAnoveAccessForOperator(Integer operatorID, String orderBy) {
    CDBCResultSet res = new CDBCResultSet();
    List ret = new ArrayList();
    StringBuffer sb = new StringBuffer("SELECT reg.regionid, reg.regname, sreg.supregname FROM regions reg, superregions sreg ");
    sb.append(" WHERE reg.supregid = sreg.supregid AND reg.regionid NOT IN (SELECT regionid FROM regionsaccess WHERE accesstype = \'R\' AND operatorid = ?)");

    //append order by clause:
    if (orderBy != null && !orderBy.equals(""))
        sb.append(" order by " + orderBy);
    res.executeQuery(sb.toString(), new Object[] { operatorID });
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        Integer regid = (Integer) ro.getColumn("regionid").asObject();
        RegionsAccess_VO vo = new RegionsAccess_VO(null, operatorID, "R", null, regid, "N", "N", "N", "N", "N", "N");
        RegionsAccess_TO to = new RegionsAccess_TO(vo);
        to.setRegionName(ro.getColumn("regname").asString());
        to.setSupRegName(ro.getColumn("supregname").asString());
        ret.add(to);
    }
    return ret;
}
/**
 * Доступ для модуля аренды.
 * Creation date: (21.11.2005 14:39:01)
 */
public final static java.util.List findRegionAccsByOperator(Integer operatorKey, String orderBy) {
    if (operatorKey == null) {
        System.out.println("Error from CDBC_RegionAccess.findRegionAccsByOperator:  operatorKey=" + operatorKey);
        return Collections.EMPTY_LIST;
    }
    CDBCResultSet res = new CDBCResultSet();
    ArrayList params = new ArrayList();
    List ret = new ArrayList();
    StringBuffer sb = new StringBuffer(findRegionAccsByOperator);
    //calculate where clause:
    params.add(operatorKey);
    //append order by clause:
    if (orderBy != null)
        sb.append(" order by " + orderBy);
    //System.out.println("sb.toString()="+sb.toString());    //temp
    res.executeQuery(sb.toString(), params.toArray());
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        RegionsAccess_VO vo = CDBC_MapFactory.createRegionsAccess(ro);
        RegionsAccess_TO to = new RegionsAccess_TO(vo);
        to.setRegionName(ro.getColumn("regname").asString());
        Currency_VO curVO = CDBC_MapFactory.createCurrency(ro);
        to.setNationalCurrVO(curVO);
        ret.add(to);
    }
    return ret;
}
/**
 * Доступ для модуля аренды.
 * Creation date: (21.11.2005 14:39:01)
 */
public final static java.util.List findLicenceRegionAccsByOperator(Integer operatorKey, String orderBy) {
	if (operatorKey == null) {
		System.out.println("Error from CDBC_RegionAccess.findLicenceRegionAccsByOperator:  operatorKey=" + operatorKey);
		return Collections.EMPTY_LIST;
	}
	CDBCResultSet res = new CDBCResultSet();
	ArrayList params = new ArrayList();
	List ret = new ArrayList();
	StringBuffer sb = new StringBuffer(findLicenceRegionAccsByOperator);
	//calculate where clause:
	params.add(operatorKey);
	//append order by clause:
	if (orderBy != null)
		sb.append(" order by " + orderBy);
	//System.out.println("sb.toString()="+sb.toString());    //temp
	res.executeQuery(sb.toString(), params.toArray());
	ListIterator iter = res.listIterator();
	while (iter.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject) iter.next();
		RegionsAccess_VO vo = CDBC_MapFactory.createRegionsAccess(ro);
		RegionsAccess_TO to = new RegionsAccess_TO(vo);
		to.setRegionName(ro.getColumn("regname").asString());
		ret.add(to);
	}
	return ret;
}
}
