package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseTaskStartBean_4ec6dba1
 */
public class EJSJDBCPersisterCMPLeaseTaskStartBean_4ec6dba1 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseTaskStartBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO leasetasksstarts (taskstart, enddate, date1, tasktype, startdate, date2, worker, economist, document) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasetasksstarts  WHERE taskstart = ?";
	private static final String _storeString = "UPDATE leasetasksstarts  SET enddate = ?, date1 = ?, tasktype = ?, startdate = ?, date2 = ?, worker = ?, economist = ?, document = ? WHERE taskstart = ?";
	private static final String _loadString = "SELECT T1.taskstart, T1.enddate, T1.date1, T1.tasktype, T1.startdate, T1.date2, T1.worker, T1.economist, T1.document FROM leasetasksstarts  T1 WHERE T1.taskstart = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"enddate", "date1", "tasktype", "startdate", "date2", "worker", "economist", "document"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseTaskStartBean_4ec6dba1
	 */
	public EJSJDBCPersisterCMPLeaseTaskStartBean_4ec6dba1() throws java.rmi.RemoteException {
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
		LeaseTaskStartBean b = (LeaseTaskStartBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[8];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.taskstart);
			if (b.enddate == null) {
				pstmt.setNull(2, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(2, b.enddate);
			}
			cacheData[0] = b.enddate;
			if (b.date1 == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.date1);
			}
			cacheData[1] = b.date1;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.tasktype);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			if (b.startdate == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.startdate);
			}
			cacheData[3] = b.startdate;
			if (b.date2 == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.date2);
			}
			cacheData[4] = b.date2;
			if (b.startOperator_operator == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.startOperator_operator.intValue());
			}
			cacheData[5] = b.startOperator_operator;
			if (b.economistWorker_worker == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.economistWorker_worker.intValue());
			}
			cacheData[6] = b.economistWorker_worker;
			if (b.leasedocument_leaseDocument == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.leasedocument_leaseDocument.intValue());
			}
			cacheData[7] = b.leasedocument_leaseDocument;
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
		LeaseTaskStartBean b = (LeaseTaskStartBean) eb;
		com.hps.july.persistence.LeaseTaskStartKey _primaryKey = (com.hps.july.persistence.LeaseTaskStartKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.taskstart = _primaryKey.taskstart;
		b.enddate = resultSet.getTimestamp(2);
		b.date1 = resultSet.getDate(3);
		b.tasktype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.startdate = resultSet.getTimestamp(5);
		b.date2 = resultSet.getDate(6);
		tempint = resultSet.getInt(7);
		b.startOperator_operator = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.economistWorker_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.leasedocument_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[8];
		cacheData[0] = resultSet.getTimestamp(2);
		cacheData[1] = resultSet.getDate(3);
		cacheData[2] = resultSet.getString(4);
		cacheData[3] = resultSet.getTimestamp(5);
		cacheData[4] = resultSet.getDate(6);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		cacheData[7] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseTaskStartBean b = (LeaseTaskStartBean) eb;
		com.hps.july.persistence.LeaseTaskStartKey _primaryKey = (com.hps.july.persistence.LeaseTaskStartKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.taskstart);
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
		LeaseTaskStartBean b = (LeaseTaskStartBean) eb;
		com.hps.july.persistence.LeaseTaskStartKey _primaryKey = new com.hps.july.persistence.LeaseTaskStartKey();
		_primaryKey.taskstart = b.taskstart;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseTaskStartBean b = (LeaseTaskStartBean) eb;
		com.hps.july.persistence.LeaseTaskStartKey _primaryKey = new com.hps.july.persistence.LeaseTaskStartKey();
		_primaryKey.taskstart = b.taskstart;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(9, _primaryKey.taskstart);
			if (b.enddate == null) {
				pstmt.setNull(1, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(1, b.enddate);
			}
			if (b.date1 == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.date1);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.tasktype);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.startdate == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.startdate);
			}
			if (b.date2 == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.date2);
			}
			if (b.startOperator_operator == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.startOperator_operator.intValue());
			}
			if (b.economistWorker_worker == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.economistWorker_worker.intValue());
			}
			if (b.leasedocument_leaseDocument == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.leasedocument_leaseDocument.intValue());
			}
			int inputPos = 9;
			if (cacheData[0] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
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
		LeaseTaskStartBean b = (LeaseTaskStartBean) eb;
		com.hps.july.persistence.LeaseTaskStartKey _primaryKey = new com.hps.july.persistence.LeaseTaskStartKey();
		_primaryKey.taskstart = b.taskstart;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.taskstart);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
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
		com.hps.july.persistence.LeaseTaskStartKey key = new com.hps.july.persistence.LeaseTaskStartKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.taskstart = resultSet.getInt(1);
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
	 * findLeaseTaskStartsByLeasedocument
	 */
	public EJSFinder findLeaseTaskStartsByLeasedocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.taskstart, T1.enddate, T1.date1, T1.tasktype, T1.startdate, T1.date2, T1.worker, T1.economist, T1.document FROM leasetasksstarts  T1 WHERE T1.document = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
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
	public EJSFinder findByQBE(java.lang.Boolean isStartDate, java.sql.Date beginStartDate, java.sql.Date endStartDate, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Boolean isTaskType, java.lang.String taskType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isStartDate, beginStartDate, endStartDate, isWorker, worker, isTaskType, taskType, order);
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
	public com.hps.july.persistence.LeaseTaskStart findByPrimaryKey(com.hps.july.persistence.LeaseTaskStartKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseTaskStart) home.activateBean(key);
	}
	/**
	 * findLeaseTaskStartsByStartOperator
	 */
	public EJSFinder findLeaseTaskStartsByStartOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.taskstart, T1.enddate, T1.date1, T1.tasktype, T1.startdate, T1.date2, T1.worker, T1.economist, T1.document FROM leasetasksstarts  T1 WHERE T1.worker = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.operator);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseTaskStartEconomistsByEconomistWorker
	 */
	public EJSFinder findLeaseTaskStartEconomistsByEconomistWorker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.taskstart, T1.enddate, T1.date1, T1.tasktype, T1.startdate, T1.date2, T1.worker, T1.economist, T1.document FROM leasetasksstarts  T1 WHERE T1.economist = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.worker);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Boolean isTaskType, java.lang.String taskType, java.lang.Boolean isDocument, java.lang.Integer document, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(isTaskType, taskType, isDocument, document, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.taskstart, T1.enddate, T1.date1, T1.tasktype, T1.startdate, T1.date2, T1.worker, T1.economist, T1.document FROM leasetasksstarts  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {149};
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
	private LeaseTaskStartBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseTaskStartBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseTaskStartBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseTaskStartBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
