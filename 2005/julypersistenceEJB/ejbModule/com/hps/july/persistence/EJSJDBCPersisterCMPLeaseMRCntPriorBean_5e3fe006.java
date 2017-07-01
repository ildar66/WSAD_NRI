package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseMRCntPriorBean_5e3fe006
 */
public class EJSJDBCPersisterCMPLeaseMRCntPriorBean_5e3fe006 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseMRCntPriorBean {
	private static final String _createString = "INSERT INTO leasemrcntprior (reglament, contract1, contract2, priority) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasemrcntprior  WHERE reglament = ? AND contract1 = ? AND contract2 = ?";
	private static final String _storeString = "UPDATE leasemrcntprior  SET priority = ? WHERE reglament = ? AND contract1 = ? AND contract2 = ?";
	private static final String _loadString = "SELECT T1.priority, T1.reglament, T1.contract1, T1.contract2 FROM leasemrcntprior  T1 WHERE T1.reglament = ? AND T1.contract1 = ? AND T1.contract2 = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"priority"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseMRCntPriorBean_5e3fe006
	 */
	public EJSJDBCPersisterCMPLeaseMRCntPriorBean_5e3fe006() throws java.rmi.RemoteException {
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
		LeaseMRCntPriorBean b = (LeaseMRCntPriorBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.priority == null) {
				pstmt.setNull(4, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(4, b.priority.shortValue());
			}
			cacheData[0] = b.priority;
			if (b.reglament_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.reglament_leaseDocument.intValue());
			}
			if (b.contract1_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.contract1_leaseDocument.intValue());
			}
			if (b.contract2_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.contract2_leaseDocument.intValue());
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
		LeaseMRCntPriorBean b = (LeaseMRCntPriorBean) eb;
		com.hps.july.persistence.LeaseMRCntPriorKey _primaryKey = (com.hps.july.persistence.LeaseMRCntPriorKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.reglament_leaseDocument = _primaryKey.reglament_leaseDocument;
		b.contract1_leaseDocument = _primaryKey.contract1_leaseDocument;
		b.contract2_leaseDocument = _primaryKey.contract2_leaseDocument;
		tempshort = resultSet.getShort(1);
		b.priority = resultSet.wasNull() ? null : new Short(tempshort);
		tempint = resultSet.getInt(2);
		b.reglament_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.contract1_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.contract2_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		tempshort = resultSet.getShort(1);
		cacheData[0] = resultSet.wasNull() ? null : new Short(tempshort);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseMRCntPriorBean b = (LeaseMRCntPriorBean) eb;
		com.hps.july.persistence.LeaseMRCntPriorKey _primaryKey = (com.hps.july.persistence.LeaseMRCntPriorKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.reglament_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.reglament_leaseDocument.intValue());
			}
			if (_primaryKey.contract1_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.contract1_leaseDocument.intValue());
			}
			if (_primaryKey.contract2_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.contract2_leaseDocument.intValue());
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
		LeaseMRCntPriorBean b = (LeaseMRCntPriorBean) eb;
		com.hps.july.persistence.LeaseMRCntPriorKey _primaryKey = new com.hps.july.persistence.LeaseMRCntPriorKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.contract1_leaseDocument = b.contract1_leaseDocument;
		_primaryKey.contract2_leaseDocument = b.contract2_leaseDocument;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseMRCntPriorBean b = (LeaseMRCntPriorBean) eb;
		com.hps.july.persistence.LeaseMRCntPriorKey _primaryKey = new com.hps.july.persistence.LeaseMRCntPriorKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.contract1_leaseDocument = b.contract1_leaseDocument;
		_primaryKey.contract2_leaseDocument = b.contract2_leaseDocument;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.reglament_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.reglament_leaseDocument.intValue());
			}
			if (_primaryKey.contract1_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.contract1_leaseDocument.intValue());
			}
			if (_primaryKey.contract2_leaseDocument == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, _primaryKey.contract2_leaseDocument.intValue());
			}
			if (b.priority == null) {
				pstmt.setNull(1, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(1, b.priority.shortValue());
			}
			if (b.reglament_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.reglament_leaseDocument.intValue());
			}
			if (b.contract1_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.contract1_leaseDocument.intValue());
			}
			if (b.contract2_leaseDocument == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.contract2_leaseDocument.intValue());
			}
			int inputPos = 4;
			if (cacheData[0] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[0]).shortValue());
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
		LeaseMRCntPriorBean b = (LeaseMRCntPriorBean) eb;
		com.hps.july.persistence.LeaseMRCntPriorKey _primaryKey = new com.hps.july.persistence.LeaseMRCntPriorKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.contract1_leaseDocument = b.contract1_leaseDocument;
		_primaryKey.contract2_leaseDocument = b.contract2_leaseDocument;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.reglament_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.reglament_leaseDocument.intValue());
			}
			if (_primaryKey.contract1_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.contract1_leaseDocument.intValue());
			}
			if (_primaryKey.contract2_leaseDocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.contract2_leaseDocument.intValue());
			}
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[0]).shortValue());
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
		com.hps.july.persistence.LeaseMRCntPriorKey key = new com.hps.july.persistence.LeaseMRCntPriorKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.reglament_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
			key.contract1_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(4);
			key.contract2_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findLeaseMRCntPriors2ByContract2
	 */
	public EJSFinder findLeaseMRCntPriors2ByContract2(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.priority, T1.reglament, T1.contract1, T1.contract2 FROM leasemrcntprior  T1 WHERE T1.contract2 = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseMRCntPrior findByPrimaryKey(com.hps.july.persistence.LeaseMRCntPriorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseMRCntPrior) home.activateBean(key);
	}
	/**
	 * findLeaseMRCntPriors1ByContract1
	 */
	public EJSFinder findLeaseMRCntPriors1ByContract1(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.priority, T1.reglament, T1.contract1, T1.contract2 FROM leasemrcntprior  T1 WHERE T1.contract1 = ?");
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
	 * findByReglamentContractOrderbyPriorityAsc
	 */
	public EJSFinder findByReglamentContractOrderbyPriorityAsc(java.lang.Integer reglament, java.lang.Integer contract1, java.lang.Integer contract2) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.priority, T1.reglament, T1.contract1, T1.contract2 FROM leasemrcntprior  T1 WHERE reglament = ? AND (contract1 = ? OR contract2 = ?) ORDER BY priority ASC");
			pstmt.setObject(1, reglament);
			pstmt.setObject(2, contract1);
			pstmt.setObject(3, contract2);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseMRCntPriorsByReglament
	 */
	public EJSFinder findLeaseMRCntPriorsByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.priority, T1.reglament, T1.contract1, T1.contract2 FROM leasemrcntprior  T1 WHERE T1.reglament = ?");
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
}
