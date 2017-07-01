package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.Date;
/**
* JDBC - Объект для работы с "Справочник услуг связи".
* Creation date: (30.09.2004 11:22:21)
* @author: Shafigullin Ildar
*/
public final class CDBC_BillingServices_Object {
	private final static java.lang.String findBillingServices_SQL =
		"SELECT idService, nameService, codeService, useInNri FROM BillingServices ";
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 11:49:47)
 */
public static CDBCResultSet findListBillingServices(Boolean isNameService, String nameService, String aSortBy) {
	StringBuffer sqlb = new StringBuffer();
	CDBCResultSet res = new CDBCResultSet();
	//add query string: 
	sqlb.append(findBillingServices_SQL + "WHERE useInNri='Y' ");
	//calculate filter clause
	if (isNameService.booleanValue()) {
		sqlb.append("AND lower(nameService) matches '" + nameService.toLowerCase() + "' ");
	}
	//append order by clause:
	sqlb.append("order by " + aSortBy);

	res.executeQuery(sqlb.toString(), null);

	return res;
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	boolean test1 = true;
	////////////////////////////////////////////////////////////////////	
	if (test1) {
		CDBCResultSet rs = CDBC_BillingServices_Object.findListBillingServices(Boolean.TRUE, "А*", "nameService");
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			BillingService_VO vo = new BillingService_VO(ro);
			count++;
			System.out.println(vo);
		}
		System.out.println("count=" + count);
	}
	////////////////////////////////////////////////////////////////////////
}
}
