package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class SectorBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
implements AntennaBeanFinderHelper{
public java.sql.PreparedStatement findByQBE(Integer argBSNum, String bsType,
	Boolean isPlanstate, String argPlanstate, 
	Boolean isState, String argState,
	Integer order) throws Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("  t1.planfacttype=1 AND t1.equipment IN (SELECT bs.equipment " +
	    " FROM basestations bs, equipment e, positions p WHERE " +
	    " p.storageplace = e.position AND e.equipment = bs.equipment AND " +
	    " bs.number=? AND bs.type=? ");
    if (isPlanstate.booleanValue())
        whereClause.append("AND p.planstate=? ");
    if (isState.booleanValue())
        whereClause.append("AND e.state=? ");
    whereClause.append(")");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "num_sect asc";
            break;
        case 2 :
            orderBy = "num_sect desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        ps.setInt(j++, argBSNum.intValue());
        ps.setString(j++, bsType);
	    if (isPlanstate.booleanValue())
        	ps.setString(j++, argPlanstate);
	    if (isState.booleanValue())
        	ps.setString(j++, argState);
	        
    }

    return ps;	    
}
}
