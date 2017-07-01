package com.hps.july.arenda.cdbcobjects;

import java.util.*;
import java.math.BigDecimal;
import java.sql.*;

import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.util.*;
import com.hps.july.terrabyte.ext.client.*;
import com.hps.july.terrabyte.core.*;
import com.hps.july.valueobject.*;

/**
 * Служебная записка по «Создание\Изменение ЗП» CDBC_Object.
 * Creation date: (07.11.2005 12:14:30)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeaseZPOfficeMemo_Object {
	public final static String TypeActionZP_create = "I";
	public final static String TypeActionZP_modify = "U";
	private static final String FIND_SQL =
		"SELECT idOfficeMemo, leasecontract, leaseDopContract, flagAddVendor, flagAddVendorSite, flagAddContract, TypeActionZP, idZP, oldSumZP, idVendorSite, idResource, SumCharge, sumZP, sumNdsZP, idCurrCharge, getNameCurrency(idCurrCharge, 0, 0) curName, dateStartZP, dateEndZp, reason, modified, created, createdby, modifiedby, rateNds, rateCalcRule, rateDelta, rateCalcRuleDay, rateFix "
			+ "FROM LeaseZPOfficeMemo ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE LeaseZPOfficeMemo SET leasecontract=?, leaseDopContract=?, flagAddVendor=?, flagAddVendorSite=?, flagAddContract=?, TypeActionZP=?, idZP=?, oldSumZP=?, idVendorSite=?, idResource=?, SumCharge=?, sumZP=?, sumNdsZP=?, idCurrCharge=?, dateStartZP=?, dateEndZp=?, reason=?, modified=?, created=?, createdby=?, modifiedby=?, rateNds=?, rateCalcRule=?, rateDelta=?, rateCalcRuleDay=?, rateFix=? "
			+ "WHERE idOfficeMemo =? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO LeaseZPOfficeMemo (idOfficeMemo, leasecontract, leaseDopContract, flagAddVendor, flagAddVendorSite, flagAddContract, TypeActionZP, idZP, oldSumZP, idVendorSite, idResource, SumCharge, sumZP, sumNdsZP, idCurrCharge, dateStartZP, dateEndZp, reason, modified, created, createdby, modifiedby, rateNds, rateCalcRule, rateDelta, rateCalcRuleDay, rateFix) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM LeaseZPOfficeMemo WHERE idOfficeMemo = ?";
	private static final String FIND_LIST_SQL = FIND_SQL + " WHERE 1=1 ";
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:04:50)
	 */
	public static final boolean add(LeaseZPOfficeMemo_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdOfficeMemo(),
				vo.getLeaseContract(),
				vo.getLeaseDopContract(),
				vo.getFlagAddVendor(),
				vo.getFlagAddVendorSite(),
				vo.getFlagAddContract(),
				vo.getTypeActionZP(),
				vo.getIdZP(),
				vo.getOldSumZP(),
				vo.getIdVendorSite(),
				vo.getIdResource(),
				vo.getSumCharge(),
				vo.getSumZP(),
				vo.getSumNdsZP(),
				vo.getIdCurrCharge(),
				vo.getDateStartZP(),
				vo.getDateEndZp(),
				vo.getReason(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy(),
				vo.getRateNds(),
				vo.getRateCalcRule(),
				vo.getRateDelta(),
				vo.getRateCalcRuleDay(),
				vo.getRateFix()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(LeaseZPOfficeMemo_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getIdOfficeMemo()};
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(LeaseZPOfficeMemo_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getLeaseContract(),
				vo.getLeaseDopContract(),
				vo.getFlagAddVendor(),
				vo.getFlagAddVendorSite(),
				vo.getFlagAddContract(),
				vo.getTypeActionZP(),
				vo.getIdZP(),
				vo.getOldSumZP(),
				vo.getIdVendorSite(),
				vo.getIdResource(),
				vo.getSumCharge(),
				vo.getSumZP(),
				vo.getSumNdsZP(),
				vo.getIdCurrCharge(),
				vo.getDateStartZP(),
				vo.getDateEndZp(),
				vo.getReason(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy(),
				vo.getRateNds(),
				vo.getRateCalcRule(),
				vo.getRateDelta(),
				vo.getRateCalcRuleDay(),
				vo.getRateFix(),
				vo.getIdOfficeMemo()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static LeaseZPOfficeMemo_TO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " WHERE idOfficeMemo = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeaseZPOfficeMemo_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			to = new LeaseZPOfficeMemo_TO(CDBC_MapFactory.createLeaseZPOfficeMemo(ro));
			to.setCurName(ro.getColumn("curName").asString());
		}
		return to;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getList(Integer mainLeaseContractKey, Integer searchFilter, String searchString, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LIST_SQL);
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		filter.append(" AND leasecontract = ? ");
		params.add(mainLeaseContractKey);
		/**		
				if (searchFilter.intValue() == 0) {
					filter.append(" AND typeRegistry = ? ");
					params.add(searchString);
				}
				else if (searchFilter.intValue() == 0) {
					filter.append(" AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastname) matches upper(?) ) ");
					params.add(searchString);
				}
				else if (searchFilter.intValue() == 0) {
					filter.append(" AND regionID = ? ");
					params.add(searchString);
				}
				else if (searchFilter.intValue() == 0) {
					filter.append(" AND owner IN ( SELECT man FROM operators WHERE operator=? ) ");
					params.add(searchString);
				}
		*/
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseZPOfficeMemo_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			//LeaseZPOfficeMemo_VO vo = CDBC_Helper.createLeaseZPOfficeMemo(ro);
			to = new LeaseZPOfficeMemo_TO(CDBC_MapFactory.createLeaseZPOfficeMemo(ro));
			to.setCurName(ro.getColumn("curName").asString());
			//to.setAccount(ro.getColumn("account").asString());
			//to.setBankName(ro.getColumn("bankName").asString());
			//to.setBankBik(ro.getColumn("bankBik").asString());
			//to.setVendorSiteName(ro.getColumn("vendorSiteName").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:31:05)
	 */
	public static String changeStateLeaseZPOfficeMemo(int idCode, String toState, int codeOperator) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = ""; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure changeStateLeaseZPOfficeMemo(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, idCode); //код 
			cs.setString(2, toState); //желаемое состояние 
			cs.setInt(3, codeOperator); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("Процедура 'changeStateLeaseZPOfficeMemo' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'changeStateLeaseZPOfficeMemo' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'changeStateLeaseZPOfficeMemo'"); //temp
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'changeStateLeaseZPOfficeMemo(?, ?, ?)'";
			System.out.println(errorTxt);
			catchMetod(ex);
		} finally {
			finallyMetod(con, cs, rs);
		}
		return errorTxt;

	}
	/**
		create procedure getSumZpOnArendaContract(
		--  $Header: /cvs/repository/webcommon/com/hps/july/arenda/cdbcobjects/CDBC_LeaseZPOfficeMemo_Object.java,v 1.8 2006/10/17 15:26:28 IShaffigulin Exp $
		--  Author: Борцов Д.
		--  Description: Определяем сумму ЗП  в заданном периоде
		--  execute procedure getSumZpOnArendaContract(3, "1.01.2004","31.12.2004", 840);
		  ABaseContract       integer,        -- код договора
		  ADateStart          date,           -- дата начала периода
		  ADateFinish         date,           -- дата окончания периода
		  ACurrency           integer         -- валюта в которой считаем
		)
		RETURNING
		 integer,          -- признак ошибки 0 - без ошибок
		 varchar(255),     -- текст ошибки
		 decimal(15,2),    -- сумма ЗП
		 decimal(15,2),    -- сумма НДС ЗП в т.ч.
		 decimal(15,2);    -- ставка НДС
	 */
	public static String fillSumZpOnArendaContract(LeaseZPOfficeMemo_VO vo) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = null; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure getSumZpOnArendaContract(?, ?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, vo.getLeaseContract().intValue()); //код договора 
			cs.setDate(2, vo.getDateStartZP()); //дата начала периодасостояние 
			cs.setDate(3, vo.getDateEndZp()); //дата окончания периода
			cs.setInt(4, vo.getIdCurrCharge().intValue());//валюта в которой считаем

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("Процедура 'getSumZpOnArendaContract' ok"); //temp
					BigDecimal sum = rs.getBigDecimal(3);
					BigDecimal nds = rs.getBigDecimal(4);
					//sum = sum.subtract(nds);
					vo.setSumZP(sum);
					vo.setSumNdsZP(nds);
					vo.setRateNds(rs.getBigDecimal(5));
					//BigDecimal monthBD = new BigDecimal(12);
					//vo.setSumCharge(vo.getSumZP().divide(monthBD, 2));
					vo.setSumCharge(rs.getBigDecimal(6));
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'getSumZpOnArendaContract' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'getSumZpOnArendaContract'"); //temp
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'getSumZpOnArendaContract(?, ?, ?)'";
			System.out.println(errorTxt);
			catchMetod(ex);
		} finally {
			finallyMetod(con, cs, rs);
		}
		return errorTxt;

	}
	/**
	 * 
	 * @param e
	 */
	private final static void catchMetod(Exception e) {
		if (e instanceof SQLException) {
			SQLException sqlExec = (SQLException) e;
			while (sqlExec != null) {
				System.out.println("Error code=" + sqlExec.getErrorCode());
				sqlExec = sqlExec.getNextException();
			}
		}
		e.printStackTrace(System.out);
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

}
