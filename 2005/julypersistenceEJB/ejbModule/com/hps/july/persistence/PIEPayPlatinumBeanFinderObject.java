package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class PIEPayPlatinumBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
implements PIEPayPlatinumBeanFinderHelper{
	private static java.util.Map aliasMap;
	private static int dateIdx;
/**
 * findByLeaseDocument method comment.
 */
public java.sql.PreparedStatement findByQBE(Boolean isDateStart, java.sql.Date argDateStart,
		Boolean isDateEnd, java.sql.Date argDateEnd, 
		Boolean isIdDogovNri, Integer argIdDogovNri, 
		Boolean isFlagWorkNri, String argFlagWorkNri, Integer order) throws java.lang.Exception {
			
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("PIE_PAYSPLATINUM"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );

	if (isDateStart.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".date >= ? ");
	if (isDateEnd.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".date <= ? ");
	if (isIdDogovNri.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".iddogovornri = ? ");
	if (isFlagWorkNri.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".flagworknri = ? ");
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy =  getDateIdx(sb.toString(),alias)+" asc";
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
		if (isDateStart.booleanValue())
			ps.setDate( j++, argDateStart );
		if (isDateEnd.booleanValue())
			ps.setDate( j++, argDateEnd );
		if (isIdDogovNri.booleanValue())
			ps.setInt( j++, argIdDogovNri.intValue() );
		if (isFlagWorkNri.booleanValue())
			ps.setString( j++, argFlagWorkNri );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:06:36)
 * @return java.util.Map
 */
public static java.util.Map getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 13:11:28)
 * @return int
 */
public static int getDateIdx( String statement, String alias ) {
	if( dateIdx <= 0 ) {
		dateIdx = PersistenceUtil.getFieldIndex( statement, alias+".date" );
	}
	return dateIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:06:36)
 * @param newAliasMap java.util.Map
 */
public static void setAliasMap(java.util.Map newAliasMap) {
	aliasMap = newAliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 13:11:28)
 * @param newLeaseRuleIdx int
 */
public static void setDateIdx(int newDateIdx) {
	dateIdx = newDateIdx;
}
}
