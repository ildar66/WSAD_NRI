package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.util.*;
import com.hps.july.valueobject.LeaseCharge_TO;
import com.hps.july.valueobject.LeaseCharge_VO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

/**
 * Объект для работы с начислениями аренды.
 * Creation date: (14.04.2004 15:14:25)
 * @author: Ildar Shafigullin
 */
public class CDBCLeaseChargesObject {
	private static final String FIND_SQL =
		"SELECT ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, "
			+ "ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, "
			+ "ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified , ldp.created , ldp.createdBy, getNamePeople(ldp.createdby) createdByName, ldp.modifiedBy, getNamePeople(ldp.modifiedby) modifiedByName, "
			+ "lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, "
			+ "lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct "
			+ "FROM leasedocpositions ldp, leasecharges lc "
			+ "WHERE lc.leasedocposition = ldp.leasedocposition ";
	private static final String FIND_TO_SQL =
		"SELECT ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, "
			+ "ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, "
			+ "ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified , ldp.created , ldp.createdBy, getNamePeople(ldp.createdby) createdByName, ldp.modifiedBy, getNamePeople(ldp.modifiedby) modifiedByName, "
			+ "lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, "
			+ "lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct, "
			+ "res.name resName, cur.shortname curName, getRateLDocPos(ldp.leasedocposition, ldp.currency) rate "
			+ "FROM leasedocpositions ldp, leasecharges lc, resources res, currencies cur "
			+ "WHERE lc.leasedocposition = ldp.leasedocposition AND res.resource = ldp.resource AND cur.currency = ldp.currency ";
	private static final String[] _createString =
		{
			"INSERT INTO leasedocpositions (leasedocposition, docposvid, date, willbeinact, operator, begindate, summ, usedinact, sumnds, enddate, source, modified, created, modifiedby, createdby, currency, act, leasecontract, resource, docpostype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
			"INSERT INTO leasecharges (leasedocposition, billdate, remaindersum, isschetfakt1, isschetfakt2, isschetfakt3, billnumber, remainderrate2rur, byhandraterur, usedincwact, leaserule) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
	private static final String[] _removeString = { "DELETE FROM leasecharges  WHERE leasedocposition = ?", "DELETE FROM leasedocpositions  WHERE leasedocposition = ?" };
	private static final String[] _storeString =
		{
			"UPDATE leasecharges  SET billdate = ?, remaindersum = ?, isschetfakt1 = ?, isschetfakt2 = ?, isschetfakt3 = ?, billnumber = ?, remainderrate2rur = ?, byhandraterur = ?, usedincwact = ?, leaserule = ? WHERE leasedocposition = ?",
			"UPDATE leasedocpositions  SET docposvid = ?, date = ?, willbeinact = ?, operator = ?, begindate = ?, summ = ?, usedinact = ?, sumnds = ?, enddate = ?, source = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, currency = ?, act = ?, leasecontract = ?, resource = ?, docpostype = ? WHERE leasedocposition = ?" };
	private static final String _loadString =
		"SELECT T2.docposvid, T2.date, T2.willbeinact, T2.operator, T2.begindate, T2.summ, T2.usedinact, T2.sumnds, T2.enddate, T2.source, T2.leasedocposition, T2.modified, T2.created, T2.modifiedby, T2.createdby, T2.currency, T2.act, T2.leasecontract, T2.resource, T2.docpostype, T1.billdate, T1.remaindersum, T1.isschetfakt1, T1.isschetfakt2, T1.isschetfakt3, T1.billnumber, T1.remainderrate2rur, T1.byhandraterur, T1.usedincwact, T1.leaserule FROM leasecharges  T1, leasedocpositions  T2 WHERE T2.docpostype = \'C\' AND T2.leasedocposition = T1.leasedocposition AND T2.leasedocposition = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String CHECK_CHANGE_CHARGE_SQL = "execute procedure CheckChangeCharge(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private static final String INSERT_CHARGE_SQL = "execute procedure insertCharge(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private static final String UPDATE_CHARGE_SQL = "execute procedure updateCharge(?,?,?,?,?,?,?,?,?,?,?,?) ";

	/**
	 * CDBCLeaseChargeObject constructor comment.
	 */
	public CDBCLeaseChargesObject() {
		super();
	}
	/**
	 * Возвращает список начислений по Акту выполненных работ.
	 */
	public static CDBCResultSet findByCWA(java.lang.Boolean isIdCWA, java.lang.Integer idCWA, String orderBy) throws java.lang.Exception {
		Object[] args = null;

		// Prepare query	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, ");
		sb.append("ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, ");
		sb.append("ldp.sumnds, ldp.operator, ldp.willbeinact, ");
		sb.append("lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, ");
		sb.append("lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, ");
		sb.append("res.name resname, ");
		sb.append("cur.shortname curname, ");
		sb.append("getRateLDocPos(ldp.leasedocposition, ldp.currency) rate ");
		//опр курс начисления или платежа к искомой валюте.
		sb.append("FROM ");
		sb.append("leasedocpositions ldp, leasecharges lc, resources res, currencies cur ");
		sb.append("WHERE ");
		sb.append("lc.leasedocposition = ldp.leasedocposition ");
		sb.append("AND res.resource = ldp.resource ");
		sb.append("AND cur.currency = ldp.currency ");

		//calculate where clause
		if (isIdCWA.booleanValue())
			sb.append(" AND lc.UsedInCWAct =  " + idCWA.toString());

		//append order by clause
		sb.append(" ORDER BY ");
		sb.append(orderBy);

		//System.out.println("CDBCLeaseChargesObject SQL=" + sb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), args);
		return res;
	}
	/**
	 * Возвращает список начислений по договору аренды
	 */
	public static CDBCResultSet findByQBE5(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		Boolean isResource,
		Integer resource,
		Boolean isDocposvid,
		String[] docposvid,
		java.lang.Integer order)
		throws java.lang.Exception {

		int i;
		Object[] args = null;

		// Prepare query	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, ");
		sb.append("ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, ");
		sb.append("ldp.sumnds, ldp.operator, ldp.willbeinact, ");
		sb.append("lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, ");
		sb.append("lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, ");
		sb.append("res.name resname, ");
		sb.append("cur.shortname curname ");
		sb.append("FROM ");
		sb.append("leasedocpositions ldp, leasecharges lc, resources res, currencies cur ");
		sb.append("WHERE ");
		sb.append("lc.leasedocposition = ldp.leasedocposition ");
		sb.append("AND res.resource = ldp.resource ");
		sb.append("AND cur.currency = ldp.currency ");

		//calculate where clause
		if (isLeaseContract.booleanValue())
			sb.append(" AND ldp.leasecontract =  " + leaseContract.toString());
		if (isDate.booleanValue()) {
			sb.append(" AND ldp.date >= ? AND ldp.date <= ? ");
			args = new Object[] { fromDate, toDate };
		}
		if (isResource.booleanValue())
			sb.append(" AND ldp.resource = " + resource.toString());
		if (isDocposvid.booleanValue()) {
			String s = "'" + docposvid[0] + "'";
			for (int ii = 1; ii < docposvid.length; ii++) {
				s = s + ",'" + docposvid[ii] + "'";
			}
			sb.append(" AND ldp.docposvid IN (" + s + ") ");
		}

		//append order by clause
		String orderBy = null;
		switch (order.intValue()) {
			case 1 :
				orderBy = "date asc";
				break;
			case 2 :
				orderBy = "date desc";
				break;
		}
		sb.append(" ORDER BY ");
		sb.append(orderBy);

		System.out.println("CDBCLeaseChargesObject.findByQBE5(1) SQL=" + sb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), args);
		return res;
	}
	/**
	 * Возвращает список начислений по договору аренды
	 */
	public static CDBCResultSet findByQBE5(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		Boolean isResource,
		Integer resource,
		Boolean isDocposvid,
		String[] docposvid,
		String orderBy)
		throws java.lang.Exception {

		int i;
		Object[] args = null;

		// Prepare query	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, ");
		sb.append("ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, ");
		sb.append("ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified, ldp.created, ldp.createdby, ldp.modifiedby, ");
		sb.append("lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, ");
		sb.append(
			"lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct, ");
		sb.append("res.name resname, ");
		sb.append("cur.shortname curname ");
		sb.append("FROM ");
		sb.append("leasedocpositions ldp, leasecharges lc, resources res, currencies cur ");
		sb.append("WHERE ");
		sb.append("lc.leasedocposition = ldp.leasedocposition ");
		sb.append("AND res.resource = ldp.resource ");
		sb.append("AND cur.currency = ldp.currency ");

		//calculate where clause
		if (isLeaseContract.booleanValue())
			sb.append(" AND ldp.leasecontract =  " + leaseContract.toString());
		if (isDate.booleanValue()) {
			sb.append(" AND ldp.date >= ? AND ldp.date <= ? ");
			args = new Object[] { fromDate, toDate };
		}
		if (isResource.booleanValue())
			sb.append(" AND ldp.resource = " + resource.toString());
		if (isDocposvid.booleanValue()) {
			String s = "'" + docposvid[0] + "'";
			for (int ii = 1; ii < docposvid.length; ii++) {
				s = s + ",'" + docposvid[ii] + "'";
			}
			sb.append(" AND ldp.docposvid IN (" + s + ") ");
		}

		//append order by clause:
		if (orderBy != null && !orderBy.trim().equals("")) {
			sb.append(" order by " + orderBy);
		}

		//System.out.println("CDBCLeaseChargesObject.findByQBE5(2) SQL=" + sb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), args);
		return res;
	}
	/**
	 * Main Метод для проверки работы других методов.
	 * Creation date: (10.03.2004 16:03:42)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) throws Exception {

		com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("LEASEChargeS");
		tc.start();
		//CDBCLeaseChargesObject o = new CDBCLeaseChargesObject();
		CDBCResultSet rs = CDBCLeaseChargesObject.findByQBE5(Boolean.TRUE, new Integer(4227),
			// Boolean isLeaseContract, Integer leaseContract
		Boolean.FALSE, null, null, // Boolean isDate, Date fromDate, Date toDate
		new Boolean(false), new Integer(0), // Boolean isResource, Integer resource
	new Boolean(true), new String[] { "N", "C" }, // Boolean isDocposvid, String[] docposvid
		new Integer(1));
		tc.finish("SQL");

		tc.start();
		java.util.ListIterator it = rs.listIterator();
		System.out.println("start");
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			CDBCColumnObject co1 = (CDBCColumnObject) ro.getColumn("leasedocposition");
			CDBCColumnObject co2 = (CDBCColumnObject) ro.getColumn("resname");
			System.out.println("" + co1.asObject() + "  '" + co2.asString() + "'");
		}
		tc.finish("Iterate");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static LeaseCharge_VO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " AND ldp.leasedocposition = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeaseCharge_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			//to = new LeaseSchetFact_VO(CDBC_Helper.createLoanAktGetPut(ro));
			//to.setOurManName(ro.getColumn("ourmanname").asString());
			vo = CDBC_MapFactory.createLeaseCharge(ro);
			vo.setCreatedByName(ro.getColumn("createdByName").asString());
			vo.setModifiedByName(ro.getColumn("modifiedByName").asString());
		}
		return vo;
	}
	/**
		 * Insert the method's description here.
		 * Creation date: (09.11.2005 16:54:13)
		 * @param id int
		 */
	public final static LeaseCharge_TO findTO(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_TO_SQL + " AND ldp.leasedocposition = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeaseCharge_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			to = new LeaseCharge_TO(CDBC_MapFactory.createLeaseCharge(ro));
			to.getVo().setCreatedByName(ro.getColumn("createdByName").asString());
			to.getVo().setModifiedByName(ro.getColumn("modifiedByName").asString());
			to.setCurName(ro.getColumn("curName").asString());
			to.setResName(ro.getColumn("resName").asString());
			to.setRate((java.math.BigDecimal) ro.getColumn("rate").asObject());
		}
		return to;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(LeaseCharge_VO vo) {
		boolean isOK = false;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params0 =
			{
				vo.getBillDate(),
				vo.getRemainderSum(),
				vo.getIsSchetFakt1(),
				vo.getIsSchetFakt2(),
				vo.getIsSchetFakt3(),
				vo.getBillNumber(),
				vo.getRemainderRate2Rur(),
				vo.getByHandRateRur(),
				vo.getUsedInCWAct(),
				vo.getLeaseRule(),
				vo.getLeaseDocPosition()};
		isOK = res.executeUpdate(_storeString[0], params0);
		if (isOK) {
			res = new CDBCResultSet();
			Object[] params1 =
				{
					vo.getDocPosVid(),
					vo.getDate(),
					vo.getWillBeInAct(),
					vo.getOperator(),
					vo.getBeginDate(),
					vo.getSumm(),
					vo.getUsedInAct(),
					vo.getSumNds(),
					vo.getEndDate(),
					vo.getSource(),
					vo.getModified(),
					vo.getCreated(),
					vo.getModifiedBy(),
					vo.getCreatedBy(),
					vo.getCurrency(),
					vo.getAct(),
					vo.getLeaseContract(),
					vo.getResource(),
					vo.getDocPosType(),
					vo.getLeaseDocPosition()};
			isOK = res.executeUpdate(_storeString[1], params1);
		}
		return isOK;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean add(LeaseCharge_VO vo) {
		boolean isOK = false;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params0 =
			{
				vo.getLeaseDocPosition(),
				vo.getDocPosVid(),
				vo.getDate(),
				vo.getWillBeInAct(),
				vo.getOperator(),
				vo.getBeginDate(),
				vo.getSumm(),
				vo.getUsedInAct(),
				vo.getSumNds(),
				vo.getEndDate(),
				vo.getSource(),
				vo.getModified(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getCreatedBy(),
				vo.getCurrency(),
				vo.getAct(),
				vo.getLeaseContract(),
				vo.getResource(),
				vo.getDocPosType()};
		isOK = res.executeUpdate(_createString[0], params0);
		if (isOK) {
			res = new CDBCResultSet();
			Object[] params1 =
				{
					vo.getLeaseDocPosition(),
					vo.getBillDate(),
					vo.getRemainderSum(),
					vo.getIsSchetFakt1(),
					vo.getIsSchetFakt2(),
					vo.getIsSchetFakt3(),
					vo.getBillNumber(),
					vo.getRemainderRate2Rur(),
					vo.getByHandRateRur(),
					vo.getUsedInCWAct(),
					vo.getLeaseRule()};

			isOK = res.executeUpdate(_createString[1], params1);
		}
		return isOK;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(LeaseCharge_VO vo) {
		boolean isOK = false;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getLeaseDocPosition()};
		isOK = res.executeUpdate(_removeString[0], params);
		if (isOK) {
			isOK = res.executeUpdate(_removeString[1], params);
		}
		return isOK;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final String delete(Integer aID) {
		String returnStr = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		res.executeQuery("execute procedure deleteCharge(?) ", params);
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
	 drop procedure CheckChangeCharge;
	create procedure CheckChangeCharge(
	--  $Header: /cvs/repository/webcommon/com/hps/july/cdbc/objects/CDBCLeaseChargesObject.java,v 1.35 2007/04/05 14:50:25 IShaffigulin Exp $
	--  Author: Борцов Д.
	--  Description: Определяем правильность измененения начисления
	--  execute procedure CheckChangeCharge(1, 1);
	i_charge integer,   -- код начисления
	i_docpostype CHAR(1),
	i_date DATE,
	i_leasecontract INTEGER,
	i_source CHAR(1),
	i_docposvid CHAR(1),
	i_begindate DATE,
	i_enddate DATE,
	i_act INTEGER,
	i_usedinact INTEGER,
	i_resource INTEGER,
	i_summ DECIMAL(15,2),
	i_currency INTEGER,
	i_sumnds DECIMAL(15,2),
	i_willbeinact INTEGER,
	i_remaindersum DECIMAL(15,2),
	i_remainderrate2rur DECIMAL(15,4),
	i_byhandraterur CHAR(1),
	i_usedincwact INTEGER
	)
	RETURNING
	integer,       -- признак возврата (0-без ошибок, <> 0 - ошибки)
	char(255);     -- текст сообщения об ошибке
	 */
	public static String checkChangeChargeOld(LeaseCharge_VO vo) {
		System.out.println(vo); //temp
		String returnStr = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getLeaseDocPosition(),
				vo.getDocPosType(),
				vo.getDate(),
				vo.getLeaseContract(),
				vo.getSource(),
				vo.getDocPosVid(),
				vo.getBeginDate(),
				vo.getEndDate(),
				vo.getAct(),
				vo.getUsedInAct(),
				vo.getResource(),
				vo.getSumm(),
				vo.getCurrency(),
				vo.getSumNds(),
				vo.getWillBeInAct(),
				vo.getRemainderSum(),
				vo.getRemainderRate2Rur(),
				vo.getByHandRateRur(),
				vo.getUsedInCWAct()};

		res.executeQuery(CHECK_CHANGE_CHARGE_SQL, params);
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
	 * Creation date: (23.10.2005 15:12:29)
	 */
	public static String checkChangeCharge(LeaseCharge_VO vo) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = null; //признак выполнения без ошибок!!!
		try {
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(CHECK_CHANGE_CHARGE_SQL);

			cs.setObject(1, vo.getLeaseDocPosition()); //код 
			cs.setObject(2, vo.getDocPosType());
			cs.setObject(3, vo.getDate());
			cs.setObject(4, vo.getLeaseContract());
			cs.setObject(5, vo.getSource());
			cs.setObject(6, vo.getDocPosVid());
			cs.setObject(7, vo.getBeginDate());
			cs.setObject(8, vo.getEndDate());
			if (vo.getAct() != null)
				cs.setObject(9, vo.getAct());
			else
				cs.setNull(9, Types.INTEGER);
			if (vo.getUsedInAct() != null)
				cs.setObject(10, vo.getUsedInAct());
			else
				cs.setNull(10, Types.INTEGER);
			cs.setObject(11, vo.getResource());
			cs.setObject(12, vo.getSumm());
			cs.setObject(13, vo.getCurrency());
			cs.setObject(14, vo.getSumNds());
			if (vo.getWillBeInAct() != null)
				cs.setObject(15, vo.getWillBeInAct());
			else
				cs.setNull(15, Types.INTEGER);
			cs.setObject(16, vo.getRemainderSum());
			if (vo.getRemainderRate2Rur() != null)
				cs.setObject(17, vo.getRemainderRate2Rur());
			else
				cs.setNull(17, Types.DECIMAL);
			cs.setObject(18, vo.getByHandRateRur());
			if (vo.getUsedInCWAct() != null)
				cs.setObject(19, vo.getUsedInCWAct());
			else
				cs.setNull(19, Types.INTEGER);

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					System.out.println("Процедура 'checkChangeCharge' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'checkChangeCharge' errorTxt: " + errorTxt); //temp
				}
			} else {
				errorTxt = "no DATA: execute procedure 'checkChangeCharge'";
				System.out.println(errorTxt);
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'checkChangeCharge'";
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
	 *  --execute procedure lnkOneChrg2PayAct(null,368543,2981598,"N", 1, 840);
		Устанавливаем связь между начислением и платежом
		{
		-- 18/12/2006 - Добавлен параметр связи начисления и платежа В КАКОЙ ВАЛЮТЕ СВЯЗЫВАТЬ
		}
		  i_act       integer,              -- код акта
		  i_charge    integer,              -- код начисления
		  i_payment   integer,              -- код платежа
		  i_typeRateCharge  char(1),        -- Y по курсу платежа,  иначе по правилам регламента
		  i_taskStart integer,               -- код журнала
		  i_currLink  integer
		) returning
		integer; -- признак обработки (0-без ошибок, иначе ошибки)
	 * 
	 * 
	 * @param i_act
	 * @param i_charge
	 * @param i_payment
	 * @param i_typeRateCharge
	 * @param i_taskStart
	 * @param i_currLink
	 * @return
	 */

	public static int lnkOneChrg2PayAct(Integer i_act, Integer i_charge, Integer i_payment, String i_typeRateCharge, Integer i_taskStart, Integer i_currLink) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = null;
		String txt = "execute procedure lnkOneChrg2PayAct(" + i_act + ", " + i_charge + ", " + i_payment + ", " + i_typeRateCharge + ", " + i_taskStart + ", " + i_currLink + ")";
		System.out.println(txt);
		int result = 0; //признак выполнения без ошибок!!!
		try {
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall("execute procedure lnkOneChrg2PayAct(?,?,?,?,?,?)");
			if (i_act != null)
				cs.setObject(1, i_act);
			else
				cs.setNull(1, Types.INTEGER);
			cs.setObject(2, i_charge);
			cs.setObject(3, i_payment);
			cs.setObject(4, i_typeRateCharge);
			cs.setObject(5, i_taskStart);
			cs.setObject(6, i_currLink);
			rs = cs.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					System.out.println("Процедура 'lnkOneChrg2PayAct' ok"); //temp
				} else {
					//errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'lnkOneChrg2PayAct' errorTxt: " + errorTxt + " result=" + result); //temp
				}
			} else {
				errorTxt = "no DATA: execute procedure 'lnkOneChrg2PayAct'";
				System.out.println(errorTxt);
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'lnkOneChrg2PayAct'";
			System.out.println(errorTxt);
			if (ex instanceof SQLException) {
				errorTxt = "Error code=" + ((SQLException) ex).getErrorCode();
				System.out.println(errorTxt);
			}
			ex.printStackTrace();
		} finally {
			finallyMetod(con, cs, rs);
		}
		//return errorTxt;
		return result;
	}

	/**
	 * 
	 * --execute procedure breaklnkOneChrg2PayAct(null,368543,2981598);
	   -- Разрываем связь между начислением и платежом
		  i_taskStart integer,
		  i_charge    integer,             -- код начисления
		  i_payment   integer              -- код платежа
		) returning
		integer; -- признак обработки (0-без ошибок, иначе ошибки)
	 * @param i_taskStart
	 * @param i_charge
	 * @param i_payment
	 * @return
	 */
	public static int breaklnkOneChrg2PayAct(Integer i_taskStart, Integer i_charge, Integer i_payment) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = null;
		int result = 0; //признак выполнения без ошибок!!!
		try {
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall("execute procedure breaklnkOneChrg2PayAct(?,?,?)");

			cs.setObject(1, i_taskStart);
			cs.setObject(2, i_charge);
			cs.setObject(3, i_payment);
			rs = cs.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					System.out.println("Процедура 'breaklnkOneChrg2PayAct' ok"); //temp
				} else {
					//errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'breaklnkOneChrg2PayAct' errorTxt: " + errorTxt); //temp
				}
			} else {
				errorTxt = "no DATA: execute procedure 'breaklnkOneChrg2PayAct'";
				System.out.println(errorTxt);
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'breaklnkOneChrg2PayAct'";
			System.out.println(errorTxt);
			if (ex instanceof SQLException) {
				errorTxt += "Error code=" + ((SQLException) ex).getErrorCode();
				System.out.println(errorTxt);
			}
			ex.printStackTrace();
		} finally {
			finallyMetod(con, cs, rs);
		}
		//return errorTxt;
		return result;
	}

