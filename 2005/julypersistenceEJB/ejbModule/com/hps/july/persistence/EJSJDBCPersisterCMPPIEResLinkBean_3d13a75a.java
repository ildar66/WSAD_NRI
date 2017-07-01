package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEResLinkBean_3d13a75a
 */
public class EJSJDBCPersisterCMPPIEResLinkBean_3d13a75a extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEResLinkBean {
	private static final String _createString = "INSERT INTO pie_reslink (idresnri, idresplatinum, owner, voper, vdat, flagMainLink) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_reslink  WHERE idresnri = ? AND idresplatinum = ? AND owner = ?";
	private static final String _storeString = "UPDATE pie_reslink  SET voper = ?, vdat = ?, flagMainLink = ? WHERE idresnri = ? AND idresplatinum = ? AND owner = ?";
	private static final String _loadString = "SELECT T1.voper, T1.idresnri, T1.vdat, T1.flagMainLink, T1.idresplatinum, T1.owner FROM pie_reslink  T1 WHERE T1.idresnri = ? AND T1.idresplatinum = ? AND T1.owner = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"voper", "vdat", "flagMainLink"};
	private static final boolean[] _predicateMaps = {true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEResLinkBean_3d13a75a
	 */
	public EJSJDBCPersisterCMPPIEResLinkBean_3d13a75a() throws java.rmi.RemoteException {
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
		PIEResLinkBean b = (PIEResLinkBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[3];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.voper == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.voper.intValue());
			}
			cacheData[0] = b.voper;
			pstmt.setInt(1, b.idresnri);
			if (b.vdat == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.vdat);
			}
			cacheData[1] = b.vdat;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.flagMainLink);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.resplatinum_idresplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.resplatinum_owner == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.resplatinum_owner.intValue());
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
		PIEResLinkBean b = (PIEResLinkBean) eb;
		com.hps.july.persistence.PIEResLinkKey _primaryKey = (com.hps.july.persistence.PIEResLinkKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idresnri = _primaryKey.idresnri;
		b.resplatinum_idresplatinum = _primaryKey.resplatinum_idresplatinum;
		b.resplatinum_owner = _primaryKey.resplatinum_owner;
		tempint = resultSet.getInt(1);
		b.voper = resultSet.wasNull() ? null : new Integer(tempint);
		b.vdat = resultSet.getTimestamp(3);
		b.flagMainLink = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		b.resplatinum_idresplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		tempint = resultSet.getInt(6);
		b.resplatinum_owner = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[3];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getTimestamp(3);
		cacheData[2] = resultSet.getString(4);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEResLinkBean b = (PIEResLinkBean) eb;
		com.hps.july.persistence.PIEResLinkKey _primaryKey = (com.hps.july.persistence.PIEResLinkKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idresnri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.resplatinum_idresplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (_primaryKey.resplatinum_owner == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.resplatinum_owner.intValue());
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
		PIEResLinkBean b = (PIEResLinkBean) eb;
		com.hps.july.persistence.PIEResLinkKey _primaryKey = new com.hps.july.persistence.PIEResLinkKey();
		_primaryKey.idresnri = b.idresnri;
		_primaryKey.resplatinum_idresplatinum = b.resplatinum_idresplatinum;
		_primaryKey.resplatinum_owner = b.resplatinum_owner;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEResLinkBean b = (PIEResLinkBean) eb;
		com.hps.july.persistence.PIEResLinkKey _primaryKey = new com.hps.july.persistence.PIEResLinkKey();
		_primaryKey.idresnri = b.idresnri;
		_primaryKey.resplatinum_idresplatinum = b.resplatinum_idresplatinum;
		_primaryKey.resplatinum_owner = b.resplatinum_owner;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(4, _primaryKey.idresnri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.resplatinum_idresplatinum);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (_primaryKey.resplatinum_owner == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, _primaryKey.resplatinum_owner.intValue());
			}
			if (b.voper == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.voper.intValue());
			}
			if (b.vdat == null) {
				pstmt.setNull(2, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(2, b.vdat);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.flagMainLink);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.resplatinum_idresplatinum);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.resplatinum_owner == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.resplatinum_owner.intValue());
			}
			int inputPos = 6;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
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
		PIEResLinkBean b = (PIEResLinkBean) eb;
		com.hps.july.persistence.PIEResLinkKey _primaryKey = new com.hps.july.persistence.PIEResLinkKey();
		_primaryKey.idresnri = b.idresnri;
		_primaryKey.resplatinum_idresplatinum = b.resplatinum_idresplatinum;
		_primaryKey.resplatinum_owner = b.resplatinum_owner;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idresnri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.resplatinum_idresplatinum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (_primaryKey.resplatinum_owner == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.resplatinum_owner.intValue());
			}
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
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
		com.hps.july.persistence.PIEResLinkKey key = new com.hps.july.persistence.PIEResLinkKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.idresnri = resultSet.getInt(2);
			key.resplatinum_idresplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
			tempint = resultSet.getInt(6);
			key.resplatinum_owner = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findByIdresnriAndOwner
	 */
	public EJSFinder findByIdresnriAndOwner(java.lang.Integer argIdresNri, java.lang.Integer argOwner) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.voper, T1.idresnri, T1.vdat, T1.flagMainLink, T1.idresplatinum, T1.owner FROM pie_reslink  T1 WHERE idresnri=? AND owner=?");
			pstmt.setObject(1, argIdresNri);
			pstmt.setObject(2, argOwner);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findPIEResLinksByResplatinum
	 */
	public EJSFinder findPIEResLinksByResplatinum(com.hps.july.persistence.PIEResPlatinumKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.voper, T1.idresnri, T1.vdat, T1.flagMainLink, T1.idresplatinum, T1.owner FROM pie_reslink  T1 WHERE T1.idresplatinum = ? AND T1.owner = ?");
			Object objectTemp = null;
boolean nullData;
			nullData = true;   // assuming <parm> == null
			if ( inKey != null) {
				objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(inKey.idresplatinum);
				nullData = (objectTemp == null);
			}
			if (nullData) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			pstmt.setInt(2, inKey.owner);
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
	public com.hps.july.persistence.PIEResLink findByPrimaryKey(com.hps.july.persistence.PIEResLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEResLink) home.activateBean(key);
	}
}
