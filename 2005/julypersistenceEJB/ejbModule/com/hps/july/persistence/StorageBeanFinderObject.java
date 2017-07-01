package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class StorageBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  implements StorageBeanFinderHelper{
	private static java.util.HashMap aliasMap;
	private static java.lang.String numberOrder;
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findAllOrderByNameAsc() throws Exception {

	//get generic query string 
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    for (int i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], "1=1" );
    }

    sb.append( " order by 1 asc" );
	//System.out.println( "SQL clause="+sb );

	//fill prepared statement
	return getPreparedStatement( sb.toString() );
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findByPlatinumAndStatus(Integer owner, String state, Integer order) throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "STORAGES");
    String alias1 = getAlias(sb.toString(), "STORAGEPLACES");
    
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " 1=1 " );
	if( "2".equals(state) )
		whereClause.append( " AND NOT EXISTS (SELECT * FROM pie_mxranlink l WHERE l.mxrannri = " + alias +
			".storageplace AND l.owner = ?) " );
	if( "3".equals(state) )
		whereClause.append( " AND EXISTS (SELECT * FROM pie_mxranlink l WHERE l.mxrannri = " + alias +
			".storageplace AND l.owner = ?) " );
	
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getNumberOrder(sb.toString(), alias1) + " asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( "2".equals(state) )
			ps.setInt( j++, owner.intValue() );			
		if( "3".equals(state) )
			ps.setInt( j++, owner.intValue() );			
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
	return (String)(getAliasMap(statement).get(alias.toUpperCase()));
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
