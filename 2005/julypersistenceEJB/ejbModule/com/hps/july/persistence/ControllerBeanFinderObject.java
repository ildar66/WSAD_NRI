package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ControllerBeanFinderObject extends EquipmentSetBeanFinderObject 
implements ControllerBeanFinderHelper{

	private static java.util.HashMap aliasMap;
	private static java.lang.String controllerAlias;
	private static java.lang.String storageplaceOrder;
	private static java.lang.String nameOrder;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isNumber, java.lang.Integer argNumber, 
	java.lang.Boolean isName, 	java.lang.String argName, 
	java.lang.Boolean isSwitch, java.lang.Integer argSwitch, 
	java.lang.Integer order) throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getControllerAlias(sb.toString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isNumber.booleanValue() )
		whereClause.append( "and "+alias+".number = ? " );
	if( isName.booleanValue() )
		whereClause.append( "and upper("+alias+".name) matches upper(?) " );
	if( isSwitch.booleanValue() )
		whereClause.append( "and "+alias+".switch = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

	//append order by clause
	String orderBy = null;
	String storageplacesAlias = (String)(getAliasMap(sb.toString()).get("STORAGEPLACES"));
	switch( order.intValue() ) {
		case 1:
			orderBy = getStorageplaceOrder(sb.toString(),storageplacesAlias)+" asc"; //storageplace
			break;
		case 2:
			orderBy = getStorageplaceOrder(sb.toString(),storageplacesAlias)+" desc";
			break;
		case 3:
			orderBy = getNameOrder(sb.toString(),alias)+" asc"; //name
			break;
		case 4:
			orderBy = getNameOrder(sb.toString(),alias)+" desc";
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
	if( isName.booleanValue() )
		ps.setString( j++, argName );
	if( isSwitch.booleanValue() )
		ps.setInt( j++, argSwitch.intValue() );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 12:30:47)
 * @return java.lang.String
 */
public java.lang.String getControllerAlias() {
	return controllerAlias;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 12:30:47)
 * @return java.lang.String
 */
public java.lang.String getControllerAlias( String statement ) {
	if( controllerAlias == null ) { 
		controllerAlias = (String)(getAliasMap(statement).get("CONTROLLERS"));
	}
	return controllerAlias;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 12:33:32)
 * @return java.lang.String
 */
public static java.lang.String getNameOrder( String statement, String alias ) {
	if( nameOrder == null ) {
		nameOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".name" ) );
	}
	return nameOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 12:33:14)
 * @return java.lang.String
 */
public static java.lang.String getStorageplaceOrder(String statement, String alias ) {
	if( storageplaceOrder == null ) {
		storageplaceOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".storageplace" ) );
	}
	return storageplaceOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 12:30:47)
 * @param newControllerAlias java.lang.String
 */
public void setControllerAlias(java.lang.String newControllerAlias) {
	controllerAlias = newControllerAlias;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 12:33:32)
 * @param newNameOrder java.lang.String
 */
public static void setNameOrder(java.lang.String newNameOrder) {
	nameOrder = newNameOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 12:33:14)
 * @param newStorageplaceOrder java.lang.String
 */
public static void setStorageplaceOrder(java.lang.String newStorageplaceOrder) {
	storageplaceOrder = newStorageplaceOrder;
}
}
