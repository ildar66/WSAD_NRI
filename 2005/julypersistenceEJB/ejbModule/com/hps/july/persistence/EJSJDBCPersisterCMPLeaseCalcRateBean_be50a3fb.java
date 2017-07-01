package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseCalcRateBean_be50a3fb
 */
public class EJSJDBCPersisterCMPLeaseCalcRateBean_be50a3fb extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseCalcRateBean {
	private static final String _createString = "INSERT INTO leasecalcrates (leasedocposition, currency, byhand, rate, act) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasecalcrates  WHERE leasedocposition = ? AND currency = ?";
	private static final String _storeString = "UPDATE leasecalcrates  SET byhand = ?, rate = ?, act = ? WHERE leasedocposition = ? AND currency = ?";
	private static final String _loadString = "SELECT T1.byhand, T1.rate, T1.leasedocposition, T1.currency, T1.act FROM leasecalcrates  T1 WHERE T1.leasedocposition = ? AND T1.currency = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"byhand", "rate", "act"};
	private static final boolean[] _predicateMaps = {true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseCalcRateBean_be50a3fb
	 */
	public EJSJDBCPersisterCMPLeaseCalcRateBean_be50a3fb() throws java.rmi.RemoteException {
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
		LeaseCalcRateBean b = (LeaseCalcRateBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[3];
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			if (b.rate == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.rate);
			}
			cacheData[1] = b.rate;
			if (b.docposition_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.docposition_leaseDocPosition.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.currency_currency.intValue());
			}
			if (b.act_leaseDocument == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.act_leaseDocument.intValue());
			}
			cacheData[2] = b.act_leaseDocument;
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
		LeaseCalcRateBean b = (LeaseCalcRateBean) eb;
		com.hps.july.persistence.LeaseCalcRateKey _primaryKey = (com.hps.july.persistence.LeaseCalcRateKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.docposition_leaseDocPosition = _primaryKey.docposition_leaseDocPosition;
		b.currency_currency = _primaryKey.currency_currency;
		b.byhand = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(1));
		b.rate = resultSet.getBigDecimal(2);
		tempint = resultSet.getInt(3);
		b.docposition_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.currency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.act_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[3];
		cacheData[0] = resultSet.getString(1);
		cacheData[1] = resultSet.getBigDecimal(2);
		tempint = resultSet.getInt(5);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseCalcRateBean b = (LeaseCalcRateBean) eb;
		com.hps.july.persistence.LeaseCalcRateKey _primaryKey = (com.hps.july.persistence.LeaseCalcRateKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.docposition_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.docposition_leaseDocPosition.intValue());
			}
			if (_primaryKey.currency_currency == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.currency_currency.intValue());
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
		LeaseCalcRateBean b = (LeaseCalcRateBean) eb;
		com.hps.july.persistence.LeaseCalcRateKey _primaryKey = new com.hps.july.persistence.LeaseCalcRateKey();
		_primaryKey.docposition_leaseDocPosition = b.docposition_leaseDocPosition;
		_primaryKey.currency_currency = b.currency_currency;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseCalcRateBean b = (LeaseCalcRateBean) eb;
		com.hps.july.persistence.LeaseCalcRateKey _primaryKey = new com.hps.july.persistence.LeaseCalcRateKey();
		_primaryKey.docposition_leaseDocPosition = b.docposition_leaseDocPosition;
		_primaryKey.currency_currency = b.currency_currency;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.docposition_leaseDocPosition == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, _primaryKey.docposition_leaseDocPosition.intValue());
			}
			if (_primaryKey.currency_currency == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, _primaryKey.currency_currency.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.rate == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.rate);
			}
			if (b.docposition_leaseDocPosition == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.docposition_leaseDocPosition.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.currency_currency.intValue());
			}
			if (b.act_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.act_leaseDocument.intValue());
			}
			int inputPos = 5;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
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
		LeaseCalcRateBean b = (LeaseCalcRateBean) eb;
		com.hps.july.persistence.LeaseCalcRateKey _primaryKey = new com.hps.july.persistence.LeaseCalcRateKey();
		_primaryKey.docposition_leaseDocPosition = b.docposition_leaseDocPosition;
		_primaryKey.currency_currency = b.currency_currency;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.docposition_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.docposition_leaseDocPosition.intValue());
			}
			if (_primaryKey.currency_currency == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.currency_currency.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
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
		com.hps.july.persistence.LeaseCalcRateKey key = new com.hps.july.persistence.LeaseCalcRateKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(3);
			key.docposition_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(4);
			key.currency_currency = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findBy_Hand_LeaseDocPosition
	 */
	public EJSFinder findBy_Hand_LeaseDocPosition(java.lang.String argByHand, java.lang.Integer argDocPosition) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.byhand, T1.rate, T1.leasedocposition, T1.currency, T1.act FROM leasecalcrates  T1 WHERE byhand = ? AND leasedocposition = ?");
			if (argByHand == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argByHand);
			}
			pstmt.setObject(2, argDocPosition);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseCalcRatesByDocposition
	 */
	public EJSFinder findLeaseCalcRatesByDocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.byhand, T1.rate, T1.leasedocposition, T1.currency, T1.act FROM leasecalcrates  T1 WHERE T1.leasedocposition = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocPosition);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseCalcRatesByCurrency
	 */
	public EJSFinder findLeaseCalcRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.byhand, T1.rate, T1.leasedocposition, T1.currency, T1.act FROM leasecalcrates  T1 WHERE T1.currency = ?");
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
	public com.hps.july.persistence.LeaseCalcRate findByPrimaryKey(com.hps.july.persistence.LeaseCalcRateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseCalcRate) home.activateBean(key);
	}
	/**
	 * findLeaseCalcRatesByAct
	 */
	public EJSFinder findLeaseCalcRatesByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.byhand, T1.rate, T1.leasedocposition, T1.currency, T1.act FROM leasecalcrates  T1 WHERE T1.act = ?");
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
