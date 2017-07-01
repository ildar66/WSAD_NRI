package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseRuleBean_75a2de69
 */
public class EJSJDBCPersisterCMPLeaseRuleBean_75a2de69 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseRuleBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO leaserules (leaserule, leasedocument, ruletype) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM leaserules  WHERE leaserule = ?";
	private static final String _storeString = "UPDATE leaserules  SET leasedocument = ?, ruletype = ? WHERE leaserule = ?";
	private static final String _loadString = "((SELECT T3.leaserule, T3.leasedocument, T3.ruletype, CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM leaserules  T3 WHERE T3.ruletype = \'Z\' AND T3.leaserule = ?)  UNION ALL (SELECT T3.leaserule, T3.leasedocument, T3.ruletype, T2.payterms, T2.summ, T2.paypurpose, T2.payperiod, T2.pptype, T2.paytype, T2.separatendspay, T2.paybeforedate, T2.validdatepay, T2.resource, T2.currency, T2.orgtopay, T2.orgacc, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM leaserules  T3, leasepayrules  T2 WHERE T3.leaserule = T2.leaserule AND T3.ruletype = \'P\' AND T3.leaserule = ?) )  UNION ALL (SELECT T3.leaserule, T3.leasedocument, T3.ruletype, CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T1.chargeperiod, T1.chargedaterule, T1.summ, T1.currency, T1.resource FROM leaserules  T3, leasechargerules  T1 WHERE T3.leaserule = T1.leaserule AND T3.ruletype = \'N\' AND T3.leaserule = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseRuleBean_75a2de69
	 */
	public EJSJDBCPersisterCMPLeaseRuleBean_75a2de69() throws java.rmi.RemoteException {
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
		LeaseRuleBean b = (LeaseRuleBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.leaseRule);
			if (b.leaseDocument_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.leaseDocument_leaseDocument.intValue());
			}
			pstmt.setString(3, "Z");
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
		LeaseRuleBean b = (LeaseRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leaseRule = _primaryKey.leaseRule;
		tempint = resultSet.getInt(2);
		b.leaseDocument_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseRuleBean b = (LeaseRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leaseRule);
			pstmt.setInt(2, _primaryKey.leaseRule);
			pstmt.setInt(3, _primaryKey.leaseRule);
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
		LeaseRuleBean b = (LeaseRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseRuleBean b = (LeaseRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(3, _primaryKey.leaseRule);
			if (b.leaseDocument_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.leaseDocument_leaseDocument.intValue());
			}
			pstmt.setString(2, "Z");
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
		LeaseRuleBean b = (LeaseRuleBean) eb;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = new com.hps.july.persistence.LeaseRuleKey();
		_primaryKey.leaseRule = b.leaseRule;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
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
		if ( discriminator.equals("Z") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("N") ) {
				homeName = "LeaseChargeRule";
			}
			else
			if ( discriminator.equals("P") ) {
				homeName = "LeasePayRule";
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
	 * findLeaseRulesByLeaseDocument
	 */
	public EJSFinder findLeaseRulesByLeaseDocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("((SELECT T3.leaserule, T3.leasedocument, T3.ruletype, CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM leaserules  T3 WHERE T3.ruletype = \'Z\' AND T3.leasedocument = ?)  UNION ALL (SELECT T3.leaserule, T3.leasedocument, T3.ruletype, T2.payterms, T2.summ, T2.paypurpose, T2.payperiod, T2.pptype, T2.paytype, T2.separatendspay, T2.paybeforedate, T2.validdatepay, T2.resource, T2.currency, T2.orgtopay, T2.orgacc, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM leaserules  T3, leasepayrules  T2 WHERE T3.leaserule = T2.leaserule AND T3.ruletype = \'P\' AND T3.leasedocument = ?) )  UNION ALL (SELECT T3.leaserule, T3.leasedocument, T3.ruletype, CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T1.chargeperiod, T1.chargedaterule, T1.summ, T1.currency, T1.resource FROM leaserules  T3, leasechargerules  T1 WHERE T3.leaserule = T1.leaserule AND T3.ruletype = \'N\' AND T3.leasedocument = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
			pstmt.setInt(2, inKey.leaseDocument);
			pstmt.setInt(3, inKey.leaseDocument);
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
	public com.hps.july.persistence.LeaseRule findByPrimaryKey(com.hps.july.persistence.LeaseRuleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.LeaseRule result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.LeaseRuleKey _primaryKey = (com.hps.july.persistence.LeaseRuleKey)key;
		try {
			try {
				result = (com.hps.july.persistence.LeaseRule)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.leaseRule);
				pstmt.setInt(2, _primaryKey.leaseRule);
				pstmt.setInt(3, _primaryKey.leaseRule);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.LeaseRule)tmpFinder.nextElement();
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
	private static final String genericFindSqlString = "((SELECT T3.leaserule, T3.leasedocument, T3.ruletype, CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM leaserules  T3 WHERE T3.ruletype = \'Z\' AND )  UNION ALL (SELECT T3.leaserule, T3.leasedocument, T3.ruletype, T2.payterms, T2.summ, T2.paypurpose, T2.payperiod, T2.pptype, T2.paytype, T2.separatendspay, T2.paybeforedate, T2.validdatepay, T2.resource, T2.currency, T2.orgtopay, T2.orgacc, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER) FROM leaserules  T3, leasepayrules  T2 WHERE T3.leaserule = T2.leaserule AND T3.ruletype = \'P\' AND ) )  UNION ALL (SELECT T3.leaserule, T3.leasedocument, T3.ruletype, CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS DECIMAL(15, 2)), CAST(NULL AS CHARACTER VARYING(255)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T1.chargeperiod, T1.chargedaterule, T1.summ, T1.currency, T1.resource FROM leaserules  T3, leasechargerules  T1 WHERE T3.leaserule = T1.leaserule AND T3.ruletype = \'N\' AND ) ";
	private static final int[] genericFindInsertPoints = {1601, 1024, 560};
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
	private LeaseRuleBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseRuleBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseRuleBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseRuleBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
