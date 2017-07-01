package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSuperRegionAccBean_7cebb5ee
 */
public class EJSJDBCPersisterCMPSuperRegionAccBean_7cebb5ee extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSuperRegionAccBean {
	private static final String _createString = "INSERT INTO regionsaccess (accessid, editfact, editplan, viewfact, viewplan, viewarenda, editarenda, operatorid, supregionid, accesstype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM regionsaccess  WHERE accessid = ?";
	private static final String _storeString = "UPDATE regionsaccess  SET editfact = ?, editplan = ?, viewfact = ?, viewplan = ?, viewarenda = ?, editarenda = ?, operatorid = ?, supregionid = ?, accesstype = ? WHERE accessid = ?";
	private static final String _loadString = "SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.viewarenda, T1.editarenda, T1.operatorid, T1.supregionid, T1.accesstype FROM regionsaccess  T1 WHERE T1.accesstype = \'S\' AND T1.accessid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"editfact", "editplan", "viewfact", "viewplan", "viewarenda", "editarenda", "operatorid", "supregionid"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSuperRegionAccBean_7cebb5ee
	 */
	public EJSJDBCPersisterCMPSuperRegionAccBean_7cebb5ee() throws java.rmi.RemoteException {
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
		SuperRegionAccBean b = (SuperRegionAccBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[8];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.accessid);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.editfact));
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.editplan));
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.viewfact));
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.viewplan));
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.viewarenda);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[4] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.editarenda);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
			if (b.operator_operator == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.operator_operator.intValue());
			}
			cacheData[6] = b.operator_operator;
			if (b.superregion_supregid == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.superregion_supregid.intValue());
			}
			cacheData[7] = b.superregion_supregid;
			pstmt.setString(10, "S");
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
		SuperRegionAccBean b = (SuperRegionAccBean) eb;
		com.hps.july.persistence.SuperRegionAccKey _primaryKey = (com.hps.july.persistence.SuperRegionAccKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.accessid = _primaryKey.accessid;
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(2));
		b.editfact = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(3));
		b.editplan = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		b.viewfact = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(5));
		b.viewplan = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.viewarenda = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(6));
		b.editarenda = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(7));
		tempint = resultSet.getInt(8);
		b.operator_operator = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.superregion_supregid = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[8];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getString(4);
		cacheData[3] = resultSet.getString(5);
		cacheData[4] = resultSet.getString(6);
		cacheData[5] = resultSet.getString(7);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		cacheData[7] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SuperRegionAccBean b = (SuperRegionAccBean) eb;
		com.hps.july.persistence.SuperRegionAccKey _primaryKey = (com.hps.july.persistence.SuperRegionAccKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.accessid);
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
		SuperRegionAccBean b = (SuperRegionAccBean) eb;
		com.hps.july.persistence.SuperRegionAccKey _primaryKey = new com.hps.july.persistence.SuperRegionAccKey();
		_primaryKey.accessid = b.accessid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SuperRegionAccBean b = (SuperRegionAccBean) eb;
		com.hps.july.persistence.SuperRegionAccKey _primaryKey = new com.hps.july.persistence.SuperRegionAccKey();
		_primaryKey.accessid = b.accessid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(10, _primaryKey.accessid);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.editfact));
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.editplan));
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.viewfact));
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.viewplan));
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.viewarenda);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.editarenda);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.operator_operator == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.operator_operator.intValue());
			}
			if (b.superregion_supregid == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.superregion_supregid.intValue());
			}
			pstmt.setString(9, "S");
			int inputPos = 10;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
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
		SuperRegionAccBean b = (SuperRegionAccBean) eb;
		com.hps.july.persistence.SuperRegionAccKey _primaryKey = new com.hps.july.persistence.SuperRegionAccKey();
		_primaryKey.accessid = b.accessid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.accessid);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
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
		com.hps.july.persistence.SuperRegionAccKey key = new com.hps.july.persistence.SuperRegionAccKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.accessid = resultSet.getInt(1);
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
	 * findSuperRegionAccsBySuperregion
	 */
	public EJSFinder findSuperRegionAccsBySuperregion(com.hps.july.persistence.SuperRegionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.viewarenda, T1.editarenda, T1.operatorid, T1.supregionid, T1.accesstype FROM regionsaccess  T1 WHERE T1.accesstype = \'S\' AND T1.supregionid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.supregid);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByOperatorAndId
	 */
	public EJSFinder findByOperatorAndId(java.lang.Integer argOperator, java.lang.Integer argSregionID) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.viewarenda, T1.editarenda, T1.operatorid, T1.supregionid, T1.accesstype FROM regionsaccess  T1 WHERE T1.accesstype = \'S\' AND operatorid = ? AND supregionid = ?");
			pstmt.setObject(1, argOperator);
			pstmt.setObject(2, argSregionID);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByOperator
	 */
	public EJSFinder findByOperator(java.lang.Integer argOperator) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.viewarenda, T1.editarenda, T1.operatorid, T1.supregionid, T1.accesstype FROM regionsaccess  T1 WHERE T1.accesstype = \'S\' AND operatorid = ?");
			pstmt.setObject(1, argOperator);
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
	public com.hps.july.persistence.SuperRegionAcc findByPrimaryKey(com.hps.july.persistence.SuperRegionAccKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.SuperRegionAcc) home.activateBean(key);
	}
	/**
	 * findAllOrderByCodeAsc
	 */
	public EJSFinder findAllOrderByCodeAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.viewarenda, T1.editarenda, T1.operatorid, T1.supregionid, T1.accesstype FROM regionsaccess  T1 WHERE T1.accesstype = \'S\' AND 1=1 ORDER BY accessid ASC");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findSuperRegionAccsByOperator
	 */
	public EJSFinder findSuperRegionAccsByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.accessid, T1.editfact, T1.editplan, T1.viewfact, T1.viewplan, T1.viewarenda, T1.editarenda, T1.operatorid, T1.supregionid, T1.accesstype FROM regionsaccess  T1 WHERE T1.accesstype = \'S\' AND T1.operatorid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.operator);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
