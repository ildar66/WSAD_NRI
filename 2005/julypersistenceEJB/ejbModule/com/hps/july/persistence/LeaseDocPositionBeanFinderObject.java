package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseDocPositionBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
	implements LeaseDocPositionBeanFinderHelper{
	private static int dateIdx;
	private static java.util.Map aliasMap;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isLeaseContract, 				java.lang.Integer leaseContract, 
	java.lang.Boolean isDate, 						java.sql.Date fromDate, 
	java.sql.Date toDate, 
    Boolean isResource, Integer resource,
	java.lang.Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("LEASEDOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isLeaseContract.booleanValue() )
		whereClause.append( " AND "+alias+".leasecontract=? " );
	if( isDate.booleanValue() )
		whereClause.append( " AND "+alias+".date >= ? and "+alias+".date <= ? " );
	if( isResource.booleanValue() )
		whereClause.append( " AND "+alias+".resource = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getDateIdx(sb.toString(),alias)+" asc";
			break;
		case 2:
			orderBy = getDateIdx(sb.toString(),alias)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isLeaseContract.booleanValue() )
			ps.setInt( j++, leaseContract.intValue() );
		if( isDate.booleanValue() ) {
			ps.setDate( j++, fromDate );
			ps.setDate( j++, toDate );
		}
		if( isResource.booleanValue() )
			ps.setInt( j++, resource.intValue() );
	}   

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE2(Integer leaseContract, Integer resource, java.sql.Date date, String docposvid)
		throws java.lang.Exception {
		
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("LEASEDOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias + ".leasecontract = ? AND " + 
		alias + ".resource = ? AND " + alias + ".date = ? AND " + alias + ".docposvid = ? ");
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

    /* 
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getDateIdx(sb.toString(),alias)+" asc";
			break;
		case 2:
			orderBy = getDateIdx(sb.toString(),alias)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	*/
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, leaseContract.intValue() );
		ps.setInt( j++, resource.intValue() );
		ps.setDate( j++, date );
		ps.setString( j++, docposvid );
	}   

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE5(
	java.lang.Boolean isLeaseContract, 				java.lang.Integer leaseContract, 
	java.lang.Boolean isDate, 						java.sql.Date fromDate, 
	java.sql.Date toDate, 
    Boolean isResource, Integer resource,
    Boolean isDocposvid, String[] docposvid, 
	java.lang.Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("LEASEDOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isLeaseContract.booleanValue() )
		whereClause.append( " AND "+alias+".leasecontract=? " );
	if( isDate.booleanValue() )
		whereClause.append( " AND "+alias+".date >= ? and "+alias+".date <= ? " );
	if( isResource.booleanValue() )
		whereClause.append( " AND "+alias+".resource = ? " );
	if (isDocposvid.booleanValue()) {
		String s = "'" + docposvid [0] + "'";
		for (int ii=1; ii<docposvid.length; ii++) {
			s = s + ",'" + docposvid [ii] + "'";
		}
		whereClause.append( " AND "+alias+".docposvid IN (" + s + ") " );
	}
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getDateIdx(sb.toString(),alias)+" asc";
			break;
		case 2:
			orderBy = getDateIdx(sb.toString(),alias)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isLeaseContract.booleanValue() )
			ps.setInt( j++, leaseContract.intValue() );
		if( isDate.booleanValue() ) {
			ps.setDate( j++, fromDate );
			ps.setDate( j++, toDate );
		}
		if( isResource.booleanValue() )
			ps.setInt( j++, resource.intValue() );
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
 * Creation date: (01.07.2002 10:39:22)
 * @return int
 */
public int getDateIdx( String statement,String alias ) {
	if( dateIdx <= 0 ) {
		dateIdx = PersistenceUtil.getFieldIndex( statement, alias+".date" );
	}
	return dateIdx;
}
}
