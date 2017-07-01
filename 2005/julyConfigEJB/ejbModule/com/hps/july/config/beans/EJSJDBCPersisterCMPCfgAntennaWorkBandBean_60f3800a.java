package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgAntennaWorkBandBean_60f3800a
 */
public class EJSJDBCPersisterCMPCfgAntennaWorkBandBean_60f3800a extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgAntennaWorkBandBean {
	private static final String _createString = "INSERT INTO informix.cfgantennesworkbands (savconfigid, id_anten, band, electricangle, kind_ant, kswn, objectstatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfgantennesworkbands  WHERE savconfigid = ? AND id_anten = ? AND band = ?";
	private static final String _storeString = "UPDATE informix.cfgantennesworkbands  SET electricangle = ?, kind_ant = ?, kswn = ?, objectstatus = ? WHERE savconfigid = ? AND id_anten = ? AND band = ?";
	private static final String _loadString = "SELECT T1.savconfigid, T1.id_anten, T1.band, T1.electricangle, T1.kind_ant, T1.kswn, T1.objectstatus FROM informix.cfgantennesworkbands  T1 WHERE T1.savconfigid = ? AND T1.id_anten = ? AND T1.band = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"electricangle", "kind_ant", "kswn", "objectstatus"};
	private static final boolean[] _predicateMaps = {true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgAntennaWorkBandBean_60f3800a
	 */
	public EJSJDBCPersisterCMPCfgAntennaWorkBandBean_60f3800a() throws java.rmi.RemoteException {
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
		CfgAntennaWorkBandBean b = (CfgAntennaWorkBandBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[4];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.idanten);
			pstmt.setShort(3, b.band);
			if (b.electricangle == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.electricangle);
			}
			cacheData[0] = b.electricangle;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kind_ant);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.kswn == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.kswn);
			}
			cacheData[2] = b.kswn;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.objectstatus);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
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
		CfgAntennaWorkBandBean b = (CfgAntennaWorkBandBean) eb;
		com.hps.july.config.beans.CfgAntennaWorkBandKey _primaryKey = (com.hps.july.config.beans.CfgAntennaWorkBandKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.savconfigid = _primaryKey.savconfigid;
		b.idanten = _primaryKey.idanten;
		b.band = _primaryKey.band;
		b.electricangle = resultSet.getBigDecimal(4);
		b.kind_ant = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.kswn = resultSet.getBigDecimal(6);
		b.objectstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		Object[] cacheData = new Object[4];
		cacheData[0] = resultSet.getBigDecimal(4);
		cacheData[1] = resultSet.getString(5);
		cacheData[2] = resultSet.getBigDecimal(6);
		cacheData[3] = resultSet.getString(7);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgAntennaWorkBandBean b = (CfgAntennaWorkBandBean) eb;
		com.hps.july.config.beans.CfgAntennaWorkBandKey _primaryKey = (com.hps.july.config.beans.CfgAntennaWorkBandKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.idanten);
			pstmt.setShort(3, _primaryKey.band);
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
		CfgAntennaWorkBandBean b = (CfgAntennaWorkBandBean) eb;
		com.hps.july.config.beans.CfgAntennaWorkBandKey _primaryKey = new com.hps.july.config.beans.CfgAntennaWorkBandKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.idanten = b.idanten;
		_primaryKey.band = b.band;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgAntennaWorkBandBean b = (CfgAntennaWorkBandBean) eb;
		com.hps.july.config.beans.CfgAntennaWorkBandKey _primaryKey = new com.hps.july.config.beans.CfgAntennaWorkBandKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.idanten = b.idanten;
		_primaryKey.band = b.band;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(5, _primaryKey.savconfigid);
			pstmt.setInt(6, _primaryKey.idanten);
			pstmt.setShort(7, _primaryKey.band);
			if (b.electricangle == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.electricangle);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kind_ant);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.kswn == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.kswn);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.objectstatus);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			int inputPos = 7;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
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
		CfgAntennaWorkBandBean b = (CfgAntennaWorkBandBean) eb;
		com.hps.july.config.beans.CfgAntennaWorkBandKey _primaryKey = new com.hps.july.config.beans.CfgAntennaWorkBandKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.idanten = b.idanten;
		_primaryKey.band = b.band;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.idanten);
			pstmt.setShort(3, _primaryKey.band);
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
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
		com.hps.july.config.beans.CfgAntennaWorkBandKey key = new com.hps.july.config.beans.CfgAntennaWorkBandKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.idanten = resultSet.getInt(2);
			key.band = resultSet.getShort(3);
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
	public com.hps.july.config.beans.CfgAntennaWorkBand findByPrimaryKey(com.hps.july.config.beans.CfgAntennaWorkBandKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgAntennaWorkBand) home.activateBean(primaryKey);
	}
}
