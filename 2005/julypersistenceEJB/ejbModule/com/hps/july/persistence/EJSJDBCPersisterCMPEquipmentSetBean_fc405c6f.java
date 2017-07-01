package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPEquipmentSetBean_fc405c6f
 */
public class EJSJDBCPersisterCMPEquipmentSetBean_fc405c6f extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderEquipmentSetBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO storageplaces (storageplace, closedate, address, operator, name, modified, created, modifiedby, createdby, division, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO equipment (equipment, state, date_bldbeg, pwr_val, pwr_res_cat, date_assemb, date_test, date_pr, pwr_cat, equipcomment, pwr_reserve, datasource, position) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM equipment  WHERE equipment = ?", "DELETE FROM storageplaces  WHERE storageplace = ?"};
	private static final String[] _storeString = {"UPDATE equipment  SET state = ?, date_bldbeg = ?, pwr_val = ?, pwr_res_cat = ?, date_assemb = ?, date_test = ?, date_pr = ?, pwr_cat = ?, equipcomment = ?, pwr_reserve = ?, datasource = ?, position = ? WHERE equipment = ?", "UPDATE storageplaces  SET closedate = ?, address = ?, operator = ?, name = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, division = ?, type = ? WHERE storageplace = ?"};
	private static final String _loadString = "(((((((SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4 WHERE T7.storageplace = T4.equipment AND T7.type = \'E\' AND T7.storageplace = ?)  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, T3.qty_shell, T3.con_type, T3.name, T3.comment_ctrl, T3.number, T3.ver_po, T3.mfs_num, T3.omcr_num, T3.lac_numbers, T3.trxfr_qty_max, T3.trxfr_qty, T3.trx_use_percent, T3.atr_qty_max, T3.trxhr_qty, T3.atr_qty, T3.aint_qty, T3.hway_qty_voice, T3.hway_qty_gprs, T3.switch, T3.resource, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4, controllers  T3 WHERE T4.equipment = T3.equipment AND T7.storageplace = T4.equipment AND T7.type = \'O\' AND T7.storageplace = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T2.type, T2.osinvname, T2.resource, CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4, comequipment  T2 WHERE T4.equipment = T2.equipment AND T7.storageplace = T4.equipment AND T7.type = \'C\' AND T7.storageplace = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, basestations  T1, equipment  T4 WHERE T7.storageplace = T4.equipment AND T4.equipment = T1.equipment AND T7.type = \'B\' AND T7.storageplace = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T6.reppower, T6.repiter_class, T6.number, T6.numchanals, T6.bandwidth, T6.donor_type, T6.date_assemb_afs, T6.date_connect, T6.date_onair, T6.donor_sect, T6.donor_ant, T6.resource, CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, repiters  T6, equipment  T4 WHERE T4.equipment = T6.equipment AND T7.storageplace = T4.equipment AND T7.type = \'R\' AND T7.storageplace = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T5.type, CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, otherequipment  T5, equipment  T4 WHERE T4.equipment = T5.equipment AND T7.storageplace = T4.equipment AND T7.type = \'T\' AND T7.storageplace = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T9.number, CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, wlan  T9, equipment  T4 WHERE T4.equipment = T9.equipment AND T7.storageplace = T4.equipment AND T7.type = \'L\' AND T7.storageplace = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T8.qty_tkgroute_nss, T8.ss7_bss, T8.type, T8.e1_use_percent, T8.number, T8.e1_nss, T8.qty_shell, T8.e1_qty_total, T8.comment, T8.e1_hlr, T8.ss7_hlrin, T8.max_vlr, T8.ss7_nss, T8.e1_bss, T8.qty_conhlr, T8.mscid, T8.capacityused, T8.capacityplan, T8.resource FROM storageplaces  T7, equipment  T4, switches  T8 WHERE T4.equipment = T8.equipment AND T7.storageplace = T4.equipment AND T7.type = \'W\' AND T7.storageplace = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPEquipmentSetBean_fc405c6f
	 */
	public EJSJDBCPersisterCMPEquipmentSetBean_fc405c6f() throws java.rmi.RemoteException {
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
		EquipmentSetBean b = (EquipmentSetBean) eb;
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
			pstmt.setString(11, "E");
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
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		EquipmentSetBean b = (EquipmentSetBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.storageplace = _primaryKey.storageplace;
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
		EquipmentSetBean b = (EquipmentSetBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.storageplace);
			pstmt.setInt(2, _primaryKey.storageplace);
			pstmt.setInt(3, _primaryKey.storageplace);
			pstmt.setInt(4, _primaryKey.storageplace);
			pstmt.setInt(5, _primaryKey.storageplace);
			pstmt.setInt(6, _primaryKey.storageplace);
			pstmt.setInt(7, _primaryKey.storageplace);
			pstmt.setInt(8, _primaryKey.storageplace);
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
		EquipmentSetBean b = (EquipmentSetBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		EquipmentSetBean b = (EquipmentSetBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
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
		pstmt = getPreparedStatement(_storeString[1]);
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
			pstmt.setString(10, "E");
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
		EquipmentSetBean b = (EquipmentSetBean) eb;
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
		if ( discriminator.equals("E") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("B") ) {
				homeName = "BaseStation";
			}
			else
			if ( discriminator.equals("C") ) {
				homeName = "ComEquipment";
			}
			else
			if ( discriminator.equals("O") ) {
				homeName = "Controller";
			}
			else
			if ( discriminator.equals("T") ) {
				homeName = "OtherEquipment";
			}
			else
			if ( discriminator.equals("R") ) {
				homeName = "Repiter";
			}
			else
			if ( discriminator.equals("W") ) {
				homeName = "Switch";
			}
			else
			if ( discriminator.equals("L") ) {
				homeName = "WLAN";
			}
			if (homeName != null) {
				bean = ((com.ibm.ejs.container.EJSHome)home).getBean(homeName, getPrimaryKey(rs), rs);
			}
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
	 * findEquipmentSetByPosition
	 */
	public EJSFinder findEquipmentSetByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(((((((SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4 WHERE T7.storageplace = T4.equipment AND T7.type = \'E\' AND T4.position = ?)  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, T3.qty_shell, T3.con_type, T3.name, T3.comment_ctrl, T3.number, T3.ver_po, T3.mfs_num, T3.omcr_num, T3.lac_numbers, T3.trxfr_qty_max, T3.trxfr_qty, T3.trx_use_percent, T3.atr_qty_max, T3.trxhr_qty, T3.atr_qty, T3.aint_qty, T3.hway_qty_voice, T3.hway_qty_gprs, T3.switch, T3.resource, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4, controllers  T3 WHERE T4.equipment = T3.equipment AND T7.storageplace = T4.equipment AND T7.type = \'O\' AND T4.position = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T2.type, T2.osinvname, T2.resource, CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4, comequipment  T2 WHERE T4.equipment = T2.equipment AND T7.storageplace = T4.equipment AND T7.type = \'C\' AND T4.position = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, basestations  T1, equipment  T4 WHERE T7.storageplace = T4.equipment AND T4.equipment = T1.equipment AND T7.type = \'B\' AND T4.position = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T6.reppower, T6.repiter_class, T6.number, T6.numchanals, T6.bandwidth, T6.donor_type, T6.date_assemb_afs, T6.date_connect, T6.date_onair, T6.donor_sect, T6.donor_ant, T6.resource, CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, repiters  T6, equipment  T4 WHERE T4.equipment = T6.equipment AND T7.storageplace = T4.equipment AND T7.type = \'R\' AND T4.position = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T5.type, CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, otherequipment  T5, equipment  T4 WHERE T4.equipment = T5.equipment AND T7.storageplace = T4.equipment AND T7.type = \'T\' AND T4.position = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T9.number, CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, wlan  T9, equipment  T4 WHERE T4.equipment = T9.equipment AND T7.storageplace = T4.equipment AND T7.type = \'L\' AND T4.position = ?) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T8.qty_tkgroute_nss, T8.ss7_bss, T8.type, T8.e1_use_percent, T8.number, T8.e1_nss, T8.qty_shell, T8.e1_qty_total, T8.comment, T8.e1_hlr, T8.ss7_hlrin, T8.max_vlr, T8.ss7_nss, T8.e1_bss, T8.qty_conhlr, T8.mscid, T8.capacityused, T8.capacityplan, T8.resource FROM storageplaces  T7, equipment  T4, switches  T8 WHERE T4.equipment = T8.equipment AND T7.storageplace = T4.equipment AND T7.type = \'W\' AND T4.position = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storageplace);
			pstmt.setInt(2, inKey.storageplace);
			pstmt.setInt(3, inKey.storageplace);
			pstmt.setInt(4, inKey.storageplace);
			pstmt.setInt(5, inKey.storageplace);
			pstmt.setInt(6, inKey.storageplace);
			pstmt.setInt(7, inKey.storageplace);
			pstmt.setInt(8, inKey.storageplace);
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
	public com.hps.july.persistence.EquipmentSet findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.EquipmentSet result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.EquipmentSet)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.storageplace);
				pstmt.setInt(2, _primaryKey.storageplace);
				pstmt.setInt(3, _primaryKey.storageplace);
				pstmt.setInt(4, _primaryKey.storageplace);
				pstmt.setInt(5, _primaryKey.storageplace);
				pstmt.setInt(6, _primaryKey.storageplace);
				pstmt.setInt(7, _primaryKey.storageplace);
				pstmt.setInt(8, _primaryKey.storageplace);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.EquipmentSet)tmpFinder.nextElement();
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
	 * findByPlatinumAndStatus
	 */
	public EJSFinder findByPlatinumAndStatus(java.lang.Integer position, java.lang.Integer owner, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByPlatinumAndStatus(position, owner, state, order);
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
	private static final String genericFindSqlString = "(((((((SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4 WHERE T7.storageplace = T4.equipment AND T7.type = \'E\' AND )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, T3.qty_shell, T3.con_type, T3.name, T3.comment_ctrl, T3.number, T3.ver_po, T3.mfs_num, T3.omcr_num, T3.lac_numbers, T3.trxfr_qty_max, T3.trxfr_qty, T3.trx_use_percent, T3.atr_qty_max, T3.trxhr_qty, T3.atr_qty, T3.aint_qty, T3.hway_qty_voice, T3.hway_qty_gprs, T3.switch, T3.resource, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4, controllers  T3 WHERE T4.equipment = T3.equipment AND T7.storageplace = T4.equipment AND T7.type = \'O\' AND ) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T2.type, T2.osinvname, T2.resource, CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, equipment  T4, comequipment  T2 WHERE T4.equipment = T2.equipment AND T7.storageplace = T4.equipment AND T7.type = \'C\' AND ) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), T1.date_assemb_afs2, T1.on_air, T1.time_backup, T1.n_stoek, T1.date_assemb_afs, T1.name, T1.date_onair, T1.date_test2, T1.date_assemb2, T1.net_stage, T1.date_connect, T1.date_pr2, T1.date_onair2, T1.con_type, T1.st_transp, T1.e1_qty, T1.number, T1.type, T1.date_bldbeg2, T1.date_connect2, T1.repeater, T1.prefixcellid, T1.controller, T1.switch, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, basestations  T1, equipment  T4 WHERE T7.storageplace = T4.equipment AND T4.equipment = T1.equipment AND T7.type = \'B\' AND ) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T6.reppower, T6.repiter_class, T6.number, T6.numchanals, T6.bandwidth, T6.donor_type, T6.date_assemb_afs, T6.date_connect, T6.date_onair, T6.donor_sect, T6.donor_ant, T6.resource, CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, repiters  T6, equipment  T4 WHERE T4.equipment = T6.equipment AND T7.storageplace = T4.equipment AND T7.type = \'R\' AND ) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T5.type, CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, otherequipment  T5, equipment  T4 WHERE T4.equipment = T5.equipment AND T7.storageplace = T4.equipment AND T7.type = \'T\' AND ) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T9.number, CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM storageplaces  T7, wlan  T9, equipment  T4 WHERE T4.equipment = T9.equipment AND T7.storageplace = T4.equipment AND T7.type = \'L\' AND ) )  UNION ALL (SELECT T7.closedate, T7.address, T7.operator, T7.name, T7.storageplace, T7.modified, T7.created, T7.modifiedby, T7.createdby, T7.division, T7.type, T4.state, T4.date_bldbeg, T4.pwr_val, T4.pwr_res_cat, T4.date_assemb, T4.date_test, T4.date_pr, T4.pwr_cat, T4.equipcomment, T4.pwr_reserve, T4.datasource, T4.position, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(40)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(50)), CAST(NULL AS INTEGER), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(5)), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS CHAR(40)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS SMALLINT), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T8.qty_tkgroute_nss, T8.ss7_bss, T8.type, T8.e1_use_percent, T8.number, T8.e1_nss, T8.qty_shell, T8.e1_qty_total, T8.comment, T8.e1_hlr, T8.ss7_hlrin, T8.max_vlr, T8.ss7_nss, T8.e1_bss, T8.qty_conhlr, T8.mscid, T8.capacityused, T8.capacityplan, T8.resource FROM storageplaces  T7, equipment  T4, switches  T8 WHERE T4.equipment = T8.equipment AND T7.storageplace = T4.equipment AND T7.type = \'W\' AND ) ";
	private static final int[] genericFindInsertPoints = {18025, 15872, 13535, 11190, 8936, 6761, 4438, 2298};
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
	private EquipmentSetBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.EquipmentSetBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.EquipmentSetBeanFinderObject temp_finderObject = new com.hps.july.persistence.EquipmentSetBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
