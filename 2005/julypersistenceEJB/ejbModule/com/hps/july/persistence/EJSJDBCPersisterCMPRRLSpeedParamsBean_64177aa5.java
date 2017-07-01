package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPRRLSpeedParamsBean_64177aa5
 */
public class EJSJDBCPersisterCMPRRLSpeedParamsBean_64177aa5 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderRRLSpeedParamsBean {
	private static final String _createString = "INSERT INTO rrlspeedparams (rrlspeedid, radiationclass, recvsensitivity, resource, streamspeed) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM rrlspeedparams  WHERE rrlspeedid = ?";
	private static final String _storeString = "UPDATE rrlspeedparams  SET radiationclass = ?, recvsensitivity = ?, resource = ?, streamspeed = ? WHERE rrlspeedid = ?";
	private static final String _loadString = "SELECT T1.rrlspeedid, T1.radiationclass, T1.recvsensitivity, T1.resource, T1.streamspeed FROM rrlspeedparams  T1 WHERE T1.rrlspeedid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPRRLSpeedParamsBean_64177aa5
	 */
	public EJSJDBCPersisterCMPRRLSpeedParamsBean_64177aa5() throws java.rmi.RemoteException {
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
		RRLSpeedParamsBean b = (RRLSpeedParamsBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.rrlspeedid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.radiationclass);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.recvsensitivity == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.recvsensitivity);
			}
			pstmt.setInt(4, b.resource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.streamspeed);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
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
		RRLSpeedParamsBean b = (RRLSpeedParamsBean) eb;
		com.hps.july.persistence.RRLSpeedParamsKey _primaryKey = (com.hps.july.persistence.RRLSpeedParamsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.rrlspeedid = _primaryKey.rrlspeedid;
		b.radiationclass = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.recvsensitivity = resultSet.getBigDecimal(3);
		b.resource = resultSet.getInt(4);
		b.streamspeed = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		RRLSpeedParamsBean b = (RRLSpeedParamsBean) eb;
		com.hps.july.persistence.RRLSpeedParamsKey _primaryKey = (com.hps.july.persistence.RRLSpeedParamsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.rrlspeedid);
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
		RRLSpeedParamsBean b = (RRLSpeedParamsBean) eb;
		com.hps.july.persistence.RRLSpeedParamsKey _primaryKey = new com.hps.july.persistence.RRLSpeedParamsKey();
		_primaryKey.rrlspeedid = b.rrlspeedid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RRLSpeedParamsBean b = (RRLSpeedParamsBean) eb;
		com.hps.july.persistence.RRLSpeedParamsKey _primaryKey = new com.hps.july.persistence.RRLSpeedParamsKey();
		_primaryKey.rrlspeedid = b.rrlspeedid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(5, _primaryKey.rrlspeedid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.radiationclass);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.recvsensitivity == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.recvsensitivity);
			}
			pstmt.setInt(3, b.resource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.streamspeed);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
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
		RRLSpeedParamsBean b = (RRLSpeedParamsBean) eb;
		com.hps.july.persistence.RRLSpeedParamsKey _primaryKey = new com.hps.july.persistence.RRLSpeedParamsKey();
		_primaryKey.rrlspeedid = b.rrlspeedid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.rrlspeedid);
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
		com.hps.july.persistence.RRLSpeedParamsKey key = new com.hps.july.persistence.RRLSpeedParamsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.rrlspeedid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.RRLSpeedParams findByPrimaryKey(com.hps.july.persistence.RRLSpeedParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.RRLSpeedParams) home.activateBean(key);
	}
	/**
	 * findByResourceAndSpeed
	 */
	public EJSFinder findByResourceAndSpeed(int argResource, java.lang.String argStreamSpeed) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.rrlspeedid, T1.radiationclass, T1.recvsensitivity, T1.resource, T1.streamspeed FROM rrlspeedparams  T1 WHERE resource = ? AND streamspeed = ?");
			pstmt.setInt(1, argResource);
			if (argStreamSpeed == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argStreamSpeed);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByResource
	 */
	public EJSFinder findByResource(int argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.rrlspeedid, T1.radiationclass, T1.recvsensitivity, T1.resource, T1.streamspeed FROM rrlspeedparams  T1 WHERE resource = ?");
			pstmt.setInt(1, argResource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
