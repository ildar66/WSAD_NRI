package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAbonentBillPosBean_5236dd9f
 */
public class EJSJDBCPersisterCMPAbonentBillPosBean_5236dd9f extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAbonentBillPosBean {
	private static final String _createString = "INSERT INTO informix.abonentbillpos (billpos, summ, summpure, cargocountry, qty, unitname, ndssumm, nspsumm, itemname, ndsrate, itemid, cargonumber, nsprate, sumpurenri, ndssummnri, nspsummnri, recordstatus, sumbyhand, summnri, resource, leasebill, currency) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.abonentbillpos  WHERE billpos = ?";
	private static final String _storeString = "UPDATE informix.abonentbillpos  SET summ = ?, summpure = ?, cargocountry = ?, qty = ?, unitname = ?, ndssumm = ?, nspsumm = ?, itemname = ?, ndsrate = ?, itemid = ?, cargonumber = ?, nsprate = ?, sumpurenri = ?, ndssummnri = ?, nspsummnri = ?, recordstatus = ?, sumbyhand = ?, summnri = ?, resource = ?, leasebill = ?, currency = ? WHERE billpos = ?";
	private static final String _loadString = "SELECT T1.summ, T1.summpure, T1.cargocountry, T1.billpos, T1.qty, T1.unitname, T1.ndssumm, T1.nspsumm, T1.itemname, T1.ndsrate, T1.itemid, T1.cargonumber, T1.nsprate, T1.sumpurenri, T1.ndssummnri, T1.nspsummnri, T1.recordstatus, T1.sumbyhand, T1.summnri, T1.resource, T1.leasebill, T1.currency FROM informix.abonentbillpos  T1 WHERE T1.billpos = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"summ", "summpure", "cargocountry", "qty", "unitname", "ndssumm", "nspsumm", "itemname", "ndsrate", "itemid", "cargonumber", "nsprate", "sumpurenri", "ndssummnri", "nspsummnri", "recordstatus", "sumbyhand", "summnri", "resource", "leasebill", "currency"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAbonentBillPosBean_5236dd9f
	 */
	public EJSJDBCPersisterCMPAbonentBillPosBean_5236dd9f() throws java.rmi.RemoteException {
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
		AbonentBillPosBean b = (AbonentBillPosBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[21];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.summ == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.summ);
			}
			cacheData[0] = b.summ;
			if (b.summpure == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.summpure);
			}
			cacheData[1] = b.summpure;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.cargocountry);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			pstmt.setInt(1, b.billpos);
			if (b.qty == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.qty);
			}
			cacheData[3] = b.qty;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.unitname);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[4] = objectTemp;
			if (b.ndssumm == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.ndssumm);
			}
			cacheData[5] = b.ndssumm;
			if (b.nspsumm == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.nspsumm);
			}
			cacheData[6] = b.nspsumm;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.itemname);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			if (b.ndsrate == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.ndsrate);
			}
			cacheData[8] = b.ndsrate;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.itemid);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[9] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.cargonumber);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			cacheData[10] = objectTemp;
			if (b.nsprate == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.nsprate);
			}
			cacheData[11] = b.nsprate;
			if (b.summpurenri == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.summpurenri);
			}
			cacheData[12] = b.summpurenri;
			if (b.ndssummnri == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.ndssummnri);
			}
			cacheData[13] = b.ndssummnri;
			if (b.nspsummnri == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.nspsummnri);
			}
			cacheData[14] = b.nspsummnri;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			cacheData[15] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.sumbyhand));
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			cacheData[16] = objectTemp;
			if (b.summnri == null) {
				pstmt.setNull(19, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(19, b.summnri);
			}
			cacheData[17] = b.summnri;
			if (b.pos2resource_resource == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.pos2resource_resource.intValue());
			}
			cacheData[18] = b.pos2resource_resource;
			if (b.pos2bill_leasebill == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.pos2bill_leasebill.intValue());
			}
			cacheData[19] = b.pos2bill_leasebill;
			if (b.pos2currency_currency == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.pos2currency_currency.intValue());
			}
			cacheData[20] = b.pos2currency_currency;
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
		AbonentBillPosBean b = (AbonentBillPosBean) eb;
		com.hps.july.persistence.AbonentBillPosKey _primaryKey = (com.hps.july.persistence.AbonentBillPosKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.billpos = _primaryKey.billpos;
		b.summ = resultSet.getBigDecimal(1);
		b.summpure = resultSet.getBigDecimal(2);
		b.cargocountry = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.qty = resultSet.getBigDecimal(5);
		b.unitname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.ndssumm = resultSet.getBigDecimal(7);
		b.nspsumm = resultSet.getBigDecimal(8);
		b.itemname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.ndsrate = resultSet.getBigDecimal(10);
		b.itemid = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		b.cargonumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.nsprate = resultSet.getBigDecimal(13);
		b.summpurenri = resultSet.getBigDecimal(14);
		b.ndssummnri = resultSet.getBigDecimal(15);
		b.nspsummnri = resultSet.getBigDecimal(16);
		b.recordstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(17));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(18));
		b.sumbyhand = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.summnri = resultSet.getBigDecimal(19);
		tempint = resultSet.getInt(20);
		b.pos2resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		b.pos2bill_leasebill = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		b.pos2currency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[21];
		cacheData[0] = resultSet.getBigDecimal(1);
		cacheData[1] = resultSet.getBigDecimal(2);
		cacheData[2] = resultSet.getString(3);
		cacheData[3] = resultSet.getBigDecimal(5);
		cacheData[4] = resultSet.getString(6);
		cacheData[5] = resultSet.getBigDecimal(7);
		cacheData[6] = resultSet.getBigDecimal(8);
		cacheData[7] = resultSet.getString(9);
		cacheData[8] = resultSet.getBigDecimal(10);
		cacheData[9] = resultSet.getString(11);
		cacheData[10] = resultSet.getString(12);
		cacheData[11] = resultSet.getBigDecimal(13);
		cacheData[12] = resultSet.getBigDecimal(14);
		cacheData[13] = resultSet.getBigDecimal(15);
		cacheData[14] = resultSet.getBigDecimal(16);
		cacheData[15] = resultSet.getString(17);
		cacheData[16] = resultSet.getString(18);
		cacheData[17] = resultSet.getBigDecimal(19);
		tempint = resultSet.getInt(20);
		cacheData[18] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		cacheData[19] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		cacheData[20] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AbonentBillPosBean b = (AbonentBillPosBean) eb;
		com.hps.july.persistence.AbonentBillPosKey _primaryKey = (com.hps.july.persistence.AbonentBillPosKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.billpos);
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
		AbonentBillPosBean b = (AbonentBillPosBean) eb;
		com.hps.july.persistence.AbonentBillPosKey _primaryKey = new com.hps.july.persistence.AbonentBillPosKey();
		_primaryKey.billpos = b.billpos;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AbonentBillPosBean b = (AbonentBillPosBean) eb;
		com.hps.july.persistence.AbonentBillPosKey _primaryKey = new com.hps.july.persistence.AbonentBillPosKey();
		_primaryKey.billpos = b.billpos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(22, _primaryKey.billpos);
			if (b.summ == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.summ);
			}
			if (b.summpure == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.summpure);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.cargocountry);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.qty == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.unitname);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.ndssumm == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.ndssumm);
			}
			if (b.nspsumm == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.nspsumm);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.itemname);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.ndsrate == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.ndsrate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.itemid);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.cargonumber);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.nsprate == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.nsprate);
			}
			if (b.summpurenri == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.summpurenri);
			}
			if (b.ndssummnri == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.ndssummnri);
			}
			if (b.nspsummnri == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.nspsummnri);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.sumbyhand));
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			if (b.summnri == null) {
				pstmt.setNull(18, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(18, b.summnri);
			}
			if (b.pos2resource_resource == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.pos2resource_resource.intValue());
			}
			if (b.pos2bill_leasebill == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.pos2bill_leasebill.intValue());
			}
			if (b.pos2currency_currency == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.pos2currency_currency.intValue());
			}
			int inputPos = 22;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[16]);
			}
			if (cacheData[17] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[17]);
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
			}
			if (cacheData[20] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[20]).intValue());
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
		AbonentBillPosBean b = (AbonentBillPosBean) eb;
		com.hps.july.persistence.AbonentBillPosKey _primaryKey = new com.hps.july.persistence.AbonentBillPosKey();
		_primaryKey.billpos = b.billpos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.billpos);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[16]);
			}
			if (cacheData[17] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[17]);
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
			}
			if (cacheData[20] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[20]).intValue());
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
		com.hps.july.persistence.AbonentBillPosKey key = new com.hps.july.persistence.AbonentBillPosKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.billpos = resultSet.getInt(4);
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
	 * findAbonentBillPosesByPos2resource
	 */
	public EJSFinder findAbonentBillPosesByPos2resource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.summ, T1.summpure, T1.cargocountry, T1.billpos, T1.qty, T1.unitname, T1.ndssumm, T1.nspsumm, T1.itemname, T1.ndsrate, T1.itemid, T1.cargonumber, T1.nsprate, T1.sumpurenri, T1.ndssummnri, T1.nspsummnri, T1.recordstatus, T1.sumbyhand, T1.summnri, T1.resource, T1.leasebill, T1.currency FROM informix.abonentbillpos  T1 WHERE T1.resource = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByLeaseBill
	 */
	public EJSFinder findByLeaseBill(java.lang.Integer leaseBill) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.summ, T1.summpure, T1.cargocountry, T1.billpos, T1.qty, T1.unitname, T1.ndssumm, T1.nspsumm, T1.itemname, T1.ndsrate, T1.itemid, T1.cargonumber, T1.nsprate, T1.sumpurenri, T1.ndssummnri, T1.nspsummnri, T1.recordstatus, T1.sumbyhand, T1.summnri, T1.resource, T1.leasebill, T1.currency FROM informix.abonentbillpos  T1 WHERE leaseBill = ? order by BillPos");
			pstmt.setObject(1, leaseBill);
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
	public com.hps.july.persistence.AbonentBillPos findByPrimaryKey(com.hps.july.persistence.AbonentBillPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.AbonentBillPos) home.activateBean(key);
	}
	/**
	 * findAbonentBillPosesByPos2currency
	 */
	public EJSFinder findAbonentBillPosesByPos2currency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.summ, T1.summpure, T1.cargocountry, T1.billpos, T1.qty, T1.unitname, T1.ndssumm, T1.nspsumm, T1.itemname, T1.ndsrate, T1.itemid, T1.cargonumber, T1.nsprate, T1.sumpurenri, T1.ndssummnri, T1.nspsummnri, T1.recordstatus, T1.sumbyhand, T1.summnri, T1.resource, T1.leasebill, T1.currency FROM informix.abonentbillpos  T1 WHERE T1.currency = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.currency);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAbonentBillPosesByPos2bill
	 */
	public EJSFinder findAbonentBillPosesByPos2bill(com.hps.july.persistence.AbonentBillKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.summ, T1.summpure, T1.cargocountry, T1.billpos, T1.qty, T1.unitname, T1.ndssumm, T1.nspsumm, T1.itemname, T1.ndsrate, T1.itemid, T1.cargonumber, T1.nsprate, T1.sumpurenri, T1.ndssummnri, T1.nspsummnri, T1.recordstatus, T1.sumbyhand, T1.summnri, T1.resource, T1.leasebill, T1.currency FROM informix.abonentbillpos  T1 WHERE T1.leasebill = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leasebill);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
