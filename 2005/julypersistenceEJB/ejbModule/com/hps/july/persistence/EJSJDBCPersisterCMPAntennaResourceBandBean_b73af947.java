package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAntennaResourceBandBean_b73af947
 */
public class EJSJDBCPersisterCMPAntennaResourceBandBean_b73af947 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAntennaResourceBandBean {
	private static final String _createString = "INSERT INTO antennaresband (band, resource, vertwidth, amplification, horzwidth, electricangle, ksvn, hasmaxelectricangle, maxelectricangle) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM antennaresband  WHERE band = ? AND resource = ?";
	private static final String _storeString = "UPDATE antennaresband  SET vertwidth = ?, amplification = ?, horzwidth = ?, electricangle = ?, ksvn = ?, hasmaxelectricangle = ?, maxelectricangle = ? WHERE band = ? AND resource = ?";
	private static final String _loadString = "SELECT T1.vertwidth, T1.band, T1.amplification, T1.horzwidth, T1.electricangle, T1.ksvn, T1.hasmaxelectricangle, T1.maxelectricangle, T1.resource FROM antennaresband  T1 WHERE T1.band = ? AND T1.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"hasmaxelectricangle"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAntennaResourceBandBean_b73af947
	 */
	public EJSJDBCPersisterCMPAntennaResourceBandBean_b73af947() throws java.rmi.RemoteException {
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
		AntennaResourceBandBean b = (AntennaResourceBandBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.vertwidth == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.vertwidth);
			}
			pstmt.setShort(1, b.band);
			if (b.amplification == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.amplification);
			}
			if (b.horzwidth == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.horzwidth);
			}
			if (b.electricangle == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.electricangle);
			}
			if (b.ksvn == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.ksvn);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.hasMaxElectricAngle));
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			if (b.maxelectricangle == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.maxelectricangle);
			}
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
		AntennaResourceBandBean b = (AntennaResourceBandBean) eb;
		com.hps.july.persistence.AntennaResourceBandKey _primaryKey = (com.hps.july.persistence.AntennaResourceBandKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.band = _primaryKey.band;
		b.resource_resource = _primaryKey.resource_resource;
		b.vertwidth = resultSet.getBigDecimal(1);
		b.amplification = resultSet.getBigDecimal(3);
		b.horzwidth = resultSet.getBigDecimal(4);
		b.electricangle = resultSet.getBigDecimal(5);
		b.ksvn = resultSet.getBigDecimal(6);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(7));
		b.hasMaxElectricAngle = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.maxelectricangle = resultSet.getBigDecimal(8);
		tempint = resultSet.getInt(9);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getString(7);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AntennaResourceBandBean b = (AntennaResourceBandBean) eb;
		com.hps.july.persistence.AntennaResourceBandKey _primaryKey = (com.hps.july.persistence.AntennaResourceBandKey)pKey;
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
		AntennaResourceBandBean b = (AntennaResourceBandBean) eb;
		com.hps.july.persistence.AntennaResourceBandKey _primaryKey = new com.hps.july.persistence.AntennaResourceBandKey();
		_primaryKey.band = b.band;
		_primaryKey.resource_resource = b.resource_resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AntennaResourceBandBean b = (AntennaResourceBandBean) eb;
		com.hps.july.persistence.AntennaResourceBandKey _primaryKey = new com.hps.july.persistence.AntennaResourceBandKey();
		_primaryKey.band = b.band;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setShort(8, _primaryKey.band);
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, _primaryKey.resource_resource.intValue());
			}
			if (b.vertwidth == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.vertwidth);
			}
			if (b.amplification == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.amplification);
			}
			if (b.horzwidth == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.horzwidth);
			}
			if (b.electricangle == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.electricangle);
			}
			if (b.ksvn == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.ksvn);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.hasMaxElectricAngle));
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.maxelectricangle == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.maxelectricangle);
			}
			if (b.resource_resource == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.resource_resource.intValue());
			}
			int inputPos = 9;
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
		AntennaResourceBandBean b = (AntennaResourceBandBean) eb;
		com.hps.july.persistence.AntennaResourceBandKey _primaryKey = new com.hps.july.persistence.AntennaResourceBandKey();
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
		com.hps.july.persistence.AntennaResourceBandKey key = new com.hps.july.persistence.AntennaResourceBandKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.band = resultSet.getShort(2);
			tempint = resultSet.getInt(9);
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
	 * findAntennaResourceBandsByResource
	 */
	public EJSFinder findAntennaResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.vertwidth, T1.band, T1.amplification, T1.horzwidth, T1.electricangle, T1.ksvn, T1.hasmaxelectricangle, T1.maxelectricangle, T1.resource FROM antennaresband  T1 WHERE T1.resource = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AntennaResourceBand findByPrimaryKey(com.hps.july.persistence.AntennaResourceBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.AntennaResourceBand) home.activateBean(key);
	}
}
