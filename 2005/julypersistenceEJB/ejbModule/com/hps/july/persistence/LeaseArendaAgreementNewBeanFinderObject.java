package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseArendaAgreementNewBeanFinderObject extends LeaseContractBeanFinderObject 
implements LeaseArendaAgreementNewBeanFinderHelper{

	private static java.util.HashMap aliasMap;
	private static int docCodeIdx;
	private static int docNumberIdx;
	private static int startDateIdx;	
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByContractAndResource(Integer contract, Integer resource, Integer order)
 throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
	//getting aliases
	String alias0 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
	String alias = (String)(getAliasMap( sb.toString() ).get("LEASEARENDAAGRMNTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( " (" + alias+".mainleasedocument = ? OR " + 
		alias + ".leasedocument = ? ) AND EXISTS (" +
		"SELECT r.leasedocument FROM leaserules r, leasechargerules cr WHERE " +
		" cr.leaserule = r.leaserule AND cr.resource = ? AND r.leasedocument = " + alias + ".leasedocument) ");
    
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getStartDateIdx(sb.toString(), alias0+".STARTDATE")+" asc";
			break;
		case 2:
			orderBy = getStartDateIdx(sb.toString(), alias0+".STARTDATE")+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, contract.intValue() );
		ps.setInt( j++, contract.intValue() );
		ps.setInt( j++, resource.intValue() );
	}

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isPosition, 			java.lang.Integer position, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Boolean isState, 				java.lang.String state, 
	java.lang.Integer order) 
	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASEDOCUMENTS"));
	String alias2 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
	String alias3 = (String)(getAliasMap( sb.toString() ).get("LEASEARENDAAGRMNTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias3+".isactive = \"Y\" " );
	if( isOrgCustomer.booleanValue() )
		whereClause.append( "and "+alias2+".orgcustomer = ? " );
	if( isOrgExecutor.booleanValue() )
		whereClause.append( "and "+alias2+".orgexecutor = ? " );
	if( isMainEconomist.booleanValue() )
		whereClause.append( "and "+alias2+".economist = ? " );
	if( isPosition.booleanValue() )
		whereClause.append( "and exists (select l.* from leaseonpositions l where l.leasedocument="+alias2+".leasedocument and l.storageplace = ?) " );
	if( isDocNumber.booleanValue() )
		whereClause.append( "and upper("+alias1+".docnumber) matches upper(?) " );
	if( isState.booleanValue() )
		if ("1".equalsIgnoreCase(state))
			whereClause.append( "and exists (SELECT leasedocument FROM leasecontracts lc WHERE " +
				" lc.leasedocument = "+alias2+".leasedocument AND " +
				"lc.contractstate = 'A' OR lc.contractstate = 'B') " );
		else if ("2".equalsIgnoreCase(state))
			whereClause.append( "and exists (SELECT leasedocument FROM leasecontracts lc WHERE " +
				" lc.leasedocument = "+alias2+".leasedocument AND " +
				"lc.contractstate = 'C') " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getDocNumberIdx(sb.toString(), alias1+".docnumber") + " asc";
			break;
		case 2:
			orderBy = getDocNumberIdx(sb.toString(), alias1+".docnumber") + " desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isOrgCustomer.booleanValue() )
			ps.setInt( j++, orgCustomer.intValue() );
		if( isOrgExecutor.booleanValue() )
			ps.setInt( j++, orgExecutor.intValue() );
		if( isMainEconomist.booleanValue() )
			ps.setInt( j++, mainEconomist.intValue() );
		if( isPosition.booleanValue() )
			ps.setInt( j++, position.intValue() );
		if( isDocNumber.booleanValue() )
			ps.setString( j++, docNumber );
	}

	return ps;
}
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByQBE2(
	java.lang.Integer mainLeaseDocument, 
	java.lang.Boolean isIsActive, 		java.lang.Boolean isActive, 
	java.lang.Boolean isContractState,  String contractState,
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
	//getting aliases
	String alias0 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
	String alias = (String)(getAliasMap( sb.toString() ).get("LEASEARENDAAGRMNTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".mainleasedocument = ? " );
	if( isIsActive.booleanValue() )
		whereClause.append( "and "+alias+".isactive = ? " );
	if( isContractState.booleanValue() )
		whereClause.append( "and "+alias0+".contractstate = ? " );
    
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getStartDateIdx(sb.toString(), alias0+".STARTDATE")+" asc";
			break;
		case 2:
			orderBy = getStartDateIdx(sb.toString(), alias0+".STARTDATE")+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, mainLeaseDocument.intValue() );
		if( isIsActive.booleanValue() )
			ps.setString( j++, (isActive.booleanValue())? "Y": "N" );
		if( isContractState.booleanValue() )
			ps.setString( j++, contractState );
	}

	return ps;
}
/**
 * findByQBE3 method comment.
 */
