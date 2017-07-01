package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectDivColValBean_8858482b
 */
public class EJSJDBCPersisterCMPProjectDivColValBean_8858482b extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectDivColValBean {
	private static final String _createString = "INSERT INTO projectdivcolvals (divcolid, project, colvalue) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM projectdivcolvals  WHERE divcolid = ? AND project = ?";
	private static final String _storeString = "UPDATE projectdivcolvals  SET colvalue = ? WHERE divcolid = ? AND project = ?";
	private static final String _loadString = "SELECT T1.colvalue, T1.divcolid, T1.project FROM projectdivcolvals  T1 WHERE T1.divcolid = ? AND T1.project = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectDivColValBean_8858482b
	 */
	public EJSJDBCPersisterCMPProjectDivColValBean_8858482b() throws java.rmi.RemoteException {
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
		ProjectDivColValBean b = (ProjectDivColValBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.colvalue == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.colvalue);
			}
			if (b.projectDivColumn_divcolid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.projectDivColumn_divcolid.intValue());
			}
			if (b.project_project == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.project_project.intValue());
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
		ProjectDivColValBean b = (ProjectDivColValBean) eb;
		com.hps.july.persistence.ProjectDivColValKey _primaryKey = (com.hps.july.persistence.ProjectDivColValKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.projectDivColumn_divcolid = _primaryKey.projectDivColumn_divcolid;
		b.project_project = _primaryKey.project_project;
		b.colvalue = resultSet.getString(1);
		tempint = resultSet.getInt(2);
		b.projectDivColumn_divcolid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.project_project = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectDivColValBean b = (ProjectDivColValBean) eb;
		com.hps.july.persistence.ProjectDivColValKey _primaryKey = (com.hps.july.persistence.ProjectDivColValKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.projectDivColumn_divcolid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.projectDivColumn_divcolid.intValue());
			}
			if (_primaryKey.project_project == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.project_project.intValue());
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
		ProjectDivColValBean b = (ProjectDivColValBean) eb;
		com.hps.july.persistence.ProjectDivColValKey _primaryKey = new com.hps.july.persistence.ProjectDivColValKey();
		_primaryKey.projectDivColumn_divcolid = b.projectDivColumn_divcolid;
		_primaryKey.project_project = b.project_project;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectDivColValBean b = (ProjectDivColValBean) eb;
		com.hps.july.persistence.ProjectDivColValKey _primaryKey = new com.hps.july.persistence.ProjectDivColValKey();
		_primaryKey.projectDivColumn_divcolid = b.projectDivColumn_divcolid;
		_primaryKey.project_project = b.project_project;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.projectDivColumn_divcolid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.projectDivColumn_divcolid.intValue());
			}
			if (_primaryKey.project_project == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.project_project.intValue());
			}
			if (b.colvalue == null) {
				pstmt.setNull(1, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(1, b.colvalue);
			}
			if (b.projectDivColumn_divcolid == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.projectDivColumn_divcolid.intValue());
			}
			if (b.project_project == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.project_project.intValue());
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
		ProjectDivColValBean b = (ProjectDivColValBean) eb;
		com.hps.july.persistence.ProjectDivColValKey _primaryKey = new com.hps.july.persistence.ProjectDivColValKey();
		_primaryKey.projectDivColumn_divcolid = b.projectDivColumn_divcolid;
		_primaryKey.project_project = b.project_project;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.projectDivColumn_divcolid == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.projectDivColumn_divcolid.intValue());
			}
			if (_primaryKey.project_project == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.project_project.intValue());
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
		com.hps.july.persistence.ProjectDivColValKey key = new com.hps.july.persistence.ProjectDivColValKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.projectDivColumn_divcolid = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.project_project = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectDivColVal findByPrimaryKey(com.hps.july.persistence.ProjectDivColValKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectDivColVal) home.activateBean(key);
	}
	/**
	 * findProjectDivColValsByProjectDivColumn
	 */
	public EJSFinder findProjectDivColValsByProjectDivColumn(com.hps.july.persistence.ProjectDivColumnsKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.colvalue, T1.divcolid, T1.project FROM projectdivcolvals  T1 WHERE T1.divcolid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.divcolid);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectDivColValsByProject
	 */
	public EJSFinder findProjectDivColValsByProject(com.hps.july.persistence.ProjectKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.colvalue, T1.divcolid, T1.project FROM projectdivcolvals  T1 WHERE T1.project = ?");
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
}
