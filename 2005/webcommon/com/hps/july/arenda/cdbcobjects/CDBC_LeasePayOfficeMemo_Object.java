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
 * "Служебные записки на оплату" CDBC_Object.
 * Creation date: (07.11.2005 12:14:30)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeasePayOfficeMemo_Object {
	public final static int typeRegistry_SF = 1;
	public final static int typeRegistry_CWA = 2;
	public final static int typeRegistry_LeaseDoc = 3;
	private static final String FIND_SQL =
		"SELECT idOfficeMemo, leasecontract, beginDate, endDate, flagAvans, flag3face, sum, nds, currency, getNameCurrency(currency, 0, 0) curName, ruleRate, orgAcc, Purpose, PP104, PP105, PPqueue, PPStatus, state, modified, created, createdby, modifiedby, sumrub, ndsrub, billdate, billnumber, ratecalcrule, ratecalcruleday, ratedelta, rateDate, rateValue, rateNds, idZpNfs  "
			+ "FROM LeasePayOfficeMemo ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE LeasePayOfficeMemo SET leasecontract=?, beginDate=?, endDate=?, flagAvans=?, flag3face=?, sum=?, nds=?, currency=?, ruleRate=?, orgAcc=?, Purpose=?, PP104=?, PP105=?, PPqueue=?, PPStatus=?, state=?, modified=?, created=?, createdby=?, modifiedby=?, sumrub=?, ndsrub=?, billdate=?, billnumber=?, ratecalcrule=?, ratecalcruleday=?, ratedelta=?, rateDate=?, rateValue=?, rateNds=?, idZpNfs=? "
			+ "WHERE idOfficeMemo =? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO LeasePayOfficeMemo (idOfficeMemo, leasecontract, beginDate, endDate, flagAvans, flag3face, sum, nds, currency, ruleRate, orgAcc, Purpose, PP104, PP105, PPqueue, PPStatus, state, modified, created, createdby, modifiedby, sumrub, ndsrub, billdate, billnumber, ratecalcrule, ratecalcruleday, ratedelta, rateDate, rateValue, rateNds, idZpNfs) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM LeasePayOfficeMemo WHERE idOfficeMemo = ?";
	private static final String FIND_LIST_SQL =
		"SELECT lp.idOfficeMemo, lp.leasecontract, lp.beginDate, lp.endDate, lp.flagAvans, lp.flag3face, lp.sum, lp.nds, lp.currency, getNameCurrency(currency, 0, 0) curName, lp.ruleRate, lp.orgAcc, lp.Purpose, lp.PP104, lp.PP105, lp.PPqueue, lp.PPStatus, lp.state, lp.modified, lp.created, lp.createdby, lp.modifiedby, lp.sumrub, lp.ndsrub, lp.billdate, lp.billnumber, lp.ratecalcrule, lp.ratecalcruleday, lp.ratedelta, lp.rateDate, lp.rateValue, lp.rateNds, lp.idZpNfs, "
			+ "vs.name vendorSiteName, acc.account account, b.name bankName, b.bik bankBik "
			+ "FROM LeasePayOfficeMemo lp, vendorSites vs, accounts acc, banks b WHERE lp.orgAcc = acc.accountID AND acc.bank = b.idBank AND acc.idVendorSite = vs.idVendorSite ";

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:04:50)
	 */
	public static final boolean add(LeasePayOfficeMemo_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdOfficeMemo(),
				vo.getLeaseContract(),
				vo.getBeginDate(),
				vo.getEndDate(),
				vo.getFlagAvans(),
				vo.getFlag3face(),
				vo.getSum(),
				vo.getNds(),
				vo.getCurrency(),
				vo.getRuleRate(),
				vo.getOrgAcc(),
				vo.getPurpose(),
				vo.getPp104(),
				vo.getPp105(),
				vo.getPpQueue(),
				vo.getPpStatus(),
				vo.getState(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy(),
				vo.getSumRub(),
				vo.getNdsRub(),
				vo.getBillDate(),
				vo.getBillNumber(),
				vo.getRateCalcRule(),
				vo.getRateCalcRuleDay(),
				vo.getRateDelta(),
				vo.getRateDate(),
				vo.getRateValue(),
				vo.getRateNds(),
				vo.getIdZpNfs()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(LeasePayOfficeMemo_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getIdOfficeMemo()};
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(LeasePayOfficeMemo_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getLeaseContract(),
				vo.getBeginDate(),
				vo.getEndDate(),
				vo.getFlagAvans(),
				vo.getFlag3face(),
				vo.getSum(),
				vo.getNds(),
				vo.getCurrency(),
				vo.getRuleRate(),
				vo.getOrgAcc(),
				vo.getPurpose(),
				vo.getPp104(),
				vo.getPp105(),
				vo.getPpQueue(),
				vo.getPpStatus(),
				vo.getState(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy(),
				vo.getSumRub(),
				vo.getNdsRub(),
				vo.getBillDate(),
				vo.getBillNumber(),
				vo.getRateCalcRule(),
				vo.getRateCalcRuleDay(),
				vo.getRateDelta(),
				vo.getRateDate(),
				vo.getRateValue(),
				vo.getRateNds(),
				vo.getIdZpNfs(),
				vo.getIdOfficeMemo()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static LeasePayOfficeMemo_TO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " WHERE idOfficeMemo = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeasePayOfficeMemo_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			to = new LeasePayOfficeMemo_TO(CDBC_MapFactory.createLeasePayOfficeMemo(ro));
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
		LeasePayOfficeMemo_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			//LeasePayOfficeMemo_VO vo = CDBC_Helper.createLeasePayOfficeMemo(ro);
			to = new LeasePayOfficeMemo_TO(CDBC_MapFactory.createLeasePayOfficeMemo(ro));
			to.setCurName(ro.getColumn("curName").asString());
			to.setAccount(ro.getColumn("account").asString());
			to.setBankName(ro.getColumn("bankName").asString());
			to.setBankBik(ro.getColumn("bankBik").asString());
			to.setVendorSiteName(ro.getColumn("vendorSiteName").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:31:05)
	 */
	public static String changeStateLeasePayOfficeMemo(int idCode, String toState, int codeOperator) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = ""; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure changeStateLeasePayOfficeMemo(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, idCode); //код 
			cs.setString(2, toState); //желаемое состояние 
			cs.setInt(3, codeOperator); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("Процедура 'changeStateLeasePayOfficeMemo' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'changeStateLeasePayOfficeMemo' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'changeStateLeasePayOfficeMemo'"); //temp
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'changeStateLeasePayOfficeMemo(?, ?, ?)'";
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

}
