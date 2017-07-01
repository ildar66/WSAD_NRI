package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class DocumentBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  implements DocumentBeanFinderHelper{
	private static java.util.Map aliasMap;
/**
 * documentFindByQBE method comment.
 */
public java.sql.PreparedStatement findDocumentByQBE(
	java.lang.Boolean isDate, 									java.sql.Date datefrom, java.sql.Date dateto, 
	java.lang.Boolean isOrganization, 					java.lang.Integer organization, 
	java.lang.Boolean isStorageFrom, 						java.lang.Integer storageFrom, 
	java.lang.Boolean isStorageTo, 							java.lang.Integer storageTo) throws java.lang.Exception {

	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  java.util.Map m = getAliasMap(sb.toString());
  String alias = (String)(m.get("DOCUMENTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isDate.booleanValue() ) {
		whereClause.append( "and "+alias+".blankdate >= ? and "+alias+".blankdate <= ? " );
	}
	if( isOrganization.booleanValue() ) {
		whereClause.append( "and "+alias+".owner = ? " );
	}
	if( isStorageFrom.booleanValue() ) {
		whereClause.append( "and "+alias+".from = ? " );
	}
	if( isStorageTo.booleanValue() ) {
		whereClause.append( "and "+alias+".to = ? " );
	}
    
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1; 
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isDate.booleanValue() ) {
			ps.setDate( j++, datefrom );
			ps.setDate( j++, dateto );
		}
		if( isOrganization.booleanValue() ) {
			ps.setInt( j++, organization.intValue() );
		}
		if( isStorageFrom.booleanValue() ) {
			ps.setInt( j++, storageFrom.intValue() );
		}
		if( isStorageTo.booleanValue() ) {
			ps.setInt( j++, storageTo.intValue() );
		}
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
}
