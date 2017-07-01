package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
/**
 * Insert the type's description here.
 * Creation date: (18.03.2005 14:43:39)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeaseMutualReglament_Object {
    private final static java.lang.String findLeaseMutualReglament_SQL =
        "SELECT T1.docdate, T1.leasedocument, T1.docnumber, T1.operator, T1.doctype, T1.regionid, "
            + "T2.mutualperiod, T2.acttype, T2.commonrate, T2.calcratetype, T2.mutstate, T2.dutyraterule, T2.startdate, T2.enddate, T2.maincurrency, T2.additionalcurrency "
            + "FROM leasemutualrglmnt  T2, leasedocuments  T1 "
            + "WHERE T1.doctype = \'Q\' AND T1.leasedocument = T2.leasedocument ";
/**
 * CDBC_WorkerObject constructor comment.
 */
public CDBC_LeaseMutualReglament_Object() {
	super();
}
/**
* получиь список наименований договоров по регламенту
 * Creation date: (16.06.2005 17:27:32)
 */
public static String findLeaseContractsByReglament(Integer i_Reglament) {
    /**
    create procedure getListCntReglament(
    --execute procedure getListCntReglament();
    --получиь список наименований договоров 
    -- входные параметры
    i_Reglament  integer       -- код регламента
    ) returning
    char(1000)                -- список договоров регламента
    */
    CDBCResultSet res = new CDBCResultSet();
    LinkedList params = new LinkedList();
    String returnStr = null;

    params.add(i_Reglament); //  код регламента
    res.executeQuery("EXECUTE PROCEDURE  getListCntReglament(?);", params.toArray());
    ListIterator iter = res.listIterator();
    if (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        returnStr = ro.getColumn("col1").asString();
    }
    return returnStr;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:06:12)
 */
public static CDBCResultSet findListLeaseMutualReglament(
    java.lang.Boolean isDocDate,    java.sql.Date docDate,
    java.lang.Boolean isBlank,    String blank,
    java.lang.Boolean isLeaseContract,    Integer leaseContract,
    java.lang.Boolean isMutStateEdit,
    java.lang.Boolean isMutStateRun,
    java.lang.Boolean isMutStateClose,
    java.lang.Boolean isActType,
    String actType,
    Boolean isRegionID, Integer regionID,
    java.lang.Integer order) {

    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    java.util.LinkedList args = new java.util.LinkedList();
    //add query string: 
    sqlb.append(findLeaseMutualReglament_SQL);
    //calculate filter clause
    if (isDocDate.booleanValue()) {
        sqlb.append(" AND T1.docdate = ? ");
        args.add(docDate);
    }

    if (isBlank.booleanValue()) {
        sqlb.append(" AND UPPER(T1.docnumber) matches UPPER(?) ");
        args.add(blank);
    }

    if (isLeaseContract.booleanValue()) {
        sqlb.append(
            " AND T1.leasedocument IN (SELECT mc.reglament FROM leasemutcontracts mc WHERE mc.contract = ?) ");
        args.add(leaseContract);
    }

    boolean mutstate = false;
    int mutcount = 0;
    if (isMutStateEdit.booleanValue() || isMutStateRun.booleanValue() || isMutStateClose.booleanValue())
        mutstate = true;
    if (mutstate)
        sqlb.append(" AND (");
    if (isMutStateEdit.booleanValue()) {
        if (mutcount > 0)
            sqlb.append(" OR ");
        mutcount++;
        sqlb.append(" (T2.mutstate = 'A') ");
    }
    if (isMutStateRun.booleanValue()) {
        if (mutcount > 0)
            sqlb.append(" OR ");
        mutcount++;
        sqlb.append(" (T2.mutstate = 'B') ");
    }
    if (isMutStateClose.booleanValue()) {
        if (mutcount > 0)
            sqlb.append(" OR ");
        mutcount++;
        sqlb.append(" (T2.mutstate = 'C') ");
    }
    if (mutstate)
        sqlb.append(" ) ");

    if (isActType.booleanValue()) {
        sqlb.append(" AND T2.acttype = ? ");
        args.add(actType);
    }
    
    if (isRegionID.booleanValue()){
    	sqlb.append(" AND T1.regionid = ? ");
		args.add(regionID);    	
    }
    	
    //append order by clause:
    sqlb.append(" order by T1.docnumber asc");

    //System.out.println("findListLeaseMutualReglament sql=" + sqlb); //temp
    res.executeQuery(sqlb.toString(), args.toArray());

    return res;
}
/**
* получиь список наименований услуг договора по регламенту
 * Creation date: (16.06.2005 17:27:32)
 */
public static String findListResourcesByReglament(Integer i_Reglament) {
    /**
    create procedure getListResReglament(
    --execute procedure getListResReglament();
    --получиь список наименований услуг договора
    -- входные параметры
    i_Reglament  integer       -- код регламента
    ) returning
    char(1000)                -- список услуг регламента
    
    */
    CDBCResultSet res = new CDBCResultSet();
    LinkedList params = new LinkedList();
    String returnStr = null;

    params.add(i_Reglament); //  код регламента
    res.executeQuery("EXECUTE PROCEDURE  getListResReglament(?);", params.toArray());
    ListIterator iter = res.listIterator();
    if (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        returnStr = ro.getColumn("col1").asString();
    }
    return returnStr;
}
}
