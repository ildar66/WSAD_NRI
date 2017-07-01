package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectActionCommentsBean_0cd9cc41
 */
public class EJSJDBCPersisterCMPProjectActionCommentsBean_0cd9cc41 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectActionCommentsBean {
	private static final String _createString = "INSERT INTO projectactioncomms (projectaction, division, comment) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM projectactioncomms  WHERE projectaction = ? AND division = ?";
	private static final String _storeString = "UPDATE projectactioncomms  SET comment = ? WHERE projectaction = ? AND division = ?";
	private static final String _loadString = "SELECT T1.comment, T1.projectaction, T1.division FROM projectactioncomms  T1 WHERE T1.projectaction = ? AND T1.division = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectActionCommentsBean_0cd9cc41
	 */
	public EJSJDBCPersisterCMPProjectActionCommentsBean_0cd9cc41() throws java.rmi.RemoteException {
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
		ProjectActionCommentsBean b = (ProjectActionCommentsBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.comment);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(3, (byte[])objectTemp);
			}
			if (b.projectaction_projectaction == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.projectaction_projectaction.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.division_division.intValue());
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
		ProjectActionCommentsBean b = (ProjectActionCommentsBean) eb;
		com.hps.july.persistence.ProjectActionCommentsKey _primaryKey = (com.hps.july.persistence.ProjectActionCommentsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.projectaction_projectaction = _primaryKey.projectaction_projectaction;
		b.division_division = _primaryKey.division_division;
		b.comment = (java.lang.String)com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().objectFrom(resultSet.getBinaryStream(1));
		tempint = resultSet.getInt(2);
		b.projectaction_projectaction = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.division_division = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectActionCommentsBean b = (ProjectActionCommentsBean) eb;
		com.hps.july.persistence.ProjectActionCommentsKey _primaryKey = (com.hps.july.persistence.ProjectActionCommentsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.projectaction_projectaction == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.projectaction_projectaction.intValue());
			}
			if (_primaryKey.division_division == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.division_division.intValue());
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
		ProjectActionCommentsBean b = (ProjectActionCommentsBean) eb;
		com.hps.july.persistence.ProjectActionCommentsKey _primaryKey = new com.hps.july.persistence.ProjectActionCommentsKey();
		_primaryKey.projectaction_projectaction = b.projectaction_projectaction;
		_primaryKey.division_division = b.division_division;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectActionCommentsBean b = (ProjectActionCommentsBean) eb;
		com.hps.july.persistence.ProjectActionCommentsKey _primaryKey = new com.hps.july.persistence.ProjectActionCommentsKey();
		_primaryKey.projectaction_projectaction = b.projectaction_projectaction;
		_primaryKey.division_division = b.division_division;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.projectaction_projectaction == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.projectaction_projectaction.intValue());
			}
			if (_primaryKey.division_division == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.division_division.intValue());
			}
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.comment);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(1, (byte[])objectTemp);
			}
			if (b.projectaction_projectaction == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.projectaction_projectaction.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.division_division.intValue());
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
		ProjectActionCommentsBean b = (ProjectActionCommentsBean) eb;
		com.hps.july.persistence.ProjectActionCommentsKey _primaryKey = new com.hps.july.persistence.ProjectActionCommentsKey();
		_primaryKey.projectaction_projectaction = b.projectaction_projectaction;
		_primaryKey.division_division = b.division_division;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.projectaction_projectaction == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.projectaction_projectaction.intValue());
			}
			if (_primaryKey.division_division == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.division_division.intValue());
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
		com.hps.july.persistence.ProjectActionCommentsKey key = new com.hps.july.persistence.ProjectActionCommentsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.projectaction_projectaction = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.division_division = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectActionComments findByPrimaryKey(com.hps.july.persistence.ProjectActionCommentsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectActionComments) home.activateBean(key);
	}
	/**
	 * findProjectActionCommentsByProjectaction
	 */
	public EJSFinder findProjectActionCommentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.comment, T1.projectaction, T1.division FROM projectactioncomms  T1 WHERE T1.projectaction = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.projectaction);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectActionCommentsByDivision
	 */
	public EJSFinder findProjectActionCommentsByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.comment, T1.projectaction, T1.division FROM projectactioncomms  T1 WHERE T1.division = ?");
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
}
