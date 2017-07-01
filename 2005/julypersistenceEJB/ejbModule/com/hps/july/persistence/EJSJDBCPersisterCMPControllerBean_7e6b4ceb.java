package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPControllerBean_7e6b4ceb
 */
public class EJSJDBCPersisterCMPControllerBean_7e6b4ceb extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderControllerBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO storageplaces (storageplace, closedate, address, operator, name, modified, created, modifiedby, createdby, division, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO equipment (equipment, state, date_bldbeg, pwr_val, pwr_res_cat, date_assemb, date_test, date_pr, pwr_cat, equipcomment, pwr_reserve, datasource, position) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO controllers (equipment, qty_shell, con_type, name, comment_ctrl, number, ver_po, mfs_num, omcr_num, lac_numbers, trxfr_qty_max, trxfr_qty, trx_use_percent, atr_qty_max, trxhr_qty, atr_qty, aint_qty, hway_qty_voice, hway_qty_gprs, switch, resource) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM controllers  WHERE equipment = ?", "DELETE FROM equipment  WHERE equipment = ?", "DELETE FROM storageplaces  WHERE storageplace = ?"};
	private static final String[] _storeString = {"UPDATE controllers  SET qty_shell = ?, con_type = ?, name = ?, comment_ctrl = ?, number = ?, ver_po = ?, mfs_num = ?, omcr_num = ?, lac_numbers = ?, trxfr_qty_max = ?, trxfr_qty = ?, trx_use_percent = ?, atr_qty_max = ?, trxhr_qty = ?, atr_qty = ?, aint_qty = ?, hway_qty_voice = ?, hway_qty_gprs = ?, switch = ?, resource = ? WHERE equipment = ?", "UPDATE equipment  SET state = ?, date_bldbeg = ?, pwr_val = ?, pwr_res_cat = ?, date_assemb = ?, date_test = ?, date_pr = ?, pwr_cat = ?, equipcomment = ?, pwr_reserve = ?, datasource = ?, position = ? WHERE equipment = ?", "UPDATE storageplaces  SET closedate = ?, address = ?, operator = ?, name = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, division = ?, type = ? WHERE storageplace = ?"};
	private static final String _loadString = "SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.qty_shell, T1.con_type, T1.name, T1.comment_ctrl, T1.number, T1.ver_po, T1.mfs_num, T1.omcr_num, T1.lac_numbers, T1.trxfr_qty_max, T1.trxfr_qty, T1.trx_use_percent, T1.atr_qty_max, T1.trxhr_qty, T1.atr_qty, T1.aint_qty, T1.hway_qty_voice, T1.hway_qty_gprs, T1.switch, T1.resource FROM storageplaces  T3, equipment  T2, controllers  T1 WHERE T3.type = \'O\' AND T2.equipment = T1.equipment AND T3.storageplace = T2.equipment AND T3.storageplace = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPControllerBean_7e6b4ceb
	 */
	public EJSJDBCPersisterCMPControllerBean_7e6b4ceb() throws java.rmi.RemoteException {
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
		ControllerBean b = (ControllerBean) eb;
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
			pstmt.setString(11, "O");
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
			if (b.qtyshell == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.qtyshell.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contype);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.controllerName);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.commentctrl == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.commentctrl);
			}
			pstmt.setInt(6, b.number);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.verpo);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.mfs_num == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.mfs_num.intValue());
			}
			if (b.omcr_num == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.omcr_num.intValue());
			}
			if (b.lac_numbers == null) {
				pstmt.setNull(10, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(10, b.lac_numbers);
			}
			if (b.trxfr_qty_max == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.trxfr_qty_max.intValue());
			}
			if (b.trxfr_qty == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.trxfr_qty.intValue());
			}
			if (b.trx_use_percent == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.trx_use_percent);
			}
			if (b.atr_qty_max == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.atr_qty_max.intValue());
			}
			if (b.trxhr_qty == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.trxhr_qty.intValue());
			}
			if (b.atr_qty == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.atr_qty.intValue());
			}
			if (b.aint_qty == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.aint_qty.intValue());
			}
			if (b.hway_qty_voice == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.hway_qty_voice.intValue());
			}
			if (b.hway_qty_grps == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.hway_qty_grps.intValue());
			}
			if (b.switch_storageplace == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.switch_storageplace.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.resource_resource.intValue());
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
		ControllerBean b = (ControllerBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.storageplace = _primaryKey.storageplace;
		tempint = resultSet.getInt(24);
		b.qtyshell = resultSet.wasNull() ? null : new Integer(tempint);
		b.contype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(25));
		b.controllerName = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		b.commentctrl = resultSet.getString(27);
		b.number = resultSet.getInt(28);
		b.verpo = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		tempint = resultSet.getInt(30);
		b.mfs_num = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(31);
		b.omcr_num = resultSet.wasNull() ? null : new Integer(tempint);
		b.lac_numbers = resultSet.getString(32);
		tempint = resultSet.getInt(33);
		b.trxfr_qty_max = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(34);
		b.trxfr_qty = resultSet.wasNull() ? null : new Integer(tempint);
		b.trx_use_percent = resultSet.getBigDecimal(35);
		tempint = resultSet.getInt(36);
		b.atr_qty_max = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(37);
		b.trxhr_qty = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(38);
		b.atr_qty = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(39);
		b.aint_qty = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(40);
		b.hway_qty_voice = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(41);
		b.hway_qty_grps = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(42);
		b.switch_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(43);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
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
		ControllerBean b = (ControllerBean) eb;
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
		ControllerBean b = (ControllerBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ControllerBean b = (ControllerBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(21, _primaryKey.storageplace);
			if (b.qtyshell == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.qtyshell.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contype);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.controllerName);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.commentctrl == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.commentctrl);
			}
			pstmt.setInt(5, b.number);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.verpo);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.mfs_num == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.mfs_num.intValue());
			}
			if (b.omcr_num == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.omcr_num.intValue());
			}
			if (b.lac_numbers == null) {
				pstmt.setNull(9, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(9, b.lac_numbers);
			}
			if (b.trxfr_qty_max == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.trxfr_qty_max.intValue());
			}
			if (b.trxfr_qty == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.trxfr_qty.intValue());
			}
			if (b.trx_use_percent == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.trx_use_percent);
			}
			if (b.atr_qty_max == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.atr_qty_max.intValue());
			}
			if (b.trxhr_qty == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.trxhr_qty.intValue());
			}
			if (b.atr_qty == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.atr_qty.intValue());
			}
			if (b.aint_qty == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.aint_qty.intValue());
			}
			if (b.hway_qty_voice == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.hway_qty_voice.intValue());
			}
			if (b.hway_qty_grps == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.hway_qty_grps.intValue());
			}
			if (b.switch_storageplace == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.switch_storageplace.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.resource_resource.intValue());
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
			pstmt.setString(10, "O");
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
		ControllerBean b = (ControllerBean) eb;
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
		if ( discriminator.equals("O") ) {
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
	 * findControllerBySwitch
	 */
	public EJSFinder findControllerBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.qty_shell, T1.con_type, T1.name, T1.comment_ctrl, T1.number, T1.ver_po, T1.mfs_num, T1.omcr_num, T1.lac_numbers, T1.trxfr_qty_max, T1.trxfr_qty, T1.trx_use_percent, T1.atr_qty_max, T1.trxhr_qty, T1.atr_qty, T1.aint_qty, T1.hway_qty_voice, T1.hway_qty_gprs, T1.switch, T1.resource FROM storageplaces  T3, equipment  T2, controllers  T1 WHERE T3.type = \'O\' AND T2.equipment = T1.equipment AND T3.storageplace = T2.equipment AND T1.switch = ?");
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
	 * findControllersByResource
	 */
	public EJSFinder findControllersByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.qty_shell, T1.con_type, T1.name, T1.comment_ctrl, T1.number, T1.ver_po, T1.mfs_num, T1.omcr_num, T1.lac_numbers, T1.trxfr_qty_max, T1.trxfr_qty, T1.trx_use_percent, T1.atr_qty_max, T1.trxhr_qty, T1.atr_qty, T1.aint_qty, T1.hway_qty_voice, T1.hway_qty_gprs, T1.switch, T1.resource FROM storageplaces  T3, equipment  T2, controllers  T1 WHERE T3.type = \'O\' AND T2.equipment = T1.equipment AND T3.storageplace = T2.equipment AND T1.resource = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Controller findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Controller result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.Controller)home.getBean(key);
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
					result = (com.hps.july.persistence.Controller)tmpFinder.nextElement();
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
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isNumber, java.lang.Integer argNumber, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSwitch, java.lang.Integer argSwitch, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isNumber, argNumber, isName, argName, isSwitch, argSwitch, order);
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
	private static final String genericFindSqlString = "SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T2.state, T2.date_bldbeg, T2.pwr_val, T2.pwr_res_cat, T2.date_assemb, T2.date_test, T2.date_pr, T2.pwr_cat, T2.equipcomment, T2.pwr_reserve, T2.datasource, T2.position, T1.qty_shell, T1.con_type, T1.name, T1.comment_ctrl, T1.number, T1.ver_po, T1.mfs_num, T1.omcr_num, T1.lac_numbers, T1.trxfr_qty_max, T1.trxfr_qty, T1.trx_use_percent, T1.atr_qty_max, T1.trxhr_qty, T1.atr_qty, T1.aint_qty, T1.hway_qty_voice, T1.hway_qty_gprs, T1.switch, T1.resource FROM storageplaces  T3, equipment  T2, controllers  T1 WHERE T3.type = \'O\' AND T2.equipment = T1.equipment AND T3.storageplace = T2.equipment AND ";
	private static final int[] genericFindInsertPoints = {746};
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
	private ControllerBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ControllerBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ControllerBeanFinderObject temp_finderObject = new com.hps.july.persistence.ControllerBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
