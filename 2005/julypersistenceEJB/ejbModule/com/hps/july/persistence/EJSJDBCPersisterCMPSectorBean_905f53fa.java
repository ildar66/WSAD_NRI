package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSectorBean_905f53fa
 */
public class EJSJDBCPersisterCMPSectorBean_905f53fa extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSectorBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO sectors (id_sect, tx_pwr2, name_sect, byhand, band, num_po, rac, cellname, trx_ovr_num, is_hr, con_abis, tx_pwr, operator, lac, bts_number, tx_ovr_set_pwr, trx_num, has_lna, trx_num2, tx_set_pwr, ddk, num_sect, cap_gprs, conf, power, has_flt, has_buster, port_abis, azimut, datasource, planfacttype, equipment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM sectors  WHERE id_sect = ?";
	private static final String _storeString = "UPDATE sectors  SET tx_pwr2 = ?, name_sect = ?, byhand = ?, band = ?, num_po = ?, rac = ?, cellname = ?, trx_ovr_num = ?, is_hr = ?, con_abis = ?, tx_pwr = ?, operator = ?, lac = ?, bts_number = ?, tx_ovr_set_pwr = ?, trx_num = ?, has_lna = ?, trx_num2 = ?, tx_set_pwr = ?, ddk = ?, num_sect = ?, cap_gprs = ?, conf = ?, power = ?, has_flt = ?, has_buster = ?, port_abis = ?, azimut = ?, datasource = ?, planfacttype = ?, equipment = ? WHERE id_sect = ?";
	private static final String _loadString = "SELECT T1.tx_pwr2, T1.name_sect, T1.byhand, T1.band, T1.num_po, T1.rac, T1.cellname, T1.trx_ovr_num, T1.is_hr, T1.con_abis, T1.tx_pwr, T1.operator, T1.lac, T1.bts_number, T1.tx_ovr_set_pwr, T1.trx_num, T1.has_lna, T1.trx_num2, T1.tx_set_pwr, T1.ddk, T1.num_sect, T1.cap_gprs, T1.conf, T1.power, T1.has_flt, T1.has_buster, T1.id_sect, T1.port_abis, T1.azimut, T1.datasource, T1.planfacttype, T1.equipment FROM sectors  T1 WHERE T1.id_sect = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSectorBean_905f53fa
	 */
	public EJSJDBCPersisterCMPSectorBean_905f53fa() throws java.rmi.RemoteException {
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
		SectorBean b = (SectorBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.txpwr2 == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.txpwr2);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.namesect);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			pstmt.setShort(5, b.band);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numpo);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.rac == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.rac.intValue());
			}
			if (b.cellname == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.cellname.intValue());
			}
			if (b.trxovrnum == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.trxovrnum.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ishr);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.conabis);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.txpwr == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.txpwr);
			}
			if (b.operator == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.operator.intValue());
			}
			if (b.lac == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.lac.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.btsnumber);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.txovrsetpwr == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.txovrsetpwr);
			}
			if (b.trxnum == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.trxnum.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.haslna);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.trxnum2 == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.trxnum2.intValue());
			}
			if (b.txsetpwr == null) {
				pstmt.setNull(20, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(20, b.txsetpwr);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ddk);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numsect);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.capgprs);
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
			if (b.power == null) {
				pstmt.setNull(25, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(25, b.power);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.hasflt);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.hasbuster);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.idsect);
			if (b.portabis == null) {
				pstmt.setNull(28, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(28, b.portabis.intValue());
			}
			if (b.azimut == null) {
				pstmt.setNull(29, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(29, b.azimut);
			}
			pstmt.setInt(30, b.datasource);
			pstmt.setInt(31, b.planfacttype);
			if (b.equipment_storageplace == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.equipment_storageplace.intValue());
			}
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
		SectorBean b = (SectorBean) eb;
		com.hps.july.persistence.SectorKey _primaryKey = (com.hps.july.persistence.SectorKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idsect = _primaryKey.idsect;
		b.txpwr2 = resultSet.getBigDecimal(1);
		b.namesect = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.byhand = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(3));
		b.band = resultSet.getShort(4);
		b.numpo = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		tempint = resultSet.getInt(6);
		b.rac = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.cellname = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.trxovrnum = resultSet.wasNull() ? null : new Integer(tempint);
		b.ishr = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(9));
		b.conabis = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.txpwr = resultSet.getBigDecimal(11);
		tempint = resultSet.getInt(12);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		b.lac = resultSet.wasNull() ? null : new Integer(tempint);
		b.btsnumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		b.txovrsetpwr = resultSet.getBigDecimal(15);
		tempint = resultSet.getInt(16);
		b.trxnum = resultSet.wasNull() ? null : new Integer(tempint);
		b.haslna = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(17));
		tempint = resultSet.getInt(18);
		b.trxnum2 = resultSet.wasNull() ? null : new Integer(tempint);
		b.txsetpwr = resultSet.getBigDecimal(19);
		b.ddk = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(20));
		b.numsect = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(21));
		b.capgprs = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(22));
		b.conf = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(23));
		b.power = resultSet.getBigDecimal(24);
		b.hasflt = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(25));
		b.hasbuster = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(26));
		tempint = resultSet.getInt(28);
		b.portabis = resultSet.wasNull() ? null : new Integer(tempint);
		b.azimut = resultSet.getBigDecimal(29);
		b.datasource = resultSet.getInt(30);
		b.planfacttype = resultSet.getInt(31);
		tempint = resultSet.getInt(32);
		b.equipment_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SectorBean b = (SectorBean) eb;
		com.hps.july.persistence.SectorKey _primaryKey = (com.hps.july.persistence.SectorKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idsect);
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
		SectorBean b = (SectorBean) eb;
		com.hps.july.persistence.SectorKey _primaryKey = new com.hps.july.persistence.SectorKey();
		_primaryKey.idsect = b.idsect;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SectorBean b = (SectorBean) eb;
		com.hps.july.persistence.SectorKey _primaryKey = new com.hps.july.persistence.SectorKey();
		_primaryKey.idsect = b.idsect;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(32, _primaryKey.idsect);
			if (b.txpwr2 == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.txpwr2);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.namesect);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setShort(4, b.band);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numpo);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.rac == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.rac.intValue());
			}
			if (b.cellname == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.cellname.intValue());
			}
			if (b.trxovrnum == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.trxovrnum.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ishr);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.conabis);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.txpwr == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.txpwr);
			}
			if (b.operator == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.operator.intValue());
			}
			if (b.lac == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.lac.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.btsnumber);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.txovrsetpwr == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.txovrsetpwr);
			}
			if (b.trxnum == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.trxnum.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.haslna);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			if (b.trxnum2 == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.trxnum2.intValue());
			}
			if (b.txsetpwr == null) {
				pstmt.setNull(19, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(19, b.txsetpwr);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ddk);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numsect);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.capgprs);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.conf);
			if (objectTemp == null) {
				pstmt.setNull(23, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(23, (java.lang.String)objectTemp);
			}
			if (b.power == null) {
				pstmt.setNull(24, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(24, b.power);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.hasflt);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.hasbuster);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			if (b.portabis == null) {
				pstmt.setNull(27, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(27, b.portabis.intValue());
			}
			if (b.azimut == null) {
				pstmt.setNull(28, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(28, b.azimut);
			}
			pstmt.setInt(29, b.datasource);
			pstmt.setInt(30, b.planfacttype);
			if (b.equipment_storageplace == null) {
				pstmt.setNull(31, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(31, b.equipment_storageplace.intValue());
			}
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
		SectorBean b = (SectorBean) eb;
		com.hps.july.persistence.SectorKey _primaryKey = new com.hps.july.persistence.SectorKey();
		_primaryKey.idsect = b.idsect;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.idsect);
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
		com.hps.july.persistence.SectorKey key = new com.hps.july.persistence.SectorKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idsect = resultSet.getInt(27);
			return key;
		}
return null;
	}
	/**
	 * findByBasestationOrderByNumberAsc
	 */
	public EJSFinder findByBasestationOrderByNumberAsc(java.lang.Integer argEquipment) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.tx_pwr2, T1.name_sect, T1.byhand, T1.band, T1.num_po, T1.rac, T1.cellname, T1.trx_ovr_num, T1.is_hr, T1.con_abis, T1.tx_pwr, T1.operator, T1.lac, T1.bts_number, T1.tx_ovr_set_pwr, T1.trx_num, T1.has_lna, T1.trx_num2, T1.tx_set_pwr, T1.ddk, T1.num_sect, T1.cap_gprs, T1.conf, T1.power, T1.has_flt, T1.has_buster, T1.id_sect, T1.port_abis, T1.azimut, T1.datasource, T1.planfacttype, T1.equipment FROM sectors  T1 WHERE planfacttype=1 AND equipment = ? ORDER BY num_sect ASC");
			pstmt.setObject(1, argEquipment);
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
	public EJSFinder findByQBE(java.lang.Integer argBSNum, java.lang.String bsType, java.lang.Boolean isPlanstate, java.lang.String argPlanstate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(argBSNum, bsType, isPlanstate, argPlanstate, isState, argState, order);
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
	public com.hps.july.persistence.Sector findByPrimaryKey(com.hps.july.persistence.SectorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Sector) home.activateBean(key);
	}
	/**
	 * findSectorsByEquipment
	 */
	public EJSFinder findSectorsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.tx_pwr2, T1.name_sect, T1.byhand, T1.band, T1.num_po, T1.rac, T1.cellname, T1.trx_ovr_num, T1.is_hr, T1.con_abis, T1.tx_pwr, T1.operator, T1.lac, T1.bts_number, T1.tx_ovr_set_pwr, T1.trx_num, T1.has_lna, T1.trx_num2, T1.tx_set_pwr, T1.ddk, T1.num_sect, T1.cap_gprs, T1.conf, T1.power, T1.has_flt, T1.has_buster, T1.id_sect, T1.port_abis, T1.azimut, T1.datasource, T1.planfacttype, T1.equipment FROM sectors  T1 WHERE T1.equipment = ?");
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
	private static final String genericFindSqlString = "SELECT T1.tx_pwr2, T1.name_sect, T1.byhand, T1.band, T1.num_po, T1.rac, T1.cellname, T1.trx_ovr_num, T1.is_hr, T1.con_abis, T1.tx_pwr, T1.operator, T1.lac, T1.bts_number, T1.tx_ovr_set_pwr, T1.trx_num, T1.has_lna, T1.trx_num2, T1.tx_set_pwr, T1.ddk, T1.num_sect, T1.cap_gprs, T1.conf, T1.power, T1.has_flt, T1.has_buster, T1.id_sect, T1.port_abis, T1.azimut, T1.datasource, T1.planfacttype, T1.equipment FROM sectors  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {427};
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
	private SectorBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.SectorBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.SectorBeanFinderObject temp_finderObject = new com.hps.july.persistence.SectorBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
