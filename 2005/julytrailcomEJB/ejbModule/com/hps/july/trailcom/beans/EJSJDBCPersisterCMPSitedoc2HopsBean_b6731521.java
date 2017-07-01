package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSitedoc2HopsBean_b6731521
 */
public class EJSJDBCPersisterCMPSitedoc2HopsBean_b6731521 extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderSitedoc2HopsBean {
	private static final String _createString = "INSERT INTO sitedocs2hops (sitedoc, hopsid) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM sitedocs2hops  WHERE sitedoc = ? AND hopsid = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.sitedoc, T1.hopsid FROM sitedocs2hops  T1 WHERE T1.sitedoc = ? AND T1.hopsid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSitedoc2HopsBean_b6731521
	 */
	public EJSJDBCPersisterCMPSitedoc2HopsBean_b6731521() throws java.rmi.RemoteException {
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
		Sitedoc2HopsBean b = (Sitedoc2HopsBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.sitedoc);
			if (b.hop_hopsid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.hop_hopsid.intValue());
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
		Sitedoc2HopsBean b = (Sitedoc2HopsBean) eb;
		com.hps.july.trailcom.beans.Sitedoc2HopsKey _primaryKey = (com.hps.july.trailcom.beans.Sitedoc2HopsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.sitedoc = _primaryKey.sitedoc;
		b.hop_hopsid = _primaryKey.hop_hopsid;
		tempint = resultSet.getInt(2);
		b.hop_hopsid = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		Sitedoc2HopsBean b = (Sitedoc2HopsBean) eb;
		com.hps.july.trailcom.beans.Sitedoc2HopsKey _primaryKey = (com.hps.july.trailcom.beans.Sitedoc2HopsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.sitedoc);
			if (_primaryKey.hop_hopsid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.hop_hopsid.intValue());
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
		Sitedoc2HopsBean b = (Sitedoc2HopsBean) eb;
		com.hps.july.trailcom.beans.Sitedoc2HopsKey _primaryKey = new com.hps.july.trailcom.beans.Sitedoc2HopsKey();
		_primaryKey.sitedoc = b.sitedoc;
		_primaryKey.hop_hopsid = b.hop_hopsid;
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
		Sitedoc2HopsBean b = (Sitedoc2HopsBean) eb;
		com.hps.july.trailcom.beans.Sitedoc2HopsKey _primaryKey = new com.hps.july.trailcom.beans.Sitedoc2HopsKey();
		_primaryKey.sitedoc = b.sitedoc;
		_primaryKey.hop_hopsid = b.hop_hopsid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.sitedoc);
			if (_primaryKey.hop_hopsid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.hop_hopsid.intValue());
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
		com.hps.july.trailcom.beans.Sitedoc2HopsKey key = new com.hps.july.trailcom.beans.Sitedoc2HopsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.sitedoc = resultSet.getInt(1);
			tempint = resultSet.getInt(2);
			key.hop_hopsid = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.Sitedoc2Hops findByPrimaryKey(com.hps.july.trailcom.beans.Sitedoc2HopsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.Sitedoc2Hops) home.activateBean(key);
	}
	/**
	 * findSitedoc2HopsByHop
	 */
	public EJSFinder findSitedoc2HopsByHop(com.hps.july.trailcom.beans.HopKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedoc, T1.hopsid FROM sitedocs2hops  T1 WHERE T1.hopsid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.hopsid);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findSitedoc2HopsBySitedoc
	 */
	public EJSFinder findSitedoc2HopsBySitedoc(java.lang.Integer sitedoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedoc, T1.hopsid FROM sitedocs2hops  T1 WHERE sitedoc = ?");
			pstmt.setObject(1, sitedoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
