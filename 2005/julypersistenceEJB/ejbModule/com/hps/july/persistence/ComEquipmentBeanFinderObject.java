package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ComEquipmentBeanFinderObject extends 
EquipmentSetBeanFinderObject  implements ComEquipmentBeanFinderHelper{
	private static java.util.HashMap aliasMap;
	private static java.lang.String numberOrder;
public PreparedStatement findByPositionType(Integer argPosition, String argType, Integer argOrder)
 throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "EQUIPMENT");
    String alias1 = getAlias(sb.toString(), "COMEQUIPMENT");
    String alias2 = getAlias(sb.toString(), "STORAGEPLACES");
    
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias + ".position = ? AND " + alias1 + ".type = ? " );
	
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( argOrder.intValue() ) {
		case 1:
			orderBy = getNumberOrder(sb.toString(), alias2) + " asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argPosition.intValue() );			
		ps.setString( j++, argType );			
	}

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 14:31:31)
 * @return java.util.HashMap
 */
public static java.util.HashMap getAliasMap(String statement) {
	if( aliasMap == null ) { 
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 14:07:52)
 * @return java.lang.String
 */
public static java.lang.String getNumberOrder(String statement, String alias ) {
	if( numberOrder == null ) { 
		numberOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".storageplace" ) );
	}
	return numberOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 14:31:31)
 * @param newAliasMap java.util.HashMap
 */
public static void setAliasMap(java.util.HashMap newAliasMap) {
	aliasMap = newAliasMap; 
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
