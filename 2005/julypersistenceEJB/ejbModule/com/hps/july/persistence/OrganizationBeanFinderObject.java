package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class OrganizationBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements OrganizationBeanFinderHelper{

/**
 * findBanksByQBE method comment.
 */
public java.sql.PreparedStatement findBanksByQBE(java.lang.Boolean isName, java.lang.String argName, 
	java.lang.Boolean isBic, java.lang.String argBic, java.lang.Integer order) throws java.lang.Exception {
	
		//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "t1.isbank=\"Y\" " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(t1.name) matches upper(?) " );
	if( isBic.booleanValue() )
		whereClause.append( "and upper(t1.bik) matches upper(?) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t1.name asc";
			break;
		case 2:
			orderBy = "t1.name desc";
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
	if( isName.booleanValue() )
		ps.setString( j++, argName );
	if( isBic.booleanValue() )
		ps.setString( j++, argBic );
	}   

	return ps;
}

/**
 * findOrganizationsButBanksByCompanyAndGroup method comment.
 */
public java.sql.PreparedStatement findOrganizationsButBanksByCompanyAndGroup(
	java.lang.Integer argCompany, java.lang.Boolean isGroup, 
	java.lang.Integer searchgroup, java.lang.Integer searchGroupping) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "company = ? and isbank = \"N\" " );
	if( isGroup.booleanValue() ) 
		whereClause.append( 
			"and exists (select s.* from searches s where s.searchgroup = ? and "+
			"s.searchgroupping = ? and s.organization = t1.organization) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argCompany.intValue() );
		if( isGroup.booleanValue() ) {
			ps.setInt( j++, searchgroup.intValue() );
			ps.setInt( j++, searchGroupping.intValue() );
		}
	}   

	return ps;
}

/**
 * findOrganizationsByNameOrderByNameAsc method comment.
 */
public java.sql.PreparedStatement findOrganizationsByNameOrderByNameAsc(java.lang.String name, 
	java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "upper(t1.name) matches upper(?)  " );
	if( argIsSupplier.booleanValue() )
		whereClause.append( "and t1.issupplier = \"Y\" " );
	if( argIsProvider.booleanValue() )
		whereClause.append( "and t1.isprovider = \"Y\" " );
	if( argIsRenter.booleanValue() )
		whereClause.append( "and t1.isrenter = \"Y\" " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = "t1.name asc";
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setString( j++, name );
	}   

	return ps;
}

/**
 * findOrganizationsByQBE method comment.
 */
public java.sql.PreparedStatement findOrganizationsByQBE(java.lang.Boolean isName, java.lang.String argName, 
	java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, 
	java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "t1.isbank = \"N\" " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(t1.name) matches upper(?) " );
	if( isSupplier.booleanValue() )
		whereClause.append( "and t1.issupplier = \"Y\" " );
	if( isProvider.booleanValue() )
		whereClause.append( "and t1.isprovider = \"Y\" " );
	if( isRenter.booleanValue() )
		whereClause.append( "and t1.isrenter = \"Y\" " );
	if( isInn.booleanValue() )
		whereClause.append( "and upper(t1.inn) matches upper(?) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = "t1.name asc";
	switch( order.intValue() ) {
		case 1:
			orderBy = "t1.name asc";
			break;	
		case 2:
			orderBy = "t1.name desc";
			break;	
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
	if( isName.booleanValue() )
		ps.setString( j++, argName );
	if( isInn.booleanValue() )
		ps.setString( j++, argInn );
	}   

	return ps;
}

/**
 * findOrganizationsByQBE method comment.
 */
public java.sql.PreparedStatement findOrganizationsByQBE2( Boolean isHaveBans, 
	Boolean isRenter, 
	Boolean isName, String argName, 
	Boolean isInn, String argInn, Boolean isBan, Integer ban, Integer order ) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "isbank = \"N\" " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(name) matches upper(?) " );
	if( isRenter.booleanValue() )
		whereClause.append( "and isrenter = \"Y\" " );
	if( isInn.booleanValue() )
		whereClause.append( "and upper(inn) matches upper(?) " );
	if( isBan.booleanValue() )
		whereClause.append( "and exists (SELECT ban FROM leasebans l WHERE l.organization = t1.organization AND l.ban=?)  " );
	if( isHaveBans.booleanValue() )
		whereClause.append( "and exists (SELECT ban FROM leasebans l WHERE l.organization = t1.organization) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = "t1.name asc";
	switch( order.intValue() ) {
		case 1:
			orderBy = "inn asc";
			break;	
		case 2:
			orderBy = "inn desc";
			break;	
		case 3:
			orderBy = "name asc";
			break;	
		case 4:
			orderBy = "name desc";
			break;	
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isName.booleanValue() )
			ps.setString( j++, argName );
		if( isInn.booleanValue() )
			ps.setString( j++, argInn );
		if( isBan.booleanValue() )
			ps.setInt( j++, ban.intValue());
	}   

	return ps;
}

/**
 * findOrganizationsByQBEAndGroup method comment.
 */
public java.sql.PreparedStatement findOrganizationsByQBEAndGroup(java.lang.Boolean isName, 
	java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, 
	java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order, 
	java.lang.Boolean isGroup, java.lang.Integer group, java.lang.Integer groupping) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "t1.isbank = \"N\" " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(t1.name) matches upper(?) " );
	if( isSupplier.booleanValue() )
		whereClause.append( "and t1.issupplier = \"Y\" " );
	if( isProvider.booleanValue() )
		whereClause.append( "and t1.isprovider = \"Y\" " );
	if( isRenter.booleanValue() )
		whereClause.append( "and t1.isrenter = \"Y\" " );
	if( isInn.booleanValue() )
		whereClause.append( "and upper(t1.inn) matches upper(?) " );
	if( isGroup.booleanValue() )
		whereClause.append( 
			"and exists (select s.* from searches s where s.searchgroup = ? and "+
			"s.searchgroupping = ? and s.organization = t1.organization) " );
		
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = "t1.name asc";
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isName.booleanValue() )
			ps.setString( j++, argName );
		if( isInn.booleanValue() )
			ps.setString( j++, argInn );
		if( isGroup.booleanValue() ) {
			ps.setInt( j++, group.intValue() );
			ps.setInt( j++, groupping.intValue() );
		}
	}   

	return ps;
}
}
