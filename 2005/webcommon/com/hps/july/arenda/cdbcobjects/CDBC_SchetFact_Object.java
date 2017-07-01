package com.hps.july.arenda.cdbcobjects;

import java.util.*;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import com.hps.july.terrabyte.ext.client.*;
import com.hps.july.terrabyte.core.*;
import com.hps.july.valueobject.*;

/**
 * "Счета-фактуры" CDBC_Object.
 * Creation date: (14.11.2006 12:14:30)
 * @author: Shafigullin Ildar
 */
public class CDBC_SchetFact_Object {
	private static final String FIND_SQL =
		"SELECT idSchetFakt, idContract, idAkt, idCurrency, numberSchetFakt, dateSchetFakt, baseDocNumber, baseDocDate, dateStartSf, dateEndSf, "
			+ "modified , created , createdBy, getNamePeople(createdby) createdByName, modifiedBy, getNamePeople(modifiedby) modifiedByName, state, getNameCurrency(idCurrency, 0, 0) curName, getSumSf(idSchetFakt) sumSf, getNdsSf(idSchetFakt) ndsSf "
			+ "FROM LeaseSchetFakt";
	private static final String FIND_LIST_SQL =
		"SELECT lf.idSchetFakt, lf.idContract, lf.idAkt, lf.idCurrency, lf.numberSchetFakt, lf.dateSchetFakt, lf.baseDocNumber, lf.baseDocDate, lf.dateStartSf, lf.dateEndSf, "
			+ "lf.modified , lf.created , lf.createdBy, lf.modifiedBy, lf.state, getNameCurrency(lf.idCurrency, 0, 0) curName, getSumSf(lf.idSchetFakt) sumSf, getNdsSf(lf.idSchetFakt) ndsSf, "
			+ "lb.idRegistryDoc as numRegistryDoc, date(lb.created) as dateRegistryDoc, getNumberFormatSF(lf.idSchetFakt) typeSF "
			+ "FROM LeaseSchetFakt lf, outer LeaseRegistryBuchDocs lb ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE LeaseSchetFakt SET idContract=?, idAkt =?, idCurrency =?, numberSchetFakt =?, dateSchetFakt =?, baseDocNumber =?, baseDocDate =?, dateStartSf=?, dateEndSf=?, "
			+ "modified=?, created =?, createdby=?, modifiedby=? "
			+ "WHERE idSchetFakt =? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO LeaseSchetFakt(idSchetFakt, idContract, idAkt, idCurrency, numberSchetFakt, dateSchetFakt, baseDocNumber, baseDocDate, dateStartSf, dateEndSf, modified , created , createdby, modifiedby) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM LeaseSchetFakt WHERE idSchetFakt = ?";
	private final static java.lang.String storeWord_SQL = "UPDATE LeaseSchetFakt SET acttext=?, actfilename=? WHERE idSchetFakt = ?";
	private final static java.lang.String findByQBE_SQL =
		"SELECT lf.idSchetFakt, lf.idContract, lf.idAkt, lf.idCurrency, lf.numberSchetFakt, lf.dateSchetFakt, lf.baseDocNumber, lf.baseDocDate, lf.dateStartSf, lf.dateEndSf, lf.modified , lf.created , lf.createdBy, lf.modifiedBy, lf.state, "
			+ "getNameCurrency(lf.idCurrency, 0, 0) curName, getSumSf(lf.idSchetFakt) sumSf, "
			+ "getNdsSf(lf.idSchetFakt) ndsSf,  getNameOrg(lc.orgexecutor) nameOrg,  ld.docdate, ld.docNumber, getNumberFormatSF(lf.idSchetFakt) typeSF "
			+ "FROM LeaseSchetFakt lf,  leasedocuments ld, leasecontracts lc ";

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:04:50)
	 */
	public static final boolean add(LeaseSchetFact_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdSchetFakt(),
				vo.getIdContract(),
				vo.getIdAkt(),
				vo.getIdCurrency(),
				vo.getNumberSchetFakt(),
				vo.getDateSchetFakt(),
				vo.getBaseDocNumber(),
				vo.getBaseDocDate(),
				vo.getDateStartSf(),
				vo.getDateEndSf(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(LeaseSchetFact_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getIdSchetFakt()};
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final String delete(Integer aID) {
		String returnStr = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		res.executeQuery("execute procedure deleteSchetFakt(?) ", params);
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
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(LeaseSchetFact_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdContract(),
				vo.getIdAkt(),
				vo.getIdCurrency(),
				vo.getNumberSchetFakt(),
				vo.getDateSchetFakt(),
				vo.getBaseDocNumber(),
				vo.getBaseDocDate(),
				vo.getDateStartSf(),
				vo.getDateEndSf(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy(),
				vo.getIdSchetFakt()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static LeaseSchetFact_VO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " WHERE idSchetFakt = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeaseSchetFact_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			//to = new LeaseSchetFact_VO(CDBC_Helper.createLoanAktGetPut(ro));
			//to.setOurManName(ro.getColumn("ourmanname").asString());
			vo = CDBC_Helper.createLeaseSchetFakt(ro);
			vo.setCreatedByName(ro.getColumn("createdByName").asString());
			vo.setModifiedByName(ro.getColumn("modifiedByName").asString());
		}
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getList(Integer loanContract, String sortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { loanContract };
		String sql = FIND_LIST_SQL + " WHERE lf.idRegistryDoc = lb.idRegistryDoc AND lf.idContract =? ";
		//append order by clause:
		if (sortBy != null)
			sql += " order by " + sortBy;
		System.out.println("SQL(idContract=" + loanContract + ")=" + sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		LeaseSchetFact_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new LeaseSchetFact_TO(CDBC_Helper.createLeaseSchetFakt(ro));
			to.setCurName(ro.getColumn("curName").asString());
			to.setSumSf((BigDecimal) ro.getColumn("sumSf").asObject());
			to.setNdsSf((BigDecimal) ro.getColumn("ndsSf").asObject());
			to.setNumRegistryDoc(ro.getColumn("numRegistryDoc").asString());
			to.setDateRegistryDoc((Date)ro.getColumn("dateRegistryDoc").asObject());
			to.setTypeSF(ro.getColumn("typeSF").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getListForCharge(Integer chargeCode, String sortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { chargeCode };
		String sql = FIND_LIST_SQL + " WHERE lf.idRegistryDoc = lb.idRegistryDoc AND lf.idSchetFakt IN (SELECT l2f.idSchetFakt FROM leaseSchetFakt2Charge l2f WHERE l2f.idCharge = ?) ";
		//append order by clause:
		if (sortBy != null)
			sql += " order by " + sortBy;
		System.out.println("SQL(chargeCode=" + chargeCode + ")=" + sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		LeaseSchetFact_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new LeaseSchetFact_TO(CDBC_Helper.createLeaseSchetFakt(ro));
			to.setCurName(ro.getColumn("curName").asString());
			to.setSumSf((BigDecimal) ro.getColumn("sumSf").asObject());
			to.setNdsSf((BigDecimal) ro.getColumn("ndsSf").asObject());
			to.setNumRegistryDoc(ro.getColumn("numRegistryDoc").asString());
			to.setDateRegistryDoc((Date)ro.getColumn("dateRegistryDoc").asObject());
			to.setTypeSF(ro.getColumn("typeSF").asString());
			ret.add(to);
		}
		return ret;
	}
	
	/**
	 * Insert the method's description here.
	 * Creation date: (17.11.2005 10:21:14)
	 */
	public final static WordDocument loadWordExternal(Integer id, String remoteUser) throws Exception {
		TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
		Document doc = client.getDocumentLastVersionByObject(id, ObjectTypes.ARENDA_INVOICE, remoteUser);
		java.io.InputStream stream = doc.getData();
		byte[] text = new byte[stream.available()];
		stream.read(text);
		stream.close();
		String filename = doc.getDocumentName();
		return new WordDocument(id, text, filename);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.11.2005 12:46:39)
	 */

	public final static boolean storeWord(int id, String filename, byte[] actText) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(storeWord_SQL);
			//данные:
			st.setBytes(1, actText);
			st.setString(2, filename);

			//входной параметр:
			st.setInt(3, id);

			if (st.executeUpdate() != 1) {
				System.out.println("storeWord :Id=" + id + " failed");
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
	 * Creation date: (17.11.2005 9:43:21)
	 */
	public final static void storeWordExternal(WordDocument doc, String remoteUser) throws Exception {
		//String host = com.hps.july.util.AppUtils.getNamedValueString("TERRABYTE_HOST");
		//int port = com.hps.july.util.AppUtils.getNamedValueInt("TERRABYTE_PORT");
		//String operator = "NRI";
		TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
		Integer nriType = DocumentTypes.ARENDA_INVOICE_2004;
		String mimeType = "application/msword";
		client.addObjectDocument(new java.io.ByteArrayInputStream(doc.getText()), doc.getFilename(), doc.getId(), ObjectTypes.ARENDA_INVOICE, remoteUser, nriType, mimeType);
		//client.addObjectDocument(doc, objectId, objectType, userName);    
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:31:05)
	 */
	public static String changeState(int idCode, String toState, int codeOperator) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = ""; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure changeStateSf(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, idCode); //код сф
			cs.setString(2, toState); //желаемое состояние сф
			cs.setInt(3, codeOperator); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("Процедура 'changeStateCompleteAct' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'changeStateSchetFact' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'changeStateSchetFact'"); //temp
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'changeStateSchetFact(?, ?, ?)'";
			System.out.println(errorTxt);
			if (ex instanceof SQLException) {
				errorTxt += "Error code=" + ((SQLException) ex).getErrorCode();
				System.out.println(errorTxt);
			}
			ex.printStackTrace();
		} finally {
			finallyMetod(con, cs, rs);
		}
		return errorTxt;

	}
	/**
	 * 
	 * @param con
	 * @param cs
	 * @param rs
	 */
	private static void finallyMetod(Connection con, CallableStatement cs, ResultSet rs) {
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
	 * Подготовка (предварительный расчет) счета-фактуры.
	Создание сч\ф по начислению аренды
	
	create procedure makeShfOnCharge(
	-- execute procedure makeShfOnCharge (1,1,1);
	--  $Header: /cvs/repository/webcommon/com/hps/july/arenda/cdbcobjects/CDBC_SchetFact_Object.java,v 1.28 2006/10/11 10:02:15 IShaffigulin Exp $
	--  Author: Борцов Д.
	--  Description: Создаем счет фактуру и позицию счета фактуры  
	-- на основании начисления аренды
	--  execute procedure makeShfOnCharge (1,1,1);
	i_Charge integer,      -- код начисления
	i_Currency integer,    -- валюта, в которой будем формировать счет фактуру
	i_Operator integer     -- код оператора
	)
	RETURNING
	integer,           -- Возвращает код ошибки
	char(500),         -- Текст ошибки
	integer,           -- Код сч\ф
	integer;           -- Код договора
	 * Creation date: (16.05.2003 14:49:47)
	 * @return java.lang.Object[]
	 */
	public static Object[] prepareShetFact(int chargeCode, int argCurrency, int operCode) {
		/**		
				try {
					Object[] ret = new Object[] { new Integer(0), "error: no data" };
					Connection con = null;
					Statement statement = null;
		
					try {
						con = new JdbcConnection().getConnection();
						statement = con.createStatement();
		
						String s = "execute procedure makeShfOnCharge(" + chargecode;
						if (argCurrency != null)
							s = s + ", " + argCurrency.intValue();
						s = s + ");";
						ResultSet rs = statement.executeQuery(s);
		
						if (rs.next()) {
							ret[0] = new Integer(rs.getInt(1));
							ret[1] = rs.getString(2);
						}
					} finally {
						try {
							if (statement != null)
								statement.close();
							if (con != null)
								con.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					return ret;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		*/
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Object[] ret = new Object[4];
		try {
			String sql = "execute procedure makeShfOnCharge(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, chargeCode); // код начисления
			cs.setInt(2, argCurrency); //валюта, в которой будем формировать счет фактуру
			cs.setInt(3, operCode); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				ret[0] = new Integer(result);
				ret[1] = rs.getString(2);//текст ошибки(если есть)
				ret[2] = new Integer(rs.getInt(3));//Код сч\ф
				ret[3] = new Integer(rs.getInt(4));//Код договора				
				if (result == 0) {
					System.out.println("Процедура 'makeShfOnCharge' ok"); //temp
				} else {
					System.out.println("Процедура 'makeShfOnCharge' errorTxt: " + ret[1]); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'makeShfOnCharge'"); //temp
			}

		} catch (Exception ex) {
			String errorTxt = "Error in execute procedure 'makeShfOnCharge(?, ?, ?)'";
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
	create procedure makeShfOnAkt(
	i_type integer, -- 1-трафик, 2-аренда, 0-трафик и аренда
	i_Akt integer,   -- код акта
	i_Rule integer default null,  -- правило формирования счетов фактур
	i_operator integer
	)
	RETURNING
	integer,           -- Возвращает код ошибки =1 без ошибок, иначе ошибки
	char(500);         -- Текст ошибки
	 */
	public static Object[] makeShfOnAkt(int i_type, int i_Akt, int i_rule, int operCode) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Object[] ret = new Object[2];
		try {
			String sql = "execute procedure makeShfOnAkt(?, ?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, i_type); //трафик
			cs.setInt(2, i_Akt); //код акта
			cs.setInt(3, i_rule); //правило формирования счетов фактур
			cs.setInt(4, operCode); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				ret[0] = new Integer(result);
				if (result == 0) {
					//ret[1] = rs.getString(2);
					System.out.println("Процедура 'makeShfOnAkt' ok"); //temp
				} else {
					String errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					ret[1] = errorTxt;
					System.out.println("Процедура 'makeShfOnAkt' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'makeShfOnAkt'"); //temp
			}

		} catch (Exception ex) {
			String errorTxt = "Error in execute procedure 'makeShfOnAkt(?, ?, ?, ?)'";
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
	 * findByQBE method comment.
	 */
	public static final List findByQBE(Integer idAct, Boolean isContractType, String typeContract, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(findByQBE_SQL);
		//calculate where clause
		StringBuffer whereClause = new StringBuffer();
		whereClause.append(" WHERE lf.idAkt = ? AND lf.idcontract = ld.leasedocument AND lc.leasedocument = ld.leasedocument ");
		params.add(idAct);

		if (isContractType.booleanValue()) {
			whereClause.append(
			//" AND lf.idContract IN (select lc.leasedocument from LeaseContracts lc where lc.contractType = ? AND lc.leasedocument= lf.idContract) ");
			"AND lc.contractType = ? ");
			params.add(typeContract);
		}

		//append order by clause:
		if (aSortBy != null)
			whereClause.append(" order by " + aSortBy);

		sqlb.append(whereClause);

		//executeQuery:
		//System.out.println("SQL clause CDBC_SchetFact_Object.findByQBE= " + sqlb);
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseSchetFact_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new LeaseSchetFact_TO(CDBC_Helper.createLeaseSchetFakt(ro));
			to.setCurName(ro.getColumn("curName").asString());
			to.setSumSf((BigDecimal) ro.getColumn("sumSf").asObject());
			to.setNdsSf((BigDecimal) ro.getColumn("ndsSf").asObject());
			to.setNameOrg(ro.getColumn("nameOrg").asString());
			to.setDocDate((java.sql.Date) ro.getColumn("docDate").asObject());
			to.setDocNumber(ro.getColumn("docNumber").asString());
			to.setTypeSF(ro.getColumn("typeSF").asString());
			
			ret.add(to);
		}
		return ret;
	}
}
