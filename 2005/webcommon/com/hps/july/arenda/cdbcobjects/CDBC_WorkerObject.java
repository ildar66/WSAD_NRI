package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
/**
 * Insert the type's description here.
 * Creation date: (18.03.2005 14:43:39)
 * @author: Shafigullin Ildar
 */
public class CDBC_WorkerObject {
    private final static java.lang.String findWorker_SQL =
        "SELECT  w.worker, w.mobilephone, w.lotusaddress,  w.phone2, w.isservicestuff, w.isactive, w.email, w.localphone, w.phone1, w.isour, w.fax, w.man, w.division, w.workposition, w.organization, w.company ,"
            + "TRIM(p.lastname) || NVL(' ' || TRIM(p.firstname) || NVL(' ' || TRIM(p.middlename),''),'') fullname, p.lastname, "
            + "TRIM(wp.name) wpname  "
            + "FROM workers w, people p,  workpositions wp "
            + "WHERE w.man = p.man AND w.workposition = wp.workposition ";
/**
 * CDBC_WorkerObject constructor comment.
 */
public CDBC_WorkerObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:06:12)
 */
public static CDBCResultSet findListWorkers(String filterStr, String aSortBy) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    //add query string: 
    sqlb.append(findWorker_SQL);
    //calculate filter clause
    sqlb.append("AND LOWER(p.lastname) MATCHES LOWER('" + filterStr + "') ");
    //append order by clause:
    sqlb.append("order by " + aSortBy);

    res.executeQuery(sqlb.toString(), null);

    return res;
}
}
