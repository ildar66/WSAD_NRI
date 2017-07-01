package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPInventoryNumbersBean_bc436f0d
 */
public class EJSJDBCPersisterCMPInventoryNumbersBean_bc436f0d extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderInventoryNumbersBean {
	private static final String _createString = "INSERT INTO InventoryNumbers (serid, serdate, serend, serprefix, serstart, serworker) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM InventoryNumbers  WHERE serid = ?";
	private static final String _storeString = "UPDATE InventoryNumbers  SET serdate = ?, serend = ?, serprefix = ?, serstart = ?, serworker = ? WHERE serid = ?";
	private static final String _loadString = "SELECT T1.serid, T1.serdate, T1.serend, T1.serprefix, T1.serstart, T1.serworker FROM InventoryNumbers  T1 WHERE T1.serid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"serdate", "serend", "serprefix", "serstart", "serworker"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPInventoryNumbersBean_bc436f0d
	 */
	public EJSJDBCPersisterCMPInventoryNumbersBean_bc436f0d() throws java.rmi.RemoteException {
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
		InventoryNumbersBean b = (InventoryNumbersBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[5];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.serid);
			if (b.serdate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.serdate);
			}
			cacheData[0] = b.serdate;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serend);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serprefix);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serstart);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
			if (b.serworker_worker == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.serworker_worker.intValue());
			}
			cacheData[4] = b.serworker_worker;
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
		InventoryNumbersBean b = (InventoryNumbersBean) eb;
		com.hps.july.persistence.InventoryNumbersKey _primaryKey = (com.hps.july.persistence.InventoryNumbersKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.serid = _primaryKey.serid;
		b.serdate = resultSet.getDate(2);
		b.serend = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.serprefix = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.serstart = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		tempint = resultSet.getInt(6);
		b.serworker_worker = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[5];
		cacheData[0] = resultSet.getDate(2);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getString(4);
		cacheData[3] = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		InventoryNumbersBean b = (InventoryNumbersBean) eb;
		com.hps.july.persistence.InventoryNumbersKey _primaryKey = (com.hps.july.persistence.InventoryNumbersKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.serid);
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
		InventoryNumbersBean b = (InventoryNumbersBean) eb;
		com.hps.july.persistence.InventoryNumbersKey _primaryKey = new com.hps.july.persistence.InventoryNumbersKey();
		_primaryKey.serid = b.serid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		InventoryNumbersBean b = (InventoryNumbersBean) eb;
		com.hps.july.persistence.InventoryNumbersKey _primaryKey = new com.hps.july.persistence.InventoryNumbersKey();
		_primaryKey.serid = b.serid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(6, _primaryKey.serid);
			if (b.serdate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.serdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serend);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serprefix);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serstart);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.serworker_worker == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.serworker_worker.intValue());
			}
			int inputPos = 6;
			if (cacheData[0] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
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
		InventoryNumbersBean b = (InventoryNumbersBean) eb;
		com.hps.july.persistence.InventoryNumbersKey _primaryKey = new com.hps.july.persistence.InventoryNumbersKey();
		_primaryKey.serid = b.serid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.serid);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
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
		com.hps.july.persistence.InventoryNumbersKey key = new com.hps.july.persistence.InventoryNumbersKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.serid = resultSet.getInt(1);
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
	 * findOrderBySerstartAsc
	 */
	public EJSFinder findOrderBySerstartAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.serid, T1.serdate, T1.serend, T1.serprefix, T1.serstart, T1.serworker FROM InventoryNumbers  T1 WHERE 1=1 order by serstart asc");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findOrderBySerprefixDesc
	 */
	public EJSFinder findOrderBySerprefixDesc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.serid, T1.serdate, T1.serend, T1.serprefix, T1.serstart, T1.serworker FROM InventoryNumbers  T1 WHERE 1=1 order by serprefix desc");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findInventoryNumbersBySerworker
	 */
	public EJSFinder findInventoryNumbersBySerworker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.serid, T1.serdate, T1.serend, T1.serprefix, T1.serstart, T1.serworker FROM InventoryNumbers  T1 WHERE T1.serworker = ?");
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
	 * findOrderBySerstartDesc
	 */
	public EJSFinder findOrderBySerstartDesc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.serid, T1.serdate, T1.serend, T1.serprefix, T1.serstart, T1.serworker FROM InventoryNumbers  T1 WHERE 1=1 order by serstart desc");
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
	public com.hps.july.persistence.InventoryNumbers findByPrimaryKey(com.hps.july.persistence.InventoryNumbersKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.InventoryNumbers) home.activateBean(key);
	}
	/**
	 * findOrderBySerprefixAsc
	 */
	public EJSFinder findOrderBySerprefixAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.serid, T1.serdate, T1.serend, T1.serprefix, T1.serstart, T1.serworker FROM InventoryNumbers  T1 WHERE 1=1 order by serprefix asc");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
