package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectActionTypeBean_c8c0ae31
 */
public class EJSJDBCPersisterCMPProjectActionTypeBean_c8c0ae31 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectActionTypeBean {
	private static final String _createString = "INSERT INTO projectactiontypes (projectactiontype, result, equiptype, name, division, typeresponsibility) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM projectactiontypes  WHERE projectactiontype = ?";
	private static final String _storeString = "UPDATE projectactiontypes  SET result = ?, equiptype = ?, name = ?, division = ?, typeresponsibility = ? WHERE projectactiontype = ?";
	private static final String _loadString = "SELECT T1.result, T1.equiptype, T1.name, T1.projectactiontype, T1.division, T1.typeresponsibility FROM projectactiontypes  T1 WHERE T1.projectactiontype = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectActionTypeBean_c8c0ae31
	 */
	public EJSJDBCPersisterCMPProjectActionTypeBean_c8c0ae31() throws java.rmi.RemoteException {
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
		ProjectActionTypeBean b = (ProjectActionTypeBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.result);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equiptype);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.projectactiontype);
			if (b.action2division_division == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.action2division_division.intValue());
			}
			if (b.responsibilitytype_responsibilityType == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.responsibilitytype_responsibilityType.intValue());
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
		ProjectActionTypeBean b = (ProjectActionTypeBean) eb;
		com.hps.july.persistence.ProjectActionTypeKey _primaryKey = (com.hps.july.persistence.ProjectActionTypeKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.projectactiontype = _primaryKey.projectactiontype;
		b.result = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.equiptype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(5);
		b.action2division_division = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.responsibilitytype_responsibilityType = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectActionTypeBean b = (ProjectActionTypeBean) eb;
		com.hps.july.persistence.ProjectActionTypeKey _primaryKey = (com.hps.july.persistence.ProjectActionTypeKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.projectactiontype);
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
		ProjectActionTypeBean b = (ProjectActionTypeBean) eb;
		com.hps.july.persistence.ProjectActionTypeKey _primaryKey = new com.hps.july.persistence.ProjectActionTypeKey();
		_primaryKey.projectactiontype = b.projectactiontype;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectActionTypeBean b = (ProjectActionTypeBean) eb;
		com.hps.july.persistence.ProjectActionTypeKey _primaryKey = new com.hps.july.persistence.ProjectActionTypeKey();
		_primaryKey.projectactiontype = b.projectactiontype;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(6, _primaryKey.projectactiontype);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.result);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equiptype);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.action2division_division == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.action2division_division.intValue());
			}
			if (b.responsibilitytype_responsibilityType == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.responsibilitytype_responsibilityType.intValue());
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
		ProjectActionTypeBean b = (ProjectActionTypeBean) eb;
		com.hps.july.persistence.ProjectActionTypeKey _primaryKey = new com.hps.july.persistence.ProjectActionTypeKey();
		_primaryKey.projectactiontype = b.projectactiontype;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.projectactiontype);
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
		com.hps.july.persistence.ProjectActionTypeKey key = new com.hps.july.persistence.ProjectActionTypeKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.projectactiontype = resultSet.getInt(4);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectActionType findByPrimaryKey(com.hps.july.persistence.ProjectActionTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectActionType) home.activateBean(key);
	}
	/**
	 * findProjectActionTypesByResponsibilitytype
	 */
	public EJSFinder findProjectActionTypesByResponsibilitytype(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.result, T1.equiptype, T1.name, T1.projectactiontype, T1.division, T1.typeresponsibility FROM projectactiontypes  T1 WHERE T1.typeresponsibility = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.responsibilityType);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByProjecttypeOrderByCodeAsc
	 */
	public EJSFinder findByProjecttypeOrderByCodeAsc(java.lang.Integer argProjectType, java.lang.Integer argProjectActionType) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.result, T1.equiptype, T1.name, T1.projectactiontype, T1.division, T1.typeresponsibility FROM projectactiontypes  T1 WHERE projectactiontype NOT IN (SELECT A.projectactiontype  FROM  projectactiontypes A, protoactions B  WHERE A.projectactiontype=B.projectactiontype   AND B.projecttype=?)  OR projectactiontype=? ORDER BY projectactiontype ASC");
			pstmt.setObject(1, argProjectType);
			pstmt.setObject(2, argProjectActionType);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectActionTypesByAction2division
	 */
	public EJSFinder findProjectActionTypesByAction2division(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.result, T1.equiptype, T1.name, T1.projectactiontype, T1.division, T1.typeresponsibility FROM projectactiontypes  T1 WHERE T1.division = ?");
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
	 * findAllOrderByCodeAsc
	 */
	public EJSFinder findAllOrderByCodeAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.result, T1.equiptype, T1.name, T1.projectactiontype, T1.division, T1.typeresponsibility FROM projectactiontypes  T1 WHERE 1=1 order by projectactiontype asc");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
