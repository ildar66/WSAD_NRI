package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseAbonentBENBean_269c14e7
 */
public class EJSJDBCPersisterCMPLeaseAbonentBENBean_269c14e7 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseAbonentBENBean {
	private static final String _createString = "INSERT INTO leaseabonentben (ben, leasedocument) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM leaseabonentben  WHERE ben = ? AND leasedocument = ?";
	private static final String _storeString = "UPDATE";
	private static final String _loadString = "SELECT T1.ben, T1.leasedocument FROM leaseabonentben  T1 WHERE T1.ben = ? AND T1.leasedocument = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseAbonentBENBean_269c14e7
	 */
	public EJSJDBCPersisterCMPLeaseAbonentBENBean_269c14e7() throws java.rmi.RemoteException {
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
		LeaseAbonentBENBean b = (LeaseAbonentBENBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[0];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setShort(1, b.ben);
			if (b.leaseabonentban_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.leaseabonentban_leaseDocument.intValue());
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
		LeaseAbonentBENBean b = (LeaseAbonentBENBean) eb;
		com.hps.july.persistence.LeaseAbonentBENKey _primaryKey = (com.hps.july.persistence.LeaseAbonentBENKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.ben = _primaryKey.ben;
		b.leaseabonentban_leaseDocument = _primaryKey.leaseabonentban_leaseDocument;
		tempint = resultSet.getInt(2);
		b.leaseabonentban_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[0];
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseAbonentBENBean b = (LeaseAbonentBENBean) eb;
		com.hps.july.persistence.LeaseAbonentBENKey _primaryKey = (com.hps.july.persistence.LeaseAbonentBENKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setShort(1, _primaryKey.ben);
			if (_primaryKey.leaseabonentban_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.leaseabonentban_leaseDocument.intValue());
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
		LeaseAbonentBENBean b = (LeaseAbonentBENBean) eb;
		com.hps.july.persistence.LeaseAbonentBENKey _primaryKey = new com.hps.july.persistence.LeaseAbonentBENKey();
		_primaryKey.ben = b.ben;
		_primaryKey.leaseabonentban_leaseDocument = b.leaseabonentban_leaseDocument;
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
		LeaseAbonentBENBean b = (LeaseAbonentBENBean) eb;
		com.hps.july.persistence.LeaseAbonentBENKey _primaryKey = new com.hps.july.persistence.LeaseAbonentBENKey();
		_primaryKey.ben = b.ben;
		_primaryKey.leaseabonentban_leaseDocument = b.leaseabonentban_leaseDocument;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setShort(1, _primaryKey.ben);
			if (_primaryKey.leaseabonentban_leaseDocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.leaseabonentban_leaseDocument.intValue());
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
		com.hps.july.persistence.LeaseAbonentBENKey key = new com.hps.july.persistence.LeaseAbonentBENKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.ben = resultSet.getShort(1);
			tempint = resultSet.getInt(2);
			key.leaseabonentban_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
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
	public com.hps.july.persistence.LeaseAbonentBEN findByPrimaryKey(com.hps.july.persistence.LeaseAbonentBENKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseAbonentBEN) home.activateBean(key);
	}
	/**
	 * findLeaseAbonentBENsByLeaseabonentban
	 */
	public EJSFinder findLeaseAbonentBENsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.ben, T1.leasedocument FROM leaseabonentben  T1 WHERE T1.leasedocument = ?");
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
	 * findByBen
	 */
	public EJSFinder findByBen(java.lang.Short argBen) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.ben, T1.leasedocument FROM leaseabonentben  T1 WHERE ben = ?");
			pstmt.setObject(1, argBen);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByLeasedocumentOrderByBenAsc
	 */
	public EJSFinder findByLeasedocumentOrderByBenAsc(java.lang.Integer argLeasedocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.ben, T1.leasedocument FROM leaseabonentben  T1 WHERE leasedocument = ? ORDER BY ben ASC");
			pstmt.setObject(1, argLeasedocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
