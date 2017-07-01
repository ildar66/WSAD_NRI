package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAntennaWorkBandBean_8b2ccd86
 */
public class EJSJDBCPersisterCMPAntennaWorkBandBean_8b2ccd86 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAntennaWorkBandBean {
	private static final String _createString = "INSERT INTO antennesworkbands (band, id_anten) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM antennesworkbands  WHERE band = ? AND id_anten = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.band, T1.id_anten FROM antennesworkbands  T1 WHERE T1.band = ? AND T1.id_anten = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAntennaWorkBandBean_8b2ccd86
	 */
	public EJSJDBCPersisterCMPAntennaWorkBandBean_8b2ccd86() throws java.rmi.RemoteException {
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
		AntennaWorkBandBean b = (AntennaWorkBandBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[0];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setShort(1, b.band);
			if (b.antenna_idanten == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.antenna_idanten.intValue());
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
		AntennaWorkBandBean b = (AntennaWorkBandBean) eb;
		com.hps.july.persistence.AntennaWorkBandKey _primaryKey = (com.hps.july.persistence.AntennaWorkBandKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.band = _primaryKey.band;
		b.antenna_idanten = _primaryKey.antenna_idanten;
		tempint = resultSet.getInt(2);
		b.antenna_idanten = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[0];
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AntennaWorkBandBean b = (AntennaWorkBandBean) eb;
		com.hps.july.persistence.AntennaWorkBandKey _primaryKey = (com.hps.july.persistence.AntennaWorkBandKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setShort(1, _primaryKey.band);
			if (_primaryKey.antenna_idanten == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.antenna_idanten.intValue());
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
		AntennaWorkBandBean b = (AntennaWorkBandBean) eb;
		com.hps.july.persistence.AntennaWorkBandKey _primaryKey = new com.hps.july.persistence.AntennaWorkBandKey();
		_primaryKey.band = b.band;
		_primaryKey.antenna_idanten = b.antenna_idanten;
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
		AntennaWorkBandBean b = (AntennaWorkBandBean) eb;
		com.hps.july.persistence.AntennaWorkBandKey _primaryKey = new com.hps.july.persistence.AntennaWorkBandKey();
		_primaryKey.band = b.band;
		_primaryKey.antenna_idanten = b.antenna_idanten;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setShort(1, _primaryKey.band);
			if (_primaryKey.antenna_idanten == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.antenna_idanten.intValue());
			}
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
		com.hps.july.persistence.AntennaWorkBandKey key = new com.hps.july.persistence.AntennaWorkBandKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.band = resultSet.getShort(1);
			tempint = resultSet.getInt(2);
			key.antenna_idanten = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findAntennaWorkBandsByAntenna
	 */
	public EJSFinder findAntennaWorkBandsByAntenna(com.hps.july.persistence.AntennaKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.band, T1.id_anten FROM antennesworkbands  T1 WHERE T1.id_anten = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idanten);
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
	public com.hps.july.persistence.AntennaWorkBand findByPrimaryKey(com.hps.july.persistence.AntennaWorkBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.AntennaWorkBand) home.activateBean(key);
	}
}
