package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPBeenet2EquipmentBean_1c9d5b1d
 */
public class EJSJDBCPersisterCMPBeenet2EquipmentBean_1c9d5b1d extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderBeenet2EquipmentBean {
	private static final String _createString = "INSERT INTO beenet2equip (beenetid, equipment) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM beenet2equip  WHERE beenetid = ? AND equipment = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.beenetid, T1.equipment FROM beenet2equip  T1 WHERE T1.beenetid = ? AND T1.equipment = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPBeenet2EquipmentBean_1c9d5b1d
	 */
	public EJSJDBCPersisterCMPBeenet2EquipmentBean_1c9d5b1d() throws java.rmi.RemoteException {
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
		Beenet2EquipmentBean b = (Beenet2EquipmentBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[0];
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.beenetid);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			pstmt.setInt(2, b.equipment);
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
		Beenet2EquipmentBean b = (Beenet2EquipmentBean) eb;
		com.hps.july.persistence2.Beenet2EquipmentKey _primaryKey = (com.hps.july.persistence2.Beenet2EquipmentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.beenetid = _primaryKey.beenetid;
		b.equipment = _primaryKey.equipment;
		Object[] cacheData = new Object[0];
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		Beenet2EquipmentBean b = (Beenet2EquipmentBean) eb;
		com.hps.july.persistence2.Beenet2EquipmentKey _primaryKey = (com.hps.july.persistence2.Beenet2EquipmentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.beenetid);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			pstmt.setInt(2, _primaryKey.equipment);
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
		Beenet2EquipmentBean b = (Beenet2EquipmentBean) eb;
		com.hps.july.persistence2.Beenet2EquipmentKey _primaryKey = new com.hps.july.persistence2.Beenet2EquipmentKey();
		_primaryKey.beenetid = b.beenetid;
		_primaryKey.equipment = b.equipment;
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
		Beenet2EquipmentBean b = (Beenet2EquipmentBean) eb;
		com.hps.july.persistence2.Beenet2EquipmentKey _primaryKey = new com.hps.july.persistence2.Beenet2EquipmentKey();
		_primaryKey.beenetid = b.beenetid;
		_primaryKey.equipment = b.equipment;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.beenetid);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			pstmt.setInt(2, _primaryKey.equipment);
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
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence2.Beenet2EquipmentKey key = new com.hps.july.persistence2.Beenet2EquipmentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.beenetid = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
			key.equipment = resultSet.getInt(2);
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
	public com.hps.july.persistence2.Beenet2Equipment findByPrimaryKey(com.hps.july.persistence2.Beenet2EquipmentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.Beenet2Equipment) home.activateBean(key);
	}
	/**
	 * findByBeenetid
	 */
	public EJSFinder findByBeenetid(java.lang.String beenetid) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.beenetid, T1.equipment FROM beenet2equip  T1 WHERE beenetid = ?");
			if (beenetid == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, beenetid);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
