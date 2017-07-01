package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с работниками.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCWorkerObject {
/**
 * CDBCPositionObject constructor comment.
 */
public CDBCWorkerObject() {
	super();
}
/**
 * Возвращает список работников по указанному паттерну
 */
public CDBCResultSet findWorkerByLastName( String pattern ) {
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(
		"SELECT w.worker worker, TRIM(p.lastname) || NVL(' ' || TRIM(p.firstname) || NVL(' ' || TRIM(p.middlename),''),'') fullname, w.workposition wp, TRIM(wp.name) wpname, w.division, TRIM(d.name) divisionname "+
		"FROM workers w, people p, divisions d, workpositions wp "+
		"WHERE w.man = p.man AND w.division = d.division AND w.workposition = wp.workposition AND LOWER(p.lastname) MATCHES LOWER(?) "+
		"ORDER BY fullname ",
		new Object[] { pattern }
	);
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2004 16:03:42)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
	CDBCWorkerObject o = new CDBCWorkerObject();
	CDBCResultSet rs = o.findWorkerByLastName("d*");
	java.util.ListIterator it = rs.listIterator();
	System.out.println("start");
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		CDBCColumnObject co1 = (CDBCColumnObject)ro.getColumn("worker");
		CDBCColumnObject co2 = (CDBCColumnObject)ro.getColumn("fullname");
		System.out.println("" + co1.asObject() + "  '" + co2.asString() + "'");
	}
}
}
