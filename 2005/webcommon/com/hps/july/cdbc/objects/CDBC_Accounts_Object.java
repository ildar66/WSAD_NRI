/*
 * Created on 21.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.*;

/**
 * @author IShaffigulin
 *
 * Справочник расчетных счетов организаций CDBC_Object
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_Accounts_Object {
	private final static java.lang.String FIND_SQL =
		"SELECT accountid, bank, idVendorSite, account, active, createdBy, created, modifiedBy, modified FROM accounts ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE accounts SET bank=?, idVendorSite=?, account=?, active=?, createdBy=?, created=?, modifiedBy=?, modified=?  "
			+ "WHERE accountid=? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO accounts (accountid, bank, idVendorSite, account, active, createdBy, created, modifiedBy, modified) "
			+ "VALUES (?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL =
		"DELETE FROM accounts WHERE accountid = ? ";
	private final static java.lang.String FIND_LIST_SQL =
		"SELECT acc.accountid, acc.bank, acc.idVendorSite, acc.account, acc.active, acc.createdBy, acc.created, acc.modifiedBy, acc.modified, b.idBank, b.name, b.bik, b.korAccount, b.legalAddress, b.swift FROM accounts acc, banks b WHERE acc.bank = b.idBank ";

	/**
	 * Insert the method's description here.
	 * Creation date: (30.09.2004 11:49:47)
	 */
	public static List findList(
		Boolean isIdVendorSite,
		Integer idVendorSite,
		String aSortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LIST_SQL);
		//calculate filter clause
		if (isIdVendorSite.booleanValue()) {
			sqlb.append("AND idVendorSite = ? ");
			params.add(idVendorSite);
		}
		//append order by clause:
		sqlb.append("order by " + aSortBy);

		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Accounts_VO vo = CDBC_MapFactory.createAccount(ro);
			Accounts_TO to = new Accounts_TO(vo);

			Banks_VO bank_VO = new Banks_VO((Integer) ro.getColumn("idBank").asObject());
			bank_VO.setName(ro.getColumn("name").asString());
			bank_VO.setBik(ro.getColumn("bik").asString());
			bank_VO.setKorAccount(ro.getColumn("korAccount").asString());
			bank_VO.setLegalAddress(ro.getColumn("legalAddress").asString());
			bank_VO.setSwift(ro.getColumn("swift").asString());
			bank_VO.setIsGhost(true);
		
			to.setBank_VO(bank_VO);
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static Accounts_VO find(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = FIND_SQL + " WHERE accountID = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Accounts_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createAccount(ro);
		}
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:06:19)
	 */
	public static boolean add(Accounts_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getAccountId(),
				vo.getBank(),
				vo.getIdVendorSite(),
				vo.getAccount(),
				vo.getActive().booleanValue()? "Y": "N",
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified()};
		return res.executeUpdate(ADD_SQL, params);
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:17:12)
	 */
	public static boolean delete(Integer id) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { id };
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:14:22)
	 */
	public static boolean edit(Accounts_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getBank(),
				vo.getIdVendorSite(),
				vo.getAccount(),
				vo.getActive().booleanValue()? "Y": "N",
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified(),
				vo.getAccountId()};
		return res.executeUpdate(EDIT_SQL, params);
	}

}
