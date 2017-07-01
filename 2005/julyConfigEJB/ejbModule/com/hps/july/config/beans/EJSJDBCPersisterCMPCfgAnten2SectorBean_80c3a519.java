package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgAnten2SectorBean_80c3a519
 */
public class EJSJDBCPersisterCMPCfgAnten2SectorBean_80c3a519 extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgAnten2SectorBean {
	private static final String _createString = "INSERT INTO informix.cfganten2sectors (SAVCONFIGID, ID_ANTEN, ID_SECT, DATASOURCE, OBJECTSTATUS) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfganten2sectors  WHERE SAVCONFIGID = ? AND ID_ANTEN = ? AND ID_SECT = ?";
	private static final String _storeString = "UPDATE informix.cfganten2sectors  SET DATASOURCE = ?, OBJECTSTATUS = ? WHERE SAVCONFIGID = ? AND ID_ANTEN = ? AND ID_SECT = ?";
	private static final String _loadString = "SELECT T1.SAVCONFIGID, T1.ID_ANTEN, T1.ID_SECT, T1.DATASOURCE, T1.OBJECTSTATUS FROM informix.cfganten2sectors  T1 WHERE T1.SAVCONFIGID = ? AND T1.ID_ANTEN = ? AND T1.ID_SECT = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"DATASOURCE", "OBJECTSTATUS"};
	private static final boolean[] _predicateMaps = {true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgAnten2SectorBean_80c3a519
	 */
	public EJSJDBCPersisterCMPCfgAnten2SectorBean_80c3a519() throws java.rmi.RemoteException {
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
		CfgAnten2SectorBean b = (CfgAnten2SectorBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[2];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.id_anten);
			pstmt.setInt(3, b.id_sect);
			if (b.datasource == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.datasource.intValue());
			}
			cacheData[0] = b.datasource;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
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
		CfgAnten2SectorBean b = (CfgAnten2SectorBean) eb;
		com.hps.july.config.beans.CfgAnten2SectorKey _primaryKey = (com.hps.july.config.beans.CfgAnten2SectorKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.savconfigid = _primaryKey.savconfigid;
		b.id_anten = _primaryKey.id_anten;
		b.id_sect = _primaryKey.id_sect;
		tempint = resultSet.getInt(4);
		b.datasource = resultSet.wasNull() ? null : new Integer(tempint);
		b.ObjectStatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		Object[] cacheData = new Object[2];
		tempint = resultSet.getInt(4);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getString(5);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgAnten2SectorBean b = (CfgAnten2SectorBean) eb;
		com.hps.july.config.beans.CfgAnten2SectorKey _primaryKey = (com.hps.july.config.beans.CfgAnten2SectorKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.id_anten);
			pstmt.setInt(3, _primaryKey.id_sect);
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
		CfgAnten2SectorBean b = (CfgAnten2SectorBean) eb;
		com.hps.july.config.beans.CfgAnten2SectorKey _primaryKey = new com.hps.july.config.beans.CfgAnten2SectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_anten = b.id_anten;
		_primaryKey.id_sect = b.id_sect;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgAnten2SectorBean b = (CfgAnten2SectorBean) eb;
		com.hps.july.config.beans.CfgAnten2SectorKey _primaryKey = new com.hps.july.config.beans.CfgAnten2SectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_anten = b.id_anten;
		_primaryKey.id_sect = b.id_sect;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(3, _primaryKey.savconfigid);
			pstmt.setInt(4, _primaryKey.id_anten);
			pstmt.setInt(5, _primaryKey.id_sect);
			if (b.datasource == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.datasource.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			int inputPos = 5;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		CfgAnten2SectorBean b = (CfgAnten2SectorBean) eb;
		com.hps.july.config.beans.CfgAnten2SectorKey _primaryKey = new com.hps.july.config.beans.CfgAnten2SectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_anten = b.id_anten;
		_primaryKey.id_sect = b.id_sect;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.id_anten);
			pstmt.setInt(3, _primaryKey.id_sect);
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		com.hps.july.config.beans.CfgAnten2SectorKey key = new com.hps.july.config.beans.CfgAnten2SectorKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.id_anten = resultSet.getInt(2);
			key.id_sect = resultSet.getInt(3);
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
	public com.hps.july.config.beans.CfgAnten2Sector findByPrimaryKey(com.hps.july.config.beans.CfgAnten2SectorKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgAnten2Sector) home.activateBean(primaryKey);
	}
}
