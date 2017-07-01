package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPCounterBean_b1595563
 */
public class EJSJDBCPersisterCMPCounterBean_b1595563 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderCounterBean {
	private static final String _createString = "INSERT INTO counters (COUNTERID, CSTATE, VENDOR_NUMBER, MODIFIEDBY, PRODUCTION_YEAR, POSITIONID, NEXTID, INITIAL_SETTINGS, PLACE_INFO, MODIFIED_DATE, REPLACE_REASON, NEXT_VERIFICATION, COUNTERINFO_ID, REPLACE_DATE, LAST_VERIFICATION, INSTALLATION_DATE, REPLACE_SETTINGS, DISMANTLING_DATE, DISMANTLING_REASON, DISMANTLING_SET, isvendorpowersupply) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM counters  WHERE COUNTERID = ?";
	private static final String _storeString = "UPDATE counters  SET CSTATE = ?, VENDOR_NUMBER = ?, MODIFIEDBY = ?, PRODUCTION_YEAR = ?, POSITIONID = ?, NEXTID = ?, INITIAL_SETTINGS = ?, PLACE_INFO = ?, MODIFIED_DATE = ?, REPLACE_REASON = ?, NEXT_VERIFICATION = ?, COUNTERINFO_ID = ?, REPLACE_DATE = ?, LAST_VERIFICATION = ?, INSTALLATION_DATE = ?, REPLACE_SETTINGS = ?, DISMANTLING_DATE = ?, DISMANTLING_REASON = ?, DISMANTLING_SET = ?, isvendorpowersupply = ? WHERE COUNTERID = ?";
	private static final String _loadString = "SELECT T1.CSTATE, T1.VENDOR_NUMBER, T1.COUNTERID, T1.MODIFIEDBY, T1.PRODUCTION_YEAR, T1.POSITIONID, T1.NEXTID, T1.INITIAL_SETTINGS, T1.PLACE_INFO, T1.MODIFIED_DATE, T1.REPLACE_REASON, T1.NEXT_VERIFICATION, T1.COUNTERINFO_ID, T1.REPLACE_DATE, T1.LAST_VERIFICATION, T1.INSTALLATION_DATE, T1.REPLACE_SETTINGS, T1.DISMANTLING_DATE, T1.DISMANTLING_REASON, T1.DISMANTLING_SET, T1.isvendorpowersupply FROM counters  T1 WHERE T1.COUNTERID = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"isvendorpowersupply"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPCounterBean_b1595563
	 */
	public EJSJDBCPersisterCMPCounterBean_b1595563() throws java.rmi.RemoteException {
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
		CounterBean b = (CounterBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.cstate == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.cstate.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.vendor_number);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.counterid);
			pstmt.setInt(4, b.modifiedby);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.production_year);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			pstmt.setInt(6, b.positionid);
			if (b.nextid == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.nextid.intValue());
			}
			if (b.initial_settings == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.initial_settings.intValue());
			}
			if (b.place_info == null) {
				pstmt.setNull(9, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(9, b.place_info);
			}
			if (b.modified_date == null) {
				pstmt.setNull(10, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(10, b.modified_date);
			}
			if (b.replace_reason == null) {
				pstmt.setNull(11, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(11, b.replace_reason);
			}
			if (b.next_verification == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.next_verification);
			}
			pstmt.setInt(13, b.counterinfo_id);
			if (b.replace_date == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.replace_date);
			}
			if (b.last_verification == null) {
				pstmt.setNull(15, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(15, b.last_verification);
			}
			if (b.installation_date == null) {
				pstmt.setNull(16, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(16, b.installation_date);
			}
			if (b.replace_settings == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.replace_settings.intValue());
			}
			if (b.dismantling_date == null) {
				pstmt.setNull(18, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(18, b.dismantling_date);
			}
			if (b.dismantling_reason == null) {
				pstmt.setNull(19, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(19, b.dismantling_reason);
			}
			if (b.dismantling_set == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.dismantling_set.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isVendorPowerSupply);
			if (objectTemp == null) {
				pstmt.setNull(21, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(21, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
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
		CounterBean b = (CounterBean) eb;
		com.hps.july.persistence2.CounterKey _primaryKey = (com.hps.july.persistence2.CounterKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.counterid = _primaryKey.counterid;
		tempint = resultSet.getInt(1);
		b.cstate = resultSet.wasNull() ? null : new Integer(tempint);
		b.vendor_number = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.modifiedby = resultSet.getInt(4);
		b.production_year = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.positionid = resultSet.getInt(6);
		tempint = resultSet.getInt(7);
		b.nextid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.initial_settings = resultSet.wasNull() ? null : new Integer(tempint);
		b.place_info = resultSet.getString(9);
		b.modified_date = resultSet.getTimestamp(10);
		b.replace_reason = resultSet.getString(11);
		b.next_verification = resultSet.getDate(12);
		b.counterinfo_id = resultSet.getInt(13);
		b.replace_date = resultSet.getDate(14);
		b.last_verification = resultSet.getDate(15);
		b.installation_date = resultSet.getDate(16);
		tempint = resultSet.getInt(17);
		b.replace_settings = resultSet.wasNull() ? null : new Integer(tempint);
		b.dismantling_date = resultSet.getDate(18);
		b.dismantling_reason = resultSet.getString(19);
		tempint = resultSet.getInt(20);
		b.dismantling_set = resultSet.wasNull() ? null : new Integer(tempint);
		b.isVendorPowerSupply = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(21));
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getString(21);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		CounterBean b = (CounterBean) eb;
		com.hps.july.persistence2.CounterKey _primaryKey = (com.hps.july.persistence2.CounterKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.counterid);
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
		CounterBean b = (CounterBean) eb;
		com.hps.july.persistence2.CounterKey _primaryKey = new com.hps.july.persistence2.CounterKey();
		_primaryKey.counterid = b.counterid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		CounterBean b = (CounterBean) eb;
		com.hps.july.persistence2.CounterKey _primaryKey = new com.hps.july.persistence2.CounterKey();
		_primaryKey.counterid = b.counterid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(21, _primaryKey.counterid);
			if (b.cstate == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.cstate.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.vendor_number);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			pstmt.setInt(3, b.modifiedby);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.production_year);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			pstmt.setInt(5, b.positionid);
			if (b.nextid == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.nextid.intValue());
			}
			if (b.initial_settings == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.initial_settings.intValue());
			}
			if (b.place_info == null) {
				pstmt.setNull(8, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(8, b.place_info);
			}
			if (b.modified_date == null) {
				pstmt.setNull(9, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(9, b.modified_date);
			}
			if (b.replace_reason == null) {
				pstmt.setNull(10, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(10, b.replace_reason);
			}
			if (b.next_verification == null) {
				pstmt.setNull(11, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(11, b.next_verification);
			}
			pstmt.setInt(12, b.counterinfo_id);
			if (b.replace_date == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.replace_date);
			}
			if (b.last_verification == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.last_verification);
			}
			if (b.installation_date == null) {
				pstmt.setNull(15, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(15, b.installation_date);
			}
			if (b.replace_settings == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.replace_settings.intValue());
			}
			if (b.dismantling_date == null) {
				pstmt.setNull(17, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(17, b.dismantling_date);
			}
			if (b.dismantling_reason == null) {
				pstmt.setNull(18, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(18, b.dismantling_reason);
			}
			if (b.dismantling_set == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.dismantling_set.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isVendorPowerSupply);
			if (objectTemp == null) {
				pstmt.setNull(20, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(20, (java.lang.String)objectTemp);
			}
			int inputPos = 21;
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
		CounterBean b = (CounterBean) eb;
		com.hps.july.persistence2.CounterKey _primaryKey = new com.hps.july.persistence2.CounterKey();
		_primaryKey.counterid = b.counterid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.counterid);
			int inputPos = 1;
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
		com.hps.july.persistence2.CounterKey key = new com.hps.july.persistence2.CounterKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.counterid = resultSet.getInt(3);
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
	public com.hps.july.persistence2.Counter findByPrimaryKey(com.hps.july.persistence2.CounterKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.Counter) home.activateBean(key);
	}
}
