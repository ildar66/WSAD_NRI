package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class WorkerBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  implements WorkerBeanFinderHelper{
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
		java.lang.Boolean isDivision, 			java.lang.Integer argDivision, 
		java.lang.Boolean isLastName, 			java.lang.String argLastName, 
		java.lang.Boolean isActive, 			java.lang.Boolean argActive, 
		java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isDivision.booleanValue() )
		whereClause.append( "and t1.division = ? " );
	if( isLastName.booleanValue() )
		whereClause.append( "and exists (select p.* from people p where p.man = t1.man and upper(p.lastname) matches upper(?) ) " );
	if( isActive.booleanValue() )
		whereClause.append( "and t1.isactive = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isDivision.booleanValue() )
			ps.setInt( j++, argDivision.intValue() );
		if( isLastName.booleanValue() )
			ps.setString( j++, argLastName );
		if( isActive.booleanValue() ) {
			String s = ( argActive.booleanValue() )? "Y": "N";
			ps.setString( j++, s );			
		}
	}   

	return ps;
}
}
