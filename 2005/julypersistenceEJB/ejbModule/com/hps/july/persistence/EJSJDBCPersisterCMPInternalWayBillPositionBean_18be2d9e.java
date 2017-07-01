package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPInternalWayBillPositionBean_18be2d9e
 */
public class EJSJDBCPersisterCMPInternalWayBillPositionBean_18be2d9e extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderInternalWayBillPositionBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO docpositions (docposition, agregateSerial, party, oldagregateserial, inventserial, resultClosed, sourceClosed, serialnumber, order, configuration, qty, oldplace, newplace, sourceBoxed, price, resultBoxed, comment, resultBroken, notes, sourceBroken, isfictserial, realserial, agregateresource, oldagregateresource, visualtagid, localserial, agrinventserial, agrlocserial, oldagrinventserial, oldagrlocserial, parentbtsdocpos, storagecardTo, owner, storageCardFrom, document, resource, agregate, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO inlwbillspos (docposition, docqty) VALUES (?, ?)"};
	private static final String[] _removeString = {"DELETE FROM inlwbillspos  WHERE docposition = ?", "DELETE FROM docpositions  WHERE docposition = ?"};
	private static final String[] _storeString = {"UPDATE inlwbillspos  SET docqty = ? WHERE docposition = ?", "UPDATE docpositions  SET agregateSerial = ?, party = ?, oldagregateserial = ?, inventserial = ?, resultClosed = ?, sourceClosed = ?, serialnumber = ?, order = ?, configuration = ?, qty = ?, oldplace = ?, newplace = ?, sourceBoxed = ?, price = ?, resultBoxed = ?, comment = ?, resultBroken = ?, notes = ?, sourceBroken = ?, isfictserial = ?, realserial = ?, agregateresource = ?, oldagregateresource = ?, visualtagid = ?, localserial = ?, agrinventserial = ?, agrlocserial = ?, oldagrinventserial = ?, oldagrlocserial = ?, parentbtsdocpos = ?, storagecardTo = ?, owner = ?, storageCardFrom = ?, document = ?, resource = ?, agregate = ?, type = ? WHERE docposition = ?"};
	private static final String _loadString = "(SELECT T2.agregateSerial, T2.docposition, T2.party, T2.oldagregateserial, T2.inventserial, T2.resultClosed, T2.sourceClosed, T2.serialnumber, T2.order, T2.configuration, T2.qty, T2.oldplace, T2.newplace, T2.sourceBoxed, T2.price, T2.resultBoxed, T2.comment, T2.resultBroken, T2.notes, T2.sourceBroken, T2.isfictserial, T2.realserial, T2.agregateresource, T2.oldagregateresource, T2.visualtagid, T2.localserial, T2.agrinventserial, T2.agrlocserial, T2.oldagrinventserial, T2.oldagrlocserial, T2.parentbtsdocpos, T2.storagecardTo, T2.owner, T2.storageCardFrom, T2.document, T2.resource, T2.agregate, T2.type, T3.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T3, docpositions  T2 WHERE T2.docposition = T3.docposition AND T2.type = \'N\' AND T2.docposition = ?)  UNION ALL (SELECT T2.agregateSerial, T2.docposition, T2.party, T2.oldagregateserial, T2.inventserial, T2.resultClosed, T2.sourceClosed, T2.serialnumber, T2.order, T2.configuration, T2.qty, T2.oldplace, T2.newplace, T2.sourceBoxed, T2.price, T2.resultBoxed, T2.comment, T2.resultBroken, T2.notes, T2.sourceBroken, T2.isfictserial, T2.realserial, T2.agregateresource, T2.oldagregateresource, T2.visualtagid, T2.localserial, T2.agrinventserial, T2.agrlocserial, T2.oldagrinventserial, T2.oldagrlocserial, T2.parentbtsdocpos, T2.storagecardTo, T2.owner, T2.storageCardFrom, T2.document, T2.resource, T2.agregate, T2.type, T3.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource FROM afsmountpos  T1, inlwbillspos  T3, docpositions  T2 WHERE T3.docposition = T1.docposition AND T2.docposition = T3.docposition AND T2.type = \'B\' AND T2.docposition = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPInternalWayBillPositionBean_18be2d9e
	 */
	public EJSJDBCPersisterCMPInternalWayBillPositionBean_18be2d9e() throws java.rmi.RemoteException {
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
		InternalWayBillPositionBean b = (InternalWayBillPositionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agregateSerial);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.docposition);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.party);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldAgregateSerial);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manufserial);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.resultClosed);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.sourceClosed);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serialnumber);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			pstmt.setInt(9, b.order);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.qty == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldplace);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.newplace);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.sourceBoxed);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.price == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.price);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.resultBoxed);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.comment == null) {
				pstmt.setNull(17, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(17, b.comment);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.resultBroken);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.notes == null) {
				pstmt.setNull(19, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(19, b.notes);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.sourceBroken);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isfictserial));
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.realserial);
			if (objectTemp == null) {
				pstmt.setNull(22, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(22, (java.lang.String)objectTemp);
			}
			if (b.agregateresource == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.agregateresource.intValue());
			}
			if (b.oldagregateresource == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.oldagregateresource.intValue());
			}
			if (b.visualtagid == null) {
				pstmt.setNull(25, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(25, b.visualtagid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.localserial);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agrmanufserial);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agrlocserial);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldagrmanufserial);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldagrlocserial);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			if (b.parentbtsdocpos == null) {
				pstmt.setNull(31, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(31, b.parentbtsdocpos.intValue());
			}
			if (b.cardTo_storagecard == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.cardTo_storagecard.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(33, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(33, b.owner_organization.intValue());
			}
			if (b.cardFrom_storagecard == null) {
				pstmt.setNull(34, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(34, b.cardFrom_storagecard.intValue());
			}
			if (b.document_document == null) {
				pstmt.setNull(35, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(35, b.document_document.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(36, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(36, b.resource_resource.intValue());
			}
			if (b.agregate_docposition == null) {
				pstmt.setNull(37, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(37, b.agregate_docposition.intValue());
			}
			pstmt.setString(38, "N");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			if (b.docQty == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.docQty);
			}
			pstmt.setInt(1, b.docposition);
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
		InternalWayBillPositionBean b = (InternalWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.docposition = _primaryKey.docposition;
		b.docQty = resultSet.getBigDecimal(39);
		b.agregateSerial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.party = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.oldAgregateSerial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.manufserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.resultClosed = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(6));
		b.sourceClosed = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(7));
		b.serialnumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.order = resultSet.getInt(9);
		b.configuration = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.qty = resultSet.getBigDecimal(11);
		b.oldplace = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		b.newplace = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.sourceBoxed = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(14));
		b.price = resultSet.getBigDecimal(15);
		b.resultBoxed = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		b.comment = resultSet.getString(17);
		b.resultBroken = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(18));
		b.notes = resultSet.getString(19);
		b.sourceBroken = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(20));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(21));
		b.isfictserial = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.realserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(22));
		tempint = resultSet.getInt(23);
		b.agregateresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(24);
		b.oldagregateresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(25);
		b.visualtagid = resultSet.wasNull() ? null : new Integer(tempint);
		b.localserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		b.agrmanufserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(27));
		b.agrlocserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(28));
		b.oldagrmanufserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.oldagrlocserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(30));
		tempint = resultSet.getInt(31);
		b.parentbtsdocpos = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(32);
		b.cardTo_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(33);
		b.owner_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(34);
		b.cardFrom_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(35);
		b.document_document = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(36);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(37);
		b.agregate_docposition = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		InternalWayBillPositionBean b = (InternalWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.docposition);
			pstmt.setInt(2, _primaryKey.docposition);
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
		InternalWayBillPositionBean b = (InternalWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		InternalWayBillPositionBean b = (InternalWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(2, _primaryKey.docposition);
			if (b.docQty == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.docQty);
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(38, _primaryKey.docposition);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agregateSerial);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.party);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldAgregateSerial);
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
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.resultClosed);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.sourceClosed);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serialnumber);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			pstmt.setInt(8, b.order);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.configuration);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.qty == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldplace);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.newplace);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.sourceBoxed);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.price == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.price);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.resultBoxed);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.comment == null) {
				pstmt.setNull(16, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(16, b.comment);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.resultBroken);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			if (b.notes == null) {
				pstmt.setNull(18, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(18, b.notes);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.sourceBroken);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isfictserial));
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.realserial);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			if (b.agregateresource == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.agregateresource.intValue());
			}
			if (b.oldagregateresource == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.oldagregateresource.intValue());
			}
			if (b.visualtagid == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.visualtagid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.localserial);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agrmanufserial);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agrlocserial);
			if (objectTemp == null) {
				pstmt.setNull(27, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(27, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldagrmanufserial);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldagrlocserial);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			if (b.parentbtsdocpos == null) {
				pstmt.setNull(30, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(30, b.parentbtsdocpos.intValue());
			}
			if (b.cardTo_storagecard == null) {
				pstmt.setNull(31, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(31, b.cardTo_storagecard.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.owner_organization.intValue());
			}
			if (b.cardFrom_storagecard == null) {
				pstmt.setNull(33, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(33, b.cardFrom_storagecard.intValue());
			}
			if (b.document_document == null) {
				pstmt.setNull(34, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(34, b.document_document.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(35, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(35, b.resource_resource.intValue());
			}
			if (b.agregate_docposition == null) {
				pstmt.setNull(36, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(36, b.agregate_docposition.intValue());
			}
			pstmt.setString(37, "N");
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
		InternalWayBillPositionBean b = (InternalWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.docposition);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.docposition);
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
		com.hps.july.persistence.DocumentPositionKey key = new com.hps.july.persistence.DocumentPositionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.docposition = resultSet.getInt(2);
			return key;
		}
return null;
	}
	/**
	 * getBean
	 */
	public javax.ejb.EJBObject getBean(Object obj) throws Exception {
		javax.ejb.EJBObject bean = null;
		ResultSet rs = (ResultSet) obj;
		java.lang.String discriminator = rs.getString(38).trim();
		if ( discriminator.equals("N") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("B") ) {
				homeName = "AfsMountPos";
			}
			if (homeName != null) {
				bean = ((com.ibm.ejs.container.EJSHome)home).getBean(homeName, getPrimaryKey(rs), rs);
			}
		}
		if (bean == null) {
			try{
				if (rs != null) rs.close();
			}
			catch (SQLException sqlExc) {}
			throw new EJSPersistenceException("Unknown or superclass discriminator value retrieved from database.");
		}
		return bean;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.InternalWayBillPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.InternalWayBillPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)key;
		try {
			try {
				result = (com.hps.july.persistence.InternalWayBillPosition)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.docposition);
				pstmt.setInt(2, _primaryKey.docposition);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.InternalWayBillPosition)tmpFinder.nextElement();
				}
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
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.InternalWayBillPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.InternalWayBillPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findMaxOrderPosition(argDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.InternalWayBillPosition)tmpFinder.nextElement();
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
	 * findByDocOrderByAgregateAsc
	 */
	public EJSFinder findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocOrderByAgregateAsc(argDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.InternalWayBillPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.InternalWayBillPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocumentSerialnum(argDocument, argSerial);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.InternalWayBillPosition)tmpFinder.nextElement();
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
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public EJSFinder findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findDocPositionsByDocAndPolicyOrderByOrderDesc(argDocument, argPolicy);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public EJSFinder findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findDocPositionsByDocAndPolicyOrderByOrderAsc(argDocument, argPolicy);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public EJSFinder findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findDocPositionsByDocOrderByOrderAsc(argDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByDocOrderByAgregateDesc
	 */
	public EJSFinder findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocOrderByAgregateDesc(argDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public EJSFinder findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findDocPositionsByDocOrderByOrderDesc(argDocument);
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
	public EJSFinder findBadAgregatesByDocument(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findBadAgregatesByDocument(argDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "(SELECT T2.agregateSerial, T2.docposition, T2.party, T2.oldagregateserial, T2.inventserial, T2.resultClosed, T2.sourceClosed, T2.serialnumber, T2.order, T2.configuration, T2.qty, T2.oldplace, T2.newplace, T2.sourceBoxed, T2.price, T2.resultBoxed, T2.comment, T2.resultBroken, T2.notes, T2.sourceBroken, T2.isfictserial, T2.realserial, T2.agregateresource, T2.oldagregateresource, T2.visualtagid, T2.localserial, T2.agrinventserial, T2.agrlocserial, T2.oldagrinventserial, T2.oldagrlocserial, T2.parentbtsdocpos, T2.storagecardTo, T2.owner, T2.storageCardFrom, T2.document, T2.resource, T2.agregate, T2.type, T3.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T3, docpositions  T2 WHERE T2.docposition = T3.docposition AND T2.type = \'N\' AND )  UNION ALL (SELECT T2.agregateSerial, T2.docposition, T2.party, T2.oldagregateserial, T2.inventserial, T2.resultClosed, T2.sourceClosed, T2.serialnumber, T2.order, T2.configuration, T2.qty, T2.oldplace, T2.newplace, T2.sourceBoxed, T2.price, T2.resultBoxed, T2.comment, T2.resultBroken, T2.notes, T2.sourceBroken, T2.isfictserial, T2.realserial, T2.agregateresource, T2.oldagregateresource, T2.visualtagid, T2.localserial, T2.agrinventserial, T2.agrlocserial, T2.oldagrinventserial, T2.oldagrlocserial, T2.parentbtsdocpos, T2.storagecardTo, T2.owner, T2.storageCardFrom, T2.document, T2.resource, T2.agregate, T2.type, T3.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource FROM afsmountpos  T1, inlwbillspos  T3, docpositions  T2 WHERE T3.docposition = T1.docposition AND T2.docposition = T3.docposition AND T2.type = \'B\' AND ) ";
	private static final int[] genericFindInsertPoints = {2718, 1517};
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
	private InternalWayBillPositionBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.InternalWayBillPositionBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.InternalWayBillPositionBeanFinderObject temp_finderObject = new com.hps.july.persistence.InternalWayBillPositionBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
