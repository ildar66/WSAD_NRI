package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPChangeActPositionBean_e8688648
 */
public class EJSJDBCPersisterCMPChangeActPositionBean_e8688648 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderChangeActPositionBean {
	private static final String _createString = "INSERT INTO changeactpos (changeactpos, newserial, oldserial, inventserial, oldresource, oldinventserial, localserial, oldlocalserial, document, newresource) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM changeactpos  WHERE changeactpos = ?";
	private static final String _storeString = "UPDATE changeactpos  SET newserial = ?, oldserial = ?, inventserial = ?, oldresource = ?, oldinventserial = ?, localserial = ?, oldlocalserial = ?, document = ?, newresource = ? WHERE changeactpos = ?";
	private static final String _loadString = "SELECT T1.changeactpos, T1.newserial, T1.oldserial, T1.inventserial, T1.oldresource, T1.oldinventserial, T1.localserial, T1.oldlocalserial, T1.document, T1.newresource FROM changeactpos  T1 WHERE T1.changeactpos = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPChangeActPositionBean_e8688648
	 */
	public EJSJDBCPersisterCMPChangeActPositionBean_e8688648() throws java.rmi.RemoteException {
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
		ChangeActPositionBean b = (ChangeActPositionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.code);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.newSerial);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldSerial);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manufserial);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.oldresource == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.oldresource.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldmanufserial);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.localserial);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldlocalserial);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.changeAct_document == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.changeAct_document.intValue());
			}
			if (b.newresource_resource == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.newresource_resource.intValue());
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
		ChangeActPositionBean b = (ChangeActPositionBean) eb;
		com.hps.july.persistence.ChangeActPositionKey _primaryKey = (com.hps.july.persistence.ChangeActPositionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.code = _primaryKey.code;
		b.newSerial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.oldSerial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.manufserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		tempint = resultSet.getInt(5);
		b.oldresource = resultSet.wasNull() ? null : new Integer(tempint);
		b.oldmanufserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.localserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.oldlocalserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		tempint = resultSet.getInt(9);
		b.changeAct_document = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.newresource_resource = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ChangeActPositionBean b = (ChangeActPositionBean) eb;
		com.hps.july.persistence.ChangeActPositionKey _primaryKey = (com.hps.july.persistence.ChangeActPositionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.code);
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
		ChangeActPositionBean b = (ChangeActPositionBean) eb;
		com.hps.july.persistence.ChangeActPositionKey _primaryKey = new com.hps.july.persistence.ChangeActPositionKey();
		_primaryKey.code = b.code;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ChangeActPositionBean b = (ChangeActPositionBean) eb;
		com.hps.july.persistence.ChangeActPositionKey _primaryKey = new com.hps.july.persistence.ChangeActPositionKey();
		_primaryKey.code = b.code;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(10, _primaryKey.code);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.newSerial);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldSerial);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manufserial);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.oldresource == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.oldresource.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldmanufserial);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.localserial);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldlocalserial);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.changeAct_document == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.changeAct_document.intValue());
			}
			if (b.newresource_resource == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.newresource_resource.intValue());
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
		ChangeActPositionBean b = (ChangeActPositionBean) eb;
		com.hps.july.persistence.ChangeActPositionKey _primaryKey = new com.hps.july.persistence.ChangeActPositionKey();
		_primaryKey.code = b.code;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.code);
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
		com.hps.july.persistence.ChangeActPositionKey key = new com.hps.july.persistence.ChangeActPositionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.code = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByDocNewSerial
	 */
	public EJSFinder findByDocNewSerial(java.lang.Integer argDoc, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.changeactpos, T1.newserial, T1.oldserial, T1.inventserial, T1.oldresource, T1.oldinventserial, T1.localserial, T1.oldlocalserial, T1.document, T1.newresource FROM changeactpos  T1 WHERE document = ? AND newserial = ?");
			pstmt.setObject(1, argDoc);
			if (argSerial == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argSerial);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findChangeActPositionByChangeAct
	 */
	public EJSFinder findChangeActPositionByChangeAct(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.changeactpos, T1.newserial, T1.oldserial, T1.inventserial, T1.oldresource, T1.oldinventserial, T1.localserial, T1.oldlocalserial, T1.document, T1.newresource FROM changeactpos  T1 WHERE T1.document = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ChangeActPosition findByPrimaryKey(com.hps.july.persistence.ChangeActPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ChangeActPosition) home.activateBean(key);
	}
	/**
	 * findChangeActPositionsByNewresource
	 */
	public EJSFinder findChangeActPositionsByNewresource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.changeactpos, T1.newserial, T1.oldserial, T1.inventserial, T1.oldresource, T1.oldinventserial, T1.localserial, T1.oldlocalserial, T1.document, T1.newresource FROM changeactpos  T1 WHERE T1.newresource = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