	/**
	--  Author: Борцов Д.
	--  Description: Определяем правильность измененения начисления
	--  execute procedure InsertCharge(1, 1);
	i_charge integer,   -- код начисления
	i_basecontract INTEGER,
	i_source CHAR(1),
	i_docposvid CHAR(1),
	i_begindate DATE,
	i_enddate DATE,
	i_resource INTEGER,
	i_sumCharge DECIMAL(15,2),
	i_ndsCharge DECIMAL(15,2),
	i_currCharge INTEGER,
	i_billnumber char(40),
	i_billdate date
	)
	RETURNING
	integer,       -- признак возврата (0-без ошибок, <> 0 - ошибки)
	char(255);     -- текст сообщения об ошибке
	 */
	public static String insertCharge(LeaseCharge_VO vo) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = null; //признак выполнения без ошибок!!!
		String txt =
			"execute procedure 'insertCharge("
				+ vo.getLeaseDocPosition()
				+ ", "
				+ vo.getLeaseContract()
				+ ", "
				+ vo.getSource()
				+ ", "
				+ vo.getBeginDate()
				+ ", "
				+ vo.getEndDate()
				+ ", "
				+ vo.getResource()
				+ ", "
				+ vo.getSumm()
				+ ", "
				+ vo.getSumNds()
				+ ", "
				+ vo.getCurrency()
				+ ", "
				+ vo.getBillNumber()
				+ ", "
				+ vo.getBillDate()
				+ ", "
				+ vo.getNeedCwAct()
				+ ", "
				+ vo.getNeedSf()
				+ ")";
		System.out.println(txt);
		try {
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(INSERT_CHARGE_SQL);

			cs.setObject(1, vo.getLeaseDocPosition()); //код
			cs.setObject(2, vo.getLeaseContract());
			cs.setObject(3, vo.getSource());
			cs.setObject(4, vo.getBeginDate());
			cs.setObject(5, vo.getEndDate());
			cs.setObject(6, vo.getResource());
			cs.setObject(7, vo.getSumm());
			cs.setObject(8, vo.getSumNds());
			cs.setObject(9, vo.getCurrency());
			cs.setObject(10, vo.getBillNumber());
			if (vo.getBillDate() != null)
				cs.setObject(11, vo.getBillDate());
			else
				cs.setNull(11, Types.DATE);
			cs.setObject(12, vo.getNeedCwAct());
			cs.setObject(13, vo.getNeedSf());

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					System.out.println("Процедура 'insertCharge' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'insertCharge' errorTxt: " + errorTxt); //temp
				}
			} else {
				errorTxt =
					"no DATA: execute procedure 'insertCharge("
						+ vo.getLeaseDocPosition()
						+ ", "
						+ vo.getLeaseContract()
						+ ", "
						+ vo.getSource()
						+ ", "
						+ vo.getBeginDate()
						+ ", "
						+ vo.getEndDate()
						+ ", "
						+ vo.getResource()
						+ ", "
						+ vo.getSumm()
						+ ", "
						+ vo.getSumNds()
						+ ", "
						+ vo.getCurrency()
						+ ", "
						+ vo.getBillNumber()
						+ ", "
						+ vo.getBillDate()
						+ ", "
						+ vo.getNeedCwAct()
						+ ", "
						+ vo.getNeedSf()
						+ ")";
				System.out.println(errorTxt);
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'insertCharge'";
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
	create procedure UpdateCharge(
	--  $Header: /cvs/repository/webcommon/com/hps/july/cdbc/objects/CDBCLeaseChargesObject.java,v 1.35 2007/04/05 14:50:25 IShaffigulin Exp $
	--  Author: Борцов Д.
	--  Description: Определяем правильность измененения начисления
	--  execute procedure UpdateCharge(1, 1);
	i_leasedocposition INTEGER,
	i_source CHAR(1),
	i_begindate DATE,
	i_enddate DATE,
	i_resource INTEGER,
	i_sumCharge DECIMAL(15,2),
	i_ndsCharge DECIMAL(15,2),
	i_currCharge INTEGER,
	i_billnumber char(40),
	i_billdate date
	)
	RETURNING
	integer,       -- признак возврата (0-без ошибок, <> 0 - ошибки)
	char(255);     -- текст сообщения об ошибке
	 */
	public static String updateCharge(LeaseCharge_VO vo) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = null; //признак выполнения без ошибок!!!
		try {
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(UPDATE_CHARGE_SQL);

			cs.setObject(1, vo.getLeaseDocPosition()); //код
			cs.setObject(2, vo.getSource());
			cs.setObject(3, vo.getBeginDate());
			cs.setObject(4, vo.getEndDate());
			cs.setObject(5, vo.getResource());
			cs.setObject(6, vo.getSumm());
			cs.setObject(7, vo.getSumNds());
			cs.setObject(8, vo.getCurrency());
			cs.setObject(9, vo.getBillNumber());
			if (vo.getBillDate() != null)
				cs.setObject(10, vo.getBillDate());
			else
				cs.setNull(10, Types.DATE);
			cs.setObject(11, vo.getNeedCwAct());
			cs.setObject(12, vo.getNeedSf());

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					System.out.println("Процедура 'updateCharge' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'updateCharge' errorTxt: " + errorTxt); //temp
				}
			} else {
				errorTxt = "no DATA: execute procedure 'updateCharge'";
				System.out.println(errorTxt);
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'updateCharge'";
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
	 * Возвращает список начислений по договору аренды
	 */
	public static CDBCResultSet findListLinkToSchetFact(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		Boolean isResource,
		Integer resource,
		Boolean isDocposvid,
		String[] docposvid,
		String orderBy)
		throws java.lang.Exception {

		int i;
		Object[] args = null;

		// Prepare query	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, ");
		sb.append("ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, ");
		sb.append("ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified, ldp.created, ldp.createdby, ldp.modifiedby, ");
		sb.append("lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, ");
		sb.append(
			"lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct, ");
		sb.append("res.name resname, ");
		sb.append("cur.shortname curname ");
		sb.append("FROM ");
		sb.append("leasedocpositions ldp, leasecharges lc, resources res, currencies cur ");
		sb.append("WHERE ");
		sb.append("lc.leasedocposition = ldp.leasedocposition ");
		sb.append("AND res.resource = ldp.resource ");
		sb.append("AND cur.currency = ldp.currency ");
		sb.append("AND lc.ostSumForSF > 0 ");

		//calculate where clause
		if (isLeaseContract.booleanValue())
			sb.append(" AND ldp.leasecontract =  " + leaseContract);
		if (isDate.booleanValue()) {
			sb.append(" AND ldp.date >= ? AND ldp.date <= ? ");
			args = new Object[] { fromDate, toDate };
		}
		if (isResource.booleanValue())
			sb.append(" AND ldp.resource = " + resource);
		if (isDocposvid.booleanValue()) {
			String s = "'" + docposvid[0] + "'";
			for (int ii = 1; ii < docposvid.length; ii++) {
				s = s + ",'" + docposvid[ii] + "'";
			}
			sb.append(" AND ldp.docposvid IN (" + s + ") ");
		}

		//append order by clause:
		if (orderBy != null && !orderBy.trim().equals("")) {
			sb.append(" order by " + orderBy);
		}

		System.out.println("CDBCLeaseChargesObject.findListLinkToSchetFact SQL=" + sb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), args);
		return res;
	}

	/**
	 * Возвращает список начислений по договору аренды
	 */
	public static CDBCResultSet findListLinkToCompletWorkAkt(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		Boolean isResource,
		Integer resource,
		Boolean isDocposvid,
		String[] docposvid,
		String orderBy)
		throws java.lang.Exception {

		int i;
		Object[] args = null;

		// Prepare query	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, ");
		sb.append("ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, ");
		sb.append("ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified, ldp.created, ldp.createdby, ldp.modifiedby, ");
		sb.append("lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, ");
		sb.append(
			"lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct, ");
		sb.append("res.name resname, ");
		sb.append("cur.shortname curname ");
		sb.append("FROM ");
		sb.append("leasedocpositions ldp, leasecharges lc, resources res, currencies cur ");
		sb.append("WHERE ");
		sb.append("lc.leasedocposition = ldp.leasedocposition ");
		sb.append("AND res.resource = ldp.resource ");
		sb.append("AND cur.currency = ldp.currency ");
		sb.append("AND lc.ostSumForCwAct > 0 ");

		//calculate where clause
		if (isLeaseContract.booleanValue())
			sb.append(" AND ldp.leasecontract =  " + leaseContract);
		if (isDate.booleanValue()) {
			sb.append(" AND ldp.date >= ? AND ldp.date <= ? ");
			args = new Object[] { fromDate, toDate };
		}
		if (isResource.booleanValue())
			sb.append(" AND ldp.resource = " + resource);
		if (isDocposvid.booleanValue()) {
			String s = "'" + docposvid[0] + "'";
			for (int ii = 1; ii < docposvid.length; ii++) {
				s = s + ",'" + docposvid[ii] + "'";
			}
			sb.append(" AND ldp.docposvid IN (" + s + ") ");
		}

		//append order by clause:
		if (orderBy != null && !orderBy.trim().equals("")) {
			sb.append(" order by " + orderBy);
		}

		System.out.println("CDBCLeaseChargesObject.findListLinkToCompletWorkAkt SQL=" + sb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), args);
		return res;
	}

	/**
	 * Возвращает список начислений по договору аренды
	 */
	public static CDBCResultSet findListLinkToPayment(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		Boolean isResource,
		Integer resource,
		Boolean isDocposvid,
		String[] docposvid,
		String orderBy)
		throws java.lang.Exception {

		int i;
		Object[] args = null;

		// Prepare query	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, ");
		sb.append("ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, ");
		sb.append("ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified, ldp.created, ldp.createdby, ldp.modifiedby, ");
		sb.append("lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, ");
		sb.append(
			"lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct, ");
		sb.append("res.name resname, ");
		sb.append("cur.shortname curname ");
		sb.append("FROM ");
		sb.append("leasedocpositions ldp, leasecharges lc, resources res, currencies cur ");
		sb.append("WHERE ");
		sb.append("lc.leasedocposition = ldp.leasedocposition ");
		sb.append("AND res.resource = ldp.resource ");
		sb.append("AND cur.currency = ldp.currency ");
		sb.append("AND ldp.docPosType = 'C' ");

		//calculate where clause
		if (isLeaseContract.booleanValue())
			sb.append(" AND ldp.leasecontract =  " + leaseContract);
		if (isDate.booleanValue()) {
			sb.append(" AND ldp.date >= ? AND ldp.date <= ? ");
			args = new Object[] { fromDate, toDate };
		}
		if (isResource.booleanValue())
			sb.append(" AND ldp.resource = " + resource);
		if (isDocposvid.booleanValue()) {
			String s = "'" + docposvid[0] + "'";
			for (int ii = 1; ii < docposvid.length; ii++) {
				s = s + ",'" + docposvid[ii] + "'";
			}
			sb.append(" AND ldp.docposvid IN (" + s + ") ");
		}

		//append order by clause:
		if (orderBy != null && !orderBy.trim().equals("")) {
			sb.append(" order by " + orderBy);
		}

		System.out.println("CDBCLeaseChargesObject.findListLinkToPayment SQL=" + sb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), args);
		return res;
	}
}
