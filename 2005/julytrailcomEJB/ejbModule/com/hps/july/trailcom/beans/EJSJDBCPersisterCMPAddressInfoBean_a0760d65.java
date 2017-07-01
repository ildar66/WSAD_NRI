package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAddressInfoBean_a0760d65
 */
public class EJSJDBCPersisterCMPAddressInfoBean_a0760d65 extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderAddressInfoBean {
	private static final String _createString = "INSERT INTO address_info (resource, typeport, addresshead, addressstep, e1_count, lastaddress, maxconnect, startaddress, addresstype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM address_info  WHERE resource = ? AND typeport = ?";
	private static final String _storeString = "UPDATE address_info  SET addresshead = ?, addressstep = ?, e1_count = ?, lastaddress = ?, maxconnect = ?, startaddress = ?, addresstype = ? WHERE resource = ? AND typeport = ?";
	private static final String _loadString = "SELECT T1.resource, T1.typeport, T1.addresshead, T1.addressstep, T1.e1_count, T1.lastaddress, T1.maxconnect, T1.startaddress, T1.addresstype FROM address_info  T1 WHERE T1.resource = ? AND T1.typeport = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAddressInfoBean_a0760d65
	 */
	public EJSJDBCPersisterCMPAddressInfoBean_a0760d65() throws java.rmi.RemoteException {
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
		AddressInfoBean b = (AddressInfoBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.resource);
			pstmt.setShort(2, b.typeport);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.addresshead);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.addressstep == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.addressstep.intValue());
			}
			if (b.e1count == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.e1count.intValue());
			}
			if (b.lastaddress == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.lastaddress.intValue());
			}
			if (b.maxconnect == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.maxconnect.intValue());
			}
			if (b.startaddress == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.startaddress.intValue());
			}
			if (b.addresstype == null) {
				pstmt.setNull(9, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(9, b.addresstype.shortValue());
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
		AddressInfoBean b = (AddressInfoBean) eb;
		com.hps.july.trailcom.beans.AddressInfoKey _primaryKey = (com.hps.july.trailcom.beans.AddressInfoKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.resource = _primaryKey.resource;
		b.typeport = _primaryKey.typeport;
		b.addresshead = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(4);
		b.addressstep = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.e1count = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.lastaddress = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.maxconnect = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.startaddress = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(9);
		b.addresstype = resultSet.wasNull() ? null : new Short(tempshort);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AddressInfoBean b = (AddressInfoBean) eb;
		com.hps.july.trailcom.beans.AddressInfoKey _primaryKey = (com.hps.july.trailcom.beans.AddressInfoKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.resource);
			pstmt.setShort(2, _primaryKey.typeport);
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
		AddressInfoBean b = (AddressInfoBean) eb;
		com.hps.july.trailcom.beans.AddressInfoKey _primaryKey = new com.hps.july.trailcom.beans.AddressInfoKey();
		_primaryKey.resource = b.resource;
		_primaryKey.typeport = b.typeport;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AddressInfoBean b = (AddressInfoBean) eb;
		com.hps.july.trailcom.beans.AddressInfoKey _primaryKey = new com.hps.july.trailcom.beans.AddressInfoKey();
		_primaryKey.resource = b.resource;
		_primaryKey.typeport = b.typeport;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(8, _primaryKey.resource);
			pstmt.setShort(9, _primaryKey.typeport);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.addresshead);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.addressstep == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.addressstep.intValue());
			}
			if (b.e1count == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.e1count.intValue());
			}
			if (b.lastaddress == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.lastaddress.intValue());
			}
			if (b.maxconnect == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.maxconnect.intValue());
			}
			if (b.startaddress == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.startaddress.intValue());
			}
			if (b.addresstype == null) {
				pstmt.setNull(7, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(7, b.addresstype.shortValue());
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
		AddressInfoBean b = (AddressInfoBean) eb;
		com.hps.july.trailcom.beans.AddressInfoKey _primaryKey = new com.hps.july.trailcom.beans.AddressInfoKey();
		_primaryKey.resource = b.resource;
		_primaryKey.typeport = b.typeport;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.resource);
			pstmt.setShort(2, _primaryKey.typeport);
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
		com.hps.july.trailcom.beans.AddressInfoKey key = new com.hps.july.trailcom.beans.AddressInfoKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.resource = resultSet.getInt(1);
			key.typeport = resultSet.getShort(2);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.AddressInfo findByPrimaryKey(com.hps.july.trailcom.beans.AddressInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.AddressInfo) home.activateBean(key);
	}
	/**
	 * findByResource
	 */
	public EJSFinder findByResource(java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resource, T1.typeport, T1.addresshead, T1.addressstep, T1.e1_count, T1.lastaddress, T1.maxconnect, T1.startaddress, T1.addresstype FROM address_info  T1 WHERE resource = ?");
			pstmt.setObject(1, argResource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
