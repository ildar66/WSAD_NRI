package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAgregateContentBean_d4664c44
 */
public class EJSJDBCPersisterCMPAgregateContentBean_d4664c44 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAgregateContentBean {
	private static final String _createString = "INSERT INTO agregatecontents (agregate, agregatepart, qty) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM agregatecontents  WHERE agregate = ? AND agregatepart = ?";
	private static final String _storeString = "UPDATE agregatecontents  SET qty = ? WHERE agregate = ? AND agregatepart = ?";
	private static final String _loadString = "SELECT T1.qty, T1.agregate, T1.agregatepart FROM agregatecontents  T1 WHERE T1.agregate = ? AND T1.agregatepart = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAgregateContentBean_d4664c44
	 */
	public EJSJDBCPersisterCMPAgregateContentBean_d4664c44() throws java.rmi.RemoteException {
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
		AgregateContentBean b = (AgregateContentBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.qty == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.qty);
			}
			if (b.agregate_storagecard == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.agregate_storagecard.intValue());
			}
			if (b.parts_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.parts_storagecard.intValue());
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
		AgregateContentBean b = (AgregateContentBean) eb;
		com.hps.july.persistence.AgregateContentKey _primaryKey = (com.hps.july.persistence.AgregateContentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.agregate_storagecard = _primaryKey.agregate_storagecard;
		b.parts_storagecard = _primaryKey.parts_storagecard;
		b.qty = resultSet.getBigDecimal(1);
		tempint = resultSet.getInt(2);
		b.agregate_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.parts_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AgregateContentBean b = (AgregateContentBean) eb;
		com.hps.july.persistence.AgregateContentKey _primaryKey = (com.hps.july.persistence.AgregateContentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.agregate_storagecard == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.agregate_storagecard.intValue());
			}
			if (_primaryKey.parts_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.parts_storagecard.intValue());
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
		AgregateContentBean b = (AgregateContentBean) eb;
		com.hps.july.persistence.AgregateContentKey _primaryKey = new com.hps.july.persistence.AgregateContentKey();
		_primaryKey.agregate_storagecard = b.agregate_storagecard;
		_primaryKey.parts_storagecard = b.parts_storagecard;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AgregateContentBean b = (AgregateContentBean) eb;
		com.hps.july.persistence.AgregateContentKey _primaryKey = new com.hps.july.persistence.AgregateContentKey();
		_primaryKey.agregate_storagecard = b.agregate_storagecard;
		_primaryKey.parts_storagecard = b.parts_storagecard;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.agregate_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.agregate_storagecard.intValue());
			}
			if (_primaryKey.parts_storagecard == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.parts_storagecard.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.qty);
			}
			if (b.agregate_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.agregate_storagecard.intValue());
			}
			if (b.parts_storagecard == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.parts_storagecard.intValue());
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
		AgregateContentBean b = (AgregateContentBean) eb;
		com.hps.july.persistence.AgregateContentKey _primaryKey = new com.hps.july.persistence.AgregateContentKey();
		_primaryKey.agregate_storagecard = b.agregate_storagecard;
		_primaryKey.parts_storagecard = b.parts_storagecard;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.agregate_storagecard == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.agregate_storagecard.intValue());
			}
			if (_primaryKey.parts_storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.parts_storagecard.intValue());
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
		com.hps.july.persistence.AgregateContentKey key = new com.hps.july.persistence.AgregateContentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.agregate_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.parts_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findAgregateAndPart
	 */
	public com.hps.july.persistence.AgregateContent findAgregateAndPart(java.lang.Integer argAgregate, java.lang.Integer argPart) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.AgregateContent result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.qty, T1.agregate, T1.agregatepart FROM agregatecontents  T1 WHERE agregate = ? and agregatepart = ?");
			pstmt.setObject(1, argAgregate);
			pstmt.setObject(2, argPart);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.AgregateContent)tmpFinder.nextElement();
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AgregateContent findByPrimaryKey(com.hps.july.persistence.AgregateContentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.AgregateContent) home.activateBean(key);
	}
	/**
	 * findAgregateByParts
	 */
	public EJSFinder findAgregateByParts(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.qty, T1.agregate, T1.agregatepart FROM agregatecontents  T1 WHERE T1.agregatepart = ?");
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
	/**
	 * findAgregateContentByAgregate
	 */
	public EJSFinder findAgregateContentByAgregate(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.qty, T1.agregate, T1.agregatepart FROM agregatecontents  T1 WHERE T1.agregate = ?");
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
