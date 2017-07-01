package com.hps.july.cdbc.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (01.11.2005 14:42:24)
 * @author: Shafigullin Ildar
 */
public class CDBC_Nfs_LnkUser_Object {
	private static final String FIND_SQL =
		"SELECT T1.personID, T1.idUserNFS, T1.login, T1.fullName, T1.flagWorkNRI, T1.recordStatus, T2.idUserNRI, T2.flagMain FROM nfs_users T1, nfs_lnkUser T2 ";
	private static final String deleteLink_SQL = "DELETE FROM nfs_lnkUser WHERE idUserNRI = ? AND personID = ? ";
	private static final String addLink_SQL = "INSERT INTO nfs_lnkUser(idUserNRI, personID, flagMain) VALUES (?,?,?) ";
	private static final String clearMainLink_SQL = "UPDATE nfs_lnkUser SET flagMain ='N' WHERE idUserNRI = ? ";
	private static final String setMainLink_SQL =
		"UPDATE nfs_lnkUser SET flagMain ='Y' WHERE idUserNRI = ? AND personID = ? ";

	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 14:54:07)
	 * @return java.util.List
	 */
	public final static java.util.List findList(
		Integer man,
		Boolean isLastName,
		String lastName,
		Boolean isIsActive,
		String isActive,
		String orderBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(FIND_SQL);
		sb.append(" WHERE T1.personID=T2.personID ");
		//calculate where clause:
		sb.append(" and T2.idUserNRI = ? ");
		params.add(man);
		if (isLastName.booleanValue()) {
			sb.append(" and upper(fullName) matches upper(?) ");
			params.add(lastName);
		}
		if (isIsActive.booleanValue()) {
			sb.append(" and recordStatus = ? ");
			params.add(isActive);
		}
		//append order by clause:
		if (orderBy != null)
			sb.append(" order by " + orderBy);
		System.out.println(sb.toString()); //temp
		res.executeQuery(sb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Nfs_Users_VO vo = CDBC_MapFactory.createNfs_Users(ro);
			PeopleToNfsUser_TO to = new PeopleToNfsUser_TO(vo);
			to.setIdUserNRI((Integer) ro.getColumn("idUserNRI").asObject());
			to.setFlagMain(ro.getColumn("flagMain").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:56:12)
	 * @param id int
	 */
	public static boolean deleteLink(int man, int personID) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(deleteLink_SQL);
			st.setInt(1, man);
			st.setInt(2, personID);

			if (st.executeUpdate() != 1) {
				System.out.println("Delete :nfs_lnkUser.personID=" + personID + " failed");
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("SQLException: CODE=" + e.getErrorCode());
			e.printStackTrace(System.out);
			return false;
		} finally {
			finallyMetod(con, st);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:56:12)
	 * @param id int
	 */
	public static boolean addLink(int man, int personID, String flagMain) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(addLink_SQL);
			st.setInt(1, man);
			st.setInt(2, personID);
			st.setString(3, flagMain);

			if (st.executeUpdate() != 1) {
				System.out.println("ADD :nfs_lnkUser.personID=" + personID + " failed");
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("SQLException: CODE=" + e.getErrorCode());
			e.printStackTrace(System.out);
			return false;
		} finally {
			finallyMetod(con, st);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:56:12)
	 * @param id int
	 */
	public static boolean setMainLink(int man, int personID) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			//ощищаем гл. пользователя:			
			con = jcon.getConnection();
			st = con.prepareStatement(clearMainLink_SQL);
			st.setInt(1, man);
			st.executeUpdate();
			//устанавливаем гл. пользователя:
			st = con.prepareStatement(setMainLink_SQL);
			st.setInt(1, man);
			st.setInt(2, personID);
			if (st.executeUpdate() != 1) {
				System.out.println("setMainLink :nfs_lnkUser.personID=" + personID + " failed");
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("SQLException: CODE=" + e.getErrorCode());
			e.printStackTrace(System.out);
			return false;
		} finally {
			finallyMetod(con, st);
		}
	}
	private static void finallyMetod(Connection con, PreparedStatement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
