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
public final class CDBC_Rates_Object {
	private final static java.lang.String findRetes_SQL =
		"SELECT currency,  getNameCurrency(currency,0,0) currName, ratetype, date, value FROM rates ";
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 11:49:47)
 */
public static CDBCResultSet findListRates(
    Integer ratetype,
    Boolean isCurrency,    Integer currency,
    Boolean isDataPerion,    java.sql.Date fromDate,    java.sql.Date toDate,
    String aSortBy) {
    StringBuffer sqlb = new StringBuffer();
    ArrayList params = new ArrayList();
    CDBCResultSet res = new CDBCResultSet();

    //add query string: 
    sqlb.append(findRetes_SQL + "WHERE ratetype= " + ratetype);
    //calculate filter clause
    if (isCurrency.booleanValue()) {
	    sqlb.append(" AND currency = ? ");
	    params.add(currency);
    }
    if (isDataPerion.booleanValue()) {
        sqlb.append(" AND date >= ? AND date <= ? ");
        params.add(fromDate);
        params.add(toDate);
    }
    //append order by clause:
    sqlb.append("order by " + aSortBy);

    res.executeQuery(sqlb.toString(), params.toArray());

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
