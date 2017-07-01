package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPEtap2HopBean_9a16d484
 */
public class EJSJDBCPersisterCMPEtap2HopBean_9a16d484 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderEtap2HopBean {
	private static final String _createString = "INSERT INTO etap2hops (hopsid, sitedoc, freqpermid) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM etap2hops  WHERE hopsid = ? AND sitedoc = ?";
	private static final String _storeString = "UPDATE etap2hops  SET freqpermid = ? WHERE hopsid = ? AND sitedoc = ?";
	private static final String _loadString = "SELECT T1.hopsid, T1.sitedoc, T1.freqpermid FROM etap2hops  T1 WHERE T1.hopsid = ? AND T1.sitedoc = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"freqpermid"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPEtap2HopBean_9a16d484
	 */
	public EJSJDBCPersisterCMPEtap2HopBean_9a16d484() throws java.rmi.RemoteException {
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
		Etap2HopBean b = (Etap2HopBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.hopsid);
			pstmt.setInt(2, b.sitedoc);
			pstmt.setInt(3, b.freqpermid);
			cacheData[0] = new Integer(b.freqpermid);
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
		Etap2HopBean b = (Etap2HopBean) eb;
		com.hps.july.persistence2.Etap2HopKey _primaryKey = (com.hps.july.persistence2.Etap2HopKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.hopsid = _primaryKey.hopsid;
		b.sitedoc = _primaryKey.sitedoc;
		b.freqpermid = resultSet.getInt(3);
		Object[] cacheData = new Object[1];
		tempint = resultSet.getInt(3);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		Etap2HopBean b = (Etap2HopBean) eb;
		com.hps.july.persistence2.Etap2HopKey _primaryKey = (com.hps.july.persistence2.Etap2HopKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.hopsid);
			pstmt.setInt(2, _primaryKey.sitedoc);
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
		Etap2HopBean b = (Etap2HopBean) eb;
		com.hps.july.persistence2.Etap2HopKey _primaryKey = new com.hps.july.persistence2.Etap2HopKey();
		_primaryKey.hopsid = b.hopsid;
		_primaryKey.sitedoc = b.sitedoc;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		Etap2HopBean b = (Etap2HopBean) eb;
		com.hps.july.persistence2.Etap2HopKey _primaryKey = new com.hps.july.persistence2.Etap2HopKey();
		_primaryKey.hopsid = b.hopsid;
		_primaryKey.sitedoc = b.sitedoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(2, _primaryKey.hopsid);
			pstmt.setInt(3, _primaryKey.sitedoc);
			pstmt.setInt(1, b.freqpermid);
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		Etap2HopBean b = (Etap2HopBean) eb;
		com.hps.july.persistence2.Etap2HopKey _primaryKey = new com.hps.july.persistence2.Etap2HopKey();
		_primaryKey.hopsid = b.hopsid;
		_primaryKey.sitedoc = b.sitedoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.hopsid);
			pstmt.setInt(2, _primaryKey.sitedoc);
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		com.hps.july.persistence2.Etap2HopKey key = new com.hps.july.persistence2.Etap2HopKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.hopsid = resultSet.getInt(1);
			key.sitedoc = resultSet.getInt(2);
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
	 * findBySitedocAndPermid
	 */
	public EJSFinder findBySitedocAndPermid(java.lang.Integer argSiteDoc, java.lang.Integer argPermid) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.hopsid, T1.sitedoc, T1.freqpermid FROM etap2hops  T1 WHERE sitedoc = ? AND freqpermid = ?");
			pstmt.setObject(1, argSiteDoc);
			pstmt.setObject(2, argPermid);
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
	public com.hps.july.persistence2.Etap2Hop findByPrimaryKey(com.hps.july.persistence2.Etap2HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.Etap2Hop) home.activateBean(key);
	}
}
