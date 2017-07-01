package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSwitchAddInfoBean_5fbc6808
 */
public class EJSJDBCPersisterCMPSwitchAddInfoBean_5fbc6808 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSwitchAddInfoBean {
	private static final String _createString = "INSERT INTO switchaddinfo (act_date, equipment, abon_act_bss, abon_qty_bss, koeff_kn, load_all_percent, load_event_percent, load_max_day, load_max_hour_all, load_max_hour_bss, load_max_hour_nss, load_mobile, load_sms_percent, load_transit, traf_all, traf_bss_all, traf_bss_bss, traf_nss_all, traf_nss_nss, tryqty_mobile_all, tryqty_sms_all, tryqty_transit_all) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM switchaddinfo  WHERE act_date = ? AND equipment = ?";
	private static final String _storeString = "UPDATE switchaddinfo  SET abon_act_bss = ?, abon_qty_bss = ?, koeff_kn = ?, load_all_percent = ?, load_event_percent = ?, load_max_day = ?, load_max_hour_all = ?, load_max_hour_bss = ?, load_max_hour_nss = ?, load_mobile = ?, load_sms_percent = ?, load_transit = ?, traf_all = ?, traf_bss_all = ?, traf_bss_bss = ?, traf_nss_all = ?, traf_nss_nss = ?, tryqty_mobile_all = ?, tryqty_sms_all = ?, tryqty_transit_all = ? WHERE act_date = ? AND equipment = ?";
	private static final String _loadString = "SELECT T1.act_date, T1.abon_act_bss, T1.abon_qty_bss, T1.koeff_kn, T1.load_all_percent, T1.load_event_percent, T1.load_max_day, T1.load_max_hour_all, T1.load_max_hour_bss, T1.load_max_hour_nss, T1.load_mobile, T1.load_sms_percent, T1.load_transit, T1.traf_all, T1.traf_bss_all, T1.traf_bss_bss, T1.traf_nss_all, T1.traf_nss_nss, T1.tryqty_mobile_all, T1.tryqty_sms_all, T1.tryqty_transit_all, T1.equipment FROM switchaddinfo  T1 WHERE T1.act_date = ? AND T1.equipment = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"abon_act_bss", "abon_qty_bss", "koeff_kn", "load_all_percent", "load_event_percent", "load_max_day", "load_max_hour_all", "load_max_hour_bss", "load_max_hour_nss", "load_mobile", "load_sms_percent", "load_transit", "traf_all", "traf_bss_all", "traf_bss_bss", "traf_nss_all", "traf_nss_nss", "tryqty_mobile_all", "tryqty_sms_all", "tryqty_transit_all"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSwitchAddInfoBean_5fbc6808
	 */
	public EJSJDBCPersisterCMPSwitchAddInfoBean_5fbc6808() throws java.rmi.RemoteException {
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
		SwitchAddInfoBean b = (SwitchAddInfoBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[20];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.act_date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.act_date);
			}
			if (b.abon_act_bss == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.abon_act_bss);
			}
			cacheData[0] = b.abon_act_bss;
			if (b.abon_qty_bss == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.abon_qty_bss.intValue());
			}
			cacheData[1] = b.abon_qty_bss;
			if (b.koeff_kn == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.koeff_kn);
			}
			cacheData[2] = b.koeff_kn;
			if (b.load_all_percent == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.load_all_percent);
			}
			cacheData[3] = b.load_all_percent;
			if (b.load_event_percent == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.load_event_percent);
			}
			cacheData[4] = b.load_event_percent;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_day);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour_all);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[6] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour_bss);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour_nss);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[8] = objectTemp;
			if (b.load_mobile == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.load_mobile.intValue());
			}
			cacheData[9] = b.load_mobile;
			if (b.load_sms_percent == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.load_sms_percent);
			}
			cacheData[10] = b.load_sms_percent;
			if (b.load_transit == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.load_transit.intValue());
			}
			cacheData[11] = b.load_transit;
			if (b.traf_all == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.traf_all.intValue());
			}
			cacheData[12] = b.traf_all;
			if (b.traf_bss_all == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.traf_bss_all.intValue());
			}
			cacheData[13] = b.traf_bss_all;
			if (b.traf_bss_bss == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.traf_bss_bss.intValue());
			}
			cacheData[14] = b.traf_bss_bss;
			if (b.traf_nss_all == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.traf_nss_all.intValue());
			}
			cacheData[15] = b.traf_nss_all;
			if (b.traf_nss_nss == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.traf_nss_nss.intValue());
			}
			cacheData[16] = b.traf_nss_nss;
			if (b.tryqty_mobile_all == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.tryqty_mobile_all.intValue());
			}
			cacheData[17] = b.tryqty_mobile_all;
			if (b.tryqty_sms_all == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.tryqty_sms_all.intValue());
			}
			cacheData[18] = b.tryqty_sms_all;
			if (b.tryqty_transit_all == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.tryqty_transit_all.intValue());
			}
			cacheData[19] = b.tryqty_transit_all;
			if (b.switch_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.switch_storageplace.intValue());
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
		SwitchAddInfoBean b = (SwitchAddInfoBean) eb;
		com.hps.july.persistence.SwitchAddInfoKey _primaryKey = (com.hps.july.persistence.SwitchAddInfoKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.act_date = _primaryKey.act_date;
		b.switch_storageplace = _primaryKey.switch_storageplace;
		b.abon_act_bss = resultSet.getBigDecimal(2);
		tempint = resultSet.getInt(3);
		b.abon_qty_bss = resultSet.wasNull() ? null : new Integer(tempint);
		b.koeff_kn = resultSet.getBigDecimal(4);
		b.load_all_percent = resultSet.getBigDecimal(5);
		b.load_event_percent = resultSet.getBigDecimal(6);
		b.load_max_day = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.load_max_hour_all = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.load_max_hour_bss = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.load_max_hour_nss = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		tempint = resultSet.getInt(11);
		b.load_mobile = resultSet.wasNull() ? null : new Integer(tempint);
		b.load_sms_percent = resultSet.getBigDecimal(12);
		tempint = resultSet.getInt(13);
		b.load_transit = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(14);
		b.traf_all = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.traf_bss_all = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		b.traf_bss_bss = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(17);
		b.traf_nss_all = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		b.traf_nss_nss = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(19);
		b.tryqty_mobile_all = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(20);
		b.tryqty_sms_all = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		b.tryqty_transit_all = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		b.switch_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[20];
		cacheData[0] = resultSet.getBigDecimal(2);
		tempint = resultSet.getInt(3);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[2] = resultSet.getBigDecimal(4);
		cacheData[3] = resultSet.getBigDecimal(5);
		cacheData[4] = resultSet.getBigDecimal(6);
		cacheData[5] = resultSet.getString(7);
		cacheData[6] = resultSet.getString(8);
		cacheData[7] = resultSet.getString(9);
		cacheData[8] = resultSet.getString(10);
		tempint = resultSet.getInt(11);
		cacheData[9] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[10] = resultSet.getBigDecimal(12);
		tempint = resultSet.getInt(13);
		cacheData[11] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(14);
		cacheData[12] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		cacheData[13] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		cacheData[14] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(17);
		cacheData[15] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		cacheData[16] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(19);
		cacheData[17] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(20);
		cacheData[18] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		cacheData[19] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SwitchAddInfoBean b = (SwitchAddInfoBean) eb;
		com.hps.july.persistence.SwitchAddInfoKey _primaryKey = (com.hps.july.persistence.SwitchAddInfoKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.act_date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.act_date);
			}
			if (_primaryKey.switch_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.switch_storageplace.intValue());
			}
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
		SwitchAddInfoBean b = (SwitchAddInfoBean) eb;
		com.hps.july.persistence.SwitchAddInfoKey _primaryKey = new com.hps.july.persistence.SwitchAddInfoKey();
		_primaryKey.act_date = b.act_date;
		_primaryKey.switch_storageplace = b.switch_storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SwitchAddInfoBean b = (SwitchAddInfoBean) eb;
		com.hps.july.persistence.SwitchAddInfoKey _primaryKey = new com.hps.july.persistence.SwitchAddInfoKey();
		_primaryKey.act_date = b.act_date;
		_primaryKey.switch_storageplace = b.switch_storageplace;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.act_date == null) {
				pstmt.setNull(21, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(21, _primaryKey.act_date);
			}
			if (_primaryKey.switch_storageplace == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, _primaryKey.switch_storageplace.intValue());
			}
			if (b.abon_act_bss == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.abon_act_bss);
			}
			if (b.abon_qty_bss == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.abon_qty_bss.intValue());
			}
			if (b.koeff_kn == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.koeff_kn);
			}
			if (b.load_all_percent == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.load_all_percent);
			}
			if (b.load_event_percent == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.load_event_percent);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_day);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour_all);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour_bss);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour_nss);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.load_mobile == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.load_mobile.intValue());
			}
			if (b.load_sms_percent == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.load_sms_percent);
			}
			if (b.load_transit == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.load_transit.intValue());
			}
			if (b.traf_all == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.traf_all.intValue());
			}
			if (b.traf_bss_all == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.traf_bss_all.intValue());
			}
			if (b.traf_bss_bss == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.traf_bss_bss.intValue());
			}
			if (b.traf_nss_all == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.traf_nss_all.intValue());
			}
			if (b.traf_nss_nss == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.traf_nss_nss.intValue());
			}
			if (b.tryqty_mobile_all == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.tryqty_mobile_all.intValue());
			}
			if (b.tryqty_sms_all == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.tryqty_sms_all.intValue());
			}
			if (b.tryqty_transit_all == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.tryqty_transit_all.intValue());
			}
			if (b.switch_storageplace == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.switch_storageplace.intValue());
			}
			int inputPos = 22;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[17]).intValue());
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
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
		SwitchAddInfoBean b = (SwitchAddInfoBean) eb;
		com.hps.july.persistence.SwitchAddInfoKey _primaryKey = new com.hps.july.persistence.SwitchAddInfoKey();
		_primaryKey.act_date = b.act_date;
		_primaryKey.switch_storageplace = b.switch_storageplace;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.act_date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.act_date);
			}
			if (_primaryKey.switch_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.switch_storageplace.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[17]).intValue());
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
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
		com.hps.july.persistence.SwitchAddInfoKey key = new com.hps.july.persistence.SwitchAddInfoKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.act_date = resultSet.getDate(1);
			tempint = resultSet.getInt(22);
			key.switch_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
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
	public com.hps.july.persistence.SwitchAddInfo findByPrimaryKey(com.hps.july.persistence.SwitchAddInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.SwitchAddInfo) home.activateBean(key);
	}
	/**
	 * findSwitchAddInfosBySwitch
	 */
	public EJSFinder findSwitchAddInfosBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.act_date, T1.abon_act_bss, T1.abon_qty_bss, T1.koeff_kn, T1.load_all_percent, T1.load_event_percent, T1.load_max_day, T1.load_max_hour_all, T1.load_max_hour_bss, T1.load_max_hour_nss, T1.load_mobile, T1.load_sms_percent, T1.load_transit, T1.traf_all, T1.traf_bss_all, T1.traf_bss_bss, T1.traf_nss_all, T1.traf_nss_nss, T1.tryqty_mobile_all, T1.tryqty_sms_all, T1.tryqty_transit_all, T1.equipment FROM switchaddinfo  T1 WHERE T1.equipment = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storageplace);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByEquipmentOrderByActdateAsc
	 */
	public EJSFinder findByEquipmentOrderByActdateAsc(java.lang.Integer equipment) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.act_date, T1.abon_act_bss, T1.abon_qty_bss, T1.koeff_kn, T1.load_all_percent, T1.load_event_percent, T1.load_max_day, T1.load_max_hour_all, T1.load_max_hour_bss, T1.load_max_hour_nss, T1.load_mobile, T1.load_sms_percent, T1.load_transit, T1.traf_all, T1.traf_bss_all, T1.traf_bss_bss, T1.traf_nss_all, T1.traf_nss_nss, T1.tryqty_mobile_all, T1.tryqty_sms_all, T1.tryqty_transit_all, T1.equipment FROM switchaddinfo  T1 WHERE equipment = ? ORDER BY act_date ASC");
			pstmt.setObject(1, equipment);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
