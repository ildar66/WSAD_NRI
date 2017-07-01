package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPFaultReportBean_f73eae9a
 */
public class EJSJDBCPersisterCMPFaultReportBean_f73eae9a extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderFaultReportBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO documents (document, insuranceact, blankdate, blanknumber, parentdocument, operator, isautodoc, blankindex, processsource, showtouser, state, processdestination, insurancedate, insuranceman, to2, needapprove, projectid, prjstatus, visualtype, owner, to, contragent, from, storagemanager, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO faultreport (document, agregateserial, newserial, eqplace, oldserial, comment, agregateresource, oldresource, newresource, techstuff, oldagregate, vivision, storagecardfrom, equipment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM faultreport  WHERE document = ?", "DELETE FROM documents  WHERE document = ?"};
	private static final String[] _storeString = {"UPDATE faultreport  SET agregateserial = ?, newserial = ?, eqplace = ?, oldserial = ?, comment = ?, agregateresource = ?, oldresource = ?, newresource = ?, techstuff = ?, oldagregate = ?, vivision = ?, storagecardfrom = ?, equipment = ? WHERE document = ?", "UPDATE documents  SET insuranceact = ?, blankdate = ?, blanknumber = ?, parentdocument = ?, operator = ?, isautodoc = ?, blankindex = ?, processsource = ?, showtouser = ?, state = ?, processdestination = ?, insurancedate = ?, insuranceman = ?, to2 = ?, needapprove = ?, projectid = ?, prjstatus = ?, visualtype = ?, owner = ?, to = ?, contragent = ?, from = ?, storagemanager = ?, type = ? WHERE document = ?"};
	private static final String _loadString = "SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.agregateserial, T2.newserial, T2.eqplace, T2.oldserial, T2.comment, T2.agregateresource, T2.oldresource, T2.newresource, T2.techstuff, T2.oldagregate, T2.vivision, T2.storagecardfrom, T2.equipment FROM faultreport  T2, documents  T1 WHERE T1.type = \'F\' AND T1.document = T2.document AND T1.document = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPFaultReportBean_f73eae9a
	 */
	public EJSJDBCPersisterCMPFaultReportBean_f73eae9a() throws java.rmi.RemoteException {
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
		FaultReportBean b = (FaultReportBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranceact);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.blankdate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.blankdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.blanknumber);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.parentdocument == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.parentdocument.intValue());
			}
			if (b.operator == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isautodoc));
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			pstmt.setInt(8, b.blankindex);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processSource);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.showtouser));
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentState);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processDestination);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.insurancedate == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.insurancedate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranseMan);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.to2 == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.to2.intValue());
			}
			pstmt.setInt(1, b.document);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.needapprove));
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.projectid == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.projectid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.prjstatus);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.visualtype == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.visualtype.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.owner_organization.intValue());
			}
			if (b.to_storageplace == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.to_storageplace.intValue());
			}
			if (b.contragent_organization == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.contragent_organization.intValue());
			}
			if (b.from_storageplace == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.from_storageplace.intValue());
			}
			if (b.storageManager_worker == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.storageManager_worker.intValue());
			}
			pstmt.setString(25, "F");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agregateserial);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.newserial);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.eqplace);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldserial);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.comment == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.comment);
			}
			if (b.agregateresource == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.agregateresource.intValue());
			}
			if (b.oldresource == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.oldresource.intValue());
			}
			if (b.newresource == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.newresource.intValue());
			}
			if (b.techStuff_worker == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.techStuff_worker.intValue());
			}
			if (b.oldagregate_storagecard == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.oldagregate_storagecard.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.division_division.intValue());
			}
			if (b.storagecardFrom_storagecard == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.storagecardFrom_storagecard.intValue());
			}
			if (b.equipment_storageplace == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.equipment_storageplace.intValue());
			}
			pstmt.setInt(1, b.document);
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
		FaultReportBean b = (FaultReportBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.document = _primaryKey.document;
		b.agregateserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		b.newserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(27));
		b.eqplace = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(28));
		b.oldserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		b.comment = resultSet.getString(30);
		tempint = resultSet.getInt(31);
		b.agregateresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(32);
		b.oldresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(33);
		b.newresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(34);
		b.techStuff_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(35);
		b.oldagregate_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(36);
		b.division_division = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(37);
		b.storagecardFrom_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(38);
		b.equipment_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		b.insuranceact = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.blankdate = resultSet.getDate(2);
		b.blanknumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(4);
		b.parentdocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(6));
		b.isautodoc = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.blankindex = resultSet.getInt(7);
		b.processSource = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(8));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(9));
		b.showtouser = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.documentState = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.processDestination = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(11));
		b.insurancedate = resultSet.getDate(12);
		b.insuranseMan = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		tempint = resultSet.getInt(14);
		b.to2 = resultSet.wasNull() ? null : new Integer(tempint);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		b.needapprove = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		tempint = resultSet.getInt(17);
		b.projectid = resultSet.wasNull() ? null : new Integer(tempint);
		b.prjstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		tempint = resultSet.getInt(19);
		b.visualtype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(20);
		b.owner_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		b.to_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		b.contragent_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(23);
		b.from_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(24);
		b.storageManager_worker = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		FaultReportBean b = (FaultReportBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.document);
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
		FaultReportBean b = (FaultReportBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		FaultReportBean b = (FaultReportBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(14, _primaryKey.document);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agregateserial);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.newserial);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.eqplace);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.oldserial);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.comment == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.comment);
			}
			if (b.agregateresource == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.agregateresource.intValue());
			}
			if (b.oldresource == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.oldresource.intValue());
			}
			if (b.newresource == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.newresource.intValue());
			}
			if (b.techStuff_worker == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.techStuff_worker.intValue());
			}
			if (b.oldagregate_storagecard == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.oldagregate_storagecard.intValue());
			}
			if (b.division_division == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.division_division.intValue());
			}
			if (b.storagecardFrom_storagecard == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.storagecardFrom_storagecard.intValue());
			}
			if (b.equipment_storageplace == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.equipment_storageplace.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(25, _primaryKey.document);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranceact);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.blankdate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.blankdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.blanknumber);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.parentdocument == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.parentdocument.intValue());
			}
			if (b.operator == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isautodoc));
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			pstmt.setInt(7, b.blankindex);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processSource);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.showtouser));
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentState);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processDestination);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.insurancedate == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.insurancedate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranseMan);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.to2 == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.to2.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.needapprove));
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.projectid == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.projectid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.prjstatus);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			if (b.visualtype == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.visualtype.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.owner_organization.intValue());
			}
			if (b.to_storageplace == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.to_storageplace.intValue());
			}
			if (b.contragent_organization == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.contragent_organization.intValue());
			}
			if (b.from_storageplace == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.from_storageplace.intValue());
			}
			if (b.storageManager_worker == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.storageManager_worker.intValue());
			}
			pstmt.setString(24, "F");
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
		FaultReportBean b = (FaultReportBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.document);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.document);
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
		com.hps.july.persistence.DocumentKey key = new com.hps.july.persistence.DocumentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.document = resultSet.getInt(15);
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
		java.lang.String discriminator = rs.getString(25).trim();
		if ( discriminator.equals("F") ) {
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
	 * findFaultReports2ByStoragecardFrom
	 */
	public EJSFinder findFaultReports2ByStoragecardFrom(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.agregateserial, T2.newserial, T2.eqplace, T2.oldserial, T2.comment, T2.agregateresource, T2.oldresource, T2.newresource, T2.techstuff, T2.oldagregate, T2.vivision, T2.storagecardfrom, T2.equipment FROM faultreport  T2, documents  T1 WHERE T1.type = \'F\' AND T1.document = T2.document AND T2.storagecardfrom = ?");
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
	 * findFaultReportByTechStuff
	 */
	public EJSFinder findFaultReportByTechStuff(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.agregateserial, T2.newserial, T2.eqplace, T2.oldserial, T2.comment, T2.agregateresource, T2.oldresource, T2.newresource, T2.techstuff, T2.oldagregate, T2.vivision, T2.storagecardfrom, T2.equipment FROM faultreport  T2, documents  T1 WHERE T1.type = \'F\' AND T1.document = T2.document AND T2.techstuff = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.worker);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findFaultReportByEquipment
	 */
	public EJSFinder findFaultReportByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.agregateserial, T2.newserial, T2.eqplace, T2.oldserial, T2.comment, T2.agregateresource, T2.oldresource, T2.newresource, T2.techstuff, T2.oldagregate, T2.vivision, T2.storagecardfrom, T2.equipment FROM faultreport  T2, documents  T1 WHERE T1.type = \'F\' AND T1.document = T2.document AND T2.equipment = ?");
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
	 * findFaultReportByDivision
	 */
	public EJSFinder findFaultReportByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.agregateserial, T2.newserial, T2.eqplace, T2.oldserial, T2.comment, T2.agregateresource, T2.oldresource, T2.newresource, T2.techstuff, T2.oldagregate, T2.vivision, T2.storagecardfrom, T2.equipment FROM faultreport  T2, documents  T1 WHERE T1.type = \'F\' AND T1.document = T2.document AND T2.vivision = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.division);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findFaultReports1ByOldagregate
	 */
	public EJSFinder findFaultReports1ByOldagregate(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.agregateserial, T2.newserial, T2.eqplace, T2.oldserial, T2.comment, T2.agregateresource, T2.oldresource, T2.newresource, T2.techstuff, T2.oldagregate, T2.vivision, T2.storagecardfrom, T2.equipment FROM faultreport  T2, documents  T1 WHERE T1.type = \'F\' AND T1.document = T2.document AND T2.oldagregate = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.FaultReport findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.FaultReport result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)key;
		try {
			try {
				result = (com.hps.july.persistence.FaultReport)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.document);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.FaultReport)tmpFinder.nextElement();
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
	 * findDocumentByQBE
	 */
	public EJSFinder findDocumentByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorageFrom, java.lang.Integer storageFrom, java.lang.Boolean isStorageTo, java.lang.Integer storageTo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findDocumentByQBE(isDate, datefrom, dateto, isOrganization, organization, isStorageFrom, storageFrom, isStorageTo, storageTo);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean useDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean useOwner, java.lang.Integer owner, java.lang.Boolean useDivision, java.lang.Integer division, java.lang.Boolean useWorker, java.lang.Integer worker, java.lang.Boolean usePosition, java.lang.Integer position, java.lang.Boolean useResource, java.lang.Integer resource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(useDate, datefrom, dateto, useOwner, owner, useDivision, division, useWorker, worker, usePosition, position, useResource, resource, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.agregateserial, T2.newserial, T2.eqplace, T2.oldserial, T2.comment, T2.agregateresource, T2.oldresource, T2.newresource, T2.techstuff, T2.oldagregate, T2.vivision, T2.storagecardfrom, T2.equipment FROM faultreport  T2, documents  T1 WHERE T1.type = \'F\' AND T1.document = T2.document AND ";
	private static final int[] genericFindInsertPoints = {655};
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
	private FaultReportBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.FaultReportBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.FaultReportBeanFinderObject temp_finderObject = new com.hps.july.persistence.FaultReportBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
