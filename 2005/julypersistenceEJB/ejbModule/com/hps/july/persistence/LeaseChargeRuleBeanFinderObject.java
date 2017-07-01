package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseChargeRuleBeanFinderObject extends LeaseRuleBeanFinderObject  
implements LeaseChargeRuleBeanFinderHelper{
	private static java.util.Map aliasMap;
	private static int leaseRuleIdx;
/**
 * findByLeaseDocument method comment.
 */
public java.sql.PreparedStatement findByLeaseDocumentAndResource(Integer leaseDocument, 
		Integer argResource, Integer order) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("LEASERULES"));
    String alias1 = (String)(m.get("LEASECHARGERULES"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".leasedocument = ? AND " + alias1 + ".resource = ? ");
    
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy =  getLeaseRuleIdx(sb.toString(),alias)+" asc";
			break;
		case 2:
			orderBy = getLeaseRuleIdx(sb.toString(),alias)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, leaseDocument.intValue() );
		ps.setInt( j++, argResource.intValue() );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:06:36)
 * @return java.util.Map
 */
public static java.util.Map getAliasMap(String statement) {
	if( aliasMap == null ) { 
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 13:11:28)
 * @return int
 */
public static int getLeaseRuleIdx( String statement, String alias ) {
	if( leaseRuleIdx <= 0 ) { 
		leaseRuleIdx = PersistenceUtil.getFieldIndex( statement, alias+".leaserule" );
	}
	return leaseRuleIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:06:36)
 * @param newAliasMap java.util.Map
 */
public static void setAliasMap(java.util.Map newAliasMap) {
	aliasMap = newAliasMap; 
}
}
