package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeasePayRuleBean_0016f96c
 */
public class EJSJDBCPersisterCMPLeasePayRuleBean_0016f96c extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeasePayRuleBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO leaserules (leaserule, leasedocument, ruletype) VALUES (?, ?, ?)", "INSERT INTO leasepayrules (leaserule, payterms, summ, paypurpose, payperiod, pptype, paytype, separatendspay, paybeforedate, validdatepay, resource, currency, orgtopay, orgacc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM leasepayrules  WHERE leaserule = ?", "DELETE FROM leaserules  WHERE leaserule = ?"};
	private static final String[] _storeString = {"UPDATE leasepayrules  SET payterms = ?, summ = ?, paypurpose = ?, payperiod = ?, pptype = ?, paytype = ?, separatendspay = ?, paybeforedate = ?, validdatepay = ?, resource = ?, currency = ?, orgtopay = ?, orgacc = ? WHERE leaserule = ?", "UPDATE leaserules  SET leasedocument = ?, ruletype = ? WHERE leaserule = ?"};
	private static final String _loadString = "SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.payterms, T1.summ, T1.paypurpose, T1.payperiod, T1.pptype, T1.paytype, T1.separatendspay, T1.paybeforedate, T1.validdatepay, T1.resource, T1.currency, T1.orgtopay, T1.orgacc FROM leaserules  T2, leasepayrules  T1 WHERE T2.ruletype = \'P\' AND T2.leaserule = T1.leaserule AND T2.leaserule = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeasePayRuleBean_0016f96c
	 */
	public EJSJDBCPersisterCMPLeasePayRuleBean_0016f96c() throws java.rmi.RemoteException {
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
		LeasePayRuleBean b = (LeasePayRuleBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			pstmt.setInt(1, b.leaseRule);
			if (b.leaseDocument_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.leaseDocument_leaseDocument.intValue());
			}
			pstmt.setString(3, "P");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			if (b.payTerms == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.payTerms);
			}
			if (b.sum == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.sum);
			}
			if (b.PayPurpose == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.PayPurpose);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.payPeriod);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ppType);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.payType);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.separateNdsPay);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.payBeforeDate == null) {
				pstmt.setNull(9, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(9, b.payBeforeDate.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.validdatepay);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.resource_resource == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.resource_resource.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.currency_currency.intValue());
			}
			if (b.orgToPay_organization == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.orgToPay_organization.intValue());
			}
			if (b.orgAcc_account == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.orgAcc_account.intValue());
			}
			pstmt.setInt(1, b.leaseRule);
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
		LeasePayRuleBean b = (LeasePayRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.leaseRule = _primaryKey.leaseRule;
		b.payTerms = resultSet.getString(4);
		b.sum = resultSet.getBigDecimal(5);
		b.PayPurpose = resultSet.getString(6);
		b.payPeriod = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.ppType = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.payType = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.separateNdsPay = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(10));
		tempshort = resultSet.getShort(11);
		b.payBeforeDate = resultSet.wasNull() ? null : new Short(tempshort);
		b.validdatepay = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(12));
		tempint = resultSet.getInt(13);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(14);
		b.currency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.orgToPay_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		b.orgAcc_account = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.leaseDocument_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeasePayRuleBean b = (LeasePayRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leaseRule);
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
		LeasePayRuleBean b = (LeasePayRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeasePayRuleBean b = (LeasePayRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(14, _primaryKey.leaseRule);
			if (b.payTerms == null) {
				pstmt.setNull(1, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(1, b.payTerms);
			}
			if (b.sum == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.sum);
			}
			if (b.PayPurpose == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.PayPurpose);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.payPeriod);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ppType);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.payType);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.separateNdsPay);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.payBeforeDate == null) {
				pstmt.setNull(8, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(8, b.payBeforeDate.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.validdatepay);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.resource_resource == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.resource_resource.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.currency_currency.intValue());
			}
			if (b.orgToPay_organization == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.orgToPay_organization.intValue());
			}
			if (b.orgAcc_account == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.orgAcc_account.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(3, _primaryKey.leaseRule);
			if (b.leaseDocument_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.leaseDocument_leaseDocument.intValue());
			}
			pstmt.setString(2, "P");
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
		LeasePayRuleBean b = (LeasePayRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.leaseRule);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.leaseRule);
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
		com.hps.july.persistence.LeaseRuleKey key = new com.hps.july.persistence.LeaseRuleKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leaseRule = resultSet.getInt(1);
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
		java.lang.String discriminator = rs.getString(3).trim();
		if ( discriminator.equals("P") ) {
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
	 * findLeasePayRuleByCurrency
	 */
	public EJSFinder findLeasePayRuleByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.payterms, T1.summ, T1.paypurpose, T1.payperiod, T1.pptype, T1.paytype, T1.separatendspay, T1.paybeforedate, T1.validdatepay, T1.resource, T1.currency, T1.orgtopay, T1.orgacc FROM leaserules  T2, leasepayrules  T1 WHERE T2.ruletype = \'P\' AND T2.leaserule = T1.leaserule AND T1.currency = ?");
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
	 * findLeasePayRuleByResource
	 */
	public EJSFinder findLeasePayRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.payterms, T1.summ, T1.paypurpose, T1.payperiod, T1.pptype, T1.paytype, T1.separatendspay, T1.paybeforedate, T1.validdatepay, T1.resource, T1.currency, T1.orgtopay, T1.orgacc FROM leaserules  T2, leasepayrules  T1 WHERE T2.ruletype = \'P\' AND T2.leaserule = T1.leaserule AND T1.resource = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeasePayRule findByPrimaryKey(com.hps.july.persistence.LeaseRuleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.LeasePayRule result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)key;
		try {
			try {
				result = (com.hps.july.persistence.LeasePayRule)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.leaseRule);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.LeasePayRule)tmpFinder.nextElement();
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
	 * findLeasePayRule4orgtopayByOrgToPay
	 */
	public EJSFinder findLeasePayRule4orgtopayByOrgToPay(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.payterms, T1.summ, T1.paypurpose, T1.payperiod, T1.pptype, T1.paytype, T1.separatendspay, T1.paybeforedate, T1.validdatepay, T1.resource, T1.currency, T1.orgtopay, T1.orgacc FROM leaserules  T2, leasepayrules  T1 WHERE T2.ruletype = \'P\' AND T2.leaserule = T1.leaserule AND T1.orgtopay = ?");
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
	 * findByLeasedocumentResourcePaytype
	 */
	public EJSFinder findByLeasedocumentResourcePaytype(java.lang.Integer leaseDocument, java.lang.Integer resource, java.lang.String paytype) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.payterms, T1.summ, T1.paypurpose, T1.payperiod, T1.pptype, T1.paytype, T1.separatendspay, T1.paybeforedate, T1.validdatepay, T1.resource, T1.currency, T1.orgtopay, T1.orgacc FROM leaserules  T2, leasepayrules  T1 WHERE T2.ruletype = \'P\' AND T2.leaserule = T1.leaserule AND  leasedocument = ? and resource = ? and paytype = ? ");
			pstmt.setObject(1, leaseDocument);
			pstmt.setObject(2, resource);
			if (paytype == null) {
			   pstmt.setNull(3, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(3, paytype);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByLeaseDocument
	 */
	public EJSFinder findByLeaseDocument(java.lang.Integer leaseDocument, java.lang.Boolean isPpType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByLeaseDocument(leaseDocument, isPpType, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeasePayRule4OrgAccByOrgAcc
	 */
	public EJSFinder findLeasePayRule4OrgAccByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.payterms, T1.summ, T1.paypurpose, T1.payperiod, T1.pptype, T1.paytype, T1.separatendspay, T1.paybeforedate, T1.validdatepay, T1.resource, T1.currency, T1.orgtopay, T1.orgacc FROM leaserules  T2, leasepayrules  T1 WHERE T2.ruletype = \'P\' AND T2.leaserule = T1.leaserule AND T1.orgacc = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.account);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.payterms, T1.summ, T1.paypurpose, T1.payperiod, T1.pptype, T1.paytype, T1.separatendspay, T1.paybeforedate, T1.validdatepay, T1.resource, T1.currency, T1.orgtopay, T1.orgacc FROM leaserules  T2, leasepayrules  T1 WHERE T2.ruletype = \'P\' AND T2.leaserule = T1.leaserule AND ";
	private static final int[] genericFindInsertPoints = {328};
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
	private LeasePayRuleBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeasePayRuleBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeasePayRuleBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeasePayRuleBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
