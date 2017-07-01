package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAddressInfo2Bean_4b0a02cd
 */
public class EJSJDBCPersisterCMPAddressInfo2Bean_4b0a02cd extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderAddressInfo2Bean {
	private static final String _createString = "INSERT INTO address_info2 (addressportid, addressname, resource, typeport) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM address_info2  WHERE addressportid = ?";
	private static final String _storeString = "UPDATE address_info2  SET addressname = ?, resource = ?, typeport = ? WHERE addressportid = ?";
	private static final String _loadString = "SELECT T1.addressportid, T1.addressname, T1.resource, T1.typeport FROM address_info2  T1 WHERE T1.addressportid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAddressInfo2Bean_4b0a02cd
	 */
	public EJSJDBCPersisterCMPAddressInfo2Bean_4b0a02cd() throws java.rmi.RemoteException {
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
		AddressInfo2Bean b = (AddressInfo2Bean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.addressportid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.addressname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.addressinfo_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.addressinfo_resource.intValue());
			}
			if (b.addressinfo_typeport == null) {
				pstmt.setNull(4, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(4, b.addressinfo_typeport.shortValue());
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
		AddressInfo2Bean b = (AddressInfo2Bean) eb;
		com.hps.july.trailcom.beans.AddressInfo2Key _primaryKey = (com.hps.july.trailcom.beans.AddressInfo2Key)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.addressportid = _primaryKey.addressportid;
		b.addressname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		tempint = resultSet.getInt(3);
		b.addressinfo_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(4);
		b.addressinfo_typeport = resultSet.wasNull() ? null : new Short(tempshort);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AddressInfo2Bean b = (AddressInfo2Bean) eb;
		com.hps.july.trailcom.beans.AddressInfo2Key _primaryKey = (com.hps.july.trailcom.beans.AddressInfo2Key)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.addressportid);
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
		AddressInfo2Bean b = (AddressInfo2Bean) eb;
		com.hps.july.trailcom.beans.AddressInfo2Key _primaryKey = new com.hps.july.trailcom.beans.AddressInfo2Key();
		_primaryKey.addressportid = b.addressportid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AddressInfo2Bean b = (AddressInfo2Bean) eb;
		com.hps.july.trailcom.beans.AddressInfo2Key _primaryKey = new com.hps.july.trailcom.beans.AddressInfo2Key();
		_primaryKey.addressportid = b.addressportid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(4, _primaryKey.addressportid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.addressname);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.addressinfo_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.addressinfo_resource.intValue());
			}
			if (b.addressinfo_typeport == null) {
				pstmt.setNull(3, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(3, b.addressinfo_typeport.shortValue());
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
		AddressInfo2Bean b = (AddressInfo2Bean) eb;
		com.hps.july.trailcom.beans.AddressInfo2Key _primaryKey = new com.hps.july.trailcom.beans.AddressInfo2Key();
		_primaryKey.addressportid = b.addressportid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.addressportid);
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
		com.hps.july.trailcom.beans.AddressInfo2Key key = new com.hps.july.trailcom.beans.AddressInfo2Key();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.addressportid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.AddressInfo2 findByPrimaryKey(com.hps.july.trailcom.beans.AddressInfo2Key key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.AddressInfo2) home.activateBean(key);
	}
	/**
	 * findByResourceTypeport
	 */
	public EJSFinder findByResourceTypeport(java.lang.Integer argResource, java.lang.Short argTypeport) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.addressportid, T1.addressname, T1.resource, T1.typeport FROM address_info2  T1 WHERE resource = ? AND typeport = ?");
			pstmt.setObject(1, argResource);
			pstmt.setObject(2, argTypeport);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAddressInfo2sByAddressinfo
	 */
	public EJSFinder findAddressInfo2sByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.addressportid, T1.addressname, T1.resource, T1.typeport FROM address_info2  T1 WHERE T1.resource = ? AND T1.typeport = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			pstmt.setShort(2, inKey.typeport);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
