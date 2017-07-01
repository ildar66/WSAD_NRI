package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ExpeditionBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  implements ExpeditionBeanFinderHelper{
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findAllOrderByNameAsc() throws Exception {

	//get generic query string 
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    for (int i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], "1=1" );
    }

    sb.append( " order by 1 asc" );
	//System.out.println( "SQL clause="+sb );

	//fill prepared statement
	return getPreparedStatement( sb.toString() );
}
}
