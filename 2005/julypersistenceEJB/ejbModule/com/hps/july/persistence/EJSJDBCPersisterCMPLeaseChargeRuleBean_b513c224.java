package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseChargeRuleBean_b513c224
 */
public class EJSJDBCPersisterCMPLeaseChargeRuleBean_b513c224 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseChargeRuleBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO leaserules (leaserule, leasedocument, ruletype) VALUES (?, ?, ?)", "INSERT INTO leasechargerules (leaserule, chargeperiod, chargedaterule, summ, currency, resource) VALUES (?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM leasechargerules  WHERE leaserule = ?", "DELETE FROM leaserules  WHERE leaserule = ?"};
	private static final String[] _storeString = {"UPDATE leasechargerules  SET chargeperiod = ?, chargedaterule = ?, summ = ?, currency = ?, resource = ? WHERE leaserule = ?", "UPDATE leaserules  SET leasedocument = ?, ruletype = ? WHERE leaserule = ?"};
	private static final String _loadString = "SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.chargeperiod, T1.chargedaterule, T1.summ, T1.currency, T1.resource FROM leaserules  T2, leasechargerules  T1 WHERE T2.ruletype = \'N\' AND T2.leaserule = T1.leaserule AND T2.leaserule = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseChargeRuleBean_b513c224
	 */
	public EJSJDBCPersisterCMPLeaseChargeRuleBean_b513c224() throws java.rmi.RemoteException {
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
		LeaseChargeRuleBean b = (LeaseChargeRuleBean) eb;
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
			pstmt.setString(3, "N");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.chargePeriod);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.chargeDateRule);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.sum == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.sum);
			}
			if (b.curency_currency == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.curency_currency.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.resource_resource.intValue());
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
		LeaseChargeRuleBean b = (LeaseChargeRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leaseRule = _primaryKey.leaseRule;
		b.chargePeriod = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.chargeDateRule = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.sum = resultSet.getBigDecimal(6);
		tempint = resultSet.getInt(7);
		b.curency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.leaseDocument_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseChargeRuleBean b = (LeaseChargeRuleBean) eb;
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
		LeaseChargeRuleBean b = (LeaseChargeRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseChargeRuleBean b = (LeaseChargeRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(6, _primaryKey.leaseRule);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.chargePeriod);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.chargeDateRule);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.sum == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.sum);
			}
			if (b.curency_currency == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.curency_currency.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.resource_resource.intValue());
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
			pstmt.setString(2, "N");
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
		LeaseChargeRuleBean b = (LeaseChargeRuleBean) eb;
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
		if ( discriminator.equals("N") ) {
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
	 * findLeaseChargeRuleByResource
	 */
	public EJSFinder findLeaseChargeRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.chargeperiod, T1.chargedaterule, T1.summ, T1.currency, T1.resource FROM leaserules  T2, leasechargerules  T1 WHERE T2.ruletype = \'N\' AND T2.leaserule = T1.leaserule AND T1.resource = ?");
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
	 * findLeaseChargeRuleByCurency
	 */
	public EJSFinder findLeaseChargeRuleByCurency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.chargeperiod, T1.chargedaterule, T1.summ, T1.currency, T1.resource FROM leaserules  T2, leasechargerules  T1 WHERE T2.ruletype = \'N\' AND T2.leaserule = T1.leaserule AND T1.currency = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseChargeRule findByPrimaryKey(com.hps.july.persistence.LeaseRuleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.LeaseChargeRule result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)key;
		try {
			try {
				result = (com.hps.july.persistence.LeaseChargeRule)home.getBean(key);
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
					result = (com.hps.july.persistence.LeaseChargeRule)tmpFinder.nextElement();
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
	 * findByLeaseDocumentAndResource
	 */
	public EJSFinder findByLeaseDocumentAndResource(java.lang.Integer leaseDocument, java.lang.Integer argResource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByLeaseDocumentAndResource(leaseDocument, argResource, order);
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
	public EJSFinder findByLeaseDocument(java.lang.Integer leaseDocument, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByLeaseDocument(leaseDocument, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T2.leaserule, T2.leasedocument, T2.ruletype, T1.chargeperiod, T1.chargedaterule, T1.summ, T1.currency, T1.resource FROM leaserules  T2, leasechargerules  T1 WHERE T2.ruletype = \'N\' AND T2.leaserule = T1.leaserule AND ";
	private static final int[] genericFindInsertPoints = {224};
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
	private LeaseChargeRuleBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseChargeRuleBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseChargeRuleBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseChargeRuleBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
