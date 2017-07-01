package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgTrx2SectorBean_d03b763f
 */
public class EJSJDBCPersisterCMPCfgTrx2SectorBean_d03b763f extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgTrx2SectorBean {
	private static final String _createString = "INSERT INTO informix.cfgtrx2sectors (savconfigid, trxid, id_sect, objectstatus) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfgtrx2sectors  WHERE savconfigid = ? AND trxid = ? AND id_sect = ?";
	private static final String _storeString = "UPDATE informix.cfgtrx2sectors  SET objectstatus = ? WHERE savconfigid = ? AND trxid = ? AND id_sect = ?";
	private static final String _loadString = "SELECT T1.savconfigid, T1.trxid, T1.id_sect, T1.objectstatus FROM informix.cfgtrx2sectors  T1 WHERE T1.savconfigid = ? AND T1.trxid = ? AND T1.id_sect = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"objectstatus"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgTrx2SectorBean_d03b763f
	 */
	public EJSJDBCPersisterCMPCfgTrx2SectorBean_d03b763f() throws java.rmi.RemoteException {
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
		CfgTrx2SectorBean b = (CfgTrx2SectorBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.trxid);
			pstmt.setInt(3, b.id_sect);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.objectstatus);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
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
		CfgTrx2SectorBean b = (CfgTrx2SectorBean) eb;
		com.hps.july.config.beans.CfgTrx2SectorKey _primaryKey = (com.hps.july.config.beans.CfgTrx2SectorKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.savconfigid = _primaryKey.savconfigid;
		b.trxid = _primaryKey.trxid;
		b.id_sect = _primaryKey.id_sect;
		b.objectstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getString(4);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgTrx2SectorBean b = (CfgTrx2SectorBean) eb;
		com.hps.july.config.beans.CfgTrx2SectorKey _primaryKey = (com.hps.july.config.beans.CfgTrx2SectorKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.trxid);
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
		CfgTrx2SectorBean b = (CfgTrx2SectorBean) eb;
		com.hps.july.config.beans.CfgTrx2SectorKey _primaryKey = new com.hps.july.config.beans.CfgTrx2SectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.trxid = b.trxid;
		_primaryKey.id_sect = b.id_sect;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgTrx2SectorBean b = (CfgTrx2SectorBean) eb;
		com.hps.july.config.beans.CfgTrx2SectorKey _primaryKey = new com.hps.july.config.beans.CfgTrx2SectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.trxid = b.trxid;
		_primaryKey.id_sect = b.id_sect;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(2, _primaryKey.savconfigid);
			pstmt.setInt(3, _primaryKey.trxid);
			pstmt.setInt(4, _primaryKey.id_sect);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.objectstatus);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			int inputPos = 4;
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
		CfgTrx2SectorBean b = (CfgTrx2SectorBean) eb;
		com.hps.july.config.beans.CfgTrx2SectorKey _primaryKey = new com.hps.july.config.beans.CfgTrx2SectorKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.trxid = b.trxid;
		_primaryKey.id_sect = b.id_sect;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.trxid);
			pstmt.setInt(3, _primaryKey.id_sect);
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
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.config.beans.CfgTrx2SectorKey key = new com.hps.july.config.beans.CfgTrx2SectorKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.trxid = resultSet.getInt(2);
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
	public com.hps.july.config.beans.CfgTrx2Sector findByPrimaryKey(com.hps.july.config.beans.CfgTrx2SectorKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgTrx2Sector) home.activateBean(primaryKey);
	}
}
