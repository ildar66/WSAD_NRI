package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOuterDocPositionBean_b5a64898
 */
public class EJSJDBCPersisterCMPOuterDocPositionBean_b5a64898 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderOuterDocPositionBean {
	private static final String _createString = "INSERT INTO outerdocpositions (outerdocposition, configuration, note, outerprice, outerqty, order, resource, document) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM outerdocpositions  WHERE outerdocposition = ?";
	private static final String _storeString = "UPDATE outerdocpositions  SET configuration = ?, note = ?, outerprice = ?, outerqty = ?, order = ?, resource = ?, document = ? WHERE outerdocposition = ?";
	private static final String _loadString = "SELECT T1.outerdocposition, T1.configuration, T1.note, T1.outerprice, T1.outerqty, T1.order, T1.resource, T1.document FROM outerdocpositions  T1 WHERE T1.outerdocposition = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOuterDocPositionBean_b5a64898
	 */
	public EJSJDBCPersisterCMPOuterDocPositionBean_b5a64898() throws java.rmi.RemoteException {
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
		OuterDocPositionBean b = (OuterDocPositionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.outerDocPosition);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.note);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.outerPrice == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.outerPrice);
			}
			if (b.outerQty == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.outerQty);
			}
			pstmt.setInt(6, b.order);
			if (b.resource_resource == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.resource_resource.intValue());
			}
			if (b.inWayBill_document == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.inWayBill_document.intValue());
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
		OuterDocPositionBean b = (OuterDocPositionBean) eb;
		com.hps.july.persistence.OuterDocPositionKey _primaryKey = (com.hps.july.persistence.OuterDocPositionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.outerDocPosition = _primaryKey.outerDocPosition;
		b.configuration = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.note = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.outerPrice = resultSet.getBigDecimal(4);
		b.outerQty = resultSet.getBigDecimal(5);
		b.order = resultSet.getInt(6);
		tempint = resultSet.getInt(7);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.inWayBill_document = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		OuterDocPositionBean b = (OuterDocPositionBean) eb;
		com.hps.july.persistence.OuterDocPositionKey _primaryKey = (com.hps.july.persistence.OuterDocPositionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.outerDocPosition);
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
		OuterDocPositionBean b = (OuterDocPositionBean) eb;
		com.hps.july.persistence.OuterDocPositionKey _primaryKey = new com.hps.july.persistence.OuterDocPositionKey();
		_primaryKey.outerDocPosition = b.outerDocPosition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		OuterDocPositionBean b = (OuterDocPositionBean) eb;
		com.hps.july.persistence.OuterDocPositionKey _primaryKey = new com.hps.july.persistence.OuterDocPositionKey();
		_primaryKey.outerDocPosition = b.outerDocPosition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(8, _primaryKey.outerDocPosition);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.note);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.outerPrice == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.outerPrice);
			}
			if (b.outerQty == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.outerQty);
			}
			pstmt.setInt(5, b.order);
			if (b.resource_resource == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.resource_resource.intValue());
			}
			if (b.inWayBill_document == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.inWayBill_document.intValue());
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
		OuterDocPositionBean b = (OuterDocPositionBean) eb;
		com.hps.july.persistence.OuterDocPositionKey _primaryKey = new com.hps.july.persistence.OuterDocPositionKey();
		_primaryKey.outerDocPosition = b.outerDocPosition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.outerDocPosition);
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
		com.hps.july.persistence.OuterDocPositionKey key = new com.hps.july.persistence.OuterDocPositionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.outerDocPosition = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.OuterDocPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.OuterDocPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.outerdocposition, T1.configuration, T1.note, T1.outerprice, T1.outerqty, T1.order, T1.resource, T1.document FROM outerdocpositions  T1 WHERE document=? and order = (select max(order) from outerdocpositions dp2 where dp2.document=t1.document)");
			pstmt.setObject(1, argDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.OuterDocPosition)tmpFinder.nextElement();
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
	 * findByDocumentResource
	 */
	public EJSFinder findByDocumentResource(java.lang.Integer argDocument, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.outerdocposition, T1.configuration, T1.note, T1.outerprice, T1.outerqty, T1.order, T1.resource, T1.document FROM outerdocpositions  T1 WHERE document=? and resource=?");
			pstmt.setObject(1, argDocument);
			pstmt.setObject(2, argResource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByInWayBillOrderByOrderAsc
	 */
	public EJSFinder findByInWayBillOrderByOrderAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.outerdocposition, T1.configuration, T1.note, T1.outerprice, T1.outerqty, T1.order, T1.resource, T1.document FROM outerdocpositions  T1 WHERE document=? order by order asc");
			pstmt.setObject(1, argDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOuterDocPositionByResource
	 */
	public EJSFinder findOuterDocPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.outerdocposition, T1.configuration, T1.note, T1.outerprice, T1.outerqty, T1.order, T1.resource, T1.document FROM outerdocpositions  T1 WHERE T1.resource = ?");
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
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.OuterDocPosition findByPrimaryKey(com.hps.july.persistence.OuterDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.OuterDocPosition) home.activateBean(key);
	}
	/**
	 * findOuterDocPositionByInWayBill
	 */
	public EJSFinder findOuterDocPositionByInWayBill(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.outerdocposition, T1.configuration, T1.note, T1.outerprice, T1.outerqty, T1.order, T1.resource, T1.document FROM outerdocpositions  T1 WHERE T1.document = ?");
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
}
