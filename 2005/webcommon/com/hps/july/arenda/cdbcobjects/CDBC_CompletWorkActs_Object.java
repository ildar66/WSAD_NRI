package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
* JDBC - Объект для работы с "Акт-ами выполненных работ".
* Creation date: (25.10.2004 18:19:10)
* @author: Shafigullin Ildar
*/
public class CDBC_CompletWorkActs_Object extends CDBC_Base_Object {
	private final static java.lang.String findCompletWorkActs_SQL =
		"SELECT idcwacode, docdate, docnumber, idContract, currency, getNameCurrency(currency,0,0) currName, actSum, actNds, actstate, actstartdate, actenddate, acttext, actfilename, nameWork, editByHand, created, createdBy, getNamePeople(createdby) createdByName, modified, modifiedBy, getNamePeople(modifiedby) modifiedByName  "
			+ "FROM CompletWorkActs ";
	private final static String findCompletWorkActsList_SQL =
		"SELECT cwa.idcwacode, cwa.docdate, cwa.docnumber, cwa.idContract, cwa.currency, getNameCurrency(cwa.currency,0,0) currName, cwa.actSum, cwa.actNds, cwa.actstate, cwa.actstartdate, cwa.actenddate, cwa.acttext, cwa.actfilename, cwa.nameWork, cwa.editByHand, cwa.created, cwa.createdBy, cwa.modified, cwa.modifiedBy,  "
			+ "lb.idRegistryDoc as numRegistryDoc, date(lb.created) as dateRegistryDoc "
			+ "FROM CompletWorkActs cwa, outer LeaseRegistryBuchDocs lb ";
	private final static java.lang.String editCompletWorkAct_SQL =
		"UPDATE CompletWorkActs SET docdate=?, docnumber=?, idContract=?, currency=?, actSum=?, actNds=?, actstate=?, actstartdate=?, actenddate=?, actfilename=?, nameWork=?, editByHand=?, created=?, createdBy=?, modified=?, modifiedBy=? "
			+ "WHERE idcwacode = ?";
	private final static java.lang.String addCompletWorkAct_SQL =
		"INSERT INTO CompletWorkActs(idcwacode, docdate, docnumber, idContract, currency, actSum, actNds, actstate, actstartdate, actenddate, acttext, actfilename, nameWork, editByHand, created, createdBy, modified, modifiedBy) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String deleteCompletWorkAct_SQL = "DELETE FROM CompletWorkActs WHERE idcwacode = ?";
	private final static java.lang.String storeWord_SQL = "UPDATE CompletWorkActs SET acttext=?, actfilename=? " + "WHERE idcwacode = ?";

	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2004 18:25:10)
	 */
	public static boolean addCompletWorkAct(CompletWorkAct_VO cwaVO) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(addCompletWorkAct_SQL);
			//обязательные поля(not null):
			st.setInt(1, cwaVO.getIdcwacode().intValue());
			st.setDate(2, cwaVO.getDocdate());
			st.setString(3, cwaVO.getDocnumber());
			st.setInt(4, cwaVO.getIdContract().intValue());
			st.setInt(5, cwaVO.getCurrency().intValue());
			st.setBigDecimal(6, cwaVO.getActSum());
			st.setBigDecimal(7, cwaVO.getActNds());
			st.setString(8, cwaVO.getActstate());
			st.setDate(9, cwaVO.getActstartdate());
			st.setDate(10, cwaVO.getActenddate());
			//необязательные поля(null):
			st.setBytes(11, cwaVO.getActtext());
			st.setString(12, cwaVO.getActfilename());
			st.setString(13, cwaVO.getNameWork());
			st.setString(14, (cwaVO.isEditByHand() == true) ? "Y" : "N");
			st.setTimestamp(15, cwaVO.getCreated());
			if (cwaVO.getCreatedBy() != null)
				st.setInt(16, cwaVO.getCreatedBy().intValue());
			else
				st.setObject(16, null);
			st.setTimestamp(17, cwaVO.getModified());
			if (cwaVO.getModifiedBy() != null)
				st.setInt(18, cwaVO.getModifiedBy().intValue());
			else
				st.setObject(18, null);

			if (st.executeUpdate() != 1) {
				System.out.println("Add CompletWorkAct:Idcwacode=" + cwaVO.getIdcwacode() + " failed");
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
	 * Creation date: (04.11.2004 14:31:05)
	 */
	public static String changeActState(int idcwacode, String toActState, int operatorCode) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = ""; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure changeStateCompleteAct(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, idcwacode); //код акта
			cs.setString(2, toActState); //желаемое состояние акта
			cs.setInt(3, operatorCode); //код оператора	
			System.out.println("Процедура 'changeStateCompleteAct' idcwacode= " + idcwacode + " toActState=" + toActState + " operatorCode=" + operatorCode); //temp
			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("Процедура 'changeStateCompleteAct' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'changeStateCompleteAct' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'changeStateCompleteAct'"); //temp
			}

		} catch (Exception ex) {
			System.out.println("Error in execute procedure 'changeStateCompleteAct'. CDBC_CompletWorkActs_Object.changeStateCompleteAct(?, ?, ?)");
			if (ex instanceof SQLException) {
				System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
			}
			ex.printStackTrace();
		} finally {
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
		return errorTxt;

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:56:12)
	 * @param id int
	
	public static boolean deleteCompletWorkAct(int idcwacode) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(deleteCompletWorkAct_SQL);
			st.setInt(1, idcwacode);

			if (st.executeUpdate() != 1) {
				System.out.println("Delete CompletWorkAct:idcwacode=" + idcwacode + " failed");
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
 */	
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2004 14:33:30)
	 */
	public static boolean editCompletWorkAct(CompletWorkAct_VO cwaVO) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(editCompletWorkAct_SQL);
			//обязательные поля(not null):
			st.setDate(1, cwaVO.getDocdate());
			st.setString(2, cwaVO.getDocnumber());
			st.setInt(3, cwaVO.getIdContract().intValue());
			st.setInt(4, cwaVO.getCurrency().intValue());
			st.setBigDecimal(5, cwaVO.getActSum());
			st.setBigDecimal(6, cwaVO.getActNds());
			st.setString(7, cwaVO.getActstate());
			st.setDate(8, cwaVO.getActstartdate());
			st.setDate(9, cwaVO.getActenddate());
			//необязательные поля(null):
			//st.setBytes(10, cwaVO.getActtext());
			st.setString(10, cwaVO.getActfilename());
			st.setString(11, cwaVO.getNameWork());
			st.setString(12, (cwaVO.isEditByHand() == true) ? "Y" : "N");
			st.setTimestamp(13, cwaVO.getCreated());
			if (cwaVO.getCreatedBy() != null)
				st.setInt(14, cwaVO.getCreatedBy().intValue());
			else
				st.setObject(14, null);
			st.setTimestamp(15, cwaVO.getModified());
			if (cwaVO.getModifiedBy() != null)
				st.setInt(16, cwaVO.getModifiedBy().intValue());
			else
				st.setObject(16, null);

			//входной параметр:
			st.setInt(17, cwaVO.getIdcwacode().intValue());

			if (st.executeUpdate() != 1) {
				System.out.println("Update CompletWorkAct:Idcwacode=" + cwaVO.getIdcwacode() + " failed");
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
	 * Creation date: (29.10.2004 13:17:08)
	 * @param idcwacode int
	 */
	public static CDBCRowObject findCompletWorkAct(int idcwacode) {
		CDBCResultSet res = new CDBCResultSet();
		String sql = findCompletWorkActs_SQL + "WHERE idcwacode = " + idcwacode;
		res.executeQuery(sql, null);
		ListIterator list = res.listIterator();
		if (list.hasNext())
			return (CDBCRowObject) list.next();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.09.2004 13:23:24)
	 */
	public static CDBCResultSet findListCompletWorkActs(Boolean isIdContract, Integer idContract, String aSortBy) {
		StringBuffer sqlb = new StringBuffer();
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idContract };
		//add query string: 
		sqlb.append(findCompletWorkActsList_SQL + " WHERE cwa.idRegistryDoc = lb.idRegistryDoc ");
		//calculate filter clause
		if (isIdContract.booleanValue())
			sqlb.append(" AND cwa.idContract = ? ");

		//append order by clause:
		sqlb.append(" order by " + aSortBy);
		System.out.println("SQL(idContract=" + idContract + ")=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params);

		return res;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.09.2004 13:23:24)
	 */
	public static CDBCResultSet findListCompletWorkActsForCharge(Integer chargeCode, String aSortBy) {
		StringBuffer sqlb = new StringBuffer();
		CDBCResultSet res = new CDBCResultSet();
		//add query string: 
		sqlb.append(findCompletWorkActsList_SQL);
		//calculate filter clause
		sqlb.append(" WHERE cwa.idRegistryDoc = lb.idRegistryDoc AND cwa.idCWACode IN (SELECT cwa2ch.idCWACode FROM completWorkAct2Charge cwa2ch WHERE cwa2ch.idCharge = ?) ");
		Object[] params = { chargeCode };
		//append order by clause:
		if (aSortBy != null) {
			sqlb.append(" order by " + aSortBy);
		}
		System.out.println("SQL(chargeCode=" + chargeCode + ")=" + sqlb.toString()); //temp	
		res.executeQuery(sqlb.toString(), params);

		return res;
	}
	/**
	 * Получаем должность и ФИО руководителя организации .
	 * Creation date: (30.03.2005 12:26:56)
	 */
	public static WorkerVO getFioDoljnForAct(Integer i_idcwacode) {
		/**
		* i_organization integer,           -- код организации
		* i_typeAct char(1),                 -- тип акта {S-сверка, А-взаимохзачет, М-зачет взаимных требований, R-акты выполненных работ }
		* i_date date default null
		 */
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { i_idcwacode };
		String sql = "execute procedure printCompleteAct2(?)";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		WorkerVO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = new WorkerVO();
			vo.setName(ro.getColumn("col1").asString());
			WorkPositions_VO wp = new WorkPositions_VO();
			wp.setName(ro.getColumn("col2").asString());
			vo.setPosition(wp);
		}
		return vo;
	}
	/**
	 * Получаем должность и ФИО руководителя организации .
	 * Creation date: (30.03.2005 12:26:56)
	 */
	public static OrganizationVO getOrgCustomerForAct(Integer i_idcwacode) {
		/**
		* i_org integer,           -- код организации
		* i_date date
		 */
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { i_idcwacode };
		String sql = "execute procedure printCompleteAct1(?)";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		OrganizationVO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = new OrganizationVO();
			vo.setOrganization((Integer) ro.getColumn("col1").asObject());
			vo.setName(ro.getColumn("col2").asString());
		}
		return vo;
	}
	/**
	 * 
	 * @param i_idcwacode
	 * @return
	 * create procedure printCompleteAct(
		--execute procedure printCompleteAct (1276);
		--  $Header: /cvs/repository/webcommon/com/hps/july/arenda/cdbcobjects/CDBC_CompletWorkActs_Object.java,v 1.15 2007/06/19 07:00:19 IShaffigulin Exp $
		--  Author: Борцов Д.
		--  Description: Переопределяем организацию Beeline
		--  в зависимости от типа акта
		  i_idcwacode integer -- код акта
		 )
		RETURNING
		integer,         -- код Заказчика
		varchar(255),    -- Наименование Заказчика
		char(80),        -- ФИО Заказчика
		char(255),       -- должность  Заказчика
		char(255),       -- наименование исполнителя
		char(255);       -- адрес исполнителя
	 */
	public static PrintComplectAct_TO getPrintComplectAct_TO(Integer i_idcwacode) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { i_idcwacode };
		String sql = "execute procedure printCompleteAct(?)";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		PrintComplectAct_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			//исполнитель: 
			OrganizationVO orgVO = new OrganizationVO();
			orgVO.setOrganization((Integer) ro.getColumn("col1").asObject()); //
			orgVO.setName(ro.getColumn("col2").asString()); //наименование исполнителя
			//Получаем должность и ФИО Заказчика:		
			WorkerVO workVO = new WorkerVO((Integer) ro.getColumn("col1").asObject()); //код Заказчика
			workVO.setName(ro.getColumn("col3").asString()); //Наименование Заказчика
			WorkPositions_VO wp = new WorkPositions_VO();
			wp.setName(ro.getColumn("col4").asString()); //должность  Заказчика
			workVO.setPosition(wp);
			to = new PrintComplectAct_TO(orgVO, workVO);
			to.setExecutorName(ro.getColumn("col5").asString());
			to.setExecutorAddress(ro.getColumn("col6").asString());
			to.setExecutorFio(ro.getColumn("col7").asString());
			to.setExecutorWorkPosition(ro.getColumn("col8").asString());
			to.setPositionName(ro.getColumn("col9").asString());
		}
		return to;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 15:17:30)
	 */
	public static String initCompletWorkAct(CompletWorkAct_VO vo) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = ""; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure initCompleteAct(?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, vo.getIdContract().intValue()); //код базового договора.

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("Процедура 'initCompleteAct' ok"); //temp
					vo.setActSum(rs.getBigDecimal(3));
					vo.setActNds(rs.getBigDecimal(4));
					vo.setNdsRate(rs.getBigDecimal(5));
					vo.setCurrency(new Integer(rs.getInt(6)));
					vo.setDocdate(rs.getDate(7));
					vo.setActstartdate(rs.getDate(8));
					vo.setActenddate(rs.getDate(9));
					vo.setNameWork(rs.getString(10));
					vo.setDocnumber(rs.getString(12));
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'initCompleteAct' errorTxt: " + errorTxt);
				}
			} else {
				System.out.println("no DATA: execute procedure 'initCompleteAct'");
			}

		} catch (Exception ex) {
			System.out.println("Error in execute procedure 'initCompleteAct'. CDBC_CompletWorkActs_Object.initCompleteAct(?, ?)");
			if (ex instanceof SQLException) {
				System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
			}
			ex.printStackTrace();
		} finally {
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
		return errorTxt;

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.10.2004 18:38:37)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		boolean test1 = true;
		////////////////////////////////////////////////////////////////////	
		if (test1) {
			Integer idContract = new Integer(4271);
			CDBCResultSet rs = CDBC_CompletWorkActs_Object.findListCompletWorkActs(Boolean.TRUE, idContract, "idContract");
			java.util.ListIterator it = rs.listIterator();
			int count = 0;
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject) it.next();
				CompletWorkAct_VO vo = new CompletWorkAct_VO(ro);
				count++;
				System.out.println(vo);
			}
			System.out.println("count=" + count);
		}
		////////////////////////////////////////////////////////////////////////	
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2004 14:33:30)
	 */
	public static boolean storeWord(int idcwacode, String actfilename, byte[] actText) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(storeWord_SQL);
			//данные:
			st.setBytes(1, actText);
			st.setString(2, actfilename);

			//входной параметр:
			st.setInt(3, idcwacode);

			if (st.executeUpdate() != 1) {
				System.out.println("storeWord CompletWorkAct:Idcwacode=" + idcwacode + " failed");
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
	 * Создание акта
	 * @param chargeCode
	 * @param argCurrency
	 * @param operCode
	 * @return
	 */
	public final static Object[] prepareCWA(int chargeCode, Integer argCurrency, int operCode) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Object[] ret = new Object[4];
		try {
			String sql = "execute procedure  makeCwActOnCharge(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, chargeCode); // код начисления
			if (argCurrency == null) {
				cs.setNull(2, Types.INTEGER); //валюта, в которой будем формировать счет фактуру
			} else {
				cs.setInt(2, argCurrency.intValue()); //валюта, в которой будем формировать счет фактуру
			}
			cs.setInt(3, operCode); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				ret[0] = new Integer(result);
				ret[1] = rs.getString(2); //текст ошибки(если есть)
				ret[2] = new Integer(rs.getInt(3)); //Код акта
				ret[3] = new Integer(rs.getInt(4)); //Код договора				
				if (result == 0) {
					System.out.println("Процедура 'makeCwActOnCharge' ok"); //temp
				} else {
					System.out.println("Процедура 'makeCwActOnCharge' errorTxt: " + ret[1]); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'makeCwActOnCharge'"); //temp
			}

		} catch (Exception ex) {
			String errorTxt = "Error in execute procedure 'makeCwActOnCharge(?, ?, ?)'";
			System.out.println(errorTxt);
			if (ex instanceof SQLException) {
				errorTxt += "Error code=" + ((SQLException) ex).getErrorCode();
				ret[1] = errorTxt;
				System.out.println(errorTxt);
			}
			ex.printStackTrace();
		} finally {
			finallyMetod(con, cs, rs);
		}
		return ret;
	}
	/**
	 * deleteCWA procedure.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final String delete(Integer aID) {
		String returnStr = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		res.executeQuery("execute procedure deleteCwAct(?) ", params);
		ListIterator iter = res.listIterator();
		if (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			int ok = ((Integer) ro.getColumn("col1").asObject()).intValue();
			if (ok != 0)
				returnStr = ro.getColumn("col2").asString();
		} else {
			returnStr = "Ошибка записи(смотри лог)";
		}
		return returnStr;
	}
}
