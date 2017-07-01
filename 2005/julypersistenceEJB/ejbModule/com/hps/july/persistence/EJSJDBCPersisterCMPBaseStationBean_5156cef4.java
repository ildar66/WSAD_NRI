package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPBaseStationBean_5156cef4
 */
public class EJSJDBCPersisterCMPBaseStationBean_5156cef4 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderBaseStationBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO storageplaces (storageplace, closedate, address, operator, name, modified, created, modifiedby, createdby, division, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO equipment (equipment, state, date_bldbeg, pwr_val, pwr_res_cat, date_assemb, date_test, date_pr, pwr_cat, equipcomment, pwr_reserve, datasource, position) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO basestations (equipment, date_assemb_afs2, on_air, time_backup, n_stoek, date_assemb_afs, name, date_onair, date_test2, date_assemb2, net_stage, date_connect, date_pr2, date_onair2, con_type, st_transp, e1_qty, number, type, date_bldbeg2, date_connect2, repeater, prefixcellid, controller, switch) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM basestations  WHERE equipment = ?", "DELETE FROM equipment  WHERE equipment = ?", "DELETE FROM storageplaces  WHERE storageplace = ?"};
	private static final String[] _storeString = {"UPDATE basestations  SET date_assemb_afs2 = ?, on_air = ?, time_backup = ?, n_stoek = ?, date_assemb_afs = ?, name = ?, date_onair = ?, date_test2 = ?, date_assemb2 = ?, net_stage = ?, date_connect = ?, date_pr2 = ?, date_onair2 = ?, con_type = ?, st_transp = ?, e1_qty = ?, number = ?, type = ?, date_bldbeg2 = ?, date_connect2 = ?, repeater = ?, prefixcellid = ?, controller = ?, switch = ? WHERE equipment = ?", "UPDATE equipment  SET state = ?, date_bldbeg = ?, pwr_val = ?, pwr_res_cat = ?, date_assemb = ?, date_test = ?, date_pr = ?, pwr_cat = ?, equipcomment = ?, pwr_reserve = ?, datasource = ?, position = ? WHERE equipment = ?", "UPDATE storageplaces  SET closedate = ?, address = ?, operator = ?, name = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, division = ?, type = ? WHERE storageplace = ?"};
	private static final String _loadString = "SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch FROM storageplaces  T3, basestations  T1, equipment  T2 WHERE T3.type = \'B\' AND T3.storageplace = T2.equipment AND T2.equipment = T1.equipment AND T3.storageplace = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPBaseStationBean_5156cef4
	 */
	public EJSJDBCPersisterCMPBaseStationBean_5156cef4() throws java.rmi.RemoteException {
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
		BaseStationBean b = (BaseStationBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			if (b.closedate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.closedate);
			}
			if (b.address == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.address);
			}
			if (b.operator == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.storageplace);
			if (b.modified == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(7, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(7, b.created);
			}
			if (b.modifiedby == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.modifiedby.intValue());
			}
			if (b.createdby == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.createdby.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.division_division.intValue());
			}
			pstmt.setString(11, "B");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equipmentState);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.datebldbeg == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.datebldbeg);
			}
			if (b.pwrval == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.pwrval);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwrrescat);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.dateassemb == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.dateassemb);
			}
			if (b.datetest == null) {
				pstmt.setNull(7, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(7, b.datetest);
			}
			if (b.datepr == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.datepr);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwrcat);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.equipcomment == null) {
				pstmt.setNull(10, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(10, b.equipcomment);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.pwrreserve);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			pstmt.setInt(12, b.datasource);
			if (b.position_storageplace == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.position_storageplace.intValue());
			}
			pstmt.setInt(1, b.storageplace);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[2]);
		try {
			if (b.dateassembafs2 == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.dateassembafs2);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.onair);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.timebackup);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.nstoek == null) {
				pstmt.setNull(5, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(5, b.nstoek.shortValue());
			}
			if (b.dateassembafs == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.dateassembafs);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.stationName);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.dateonair == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.dateonair);
			}
			if (b.datetest2 == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.datetest2);
			}
			if (b.dateassemb2 == null) {
				pstmt.setNull(10, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(10, b.dateassemb2);
			}
			if (b.netstage == null) {
				pstmt.setNull(11, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(11, b.netstage.shortValue());
			}
			if (b.dateconnect == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.dateconnect);
			}
			if (b.datepr2 == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.datepr2);
			}
			if (b.dateonair2 == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.dateonair2);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contype);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sttransp);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.e1qty == null) {
				pstmt.setNull(17, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(17, b.e1qty.shortValue());
			}
			pstmt.setInt(18, b.number);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.stationType);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			if (b.datebldbeg2 == null) {
				pstmt.setNull(20, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(20, b.datebldbeg2);
			}
			if (b.dateconnect2 == null) {
				pstmt.setNull(21, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(21, b.dateconnect2);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.repeater);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			if (b.prefixcellid == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.prefixcellid.intValue());
			}
			if (b.controller_storageplace == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.controller_storageplace.intValue());
			}
			if (b.switch_storageplace == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.switch_storageplace.intValue());
			}
			pstmt.setInt(1, b.storageplace);
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
		BaseStationBean b = (BaseStationBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.storageplace = _primaryKey.storageplace;
		b.dateassembafs2 = resultSet.getDate(24);
		b.onair = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(25));
		b.timebackup = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		tempshort = resultSet.getShort(27);
		b.nstoek = resultSet.wasNull() ? null : new Short(tempshort);
		b.dateassembafs = resultSet.getDate(28);
		b.stationName = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.dateonair = resultSet.getDate(30);
		b.datetest2 = resultSet.getDate(31);
		b.dateassemb2 = resultSet.getDate(32);
		tempshort = resultSet.getShort(33);
		b.netstage = resultSet.wasNull() ? null : new Short(tempshort);
		b.dateconnect = resultSet.getDate(34);
		b.datepr2 = resultSet.getDate(35);
		b.dateonair2 = resultSet.getDate(36);
		b.contype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(37));
		b.sttransp = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(38));
		tempshort = resultSet.getShort(39);
		b.e1qty = resultSet.wasNull() ? null : new Short(tempshort);
		b.number = resultSet.getInt(40);
		b.stationType = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(41));
		b.datebldbeg2 = resultSet.getDate(42);
		b.dateconnect2 = resultSet.getDate(43);
		b.repeater = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(44));
		tempint = resultSet.getInt(45);
		b.prefixcellid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(46);
		b.controller_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(47);
		b.switch_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		b.equipmentState = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.datebldbeg = resultSet.getDate(13);
		b.pwrval = resultSet.getBigDecimal(14);
		b.pwrrescat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(15));
		b.dateassemb = resultSet.getDate(16);
		b.datetest = resultSet.getDate(17);
		b.datepr = resultSet.getDate(18);
		b.pwrcat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(19));
		b.equipcomment = resultSet.getString(20);
		b.pwrreserve = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(21));
		b.datasource = resultSet.getInt(22);
		tempint = resultSet.getInt(23);
		b.position_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		b.closedate = resultSet.getDate(1);
		b.address = resultSet.getString(2);
		tempint = resultSet.getInt(3);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.modified = resultSet.getTimestamp(6);
		b.created = resultSet.getTimestamp(7);
		tempint = resultSet.getInt(8);
		b.modifiedby = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.createdby = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.division_division = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		BaseStationBean b = (BaseStationBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.storageplace);
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
		BaseStationBean b = (BaseStationBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		BaseStationBean b = (BaseStationBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(25, _primaryKey.storageplace);
			if (b.dateassembafs2 == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.dateassembafs2);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.onair);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.timebackup);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.nstoek == null) {
				pstmt.setNull(4, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(4, b.nstoek.shortValue());
			}
			if (b.dateassembafs == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.dateassembafs);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.stationName);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.dateonair == null) {
				pstmt.setNull(7, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(7, b.dateonair);
			}
			if (b.datetest2 == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.datetest2);
			}
			if (b.dateassemb2 == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.dateassemb2);
			}
			if (b.netstage == null) {
				pstmt.setNull(10, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(10, b.netstage.shortValue());
			}
			if (b.dateconnect == null) {
				pstmt.setNull(11, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(11, b.dateconnect);
			}
			if (b.datepr2 == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.datepr2);
			}
			if (b.dateonair2 == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.dateonair2);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contype);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sttransp);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.e1qty == null) {
				pstmt.setNull(16, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(16, b.e1qty.shortValue());
			}
			pstmt.setInt(17, b.number);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.stationType);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.datebldbeg2 == null) {
				pstmt.setNull(19, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(19, b.datebldbeg2);
			}
			if (b.dateconnect2 == null) {
				pstmt.setNull(20, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(20, b.dateconnect2);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.repeater);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			if (b.prefixcellid == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.prefixcellid.intValue());
			}
			if (b.controller_storageplace == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.controller_storageplace.intValue());
			}
			if (b.switch_storageplace == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.switch_storageplace.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(13, _primaryKey.storageplace);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equipmentState);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.datebldbeg == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.datebldbeg);
			}
			if (b.pwrval == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.pwrval);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwrrescat);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.dateassemb == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.dateassemb);
			}
			if (b.datetest == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.datetest);
			}
			if (b.datepr == null) {
				pstmt.setNull(7, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(7, b.datepr);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pwrcat);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.equipcomment == null) {
				pstmt.setNull(9, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(9, b.equipcomment);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.pwrreserve);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			pstmt.setInt(11, b.datasource);
			if (b.position_storageplace == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.position_storageplace.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[2]);
		try {
			pstmt.setInt(11, _primaryKey.storageplace);
			if (b.closedate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.closedate);
			}
			if (b.address == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.address);
			}
			if (b.operator == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.modified == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.created);
			}
			if (b.modifiedby == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.modifiedby.intValue());
			}
			if (b.createdby == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.createdby.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.division_division.intValue());
			}
			pstmt.setString(10, "B");
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
		BaseStationBean b = (BaseStationBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.storageplace);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.storageplace);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[2]);
		try {
			pstmt.setInt(1, _primaryKey.storageplace);
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
		com.hps.july.persistence.StoragePlaceKey key = new com.hps.july.persistence.StoragePlaceKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.storageplace = resultSet.getInt(5);
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
		java.lang.String discriminator = rs.getString(11).trim();
		if ( discriminator.equals("B") ) {
			bean = super.getBean(obj);
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
	 * findBaseStationBySwitch
	 */
	public EJSFinder findBaseStationBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch FROM storageplaces  T3, basestations  T1, equipment  T2 WHERE T3.type = \'B\' AND T3.storageplace = T2.equipment AND T2.equipment = T1.equipment AND T1.switch = ?");
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
	 * findBaseStationByController
	 */
	public EJSFinder findBaseStationByController(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch FROM storageplaces  T3, basestations  T1, equipment  T2 WHERE T3.type = \'B\' AND T3.storageplace = T2.equipment AND T2.equipment = T1.equipment AND T1.controller = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.BaseStation findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.BaseStation result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.BaseStation)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.storageplace);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.BaseStation)tmpFinder.nextElement();
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
	 * findByBSNumber
	 */
	public EJSFinder findByBSNumber(java.lang.Integer argBSNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch FROM storageplaces  T3, basestations  T1, equipment  T2 WHERE T3.type = \'B\' AND T3.storageplace = T2.equipment AND T2.equipment = T1.equipment AND number = ?");
			pstmt.setObject(1, argBSNumber);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAllOrderByNameAsc
	 */
	public EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findAllOrderByNameAsc();
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch FROM storageplaces  T3, basestations  T1, equipment  T2 WHERE T3.type = \'B\' AND T3.storageplace = T2.equipment AND T2.equipment = T1.equipment AND ";
	private static final int[] genericFindInsertPoints = {808};
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
	private BaseStationBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.BaseStationBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.BaseStationBeanFinderObject temp_finderObject = new com.hps.july.persistence.BaseStationBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
