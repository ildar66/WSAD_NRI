package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class CompanyBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  implements CompanyBeanFinderHelper{
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findByName( Integer order ) throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], "1 = 1" );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "name asc";
			break;
		case 2:
			orderBy = "name desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	/*int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argEncloser.intValue() );
	} */  

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 10:29:33)
 * @return java.sql.PreparedStatement
 * @param argEncloser java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
public PreparedStatement findOrderByNameAsc() throws java.lang.Exception {
	return findByName( new Integer(1) );
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 10:29:33)
 * @return java.sql.PreparedStatement
 * @param argEncloser java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
public PreparedStatement findOrderByNameDesc() throws java.lang.Exception {
	return findByName( new Integer(2) );
}
}
