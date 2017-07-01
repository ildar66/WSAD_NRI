package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPInWayBillPositionBean_10168c1a
 */
public class EJSJDBCPersisterCMPInWayBillPositionBean_10168c1a extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderInWayBillPositionBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO docpositions (docposition, agregateSerial, party, oldagregateserial, inventserial, resultClosed, sourceClosed, serialnumber, order, configuration, qty, oldplace, newplace, sourceBoxed, price, resultBoxed, comment, resultBroken, notes, sourceBroken, isfictserial, realserial, agregateresource, oldagregateresource, visualtagid, localserial, agrinventserial, agrlocserial, oldagrinventserial, oldagrlocserial, parentbtsdocpos, storagecardTo, owner, storageCardFrom, document, resource, agregate, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO inwaybillspos (docposition, sourceprice, outerdocposition) VALUES (?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM inwaybillspos  WHERE docposition = ?", "DELETE FROM docpositions  WHERE docposition = ?"};
	private static final String[] _storeString = {"UPDATE inwaybillspos  SET sourceprice = ?, outerdocposition = ? WHERE docposition = ?", "UPDATE docpositions  SET agregateSerial = ?, party = ?, oldagregateserial = ?, inventserial = ?, resultClosed = ?, sourceClosed = ?, serialnumber = ?, order = ?, configuration = ?, qty = ?, oldplace = ?, newplace = ?, sourceBoxed = ?, price = ?, resultBoxed = ?, comment = ?, resultBroken = ?, notes = ?, sourceBroken = ?, isfictserial = ?, realserial = ?, agregateresource = ?, oldagregateresource = ?, visualtagid = ?, localserial = ?, agrinventserial = ?, agrlocserial = ?, oldagrinventserial = ?, oldagrlocserial = ?, parentbtsdocpos = ?, storagecardTo = ?, owner = ?, storageCardFrom = ?, document = ?, resource = ?, agregate = ?, type = ? WHERE docposition = ?"};
	private static final String _loadString = "SELECT T1.agregateSerial, T1.docposition, T1.party, T1.oldagregateserial, T1.inventserial, T1.resultClosed, T1.sourceClosed, T1.serialnumber, T1.order, T1.configuration, T1.qty, T1.oldplace, T1.newplace, T1.sourceBoxed, T1.price, T1.resultBoxed, T1.comment, T1.resultBroken, T1.notes, T1.sourceBroken, T1.isfictserial, T1.realserial, T1.agregateresource, T1.oldagregateresource, T1.visualtagid, T1.localserial, T1.agrinventserial, T1.agrlocserial, T1.oldagrinventserial, T1.oldagrlocserial, T1.parentbtsdocpos, T1.storagecardTo, T1.owner, T1.storageCardFrom, T1.document, T1.resource, T1.agregate, T1.type, T2.sourceprice, T2.outerdocposition FROM docpositions  T1, inwaybillspos  T2 WHERE T1.type = \'W\' AND T1.docposition = T2.docposition AND T1.docposition = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPInWayBillPositionBean_10168c1a
	 */
	public EJSJDBCPersisterCMPInWayBillPositionBean_10168c1a() throws java.rmi.RemoteException {
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
		InWayBillPositionBean b = (InWayBillPositionBean) eb;
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
			pstmt.setString(38, "W");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			if (b.sourcePrice == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.sourcePrice);
			}
			if (b.outerDocPosition_outerDocPosition == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.outerDocPosition_outerDocPosition.intValue());
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
		InWayBillPositionBean b = (InWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.docposition = _primaryKey.docposition;
		b.sourcePrice = resultSet.getBigDecimal(39);
		tempint = resultSet.getInt(40);
		b.outerDocPosition_outerDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
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
		InWayBillPositionBean b = (InWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.docposition);
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
		InWayBillPositionBean b = (InWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		InWayBillPositionBean b = (InWayBillPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(3, _primaryKey.docposition);
			if (b.sourcePrice == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.sourcePrice);
			}
			if (b.outerDocPosition_outerDocPosition == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.outerDocPosition_outerDocPosition.intValue());
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
			pstmt.setString(37, "W");
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
		InWayBillPositionBean b = (InWayBillPositionBean) eb;
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
		if ( discriminator.equals("W") ) {
			bean = super.getBean(obj);
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
	public com.hps.july.persistence.InWayBillPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.InWayBillPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)key;
		try {
			try {
				result = (com.hps.july.persistence.InWayBillPosition)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.docposition);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.InWayBillPosition)tmpFinder.nextElement();
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
	public com.hps.july.persistence.InWayBillPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.InWayBillPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findMaxOrderPosition(argDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.InWayBillPosition)tmpFinder.nextElement();
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
	 * findInWayBillPositionByOuterDocPosition
	 */
	public EJSFinder findInWayBillPositionByOuterDocPosition(com.hps.july.persistence.OuterDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.agregateSerial, T1.docposition, T1.party, T1.oldagregateserial, T1.inventserial, T1.resultClosed, T1.sourceClosed, T1.serialnumber, T1.order, T1.configuration, T1.qty, T1.oldplace, T1.newplace, T1.sourceBoxed, T1.price, T1.resultBoxed, T1.comment, T1.resultBroken, T1.notes, T1.sourceBroken, T1.isfictserial, T1.realserial, T1.agregateresource, T1.oldagregateresource, T1.visualtagid, T1.localserial, T1.agrinventserial, T1.agrlocserial, T1.oldagrinventserial, T1.oldagrlocserial, T1.parentbtsdocpos, T1.storagecardTo, T1.owner, T1.storageCardFrom, T1.document, T1.resource, T1.agregate, T1.type, T2.sourceprice, T2.outerdocposition FROM docpositions  T1, inwaybillspos  T2 WHERE T1.type = \'W\' AND T1.docposition = T2.docposition AND T2.outerdocposition = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.outerDocPosition);
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
	public com.hps.july.persistence.InWayBillPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.InWayBillPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocumentSerialnum(argDocument, argSerial);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.InWayBillPosition)tmpFinder.nextElement();
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
	private static final String genericFindSqlString = "SELECT T1.agregateSerial, T1.docposition, T1.party, T1.oldagregateserial, T1.inventserial, T1.resultClosed, T1.sourceClosed, T1.serialnumber, T1.order, T1.configuration, T1.qty, T1.oldplace, T1.newplace, T1.sourceBoxed, T1.price, T1.resultBoxed, T1.comment, T1.resultBroken, T1.notes, T1.sourceBroken, T1.isfictserial, T1.realserial, T1.agregateresource, T1.oldagregateresource, T1.visualtagid, T1.localserial, T1.agrinventserial, T1.agrlocserial, T1.oldagrinventserial, T1.oldagrlocserial, T1.parentbtsdocpos, T1.storagecardTo, T1.owner, T1.storageCardFrom, T1.document, T1.resource, T1.agregate, T1.type, T2.sourceprice, T2.outerdocposition FROM docpositions  T1, inwaybillspos  T2 WHERE T1.type = \'W\' AND T1.docposition = T2.docposition AND ";
	private static final int[] genericFindInsertPoints = {744};
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
	private InWayBillPositionBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.InWayBillPositionBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.InWayBillPositionBeanFinderObject temp_finderObject = new com.hps.july.persistence.InWayBillPositionBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
