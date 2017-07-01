package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
 * JDBC - Объект для работы с позициями служебных записок.
 * Creation date: (26.08.2004 12:19:28)
 * @author: Shafigullin Ildar
 */
public class CDBC_MemoPos_Object {
	private final static java.lang.String findMemoPos_SQL =
		"SELECT idPos, idHeader, phoneNumber, tarifplan, comcardcnt, cardamount, simcardcnt, equipname, "
			+ "equipcnt, defectdescr, service, opertype, startdate, enddate, isgarantie, cardname, equipcode, idtarifplan, idservice, billdelivery, billaddress "
			+ "FROM OfficeMemoPos ";
	private final static java.lang.String deleteMemoPos_SQL = "DELETE FROM OfficeMemoPos WHERE idPos = ?";
	private final static java.lang.String addMemoPos_SQL =
		"INSERT INTO OfficeMemoPos(idPos, idHeader, phoneNumber, tarifplan, comcardcnt, cardamount, simcardcnt, equipname, "
			+ "equipcnt, defectdescr, service, opertype, startdate, enddate, isgarantie, cardname, equipcode, idtarifplan, idservice, billdelivery, billaddress) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String editMemoPos_SQL =
		"UPDATE OfficeMemoPos SET idHeader=?, phoneNumber=?, tarifplan=?, comcardcnt=?, cardamount=?, simcardcnt=?, equipname=?, "
			+ "equipcnt=?, defectdescr=?, service=?, opertype=?, startdate=?, enddate=?, isgarantie=?, cardname=?, equipcode=?, idtarifplan=?, idservice=?, billdelivery=?, billaddress=? "
			+ "WHERE idPos = ?";
/**
 * CDBC_MemoPos_Object constructor comment.
 */
public CDBC_MemoPos_Object() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 11:56:44)
 * @return boolean
 * @param memoPos com.hps.july.arenda.valueobject.MemoPos_VO
 * @exception java.lang.Exception The exception description.
 */
public static boolean addMemoPos(MemoPos_VO memoPos) throws java.lang.Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(addMemoPos_SQL);
		//обязательные поля(not null):
		st.setInt(1, memoPos.getIdPos().intValue());
		st.setInt(2, memoPos.getIdHeader().intValue());
		//необязательные поля(null):
		st.setString(3, memoPos.getPhoneNumber());
		st.setString(4, memoPos.getTarifplan());
		if (memoPos.getComcardcnt() != null)
			st.setInt(5, memoPos.getComcardcnt().intValue());
		else
			st.setObject(5, null);

		if (memoPos.getCardamount() != null)
			st.setBigDecimal(6, memoPos.getCardamount());
		else
			st.setObject(6, null);

		if (memoPos.getSimcardcnt() != null)
			st.setInt(7, memoPos.getSimcardcnt().intValue());
		else
			st.setObject(7, null);

		st.setString(8, memoPos.getEquipname());
		if (memoPos.getEquipcnt() != null)
			st.setInt(9, memoPos.getEquipcnt().intValue());
		else
			st.setObject(9, null);

		st.setString(10, memoPos.getDefectdescr());
		st.setString(11, memoPos.getService());
		st.setString(12, memoPos.getOpertype());
		if (memoPos.getStartdate() != null)
			st.setDate(13, memoPos.getStartdate());
		else
			st.setObject(13, null);
		if (memoPos.getEnddate() != null)
			st.setDate(14, memoPos.getEnddate());
		else
			st.setObject(14, null);

		if (memoPos.getIsgarantie() != null) {
			if (memoPos.getIsgarantie() == Boolean.TRUE)
				st.setString(15, "Y");
			else
				st.setString(15, "N");
		} else
			st.setObject(15, null);

		st.setString(16, memoPos.getCardname());

		if (memoPos.getEquipcode() != null)
			st.setInt(17, memoPos.getEquipcode().intValue());
		else
			st.setObject(17, null);
			
		if (memoPos.getIdTarifPlan() != null)
			st.setInt(18, memoPos.getIdTarifPlan().intValue());
		else
			st.setObject(18, null);
			
		if (memoPos.getIdService() != null)
			st.setInt(19, memoPos.getIdService().intValue());
		else
			st.setObject(19, null);
			
		if (memoPos.getBilldelivery() != null)
			st.setInt(20, memoPos.getBilldelivery().intValue());
		else
			st.setObject(20, null);
			
		st.setString(21, memoPos.getBilladdress());				

		if (st.executeUpdate() != 1) {
			System.out.println("Insert MemoPos:IdPos=" + memoPos.getIdPos() + " failed");
			return false;
		}
		return true;
	} catch (SQLException e) {
		System.out.println("SQLException: CODE=" + e.getErrorCode());
		e.printStackTrace(System.out);
		return false;
	} finally {
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
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 11:51:19)
 * @return boolean
 * @param idPos int
 * @exception java.lang.Exception The exception description.
 */
