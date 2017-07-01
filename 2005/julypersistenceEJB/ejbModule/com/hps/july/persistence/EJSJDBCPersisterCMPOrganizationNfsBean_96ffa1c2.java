package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOrganizationNfsBean_96ffa1c2
 */
public class EJSJDBCPersisterCMPOrganizationNfsBean_96ffa1c2 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderOrganizationNfsBean {
	private static final String[] _createString = {"INSERT INTO vendors (idvendor, inn, name) VALUES (?, ?, ?)", "INSERT INTO vendorsites (idvendorsite, name, kpp, address, directorfio, accountmanagerfio) VALUES (?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM vendorsites  WHERE idvendorsite = ?", "DELETE FROM vendors  WHERE idvendor = ?"};
	private static final String[] _storeString = {"UPDATE vendorsites  SET name = ?, kpp = ?, address = ?, directorfio = ?, accountmanagerfio = ? WHERE idvendorsite = ?", "UPDATE vendors  SET inn = ?, name = ? WHERE idvendor = ?"};
	private static final String _loadString = "SELECT T1.inn, T1.name, T2.idvendorsite, T2.name, T2.kpp, T2.address, T2.directorfio, T2.accountmanagerfio FROM vendorsites  T2, vendors  T1 WHERE T1.idvendor = T2.idvendor AND T2.idvendorsite = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOrganizationNfsBean_96ffa1c2
	 */
	public EJSJDBCPersisterCMPOrganizationNfsBean_96ffa1c2() throws java.rmi.RemoteException {
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
		OrganizationNfsBean b = (OrganizationNfsBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.inn);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			pstmt.setInt(1, b.organization);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kpp);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.legaladdress);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.directorinfo == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.directorinfo);
			}
			if (b.accauntmanagerinfo == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.accauntmanagerinfo);
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
		OrganizationNfsBean b = (OrganizationNfsBean) eb;
		com.hps.july.persistence.OrganizationNfsKey _primaryKey = (com.hps.july.persistence.OrganizationNfsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.organization = _primaryKey.organization;
		b.inn = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.kpp = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.legaladdress = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.shortname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.directorinfo = resultSet.getString(7);
		b.accauntmanagerinfo = resultSet.getString(8);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		OrganizationNfsBean b = (OrganizationNfsBean) eb;
		com.hps.july.persistence.OrganizationNfsKey _primaryKey = (com.hps.july.persistence.OrganizationNfsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.organization);
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
		OrganizationNfsBean b = (OrganizationNfsBean) eb;
		com.hps.july.persistence.OrganizationNfsKey _primaryKey = new com.hps.july.persistence.OrganizationNfsKey();
		_primaryKey.organization = b.organization;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		OrganizationNfsBean b = (OrganizationNfsBean) eb;
		com.hps.july.persistence.OrganizationNfsKey _primaryKey = new com.hps.july.persistence.OrganizationNfsKey();
		_primaryKey.organization = b.organization;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(6, _primaryKey.organization);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kpp);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.legaladdress);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.directorinfo == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.directorinfo);
			}
			if (b.accauntmanagerinfo == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.accauntmanagerinfo);
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.inn);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
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
		OrganizationNfsBean b = (OrganizationNfsBean) eb;
		com.hps.july.persistence.OrganizationNfsKey _primaryKey = new com.hps.july.persistence.OrganizationNfsKey();
		_primaryKey.organization = b.organization;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.organization);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
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
		com.hps.july.persistence.OrganizationNfsKey key = new com.hps.july.persistence.OrganizationNfsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.organization = resultSet.getInt(3);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.OrganizationNfs findByPrimaryKey(com.hps.july.persistence.OrganizationNfsKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.OrganizationNfs) home.activateBean(primaryKey);
	}
}
