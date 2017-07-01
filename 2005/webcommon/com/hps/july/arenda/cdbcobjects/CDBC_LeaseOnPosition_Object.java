/*
 * Created on 07.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.cdbcobjects;

import java.util.*;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;

/**
 * Связь позиций и договоров аренды CDBC_Object.
 * @author IShaffigulin
 * 
 */
public class CDBC_LeaseOnPosition_Object {
	private static final String FIND_LIST_POSITION_BY_LeaseArendaAgreementNew_SQL =
		"SELECT lp.storageplace, lp.leaseDocument, sp.name, sp.division, sp.address, sp.closedate, sp.type, sp.operator, sp.modified, sp.created, sp.createdby, sp.modifiedby, p.gsmid, p.dampsid, getNumBsGsmOnPos(p.storageplace, 0) gsmIDs, getNumBsDampsOnPos(p.storageplace, 0) dampsIDs, getNameOtv2Pos(1, lp.storageplace) nameOtvPos "
			+ "FROM leaseOnPositions lp, storageplaces sp, positions p WHERE lp.storageplace = sp.storageplace AND sp.storageplace = p.storageplace ";

	private static final String FIND_ALL_LIST_POSITION_BY_LeaseArendaAgreement_SQL =
		"SELECT lp.storageplace, lp.leaseDocument, sp.name, sp.division, sp.address, sp.closedate, sp.type, sp.operator, sp.modified, sp.created, sp.createdby, sp.modifiedby, p.gsmid, p.dampsid, getNumBsGsmOnPos(p.storageplace, 0) gsmIDs, getNumBsDampsOnPos(p.storageplace, 0) dampsIDs, getNameOtv2Pos(1, lp.storageplace) nameOtvPos, agr.mainPosition, ld.docNumber "
			+ "FROM leaseOnPositions lp, storageplaces sp, positions p, leaseArendaAgrmnts agr, leaseDocuments ld WHERE lp.storageplace = sp.storageplace AND sp.storageplace = p.storageplace AND agr.leaseDocument = lp.leaseDocument AND agr.leaseDocument = ld.leaseDocument ";

	/**
	 * Поиск списка позиций по договору аренды.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List findPositionsByLeaseArendaAgreementNew(Integer leaseContractKey, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LIST_POSITION_BY_LeaseArendaAgreementNew_SQL);
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		filter.append(" AND lp.leaseDocument = ? ");
		params.add(leaseContractKey);
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		System.out.println("params=" + params); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		Position_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new Position_TO(CDBC_Helper.createPositionVO(ro));
			to.setNameOtvPos(ro.getColumn("nameOtvPos").asString());
			to.setGsmIDs(ro.getColumn("gsmIDs").asString());
			to.setDampsIDs(ro.getColumn("dampsIDs").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Поиск всего списка позиций по главному договору аренды.* 
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List findAllPositionsByMainDog(Integer mainLeaseContractKey, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_ALL_LIST_POSITION_BY_LeaseArendaAgreement_SQL);
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		filter.append(" AND (agr.mainLeaseDocument = ? OR agr.leaseDocument = ? ) ");
		params.add(mainLeaseContractKey);
		params.add(mainLeaseContractKey);
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		System.out.println("CDBC_LeaseOnPosition_Object.findAllPositionsByMainDog=" + sqlb.toString()); //temp
		System.out.println("params=" + params);
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		Position_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new Position_TO(CDBC_Helper.createPositionVO(ro));
			to.setNameOtvPos(ro.getColumn("nameOtvPos").asString());
			to.setLeaseDocument((Integer) ro.getColumn("leaseDocument").asObject());
			to.setDocNumber(ro.getColumn("docNumber").asString());
			to.setMainPosition((Integer) ro.getColumn("mainPosition").asObject());
			to.setGsmIDs(ro.getColumn("gsmIDs").asString());
			to.setDampsIDs(ro.getColumn("dampsIDs").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * Имя позиции.
	 * @param posID
	 * @return
	 */
	public static final String getNamePosition(Integer posID) {
		String returnStr = null;
		CDBCResultSet res = new CDBCResultSet();
		String sql = " execute procedure getNamePosition(?) ";
		res.executeQuery(sql, new Object[] { posID });
		java.util.ListIterator iter = res.listIterator();
		if (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			returnStr = ro.getColumn("col1").asString();
		} else {
			returnStr = "Ошибка execute procedure getNamePosition(" + posID + ")";
		}
		return returnStr;
	}
}
