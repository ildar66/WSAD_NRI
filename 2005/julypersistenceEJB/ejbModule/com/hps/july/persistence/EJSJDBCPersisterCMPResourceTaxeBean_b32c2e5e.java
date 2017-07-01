package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPResourceTaxeBean_b32c2e5e
 */
public class EJSJDBCPersisterCMPResourceTaxeBean_b32c2e5e extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderResourceTaxeBean {
	private static final String _createString = "INSERT INTO resourcetaxes (date, resource, nds, nsp) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM resourcetaxes  WHERE date = ? AND resource = ?";
	private static final String _storeString = "UPDATE resourcetaxes  SET nds = ?, nsp = ? WHERE date = ? AND resource = ?";
	private static final String _loadString = "SELECT T1.date, T1.nds, T1.nsp, T1.resource FROM resourcetaxes  T1 WHERE T1.date = ? AND T1.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"nds", "nsp"};
	private static final boolean[] _predicateMaps = {true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPResourceTaxeBean_b32c2e5e
	 */
	public EJSJDBCPersisterCMPResourceTaxeBean_b32c2e5e() throws java.rmi.RemoteException {
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
		ResourceTaxeBean b = (ResourceTaxeBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[2];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.date);
			}
			if (b.nds == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.nds);
			}
			cacheData[0] = b.nds;
			if (b.nsp == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.nsp);
			}
			cacheData[1] = b.nsp;
			if (b.resource_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.resource_resource.intValue());
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
		ResourceTaxeBean b = (ResourceTaxeBean) eb;
		com.hps.july.persistence.ResourceTaxeKey _primaryKey = (com.hps.july.persistence.ResourceTaxeKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.date = _primaryKey.date;
		b.resource_resource = _primaryKey.resource_resource;
		b.nds = resultSet.getBigDecimal(2);
		b.nsp = resultSet.getBigDecimal(3);
		tempint = resultSet.getInt(4);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[2];
		cacheData[0] = resultSet.getBigDecimal(2);
		cacheData[1] = resultSet.getBigDecimal(3);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ResourceTaxeBean b = (ResourceTaxeBean) eb;
		com.hps.july.persistence.ResourceTaxeKey _primaryKey = (com.hps.july.persistence.ResourceTaxeKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.date);
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.resource_resource.intValue());
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
		ResourceTaxeBean b = (ResourceTaxeBean) eb;
		com.hps.july.persistence.ResourceTaxeKey _primaryKey = new com.hps.july.persistence.ResourceTaxeKey();
		_primaryKey.date = b.date;
		_primaryKey.resource_resource = b.resource_resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ResourceTaxeBean b = (ResourceTaxeBean) eb;
		com.hps.july.persistence.ResourceTaxeKey _primaryKey = new com.hps.july.persistence.ResourceTaxeKey();
		_primaryKey.date = b.date;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.date == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, _primaryKey.date);
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, _primaryKey.resource_resource.intValue());
			}
			if (b.nds == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.nds);
			}
			if (b.nsp == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.nsp);
			}
			if (b.resource_resource == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.resource_resource.intValue());
			}
			int inputPos = 4;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
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
		ResourceTaxeBean b = (ResourceTaxeBean) eb;
		com.hps.july.persistence.ResourceTaxeKey _primaryKey = new com.hps.july.persistence.ResourceTaxeKey();
		_primaryKey.date = b.date;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.date);
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.resource_resource.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
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
		com.hps.july.persistence.ResourceTaxeKey key = new com.hps.july.persistence.ResourceTaxeKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.date = resultSet.getDate(1);
			tempint = resultSet.getInt(4);
			key.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findResourceTaxesByResource
	 */
	public EJSFinder findResourceTaxesByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.date, T1.nds, T1.nsp, T1.resource FROM resourcetaxes  T1 WHERE T1.resource = ?");
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
	/**
	 * findBySubtypeDateOrderByResourceAsc
	 */
	public EJSFinder findBySubtypeDateOrderByResourceAsc(java.lang.Integer ressubtype, java.sql.Date date) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.date, T1.nds, T1.nsp, T1.resource FROM resourcetaxes  T1 WHERE resource IN (SELECT resource FROM resources WHERE resourcesubtype = ?) and date = (select max(ta.date) from resourcetaxes ta where ta.date <= ? and ta.resource=t1.resource ) order by resource asc");
			pstmt.setObject(1, ressubtype);
			pstmt.setDate(2, date);
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
	public com.hps.july.persistence.ResourceTaxe findByPrimaryKey(com.hps.july.persistence.ResourceTaxeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ResourceTaxe) home.activateBean(key);
	}
	/**
	 * findByResourceOrderByDateDesc
	 */
	public EJSFinder findByResourceOrderByDateDesc(java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.date, T1.nds, T1.nsp, T1.resource FROM resourcetaxes  T1 WHERE resource = ? order by date desc");
			pstmt.setObject(1, resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
