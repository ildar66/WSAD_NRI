package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOperators2RolesBean_a0bb30ab
 */
public class EJSJDBCPersisterCMPOperators2RolesBean_a0bb30ab extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderOperators2RolesBean {
	private static final String _createString = "INSERT INTO operators2roles (operator, role) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM operators2roles  WHERE operator = ? AND role = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.operator, T1.role FROM operators2roles  T1 WHERE T1.operator = ? AND T1.role = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOperators2RolesBean_a0bb30ab
	 */
	public EJSJDBCPersisterCMPOperators2RolesBean_a0bb30ab() throws java.rmi.RemoteException {
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
		Operators2RolesBean b = (Operators2RolesBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.operator_operator == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.operator_operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.role_role);
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
		Operators2RolesBean b = (Operators2RolesBean) eb;
		com.hps.july.persistence.Operators2RolesKey _primaryKey = (com.hps.july.persistence.Operators2RolesKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.operator_operator = _primaryKey.operator_operator;
		b.role_role = _primaryKey.role_role;
		tempint = resultSet.getInt(1);
		b.operator_operator = resultSet.wasNull() ? null : new Integer(tempint);
		b.role_role = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		Operators2RolesBean b = (Operators2RolesBean) eb;
		com.hps.july.persistence.Operators2RolesKey _primaryKey = (com.hps.july.persistence.Operators2RolesKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.operator_operator == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.operator_operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.role_role);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
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
		Operators2RolesBean b = (Operators2RolesBean) eb;
		com.hps.july.persistence.Operators2RolesKey _primaryKey = new com.hps.july.persistence.Operators2RolesKey();
		_primaryKey.operator_operator = b.operator_operator;
		_primaryKey.role_role = b.role_role;
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
		Operators2RolesBean b = (Operators2RolesBean) eb;
		com.hps.july.persistence.Operators2RolesKey _primaryKey = new com.hps.july.persistence.Operators2RolesKey();
		_primaryKey.operator_operator = b.operator_operator;
		_primaryKey.role_role = b.role_role;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.operator_operator == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.operator_operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.role_role);
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
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.Operators2RolesKey key = new com.hps.july.persistence.Operators2RolesKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(1);
			key.operator_operator = resultSet.wasNull() ? null : new Integer(tempint);
			key.role_role = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Operators2Roles findByPrimaryKey(com.hps.july.persistence.Operators2RolesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Operators2Roles) home.activateBean(key);
	}
	/**
	 * findOperators2RolesByRole
	 */
	public EJSFinder findOperators2RolesByRole(com.hps.july.persistence.RoleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.operator, T1.role FROM operators2roles  T1 WHERE T1.role = ?");
			Object objectTemp = null;
boolean nullData;
			nullData = true;   // assuming <parm> == null
			if ( inKey != null) {
				objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(inKey.role);
				nullData = (objectTemp == null);
			}
			if (nullData) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOperators2RolesByOperator
	 */
	public EJSFinder findOperators2RolesByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.operator, T1.role FROM operators2roles  T1 WHERE T1.operator = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.operator);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
