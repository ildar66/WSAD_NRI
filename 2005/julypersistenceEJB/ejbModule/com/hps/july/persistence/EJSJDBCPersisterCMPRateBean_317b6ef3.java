package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPRateBean_317b6ef3
 */
public class EJSJDBCPersisterCMPRateBean_317b6ef3 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderRateBean {
	private static final String _createString = "INSERT INTO rates (date, ratetype, currency, value) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM rates  WHERE date = ? AND ratetype = ? AND currency = ?";
	private static final String _storeString = "UPDATE rates  SET value = ? WHERE date = ? AND ratetype = ? AND currency = ?";
	private static final String _loadString = "SELECT T1.value, T1.date, T1.ratetype, T1.currency FROM rates  T1 WHERE T1.date = ? AND T1.ratetype = ? AND T1.currency = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"value"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPRateBean_317b6ef3
	 */
	public EJSJDBCPersisterCMPRateBean_317b6ef3() throws java.rmi.RemoteException {
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
		RateBean b = (RateBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.value == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.value);
			}
			cacheData[0] = b.value;
			if (b.date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.date);
			}
			if (b.type_ratetype == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.type_ratetype.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.currency_currency.intValue());
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
		RateBean b = (RateBean) eb;
		com.hps.july.persistence.RateKey _primaryKey = (com.hps.july.persistence.RateKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.date = _primaryKey.date;
		b.type_ratetype = _primaryKey.type_ratetype;
		b.currency_currency = _primaryKey.currency_currency;
		b.value = resultSet.getBigDecimal(1);
		tempint = resultSet.getInt(3);
		b.type_ratetype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.currency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getBigDecimal(1);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		RateBean b = (RateBean) eb;
		com.hps.july.persistence.RateKey _primaryKey = (com.hps.july.persistence.RateKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.date);
			}
			if (_primaryKey.type_ratetype == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.type_ratetype.intValue());
			}
			if (_primaryKey.currency_currency == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.currency_currency.intValue());
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
		RateBean b = (RateBean) eb;
		com.hps.july.persistence.RateKey _primaryKey = new com.hps.july.persistence.RateKey();
		_primaryKey.date = b.date;
		_primaryKey.type_ratetype = b.type_ratetype;
		_primaryKey.currency_currency = b.currency_currency;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RateBean b = (RateBean) eb;
		com.hps.july.persistence.RateKey _primaryKey = new com.hps.july.persistence.RateKey();
		_primaryKey.date = b.date;
		_primaryKey.type_ratetype = b.type_ratetype;
		_primaryKey.currency_currency = b.currency_currency;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.date == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, _primaryKey.date);
			}
			if (_primaryKey.type_ratetype == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.type_ratetype.intValue());
			}
			if (_primaryKey.currency_currency == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, _primaryKey.currency_currency.intValue());
			}
			if (b.value == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.value);
			}
			if (b.type_ratetype == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.type_ratetype.intValue());
			}
			if (b.currency_currency == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.currency_currency.intValue());
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
		RateBean b = (RateBean) eb;
		com.hps.july.persistence.RateKey _primaryKey = new com.hps.july.persistence.RateKey();
		_primaryKey.date = b.date;
		_primaryKey.type_ratetype = b.type_ratetype;
		_primaryKey.currency_currency = b.currency_currency;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.date);
			}
			if (_primaryKey.type_ratetype == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.type_ratetype.intValue());
			}
			if (_primaryKey.currency_currency == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.currency_currency.intValue());
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
		com.hps.july.persistence.RateKey key = new com.hps.july.persistence.RateKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.date = resultSet.getDate(2);
			tempint = resultSet.getInt(3);
			key.type_ratetype = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findByTypeDate
	 */
	public EJSFinder findByTypeDate(java.lang.Integer type, java.sql.Date date) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.value, T1.date, T1.ratetype, T1.currency FROM rates  T1 WHERE ratetype = ? and date=(select max(t2.date) from rates t2 where t1.ratetype= t2.ratetype and t1.currency=t2.currency and t2.date <= ? )");
			pstmt.setObject(1, type);
			pstmt.setDate(2, date);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findRateByType
	 */
	public EJSFinder findRateByType(com.hps.july.persistence.RateTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.value, T1.date, T1.ratetype, T1.currency FROM rates  T1 WHERE T1.ratetype = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.ratetype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByTypeAndCurrencyOrderByDateDesc
	 */
	public EJSFinder findByTypeAndCurrencyOrderByDateDesc(java.lang.Integer argType, java.lang.Integer argCurrency) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.value, T1.date, T1.ratetype, T1.currency FROM rates  T1 WHERE ratetype = ? and currency = ? order by date desc");
			pstmt.setObject(1, argType);
			pstmt.setObject(2, argCurrency);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findRatesByCurrency
	 */
	public EJSFinder findRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.value, T1.date, T1.ratetype, T1.currency FROM rates  T1 WHERE T1.currency = ?");
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
	public com.hps.july.persistence.Rate findByPrimaryKey(com.hps.july.persistence.RateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Rate) home.activateBean(key);
	}
	/**
	 * findByTypeCurrencyForDate
	 */
	public com.hps.july.persistence.Rate findByTypeCurrencyForDate(java.lang.Integer type, java.lang.Integer currency, java.sql.Date date) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Rate result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.value, T1.date, T1.ratetype, T1.currency FROM rates  T1 WHERE ratetype = ? and currency = ? and date=(select max(t2.date) from rates t2 where t1.ratetype= t2.ratetype and t1.currency=t2.currency and t2.date <= ? )");
			pstmt.setObject(1, type);
			pstmt.setObject(2, currency);
			pstmt.setDate(3, date);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.Rate)tmpFinder.nextElement();
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
}
