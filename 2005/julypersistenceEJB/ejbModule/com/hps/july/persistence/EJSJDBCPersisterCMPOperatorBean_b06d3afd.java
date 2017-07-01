package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOperatorBean_b06d3afd
 */
public class EJSJDBCPersisterCMPOperatorBean_b06d3afd extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderOperatorBean {
	private static final String _createString = "INSERT INTO operators (operator, password, loiginid, isenabled, msucode, oldpwd, man) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM operators  WHERE operator = ?";
	private static final String _storeString = "UPDATE operators  SET password = ?, loiginid = ?, isenabled = ?, msucode = ?, oldpwd = ?, man = ? WHERE operator = ?";
	private static final String _loadString = "SELECT T1.password, T1.loiginid, T1.operator, T1.isenabled, T1.msucode, T1.oldpwd, T1.man FROM operators  T1 WHERE T1.operator = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOperatorBean_b06d3afd
	 */
	public EJSJDBCPersisterCMPOperatorBean_b06d3afd() throws java.rmi.RemoteException {
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
		OperatorBean b = (OperatorBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.password);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.login);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.operator);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.enabled);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.msucode == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.msucode.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldpwd);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.man_man == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.man_man.intValue());
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
		OperatorBean b = (OperatorBean) eb;
		com.hps.july.persistence.OperatorKey _primaryKey = (com.hps.july.persistence.OperatorKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.operator = _primaryKey.operator;
		b.password = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.login = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.enabled = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		tempint = resultSet.getInt(5);
		b.msucode = resultSet.wasNull() ? null : new Integer(tempint);
		b.oldpwd = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		tempint = resultSet.getInt(7);
		b.man_man = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		OperatorBean b = (OperatorBean) eb;
		com.hps.july.persistence.OperatorKey _primaryKey = (com.hps.july.persistence.OperatorKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.operator);
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
		OperatorBean b = (OperatorBean) eb;
		com.hps.july.persistence.OperatorKey _primaryKey = new com.hps.july.persistence.OperatorKey();
		_primaryKey.operator = b.operator;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		OperatorBean b = (OperatorBean) eb;
		com.hps.july.persistence.OperatorKey _primaryKey = new com.hps.july.persistence.OperatorKey();
		_primaryKey.operator = b.operator;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(7, _primaryKey.operator);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.password);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.login);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.enabled);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.msucode == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.msucode.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldpwd);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.man_man == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.man_man.intValue());
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
		OperatorBean b = (OperatorBean) eb;
		com.hps.july.persistence.OperatorKey _primaryKey = new com.hps.july.persistence.OperatorKey();
		_primaryKey.operator = b.operator;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.operator);
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
		com.hps.july.persistence.OperatorKey key = new com.hps.july.persistence.OperatorKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.operator = resultSet.getInt(3);
			return key;
		}
return null;
	}
	/**
	 * findOperatorsByMan
	 */
	public EJSFinder findOperatorsByMan(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.password, T1.loiginid, T1.operator, T1.isenabled, T1.msucode, T1.oldpwd, T1.man FROM operators  T1 WHERE T1.man = ?");
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
	/**
	 * findOperatorByLastNameOrderByLoginAsc
	 */
	public EJSFinder findOperatorByLastNameOrderByLoginAsc(java.lang.String lastName) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.password, T1.loiginid, T1.operator, T1.isenabled, T1.msucode, T1.oldpwd, T1.man FROM operators  T1 WHERE  man IN (SELECT man FROM people WHERE upper(lastName) matches upper(?)) ORDER BY loiginid ASC");
			if (lastName == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, lastName);
			}
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
	public com.hps.july.persistence.Operator findByPrimaryKey(com.hps.july.persistence.OperatorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Operator) home.activateBean(key);
	}
	/**
	 * findByLogin
	 */
	public com.hps.july.persistence.Operator findByLogin(java.lang.String login) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Operator result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.password, T1.loiginid, T1.operator, T1.isenabled, T1.msucode, T1.oldpwd, T1.man FROM operators  T1 WHERE  loiginid=?");
			if (login == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, login);
			}
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.Operator)tmpFinder.nextElement();
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
	 * findOperatorsWithImportSessions
	 */
	public EJSFinder findOperatorsWithImportSessions() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.password, T1.loiginid, T1.operator, T1.isenabled, T1.msucode, T1.oldpwd, T1.man FROM operators  T1 WHERE  operator IN (SELECT i.operator FROM importsessions i)");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
