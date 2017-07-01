package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPDopInfoLPaymentBean_dc156731
 */
public class EJSJDBCPersisterCMPDopInfoLPaymentBean_dc156731 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderDopInfoLPaymentBean {
	private static final String _createString = "INSERT INTO dopinfolpayments (leasedocposition, idbudjet, numpayplatinum, idpaytype, typerashod, numberanddatebdoc, definerate, flagsync, datebuch, idpaymode, iskassacheck, iskvitancia, percentavans, istovcheck, paystateplatinum, isact, datebeforepay, idexpence, dateplatinum, typeinstr, typebasedoc, purposepay, otvuser, datenritoplatinum, isschet, fl101, fl104, fl105, fl106, fl107, fl108, fl109, fl110) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM dopinfolpayments  WHERE leasedocposition = ?";
	private static final String _storeString = "UPDATE dopinfolpayments  SET idbudjet = ?, numpayplatinum = ?, idpaytype = ?, typerashod = ?, numberanddatebdoc = ?, definerate = ?, flagsync = ?, datebuch = ?, idpaymode = ?, iskassacheck = ?, iskvitancia = ?, percentavans = ?, istovcheck = ?, paystateplatinum = ?, isact = ?, datebeforepay = ?, idexpence = ?, dateplatinum = ?, typeinstr = ?, typebasedoc = ?, purposepay = ?, otvuser = ?, datenritoplatinum = ?, isschet = ?, fl101 = ?, fl104 = ?, fl105 = ?, fl106 = ?, fl107 = ?, fl108 = ?, fl109 = ?, fl110 = ? WHERE leasedocposition = ?";
	private static final String _loadString = "SELECT T1.idbudjet, T1.numpayplatinum, T1.idpaytype, T1.typerashod, T1.numberanddatebdoc, T1.leasedocposition, T1.definerate, T1.flagsync, T1.datebuch, T1.idpaymode, T1.iskassacheck, T1.iskvitancia, T1.percentavans, T1.istovcheck, T1.paystateplatinum, T1.isact, T1.datebeforepay, T1.idexpence, T1.dateplatinum, T1.typeinstr, T1.typebasedoc, T1.purposepay, T1.otvuser, T1.datenritoplatinum, T1.isschet, T1.fl101, T1.fl104, T1.fl105, T1.fl106, T1.fl107, T1.fl108, T1.fl109, T1.fl110 FROM dopinfolpayments  T1 WHERE T1.leasedocposition = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"idbudjet", "numpayplatinum", "idpaytype", "typerashod", "numberanddatebdoc", "definerate", "flagsync", "datebuch", "idpaymode", "iskassacheck", "iskvitancia", "percentavans", "istovcheck", "paystateplatinum", "isact", "datebeforepay", "idexpence", "dateplatinum", "typeinstr", "typebasedoc", "purposepay", "otvuser", "datenritoplatinum", "isschet", "fl101", "fl104", "fl105", "fl106", "fl107", "fl108", "fl109", "fl110"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPDopInfoLPaymentBean_dc156731
	 */
	public EJSJDBCPersisterCMPDopInfoLPaymentBean_dc156731() throws java.rmi.RemoteException {
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
		DopInfoLPaymentBean b = (DopInfoLPaymentBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[32];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.idbudjet == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.idbudjet.intValue());
			}
			cacheData[0] = b.idbudjet;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numpayplatinum);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.idpaytype == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.idpaytype.intValue());
			}
			cacheData[2] = b.idpaytype;
			if (b.typerashod == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.typerashod.intValue());
			}
			cacheData[3] = b.typerashod;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numberanddatebasedoc);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[4] = objectTemp;
			pstmt.setInt(1, b.leasedocposition);
			if (b.definerate == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.definerate.intValue());
			}
			cacheData[5] = b.definerate;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.flagsync);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			cacheData[6] = objectTemp;
			if (b.datebuch == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.datebuch);
			}
			cacheData[7] = b.datebuch;
			if (b.idpaymode == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.idpaymode.intValue());
			}
			cacheData[8] = b.idpaymode;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.iskassacheck);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[9] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.iskvitancia);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			cacheData[10] = objectTemp;
			if (b.percentavans == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.percentavans);
			}
			cacheData[11] = b.percentavans;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.istovcheck);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			cacheData[12] = objectTemp;
			if (b.paystateplatinum == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.paystateplatinum.intValue());
			}
			cacheData[13] = b.paystateplatinum;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isact);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			cacheData[14] = objectTemp;
			if (b.datebeforepay == null) {
				pstmt.setNull(17, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(17, b.datebeforepay);
			}
			cacheData[15] = b.datebeforepay;
			if (b.idexpence == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.idexpence.intValue());
			}
			cacheData[16] = b.idexpence;
			if (b.dateplatinum == null) {
				pstmt.setNull(19, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(19, b.dateplatinum);
			}
			cacheData[17] = b.dateplatinum;
			if (b.typeinstr == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.typeinstr.intValue());
			}
			cacheData[18] = b.typeinstr;
			if (b.typebasedoc == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.typebasedoc.intValue());
			}
			cacheData[19] = b.typebasedoc;
			if (b.purposepay == null) {
				pstmt.setNull(22, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(22, b.purposepay);
			}
			cacheData[20] = b.purposepay;
			if (b.otvuser == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.otvuser.intValue());
			}
			cacheData[21] = b.otvuser;
			if (b.datenritoplatinum == null) {
				pstmt.setNull(24, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(24, b.datenritoplatinum);
			}
			cacheData[22] = b.datenritoplatinum;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isschet);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			cacheData[23] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl101);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			cacheData[24] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl104);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			cacheData[25] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl105);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			cacheData[26] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl106);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			cacheData[27] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl107);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			cacheData[28] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl108);
			if (objectTemp == null) {
				pstmt.setNull(31, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(31, (java.lang.String)objectTemp);
			}
			cacheData[29] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl109);
			if (objectTemp == null) {
				pstmt.setNull(32, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(32, (java.lang.String)objectTemp);
			}
			cacheData[30] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl110);
			if (objectTemp == null) {
				pstmt.setNull(33, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(33, (java.lang.String)objectTemp);
			}
			cacheData[31] = objectTemp;
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
		DopInfoLPaymentBean b = (DopInfoLPaymentBean) eb;
		com.hps.july.persistence.DopInfoLPaymentKey _primaryKey = (com.hps.july.persistence.DopInfoLPaymentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leasedocposition = _primaryKey.leasedocposition;
		tempint = resultSet.getInt(1);
		b.idbudjet = resultSet.wasNull() ? null : new Integer(tempint);
		b.numpayplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		tempint = resultSet.getInt(3);
		b.idpaytype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.typerashod = resultSet.wasNull() ? null : new Integer(tempint);
		b.numberanddatebasedoc = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		tempint = resultSet.getInt(7);
		b.definerate = resultSet.wasNull() ? null : new Integer(tempint);
		b.flagsync = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.datebuch = resultSet.getDate(9);
		tempint = resultSet.getInt(10);
		b.idpaymode = resultSet.wasNull() ? null : new Integer(tempint);
		b.iskassacheck = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(11));
		b.iskvitancia = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(12));
		b.percentavans = resultSet.getBigDecimal(13);
		b.istovcheck = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(14));
		tempint = resultSet.getInt(15);
		b.paystateplatinum = resultSet.wasNull() ? null : new Integer(tempint);
		b.isact = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		b.datebeforepay = resultSet.getDate(17);
		tempint = resultSet.getInt(18);
		b.idexpence = resultSet.wasNull() ? null : new Integer(tempint);
		b.dateplatinum = resultSet.getTimestamp(19);
		tempint = resultSet.getInt(20);
		b.typeinstr = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		b.typebasedoc = resultSet.wasNull() ? null : new Integer(tempint);
		b.purposepay = resultSet.getString(22);
		tempint = resultSet.getInt(23);
		b.otvuser = resultSet.wasNull() ? null : new Integer(tempint);
		b.datenritoplatinum = resultSet.getTimestamp(24);
		b.isschet = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(25));
		b.fl101 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		b.fl104 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(27));
		b.fl105 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(28));
		b.fl106 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.fl107 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(30));
		b.fl108 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(31));
		b.fl109 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(32));
		b.fl110 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(33));
		Object[] cacheData = new Object[32];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getString(2);
		tempint = resultSet.getInt(3);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[4] = resultSet.getString(5);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[6] = resultSet.getString(8);
		cacheData[7] = resultSet.getDate(9);
		tempint = resultSet.getInt(10);
		cacheData[8] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[9] = resultSet.getString(11);
		cacheData[10] = resultSet.getString(12);
		cacheData[11] = resultSet.getBigDecimal(13);
		cacheData[12] = resultSet.getString(14);
		tempint = resultSet.getInt(15);
		cacheData[13] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[14] = resultSet.getString(16);
		cacheData[15] = resultSet.getDate(17);
		tempint = resultSet.getInt(18);
		cacheData[16] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[17] = resultSet.getTimestamp(19);
		tempint = resultSet.getInt(20);
		cacheData[18] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		cacheData[19] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[20] = resultSet.getString(22);
		tempint = resultSet.getInt(23);
		cacheData[21] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[22] = resultSet.getTimestamp(24);
		cacheData[23] = resultSet.getString(25);
		cacheData[24] = resultSet.getString(26);
		cacheData[25] = resultSet.getString(27);
		cacheData[26] = resultSet.getString(28);
		cacheData[27] = resultSet.getString(29);
		cacheData[28] = resultSet.getString(30);
		cacheData[29] = resultSet.getString(31);
		cacheData[30] = resultSet.getString(32);
		cacheData[31] = resultSet.getString(33);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		DopInfoLPaymentBean b = (DopInfoLPaymentBean) eb;
		com.hps.july.persistence.DopInfoLPaymentKey _primaryKey = (com.hps.july.persistence.DopInfoLPaymentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leasedocposition);
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
		DopInfoLPaymentBean b = (DopInfoLPaymentBean) eb;
		com.hps.july.persistence.DopInfoLPaymentKey _primaryKey = new com.hps.july.persistence.DopInfoLPaymentKey();
		_primaryKey.leasedocposition = b.leasedocposition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		DopInfoLPaymentBean b = (DopInfoLPaymentBean) eb;
		com.hps.july.persistence.DopInfoLPaymentKey _primaryKey = new com.hps.july.persistence.DopInfoLPaymentKey();
		_primaryKey.leasedocposition = b.leasedocposition;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(33, _primaryKey.leasedocposition);
			if (b.idbudjet == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.idbudjet.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numpayplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.idpaytype == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.idpaytype.intValue());
			}
			if (b.typerashod == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.typerashod.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numberanddatebasedoc);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.definerate == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.definerate.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.flagsync);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.datebuch == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.datebuch);
			}
			if (b.idpaymode == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.idpaymode.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.iskassacheck);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.iskvitancia);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.percentavans == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.percentavans);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.istovcheck);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.paystateplatinum == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.paystateplatinum.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isact);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.datebeforepay == null) {
				pstmt.setNull(16, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(16, b.datebeforepay);
			}
			if (b.idexpence == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.idexpence.intValue());
			}
			if (b.dateplatinum == null) {
				pstmt.setNull(18, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(18, b.dateplatinum);
			}
			if (b.typeinstr == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.typeinstr.intValue());
			}
			if (b.typebasedoc == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.typebasedoc.intValue());
			}
			if (b.purposepay == null) {
				pstmt.setNull(21, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(21, b.purposepay);
			}
			if (b.otvuser == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.otvuser.intValue());
			}
			if (b.datenritoplatinum == null) {
				pstmt.setNull(23, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(23, b.datenritoplatinum);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isschet);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl101);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl104);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl105);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl106);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl107);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl108);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl109);
			if (objectTemp == null) {
				pstmt.setNull(31, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(31, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl110);
			if (objectTemp == null) {
				pstmt.setNull(32, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(32, (java.lang.String)objectTemp);
			}
			int inputPos = 33;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
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
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[17]);
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
			}
			if (cacheData[20] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[20]);
			}
			if (cacheData[21] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[21]).intValue());
			}
			if (cacheData[22] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[22]);
			}
			if (cacheData[23] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[23]);
			}
			if (cacheData[24] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[24]);
			}
			if (cacheData[25] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[25]);
			}
			if (cacheData[26] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[26]);
			}
			if (cacheData[27] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[27]);
			}
			if (cacheData[28] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[28]);
			}
			if (cacheData[29] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[29]);
			}
			if (cacheData[30] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[30]);
			}
			if (cacheData[31] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[31]);
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
		DopInfoLPaymentBean b = (DopInfoLPaymentBean) eb;
		com.hps.july.persistence.DopInfoLPaymentKey _primaryKey = new com.hps.july.persistence.DopInfoLPaymentKey();
		_primaryKey.leasedocposition = b.leasedocposition;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.leasedocposition);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
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
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[17]);
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
			}
			if (cacheData[20] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[20]);
			}
			if (cacheData[21] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[21]).intValue());
			}
			if (cacheData[22] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[22]);
			}
			if (cacheData[23] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[23]);
			}
			if (cacheData[24] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[24]);
			}
			if (cacheData[25] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[25]);
			}
			if (cacheData[26] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[26]);
			}
			if (cacheData[27] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[27]);
			}
			if (cacheData[28] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[28]);
			}
			if (cacheData[29] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[29]);
			}
			if (cacheData[30] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[30]);
			}
			if (cacheData[31] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[31]);
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
		com.hps.july.persistence.DopInfoLPaymentKey key = new com.hps.july.persistence.DopInfoLPaymentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leasedocposition = resultSet.getInt(6);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.DopInfoLPayment findByPrimaryKey(com.hps.july.persistence.DopInfoLPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.DopInfoLPayment) home.activateBean(key);
	}
}
