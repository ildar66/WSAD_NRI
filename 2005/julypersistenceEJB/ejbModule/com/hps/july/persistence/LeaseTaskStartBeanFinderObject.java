package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseTaskStartBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements LeaseTaskStartBeanFinderHelper{
		private static java.util.HashMap aliasMap;
/**
 * findBanksByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(java.lang.Boolean isStartDate, java.sql.Date beginStartDate, 
	java.sql.Date endStartDate, // период
        java.lang.Boolean isWorker, java.lang.Integer worker,
        java.lang.Boolean isTaskType, java.lang.String taskType,
        java.lang.Integer order) throws java.lang.Exception {
	
		//get generic query string 
		int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

		//getting aliases
		String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASETASKSSTARTS"));
    
    //calculate where clause
		StringBuffer whereClause = new StringBuffer( "1=1 " );
		if( isStartDate.booleanValue() )
			whereClause.append( "and " + alias1 + ".startdate >= ? AND " + alias1 + ".startdate <= ? " );
		if( isWorker.booleanValue() )
			whereClause.append( "and worker = ? " );
		if( isTaskType.booleanValue() )
			whereClause.append( "and tasktype = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		  sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
		//append order by clause
		String orderBy = null;
		switch( order.intValue() ) {
			case 1:
				orderBy = alias1 + ".startdate asc";
				break;
			case 2:
				orderBy = alias1 + ".startdate desc";
		}
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
	
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			if( isStartDate.booleanValue() ) {
				ps.setDate( j++, beginStartDate );
				ps.setDate( j++, endStartDate );
			}
			if( isWorker.booleanValue() )
				ps.setInt( j++, worker.intValue() );
			if( isTaskType.booleanValue() )
				ps.setString( j++, taskType );
		}   

		return ps;
}
/**
 * findBanksByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE2(
        java.lang.Boolean isTaskType, java.lang.String taskType,
        java.lang.Boolean isDocument, java.lang.Integer document,
        java.lang.Integer order) throws java.lang.Exception {
	
		//get generic query string 
		int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

		//getting aliases
		String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASETASKSSTARTS"));
    
    //calculate where clause
		StringBuffer whereClause = new StringBuffer( "1=1 " );
		if( isTaskType.booleanValue() )
			whereClause.append( "and tasktype = ? " );
		if( isDocument.booleanValue() )
			whereClause.append( "and document = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		  sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
		//append order by clause
		String orderBy = null;
		switch( order.intValue() ) {
			case 1:
				orderBy = alias1 + ".startdate asc";
				break;
			case 2:
				orderBy = alias1 + ".startdate desc";
		}
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
	
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			if( isTaskType.booleanValue() )
				ps.setString( j++, taskType );
			if( isDocument.booleanValue() )
				ps.setInt( j++, document.intValue() );
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
}
