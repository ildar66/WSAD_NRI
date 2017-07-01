package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEMxranLinkBean_8e0472a7
 */
public class EJSJDBCPersisterCMPPIEMxranLinkBean_8e0472a7 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEMxranLinkBean {
	private static final String _createString = "INSERT INTO pie_mxranlink (mxrannri, mxranplatinum, owner) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_mxranlink  WHERE mxrannri = ? AND mxranplatinum = ? AND owner = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.mxrannri, T1.mxranplatinum, T1.owner FROM pie_mxranlink  T1 WHERE T1.mxrannri = ? AND T1.mxranplatinum = ? AND T1.owner = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEMxranLinkBean_8e0472a7
	 */
	public EJSJDBCPersisterCMPPIEMxranLinkBean_8e0472a7() throws java.rmi.RemoteException {
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
		PIEMxranLinkBean b = (PIEMxranLinkBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[0];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.mxrannri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.mxranplatinum_mxranplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.mxranplatinum_owner_organization == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.mxranplatinum_owner_organization.intValue());
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
		PIEMxranLinkBean b = (PIEMxranLinkBean) eb;
		com.hps.july.persistence.PIEMxranLinkKey _primaryKey = (com.hps.july.persistence.PIEMxranLinkKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.mxrannri = _primaryKey.mxrannri;
		b.mxranplatinum_mxranplatinum = _primaryKey.mxranplatinum_mxranplatinum;
		b.mxranplatinum_owner_organization = _primaryKey.mxranplatinum_owner_organization;
		b.mxranplatinum_mxranplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		tempint = resultSet.getInt(3);
		b.mxranplatinum_owner_organization = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[0];
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEMxranLinkBean b = (PIEMxranLinkBean) eb;
		com.hps.july.persistence.PIEMxranLinkKey _primaryKey = (com.hps.july.persistence.PIEMxranLinkKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.mxrannri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.mxranplatinum_mxranplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (_primaryKey.mxranplatinum_owner_organization == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.mxranplatinum_owner_organization.intValue());
			}
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
		PIEMxranLinkBean b = (PIEMxranLinkBean) eb;
		com.hps.july.persistence.PIEMxranLinkKey _primaryKey = new com.hps.july.persistence.PIEMxranLinkKey();
		_primaryKey.mxrannri = b.mxrannri;
		_primaryKey.mxranplatinum_mxranplatinum = b.mxranplatinum_mxranplatinum;
		_primaryKey.mxranplatinum_owner_organization = b.mxranplatinum_owner_organization;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		return;
	}
	/**
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEMxranLinkBean b = (PIEMxranLinkBean) eb;
		com.hps.july.persistence.PIEMxranLinkKey _primaryKey = new com.hps.july.persistence.PIEMxranLinkKey();
		_primaryKey.mxrannri = b.mxrannri;
		_primaryKey.mxranplatinum_mxranplatinum = b.mxranplatinum_mxranplatinum;
		_primaryKey.mxranplatinum_owner_organization = b.mxranplatinum_owner_organization;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.mxrannri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.mxranplatinum_mxranplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (_primaryKey.mxranplatinum_owner_organization == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.mxranplatinum_owner_organization.intValue());
			}
			int inputPos = 3;
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
		com.hps.july.persistence.PIEMxranLinkKey key = new com.hps.july.persistence.PIEMxranLinkKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.mxrannri = resultSet.getInt(1);
			key.mxranplatinum_mxranplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
			tempint = resultSet.getInt(3);
			key.mxranplatinum_owner_organization = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findPIEMxranLinksByMxranplatinum
	 */
	public EJSFinder findPIEMxranLinksByMxranplatinum(com.hps.july.persistence.PIEMxranPlatinumKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mxrannri, T1.mxranplatinum, T1.owner FROM pie_mxranlink  T1 WHERE T1.mxranplatinum = ? AND T1.owner = ?");
			Object objectTemp = null;
boolean nullData;
			nullData = true;   // assuming <parm> == null
			if ( inKey != null) {
				objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(inKey.mxranplatinum);
				nullData = (objectTemp == null);
			}
			if (nullData) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (inKey.owner_organization == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, inKey.owner_organization.intValue());
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
	public com.hps.july.persistence.PIEMxranLink findByPrimaryKey(com.hps.july.persistence.PIEMxranLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEMxranLink) home.activateBean(key);
	}
	/**
	 * findByMxrannriOwner
	 */
	public EJSFinder findByMxrannriOwner(java.lang.Integer mxrannri, java.lang.Integer owner) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mxrannri, T1.mxranplatinum, T1.owner FROM pie_mxranlink  T1 WHERE mxrannri = ? AND owner = ?");
			pstmt.setObject(1, mxrannri);
			pstmt.setObject(2, owner);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
