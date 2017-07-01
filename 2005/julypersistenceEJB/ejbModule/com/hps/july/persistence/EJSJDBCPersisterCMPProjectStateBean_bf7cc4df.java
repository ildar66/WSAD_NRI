package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectStateBean_bf7cc4df
 */
public class EJSJDBCPersisterCMPProjectStateBean_bf7cc4df extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectStateBean {
	private static final String _createString = "INSERT INTO projectstates (projectstate, state, when, man, project) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM projectstates  WHERE projectstate = ?";
	private static final String _storeString = "UPDATE projectstates  SET state = ?, when = ?, man = ?, project = ? WHERE projectstate = ?";
	private static final String _loadString = "SELECT T1.projectstate, T1.state, T1.when, T1.man, T1.project FROM projectstates  T1 WHERE T1.projectstate = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectStateBean_bf7cc4df
	 */
	public EJSJDBCPersisterCMPProjectStateBean_bf7cc4df() throws java.rmi.RemoteException {
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
		ProjectStateBean b = (ProjectStateBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.projectstate);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.when == null) {
				pstmt.setNull(3, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(3, b.when);
			}
			if (b.man_man == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.man_man.intValue());
			}
			if (b.project_project == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.project_project.intValue());
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
		ProjectStateBean b = (ProjectStateBean) eb;
		com.hps.july.persistence.ProjectStateKey _primaryKey = (com.hps.july.persistence.ProjectStateKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.projectstate = _primaryKey.projectstate;
		b.state = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.when = resultSet.getTimestamp(3);
		tempint = resultSet.getInt(4);
		b.man_man = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.project_project = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectStateBean b = (ProjectStateBean) eb;
		com.hps.july.persistence.ProjectStateKey _primaryKey = (com.hps.july.persistence.ProjectStateKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.projectstate);
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
		ProjectStateBean b = (ProjectStateBean) eb;
		com.hps.july.persistence.ProjectStateKey _primaryKey = new com.hps.july.persistence.ProjectStateKey();
		_primaryKey.projectstate = b.projectstate;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectStateBean b = (ProjectStateBean) eb;
		com.hps.july.persistence.ProjectStateKey _primaryKey = new com.hps.july.persistence.ProjectStateKey();
		_primaryKey.projectstate = b.projectstate;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(5, _primaryKey.projectstate);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.when == null) {
				pstmt.setNull(2, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(2, b.when);
			}
			if (b.man_man == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.man_man.intValue());
			}
			if (b.project_project == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.project_project.intValue());
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
		ProjectStateBean b = (ProjectStateBean) eb;
		com.hps.july.persistence.ProjectStateKey _primaryKey = new com.hps.july.persistence.ProjectStateKey();
		_primaryKey.projectstate = b.projectstate;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.projectstate);
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
		com.hps.july.persistence.ProjectStateKey key = new com.hps.july.persistence.ProjectStateKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.projectstate = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectState findByPrimaryKey(com.hps.july.persistence.ProjectStateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectState) home.activateBean(key);
	}
	/**
	 * findCurrentForProject
	 */
	public com.hps.july.persistence.ProjectState findCurrentForProject(java.lang.Integer argProject) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.ProjectState result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectstate, T1.state, T1.when, T1.man, T1.project FROM projectstates  T1 WHERE projectstate = (SELECT max(projectstate)  FROM projectstates p WHERE p.project = ? )");
			pstmt.setObject(1, argProject);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.ProjectState)tmpFinder.nextElement();
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
	 * findProjectStatesByProject
	 */
	public EJSFinder findProjectStatesByProject(com.hps.july.persistence.ProjectKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectstate, T1.state, T1.when, T1.man, T1.project FROM projectstates  T1 WHERE T1.project = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.project);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectStatesByMan
	 */
	public EJSFinder findProjectStatesByMan(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectstate, T1.state, T1.when, T1.man, T1.project FROM projectstates  T1 WHERE T1.man = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.man);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
