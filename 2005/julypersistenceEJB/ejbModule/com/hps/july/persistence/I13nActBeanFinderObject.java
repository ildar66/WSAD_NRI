package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class I13nActBeanFinderObject extends DocumentBeanFinderObject 
implements I13nActBeanFinderHelper{

/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
public java.sql.PreparedStatement findI13nActByQBE(Boolean isDate, java.sql.Date argDateFrom, java.sql.Date argDateTo, 
	java.lang.Boolean isOrganization, 
	java.lang.Integer argOrganization,
	java.lang.Boolean isStorage, java.lang.Integer argStorage,
	java.lang.Boolean isStorageType, java.lang.String storageType,
	java.lang.Integer order) throws java.lang.Exception {
	
	//process 
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
    String equipmentTypes = "(\"E\", \"B\", \"C\", \"O\", \"W\", \"T\", \"R\", \"L\")";
	StringBuffer whereClause = new StringBuffer("1=1 ");
	if (isDate.booleanValue()) {
		whereClause.append(" AND t1.blankdate >= ? AND t1.blankdate <= ? " );
	}
	if( isOrganization.booleanValue() )
		whereClause.append( "and t1.owner = ? " );
	if( isStorageType.booleanValue() ) {
		if( storageType.equals( "E" ) ) {
			if( isStorage.booleanValue() )
				whereClause.append( "and t1.from = ? " );
			whereClause.append("and exists (select s.type from storageplaces s where s.storageplace=t1.from and s.type in ");
			whereClause.append(equipmentTypes);
			whereClause.append(" ) " );
		} else if( storageType.equals( "Q" ) ) {
			if( isStorage.booleanValue() ) {
				whereClause.append(
					"and exists (select e.position from storageplaces sp, equipment e "+
					" where sp.storageplace = e.equipment and e.equipment = t1.from and e.position = ? "+
					" and sp.type in  " );
				whereClause.append(equipmentTypes);
				whereClause.append(" ) " );
			} else {
				whereClause.append(
					"and exists (select e.position from storageplaces sp, equipment e "+
					" where sp.storageplace = e.equipment and e.equipment = t1.from "+
					" and s.type in  " );
				whereClause.append(equipmentTypes);
				whereClause.append(" ) " );
			}
		} else {
			if( isStorage.booleanValue() )
				whereClause.append( "and t1.from = ? " );
			whereClause.append( 
				"and exists (select s.type from storageplaces s where s.storageplace=t1.from and s.type in "+
				"(\""+storageType+"\") ) " );
		}
	} else {
		if( isStorage.booleanValue() )
			whereClause.append( "and t1.from = ? " );
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
			orderBy = "t1.blankdate asc, " + "t1.blankindex asc";
			break;
		case 4:
			orderBy = "t1.blankdate desc, " + "t1.blankindex asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if (isDate.booleanValue()) {
			ps.setDate( j++, argDateFrom );
			ps.setDate( j++, argDateTo );
		}
		if( isOrganization.booleanValue() )
			ps.setInt( j++, argOrganization.intValue() );
		if( isStorage.booleanValue() )
			ps.setInt( j++, argStorage.intValue() );
		//if( isStorageType.booleanValue() )
			//ps.setString( j++, storageType );
	}   

	return ps;
}
}
