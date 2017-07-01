package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPRepiterBean_8d933516
 */
public class EJSJDBCPersisterCMPRepiterBean_8d933516 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderRepiterBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO storageplaces (storageplace, closedate, address, operator, name, modified, created, modifiedby, createdby, division, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO equipment (equipment, state, date_bldbeg, pwr_val, pwr_res_cat, date_assemb, date_test, date_pr, pwr_cat, equipcomment, pwr_reserve, datasource, position) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO repiters (equipment, reppower, repiter_class, number, numchanals, bandwidth, donor_type, date_assemb_afs, date_connect, date_onair, donor_sect, donor_ant, resource) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM repiters  WHERE equipment = ?", "DELETE FROM equipment  WHERE equipment = ?", "DELETE FROM storageplaces  WHERE storageplace = ?"};
	private static final String[] _storeString = {"UPDATE repiters  SET reppower = ?, repiter_class = ?, number = ?, numchanals = ?, bandwidth = ?, donor_type = ?, date_assemb_afs = ?, date_connect = ?, date_onair = ?, donor_sect = ?, donor_ant = ?, resource = ? WHERE equipment = ?", "UPDATE equipment  SET state = ?, date_bldbeg = ?, pwr_val = ?, pwr_res_cat = ?, date_assemb = ?, date_test = ?, date_pr = ?, pwr_cat = ?, equipcomment = ?, pwr_reserve = ?, datasource = ?, position = ? WHERE equipment = ?", "UPDATE storageplaces  SET closedate = ?, address = ?, operator = ?, name = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, division = ?, type = ? WHERE storageplace = ?"};
	private static final String _loadString = "SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T1.state, T1.date_bldbeg, T1.pwr_val, T1.pwr_res_cat, T1.date_assemb, T1.date_test, T1.date_pr, T1.pwr_cat, T1.equipcomment, T1.pwr_reserve, T1.datasource, T1.position, T2.reppower, T2.repiter_class, T2.number, T2.numchanals, T2.bandwidth, T2.donor_type, T2.date_assemb_afs, T2.date_connect, T2.date_onair, T2.donor_sect, T2.donor_ant, T2.resource FROM storageplaces  T3, repiters  T2, equipment  T1 WHERE T3.type = \'R\' AND T1.equipment = T2.equipment AND T3.storageplace = T1.equipment AND T3.storageplace = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPRepiterBean_8d933516
	 */
	public EJSJDBCPersisterCMPRepiterBean_8d933516() throws java.rmi.RemoteException {
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
		RepiterBean b = (RepiterBean) eb;
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
			pstmt.setString(11, "R");
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
			if (b.reppower == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.reppower);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.repiter_class);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setInt(4, b.number);
			if (b.numchanals == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.numchanals.intValue());
			}
			if (b.bandwidth == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.bandwidth);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.donor_type);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.date_assemb_afs == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.date_assemb_afs);
			}
			if (b.date_connect == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.date_connect);
			}
			if (b.date_onair == null) {
				pstmt.setNull(10, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(10, b.date_onair);
			}
			if (b.donor_sect_idsect == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.donor_sect_idsect.intValue());
			}
			if (b.donor_ant_idanten == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.donor_ant_idanten.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.resource_resource.intValue());
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
		RepiterBean b = (RepiterBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.storageplace = _primaryKey.storageplace;
		b.reppower = resultSet.getBigDecimal(24);
		b.repiter_class = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(25));
		b.number = resultSet.getInt(26);
		tempint = resultSet.getInt(27);
		b.numchanals = resultSet.wasNull() ? null : new Integer(tempint);
		b.bandwidth = resultSet.getBigDecimal(28);
		b.donor_type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.date_assemb_afs = resultSet.getDate(30);
		b.date_connect = resultSet.getDate(31);
		b.date_onair = resultSet.getDate(32);
		tempint = resultSet.getInt(33);
		b.donor_sect_idsect = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(34);
		b.donor_ant_idanten = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(35);
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
		RepiterBean b = (RepiterBean) eb;
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
		RepiterBean b = (RepiterBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RepiterBean b = (RepiterBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(13, _primaryKey.storageplace);
			if (b.reppower == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.reppower);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.repiter_class);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			pstmt.setInt(3, b.number);
			if (b.numchanals == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.numchanals.intValue());
			}
			if (b.bandwidth == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.bandwidth);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.donor_type);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.date_assemb_afs == null) {
				pstmt.setNull(7, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(7, b.date_assemb_afs);
			}
			if (b.date_connect == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.date_connect);
			}
			if (b.date_onair == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.date_onair);
			}
			if (b.donor_sect_idsect == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.donor_sect_idsect.intValue());
			}
			if (b.donor_ant_idanten == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.donor_ant_idanten.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.resource_resource.intValue());
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
			pstmt.setString(10, "R");
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
		RepiterBean b = (RepiterBean) eb;
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
		if ( discriminator.equals("R") ) {
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
	 * findRepitersByDonor_sect
	 */
	public EJSFinder findRepitersByDonor_sect(com.hps.july.persistence.SectorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T1.state, T1.date_bldbeg, T1.pwr_val, T1.pwr_res_cat, T1.date_assemb, T1.date_test, T1.date_pr, T1.pwr_cat, T1.equipcomment, T1.pwr_reserve, T1.datasource, T1.position, T2.reppower, T2.repiter_class, T2.number, T2.numchanals, T2.bandwidth, T2.donor_type, T2.date_assemb_afs, T2.date_connect, T2.date_onair, T2.donor_sect, T2.donor_ant, T2.resource FROM storageplaces  T3, repiters  T2, equipment  T1 WHERE T3.type = \'R\' AND T1.equipment = T2.equipment AND T3.storageplace = T1.equipment AND T2.donor_sect = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idsect);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findRepitersByResource
	 */
	public EJSFinder findRepitersByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T1.state, T1.date_bldbeg, T1.pwr_val, T1.pwr_res_cat, T1.date_assemb, T1.date_test, T1.date_pr, T1.pwr_cat, T1.equipcomment, T1.pwr_reserve, T1.datasource, T1.position, T2.reppower, T2.repiter_class, T2.number, T2.numchanals, T2.bandwidth, T2.donor_type, T2.date_assemb_afs, T2.date_connect, T2.date_onair, T2.donor_sect, T2.donor_ant, T2.resource FROM storageplaces  T3, repiters  T2, equipment  T1 WHERE T3.type = \'R\' AND T1.equipment = T2.equipment AND T3.storageplace = T1.equipment AND T2.resource = ?");
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
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isDonorSect, java.lang.Integer donorSect, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isDonorSect, donorSect, order);
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
	public com.hps.july.persistence.Repiter findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Repiter result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.Repiter)home.getBean(key);
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
					result = (com.hps.july.persistence.Repiter)tmpFinder.nextElement();
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
	 * findRepitersByDonor_ant
	 */
	public EJSFinder findRepitersByDonor_ant(com.hps.july.persistence.AntennaKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T1.state, T1.date_bldbeg, T1.pwr_val, T1.pwr_res_cat, T1.date_assemb, T1.date_test, T1.date_pr, T1.pwr_cat, T1.equipcomment, T1.pwr_reserve, T1.datasource, T1.position, T2.reppower, T2.repiter_class, T2.number, T2.numchanals, T2.bandwidth, T2.donor_type, T2.date_assemb_afs, T2.date_connect, T2.date_onair, T2.donor_sect, T2.donor_ant, T2.resource FROM storageplaces  T3, repiters  T2, equipment  T1 WHERE T3.type = \'R\' AND T1.equipment = T2.equipment AND T3.storageplace = T1.equipment AND T2.donor_ant = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idanten);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
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
	private static final String genericFindSqlString = "SELECT T3.closedate, T3.address, T3.operator, T3.name, T3.storageplace, T3.modified, T3.created, T3.modifiedby, T3.createdby, T3.division, T3.type, T1.state, T1.date_bldbeg, T1.pwr_val, T1.pwr_res_cat, T1.date_assemb, T1.date_test, T1.date_pr, T1.pwr_cat, T1.equipcomment, T1.pwr_reserve, T1.datasource, T1.position, T2.reppower, T2.repiter_class, T2.number, T2.numchanals, T2.bandwidth, T2.donor_type, T2.date_assemb_afs, T2.date_connect, T2.date_onair, T2.donor_sect, T2.donor_ant, T2.resource FROM storageplaces  T3, repiters  T2, equipment  T1 WHERE T3.type = \'R\' AND T1.equipment = T2.equipment AND T3.storageplace = T1.equipment AND ";
	private static final int[] genericFindInsertPoints = {639};
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
	private RepiterBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.RepiterBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.RepiterBeanFinderObject temp_finderObject = new com.hps.july.persistence.RepiterBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
