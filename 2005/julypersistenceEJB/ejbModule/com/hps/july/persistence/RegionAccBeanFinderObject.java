package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class RegionAccBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements RegionAccBeanFinderHelper{
	private static java.util.HashMap aliasMap;

/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(Integer argOperator,
		Boolean isSuperregion, Integer argSupregion,
		Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "REGIONSACCESS");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias + ".operatorid = ? " );
	if( isSuperregion.booleanValue() )
		whereClause.append( "AND " + alias + ".regionid IN (SELECT r.regionid FROM regions r WHERE r.supregid = ?) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

    /* 
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getModelOrder(sb.toString(), alias) + " asc";
			break;
		case 2:
			orderBy = getModelOrder(sb.toString(), alias) + " desc";
			break;
		case 3:
			orderBy = getNameOrder(sb.toString(), alias) + " asc";
			break;
		case 4:
			orderBy = getNameOrder(sb.toString(), alias) + " desc";
			break;
	}
	sb.append( " order by "+orderBy );
	*/
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argOperator.intValue() );
		if( isSuperregion.booleanValue() )
			ps.setInt( j++, argSupregion.intValue() );
	}   

	return ps;
}
public String getAlias(String statement, String alias) {
	return (String)(getAliasMap(statement).get(alias.toUpperCase()));
}
public static java.util.HashMap getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
public static void setAliasMap(java.util.HashMap newAliasMap) {
	aliasMap = newAliasMap;
}
}
