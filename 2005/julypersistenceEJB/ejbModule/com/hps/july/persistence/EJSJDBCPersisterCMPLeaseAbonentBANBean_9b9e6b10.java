package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseAbonentBANBean_9b9e6b10
 */
public class EJSJDBCPersisterCMPLeaseAbonentBANBean_9b9e6b10 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseAbonentBANBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO leasedocuments (leasedocument, createdby, modifiedby, docdate, docnumber, modified, created, operator, regionid, doctype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO leasecontracts (leasedocument, reportperiod, enddate, contracttype, summ1, contractstate, ratecalcruleday, orgowner, ratecalcrule, dateclose, ratedelta, execname, startdate, extendperiod, summ2, chargends, extendtype, CustName, docfilename, changeenddate, extendyears, extendmonthes, extenddays, ratends, nalogagent, isratelimit, ratelimitmin, ratelimitmax, buchdocnumber, havedocsigned, havedocsignedcustomer, manager, economist, currency2, currency1, orgexecutor, orgcustomer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO leaseabonentban (leasedocument, ban, bil_contrstatus, bil_accounttype, bil_name, balans, bil_inn, bil_contrstname, flagworkpie, bil_contrstdate, useallben, bil_startservdate, bil_suspdate, bil_acctypename, bil_billaddress, mainposition, proctype, useinacts, techcontract) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM leaseabonentban  WHERE leasedocument = ?", "DELETE FROM leasecontracts  WHERE leasedocument = ?", "DELETE FROM leasedocuments  WHERE leasedocument = ?"};
	private static final String[] _storeString = {"UPDATE leaseabonentban  SET ban = ?, bil_contrstatus = ?, bil_accounttype = ?, bil_name = ?, balans = ?, bil_inn = ?, bil_contrstname = ?, flagworkpie = ?, bil_contrstdate = ?, useallben = ?, bil_startservdate = ?, bil_suspdate = ?, bil_acctypename = ?, bil_billaddress = ?, mainposition = ?, proctype = ?, useinacts = ?, techcontract = ? WHERE leasedocument = ?", "UPDATE leasecontracts  SET reportperiod = ?, enddate = ?, contracttype = ?, summ1 = ?, contractstate = ?, ratecalcruleday = ?, orgowner = ?, ratecalcrule = ?, dateclose = ?, ratedelta = ?, execname = ?, startdate = ?, extendperiod = ?, summ2 = ?, chargends = ?, extendtype = ?, CustName = ?, docfilename = ?, changeenddate = ?, extendyears = ?, extendmonthes = ?, extenddays = ?, ratends = ?, nalogagent = ?, isratelimit = ?, ratelimitmin = ?, ratelimitmax = ?, buchdocnumber = ?, havedocsigned = ?, havedocsignedcustomer = ?, manager = ?, economist = ?, currency2 = ?, currency1 = ?, orgexecutor = ?, orgcustomer = ? WHERE leasedocument = ?", "UPDATE leasedocuments  SET createdby = ?, modifiedby = ?, docdate = ?, docnumber = ?, modified = ?, created = ?, operator = ?, regionid = ?, doctype = ? WHERE leasedocument = ?"};
	private static final String _loadString = "SELECT T3.createdby, T3.modifiedby, T3.docdate, T3.docnumber, T3.leasedocument, T3.modified, T3.created, T3.operator, T3.regionid, T3.doctype, T2.reportperiod, T2.enddate, T2.contracttype, T2.summ1, T2.contractstate, T2.ratecalcruleday, T2.orgowner, T2.ratecalcrule, T2.dateclose, T2.ratedelta, T2.execname, T2.startdate, T2.extendperiod, T2.summ2, T2.chargends, T2.extendtype, T2.CustName, T2.docfilename, T2.changeenddate, T2.extendyears, T2.extendmonthes, T2.extenddays, T2.ratends, T2.nalogagent, T2.isratelimit, T2.ratelimitmin, T2.ratelimitmax, T2.buchdocnumber, T2.havedocsigned, T2.havedocsignedcustomer, T2.manager, T2.economist, T2.currency2, T2.currency1, T2.orgexecutor, T2.orgcustomer, T1.ban, T1.bil_contrstatus, T1.bil_accounttype, T1.bil_name, T1.balans, T1.bil_inn, T1.bil_contrstname, T1.flagworkpie, T1.bil_contrstdate, T1.useallben, T1.bil_startservdate, T1.bil_suspdate, T1.bil_acctypename, T1.bil_billaddress, T1.mainposition, T1.proctype, T1.useinacts, T1.techcontract FROM leaseabonentban  T1, leasedocuments  T3, leasecontracts  T2 WHERE T3.doctype = \'B\' AND T2.leasedocument = T1.leasedocument AND T3.leasedocument = T2.leasedocument AND T3.leasedocument = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseAbonentBANBean_9b9e6b10
	 */
	public EJSJDBCPersisterCMPLeaseAbonentBANBean_9b9e6b10() throws java.rmi.RemoteException {
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
		LeaseAbonentBANBean b = (LeaseAbonentBANBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
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
			pstmt.setString(10, "B");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.reportPeriod);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.endDate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.endDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contractType);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.summ1 == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.summ1);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contractState);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.ratecalcruleday == null) {
				pstmt.setNull(7, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(7, b.ratecalcruleday.shortValue());
			}
			if (b.orgowner == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.orgowner.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ratecalcrule);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.dateclose == null) {
				pstmt.setNull(10, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(10, b.dateclose);
			}
			if (b.ratedelta == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.ratedelta);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.execname);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.startDate == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.startDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.extendPeriod);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.summ2 == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.summ2);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.chargeNds));
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.extendType);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.custname);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docFileName);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.changeenddate);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			if (b.extendyears == null) {
				pstmt.setNull(21, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(21, b.extendyears.shortValue());
			}
			if (b.extendmonthes == null) {
				pstmt.setNull(22, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(22, b.extendmonthes.shortValue());
			}
			if (b.extenddays == null) {
				pstmt.setNull(23, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(23, b.extenddays.shortValue());
			}
			if (b.RateNDS == null) {
				pstmt.setNull(24, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(24, b.RateNDS);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.NalogAgent));
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isRateLimit));
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
			}
			if (b.rateLimitMin == null) {
				pstmt.setNull(27, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(27, b.rateLimitMin);
			}
			if (b.rateLimitMax == null) {
				pstmt.setNull(28, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(28, b.rateLimitMax);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.buchdocnumber);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.havedocsigned);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.havedocsignedcustomer);
			if (objectTemp == null) {
				pstmt.setNull(31, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(31, (java.lang.String)objectTemp);
			}
			if (b.manager_worker == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.manager_worker.intValue());
			}
			if (b.economist_worker == null) {
				pstmt.setNull(33, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(33, b.economist_worker.intValue());
			}
			if (b.currency2_currency == null) {
				pstmt.setNull(34, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(34, b.currency2_currency.intValue());
			}
			if (b.currency1_currency == null) {
				pstmt.setNull(35, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(35, b.currency1_currency.intValue());
			}
			if (b.orgExecutor_organization == null) {
				pstmt.setNull(36, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(36, b.orgExecutor_organization.intValue());
			}
			if (b.orgCustomer_organization == null) {
				pstmt.setNull(37, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(37, b.orgCustomer_organization.intValue());
			}
			pstmt.setInt(1, b.leaseDocument);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[2]);
		try {
			pstmt.setInt(2, b.ban);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_contrstatus);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.accounttype);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_name);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.balans == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.balans);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_inn);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_contrstname);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworkpie));
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.bil_contrstdate == null) {
				pstmt.setNull(10, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(10, b.bil_contrstdate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.useallben));
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.bil_startservdate == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.bil_startservdate);
			}
			if (b.bil_suspdate == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.bil_suspdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_acctypename);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_billaddress);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.mainposition == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.mainposition.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.proctype);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.useinacts));
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.techcontract));
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.leaseDocument);
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
		LeaseAbonentBANBean b = (LeaseAbonentBANBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.leaseDocument = _primaryKey.leaseDocument;
		b.ban = resultSet.getInt(47);
		b.bil_contrstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(48));
		b.accounttype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(49));
		b.bil_name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(50));
		b.balans = resultSet.getBigDecimal(51);
		b.bil_inn = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(52));
		b.bil_contrstname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(53));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(54));
		b.flagworkpie = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.bil_contrstdate = resultSet.getDate(55);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(56));
		b.useallben = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.bil_startservdate = resultSet.getDate(57);
		b.bil_suspdate = resultSet.getDate(58);
		b.bil_acctypename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(59));
		b.bil_billaddress = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(60));
		tempint = resultSet.getInt(61);
		b.mainposition = resultSet.wasNull() ? null : new Integer(tempint);
		b.proctype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(62));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(63));
		b.useinacts = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(64));
		b.techcontract = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.reportPeriod = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		b.endDate = resultSet.getDate(12);
		b.contractType = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.summ1 = resultSet.getBigDecimal(14);
		b.contractState = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(15));
		tempshort = resultSet.getShort(16);
		b.ratecalcruleday = resultSet.wasNull() ? null : new Short(tempshort);
		tempint = resultSet.getInt(17);
		b.orgowner = resultSet.wasNull() ? null : new Integer(tempint);
		b.ratecalcrule = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		b.dateclose = resultSet.getDate(19);
		b.ratedelta = resultSet.getBigDecimal(20);
		b.execname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(21));
		b.startDate = resultSet.getDate(22);
		b.extendPeriod = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(23));
		b.summ2 = resultSet.getBigDecimal(24);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(25));
		b.chargeNds = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.extendType = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(26));
		b.custname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(27));
		b.docFileName = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(28));
		b.changeenddate = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(29));
		tempshort = resultSet.getShort(30);
		b.extendyears = resultSet.wasNull() ? null : new Short(tempshort);
		tempshort = resultSet.getShort(31);
		b.extendmonthes = resultSet.wasNull() ? null : new Short(tempshort);
		tempshort = resultSet.getShort(32);
		b.extenddays = resultSet.wasNull() ? null : new Short(tempshort);
		b.RateNDS = resultSet.getBigDecimal(33);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(34));
		b.NalogAgent = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(35));
		b.isRateLimit = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.rateLimitMin = resultSet.getBigDecimal(36);
		b.rateLimitMax = resultSet.getBigDecimal(37);
		b.buchdocnumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(38));
		b.havedocsigned = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(39));
		b.havedocsignedcustomer = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(40));
		tempint = resultSet.getInt(41);
		b.manager_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(42);
		b.economist_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(43);
		b.currency2_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(44);
		b.currency1_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(45);
		b.orgExecutor_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(46);
		b.orgCustomer_organization = resultSet.wasNull() ? null : new Integer(tempint);
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
		LeaseAbonentBANBean b = (LeaseAbonentBANBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
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
		LeaseAbonentBANBean b = (LeaseAbonentBANBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseAbonentBANBean b = (LeaseAbonentBANBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(19, _primaryKey.leaseDocument);
			pstmt.setInt(1, b.ban);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_contrstatus);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.accounttype);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_name);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.balans == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.balans);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_inn);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_contrstname);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworkpie));
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.bil_contrstdate == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.bil_contrstdate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.useallben));
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.bil_startservdate == null) {
				pstmt.setNull(11, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(11, b.bil_startservdate);
			}
			if (b.bil_suspdate == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.bil_suspdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_acctypename);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bil_billaddress);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.mainposition == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.mainposition.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.proctype);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.useinacts));
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.techcontract));
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(37, _primaryKey.leaseDocument);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.reportPeriod);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.endDate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.endDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contractType);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.summ1 == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.summ1);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.contractState);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.ratecalcruleday == null) {
				pstmt.setNull(6, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(6, b.ratecalcruleday.shortValue());
			}
			if (b.orgowner == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.orgowner.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ratecalcrule);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.dateclose == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.dateclose);
			}
			if (b.ratedelta == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.ratedelta);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.execname);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.startDate == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.startDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.extendPeriod);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.summ2 == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.summ2);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.chargeNds));
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.extendType);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.custname);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docFileName);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.changeenddate);
			if (objectTemp == null) {
				pstmt.setNull(19, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(19, (java.lang.String)objectTemp);
			}
			if (b.extendyears == null) {
				pstmt.setNull(20, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(20, b.extendyears.shortValue());
			}
			if (b.extendmonthes == null) {
				pstmt.setNull(21, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(21, b.extendmonthes.shortValue());
			}
			if (b.extenddays == null) {
				pstmt.setNull(22, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(22, b.extenddays.shortValue());
			}
			if (b.RateNDS == null) {
				pstmt.setNull(23, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(23, b.RateNDS);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.NalogAgent));
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isRateLimit));
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			if (b.rateLimitMin == null) {
				pstmt.setNull(26, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(26, b.rateLimitMin);
			}
			if (b.rateLimitMax == null) {
				pstmt.setNull(27, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(27, b.rateLimitMax);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.buchdocnumber);
			if (objectTemp == null) {
				pstmt.setNull(28, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(28, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.havedocsigned);
			if (objectTemp == null) {
				pstmt.setNull(29, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(29, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.havedocsignedcustomer);
			if (objectTemp == null) {
				pstmt.setNull(30, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(30, (java.lang.String)objectTemp);
			}
			if (b.manager_worker == null) {
				pstmt.setNull(31, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(31, b.manager_worker.intValue());
			}
			if (b.economist_worker == null) {
				pstmt.setNull(32, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(32, b.economist_worker.intValue());
			}
			if (b.currency2_currency == null) {
				pstmt.setNull(33, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(33, b.currency2_currency.intValue());
			}
			if (b.currency1_currency == null) {
				pstmt.setNull(34, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(34, b.currency1_currency.intValue());
			}
			if (b.orgExecutor_organization == null) {
				pstmt.setNull(35, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(35, b.orgExecutor_organization.intValue());
			}
			if (b.orgCustomer_organization == null) {
				pstmt.setNull(36, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(36, b.orgCustomer_organization.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[2]);
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
			pstmt.setString(9, "B");
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
		LeaseAbonentBANBean b = (LeaseAbonentBANBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[2]);
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
		if ( discriminator.equals("B") ) {
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
	 * findByBAN
	 */
	public EJSFinder findByBAN(java.lang.Integer argBan) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.createdby, T3.modifiedby, T3.docdate, T3.docnumber, T3.leasedocument, T3.modified, T3.created, T3.operator, T3.regionid, T3.doctype, T2.reportperiod, T2.enddate, T2.contracttype, T2.summ1, T2.contractstate, T2.ratecalcruleday, T2.orgowner, T2.ratecalcrule, T2.dateclose, T2.ratedelta, T2.execname, T2.startdate, T2.extendperiod, T2.summ2, T2.chargends, T2.extendtype, T2.CustName, T2.docfilename, T2.changeenddate, T2.extendyears, T2.extendmonthes, T2.extenddays, T2.ratends, T2.nalogagent, T2.isratelimit, T2.ratelimitmin, T2.ratelimitmax, T2.buchdocnumber, T2.havedocsigned, T2.havedocsignedcustomer, T2.manager, T2.economist, T2.currency2, T2.currency1, T2.orgexecutor, T2.orgcustomer, T1.ban, T1.bil_contrstatus, T1.bil_accounttype, T1.bil_name, T1.balans, T1.bil_inn, T1.bil_contrstname, T1.flagworkpie, T1.bil_contrstdate, T1.useallben, T1.bil_startservdate, T1.bil_suspdate, T1.bil_acctypename, T1.bil_billaddress, T1.mainposition, T1.proctype, T1.useinacts, T1.techcontract FROM leaseabonentban  T1, leasedocuments  T3, leasecontracts  T2 WHERE T3.doctype = \'B\' AND T2.leasedocument = T1.leasedocument AND T3.leasedocument = T2.leasedocument AND ban = ?");
			pstmt.setObject(1, argBan);
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
	public EJSFinder findByQBE(java.lang.String contractType, java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(contractType, isOrgCustomer, orgCustomer, isOrgExecutor, orgExecutor, isMainEconomist, mainEconomist, isDocNumber, docNumber, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByFlagWorkPIE
	 */
	public EJSFinder findByFlagWorkPIE(java.lang.String argFlagWorkPIE) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T3.createdby, T3.modifiedby, T3.docdate, T3.docnumber, T3.leasedocument, T3.modified, T3.created, T3.operator, T3.regionid, T3.doctype, T2.reportperiod, T2.enddate, T2.contracttype, T2.summ1, T2.contractstate, T2.ratecalcruleday, T2.orgowner, T2.ratecalcrule, T2.dateclose, T2.ratedelta, T2.execname, T2.startdate, T2.extendperiod, T2.summ2, T2.chargends, T2.extendtype, T2.CustName, T2.docfilename, T2.changeenddate, T2.extendyears, T2.extendmonthes, T2.extenddays, T2.ratends, T2.nalogagent, T2.isratelimit, T2.ratelimitmin, T2.ratelimitmax, T2.buchdocnumber, T2.havedocsigned, T2.havedocsignedcustomer, T2.manager, T2.economist, T2.currency2, T2.currency1, T2.orgexecutor, T2.orgcustomer, T1.ban, T1.bil_contrstatus, T1.bil_accounttype, T1.bil_name, T1.balans, T1.bil_inn, T1.bil_contrstname, T1.flagworkpie, T1.bil_contrstdate, T1.useallben, T1.bil_startservdate, T1.bil_suspdate, T1.bil_acctypename, T1.bil_billaddress, T1.mainposition, T1.proctype, T1.useinacts, T1.techcontract FROM leaseabonentban  T1, leasedocuments  T3, leasecontracts  T2 WHERE T3.doctype = \'B\' AND T2.leasedocument = T1.leasedocument AND T3.leasedocument = T2.leasedocument AND flagworkpie = ?");
			if (argFlagWorkPIE == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argFlagWorkPIE);
			}
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
	public com.hps.july.persistence.LeaseAbonentBAN findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.LeaseAbonentBAN result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)key;
		try {
			try {
				result = (com.hps.july.persistence.LeaseAbonentBAN)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.leaseDocument);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.LeaseAbonentBAN)tmpFinder.nextElement();
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
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Boolean isCustomerName, java.lang.String customerName, java.lang.Boolean isCustomerInn, java.lang.String customerInn, java.lang.Boolean isBan, java.lang.String ban, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(isCustomerName, customerName, isCustomerInn, customerInn, isBan, ban, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE3
	 */
	public EJSFinder findByQBE3(java.lang.Boolean isCustomerName, java.lang.String customerName, java.lang.Boolean isCustomerInn, java.lang.String customerInn, java.lang.Boolean isBan, java.lang.String ban, java.lang.Boolean isContractState, java.lang.String contractState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE3(isCustomerName, customerName, isCustomerInn, customerInn, isBan, ban, isContractState, contractState, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T3.createdby, T3.modifiedby, T3.docdate, T3.docnumber, T3.leasedocument, T3.modified, T3.created, T3.operator, T3.regionid, T3.doctype, T2.reportperiod, T2.enddate, T2.contracttype, T2.summ1, T2.contractstate, T2.ratecalcruleday, T2.orgowner, T2.ratecalcrule, T2.dateclose, T2.ratedelta, T2.execname, T2.startdate, T2.extendperiod, T2.summ2, T2.chargends, T2.extendtype, T2.CustName, T2.docfilename, T2.changeenddate, T2.extendyears, T2.extendmonthes, T2.extenddays, T2.ratends, T2.nalogagent, T2.isratelimit, T2.ratelimitmin, T2.ratelimitmax, T2.buchdocnumber, T2.havedocsigned, T2.havedocsignedcustomer, T2.manager, T2.economist, T2.currency2, T2.currency1, T2.orgexecutor, T2.orgcustomer, T1.ban, T1.bil_contrstatus, T1.bil_accounttype, T1.bil_name, T1.balans, T1.bil_inn, T1.bil_contrstname, T1.flagworkpie, T1.bil_contrstdate, T1.useallben, T1.bil_startservdate, T1.bil_suspdate, T1.bil_acctypename, T1.bil_billaddress, T1.mainposition, T1.proctype, T1.useinacts, T1.techcontract FROM leaseabonentban  T1, leasedocuments  T3, leasecontracts  T2 WHERE T3.doctype = \'B\' AND T2.leasedocument = T1.leasedocument AND T3.leasedocument = T2.leasedocument AND ";
	private static final int[] genericFindInsertPoints = {1164};
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
	private LeaseAbonentBANBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseAbonentBANBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseAbonentBANBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseAbonentBANBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
