package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import java.sql.Date;
/**
* JDBC - Объект для работы с "Информацией о доставке счетов абонентских договоров."
* Creation date: (20.01.2005 11:09:03)
* @author: Shafigullin Ildar
*/
public class CDBC_CourierDelivery_Object {
    private final static java.lang.String findCourierDelivery_SQL =
        "SELECT idrecord, leasedocument, ban, ben, sys_creation_date, document_no, document_type, delivery_date, delivery_status, courier_code, memo, record_status FROM courierdelivery ";
/**
 * CDBC_CourierDelivery_Object constructor comment.
 */
public CDBC_CourierDelivery_Object() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:15:46)
 */
public static CDBCResultSet findListCourierDelivery(
    Integer idLeaseDocument,
    Boolean isDocument_No,    String document_No,
    Boolean isDate,    Date fromDate,    Date toDate,
    String aSortBy) {
	    
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    Object[] args = null;
    //add query string: 
    sqlb.append(findCourierDelivery_SQL + " WHERE leasedocument= " + idLeaseDocument + " ");
    //calculate filter clause
    if (isDocument_No.booleanValue())
        sqlb.append(" AND document_no matches '" + document_No + "' ");
    if (isDate.booleanValue()) {
        sqlb.append(" AND delivery_date >= ? AND delivery_date <= ? ");
        args = new Object[] { fromDate, toDate };
    }
    //append order by clause:
    sqlb.append(" order by " + aSortBy);
	System.out.println("findListCourierDelivery sql="+ sqlb);//temp
    res.executeQuery(sqlb.toString(), args);

    return res;
}
}
