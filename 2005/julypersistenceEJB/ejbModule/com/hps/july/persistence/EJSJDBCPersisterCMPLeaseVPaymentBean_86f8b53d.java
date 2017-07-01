package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseVPaymentBean_86f8b53d
 */
public class EJSJDBCPersisterCMPLeaseVPaymentBean_86f8b53d extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseVPaymentBean {
	private static final String _createString = "INSERT INTO leasevpayment (act, debetcontract, creditcontract, summ) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasevpayment  WHERE act = ? AND debetcontract = ? AND creditcontract = ?";
	private static final String _storeString = "UPDATE leasevpayment  SET summ = ? WHERE act = ? AND debetcontract = ? AND creditcontract = ?";
	private static final String _loadString = "SELECT T1.summ, T1.act, T1.debetcontract, T1.creditcontract FROM leasevpayment  T1 WHERE T1.act = ? AND T1.debetcontract = ? AND T1.creditcontract = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"summ"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseVPaymentBean_86f8b53d
	 */
	public EJSJDBCPersisterCMPLeaseVPaymentBean_86f8b53d() throws java.rmi.RemoteException {
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
		LeaseVPaymentBean b = (LeaseVPaymentBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.summ == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.summ);
			}
			cacheData[0] = b.summ;
			if (b.act_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.act_leaseDocument.intValue());
			}
			if (b.debetcontract_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.debetcontract_leaseDocument.intValue());
			}
			if (b.creditcontract_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.creditcontract_leaseDocument.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		putDataIntoCache(cacheData);
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		LeaseVPaymentBean b = (LeaseVPaymentBean) eb;
		com.hps.july.persistence.LeaseVPaymentKey _primaryKey = (com.hps.july.persistence.LeaseVPaymentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.act_leaseDocument = _primaryKey.act_leaseDocument;
		b.debetcontract_leaseDocument = _primaryKey.debetcontract_leaseDocument;
		b.creditcontract_leaseDocument = _primaryKey.creditcontract_leaseDocument;
		b.summ = resultSet.getBigDecimal(1);
		tempint = resultSet.getInt(2);
		b.act_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.debetcontract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.creditcontract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getBigDecimal(1);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseVPaymentBean b = (LeaseVPaymentBean) eb;
		com.hps.july.persistence.LeaseVPaymentKey _primaryKey = (com.hps.july.persistence.LeaseVPaymentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.act_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.act_leaseDocument.intValue());
			}
			if (_primaryKey.debetcontract_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.debetcontract_leaseDocument.intValue());
			}
			if (_primaryKey.creditcontract_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.creditcontract_leaseDocument.intValue());
			}
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
		LeaseVPaymentBean b = (LeaseVPaymentBean) eb;
		com.hps.july.persistence.LeaseVPaymentKey _primaryKey = new com.hps.july.persistence.LeaseVPaymentKey();
		_primaryKey.act_leaseDocument = b.act_leaseDocument;
		_primaryKey.debetcontract_leaseDocument = b.debetcontract_leaseDocument;
		_primaryKey.creditcontract_leaseDocument = b.creditcontract_leaseDocument;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseVPaymentBean b = (LeaseVPaymentBean) eb;
		com.hps.july.persistence.LeaseVPaymentKey _primaryKey = new com.hps.july.persistence.LeaseVPaymentKey();
		_primaryKey.act_leaseDocument = b.act_leaseDocument;
		_primaryKey.debetcontract_leaseDocument = b.debetcontract_leaseDocument;
		_primaryKey.creditcontract_leaseDocument = b.creditcontract_leaseDocument;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.act_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.act_leaseDocument.intValue());
			}
			if (_primaryKey.debetcontract_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.debetcontract_leaseDocument.intValue());
			}
			if (_primaryKey.creditcontract_leaseDocument == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, _primaryKey.creditcontract_leaseDocument.intValue());
			}
			if (b.summ == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.summ);
			}
			if (b.act_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.act_leaseDocument.intValue());
			}
			if (b.debetcontract_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.debetcontract_leaseDocument.intValue());
			}
			if (b.creditcontract_leaseDocument == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.creditcontract_leaseDocument.intValue());
			}
			int inputPos = 4;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
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
		LeaseVPaymentBean b = (LeaseVPaymentBean) eb;
		com.hps.july.persistence.LeaseVPaymentKey _primaryKey = new com.hps.july.persistence.LeaseVPaymentKey();
		_primaryKey.act_leaseDocument = b.act_leaseDocument;
		_primaryKey.debetcontract_leaseDocument = b.debetcontract_leaseDocument;
		_primaryKey.creditcontract_leaseDocument = b.creditcontract_leaseDocument;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.act_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.act_leaseDocument.intValue());
			}
			if (_primaryKey.debetcontract_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.debetcontract_leaseDocument.intValue());
			}
			if (_primaryKey.creditcontract_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.creditcontract_leaseDocument.intValue());
			}
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.LeaseVPaymentKey key = new com.hps.july.persistence.LeaseVPaymentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.act_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.debetcontract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(4);
			key.creditcontract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			return key;
		}
