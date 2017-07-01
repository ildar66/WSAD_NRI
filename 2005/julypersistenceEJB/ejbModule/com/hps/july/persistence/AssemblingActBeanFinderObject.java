package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class AssemblingActBeanFinderObject extends DocumentBeanFinderObject  
	implements AssemblingActBeanFinderHelper{
	private static int blankIdx;
	private static int blankdateIdx;
	private static java.util.Map aliasMap;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.sql.Date startDate, 				java.sql.Date endDate, 
	java.lang.Boolean isOrganization, 		java.lang.Integer organization, 
	java.lang.Boolean isStorage, 			java.lang.Integer storage, 
	java.lang.Boolean isOperationType, 		java.lang.String operationType, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias1 = (String)(m.get("DOCUMENTS"));
    String alias2 = (String)(m.get("ASEMBLINGACTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias1+".blankdate >= ? and "+alias1+".blankdate <= ? " );
	if( isOrganization.booleanValue() )
		whereClause.append( "and "+alias1+".owner=? " );
	if( isStorage.booleanValue() )
		whereClause.append( "and "+alias1+".from = ? " );
	else
		whereClause.append( "and exists (select s.storageplace from storages s where s.storageplace="+alias1+".from )" );
	if( isOperationType.booleanValue() )
		whereClause.append( "and "+alias2+".operationtype = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getBlankIdx(sb.toString(),alias1)+" asc";
			break;
		case 2:
			orderBy = getBlankIdx(sb.toString(),alias1)+" desc";
			break;
		case 3:
			orderBy = getBlankdateIdx(sb.toString(),alias1)+" asc," + getBlankIdx(sb.toString(),alias1)+" asc";
			break;
		case 4:
			orderBy = getBlankdateIdx(sb.toString(),alias1)+" desc, " + getBlankIdx(sb.toString(),alias1)+" asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setDate( j++, startDate );
		ps.setDate( j++, endDate );
		if( isOrganization.booleanValue() )
			ps.setInt( j++, organization.intValue() );
		if( isStorage.booleanValue() )
			ps.setInt( j++, storage.intValue() );
		if( isOperationType.booleanValue() )
			ps.setString( j++, operationType );
		}
	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE2(
	java.sql.Date startDate, 							java.sql.Date endDate, 
	java.lang.Boolean isOrganization, 		java.lang.Integer organization, 
	java.lang.Boolean isPosition, 				java.lang.Integer position, 
	java.lang.Boolean isOperationType, 		java.lang.String operationType, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias1 = (String)(m.get("DOCUMENTS"));
    String alias2 = (String)(m.get("ASEMBLINGACTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias1+".blankdate >= ? and "+alias1+".blankdate <= ? " );
	if( isOrganization.booleanValue() )
		whereClause.append( "and "+alias1+".owner=? " );
	if( isPosition.booleanValue() )
		if( isOperationType.booleanValue() ) {
			if( operationType.equals("A") ) {
				whereClause.append( "and exists (select e.* from equipment e where e.equipment = "+alias1+".to and e.position = ? )" );
			} else {
				whereClause.append( "and exists (select e.* from equipment e where e.equipment = "+alias1+".from and e.position = ? )" );
			}
		} else {
		}
	else
		whereClause.append( "and ( "+alias2+".operationtype=\"A\" and "+
			"exists (select e.expedition from expedition e where e.expedition="+alias1+".from) and "+
			"exists (select q.equipment from equipment q where q.equipment = "+alias1+".to ) or "+alias2+".operationtype = \"D\" and "+
			"exists (select q.equipment from equipment q where q.equipment = "+alias1+".from ) and "+
			"exists (select e.expedition from expedition e where e.expedition="+alias1+".to) )" );
	if( isOperationType.booleanValue() )
		whereClause.append( "and "+alias2+".operationtype = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getBlankIdx(sb.toString(),alias1)+" asc";
			break;
		case 2:
			orderBy = getBlankIdx(sb.toString(),alias1)+" desc";
			break;
		case 3:
			orderBy = getBlankdateIdx(sb.toString(),alias1)+" asc," + getBlankIdx(sb.toString(),alias1)+" asc";
			break;
		case 4:
			orderBy = getBlankdateIdx(sb.toString(),alias1)+" desc, " + getBlankIdx(sb.toString(),alias1)+" asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setDate( j++, startDate );
		ps.setDate( j++, endDate );
		if( isOrganization.booleanValue() )
			ps.setInt( j++, organization.intValue() );
		if( isPosition.booleanValue() && isOperationType.booleanValue() )
			ps.setInt( j++, position.intValue() );
		if( isOperationType.booleanValue() )
			ps.setString( j++, operationType );
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
public static int getBlankdateIdx( String statement,String alias ) {
	if( blankdateIdx <= 0 ) {
		blankdateIdx = PersistenceUtil.getFieldIndex( statement, alias+".blankdate" );
	}
	return blankdateIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:39:22)
 * @return int
 */
public static int getBlankIdx( String statement,String alias ) {
	if( blankIdx <= 0 ) {
		blankIdx = PersistenceUtil.getFieldIndex( statement, alias+".blankindex" );
	}
	return blankIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:06:36)
 * @param newAliasMap java.util.Map
 */
public static void setAliasMap(java.util.Map newAliasMap) {
	aliasMap = newAliasMap;
}
}
