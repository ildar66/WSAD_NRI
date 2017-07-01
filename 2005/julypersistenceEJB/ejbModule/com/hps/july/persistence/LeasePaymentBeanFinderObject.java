package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeasePaymentBeanFinderObject extends LeaseDocPositionBeanFinderObject  
	implements LeasePaymentBeanFinderHelper{
	private static int dateIdx;
	private static java.util.Map aliasMap;		
		
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByQBE2(
	java.lang.Integer leaseRule, 
	java.sql.Date startDate, 				java.sql.Date finishDate, 
	java.lang.Boolean isSource, 		java.lang.String source
	) throws java.lang.Exception {
		
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  java.util.Map m = getAliasMap(sb.toString());
  String alias1 = (String)(m.get("LEASEDOCPOSITIONS"));
  String alias2 = (String)(m.get("LEASEPAYMENTS"));
    
  //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias2+".leaserule = ? and "+
		alias1+".date >= ? and "+alias1+".date <= ? " );
	if( isSource.booleanValue() )
		whereClause.append( "and "+alias1+".source = ? " );
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }

    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, leaseRule.intValue() );
		ps.setDate( j++, startDate );
		ps.setDate( j++, finishDate );
		if( isSource.booleanValue() )
			ps.setString( j++, source );
	}   

	return ps;
}
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByQBE3(Integer leaseContract, Integer resource, 
	java.sql.Date startInterval, java.sql.Date finishInterval) throws java.lang.Exception {
		
	  //get generic query string 
	  int i;
	  int[] genericFindInsertPoints = getGenericFindInsertPoints();
	  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	  //get documents alias
	  java.util.Map m = getAliasMap(sb.toString());
	  String alias1 = (String)(m.get("LEASEDOCPOSITIONS"));
	  String alias2 = (String)(m.get("LEASEPAYMENTS"));
    
      //calculate where clause
	  StringBuffer whereClause = new StringBuffer( alias1+".leasecontract = ? AND " + alias1 + ".resource = ? AND ( "+
		" ( " + alias1+".begindate >= ? AND "+alias1+".begindate <= ? ) OR " + 
		" ( " + alias1+".enddate >= ? AND "+alias1+".enddate <= ? ) OR " + 
		" ( " + alias1+".begindate <= ? AND "+alias1+".enddate >= ? ) ) AND " + 
		"(" + alias1+".docposvid = 'N' OR " + alias1+".docposvid = 'C')");
    
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, leaseContract.intValue() );
		ps.setInt( j++, resource.intValue() );
		ps.setDate( j++, startInterval );
		ps.setDate( j++, finishInterval );
		ps.setDate( j++, startInterval );
		ps.setDate( j++, finishInterval );
		ps.setDate( j++, startInterval );
		ps.setDate( j++, finishInterval );
	}   

	return ps;
}
/**
 * findByQBE4 method comment.
 */
public java.sql.PreparedStatement findByQBE4(
        Integer contract, 
        Boolean isStartDate, java.sql.Date actStartDate, 
        Boolean isEndDate, java.sql.Date actEndDate,
        Boolean isRemainder, java.math.BigDecimal remainder,
        Boolean isResource, Integer resource,
        Boolean isCalcPosOnly,
        Boolean isAutoRUR, Boolean autoRUR) throws java.lang.Exception {
			
	  //get generic query string 
	  int i;
	  int[] genericFindInsertPoints = getGenericFindInsertPoints();
	  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	  //get documents alias
	  java.util.Map m = getAliasMap(sb.toString());
	  String alias1 = (String)(m.get("LEASEDOCPOSITIONS"));
	  String alias2 = (String)(m.get("LEASEPAYMENTS"));
	    
	  //calculate where clause
	  StringBuffer whereClause = new StringBuffer( alias1+".leasecontract = ? ");

	  if (isStartDate.booleanValue())
	  	whereClause = whereClause.append(" AND " + alias1 + ".date >= ? ");
	  if (isEndDate.booleanValue())
	  	whereClause = whereClause.append(" AND " + alias1 + ".date <= ? ");

	  if (isRemainder.booleanValue())
	  	whereClause = whereClause.append(" AND " + alias2 + ".rurremainder > ? ");
    
	  if (isResource.booleanValue())
	  	whereClause = whereClause.append(" AND " + alias1 + ".resource = ? ");
	  	
	  if (isCalcPosOnly.booleanValue())
	  	whereClause = whereClause.append(" AND " + alias1 + ".source = 'A' AND " +
		  	alias1 + ".docposvid IN ('Q', 'K', 'Z') ");

	  if (isAutoRUR.booleanValue())
	  	if (autoRUR.booleanValue())
	  		whereClause = whereClause.append(" AND " + alias2 + ".byautorur = 'Y' ");
		else
	  		whereClause = whereClause.append(" AND " + alias2 + ".byautorur = 'N' ");
	  	
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }

  //append order by clause
	String orderBy = null;
			orderBy =  getDateIdx(sb.toString(), alias1)+" asc";
	sb.append( " order by "+orderBy );

    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, contract.intValue() );
	    if (isStartDate.booleanValue())
		  ps.setDate( j++, actStartDate );
	    if (isEndDate.booleanValue())
		  ps.setDate( j++, actEndDate );
	    if (isRemainder.booleanValue())
		  ps.setBigDecimal( j++, remainder );
	    if (isResource.booleanValue())
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
