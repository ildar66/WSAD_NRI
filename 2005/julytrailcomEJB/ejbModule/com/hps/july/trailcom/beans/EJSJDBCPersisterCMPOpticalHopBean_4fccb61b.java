package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOpticalHopBean_4fccb61b
 */
public class EJSJDBCPersisterCMPOpticalHopBean_4fccb61b extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderOpticalHopBean {
	private static final String _createString = "INSERT INTO opticalhops (hopsid, hopscomment) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM opticalhops  WHERE hopsid = ?";
	private static final String _storeString = "UPDATE opticalhops  SET hopscomment = ? WHERE hopsid = ?";
	private static final String _loadString = "SELECT T1.hopscomment, T1.hopsid FROM opticalhops  T1 WHERE T1.hopsid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOpticalHopBean_4fccb61b
	 */
	public EJSJDBCPersisterCMPOpticalHopBean_4fccb61b() throws java.rmi.RemoteException {
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
		OpticalHopBean b = (OpticalHopBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopscomment);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
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
		OpticalHopBean b = (OpticalHopBean) eb;
		com.hps.july.trailcom.beans.OpticalHopKey _primaryKey = (com.hps.july.trailcom.beans.OpticalHopKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.hopid_hopsid = _primaryKey.hopid_hopsid;
		b.hopscomment = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		tempint = resultSet.getInt(2);
		b.hopid_hopsid = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		OpticalHopBean b = (OpticalHopBean) eb;
		com.hps.july.trailcom.beans.OpticalHopKey _primaryKey = (com.hps.july.trailcom.beans.OpticalHopKey)pKey;
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
		OpticalHopBean b = (OpticalHopBean) eb;
		com.hps.july.trailcom.beans.OpticalHopKey _primaryKey = new com.hps.july.trailcom.beans.OpticalHopKey();
		_primaryKey.hopid_hopsid = b.hopid_hopsid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		OpticalHopBean b = (OpticalHopBean) eb;
		com.hps.july.trailcom.beans.OpticalHopKey _primaryKey = new com.hps.july.trailcom.beans.OpticalHopKey();
		_primaryKey.hopid_hopsid = b.hopid_hopsid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.hopid_hopsid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.hopid_hopsid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopscomment);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.hopid_hopsid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.hopid_hopsid.intValue());
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
		OpticalHopBean b = (OpticalHopBean) eb;
		com.hps.july.trailcom.beans.OpticalHopKey _primaryKey = new com.hps.july.trailcom.beans.OpticalHopKey();
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
		com.hps.july.trailcom.beans.OpticalHopKey key = new com.hps.july.trailcom.beans.OpticalHopKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.hopid_hopsid = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findOpticalHopByHopid
	 */
	public com.hps.july.trailcom.beans.OpticalHop findOpticalHopByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.trailcom.beans.OpticalHop result = null;
		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.hopscomment, T1.hopsid FROM opticalhops  T1 WHERE T1.hopsid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.hopsid);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.trailcom.beans.OpticalHop)tmpFinder.nextElement();
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
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.OpticalHop findByPrimaryKey(com.hps.july.trailcom.beans.OpticalHopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.OpticalHop) home.activateBean(key);
	}
}
