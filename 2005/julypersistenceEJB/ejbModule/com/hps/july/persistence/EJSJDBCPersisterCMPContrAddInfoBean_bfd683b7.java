package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPContrAddInfoBean_bfd683b7
 */
public class EJSJDBCPersisterCMPContrAddInfoBean_bfd683b7 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderContrAddInfoBean {
	private static final String _createString = "INSERT INTO contraddinfo (act_date, equipment, acc_load, bad_cunsr_percent, bad_cunssr_percent, cap_use_percent, conn_lost_avg, koef_kk, load_aint_percent, load_max_day, load_max_hour, ss7_load_avg, traf_aint) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM contraddinfo  WHERE act_date = ? AND equipment = ?";
	private static final String _storeString = "UPDATE contraddinfo  SET acc_load = ?, bad_cunsr_percent = ?, bad_cunssr_percent = ?, cap_use_percent = ?, conn_lost_avg = ?, koef_kk = ?, load_aint_percent = ?, load_max_day = ?, load_max_hour = ?, ss7_load_avg = ?, traf_aint = ? WHERE act_date = ? AND equipment = ?";
	private static final String _loadString = "SELECT T1.act_date, T1.acc_load, T1.bad_cunsr_percent, T1.bad_cunssr_percent, T1.cap_use_percent, T1.conn_lost_avg, T1.koef_kk, T1.load_aint_percent, T1.load_max_day, T1.load_max_hour, T1.ss7_load_avg, T1.traf_aint, T1.equipment FROM contraddinfo  T1 WHERE T1.act_date = ? AND T1.equipment = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"acc_load", "bad_cunsr_percent", "bad_cunssr_percent", "cap_use_percent", "conn_lost_avg", "koef_kk", "load_aint_percent", "load_max_day", "load_max_hour", "ss7_load_avg", "traf_aint"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPContrAddInfoBean_bfd683b7
	 */
	public EJSJDBCPersisterCMPContrAddInfoBean_bfd683b7() throws java.rmi.RemoteException {
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
		ContrAddInfoBean b = (ContrAddInfoBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[11];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.act_date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.act_date);
			}
			if (b.acc_load == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.acc_load.intValue());
			}
			cacheData[0] = b.acc_load;
			if (b.bad_cunsr_percent == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.bad_cunsr_percent);
			}
			cacheData[1] = b.bad_cunsr_percent;
			if (b.bad_cunssr_percent == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.bad_cunssr_percent);
			}
			cacheData[2] = b.bad_cunssr_percent;
			if (b.cap_use_percent == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.cap_use_percent);
			}
			cacheData[3] = b.cap_use_percent;
			if (b.conn_lost_avg == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.conn_lost_avg.intValue());
			}
			cacheData[4] = b.conn_lost_avg;
			if (b.koef_kk == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.koef_kk);
			}
			cacheData[5] = b.koef_kk;
			if (b.load_aint_percent == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.load_aint_percent);
			}
			cacheData[6] = b.load_aint_percent;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_day);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[8] = objectTemp;
			if (b.ss7_load_avg == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.ss7_load_avg);
			}
			cacheData[9] = b.ss7_load_avg;
			if (b.traf_aint == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.traf_aint.intValue());
			}
			cacheData[10] = b.traf_aint;
			if (b.controller_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.controller_storageplace.intValue());
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
		ContrAddInfoBean b = (ContrAddInfoBean) eb;
		com.hps.july.persistence.ContrAddInfoKey _primaryKey = (com.hps.july.persistence.ContrAddInfoKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.act_date = _primaryKey.act_date;
		b.controller_storageplace = _primaryKey.controller_storageplace;
		tempint = resultSet.getInt(2);
		b.acc_load = resultSet.wasNull() ? null : new Integer(tempint);
		b.bad_cunsr_percent = resultSet.getBigDecimal(3);
		b.bad_cunssr_percent = resultSet.getBigDecimal(4);
		b.cap_use_percent = resultSet.getBigDecimal(5);
		tempint = resultSet.getInt(6);
		b.conn_lost_avg = resultSet.wasNull() ? null : new Integer(tempint);
		b.koef_kk = resultSet.getBigDecimal(7);
		b.load_aint_percent = resultSet.getBigDecimal(8);
		b.load_max_day = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.load_max_hour = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.ss7_load_avg = resultSet.getBigDecimal(11);
		tempint = resultSet.getInt(12);
		b.traf_aint = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		b.controller_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[11];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getBigDecimal(3);
		cacheData[2] = resultSet.getBigDecimal(4);
		cacheData[3] = resultSet.getBigDecimal(5);
		tempint = resultSet.getInt(6);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[5] = resultSet.getBigDecimal(7);
		cacheData[6] = resultSet.getBigDecimal(8);
		cacheData[7] = resultSet.getString(9);
		cacheData[8] = resultSet.getString(10);
		cacheData[9] = resultSet.getBigDecimal(11);
		tempint = resultSet.getInt(12);
		cacheData[10] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ContrAddInfoBean b = (ContrAddInfoBean) eb;
		com.hps.july.persistence.ContrAddInfoKey _primaryKey = (com.hps.july.persistence.ContrAddInfoKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.act_date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.act_date);
			}
			if (_primaryKey.controller_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.controller_storageplace.intValue());
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
		ContrAddInfoBean b = (ContrAddInfoBean) eb;
		com.hps.july.persistence.ContrAddInfoKey _primaryKey = new com.hps.july.persistence.ContrAddInfoKey();
		_primaryKey.act_date = b.act_date;
		_primaryKey.controller_storageplace = b.controller_storageplace;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ContrAddInfoBean b = (ContrAddInfoBean) eb;
		com.hps.july.persistence.ContrAddInfoKey _primaryKey = new com.hps.july.persistence.ContrAddInfoKey();
		_primaryKey.act_date = b.act_date;
		_primaryKey.controller_storageplace = b.controller_storageplace;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.act_date == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, _primaryKey.act_date);
			}
			if (_primaryKey.controller_storageplace == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, _primaryKey.controller_storageplace.intValue());
			}
			if (b.acc_load == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.acc_load.intValue());
			}
			if (b.bad_cunsr_percent == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.bad_cunsr_percent);
			}
			if (b.bad_cunssr_percent == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.bad_cunssr_percent);
			}
			if (b.cap_use_percent == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.cap_use_percent);
			}
			if (b.conn_lost_avg == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.conn_lost_avg.intValue());
			}
			if (b.koef_kk == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.koef_kk);
			}
			if (b.load_aint_percent == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.load_aint_percent);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_day);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.load_max_hour);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.ss7_load_avg == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.ss7_load_avg);
			}
			if (b.traf_aint == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.traf_aint.intValue());
			}
			if (b.controller_storageplace == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.controller_storageplace.intValue());
			}
			int inputPos = 13;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
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
		ContrAddInfoBean b = (ContrAddInfoBean) eb;
		com.hps.july.persistence.ContrAddInfoKey _primaryKey = new com.hps.july.persistence.ContrAddInfoKey();
		_primaryKey.act_date = b.act_date;
		_primaryKey.controller_storageplace = b.controller_storageplace;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.act_date == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.act_date);
			}
			if (_primaryKey.controller_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.controller_storageplace.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
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
		com.hps.july.persistence.ContrAddInfoKey key = new com.hps.july.persistence.ContrAddInfoKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.act_date = resultSet.getDate(1);
			tempint = resultSet.getInt(13);
			key.controller_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findContrAddInfosByController
	 */
	public EJSFinder findContrAddInfosByController(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.act_date, T1.acc_load, T1.bad_cunsr_percent, T1.bad_cunssr_percent, T1.cap_use_percent, T1.conn_lost_avg, T1.koef_kk, T1.load_aint_percent, T1.load_max_day, T1.load_max_hour, T1.ss7_load_avg, T1.traf_aint, T1.equipment FROM contraddinfo  T1 WHERE T1.equipment = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storageplace);
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
	public com.hps.july.persistence.ContrAddInfo findByPrimaryKey(com.hps.july.persistence.ContrAddInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ContrAddInfo) home.activateBean(key);
	}
	/**
	 * findByEquipmentOrderByActdateAsc
	 */
	public EJSFinder findByEquipmentOrderByActdateAsc(java.lang.Integer equipment) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.act_date, T1.acc_load, T1.bad_cunsr_percent, T1.bad_cunssr_percent, T1.cap_use_percent, T1.conn_lost_avg, T1.koef_kk, T1.load_aint_percent, T1.load_max_day, T1.load_max_hour, T1.ss7_load_avg, T1.traf_aint, T1.equipment FROM contraddinfo  T1 WHERE equipment = ? ORDER BY act_date ASC");
			pstmt.setObject(1, equipment);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
