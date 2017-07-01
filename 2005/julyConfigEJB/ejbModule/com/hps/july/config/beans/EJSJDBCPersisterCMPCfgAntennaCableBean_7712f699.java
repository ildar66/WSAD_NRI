package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgAntennaCableBean_7712f699
 */
public class EJSJDBCPersisterCMPCfgAntennaCableBean_7712f699 extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgAntennaCableBean {
	private static final String _createString = "INSERT INTO informix.cfgantennacables (savconfigid, id_cable, id_anten, len_cable, cableres, groundresource, groundcnt, storagecard, qty, datasource, objectstatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfgantennacables  WHERE savconfigid = ? AND id_cable = ?";
	private static final String _storeString = "UPDATE informix.cfgantennacables  SET id_anten = ?, len_cable = ?, cableres = ?, groundresource = ?, groundcnt = ?, storagecard = ?, qty = ?, datasource = ?, objectstatus = ? WHERE savconfigid = ? AND id_cable = ?";
	private static final String _loadString = "SELECT T1.savconfigid, T1.id_cable, T1.id_anten, T1.len_cable, T1.cableres, T1.groundresource, T1.groundcnt, T1.storagecard, T1.qty, T1.datasource, T1.objectstatus FROM informix.cfgantennacables  T1 WHERE T1.savconfigid = ? AND T1.id_cable = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"id_anten", "cableres", "datasource"};
	private static final boolean[] _predicateMaps = {true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgAntennaCableBean_7712f699
	 */
	public EJSJDBCPersisterCMPCfgAntennaCableBean_7712f699() throws java.rmi.RemoteException {
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
		CfgAntennaCableBean b = (CfgAntennaCableBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[3];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.idCable);
			pstmt.setInt(3, b.id_anten);
			cacheData[0] = new Integer(b.id_anten);
			if (b.lenCable == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.lenCable);
			}
			pstmt.setInt(5, b.cableres);
			cacheData[1] = new Integer(b.cableres);
			if (b.groundresource == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.groundresource.intValue());
			}
			if (b.groundcnt == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.groundcnt.intValue());
			}
			if (b.storagecard == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.storagecard.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.qty);
			}
			pstmt.setInt(10, b.datasource);
			cacheData[2] = new Integer(b.datasource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.objectstatus);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
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
		CfgAntennaCableBean b = (CfgAntennaCableBean) eb;
		com.hps.july.config.beans.CfgAntennaCableKey _primaryKey = (com.hps.july.config.beans.CfgAntennaCableKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.savconfigid = _primaryKey.savconfigid;
		b.idCable = _primaryKey.idCable;
		b.id_anten = resultSet.getInt(3);
		b.lenCable = resultSet.getBigDecimal(4);
		b.cableres = resultSet.getInt(5);
		tempint = resultSet.getInt(6);
		b.groundresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.groundcnt = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		b.qty = resultSet.getBigDecimal(9);
		b.datasource = resultSet.getInt(10);
		b.objectstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		Object[] cacheData = new Object[3];
		tempint = resultSet.getInt(3);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgAntennaCableBean b = (CfgAntennaCableBean) eb;
		com.hps.july.config.beans.CfgAntennaCableKey _primaryKey = (com.hps.july.config.beans.CfgAntennaCableKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.idCable);
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
		CfgAntennaCableBean b = (CfgAntennaCableBean) eb;
		com.hps.july.config.beans.CfgAntennaCableKey _primaryKey = new com.hps.july.config.beans.CfgAntennaCableKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.idCable = b.idCable;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgAntennaCableBean b = (CfgAntennaCableBean) eb;
		com.hps.july.config.beans.CfgAntennaCableKey _primaryKey = new com.hps.july.config.beans.CfgAntennaCableKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.idCable = b.idCable;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(10, _primaryKey.savconfigid);
			pstmt.setInt(11, _primaryKey.idCable);
			pstmt.setInt(1, b.id_anten);
			if (b.lenCable == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.lenCable);
			}
			pstmt.setInt(3, b.cableres);
			if (b.groundresource == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.groundresource.intValue());
			}
			if (b.groundcnt == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.groundcnt.intValue());
			}
			if (b.storagecard == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.storagecard.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.qty);
			}
			pstmt.setInt(8, b.datasource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.objectstatus);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			int inputPos = 11;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
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
		CfgAntennaCableBean b = (CfgAntennaCableBean) eb;
		com.hps.july.config.beans.CfgAntennaCableKey _primaryKey = new com.hps.july.config.beans.CfgAntennaCableKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.idCable = b.idCable;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.idCable);
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
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
		com.hps.july.config.beans.CfgAntennaCableKey key = new com.hps.july.config.beans.CfgAntennaCableKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.idCable = resultSet.getInt(2);
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
	public com.hps.july.config.beans.CfgAntennaCable findByPrimaryKey(com.hps.july.config.beans.CfgAntennaCableKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgAntennaCable) home.activateBean(primaryKey);
	}
}
