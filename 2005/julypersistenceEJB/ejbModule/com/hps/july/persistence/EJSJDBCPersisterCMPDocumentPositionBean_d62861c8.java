package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPDocumentPositionBean_d62861c8
 */
public class EJSJDBCPersisterCMPDocumentPositionBean_d62861c8 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderDocumentPositionBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO docpositions (docposition, agregateSerial, party, oldagregateserial, inventserial, resultClosed, sourceClosed, serialnumber, order, configuration, qty, oldplace, newplace, sourceBoxed, price, resultBoxed, comment, resultBroken, notes, sourceBroken, isfictserial, realserial, agregateresource, oldagregateresource, visualtagid, localserial, agrinventserial, agrlocserial, oldagrinventserial, oldagrlocserial, parentbtsdocpos, storagecardTo, owner, storageCardFrom, document, resource, agregate, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM docpositions  WHERE docposition = ?";
	private static final String _storeString = "UPDATE docpositions  SET agregateSerial = ?, party = ?, oldagregateserial = ?, inventserial = ?, resultClosed = ?, sourceClosed = ?, serialnumber = ?, order = ?, configuration = ?, qty = ?, oldplace = ?, newplace = ?, sourceBoxed = ?, price = ?, resultBoxed = ?, comment = ?, resultBroken = ?, notes = ?, sourceBroken = ?, isfictserial = ?, realserial = ?, agregateresource = ?, oldagregateresource = ?, visualtagid = ?, localserial = ?, agrinventserial = ?, agrlocserial = ?, oldagrinventserial = ?, oldagrlocserial = ?, parentbtsdocpos = ?, storagecardTo = ?, owner = ?, storageCardFrom = ?, document = ?, resource = ?, agregate = ?, type = ? WHERE docposition = ?";
	private static final String _loadString = "((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND T3.docposition = ?)  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND T3.docposition = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND T3.docposition = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND T3.docposition = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND T3.docposition = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND T3.docposition = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND T3.docposition = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPDocumentPositionBean_d62861c8
	 */
	public EJSJDBCPersisterCMPDocumentPositionBean_d62861c8() throws java.rmi.RemoteException {
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
		DocumentPositionBean b = (DocumentPositionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
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
			pstmt.setString(38, "Q");
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
		DocumentPositionBean b = (DocumentPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.docposition = _primaryKey.docposition;
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
		DocumentPositionBean b = (DocumentPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.docposition);
			pstmt.setInt(2, _primaryKey.docposition);
			pstmt.setInt(3, _primaryKey.docposition);
			pstmt.setInt(4, _primaryKey.docposition);
			pstmt.setInt(5, _primaryKey.docposition);
			pstmt.setInt(6, _primaryKey.docposition);
			pstmt.setInt(7, _primaryKey.docposition);
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
		DocumentPositionBean b = (DocumentPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		DocumentPositionBean b = (DocumentPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
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
			pstmt.setString(37, "Q");
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
		DocumentPositionBean b = (DocumentPositionBean) eb;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = new com.hps.july.persistence.DocumentPositionKey();
		_primaryKey.docposition = b.docposition;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
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
		if ( discriminator.equals("Q") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("C") ) {
				homeName = "ContractPosition";
			}
			else
			if ( discriminator.equals("I") ) {
				homeName = "I13nActPosition";
			}
			else
			if ( discriminator.equals("P") ) {
				homeName = "IBPMountPos";
			}
			else
			if ( discriminator.equals("N") ) {
				homeName = "InternalWayBillPosition";
			}
			else
			if ( discriminator.equals("W") ) {
				homeName = "InWayBillPosition";
			}
			else
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
	 * findByStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByStorageAfterDate(java.lang.Integer argStorage, java.sql.Date argDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.DocumentPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findByStorageAfterDate(argStorage, argDate);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.DocumentPosition)tmpFinder.nextElement();
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
	 * findByResourceSetAndStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByResourceSetAndStorageAfterDate(java.lang.Integer argDocument, java.lang.Integer argStorage, java.sql.Date argDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.DocumentPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findByResourceSetAndStorageAfterDate(argDocument, argStorage, argDate);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.DocumentPosition)tmpFinder.nextElement();
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
	 * findByDocumentQBE
	 */
	public EJSFinder findByDocumentQBE(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocumentQBE(argDocument, argPolicy, argNumber, isResource, argResource, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findDocumentPositionByResource
	 */
	public EJSFinder findDocumentPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND T3.resource = ?)  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND T3.resource = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND T3.resource = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND T3.resource = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND T3.resource = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND T3.resource = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND T3.resource = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			pstmt.setInt(2, inKey.resource);
			pstmt.setInt(3, inKey.resource);
			pstmt.setInt(4, inKey.resource);
			pstmt.setInt(5, inKey.resource);
			pstmt.setInt(6, inKey.resource);
			pstmt.setInt(7, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findDocumentPositionByDocument
	 */
	public EJSFinder findDocumentPositionByDocument(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND T3.document = ?)  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND T3.document = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND T3.document = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND T3.document = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND T3.document = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND T3.document = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND T3.document = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.document);
			pstmt.setInt(2, inKey.document);
			pstmt.setInt(3, inKey.document);
			pstmt.setInt(4, inKey.document);
			pstmt.setInt(5, inKey.document);
			pstmt.setInt(6, inKey.document);
			pstmt.setInt(7, inKey.document);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.DocumentPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.DocumentPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findMaxOrderPosition(argDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.DocumentPosition)tmpFinder.nextElement();
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
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Boolean isSerial, java.lang.String argSerial, java.lang.Boolean isParty, java.lang.String argParty, java.lang.Boolean isTo, java.lang.Integer argTo, java.lang.Boolean isFrom, java.lang.Integer argFrom, java.lang.String argDocType, java.lang.Boolean isAddDoc, java.lang.Integer argAddDoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(argResource, argOwner, isSerial, argSerial, isParty, argParty, isTo, argTo, isFrom, argFrom, argDocType, isAddDoc, argAddDoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByAgregateAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByAgregateAfterDate(java.lang.String argAgregatSerial, java.sql.Date argDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.DocumentPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findByAgregateAfterDate(argAgregatSerial, argDate);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.DocumentPosition)tmpFinder.nextElement();
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
	 * findDocumentPositionByOwner
	 */
	public EJSFinder findDocumentPositionByOwner(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND T3.owner = ?)  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND T3.owner = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND T3.owner = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND T3.owner = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND T3.owner = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND T3.owner = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND T3.owner = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.organization);
			pstmt.setInt(2, inKey.organization);
			pstmt.setInt(3, inKey.organization);
			pstmt.setInt(4, inKey.organization);
			pstmt.setInt(5, inKey.organization);
			pstmt.setInt(6, inKey.organization);
			pstmt.setInt(7, inKey.organization);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByDocumentQBE2
	 */
	public EJSFinder findByDocumentQBE2(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocumentQBE2(argDocument, argPolicy, argNumber, isOwner, owner, isResource, argResource, order);
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
	public com.hps.july.persistence.DocumentPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.DocumentPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.DocumentPositionKey _primaryKey = (com.hps.july.persistence.DocumentPositionKey)key;
		try {
			try {
				result = (com.hps.july.persistence.DocumentPosition)home.getBean(key);
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
				pstmt.setInt(3, _primaryKey.docposition);
				pstmt.setInt(4, _primaryKey.docposition);
				pstmt.setInt(5, _primaryKey.docposition);
				pstmt.setInt(6, _primaryKey.docposition);
				pstmt.setInt(7, _primaryKey.docposition);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.DocumentPosition)tmpFinder.nextElement();
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
	/**
	 * findAgregatePartsByAgregate
	 */
	public EJSFinder findAgregatePartsByAgregate(com.hps.july.persistence.DocumentPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND T3.agregate = ?)  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND T3.agregate = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND T3.agregate = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND T3.agregate = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND T3.agregate = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND T3.agregate = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND T3.agregate = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.docposition);
			pstmt.setInt(2, inKey.docposition);
			pstmt.setInt(3, inKey.docposition);
			pstmt.setInt(4, inKey.docposition);
			pstmt.setInt(5, inKey.docposition);
			pstmt.setInt(6, inKey.docposition);
			pstmt.setInt(7, inKey.docposition);
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
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.DocumentPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.DocumentPosition result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getFinderObject().findByDocumentSerialnum(argDocument, argSerial);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.DocumentPosition)tmpFinder.nextElement();
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
	 * findInDocumentPositionByCardTo
	 */
	public EJSFinder findInDocumentPositionByCardTo(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND T3.storagecardTo = ?)  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND T3.storagecardTo = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND T3.storagecardTo = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND T3.storagecardTo = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND T3.storagecardTo = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND T3.storagecardTo = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND T3.storagecardTo = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storagecard);
			pstmt.setInt(2, inKey.storagecard);
			pstmt.setInt(3, inKey.storagecard);
			pstmt.setInt(4, inKey.storagecard);
			pstmt.setInt(5, inKey.storagecard);
			pstmt.setInt(6, inKey.storagecard);
			pstmt.setInt(7, inKey.storagecard);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
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
	 * findOutDocumentPositionByCardFrom
	 */
	public EJSFinder findOutDocumentPositionByCardFrom(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND T3.storageCardFrom = ?)  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND T3.storageCardFrom = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND T3.storageCardFrom = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND T3.storageCardFrom = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND T3.storageCardFrom = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND T3.storageCardFrom = ?) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND T3.storageCardFrom = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storagecard);
			pstmt.setInt(2, inKey.storagecard);
			pstmt.setInt(3, inKey.storagecard);
			pstmt.setInt(4, inKey.storagecard);
			pstmt.setInt(5, inKey.storagecard);
			pstmt.setInt(6, inKey.storagecard);
			pstmt.setInt(7, inKey.storagecard);
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
	 * findByRequestResource
	 */
	public EJSFinder findByRequestResource(java.lang.Integer requestId, java.lang.Integer resourceId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByRequestResource(requestId, resourceId);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "((((((SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3 WHERE T3.type = \'Q\' AND )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, T4.state, T4.contentsscaned, T4.note, T4.cordocnum, T4.contract, CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, i13actpos  T4 WHERE T3.docposition = T4.docposition AND T3.type = \'I\' AND ) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM inlwbillspos  T6, docpositions  T3 WHERE T3.docposition = T6.docposition AND T3.type = \'N\' AND ) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), T6.docqty, T1.sectorD, T1.has_lna, T1.sectorO, T1.h_set1, T1.parentdocpos, T1.az_ant, T1.sectorC, T1.sectorB, T1.nakl_variation, T1.sectorG, T1.num_ant, T1.sectorE, T1.has_buster, T1.sectorF, T1.has_flt, T1.kind_ant, T1.kswn, T1.az_variation, T1.len_cable, T1.groundcnt, T1.sectorH, T1.sectorO1800, T1.ddk, T1.sectorA, T1.nakl, T1.docpostype, T1.input_power, T1.ksvn1800, T1.ksvn900, T1.ksvn800, T1.ksvn2000, T1.groundresource, CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM afsmountpos  T1, inlwbillspos  T6, docpositions  T3 WHERE T6.docposition = T1.docposition AND T3.docposition = T6.docposition AND T3.type = \'B\' AND ) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM docpositions  T3, ibpmountpos  T5 WHERE T3.docposition = T5.docposition AND T3.type = \'P\' AND ) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), T2.order, CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER) FROM contractpos  T2, docpositions  T3 WHERE T3.docposition = T2.docposition AND T3.type = \'C\' AND ) )  UNION ALL (SELECT T3.agregateSerial, T3.docposition, T3.party, T3.oldagregateserial, T3.inventserial, T3.resultClosed, T3.sourceClosed, T3.serialnumber, T3.order, T3.configuration, T3.qty, T3.oldplace, T3.newplace, T3.sourceBoxed, T3.price, T3.resultBoxed, T3.comment, T3.resultBroken, T3.notes, T3.sourceBroken, T3.isfictserial, T3.realserial, T3.agregateresource, T3.oldagregateresource, T3.visualtagid, T3.localserial, T3.agrinventserial, T3.agrlocserial, T3.oldagrinventserial, T3.oldagrlocserial, T3.parentbtsdocpos, T3.storagecardTo, T3.owner, T3.storageCardFrom, T3.document, T3.resource, T3.agregate, T3.type, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(100)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 3)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(32)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), T7.sourceprice, T7.outerdocposition FROM docpositions  T3, inwaybillspos  T7 WHERE T3.docposition = T7.docposition AND T3.type = \'W\' AND ) ";
	private static final int[] genericFindInsertPoints = {11780, 10036, 8292, 6534, 5123, 3383, 1695};
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
	private DocumentPositionBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.DocumentPositionBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.DocumentPositionBeanFinderObject temp_finderObject = new com.hps.july.persistence.DocumentPositionBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
