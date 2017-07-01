package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseMutualActNewBeanFinderObject extends LeaseDocumentBeanFinderObject  
	implements LeaseMutualActNewBeanFinderHelper{ 
	private static int dateIdx;
	private static java.util.Map aliasMap;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isMutualReglament, 			java.lang.Integer mutualReglament, 
	java.lang.Boolean isDate, 						java.sql.Date fromDate, 
	java.sql.Date toDate, 
	java.lang.Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  java.util.Map m = getAliasMap(sb.toString());
  String alias1 = (String)(m.get("LEASEDOCUMENTS"));
  String alias2 = (String)(m.get("LEASEMUTUALACTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isMutualReglament.booleanValue() )
		whereClause.append( "and "+alias2+".mutualreglament=? " );
	if( isDate.booleanValue() )
		whereClause.append( "and "+alias1+".docdate >= ? and "+alias1+".docdate <= ?" );
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = alias1+".docdate asc";
			break;
		case 2:
			orderBy = alias1+".docdate desc";
			break;
		case 3:
			orderBy = alias2+".actstartdate asc";
			break;
		case 4:
			orderBy = alias2+".actstartdate desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isMutualReglament.booleanValue() )
			ps.setInt( j++, mutualReglament.intValue() );
		if( isDate.booleanValue() ) {
			ps.setDate( j++, fromDate );
			ps.setDate( j++, toDate );
		}
	}   

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE2(
    Integer mutualReglament, 
    Boolean isEdit, 
    Boolean isRun, 
    Boolean isClose, 
    Integer order
) throws java.lang.Exception {
		
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  java.util.Map m = getAliasMap(sb.toString());
  String alias1 = (String)(m.get("LEASEDOCUMENTS"));
  String alias2 = (String)(m.get("LEASEMUTUALACTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias2+".mutualreglament=? " );
	if (isEdit.booleanValue() || isRun.booleanValue() || isClose.booleanValue())
		whereClause.append( " AND ( " );
	if( isEdit.booleanValue() )
		whereClause.append( alias2+".actstate='O' " );
	if( isRun.booleanValue() ) {
		if( isEdit.booleanValue() )
			whereClause.append( " OR " );
		
		whereClause.append( alias2+".actstate='R' " );
	}
	if( isClose.booleanValue() ) {
		if( isEdit.booleanValue() || isRun.booleanValue() )
			whereClause.append( " OR " );
		whereClause.append( alias2+".actstate='C' " );
	}
	if (isEdit.booleanValue() || isRun.booleanValue() || isClose.booleanValue())
		whereClause.append( " ) " );
    
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = alias2+".actenddate asc";
			break;
		case 2:
			orderBy = alias2+".actenddate desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, mutualReglament.intValue() );
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
 * Creation date: (01.07.2002 10:39:22)
 * @return int
 */
public static int getDateIdx( String statement,String alias ) {
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
}
