package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEOtvUserLinkBean_112a133a
 */
public class EJSJDBCPersisterCMPPIEOtvUserLinkBean_112a133a extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEOtvUserLinkBean {
	private static final String _createString = "INSERT INTO pie_otvuserlink (otvusernri, otvuserplatinum) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM pie_otvuserlink  WHERE otvusernri = ?";
	private static final String _storeString = "UPDATE pie_otvuserlink  SET otvuserplatinum = ? WHERE otvusernri = ?";
	private static final String _loadString = "SELECT T1.otvusernri, T1.otvuserplatinum FROM pie_otvuserlink  T1 WHERE T1.otvusernri = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"otvuserplatinum"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEOtvUserLinkBean_112a133a
	 */
	public EJSJDBCPersisterCMPPIEOtvUserLinkBean_112a133a() throws java.rmi.RemoteException {
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
		PIEOtvUserLinkBean b = (PIEOtvUserLinkBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.otvusernri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.otvuserplatinum_otvuserplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
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
		PIEOtvUserLinkBean b = (PIEOtvUserLinkBean) eb;
		com.hps.july.persistence.PIEOtvUserLinkKey _primaryKey = (com.hps.july.persistence.PIEOtvUserLinkKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.otvusernri = _primaryKey.otvusernri;
		b.otvuserplatinum_otvuserplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getString(2);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEOtvUserLinkBean b = (PIEOtvUserLinkBean) eb;
		com.hps.july.persistence.PIEOtvUserLinkKey _primaryKey = (com.hps.july.persistence.PIEOtvUserLinkKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.otvusernri);
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
		PIEOtvUserLinkBean b = (PIEOtvUserLinkBean) eb;
		com.hps.july.persistence.PIEOtvUserLinkKey _primaryKey = new com.hps.july.persistence.PIEOtvUserLinkKey();
		_primaryKey.otvusernri = b.otvusernri;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEOtvUserLinkBean b = (PIEOtvUserLinkBean) eb;
		com.hps.july.persistence.PIEOtvUserLinkKey _primaryKey = new com.hps.july.persistence.PIEOtvUserLinkKey();
		_primaryKey.otvusernri = b.otvusernri;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(2, _primaryKey.otvusernri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.otvuserplatinum_otvuserplatinum);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
		PIEOtvUserLinkBean b = (PIEOtvUserLinkBean) eb;
		com.hps.july.persistence.PIEOtvUserLinkKey _primaryKey = new com.hps.july.persistence.PIEOtvUserLinkKey();
		_primaryKey.otvusernri = b.otvusernri;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.otvusernri);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
		com.hps.july.persistence.PIEOtvUserLinkKey key = new com.hps.july.persistence.PIEOtvUserLinkKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.otvusernri = resultSet.getInt(1);
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
	 * findPIEOtvUserLinksByOtvuserplatinum
	 */
	public EJSFinder findPIEOtvUserLinksByOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinumKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.otvusernri, T1.otvuserplatinum FROM pie_otvuserlink  T1 WHERE T1.otvuserplatinum = ?");
			Object objectTemp = null;
boolean nullData;
			nullData = true;   // assuming <parm> == null
			if ( inKey != null) {
				objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(inKey.otvuserplatinum);
				nullData = (objectTemp == null);
			}
			if (nullData) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
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
	public com.hps.july.persistence.PIEOtvUserLink findByPrimaryKey(com.hps.july.persistence.PIEOtvUserLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEOtvUserLink) home.activateBean(key);
	}
}
