package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPRoleBean_745b5a02
 */
public class EJSJDBCPersisterCMPRoleBean_745b5a02 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderRoleBean {
	private static final String _createString = "INSERT INTO roles (role, rolename) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM roles  WHERE role = ?";
	private static final String _storeString = "UPDATE roles  SET rolename = ? WHERE role = ?";
	private static final String _loadString = "SELECT T1.role, T1.rolename FROM roles  T1 WHERE T1.role = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPRoleBean_745b5a02
	 */
	public EJSJDBCPersisterCMPRoleBean_745b5a02() throws java.rmi.RemoteException {
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
		RoleBean b = (RoleBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.role);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rolename);
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
		RoleBean b = (RoleBean) eb;
		com.hps.july.persistence.RoleKey _primaryKey = (com.hps.july.persistence.RoleKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.role = _primaryKey.role;
		b.rolename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		RoleBean b = (RoleBean) eb;
		com.hps.july.persistence.RoleKey _primaryKey = (com.hps.july.persistence.RoleKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.role);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
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
		RoleBean b = (RoleBean) eb;
		com.hps.july.persistence.RoleKey _primaryKey = new com.hps.july.persistence.RoleKey();
		_primaryKey.role = b.role;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RoleBean b = (RoleBean) eb;
		com.hps.july.persistence.RoleKey _primaryKey = new com.hps.july.persistence.RoleKey();
		_primaryKey.role = b.role;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.role);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rolename);
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
		RoleBean b = (RoleBean) eb;
		com.hps.july.persistence.RoleKey _primaryKey = new com.hps.july.persistence.RoleKey();
		_primaryKey.role = b.role;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.role);
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
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.RoleKey key = new com.hps.july.persistence.RoleKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.role = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Role findByPrimaryKey(com.hps.july.persistence.RoleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Role) home.activateBean(key);
	}
	/**
	 * findAll
	 */
	public EJSFinder findAll() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.role, T1.rolename FROM roles  T1 WHERE role=role");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
