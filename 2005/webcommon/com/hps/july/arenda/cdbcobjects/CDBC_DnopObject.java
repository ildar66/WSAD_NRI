/*
 * Created on 18.12.2006
 *
 * "Чем оплачено начисление" CDBC_Object.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.cdbcobjects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.ListIterator;

import com.hps.july.arenda.valueobject.DnopForCharge_TO;
import com.hps.july.arenda.valueobject.DnopForPayment_TO;
import com.hps.july.arenda.valueobject.Dnop_TO;
import com.hps.july.arenda.valueobject.Dnop_VO;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBC_Object;

/**
 * @author IShaffigulin
 *
 * "Чем оплачено начисление" CDBC_Object.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_DnopObject extends CDBC_Object {
	private static final String FIND_SQL = "SELECT leaseCharge, leasePayment, chargeSum, chargeRurRate, chargeRurSum, payRurSum, source, act, usedInAct, byHandChrgRateRur FROM LeaseDnop ";
	private static final String FIND_LIST_FOR_CHARGE_SQL =
		"SELECT dnp.leaseCharge, dnp.leasePayment, dnp.chargeSum, dnp.chargeRurRate, dnp.chargeRurSum, dnp.payRurSum, dnp.source, dnp.act, dnp.usedInAct, dnp.byHandChrgRateRur, "
			+ "getNameCurrency(ldc.currency,0,0) curChargeName, "
			+ "ldma.docDate docDateAct, ldma.docNumber docNumberAct, ldma1.docDate docDateUsedInAct, ldma1.docNumber docNumberUsedInAct, "
			+ "lp.docNumber docNumberPay, lp.summRub summRubPay, "
			+ "ldp.date datePay, ldp.docPosVid "
			+ "FROM LeaseDnop dnp, leasePayments lp, leaseDocPositions ldp, leaseDocPositions ldc, outer leaseDocuments ldma, outer leaseDocuments ldma1 "
			+ "WHERE lp.leaseDocPosition = dnp.leasePayment AND ldp.leaseDocPosition = lp.leaseDocPosition "
			+ "AND ldc.leaseDocPosition = dnp.leaseCharge "
			+ "AND ldma.leaseDocument = dnp.act "
			+ "AND ldma1.leaseDocument = dnp.usedInAct ";
	private static final String FIND_LIST_FOR_PAYMENTS_SQL =
		"SELECT dnp.leaseCharge, dnp.leasePayment, dnp.chargeSum, dnp.chargeRurRate, dnp.chargeRurSum, dnp.payRurSum, dnp.source, dnp.act, dnp.usedInAct, dnp.byHandChrgRateRur, "
			+ "getNameCurrency(ldc.currency,0,0) curChargeName, "
			+ "ldma.docDate docDateAct, ldma.docNumber docNumberAct, ldma1.docDate docDateUsedInAct, ldma1.docNumber docNumberUsedInAct, "
			+ "ldc.docPosVid, "
			+ "getNameResource (ldc.resource) nameResource, "
			+ "ldc.date dateCharge, ldc.beginDate beginDateCharge, ldc.endDate endDateCharge,"
			+ "lc.billNumber billNumber, lc.billDate billDate "
			+ "FROM LeaseDnop dnp, leaseCharges lc, leaseDocPositions ldc, outer leaseDocuments ldma, outer leaseDocuments ldma1 "
			+ "WHERE lc.leaseDocPosition = dnp.leaseCharge AND ldc.leaseDocPosition = lc.leaseDocPosition "
			+ "AND ldma.leaseDocument = dnp.act "
			+ "AND ldma1.leaseDocument = dnp.usedInAct ";			
	private static final String FIND_TO_SQL =
		"SELECT dnp.leaseCharge, dnp.leasePayment, dnp.chargeSum, dnp.chargeRurRate, dnp.chargeRurSum, dnp.payRurSum, dnp.source, dnp.act, dnp.usedInAct, dnp.byHandChrgRateRur, "
			+ "getNameCurrency(ldc.currency,0,0) curChargeName, "
			+ "ldma.docDate docDateAct, ldma.docNumber docNumberAct, ldma1.docDate docDateUsedInAct, ldma1.docNumber docNumberUsedInAct, "
			+ "lp.docNumber docNumberPay, lp.summRub summRubPay, "
			+ "ldp.date datePay, ldp.docPosVid "
			+ "FROM LeaseDnop dnp, leasePayments lp, leaseDocPositions ldp, leaseDocPositions ldc, outer leaseDocuments ldma, outer leaseDocuments ldma1 "
			+ "WHERE lp.leaseDocPosition = dnp.leasePayment AND ldp.leaseDocPosition = lp.leaseDocPosition "
			+ "AND ldc.leaseDocPosition = dnp.leaseCharge "
			+ "AND ldma.leaseDocument = dnp.act "
			+ "AND ldma1.leaseDocument = dnp.usedInAct ";			
	private final static java.lang.String EDIT_SQL =
		"UPDATE LeaseDnop SET chargeSum=?, chargeRurRate=?, chargeRurSum=?, payRurSum=?, source=?, act=?, usedInAct=?, byHandChrgRateRur=? WHERE leaseCharge=? AND leasePayment=? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO LeaseDnop(leaseCharge, leasePayment, chargeSum, chargeRurRate, chargeRurSum, payRurSum, source, act, usedInAct, byHandChrgRateRur) " + "VALUES (?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM LeaseDnop WHERE leaseCharge=? AND leasePayment=? ";

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static final boolean add(Dnop_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getLeaseCharge(),
				vo.getLeasePayment(),
				vo.getChargeSum(),
				vo.getChargeRurRate(),
				vo.getChargeRurSum(),
				vo.getPayRurSum(),
				vo.getSource(),
				vo.getAct(),
				vo.getUsedInAct(),
				vo.getByHandChrgRateRur()};
		return res.executeUpdate(ADD_SQL, params);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static final boolean delete(Dnop_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getLeaseCharge(), vo.getLeasePayment()};
		return res.executeUpdate(DELETE_SQL, params);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static final boolean edit(Dnop_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getChargeSum(),
				vo.getChargeRurRate(),
				vo.getChargeRurSum(),
				vo.getPayRurSum(),
				vo.getSource(),
				vo.getAct(),
				vo.getUsedInAct(),
				vo.getByHandChrgRateRur(),
				vo.getLeaseCharge(),
				vo.getLeasePayment()};
		return res.executeUpdate(EDIT_SQL, params);
	}

	/**
	 * 
	 * @param aID
	 * @return
	 */
	public final static Dnop_VO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " WHERE leaseCharge=? AND leasePayment=? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Dnop_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			//to = new Dnop_VO(CDBC_Helper.createLoanAktGetPut(ro));
			vo = CDBC_Helper.createDnop_VO(ro);
			//vo.setCreatedByName(ro.getColumn("createdByName").asString());
			//vo.setModifiedByName(ro.getColumn("modifiedByName").asString());
		}
		return vo;
	}
	
	/**
	 * 
	 * @param aID
	 * @return
	 */
	public final static Dnop_TO findTO(int aLeaseCharge, int aLeasePayment) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aLeaseCharge), new Integer(aLeasePayment)};
		String sql = FIND_TO_SQL + " AND leaseCharge=? AND leasePayment=? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Dnop_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			to = new Dnop_TO(CDBC_Helper.createDnop_VO(ro));
			to.setCurChargeName(ro.getColumn("curChargeName").asString());
			to.setDocDateAct((Date) ro.getColumn("docDateAct").asObject());
			to.setDocNumberAct(ro.getColumn("docNumberAct").asString());
			to.setDocDateUsedInAct((Date)ro.getColumn("docDateUsedInAct").asObject());
			to.setDocNumberUsedInAct(ro.getColumn("docNumberUsedInAct").asString());
			to.setDocNumberPay(ro.getColumn("docNumberPay").asString());
			to.setSummRubPay((BigDecimal)ro.getColumn("summRubPay").asObject());
			to.setDatePay((Date)ro.getColumn("datePay").asObject());
			to.setDocPosVid(ro.getColumn("docPosVid").asString());
		}
		return to;
	}	

	/**
	 * 
	 * @param leaseCharge
	 * @param sortBy
	 * @return
	 */
	public static final List getListForCharge(Integer leaseCharge, String sortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { leaseCharge };
		String sql = FIND_LIST_FOR_CHARGE_SQL + " AND dnp.leaseCharge=? ";
		//append order by clause:
		if (sortBy != null)
			sql += " order by " + sortBy;
		System.out.println("SQL(leaseCharge=" + leaseCharge + ")=" + sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		DnopForCharge_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new DnopForCharge_TO(CDBC_Helper.createDnop_VO(ro));
			to.setCurChargeName(ro.getColumn("curChargeName").asString());
			to.setDocDateAct((Date) ro.getColumn("docDateAct").asObject());
			to.setDocNumberAct(ro.getColumn("docNumberAct").asString());
			to.setDocDateUsedInAct((Date)ro.getColumn("docDateUsedInAct").asObject());
			to.setDocNumberUsedInAct(ro.getColumn("docNumberUsedInAct").asString());
			to.setDocNumberPay(ro.getColumn("docNumberPay").asString());
			to.setSummRubPay((BigDecimal)ro.getColumn("summRubPay").asObject());
			to.setDatePay((Date)ro.getColumn("datePay").asObject());
			to.setDocPosVid(ro.getColumn("docPosVid").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * 
	 * @param leaseCharge
	 * @param sortBy
	 * @return
	 */
	public static final List getListForPayment(Integer leasePayment, String sortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { leasePayment };
		String sql = FIND_LIST_FOR_PAYMENTS_SQL + " AND dnp.leasePayment=? ";
		//append order by clause:
		if (sortBy != null)
			sql += " order by " + sortBy;
		System.out.println("SQL(leasePayment=" + leasePayment + ")=" + sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		DnopForPayment_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new DnopForPayment_TO(CDBC_Helper.createDnop_VO(ro));
			to.setCurChargeName(ro.getColumn("curChargeName").asString());
			to.setDocDateAct((Date) ro.getColumn("docDateAct").asObject());
			to.setDocNumberAct(ro.getColumn("docNumberAct").asString());
			to.setDocDateUsedInAct((Date)ro.getColumn("docDateUsedInAct").asObject());
			to.setDocNumberUsedInAct(ro.getColumn("docNumberUsedInAct").asString());
			to.setDocPosVid(ro.getColumn("docPosVid").asString());
			to.setNameResource(ro.getColumn("nameResource").asString());
			to.setDateCharge((Date)ro.getColumn("dateCharge").asObject());
			to.setBeginDateCharge((Date)ro.getColumn("beginDateCharge").asObject());
			to.setEndDateCharge((Date)ro.getColumn("endDateCharge").asObject());
			to.setBillNumber(ro.getColumn("billNumber").asString());
			to.setBillDate((Date)ro.getColumn("billDate").asObject());
			ret.add(to);
		}
		return ret;
	}

}
