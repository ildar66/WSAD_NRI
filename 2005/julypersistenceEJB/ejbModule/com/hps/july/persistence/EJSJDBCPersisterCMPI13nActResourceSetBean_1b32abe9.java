package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPI13nActResourceSetBean_1b32abe9
 */
public class EJSJDBCPersisterCMPI13nActResourceSetBean_1b32abe9 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderI13nActResourceSetBean {
	private static final String _createString = "INSERT INTO i13nactresourceset (resource, document) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM i13nactresourceset  WHERE resource = ? AND document = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.resource, T1.document FROM i13nactresourceset  T1 WHERE T1.resource = ? AND T1.document = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPI13nActResourceSetBean_1b32abe9
	 */
	public EJSJDBCPersisterCMPI13nActResourceSetBean_1b32abe9() throws java.rmi.RemoteException {
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
		I13nActResourceSetBean b = (I13nActResourceSetBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[0];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.resource_resource == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.resource_resource.intValue());
			}
			if (b.i13nAct_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.i13nAct_document.intValue());
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
		I13nActResourceSetBean b = (I13nActResourceSetBean) eb;
		com.hps.july.persistence.I13nActResourceSetKey _primaryKey = (com.hps.july.persistence.I13nActResourceSetKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.resource_resource = _primaryKey.resource_resource;
		b.i13nAct_document = _primaryKey.i13nAct_document;
		tempint = resultSet.getInt(1);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.i13nAct_document = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[0];
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		I13nActResourceSetBean b = (I13nActResourceSetBean) eb;
		com.hps.july.persistence.I13nActResourceSetKey _primaryKey = (com.hps.july.persistence.I13nActResourceSetKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.resource_resource.intValue());
			}
			if (_primaryKey.i13nAct_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.i13nAct_document.intValue());
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
		I13nActResourceSetBean b = (I13nActResourceSetBean) eb;
		com.hps.july.persistence.I13nActResourceSetKey _primaryKey = new com.hps.july.persistence.I13nActResourceSetKey();
		_primaryKey.resource_resource = b.resource_resource;
		_primaryKey.i13nAct_document = b.i13nAct_document;
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
		I13nActResourceSetBean b = (I13nActResourceSetBean) eb;
		com.hps.july.persistence.I13nActResourceSetKey _primaryKey = new com.hps.july.persistence.I13nActResourceSetKey();
		_primaryKey.resource_resource = b.resource_resource;
		_primaryKey.i13nAct_document = b.i13nAct_document;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.resource_resource.intValue());
			}
			if (_primaryKey.i13nAct_document == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.i13nAct_document.intValue());
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
		com.hps.july.persistence.I13nActResourceSetKey key = new com.hps.july.persistence.I13nActResourceSetKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(1);
			key.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(2);
			key.i13nAct_document = resultSet.wasNull() ? null : new Integer(tempint);
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
	public com.hps.july.persistence.I13nActResourceSet findByPrimaryKey(com.hps.july.persistence.I13nActResourceSetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.I13nActResourceSet) home.activateBean(key);
	}
	/**
	 * findI13nActResourceSetByI13nAct
	 */
	public EJSFinder findI13nActResourceSetByI13nAct(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resource, T1.document FROM i13nactresourceset  T1 WHERE T1.document = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.document);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findI13nActResourceSetByResource
	 */
	public EJSFinder findI13nActResourceSetByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resource, T1.document FROM i13nactresourceset  T1 WHERE T1.resource = ?");
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
	 * findBlockingRecord
	 */
	public com.hps.july.persistence.I13nActResourceSet findBlockingRecord(java.lang.Integer argResource, java.lang.Integer argStorage, java.sql.Date docDate, java.lang.Integer argCurrentDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.I13nActResourceSet result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resource, T1.document FROM i13nactresourceset  T1 WHERE t1.resource = ? and exists (select d.document from documents d where d.document=t1.document and d.state=\"2\" and d.type=\"I\" and d.from = ? and d.blankdate >= ? and d.document not in (select dd.documentfrom from docdependencies dd where dd.type in(\"P\", \"S\") and dd.documentto = ? ))");
			pstmt.setObject(1, argResource);
			pstmt.setObject(2, argStorage);
			pstmt.setDate(3, docDate);
			pstmt.setObject(4, argCurrentDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.I13nActResourceSet)tmpFinder.nextElement();
			}
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
		finally {
			if ( tmpFinder != null ) tmpFinder.close();
		}
		if (result == null) {
			throw new javax.ejb.ObjectNotFoundException();
		}
		return result;
	}
}
