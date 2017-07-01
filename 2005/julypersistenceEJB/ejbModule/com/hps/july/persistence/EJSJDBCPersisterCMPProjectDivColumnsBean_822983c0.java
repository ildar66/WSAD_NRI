package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectDivColumnsBean_822983c0
 */
public class EJSJDBCPersisterCMPProjectDivColumnsBean_822983c0 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectDivColumnsBean {
	private static final String _createString = "INSERT INTO ProjectDivColumns (divcolid, aftercol, colname, projecttype, division) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM ProjectDivColumns  WHERE divcolid = ?";
	private static final String _storeString = "UPDATE ProjectDivColumns  SET aftercol = ?, colname = ?, projecttype = ?, division = ? WHERE divcolid = ?";
	private static final String _loadString = "SELECT T1.divcolid, T1.aftercol, T1.colname, T1.projecttype, T1.division FROM ProjectDivColumns  T1 WHERE T1.divcolid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectDivColumnsBean_822983c0
	 */
	public EJSJDBCPersisterCMPProjectDivColumnsBean_822983c0() throws java.rmi.RemoteException {
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
		ProjectDivColumnsBean b = (ProjectDivColumnsBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.divcolid);
			pstmt.setInt(2, b.aftercol);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.colname);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.projectType_projecttype == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.projectType_projecttype.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.division_division.intValue());
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
		ProjectDivColumnsBean b = (ProjectDivColumnsBean) eb;
		com.hps.july.persistence.ProjectDivColumnsKey _primaryKey = (com.hps.july.persistence.ProjectDivColumnsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.divcolid = _primaryKey.divcolid;
		b.aftercol = resultSet.getInt(2);
		b.colname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(4);
		b.projectType_projecttype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.division_division = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectDivColumnsBean b = (ProjectDivColumnsBean) eb;
		com.hps.july.persistence.ProjectDivColumnsKey _primaryKey = (com.hps.july.persistence.ProjectDivColumnsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.divcolid);
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
		ProjectDivColumnsBean b = (ProjectDivColumnsBean) eb;
		com.hps.july.persistence.ProjectDivColumnsKey _primaryKey = new com.hps.july.persistence.ProjectDivColumnsKey();
		_primaryKey.divcolid = b.divcolid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectDivColumnsBean b = (ProjectDivColumnsBean) eb;
		com.hps.july.persistence.ProjectDivColumnsKey _primaryKey = new com.hps.july.persistence.ProjectDivColumnsKey();
		_primaryKey.divcolid = b.divcolid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(5, _primaryKey.divcolid);
			pstmt.setInt(1, b.aftercol);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.colname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.projectType_projecttype == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.projectType_projecttype.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.division_division.intValue());
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
		ProjectDivColumnsBean b = (ProjectDivColumnsBean) eb;
		com.hps.july.persistence.ProjectDivColumnsKey _primaryKey = new com.hps.july.persistence.ProjectDivColumnsKey();
		_primaryKey.divcolid = b.divcolid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.divcolid);
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
		com.hps.july.persistence.ProjectDivColumnsKey key = new com.hps.july.persistence.ProjectDivColumnsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.divcolid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findProjectDivColumnsByDivision
	 */
	public EJSFinder findProjectDivColumnsByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.divcolid, T1.aftercol, T1.colname, T1.projecttype, T1.division FROM ProjectDivColumns  T1 WHERE T1.division = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.division);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByColDivisionActtypeOrderByAfterColAsc
	 */
	public EJSFinder findByColDivisionActtypeOrderByAfterColAsc(java.lang.Integer argAfterCol, java.lang.Integer argDivision, java.lang.Integer argProjectType) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.divcolid, T1.aftercol, T1.colname, T1.projecttype, T1.division FROM ProjectDivColumns  T1 WHERE aftercol = ? and division = ? and projecttype = ? order by aftercol asc");
			pstmt.setObject(1, argAfterCol);
			pstmt.setObject(2, argDivision);
			pstmt.setObject(3, argProjectType);
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
	public com.hps.july.persistence.ProjectDivColumns findByPrimaryKey(com.hps.july.persistence.ProjectDivColumnsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectDivColumns) home.activateBean(key);
	}
	/**
	 * findProjectDivColumnsByProjectType
	 */
	public EJSFinder findProjectDivColumnsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.divcolid, T1.aftercol, T1.colname, T1.projecttype, T1.division FROM ProjectDivColumns  T1 WHERE T1.projecttype = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.projecttype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
