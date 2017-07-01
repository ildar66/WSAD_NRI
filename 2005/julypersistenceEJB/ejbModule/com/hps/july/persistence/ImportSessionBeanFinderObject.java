package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ImportSessionBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements ImportSessionBeanFinderHelper{
	private static java.util.HashMap aliasMap;
	private static java.lang.String startOrder;

/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
		Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate,
		Boolean isOperator, Integer operator,
		Boolean isKeyfields, String keyfields,
		Boolean isImpsesid, Integer impsesid,
		Integer order
	) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "IMPORTSESSIONS");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1" );
	if( isRecendtime.booleanValue() )
		whereClause.append( "AND " + alias + ".importstart >= ? AND " + alias + ".importstart <= ? ");
	if( isOperator.booleanValue() )
		whereClause.append( "AND " + alias + ".operator = ?" );
	if( isImpsesid.booleanValue() )
		whereClause.append( "AND " + alias + ".impsesid = ? ");
	if(isKeyfields.booleanValue())
		whereClause.append( "AND " + alias + ".impsesid IN (SELECT s.impsesid FROM importrecords s WHERE " +
			" UPPER(s.keyfields) MATCHES UPPER(?)) " );
		
		 
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getStartOrder(sb.toString(), alias) + " asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isRecendtime.booleanValue() ) {
			ps.setTimestamp( j++, beginDate);
			ps.setTimestamp( j++, endDate);
		}
		if( isOperator.booleanValue() )
			ps.setInt( j++, operator.intValue() );
		if( isImpsesid.booleanValue() )
			ps.setInt( j++, impsesid.intValue() );

		if( isKeyfields.booleanValue() )
			ps.setString( j++, keyfields );
	}   

	return ps;
}
/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE2(
		Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate,
		Boolean isOperator, Integer operator,
		Boolean isKeyfields, String keyfields,
		Boolean isImpsesid, Integer impsesid,
		Boolean isTaskid, Integer argTaskId,
		Integer order
	) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "IMPORTSESSIONS");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1" );
	if( isRecendtime.booleanValue() )
		whereClause.append( "AND " + alias + ".importstart >= ? AND " + alias + ".importstart <= ? ");
	if( isOperator.booleanValue() )
		whereClause.append( "AND " + alias + ".operator = ?" );
	if( isImpsesid.booleanValue() )
		whereClause.append( "AND " + alias + ".impsesid = ? ");
	if(isKeyfields.booleanValue())
		whereClause.append( "AND " + alias + ".impsesid IN (SELECT s.impsesid FROM importrecords s WHERE " +
			" UPPER(s.keyfields) MATCHES UPPER(?)) " );
	if( isTaskid.booleanValue() )
		whereClause.append( "AND " + alias + ".imptaskid = ? ");
		
		 
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getStartOrder(sb.toString(), alias) + " asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isRecendtime.booleanValue() ) {
			ps.setTimestamp( j++, beginDate);
			ps.setTimestamp( j++, endDate);
		}
		if( isOperator.booleanValue() )
			ps.setInt( j++, operator.intValue() );
		if( isImpsesid.booleanValue() )
			ps.setInt( j++, impsesid.intValue() );

		if( isKeyfields.booleanValue() )
			ps.setString( j++, keyfields );
			
		if( isTaskid.booleanValue() )
			ps.setInt( j++, argTaskId.intValue() );
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
	public static java.lang.String getStartOrder(String statement, String alias ) {
		if( startOrder == null ) {
			startOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".importstart" ) );
		}
		return startOrder;
	}
public static void setAliasMap(java.util.HashMap newAliasMap) {
	aliasMap = newAliasMap;
}
	public static void setStartOrder(java.lang.String newStartOrder) {
		startOrder = newStartOrder;
	}
}
