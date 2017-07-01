package com.hps.july.persistence;

import java.sql.*;
public class LeaseSchetFaktBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements LeaseSchetFaktBeanFinderHelper{
	
	private static java.util.HashMap aliasMap;
	private static int numberSchetFakt;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(Integer idAct, Boolean isContractType, String typeContract, Integer order) 
	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASESCHETFAKT"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer(alias1+".idAkt = ? ");
	
	if(isContractType.booleanValue()){ 
		whereClause = whereClause.append(" and "+ alias1+".idContract in "
			+"(select lc.leasedocument from LeaseContracts lc where lc.contractType='"+typeContract+"' and "
			+"lc.leasedocument="+alias1+".idContract)");
	}

    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getNumberSchetFact(sb.toString(), alias1+".NUMBERSCHETFAKT")+" asc";
			break;
		case 2:
			orderBy = getNumberSchetFact(sb.toString(), alias1+".NUMBERSCHETFAKT")+" desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause LeaseSchetFactBean.findByQBE="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, idAct.intValue() );
	}

	return ps;
}
public java.util.HashMap getAliasMap() {
	return aliasMap;
}
public java.util.Map getAliasMap( String statement ) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
public int getNumberSchetFact( String statement, String field ) {
	if( numberSchetFakt == 0 ) {
		numberSchetFakt = PersistenceUtil.getFieldIndex( statement, field );
	}
	return numberSchetFakt;
}
}
