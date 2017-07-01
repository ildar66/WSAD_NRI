package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPositionBean_324e4597
 */
public class EJSJDBCPersisterCMPPositionBean_324e4597 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPositionBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO storageplaces (storageplace, closedate, address, operator, name, modified, created, modifiedby, createdby, division, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO positions (storageplace, sq_qty, aptypeid, longitude, applacetypeid, gsmid, latitude, dampsid, rentvolume, applaceid, docaddress, comment_doc, oporplaceid, details, date_beginbuild, inAction, linktogosnet_lat, oporadate, grchlat, accesslistexp, dampsname, grchaddress, dcsid, dog_date, date_posclose, grchlong, linktogosnet_lon, dog_number, pay_a, oporaour, oporaheight, date_endbuild, orderno, planstate, haveplan, posstate, antplaceid, avg_h_set, inmetro, datasource, latitude_wgs84, longitude_wgs84, geosystem, regionid, renter, netzone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM positions  WHERE storageplace = ?", "DELETE FROM storageplaces  WHERE storageplace = ?"};
	private static final String[] _storeString = {"UPDATE positions  SET sq_qty = ?, aptypeid = ?, longitude = ?, applacetypeid = ?, gsmid = ?, latitude = ?, dampsid = ?, rentvolume = ?, applaceid = ?, docaddress = ?, comment_doc = ?, oporplaceid = ?, details = ?, date_beginbuild = ?, inAction = ?, linktogosnet_lat = ?, oporadate = ?, grchlat = ?, accesslistexp = ?, dampsname = ?, grchaddress = ?, dcsid = ?, dog_date = ?, date_posclose = ?, grchlong = ?, linktogosnet_lon = ?, dog_number = ?, pay_a = ?, oporaour = ?, oporaheight = ?, date_endbuild = ?, orderno = ?, planstate = ?, haveplan = ?, posstate = ?, antplaceid = ?, avg_h_set = ?, inmetro = ?, datasource = ?, latitude_wgs84 = ?, longitude_wgs84 = ?, geosystem = ?, regionid = ?, renter = ?, netzone = ? WHERE storageplace = ?", "UPDATE storageplaces  SET closedate = ?, address = ?, operator = ?, name = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, division = ?, type = ? WHERE storageplace = ?"};
	private static final String _loadString = "SELECT T2.closedate, T2.address, T2.operator, T2.name, T2.storageplace, T2.modified, T2.created, T2.modifiedby, T2.createdby, T2.division, T2.type, T1.sq_qty, T1.aptypeid, T1.longitude, T1.applacetypeid, T1.gsmid, T1.latitude, T1.dampsid, T1.rentvolume, T1.applaceid, T1.docaddress, T1.comment_doc, T1.oporplaceid, T1.details, T1.date_beginbuild, T1.inAction, T1.linktogosnet_lat, T1.oporadate, T1.grchlat, T1.accesslistexp, T1.dampsname, T1.grchaddress, T1.dcsid, T1.dog_date, T1.date_posclose, T1.grchlong, T1.linktogosnet_lon, T1.dog_number, T1.pay_a, T1.oporaour, T1.oporaheight, T1.date_endbuild, T1.orderno, T1.planstate, T1.haveplan, T1.posstate, T1.antplaceid, T1.avg_h_set, T1.inmetro, T1.datasource, T1.latitude_wgs84, T1.longitude_wgs84, T1.geosystem, T1.regionid, T1.renter, T1.netzone FROM storageplaces  T2, positions  T1 WHERE T2.type = \'P\' AND T2.storageplace = T1.storageplace AND T2.storageplace = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPositionBean_324e4597
	 */
	public EJSJDBCPersisterCMPPositionBean_324e4597() throws java.rmi.RemoteException {
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
		PositionBean b = (PositionBean) eb;
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
			pstmt.setString(11, "P");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			if (b.sqqty == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.sqqty);
			}
			if (b.aptypeid == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.aptypeid.intValue());
			}
			if (b.longitude == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.longitude);
			}
			if (b.applacetypeid == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.applacetypeid.intValue());
			}
			if (b.gsmid == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.gsmid.intValue());
			}
			if (b.latitude == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.latitude);
			}
			if (b.dampsid == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.dampsid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rentervolume);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.applaceid == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.applaceid.intValue());
			}
			if (b.docaddress == null) {
				pstmt.setNull(11, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(11, b.docaddress);
			}
			if (b.comment_doc == null) {
				pstmt.setNull(12, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(12, b.comment_doc);
			}
			if (b.oporplaceid == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.oporplaceid.intValue());
			}
			if (b.details == null) {
				pstmt.setNull(14, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(14, b.details);
			}
			if (b.datebeginbuild == null) {
				pstmt.setNull(15, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(15, b.datebeginbuild);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.inAction);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.linktogosnetlat);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			if (b.oporadate == null) {
				pstmt.setNull(18, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(18, b.oporadate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.grchlat);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			if (b.accesslistexp == null) {
				pstmt.setNull(20, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(20, b.accesslistexp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.dampsname);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			if (b.grchaddress == null) {
				pstmt.setNull(22, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(22, b.grchaddress);
			}
			if (b.dcsid == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.dcsid.intValue());
			}
			if (b.dogdate == null) {
				pstmt.setNull(24, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(24, b.dogdate);
			}
			if (b.date_posclose == null) {
				pstmt.setNull(25, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(25, b.date_posclose);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.grchlong);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.linktogosnetlon);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.dognumber);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			if (b.paya == null) {
				pstmt.setNull(29, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(29, b.paya);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.oporaour);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			if (b.oporaheight == null) {
				pstmt.setNull(31, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(31, b.oporaheight);
			}
			if (b.date_endbuild == null) {
				pstmt.setNull(32, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(32, b.date_endbuild);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.orderno);
			if (objectTemp == null) {
				pstmt.setNull(33, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(33, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.planstate);
			if (objectTemp == null) {
				pstmt.setNull(34, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(34, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.haveplan);
			if (objectTemp == null) {
				pstmt.setNull(35, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(35, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.posstate);
			if (objectTemp == null) {
				pstmt.setNull(36, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(36, (java.lang.String)objectTemp);
			}
			if (b.antplaceid == null) {
				pstmt.setNull(37, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(37, b.antplaceid.intValue());
			}
			if (b.avg_h_set == null) {
				pstmt.setNull(38, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(38, b.avg_h_set);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.inmetro));
			if (objectTemp == null) {
				pstmt.setNull(39, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(39, (java.lang.String)objectTemp);
			}
			pstmt.setInt(40, b.datasource);
			if (b.latitude_WGS84 == null) {
				pstmt.setNull(41, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(41, b.latitude_WGS84);
			}
			if (b.longitude_WGS84 == null) {
				pstmt.setNull(42, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(42, b.longitude_WGS84);
			}
			pstmt.setInt(43, b.geosystem);
			if (b.region_regionid == null) {
				pstmt.setNull(44, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(44, b.region_regionid.intValue());
			}
			if (b.renter_organization == null) {
				pstmt.setNull(45, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(45, b.renter_organization.intValue());
			}
			if (b.netZone_netzone == null) {
				pstmt.setNull(46, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(46, b.netZone_netzone.intValue());
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
		PositionBean b = (PositionBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.storageplace = _primaryKey.storageplace;
		b.sqqty = resultSet.getBigDecimal(12);
		tempint = resultSet.getInt(13);
		b.aptypeid = resultSet.wasNull() ? null : new Integer(tempint);
		b.longitude = resultSet.getBigDecimal(14);
		tempint = resultSet.getInt(15);
		b.applacetypeid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		b.gsmid = resultSet.wasNull() ? null : new Integer(tempint);
		b.latitude = resultSet.getBigDecimal(17);
		tempint = resultSet.getInt(18);
		b.dampsid = resultSet.wasNull() ? null : new Integer(tempint);
		b.rentervolume = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(19));
		tempint = resultSet.getInt(20);
		b.applaceid = resultSet.wasNull() ? null : new Integer(tempint);
		b.docaddress = resultSet.getString(21);
		b.comment_doc = resultSet.getString(22);
		tempint = resultSet.getInt(23);
		b.oporplaceid = resultSet.wasNull() ? null : new Integer(tempint);
		b.details = resultSet.getString(24);
		b.datebeginbuild = resultSet.getDate(25);
		b.inAction = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(26));
		b.linktogosnetlat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(27));
		b.oporadate = resultSet.getDate(28);
		b.grchlat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.accesslistexp = resultSet.getDate(30);
		b.dampsname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(31));
		b.grchaddress = resultSet.getString(32);
		tempint = resultSet.getInt(33);
		b.dcsid = resultSet.wasNull() ? null : new Integer(tempint);
		b.dogdate = resultSet.getDate(34);
		b.date_posclose = resultSet.getDate(35);
		b.grchlong = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(36));
		b.linktogosnetlon = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(37));
		b.dognumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(38));
		b.paya = resultSet.getBigDecimal(39);
		b.oporaour = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(40));
		b.oporaheight = resultSet.getBigDecimal(41);
		b.date_endbuild = resultSet.getDate(42);
		b.orderno = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(43));
		b.planstate = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(44));
		b.haveplan = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(45));
		b.posstate = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(46));
		tempint = resultSet.getInt(47);
		b.antplaceid = resultSet.wasNull() ? null : new Integer(tempint);
		b.avg_h_set = resultSet.getBigDecimal(48);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(49));
		b.inmetro = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.datasource = resultSet.getInt(50);
		b.latitude_WGS84 = resultSet.getBigDecimal(51);
		b.longitude_WGS84 = resultSet.getBigDecimal(52);
		b.geosystem = resultSet.getInt(53);
		tempint = resultSet.getInt(54);
		b.region_regionid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(55);
		b.renter_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(56);
		b.netZone_netzone = resultSet.wasNull() ? null : new Integer(tempint);
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
		PositionBean b = (PositionBean) eb;
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
		PositionBean b = (PositionBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PositionBean b = (PositionBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(46, _primaryKey.storageplace);
			if (b.sqqty == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.sqqty);
			}
			if (b.aptypeid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.aptypeid.intValue());
			}
			if (b.longitude == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.longitude);
			}
			if (b.applacetypeid == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.applacetypeid.intValue());
			}
			if (b.gsmid == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.gsmid.intValue());
			}
			if (b.latitude == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.latitude);
			}
			if (b.dampsid == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.dampsid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rentervolume);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.applaceid == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.applaceid.intValue());
			}
			if (b.docaddress == null) {
				pstmt.setNull(10, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(10, b.docaddress);
			}
			if (b.comment_doc == null) {
				pstmt.setNull(11, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(11, b.comment_doc);
			}
			if (b.oporplaceid == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.oporplaceid.intValue());
			}
			if (b.details == null) {
				pstmt.setNull(13, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(13, b.details);
			}
			if (b.datebeginbuild == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.datebeginbuild);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.inAction);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.linktogosnetlat);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.oporadate == null) {
				pstmt.setNull(17, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(17, b.oporadate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.grchlat);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.accesslistexp == null) {
				pstmt.setNull(19, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(19, b.accesslistexp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.dampsname);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			if (b.grchaddress == null) {
				pstmt.setNull(21, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(21, b.grchaddress);
			}
			if (b.dcsid == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.dcsid.intValue());
			}
			if (b.dogdate == null) {
				pstmt.setNull(23, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(23, b.dogdate);
			}
			if (b.date_posclose == null) {
				pstmt.setNull(24, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(24, b.date_posclose);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.grchlong);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.linktogosnetlon);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.dognumber);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			if (b.paya == null) {
				pstmt.setNull(28, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(28, b.paya);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.oporaour);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			if (b.oporaheight == null) {
				pstmt.setNull(30, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(30, b.oporaheight);
			}
			if (b.date_endbuild == null) {
				pstmt.setNull(31, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(31, b.date_endbuild);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.orderno);
			if (objectTemp == null) {
				pstmt.setNull(32, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(32, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.planstate);
			if (objectTemp == null) {
				pstmt.setNull(33, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(33, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.haveplan);
			if (objectTemp == null) {
				pstmt.setNull(34, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(34, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.posstate);
			if (objectTemp == null) {
				pstmt.setNull(35, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(35, (java.lang.String)objectTemp);
			}
			if (b.antplaceid == null) {
				pstmt.setNull(36, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(36, b.antplaceid.intValue());
			}
			if (b.avg_h_set == null) {
				pstmt.setNull(37, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(37, b.avg_h_set);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.inmetro));
			if (objectTemp == null) {
				pstmt.setNull(38, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(38, (java.lang.String)objectTemp);
			}
			pstmt.setInt(39, b.datasource);
			if (b.latitude_WGS84 == null) {
				pstmt.setNull(40, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(40, b.latitude_WGS84);
			}
			if (b.longitude_WGS84 == null) {
				pstmt.setNull(41, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(41, b.longitude_WGS84);
			}
			pstmt.setInt(42, b.geosystem);
			if (b.region_regionid == null) {
				pstmt.setNull(43, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(43, b.region_regionid.intValue());
			}
			if (b.renter_organization == null) {
				pstmt.setNull(44, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(44, b.renter_organization.intValue());
			}
			if (b.netZone_netzone == null) {
				pstmt.setNull(45, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(45, b.netZone_netzone.intValue());
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
			pstmt.setString(10, "P");
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
		PositionBean b = (PositionBean) eb;
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
		if ( discriminator.equals("P") ) {
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
	 * findByQBE4
	 */
	public EJSFinder findByQBE4(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE4(isNetZone, argNetZone, isAllType, isDAMPS, isGSM900, isDCS1800, isControllers, isWorker, argWorker);
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
	public EJSFinder findByQBE(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findPositionsByRegion
	 */
	public EJSFinder findPositionsByRegion(com.hps.july.persistence.RegionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.closedate, T2.address, T2.operator, T2.name, T2.storageplace, T2.modified, T2.created, T2.modifiedby, T2.createdby, T2.division, T2.type, T1.sq_qty, T1.aptypeid, T1.longitude, T1.applacetypeid, T1.gsmid, T1.latitude, T1.dampsid, T1.rentvolume, T1.applaceid, T1.docaddress, T1.comment_doc, T1.oporplaceid, T1.details, T1.date_beginbuild, T1.inAction, T1.linktogosnet_lat, T1.oporadate, T1.grchlat, T1.accesslistexp, T1.dampsname, T1.grchaddress, T1.dcsid, T1.dog_date, T1.date_posclose, T1.grchlong, T1.linktogosnet_lon, T1.dog_number, T1.pay_a, T1.oporaour, T1.oporaheight, T1.date_endbuild, T1.orderno, T1.planstate, T1.haveplan, T1.posstate, T1.antplaceid, T1.avg_h_set, T1.inmetro, T1.datasource, T1.latitude_wgs84, T1.longitude_wgs84, T1.geosystem, T1.regionid, T1.renter, T1.netzone FROM storageplaces  T2, positions  T1 WHERE T2.type = \'P\' AND T2.storageplace = T1.storageplace AND T1.regionid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.regionid);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findRenteePositionByRenter
	 */
	public EJSFinder findRenteePositionByRenter(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.closedate, T2.address, T2.operator, T2.name, T2.storageplace, T2.modified, T2.created, T2.modifiedby, T2.createdby, T2.division, T2.type, T1.sq_qty, T1.aptypeid, T1.longitude, T1.applacetypeid, T1.gsmid, T1.latitude, T1.dampsid, T1.rentvolume, T1.applaceid, T1.docaddress, T1.comment_doc, T1.oporplaceid, T1.details, T1.date_beginbuild, T1.inAction, T1.linktogosnet_lat, T1.oporadate, T1.grchlat, T1.accesslistexp, T1.dampsname, T1.grchaddress, T1.dcsid, T1.dog_date, T1.date_posclose, T1.grchlong, T1.linktogosnet_lon, T1.dog_number, T1.pay_a, T1.oporaour, T1.oporaheight, T1.date_endbuild, T1.orderno, T1.planstate, T1.haveplan, T1.posstate, T1.antplaceid, T1.avg_h_set, T1.inmetro, T1.datasource, T1.latitude_wgs84, T1.longitude_wgs84, T1.geosystem, T1.regionid, T1.renter, T1.netzone FROM storageplaces  T2, positions  T1 WHERE T2.type = \'P\' AND T2.storageplace = T1.storageplace AND T1.renter = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.organization);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findPositionByNetZone
	 */
	public EJSFinder findPositionByNetZone(com.hps.july.persistence.NetZoneKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.closedate, T2.address, T2.operator, T2.name, T2.storageplace, T2.modified, T2.created, T2.modifiedby, T2.createdby, T2.division, T2.type, T1.sq_qty, T1.aptypeid, T1.longitude, T1.applacetypeid, T1.gsmid, T1.latitude, T1.dampsid, T1.rentvolume, T1.applaceid, T1.docaddress, T1.comment_doc, T1.oporplaceid, T1.details, T1.date_beginbuild, T1.inAction, T1.linktogosnet_lat, T1.oporadate, T1.grchlat, T1.accesslistexp, T1.dampsname, T1.grchaddress, T1.dcsid, T1.dog_date, T1.date_posclose, T1.grchlong, T1.linktogosnet_lon, T1.dog_number, T1.pay_a, T1.oporaour, T1.oporaheight, T1.date_endbuild, T1.orderno, T1.planstate, T1.haveplan, T1.posstate, T1.antplaceid, T1.avg_h_set, T1.inmetro, T1.datasource, T1.latitude_wgs84, T1.longitude_wgs84, T1.geosystem, T1.regionid, T1.renter, T1.netzone FROM storageplaces  T2, positions  T1 WHERE T2.type = \'P\' AND T2.storageplace = T1.storageplace AND T1.netzone = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.netzone);
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
	public com.hps.july.persistence.Position findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Position result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.Position)home.getBean(key);
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
					result = (com.hps.july.persistence.Position)tmpFinder.nextElement();
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
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, isRenter, argRenter, isResponsableWorker, argResponsableWorker, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE3
	 */
	public EJSFinder findByQBE3(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Boolean isInAction, java.lang.String inAction, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE3(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, isRenter, argRenter, isResponsableWorker, argResponsableWorker, isInAction, inAction, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T2.closedate, T2.address, T2.operator, T2.name, T2.storageplace, T2.modified, T2.created, T2.modifiedby, T2.createdby, T2.division, T2.type, T1.sq_qty, T1.aptypeid, T1.longitude, T1.applacetypeid, T1.gsmid, T1.latitude, T1.dampsid, T1.rentvolume, T1.applaceid, T1.docaddress, T1.comment_doc, T1.oporplaceid, T1.details, T1.date_beginbuild, T1.inAction, T1.linktogosnet_lat, T1.oporadate, T1.grchlat, T1.accesslistexp, T1.dampsname, T1.grchaddress, T1.dcsid, T1.dog_date, T1.date_posclose, T1.grchlong, T1.linktogosnet_lon, T1.dog_number, T1.pay_a, T1.oporaour, T1.oporaheight, T1.date_endbuild, T1.orderno, T1.planstate, T1.haveplan, T1.posstate, T1.antplaceid, T1.avg_h_set, T1.inmetro, T1.datasource, T1.latitude_wgs84, T1.longitude_wgs84, T1.geosystem, T1.regionid, T1.renter, T1.netzone FROM storageplaces  T2, positions  T1 WHERE T2.type = \'P\' AND T2.storageplace = T1.storageplace AND ";
	private static final int[] genericFindInsertPoints = {898};
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
	private PositionBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.PositionBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.PositionBeanFinderObject temp_finderObject = new com.hps.july.persistence.PositionBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
