package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgSectorBean_30c46d37
 */
public class EJSJDBCPersisterCMPCfgSectorBean_30c46d37 extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgSectorBean {
	private static final String _createString = "INSERT INTO informix.cfgsectors (SAVCONFIGID, ID_SECT, EQUIPMENT, NAME_SECT, BAND, NUM_SECT, AZIMUT, power, BTS_NUMBER, CON_ABIS, PORT_ABIS, NUM_PO, DDK, TRX_NUM, TX_PWR, TRX_NUM2, TX_PWR2, TX_SET_PWR, TRX_OVR_NUM, TX_OVR_SET_PWR, HAS_FLT, HAS_LNA, HAS_BUSTER, CONF, IS_HR, CAP_GPRS, OPERATOR, BYHAND, LAC, RAC, CELLNAME, NCC, BCC, STANDID, CELLINFO, DATASOURCE, OBJECTSTATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfgsectors  WHERE SAVCONFIGID = ? AND ID_SECT = ?";
	private static final String _storeString = "UPDATE informix.cfgsectors  SET EQUIPMENT = ?, NAME_SECT = ?, BAND = ?, NUM_SECT = ?, AZIMUT = ?, power = ?, BTS_NUMBER = ?, CON_ABIS = ?, PORT_ABIS = ?, NUM_PO = ?, DDK = ?, TRX_NUM = ?, TX_PWR = ?, TRX_NUM2 = ?, TX_PWR2 = ?, TX_SET_PWR = ?, TRX_OVR_NUM = ?, TX_OVR_SET_PWR = ?, HAS_FLT = ?, HAS_LNA = ?, HAS_BUSTER = ?, CONF = ?, IS_HR = ?, CAP_GPRS = ?, OPERATOR = ?, BYHAND = ?, LAC = ?, RAC = ?, CELLNAME = ?, NCC = ?, BCC = ?, STANDID = ?, CELLINFO = ?, DATASOURCE = ?, OBJECTSTATUS = ? WHERE SAVCONFIGID = ? AND ID_SECT = ?";
	private static final String _loadString = "SELECT T1.SAVCONFIGID, T1.ID_SECT, T1.EQUIPMENT, T1.NAME_SECT, T1.BAND, T1.NUM_SECT, T1.AZIMUT, T1.power, T1.BTS_NUMBER, T1.CON_ABIS, T1.PORT_ABIS, T1.NUM_PO, T1.DDK, T1.TRX_NUM, T1.TX_PWR, T1.TRX_NUM2, T1.TX_PWR2, T1.TX_SET_PWR, T1.TRX_OVR_NUM, T1.TX_OVR_SET_PWR, T1.HAS_FLT, T1.HAS_LNA, T1.HAS_BUSTER, T1.CONF, T1.IS_HR, T1.CAP_GPRS, T1.OPERATOR, T1.BYHAND, T1.LAC, T1.RAC, T1.CELLNAME, T1.NCC, T1.BCC, T1.STANDID, T1.CELLINFO, T1.DATASOURCE, T1.OBJECTSTATUS FROM informix.cfgsectors  T1 WHERE T1.SAVCONFIGID = ? AND T1.ID_SECT = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"EQUIPMENT", "DATASOURCE"};
	private static final boolean[] _predicateMaps = {true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgSectorBean_30c46d37
	 */
	public EJSJDBCPersisterCMPCfgSectorBean_30c46d37() throws java.rmi.RemoteException {
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
		CfgSectorBean b = (CfgSectorBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[2];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.id_sect);
			pstmt.setInt(3, b.equipment);
			cacheData[0] = new Integer(b.equipment);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name_sect);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.band == null) {
				pstmt.setNull(5, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(5, b.band.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.num_sect);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.azimut == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.azimut);
			}
			if (b.power == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.power);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bts_number);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.con_abis);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.port_abis == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.port_abis.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.num_po);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ddk);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.trx_num == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.trx_num.intValue());
			}
			if (b.tx_pwr == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.tx_pwr);
			}
			if (b.trx_num2 == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.trx_num2.intValue());
			}
			if (b.tx_pwr2 == null) {
				pstmt.setNull(17, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(17, b.tx_pwr2);
			}
			if (b.tx_set_pwr == null) {
				pstmt.setNull(18, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(18, b.tx_set_pwr);
			}
			if (b.trx_ovr_num == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.trx_ovr_num.intValue());
			}
			if (b.tx_ovr_set_pwr == null) {
				pstmt.setNull(20, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(20, b.tx_ovr_set_pwr);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.has_flt);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.has_lna);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.has_buster);
			if (objectTemp == null) {
				pstmt.setNull(23, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(23, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.conf);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.is_hr);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.cap_gprs);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			if (b.operator == null) {
				pstmt.setNull(27, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(27, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			if (b.lac == null) {
				pstmt.setNull(29, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(29, b.lac.intValue());
			}
			if (b.rac == null) {
				pstmt.setNull(30, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(30, b.rac.intValue());
			}
			if (b.cellname == null) {
				pstmt.setNull(31, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(31, b.cellname.intValue());
			}
			if (b.ncc == null) {
				pstmt.setNull(32, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(32, b.ncc.shortValue());
			}
			if (b.bcc == null) {
				pstmt.setNull(33, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(33, b.bcc.shortValue());
			}
			if (b.standid == null) {
				pstmt.setNull(34, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(34, b.standid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.cellinfo);
			if (objectTemp == null) {
				pstmt.setNull(35, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(35, (java.lang.String)objectTemp);
			}
			pstmt.setInt(36, b.datasource);
			cacheData[1] = new Integer(b.datasource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(37, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(37, (java.lang.String)objectTemp);
			}
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
		CfgSectorBean b = (CfgSectorBean) eb;
		com.hps.july.config.beans.CfgSectorKey _primaryKey = (com.hps.july.config.beans.CfgSectorKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.savconfigid = _primaryKey.savconfigid;
		b.id_sect = _primaryKey.id_sect;
		b.equipment = resultSet.getInt(3);
		b.name_sect = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		tempshort = resultSet.getShort(5);
		b.band = resultSet.wasNull() ? null : new Short(tempshort);
		b.num_sect = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.azimut = resultSet.getBigDecimal(7);
		b.power = resultSet.getBigDecimal(8);
		b.bts_number = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.con_abis = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		tempint = resultSet.getInt(11);
		b.port_abis = resultSet.wasNull() ? null : new Integer(tempint);
		b.num_po = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.ddk = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(13));
		tempint = resultSet.getInt(14);
		b.trx_num = resultSet.wasNull() ? null : new Integer(tempint);
		b.tx_pwr = resultSet.getBigDecimal(15);
		tempint = resultSet.getInt(16);
		b.trx_num2 = resultSet.wasNull() ? null : new Integer(tempint);
		b.tx_pwr2 = resultSet.getBigDecimal(17);
		b.tx_set_pwr = resultSet.getBigDecimal(18);
		tempint = resultSet.getInt(19);
		b.trx_ovr_num = resultSet.wasNull() ? null : new Integer(tempint);
		b.tx_ovr_set_pwr = resultSet.getBigDecimal(20);
		b.has_flt = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(21));
		b.has_lna = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(22));
		b.has_buster = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(23));
		b.conf = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(24));
		b.is_hr = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(25));
		b.cap_gprs = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(26));
		tempint = resultSet.getInt(27);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		b.byhand = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(28));
		tempint = resultSet.getInt(29);
		b.lac = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(30);
		b.rac = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(31);
		b.cellname = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(32);
		b.ncc = resultSet.wasNull() ? null : new Short(tempshort);
		tempshort = resultSet.getShort(33);
		b.bcc = resultSet.wasNull() ? null : new Short(tempshort);
		tempint = resultSet.getInt(34);
		b.standid = resultSet.wasNull() ? null : new Integer(tempint);
		b.cellinfo = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(35));
		b.datasource = resultSet.getInt(36);
		b.ObjectStatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(37));
		Object[] cacheData = new Object[2];
		tempint = resultSet.getInt(3);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(36);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgSectorBean b = (CfgSectorBean) eb;
		com.hps.july.config.beans.CfgSectorKey _primaryKey = (com.hps.july.config.beans.CfgSectorKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.id_sect);
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
		CfgSectorBean b = (CfgSectorBean) eb;
		com.hps.july.config.beans.CfgSectorKey _primaryKey = new com.hps.july.config.beans.CfgSectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_sect = b.id_sect;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgSectorBean b = (CfgSectorBean) eb;
		com.hps.july.config.beans.CfgSectorKey _primaryKey = new com.hps.july.config.beans.CfgSectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_sect = b.id_sect;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(36, _primaryKey.savconfigid);
			pstmt.setInt(37, _primaryKey.id_sect);
			pstmt.setInt(1, b.equipment);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name_sect);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.band == null) {
				pstmt.setNull(3, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(3, b.band.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.num_sect);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.azimut == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.azimut);
			}
			if (b.power == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.power);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bts_number);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.con_abis);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.port_abis == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.port_abis.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.num_po);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ddk);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.trx_num == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.trx_num.intValue());
			}
			if (b.tx_pwr == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.tx_pwr);
			}
			if (b.trx_num2 == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.trx_num2.intValue());
			}
			if (b.tx_pwr2 == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.tx_pwr2);
			}
			if (b.tx_set_pwr == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.tx_set_pwr);
			}
			if (b.trx_ovr_num == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.trx_ovr_num.intValue());
			}
			if (b.tx_ovr_set_pwr == null) {
				pstmt.setNull(18, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(18, b.tx_ovr_set_pwr);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.has_flt);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.has_lna);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.has_buster);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.conf);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.is_hr);
			if (objectTemp == null) {
				pstmt.setNull(23, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(23, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.cap_gprs);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			if (b.operator == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			if (b.lac == null) {
				pstmt.setNull(27, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(27, b.lac.intValue());
			}
			if (b.rac == null) {
				pstmt.setNull(28, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(28, b.rac.intValue());
			}
			if (b.cellname == null) {
				pstmt.setNull(29, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(29, b.cellname.intValue());
			}
			if (b.ncc == null) {
				pstmt.setNull(30, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(30, b.ncc.shortValue());
			}
			if (b.bcc == null) {
				pstmt.setNull(31, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(31, b.bcc.shortValue());
			}
			if (b.standid == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.standid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.cellinfo);
			if (objectTemp == null) {
				pstmt.setNull(33, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(33, (java.lang.String)objectTemp);
			}
			pstmt.setInt(34, b.datasource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(35, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(35, (java.lang.String)objectTemp);
			}
			int inputPos = 37;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
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
		CfgSectorBean b = (CfgSectorBean) eb;
		com.hps.july.config.beans.CfgSectorKey _primaryKey = new com.hps.july.config.beans.CfgSectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_sect = b.id_sect;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.id_sect);
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
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
		com.hps.july.config.beans.CfgSectorKey key = new com.hps.july.config.beans.CfgSectorKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.id_sect = resultSet.getInt(2);
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
	public com.hps.july.config.beans.CfgSector findByPrimaryKey(com.hps.july.config.beans.CfgSectorKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgSector) home.activateBean(primaryKey);
	}
}
