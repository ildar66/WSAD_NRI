package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPositionResponsibleWorkersBean_5cb3b8ab
 */
public class EJSJDBCPersisterCMPPositionResponsibleWorkersBean_5cb3b8ab extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO WorkResponsibility (resptype, storageplace, IdResponsibility, operator, worker, organization) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM WorkResponsibility  WHERE resptype = ? AND storageplace = ? AND IdResponsibility = ?";
	private static final String _storeString = "UPDATE WorkResponsibility  SET operator = ?, worker = ?, organization = ? WHERE resptype = ? AND storageplace = ? AND IdResponsibility = ?";
	private static final String _loadString = "SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE T1.resptype = ? AND T1.storageplace = ? AND T1.IdResponsibility = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"operator", "worker", "organization"};
	private static final boolean[] _predicateMaps = {true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPositionResponsibleWorkersBean_5cb3b8ab
	 */
	public EJSJDBCPersisterCMPPositionResponsibleWorkersBean_5cb3b8ab() throws java.rmi.RemoteException {
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
		PositionResponsibleWorkersBean b = (PositionResponsibleWorkersBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[3];
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.resptype);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.operator == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.operator.intValue());
			}
			cacheData[0] = b.operator;
			if (b.worker_worker == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.worker_worker.intValue());
			}
			cacheData[1] = b.worker_worker;
			if (b.position_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.position_storageplace.intValue());
			}
			if (b.organization_organization == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.organization_organization.intValue());
			}
			cacheData[2] = b.organization_organization;
			if (b.type_responsibilityType == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.type_responsibilityType.intValue());
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
		PositionResponsibleWorkersBean b = (PositionResponsibleWorkersBean) eb;
		com.hps.july.persistence.PositionResponsibleWorkersKey _primaryKey = (com.hps.july.persistence.PositionResponsibleWorkersKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.resptype = _primaryKey.resptype;
		b.position_storageplace = _primaryKey.position_storageplace;
		b.type_responsibilityType = _primaryKey.type_responsibilityType;
		tempint = resultSet.getInt(2);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.worker_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.position_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.organization_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.type_responsibilityType = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[3];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PositionResponsibleWorkersBean b = (PositionResponsibleWorkersBean) eb;
		com.hps.july.persistence.PositionResponsibleWorkersKey _primaryKey = (com.hps.july.persistence.PositionResponsibleWorkersKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.resptype);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (_primaryKey.position_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.position_storageplace.intValue());
			}
			if (_primaryKey.type_responsibilityType == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.type_responsibilityType.intValue());
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
		PositionResponsibleWorkersBean b = (PositionResponsibleWorkersBean) eb;
		com.hps.july.persistence.PositionResponsibleWorkersKey _primaryKey = new com.hps.july.persistence.PositionResponsibleWorkersKey();
		_primaryKey.resptype = b.resptype;
		_primaryKey.position_storageplace = b.position_storageplace;
		_primaryKey.type_responsibilityType = b.type_responsibilityType;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PositionResponsibleWorkersBean b = (PositionResponsibleWorkersBean) eb;
		com.hps.july.persistence.PositionResponsibleWorkersKey _primaryKey = new com.hps.july.persistence.PositionResponsibleWorkersKey();
		_primaryKey.resptype = b.resptype;
		_primaryKey.position_storageplace = b.position_storageplace;
		_primaryKey.type_responsibilityType = b.type_responsibilityType;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.resptype);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (_primaryKey.position_storageplace == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, _primaryKey.position_storageplace.intValue());
			}
			if (_primaryKey.type_responsibilityType == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, _primaryKey.type_responsibilityType.intValue());
			}
			if (b.operator == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.operator.intValue());
			}
			if (b.worker_worker == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.worker_worker.intValue());
			}
			if (b.position_storageplace == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.position_storageplace.intValue());
			}
			if (b.organization_organization == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.organization_organization.intValue());
			}
			if (b.type_responsibilityType == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.type_responsibilityType.intValue());
			}
			int inputPos = 6;
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
		PositionResponsibleWorkersBean b = (PositionResponsibleWorkersBean) eb;
		com.hps.july.persistence.PositionResponsibleWorkersKey _primaryKey = new com.hps.july.persistence.PositionResponsibleWorkersKey();
		_primaryKey.resptype = b.resptype;
		_primaryKey.position_storageplace = b.position_storageplace;
		_primaryKey.type_responsibilityType = b.type_responsibilityType;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(_primaryKey.resptype);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (_primaryKey.position_storageplace == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.position_storageplace.intValue());
			}
			if (_primaryKey.type_responsibilityType == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.type_responsibilityType.intValue());
			}
			int inputPos = 3;
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
		com.hps.july.persistence.PositionResponsibleWorkersKey key = new com.hps.july.persistence.PositionResponsibleWorkersKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.resptype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
			tempint = resultSet.getInt(4);
			key.position_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(6);
			key.type_responsibilityType = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findByPosition
	 */
	public EJSFinder findByPosition(java.lang.Integer argStoragePlace) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE storageplace = ?");
			pstmt.setObject(1, argStoragePlace);
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
	public EJSFinder findByQBE(java.lang.Boolean isStorageplace, java.lang.Integer storageplace, java.lang.Boolean isType, java.lang.Integer type, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isStorageplace, storageplace, isType, type, order);
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
	public com.hps.july.persistence.PositionResponsibleWorkers findByPrimaryKey(com.hps.july.persistence.PositionResponsibleWorkersKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PositionResponsibleWorkers) home.activateBean(key);
	}
	/**
	 * findPositionResponsibleWorkerByOrganization
	 */
	public EJSFinder findPositionResponsibleWorkerByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE T1.organization = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.organization);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findPositionResponsibleWorkersByType
	 */
	public EJSFinder findPositionResponsibleWorkersByType(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE T1.IdResponsibility = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.responsibilityType);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findPositionResponsibleWorkersByPosition
	 */
	public EJSFinder findPositionResponsibleWorkersByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE T1.storageplace = ?");
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
	 * findByPositionResptype
	 */
	public EJSFinder findByPositionResptype(java.lang.Integer argStoragePlace, java.lang.String argResptype) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE storageplace = ? AND resptype = ? order by organization ");
			pstmt.setObject(1, argStoragePlace);
			if (argResptype == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argResptype);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAllOrderByCodeAsc
	 */
	public EJSFinder findAllOrderByCodeAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE 1=1 order by worker asc");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findPositionResponsibleWorkersByWorker
	 */
	public EJSFinder findPositionResponsibleWorkersByWorker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE T1.worker = ?");
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
	 * findByPositionResponseType
	 */
	public EJSFinder findByPositionResponseType(java.lang.Integer argStoragePlace, java.lang.Integer argRespType) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE storageplace =? AND idresponsibility = ?");
			pstmt.setObject(1, argStoragePlace);
			pstmt.setObject(2, argRespType);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.resptype, T1.operator, T1.worker, T1.storageplace, T1.organization, T1.IdResponsibility FROM WorkResponsibility  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {132};
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
	private PositionResponsibleWorkersBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.PositionResponsibleWorkersBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.PositionResponsibleWorkersBeanFinderObject temp_finderObject = new com.hps.july.persistence.PositionResponsibleWorkersBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
