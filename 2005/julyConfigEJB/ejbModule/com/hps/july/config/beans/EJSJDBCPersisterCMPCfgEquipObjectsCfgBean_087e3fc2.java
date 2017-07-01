package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgEquipObjectsCfgBean_087e3fc2
 */
public class EJSJDBCPersisterCMPCfgEquipObjectsCfgBean_087e3fc2 extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgEquipObjectsCfgBean {
	private static final String _createString = "INSERT INTO informix.cfgequipobjectscfg (SAVCONFIGID, OBJCFGID, EQUIPMENT, STORAGECARD, QTY, OBJECTSTATUS, parentobjcfgid) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfgequipobjectscfg  WHERE SAVCONFIGID = ? AND OBJCFGID = ?";
	private static final String _storeString = "UPDATE informix.cfgequipobjectscfg  SET EQUIPMENT = ?, STORAGECARD = ?, QTY = ?, OBJECTSTATUS = ?, parentobjcfgid = ? WHERE SAVCONFIGID = ? AND OBJCFGID = ?";
	private static final String _loadString = "SELECT T1.SAVCONFIGID, T1.OBJCFGID, T1.EQUIPMENT, T1.STORAGECARD, T1.QTY, T1.OBJECTSTATUS, T1.parentobjcfgid FROM informix.cfgequipobjectscfg  T1 WHERE T1.SAVCONFIGID = ? AND T1.OBJCFGID = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"EQUIPMENT"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgEquipObjectsCfgBean_087e3fc2
	 */
	public EJSJDBCPersisterCMPCfgEquipObjectsCfgBean_087e3fc2() throws java.rmi.RemoteException {
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
		CfgEquipObjectsCfgBean b = (CfgEquipObjectsCfgBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.objcfgid);
			pstmt.setInt(3, b.equipment);
			cacheData[0] = new Integer(b.equipment);
			if (b.storagecard == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.storagecard.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.parentobjcfgid == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.parentobjcfgid.intValue());
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
		CfgEquipObjectsCfgBean b = (CfgEquipObjectsCfgBean) eb;
		com.hps.july.config.beans.CfgEquipObjectsCfgKey _primaryKey = (com.hps.july.config.beans.CfgEquipObjectsCfgKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.savconfigid = _primaryKey.savconfigid;
		b.objcfgid = _primaryKey.objcfgid;
		b.equipment = resultSet.getInt(3);
		tempint = resultSet.getInt(4);
		b.storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		b.qty = resultSet.getBigDecimal(5);
		b.ObjectStatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		tempint = resultSet.getInt(7);
		b.parentobjcfgid = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		tempint = resultSet.getInt(3);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgEquipObjectsCfgBean b = (CfgEquipObjectsCfgBean) eb;
		com.hps.july.config.beans.CfgEquipObjectsCfgKey _primaryKey = (com.hps.july.config.beans.CfgEquipObjectsCfgKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.objcfgid);
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
		CfgEquipObjectsCfgBean b = (CfgEquipObjectsCfgBean) eb;
		com.hps.july.config.beans.CfgEquipObjectsCfgKey _primaryKey = new com.hps.july.config.beans.CfgEquipObjectsCfgKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.objcfgid = b.objcfgid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgEquipObjectsCfgBean b = (CfgEquipObjectsCfgBean) eb;
		com.hps.july.config.beans.CfgEquipObjectsCfgKey _primaryKey = new com.hps.july.config.beans.CfgEquipObjectsCfgKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.objcfgid = b.objcfgid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(6, _primaryKey.savconfigid);
			pstmt.setInt(7, _primaryKey.objcfgid);
			pstmt.setInt(1, b.equipment);
			if (b.storagecard == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.storagecard.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.parentobjcfgid == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.parentobjcfgid.intValue());
			}
			int inputPos = 7;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		CfgEquipObjectsCfgBean b = (CfgEquipObjectsCfgBean) eb;
		com.hps.july.config.beans.CfgEquipObjectsCfgKey _primaryKey = new com.hps.july.config.beans.CfgEquipObjectsCfgKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.objcfgid = b.objcfgid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.objcfgid);
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		com.hps.july.config.beans.CfgEquipObjectsCfgKey key = new com.hps.july.config.beans.CfgEquipObjectsCfgKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.objcfgid = resultSet.getInt(2);
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
	public com.hps.july.config.beans.CfgEquipObjectsCfg findByPrimaryKey(com.hps.july.config.beans.CfgEquipObjectsCfgKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgEquipObjectsCfg) home.activateBean(primaryKey);
	}
}
