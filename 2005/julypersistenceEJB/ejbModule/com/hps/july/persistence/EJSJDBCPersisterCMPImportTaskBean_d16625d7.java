package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPImportTaskBean_d16625d7
 */
public class EJSJDBCPersisterCMPImportTaskBean_d16625d7 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderImportTaskBean {
	private static final String _createString = "INSERT INTO importtasks (imptaskid, name, xml_file) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM importtasks  WHERE imptaskid = ?";
	private static final String _storeString = "UPDATE importtasks  SET name = ?, xml_file = ? WHERE imptaskid = ?";
	private static final String _loadString = "SELECT T1.imptaskid, T1.name, T1.xml_file FROM importtasks  T1 WHERE T1.imptaskid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPImportTaskBean_d16625d7
	 */
	public EJSJDBCPersisterCMPImportTaskBean_d16625d7() throws java.rmi.RemoteException {
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
		ImportTaskBean b = (ImportTaskBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.imptaskid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.xmlfile == null) {
				pstmt.setNull(3, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(3, b.xmlfile);
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
		ImportTaskBean b = (ImportTaskBean) eb;
		com.hps.july.persistence.ImportTaskKey _primaryKey = (com.hps.july.persistence.ImportTaskKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.imptaskid = _primaryKey.imptaskid;
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.xmlfile = resultSet.getBytes(3);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ImportTaskBean b = (ImportTaskBean) eb;
		com.hps.july.persistence.ImportTaskKey _primaryKey = (com.hps.july.persistence.ImportTaskKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.imptaskid);
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
		ImportTaskBean b = (ImportTaskBean) eb;
		com.hps.july.persistence.ImportTaskKey _primaryKey = new com.hps.july.persistence.ImportTaskKey();
		_primaryKey.imptaskid = b.imptaskid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ImportTaskBean b = (ImportTaskBean) eb;
		com.hps.july.persistence.ImportTaskKey _primaryKey = new com.hps.july.persistence.ImportTaskKey();
		_primaryKey.imptaskid = b.imptaskid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(3, _primaryKey.imptaskid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.xmlfile == null) {
				pstmt.setNull(2, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(2, b.xmlfile);
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
		ImportTaskBean b = (ImportTaskBean) eb;
		com.hps.july.persistence.ImportTaskKey _primaryKey = new com.hps.july.persistence.ImportTaskKey();
		_primaryKey.imptaskid = b.imptaskid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.imptaskid);
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
		com.hps.july.persistence.ImportTaskKey key = new com.hps.july.persistence.ImportTaskKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.imptaskid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ImportTask findByPrimaryKey(com.hps.july.persistence.ImportTaskKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ImportTask) home.activateBean(key);
	}
}
