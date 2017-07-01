package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCableWorkParamsBean_80ac4c0f
 */
public class EJSJDBCPersisterCMPCableWorkParamsBean_80ac4c0f extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderCableWorkParamsBean {
	private static final String _createString = "INSERT INTO cableworkparams (band, id_anten, id_cable, ksvn) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM cableworkparams  WHERE band = ? AND id_anten = ? AND id_cable = ?";
	private static final String _storeString = "UPDATE cableworkparams  SET ksvn = ? WHERE band = ? AND id_anten = ? AND id_cable = ?";
	private static final String _loadString = "SELECT T1.band, T1.id_anten, T1.id_cable, T1.ksvn FROM cableworkparams  T1 WHERE T1.band = ? AND T1.id_anten = ? AND T1.id_cable = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"ksvn"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCableWorkParamsBean_80ac4c0f
	 */
	public EJSJDBCPersisterCMPCableWorkParamsBean_80ac4c0f() throws java.rmi.RemoteException {
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
		CableWorkParamsBean b = (CableWorkParamsBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setShort(1, b.band);
			pstmt.setInt(2, b.id_anten);
			pstmt.setInt(3, b.id_cable);
			if (b.ksvn == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.ksvn);
			}
			cacheData[0] = b.ksvn;
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
		CableWorkParamsBean b = (CableWorkParamsBean) eb;
		com.hps.july.persistence2.CableWorkParamsKey _primaryKey = (com.hps.july.persistence2.CableWorkParamsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.band = _primaryKey.band;
		b.id_anten = _primaryKey.id_anten;
		b.id_cable = _primaryKey.id_cable;
		b.ksvn = resultSet.getBigDecimal(4);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getBigDecimal(4);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CableWorkParamsBean b = (CableWorkParamsBean) eb;
		com.hps.july.persistence2.CableWorkParamsKey _primaryKey = (com.hps.july.persistence2.CableWorkParamsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setShort(1, _primaryKey.band);
			pstmt.setInt(2, _primaryKey.id_anten);
			pstmt.setInt(3, _primaryKey.id_cable);
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
		CableWorkParamsBean b = (CableWorkParamsBean) eb;
		com.hps.july.persistence2.CableWorkParamsKey _primaryKey = new com.hps.july.persistence2.CableWorkParamsKey();
		_primaryKey.band = b.band;
		_primaryKey.id_anten = b.id_anten;
		_primaryKey.id_cable = b.id_cable;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CableWorkParamsBean b = (CableWorkParamsBean) eb;
		com.hps.july.persistence2.CableWorkParamsKey _primaryKey = new com.hps.july.persistence2.CableWorkParamsKey();
		_primaryKey.band = b.band;
		_primaryKey.id_anten = b.id_anten;
		_primaryKey.id_cable = b.id_cable;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setShort(2, _primaryKey.band);
			pstmt.setInt(3, _primaryKey.id_anten);
			pstmt.setInt(4, _primaryKey.id_cable);
			if (b.ksvn == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.ksvn);
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
		CableWorkParamsBean b = (CableWorkParamsBean) eb;
		com.hps.july.persistence2.CableWorkParamsKey _primaryKey = new com.hps.july.persistence2.CableWorkParamsKey();
		_primaryKey.band = b.band;
		_primaryKey.id_anten = b.id_anten;
		_primaryKey.id_cable = b.id_cable;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setShort(1, _primaryKey.band);
			pstmt.setInt(2, _primaryKey.id_anten);
			pstmt.setInt(3, _primaryKey.id_cable);
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
		com.hps.july.persistence2.CableWorkParamsKey key = new com.hps.july.persistence2.CableWorkParamsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.band = resultSet.getShort(1);
			key.id_anten = resultSet.getInt(2);
			key.id_cable = resultSet.getInt(3);
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
	 * findByCable
	 */
	public EJSFinder findByCable(java.lang.Integer argCableId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.band, T1.id_anten, T1.id_cable, T1.ksvn FROM cableworkparams  T1 WHERE id_cable = ?");
			pstmt.setObject(1, argCableId);
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
	public com.hps.july.persistence2.CableWorkParams findByPrimaryKey(com.hps.july.persistence2.CableWorkParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.CableWorkParams) home.activateBean(key);
	}
}
