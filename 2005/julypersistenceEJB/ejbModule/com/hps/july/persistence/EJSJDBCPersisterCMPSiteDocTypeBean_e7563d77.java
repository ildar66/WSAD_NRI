package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSiteDocTypeBean_e7563d77
 */
public class EJSJDBCPersisterCMPSiteDocTypeBean_e7563d77 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSiteDocTypeBean {
	private static final String _createString = "INSERT INTO sitedoctypes (sitedoctype, sitedoctypename, sitedoctypetxt) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM sitedoctypes  WHERE sitedoctype = ?";
	private static final String _storeString = "UPDATE sitedoctypes  SET sitedoctypename = ?, sitedoctypetxt = ? WHERE sitedoctype = ?";
	private static final String _loadString = "SELECT T1.sitedoctype, T1.sitedoctypename, T1.sitedoctypetxt FROM sitedoctypes  T1 WHERE T1.sitedoctype = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"sitedoctypename"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSiteDocTypeBean_e7563d77
	 */
	public EJSJDBCPersisterCMPSiteDocTypeBean_e7563d77() throws java.rmi.RemoteException {
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
		SiteDocTypeBean b = (SiteDocTypeBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.sitedoctype);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sitedoctypename);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.sitedoctypetxt);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(3, (byte[])objectTemp);
			}
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
		SiteDocTypeBean b = (SiteDocTypeBean) eb;
		com.hps.july.persistence.SiteDocTypeKey _primaryKey = (com.hps.july.persistence.SiteDocTypeKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.sitedoctype = _primaryKey.sitedoctype;
		b.sitedoctypename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.sitedoctypetxt = (java.lang.String)com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().objectFrom(resultSet.getBinaryStream(3));
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getString(2);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SiteDocTypeBean b = (SiteDocTypeBean) eb;
		com.hps.july.persistence.SiteDocTypeKey _primaryKey = (com.hps.july.persistence.SiteDocTypeKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.sitedoctype);
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
		SiteDocTypeBean b = (SiteDocTypeBean) eb;
		com.hps.july.persistence.SiteDocTypeKey _primaryKey = new com.hps.july.persistence.SiteDocTypeKey();
		_primaryKey.sitedoctype = b.sitedoctype;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SiteDocTypeBean b = (SiteDocTypeBean) eb;
		com.hps.july.persistence.SiteDocTypeKey _primaryKey = new com.hps.july.persistence.SiteDocTypeKey();
		_primaryKey.sitedoctype = b.sitedoctype;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(3, _primaryKey.sitedoctype);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sitedoctypename);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.sitedoctypetxt);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(2, (byte[])objectTemp);
			}
			int inputPos = 3;
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
		SiteDocTypeBean b = (SiteDocTypeBean) eb;
		com.hps.july.persistence.SiteDocTypeKey _primaryKey = new com.hps.july.persistence.SiteDocTypeKey();
		_primaryKey.sitedoctype = b.sitedoctype;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.sitedoctype);
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
		com.hps.july.persistence.SiteDocTypeKey key = new com.hps.july.persistence.SiteDocTypeKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.sitedoctype = resultSet.getInt(1);
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
	public com.hps.july.persistence.SiteDocType findByPrimaryKey(com.hps.july.persistence.SiteDocTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.SiteDocType) home.activateBean(key);
	}
	/**
	 * findAll
	 */
	public EJSFinder findAll() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedoctype, T1.sitedoctypename, T1.sitedoctypetxt FROM sitedoctypes  T1 WHERE 1=1");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
