package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class InwayBillBeanFinderObject extends DocumentBeanFinderObject 
implements InwayBillBeanFinderHelper{

/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isStorage, 				java.lang.Integer storage, 
	java.sql.Date startDate, java.sql.Date endDate,
	Boolean isCordocnum, 								String cordocnum, 
	java.lang.Boolean isOwner, 					java.lang.Integer owner, 
	java.lang.Boolean isSupplier, 			java.lang.Integer supplier, 
	java.lang.Boolean isDActOnly, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//process 
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "t1.showtouser = 'Y' AND t1.blankdate >= ? and t1.blankdate <= ?  " );
	if( isStorage.booleanValue() )
		whereClause.append( "and t1.to = ? " );
	if( isOwner.booleanValue() )
		whereClause.append( "and t1.owner = ? " );
	if( isSupplier.booleanValue() ) {
		whereClause.append( "and t1.contragent = ? " );
	}
	if( isDActOnly.booleanValue() ) {
		whereClause.append( "and t2.dactnumber is not null " );
	}  
	if( isCordocnum.booleanValue() ) {
		whereClause.append( "and upper( t2.cordocnum ) matches upper(?) " );
	}
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t1.blankindex asc";
			break;
		case 2:
			orderBy = "t1.blankindex desc";
			break;
		case 3:
			orderBy = "t1.blankdate asc, t1.blankindex asc";
			break;
		case 4:
			orderBy = "t1.blankdate desc, t1.blankindex asc";
			break;
		case 5:
			orderBy = "t2.cordocnum asc";
			break;
		case 6:
			orderBy = "t2.cordocnum desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setDate( j++, startDate );	
		ps.setDate( j++, endDate );	
		if( isStorage.booleanValue() )
			ps.setInt( j++, storage.intValue() );
		if( isOwner.booleanValue() )
			ps.setInt( j++, owner.intValue() );
		if( isSupplier.booleanValue() )
			ps.setInt( j++, supplier.intValue() );
		if( isCordocnum.booleanValue() )
			ps.setString( j++, cordocnum );
	}   

	return ps;
}
}
