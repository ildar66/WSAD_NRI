package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAddressSpaceBean_4288f116
 */
public class EJSJDBCPersisterCMPAddressSpaceBean_4288f116 extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderAddressSpaceBean {
	private static final String _createString = "INSERT INTO address_space (portid, activestate, address, disabletime, existstate, insegment, realconnect, storagecard, resource, typeport) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM address_space  WHERE portid = ?";
	private static final String _storeString = "UPDATE address_space  SET activestate = ?, address = ?, disabletime = ?, existstate = ?, insegment = ?, realconnect = ?, storagecard = ?, resource = ?, typeport = ? WHERE portid = ?";
	private static final String _loadString = "SELECT T1.portid, T1.activestate, T1.address, T1.disabletime, T1.existstate, T1.insegment, T1.realconnect, T1.storagecard, T1.resource, T1.typeport FROM address_space  T1 WHERE T1.portid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAddressSpaceBean_4288f116
	 */
	public EJSJDBCPersisterCMPAddressSpaceBean_4288f116() throws java.rmi.RemoteException {
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
		AddressSpaceBean b = (AddressSpaceBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.portid);
			if (b.activestate == null) {
				pstmt.setNull(2, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(2, b.activestate.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.address);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.disabletime == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.disabletime);
			}
			if (b.existstate == null) {
				pstmt.setNull(5, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(5, b.existstate.shortValue());
			}
			if (b.insegment == null) {
				pstmt.setNull(6, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(6, b.insegment.shortValue());
			}
			if (b.realconnect == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.realconnect.intValue());
			}
			if (b.storagecard == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.storagecard.intValue());
			}
			if (b.addressinfo_resource == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.addressinfo_resource.intValue());
			}
			if (b.addressinfo_typeport == null) {
				pstmt.setNull(10, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(10, b.addressinfo_typeport.shortValue());
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
		AddressSpaceBean b = (AddressSpaceBean) eb;
		com.hps.july.trailcom.beans.AddressSpaceKey _primaryKey = (com.hps.july.trailcom.beans.AddressSpaceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.portid = _primaryKey.portid;
		tempshort = resultSet.getShort(2);
		b.activestate = resultSet.wasNull() ? null : new Short(tempshort);
		b.address = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.disabletime = resultSet.getTimestamp(4);
		tempshort = resultSet.getShort(5);
		b.existstate = resultSet.wasNull() ? null : new Short(tempshort);
		tempshort = resultSet.getShort(6);
		b.insegment = resultSet.wasNull() ? null : new Short(tempshort);
		tempint = resultSet.getInt(7);
		b.realconnect = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.addressinfo_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(10);
		b.addressinfo_typeport = resultSet.wasNull() ? null : new Short(tempshort);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AddressSpaceBean b = (AddressSpaceBean) eb;
		com.hps.july.trailcom.beans.AddressSpaceKey _primaryKey = (com.hps.july.trailcom.beans.AddressSpaceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.portid);
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
		AddressSpaceBean b = (AddressSpaceBean) eb;
		com.hps.july.trailcom.beans.AddressSpaceKey _primaryKey = new com.hps.july.trailcom.beans.AddressSpaceKey();
		_primaryKey.portid = b.portid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AddressSpaceBean b = (AddressSpaceBean) eb;
		com.hps.july.trailcom.beans.AddressSpaceKey _primaryKey = new com.hps.july.trailcom.beans.AddressSpaceKey();
		_primaryKey.portid = b.portid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(10, _primaryKey.portid);
			if (b.activestate == null) {
				pstmt.setNull(1, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(1, b.activestate.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.address);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.disabletime == null) {
				pstmt.setNull(3, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(3, b.disabletime);
			}
			if (b.existstate == null) {
				pstmt.setNull(4, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(4, b.existstate.shortValue());
			}
			if (b.insegment == null) {
				pstmt.setNull(5, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(5, b.insegment.shortValue());
			}
			if (b.realconnect == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.realconnect.intValue());
			}
			if (b.storagecard == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.storagecard.intValue());
			}
			if (b.addressinfo_resource == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.addressinfo_resource.intValue());
			}
			if (b.addressinfo_typeport == null) {
				pstmt.setNull(9, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(9, b.addressinfo_typeport.shortValue());
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
		AddressSpaceBean b = (AddressSpaceBean) eb;
		com.hps.july.trailcom.beans.AddressSpaceKey _primaryKey = new com.hps.july.trailcom.beans.AddressSpaceKey();
		_primaryKey.portid = b.portid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.portid);
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
		com.hps.july.trailcom.beans.AddressSpaceKey key = new com.hps.july.trailcom.beans.AddressSpaceKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.portid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.AddressSpace findByPrimaryKey(com.hps.july.trailcom.beans.AddressSpaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.AddressSpace) home.activateBean(key);
	}
	/**
	 * findAddressSpacesByAddressinfo
	 */
	public EJSFinder findAddressSpacesByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.portid, T1.activestate, T1.address, T1.disabletime, T1.existstate, T1.insegment, T1.realconnect, T1.storagecard, T1.resource, T1.typeport FROM address_space  T1 WHERE T1.resource = ? AND T1.typeport = ?");
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
	/**
	 * findByStoragecard
	 */
	public EJSFinder findByStoragecard(java.lang.Integer argStoragecard) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.portid, T1.activestate, T1.address, T1.disabletime, T1.existstate, T1.insegment, T1.realconnect, T1.storagecard, T1.resource, T1.typeport FROM address_space  T1 WHERE storagecard = ?");
			pstmt.setObject(1, argStoragecard);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
