package com.hps.july.persistence;

import java.sql.PreparedStatement;
/**
 * Insert the type's description here.
 * Creation date: (17.07.2003 12:28:35)
 * @author: Maksim Gerasimov
 */
public class CarBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject implements CarBeanFinderHelper {
/**
 * CarBeanFinderObject constructor comment.
 */
public CarBeanFinderObject() {
	super();
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	Boolean isOrganization, Integer organization, 
	Boolean isDivision, Integer division, 
	Integer order) throws Exception {
	
		//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " 1=1 " );

	if(isOrganization.booleanValue())
		whereClause.append( " and organization = ? " );
	
	if(isDivision.booleanValue())
		whereClause.append(" and division = ? ");
		
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause );
    }
    
	//append order by clause
	String orderBy = null;	
	switch( order.intValue() ) {
		case 1:
			orderBy = "car_number asc";
			break;
		case 2:
			orderBy = "car_number desc";
			break;
	}
	
	sb.append( " order by "+orderBy );
	
	//System.out.println( "CarBeanFinderObject.findByQBE SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );

	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if(isOrganization.booleanValue())
				ps.setInt( j++, organization.intValue());
		if(isDivision.booleanValue())
			ps.setInt( j++, division.intValue());
	}   

	return ps;
}
}
