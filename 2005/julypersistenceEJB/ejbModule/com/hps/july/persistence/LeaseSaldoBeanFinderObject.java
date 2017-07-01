package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseSaldoBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements LeaseSaldoBeanFinderHelper{

	private static java.util.HashMap aliasMap;
	private static int startDateIdx;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(Integer leaseContract,
		Boolean isDateStart,
        java.sql.Date fromDateStart, java.sql.Date toDateStart, /*диапазон для dateStart*/
        Integer order
) 
	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASESALDO"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias1+".leasecontract = ? ");

	if (isDateStart.booleanValue())
		whereClause = whereClause.append(" AND "+
			alias1 + ".saldate >= ? AND " + alias1 + ".saldate <= ? ");
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getStartDateIdx(sb.toString(), alias1+".SALDATE")+" asc";
			break;
		case 2:
			orderBy = getStartDateIdx(sb.toString(), alias1+".SALDATE")+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, leaseContract.intValue() );
		if (isDateStart.booleanValue()) {
			ps.setDate( j++, fromDateStart );
			ps.setDate( j++, toDateStart );
		}
	}

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public java.util.HashMap getAliasMap() {
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public java.util.Map getAliasMap( String statement ) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:26:26)
 * @return int
 */
public int getStartDateIdx( String statement, String field ) {
	if( startDateIdx == 0 ) {
		startDateIdx = PersistenceUtil.getFieldIndex( statement, field );
	}
	return startDateIdx;
}
}
