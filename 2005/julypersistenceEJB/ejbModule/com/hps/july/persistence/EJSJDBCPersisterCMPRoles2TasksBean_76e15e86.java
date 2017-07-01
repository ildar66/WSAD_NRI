package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPRoles2TasksBean_76e15e86
 */
public class EJSJDBCPersisterCMPRoles2TasksBean_76e15e86 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderRoles2TasksBean {
	private static final String _createString = "INSERT INTO roles2tasks (role, task) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM roles2tasks  WHERE role = ? AND task = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.role, T1.task FROM roles2tasks  T1 WHERE T1.role = ? AND T1.task = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPRoles2TasksBean_76e15e86
	 */
	public EJSJDBCPersisterCMPRoles2TasksBean_76e15e86() throws java.rmi.RemoteException {
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
		Roles2TasksBean b = (Roles2TasksBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.role_role);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.task_task == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.task_task.intValue());
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
		Roles2TasksBean b = (Roles2TasksBean) eb;
		com.hps.july.persistence.Roles2TasksKey _primaryKey = (com.hps.july.persistence.Roles2TasksKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.role_role = _primaryKey.role_role;
		b.task_task = _primaryKey.task_task;
		b.role_role = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		tempint = resultSet.getInt(2);
		b.task_task = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		Roles2TasksBean b = (Roles2TasksBean) eb;
		com.hps.july.persistence.Roles2TasksKey _primaryKey = (com.hps.july.persistence.Roles2TasksKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.role_role);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (_primaryKey.task_task == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.task_task.intValue());
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
		Roles2TasksBean b = (Roles2TasksBean) eb;
		com.hps.july.persistence.Roles2TasksKey _primaryKey = new com.hps.july.persistence.Roles2TasksKey();
		_primaryKey.role_role = b.role_role;
		_primaryKey.task_task = b.task_task;
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
		Roles2TasksBean b = (Roles2TasksBean) eb;
		com.hps.july.persistence.Roles2TasksKey _primaryKey = new com.hps.july.persistence.Roles2TasksKey();
		_primaryKey.role_role = b.role_role;
		_primaryKey.task_task = b.task_task;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.role_role);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (_primaryKey.task_task == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.task_task.intValue());
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
		com.hps.july.persistence.Roles2TasksKey key = new com.hps.july.persistence.Roles2TasksKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.role_role = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
			tempint = resultSet.getInt(2);
			key.task_task = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findRoles2TasksByRoleString
	 */
	public EJSFinder findRoles2TasksByRoleString(java.lang.String role) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.role, T1.task FROM roles2tasks  T1 WHERE role=?");
			if (role == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, role);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findTasksByRole
	 */
	public EJSFinder findTasksByRole(com.hps.july.persistence.RoleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.role, T1.task FROM roles2tasks  T1 WHERE T1.role = ?");
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
	 * findRoleByTask
	 */
	public EJSFinder findRoleByTask(com.hps.july.persistence.TaskKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.role, T1.task FROM roles2tasks  T1 WHERE T1.task = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.task);
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
	public com.hps.july.persistence.Roles2Tasks findByPrimaryKey(com.hps.july.persistence.Roles2TasksKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Roles2Tasks) home.activateBean(key);
	}
}
