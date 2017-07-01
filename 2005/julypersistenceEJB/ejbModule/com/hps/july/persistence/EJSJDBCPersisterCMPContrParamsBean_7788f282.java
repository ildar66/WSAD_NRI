package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPContrParamsBean_7788f282
 */
public class EJSJDBCPersisterCMPContrParamsBean_7788f282 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderContrParamsBean {
	private static final String _createString = "INSERT INTO contrparams (paramid, param_level, param_value, param_type, equipment, act_date) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM contrparams  WHERE paramid = ?";
	private static final String _storeString = "UPDATE contrparams  SET param_level = ?, param_value = ?, param_type = ?, equipment = ?, act_date = ? WHERE paramid = ?";
	private static final String _loadString = "SELECT T1.paramid, T1.param_level, T1.param_value, T1.param_type, T1.equipment, T1.act_date FROM contrparams  T1 WHERE T1.paramid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"param_level", "param_value", "param_type", "equipment", "act_date"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPContrParamsBean_7788f282
	 */
	public EJSJDBCPersisterCMPContrParamsBean_7788f282() throws java.rmi.RemoteException {
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
		ContrParamsBean b = (ContrParamsBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[5];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.paramid);
			if (b.param_level == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.param_level);
			}
			cacheData[0] = b.param_level;
			if (b.param_value == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.param_value);
			}
			cacheData[1] = b.param_value;
			pstmt.setInt(4, b.param_type);
			cacheData[2] = new Integer(b.param_type);
			if (b.contraddinfo_act_date == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.contraddinfo_act_date);
			}
			cacheData[4] = b.contraddinfo_act_date;
			if (b.contraddinfo_controller_storageplace == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.contraddinfo_controller_storageplace.intValue());
			}
			cacheData[3] = b.contraddinfo_controller_storageplace;
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
		ContrParamsBean b = (ContrParamsBean) eb;
		com.hps.july.persistence.ContrParamsKey _primaryKey = (com.hps.july.persistence.ContrParamsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.paramid = _primaryKey.paramid;
		b.param_level = resultSet.getBigDecimal(2);
		b.param_value = resultSet.getBigDecimal(3);
		b.param_type = resultSet.getInt(4);
		b.contraddinfo_act_date = resultSet.getDate(6);
		tempint = resultSet.getInt(5);
		b.contraddinfo_controller_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[5];
		cacheData[0] = resultSet.getBigDecimal(2);
		cacheData[1] = resultSet.getBigDecimal(3);
		tempint = resultSet.getInt(4);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[4] = resultSet.getDate(6);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ContrParamsBean b = (ContrParamsBean) eb;
		com.hps.july.persistence.ContrParamsKey _primaryKey = (com.hps.july.persistence.ContrParamsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.paramid);
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
		ContrParamsBean b = (ContrParamsBean) eb;
		com.hps.july.persistence.ContrParamsKey _primaryKey = new com.hps.july.persistence.ContrParamsKey();
		_primaryKey.paramid = b.paramid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ContrParamsBean b = (ContrParamsBean) eb;
		com.hps.july.persistence.ContrParamsKey _primaryKey = new com.hps.july.persistence.ContrParamsKey();
		_primaryKey.paramid = b.paramid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(6, _primaryKey.paramid);
			if (b.param_level == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.param_level);
			}
			if (b.param_value == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.param_value);
			}
			pstmt.setInt(3, b.param_type);
			if (b.contraddinfo_act_date == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.contraddinfo_act_date);
			}
			if (b.contraddinfo_controller_storageplace == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.contraddinfo_controller_storageplace.intValue());
			}
			int inputPos = 6;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
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
		ContrParamsBean b = (ContrParamsBean) eb;
		com.hps.july.persistence.ContrParamsKey _primaryKey = new com.hps.july.persistence.ContrParamsKey();
		_primaryKey.paramid = b.paramid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.paramid);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
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
		com.hps.july.persistence.ContrParamsKey key = new com.hps.july.persistence.ContrParamsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.paramid = resultSet.getInt(1);
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
	 * findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc
	 */
	public EJSFinder findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate, java.lang.Integer param_type) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.paramid, T1.param_level, T1.param_value, T1.param_type, T1.equipment, T1.act_date FROM contrparams  T1 WHERE equipment = ? AND act_date = ? and param_type = ? ORDER BY param_level ASC");
			pstmt.setObject(1, equipment);
			pstmt.setDate(2, actdate);
			pstmt.setObject(3, param_type);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findContrParamsByContraddinfo
	 */
	public EJSFinder findContrParamsByContraddinfo(com.hps.july.persistence.ContrAddInfoKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.paramid, T1.param_level, T1.param_value, T1.param_type, T1.equipment, T1.act_date FROM contrparams  T1 WHERE T1.equipment = ? AND T1.act_date = ?");
			Object objectTemp = null;
boolean nullData;
			if (inKey.act_date == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, inKey.act_date);
			}
			if (inKey.controller_storageplace == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, inKey.controller_storageplace.intValue());
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
	public com.hps.july.persistence.ContrParams findByPrimaryKey(com.hps.july.persistence.ContrParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ContrParams) home.activateBean(key);
	}
	/**
	 * findByEquipmentAndActdateOrderByParamlevelAsc
	 */
	public EJSFinder findByEquipmentAndActdateOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.paramid, T1.param_level, T1.param_value, T1.param_type, T1.equipment, T1.act_date FROM contrparams  T1 WHERE equipment = ? AND act_date = ? ORDER BY param_level ASC");
			pstmt.setObject(1, equipment);
			pstmt.setDate(2, actdate);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
