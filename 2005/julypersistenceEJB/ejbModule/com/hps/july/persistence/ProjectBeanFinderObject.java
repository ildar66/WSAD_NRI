package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ProjectBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements ProjectBeanFinderHelper{

/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE1(
    Integer projecttype,
    Boolean isProjectstate,
    String argProjectstate,
    Boolean isPosition,
    Integer argPosition,
    Boolean isNetzone,
    Integer argNetzone,
    Integer order)
    throws java.lang.Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("projecttype=? ");
    if (isProjectstate.booleanValue())
        whereClause.append(
            " AND "
                + "(SELECT max(p.state) "
                + "FROM projectstates p "
                + "WHERE p.project = t1.project AND p.when ="
                + "(SELECT max(p1.when) "
                + "FROM projectstates p1 "
                + "WHERE p1.project = t1.project)) =?");
    if (isPosition.booleanValue())
        whereClause.append(
            " AND equipment  IN (SELECT equipment FROM equipment e WHERE e.position = ? ) ");
    if (isNetzone.booleanValue())
        whereClause.append(
            " AND equipment IN (SELECT equipment FROM equipment e, positions p WHERE "
                + "p.storageplace = e.position AND p.netzone = ?) ");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "name asc";
            break;
        case 2 :
            orderBy = "name desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        ps.setInt(j++, projecttype.intValue());
        if (isProjectstate.booleanValue())
            ps.setString(j++, argProjectstate);
        if (isPosition.booleanValue())
            ps.setInt(j++, argPosition.intValue());
        if (isNetzone.booleanValue())
            ps.setInt(j++, argNetzone.intValue());
    }

    return ps;
}
/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE2(Integer division, Integer projecttype,
	Boolean isSupregions, Integer [] supregions, 
	Boolean isRegions, Integer [] regions, 
	Boolean isNetzones, Integer [] netzones,
	Boolean isPosition, Integer argPosition,
	Boolean isResponsible, Integer argResponsible,
	Boolean isEndDate, Short endMonth, Integer endYear,
	Boolean isProjectstate, String argProjectstate, 
 	Integer order)
    throws java.lang.Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("projecttype=? ");
    if (isSupregions.booleanValue()) {
	    String s = "";
	    for (i=0; i<supregions.length; i++) {
		    if (s.length() > 0)
		    	s = s + ", ";
		    s = s + supregions [i].toString();
	    }
	    if (s.length() > 0)
        whereClause.append(" AND position IN (SELECT p.storageplace FROM positions p, regions r " +
	        "WHERE r.regionid = p.regionid AND r.supregid IN (" + s + "))");
    }
    if (isRegions.booleanValue()) {
	    String s = "";
	    for (i=0; i<regions.length; i++) {
		    if (s.length() > 0)
		    	s = s + ", ";
		    s = s + regions [i].toString();
	    }
	    if (s.length() > 0)
        whereClause.append(" AND position IN (SELECT p.storageplace FROM positions p " +
	        "WHERE p.regionid IN (" + s + "))");
    }
    if (isNetzones.booleanValue()) {
	    String s = "";
	    for (i=0; i<netzones.length; i++) {
		    if (s.length() > 0)
		    	s = s + ", ";
		    s = s + netzones [i].toString();
	    }
	    if (s.length() > 0)
        whereClause.append(" AND position IN (SELECT p.storageplace FROM positions p " +
	        "WHERE p.netzone IN (" + s + "))");
    }
    if (isPosition.booleanValue())
        whereClause.append(" AND position = ?");
        
    if (isResponsible.booleanValue())
        whereClause.append(" AND project IN (SELECT p.project FROM projectactions p, projectactiontypes t, " +
	        "workresponsibility w WHERE t.projectactiontype = p.projectactiontype AND " +
	        "w.idresponsibility = t.typeresponsibility AND w.storageplace = T1.position AND w.worker=?)");
        
    if (isEndDate.booleanValue())
        whereClause.append(" AND monthfinish = ? AND yearfinish = ?");

    if (isProjectstate.booleanValue())
        whereClause.append(
            " AND "
                + "(SELECT max(p.state) "
                + "FROM projectstates p "
                + "WHERE p.project = t1.project AND p.when ="
                + "(SELECT max(p1.when) "
                + "FROM projectstates p1 "
                + "WHERE p1.project = t1.project)) = ?");
        
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "project asc";
            break;
        case 2 :
            orderBy = "project desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        ps.setInt(j++, projecttype.intValue());
        if (isPosition.booleanValue())
            ps.setInt(j++, argPosition.intValue());
        if (isResponsible.booleanValue())
            ps.setInt(j++, argResponsible.intValue());
        if (isEndDate.booleanValue()) {
            ps.setShort(j++, endMonth.shortValue());
            ps.setInt(j++, endYear.intValue());
        }
        if (isProjectstate.booleanValue())
            ps.setString(j++, argProjectstate);
    }

    return ps;
}
}
