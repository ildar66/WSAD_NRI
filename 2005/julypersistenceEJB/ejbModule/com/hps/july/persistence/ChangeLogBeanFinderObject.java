package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ChangeLogBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
implements ChangeLogBeanFinderHelper{
public java.sql.PreparedStatement findByQBE(
        Boolean isObjtype, Short objtype,
        Boolean isObjid, Integer objid,
        Boolean isPeriod, java.sql.Timestamp dateStart, java.sql.Timestamp dateEnd,
        Boolean isMan, Integer man,
        Boolean isEventtype, String eventtype,
        Integer order
    ) throws Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("1=1 ");
    if (isObjtype.booleanValue())
        whereClause.append("AND objtype=? ");
    if (isObjid.booleanValue())
        whereClause.append("AND objid=?");
    if (isPeriod.booleanValue())
        whereClause.append("AND recdate >= ? AND recdate <=? ");
    if (isMan.booleanValue())
        whereClause.append("and man=?");
    if (isEventtype.booleanValue())
        whereClause.append("and eventtype=?");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "logid asc";
            break;
        case 2 :
            orderBy = "logid desc";
            break;
        case 3 :
            orderBy = "recdate asc";
            break;
        case 4 :
            orderBy = "recdate desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
	    if (isObjtype.booleanValue())
            ps.setShort(j++, objtype.shortValue());
	    if (isObjid.booleanValue())
            ps.setInt(j++, objid.intValue());
	    if (isPeriod.booleanValue()) {
            ps.setTimestamp(j++, dateStart);
            ps.setTimestamp(j++, dateEnd);
	    }
	    if (isMan.booleanValue())
            ps.setInt(j++, man.intValue());
	    if (isEventtype.booleanValue())
            ps.setString(j++, eventtype);
	        
    }

    return ps;	    
}
}
