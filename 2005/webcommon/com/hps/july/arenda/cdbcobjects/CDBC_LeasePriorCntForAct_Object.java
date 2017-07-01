package com.hps.july.arenda.cdbcobjects;

import java.util.*;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.*;

/**
 * "ѕриоритеты списани€ задолженности с договора" CDBC_Object.
 * Creation date: (07.11.2005 12:14:30)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeasePriorCntForAct_Object {
	public static Integer DEFAULT_PRIORITY = new Integer(0);
	private static final String FIND_LIST_SQL =
		"SELECT UNIQUE c.reglament, c.contract, d.docdate, d.docnumber, NVL(p.priority, 0) priority, NVL(p.idact, a.leasedocument) idAct, NVL(p.leasedocument, c.contract) leaseDocument "
			+ "FROM leasemutualacts a, leasemutcontracts c, leasedocuments d, outer leasepriorcntforact p "
			+ "WHERE a.leasedocument = ? AND  c.reglament = a.mutualreglament AND d.leasedocument = c.contract AND p.idact = a.leasedocument AND p.leasedocument = c.contract ";
	private final static java.lang.String EDIT_SQL = "UPDATE LeasePriorCntForAct SET priority=? WHERE idact=? AND leasedocument=? ";
	private final static java.lang.String ADD_SQL = "INSERT INTO LeasePriorCntForAct (idact, leasedocument, priority) VALUES (?,?,?) ";
	private final static java.lang.String FIND_SQL = "SELECT * FROM LeasePriorCntForAct WHERE idact=? AND leasedocument=? ";

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getList(int leaseDocument, String sortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(leaseDocument)};
		String sql = FIND_LIST_SQL;
		//append order by clause:
		if (sortBy != null)
			sql += " ORDER BY " + sortBy;
		System.out.println(sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		LeasePriorCntForAct_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new LeasePriorCntForAct_TO(CDBC_Helper.createLeasePriorCntForAct(ro));
			to.setDocDate((java.sql.Date) ro.getColumn("docdate").asObject());
			to.setDocNumber(ro.getColumn("docnumber").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static LeasePriorCntForAct_VO find(Integer idAct, Integer leaseDocument) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idAct, leaseDocument };
		String sql = FIND_SQL;
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeasePriorCntForAct_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_Helper.createLeasePriorCntForAct(ro);
		}
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:04:50)
	 */
	public static final boolean add(LeasePriorCntForAct_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getIdact(), vo.getLeasedocument(), vo.getPriority()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(LeasePriorCntForAct_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getPriority(), vo.getIdact(), vo.getLeasedocument()};
		return res.executeUpdate(EDIT_SQL, params);
	}
}
