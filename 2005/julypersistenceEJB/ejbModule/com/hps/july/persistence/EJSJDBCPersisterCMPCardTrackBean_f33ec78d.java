package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCardTrackBean_f33ec78d
 */
public class EJSJDBCPersisterCMPCardTrackBean_f33ec78d extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderCardTrackBean {
	private static final String _createString = "INSERT INTO cardtracks (trackid, deltaprice, oldconfiguration, actiontype, when, document, from, to, storagecard) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM cardtracks  WHERE trackid = ?";
	private static final String _storeString = "UPDATE cardtracks  SET deltaprice = ?, oldconfiguration = ?, actiontype = ?, when = ?, document = ?, from = ?, to = ?, storagecard = ? WHERE trackid = ?";
	private static final String _loadString = "SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE T1.trackid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCardTrackBean_f33ec78d
	 */
	public EJSJDBCPersisterCMPCardTrackBean_f33ec78d() throws java.rmi.RemoteException {
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
		CardTrackBean b = (CardTrackBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.deltaprice == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.deltaprice);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.actiontype);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.when == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.when);
			}
			pstmt.setInt(1, b.trackId);
			if (b.document_document == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.document_document.intValue());
			}
			if (b.from_storageplace == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.from_storageplace.intValue());
			}
			if (b.to_storageplace == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.to_storageplace.intValue());
			}
			if (b.card_storagecard == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.card_storagecard.intValue());
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
		CardTrackBean b = (CardTrackBean) eb;
		com.hps.july.persistence.CardTrackKey _primaryKey = (com.hps.july.persistence.CardTrackKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.trackId = _primaryKey.trackId;
		b.deltaprice = resultSet.getBigDecimal(1);
		b.configuration = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.actiontype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.when = resultSet.getTimestamp(4);
		tempint = resultSet.getInt(6);
		b.document_document = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.from_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.to_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.card_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CardTrackBean b = (CardTrackBean) eb;
		com.hps.july.persistence.CardTrackKey _primaryKey = (com.hps.july.persistence.CardTrackKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.trackId);
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
		CardTrackBean b = (CardTrackBean) eb;
		com.hps.july.persistence.CardTrackKey _primaryKey = new com.hps.july.persistence.CardTrackKey();
		_primaryKey.trackId = b.trackId;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CardTrackBean b = (CardTrackBean) eb;
		com.hps.july.persistence.CardTrackKey _primaryKey = new com.hps.july.persistence.CardTrackKey();
		_primaryKey.trackId = b.trackId;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(9, _primaryKey.trackId);
			if (b.deltaprice == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.deltaprice);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.actiontype);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.when == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.when);
			}
			if (b.document_document == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.document_document.intValue());
			}
			if (b.from_storageplace == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.from_storageplace.intValue());
			}
			if (b.to_storageplace == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.to_storageplace.intValue());
			}
			if (b.card_storagecard == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.card_storagecard.intValue());
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
		CardTrackBean b = (CardTrackBean) eb;
		com.hps.july.persistence.CardTrackKey _primaryKey = new com.hps.july.persistence.CardTrackKey();
		_primaryKey.trackId = b.trackId;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.trackId);
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
		com.hps.july.persistence.CardTrackKey key = new com.hps.july.persistence.CardTrackKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.trackId = resultSet.getInt(5);
			return key;
		}
return null;
	}
	/**
	 * findCardTrackByDocument
	 */
	public EJSFinder findCardTrackByDocument(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE T1.document = ?");
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
	 * findCardTrackFromByFrom
	 */
	public EJSFinder findCardTrackFromByFrom(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE T1.from = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.CardTrack findByPrimaryKey(com.hps.july.persistence.CardTrackKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.CardTrack) home.activateBean(key);
	}
	/**
	 * findBySerialAfterId
	 */
	public EJSFinder findBySerialAfterId(java.lang.String argSerial, java.lang.Integer id) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE serial = ? and trackid > ? order by trackid asc");
			if (argSerial == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argSerial);
			}
			pstmt.setObject(2, id);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findCardTrackByCard
	 */
	public EJSFinder findCardTrackByCard(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE T1.storagecard = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storagecard);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLastDocumentTrack
	 */
	public com.hps.july.persistence.CardTrack findLastDocumentTrack(java.lang.Integer argCard, java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.CardTrack result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE trackid = (select max(c1.trackid) from cardtracks c1 where c1.storagecard = ? and c1.document=?)");
			pstmt.setObject(1, argCard);
			pstmt.setObject(2, argDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.CardTrack)tmpFinder.nextElement();
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
	 * findCardTrackToByTo
	 */
	public EJSFinder findCardTrackToByTo(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE T1.to = ?");
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
	 * findBeforeDocument
	 */
	public com.hps.july.persistence.CardTrack findBeforeDocument(java.lang.Integer argCard, java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.CardTrack result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.deltaprice, T1.oldconfiguration, T1.actiontype, T1.when, T1.trackid, T1.document, T1.from, T1.to, T1.storagecard FROM cardtracks  T1 WHERE trackid = (select max(c.trackid) from cardtracks c where c.storagecard = ? and c.trackid < (select NVL(max(c1.trackid), 2147483648) from cardtracks c1 where c1.storagecard = c.storagecard and c1.document=?) )");
			pstmt.setObject(1, argCard);
			pstmt.setObject(2, argDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.CardTrack)tmpFinder.nextElement();
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
}
