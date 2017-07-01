package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class CurrencyBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
	implements CurrencyBeanFinderHelper{
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findByConnectedOrderByNameAsc(Integer argConnected) throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " 1=1 " );
	if (argConnected.intValue() == 2)
    	whereClause = whereClause.append(" AND EXISTS (SELECT pv.* FROM pie_valutes pv WHERE pv.idvautenri=t1.currency)");
	if (argConnected.intValue() == 3)
    	whereClause = whereClause.append(" AND NOT EXISTS (SELECT pv.* FROM pie_valutes pv WHERE pv.idvautenri=t1.currency)");
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause );
    }
    
	//append order by clause
	String orderBy = "name asc";
	/*
	switch( order ) {
		case 1:
			orderBy = "name asc";
			break;
		case 2:
			orderBy = "name desc";
			break;
	}
	*/
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		//ps.setInt( j++, argEncloser.intValue() );
	}   

	return ps;
}
}
