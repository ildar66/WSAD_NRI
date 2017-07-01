package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class FaultReportBeanFinderObject extends DocumentBeanFinderObject 
implements FaultReportBeanFinderHelper{
	private static int blankIdx;
	private static int blankDateIdx;
	private static java.util.Map aliasMap;
	private static java.lang.String alias1;
	private static java.lang.String alias2;

/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean useDate, 							java.sql.Date datefrom, java.sql.Date dateto, 
	java.lang.Boolean useOwner, 						java.lang.Integer owner, 
	java.lang.Boolean useDivision, 					java.lang.Integer division, 
	java.lang.Boolean useWorker, 						java.lang.Integer worker, 
	java.lang.Boolean usePosition, 					java.lang.Integer position, 
	java.lang.Boolean useResource, 					java.lang.Integer resource, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  String alias1 = getAlias1( sb.toString() );
  String alias2 = getAlias2( sb.toString() );
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( useDate.booleanValue() ) {
		whereClause.append( "and "+alias1+".blankdate >= ? and "+alias1+".blankdate <= ? " );
	}
	if( useOwner.booleanValue() ) {
		whereClause.append( "and "+alias1+".owner = ? " );
	}
	if( useDivision.booleanValue() ) {
		whereClause.append( "and "+alias2+".vivision = ? " );
	}
	if( useWorker.booleanValue() ) {
		whereClause.append( "and exists (select e.* from expedition e where e.expedition="+alias1+".from and e.expeditor=?) " );
	}
	if( usePosition.booleanValue() ) {
		whereClause.append( "and "+alias1+".to in (select e.equipment from equipment e where position = ?) " );
	}
	if( useResource.booleanValue() ) {
		whereClause.append( "and exists (select d.* from docpositions d where d.document="+alias1+".document and d.resource=?) " );
	}
    
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getBlankIdx(sb.toString(),alias1)+" asc";
			break;
		case 2:
			orderBy = getBlankIdx(sb.toString(),alias1)+" desc";
			break;
		case 3:
			orderBy = getBlankDateIdx(sb.toString(),alias1)+" asc, " + getBlankIdx(sb.toString(),alias1)+" asc";
			break;
		case 4:
			orderBy = getBlankDateIdx(sb.toString(),alias1)+" desc, " + getBlankIdx(sb.toString(),alias1)+" asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1; 
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( useDate.booleanValue() ) {
			ps.setDate( j++, datefrom );
			ps.setDate( j++, dateto );
		}
		if( useOwner.booleanValue() ) {
			ps.setInt( j++, owner.intValue() );
		}
		if( useDivision.booleanValue() ) {
			ps.setInt( j++, division.intValue() );
		}
		if( useWorker.booleanValue() ) {
			ps.setInt( j++, worker.intValue() );
		}
		if( usePosition.booleanValue() ) {
			ps.setInt( j++, position.intValue() );
		}
		if( useResource.booleanValue() ) {
			ps.setInt( j++, resource.intValue() );
		}
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:57:57)
 * @return java.lang.String
 */
public java.lang.String getAlias1( String statement ) {
	if( alias1 == null ) {
		alias1 = (String)(getAliasMap(statement).get("DOCUMENTS"));
	}
	return alias1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:58:18)
 * @return java.lang.String
 */
public java.lang.String getAlias2(String statement) {
	if( alias2 == null ) {
		alias2 = (String)(getAliasMap(statement).get("FAULTREPORT"));
	}
	return alias2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:55:23)
 * @return java.util.Map
 */
public java.util.Map getAliasMap( String statement ) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:39:05)
 * @return int
 */
public static int getBlankDateIdx(String statement, String alias) {
	if( blankDateIdx <= 0 ) {
		blankDateIdx = PersistenceUtil.getFieldIndex( statement, alias+".blankdate" );
	}
	return blankDateIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:39:05)
 * @return int
 */
public static int getBlankIdx(String statement, String alias) {
	if( blankIdx <= 0 ) {
		blankIdx = PersistenceUtil.getFieldIndex( statement, alias+".blankindex" );
	}
	return blankIdx;
}
}
