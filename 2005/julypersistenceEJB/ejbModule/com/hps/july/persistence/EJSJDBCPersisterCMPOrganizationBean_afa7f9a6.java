package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOrganizationBean_afa7f9a6
 */
public class EJSJDBCPersisterCMPOrganizationBean_afa7f9a6 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderOrganizationBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO organizations (organization, zip, contactlist, directorfio, isrenter, koraccount, isprovider, phone, organizationtype, phisicaladdress, shortname, inn, accountmanagerfio, okpo, isbank, legaladdress, bik, name, kpp, swift, bossposition, okonh, fax, issupplier, ischannalrenter, company) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM organizations  WHERE organization = ?";
	private static final String _storeString = "UPDATE organizations  SET zip = ?, contactlist = ?, directorfio = ?, isrenter = ?, koraccount = ?, isprovider = ?, phone = ?, organizationtype = ?, phisicaladdress = ?, shortname = ?, inn = ?, accountmanagerfio = ?, okpo = ?, isbank = ?, legaladdress = ?, bik = ?, name = ?, kpp = ?, swift = ?, bossposition = ?, okonh = ?, fax = ?, issupplier = ?, ischannalrenter = ?, company = ? WHERE organization = ?";
	private static final String _loadString = "SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE T1.organization = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOrganizationBean_afa7f9a6
	 */
	public EJSJDBCPersisterCMPOrganizationBean_afa7f9a6() throws java.rmi.RemoteException {
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
		OrganizationBean b = (OrganizationBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.zip);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.contactList);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(3, (byte[])objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.directorinfo);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isrenter);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.koraccount);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isprovider);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.phone);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.organizationType);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.phisicaladdress);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.organization);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.inn);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.accauntmanagerinfo);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.okpo);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.bank);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.legaladdress);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bik);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kpp);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.swift);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bossPosition);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.okonh);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fax);
			if (objectTemp == null) {
				pstmt.setNull(23, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(23, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.issupplier);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ischannalrenter);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			if (b.company_company == null) {
				pstmt.setNull(26, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(26, b.company_company.intValue());
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
		OrganizationBean b = (OrganizationBean) eb;
		com.hps.july.persistence.OrganizationKey _primaryKey = (com.hps.july.persistence.OrganizationKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.organization = _primaryKey.organization;
		b.zip = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.contactList = (java.lang.String)com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().objectFrom(resultSet.getBinaryStream(2));
		b.directorinfo = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.isrenter = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		b.koraccount = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.isprovider = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(6));
		b.phone = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.organizationType = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.phisicaladdress = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.shortname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.inn = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.accauntmanagerinfo = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.okpo = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		b.bank = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(15));
		b.legaladdress = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(16));
		b.bik = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(17));
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		b.kpp = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(19));
		b.swift = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(20));
		b.bossPosition = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(21));
		b.okonh = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(22));
		b.fax = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(23));
		b.issupplier = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(24));
		b.ischannalrenter = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(25));
		tempint = resultSet.getInt(26);
		b.company_company = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		OrganizationBean b = (OrganizationBean) eb;
		com.hps.july.persistence.OrganizationKey _primaryKey = (com.hps.july.persistence.OrganizationKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
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
		OrganizationBean b = (OrganizationBean) eb;
		com.hps.july.persistence.OrganizationKey _primaryKey = new com.hps.july.persistence.OrganizationKey();
		_primaryKey.organization = b.organization;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		OrganizationBean b = (OrganizationBean) eb;
		com.hps.july.persistence.OrganizationKey _primaryKey = new com.hps.july.persistence.OrganizationKey();
		_primaryKey.organization = b.organization;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(26, _primaryKey.organization);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.zip);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.contactList);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(2, (byte[])objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.directorinfo);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isrenter);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.koraccount);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isprovider);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.phone);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.organizationType);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.phisicaladdress);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.inn);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.accauntmanagerinfo);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.okpo);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.bank);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.legaladdress);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bik);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kpp);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.swift);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bossPosition);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.okonh);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.fax);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.issupplier);
			if (objectTemp == null) {
				pstmt.setNull(23, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(23, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.ischannalrenter);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			if (b.company_company == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.company_company.intValue());
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
		OrganizationBean b = (OrganizationBean) eb;
		com.hps.july.persistence.OrganizationKey _primaryKey = new com.hps.july.persistence.OrganizationKey();
		_primaryKey.organization = b.organization;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.organization);
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
		com.hps.july.persistence.OrganizationKey key = new com.hps.july.persistence.OrganizationKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.organization = resultSet.getInt(11);
			return key;
		}
