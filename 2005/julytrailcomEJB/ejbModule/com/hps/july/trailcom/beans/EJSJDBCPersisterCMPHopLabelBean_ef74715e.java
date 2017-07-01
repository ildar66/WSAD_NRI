package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPHopLabelBean_ef74715e
 */
public class EJSJDBCPersisterCMPHopLabelBean_ef74715e extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderHopLabelBean {
	private static final String _createString = "INSERT INTO hopslabel (hopslabelid, hopsname, hopsnamecomments, hopsid) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM hopslabel  WHERE hopslabelid = ?";
	private static final String _storeString = "UPDATE hopslabel  SET hopsname = ?, hopsnamecomments = ?, hopsid = ? WHERE hopslabelid = ?";
	private static final String _loadString = "SELECT T1.hopslabelid, T1.hopsname, T1.hopsnamecomments, T1.hopsid FROM hopslabel  T1 WHERE T1.hopslabelid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPHopLabelBean_ef74715e
	 */
	public EJSJDBCPersisterCMPHopLabelBean_ef74715e() throws java.rmi.RemoteException {
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
		HopLabelBean b = (HopLabelBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.hopslabelid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopsname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopsnamecomments);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.hopid_hopsid == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.hopid_hopsid.intValue());
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
		HopLabelBean b = (HopLabelBean) eb;
		com.hps.july.trailcom.beans.HopLabelKey _primaryKey = (com.hps.july.trailcom.beans.HopLabelKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.hopslabelid = _primaryKey.hopslabelid;
		b.hopsname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.hopsnamecomments = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(4);
		b.hopid_hopsid = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		HopLabelBean b = (HopLabelBean) eb;
		com.hps.july.trailcom.beans.HopLabelKey _primaryKey = (com.hps.july.trailcom.beans.HopLabelKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.hopslabelid);
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
		HopLabelBean b = (HopLabelBean) eb;
		com.hps.july.trailcom.beans.HopLabelKey _primaryKey = new com.hps.july.trailcom.beans.HopLabelKey();
		_primaryKey.hopslabelid = b.hopslabelid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		HopLabelBean b = (HopLabelBean) eb;
		com.hps.july.trailcom.beans.HopLabelKey _primaryKey = new com.hps.july.trailcom.beans.HopLabelKey();
		_primaryKey.hopslabelid = b.hopslabelid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(4, _primaryKey.hopslabelid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopsname);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopsnamecomments);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.hopid_hopsid == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.hopid_hopsid.intValue());
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
		HopLabelBean b = (HopLabelBean) eb;
		com.hps.july.trailcom.beans.HopLabelKey _primaryKey = new com.hps.july.trailcom.beans.HopLabelKey();
		_primaryKey.hopslabelid = b.hopslabelid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.hopslabelid);
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
		com.hps.july.trailcom.beans.HopLabelKey key = new com.hps.july.trailcom.beans.HopLabelKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.hopslabelid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findHopLabelsByHopid
	 */
	public EJSFinder findHopLabelsByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.hopslabelid, T1.hopsname, T1.hopsnamecomments, T1.hopsid FROM hopslabel  T1 WHERE T1.hopsid = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.HopLabel findByPrimaryKey(com.hps.july.trailcom.beans.HopLabelKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.HopLabel) home.activateBean(key);
	}
	/**
	 * findByHopsidOrderByHopslabelidAsc
	 */
	public EJSFinder findByHopsidOrderByHopslabelidAsc(java.lang.Integer hopid) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.hopslabelid, T1.hopsname, T1.hopsnamecomments, T1.hopsid FROM hopslabel  T1 WHERE hopsid = ? order by hopslabelid asc");
			pstmt.setObject(1, hopid);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
