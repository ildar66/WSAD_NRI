package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPI13nDateSavingBean_85b3cc12
 */
public class EJSJDBCPersisterCMPI13nDateSavingBean_85b3cc12 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderI13nDateSavingBean {
	private static final String _createString = "INSERT INTO i13ndatesav (document, storagecard, oldI13nDate) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM i13ndatesav  WHERE document = ? AND storagecard = ?";
	private static final String _storeString = "UPDATE i13ndatesav  SET oldI13nDate = ? WHERE document = ? AND storagecard = ?";
	private static final String _loadString = "SELECT T1.oldI13nDate, T1.document, T1.storagecard FROM i13ndatesav  T1 WHERE T1.document = ? AND T1.storagecard = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPI13nDateSavingBean_85b3cc12
	 */
	public EJSJDBCPersisterCMPI13nDateSavingBean_85b3cc12() throws java.rmi.RemoteException {
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
		I13nDateSavingBean b = (I13nDateSavingBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.oldI13nDate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.oldI13nDate);
			}
			if (b.i13nAct_document == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.i13nAct_document.intValue());
			}
			if (b.storageCard_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.storageCard_storagecard.intValue());
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
		I13nDateSavingBean b = (I13nDateSavingBean) eb;
		com.hps.july.persistence.I13nDateSavingKey _primaryKey = (com.hps.july.persistence.I13nDateSavingKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.i13nAct_document = _primaryKey.i13nAct_document;
		b.storageCard_storagecard = _primaryKey.storageCard_storagecard;
		b.oldI13nDate = resultSet.getDate(1);
		tempint = resultSet.getInt(2);
		b.i13nAct_document = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.storageCard_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		I13nDateSavingBean b = (I13nDateSavingBean) eb;
		com.hps.july.persistence.I13nDateSavingKey _primaryKey = (com.hps.july.persistence.I13nDateSavingKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.i13nAct_document == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.i13nAct_document.intValue());
			}
			if (_primaryKey.storageCard_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.storageCard_storagecard.intValue());
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
		I13nDateSavingBean b = (I13nDateSavingBean) eb;
		com.hps.july.persistence.I13nDateSavingKey _primaryKey = new com.hps.july.persistence.I13nDateSavingKey();
		_primaryKey.i13nAct_document = b.i13nAct_document;
		_primaryKey.storageCard_storagecard = b.storageCard_storagecard;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		I13nDateSavingBean b = (I13nDateSavingBean) eb;
		com.hps.july.persistence.I13nDateSavingKey _primaryKey = new com.hps.july.persistence.I13nDateSavingKey();
		_primaryKey.i13nAct_document = b.i13nAct_document;
		_primaryKey.storageCard_storagecard = b.storageCard_storagecard;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.i13nAct_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.i13nAct_document.intValue());
			}
			if (_primaryKey.storageCard_storagecard == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.storageCard_storagecard.intValue());
			}
			if (b.oldI13nDate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.oldI13nDate);
			}
			if (b.i13nAct_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.i13nAct_document.intValue());
			}
			if (b.storageCard_storagecard == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.storageCard_storagecard.intValue());
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
		I13nDateSavingBean b = (I13nDateSavingBean) eb;
		com.hps.july.persistence.I13nDateSavingKey _primaryKey = new com.hps.july.persistence.I13nDateSavingKey();
		_primaryKey.i13nAct_document = b.i13nAct_document;
		_primaryKey.storageCard_storagecard = b.storageCard_storagecard;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.i13nAct_document == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.i13nAct_document.intValue());
			}
			if (_primaryKey.storageCard_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.storageCard_storagecard.intValue());
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
		com.hps.july.persistence.I13nDateSavingKey key = new com.hps.july.persistence.I13nDateSavingKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.i13nAct_document = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.storageCard_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.I13nDateSaving findByPrimaryKey(com.hps.july.persistence.I13nDateSavingKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.I13nDateSaving) home.activateBean(key);
	}
	/**
	 * findI13nDateSavingByI13nAct
	 */
	public EJSFinder findI13nDateSavingByI13nAct(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.oldI13nDate, T1.document, T1.storagecard FROM i13ndatesav  T1 WHERE T1.document = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.document);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findI13nDateSavingByStorageCard
	 */
	public EJSFinder findI13nDateSavingByStorageCard(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.oldI13nDate, T1.document, T1.storagecard FROM i13ndatesav  T1 WHERE T1.storagecard = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storagecard);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
