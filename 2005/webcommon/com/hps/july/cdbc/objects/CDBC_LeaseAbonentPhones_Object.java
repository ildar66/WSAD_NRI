package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
/**
 * JDBC - Объект для работы с телефонами абонента.
 * Creation date: (01.09.2004 11:38:11)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeaseAbonentPhones_Object {
	private final static java.lang.String findPhones_SQL = "SELECT leasedocument, phonenumber, phonestatus, netstandard, imsi, ben, soc, socdescription, socstartdate FROM leaseabonentphones ";
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:43:04)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param idLeaseDoc java.lang.Integer
 */
public static CDBCResultSet findListPhones(Integer idLeaseDoc) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findPhones_SQL + "WHERE leasedocument = " + idLeaseDoc;
	//append order by clause:
	sql += " order by phonenumber";
	res.executeQuery(sql, null);
	return res;
}
}
