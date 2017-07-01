package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPContractBean_f0f90933
 */
public class EJSJDBCPersisterCMPContractBean_f0f90933 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderContractBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO documents (document, insuranceact, blankdate, blanknumber, parentdocument, operator, isautodoc, blankindex, processsource, showtouser, state, processdestination, insurancedate, insuranceman, to2, needapprove, projectid, prjstatus, visualtype, owner, to, contragent, from, storagemanager, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO contracts (document, startdate, sum, name, finishdate, contractstate, textFileName, timelinefilename, worker, currency, baseagreement, controller, sypplytype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM contracts  WHERE document = ?", "DELETE FROM documents  WHERE document = ?"};
	private static final String[] _storeString = {"UPDATE contracts  SET startdate = ?, sum = ?, name = ?, finishdate = ?, contractstate = ?, textFileName = ?, timelinefilename = ?, worker = ?, currency = ?, baseagreement = ?, controller = ?, sypplytype = ? WHERE document = ?", "UPDATE documents  SET insuranceact = ?, blankdate = ?, blanknumber = ?, parentdocument = ?, operator = ?, isautodoc = ?, blankindex = ?, processsource = ?, showtouser = ?, state = ?, processdestination = ?, insurancedate = ?, insuranceman = ?, to2 = ?, needapprove = ?, projectid = ?, prjstatus = ?, visualtype = ?, owner = ?, to = ?, contragent = ?, from = ?, storagemanager = ?, type = ? WHERE document = ?"};
	private static final String _loadString = "SELECT T2.insuranceact, T2.blankdate, T2.blanknumber, T2.parentdocument, T2.operator, T2.isautodoc, T2.blankindex, T2.processsource, T2.showtouser, T2.state, T2.processdestination, T2.insurancedate, T2.insuranceman, T2.to2, T2.document, T2.needapprove, T2.projectid, T2.prjstatus, T2.visualtype, T2.owner, T2.to, T2.contragent, T2.from, T2.storagemanager, T2.type, T1.startdate, T1.sum, T1.name, T1.finishdate, T1.contractstate, T1.textFileName, T1.timelinefilename, T1.worker, T1.currency, T1.baseagreement, T1.controller, T1.sypplytype FROM contracts  T1, documents  T2 WHERE T2.type = \'C\' AND T2.document = T1.document AND T2.document = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPContractBean_f0f90933
	 */
	public EJSJDBCPersisterCMPContractBean_f0f90933() throws java.rmi.RemoteException {
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
		ContractBean b = (ContractBean) eb;
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
			pstmt.setString(25, "C");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			if (b.startDate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.startDate);
			}
			if (b.sum == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.sum);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.finishDate == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.finishDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contractState);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.textFileName);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.timelineFileName);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.worker_worker == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.worker_worker.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.currency_currency.intValue());
			}
			if (b.baseAgreement_baseagreement == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.baseAgreement_baseagreement.intValue());
			}
			if (b.controller_worker == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.controller_worker.intValue());
			}
			if (b.supplyType_supplyType == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.supplyType_supplyType.intValue());
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
		ContractBean b = (ContractBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.document = _primaryKey.document;
		b.startDate = resultSet.getDate(26);
		b.sum = resultSet.getBigDecimal(27);
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(28));
		b.finishDate = resultSet.getDate(29);
		b.contractState = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(30));
		b.textFileName = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(31));
		b.timelineFileName = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(32));
		tempint = resultSet.getInt(33);
		b.worker_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(34);
		b.currency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(35);
		b.baseAgreement_baseagreement = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(36);
		b.controller_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(37);
		b.supplyType_supplyType = resultSet.wasNull() ? null : new Integer(tempint);
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
		ContractBean b = (ContractBean) eb;
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
		ContractBean b = (ContractBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ContractBean b = (ContractBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(13, _primaryKey.document);
			if (b.startDate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.startDate);
			}
			if (b.sum == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.sum);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.finishDate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.finishDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contractState);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.textFileName);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.timelineFileName);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.worker_worker == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.worker_worker.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.currency_currency.intValue());
			}
			if (b.baseAgreement_baseagreement == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.baseAgreement_baseagreement.intValue());
			}
			if (b.controller_worker == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.controller_worker.intValue());
			}
			if (b.supplyType_supplyType == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.supplyType_supplyType.intValue());
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
			pstmt.setString(24, "C");
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
		ContractBean b = (ContractBean) eb;
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
		if ( discriminator.equals("C") ) {
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
	 * findControlledContractByController
	 */
	public EJSFinder findControlledContractByController(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.insuranceact, T2.blankdate, T2.blanknumber, T2.parentdocument, T2.operator, T2.isautodoc, T2.blankindex, T2.processsource, T2.showtouser, T2.state, T2.processdestination, T2.insurancedate, T2.insuranceman, T2.to2, T2.document, T2.needapprove, T2.projectid, T2.prjstatus, T2.visualtype, T2.owner, T2.to, T2.contragent, T2.from, T2.storagemanager, T2.type, T1.startdate, T1.sum, T1.name, T1.finishdate, T1.contractstate, T1.textFileName, T1.timelinefilename, T1.worker, T1.currency, T1.baseagreement, T1.controller, T1.sypplytype FROM contracts  T1, documents  T2 WHERE T2.type = \'C\' AND T2.document = T1.document AND T1.controller = ?");
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
	 * findContractBySupplyType
	 */
	public EJSFinder findContractBySupplyType(com.hps.july.persistence.SupplyTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.insuranceact, T2.blankdate, T2.blanknumber, T2.parentdocument, T2.operator, T2.isautodoc, T2.blankindex, T2.processsource, T2.showtouser, T2.state, T2.processdestination, T2.insurancedate, T2.insuranceman, T2.to2, T2.document, T2.needapprove, T2.projectid, T2.prjstatus, T2.visualtype, T2.owner, T2.to, T2.contragent, T2.from, T2.storagemanager, T2.type, T1.startdate, T1.sum, T1.name, T1.finishdate, T1.contractstate, T1.textFileName, T1.timelinefilename, T1.worker, T1.currency, T1.baseagreement, T1.controller, T1.sypplytype FROM contracts  T1, documents  T2 WHERE T2.type = \'C\' AND T2.document = T1.document AND T1.sypplytype = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.supplyType);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findContractByCurrency
	 */
	public EJSFinder findContractByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.insuranceact, T2.blankdate, T2.blanknumber, T2.parentdocument, T2.operator, T2.isautodoc, T2.blankindex, T2.processsource, T2.showtouser, T2.state, T2.processdestination, T2.insurancedate, T2.insuranceman, T2.to2, T2.document, T2.needapprove, T2.projectid, T2.prjstatus, T2.visualtype, T2.owner, T2.to, T2.contragent, T2.from, T2.storagemanager, T2.type, T1.startdate, T1.sum, T1.name, T1.finishdate, T1.contractstate, T1.textFileName, T1.timelinefilename, T1.worker, T1.currency, T1.baseagreement, T1.controller, T1.sypplytype FROM contracts  T1, documents  T2 WHERE T2.type = \'C\' AND T2.document = T1.document AND T1.currency = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.currency);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findContractByQBE2
	 */
	public EJSFinder findContractByQBE2(java.lang.Boolean isSupplyType, java.lang.Integer sypplyType, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.String matchName, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findContractByQBE2(isSupplyType, sypplyType, isOwner, owner, isContragent, contragent, matchName, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findContractByQBE3
	 */
	public EJSFinder findContractByQBE3(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argBlankDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findContractByQBE3(argSupplyType, isBaseAgreement, argBaseAgreement, isOrganization, argOrganization, isContragent, argContragent, argBlankDate, argFinishDate, isState, argState, order);
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
	public com.hps.july.persistence.Contract findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Contract result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)key;
		try {
			try {
				result = (com.hps.july.persistence.Contract)home.getBean(key);
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
					result = (com.hps.july.persistence.Contract)tmpFinder.nextElement();
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
	 * findWorkedContractByWorker
	 */
	public EJSFinder findWorkedContractByWorker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.insuranceact, T2.blankdate, T2.blanknumber, T2.parentdocument, T2.operator, T2.isautodoc, T2.blankindex, T2.processsource, T2.showtouser, T2.state, T2.processdestination, T2.insurancedate, T2.insuranceman, T2.to2, T2.document, T2.needapprove, T2.projectid, T2.prjstatus, T2.visualtype, T2.owner, T2.to, T2.contragent, T2.from, T2.storagemanager, T2.type, T1.startdate, T1.sum, T1.name, T1.finishdate, T1.contractstate, T1.textFileName, T1.timelinefilename, T1.worker, T1.currency, T1.baseagreement, T1.controller, T1.sypplytype FROM contracts  T1, documents  T2 WHERE T2.type = \'C\' AND T2.document = T1.document AND T1.worker = ?");
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
	 * findContractByBaseAgreement
	 */
	public EJSFinder findContractByBaseAgreement(com.hps.july.persistence.BaseAgreementKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.insuranceact, T2.blankdate, T2.blanknumber, T2.parentdocument, T2.operator, T2.isautodoc, T2.blankindex, T2.processsource, T2.showtouser, T2.state, T2.processdestination, T2.insurancedate, T2.insuranceman, T2.to2, T2.document, T2.needapprove, T2.projectid, T2.prjstatus, T2.visualtype, T2.owner, T2.to, T2.contragent, T2.from, T2.storagemanager, T2.type, T1.startdate, T1.sum, T1.name, T1.finishdate, T1.contractstate, T1.textFileName, T1.timelinefilename, T1.worker, T1.currency, T1.baseagreement, T1.controller, T1.sypplytype FROM contracts  T1, documents  T2 WHERE T2.type = \'C\' AND T2.document = T1.document AND T1.baseagreement = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.baseagreement);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findContractByQBE
	 */
	public EJSFinder findContractByQBE(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argStartDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findContractByQBE(argSupplyType, isBaseAgreement, argBaseAgreement, isOrganization, argOrganization, isContragent, argContragent, argStartDate, argFinishDate, isState, argState, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T2.insuranceact, T2.blankdate, T2.blanknumber, T2.parentdocument, T2.operator, T2.isautodoc, T2.blankindex, T2.processsource, T2.showtouser, T2.state, T2.processdestination, T2.insurancedate, T2.insuranceman, T2.to2, T2.document, T2.needapprove, T2.projectid, T2.prjstatus, T2.visualtype, T2.owner, T2.to, T2.contragent, T2.from, T2.storagemanager, T2.type, T1.startdate, T1.sum, T1.name, T1.finishdate, T1.contractstate, T1.textFileName, T1.timelinefilename, T1.worker, T1.currency, T1.baseagreement, T1.controller, T1.sypplytype FROM contracts  T1, documents  T2 WHERE T2.type = \'C\' AND T2.document = T1.document AND ";
	private static final int[] genericFindInsertPoints = {626};
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
	private ContractBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ContractBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ContractBeanFinderObject temp_finderObject = new com.hps.july.persistence.ContractBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
