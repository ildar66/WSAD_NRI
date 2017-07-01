package com.hps.july.cdbc.objects;

import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;

/**
 * Объект для работы с журналом изменений.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCLogObject {
	public static final Integer POSITION = new Integer(4);
	public static final Integer INSERT = new Integer(1);
	public static final Integer UPDATE = new Integer(2);
	public static final Integer DELETE = new Integer(3);
/**
 * CDBCLogObject constructor.
 */
public CDBCLogObject() {
	super();
}
/**
 * Вызов хранимой процедуры ChangesLog c передачей всех аргументов.
 * Creation date: (21.05.2004 17:18:12)
 * @return java.lang.Integer
 */
public Integer changesLog(Integer argObjType, Integer argPreObjId, Integer argPosObjId, Integer argEventType, Integer argMan) {
	Integer result = null;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	try {
		JdbcConnection jcon = new JdbcConnection();
		con = jcon.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("execute procedure changeslog(" + argObjType + ", " + argPreObjId + ", " +
			argPosObjId + ", " + argEventType + ", " + argMan + ")" );
		if (rs.next()) {
			result = (Integer)rs.getObject(1);
		}
	} catch (Exception ee) {
		ee.printStackTrace(System.out);
	} finally {
			try {
				rs.close();
			} catch (Exception e) {
				// Ignore error
			}
			try {
				st.close();
			} catch (Exception e) {
				// Ignore error
			}
			try {
				con.close();
			} catch (Exception e) {
				// Ignore error
			}
	}
	return result;
}
/**
 * Вызов хранимой процедуры ChangesLogDetails c передачей всех аргументов.
 * Creation date: (21.05.2004 17:18:12)
 * @return java.lang.Integer
 */
public void changesLogDetails(Integer argLogId, String argLabel, String argValBefore, String argValAfter) {
	Connection con = null;
	PreparedStatement st = null;
	try {
		JdbcConnection jcon = new JdbcConnection();
		con = jcon.getConnection();
		st = con.prepareStatement("execute procedure changeslogdetails(?, ?, ?, ?)");
		st.setInt(1, argLogId.intValue());
		st.setString(2, argLabel);
		st.setString(3, argValBefore);
		st.setString(4, argValAfter);
		st.execute();
	} catch (Exception ee) {
		ee.printStackTrace(System.out);
	} finally {
			try {
				st.close();
			} catch (Exception e) {
				// Ignore error
			}
			try {
				con.close();
			} catch (Exception e) {
				// Ignore error
			}
	}
}
}
