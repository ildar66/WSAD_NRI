package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPEtapDocBean_273da4f8
 */
public class EJSJDBCPersisterCMPEtapDocBean_273da4f8 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderEtapDocBean {
	private static final String _createString = "INSERT INTO etapdocs (sitedoc, etaptypeid, freqpermid, equiplink, havepay) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM etapdocs  WHERE sitedoc = ?";
	private static final String _storeString = "UPDATE etapdocs  SET etaptypeid = ?, freqpermid = ?, equiplink = ?, havepay = ? WHERE sitedoc = ?";
	private static final String _loadString = "SELECT T1.etaptypeid, T1.freqpermid, T1.sitedoc, T1.equiplink, T1.havepay FROM etapdocs  T1 WHERE T1.sitedoc = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"etaptypeid", "freqpermid", "equiplink", "havepay"};
	private static final boolean[] _predicateMaps = {true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPEtapDocBean_273da4f8
	 */
	public EJSJDBCPersisterCMPEtapDocBean_273da4f8() throws java.rmi.RemoteException {
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
		EtapDocBean b = (EtapDocBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[4];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(2, b.etaptypeid);
			cacheData[0] = new Integer(b.etaptypeid);
			pstmt.setInt(3, b.freqpermid);
			cacheData[1] = new Integer(b.freqpermid);
			pstmt.setInt(1, b.sitedoc);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equiplink);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.havepay);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
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
		EtapDocBean b = (EtapDocBean) eb;
		com.hps.july.persistence2.EtapDocKey _primaryKey = (com.hps.july.persistence2.EtapDocKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.sitedoc = _primaryKey.sitedoc;
		b.etaptypeid = resultSet.getInt(1);
		b.freqpermid = resultSet.getInt(2);
		b.equiplink = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.havepay = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(5));
		Object[] cacheData = new Object[4];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[2] = resultSet.getString(4);
		cacheData[3] = resultSet.getString(5);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		EtapDocBean b = (EtapDocBean) eb;
		com.hps.july.persistence2.EtapDocKey _primaryKey = (com.hps.july.persistence2.EtapDocKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.sitedoc);
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
		EtapDocBean b = (EtapDocBean) eb;
		com.hps.july.persistence2.EtapDocKey _primaryKey = new com.hps.july.persistence2.EtapDocKey();
		_primaryKey.sitedoc = b.sitedoc;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		EtapDocBean b = (EtapDocBean) eb;
		com.hps.july.persistence2.EtapDocKey _primaryKey = new com.hps.july.persistence2.EtapDocKey();
		_primaryKey.sitedoc = b.sitedoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(5, _primaryKey.sitedoc);
			pstmt.setInt(1, b.etaptypeid);
			pstmt.setInt(2, b.freqpermid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.equiplink);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.havepay);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			int inputPos = 5;
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
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
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
		EtapDocBean b = (EtapDocBean) eb;
		com.hps.july.persistence2.EtapDocKey _primaryKey = new com.hps.july.persistence2.EtapDocKey();
		_primaryKey.sitedoc = b.sitedoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.sitedoc);
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
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
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
		com.hps.july.persistence2.EtapDocKey key = new com.hps.july.persistence2.EtapDocKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.sitedoc = resultSet.getInt(3);
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
	public com.hps.july.persistence2.EtapDoc findByPrimaryKey(com.hps.july.persistence2.EtapDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.EtapDoc) home.activateBean(key);
	}
}
