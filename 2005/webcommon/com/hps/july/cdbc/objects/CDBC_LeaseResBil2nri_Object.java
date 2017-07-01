package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
* JDBC - Объект для работы с "Соответствие между ресурсами Billing & NRI".
* Creation date: (09.09.2004 12:45:09)
* @author: Shafigullin Ildar
*/
public class CDBC_LeaseResBil2nri_Object {
	private final static java.lang.String findLeaseResBil2nri_SQL =
		"SELECT idrecord, idresbilling, resource, billresname, record_status, typeRes, isActive FROM leaseresbil2nri ";
/**
 * CDBC_LeaseResBil2nri_Object constructor comment.
 */
public CDBC_LeaseResBil2nri_Object() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 13:23:24)
 */
public static CDBCResultSet findListLeaseResBil2nri(
	Boolean isIdResBilling, String idResBilling,
	Boolean isBillResName, String billResName,
	Boolean isTypeRes, String typeRes,
	String aSortBy) {
	StringBuffer sqlb = new StringBuffer();
	CDBCResultSet res = new CDBCResultSet();
	//add query string: 
	sqlb.append(findLeaseResBil2nri_SQL + "WHERE isActive = 'Y' ");
	//calculate filter clause
	if (isIdResBilling.booleanValue())
		sqlb.append("AND lower(idResBilling) matches '" + idResBilling.toLowerCase() + "' ");
	if (isBillResName.booleanValue())
		sqlb.append("AND lower(billResName) matches '" + billResName.toLowerCase() + "' ");		
	if (isTypeRes.booleanValue())
		sqlb.append("AND typeRes = '"+typeRes+"' ");
	//append order by clause:
	sqlb.append("order by " + aSortBy);
	
	res.executeQuery(sqlb.toString(), null);

	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:46:54)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
	boolean test1 = true;
////////////////////////////////////////////////////////////////////	
	if (test1) {
		CDBCResultSet rs =
			CDBC_LeaseResBil2nri_Object.findListLeaseResBil2nri(
				Boolean.FALSE,
				null,
				Boolean.FALSE,
				null,
				Boolean.FALSE,
				null,
				"idresbilling");
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			LeaseResBil2nri_VO vo = new LeaseResBil2nri_VO (ro);
			count++;
			System.out.println(vo);
		}
		System.out.println("count=" + count);
	}
////////////////////////////////////////////////////////////////////////	
}
}
