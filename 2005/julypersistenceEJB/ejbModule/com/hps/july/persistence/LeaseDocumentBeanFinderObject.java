package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseDocumentBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements LeaseDocumentBeanFinderHelper{

/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(java.lang.Boolean isDocDate, java.sql.Date docDate, java.lang.Boolean isBlank, java.lang.String blank, java.lang.Integer order) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isDocDate.booleanValue() )
		whereClause.append( "and t1.docdate = ? " );
	if( isBlank.booleanValue() )
		whereClause.append( "and upper(t1.docnumber) matches upper(?) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t1.docnumber asc";
			break;
		case 2:
			orderBy = "t1.docnumber desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isDocDate.booleanValue() )
			ps.setDate( j++, docDate );
		if( isBlank.booleanValue() )
			ps.setString( j++, blank );
	}

	return ps;
}
}
