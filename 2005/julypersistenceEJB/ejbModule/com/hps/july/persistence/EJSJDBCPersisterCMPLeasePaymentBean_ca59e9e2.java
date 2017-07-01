package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeasePaymentBean_ca59e9e2
 */
public class EJSJDBCPersisterCMPLeasePaymentBean_ca59e9e2 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeasePaymentBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO leasedocpositions (leasedocposition, docposvid, date, willbeinact, operator, begindate, summ, usedinact, sumnds, enddate, source, modified, created, modifiedby, createdby, currency, act, leasecontract, resource, docpostype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO leasepayments (leasedocposition, byautorur, paymentstate, paymenttype, payrate, docnumber, isSchetFakt, rurremainder, nds_rub, summrub, officememonumber, otvworker, flagoplnds, leaserule) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM leasepayments  WHERE leasedocposition = ?", "DELETE FROM leasedocpositions  WHERE leasedocposition = ?"};
	private static final String[] _storeString = {"UPDATE leasepayments  SET byautorur = ?, paymentstate = ?, paymenttype = ?, payrate = ?, docnumber = ?, isSchetFakt = ?, rurremainder = ?, nds_rub = ?, summrub = ?, officememonumber = ?, otvworker = ?, flagoplnds = ?, leaserule = ? WHERE leasedocposition = ?", "UPDATE leasedocpositions  SET docposvid = ?, date = ?, willbeinact = ?, operator = ?, begindate = ?, summ = ?, usedinact = ?, sumnds = ?, enddate = ?, source = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, currency = ?, act = ?, leasecontract = ?, resource = ?, docpostype = ? WHERE leasedocposition = ?"};
	private static final String _loadString = "(SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER) FROM leasepayments  T2, leasedocpositions  T1 WHERE T1.leasedocposition = T2.leasedocposition AND T1.docpostype = \'P\' AND T1.leasedocposition = ?)  UNION ALL (SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, T3.billdate, T3.billnumber, T3.paypurpose, T3.pptype, T3.orgacc FROM leasepayments  T2, leasedocpositions  T1, leasepayorder  T3 WHERE T1.leasedocposition = T2.leasedocposition AND T2.leasedocposition = T3.leasedocposition AND T1.docpostype = \'O\' AND T1.leasedocposition = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeasePaymentBean_ca59e9e2
	 */
	public EJSJDBCPersisterCMPLeasePaymentBean_ca59e9e2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postInit
	 */
	public void postInit() {
	}
	/**
	 * _create
	 */
	public void _create(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeasePaymentBean b = (LeasePaymentBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docposvid);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.date == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.date);
			}
			if (b.willbeinact == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.willbeinact.intValue());
			}
			if (b.operator == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.operator.intValue());
			}
			if (b.begindate == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.begindate);
			}
			if (b.summ == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.summ);
			}
			if (b.usedinact == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.usedinact.intValue());
			}
			if (b.sumnds == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.sumnds);
			}
			if (b.enddate == null) {
				pstmt.setNull(10, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(10, b.enddate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.source);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.leaseDocPosition);
			if (b.modified == null) {
				pstmt.setNull(12, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(12, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(13, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(13, b.created);
			}
			if (b.modifiedby == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.modifiedby.intValue());
			}
			if (b.createdby == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.createdby.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.currency_currency.intValue());
			}
			if (b.act_leaseDocument == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.act_leaseDocument.intValue());
			}
			if (b.leaseContract_leaseDocument == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.leaseContract_leaseDocument.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.resource_resource.intValue());
			}
			pstmt.setString(20, "P");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.byautorur));
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paymentstate);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paymentType);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.payrate == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.payrate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docNumber);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.isSchetFakt);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.rurremainder == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.rurremainder);
			}
			if (b.ndsRub == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.ndsRub);
			}
			if (b.sumRub == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.sumRub);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.officememonumber);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.otvworker == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.otvworker.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.flagOplNds);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.leaseRule_leaseRule == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.leaseRule_leaseRule.intValue());
			}
			pstmt.setInt(1, b.leaseDocPosition);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		LeasePaymentBean b = (LeasePaymentBean) eb;
		com.hps.july.persistence.LeaseDocPositionKey _primaryKey = (com.hps.july.persistence.LeaseDocPositionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leaseDocPosition = _primaryKey.leaseDocPosition;
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(21));
		b.byautorur = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.paymentstate = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(22));
		b.paymentType = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(23));
		b.payrate = resultSet.getBigDecimal(24);
		b.docNumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(25));
		b.isSchetFakt = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		b.rurremainder = resultSet.getBigDecimal(27);
		b.ndsRub = resultSet.getBigDecimal(28);
		b.sumRub = resultSet.getBigDecimal(29);
		b.officememonumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(30));
		tempint = resultSet.getInt(31);
		b.otvworker = resultSet.wasNull() ? null : new Integer(tempint);
		b.flagOplNds = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(32));
		tempint = resultSet.getInt(33);
		b.leaseRule_leaseRule = resultSet.wasNull() ? null : new Integer(tempint);
		b.docposvid = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.date = resultSet.getDate(2);
		tempint = resultSet.getInt(3);
		b.willbeinact = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		b.begindate = resultSet.getDate(5);
		b.summ = resultSet.getBigDecimal(6);
		tempint = resultSet.getInt(7);
		b.usedinact = resultSet.wasNull() ? null : new Integer(tempint);
		b.sumnds = resultSet.getBigDecimal(8);
		b.enddate = resultSet.getDate(9);
		b.source = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.modified = resultSet.getTimestamp(12);
		b.created = resultSet.getTimestamp(13);
		tempint = resultSet.getInt(14);
		b.modifiedby = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.createdby = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		b.currency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(17);
		b.act_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		b.leaseContract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(19);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeasePaymentBean b = (LeasePaymentBean) eb;
		com.hps.july.persistence.LeaseDocPositionKey _primaryKey = (com.hps.july.persistence.LeaseDocPositionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocPosition);
			pstmt.setInt(2, _primaryKey.leaseDocPosition);
			resultSet = pstmt.executeQuery();
			if (!(resultSet.next())) throw new javax.ejb.ObjectNotFoundException();
			hydrate(eb, resultSet, pKey);
		}
		finally {
			if (resultSet != null) resultSet.close();
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * refresh
	 */
	public void refresh(EntityBean eb, boolean forUpdate) throws Exception {
		LeasePaymentBean b = (LeasePaymentBean) eb;
		com.hps.july.persistence.LeaseDocPositionKey _primaryKey = new com.hps.july.persistence.LeaseDocPositionKey();
		_primaryKey.leaseDocPosition = b.leaseDocPosition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeasePaymentBean b = (LeasePaymentBean) eb;
		com.hps.july.persistence.LeaseDocPositionKey _primaryKey = new com.hps.july.persistence.LeaseDocPositionKey();
		_primaryKey.leaseDocPosition = b.leaseDocPosition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(14, _primaryKey.leaseDocPosition);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.byautorur));
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paymentstate);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paymentType);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.payrate == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.payrate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docNumber);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.isSchetFakt);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.rurremainder == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.rurremainder);
			}
			if (b.ndsRub == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.ndsRub);
			}
			if (b.sumRub == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.sumRub);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.officememonumber);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.otvworker == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.otvworker.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.flagOplNds);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.leaseRule_leaseRule == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.leaseRule_leaseRule.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(20, _primaryKey.leaseDocPosition);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docposvid);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.date == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.date);
			}
			if (b.willbeinact == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.willbeinact.intValue());
			}
			if (b.operator == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.operator.intValue());
			}
			if (b.begindate == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.begindate);
			}
			if (b.summ == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.summ);
			}
			if (b.usedinact == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.usedinact.intValue());
			}
			if (b.sumnds == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.sumnds);
			}
			if (b.enddate == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.enddate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.source);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.modified == null) {
				pstmt.setNull(11, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(11, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(12, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(12, b.created);
			}
			if (b.modifiedby == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.modifiedby.intValue());
			}
			if (b.createdby == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.createdby.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.currency_currency.intValue());
			}
			if (b.act_leaseDocument == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.act_leaseDocument.intValue());
			}
			if (b.leaseContract_leaseDocument == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.leaseContract_leaseDocument.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.resource_resource.intValue());
			}
			pstmt.setString(19, "P");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeasePaymentBean b = (LeasePaymentBean) eb;
		com.hps.july.persistence.LeaseDocPositionKey _primaryKey = new com.hps.july.persistence.LeaseDocPositionKey();
		_primaryKey.leaseDocPosition = b.leaseDocPosition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocPosition);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocPosition);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.LeaseDocPositionKey key = new com.hps.july.persistence.LeaseDocPositionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leaseDocPosition = resultSet.getInt(11);
			return key;
		}
