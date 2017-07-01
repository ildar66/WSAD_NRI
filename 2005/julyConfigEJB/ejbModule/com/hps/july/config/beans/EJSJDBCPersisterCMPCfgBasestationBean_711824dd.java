package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgBasestationBean_711824dd
 */
public class EJSJDBCPersisterCMPCfgBasestationBean_711824dd extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgBasestationBean {
	private static final String _createString = "INSERT INTO informix.cfgbasestations (SAVCONFIGID, EQUIPMENT, CONTROLLER, type, repeater, number, name, n_stoek, st_transp, time_backup, date_assemb_afs, date_assemb_afs2, date_connect, date_connect2, date_onair, date_onair2, net_stage, con_type, e1_qty, on_air, date_bldbeg2, date_assemb2, date_test2, date_pr2, prefixcellid, softversion, stand_resource, isarendats, state900, state1800, h_obj_ant, antplaceid, numdcspermit, numgsmpermit, pwr_val, pwr_cat, pwr_reserve, pwr_res_cat, date_bldbeg, date_assemb, date_test, date_pr, equipcomment, logictypeid, manufid, objectstatus, apartmentid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfgbasestations  WHERE SAVCONFIGID = ? AND EQUIPMENT = ?";
	private static final String _storeString = "UPDATE informix.cfgbasestations  SET CONTROLLER = ?, type = ?, repeater = ?, number = ?, name = ?, n_stoek = ?, st_transp = ?, time_backup = ?, date_assemb_afs = ?, date_assemb_afs2 = ?, date_connect = ?, date_connect2 = ?, date_onair = ?, date_onair2 = ?, net_stage = ?, con_type = ?, e1_qty = ?, on_air = ?, date_bldbeg2 = ?, date_assemb2 = ?, date_test2 = ?, date_pr2 = ?, prefixcellid = ?, softversion = ?, stand_resource = ?, isarendats = ?, state900 = ?, state1800 = ?, h_obj_ant = ?, antplaceid = ?, numdcspermit = ?, numgsmpermit = ?, pwr_val = ?, pwr_cat = ?, pwr_reserve = ?, pwr_res_cat = ?, date_bldbeg = ?, date_assemb = ?, date_test = ?, date_pr = ?, equipcomment = ?, logictypeid = ?, manufid = ?, objectstatus = ?, apartmentid = ? WHERE SAVCONFIGID = ? AND EQUIPMENT = ?";
	private static final String _loadString = "SELECT T1.SAVCONFIGID, T1.EQUIPMENT, T1.CONTROLLER, T1.type, T1.repeater, T1.number, T1.name, T1.n_stoek, T1.st_transp, T1.time_backup, T1.date_assemb_afs, T1.date_assemb_afs2, T1.date_connect, T1.date_connect2, T1.date_onair, T1.date_onair2, T1.net_stage, T1.con_type, T1.e1_qty, T1.on_air, T1.date_bldbeg2, T1.date_assemb2, T1.date_test2, T1.date_pr2, T1.prefixcellid, T1.softversion, T1.stand_resource, T1.isarendats, T1.state900, T1.state1800, T1.h_obj_ant, T1.antplaceid, T1.numdcspermit, T1.numgsmpermit, T1.pwr_val, T1.pwr_cat, T1.pwr_reserve, T1.pwr_res_cat, T1.date_bldbeg, T1.date_assemb, T1.date_test, T1.date_pr, T1.equipcomment, T1.logictypeid, T1.manufid, T1.objectstatus, T1.apartmentid FROM informix.cfgbasestations  T1 WHERE T1.SAVCONFIGID = ? AND T1.EQUIPMENT = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"repeater", "number"};
	private static final boolean[] _predicateMaps = {true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgBasestationBean_711824dd
	 */
	public EJSJDBCPersisterCMPCfgBasestationBean_711824dd() throws java.rmi.RemoteException {
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
		CfgBasestationBean b = (CfgBasestationBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[2];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.equipment);
			if (b.controller == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.controller.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.repeater));
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			pstmt.setInt(6, b.number);
			cacheData[1] = new Integer(b.number);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.n_stoek == null) {
				pstmt.setNull(8, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(8, b.n_stoek.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.st_transp);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.time_backup);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.date_assemb_afs == null) {
				pstmt.setNull(11, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(11, b.date_assemb_afs);
			}
			if (b.date_assemb_afs2 == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.date_assemb_afs2);
			}
			if (b.date_connect == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.date_connect);
			}
			if (b.date_connect2 == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.date_connect2);
			}
			if (b.date_onair == null) {
				pstmt.setNull(15, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(15, b.date_onair);
			}
			if (b.date_onair2 == null) {
				pstmt.setNull(16, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(16, b.date_onair2);
			}
			if (b.net_stage == null) {
				pstmt.setNull(17, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(17, b.net_stage.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.con_type);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.e1_qty == null) {
				pstmt.setNull(19, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(19, b.e1_qty.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.on_air);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			if (b.date_bldbeg2 == null) {
				pstmt.setNull(21, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(21, b.date_bldbeg2);
			}
			if (b.date_assemb2 == null) {
				pstmt.setNull(22, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(22, b.date_assemb2);
			}
			if (b.date_test2 == null) {
				pstmt.setNull(23, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(23, b.date_test2);
			}
			if (b.date_pr2 == null) {
				pstmt.setNull(24, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(24, b.date_pr2);
			}
			if (b.prefixcellid == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.prefixcellid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.softversion);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			if (b.stand_resource == null) {
				pstmt.setNull(27, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(27, b.stand_resource.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isarendats);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state900);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state1800);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			if (b.h_obj_ant == null) {
				pstmt.setNull(31, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(31, b.h_obj_ant);
			}
			if (b.antplaceid == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.antplaceid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numdcspermit);
			if (objectTemp == null) {
				pstmt.setNull(33, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(33, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numgsmpermit);
			if (objectTemp == null) {
				pstmt.setNull(34, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(34, (java.lang.String)objectTemp);
			}
			if (b.pwr_val == null) {
				pstmt.setNull(35, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(35, b.pwr_val);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwr_cat);
			if (objectTemp == null) {
				pstmt.setNull(36, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(36, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwr_reserve);
			if (objectTemp == null) {
				pstmt.setNull(37, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(37, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwr_res_cat);
			if (objectTemp == null) {
				pstmt.setNull(38, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(38, (java.lang.String)objectTemp);
			}
			if (b.date_bldbeg == null) {
				pstmt.setNull(39, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(39, b.date_bldbeg);
			}
			if (b.date_assemb == null) {
				pstmt.setNull(40, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(40, b.date_assemb);
			}
			if (b.date_test == null) {
				pstmt.setNull(41, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(41, b.date_test);
			}
			if (b.date_pr == null) {
				pstmt.setNull(42, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(42, b.date_pr);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equipcomment);
			if (objectTemp == null) {
				pstmt.setNull(43, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(43, (java.lang.String)objectTemp);
			}
			if (b.logictypeid == null) {
				pstmt.setNull(44, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(44, b.logictypeid.intValue());
			}
			if (b.manufid == null) {
				pstmt.setNull(45, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(45, b.manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(46, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(46, (java.lang.String)objectTemp);
			}
			if (b.apartmentid == null) {
				pstmt.setNull(47, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(47, b.apartmentid.intValue());
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
		CfgBasestationBean b = (CfgBasestationBean) eb;
		com.hps.july.config.beans.CfgBasestationKey _primaryKey = (com.hps.july.config.beans.CfgBasestationKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.savconfigid = _primaryKey.savconfigid;
		b.equipment = _primaryKey.equipment;
		tempint = resultSet.getInt(3);
		b.controller = resultSet.wasNull() ? null : new Integer(tempint);
		b.type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(5));
		b.repeater = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.number = resultSet.getInt(6);
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		tempshort = resultSet.getShort(8);
		b.n_stoek = resultSet.wasNull() ? null : new Short(tempshort);
		b.st_transp = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.time_backup = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.date_assemb_afs = resultSet.getDate(11);
		b.date_assemb_afs2 = resultSet.getDate(12);
		b.date_connect = resultSet.getDate(13);
		b.date_connect2 = resultSet.getDate(14);
		b.date_onair = resultSet.getDate(15);
		b.date_onair2 = resultSet.getDate(16);
		tempshort = resultSet.getShort(17);
		b.net_stage = resultSet.wasNull() ? null : new Short(tempshort);
		b.con_type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		tempshort = resultSet.getShort(19);
		b.e1_qty = resultSet.wasNull() ? null : new Short(tempshort);
		b.on_air = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(20));
		b.date_bldbeg2 = resultSet.getDate(21);
		b.date_assemb2 = resultSet.getDate(22);
		b.date_test2 = resultSet.getDate(23);
		b.date_pr2 = resultSet.getDate(24);
		tempint = resultSet.getInt(25);
		b.prefixcellid = resultSet.wasNull() ? null : new Integer(tempint);
		b.softversion = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		tempint = resultSet.getInt(27);
		b.stand_resource = resultSet.wasNull() ? null : new Integer(tempint);
		b.isarendats = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(28));
		b.state900 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.state1800 = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(30));
		b.h_obj_ant = resultSet.getBigDecimal(31);
		tempint = resultSet.getInt(32);
		b.antplaceid = resultSet.wasNull() ? null : new Integer(tempint);
		b.numdcspermit = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(33));
		b.numgsmpermit = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(34));
		b.pwr_val = resultSet.getBigDecimal(35);
		b.pwr_cat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(36));
		b.pwr_reserve = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(37));
		b.pwr_res_cat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(38));
		b.date_bldbeg = resultSet.getDate(39);
		b.date_assemb = resultSet.getDate(40);
		b.date_test = resultSet.getDate(41);
		b.date_pr = resultSet.getDate(42);
		b.equipcomment = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(43));
		tempint = resultSet.getInt(44);
		b.logictypeid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(45);
		b.manufid = resultSet.wasNull() ? null : new Integer(tempint);
		b.ObjectStatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(46));
		tempint = resultSet.getInt(47);
		b.apartmentid = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[2];
		cacheData[0] = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgBasestationBean b = (CfgBasestationBean) eb;
		com.hps.july.config.beans.CfgBasestationKey _primaryKey = (com.hps.july.config.beans.CfgBasestationKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.equipment);
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
		CfgBasestationBean b = (CfgBasestationBean) eb;
		com.hps.july.config.beans.CfgBasestationKey _primaryKey = new com.hps.july.config.beans.CfgBasestationKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.equipment = b.equipment;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgBasestationBean b = (CfgBasestationBean) eb;
		com.hps.july.config.beans.CfgBasestationKey _primaryKey = new com.hps.july.config.beans.CfgBasestationKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.equipment = b.equipment;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(46, _primaryKey.savconfigid);
			pstmt.setInt(47, _primaryKey.equipment);
			if (b.controller == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.controller.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.repeater));
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setInt(4, b.number);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.n_stoek == null) {
				pstmt.setNull(6, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(6, b.n_stoek.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.st_transp);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.time_backup);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.date_assemb_afs == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.date_assemb_afs);
			}
			if (b.date_assemb_afs2 == null) {
				pstmt.setNull(10, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(10, b.date_assemb_afs2);
			}
			if (b.date_connect == null) {
				pstmt.setNull(11, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(11, b.date_connect);
			}
			if (b.date_connect2 == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.date_connect2);
			}
			if (b.date_onair == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.date_onair);
			}
			if (b.date_onair2 == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.date_onair2);
			}
			if (b.net_stage == null) {
				pstmt.setNull(15, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(15, b.net_stage.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.con_type);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.e1_qty == null) {
				pstmt.setNull(17, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(17, b.e1_qty.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.on_air);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.date_bldbeg2 == null) {
				pstmt.setNull(19, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(19, b.date_bldbeg2);
			}
			if (b.date_assemb2 == null) {
				pstmt.setNull(20, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(20, b.date_assemb2);
			}
			if (b.date_test2 == null) {
				pstmt.setNull(21, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(21, b.date_test2);
			}
			if (b.date_pr2 == null) {
				pstmt.setNull(22, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(22, b.date_pr2);
			}
			if (b.prefixcellid == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.prefixcellid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.softversion);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			if (b.stand_resource == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.stand_resource.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isarendats);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state900);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state1800);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			if (b.h_obj_ant == null) {
				pstmt.setNull(29, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(29, b.h_obj_ant);
			}
			if (b.antplaceid == null) {
				pstmt.setNull(30, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(30, b.antplaceid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numdcspermit);
			if (objectTemp == null) {
				pstmt.setNull(31, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(31, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numgsmpermit);
			if (objectTemp == null) {
				pstmt.setNull(32, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(32, (java.lang.String)objectTemp);
			}
			if (b.pwr_val == null) {
				pstmt.setNull(33, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(33, b.pwr_val);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwr_cat);
			if (objectTemp == null) {
				pstmt.setNull(34, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(34, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwr_reserve);
			if (objectTemp == null) {
				pstmt.setNull(35, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(35, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwr_res_cat);
			if (objectTemp == null) {
				pstmt.setNull(36, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(36, (java.lang.String)objectTemp);
			}
			if (b.date_bldbeg == null) {
				pstmt.setNull(37, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(37, b.date_bldbeg);
			}
			if (b.date_assemb == null) {
				pstmt.setNull(38, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(38, b.date_assemb);
			}
			if (b.date_test == null) {
				pstmt.setNull(39, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(39, b.date_test);
			}
			if (b.date_pr == null) {
				pstmt.setNull(40, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(40, b.date_pr);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equipcomment);
			if (objectTemp == null) {
				pstmt.setNull(41, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(41, (java.lang.String)objectTemp);
			}
			if (b.logictypeid == null) {
				pstmt.setNull(42, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(42, b.logictypeid.intValue());
			}
			if (b.manufid == null) {
				pstmt.setNull(43, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(43, b.manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(44, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(44, (java.lang.String)objectTemp);
			}
			if (b.apartmentid == null) {
				pstmt.setNull(45, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(45, b.apartmentid.intValue());
			}
			int inputPos = 47;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
		CfgBasestationBean b = (CfgBasestationBean) eb;
		com.hps.july.config.beans.CfgBasestationKey _primaryKey = new com.hps.july.config.beans.CfgBasestationKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.equipment = b.equipment;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.equipment);
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
		com.hps.july.config.beans.CfgBasestationKey key = new com.hps.july.config.beans.CfgBasestationKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.equipment = resultSet.getInt(2);
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
	public com.hps.july.config.beans.CfgBasestation findByPrimaryKey(com.hps.july.config.beans.CfgBasestationKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgBasestation) home.activateBean(primaryKey);
	}
}
