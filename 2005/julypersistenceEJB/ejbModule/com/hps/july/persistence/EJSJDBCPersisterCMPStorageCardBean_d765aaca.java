package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPStorageCardBean_d765aaca
 */
public class EJSJDBCPersisterCMPStorageCardBean_d765aaca extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderStorageCardBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO storagecards (storagecard, configuration, comment, party, policy, place, i13ndate, notes, broken, inventserial, price, qty, serialnumber, dateopened, closed, qty_broken, boxed, dateclosed, isfictserial, isapproved, localserial, resource, document, contract, storageplace, owner) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM storagecards  WHERE storagecard = ?";
	private static final String _storeString = "UPDATE storagecards  SET configuration = ?, comment = ?, party = ?, policy = ?, place = ?, i13ndate = ?, notes = ?, broken = ?, inventserial = ?, price = ?, qty = ?, serialnumber = ?, dateopened = ?, closed = ?, qty_broken = ?, boxed = ?, dateclosed = ?, isfictserial = ?, isapproved = ?, localserial = ?, resource = ?, document = ?, contract = ?, storageplace = ?, owner = ? WHERE storagecard = ?";
	private static final String _loadString = "SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE T1.storagecard = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPStorageCardBean_d765aaca
	 */
	public EJSJDBCPersisterCMPStorageCardBean_d765aaca() throws java.rmi.RemoteException {
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
		StorageCardBean b = (StorageCardBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.comment == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.comment);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.party);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.policy);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.place);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.i13nDate == null) {
				pstmt.setNull(7, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(7, b.i13nDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.broken);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manufserial);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.price == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.price);
			}
			if (b.qty == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serialnumber);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.dateopened == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.dateopened);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.closed);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.qtyBroken == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.qtyBroken);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.boxed);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.storagecard);
			if (b.dateclosed == null) {
				pstmt.setNull(18, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(18, b.dateclosed);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isfictserial));
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isapproved));
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.localserial);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			if (b.resource_resource == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.resource_resource.intValue());
			}
			if (b.lastDocument_document == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.lastDocument_document.intValue());
			}
			if (b.contract_document == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.contract_document.intValue());
			}
			if (b.currentstorage_storageplace == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.currentstorage_storageplace.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(26, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(26, b.owner_organization.intValue());
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
		StorageCardBean b = (StorageCardBean) eb;
		com.hps.july.persistence.StorageCardKey _primaryKey = (com.hps.july.persistence.StorageCardKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.storagecard = _primaryKey.storagecard;
		b.configuration = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.comment = resultSet.getString(2);
		b.party = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.policy = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.place = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.i13nDate = resultSet.getDate(6);
		b.notes = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.broken = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(8));
		b.manufserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.price = resultSet.getBigDecimal(10);
		b.qty = resultSet.getBigDecimal(11);
		b.serialnumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.dateopened = resultSet.getDate(13);
		b.closed = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(14));
		b.qtyBroken = resultSet.getBigDecimal(15);
		b.boxed = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		b.dateclosed = resultSet.getDate(18);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(19));
		b.isfictserial = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(20));
		b.isapproved = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.localserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(21));
		tempint = resultSet.getInt(22);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(23);
		b.lastDocument_document = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(24);
		b.contract_document = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(25);
		b.currentstorage_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(26);
		b.owner_organization = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		StorageCardBean b = (StorageCardBean) eb;
		com.hps.july.persistence.StorageCardKey _primaryKey = (com.hps.july.persistence.StorageCardKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.storagecard);
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
		StorageCardBean b = (StorageCardBean) eb;
		com.hps.july.persistence.StorageCardKey _primaryKey = new com.hps.july.persistence.StorageCardKey();
		_primaryKey.storagecard = b.storagecard;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		StorageCardBean b = (StorageCardBean) eb;
		com.hps.july.persistence.StorageCardKey _primaryKey = new com.hps.july.persistence.StorageCardKey();
		_primaryKey.storagecard = b.storagecard;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(26, _primaryKey.storagecard);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.comment == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.comment);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.party);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.policy);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.place);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.i13nDate == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.i13nDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.broken);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manufserial);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.price == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.price);
			}
			if (b.qty == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serialnumber);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.dateopened == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.dateopened);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.closed);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.qtyBroken == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.qtyBroken);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.boxed);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.dateclosed == null) {
				pstmt.setNull(17, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(17, b.dateclosed);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isfictserial));
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isapproved));
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.localserial);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			if (b.resource_resource == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.resource_resource.intValue());
			}
			if (b.lastDocument_document == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.lastDocument_document.intValue());
			}
			if (b.contract_document == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.contract_document.intValue());
			}
			if (b.currentstorage_storageplace == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.currentstorage_storageplace.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.owner_organization.intValue());
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
		StorageCardBean b = (StorageCardBean) eb;
		com.hps.july.persistence.StorageCardKey _primaryKey = new com.hps.july.persistence.StorageCardKey();
		_primaryKey.storagecard = b.storagecard;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.storagecard);
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
		com.hps.july.persistence.StorageCardKey key = new com.hps.july.persistence.StorageCardKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.storagecard = resultSet.getInt(17);
			return key;
		}
