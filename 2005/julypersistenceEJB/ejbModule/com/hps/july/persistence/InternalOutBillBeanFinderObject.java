package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class InternalOutBillBeanFinderObject extends DocumentBeanFinderObject 
implements InternalOutBillBeanFinderHelper{

	private static int blankIdx;
	private static int blankDateIdx;
	private static java.util.Map aliasMap;
	private static java.lang.String alias1;
	private static java.lang.String alias2;
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByQBE2(
	java.lang.Boolean isDate, 							java.sql.Date datefrom, java.sql.Date dateto, 
	java.lang.Boolean isOwner, 							java.lang.Integer owner, 
	java.lang.Boolean isPosition, 					java.lang.Integer position, 
	java.lang.Boolean isProvider, 					java.lang.Integer provider, 
	java.lang.Boolean isWorker, 						java.lang.Integer worker, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  java.util.Map m = getAliasMap(sb.toString());
  String alias1 = (String)(m.get("INTERNALOUTBILL"));
  String alias2 = (String)(m.get("DOCUMENTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias2 + ".showtouser = 'Y' AND exists (select e.equipment from equipment e where e.equipment="+
		alias2+".from )  " );
	if( isDate.booleanValue() ) {
		whereClause.append( "and "+alias2+".blankdate >= ? and "+alias2+".blankdate <= ? " );
	}
	if( isOwner.booleanValue() ) {
		whereClause.append( "and "+alias2+".owner = ? " );
	}
	if( isPosition.booleanValue() ) {
		whereClause.append( "and "+alias2+".from in (select e.equipment from equipment e where position = ?) " );
	}
	if( isProvider.booleanValue() ) {
		whereClause.append( "and exists (select e.* from expedition e where e.expedition="+alias2+".to and e.organization=?) " );
	}
	if( isWorker.booleanValue() ) {
		whereClause.append( "and exists (select e.* from expedition e where e.expedition="+alias2+".to and e.expeditor=?) " );
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
 * findInternalOutBillByQBE method comment.
 */
public java.sql.PreparedStatement findInternalOutBillByQBE(
	java.lang.Boolean isDate, 			java.sql.Date dateFrom, java.sql.Date dateTo, 
	java.lang.Boolean isOwner, 			java.lang.Integer owner, 
	java.lang.Boolean isStorage, 		java.lang.Integer storage, 
	java.lang.Boolean isContragent, 	java.lang.Integer contragent, 
	java.lang.Boolean isWorker, 		java.lang.Integer worker, 
	java.lang.Integer order) throws java.lang.Exception {

	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( getAlias1(sb.toString())+".showtouser = 'Y' AND " +
		" exists (select s.storageplace from storages s where s.storageplace="+
		getAlias1(sb.toString())+".from )  " );
	if( isDate.booleanValue() )
		whereClause.append( "and "+getAlias1(sb.toString())+".blankdate >= ? and "+
			getAlias1(sb.toString())+".blankdate <= ? " ); 
	if( isOwner.booleanValue() )
		whereClause.append( "and "+getAlias1(sb.toString())+".owner = ? " );
	if( isStorage.booleanValue() )
		whereClause.append( "and "+getAlias1(sb.toString())+".from = ? " );
	if( isContragent.booleanValue() )
		whereClause.append( "and exists(select e.* from expedition e where e.expedition="+
			getAlias1(sb.toString())+".to and e.organization=?)" );
	if( isWorker.booleanValue() )
		whereClause.append( "and exists(select e.* from expedition e where e.expedition="+
			getAlias1(sb.toString())+".to and e.expeditor=?)" );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getAlias1(sb.toString())+".blankindex asc";
			break;
		case 2:
			orderBy = getAlias1(sb.toString())+".blankindex desc";
			break;
		case 3:
			orderBy = getAlias1(sb.toString())+".blankdate asc, " + getAlias1(sb.toString())+".blankindex asc";
			break;
		case 4:
			orderBy = getAlias1(sb.toString())+".blankdate desc, " + getAlias1(sb.toString())+".blankindex asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isDate.booleanValue() ) {
			ps.setDate( j++, dateFrom );
			ps.setDate( j++, dateTo );
		}
		if( isOwner.booleanValue() )
			ps.setInt( j++, owner.intValue() );
		if( isStorage.booleanValue() )
			ps.setInt( j++, storage.intValue() );
		if( isContragent.booleanValue() )
			ps.setInt( j++, contragent.intValue() );
		if( isWorker.booleanValue() )
			ps.setInt( j++, worker.intValue() );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:57:57)
 * @return java.lang.String
 */
public java.lang.String getAlias1( String statement ) {
	if( alias1 == null ) {
		alias1 = (String)(getAliasMap(statement).get("DOCUMENTS"));
	}
	return alias1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:58:18)
 * @return java.lang.String
 */
public static java.lang.String getAlias2() {
	return alias2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:58:18)
 * @return java.lang.String
 */
public java.lang.String getAlias2(String statement) {
	if( alias2 == null ) {
		alias2 = (String)(getAliasMap(statement).get("INTERNALOUTBILL"));
	}
	return alias2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:55:23)
 * @return java.util.Map
 */
public java.util.Map getAliasMap( String statement ) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
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
 * Creation date: (03.07.2002 13:57:57)
 * @param newAlias1 java.lang.String
 */
public static void setAlias1(java.lang.String newAlias1) {
	alias1 = newAlias1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:58:18)
 * @param newAlias2 java.lang.String
 */
public static void setAlias2(java.lang.String newAlias2) {
	alias2 = newAlias2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:55:23)
 * @param newAliasMap java.util.Map
 */
public void setAliasMap(java.util.Map newAliasMap) {
	aliasMap = newAliasMap;
}
}
