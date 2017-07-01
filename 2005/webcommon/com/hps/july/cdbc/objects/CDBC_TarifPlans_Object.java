package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.Date;
/**
* JDBC - Объект для работы с "Справочник тарифных планов".
* Creation date: (30.09.2004 11:22:21)
* @author: Shafigullin Ildar
*/
public final class CDBC_TarifPlans_Object {
	private final static java.lang.String findTarifPlan_SQL =
		"SELECT idTarifPlan, nameTarifPlan, codeTarifPlan, effective_date, expiration_date, useInNri FROM TarifPlans ";
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 11:49:47)
 */
public static CDBCResultSet findListTarifPlans(Boolean isNameTarifPlan, String nameTarifPlan, String aSortBy) {
	StringBuffer sqlb = new StringBuffer();
	CDBCResultSet res = new CDBCResultSet();
	//add query string: 
	sqlb.append(findTarifPlan_SQL + "WHERE useInNri='Y' ");
	//calculate filter clause
	if (isNameTarifPlan.booleanValue()) {
		sqlb.append("AND lower(nameTarifPlan) matches '" + nameTarifPlan.toLowerCase() + "' ");
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
		CDBCResultSet rs = CDBC_TarifPlans_Object.findListTarifPlans(Boolean.TRUE, "*", "nameTarifPlan");
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			TarifPlan_VO vo = new TarifPlan_VO(ro);
			count++;
			System.out.println(vo);
		}
		System.out.println("count=" + count);
	}
	////////////////////////////////////////////////////////////////////////
}
}
