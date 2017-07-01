package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class AbonentBillBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  
implements AbonentBillBeanFinderHelper{
public java.sql.PreparedStatement findByQBE(
        Boolean isLeaseDocument, Integer leaseDocument,
        Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, 
        Boolean isBillType, String billType,
        Integer order) throws Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("1=1 ");
    if (isLeaseDocument.booleanValue())
        whereClause.append("and leaseDocument=? ");
    if (isBillDate.booleanValue())
        whereClause.append("and BillDate >= ? and billdate <=? ");
    if (isBillType.booleanValue())
        whereClause.append("and billType=?");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "billNumber asc";
            break;
        case 2 :
            orderBy = "billNumber desc";
            break;
        case 3 :
            orderBy = "billDate asc";
            break;
        case 4 :
            orderBy = "billDate desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        if (isLeaseDocument.booleanValue())
            ps.setInt(j++, leaseDocument.intValue());
        if (isBillDate.booleanValue()){
            ps.setDate(j++, fromBillDate);
            ps.setDate(j++, toBillDate);
        }
        if (isBillType.booleanValue())
            ps.setString(j++, billType);
    }

    return ps;	    
}
public java.sql.PreparedStatement findByQBE2(
        Boolean isLeaseDocument, Integer leaseDocument,
        Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, 
        Boolean isBillType, String billType,
        Boolean isUseinNRI, Boolean useInNRI,
        Integer order) throws Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("1=1 ");
    if (isLeaseDocument.booleanValue())
        whereClause.append("and leaseDocument=? ");
    if (isBillDate.booleanValue())
        whereClause.append("and BillDate >= ? and billdate <=? ");
    if (isBillType.booleanValue())
        whereClause.append("and billType=? ");
    if (isUseinNRI.booleanValue())
    	if (useInNRI.booleanValue())
        	whereClause.append("and useinnri='Y' ");
        else
        	whereClause.append("and useinnri='N' ");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "billNumber asc";
            break;
        case 2 :
            orderBy = "billNumber desc";
            break;
        case 3 :
            orderBy = "billDate asc";
            break;
        case 4 :
            orderBy = "billDate desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        if (isLeaseDocument.booleanValue())
            ps.setInt(j++, leaseDocument.intValue());
        if (isBillDate.booleanValue()){
            ps.setDate(j++, fromBillDate);
            ps.setDate(j++, toBillDate);
        }
        if (isBillType.booleanValue())
            ps.setString(j++, billType);
    }

    return ps;	    
}
}