return null;
	}
	/**
	 * findStorageCardByCurrentstorage
	 */
	public EJSFinder findStorageCardByCurrentstorage(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE T1.storageplace = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storageplace);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByResourceQBE
	 */
	public EJSFinder findByResourceQBE(java.lang.Integer argResourceSubType, java.lang.Integer argStorage, java.lang.String argPolicy, java.lang.String argSerial, java.lang.String argParty, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByResourceQBE(argResourceSubType, argStorage, argPolicy, argSerial, argParty, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByMainAgregateOrderByResourceAsc
	 */
	public EJSFinder findByMainAgregateOrderByResourceAsc(java.lang.Integer argAgregate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE closed=\'N\' AND  storagecard IN (SELECT agregatepart FROM agregatecontents agr WHERE agr.agregate = ?) ORDER BY resource ASC");
			pstmt.setObject(1, argAgregate);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByStorageResource
	 */
	public EJSFinder findByStorageResource(java.lang.Integer storage, java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE storageplace=? and resource=? and closed = \"N\"");
			pstmt.setObject(1, storage);
			pstmt.setObject(2, resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByStorageNotAgregatedOrderByResourceAsc
	 */
	public EJSFinder findByStorageNotAgregatedOrderByResourceAsc(java.lang.Integer argStorage) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE storageplace = ? AND closed=\'N\' AND  NOT EXISTS (SELECT agregate FROM agregatecontents agr WHERE agr.agregatepart = t1.storagecard) ORDER BY resource ASC");
			pstmt.setObject(1, argStorage);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBadAgregatesByDocument
	 */
	public EJSFinder findBadAgregatesByDocument(java.lang.Integer document) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE t1.storagecard in                                                             (                                                                             select s1.storagecard from storagecards s, agregatecontents a,                    storagecards s1, docpositions d                                              where                                                                             s.serialnumber = d.serialnumber and d.document = ? and                         exists (                                                                          select dd.agregate                                                            from docpositions dd                                                          where dd.agregate = d.docposition and dd.document = d.document            )                                                                        and s.closed = \"N\"                                                            and a.agregate = s.storagecard                                                and s1.storagecard = a.agregatepart                                           and not exists (                                                               select ddd.docposition from docpositions ddd, docpositions dddd                where                                                                            ddd.agregate=dddd.docposition and                                             dddd.serialnumber = s1.serialnumber and                                       dddd.document = ddd.document and                                              ddd.document = d.document and                                              (                                                                             (s1.serialnumber = ddd.serialnumber                                              and s1.policy = \"S\" and s1.closed = \"N\")                                   or                                                                            (s1.party = ddd.party and s1.policy = \"P\" and ddd.qty = a.qty)                or                                                                            (s1.resource = ddd.resource and s1.policy = \"B\" and ddd.qty = a.qty)          )                                                                           )                                                                          )                                                                             ");
			pstmt.setObject(1, document);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findStorageCardByResource
	 */
	public EJSFinder findStorageCardByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE T1.resource = ?");
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
	 * findByStorageOwnerParty
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerParty(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.String argParty) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.StorageCard result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE closed = \"N\" and storageplace=? and owner = ? and party = ?");
			pstmt.setObject(1, argStorage);
			pstmt.setObject(2, argOwner);
			if (argParty == null) {
			   pstmt.setNull(3, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(3, argParty);
			}
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.StorageCard)tmpFinder.nextElement();
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
	 * findByPartyMaskOrderByPartyAsc
	 */
	public EJSFinder findByPartyMaskOrderByPartyAsc(java.lang.String argPartymask) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE upper(party) matches upper (?) and closed = \"N\" order by party ASC");
			if (argPartymask == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argPartymask);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findStorageCardByQBE3
	 */
	public EJSFinder findStorageCardByQBE3(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Boolean onlyWithoutParts, java.lang.Integer brokenType, java.lang.Integer documentKey, java.lang.Boolean useExcludeFilter, java.lang.Integer storageCard, java.lang.Boolean usePolicy, java.lang.String policy, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findStorageCardByQBE3(storageplace, isOwner, owner, isResourceset, resourceset, isResource, resource, isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, onlyWithoutParts, brokenType, documentKey, useExcludeFilter, storageCard, usePolicy, policy, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPartie
	 */
	public EJSFinder findByPartie(java.lang.String argParstart, java.lang.String argParend) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE party >= ? AND party <= ? and closed = \"N\"");
			if (argParstart == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argParstart);
			}
			if (argParend == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argParend);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByStorageOwnerResource
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerResource(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.StorageCard result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE closed = \"N\" and storageplace=? and owner = ? and resource = ?");
			pstmt.setObject(1, argStorage);
			pstmt.setObject(2, argOwner);
			pstmt.setObject(3, argResource);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.StorageCard)tmpFinder.nextElement();
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
	 * findStorageCardByOwner
	 */
	public EJSFinder findStorageCardByOwner(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE T1.owner = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.organization);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBySerie
	 */
	public EJSFinder findBySerie(java.lang.String argSerstart, java.lang.String argSerend) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE serialnumber >= ? AND serialnumber <= ? and closed = \"N\"");
			if (argSerstart == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argSerstart);
			}
			if (argSerend == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argSerend);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBySerialResource
	 */
	public com.hps.july.persistence.StorageCard findBySerialResource(java.lang.String argSerial, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.StorageCard result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE serialnumber = ? AND resource = ? AND closed = \'N\'");
			if (argSerial == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argSerial);
			}
			pstmt.setObject(2, argResource);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.StorageCard)tmpFinder.nextElement();
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
	 * findPosibillity2IgnoreI13nDate
	 */
	public com.hps.july.persistence.StorageCard findPosibillity2IgnoreI13nDate(java.lang.Integer argCard, java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.StorageCard result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE t1.storagecard=? and exists (select i.* from i13ndatesav i where i.storagecard=t1.storagecard and i.document in (select d.documentfrom from docdependencies d where d.documentto=? and d.type in (\"P\", \"S\") ))");
			pstmt.setObject(1, argCard);
			pstmt.setObject(2, argDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.StorageCard)tmpFinder.nextElement();
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
	 * findStorageCardByQBE
	 */
	public EJSFinder findStorageCardByQBE(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findStorageCardByQBE(storageplace, isOwner, owner, isResourceset, resourceset, isResource, resource, isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByStorageAndI13nResourceSetAct
	 */
	public EJSFinder findByStorageAndI13nResourceSetAct(java.lang.Integer argStorage, java.lang.Integer act) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE t1.storageplace = ? and t1.resource in ( select i.resource from i13nactresourceset i where i.document = ? )");
			pstmt.setObject(1, argStorage);
			pstmt.setObject(2, act);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findStorageCardByContract
	 */
	public EJSFinder findStorageCardByContract(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE T1.contract = ?");
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
	 * findByStorageNotInDoc
	 */
	public EJSFinder findByStorageNotInDoc(java.lang.Integer storageplace, java.lang.Boolean useAgregate, java.lang.Integer agregate, java.lang.Integer document, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByStorageNotInDoc(storageplace, useAgregate, agregate, document, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBySerialMaskOrderBySerialAsc
	 */
	public EJSFinder findBySerialMaskOrderBySerialAsc(java.lang.String argSermask) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE upper(serialnumber) matches upper (?) and closed = \"N\" order by serialnumber ASC");
			if (argSermask == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argSermask);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findCurrentStorageCardByLastDocument
	 */
	public EJSFinder findCurrentStorageCardByLastDocument(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE T1.document = ?");
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
	public com.hps.july.persistence.StorageCard findByPrimaryKey(com.hps.july.persistence.StorageCardKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.StorageCard) home.activateBean(key);
	}
	/**
	 * findBySerial
	 */
	public com.hps.july.persistence.StorageCard findBySerial(java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.StorageCard result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE serialnumber=? and closed = \"N\"");
			if (argSerial == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argSerial);
			}
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.StorageCard)tmpFinder.nextElement();
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
	 * findStorageCardByQBE2
	 */
	public EJSFinder findStorageCardByQBE2(java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findStorageCardByQBE2(isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, owner, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findClosedBySerialInStorage
	 */
	public com.hps.july.persistence.StorageCard findClosedBySerialInStorage(java.lang.String argSerial, java.lang.Integer argStorage) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.StorageCard result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE serialnumber=? and closed = \"Y\" and storageplace = ?");
			if (argSerial == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argSerial);
			}
			pstmt.setObject(2, argStorage);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.StorageCard)tmpFinder.nextElement();
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
	private static final String genericFindSqlString = "SELECT T1.configuration, T1.comment, T1.party, T1.policy, T1.place, T1.i13ndate, T1.notes, T1.broken, T1.inventserial, T1.price, T1.qty, T1.serialnumber, T1.dateopened, T1.closed, T1.qty_broken, T1.boxed, T1.storagecard, T1.dateclosed, T1.isfictserial, T1.isapproved, T1.localserial, T1.resource, T1.document, T1.contract, T1.storageplace, T1.owner FROM storagecards  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {377};
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
	private StorageCardBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.StorageCardBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.StorageCardBeanFinderObject temp_finderObject = new com.hps.july.persistence.StorageCardBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
