package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseMutualRuleNewBean_ed76f092
 */
public class EJSJDBCPersisterCMPLeaseMutualRuleNewBean_ed76f092 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseMutualRuleNewBean {
	private static final String _createString = "INSERT INTO leasemutualrules (reglament, resource, chargedaterule, dopchargdatrul, paydaterule, ratetype) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasemutualrules  WHERE reglament = ? AND resource = ?";
	private static final String _storeString = "UPDATE leasemutualrules  SET chargedaterule = ?, dopchargdatrul = ?, paydaterule = ?, ratetype = ? WHERE reglament = ? AND resource = ?";
	private static final String _loadString = "SELECT T1.chargedaterule, T1.dopchargdatrul, T1.paydaterule, T1.ratetype, T1.reglament, T1.resource FROM leasemutualrules  T1 WHERE T1.reglament = ? AND T1.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseMutualRuleNewBean_ed76f092
	 */
	public EJSJDBCPersisterCMPLeaseMutualRuleNewBean_ed76f092() throws java.rmi.RemoteException {
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
		LeaseMutualRuleNewBean b = (LeaseMutualRuleNewBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.chargedaterule);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.dopchargdatrul));
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paydaterule);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.rateType == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.rateType.intValue());
			}
			if (b.reglament_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.reglament_leaseDocument.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.resource_resource.intValue());
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
		LeaseMutualRuleNewBean b = (LeaseMutualRuleNewBean) eb;
		com.hps.july.persistence.LeaseMutualRuleNewKey _primaryKey = (com.hps.july.persistence.LeaseMutualRuleNewKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.reglament_leaseDocument = _primaryKey.reglament_leaseDocument;
		b.resource_resource = _primaryKey.resource_resource;
		b.chargedaterule = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(2));
		b.dopchargdatrul = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.paydaterule = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(4);
		b.rateType = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.reglament_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseMutualRuleNewBean b = (LeaseMutualRuleNewBean) eb;
		com.hps.july.persistence.LeaseMutualRuleNewKey _primaryKey = (com.hps.july.persistence.LeaseMutualRuleNewKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			if (_primaryKey.reglament_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.reglament_leaseDocument.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.resource_resource.intValue());
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
		LeaseMutualRuleNewBean b = (LeaseMutualRuleNewBean) eb;
		com.hps.july.persistence.LeaseMutualRuleNewKey _primaryKey = new com.hps.july.persistence.LeaseMutualRuleNewKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.resource_resource = b.resource_resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseMutualRuleNewBean b = (LeaseMutualRuleNewBean) eb;
		com.hps.july.persistence.LeaseMutualRuleNewKey _primaryKey = new com.hps.july.persistence.LeaseMutualRuleNewKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			if (_primaryKey.reglament_leaseDocument == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, _primaryKey.reglament_leaseDocument.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, _primaryKey.resource_resource.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.chargedaterule);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.dopchargdatrul));
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.paydaterule);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.rateType == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.rateType.intValue());
			}
			if (b.reglament_leaseDocument == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.reglament_leaseDocument.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.resource_resource.intValue());
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
		LeaseMutualRuleNewBean b = (LeaseMutualRuleNewBean) eb;
		com.hps.july.persistence.LeaseMutualRuleNewKey _primaryKey = new com.hps.july.persistence.LeaseMutualRuleNewKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			if (_primaryKey.reglament_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.reglament_leaseDocument.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.resource_resource.intValue());
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
		com.hps.july.persistence.LeaseMutualRuleNewKey key = new com.hps.july.persistence.LeaseMutualRuleNewKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(5);
			key.reglament_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(6);
			key.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}
	/**
	 * findLeaseMutualRuleNewsByReglamentOrderByResourceAsc
	 */
	public EJSFinder findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(java.lang.Integer argreglament) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargedaterule, T1.dopchargdatrul, T1.paydaterule, T1.ratetype, T1.reglament, T1.resource FROM leasemutualrules  T1 WHERE reglament = ? ORDER BY resource ASC");
			pstmt.setObject(1, argreglament);
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
	public com.hps.july.persistence.LeaseMutualRuleNew findByPrimaryKey(com.hps.july.persistence.LeaseMutualRuleNewKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseMutualRuleNew) home.activateBean(key);
	}
	/**
	 * findLeaseMutualRuleNewsByResource
	 */
	public EJSFinder findLeaseMutualRuleNewsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargedaterule, T1.dopchargdatrul, T1.paydaterule, T1.ratetype, T1.reglament, T1.resource FROM leasemutualrules  T1 WHERE T1.resource = ?");
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
	 * findLeaseMutualRulesByReglament
	 */
	public EJSFinder findLeaseMutualRulesByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargedaterule, T1.dopchargdatrul, T1.paydaterule, T1.ratetype, T1.reglament, T1.resource FROM leasemutualrules  T1 WHERE T1.reglament = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
