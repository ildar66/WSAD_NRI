package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class PIEMxranPlatinumBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
	implements PIEMxranPlatinumBeanFinderHelper{

/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByMxranNameOwner(Boolean isMxranPlatinum, String mxranplatinum,
		Boolean isName, String name, 
		Integer owner, Integer order)
			throws java.lang.Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer(" owner = ? ");
    if (isMxranPlatinum.booleanValue())
        whereClause.append(" AND upper(mxranplatinum) matches upper(?) ");
    if (isName.booleanValue())
        whereClause.append(" AND upper(name) matches upper(?) ");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "mxranplatinum asc";
            break;
        case 2 :
            orderBy = "mxranplatinum desc";
            break;
        case 3 :
            orderBy = "name asc";
            break;
        case 4 :
            orderBy = "name desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        ps.setInt(j++, owner.intValue());
        if (isMxranPlatinum.booleanValue())
            ps.setString(j++, mxranplatinum);
        if (isName.booleanValue())
            ps.setString(j++, name);
    }

    return ps;
}
}
