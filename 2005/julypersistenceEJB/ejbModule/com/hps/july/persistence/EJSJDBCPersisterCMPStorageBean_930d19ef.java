package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPStorageBean_930d19ef
 */
public class EJSJDBCPersisterCMPStorageBean_930d19ef extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderStorageBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO storageplaces (storageplace, closedate, address, operator, name, modified, created, modifiedby, createdby, division, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO storages (storageplace, pstnphone, internalphone, regionid) VALUES (?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM storages  WHERE storageplace = ?", "DELETE FROM storageplaces  WHERE storageplace = ?"};
	private static final String[] _storeString = {"UPDATE storages  SET pstnphone = ?, internalphone = ?, regionid = ? WHERE storageplace = ?", "UPDATE storageplaces  SET closedate = ?, address = ?, operator = ?, name = ?, modified = ?, created = ?, modifiedby = ?, createdby = ?, division = ?, type = ? WHERE storageplace = ?"};
	private static final String _loadString = "SELECT T1.closedate, T1.address, T1.operator, T1.name, T1.storageplace, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.division, T1.type, T2.pstnphone, T2.internalphone, T2.regionid FROM storageplaces  T1, storages  T2 WHERE T1.type = \'S\' AND T1.storageplace = T2.storageplace AND T1.storageplace = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPStorageBean_930d19ef
	 */
	public EJSJDBCPersisterCMPStorageBean_930d19ef() throws java.rmi.RemoteException {
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
		StorageBean b = (StorageBean) eb;
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
			pstmt.setString(11, "S");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pstnphone);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.internalphone);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setInt(4, b.regionid);
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
		StorageBean b = (StorageBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.storageplace = _primaryKey.storageplace;
		b.pstnphone = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.internalphone = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.regionid = resultSet.getInt(14);
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
		StorageBean b = (StorageBean) eb;
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
		StorageBean b = (StorageBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		StorageBean b = (StorageBean) eb;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = new com.hps.july.persistence.StoragePlaceKey();
		_primaryKey.storageplace = b.storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(4, _primaryKey.storageplace);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pstnphone);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.internalphone);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			pstmt.setInt(3, b.regionid);
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
			pstmt.setString(10, "S");
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
		StorageBean b = (StorageBean) eb;
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
		if ( discriminator.equals("S") ) {
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
	 * findByPlatinumAndStatus
	 */
	public EJSFinder findByPlatinumAndStatus(java.lang.Integer owner, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByPlatinumAndStatus(owner, state, order);
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
	public com.hps.july.persistence.Storage findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Storage result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.StoragePlaceKey _primaryKey = (com.hps.july.persistence.StoragePlaceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.Storage)home.getBean(key);
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
					result = (com.hps.july.persistence.Storage)tmpFinder.nextElement();
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
	private static final String genericFindSqlString = "SELECT T1.closedate, T1.address, T1.operator, T1.name, T1.storageplace, T1.modified, T1.created, T1.modifiedby, T1.createdby, T1.division, T1.type, T2.pstnphone, T2.internalphone, T2.regionid FROM storageplaces  T1, storages  T2 WHERE T1.type = \'S\' AND T1.storageplace = T2.storageplace AND ";
	private static final int[] genericFindInsertPoints = {291};
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
	private StorageBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.StorageBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.StorageBeanFinderObject temp_finderObject = new com.hps.july.persistence.StorageBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
