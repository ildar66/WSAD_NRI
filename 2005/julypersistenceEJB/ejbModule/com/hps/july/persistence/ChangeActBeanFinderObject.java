package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ChangeActBeanFinderObject extends DocumentBeanFinderObject 
implements ChangeActBeanFinderHelper{

	private static java.util.Map aliasMap;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isDate, 							java.sql.Date datefrom, java.sql.Date dateto,
	java.lang.Boolean isOwner, 							java.lang.Integer owner, 
	java.lang.Boolean isContragent, 				java.lang.Integer contragent, 
	java.lang.Boolean isExpeditor, 					java.lang.Integer expeditor, 
	java.lang.Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());

  //alias
  String alias = (String)(getAliasMap(sb.toString()).get("DOCUMENTS"));
    
  //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isDate.booleanValue() )
		whereClause.append( "and "+alias+".blankdate >= ? and "+alias+".blankdate <= ? " ); 
	if( isOwner.booleanValue() )
		whereClause.append( "and "+alias+".owner = ? " );
	if( isContragent.booleanValue() )
		whereClause.append( "and exists(select e.* from expedition e where e.expedition="+
			alias+".to and e.organization=?)" );
	if( isExpeditor.booleanValue() )
		whereClause.append( "and exists(select e.* from expedition e where e.expedition="+
			alias+".to and e.expeditor=?)" );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = alias+".blankindex asc";
			break;
		case 2:
			orderBy = alias+".blankindex desc";
			break;
		case 3:
			orderBy = alias+".blankdate asc, " + alias+".blankindex asc";
			break;
		case 4:
			orderBy = alias+".blankdate desc, " + alias+".blankindex asc";
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
		if( isOwner.booleanValue() )
			ps.setInt( j++, owner.intValue() );
		if( isContragent.booleanValue() )
			ps.setInt( j++, contragent.intValue() );
		if( isExpeditor.booleanValue() )
			ps.setInt( j++, expeditor.intValue() );
	}   

	return ps;
}
/**
 * findByQBEPosition method comment.
 */
public java.sql.PreparedStatement findByQBEPosition(
	java.lang.Boolean isDate, 							java.sql.Date datefrom, java.sql.Date dateto, 
	java.lang.Boolean isOwner, 							java.lang.Integer owner,
	Character requestType,
	java.lang.Boolean isPosition, 					java.lang.Integer position, 
	java.lang.Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());

  //alias
  String alias = (String)(getAliasMap(sb.toString()).get("DOCUMENTS"));
    
  //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isDate.booleanValue() )
		whereClause.append( "and "+alias+".blankdate >= ? and "+alias+".blankdate <= ? " ); 
	if( isOwner.booleanValue() )
		whereClause.append( "and "+alias+".owner = ? " );
	if( isPosition.booleanValue() ) {
		if( requestType.charValue() == 'P' )
			whereClause.append( "and "+alias+".from in (select e.equipment from equipment e where e.position = ?) " );
		else if( requestType.charValue() == 'S' )
			whereClause.append( "and "+alias+".from in (select s.storageplace from storages s where s.storageplace = ?) " );
		else if( requestType.charValue() == 'E' )
			whereClause.append( "and "+alias+".from in (select e.expedition from expedition e where e.expedition = ?) " );
	} else {
		if( requestType.charValue() == 'P' )
			whereClause.append( "and exists  (select e.equipment from equipment e where e.equipment = "+alias+".from) " );
		else if( requestType.charValue() == 'S' )
			whereClause.append( "and exists (select s.storageplace from storages s where s.storageplace = "+alias+".from) " );
		else if( requestType.charValue() == 'E' )
			whereClause.append( "and exists (select e.expedition from expedition e where e.expedition = "+alias+".from ) " );
	}
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = alias+".blankindex asc";
			break;
		case 2:
			orderBy = alias+".blankindex desc";
			break;
		case 3:
			orderBy = alias+".blankdate asc, " + alias+".blankindex asc";
			break;
		case 4:
			orderBy = alias+".blankdate desc, " + alias+".blankindex asc";
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
		if( isOwner.booleanValue() )
			ps.setInt( j++, owner.intValue() );
		if( isPosition.booleanValue() )
			ps.setInt( j++, position.intValue() );
	}   

	return ps;
}
/**
 * findByQBEPosition method comment.
 */
public java.sql.PreparedStatement findByQBEPosition2(Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto,
    Boolean isOwner, Integer owner,
    Character requestType,
    Boolean isPosition, Integer position,
    Character acttype,
    Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());

  //alias
  String alias = (String)(getAliasMap(sb.toString()).get("DOCUMENTS"));
  String alias1 = (String)(getAliasMap(sb.toString()).get("CHANGEACT"));
    
  //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if (acttype.equals(new Character('C')))
		whereClause.append( "AND acttype = 'C' " ); 
	else if (acttype.equals(new Character('U')))
		whereClause.append( "AND acttype = 'U' " ); 
	if( isDate.booleanValue() )
		whereClause.append( "and "+alias+".blankdate >= ? and "+alias+".blankdate <= ? " ); 
	if( isOwner.booleanValue() )
		whereClause.append( "and "+alias+".owner = ? " );
	if( isPosition.booleanValue() ) {
		if( requestType.charValue() == 'P' )
			whereClause.append( "and "+alias+".from in (select e.equipment from equipment e where e.position = ?) " );
		else if( requestType.charValue() == 'S' )
			whereClause.append( "and "+alias+".from in (select s.storageplace from storages s where s.storageplace = ?) " );
		else if( requestType.charValue() == 'E' )
			whereClause.append( "and "+alias+".from in (select e.expedition from expedition e where e.expedition = ?) " );
	} else {
		if( requestType.charValue() == 'P' )
			whereClause.append( "and exists  (select e.equipment from equipment e where e.equipment = "+alias+".from) " );
		else if( requestType.charValue() == 'S' )
			whereClause.append( "and exists (select s.storageplace from storages s where s.storageplace = "+alias+".from) " );
		else if( requestType.charValue() == 'E' )
			whereClause.append( "and exists (select e.expedition from expedition e where e.expedition = "+alias+".from ) " );
	}
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = alias+".blankindex asc";
			break;
		case 2:
			orderBy = alias+".blankindex desc";
			break;
		case 3:
			orderBy = alias+".blankdate asc, " + alias+".blankindex asc";
			break;
		case 4:
			orderBy = alias+".blankdate desc, " + alias+".blankindex asc";
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
		if( isOwner.booleanValue() )
			ps.setInt( j++, owner.intValue() );
		if( isPosition.booleanValue() )
			ps.setInt( j++, position.intValue() );
	}   

	return ps;
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
 * Creation date: (03.07.2002 13:55:23)
 * @param newAliasMap java.util.Map
 */
public void setAliasMap(java.util.Map newAliasMap) {
	aliasMap = newAliasMap;
}
}
