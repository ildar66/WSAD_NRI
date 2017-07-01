package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class OutWayBillBeanFinderObject extends DocumentBeanFinderObject 
implements OutWayBillBeanFinderHelper{
	private static java.util.Map aliasMap;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isDate, 				java.sql.Date dateFrom, java.sql.Date dateTo,  
	java.lang.Boolean isOwner, 				java.lang.Integer owner, 
	java.lang.Boolean isStorage, 			java.lang.Integer storage, 
	java.lang.Boolean isContragent, 		java.lang.Integer contragent, 
	java.lang.Integer order) throws java.lang.Exception {

	//process 
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCUMENTS"));
    
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1  " );
	if( isDate.booleanValue() )
		whereClause.append( "and "+alias+".blankdate >= ? and "+alias+".blankdate <= ? " );
	if( isOwner.booleanValue() )
		whereClause.append( "and "+alias+".owner = ? " );
	if( isStorage.booleanValue() ) {
		whereClause.append( "and "+alias+".from = ? " );
	}
	if( isContragent.booleanValue() ) {
		whereClause.append( "and "+alias+".contragent = ? " );
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
			ps.setDate( j++, dateFrom );
			ps.setDate( j++, dateTo );
		}
		if( isOwner.booleanValue() )
			ps.setInt( j++, owner.intValue() );
		if( isStorage.booleanValue() ) {
			ps.setInt( j++, storage.intValue() );
		}
		if( isContragent.booleanValue() ) {
			ps.setInt( j++, contragent.intValue() );
		}
	}   

	return ps;
}
	public java.util.Map getAliasMap(String statement) {
		if( aliasMap == null ) {
			aliasMap=PersistenceUtil.getAliasesMap(statement);
		}
		return aliasMap;
	}
}
