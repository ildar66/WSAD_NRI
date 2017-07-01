package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEPayNRIBean_6b039a46
 */
public class EJSJDBCPersisterCMPPIEPayNRIBean_6b039a46 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEPayNRIBean {
	private static final String _createString = "INSERT INTO pie_paysnri (id, idexpence, purposepay, idpaytype, idbudjet, idaccountnri, numberanddatebdoc, typebasedoc, sumpay, idusernri, iddogovnri, datebuch, definerate, datecreate, idpaymode, percentavans, datebeforepay, valutepay, isavans, idtypeforbuch, typedogovnri, tip_rasxodov, ndspay, fl101, fl104, fl105, fl106, fl107, fl108, fl109, fl110, id_query) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_paysnri  WHERE id = ?";
	private static final String _storeString = "UPDATE pie_paysnri  SET idexpence = ?, purposepay = ?, idpaytype = ?, idbudjet = ?, idaccountnri = ?, numberanddatebdoc = ?, typebasedoc = ?, sumpay = ?, idusernri = ?, iddogovnri = ?, datebuch = ?, definerate = ?, datecreate = ?, idpaymode = ?, percentavans = ?, datebeforepay = ?, valutepay = ?, isavans = ?, idtypeforbuch = ?, typedogovnri = ?, tip_rasxodov = ?, ndspay = ?, fl101 = ?, fl104 = ?, fl105 = ?, fl106 = ?, fl107 = ?, fl108 = ?, fl109 = ?, fl110 = ?, id_query = ? WHERE id = ?";
	private static final String _loadString = "SELECT T1.idexpence, T1.purposepay, T1.idpaytype, T1.idbudjet, T1.idaccountnri, T1.id, T1.numberanddatebdoc, T1.typebasedoc, T1.sumpay, T1.idusernri, T1.iddogovnri, T1.datebuch, T1.definerate, T1.datecreate, T1.idpaymode, T1.percentavans, T1.datebeforepay, T1.valutepay, T1.isavans, T1.idtypeforbuch, T1.typedogovnri, T1.tip_rasxodov, T1.ndspay, T1.fl101, T1.fl104, T1.fl105, T1.fl106, T1.fl107, T1.fl108, T1.fl109, T1.fl110, T1.id_query FROM pie_paysnri  T1 WHERE T1.id = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"idexpence", "purposepay", "idpaytype", "idbudjet", "idaccountnri", "numberanddatebdoc", "typebasedoc", "sumpay", "idusernri", "iddogovnri", "datebuch", "definerate", "datecreate", "idpaymode", "percentavans", "datebeforepay", "valutepay", "isavans", "idtypeforbuch", "typedogovnri", "tip_rasxodov", "ndspay", "fl101", "fl104", "fl105", "fl106", "fl107", "fl108", "fl109", "fl110", "id_query"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEPayNRIBean_6b039a46
	 */
	public EJSJDBCPersisterCMPPIEPayNRIBean_6b039a46() throws java.rmi.RemoteException {
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
		PIEPayNRIBean b = (PIEPayNRIBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[31];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.idexpence == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.idexpence.intValue());
			}
			cacheData[0] = b.idexpence;
			if (b.purposepay == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.purposepay);
			}
			cacheData[1] = b.purposepay;
			if (b.idpaytype == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.idpaytype.intValue());
			}
			cacheData[2] = b.idpaytype;
			if (b.idbudjet == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.idbudjet.intValue());
			}
			cacheData[3] = b.idbudjet;
			pstmt.setInt(6, b.idaccountnri);
			cacheData[4] = new Integer(b.idaccountnri);
			pstmt.setInt(1, b.id);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numberanddatebdoc);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
			if (b.typebasedoc == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.typebasedoc.intValue());
			}
			cacheData[6] = b.typebasedoc;
			if (b.sumpay == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.sumpay);
			}
			cacheData[7] = b.sumpay;
			if (b.idusernri == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.idusernri.intValue());
			}
			cacheData[8] = b.idusernri;
			pstmt.setInt(11, b.iddogovnri);
			cacheData[9] = new Integer(b.iddogovnri);
			if (b.datebuch == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.datebuch);
			}
			cacheData[10] = b.datebuch;
			if (b.definerate == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.definerate.intValue());
			}
			cacheData[11] = b.definerate;
			if (b.datecreate == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.datecreate);
			}
			cacheData[12] = b.datecreate;
			if (b.idpaymode == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.idpaymode.intValue());
			}
			cacheData[13] = b.idpaymode;
			if (b.percentavans == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.percentavans);
			}
			cacheData[14] = b.percentavans;
			if (b.datebeforepay == null) {
				pstmt.setNull(17, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(17, b.datebeforepay);
			}
			cacheData[15] = b.datebeforepay;
			pstmt.setInt(18, b.valutepay);
			cacheData[16] = new Integer(b.valutepay);
			if (b.isavans == null) {
				pstmt.setNull(19, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(19, b.isavans.shortValue());
			}
			cacheData[17] = b.isavans;
			if (b.idtypeforbuch == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.idtypeforbuch.intValue());
			}
			cacheData[18] = b.idtypeforbuch;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typedogovnri);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			cacheData[19] = objectTemp;
			if (b.tiprasxodov == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.tiprasxodov.intValue());
			}
			cacheData[20] = b.tiprasxodov;
			if (b.ndspay == null) {
				pstmt.setNull(23, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(23, b.ndspay);
			}
			cacheData[21] = b.ndspay;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl101);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			cacheData[22] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl104);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			cacheData[23] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl105);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			cacheData[24] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl106);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			cacheData[25] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl107);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			cacheData[26] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl108);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			cacheData[27] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl109);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			cacheData[28] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl110);
			if (objectTemp == null) {
				pstmt.setNull(31, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(31, (java.lang.String)objectTemp);
			}
			cacheData[29] = objectTemp;
			if (b.query_idquery == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.query_idquery.intValue());
			}
			cacheData[30] = b.query_idquery;
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
		PIEPayNRIBean b = (PIEPayNRIBean) eb;
		com.hps.july.persistence.PIEPayNRIKey _primaryKey = (com.hps.july.persistence.PIEPayNRIKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.id = _primaryKey.id;
		tempint = resultSet.getInt(1);
		b.idexpence = resultSet.wasNull() ? null : new Integer(tempint);
		b.purposepay = resultSet.getString(2);
		tempint = resultSet.getInt(3);
		b.idpaytype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.idbudjet = resultSet.wasNull() ? null : new Integer(tempint);
		b.idaccountnri = resultSet.getInt(5);
		b.numberanddatebdoc = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		tempint = resultSet.getInt(8);
		b.typebasedoc = resultSet.wasNull() ? null : new Integer(tempint);
		b.sumpay = resultSet.getBigDecimal(9);
		tempint = resultSet.getInt(10);
		b.idusernri = resultSet.wasNull() ? null : new Integer(tempint);
		b.iddogovnri = resultSet.getInt(11);
		b.datebuch = resultSet.getDate(12);
		tempint = resultSet.getInt(13);
		b.definerate = resultSet.wasNull() ? null : new Integer(tempint);
		b.datecreate = resultSet.getDate(14);
		tempint = resultSet.getInt(15);
		b.idpaymode = resultSet.wasNull() ? null : new Integer(tempint);
		b.percentavans = resultSet.getBigDecimal(16);
		b.datebeforepay = resultSet.getDate(17);
		b.valutepay = resultSet.getInt(18);
		tempshort = resultSet.getShort(19);
		b.isavans = resultSet.wasNull() ? null : new Short(tempshort);
		tempint = resultSet.getInt(20);
		b.idtypeforbuch = resultSet.wasNull() ? null : new Integer(tempint);
		b.typedogovnri = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(21));
		tempint = resultSet.getInt(22);
		b.tiprasxodov = resultSet.wasNull() ? null : new Integer(tempint);
		b.ndspay = resultSet.getBigDecimal(23);
		b.fl101 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(24));
		b.fl104 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(25));
		b.fl105 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		b.fl106 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(27));
		b.fl107 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(28));
		b.fl108 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.fl109 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(30));
		b.fl110 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(31));
		tempint = resultSet.getInt(32);
		b.query_idquery = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[31];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getString(2);
		tempint = resultSet.getInt(3);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[5] = resultSet.getString(7);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[7] = resultSet.getBigDecimal(9);
		tempint = resultSet.getInt(10);
		cacheData[8] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(11);
		cacheData[9] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[10] = resultSet.getDate(12);
		tempint = resultSet.getInt(13);
		cacheData[11] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[12] = resultSet.getDate(14);
		tempint = resultSet.getInt(15);
		cacheData[13] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[14] = resultSet.getBigDecimal(16);
		cacheData[15] = resultSet.getDate(17);
		tempint = resultSet.getInt(18);
		cacheData[16] = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(19);
		cacheData[17] = resultSet.wasNull() ? null : new Short(tempshort);
		tempint = resultSet.getInt(20);
		cacheData[18] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[19] = resultSet.getString(21);
		tempint = resultSet.getInt(22);
		cacheData[20] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[21] = resultSet.getBigDecimal(23);
		cacheData[22] = resultSet.getString(24);
		cacheData[23] = resultSet.getString(25);
		cacheData[24] = resultSet.getString(26);
		cacheData[25] = resultSet.getString(27);
		cacheData[26] = resultSet.getString(28);
		cacheData[27] = resultSet.getString(29);
		cacheData[28] = resultSet.getString(30);
		cacheData[29] = resultSet.getString(31);
		tempint = resultSet.getInt(32);
		cacheData[30] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEPayNRIBean b = (PIEPayNRIBean) eb;
		com.hps.july.persistence.PIEPayNRIKey _primaryKey = (com.hps.july.persistence.PIEPayNRIKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.id);
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
		PIEPayNRIBean b = (PIEPayNRIBean) eb;
		com.hps.july.persistence.PIEPayNRIKey _primaryKey = new com.hps.july.persistence.PIEPayNRIKey();
		_primaryKey.id = b.id;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEPayNRIBean b = (PIEPayNRIBean) eb;
		com.hps.july.persistence.PIEPayNRIKey _primaryKey = new com.hps.july.persistence.PIEPayNRIKey();
		_primaryKey.id = b.id;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(32, _primaryKey.id);
			if (b.idexpence == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.idexpence.intValue());
			}
			if (b.purposepay == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.purposepay);
			}
			if (b.idpaytype == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.idpaytype.intValue());
			}
			if (b.idbudjet == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.idbudjet.intValue());
			}
			pstmt.setInt(5, b.idaccountnri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numberanddatebdoc);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.typebasedoc == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.typebasedoc.intValue());
			}
			if (b.sumpay == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.sumpay);
			}
			if (b.idusernri == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.idusernri.intValue());
			}
			pstmt.setInt(10, b.iddogovnri);
			if (b.datebuch == null) {
				pstmt.setNull(11, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(11, b.datebuch);
			}
			if (b.definerate == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.definerate.intValue());
			}
			if (b.datecreate == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.datecreate);
			}
			if (b.idpaymode == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.idpaymode.intValue());
			}
			if (b.percentavans == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.percentavans);
			}
			if (b.datebeforepay == null) {
				pstmt.setNull(16, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(16, b.datebeforepay);
			}
			pstmt.setInt(17, b.valutepay);
			if (b.isavans == null) {
				pstmt.setNull(18, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(18, b.isavans.shortValue());
			}
			if (b.idtypeforbuch == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.idtypeforbuch.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typedogovnri);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			if (b.tiprasxodov == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.tiprasxodov.intValue());
			}
			if (b.ndspay == null) {
				pstmt.setNull(22, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(22, b.ndspay);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl101);
			if (objectTemp == null) {
				pstmt.setNull(23, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(23, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl104);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl105);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl106);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl107);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl108);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl109);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fl110);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			if (b.query_idquery == null) {
				pstmt.setNull(31, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(31, b.query_idquery.intValue());
			}
			int inputPos = 32;
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
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[17]).shortValue());
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[19]);
			}
			if (cacheData[20] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[20]).intValue());
			}
			if (cacheData[21] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[21]);
			}
			if (cacheData[22] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[22]);
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
				pstmt.setInt(++inputPos, ((Number)cacheData[30]).intValue());
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
		PIEPayNRIBean b = (PIEPayNRIBean) eb;
		com.hps.july.persistence.PIEPayNRIKey _primaryKey = new com.hps.july.persistence.PIEPayNRIKey();
		_primaryKey.id = b.id;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.id);
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
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[17]).shortValue());
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[19]);
			}
			if (cacheData[20] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[20]).intValue());
			}
			if (cacheData[21] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[21]);
			}
			if (cacheData[22] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[22]);
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
				pstmt.setInt(++inputPos, ((Number)cacheData[30]).intValue());
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
		com.hps.july.persistence.PIEPayNRIKey key = new com.hps.july.persistence.PIEPayNRIKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.id = resultSet.getInt(6);
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
	public com.hps.july.persistence.PIEPayNRI findByPrimaryKey(com.hps.july.persistence.PIEPayNRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEPayNRI) home.activateBean(key);
	}
	/**
	 * findPIEPayNRIsByQuery
	 */
	public EJSFinder findPIEPayNRIsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idexpence, T1.purposepay, T1.idpaytype, T1.idbudjet, T1.idaccountnri, T1.id, T1.numberanddatebdoc, T1.typebasedoc, T1.sumpay, T1.idusernri, T1.iddogovnri, T1.datebuch, T1.definerate, T1.datecreate, T1.idpaymode, T1.percentavans, T1.datebeforepay, T1.valutepay, T1.isavans, T1.idtypeforbuch, T1.typedogovnri, T1.tip_rasxodov, T1.ndspay, T1.fl101, T1.fl104, T1.fl105, T1.fl106, T1.fl107, T1.fl108, T1.fl109, T1.fl110, T1.id_query FROM pie_paysnri  T1 WHERE T1.id_query = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idquery);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
