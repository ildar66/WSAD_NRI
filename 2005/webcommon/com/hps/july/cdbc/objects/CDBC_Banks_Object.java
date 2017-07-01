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

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.valueobject.Banks_VO;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_Banks_Object {
	private final static java.lang.String FIND_SQL =
		"SELECT first 1000 idBank, name, bik, korAccount, legalAddress, swift, source, createdBy, created, modifiedBy, modified, recordStatus FROM banks ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE banks SET name=?, bik=?, korAccount=?, legalAddress=?, swift=?, source=?, createdBy=?, created=?, modifiedBy=?, modified=?, recordStatus=? "
			+ "WHERE idBank=? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO banks (idBank, name, bik, korAccount, legalAddress, swift, source, createdBy, created, modifiedBy, modified, recordStatus) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
	//private final static java.lang.String DELETE_SQL = "DELETE FROM banks WHERE idBank = ? ";
	private final static java.lang.String DELETE_SQL = "UPDATE banks SET recordStatus='D' WHERE idBank = ? ";

	/**
	 * Insert the method's description here.
	 * Creation date: (30.09.2004 11:49:47)
	 */
	public static List findList(Boolean isName, String name, Boolean isBik, String bik, String aSortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_SQL);
		sqlb.append(" WHERE 1=1 ");
		//calculate filter clause
		if (isName.booleanValue()) {
			sqlb.append("AND lower(name) matches lower(?) ");
			params.add(name);
		}
		if (isBik.booleanValue()) {
			sqlb.append("AND lower(bik) matches lower(?) ");
			params.add(bik);
		}
		//append order by clause:
		sqlb.append("order by " + aSortBy);

		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Banks_VO vo = CDBC_MapFactory.createBank(ro);
			//Banks_TO to = new Banks_TO(vo);
			ret.add(vo);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static Banks_VO find(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = FIND_SQL + " WHERE idBank = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Banks_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createBank(ro);
		}
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:06:19)
	 */
	public static boolean add(Banks_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdBank(),
				vo.getName(),
				vo.getBik(),
				vo.getKorAccount(),
				vo.getLegalAddress(),
				vo.getSwift(),
				vo.getSource(),
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified(),
				vo.getRecordStatus()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:17:12)
	 */
	public static boolean delete(Integer idBank) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idBank };
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:14:22)
	 */
	public static boolean edit(Banks_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getName(),
				vo.getBik(),
				vo.getKorAccount(),
				vo.getLegalAddress(),
				vo.getSwift(),
				vo.getSource(),
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified(),
				vo.getRecordStatus(),
				vo.getIdBank()};
		return res.executeUpdate(EDIT_SQL, params);
	}
}
