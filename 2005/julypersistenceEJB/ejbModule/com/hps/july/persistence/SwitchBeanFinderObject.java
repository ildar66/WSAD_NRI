package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class SwitchBeanFinderObject extends EquipmentSetBeanFinderObject 
implements SwitchBeanFinderHelper{

	private static java.util.HashMap aliasesMap;
	private static java.lang.String numberOrder;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isNumber, 	java.lang.Integer argNumber, 
	java.lang.Boolean isType, 		java.lang.String argType, 
	java.lang.Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
	String alias = getAlias( sb.toString(), "SWITCHES" );
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isNumber.booleanValue() )
		whereClause.append( "and "+alias+".number = ? " );
	if( isType.booleanValue() )
		whereClause.append( "and "+alias+".type = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getNumberOrder(sb.toString(), alias)+" asc";
			break;
		case 2:
			orderBy = getNumberOrder(sb.toString(), alias)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
	if( isNumber.booleanValue() )
		ps.setInt( j++, argNumber.intValue() );
	if( isType.booleanValue() )
		ps.setString( j++, argType );
	}   

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE2(
	java.lang.Boolean isNumber, 	java.lang.Integer argNumber, 
	java.lang.Boolean isType, 		java.lang.String argType, 
	Boolean isPlanState, String argPlanState,
	java.lang.Integer order) throws java.lang.Exception {
		
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
	String alias = getAlias( sb.toString(), "SWITCHES" );
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isNumber.booleanValue() )
		whereClause.append( "and "+alias+".number = ? " );
	if( isType.booleanValue() )
		whereClause.append( "and "+alias+".type = ? " );
	if (isPlanState.booleanValue())
		whereClause.append( "and EXISTS (SELECT e.equipment FROM equipment e, positions p WHERE " +
			"p.storageplace = e.position AND p.planstate = ? AND e.equipment = " + alias + ".equipment)  " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getNumberOrder(sb.toString(), alias)+" asc";
			break;
		case 2:
			orderBy = getNumberOrder(sb.toString(), alias)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isNumber.booleanValue() )
			ps.setInt( j++, argNumber.intValue() );
		if( isType.booleanValue() )
			ps.setString( j++, argType );
		if (isPlanState.booleanValue())
			ps.setString( j++, argPlanState );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 13:57:29)
 * @return java.lang.String
 * @param statement java.lang.String
 * @param alias java.lang.String
 */
public String getAlias(String statement, String alias) {
	return (String)(getAliasesMap(statement).get(alias.toUpperCase()));
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 13:54:06)
 * @return java.util.HashMap
 */
public java.util.HashMap getAliasesMap(String statement) {
	if( aliasesMap == null ) {
		aliasesMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasesMap;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 14:07:52)
 * @return java.lang.String
 */
public static java.lang.String getNumberOrder(String statement, String alias ) {
	if( numberOrder == null ) {
		numberOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".number" ) );
	}
	return numberOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 13:54:06)
 * @param newAliasesMap java.util.HashMap
 */
public void setAliasesMap(java.util.HashMap newAliasesMap) {
	aliasesMap = newAliasesMap;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 14:07:52)
 * @param newNumberOrder java.lang.String
 */
public static void setNumberOrder(java.lang.String newNumberOrder) {
	numberOrder = newNumberOrder;
}
}
