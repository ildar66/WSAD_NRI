package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEQueryListBean_543889f5
 */
public class EJSJDBCPersisterCMPPIEQueryListBean_543889f5 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEQueryListBean {
	private static final String _createString = "INSERT INTO pie_query_list (id_query_list, idobjnriint, idobjnristr, typeobjnri, id_query) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_query_list  WHERE id_query_list = ?";
	private static final String _storeString = "UPDATE pie_query_list  SET idobjnriint = ?, idobjnristr = ?, typeobjnri = ?, id_query = ? WHERE id_query_list = ?";
	private static final String _loadString = "SELECT T1.id_query_list, T1.idobjnriint, T1.idobjnristr, T1.typeobjnri, T1.id_query FROM pie_query_list  T1 WHERE T1.id_query_list = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"idobjnriint", "idobjnristr", "typeobjnri", "id_query"};
	private static final boolean[] _predicateMaps = {true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEQueryListBean_543889f5
	 */
	public EJSJDBCPersisterCMPPIEQueryListBean_543889f5() throws java.rmi.RemoteException {
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
		PIEQueryListBean b = (PIEQueryListBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[4];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idquerylist);
			if (b.idobjnriint == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.idobjnriint.intValue());
			}
			cacheData[0] = b.idobjnriint;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.idobjnristr);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typeobjnri);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			if (b.query_idquery == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.query_idquery.intValue());
			}
			cacheData[3] = b.query_idquery;
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
		PIEQueryListBean b = (PIEQueryListBean) eb;
		com.hps.july.persistence.PIEQueryListKey _primaryKey = (com.hps.july.persistence.PIEQueryListKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idquerylist = _primaryKey.idquerylist;
		tempint = resultSet.getInt(2);
		b.idobjnriint = resultSet.wasNull() ? null : new Integer(tempint);
		b.idobjnristr = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.typeobjnri = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		tempint = resultSet.getInt(5);
		b.query_idquery = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[4];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getString(4);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEQueryListBean b = (PIEQueryListBean) eb;
		com.hps.july.persistence.PIEQueryListKey _primaryKey = (com.hps.july.persistence.PIEQueryListKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idquerylist);
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
		PIEQueryListBean b = (PIEQueryListBean) eb;
		com.hps.july.persistence.PIEQueryListKey _primaryKey = new com.hps.july.persistence.PIEQueryListKey();
		_primaryKey.idquerylist = b.idquerylist;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEQueryListBean b = (PIEQueryListBean) eb;
		com.hps.july.persistence.PIEQueryListKey _primaryKey = new com.hps.july.persistence.PIEQueryListKey();
		_primaryKey.idquerylist = b.idquerylist;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(5, _primaryKey.idquerylist);
			if (b.idobjnriint == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.idobjnriint.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.idobjnristr);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typeobjnri);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.query_idquery == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.query_idquery.intValue());
			}
			int inputPos = 5;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
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
		PIEQueryListBean b = (PIEQueryListBean) eb;
		com.hps.july.persistence.PIEQueryListKey _primaryKey = new com.hps.july.persistence.PIEQueryListKey();
		_primaryKey.idquerylist = b.idquerylist;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idquerylist);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
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
		com.hps.july.persistence.PIEQueryListKey key = new com.hps.july.persistence.PIEQueryListKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idquerylist = resultSet.getInt(1);
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
	public com.hps.july.persistence.PIEQueryList findByPrimaryKey(com.hps.july.persistence.PIEQueryListKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEQueryList) home.activateBean(key);
	}
	/**
	 * findPIEQueryListsByQuery
	 */
	public EJSFinder findPIEQueryListsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.id_query_list, T1.idobjnriint, T1.idobjnristr, T1.typeobjnri, T1.id_query FROM pie_query_list  T1 WHERE T1.id_query = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idquery);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
