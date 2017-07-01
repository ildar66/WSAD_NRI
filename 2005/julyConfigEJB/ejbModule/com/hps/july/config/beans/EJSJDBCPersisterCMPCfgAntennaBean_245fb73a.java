package com.hps.july.config.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCfgAntennaBean_245fb73a
 */
public class EJSJDBCPersisterCMPCfgAntennaBean_245fb73a extends EJSJDBCPersister implements com.hps.july.config.beans.EJSFinderCfgAntennaBean {
	private static final String _createString = "INSERT INTO informix.cfgantennes (SAVCONFIGID, ID_ANTEN, resource, NUM_ANT, KIND_ANT, NAKL, AZ_ANT, KSWN, h_set1, LEN_CABLE, CABLERES, EQUIPMENT, AZ_VARIATION, NAKL_VARIATION, INPUT_POWER, OPERATOR, BYHAND, GROUNDRESOURCE, GROUNDCNT, LOCATIONTYPE, ELECTRICALTILT, STORAGECARD, QTY, DATASOURCE, OBJECTSTATUS, commcable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.cfgantennes  WHERE SAVCONFIGID = ? AND ID_ANTEN = ?";
	private static final String _storeString = "UPDATE informix.cfgantennes  SET resource = ?, NUM_ANT = ?, KIND_ANT = ?, NAKL = ?, AZ_ANT = ?, KSWN = ?, h_set1 = ?, LEN_CABLE = ?, CABLERES = ?, EQUIPMENT = ?, AZ_VARIATION = ?, NAKL_VARIATION = ?, INPUT_POWER = ?, OPERATOR = ?, BYHAND = ?, GROUNDRESOURCE = ?, GROUNDCNT = ?, LOCATIONTYPE = ?, ELECTRICALTILT = ?, STORAGECARD = ?, QTY = ?, DATASOURCE = ?, OBJECTSTATUS = ?, commcable = ? WHERE SAVCONFIGID = ? AND ID_ANTEN = ?";
	private static final String _loadString = "SELECT T1.SAVCONFIGID, T1.ID_ANTEN, T1.resource, T1.NUM_ANT, T1.KIND_ANT, T1.NAKL, T1.AZ_ANT, T1.KSWN, T1.h_set1, T1.LEN_CABLE, T1.CABLERES, T1.EQUIPMENT, T1.AZ_VARIATION, T1.NAKL_VARIATION, T1.INPUT_POWER, T1.OPERATOR, T1.BYHAND, T1.GROUNDRESOURCE, T1.GROUNDCNT, T1.LOCATIONTYPE, T1.ELECTRICALTILT, T1.STORAGECARD, T1.QTY, T1.DATASOURCE, T1.OBJECTSTATUS, T1.commcable FROM informix.cfgantennes  T1 WHERE T1.SAVCONFIGID = ? AND T1.ID_ANTEN = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"resource", "EQUIPMENT", "DATASOURCE"};
	private static final boolean[] _predicateMaps = {true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCfgAntennaBean_245fb73a
	 */
	public EJSJDBCPersisterCMPCfgAntennaBean_245fb73a() throws java.rmi.RemoteException {
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
		CfgAntennaBean b = (CfgAntennaBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[3];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.savconfigid);
			pstmt.setInt(2, b.id_anten);
			pstmt.setInt(3, b.resource);
			cacheData[0] = new Integer(b.resource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.num_ant);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kind_ant);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.nakl == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.nakl);
			}
			if (b.az_ant == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.az_ant);
			}
			if (b.kswn == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.kswn);
			}
			if (b.h_set1 == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.h_set1);
			}
			if (b.len_cable == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.len_cable);
			}
			if (b.cableres == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.cableres.intValue());
			}
			pstmt.setInt(12, b.equipment);
			cacheData[1] = new Integer(b.equipment);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.az_variation);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.nakl_variation);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.input_power == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.input_power);
			}
			if (b.operator == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			if (b.groundresource == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.groundresource.intValue());
			}
			if (b.groundcnt == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.groundcnt.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.locationtype);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			if (b.electricaltilt == null) {
				pstmt.setNull(21, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(21, b.electricaltilt);
			}
			if (b.StorageCard == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.StorageCard.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(23, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(23, b.qty);
			}
			pstmt.setInt(24, b.datasource);
			cacheData[2] = new Integer(b.datasource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(25, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(25, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.commcable);
			if (objectTemp == null) {
				pstmt.setNull(26, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(26, (java.lang.String)objectTemp);
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
		CfgAntennaBean b = (CfgAntennaBean) eb;
		com.hps.july.config.beans.CfgAntennaKey _primaryKey = (com.hps.july.config.beans.CfgAntennaKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.savconfigid = _primaryKey.savconfigid;
		b.id_anten = _primaryKey.id_anten;
		b.resource = resultSet.getInt(3);
		b.num_ant = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.kind_ant = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.nakl = resultSet.getBigDecimal(6);
		b.az_ant = resultSet.getBigDecimal(7);
		b.kswn = resultSet.getBigDecimal(8);
		b.h_set1 = resultSet.getBigDecimal(9);
		b.len_cable = resultSet.getBigDecimal(10);
		tempint = resultSet.getInt(11);
		b.cableres = resultSet.wasNull() ? null : new Integer(tempint);
		b.equipment = resultSet.getInt(12);
		b.az_variation = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.nakl_variation = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		b.input_power = resultSet.getBigDecimal(15);
		tempint = resultSet.getInt(16);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		b.byhand = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(17));
		tempint = resultSet.getInt(18);
		b.groundresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(19);
		b.groundcnt = resultSet.wasNull() ? null : new Integer(tempint);
		b.locationtype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(20));
		b.electricaltilt = resultSet.getBigDecimal(21);
		tempint = resultSet.getInt(22);
		b.StorageCard = resultSet.wasNull() ? null : new Integer(tempint);
		b.qty = resultSet.getBigDecimal(23);
		b.datasource = resultSet.getInt(24);
		b.ObjectStatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(25));
		b.commcable = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(26));
		Object[] cacheData = new Object[3];
		tempint = resultSet.getInt(3);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(12);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(24);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CfgAntennaBean b = (CfgAntennaBean) eb;
		com.hps.july.config.beans.CfgAntennaKey _primaryKey = (com.hps.july.config.beans.CfgAntennaKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.id_anten);
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
		CfgAntennaBean b = (CfgAntennaBean) eb;
		com.hps.july.config.beans.CfgAntennaKey _primaryKey = new com.hps.july.config.beans.CfgAntennaKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_anten = b.id_anten;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CfgAntennaBean b = (CfgAntennaBean) eb;
		com.hps.july.config.beans.CfgAntennaKey _primaryKey = new com.hps.july.config.beans.CfgAntennaKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_anten = b.id_anten;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(25, _primaryKey.savconfigid);
			pstmt.setInt(26, _primaryKey.id_anten);
			pstmt.setInt(1, b.resource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.num_ant);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kind_ant);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.nakl == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.nakl);
			}
			if (b.az_ant == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.az_ant);
			}
			if (b.kswn == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.kswn);
			}
			if (b.h_set1 == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.h_set1);
			}
			if (b.len_cable == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.len_cable);
			}
			if (b.cableres == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.cableres.intValue());
			}
			pstmt.setInt(10, b.equipment);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.az_variation);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.nakl_variation);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.input_power == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.input_power);
			}
			if (b.operator == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.groundresource == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.groundresource.intValue());
			}
			if (b.groundcnt == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.groundcnt.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.locationtype);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.electricaltilt == null) {
				pstmt.setNull(19, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(19, b.electricaltilt);
			}
			if (b.StorageCard == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.StorageCard.intValue());
			}
			if (b.qty == null) {
				pstmt.setNull(21, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(21, b.qty);
			}
			pstmt.setInt(22, b.datasource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.ObjectStatus);
			if (objectTemp == null) {
				pstmt.setNull(23, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(23, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.commcable);
			if (objectTemp == null) {
				pstmt.setNull(24, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(24, (java.lang.String)objectTemp);
			}
			int inputPos = 26;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
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
		CfgAntennaBean b = (CfgAntennaBean) eb;
		com.hps.july.config.beans.CfgAntennaKey _primaryKey = new com.hps.july.config.beans.CfgAntennaKey();
		_primaryKey.savconfigid = b.savconfigid;
		_primaryKey.id_anten = b.id_anten;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.savconfigid);
			pstmt.setInt(2, _primaryKey.id_anten);
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
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
		com.hps.july.config.beans.CfgAntennaKey key = new com.hps.july.config.beans.CfgAntennaKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.savconfigid = resultSet.getInt(1);
			key.id_anten = resultSet.getInt(2);
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
	public com.hps.july.config.beans.CfgAntenna findByPrimaryKey(com.hps.july.config.beans.CfgAntennaKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.config.beans.CfgAntenna) home.activateBean(primaryKey);
	}
}