public static boolean deleteMemoPos(int idPos) throws java.lang.Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(deleteMemoPos_SQL);
		st.setInt(1, idPos);

		if (st.executeUpdate() != 1) {
			System.out.println("Delete MemoPos:IdPos=" + idPos + " failed");
			return false;
		}
		return true;
	} catch (SQLException e) {
		System.out.println("SQLException: CODE=" + e.getErrorCode());
		e.printStackTrace(System.out);
		return false;
	} finally {
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
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 12:28:06)
 * @return boolean
 * @param memoPos com.hps.july.arenda.valueobject.MemoPos_VO
 * @exception java.lang.Exception The exception description.
 */
public static boolean editMemoPos(MemoPos_VO memoPos) throws java.lang.Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(editMemoPos_SQL);
		//обязательные поля(not null):
		st.setInt(1, memoPos.getIdHeader().intValue());
		//необязательные поля(null):
		st.setString(2, memoPos.getPhoneNumber());
		st.setString(3, memoPos.getTarifplan());
		if (memoPos.getComcardcnt() != null)
			st.setInt(4, memoPos.getComcardcnt().intValue());
		else
			st.setObject(4, null);

		if (memoPos.getCardamount() != null)
			st.setBigDecimal(5, memoPos.getCardamount());
		else
			st.setObject(5, null);

		if (memoPos.getSimcardcnt() != null)
			st.setInt(6, memoPos.getSimcardcnt().intValue());
		else
			st.setObject(6, null);

		st.setString(7, memoPos.getEquipname());
		if (memoPos.getEquipcnt() != null)
			st.setInt(8, memoPos.getEquipcnt().intValue());
		else
			st.setObject(8, null);

		st.setString(9, memoPos.getDefectdescr());
		st.setString(10, memoPos.getService());
		st.setString(11, memoPos.getOpertype());
		if (memoPos.getStartdate() != null)
			st.setDate(12, memoPos.getStartdate());
		else
			st.setObject(12, null);
		if (memoPos.getEnddate() != null)
			st.setDate(13, memoPos.getEnddate());
		else
			st.setObject(13, null);

		if (memoPos.getIsgarantie() != null) {
			if (memoPos.getIsgarantie() == Boolean.TRUE)
				st.setString(14, "Y");
			else
				st.setString(14, "N");
		} else
			st.setObject(14, null);

		st.setString(15, memoPos.getCardname());

		if (memoPos.getEquipcode() != null)
			st.setInt(16, memoPos.getEquipcode().intValue());
		else
			st.setObject(16, null);
			
		if (memoPos.getIdTarifPlan() != null)
			st.setInt(17, memoPos.getIdTarifPlan().intValue());
		else
			st.setObject(17, null);
			
		if (memoPos.getIdService() != null)
			st.setInt(18, memoPos.getIdService().intValue());
		else
			st.setObject(18, null);

		if (memoPos.getBilldelivery() != null)
			st.setInt(19, memoPos.getBilldelivery().intValue());
		else
			st.setObject(19, null);
			
		st.setString(20, memoPos.getBilladdress());				
				
		//входной параметр:
		st.setInt(21, memoPos.getIdPos().intValue());

		if (st.executeUpdate() != 1) {
			System.out.println("Update MemoPos:IdPos=" + memoPos.getIdPos() + " failed");
			return false;
		}
		return true;
	} catch (SQLException e) {
		System.out.println("SQLException: CODE=" + e.getErrorCode());
		e.printStackTrace(System.out);
		return false;
	} finally {
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
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:28:21)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param idHeader java.lang.Integer
 */
public static CDBCResultSet findListMemoPos(Integer idHeader) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findMemoPos_SQL + "WHERE idHeader = " + idHeader;
	res.executeQuery(sql, null);
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 14:18:54)
 * @return com.hps.july.cdbc.lib.CDBCRowObject
 * @param idPos int
 */
public static CDBCRowObject findMemoPos(int idPos) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findMemoPos_SQL + "WHERE idPos = " + idPos;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:38:01)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
	boolean test1 = true;
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test1) {
		Integer idHeader = new Integer(37);
		CDBCResultSet rs = CDBC_MemoPos_Object.findListMemoPos(idHeader);
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			com.hps.july.arenda.valueobject.MemoPos_VO vo = new com.hps.july.arenda.valueobject.MemoPos_VO(ro);
			count++;
			System.out.println(vo);
		}
		System.out.println("count findListMemoPos =" + count);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
}
