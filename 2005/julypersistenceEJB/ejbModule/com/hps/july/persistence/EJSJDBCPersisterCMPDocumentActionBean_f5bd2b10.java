package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPDocumentActionBean_f5bd2b10
 */
public class EJSJDBCPersisterCMPDocumentActionBean_f5bd2b10 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderDocumentActionBean {
	private static final String _createString = "INSERT INTO docactions (docaction, when, what, type, document, operator) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM docactions  WHERE docaction = ?";
	private static final String _storeString = "UPDATE docactions  SET when = ?, what = ?, type = ?, document = ?, operator = ? WHERE docaction = ?";
	private static final String _loadString = "SELECT T1.when, T1.what, T1.docaction, T1.type, T1.document, T1.operator FROM docactions  T1 WHERE T1.docaction = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPDocumentActionBean_f5bd2b10
	 */
	public EJSJDBCPersisterCMPDocumentActionBean_f5bd2b10() throws java.rmi.RemoteException {
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
		DocumentActionBean b = (DocumentActionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.when == null) {
				pstmt.setNull(2, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(2, b.when);
			}
			if (b.what == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.what);
			}
			pstmt.setInt(1, b.docAction);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			pstmt.setInt(5, b.document);
			if (b.operator_operator == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.operator_operator.intValue());
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
		DocumentActionBean b = (DocumentActionBean) eb;
		com.hps.july.persistence.DocumentActionKey _primaryKey = (com.hps.july.persistence.DocumentActionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.docAction = _primaryKey.docAction;
		b.when = resultSet.getTimestamp(1);
		b.what = resultSet.getString(2);
		b.type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.document = resultSet.getInt(5);
		tempint = resultSet.getInt(6);
		b.operator_operator = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		DocumentActionBean b = (DocumentActionBean) eb;
		com.hps.july.persistence.DocumentActionKey _primaryKey = (com.hps.july.persistence.DocumentActionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.docAction);
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
		DocumentActionBean b = (DocumentActionBean) eb;
		com.hps.july.persistence.DocumentActionKey _primaryKey = new com.hps.july.persistence.DocumentActionKey();
		_primaryKey.docAction = b.docAction;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		DocumentActionBean b = (DocumentActionBean) eb;
		com.hps.july.persistence.DocumentActionKey _primaryKey = new com.hps.july.persistence.DocumentActionKey();
		_primaryKey.docAction = b.docAction;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(6, _primaryKey.docAction);
			if (b.when == null) {
				pstmt.setNull(1, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(1, b.when);
			}
			if (b.what == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.what);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setInt(4, b.document);
			if (b.operator_operator == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.operator_operator.intValue());
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
		DocumentActionBean b = (DocumentActionBean) eb;
		com.hps.july.persistence.DocumentActionKey _primaryKey = new com.hps.july.persistence.DocumentActionKey();
		_primaryKey.docAction = b.docAction;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.docAction);
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
		com.hps.july.persistence.DocumentActionKey key = new com.hps.july.persistence.DocumentActionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.docAction = resultSet.getInt(3);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.DocumentAction findByPrimaryKey(com.hps.july.persistence.DocumentActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.DocumentAction) home.activateBean(key);
	}
	/**
	 * findDocumentActionByOperator
	 */
	public EJSFinder findDocumentActionByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.when, T1.what, T1.docaction, T1.type, T1.document, T1.operator FROM docactions  T1 WHERE T1.operator = ?");
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
}
