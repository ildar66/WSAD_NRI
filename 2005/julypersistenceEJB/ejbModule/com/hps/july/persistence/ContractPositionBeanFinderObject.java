package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ContractPositionBeanFinderObject extends DocumentPositionBeanFinderObject  
implements ContractPositionBeanFinderHelper{
	private static int orderIdx;
	private static java.util.Map aliasMap;
/**
 * findByDocOrderByContractPositionOrderAsc method comment.
 */
public java.sql.PreparedStatement findByDocOrderByContractPositionOrderAsc(java.lang.Integer argDocument) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "t2.document = ? " );    
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	orderBy = "t1.order asc";
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argDocument.intValue() );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:06:36)
 * @return java.util.Map
 */
public java.util.Map getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:39:05)
 * @return int
 */
public int getOrderIdx(String statement, String alias) {
	if( orderIdx <= 0 ) {
		orderIdx = PersistenceUtil.getFieldIndex( statement, alias+".order" );
	}
	return orderIdx;
}
}
