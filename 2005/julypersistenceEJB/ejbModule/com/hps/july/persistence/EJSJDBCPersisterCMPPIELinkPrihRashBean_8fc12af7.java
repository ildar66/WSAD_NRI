package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIELinkPrihRashBean_8fc12af7
 */
public class EJSJDBCPersisterCMPPIELinkPrihRashBean_8fc12af7 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIELinkPrihRashBean {
	private static final String _createString = "INSERT INTO pie_linkprihrash (idlinkprihodrashod, docposprihod, docposrashod, fromstorageprihod, qty) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_linkprihrash  WHERE idlinkprihodrashod = ?";
	private static final String _storeString = "UPDATE pie_linkprihrash  SET docposprihod = ?, docposrashod = ?, fromstorageprihod = ?, qty = ? WHERE idlinkprihodrashod = ?";
	private static final String _loadString = "SELECT T1.idlinkprihodrashod, T1.docposprihod, T1.docposrashod, T1.fromstorageprihod, T1.qty FROM pie_linkprihrash  T1 WHERE T1.idlinkprihodrashod = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"docposprihod", "docposrashod", "fromstorageprihod", "qty"};
	private static final boolean[] _predicateMaps = {true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIELinkPrihRashBean_8fc12af7
	 */
	public EJSJDBCPersisterCMPPIELinkPrihRashBean_8fc12af7() throws java.rmi.RemoteException {
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
		PIELinkPrihRashBean b = (PIELinkPrihRashBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[4];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idlinkprihodrashod);
			pstmt.setInt(2, b.docposprihod);
			cacheData[0] = new Integer(b.docposprihod);
			pstmt.setInt(3, b.docposrashod);
			cacheData[1] = new Integer(b.docposrashod);
			pstmt.setInt(4, b.fromstorageprihod);
			cacheData[2] = new Integer(b.fromstorageprihod);
			if (b.qty == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.qty);
			}
			cacheData[3] = b.qty;
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
		PIELinkPrihRashBean b = (PIELinkPrihRashBean) eb;
		com.hps.july.persistence.PIELinkPrihRashKey _primaryKey = (com.hps.july.persistence.PIELinkPrihRashKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idlinkprihodrashod = _primaryKey.idlinkprihodrashod;
		b.docposprihod = resultSet.getInt(2);
		b.docposrashod = resultSet.getInt(3);
		b.fromstorageprihod = resultSet.getInt(4);
		b.qty = resultSet.getBigDecimal(5);
		Object[] cacheData = new Object[4];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[3] = resultSet.getBigDecimal(5);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIELinkPrihRashBean b = (PIELinkPrihRashBean) eb;
		com.hps.july.persistence.PIELinkPrihRashKey _primaryKey = (com.hps.july.persistence.PIELinkPrihRashKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idlinkprihodrashod);
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
		PIELinkPrihRashBean b = (PIELinkPrihRashBean) eb;
		com.hps.july.persistence.PIELinkPrihRashKey _primaryKey = new com.hps.july.persistence.PIELinkPrihRashKey();
		_primaryKey.idlinkprihodrashod = b.idlinkprihodrashod;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIELinkPrihRashBean b = (PIELinkPrihRashBean) eb;
		com.hps.july.persistence.PIELinkPrihRashKey _primaryKey = new com.hps.july.persistence.PIELinkPrihRashKey();
		_primaryKey.idlinkprihodrashod = b.idlinkprihodrashod;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(5, _primaryKey.idlinkprihodrashod);
			pstmt.setInt(1, b.docposprihod);
			pstmt.setInt(2, b.docposrashod);
			pstmt.setInt(3, b.fromstorageprihod);
			if (b.qty == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.qty);
			}
			int inputPos = 5;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
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
		PIELinkPrihRashBean b = (PIELinkPrihRashBean) eb;
		com.hps.july.persistence.PIELinkPrihRashKey _primaryKey = new com.hps.july.persistence.PIELinkPrihRashKey();
		_primaryKey.idlinkprihodrashod = b.idlinkprihodrashod;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idlinkprihodrashod);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
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
		com.hps.july.persistence.PIELinkPrihRashKey key = new com.hps.july.persistence.PIELinkPrihRashKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idlinkprihodrashod = resultSet.getInt(1);
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
	 * findByDocposPrihod
	 */
	public EJSFinder findByDocposPrihod(java.lang.Integer argDocpos) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idlinkprihodrashod, T1.docposprihod, T1.docposrashod, T1.fromstorageprihod, T1.qty FROM pie_linkprihrash  T1 WHERE docposprihod = ?");
			pstmt.setObject(1, argDocpos);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByDocposRashod
	 */
	public EJSFinder findByDocposRashod(java.lang.Integer argDocpos) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idlinkprihodrashod, T1.docposprihod, T1.docposrashod, T1.fromstorageprihod, T1.qty FROM pie_linkprihrash  T1 WHERE docposrashod = ?");
			pstmt.setObject(1, argDocpos);
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
	public com.hps.july.persistence.PIELinkPrihRash findByPrimaryKey(com.hps.july.persistence.PIELinkPrihRashKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIELinkPrihRash) home.activateBean(key);
	}
}
