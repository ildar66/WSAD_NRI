package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEDopInfoContrBean_1d890592
 */
public class EJSJDBCPersisterCMPPIEDopInfoContrBean_1d890592 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEDopInfoContrBean {
	private static final String _createString = "INSERT INTO pie_dopinfocontr (leasedocument, idbudjet, idexpense, vendor, datenritoplatinum, dateplatinum, flagsync) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_dopinfocontr  WHERE leasedocument = ?";
	private static final String _storeString = "UPDATE pie_dopinfocontr  SET idbudjet = ?, idexpense = ?, vendor = ?, datenritoplatinum = ?, dateplatinum = ?, flagsync = ? WHERE leasedocument = ?";
	private static final String _loadString = "SELECT T1.idbudjet, T1.idexpense, T1.vendor, T1.leasedocument, T1.datenritoplatinum, T1.dateplatinum, T1.flagsync FROM pie_dopinfocontr  T1 WHERE T1.leasedocument = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"idbudjet", "idexpense", "vendor", "datenritoplatinum", "dateplatinum", "flagsync"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEDopInfoContrBean_1d890592
	 */
	public EJSJDBCPersisterCMPPIEDopInfoContrBean_1d890592() throws java.rmi.RemoteException {
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
		PIEDopInfoContrBean b = (PIEDopInfoContrBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[6];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.idbudjet == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.idbudjet.intValue());
			}
			cacheData[0] = b.idbudjet;
			if (b.idexpense == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.idexpense.intValue());
			}
			cacheData[1] = b.idexpense;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.vendor);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			pstmt.setInt(1, b.leasedocument);
			if (b.datenritoplatinum == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.datenritoplatinum);
			}
			cacheData[3] = b.datenritoplatinum;
			if (b.dateplatinum == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.dateplatinum);
			}
			cacheData[4] = b.dateplatinum;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.flagsync);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
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
		PIEDopInfoContrBean b = (PIEDopInfoContrBean) eb;
		com.hps.july.persistence.PIEDopInfoContrKey _primaryKey = (com.hps.july.persistence.PIEDopInfoContrKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leasedocument = _primaryKey.leasedocument;
		tempint = resultSet.getInt(1);
		b.idbudjet = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.idexpense = resultSet.wasNull() ? null : new Integer(tempint);
		b.vendor = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.datenritoplatinum = resultSet.getTimestamp(5);
		b.dateplatinum = resultSet.getTimestamp(6);
		b.flagsync = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		Object[] cacheData = new Object[6];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[2] = resultSet.getString(3);
		cacheData[3] = resultSet.getTimestamp(5);
		cacheData[4] = resultSet.getTimestamp(6);
		cacheData[5] = resultSet.getString(7);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEDopInfoContrBean b = (PIEDopInfoContrBean) eb;
		com.hps.july.persistence.PIEDopInfoContrKey _primaryKey = (com.hps.july.persistence.PIEDopInfoContrKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leasedocument);
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
		PIEDopInfoContrBean b = (PIEDopInfoContrBean) eb;
		com.hps.july.persistence.PIEDopInfoContrKey _primaryKey = new com.hps.july.persistence.PIEDopInfoContrKey();
		_primaryKey.leasedocument = b.leasedocument;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEDopInfoContrBean b = (PIEDopInfoContrBean) eb;
		com.hps.july.persistence.PIEDopInfoContrKey _primaryKey = new com.hps.july.persistence.PIEDopInfoContrKey();
		_primaryKey.leasedocument = b.leasedocument;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(7, _primaryKey.leasedocument);
			if (b.idbudjet == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.idbudjet.intValue());
			}
			if (b.idexpense == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.idexpense.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.vendor);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.datenritoplatinum == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.datenritoplatinum);
			}
			if (b.dateplatinum == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.dateplatinum);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.flagsync);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			int inputPos = 7;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
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
		PIEDopInfoContrBean b = (PIEDopInfoContrBean) eb;
		com.hps.july.persistence.PIEDopInfoContrKey _primaryKey = new com.hps.july.persistence.PIEDopInfoContrKey();
		_primaryKey.leasedocument = b.leasedocument;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.leasedocument);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
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
		com.hps.july.persistence.PIEDopInfoContrKey key = new com.hps.july.persistence.PIEDopInfoContrKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leasedocument = resultSet.getInt(4);
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
	public com.hps.july.persistence.PIEDopInfoContr findByPrimaryKey(com.hps.july.persistence.PIEDopInfoContrKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEDopInfoContr) home.activateBean(key);
	}
}