return null;
	}
	/**
	 * findOrganizationsButBanksByCompanyAndGroup
	 */
	public EJSFinder findOrganizationsButBanksByCompanyAndGroup(java.lang.Integer argCompany, java.lang.Boolean isGroup, java.lang.Integer searchgroup, java.lang.Integer searchGroupping) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findOrganizationsButBanksByCompanyAndGroup(argCompany, isGroup, searchgroup, searchGroupping);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOrganizationsByQBE2
	 */
	public EJSFinder findOrganizationsByQBE2(java.lang.Boolean isHaveBans, java.lang.Boolean isRenter, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Boolean isBan, java.lang.Integer ban, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findOrganizationsByQBE2(isHaveBans, isRenter, isName, argName, isInn, argInn, isBan, ban, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOrganizationByCompany
	 */
	public EJSFinder findOrganizationByCompany(com.hps.july.persistence.CompanyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE T1.company = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.company);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOrganizationsByNameOrderByNameAsc
	 */
	public EJSFinder findOrganizationsByNameOrderByNameAsc(java.lang.String name, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findOrganizationsByNameOrderByNameAsc(name, argIsSupplier, argIsProvider, argIsRenter);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOrganizationsButBanksByCompany
	 */
	public EJSFinder findOrganizationsButBanksByCompany(java.lang.Integer argCompany) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE company = ? and isbank <> \"Y\"");
			pstmt.setObject(1, argCompany);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByInnOrderByInnAsc
	 */
	public EJSFinder findByInnOrderByInnAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE upper(inn) matches upper(?) order by inn asc");
			if (name == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, name);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByNameOrderByNameAsc
	 */
	public EJSFinder findByNameOrderByNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE upper(name) matches upper(?) order by name asc");
			if (name == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, name);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBanksByNameOrderByNameAsc
	 */
	public EJSFinder findBanksByNameOrderByNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE isbank = \"Y\" and upper(name) matches upper(?) order by name asc");
			if (name == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, name);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOurOrganizations
	 */
	public EJSFinder findOurOrganizations() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE t1.company = (select n.intvalue from namedvalues n where n.id = \"OUR_COMPANY\" )");
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
	public com.hps.july.persistence.Organization findByPrimaryKey(com.hps.july.persistence.OrganizationKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Organization) home.activateBean(key);
	}
	/**
	 * findOrganizationsByQBE
	 */
	public EJSFinder findOrganizationsByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findOrganizationsByQBE(isName, argName, isSupplier, isProvider, isRenter, isInn, argInn, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOrganizationsByQBEAndGroup
	 */
	public EJSFinder findOrganizationsByQBEAndGroup(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order, java.lang.Boolean isGroup, java.lang.Integer group, java.lang.Integer groupping) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findOrganizationsByQBEAndGroup(isName, argName, isSupplier, isProvider, isRenter, isInn, argInn, order, isGroup, group, groupping);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBanksByQBE
	 */
	public EJSFinder findBanksByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isBic, java.lang.String argBic, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findBanksByQBE(isName, argName, isBic, argBic, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOrganizationsByReglament
	 */
	public EJSFinder findOrganizationsByReglament(java.lang.Integer argCustReglament, java.lang.Integer argExecReglament) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE organization IN (SELECT l.orgcustomer FROM leasecontracts l, leasemutcontracts m  WHERE m.contract = l.leasedocument AND m.reglament = ?) OR organization IN (SELECT l.orgexecutor FROM leasecontracts l, leasemutcontracts m  WHERE m.contract = l.leasedocument AND m.reglament = ?) ");
			pstmt.setObject(1, argCustReglament);
			pstmt.setObject(2, argExecReglament);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.zip, T1.contactlist, T1.directorfio, T1.isrenter, T1.koraccount, T1.isprovider, T1.phone, T1.organizationtype, T1.phisicaladdress, T1.shortname, T1.organization, T1.inn, T1.accountmanagerfio, T1.okpo, T1.isbank, T1.legaladdress, T1.bik, T1.name, T1.kpp, T1.swift, T1.bossposition, T1.okonh, T1.fax, T1.issupplier, T1.ischannalrenter, T1.company FROM organizations  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {384};
	/**
	 * getMergedPreparedStatement
	 */
	public PreparedStatement getMergedPreparedStatement(String searchCondition) throws Exception {
		StringBuffer sb = new StringBuffer(genericFindSqlString);
		for (int i = 0; i < genericFindInsertPoints.length; i++) {
		   sb.insert(genericFindInsertPoints[i], searchCondition);
		}
		return super.getPreparedStatement(sb.toString());
	}
	/**
	 * getMergedWhereCount
	 */
	public int getMergedWhereCount() {
		return genericFindInsertPoints.length;
	}
	/**
	 * getGenericFindSqlString
	 */
	public String getGenericFindSqlString() {
		return genericFindSqlString;
	}
	/**
	 * getGenericFindInsertPoints
	 */
	public int[] getGenericFindInsertPoints() {
		return genericFindInsertPoints;
	}
	private OrganizationBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.OrganizationBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.OrganizationBeanFinderObject temp_finderObject = new com.hps.july.persistence.OrganizationBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
