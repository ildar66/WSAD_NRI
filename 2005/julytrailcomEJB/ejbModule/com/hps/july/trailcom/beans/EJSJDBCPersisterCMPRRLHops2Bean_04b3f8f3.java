package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPRRLHops2Bean_04b3f8f3
 */
public class EJSJDBCPersisterCMPRRLHops2Bean_04b3f8f3 extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderRRLHops2Bean {
	private static final String _createString = "INSERT INTO rrl_hops2 (hopsid, frequency_a1, signal_real_b, cable_2mb_a, frequency_b1, cable_rrl_b, cable_rrl_a, diam_b, type_hw, frequency_a_doc, cable_power_a, azimuthBA_Doc, height_a_doc, signal_real_a, diam_a_doc, power_a, power_b, speed_doc, comment_a, cable_power_b, diam2_b, capacity, frequency_b_doc, comment_doc, comment_b, Azimuth, signal_calc_a, file_shortnumber, height_b, diam_b_doc, azimuthAB_Doc, accumid_a, file_number, diam_a, height_a, signal_calc_b, cable_2mbr_b, frequency_a2, frequency_b2, power_doc, height_b_doc, diam2_a, accumid_b, resource_doc, number_in_file, sfonumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM rrl_hops2  WHERE hopsid = ?";
	private static final String _storeString = "UPDATE rrl_hops2  SET frequency_a1 = ?, signal_real_b = ?, cable_2mb_a = ?, frequency_b1 = ?, cable_rrl_b = ?, cable_rrl_a = ?, diam_b = ?, type_hw = ?, frequency_a_doc = ?, cable_power_a = ?, azimuthBA_Doc = ?, height_a_doc = ?, signal_real_a = ?, diam_a_doc = ?, power_a = ?, power_b = ?, speed_doc = ?, comment_a = ?, cable_power_b = ?, diam2_b = ?, capacity = ?, frequency_b_doc = ?, comment_doc = ?, comment_b = ?, Azimuth = ?, signal_calc_a = ?, file_shortnumber = ?, height_b = ?, diam_b_doc = ?, azimuthAB_Doc = ?, accumid_a = ?, file_number = ?, diam_a = ?, height_a = ?, signal_calc_b = ?, cable_2mbr_b = ?, frequency_a2 = ?, frequency_b2 = ?, power_doc = ?, height_b_doc = ?, diam2_a = ?, accumid_b = ?, resource_doc = ?, number_in_file = ?, sfonumber = ? WHERE hopsid = ?";
	private static final String _loadString = "SELECT T1.frequency_a1, T1.signal_real_b, T1.cable_2mb_a, T1.frequency_b1, T1.cable_rrl_b, T1.cable_rrl_a, T1.diam_b, T1.type_hw, T1.frequency_a_doc, T1.cable_power_a, T1.azimuthBA_Doc, T1.height_a_doc, T1.signal_real_a, T1.diam_a_doc, T1.power_a, T1.power_b, T1.speed_doc, T1.comment_a, T1.cable_power_b, T1.diam2_b, T1.capacity, T1.frequency_b_doc, T1.comment_doc, T1.comment_b, T1.Azimuth, T1.signal_calc_a, T1.file_shortnumber, T1.height_b, T1.diam_b_doc, T1.azimuthAB_Doc, T1.accumid_a, T1.file_number, T1.diam_a, T1.height_a, T1.signal_calc_b, T1.cable_2mbr_b, T1.frequency_a2, T1.frequency_b2, T1.power_doc, T1.height_b_doc, T1.diam2_a, T1.accumid_b, T1.resource_doc, T1.number_in_file, T1.sfonumber, T1.hopsid FROM rrl_hops2  T1 WHERE T1.hopsid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPRRLHops2Bean_04b3f8f3
	 */
	public EJSJDBCPersisterCMPRRLHops2Bean_04b3f8f3() throws java.rmi.RemoteException {
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
		RRLHops2Bean b = (RRLHops2Bean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.frequency_a1 == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.frequency_a1);
			}
			if (b.signal_real_b == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.signal_real_b);
			}
			if (b.cable_2mb_a == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.cable_2mb_a);
			}
			if (b.frequency_b1 == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.frequency_b1);
			}
			if (b.cable_rrl_b == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.cable_rrl_b);
			}
			if (b.cable_rrl_a == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.cable_rrl_a);
			}
			if (b.diam_b == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.diam_b);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type_hw);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.frequency_a_doc == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.frequency_a_doc);
			}
			if (b.cable_power_a == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.cable_power_a);
			}
			if (b.azimuthBA_Doc == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.azimuthBA_Doc);
			}
			if (b.height_a_doc == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.height_a_doc);
			}
			if (b.signal_real_a == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.signal_real_a);
			}
			if (b.diam_a_doc == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.diam_a_doc);
			}
			if (b.power_a == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.power_a);
			}
			if (b.power_b == null) {
				pstmt.setNull(17, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(17, b.power_b);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.speed_doc);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.comment_a);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			if (b.cable_power_b == null) {
				pstmt.setNull(20, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(20, b.cable_power_b);
			}
			if (b.diam2_b == null) {
				pstmt.setNull(21, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(21, b.diam2_b);
			}
			if (b.capacity == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.capacity.intValue());
			}
			if (b.frequency_b_doc == null) {
				pstmt.setNull(23, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(23, b.frequency_b_doc);
			}
			if (b.comment_doc == null) {
				pstmt.setNull(24, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(24, b.comment_doc);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.comment_b);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			if (b.azimuth == null) {
				pstmt.setNull(26, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(26, b.azimuth);
			}
			if (b.signal_calc_a == null) {
				pstmt.setNull(27, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(27, b.signal_calc_a);
			}
			if (b.file_shortnumber == null) {
				pstmt.setNull(28, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(28, b.file_shortnumber.intValue());
			}
			if (b.height_b == null) {
				pstmt.setNull(29, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(29, b.height_b);
			}
			if (b.diam_b_doc == null) {
				pstmt.setNull(30, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(30, b.diam_b_doc);
			}
			if (b.azimuthAB_Doc == null) {
				pstmt.setNull(31, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(31, b.azimuthAB_Doc);
			}
			if (b.accumid_a == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.accumid_a.intValue());
			}
			if (b.file_number == null) {
				pstmt.setNull(33, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(33, b.file_number.intValue());
			}
			if (b.diam_a == null) {
				pstmt.setNull(34, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(34, b.diam_a);
			}
			if (b.height_a == null) {
				pstmt.setNull(35, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(35, b.height_a);
			}
			if (b.signal_calc_b == null) {
				pstmt.setNull(36, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(36, b.signal_calc_b);
			}
			if (b.cable_2mbr_b == null) {
				pstmt.setNull(37, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(37, b.cable_2mbr_b);
			}
			if (b.frequency_a2 == null) {
				pstmt.setNull(38, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(38, b.frequency_a2);
			}
			if (b.frequency_b2 == null) {
				pstmt.setNull(39, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(39, b.frequency_b2);
			}
			if (b.power_doc == null) {
				pstmt.setNull(40, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(40, b.power_doc);
			}
			if (b.height_b_doc == null) {
				pstmt.setNull(41, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(41, b.height_b_doc);
			}
			if (b.diam2_a == null) {
				pstmt.setNull(42, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(42, b.diam2_a);
			}
			if (b.accumid_b == null) {
				pstmt.setNull(43, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(43, b.accumid_b.intValue());
			}
			if (b.resource_doc == null) {
				pstmt.setNull(44, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(44, b.resource_doc.intValue());
			}
			if (b.number_in_file == null) {
				pstmt.setNull(45, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(45, b.number_in_file.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sfonumber);
			if (objectTemp == null) {
				pstmt.setNull(46, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(46, (java.lang.String)objectTemp);
			}
			if (b.hopid_hopsid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.hopid_hopsid.intValue());
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
		RRLHops2Bean b = (RRLHops2Bean) eb;
		com.hps.july.trailcom.beans.RRLHops2Key _primaryKey = (com.hps.july.trailcom.beans.RRLHops2Key)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.hopid_hopsid = _primaryKey.hopid_hopsid;
		b.frequency_a1 = resultSet.getBigDecimal(1);
		b.signal_real_b = resultSet.getBigDecimal(2);
		b.cable_2mb_a = resultSet.getBigDecimal(3);
		b.frequency_b1 = resultSet.getBigDecimal(4);
		b.cable_rrl_b = resultSet.getBigDecimal(5);
		b.cable_rrl_a = resultSet.getBigDecimal(6);
		b.diam_b = resultSet.getBigDecimal(7);
		b.type_hw = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.frequency_a_doc = resultSet.getBigDecimal(9);
		b.cable_power_a = resultSet.getBigDecimal(10);
		b.azimuthBA_Doc = resultSet.getBigDecimal(11);
		b.height_a_doc = resultSet.getBigDecimal(12);
		b.signal_real_a = resultSet.getBigDecimal(13);
		b.diam_a_doc = resultSet.getBigDecimal(14);
		b.power_a = resultSet.getBigDecimal(15);
		b.power_b = resultSet.getBigDecimal(16);
		b.speed_doc = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(17));
		b.comment_a = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		b.cable_power_b = resultSet.getBigDecimal(19);
		b.diam2_b = resultSet.getBigDecimal(20);
		tempint = resultSet.getInt(21);
		b.capacity = resultSet.wasNull() ? null : new Integer(tempint);
		b.frequency_b_doc = resultSet.getBigDecimal(22);
		b.comment_doc = resultSet.getString(23);
		b.comment_b = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(24));
		b.azimuth = resultSet.getBigDecimal(25);
		b.signal_calc_a = resultSet.getBigDecimal(26);
		tempint = resultSet.getInt(27);
		b.file_shortnumber = resultSet.wasNull() ? null : new Integer(tempint);
		b.height_b = resultSet.getBigDecimal(28);
		b.diam_b_doc = resultSet.getBigDecimal(29);
		b.azimuthAB_Doc = resultSet.getBigDecimal(30);
		tempint = resultSet.getInt(31);
		b.accumid_a = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(32);
		b.file_number = resultSet.wasNull() ? null : new Integer(tempint);
		b.diam_a = resultSet.getBigDecimal(33);
		b.height_a = resultSet.getBigDecimal(34);
		b.signal_calc_b = resultSet.getBigDecimal(35);
		b.cable_2mbr_b = resultSet.getBigDecimal(36);
		b.frequency_a2 = resultSet.getBigDecimal(37);
		b.frequency_b2 = resultSet.getBigDecimal(38);
		b.power_doc = resultSet.getBigDecimal(39);
		b.height_b_doc = resultSet.getBigDecimal(40);
		b.diam2_a = resultSet.getBigDecimal(41);
		tempint = resultSet.getInt(42);
		b.accumid_b = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(43);
		b.resource_doc = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(44);
		b.number_in_file = resultSet.wasNull() ? null : new Integer(tempint);
		b.sfonumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(45));
		tempint = resultSet.getInt(46);
		b.hopid_hopsid = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		RRLHops2Bean b = (RRLHops2Bean) eb;
		com.hps.july.trailcom.beans.RRLHops2Key _primaryKey = (com.hps.july.trailcom.beans.RRLHops2Key)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.hopid_hopsid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.hopid_hopsid.intValue());
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
		RRLHops2Bean b = (RRLHops2Bean) eb;
		com.hps.july.trailcom.beans.RRLHops2Key _primaryKey = new com.hps.july.trailcom.beans.RRLHops2Key();
		_primaryKey.hopid_hopsid = b.hopid_hopsid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RRLHops2Bean b = (RRLHops2Bean) eb;
		com.hps.july.trailcom.beans.RRLHops2Key _primaryKey = new com.hps.july.trailcom.beans.RRLHops2Key();
		_primaryKey.hopid_hopsid = b.hopid_hopsid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.hopid_hopsid == null) {
				pstmt.setNull(46, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(46, _primaryKey.hopid_hopsid.intValue());
			}
			if (b.frequency_a1 == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.frequency_a1);
			}
			if (b.signal_real_b == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.signal_real_b);
			}
			if (b.cable_2mb_a == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.cable_2mb_a);
			}
			if (b.frequency_b1 == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.frequency_b1);
			}
			if (b.cable_rrl_b == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.cable_rrl_b);
			}
			if (b.cable_rrl_a == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.cable_rrl_a);
			}
			if (b.diam_b == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.diam_b);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type_hw);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.frequency_a_doc == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.frequency_a_doc);
			}
			if (b.cable_power_a == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.cable_power_a);
			}
			if (b.azimuthBA_Doc == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.azimuthBA_Doc);
			}
			if (b.height_a_doc == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.height_a_doc);
			}
			if (b.signal_real_a == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.signal_real_a);
			}
			if (b.diam_a_doc == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.diam_a_doc);
			}
			if (b.power_a == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.power_a);
			}
			if (b.power_b == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.power_b);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.speed_doc);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.comment_a);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.cable_power_b == null) {
				pstmt.setNull(19, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(19, b.cable_power_b);
			}
			if (b.diam2_b == null) {
				pstmt.setNull(20, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(20, b.diam2_b);
			}
			if (b.capacity == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.capacity.intValue());
			}
			if (b.frequency_b_doc == null) {
				pstmt.setNull(22, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(22, b.frequency_b_doc);
			}
			if (b.comment_doc == null) {
				pstmt.setNull(23, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(23, b.comment_doc);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.comment_b);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			if (b.azimuth == null) {
				pstmt.setNull(25, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(25, b.azimuth);
			}
			if (b.signal_calc_a == null) {
				pstmt.setNull(26, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(26, b.signal_calc_a);
			}
			if (b.file_shortnumber == null) {
				pstmt.setNull(27, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(27, b.file_shortnumber.intValue());
			}
			if (b.height_b == null) {
				pstmt.setNull(28, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(28, b.height_b);
			}
			if (b.diam_b_doc == null) {
				pstmt.setNull(29, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(29, b.diam_b_doc);
			}
			if (b.azimuthAB_Doc == null) {
				pstmt.setNull(30, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(30, b.azimuthAB_Doc);
			}
			if (b.accumid_a == null) {
				pstmt.setNull(31, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(31, b.accumid_a.intValue());
			}
			if (b.file_number == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.file_number.intValue());
			}
			if (b.diam_a == null) {
				pstmt.setNull(33, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(33, b.diam_a);
			}
			if (b.height_a == null) {
				pstmt.setNull(34, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(34, b.height_a);
			}
			if (b.signal_calc_b == null) {
				pstmt.setNull(35, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(35, b.signal_calc_b);
			}
			if (b.cable_2mbr_b == null) {
				pstmt.setNull(36, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(36, b.cable_2mbr_b);
			}
			if (b.frequency_a2 == null) {
				pstmt.setNull(37, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(37, b.frequency_a2);
			}
			if (b.frequency_b2 == null) {
				pstmt.setNull(38, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(38, b.frequency_b2);
			}
			if (b.power_doc == null) {
				pstmt.setNull(39, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(39, b.power_doc);
			}
			if (b.height_b_doc == null) {
				pstmt.setNull(40, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(40, b.height_b_doc);
			}
			if (b.diam2_a == null) {
				pstmt.setNull(41, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(41, b.diam2_a);
			}
			if (b.accumid_b == null) {
				pstmt.setNull(42, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(42, b.accumid_b.intValue());
			}
			if (b.resource_doc == null) {
				pstmt.setNull(43, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(43, b.resource_doc.intValue());
			}
			if (b.number_in_file == null) {
				pstmt.setNull(44, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(44, b.number_in_file.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sfonumber);
			if (objectTemp == null) {
				pstmt.setNull(45, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(45, (java.lang.String)objectTemp);
			}
			if (b.hopid_hopsid == null) {
				pstmt.setNull(46, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(46, b.hopid_hopsid.intValue());
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
		RRLHops2Bean b = (RRLHops2Bean) eb;
		com.hps.july.trailcom.beans.RRLHops2Key _primaryKey = new com.hps.july.trailcom.beans.RRLHops2Key();
		_primaryKey.hopid_hopsid = b.hopid_hopsid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.hopid_hopsid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.hopid_hopsid.intValue());
			}
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
		com.hps.july.trailcom.beans.RRLHops2Key key = new com.hps.july.trailcom.beans.RRLHops2Key();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(46);
			key.hopid_hopsid = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.RRLHops2 findByPrimaryKey(com.hps.july.trailcom.beans.RRLHops2Key key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.RRLHops2) home.activateBean(key);
	}
	/**
	 * findRrlHops2ByHopid
	 */
	public com.hps.july.trailcom.beans.RRLHops2 findRrlHops2ByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.trailcom.beans.RRLHops2 result = null;
		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.frequency_a1, T1.signal_real_b, T1.cable_2mb_a, T1.frequency_b1, T1.cable_rrl_b, T1.cable_rrl_a, T1.diam_b, T1.type_hw, T1.frequency_a_doc, T1.cable_power_a, T1.azimuthBA_Doc, T1.height_a_doc, T1.signal_real_a, T1.diam_a_doc, T1.power_a, T1.power_b, T1.speed_doc, T1.comment_a, T1.cable_power_b, T1.diam2_b, T1.capacity, T1.frequency_b_doc, T1.comment_doc, T1.comment_b, T1.Azimuth, T1.signal_calc_a, T1.file_shortnumber, T1.height_b, T1.diam_b_doc, T1.azimuthAB_Doc, T1.accumid_a, T1.file_number, T1.diam_a, T1.height_a, T1.signal_calc_b, T1.cable_2mbr_b, T1.frequency_a2, T1.frequency_b2, T1.power_doc, T1.height_b_doc, T1.diam2_a, T1.accumid_b, T1.resource_doc, T1.number_in_file, T1.sfonumber, T1.hopsid FROM rrl_hops2  T1 WHERE T1.hopsid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.hopsid);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.trailcom.beans.RRLHops2)tmpFinder.nextElement();
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
}
