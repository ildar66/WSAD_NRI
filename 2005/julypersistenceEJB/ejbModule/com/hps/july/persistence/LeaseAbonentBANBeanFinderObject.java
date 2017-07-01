package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseAbonentBANBeanFinderObject extends LeaseContractBeanFinderObject 
implements LeaseAbonentBANBeanFinderHelper{
		private static java.util.HashMap aliasMap;
		private static int docNumberIdx;
 
public java.sql.PreparedStatement findByQBE2(
	Boolean isCustomerName, String customerName, 
	Boolean isCustomerInn, String customerInn, 
	Boolean isBan, String ban, 
	Integer order) throws Exception {
    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //getting aliases
    String alias1 = (String) (getAliasMap(sb.toString()).get("LEASEDOCUMENTS"));
    String alias2 = (String) (getAliasMap(sb.toString()).get("LEASECONTRACTS"));
    String alias3 = (String) (getAliasMap(sb.toString()).get("LEASEABONENTBAN"));

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("1=1 ");
    if (isCustomerName.booleanValue())
        whereClause.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o1 WHERE upper(o1.name) matches upper(?) ) ");
    if (isCustomerInn.booleanValue())
        whereClause.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o2 WHERE upper(o2.inn) matches upper(?) ) ");
    if (isBan.booleanValue())
        whereClause.append("and upper(" + alias1 + ".docnumber) matches upper(?) ");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = getDocNumberIdx(sb.toString(), alias1 + ".DOCNUMBER") + " asc";
            break;
        case 2 :
            orderBy = getDocNumberIdx(sb.toString(), alias1 + ".DOCNUMBER") + " desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        if (isCustomerName.booleanValue())
            ps.setString(j++, customerName);
        if (isCustomerInn.booleanValue())
            ps.setString(j++, customerInn);            
        if (isBan.booleanValue())
            ps.setString(j++, ban);
    }

    return ps;
}
public java.sql.PreparedStatement findByQBE3(
    Boolean isCustomerName, String customerName,
    Boolean isCustomerInn, String customerInn,
    Boolean isBan, String ban,
    Boolean isContractState, String contractState,
    Integer order) throws Exception {
    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //getting aliases
    String alias1 = (String) (getAliasMap(sb.toString()).get("LEASEDOCUMENTS"));
    String alias2 = (String) (getAliasMap(sb.toString()).get("LEASECONTRACTS"));
    String alias3 = (String) (getAliasMap(sb.toString()).get("LEASEABONENTBAN"));

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("1=1 ");
    if (isCustomerName.booleanValue())
        whereClause.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o1 WHERE upper(o1.name) matches upper(?) ) ");
    if (isCustomerInn.booleanValue())
        whereClause.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o2 WHERE upper(o2.inn) matches upper(?) ) ");
    if (isBan.booleanValue())
        whereClause.append("and upper(" + alias1 + ".docnumber) matches upper(?) ");
    if (isContractState.booleanValue())
    	whereClause.append("AND " + alias2 + ".contractstate = ?");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = getDocNumberIdx(sb.toString(), alias1 + ".DOCNUMBER") + " asc";
            break;
        case 2 :
            orderBy = getDocNumberIdx(sb.toString(), alias1 + ".DOCNUMBER") + " desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        if (isCustomerName.booleanValue())
            ps.setString(j++, customerName);
        if (isCustomerInn.booleanValue())
            ps.setString(j++, customerInn);            
        if (isBan.booleanValue())
            ps.setString(j++, ban);
    	if (isContractState.booleanValue())
            ps.setString(j++, contractState);
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
public static int getDocNumberIdx( String statement, String field ) {
	if( docNumberIdx == 0 ) {
		docNumberIdx = PersistenceUtil.getFieldIndex( statement, field );
	}
	return docNumberIdx; 
}
}
