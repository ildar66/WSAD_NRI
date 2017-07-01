package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectTypeBean_35a970e0
 */
public class EJSJDBCPersisterCMPProjectTypeBean_35a970e0 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectTypeBean {
	private static final String _createString = "INSERT INTO projecttypes (projecttype, name) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM projecttypes  WHERE projecttype = ?";
	private static final String _storeString = "UPDATE projecttypes  SET name = ? WHERE projecttype = ?";
	private static final String _loadString = "SELECT T1.projecttype, T1.name FROM projecttypes  T1 WHERE T1.projecttype = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectTypeBean_35a970e0
	 */
	public EJSJDBCPersisterCMPProjectTypeBean_35a970e0() throws java.rmi.RemoteException {
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
		ProjectTypeBean b = (ProjectTypeBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.projecttype);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
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
		ProjectTypeBean b = (ProjectTypeBean) eb;
		com.hps.july.persistence.ProjectTypeKey _primaryKey = (com.hps.july.persistence.ProjectTypeKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.projecttype = _primaryKey.projecttype;
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectTypeBean b = (ProjectTypeBean) eb;
		com.hps.july.persistence.ProjectTypeKey _primaryKey = (com.hps.july.persistence.ProjectTypeKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.projecttype);
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
		ProjectTypeBean b = (ProjectTypeBean) eb;
		com.hps.july.persistence.ProjectTypeKey _primaryKey = new com.hps.july.persistence.ProjectTypeKey();
		_primaryKey.projecttype = b.projecttype;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectTypeBean b = (ProjectTypeBean) eb;
		com.hps.july.persistence.ProjectTypeKey _primaryKey = new com.hps.july.persistence.ProjectTypeKey();
		_primaryKey.projecttype = b.projecttype;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(2, _primaryKey.projecttype);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
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
		ProjectTypeBean b = (ProjectTypeBean) eb;
		com.hps.july.persistence.ProjectTypeKey _primaryKey = new com.hps.july.persistence.ProjectTypeKey();
		_primaryKey.projecttype = b.projecttype;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.projecttype);
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
		com.hps.july.persistence.ProjectTypeKey key = new com.hps.july.persistence.ProjectTypeKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.projecttype = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findAllOrderByCodeAsc
	 */
	public EJSFinder findAllOrderByCodeAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projecttype, T1.name FROM projecttypes  T1 WHERE 1=1 order by projecttype asc");
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
	public com.hps.july.persistence.ProjectType findByPrimaryKey(com.hps.july.persistence.ProjectTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectType) home.activateBean(key);
	}
}
