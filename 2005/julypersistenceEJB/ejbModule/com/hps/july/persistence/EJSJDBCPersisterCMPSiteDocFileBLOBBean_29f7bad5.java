package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSiteDocFileBLOBBean_29f7bad5
 */
public class EJSJDBCPersisterCMPSiteDocFileBLOBBean_29f7bad5 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSiteDocFileBLOBBean {
	private static final String _createString = "INSERT INTO sitedocfiles (sitedocfile, sitedocfilebody) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM sitedocfiles  WHERE sitedocfile = ?";
	private static final String _storeString = "UPDATE sitedocfiles  SET sitedocfilebody = ? WHERE sitedocfile = ?";
	private static final String _loadString = "SELECT T1.sitedocfile, T1.sitedocfilebody FROM sitedocfiles  T1 WHERE T1.sitedocfile = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {};
	private static final boolean[] _predicateMaps = {};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSiteDocFileBLOBBean_29f7bad5
	 */
	public EJSJDBCPersisterCMPSiteDocFileBLOBBean_29f7bad5() throws java.rmi.RemoteException {
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
		SiteDocFileBLOBBean b = (SiteDocFileBLOBBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[0];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.sitedocfile);
			objectTemp = com.ibm.vap.converters.streams.VapBinaryStreamToByteArrayConverter.singleton().dataFrom(b.sitedocfilebody);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBinaryStream(2, new java.io.ByteArrayInputStream((byte[])objectTemp), ((byte[])objectTemp).length);
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
		SiteDocFileBLOBBean b = (SiteDocFileBLOBBean) eb;
		com.hps.july.persistence.SiteDocFileBLOBKey _primaryKey = (com.hps.july.persistence.SiteDocFileBLOBKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.sitedocfile = _primaryKey.sitedocfile;
		b.sitedocfilebody = (byte[])com.ibm.vap.converters.streams.VapBinaryStreamToByteArrayConverter.singleton().objectFrom(resultSet.getBinaryStream(2));
		Object[] cacheData = new Object[0];
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SiteDocFileBLOBBean b = (SiteDocFileBLOBBean) eb;
		com.hps.july.persistence.SiteDocFileBLOBKey _primaryKey = (com.hps.july.persistence.SiteDocFileBLOBKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.sitedocfile);
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
		SiteDocFileBLOBBean b = (SiteDocFileBLOBBean) eb;
		com.hps.july.persistence.SiteDocFileBLOBKey _primaryKey = new com.hps.july.persistence.SiteDocFileBLOBKey();
		_primaryKey.sitedocfile = b.sitedocfile;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SiteDocFileBLOBBean b = (SiteDocFileBLOBBean) eb;
		com.hps.july.persistence.SiteDocFileBLOBKey _primaryKey = new com.hps.july.persistence.SiteDocFileBLOBKey();
		_primaryKey.sitedocfile = b.sitedocfile;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(2, _primaryKey.sitedocfile);
			objectTemp = com.ibm.vap.converters.streams.VapBinaryStreamToByteArrayConverter.singleton().dataFrom(b.sitedocfilebody);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBinaryStream(1, new java.io.ByteArrayInputStream((byte[])objectTemp), ((byte[])objectTemp).length);
			}
			int inputPos = 2;
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
		SiteDocFileBLOBBean b = (SiteDocFileBLOBBean) eb;
		com.hps.july.persistence.SiteDocFileBLOBKey _primaryKey = new com.hps.july.persistence.SiteDocFileBLOBKey();
		_primaryKey.sitedocfile = b.sitedocfile;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.sitedocfile);
			int inputPos = 1;
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
		com.hps.july.persistence.SiteDocFileBLOBKey key = new com.hps.july.persistence.SiteDocFileBLOBKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.sitedocfile = resultSet.getInt(1);
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
	public com.hps.july.persistence.SiteDocFileBLOB findByPrimaryKey(com.hps.july.persistence.SiteDocFileBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.SiteDocFileBLOB) home.activateBean(key);
	}
}
