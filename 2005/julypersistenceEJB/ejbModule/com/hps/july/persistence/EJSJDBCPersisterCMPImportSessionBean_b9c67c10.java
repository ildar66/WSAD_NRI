package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPImportSessionBean_b9c67c10
 */
public class EJSJDBCPersisterCMPImportSessionBean_b9c67c10 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderImportSessionBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO importsessions (impsesid, errcount, filename, filesize, filetime, importend, importstart, reccount, imptaskid, operator) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM importsessions  WHERE impsesid = ?";
	private static final String _storeString = "UPDATE importsessions  SET errcount = ?, filename = ?, filesize = ?, filetime = ?, importend = ?, importstart = ?, reccount = ?, imptaskid = ?, operator = ? WHERE impsesid = ?";
	private static final String _loadString = "SELECT T1.impsesid, T1.errcount, T1.filename, T1.filesize, T1.filetime, T1.importend, T1.importstart, T1.reccount, T1.imptaskid, T1.operator FROM importsessions  T1 WHERE T1.impsesid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPImportSessionBean_b9c67c10
	 */
	public EJSJDBCPersisterCMPImportSessionBean_b9c67c10() throws java.rmi.RemoteException {
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
		ImportSessionBean b = (ImportSessionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.impsesid);
			pstmt.setInt(2, b.errcount);
			if (b.filename == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.filename);
			}
			pstmt.setInt(4, b.filesize);
			if (b.filetime == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.filetime);
			}
			if (b.importend == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.importend);
			}
			if (b.importstart == null) {
				pstmt.setNull(7, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(7, b.importstart);
			}
			pstmt.setInt(8, b.reccount);
			if (b.importtask_imptaskid == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.importtask_imptaskid.intValue());
			}
			if (b.operator_operator == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.operator_operator.intValue());
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
		ImportSessionBean b = (ImportSessionBean) eb;
		com.hps.july.persistence.ImportSessionKey _primaryKey = (com.hps.july.persistence.ImportSessionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.impsesid = _primaryKey.impsesid;
		b.errcount = resultSet.getInt(2);
		b.filename = resultSet.getString(3);
		b.filesize = resultSet.getInt(4);
		b.filetime = resultSet.getTimestamp(5);
		b.importend = resultSet.getTimestamp(6);
		b.importstart = resultSet.getTimestamp(7);
		b.reccount = resultSet.getInt(8);
		tempint = resultSet.getInt(9);
		b.importtask_imptaskid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.operator_operator = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ImportSessionBean b = (ImportSessionBean) eb;
		com.hps.july.persistence.ImportSessionKey _primaryKey = (com.hps.july.persistence.ImportSessionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.impsesid);
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
		ImportSessionBean b = (ImportSessionBean) eb;
		com.hps.july.persistence.ImportSessionKey _primaryKey = new com.hps.july.persistence.ImportSessionKey();
		_primaryKey.impsesid = b.impsesid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ImportSessionBean b = (ImportSessionBean) eb;
		com.hps.july.persistence.ImportSessionKey _primaryKey = new com.hps.july.persistence.ImportSessionKey();
		_primaryKey.impsesid = b.impsesid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(10, _primaryKey.impsesid);
			pstmt.setInt(1, b.errcount);
			if (b.filename == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.filename);
			}
			pstmt.setInt(3, b.filesize);
			if (b.filetime == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.filetime);
			}
			if (b.importend == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.importend);
			}
			if (b.importstart == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.importstart);
			}
			pstmt.setInt(7, b.reccount);
			if (b.importtask_imptaskid == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.importtask_imptaskid.intValue());
			}
			if (b.operator_operator == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.operator_operator.intValue());
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
		ImportSessionBean b = (ImportSessionBean) eb;
		com.hps.july.persistence.ImportSessionKey _primaryKey = new com.hps.july.persistence.ImportSessionKey();
		_primaryKey.impsesid = b.impsesid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.impsesid);
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
		com.hps.july.persistence.ImportSessionKey key = new com.hps.july.persistence.ImportSessionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.impsesid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findImportSessionsByOperator
	 */
	public EJSFinder findImportSessionsByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.impsesid, T1.errcount, T1.filename, T1.filesize, T1.filetime, T1.importend, T1.importstart, T1.reccount, T1.imptaskid, T1.operator FROM importsessions  T1 WHERE T1.operator = ?");
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
	/**
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Boolean isTaskid, java.lang.Integer argTaskId, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, isTaskid, argTaskId, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, order);
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
	public com.hps.july.persistence.ImportSession findByPrimaryKey(com.hps.july.persistence.ImportSessionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ImportSession) home.activateBean(key);
	}
	/**
	 * findImportSessionsByImporttask
	 */
	public EJSFinder findImportSessionsByImporttask(com.hps.july.persistence.ImportTaskKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.impsesid, T1.errcount, T1.filename, T1.filesize, T1.filetime, T1.importend, T1.importstart, T1.reccount, T1.imptaskid, T1.operator FROM importsessions  T1 WHERE T1.imptaskid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.imptaskid);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.impsesid, T1.errcount, T1.filename, T1.filesize, T1.filetime, T1.importend, T1.importstart, T1.reccount, T1.imptaskid, T1.operator FROM importsessions  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {171};
	/**
	 * getMergedPreparedStatement
	 */
	public PreparedStatement getMergedPreparedStatement(String searchCondition) throws Exception {
		StringBuffer sb = new StringBuffer(genericFindSqlString);
		for (int i = 0; i < genericFindInsertPoints.length; i++) {
		   sb.insert(genericFindInsertPoints[i], searchCondition);
		}
		return super.getPreparedStatement(sb.toString());
	}
	/**
	 * getMergedWhereCount
	 */
	public int getMergedWhereCount() {
		return genericFindInsertPoints.length;
	}
	/**
	 * getGenericFindSqlString
	 */
	public String getGenericFindSqlString() {
		return genericFindSqlString;
	}
	/**
	 * getGenericFindInsertPoints
	 */
	public int[] getGenericFindInsertPoints() {
		return genericFindInsertPoints;
	}
	private ImportSessionBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ImportSessionBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ImportSessionBeanFinderObject temp_finderObject = new com.hps.july.persistence.ImportSessionBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
