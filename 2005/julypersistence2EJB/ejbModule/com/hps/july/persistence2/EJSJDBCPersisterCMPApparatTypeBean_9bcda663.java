package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPApparatTypeBean_9bcda663
 */
public class EJSJDBCPersisterCMPApparatTypeBean_9bcda663 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderApparatTypeBean {
	private static final String _createString = "INSERT INTO apparattypes (aptypeid, aptype, name) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM apparattypes  WHERE aptypeid = ?";
	private static final String _storeString = "UPDATE apparattypes  SET aptype = ?, name = ? WHERE aptypeid = ?";
	private static final String _loadString = "SELECT T1.aptypeid, T1.aptype, T1.name FROM apparattypes  T1 WHERE T1.aptypeid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"aptype", "name"};
	private static final boolean[] _predicateMaps = {true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPApparatTypeBean_9bcda663
	 */
	public EJSJDBCPersisterCMPApparatTypeBean_9bcda663() throws java.rmi.RemoteException {
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
		ApparatTypeBean b = (ApparatTypeBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[2];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.aptypeid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.aptype);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
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
		ApparatTypeBean b = (ApparatTypeBean) eb;
		com.hps.july.persistence2.ApparatTypeKey _primaryKey = (com.hps.july.persistence2.ApparatTypeKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.aptypeid = _primaryKey.aptypeid;
		b.aptype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		Object[] cacheData = new Object[2];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ApparatTypeBean b = (ApparatTypeBean) eb;
		com.hps.july.persistence2.ApparatTypeKey _primaryKey = (com.hps.july.persistence2.ApparatTypeKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.aptypeid);
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
		ApparatTypeBean b = (ApparatTypeBean) eb;
		com.hps.july.persistence2.ApparatTypeKey _primaryKey = new com.hps.july.persistence2.ApparatTypeKey();
		_primaryKey.aptypeid = b.aptypeid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ApparatTypeBean b = (ApparatTypeBean) eb;
		com.hps.july.persistence2.ApparatTypeKey _primaryKey = new com.hps.july.persistence2.ApparatTypeKey();
		_primaryKey.aptypeid = b.aptypeid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(3, _primaryKey.aptypeid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.aptype);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
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
		ApparatTypeBean b = (ApparatTypeBean) eb;
		com.hps.july.persistence2.ApparatTypeKey _primaryKey = new com.hps.july.persistence2.ApparatTypeKey();
		_primaryKey.aptypeid = b.aptypeid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.aptypeid);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
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
		com.hps.july.persistence2.ApparatTypeKey key = new com.hps.july.persistence2.ApparatTypeKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.aptypeid = resultSet.getInt(1);
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
	public com.hps.july.persistence2.ApparatType findByPrimaryKey(com.hps.july.persistence2.ApparatTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.ApparatType) home.activateBean(key);
	}
}
