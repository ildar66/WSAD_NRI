package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseMutualContractsBean_0dc94a49
 */
public class EJSJDBCPersisterCMPLeaseMutualContractsBean_0dc94a49 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseMutualContractsBean {
	private static final String _createString = "INSERT INTO leasemutcontracts (reglament, contract, resource) VALUES (?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasemutcontracts  WHERE reglament = ? AND contract = ? AND resource = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.reglament, T1.contract, T1.resource FROM leasemutcontracts  T1 WHERE T1.reglament = ? AND T1.contract = ? AND T1.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseMutualContractsBean_0dc94a49
	 */
	public EJSJDBCPersisterCMPLeaseMutualContractsBean_0dc94a49() throws java.rmi.RemoteException {
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
		LeaseMutualContractsBean b = (LeaseMutualContractsBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[0];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.reglament_leaseDocument == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.reglament_leaseDocument.intValue());
			}
			if (b.contract_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.contract_leaseDocument.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.resource_resource.intValue());
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
		LeaseMutualContractsBean b = (LeaseMutualContractsBean) eb;
		com.hps.july.persistence.LeaseMutualContractsKey _primaryKey = (com.hps.july.persistence.LeaseMutualContractsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.reglament_leaseDocument = _primaryKey.reglament_leaseDocument;
		b.contract_leaseDocument = _primaryKey.contract_leaseDocument;
		b.resource_resource = _primaryKey.resource_resource;
		tempint = resultSet.getInt(1);
		b.reglament_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.contract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[0];
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseMutualContractsBean b = (LeaseMutualContractsBean) eb;
		com.hps.july.persistence.LeaseMutualContractsKey _primaryKey = (com.hps.july.persistence.LeaseMutualContractsKey)pKey;
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
			if (_primaryKey.contract_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.contract_leaseDocument.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.resource_resource.intValue());
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
		LeaseMutualContractsBean b = (LeaseMutualContractsBean) eb;
		com.hps.july.persistence.LeaseMutualContractsKey _primaryKey = new com.hps.july.persistence.LeaseMutualContractsKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.contract_leaseDocument = b.contract_leaseDocument;
		_primaryKey.resource_resource = b.resource_resource;
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
		LeaseMutualContractsBean b = (LeaseMutualContractsBean) eb;
		com.hps.july.persistence.LeaseMutualContractsKey _primaryKey = new com.hps.july.persistence.LeaseMutualContractsKey();
		_primaryKey.reglament_leaseDocument = b.reglament_leaseDocument;
		_primaryKey.contract_leaseDocument = b.contract_leaseDocument;
		_primaryKey.resource_resource = b.resource_resource;
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
			if (_primaryKey.contract_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.contract_leaseDocument.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.resource_resource.intValue());
			}
			int inputPos = 3;
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
		com.hps.july.persistence.LeaseMutualContractsKey key = new com.hps.july.persistence.LeaseMutualContractsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(1);
			key.reglament_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(2);
			key.contract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(3);
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
	 * findLeaseArendaAgreementsByReglament
	 */
	public EJSFinder findLeaseArendaAgreementsByReglament(java.lang.Integer argReglament) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.reglament, T1.contract, T1.resource FROM leasemutcontracts  T1 WHERE reglament = ? AND contract IN  (SELECT leasedocument FROM leasecontracts c WHERE c.contracttype = \'A\') ORDER BY contract ASC");
			pstmt.setObject(1, argReglament);
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
	public com.hps.july.persistence.LeaseMutualContracts findByPrimaryKey(com.hps.july.persistence.LeaseMutualContractsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseMutualContracts) home.activateBean(key);
	}
	/**
	 * findLeaseMutualContractsByReglament
	 */
	public EJSFinder findLeaseMutualContractsByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.reglament, T1.contract, T1.resource FROM leasemutcontracts  T1 WHERE T1.reglament = ?");
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
	 * findLeaseMutualContractsByResource
	 */
	public EJSFinder findLeaseMutualContractsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.reglament, T1.contract, T1.resource FROM leasemutcontracts  T1 WHERE T1.resource = ?");
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
	 * findLeaseMutualContractsByContract
	 */
	public EJSFinder findLeaseMutualContractsByContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.reglament, T1.contract, T1.resource FROM leasemutcontracts  T1 WHERE T1.contract = ?");
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
