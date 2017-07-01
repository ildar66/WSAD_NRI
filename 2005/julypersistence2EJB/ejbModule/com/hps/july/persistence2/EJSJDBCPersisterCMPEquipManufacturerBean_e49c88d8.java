package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPEquipManufacturerBean_e49c88d8
 */
public class EJSJDBCPersisterCMPEquipManufacturerBean_e49c88d8 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderEquipManufacturerBean {
	private static final String _createString = "INSERT INTO equipmanufacturers (manufid, name, shortname, equipcatalog, officialsite, comment) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM equipmanufacturers  WHERE manufid = ?";
	private static final String _storeString = "UPDATE equipmanufacturers  SET name = ?, shortname = ?, equipcatalog = ?, officialsite = ?, comment = ? WHERE manufid = ?";
	private static final String _loadString = "SELECT T1.manufid, T1.name, T1.shortname, T1.equipcatalog, T1.officialsite, T1.comment FROM equipmanufacturers  T1 WHERE T1.manufid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPEquipManufacturerBean_e49c88d8
	 */
	public EJSJDBCPersisterCMPEquipManufacturerBean_e49c88d8() throws java.rmi.RemoteException {
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
		EquipManufacturerBean b = (EquipManufacturerBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.manufid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equipcatalog);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.officialsite == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.officialsite);
			}
			if (b.comment == null) {
				pstmt.setNull(6, java.sql.Types.LONGVARCHAR);
			}
			else {
				pstmt.setString(6, b.comment);
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
		EquipManufacturerBean b = (EquipManufacturerBean) eb;
		java.lang.Integer manufid = (java.lang.Integer)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.manufid = manufid;
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.shortname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.equipcatalog = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.officialsite = resultSet.getString(5);
		b.comment = resultSet.getString(6);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		EquipManufacturerBean b = (EquipManufacturerBean) eb;
		java.lang.Integer manufid = (java.lang.Integer)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (manufid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, manufid.intValue());
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
		EquipManufacturerBean b = (EquipManufacturerBean) eb;
		java.lang.Integer manufid;
		manufid = b.manufid;
		java.lang.Integer _primaryKey = manufid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		EquipManufacturerBean b = (EquipManufacturerBean) eb;
		java.lang.Integer manufid;
		manufid = b.manufid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (manufid == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equipcatalog);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.officialsite == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.officialsite);
			}
			if (b.comment == null) {
				pstmt.setNull(5, java.sql.Types.LONGVARCHAR);
			}
			else {
				pstmt.setString(5, b.comment);
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
		EquipManufacturerBean b = (EquipManufacturerBean) eb;
		java.lang.Integer manufid;
		manufid = b.manufid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (manufid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, manufid.intValue());
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
		java.lang.Integer manufid;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(1);
			manufid = resultSet.wasNull() ? null : new Integer(tempint);
			return manufid;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.EquipManufacturer findByPrimaryKey(java.lang.Integer primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.EquipManufacturer) home.activateBean(primaryKey);
	}
}
