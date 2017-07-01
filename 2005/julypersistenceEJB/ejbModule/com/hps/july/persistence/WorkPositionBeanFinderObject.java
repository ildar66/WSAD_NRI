package com.hps.july.persistence;

import java.sql.PreparedStatement;
import com.ibm.vap.finders.*;
/**
 * Insert the type's description here.
 * Creation date: (24.07.2003 11:34:26)
 * @author: Maksim Gerasimov
 */
public class WorkPositionBeanFinderObject extends VapEJSJDBCFinderObject implements WorkPositionBeanFinderHelper {
public java.sql.PreparedStatement findByQBE(Boolean isIsActive, Boolean isActive, Integer order) throws Exception{

  	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " 1=1 " );

	String active = null;
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
	
	//System.out.println( "WorkPositionBeanFinderObject.findByQBE SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );

	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if(isIsActive.booleanValue())
				ps.setString( j++, active);
	}   

	return ps;

}
}
