/*
 * Created on 09.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.valueobject.CompletWorkAkt2Charge_TO;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_CompletWorkAkt2Charge_Object {
	private static final String FIND_LIST_FOR_CWA_SQL =
		"SELECT ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, "
			+ "ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, "
			+ "ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified , ldp.created , ldp.createdBy, ldp.modifiedBy, "
			+ "lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, "
			+ "lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct, "
			+ "cwa2ch.linkSumCharge, cwa2ch.idCwaCode, "
			+ "res.name resname, "
			+ "cur.shortname curname "
			+ "FROM leasedocpositions ldp, leasecharges lc, CompletWorkAct2Charge cwa2ch, resources res, currencies cur "
			+ "WHERE lc.leasedocposition = ldp.leasedocposition "
			+ "AND ldp.leasedocposition = cwa2ch.idcharge "
			+ "AND res.resource = ldp.resource "
			+ "AND cur.currency = ldp.currency ";
	private static final String _createString =
		"INSERT INTO CompletWorkAct2Charge (idCwaCode, idcharge, linksumcharge) VALUES (?, ?, ?)";
	private static final String _removeString =
		"DELETE FROM CompletWorkAct2Charge WHERE idCwaCode = ? AND idcharge = ? ";
	private static final String _storeString =
		"UPDATE CompletWorkAct2Charge SET linksumcharge = ? WHERE idCwaCode = ? AND idcharge = ? ";
	private static final String _loadString =
		"SELECT idCwaCode, idcharge, linksumcharge FROM CompletWorkAct2Charge WHERE idCwaCode = ? AND idcharge = ? ";

	/**
	 * 
	 */
	public CDBC_CompletWorkAkt2Charge_Object() {
		super();
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final ArrayList getListForCWA(Integer aidCwaCode, String sortBy) {
		ArrayList ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aidCwaCode };
		String sql = FIND_LIST_FOR_CWA_SQL + " AND idCwaCode  = ? ";
		//append order by clause:
		if (sortBy != null)
			sql += " order by " + sortBy;
		System.out.println("getListForCWA SQL: " + sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		CompletWorkAkt2Charge_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new CompletWorkAkt2Charge_TO();
			to.setChargeVO(CDBC_MapFactory.createLeaseCharge(ro));
			to.setIdCwaCode((Integer) ro.getColumn("idCwaCode").asObject());
			to.setLinkSumCharge((BigDecimal) ro.getColumn("linksumcharge").asObject());
			to.setCurName(ro.getColumn("curname").asString());
			to.setResName(ro.getColumn("resname").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (05.08.2005 12:14:11)
	 */
	public static boolean add(CompletWorkAkt2Charge_TO to) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { to.getIdCwaCode(), to.getChargeVO().getLeaseDocPosition(), to.getLinkSumCharge()};
		return res.executeUpdate(_createString, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.08.2005 12:14:11)
	 */
	public static boolean edit(CompletWorkAkt2Charge_TO to) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { to.getLinkSumCharge(), to.getIdCwaCode(), to.getChargeVO().getLeaseDocPosition()};
		return res.executeUpdate(_storeString, params);
	}
	/**
	 * Creation date: (23.07.2005 13:57:38)
	 */
	public static BigDecimal find(Integer aidCwaCode, Integer aIdCharge) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aidCwaCode, aIdCharge };
		res.executeQuery(_loadString, params);
		ListIterator list = res.listIterator();
		BigDecimal retBigDecimal = null;
		if (list.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) list.next();
			retBigDecimal = (BigDecimal)ro.getColumn("linksumcharge").asObject();
		}
		return retBigDecimal;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(Integer aidCwaCode, Integer aIdCharge) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aidCwaCode, aIdCharge };
		return res.executeUpdate(_removeString, params);
	}	
}
