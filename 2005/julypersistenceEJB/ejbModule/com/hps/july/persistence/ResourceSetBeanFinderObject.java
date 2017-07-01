package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ResourceSetBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements ResourceSetBeanFinderHelper{

/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isSubtypekey, 			ResourceSubTypeKey subtypeKey, 
	java.lang.Boolean isModel, 					java.lang.String model, 
	java.lang.Boolean isName, 					java.lang.String name, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    StringBuffer sbb = new StringBuffer(
	    "mainpart = r.resource "
	    );
    
    
    //calculate where clause
	if( isSubtypekey.booleanValue() )
		sbb.append( "and r.resourcesubtype = ? " );
	if( isModel.booleanValue() )
		sbb.append( "and upper(r.model) matches upper(?) " );
	if( isName.booleanValue() )
		sbb.append( "and upper(r.name) matches upper(?) " );

	//and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], sbb.toString() );
    }
    int fIdx = sb.toString().indexOf( " FROM " );
    sb.replace( fIdx, fIdx+6, ", r.model from resources r, " );
   
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "r.model asc";
			break;
		case 2:
			orderBy = "r.model desc";
			break;
		case 3:
			orderBy = "name asc";
			break;
		case 4:
			orderBy = "name desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isSubtypekey.booleanValue() )
			ps.setInt( j++, subtypeKey.resourcesubtype );
		if( isModel.booleanValue() )
			ps.setString( j++, model );
		if( isName.booleanValue() )
			ps.setString( j++, name );
	}   

	return ps;
}
}
