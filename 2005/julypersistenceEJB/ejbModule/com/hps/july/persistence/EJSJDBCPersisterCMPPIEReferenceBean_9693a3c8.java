package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEReferenceBean_9693a3c8
 */
public class EJSJDBCPersisterCMPPIEReferenceBean_9693a3c8 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEReferenceBean {
	private static final String _createString = "INSERT INTO pie_reference (idreference, idplatinum, name, owner, p_status, sprav) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_reference  WHERE idreference = ?";
	private static final String _storeString = "UPDATE pie_reference  SET idplatinum = ?, name = ?, owner = ?, p_status = ?, sprav = ? WHERE idreference = ?";
	private static final String _loadString = "SELECT T1.idreference, T1.idplatinum, T1.name, T1.owner, T1.p_status, T1.sprav FROM pie_reference  T1 WHERE T1.idreference = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"idplatinum", "name", "owner", "p_status", "sprav"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEReferenceBean_9693a3c8
	 */
	public EJSJDBCPersisterCMPPIEReferenceBean_9693a3c8() throws java.rmi.RemoteException {
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
		PIEReferenceBean b = (PIEReferenceBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[5];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idreference);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.idplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			if (b.name == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.name);
			}
			cacheData[1] = b.name;
			pstmt.setInt(4, b.owner);
			cacheData[2] = new Integer(b.owner);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pstatus);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sprav);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[4] = objectTemp;
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
		PIEReferenceBean b = (PIEReferenceBean) eb;
		com.hps.july.persistence.PIEReferenceKey _primaryKey = (com.hps.july.persistence.PIEReferenceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idreference = _primaryKey.idreference;
		b.idplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.name = resultSet.getString(3);
		b.owner = resultSet.getInt(4);
		b.pstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.sprav = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		Object[] cacheData = new Object[5];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		tempint = resultSet.getInt(4);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[3] = resultSet.getString(5);
		cacheData[4] = resultSet.getString(6);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEReferenceBean b = (PIEReferenceBean) eb;
		com.hps.july.persistence.PIEReferenceKey _primaryKey = (com.hps.july.persistence.PIEReferenceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idreference);
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
		PIEReferenceBean b = (PIEReferenceBean) eb;
		com.hps.july.persistence.PIEReferenceKey _primaryKey = new com.hps.july.persistence.PIEReferenceKey();
		_primaryKey.idreference = b.idreference;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEReferenceBean b = (PIEReferenceBean) eb;
		com.hps.july.persistence.PIEReferenceKey _primaryKey = new com.hps.july.persistence.PIEReferenceKey();
		_primaryKey.idreference = b.idreference;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(6, _primaryKey.idreference);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.idplatinum);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.name == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.name);
			}
			pstmt.setInt(3, b.owner);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.pstatus);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sprav);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			int inputPos = 6;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
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
		PIEReferenceBean b = (PIEReferenceBean) eb;
		com.hps.july.persistence.PIEReferenceKey _primaryKey = new com.hps.july.persistence.PIEReferenceKey();
		_primaryKey.idreference = b.idreference;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idreference);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
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
		com.hps.july.persistence.PIEReferenceKey key = new com.hps.july.persistence.PIEReferenceKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idreference = resultSet.getInt(1);
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
	public com.hps.july.persistence.PIEReference findByPrimaryKey(com.hps.july.persistence.PIEReferenceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEReference) home.activateBean(key);
	}
	/**
	 * findBySpravOrderByCodeAsc
	 */
	public EJSFinder findBySpravOrderByCodeAsc(java.lang.String argSprav) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idreference, T1.idplatinum, T1.name, T1.owner, T1.p_status, T1.sprav FROM pie_reference  T1 WHERE sprav = ? ORDER BY idreference ASC");
			if (argSprav == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argSprav);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByOwnerAndSpravOrderByNameAsc
	 */
	public EJSFinder findByOwnerAndSpravOrderByNameAsc(java.lang.Integer argOwner, java.lang.String argSprav) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idreference, T1.idplatinum, T1.name, T1.owner, T1.p_status, T1.sprav FROM pie_reference  T1 WHERE owner=? AND sprav = ? ORDER BY name ASC");
			pstmt.setObject(1, argOwner);
			if (argSprav == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argSprav);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
