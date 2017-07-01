package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAbonentPaymentBean_a0239318
 */
public class EJSJDBCPersisterCMPAbonentPaymentBean_a0239318 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAbonentPaymentBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO abonentpayments (paypos, sumpayusd, flagworknri, sumnrirur, sumpayrur, ben, paynumber, sumfreeusd, recordstatus, sumnriusd, needpay, pym_type, typename, sumfreerur, paydate, byhand, resource, changeneedpay, paypurpose, leasedocument) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM abonentpayments  WHERE paypos = ?";
	private static final String _storeString = "UPDATE abonentpayments  SET sumpayusd = ?, flagworknri = ?, sumnrirur = ?, sumpayrur = ?, ben = ?, paynumber = ?, sumfreeusd = ?, recordstatus = ?, sumnriusd = ?, needpay = ?, pym_type = ?, typename = ?, sumfreerur = ?, paydate = ?, byhand = ?, resource = ?, changeneedpay = ?, paypurpose = ?, leasedocument = ? WHERE paypos = ?";
	private static final String _loadString = "SELECT T1.sumpayusd, T1.flagworknri, T1.sumnrirur, T1.sumpayrur, T1.ben, T1.paypos, T1.paynumber, T1.sumfreeusd, T1.recordstatus, T1.sumnriusd, T1.needpay, T1.pym_type, T1.typename, T1.sumfreerur, T1.paydate, T1.byhand, T1.resource, T1.changeneedpay, T1.paypurpose, T1.leasedocument FROM abonentpayments  T1 WHERE T1.paypos = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"sumpayusd", "flagworknri", "sumnrirur", "sumpayrur", "ben", "paynumber", "sumfreeusd", "recordstatus", "sumnriusd", "needpay", "pym_type", "typename", "sumfreerur", "paydate", "byhand", "resource", "changeneedpay", "paypurpose", "leasedocument"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAbonentPaymentBean_a0239318
	 */
	public EJSJDBCPersisterCMPAbonentPaymentBean_a0239318() throws java.rmi.RemoteException {
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
		AbonentPaymentBean b = (AbonentPaymentBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[19];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.sumpayusd == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.sumpayusd);
			}
			cacheData[0] = b.sumpayusd;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworknri));
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.sumnrirur == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.sumnrirur);
			}
			cacheData[2] = b.sumnrirur;
			if (b.sumpayrur == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.sumpayrur);
			}
			cacheData[3] = b.sumpayrur;
			if (b.ben == null) {
				pstmt.setNull(6, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(6, b.ben.shortValue());
			}
			cacheData[4] = b.ben;
			pstmt.setInt(1, b.paypos);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paynumber);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
			if (b.sumfreeusd == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.sumfreeusd);
			}
			cacheData[6] = b.sumfreeusd;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			if (b.sumnriusd == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.sumnriusd);
			}
			cacheData[8] = b.sumnriusd;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.needpay));
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[9] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pymtype);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			cacheData[10] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typename);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			cacheData[11] = objectTemp;
			if (b.sumfreerur == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.sumfreerur);
			}
			cacheData[12] = b.sumfreerur;
			if (b.paydate == null) {
				pstmt.setNull(15, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(15, b.paydate);
			}
			cacheData[13] = b.paydate;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.byhand));
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			cacheData[14] = objectTemp;
			if (b.resource == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.resource.intValue());
			}
			cacheData[15] = b.resource;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.changeneedpay);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			cacheData[16] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.payPurpose);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			cacheData[17] = objectTemp;
			if (b.leaseabonentban_leaseDocument == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.leaseabonentban_leaseDocument.intValue());
			}
			cacheData[18] = b.leaseabonentban_leaseDocument;
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		putDataIntoCache(cacheData);
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		AbonentPaymentBean b = (AbonentPaymentBean) eb;
		com.hps.july.persistence.AbonentPaymentKey _primaryKey = (com.hps.july.persistence.AbonentPaymentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.paypos = _primaryKey.paypos;
		b.sumpayusd = resultSet.getBigDecimal(1);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(2));
		b.flagworknri = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.sumnrirur = resultSet.getBigDecimal(3);
		b.sumpayrur = resultSet.getBigDecimal(4);
		tempshort = resultSet.getShort(5);
		b.ben = resultSet.wasNull() ? null : new Short(tempshort);
		b.paynumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.sumfreeusd = resultSet.getBigDecimal(8);
		b.recordstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.sumnriusd = resultSet.getBigDecimal(10);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(11));
		b.needpay = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.pymtype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.typename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.sumfreerur = resultSet.getBigDecimal(14);
		b.paydate = resultSet.getDate(15);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		b.byhand = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		tempint = resultSet.getInt(17);
		b.resource = resultSet.wasNull() ? null : new Integer(tempint);
		b.changeneedpay = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		b.payPurpose = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(19));
		tempint = resultSet.getInt(20);
		b.leaseabonentban_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[19];
		cacheData[0] = resultSet.getBigDecimal(1);
		cacheData[1] = resultSet.getString(2);
		cacheData[2] = resultSet.getBigDecimal(3);
		cacheData[3] = resultSet.getBigDecimal(4);
		tempshort = resultSet.getShort(5);
		cacheData[4] = resultSet.wasNull() ? null : new Short(tempshort);
		cacheData[5] = resultSet.getString(7);
		cacheData[6] = resultSet.getBigDecimal(8);
		cacheData[7] = resultSet.getString(9);
		cacheData[8] = resultSet.getBigDecimal(10);
		cacheData[9] = resultSet.getString(11);
		cacheData[10] = resultSet.getString(12);
		cacheData[11] = resultSet.getString(13);
		cacheData[12] = resultSet.getBigDecimal(14);
		cacheData[13] = resultSet.getDate(15);
		cacheData[14] = resultSet.getString(16);
		tempint = resultSet.getInt(17);
		cacheData[15] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[16] = resultSet.getString(18);
		cacheData[17] = resultSet.getString(19);
		tempint = resultSet.getInt(20);
		cacheData[18] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AbonentPaymentBean b = (AbonentPaymentBean) eb;
		com.hps.july.persistence.AbonentPaymentKey _primaryKey = (com.hps.july.persistence.AbonentPaymentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.paypos);
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
		AbonentPaymentBean b = (AbonentPaymentBean) eb;
		com.hps.july.persistence.AbonentPaymentKey _primaryKey = new com.hps.july.persistence.AbonentPaymentKey();
		_primaryKey.paypos = b.paypos;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AbonentPaymentBean b = (AbonentPaymentBean) eb;
		com.hps.july.persistence.AbonentPaymentKey _primaryKey = new com.hps.july.persistence.AbonentPaymentKey();
		_primaryKey.paypos = b.paypos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(20, _primaryKey.paypos);
			if (b.sumpayusd == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.sumpayusd);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworknri));
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.sumnrirur == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.sumnrirur);
			}
			if (b.sumpayrur == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.sumpayrur);
			}
			if (b.ben == null) {
				pstmt.setNull(5, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(5, b.ben.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paynumber);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.sumfreeusd == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.sumfreeusd);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.sumnriusd == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.sumnriusd);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.needpay));
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pymtype);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typename);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.sumfreerur == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.sumfreerur);
			}
			if (b.paydate == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.paydate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.byhand));
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.resource == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.resource.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.changeneedpay);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.payPurpose);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.leaseabonentban_leaseDocument == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.leaseabonentban_leaseDocument.intValue());
			}
			int inputPos = 20;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[4]).shortValue());
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
			}
			if (cacheData[16] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[16]);
			}
			if (cacheData[17] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[17]);
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
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
		AbonentPaymentBean b = (AbonentPaymentBean) eb;
		com.hps.july.persistence.AbonentPaymentKey _primaryKey = new com.hps.july.persistence.AbonentPaymentKey();
		_primaryKey.paypos = b.paypos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.paypos);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[4]).shortValue());
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
			}
			if (cacheData[16] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[16]);
			}
			if (cacheData[17] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[17]);
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.AbonentPaymentKey key = new com.hps.july.persistence.AbonentPaymentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.paypos = resultSet.getInt(6);
			return key;
		}
