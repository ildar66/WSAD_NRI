package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.Date;
/**
* JDBC - Объект для работы с "Счета по абоненстским договорам".
* Creation date: (16.09.2004 14:43:55)
* @author: Shafigullin Ildar
*/
public class CDBC_AbonentBills_Object {
	private final static java.lang.String findAbonentBill_SQL =
		"SELECT leasebill, leasedocument, billdate, billnumber, billperiodstart, billperiodend, factbill, billstatus, billtype, getNdsAbonentBill(leasebill) sumNds, getSumAbonentBill(leasebill) sum FROM abonentbills ";
/**
 * Insert the method's description here.
 * Creation date: (17.09.2004 17:00:05)
 */
public static CDBCRowObject findAbonentBill(int Leasebill) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findAbonentBill_SQL + "WHERE Leasebill = " + Leasebill;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 15:27:19)
 */
public static CDBCResultSet findListAbonentBills(
    Boolean isLeaseDocument, Integer leaseDocument,
	Boolean isBillNumber, String billNumber,    
    Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, 
    Boolean isBillType, String billType,
	String aSortBy) {
	StringBuffer sqlb = new StringBuffer();
	CDBCResultSet res = new CDBCResultSet();
	Object[] params = null;
	//add query string: 
	sqlb.append(findAbonentBill_SQL + "WHERE 1=1 ");
	//calculate filter clause
	if (isLeaseDocument.booleanValue()) {
		sqlb.append("AND leaseDocument=" + leaseDocument +" ");
	}	
	if (isBillNumber.booleanValue()){
		sqlb.append("AND lower(billNumber) matches '" + billNumber.toLowerCase() + "' ");
	}
	if (isBillDate.booleanValue()) {
		sqlb.append("AND billDate >= ? AND billdate <=? ");
		params = new Object[]{fromBillDate, toBillDate};
	}
	if (isBillType.booleanValue()) {
		sqlb.append("AND billtype='"+billType+"' ");
	}
	//append order by clause:
	sqlb.append("order by " + aSortBy);
	
	res.executeQuery(sqlb.toString(), params);

	return res;
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) throws Exception{
	boolean test1 = true;
////////////////////////////////////////////////////////////////////	
	if (test1) {
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.util.Date d = format.parse("15.05.2003");
		java.sql.Date data = new java.sql.Date(d.getTime());
		CDBCResultSet rs =
			CDBC_AbonentBills_Object.findListAbonentBills(
				Boolean.TRUE,	new Integer(1834),
				Boolean.TRUE,	"*",
				Boolean.TRUE,	data, data,
				Boolean.FALSE,	null,
				"billnumber");
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			AbonentBill_VO vo = new AbonentBill_VO (ro);
			count++;
			System.out.println(vo);
		}
		System.out.println("count=" + count);
	}
////////////////////////////////////////////////////////////////////////	
}
}
