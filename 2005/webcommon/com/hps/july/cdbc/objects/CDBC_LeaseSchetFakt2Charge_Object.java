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
import com.hps.july.valueobject.LeaseCharge_VO;
import com.hps.july.valueobject.LeaseSchetFakt2Charge_TO;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_LeaseSchetFakt2Charge_Object {
	private static final String FIND_LIST_FOR_SF_SQL =
		"SELECT ldp.leasedocposition, ldp.docpostype, ldp.date, ldp.leasecontract, ldp.source, ldp.docposvid, "
			+ "ldp.begindate, ldp.enddate, ldp.act, ldp.usedinact, ldp.resource, ldp.summ, ldp.currency, "
			+ "ldp.sumnds, ldp.operator, ldp.willbeinact, ldp.modified , ldp.created , ldp.createdBy, ldp.modifiedBy, "
			+ "lc.leaserule, lc.remaindersum, lc.remainderrate2rur, lc.byhandraterur, lc.billnumber, lc.needCwAct, lc.needSf, "
			+ "lc.billdate, lc.isschetfakt1, lc.isschetfakt2, lc.isschetfakt3, lc.usedincwact, lc.isworkact1, lc.isworkact2, lc.isworkact3, lc.ostSumForSF, lc.flagSF, lc.ostSumForCwAct, lc.flagCwAct, "
			+ "lsf2ch.linkSumCharge, lsf2ch.idSchetFakt, "
			+ "res.name resname, "
			+ "cur.shortname curname "
			+ "FROM leasedocpositions ldp, leasecharges lc, LeaseSchetFakt2Charge lsf2ch, resources res, currencies cur "
			+ "WHERE lc.leasedocposition = ldp.leasedocposition "
			+ "AND ldp.leasedocposition = lsf2ch.idcharge "
			+ "AND res.resource = ldp.resource "
			+ "AND cur.currency = ldp.currency ";
	private static final String _createString =
		"INSERT INTO LeaseSchetFakt2Charge (idschetfakt, idcharge, linksumcharge) VALUES (?, ?, ?)";
	private static final String _removeString =
		"DELETE FROM LeaseSchetFakt2Charge WHERE idschetfakt = ? AND idcharge = ? ";
	private static final String _storeString =
		"UPDATE LeaseSchetFakt2Charge SET linksumcharge = ? WHERE idschetfakt = ? AND idcharge = ? ";
	private static final String _loadString =
		"SELECT idschetfakt, idcharge, linksumcharge FROM LeaseSchetFakt2Charge WHERE idschetfakt = ? AND idcharge = ? ";

	/**
	 * 
	 */
	public CDBC_LeaseSchetFakt2Charge_Object() {
		super();
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final ArrayList getListForSchetFact(Integer aIdSchetFakt, String sortBy) {
		ArrayList ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aIdSchetFakt };
		String sql = FIND_LIST_FOR_SF_SQL + " AND idSchetFakt  = ? ";
		//append order by clause:
		if (sortBy != null)
			sql += " order by " + sortBy;
		System.out.println("getListForSchetFact SQL: " + sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		LeaseSchetFakt2Charge_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new LeaseSchetFakt2Charge_TO();
			to.setChargeVO(CDBC_MapFactory.createLeaseCharge(ro));
			to.setIdSchetfakt((Integer) ro.getColumn("idschetfakt").asObject());
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
	public static boolean add(LeaseSchetFakt2Charge_TO to) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { to.getIdSchetfakt(), to.getChargeVO().getLeaseDocPosition(), to.getLinkSumCharge()};
		return res.executeUpdate(_createString, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.08.2005 12:14:11)
	 */
	public static boolean edit(LeaseSchetFakt2Charge_TO to) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { to.getLinkSumCharge(), to.getIdSchetfakt(), to.getChargeVO().getLeaseDocPosition()};
		return res.executeUpdate(_storeString, params);
	}
	/**
	 * Creation date: (23.07.2005 13:57:38)
	 */
	public static BigDecimal find(Integer aIdSchetFakt, Integer aIdCharge) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aIdSchetFakt, aIdCharge };
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
	public static final boolean delete(Integer aIdSchetFakt, Integer aIdCharge) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aIdSchetFakt, aIdCharge };
		return res.executeUpdate(_removeString, params);
	}	
}
