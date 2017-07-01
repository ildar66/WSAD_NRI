package com.hps.july.persistence;

import java.sql.PreparedStatement;
/**
 * Insert the type's description here.
 * Creation date: (27.08.2003 20:06:37)
 * @author: Maksim Gerasimov
 */
public class RepiterBeanFinderObject extends EquipmentSetBeanFinderObject implements RepiterBeanFinderHelper {
	private static String storageplaceName = null;
	private static java.util.HashMap aliasesMap;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(Boolean isDonorSect, Integer donorSect, Integer order) throws Exception {
		//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
	String alias1 = getAlias( sb.toString(), "STORAGEPLACES" );
	String alias2 = getAlias( sb.toString(), "REPITERS" );
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isDonorSect.booleanValue() )
		whereClause.append( " and "+alias2+".donor_sect = ? " );

	//and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getStorageplaceNameOrder(sb.toString(), alias1)+" asc";
			break;
		case 2:
			orderBy = getStorageplaceNameOrder(sb.toString(), alias1)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause RepiterbeanFinderObject="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
	if( isDonorSect.booleanValue() )
		ps.setInt( j++, donorSect.intValue() );
	}   

	return ps;
}
public String getAlias(String statement, String alias) {
	return (String)(getAliasesMap(statement).get(alias.toUpperCase()));
}
public java.util.HashMap getAliasesMap(String statement) {
	if( aliasesMap == null ) {
		aliasesMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasesMap;
}
public static String getStorageplaceNameOrder(String statement, String alias ) {
	if( storageplaceName == null ) {
		storageplaceName = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".name" ) );
	}
	return storageplaceName;
}
}
