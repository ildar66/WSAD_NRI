package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class DirectionBeanFinderObject extends DivisionBeanFinderObject  implements DirectionBeanFinderHelper{
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findByParent( Integer argEncloser, int order ) throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], " company = ? and isactive = 'Y' " );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order ) {
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
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argEncloser.intValue() );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 10:29:33)
 * @return java.sql.PreparedStatement
 * @param argEncloser java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
public PreparedStatement findByParentOrderByNameAsc(Integer argEncloser) throws java.lang.Exception {
	return findByParent( argEncloser, 1 );
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 10:29:33)
 * @return java.sql.PreparedStatement
 * @param argEncloser java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
public PreparedStatement findByParentOrderByNameDesc(Integer argEncloser) throws java.lang.Exception {
	return findByParent( argEncloser, 2 );
}
public java.sql.PreparedStatement findByQBE(
    Boolean isParent, Integer parent,
    Boolean isIsActive, Boolean isActive,
    Integer order
	) throws Exception{

		//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " 1=1 " );

	String active = null;
	if(isParent.booleanValue())
		whereClause.append( " and company = ? " );
	if(isIsActive.booleanValue()){
		active = isActive.booleanValue() ? "Y" : "N";
		whereClause.append( " and isactive = ? " );
	}
		
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause );
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
	
	//System.out.println( "DirectionBeanFinderObject.findByQBE SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if(isParent.booleanValue())
				ps.setInt( j++, parent.intValue());
		if(isIsActive.booleanValue())
			ps.setString( j++, active);
	}   

	return ps;

}
}
