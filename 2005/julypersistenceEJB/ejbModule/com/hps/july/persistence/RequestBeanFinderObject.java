package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class RequestBeanFinderObject extends DocumentBeanFinderObject 
implements RequestBeanFinderHelper{

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
	java.lang.Boolean useDivision, 					java.lang.Integer division, 
	java.lang.Boolean usePosition, 					java.lang.Integer position, 
	java.lang.String requestType, 
	java.lang.Boolean useOrganization, 			java.lang.Integer organization, 
	java.lang.Boolean useWorker, 						java.lang.Integer worker,
	  Boolean hasNoLink
	) throws java.lang.Exception {

	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( useDate.booleanValue() )
		whereClause.append( "and "+getAlias1(sb.toString())+".blankdate >= ? and "+getAlias1(sb.toString())+".blankdate <= ? " ); 
	if( useDivision.booleanValue() )
		whereClause.append( "and "+getAlias2(sb.toString())+".divisionrequester = ? " );
	if( usePosition.booleanValue() )
		whereClause.append( "and "+getAlias2(sb.toString())+".position = ? " );
	if( requestType.equals("P") ) {
		if( useOrganization.booleanValue() ) {
			whereClause.append( "and "+getAlias1(sb.toString())+".from in "+
				"(select e.expedition from expedition e where e.organization = ? ) " );
		} else {
			whereClause.append( "and "+getAlias1(sb.toString())+".from in "+
				"(select e.expedition from expedition e where e.organization is not null ) " );
		}
	} else if( requestType.equals("W") ) {
		if( useWorker.booleanValue() ) {
			whereClause.append( "and "+getAlias1(sb.toString())+".from in "+
				"(select e.expedition from expedition e where e.expeditor = ? ) " );
		} else {
			whereClause.append( "and "+getAlias1(sb.toString())+".from in "+
				"(select e.expedition from expedition e where e.expeditor is not null ) " );
		}
	}

	if (hasNoLink.booleanValue()) {
	}

  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( useDate.booleanValue() ) {
			ps.setDate( j++, datefrom );	
			ps.setDate( j++, dateto );	
		}
		if( useDivision.booleanValue() ) {
			ps.setInt( j++, division.intValue() );
		}
		if( usePosition.booleanValue() ) {
			ps.setInt( j++, position.intValue() );
		}
		if( requestType.equals("P") ) {
			if( useOrganization.booleanValue() ) {
				ps.setInt( j++, organization.intValue() );
			}
		} else if( requestType.equals("W") ) {
			if( useWorker.booleanValue() ) {
				ps.setInt( j++, worker.intValue() );
			}
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
		alias2 = (String)(getAliasMap(statement).get("REQUESTS"));
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
		blankIdx = PersistenceUtil.getFieldIndex( statement, alias+".blanknumber" );
	}
	return blankIdx;
}
}
