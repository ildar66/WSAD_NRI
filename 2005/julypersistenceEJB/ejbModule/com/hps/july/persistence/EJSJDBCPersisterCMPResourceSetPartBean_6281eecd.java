package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPResourceSetPartBean_6281eecd
 */
public class EJSJDBCPersisterCMPResourceSetPartBean_6281eecd extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderResourceSetPartBean {
	private static final String _createString = "INSERT INTO resourcesetparts (resource, resourceset, qty) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM resourcesetparts  WHERE resource = ? AND resourceset = ?";
	private static final String _storeString = "UPDATE resourcesetparts  SET qty = ? WHERE resource = ? AND resourceset = ?";
	private static final String _loadString = "SELECT T1.qty, T1.resource, T1.resourceset FROM resourcesetparts  T1 WHERE T1.resource = ? AND T1.resourceset = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"qty"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPResourceSetPartBean_6281eecd
	 */
	public EJSJDBCPersisterCMPResourceSetPartBean_6281eecd() throws java.rmi.RemoteException {
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
		ResourceSetPartBean b = (ResourceSetPartBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.qty == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.qty);
			}
			cacheData[0] = b.qty;
			if (b.part_resource == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.part_resource.intValue());
			}
			if (b.set_resourceset == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.set_resourceset.intValue());
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
		ResourceSetPartBean b = (ResourceSetPartBean) eb;
		com.hps.july.persistence.ResourceSetPartKey _primaryKey = (com.hps.july.persistence.ResourceSetPartKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.part_resource = _primaryKey.part_resource;
		b.set_resourceset = _primaryKey.set_resourceset;
		b.qty = resultSet.getBigDecimal(1);
		tempint = resultSet.getInt(2);
		b.part_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.set_resourceset = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getBigDecimal(1);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ResourceSetPartBean b = (ResourceSetPartBean) eb;
		com.hps.july.persistence.ResourceSetPartKey _primaryKey = (com.hps.july.persistence.ResourceSetPartKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.part_resource == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.part_resource.intValue());
			}
			if (_primaryKey.set_resourceset == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.set_resourceset.intValue());
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
		ResourceSetPartBean b = (ResourceSetPartBean) eb;
		com.hps.july.persistence.ResourceSetPartKey _primaryKey = new com.hps.july.persistence.ResourceSetPartKey();
		_primaryKey.part_resource = b.part_resource;
		_primaryKey.set_resourceset = b.set_resourceset;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ResourceSetPartBean b = (ResourceSetPartBean) eb;
		com.hps.july.persistence.ResourceSetPartKey _primaryKey = new com.hps.july.persistence.ResourceSetPartKey();
		_primaryKey.part_resource = b.part_resource;
		_primaryKey.set_resourceset = b.set_resourceset;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.part_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.part_resource.intValue());
			}
			if (_primaryKey.set_resourceset == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.set_resourceset.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.qty);
			}
			if (b.part_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.part_resource.intValue());
			}
			if (b.set_resourceset == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.set_resourceset.intValue());
			}
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
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
		ResourceSetPartBean b = (ResourceSetPartBean) eb;
		com.hps.july.persistence.ResourceSetPartKey _primaryKey = new com.hps.july.persistence.ResourceSetPartKey();
		_primaryKey.part_resource = b.part_resource;
		_primaryKey.set_resourceset = b.set_resourceset;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.part_resource == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.part_resource.intValue());
			}
			if (_primaryKey.set_resourceset == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.set_resourceset.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
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
		com.hps.july.persistence.ResourceSetPartKey key = new com.hps.july.persistence.ResourceSetPartKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.part_resource = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.set_resourceset = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findSetPartsBySet
	 */
	public EJSFinder findSetPartsBySet(com.hps.july.persistence.ResourceSetKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.qty, T1.resource, T1.resourceset FROM resourcesetparts  T1 WHERE T1.resourceset = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resourceset);
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
	public com.hps.july.persistence.ResourceSetPart findByPrimaryKey(com.hps.july.persistence.ResourceSetPartKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ResourceSetPart) home.activateBean(key);
	}
	/**
	 * findResourceSetPartsByPart
	 */
	public EJSFinder findResourceSetPartsByPart(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.qty, T1.resource, T1.resourceset FROM resourcesetparts  T1 WHERE T1.resource = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