return null;
	}

	/**
	 * RdbRt
	 */
	public class RdbRt {
	public static final String EQUALS = " = ";
	public static final String ISNULL = " IS NULL";
	public static final String MARKER = "?";
	public static final String AND = " AND ";
	private String fStatement;
	private String[] fPredicates = new String[0];
	private boolean[] fPredicateMap = new boolean[0];
	public RdbRt() { }
	public RdbRt(String aStmt) {
		rootStmt(aStmt);
	}
	public RdbRt(String aStmt, String[] anArray, boolean[] aMap) {
		rootStmt(aStmt);
		predicates(anArray);
		predicateMap(aMap);
	}
	public String nativeQuery() {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer);
		return aBuffer.toString();
	}
	public String nativeQuery(Object[] values) {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer, values);
		return aBuffer.toString();
	}
	public String[] predicates() {
		return fPredicates;
	}
	public void predicates(String[] anArray) {
		fPredicates = anArray;
	}
	public boolean[] predicateMap() {
		return fPredicateMap;
	}
	public void predicateMap(boolean[] anArray) {
		fPredicateMap = anArray;
	}
	public void predicatesOn(StringBuffer aBuffer, Object[] values) {
		int j = predicates().length;
		if (j != values.length)
			throw new RuntimeException("differing number of predicates and values");
		String each;
		for (int i = 0; i < j; i++) {
			if (!fPredicateMap[i]) continue;
				aBuffer.append(AND);
			each = predicates()[i];
			aBuffer.append(each);
			if (values[i] == null)
				aBuffer.append(ISNULL);
			else {
				aBuffer.append(EQUALS);
				aBuffer.append(MARKER);
			}
		}
	}
	public String rootStmt() {
		return fStatement;
	}
	public void rootStmt(String aStmt) {
		fStatement = aStmt;
	}
	public void statementOn(StringBuffer aBuffer) {
		aBuffer.append(rootStmt());
	}
	public void statementOn(StringBuffer aBuffer, Object[] values) {
		aBuffer.append(rootStmt());
		if (predicates() != null && predicates().length != 0) {
			predicatesOn(aBuffer, values);
		}
	}
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseVPayment findByPrimaryKey(com.hps.july.persistence.LeaseVPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseVPayment) home.activateBean(key);
	}
	/**
	 * findLeaseVPaymentsByAct
	 */
	public EJSFinder findLeaseVPaymentsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.summ, T1.act, T1.debetcontract, T1.creditcontract FROM leasevpayment  T1 WHERE T1.act = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseVPaymentDsByDebetcontract
	 */
	public EJSFinder findLeaseVPaymentDsByDebetcontract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.summ, T1.act, T1.debetcontract, T1.creditcontract FROM leasevpayment  T1 WHERE T1.debetcontract = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseVPaymentCsByCreditcontract
	 */
	public EJSFinder findLeaseVPaymentCsByCreditcontract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.summ, T1.act, T1.debetcontract, T1.creditcontract FROM leasevpayment  T1 WHERE T1.creditcontract = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
