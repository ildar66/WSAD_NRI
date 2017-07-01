package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeasePayRuleBeanFinderObject extends LeaseRuleBeanFinderObject  
implements LeasePayRuleBeanFinderHelper{
	private static java.util.Map aliasMap;
	private static int leaseRuleIdx;
/**
 * findByLeaseDocument method comment.
 */
public java.sql.PreparedStatement findByLeaseDocument(java.lang.Integer leaseDocument, 
		Boolean isPpType, java.lang.Integer order) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias1 = (String)(m.get("LEASERULES"));
    String alias2 = (String)(m.get("LEASEPAYRULES"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias1+".leasedocument = ? " );

	if (isPpType.booleanValue())
		whereClause = whereClause.append(" AND (" + alias2 + ".pptype = 'A' OR " + alias2 + ".pptype = 'C') ");
    
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy =  getLeaseRuleIdx(sb.toString(), alias1)+" asc";
			break;
		case 2:
			orderBy = getLeaseRuleIdx(sb.toString(), alias1)+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, leaseDocument.intValue() );
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
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 13:11:28)
 * @param newLeaseRuleIdx int
 */
public static void setLeaseRuleIdx(int newLeaseRuleIdx) {
	leaseRuleIdx = newLeaseRuleIdx;
}
}
