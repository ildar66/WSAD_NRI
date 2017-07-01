package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
/**
 * Insert the type's description here.
 * Creation date: (16.11.2004 15:50:43)
 * @author: Vadim Glushkov
 */
public class CDBCMSUserObject {

	public CDBCMSUserObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.11.2004 15:56:20)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet
	 * @param name java.lang.String
	 */
	public com.hps.july.cdbc.lib.CDBCResultSet findByName(String name) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" 	m.msucode, m.msuser ");
		sql.append(" FROM ");
		sql.append(" 	msusers m ");
		sql.append(" WHERE ");
		sql.append(" 	UPPER(m.msuser) MATCHES UPPER(?) ");
		sql.append(" ORDER BY ");
		sql.append(" 	m.msuser ");

		if(name == null) name = "";
		StringBuffer nameSb = new StringBuffer(name);
		int c = name.indexOf("*");
		if(c == -1) {
			nameSb.insert(0, '*');
			if(nameSb.length() > 1) nameSb.append('*');
		}
		
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sql.toString(), new Object [] { nameSb.toString() });
		return rs;
	}
}
