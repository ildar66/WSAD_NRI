package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPDocumentsLinkBean_27e6892f
 */
public class EJSJDBCPersisterCMPDocumentsLinkBean_27e6892f extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderDocumentsLinkBean {
	private static final String _createString = "INSERT INTO docdependencies (type, documentfrom, documentto) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM docdependencies  WHERE type = ? AND documentfrom = ? AND documentto = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.type, T1.documentfrom, T1.documentto FROM docdependencies  T1 WHERE T1.type = ? AND T1.documentfrom = ? AND T1.documentto = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPDocumentsLinkBean_27e6892f
	 */
	public EJSJDBCPersisterCMPDocumentsLinkBean_27e6892f() throws java.rmi.RemoteException {
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
		DocumentsLinkBean b = (DocumentsLinkBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.documentfrom_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.documentfrom_document.intValue());
			}
			if (b.documentTo_document == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.documentTo_document.intValue());
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
		DocumentsLinkBean b = (DocumentsLinkBean) eb;
		com.hps.july.persistence.DocumentsLinkKey _primaryKey = (com.hps.july.persistence.DocumentsLinkKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.type = _primaryKey.type;
		b.documentfrom_document = _primaryKey.documentfrom_document;
		b.documentTo_document = _primaryKey.documentTo_document;
		tempint = resultSet.getInt(2);
		b.documentfrom_document = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.documentTo_document = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		DocumentsLinkBean b = (DocumentsLinkBean) eb;
		com.hps.july.persistence.DocumentsLinkKey _primaryKey = (com.hps.july.persistence.DocumentsLinkKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.type);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (_primaryKey.documentfrom_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.documentfrom_document.intValue());
			}
			if (_primaryKey.documentTo_document == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.documentTo_document.intValue());
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
		DocumentsLinkBean b = (DocumentsLinkBean) eb;
		com.hps.july.persistence.DocumentsLinkKey _primaryKey = new com.hps.july.persistence.DocumentsLinkKey();
		_primaryKey.type = b.type;
		_primaryKey.documentfrom_document = b.documentfrom_document;
		_primaryKey.documentTo_document = b.documentTo_document;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		return;
	}
	/**
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		DocumentsLinkBean b = (DocumentsLinkBean) eb;
		com.hps.july.persistence.DocumentsLinkKey _primaryKey = new com.hps.july.persistence.DocumentsLinkKey();
		_primaryKey.type = b.type;
		_primaryKey.documentfrom_document = b.documentfrom_document;
		_primaryKey.documentTo_document = b.documentTo_document;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.type);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (_primaryKey.documentfrom_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.documentfrom_document.intValue());
			}
			if (_primaryKey.documentTo_document == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.documentTo_document.intValue());
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
		com.hps.july.persistence.DocumentsLinkKey key = new com.hps.july.persistence.DocumentsLinkKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
			tempint = resultSet.getInt(2);
			key.documentfrom_document = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.documentTo_document = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findByTypeAndDocFrom
	 */
	public EJSFinder findByTypeAndDocFrom(java.lang.String argType, java.lang.Integer argDoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.type, T1.documentfrom, T1.documentto FROM docdependencies  T1 WHERE type = ? and documentfrom = ?");
			if (argType == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argType);
			}
			pstmt.setObject(2, argDoc);
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
	public com.hps.july.persistence.DocumentsLink findByPrimaryKey(com.hps.july.persistence.DocumentsLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.DocumentsLink) home.activateBean(key);
	}
	/**
	 * findDocumentsLinkToByDocumentTo
	 */
	public EJSFinder findDocumentsLinkToByDocumentTo(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.type, T1.documentfrom, T1.documentto FROM docdependencies  T1 WHERE T1.documentto = ?");
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
	 * findDocumentsLinkFromByDocumentfrom
	 */
	public EJSFinder findDocumentsLinkFromByDocumentfrom(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.type, T1.documentfrom, T1.documentto FROM docdependencies  T1 WHERE T1.documentfrom = ?");
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
	 * findByTypeAndDocTo
	 */
	public EJSFinder findByTypeAndDocTo(java.lang.String argType, java.lang.Integer argDoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.type, T1.documentfrom, T1.documentto FROM docdependencies  T1 WHERE type = ? and documentto = ?");
			if (argType == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argType);
			}
			pstmt.setObject(2, argDoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
