package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSitedoc2SplaceBean_5aa991cc
 */
public class EJSJDBCPersisterCMPSitedoc2SplaceBean_5aa991cc extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSitedoc2SplaceBean {
	private static final String _createString = "INSERT INTO sitedocs2splace (sitedoc, storageplace) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM sitedocs2splace  WHERE sitedoc = ? AND storageplace = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.sitedoc, T1.storageplace FROM sitedocs2splace  T1 WHERE T1.sitedoc = ? AND T1.storageplace = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSitedoc2SplaceBean_5aa991cc
	 */
	public EJSJDBCPersisterCMPSitedoc2SplaceBean_5aa991cc() throws java.rmi.RemoteException {
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
		Sitedoc2SplaceBean b = (Sitedoc2SplaceBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.siteDoc_sitedoc == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.siteDoc_sitedoc.intValue());
			}
			if (b.storagePlace_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.storagePlace_storageplace.intValue());
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
		Sitedoc2SplaceBean b = (Sitedoc2SplaceBean) eb;
		com.hps.july.persistence.Sitedoc2SplaceKey _primaryKey = (com.hps.july.persistence.Sitedoc2SplaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.siteDoc_sitedoc = _primaryKey.siteDoc_sitedoc;
		b.storagePlace_storageplace = _primaryKey.storagePlace_storageplace;
		tempint = resultSet.getInt(1);
		b.siteDoc_sitedoc = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.storagePlace_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		Sitedoc2SplaceBean b = (Sitedoc2SplaceBean) eb;
		com.hps.july.persistence.Sitedoc2SplaceKey _primaryKey = (com.hps.july.persistence.Sitedoc2SplaceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.siteDoc_sitedoc == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.siteDoc_sitedoc.intValue());
			}
			if (_primaryKey.storagePlace_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.storagePlace_storageplace.intValue());
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
		Sitedoc2SplaceBean b = (Sitedoc2SplaceBean) eb;
		com.hps.july.persistence.Sitedoc2SplaceKey _primaryKey = new com.hps.july.persistence.Sitedoc2SplaceKey();
		_primaryKey.siteDoc_sitedoc = b.siteDoc_sitedoc;
		_primaryKey.storagePlace_storageplace = b.storagePlace_storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		return;
	}
	/**
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		Sitedoc2SplaceBean b = (Sitedoc2SplaceBean) eb;
		com.hps.july.persistence.Sitedoc2SplaceKey _primaryKey = new com.hps.july.persistence.Sitedoc2SplaceKey();
		_primaryKey.siteDoc_sitedoc = b.siteDoc_sitedoc;
		_primaryKey.storagePlace_storageplace = b.storagePlace_storageplace;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.siteDoc_sitedoc == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.siteDoc_sitedoc.intValue());
			}
			if (_primaryKey.storagePlace_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.storagePlace_storageplace.intValue());
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
		com.hps.july.persistence.Sitedoc2SplaceKey key = new com.hps.july.persistence.Sitedoc2SplaceKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(1);
			key.siteDoc_sitedoc = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(2);
			key.storagePlace_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findSitedoc2SplacesByStoragePlace
	 */
	public EJSFinder findSitedoc2SplacesByStoragePlace(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedoc, T1.storageplace FROM sitedocs2splace  T1 WHERE T1.storageplace = ?");
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
	 * findSitedoc2SplacesBySiteDoc
	 */
	public EJSFinder findSitedoc2SplacesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedoc, T1.storageplace FROM sitedocs2splace  T1 WHERE T1.sitedoc = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.sitedoc);
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
	public com.hps.july.persistence.Sitedoc2Splace findByPrimaryKey(com.hps.july.persistence.Sitedoc2SplaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Sitedoc2Splace) home.activateBean(key);
	}
}
