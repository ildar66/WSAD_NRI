package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPChangeLogBean_7a6fd283
 */
public class EJSJDBCPersisterCMPChangeLogBean_7a6fd283 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderChangeLogBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO changeslog (logid, eventtype, objid, objtype, recdate, man) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM changeslog  WHERE logid = ?";
	private static final String _storeString = "UPDATE changeslog  SET eventtype = ?, objid = ?, objtype = ?, recdate = ?, man = ? WHERE logid = ?";
	private static final String _loadString = "SELECT T1.logid, T1.eventtype, T1.objid, T1.objtype, T1.recdate, T1.man FROM changeslog  T1 WHERE T1.logid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"eventtype", "objid", "objtype", "recdate", "man"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPChangeLogBean_7a6fd283
	 */
	public EJSJDBCPersisterCMPChangeLogBean_7a6fd283() throws java.rmi.RemoteException {
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
		ChangeLogBean b = (ChangeLogBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[5];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.logid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.eventtype);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			pstmt.setInt(3, b.objid);
			cacheData[1] = new Integer(b.objid);
			pstmt.setShort(4, b.objtype);
			cacheData[2] = new Short(b.objtype);
			if (b.recdate == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.recdate);
			}
			cacheData[3] = b.recdate;
			if (b.people_man == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.people_man.intValue());
			}
			cacheData[4] = b.people_man;
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
		ChangeLogBean b = (ChangeLogBean) eb;
		com.hps.july.persistence.ChangeLogKey _primaryKey = (com.hps.july.persistence.ChangeLogKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.logid = _primaryKey.logid;
		b.eventtype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.objid = resultSet.getInt(3);
		b.objtype = resultSet.getShort(4);
		b.recdate = resultSet.getTimestamp(5);
		tempint = resultSet.getInt(6);
		b.people_man = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[5];
		cacheData[0] = resultSet.getString(2);
		tempint = resultSet.getInt(3);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(4);
		cacheData[2] = resultSet.wasNull() ? null : new Short(tempshort);
		cacheData[3] = resultSet.getTimestamp(5);
		tempint = resultSet.getInt(6);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ChangeLogBean b = (ChangeLogBean) eb;
		com.hps.july.persistence.ChangeLogKey _primaryKey = (com.hps.july.persistence.ChangeLogKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.logid);
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
		ChangeLogBean b = (ChangeLogBean) eb;
		com.hps.july.persistence.ChangeLogKey _primaryKey = new com.hps.july.persistence.ChangeLogKey();
		_primaryKey.logid = b.logid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ChangeLogBean b = (ChangeLogBean) eb;
		com.hps.july.persistence.ChangeLogKey _primaryKey = new com.hps.july.persistence.ChangeLogKey();
		_primaryKey.logid = b.logid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(6, _primaryKey.logid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.eventtype);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			pstmt.setInt(2, b.objid);
			pstmt.setShort(3, b.objtype);
			if (b.recdate == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.recdate);
			}
			if (b.people_man == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.people_man.intValue());
			}
			int inputPos = 6;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[2]).shortValue());
			}
			if (cacheData[3] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
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
		ChangeLogBean b = (ChangeLogBean) eb;
		com.hps.july.persistence.ChangeLogKey _primaryKey = new com.hps.july.persistence.ChangeLogKey();
		_primaryKey.logid = b.logid;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.logid);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[2]).shortValue());
			}
			if (cacheData[3] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
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
		com.hps.july.persistence.ChangeLogKey key = new com.hps.july.persistence.ChangeLogKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.logid = resultSet.getInt(1);
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
	public com.hps.july.persistence.ChangeLog findByPrimaryKey(com.hps.july.persistence.ChangeLogKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ChangeLog) home.activateBean(key);
	}
	/**
	 * findChangeLogsByPeople
	 */
	public EJSFinder findChangeLogsByPeople(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.logid, T1.eventtype, T1.objid, T1.objtype, T1.recdate, T1.man FROM changeslog  T1 WHERE T1.man = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.man);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isObjtype, java.lang.Short objtype, java.lang.Boolean isObjid, java.lang.Integer objid, java.lang.Boolean isPeriod, java.sql.Timestamp dateStart, java.sql.Timestamp dateEnd, java.lang.Boolean isMan, java.lang.Integer man, java.lang.Boolean isEventtype, java.lang.String eventtype, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isObjtype, objtype, isObjid, objid, isPeriod, dateStart, dateEnd, isMan, man, isEventtype, eventtype, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.logid, T1.eventtype, T1.objid, T1.objtype, T1.recdate, T1.man FROM changeslog  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {98};
	/**
	 * getMergedPreparedStatement
	 */
	public PreparedStatement getMergedPreparedStatement(String searchCondition) throws Exception {
		StringBuffer sb = new StringBuffer(genericFindSqlString);
		for (int i = 0; i < genericFindInsertPoints.length; i++) {
		   sb.insert(genericFindInsertPoints[i], searchCondition);
		}
		return super.getPreparedStatement(sb.toString());
	}
	/**
	 * getMergedWhereCount
	 */
	public int getMergedWhereCount() {
		return genericFindInsertPoints.length;
	}
	/**
	 * getGenericFindSqlString
	 */
	public String getGenericFindSqlString() {
		return genericFindSqlString;
	}
	/**
	 * getGenericFindInsertPoints
	 */
	public int[] getGenericFindInsertPoints() {
		return genericFindInsertPoints;
	}
	private ChangeLogBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ChangeLogBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ChangeLogBeanFinderObject temp_finderObject = new com.hps.july.persistence.ChangeLogBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
