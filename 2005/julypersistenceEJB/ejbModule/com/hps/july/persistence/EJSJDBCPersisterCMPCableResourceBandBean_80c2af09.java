package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCableResourceBandBean_80c2af09
 */
public class EJSJDBCPersisterCMPCableResourceBandBean_80c2af09 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderCableResourceBandBean {
	private static final String _createString = "INSERT INTO cableresband (band, resource, lostfactor) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM cableresband  WHERE band = ? AND resource = ?";
	private static final String _storeString = "UPDATE cableresband  SET lostfactor = ? WHERE band = ? AND resource = ?";
	private static final String _loadString = "SELECT T1.band, T1.lostfactor, T1.resource FROM cableresband  T1 WHERE T1.band = ? AND T1.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"lostfactor"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCableResourceBandBean_80c2af09
	 */
	public EJSJDBCPersisterCMPCableResourceBandBean_80c2af09() throws java.rmi.RemoteException {
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
		CableResourceBandBean b = (CableResourceBandBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setShort(1, b.band);
			if (b.lostfactor == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.lostfactor);
			}
			cacheData[0] = b.lostfactor;
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
		CableResourceBandBean b = (CableResourceBandBean) eb;
		com.hps.july.persistence.CableResourceBandKey _primaryKey = (com.hps.july.persistence.CableResourceBandKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.band = _primaryKey.band;
		b.resource_resource = _primaryKey.resource_resource;
		b.lostfactor = resultSet.getBigDecimal(2);
		tempint = resultSet.getInt(3);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getBigDecimal(2);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CableResourceBandBean b = (CableResourceBandBean) eb;
		com.hps.july.persistence.CableResourceBandKey _primaryKey = (com.hps.july.persistence.CableResourceBandKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setShort(1, _primaryKey.band);
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
		CableResourceBandBean b = (CableResourceBandBean) eb;
		com.hps.july.persistence.CableResourceBandKey _primaryKey = new com.hps.july.persistence.CableResourceBandKey();
		_primaryKey.band = b.band;
		_primaryKey.resource_resource = b.resource_resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CableResourceBandBean b = (CableResourceBandBean) eb;
		com.hps.july.persistence.CableResourceBandKey _primaryKey = new com.hps.july.persistence.CableResourceBandKey();
		_primaryKey.band = b.band;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setShort(2, _primaryKey.band);
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.resource_resource.intValue());
			}
			if (b.lostfactor == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.lostfactor);
			}
			if (b.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.resource_resource.intValue());
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
		CableResourceBandBean b = (CableResourceBandBean) eb;
		com.hps.july.persistence.CableResourceBandKey _primaryKey = new com.hps.july.persistence.CableResourceBandKey();
		_primaryKey.band = b.band;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setShort(1, _primaryKey.band);
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
		com.hps.july.persistence.CableResourceBandKey key = new com.hps.july.persistence.CableResourceBandKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.band = resultSet.getShort(1);
			tempint = resultSet.getInt(3);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.CableResourceBand findByPrimaryKey(com.hps.july.persistence.CableResourceBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.CableResourceBand) home.activateBean(key);
	}
	/**
	 * findCableResourceBandsByResource
	 */
	public EJSFinder findCableResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.band, T1.lostfactor, T1.resource FROM cableresband  T1 WHERE T1.resource = ?");
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
	 * findByCableResAndAntennaOrderByBand
	 */
	public EJSFinder findByCableResAndAntennaOrderByBand(java.lang.Integer cable, java.lang.Integer antenna) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.band, T1.lostfactor, T1.resource FROM cableresband  T1 WHERE resource = ? AND band IN (SELECT a.band FROM antennesworkbands a WHERE id_anten=?) ORDER BY band ASC");
			pstmt.setObject(1, cable);
			pstmt.setObject(2, antenna);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByCableResOrderByBand
	 */
	public EJSFinder findByCableResOrderByBand(java.lang.Integer cable) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.band, T1.lostfactor, T1.resource FROM cableresband  T1 WHERE resource = ? ORDER BY band ASC");
			pstmt.setObject(1, cable);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