public java.sql.PreparedStatement findByQBE3(
	java.lang.Boolean isEndDate, 							java.sql.Date startEndDate, java.sql.Date finishEndDate, 
	java.lang.Boolean isIsActive, 						java.lang.Boolean isActive, 
	java.lang.Boolean isContractState, 				java.lang.String contractState, 
	java.lang.Boolean isExtendType, 					java.lang.String extendType,
	java.lang.Boolean isEconomist, 						Integer economist
	) 
	throws java.lang.Exception {

	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASEDOCUMENTS"));
	String alias2 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
	String alias3 = (String)(getAliasMap( sb.toString() ).get("LEASEARENDAAGRMNTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isEndDate.booleanValue() )
		whereClause.append( "and "+alias2+".enddate >= ? and "+alias2+".enddate <= ? " );
	if( isIsActive.booleanValue() )
		whereClause.append( "and "+alias3+".isactive = ? " );
	if( isContractState.booleanValue() )
		whereClause.append( "and "+alias2+".contractstate = ? " );
	if( isExtendType.booleanValue() )
		whereClause.append( "and "+alias2+".extendtype = ? " );
	if( isEconomist.booleanValue() )
		whereClause.append( "and "+alias2+".economist = ? " );
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isEndDate.booleanValue() ) {
			ps.setDate( j++, startEndDate );
			ps.setDate( j++, finishEndDate );
		}
		if( isIsActive.booleanValue() ) {
			ps.setString( j++, (isIsActive.booleanValue())? "Y": "N" );
		}
		if( isContractState.booleanValue() ) {
			ps.setString( j++, contractState );
		}
		if( isExtendType.booleanValue() ) {
			ps.setString( j++, extendType );
		}
		if( isEconomist.booleanValue() ) {
			ps.setInt( j++, economist.intValue() );
		}
	}

	return ps;
}
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByQBE4(Boolean isEconomist, Integer economist)
		throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
	//getting aliases
	String alias0 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
	String alias = (String)(getAliasMap( sb.toString() ).get("LEASEARENDAAGRMNTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias + ".mainleasedocument IS NULL AND contractstate = 'B' " );
	if( isEconomist.booleanValue() )
		whereClause.append( " AND "+alias0+".economist = ? " );
    
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }
    
	//append order by clause
	/*
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getStartDateIdx(sb.toString(), alias0+".STARTDATE")+" asc";
			break;
		case 2:
			orderBy = getStartDateIdx(sb.toString(), alias0+".STARTDATE")+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	*/
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if (isEconomist.booleanValue())
			ps.setInt( j++, economist.intValue() );
	}

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE5(
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isPosition, 			java.lang.Integer position, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Boolean isState, 				java.lang.String state, 
	java.lang.Integer order) 
	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    StringBuffer sb1 = new StringBuffer(getGenericFindSqlString());
    
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASEDOCUMENTS"));
	String alias2 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
	String alias3 = (String)(getAliasMap( sb.toString() ).get("LEASEARENDAAGRMNTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias3+".isactive = \"Y\" AND (" + alias3 + ".mainleasedocument IN ");
	
	StringBuffer whereClauseAdd = new StringBuffer( "(SELECT d1.leasedocument FROM leasedocuments d1, leasecontracts d2, leasearendaagrmnts d3 WHERE " +
		" d3.leasedocument=d2.leasedocument AND d2.leasedocument=d1.leasedocument ");
	if( isOrgCustomer.booleanValue() )
		whereClauseAdd.append( "and d2.orgcustomer = ? " );
	if( isOrgExecutor.booleanValue() )
		whereClauseAdd.append( "and d2.orgexecutor = ? " );
	if( isMainEconomist.booleanValue() )
		whereClauseAdd.append( "and d2.economist = ? " );
	if( isPosition.booleanValue() )
		whereClauseAdd.append( "and exists (select l.* from leaseonpositions l where l.leasedocument=d2.leasedocument and l.storageplace = ?) " );
	if( isDocNumber.booleanValue() )
		whereClauseAdd.append( "and upper(d1.docnumber) matches upper(?) " );

	/* Old Version
	if( isState.booleanValue() )
		if ("1".equalsIgnoreCase(state))
			whereClauseAdd.append( "and exists (SELECT lc.leasedocument FROM leasecontracts lc WHERE " +
				" lc.leasedocument = d2.leasedocument AND " +
				"lc.contractstate = 'A') " );
		else if ("2".equalsIgnoreCase(state))
			whereClauseAdd.append( "and exists (SELECT lc.leasedocument FROM leasecontracts lc WHERE " +
				" lc.leasedocument = d2.leasedocument AND " +
				"lc.contractstate = 'B') " );
		else if ("3".equalsIgnoreCase(state))
			whereClauseAdd.append( "and exists (SELECT lc.leasedocument FROM leasecontracts lc WHERE " +
				" lc.leasedocument = d2.leasedocument AND " +
				"lc.contractstate = 'C') " );
	*/
	if( isState.booleanValue() )
		if ("1".equalsIgnoreCase(state))
			whereClauseAdd.append( "and d2.contractstate = 'A' " );
		else if ("2".equalsIgnoreCase(state))
			whereClauseAdd.append( "and d2.contractstate = 'B' " );
		else if ("3".equalsIgnoreCase(state))
			whereClauseAdd.append( "and d2.contractstate = 'C' " );
	whereClauseAdd.append( " ) " );

	whereClause.append(whereClauseAdd);
	whereClause.append( " ) " );
	
	StringBuffer whereClause1 = new StringBuffer( alias3+".isactive = \"Y\" AND ");
	whereClause1.append( " ( (" + alias3 + ".mainleasedocument IS NULL) AND (" + alias3+ ".leasedocument IN  " );

	whereClause1.append(whereClauseAdd);
	
	whereClause1.append( " ) ) " );
	
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb1.insert(genericFindInsertPoints[i], whereClause1.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getDocNumberIdx(sb.toString(), alias1+".docnumber") + " asc";
			break;
		case 2:
			orderBy = getDocNumberIdx(sb.toString(), alias1+".docnumber") + " desc";
			break;
	}
	sb.append( " UNION ALL " );

	sb.append( sb1 );
		
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		for( int k = 0; k < 2; k++) {
			if( isOrgCustomer.booleanValue() )
				ps.setInt( j++, orgCustomer.intValue() );
			if( isOrgExecutor.booleanValue() )
				ps.setInt( j++, orgExecutor.intValue() );
			if( isMainEconomist.booleanValue() )
				ps.setInt( j++, mainEconomist.intValue() );
			if( isPosition.booleanValue() )
				ps.setInt( j++, position.intValue() );
			if( isDocNumber.booleanValue() )
				ps.setString( j++, docNumber );
		}
	}

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public static java.util.HashMap getAliasMap() { 
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 21:17:02)
 * @return java.util.Map
 */
public static java.util.Map getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:26:26)
 * @return int
 */
public static int getDocCodeIdx( String statement, String field ) {
	if( docCodeIdx == 0 ) {
		docCodeIdx = PersistenceUtil.getFieldIndex( statement, field );
	} 
	return docCodeIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:26:26)
 * @return int
 */
public static int getDocNumberIdx( String statement, String field ) {
	if( docNumberIdx == 0 ) {
		docNumberIdx = PersistenceUtil.getFieldIndex( statement, field );
	} 
	return docNumberIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:26:26)
 * @return int
 */
public static int getStartDateIdx( String statement, String field ) {
	if( startDateIdx == 0 ) {
		startDateIdx = PersistenceUtil.getFieldIndex( statement, field ); 
	}
	return startDateIdx;
}
}
