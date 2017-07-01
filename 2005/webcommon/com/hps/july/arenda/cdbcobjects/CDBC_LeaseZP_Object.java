package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
/**
** JDBC - Объект для работы с таблицей БД leaseZP "Связь с заказами на приобретение (NFS)".
* Creation date: (18.11.2004 12:26:23)
* @author: Shafigullin Ildar
*/
public class CDBC_LeaseZP_Object {
	private final static java.lang.String findLeaseZP_SQL = "SELECT docdate, docnumber FROM leasedocuments ld, leaseZP lzp WHERE ld.leasedocument = lzp.leasedocument ";
/**
 * Insert the method's description here.
 * Creation date: (18.11.2004 12:35:39)
 */
public static CDBCRowObject findLeaseZpFromIdZpNfs(Integer idzpnfs) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findLeaseZP_SQL + "AND lzp.idzpnfs = " + idzpnfs;
	res.executeQuery(sql, null);
	java.util.ListIterator list = res.listIterator();
	if (list.hasNext()) {
		return (CDBCRowObject) list.next();
	} else {
		return null;
	}
}
}
