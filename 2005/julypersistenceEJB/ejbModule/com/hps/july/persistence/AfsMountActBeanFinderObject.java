package com.hps.july.persistence;

import java.sql.*;
public class AfsMountActBeanFinderObject extends InternalWayBillBeanFinderObject 
	implements AfsMountActBeanFinderHelper{
	private static java.util.Map aliasMap;
	private static int blankDateIdx;
	private static int blankIdx;
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByQBE2( 
	java.lang.Boolean isDate, 				java.sql.Date datefrom, java.sql.Date dateto, 
	java.lang.Boolean isOwner, 				java.lang.Integer owner, 
	java.lang.Boolean isPosition, 		java.lang.Integer position, 
	java.lang.Boolean isProvider, 		java.lang.Integer provider, 
	java.lang.Boolean isWorker, 			java.lang.Integer worker, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  java.util.Map m = getAliasMap(sb.toString());
  String alias1 = (String)(m.get("INTERNALWAYBILLS"));
  String alias2 = (String)(m.get("DOCUMENTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias2 + ".showtouser = 'Y' AND exists (select e.equipment from equipment e where e.equipment="+alias2+".to )  " +
		" AND " + alias2 + ".type='B' ");
	if( isDate.booleanValue() ) {
		whereClause.append( "and "+alias2+".blankdate >= ? and "+alias2+".blankdate <= ? " );
	}
	if( isOwner.booleanValue() ) {
		whereClause.append( "and "+alias2+".owner = ? " );
	}
	if( isPosition.booleanValue() ) {
		whereClause.append( "and "+alias2+".to in (select e.equipment from equipment e where position = ?) " );
	}
	if( isProvider.booleanValue() ) {
		whereClause.append( "and exists (select e.* from expedition e where e.expedition="+alias2+".from and e.organization=?) " );
	}
	if( isWorker.booleanValue() ) {
		whereClause.append( "and exists (select e.* from expedition e where e.expedition="+alias2+".from and e.expeditor=?) " );
	}
    
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getBlankIdx(sb.toString(),alias2)+" asc";
			break;
		case 2:
			orderBy = getBlankIdx(sb.toString(),alias2)+" desc";
			break;
		case 3:
			orderBy = getBlankDateIdx(sb.toString(),alias2)+" asc, "+getBlankIdx(sb.toString(),alias2)+" asc";
			break;
		case 4:
			orderBy = getBlankDateIdx(sb.toString(),alias2)+" desc, "+getBlankIdx(sb.toString(),alias2)+" asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1; 
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isDate.booleanValue() ) {
			ps.setDate( j++, datefrom );
			ps.setDate( j++, dateto );
		}
		if( isOwner.booleanValue() ) {
			ps.setInt( j++, owner.intValue() );
		}
		if( isPosition.booleanValue() ) {
			ps.setInt( j++, position.intValue() );
		}
		if( isProvider.booleanValue() ) {
			ps.setInt( j++, provider.intValue() );
		}
		if( isWorker.booleanValue() ) {
			ps.setInt( j++, worker.intValue() );
		}
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
public static int getBlankDateIdx(String statement, String alias) {
	if( blankDateIdx <= 0 ) { 
		blankDateIdx = PersistenceUtil.getFieldIndex( statement, alias+".blankdate" );
	}
	return blankDateIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:39:05)
 * @return int
 */
public static int getBlankIdx(String statement, String alias) {
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
