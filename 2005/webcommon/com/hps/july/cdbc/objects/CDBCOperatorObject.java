package com.hps.july.cdbc.objects;

import java.util.ListIterator;

import com.hps.july.cdbc.lib.*;
/**
 * Insert the type's description here.
 * Creation date: (18.11.2004 12:57:58)
 * @author: Vadim Glushkov
 */
public class CDBCOperatorObject {
	/**
	 * CDBCOperatorObject constructor comment.
	 */
	public CDBCOperatorObject() {
		super();
	}
	
	/**
	 * ћетод поиска всех операторов дл€ физического лица.
	 * Creation date: (18.11.2004 13:00:09)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet
	 * @param man java.lang.Integer
	 */
	public com.hps.july.cdbc.lib.CDBCResultSet findOperatorsByMan(Integer man) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" 	o.operator as oper, o.loiginid as login, o.isenabled as e, ");
		sql.append(" 	m.msuser as ms");
		sql.append(" FROM ");
		sql.append(" 	operators o, outer msusers m ");
		sql.append(" WHERE ");
		sql.append("	m.msucode = o.msucode AND o.man = ? ");

		if(man == null) man = new Integer(-1);

		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sql.toString(), new Object [] { man });
		return rs;
	}
	
	public static Integer findManByOperator(String argOperator) {
		Integer result = null;
		
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery("SELECT man FROM operators WHERE loiginid = ?", new Object [] { argOperator });
		ListIterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			result = (Integer)ro.getColumn("man").asObject();
		}
		
		return result;
	}
	
	public static String findFullNameByOperator(String argOperator) {
		String result = null;
		
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery("SELECT p.man, TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename) name " +			"FROM operators o, people p WHERE o.loiginid = ? AND p.man = o.man", new Object [] { argOperator });
		ListIterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			result = ro.getColumn("name").asString();
		}
		return result;
	}
}
