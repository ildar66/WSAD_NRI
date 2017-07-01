package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPGroup2ResourceBean_ebda9379
 */
public class EJSJDBCPersisterCMPGroup2ResourceBean_ebda9379 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderGroup2ResourceBean {
	private static final String _createString = "INSERT INTO group2res (groupid, resource, qty) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM group2res  WHERE groupid = ? AND resource = ?";
	private static final String _storeString = "UPDATE group2res  SET qty = ? WHERE groupid = ? AND resource = ?";
	private static final String _loadString = "SELECT T1.groupid, T1.resource, T1.qty FROM group2res  T1 WHERE T1.groupid = ? AND T1.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"qty"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPGroup2ResourceBean_ebda9379
	 */
	public EJSJDBCPersisterCMPGroup2ResourceBean_ebda9379() throws java.rmi.RemoteException {
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
		Group2ResourceBean b = (Group2ResourceBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.groupid);
			pstmt.setInt(2, b.resource);
			if (b.qty == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.qty);
			}
			cacheData[0] = b.qty;
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
		Group2ResourceBean b = (Group2ResourceBean) eb;
		com.hps.july.persistence2.Group2ResourceKey _primaryKey = (com.hps.july.persistence2.Group2ResourceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.groupid = _primaryKey.groupid;
		b.resource = _primaryKey.resource;
		b.qty = resultSet.getBigDecimal(3);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getBigDecimal(3);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		Group2ResourceBean b = (Group2ResourceBean) eb;
		com.hps.july.persistence2.Group2ResourceKey _primaryKey = (com.hps.july.persistence2.Group2ResourceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.groupid);
			pstmt.setInt(2, _primaryKey.resource);
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
		Group2ResourceBean b = (Group2ResourceBean) eb;
		com.hps.july.persistence2.Group2ResourceKey _primaryKey = new com.hps.july.persistence2.Group2ResourceKey();
		_primaryKey.groupid = b.groupid;
		_primaryKey.resource = b.resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		Group2ResourceBean b = (Group2ResourceBean) eb;
		com.hps.july.persistence2.Group2ResourceKey _primaryKey = new com.hps.july.persistence2.Group2ResourceKey();
		_primaryKey.groupid = b.groupid;
		_primaryKey.resource = b.resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(2, _primaryKey.groupid);
			pstmt.setInt(3, _primaryKey.resource);
			if (b.qty == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.qty);
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
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		Group2ResourceBean b = (Group2ResourceBean) eb;
		com.hps.july.persistence2.Group2ResourceKey _primaryKey = new com.hps.july.persistence2.Group2ResourceKey();
		_primaryKey.groupid = b.groupid;
		_primaryKey.resource = b.resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.groupid);
			pstmt.setInt(2, _primaryKey.resource);
			int inputPos = 2;
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
		com.hps.july.persistence2.Group2ResourceKey key = new com.hps.july.persistence2.Group2ResourceKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.groupid = resultSet.getInt(1);
			key.resource = resultSet.getInt(2);
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
	public com.hps.july.persistence2.Group2Resource findByPrimaryKey(com.hps.july.persistence2.Group2ResourceKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.Group2Resource) home.activateBean(primaryKey);
	}
}