return null;
	}

	/**
	 * RdbRt
	 */
	public class RdbRt {
	public static final String EQUALS = " = ";
	public static final String ISNULL = " IS NULL";
	public static final String MARKER = "?";
	public static final String AND = " AND ";
	private String fStatement;
	private String[] fPredicates = new String[0];
	private boolean[] fPredicateMap = new boolean[0];
	public RdbRt() { }
	public RdbRt(String aStmt) {
		rootStmt(aStmt);
	}
	public RdbRt(String aStmt, String[] anArray, boolean[] aMap) {
		rootStmt(aStmt);
		predicates(anArray);
		predicateMap(aMap);
	}
	public String nativeQuery() {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer);
		return aBuffer.toString();
	}
	public String nativeQuery(Object[] values) {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer, values);
		return aBuffer.toString();
	}
	public String[] predicates() {
		return fPredicates;
	}
	public void predicates(String[] anArray) {
		fPredicates = anArray;
	}
	public boolean[] predicateMap() {
		return fPredicateMap;
	}
	public void predicateMap(boolean[] anArray) {
		fPredicateMap = anArray;
	}
	public void predicatesOn(StringBuffer aBuffer, Object[] values) {
		int j = predicates().length;
		if (j != values.length)
			throw new RuntimeException("differing number of predicates and values");
		String each;
		for (int i = 0; i < j; i++) {
			if (!fPredicateMap[i]) continue;
				aBuffer.append(AND);
			each = predicates()[i];
			aBuffer.append(each);
			if (values[i] == null)
				aBuffer.append(ISNULL);
			else {
				aBuffer.append(EQUALS);
				aBuffer.append(MARKER);
			}
		}
	}
	public String rootStmt() {
		return fStatement;
	}
	public void rootStmt(String aStmt) {
		fStatement = aStmt;
	}
	public void statementOn(StringBuffer aBuffer) {
		aBuffer.append(rootStmt());
	}
	public void statementOn(StringBuffer aBuffer, Object[] values) {
		aBuffer.append(rootStmt());
		if (predicates() != null && predicates().length != 0) {
			predicatesOn(aBuffer, values);
		}
	}
	}
	/**
	 * findByBANDate
	 */
	public EJSFinder findByBANDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sumpayusd, T1.flagworknri, T1.sumnrirur, T1.sumpayrur, T1.ben, T1.paypos, T1.paynumber, T1.sumfreeusd, T1.recordstatus, T1.sumnriusd, T1.needpay, T1.pym_type, T1.typename, T1.sumfreerur, T1.paydate, T1.byhand, T1.resource, T1.changeneedpay, T1.paypurpose, T1.leasedocument FROM abonentpayments  T1 WHERE flagworknri = \'Y\' AND leasedocument IN (SELECT leaseDocument FROM LeaseAbonentBan WHERE ban=? AND bil_StartServDate > ?)");
			pstmt.setObject(1, argBan);
			pstmt.setDate(2, argStartDate);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAbonentPaymentsByLeaseabonentban
	 */
	public EJSFinder findAbonentPaymentsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sumpayusd, T1.flagworknri, T1.sumnrirur, T1.sumpayrur, T1.ben, T1.paypos, T1.paynumber, T1.sumfreeusd, T1.recordstatus, T1.sumnriusd, T1.needpay, T1.pym_type, T1.typename, T1.sumfreerur, T1.paydate, T1.byhand, T1.resource, T1.changeneedpay, T1.paypurpose, T1.leasedocument FROM abonentpayments  T1 WHERE T1.leasedocument = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByFlagWorkNRI
	 */
	public EJSFinder findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sumpayusd, T1.flagworknri, T1.sumnrirur, T1.sumpayrur, T1.ben, T1.paypos, T1.paynumber, T1.sumfreeusd, T1.recordstatus, T1.sumnriusd, T1.needpay, T1.pym_type, T1.typename, T1.sumfreerur, T1.paydate, T1.byhand, T1.resource, T1.changeneedpay, T1.paypurpose, T1.leasedocument FROM abonentpayments  T1 WHERE flagworknri = ?");
			if (argFlagWorkNRI == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argFlagWorkNRI);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByDocumentQBE2
	 */
	public EJSFinder findByDocumentQBE2(java.lang.Integer argDocument, java.lang.Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.Boolean isNeedPay, java.lang.Boolean needPay, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocumentQBE2(argDocument, isDatePeriod, argStartDate, argEndDate, isNeedPay, needPay, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByDocumentQBE
	 */
	public EJSFinder findByDocumentQBE(java.lang.Integer argDocument, java.lang.Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocumentQBE(argDocument, isDatePeriod, argStartDate, argEndDate, order);
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
	public com.hps.july.persistence.AbonentPayment findByPrimaryKey(com.hps.july.persistence.AbonentPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.AbonentPayment) home.activateBean(key);
	}
	private static final String genericFindSqlString = "SELECT T1.sumpayusd, T1.flagworknri, T1.sumnrirur, T1.sumpayrur, T1.ben, T1.paypos, T1.paynumber, T1.sumfreeusd, T1.recordstatus, T1.sumnriusd, T1.needpay, T1.pym_type, T1.typename, T1.sumfreerur, T1.paydate, T1.byhand, T1.resource, T1.changeneedpay, T1.paypurpose, T1.leasedocument FROM abonentpayments  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {314};
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
	private AbonentPaymentBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.AbonentPaymentBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.AbonentPaymentBeanFinderObject temp_finderObject = new com.hps.july.persistence.AbonentPaymentBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