return null;
	}
	/**
	 * getBean
	 */
	public javax.ejb.EJBObject getBean(Object obj) throws Exception {
		javax.ejb.EJBObject bean = null;
		ResultSet rs = (ResultSet) obj;
		java.lang.String discriminator = rs.getString(20).trim();
		if ( discriminator.equals("P") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("O") ) {
				homeName = "LeasePayOrder";
			}
			if (homeName != null) {
				bean = ((com.ibm.ejs.container.EJSHome)home).getBean(homeName, getPrimaryKey(rs), rs);
			}
		}
		if (bean == null) {
			try{
				if (rs != null) rs.close();
			}
			catch (SQLException sqlExc) {}
			throw new EJSPersistenceException("Unknown or superclass discriminator value retrieved from database.");
		}
		return bean;
	}
	/**
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Integer leaseRule, java.sql.Date startDate, java.sql.Date finishDate, java.lang.Boolean isSource, java.lang.String source) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(leaseRule, startDate, finishDate, isSource, source);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeasePayment findByPrimaryKey(com.hps.july.persistence.LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.LeasePayment result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.LeaseDocPositionKey _primaryKey = (com.hps.july.persistence.LeaseDocPositionKey)key;
		try {
			try {
				result = (com.hps.july.persistence.LeasePayment)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.leaseDocPosition);
				pstmt.setInt(2, _primaryKey.leaseDocPosition);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.LeasePayment)tmpFinder.nextElement();
				}
			}
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
		finally {
			if ( tmpFinder != null ) tmpFinder.close();
		}
		if (result == null) {
			throw new javax.ejb.ObjectNotFoundException();
		}
		return result;
	}
	/**
	 * findByLeaseContract
	 */
	public EJSFinder findByLeaseContract(java.lang.Integer argContract) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER) FROM leasepayments  T2, leasedocpositions  T1 WHERE T1.leasedocposition = T2.leasedocposition AND T1.docpostype = \'P\' AND leasecontract = ?)  UNION ALL (SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, T3.billdate, T3.billnumber, T3.paypurpose, T3.pptype, T3.orgacc FROM leasepayments  T2, leasedocpositions  T1, leasepayorder  T3 WHERE T1.leasedocposition = T2.leasedocposition AND T2.leasedocposition = T3.leasedocposition AND T1.docpostype = \'O\' AND leasecontract = ?) ");
			for (int _EJS_i=0; _EJS_i<2; _EJS_i+=1) {
				pstmt.setObject(_EJS_i+1, argContract);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE5
	 */
	public EJSFinder findByQBE5(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isDocposvid, java.lang.String[] docposvid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE5(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, isDocposvid, docposvid, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeasePaymentByLeaseRule
	 */
	public EJSFinder findLeasePaymentByLeaseRule(com.hps.july.persistence.LeaseRuleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER) FROM leasepayments  T2, leasedocpositions  T1 WHERE T1.leasedocposition = T2.leasedocposition AND T1.docpostype = \'P\' AND T2.leaserule = ?)  UNION ALL (SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, T3.billdate, T3.billnumber, T3.paypurpose, T3.pptype, T3.orgacc FROM leasepayments  T2, leasedocpositions  T1, leasepayorder  T3 WHERE T1.leasedocposition = T2.leasedocposition AND T2.leasedocposition = T3.leasedocposition AND T1.docpostype = \'O\' AND T2.leaserule = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseRule);
			pstmt.setInt(2, inKey.leaseRule);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE4
	 */
	public EJSFinder findByQBE4(java.lang.Integer contract, java.lang.Boolean isStartDate, java.sql.Date actStartDate, java.lang.Boolean isEndDate, java.sql.Date actEndDate, java.lang.Boolean isRemainder, java.math.BigDecimal remainder, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isCalcPosOnly, java.lang.Boolean isAutoRUR, java.lang.Boolean autoRUR) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE4(contract, isStartDate, actStartDate, isEndDate, actEndDate, isRemainder, remainder, isResource, resource, isCalcPosOnly, isAutoRUR, autoRUR);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE3
	 */
	public EJSFinder findByQBE3(java.lang.Integer leaseContract, java.lang.Integer resource, java.sql.Date startInterval, java.sql.Date finishInterval) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE3(leaseContract, resource, startInterval, finishInterval);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "(SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER) FROM leasepayments  T2, leasedocpositions  T1 WHERE T1.leasedocposition = T2.leasedocposition AND T1.docpostype = \'P\' AND )  UNION ALL (SELECT T1.docposvid, T1.date, T1.willbeinact, T1.operator, T1.begindate, T1.summ, T1.usedinact, T1.sumnds, T1.enddate, T1.source, T1.leasedocposition, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.currency, T1.act, T1.leasecontract, T1.resource, T1.docpostype, T2.byautorur, T2.paymentstate, T2.paymenttype, T2.payrate, T2.docnumber, T2.isSchetFakt, T2.rurremainder, T2.nds_rub, T2.summrub, T2.officememonumber, T2.otvworker, T2.flagoplnds, T2.leaserule, T3.billdate, T3.billnumber, T3.paypurpose, T3.pptype, T3.orgacc FROM leasepayments  T2, leasedocpositions  T1, leasepayorder  T3 WHERE T1.leasedocposition = T2.leasedocposition AND T2.leasedocposition = T3.leasedocposition AND T1.docpostype = \'O\' AND ) ";
	private static final int[] genericFindInsertPoints = {1447, 716};
	/**
	 * getMergedPreparedStatement
	 */
	public PreparedStatement getMergedPreparedStatement(String searchCondition) throws Exception {
		StringBuffer sb = new StringBuffer(genericFindSqlString);
		for (int i = 0; i < genericFindInsertPoints.length; i++) {
		   sb.insert(genericFindInsertPoints[i], searchCondition);
		}
		return super.getPreparedStatement(sb.toString());
	}
	/**
	 * getMergedWhereCount
	 */
	public int getMergedWhereCount() {
		return genericFindInsertPoints.length;
	}
	/**
	 * getGenericFindSqlString
	 */
	public String getGenericFindSqlString() {
		return genericFindSqlString;
	}
	/**
	 * getGenericFindInsertPoints
	 */
	public int[] getGenericFindInsertPoints() {
		return genericFindInsertPoints;
	}
	private LeasePaymentBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeasePaymentBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeasePaymentBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeasePaymentBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
