package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseDocumentBean_a05aa12e
 */
public class EJSJDBCPersisterCMPLeaseDocumentBean_a05aa12e extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseDocumentBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO leasedocuments (leasedocument, createdby, modifiedby, docdate, docnumber, modified, created, operator, regionid, doctype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasedocuments  WHERE leasedocument = ?";
	private static final String _storeString = "UPDATE leasedocuments  SET createdby = ?, modifiedby = ?, docdate = ?, docnumber = ?, modified = ?, created = ?, operator = ?, regionid = ?, doctype = ? WHERE leasedocument = ?";
	private static final String _loadString = "(((((SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(80)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4 WHERE T4.doctype = \'Z\' AND T4.leasedocument = ?)  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, T3.reportperiod, T3.enddate, T3.contracttype, T3.summ1, T3.contractstate, T3.ratecalcruleday, T3.orgowner, T3.ratecalcrule, T3.dateclose, T3.ratedelta, T3.execname, T3.startdate, T3.extendperiod, T3.summ2, T3.chargends, T3.extendtype, T3.CustName, T3.docfilename, T3.changeenddate, T3.extendyears, T3.extendmonthes, T3.extenddays, T3.ratends, T3.nalogagent, T3.manager, T3.economist, T3.currency2, T3.currency1, T3.orgexecutor, T3.orgcustomer, CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4, leasecontracts  T3 WHERE T4.leasedocument = T3.leasedocument AND T4.doctype = \'K\' AND T4.leasedocument = ?) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, T3.reportperiod, T3.enddate, T3.contracttype, T3.summ1, T3.contractstate, T3.ratecalcruleday, T3.orgowner, T3.ratecalcrule, T3.dateclose, T3.ratedelta, T3.execname, T3.startdate, T3.extendperiod, T3.summ2, T3.chargends, T3.extendtype, T3.CustName, T3.docfilename, T3.changeenddate, T3.extendyears, T3.extendmonthes, T3.extenddays, T3.ratends, T3.nalogagent, T3.manager, T3.economist, T3.currency2, T3.currency1, T3.orgexecutor, T3.orgcustomer, T2.dogelectonum, T2.dogelectrodate, T2.numberofphones, T2.numberofphonestemp, T2.calcelectrotype, T2.mainleasedocument, T2.isactive, T2.isdogelectro, T2.officialdoc, T2.activecontract, T2.mainresource, T2.sumtrafic, T2.sumaccept, T2.sumpay, T2.needofficialdoc, T2.basestartdate, T2.baseenddate, T2.customerold, T2.haveioact, T2.ioactnumber, T2.ioactdate, T2.mainposition, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasearendaagrmnts  T2, leasedocuments  T4, leasecontracts  T3 WHERE T3.leasedocument = T2.leasedocument AND T4.leasedocument = T3.leasedocument AND T4.doctype = \'A\' AND T4.leasedocument = ?) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, T3.reportperiod, T3.enddate, T3.contracttype, T3.summ1, T3.contractstate, T3.ratecalcruleday, T3.orgowner, T3.ratecalcrule, T3.dateclose, T3.ratedelta, T3.execname, T3.startdate, T3.extendperiod, T3.summ2, T3.chargends, T3.extendtype, T3.CustName, T3.docfilename, T3.changeenddate, T3.extendyears, T3.extendmonthes, T3.extenddays, T3.ratends, T3.nalogagent, T3.manager, T3.economist, T3.currency2, T3.currency1, T3.orgexecutor, T3.orgcustomer, CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), T1.ban, T1.bil_contrstatus, T1.bil_accounttype, T1.bil_name, T1.balans, T1.bil_inn, T1.bil_contrstname, T1.flagworkpie, T1.bil_contrstdate, T1.useallben, T1.bil_startservdate, T1.bil_suspdate, T1.bil_acctypename, T1.bil_billaddress, T1.mainposition, T1.proctype, T1.useinacts, T1.techcontract, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4, leasecontracts  T3, leaseabonentban  T1 WHERE T3.leasedocument = T1.leasedocument AND T4.leasedocument = T3.leasedocument AND T4.doctype = \'B\' AND T4.leasedocument = ?) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(80)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), T6.mutualperiod, T6.acttype, T6.commonrate, T6.calcratetype, T6.mutstate, T6.dutyraterule, T6.startdate, T6.enddate, T6.maincurrency, T6.additionalcurrency, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4, leasemutualrglmnt  T6 WHERE T4.leasedocument = T6.leasedocument AND T4.doctype = \'Q\' AND T4.leasedocument = ?) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(80)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T5.actstate, T5.actenddate, T5.actstartdate, T5.isSchetFakt, T5.header, T5.footer, T5.istemp, T5.actfilename, T5.mutualreglament FROM leasedocuments  T4, leasemutualacts  T5 WHERE T4.leasedocument = T5.leasedocument AND T4.doctype = \'M\' AND T4.leasedocument = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseDocumentBean_a05aa12e
	 */
	public EJSJDBCPersisterCMPLeaseDocumentBean_a05aa12e() throws java.rmi.RemoteException {
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
		LeaseDocumentBean b = (LeaseDocumentBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.createdby == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.createdby.intValue());
			}
			if (b.modifiedby == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.modifiedby.intValue());
			}
			if (b.documentDate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.documentDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentNumber);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.leaseDocument);
			if (b.modified == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(7, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(7, b.created);
			}
			if (b.operator == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.operator.intValue());
			}
			pstmt.setInt(9, b.regionid);
			pstmt.setString(10, "Z");
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
		LeaseDocumentBean b = (LeaseDocumentBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leaseDocument = _primaryKey.leaseDocument;
		tempint = resultSet.getInt(1);
		b.createdby = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.modifiedby = resultSet.wasNull() ? null : new Integer(tempint);
		b.documentDate = resultSet.getDate(3);
		b.documentNumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.modified = resultSet.getTimestamp(6);
		b.created = resultSet.getTimestamp(7);
		tempint = resultSet.getInt(8);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		b.regionid = resultSet.getInt(9);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseDocumentBean b = (LeaseDocumentBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
			pstmt.setInt(2, _primaryKey.leaseDocument);
			pstmt.setInt(3, _primaryKey.leaseDocument);
			pstmt.setInt(4, _primaryKey.leaseDocument);
			pstmt.setInt(5, _primaryKey.leaseDocument);
			pstmt.setInt(6, _primaryKey.leaseDocument);
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
		LeaseDocumentBean b = (LeaseDocumentBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseDocumentBean b = (LeaseDocumentBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(10, _primaryKey.leaseDocument);
			if (b.createdby == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.createdby.intValue());
			}
			if (b.modifiedby == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.modifiedby.intValue());
			}
			if (b.documentDate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.documentDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentNumber);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.modified == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.created);
			}
			if (b.operator == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.operator.intValue());
			}
			pstmt.setInt(8, b.regionid);
			pstmt.setString(9, "Z");
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
		LeaseDocumentBean b = (LeaseDocumentBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
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
		com.hps.july.persistence.LeaseDocumentKey key = new com.hps.july.persistence.LeaseDocumentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leaseDocument = resultSet.getInt(5);
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
		java.lang.String discriminator = rs.getString(10).trim();
		if ( discriminator.equals("Z") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("K") ) {
				homeName = "LeaseContract";
			}
			else
			if ( discriminator.equals("M") ) {
				homeName = "LeaseMutualActNew";
			}
			else
			if ( discriminator.equals("Q") ) {
				homeName = "LeaseMutualReglament";
			}
			else
			if ( discriminator.equals("B") ) {
				homeName = "LeaseAbonentBAN";
			}
			else
			if ( discriminator.equals("A") ) {
				homeName = "LeaseArendaAgreementNew";
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
	public com.hps.july.persistence.LeaseDocument findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.LeaseDocument result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)key;
		try {
			try {
				result = (com.hps.july.persistence.LeaseDocument)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.leaseDocument);
				pstmt.setInt(2, _primaryKey.leaseDocument);
				pstmt.setInt(3, _primaryKey.leaseDocument);
				pstmt.setInt(4, _primaryKey.leaseDocument);
				pstmt.setInt(5, _primaryKey.leaseDocument);
				pstmt.setInt(6, _primaryKey.leaseDocument);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.LeaseDocument)tmpFinder.nextElement();
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
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isDocDate, java.sql.Date docDate, java.lang.Boolean isBlank, java.lang.String blank, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isDocDate, docDate, isBlank, blank, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "(((((SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(80)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4 WHERE T4.doctype = \'Z\' AND )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, T3.reportperiod, T3.enddate, T3.contracttype, T3.summ1, T3.contractstate, T3.ratecalcruleday, T3.orgowner, T3.ratecalcrule, T3.dateclose, T3.ratedelta, T3.execname, T3.startdate, T3.extendperiod, T3.summ2, T3.chargends, T3.extendtype, T3.CustName, T3.docfilename, T3.changeenddate, T3.extendyears, T3.extendmonthes, T3.extenddays, T3.ratends, T3.nalogagent, T3.manager, T3.economist, T3.currency2, T3.currency1, T3.orgexecutor, T3.orgcustomer, CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4, leasecontracts  T3 WHERE T4.leasedocument = T3.leasedocument AND T4.doctype = \'K\' AND ) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, T3.reportperiod, T3.enddate, T3.contracttype, T3.summ1, T3.contractstate, T3.ratecalcruleday, T3.orgowner, T3.ratecalcrule, T3.dateclose, T3.ratedelta, T3.execname, T3.startdate, T3.extendperiod, T3.summ2, T3.chargends, T3.extendtype, T3.CustName, T3.docfilename, T3.changeenddate, T3.extendyears, T3.extendmonthes, T3.extenddays, T3.ratends, T3.nalogagent, T3.manager, T3.economist, T3.currency2, T3.currency1, T3.orgexecutor, T3.orgcustomer, T2.dogelectonum, T2.dogelectrodate, T2.numberofphones, T2.numberofphonestemp, T2.calcelectrotype, T2.mainleasedocument, T2.isactive, T2.isdogelectro, T2.officialdoc, T2.activecontract, T2.mainresource, T2.sumtrafic, T2.sumaccept, T2.sumpay, T2.needofficialdoc, T2.basestartdate, T2.baseenddate, T2.customerold, T2.haveioact, T2.ioactnumber, T2.ioactdate, T2.mainposition, CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasearendaagrmnts  T2, leasedocuments  T4, leasecontracts  T3 WHERE T3.leasedocument = T2.leasedocument AND T4.leasedocument = T3.leasedocument AND T4.doctype = \'A\' AND ) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, T3.reportperiod, T3.enddate, T3.contracttype, T3.summ1, T3.contractstate, T3.ratecalcruleday, T3.orgowner, T3.ratecalcrule, T3.dateclose, T3.ratedelta, T3.execname, T3.startdate, T3.extendperiod, T3.summ2, T3.chargends, T3.extendtype, T3.CustName, T3.docfilename, T3.changeenddate, T3.extendyears, T3.extendmonthes, T3.extenddays, T3.ratends, T3.nalogagent, T3.manager, T3.economist, T3.currency2, T3.currency1, T3.orgexecutor, T3.orgcustomer, CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), T1.ban, T1.bil_contrstatus, T1.bil_accounttype, T1.bil_name, T1.balans, T1.bil_inn, T1.bil_contrstname, T1.flagworkpie, T1.bil_contrstdate, T1.useallben, T1.bil_startservdate, T1.bil_suspdate, T1.bil_acctypename, T1.bil_billaddress, T1.mainposition, T1.proctype, T1.useinacts, T1.techcontract, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4, leasecontracts  T3, leaseabonentban  T1 WHERE T3.leasedocument = T1.leasedocument AND T4.leasedocument = T3.leasedocument AND T4.doctype = \'B\' AND ) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(80)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), T6.mutualperiod, T6.acttype, T6.commonrate, T6.calcratetype, T6.mutstate, T6.dutyraterule, T6.startdate, T6.enddate, T6.maincurrency, T6.additionalcurrency, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS INTEGER) FROM leasedocuments  T4, leasemutualrglmnt  T6 WHERE T4.leasedocument = T6.leasedocument AND T4.doctype = \'Q\' AND ) )  UNION ALL (SELECT T4.createdby, T4.modifiedby, T4.docdate, T4.docnumber, T4.leasedocument, T4.modified, T4.created, T4.operator, T4.regionid, T4.doctype, CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(80)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(80)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS SMALLINT), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(2)), CAST(NULL AS CHAR(3)), CAST(NULL AS CHAR(150)), CAST(NULL AS DECIMAL(15, 4)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(20)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS CHAR(30)), CAST(NULL AS CHAR(100)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DATE), CAST(NULL AS DATE), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T5.actstate, T5.actenddate, T5.actstartdate, T5.isSchetFakt, T5.header, T5.footer, T5.istemp, T5.actfilename, T5.mutualreglament FROM leasedocuments  T4, leasemutualacts  T5 WHERE T4.leasedocument = T5.leasedocument AND T4.doctype = \'M\' AND ) ";
	private static final int[] genericFindInsertPoints = {13063, 10787, 8474, 6433, 4409, 2306};
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
	private LeaseDocumentBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseDocumentBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseDocumentBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseDocumentBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
