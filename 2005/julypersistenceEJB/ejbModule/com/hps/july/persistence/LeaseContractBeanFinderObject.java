package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseContractBeanFinderObject extends LeaseDocumentBeanFinderObject 
implements LeaseContractBeanFinderHelper{

	private static java.util.HashMap aliasMap;
	private static int docNumberIdx;
	private static int docCodeIdx;
	private static int startDateIdx;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE( String contractType,
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Integer order) 
	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASEDOCUMENTS"));
	String alias2 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias2+".contracttype = ? AND " +
		" ( " + alias2 + ".contracttype <> 'A' OR (" + alias2 + ".contracttype = 'A' AND " +
		" EXISTS (SELECT agr.leasedocument FROM leasearendaagrmnts agr WHERE agr.leasedocument = " + 
		alias2 + ".leasedocument AND agr.mainleasedocument IS NULL) ) ) ");
	if( isOrgCustomer.booleanValue() )
		whereClause.append( "and "+alias2+".orgcustomer = ? " );
	if( isOrgExecutor.booleanValue() )
		whereClause.append( "and "+alias2+".orgexecutor = ? " );
	if( isMainEconomist.booleanValue() )
		whereClause.append( "and "+alias2+".economist = ? " );
	if( isDocNumber.booleanValue() )
		whereClause.append( "and upper("+alias1+".docnumber) matches upper(?) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getDocNumberIdx(sb.toString(), alias1+".DOCNUMBER")+" asc";
			break;
		case 2:
			orderBy = getDocNumberIdx(sb.toString(), alias1+".DOCNUMBER")+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setString( j++, contractType );
		if( isOrgCustomer.booleanValue() )
			ps.setInt( j++, orgCustomer.intValue() );
		if( isOrgExecutor.booleanValue() )
			ps.setInt( j++, orgExecutor.intValue() );
		if( isMainEconomist.booleanValue() )
			ps.setInt( j++, mainEconomist.intValue() );
		if( isDocNumber.booleanValue() )
			ps.setString( j++, docNumber );
	}

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findLeaseContractsByReglamentOrderByCodeAsc(Integer argReglament) 
	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASEDOCUMENTS"));
	String alias2 = (String)(getAliasMap( sb.toString() ).get("LEASECONTRACTS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias2+".leasedocument IN " +
		" (SELECT m.contract FROM leasemutcontracts m WHERE m.reglament = ?) ");
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = getDocCodeIdx(sb.toString(), alias1+".LEASEDOCUMENT")+" asc";
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argReglament.intValue());
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
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public static java.util.Map getAliasMap( String statement ) {
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
