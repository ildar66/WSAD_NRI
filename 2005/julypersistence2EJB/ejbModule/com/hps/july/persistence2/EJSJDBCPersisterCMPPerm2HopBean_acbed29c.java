package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPerm2HopBean_acbed29c
 */
public class EJSJDBCPersisterCMPPerm2HopBean_acbed29c extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderPerm2HopBean {
	private static final String _createString = "INSERT INTO perm2hops (freqpermid, hopsid, numberinfile) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM perm2hops  WHERE freqpermid = ? AND hopsid = ?";
	private static final String _storeString = "UPDATE perm2hops  SET numberinfile = ? WHERE freqpermid = ? AND hopsid = ?";
	private static final String _loadString = "SELECT T1.freqpermid, T1.hopsid, T1.numberinfile FROM perm2hops  T1 WHERE T1.freqpermid = ? AND T1.hopsid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"numberinfile"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPerm2HopBean_acbed29c
	 */
	public EJSJDBCPersisterCMPPerm2HopBean_acbed29c() throws java.rmi.RemoteException {
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
		Perm2HopBean b = (Perm2HopBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.freqpermid);
			pstmt.setInt(2, b.hopsid);
			if (b.numberinfile == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.numberinfile.intValue());
			}
			cacheData[0] = b.numberinfile;
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
		Perm2HopBean b = (Perm2HopBean) eb;
		com.hps.july.persistence2.Perm2HopKey _primaryKey = (com.hps.july.persistence2.Perm2HopKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.freqpermid = _primaryKey.freqpermid;
		b.hopsid = _primaryKey.hopsid;
		tempint = resultSet.getInt(3);
		b.numberinfile = resultSet.wasNull() ? null : new Integer(tempint);
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
		Perm2HopBean b = (Perm2HopBean) eb;
		com.hps.july.persistence2.Perm2HopKey _primaryKey = (com.hps.july.persistence2.Perm2HopKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.freqpermid);
			pstmt.setInt(2, _primaryKey.hopsid);
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
		Perm2HopBean b = (Perm2HopBean) eb;
		com.hps.july.persistence2.Perm2HopKey _primaryKey = new com.hps.july.persistence2.Perm2HopKey();
		_primaryKey.freqpermid = b.freqpermid;
		_primaryKey.hopsid = b.hopsid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		Perm2HopBean b = (Perm2HopBean) eb;
		com.hps.july.persistence2.Perm2HopKey _primaryKey = new com.hps.july.persistence2.Perm2HopKey();
		_primaryKey.freqpermid = b.freqpermid;
		_primaryKey.hopsid = b.hopsid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(2, _primaryKey.freqpermid);
			pstmt.setInt(3, _primaryKey.hopsid);
			if (b.numberinfile == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.numberinfile.intValue());
			}
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
		Perm2HopBean b = (Perm2HopBean) eb;
		com.hps.july.persistence2.Perm2HopKey _primaryKey = new com.hps.july.persistence2.Perm2HopKey();
		_primaryKey.freqpermid = b.freqpermid;
		_primaryKey.hopsid = b.hopsid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.freqpermid);
			pstmt.setInt(2, _primaryKey.hopsid);
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
		com.hps.july.persistence2.Perm2HopKey key = new com.hps.july.persistence2.Perm2HopKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.freqpermid = resultSet.getInt(1);
			key.hopsid = resultSet.getInt(2);
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
	public com.hps.july.persistence2.Perm2Hop findByPrimaryKey(com.hps.july.persistence2.Perm2HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.Perm2Hop) home.activateBean(key);
	}
}
