package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAfsSchemeBean_3edc0e87
 */
public class EJSJDBCPersisterCMPAfsSchemeBean_3edc0e87 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderAfsSchemeBean {
	private static final String _createString = "INSERT INTO confafsschemes (schemeid, numscheme, sectcount900, sectcount1800, antx2, antx4, antv1, antv2, dbc1, dbc2, df1, df2, tma, jo, ji, con, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM confafsschemes  WHERE schemeid = ?";
	private static final String _storeString = "UPDATE confafsschemes  SET numscheme = ?, sectcount900 = ?, sectcount1800 = ?, antx2 = ?, antx4 = ?, antv1 = ?, antv2 = ?, dbc1 = ?, dbc2 = ?, df1 = ?, df2 = ?, tma = ?, jo = ?, ji = ?, con = ?, notes = ? WHERE schemeid = ?";
	private static final String _loadString = "SELECT T1.schemeid, T1.numscheme, T1.sectcount900, T1.sectcount1800, T1.antx2, T1.antx4, T1.antv1, T1.antv2, T1.dbc1, T1.dbc2, T1.df1, T1.df2, T1.tma, T1.jo, T1.ji, T1.con, T1.notes FROM confafsschemes  T1 WHERE T1.schemeid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAfsSchemeBean_3edc0e87
	 */
	public EJSJDBCPersisterCMPAfsSchemeBean_3edc0e87() throws java.rmi.RemoteException {
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
		AfsSchemeBean b = (AfsSchemeBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.schemeid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.schemeid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numscheme);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.sectcount900 == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.sectcount900.intValue());
			}
			if (b.sectcount1800 == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.sectcount1800.intValue());
			}
			if (b.antX2 == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.antX2.intValue());
			}
			if (b.antX4 == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.antX4.intValue());
			}
			if (b.antV1 == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.antV1.intValue());
			}
			if (b.antV2 == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.antV2.intValue());
			}
			if (b.dbc1 == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.dbc1.intValue());
			}
			if (b.dbc2 == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.dbc2.intValue());
			}
			if (b.df1 == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.df1.intValue());
			}
			if (b.df2 == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.df2.intValue());
			}
			if (b.tma == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.tma.intValue());
			}
			if (b.jo == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.jo.intValue());
			}
			if (b.ji == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.ji.intValue());
			}
			if (b.conn == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.conn.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
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
		AfsSchemeBean b = (AfsSchemeBean) eb;
		com.hps.july.persistence2.AfsSchemeKey _primaryKey = (com.hps.july.persistence2.AfsSchemeKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.schemeid = _primaryKey.schemeid;
		b.numscheme = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		tempint = resultSet.getInt(3);
		b.sectcount900 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.sectcount1800 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.antX2 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.antX4 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.antV1 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.antV2 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.dbc1 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.dbc2 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(11);
		b.df1 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(12);
		b.df2 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		b.tma = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(14);
		b.jo = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.ji = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		b.conn = resultSet.wasNull() ? null : new Integer(tempint);
		b.notes = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(17));
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AfsSchemeBean b = (AfsSchemeBean) eb;
		com.hps.july.persistence2.AfsSchemeKey _primaryKey = (com.hps.july.persistence2.AfsSchemeKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.schemeid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.schemeid.intValue());
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
		AfsSchemeBean b = (AfsSchemeBean) eb;
		com.hps.july.persistence2.AfsSchemeKey _primaryKey = new com.hps.july.persistence2.AfsSchemeKey();
		_primaryKey.schemeid = b.schemeid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AfsSchemeBean b = (AfsSchemeBean) eb;
		com.hps.july.persistence2.AfsSchemeKey _primaryKey = new com.hps.july.persistence2.AfsSchemeKey();
		_primaryKey.schemeid = b.schemeid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.schemeid == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, _primaryKey.schemeid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numscheme);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.sectcount900 == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.sectcount900.intValue());
			}
			if (b.sectcount1800 == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.sectcount1800.intValue());
			}
			if (b.antX2 == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.antX2.intValue());
			}
			if (b.antX4 == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.antX4.intValue());
			}
			if (b.antV1 == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.antV1.intValue());
			}
			if (b.antV2 == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.antV2.intValue());
			}
			if (b.dbc1 == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.dbc1.intValue());
			}
			if (b.dbc2 == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.dbc2.intValue());
			}
			if (b.df1 == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.df1.intValue());
			}
			if (b.df2 == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.df2.intValue());
			}
			if (b.tma == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.tma.intValue());
			}
			if (b.jo == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.jo.intValue());
			}
			if (b.ji == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.ji.intValue());
			}
			if (b.conn == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.conn.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
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
		AfsSchemeBean b = (AfsSchemeBean) eb;
		com.hps.july.persistence2.AfsSchemeKey _primaryKey = new com.hps.july.persistence2.AfsSchemeKey();
		_primaryKey.schemeid = b.schemeid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.schemeid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.schemeid.intValue());
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
		com.hps.july.persistence2.AfsSchemeKey key = new com.hps.july.persistence2.AfsSchemeKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(1);
			key.schemeid = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.AfsScheme findByPrimaryKey(com.hps.july.persistence2.AfsSchemeKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.AfsScheme) home.activateBean(primaryKey);
	}
}
