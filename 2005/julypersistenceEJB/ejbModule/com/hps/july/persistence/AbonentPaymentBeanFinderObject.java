package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class AbonentPaymentBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
implements AbonentPaymentBeanFinderHelper{
/**
 * findByPositions method comment.
 */
public java.sql.PreparedStatement findByDocumentQBE(Integer argDocument, 
		Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate,
		Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
	int[] genericFindInsertPoints = getGenericFindInsertPoints();
	StringBuffer sb = new StringBuffer(getGenericFindSqlString());

	//calculate where clause
	StringBuffer whereClause = new StringBuffer( "leasedocument=? " );
	if( isDatePeriod.booleanValue() )
		whereClause.append( "AND paydate >= ? AND paydate <= ? " );
  
    
	//and fill it by where clause
	for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	}
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argDocument.intValue() );
		if( isDatePeriod.booleanValue() ) {
			ps.setDate( j++, argStartDate );
			ps.setDate( j++, argEndDate );
		}
	}   

	return ps;
}
/**
 * findByPositions method comment.
 */
public java.sql.PreparedStatement findByDocumentQBE2(Integer argDocument, 
		Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate,
		Boolean isNeedPay, Boolean needPay,
		Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
	int[] genericFindInsertPoints = getGenericFindInsertPoints();
	StringBuffer sb = new StringBuffer(getGenericFindSqlString());

	//calculate where clause
	StringBuffer whereClause = new StringBuffer( "leasedocument=? " );
	if( isDatePeriod.booleanValue() )
		whereClause.append( "AND paydate >= ? AND paydate <= ? " );

	if (isNeedPay.booleanValue())
		if (needPay.booleanValue()) 
			whereClause.append( "AND needpay='Y' " );
		else
			whereClause.append( "AND needpay='N' " );
    
	//and fill it by where clause
	for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	}

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "paydate asc";
            break;
        case 2 :
            orderBy = "paydate desc";
            break;
    }
    sb.append(" order by " + orderBy);
		
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argDocument.intValue() );
		if( isDatePeriod.booleanValue() ) {
			ps.setDate( j++, argStartDate );
			ps.setDate( j++, argEndDate );
		}
	}   

	return ps;
}
}
