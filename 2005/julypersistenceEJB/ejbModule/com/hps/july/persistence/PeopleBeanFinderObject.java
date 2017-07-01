package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class PeopleBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
	implements PeopleBeanFinderHelper{
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findByConnectedOrderByNameAsc(Integer argConnected) throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " 1=1 " );
	if (argConnected.intValue() == 2)
    	whereClause = whereClause.append(" AND EXISTS (SELECT pv.* FROM pie_otvuserlink pv WHERE pv.otvusernri=t1.man)");
	if (argConnected.intValue() == 3)
    	whereClause = whereClause.append(" AND NOT EXISTS (SELECT pv.* FROM pie_otvuserlink pv WHERE pv.otvusernri=t1.man)");

  whereClause = whereClause.append(" and isActive = 'Y' ");
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause );
    }
    
	//append order by clause
	String orderBy = "lastname asc";
	/*
	switch( order ) {
		case 1:
			orderBy = "name asc";
			break;
		case 2:
			orderBy = "name desc";
			break;
	}
	*/
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		//ps.setInt( j++, argEncloser.intValue() );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findByQBE(
    Boolean isLastName, String lastName, /* должен поддерживаться поиск по маске "*" */
    Integer argConnected,
    Boolean isIsActive, Boolean isActive,
    Integer order
) throws Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " 1=1 " );

	if(isLastName.booleanValue())
		whereClause.append( " and upper(lastname) matches upper(?) " );
	
	if (argConnected.intValue() == 2)
    	whereClause = whereClause.append(" AND EXISTS (SELECT pv.* FROM pie_otvuserlink pv WHERE pv.otvusernri=t1.man)");
	if (argConnected.intValue() == 3)
    	whereClause = whereClause.append(" AND NOT EXISTS (SELECT pv.* FROM pie_otvuserlink pv WHERE pv.otvusernri=t1.man)");
  
	if(isIsActive.booleanValue())
		whereClause.append( " and isactive = ? " );
		
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause );
    }
    
	//append order by clause
	String orderBy = null;	
	switch( order.intValue() ) {
		case 1:
			orderBy = "lastname asc";
			break;
		case 2:
			orderBy = "lastname desc";
			break;
	}
	
	sb.append( " order by "+orderBy );
	
	//System.out.println( "PeopleBeanFinderObject.findByQBE SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );

	String active = isActive.booleanValue() ? "Y" : "N";
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if(isLastName.booleanValue())
				ps.setString( j++, lastName);
		if(isIsActive.booleanValue())
			ps.setString( j++, active);
	}   

	return ps;
}
}
