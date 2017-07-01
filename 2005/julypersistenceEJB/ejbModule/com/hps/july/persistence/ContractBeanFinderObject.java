package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ContractBeanFinderObject extends DocumentBeanFinderObject 
implements ContractBeanFinderHelper{

/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findContractByQBE( Integer argSupplyType, Boolean isBaseAgreement, 
	Integer argBaseAgreement, Boolean isOrganization, Integer argOrganization, 
	Boolean isContragent, Integer argContragent, java.sql.Date argStartDate, java.sql.Date argFinishDate,
	Boolean isState, String argState, Integer order ) throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "t1.sypplytype = ? and t1.startdate >= ? and t1.startdate <= ? " );
	if( isBaseAgreement.booleanValue() )
		whereClause.append( "and t1.baseagreement = ? " );
	if( isOrganization.booleanValue() )
		whereClause.append( "and t2.owner = ? " );
	if( isContragent.booleanValue() )
		whereClause.append( "and t2.contragent = ? " );
	if( isState.booleanValue() )
		whereClause.append( "and t1.contractstate = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t1.startdate asc";
			break;
		case 2:
			orderBy = "t1.finishdate asc";
			break;
		case 3:
			orderBy = "t2.blankdate asc";
			break;
		case 4:
			orderBy = "t1.baseagreement asc";
			break;
		case 5:
			orderBy = "t2.blanknumber asc";
			break;
		case 6:
			orderBy = "t1.startdate desc";
			break;
		case 7:
			orderBy = "t1.finishdate desc";
			break;
		case 8:
			orderBy = "t2.blankdate desc";
			break;
		case 9:
			orderBy = "t1.baseagreement desc";
			break;
		case 10:
			orderBy = "t2.blanknumber desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argSupplyType.intValue() );
		ps.setDate( j++, argStartDate );	
		ps.setDate( j++, argFinishDate );	
		if( isBaseAgreement.booleanValue() )
			ps.setInt( j++, argBaseAgreement.intValue() );
		if( isOrganization.booleanValue() )
			ps.setInt( j++, argOrganization.intValue() );
		if( isContragent.booleanValue() )
			ps.setInt( j++, argContragent.intValue() );
		if( isState.booleanValue() )
			ps.setString( j++, argState );
	}   

	return ps;
}
/**
 * findContractByQBE2 method comment.
 */
public java.sql.PreparedStatement findContractByQBE2( java.lang.Boolean isSupplyType, java.lang.Integer sypplyType, 
	java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isContragent, java.lang.Integer contragent, 
	java.lang.String matchName, java.lang.Integer order) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "upper(t1.name) matches upper(?) " );
	if( isSupplyType.booleanValue() )
		whereClause.append( "and t1.sypplytype = ? " );
	if( isOwner.booleanValue() )
		whereClause.append( "and t2.owner = ? " );
	if( isContragent.booleanValue() )
		whereClause.append( "and t2.contragent = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t1.startdate asc";
			break;
		case 2:
			orderBy = "t1.finishdate asc";
			break;
		case 3:
			orderBy = "t2.blankdate asc";
			break;
		case 4:
			orderBy = "t1.baseagreement asc";
			break;
		case 5:
			orderBy = "t2.blanknumber asc";
			break;
		case 6:
			orderBy = "t1.startdate desc";
			break;
		case 7:
			orderBy = "t1.finishdate desc";
			break;
		case 8:
			orderBy = "t2.blankdate desc";
			break;
		case 9:
			orderBy = "t1.baseagreement desc";
			break;
		case 10:
			orderBy = "t2.blanknumber desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setString( j++, matchName );
		if( isSupplyType.booleanValue() )
			ps.setInt( j++, sypplyType.intValue() );
		if( isOwner.booleanValue() )
			ps.setInt( j++, owner.intValue() );
		if( isContragent.booleanValue() )
			ps.setInt( j++, contragent.intValue() );
	}   

	return ps;
}
/**
 * findContractByQBE3 method comment.
 */
public java.sql.PreparedStatement findContractByQBE3(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argBlankDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "t1.sypplytype = ? and t2.blankdate >= ? and t1.startdate <= ? " );
	if( isBaseAgreement.booleanValue() )
		whereClause.append( "and t1.baseagreement = ? " );
	if( isOrganization.booleanValue() )
		whereClause.append( "and t2.owner = ? " );
	if( isContragent.booleanValue() )
		whereClause.append( "and t2.contragent = ? " );
	if( isState.booleanValue() )
		whereClause.append( "and t1.contractstate = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t2.blankdate asc";
			break;
		case 2:
			orderBy = "t1.finishdate asc";
			break;
		case 3:
			orderBy = "t2.blankdate asc";
			break;
		case 4:
			orderBy = "t1.baseagreement asc";
			break;
		case 5:
			orderBy = "t2.blanknumber asc";
			break;
		case 6:
			orderBy = "t2.blankdate desc";
			break;
		case 7:
			orderBy = "t1.finishdate desc";
			break;
		case 8:
			orderBy = "t2.blankdate desc";
			break;
		case 9:
			orderBy = "t1.baseagreement desc";
			break;
		case 10:
			orderBy = "t2.blanknumber desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argSupplyType.intValue() );
		ps.setDate( j++, argBlankDate );	
		ps.setDate( j++, argFinishDate );	
		if( isBaseAgreement.booleanValue() )
			ps.setInt( j++, argBaseAgreement.intValue() );
		if( isOrganization.booleanValue() )
			ps.setInt( j++, argOrganization.intValue() );
		if( isContragent.booleanValue() )
			ps.setInt( j++, argContragent.intValue() );
		if( isState.booleanValue() )
			ps.setString( j++, argState );
	}   

	return ps;
}
}
