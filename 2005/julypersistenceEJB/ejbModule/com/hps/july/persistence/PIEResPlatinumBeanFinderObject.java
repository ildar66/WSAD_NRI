package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class PIEResPlatinumBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements PIEResPlatinumBeanFinderHelper{
		private static java.util.HashMap aliasMap;
/**
 * findBanksByQBE method comment.
 */
public java.sql.PreparedStatement findByIdresplatinNameOwner(Boolean isIdresplatin, String idresplatin, 
		Boolean isNameRes, String nameRes, Integer owner,
		Integer order) throws java.lang.Exception {
	
		//get generic query string 
		int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

		//getting aliases
		String alias1 = (String)(getAliasMap( sb.toString() ).get("PIE_RESPLATINUM"));
    
    	//calculate where clause
		StringBuffer whereClause = new StringBuffer( "owner = ? " );
		if( isIdresplatin.booleanValue() )
			whereClause.append( " AND upper(idresplatinum) MATCHES (upper(?)) " );
		if( isNameRes.booleanValue() )
			whereClause.append( " AND upper(nameres) MATCHES (upper(?)) " );
    
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
			  sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	    }
    
		//append order by clause
		String orderBy = null;
		switch( order.intValue() ) {
			case 1:
				orderBy = alias1 + ".nameres asc";
				break;
			case 2:
				orderBy = alias1 + ".nameres desc";
		}
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
	
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			ps.setInt( j++, owner.intValue() );
			if( isIdresplatin.booleanValue() )
				ps.setString( j++, idresplatin );
			if( isNameRes.booleanValue() )
				ps.setString( j++, nameRes );
		}   

		return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public java.util.HashMap getAliasMap() {
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public java.util.Map getAliasMap( String statement ) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
}
