/*
 * Created on 26.09.2006
 *
 * CDBC_Base_Object
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.sql.*;

/**
 * @author IShaffigulin
 *
 * CDBC_Base_Object
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_Base_Object {
	/**
	 * 
	 * @param con
	 * @param cs
	 * @param rs
	 */
	protected static final void finallyMetod(Connection con, Statement cs, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (cs != null)
				cs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	/**
	 * 
	 * @param e
	 */
	protected final static void catchMetod(Exception e) {
		if (e instanceof SQLException) {
			SQLException sqlExec = (SQLException) e;
			while (sqlExec != null) {
				System.out.println("Error code=" + sqlExec.getErrorCode());
				sqlExec = sqlExec.getNextException();
			}
		}
		e.printStackTrace(System.out);
	}
}
