package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAbonBillpos2docposBean_d13558d4
 */
public class EJSJDBCPersisterCMPAbonBillpos2docposBean_d13558d4 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAbonBillpos2docposBean {
	private static final String _createString = "INSERT INTO informix.abonbillpos2docpos (leasedocposition, billpos) VALUES (?, ?)";
	private static final String _removeString = "DELETE FROM informix.abonbillpos2docpos  WHERE leasedocposition = ?";
	private static final String _storeString = "UPDATE informix.abonbillpos2docpos  SET billpos = ? WHERE leasedocposition = ?";
	private static final String _loadString = "SELECT T1.leasedocposition, T1.billpos FROM informix.abonbillpos2docpos  T1 WHERE T1.leasedocposition = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"billpos"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAbonBillpos2docposBean_d13558d4
	 */
	public EJSJDBCPersisterCMPAbonBillpos2docposBean_d13558d4() throws java.rmi.RemoteException {
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
		AbonBillpos2docposBean b = (AbonBillpos2docposBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.leasedocposition_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.leasedocposition_leaseDocPosition.intValue());
			}
			if (b.billpos_billpos == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.billpos_billpos.intValue());
			}
			cacheData[0] = b.billpos_billpos;
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
		AbonBillpos2docposBean b = (AbonBillpos2docposBean) eb;
		com.hps.july.persistence.AbonBillpos2docposKey _primaryKey = (com.hps.july.persistence.AbonBillpos2docposKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leasedocposition_leaseDocPosition = _primaryKey.leasedocposition_leaseDocPosition;
		tempint = resultSet.getInt(1);
		b.leasedocposition_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.billpos_billpos = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AbonBillpos2docposBean b = (AbonBillpos2docposBean) eb;
		com.hps.july.persistence.AbonBillpos2docposKey _primaryKey = (com.hps.july.persistence.AbonBillpos2docposKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.leasedocposition_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.leasedocposition_leaseDocPosition.intValue());
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
		AbonBillpos2docposBean b = (AbonBillpos2docposBean) eb;
		com.hps.july.persistence.AbonBillpos2docposKey _primaryKey = new com.hps.july.persistence.AbonBillpos2docposKey();
		_primaryKey.leasedocposition_leaseDocPosition = b.leasedocposition_leaseDocPosition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AbonBillpos2docposBean b = (AbonBillpos2docposBean) eb;
		com.hps.july.persistence.AbonBillpos2docposKey _primaryKey = new com.hps.july.persistence.AbonBillpos2docposKey();
		_primaryKey.leasedocposition_leaseDocPosition = b.leasedocposition_leaseDocPosition;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.leasedocposition_leaseDocPosition == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.leasedocposition_leaseDocPosition.intValue());
			}
			if (b.leasedocposition_leaseDocPosition == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.leasedocposition_leaseDocPosition.intValue());
			}
			if (b.billpos_billpos == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.billpos_billpos.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		AbonBillpos2docposBean b = (AbonBillpos2docposBean) eb;
		com.hps.july.persistence.AbonBillpos2docposKey _primaryKey = new com.hps.july.persistence.AbonBillpos2docposKey();
		_primaryKey.leasedocposition_leaseDocPosition = b.leasedocposition_leaseDocPosition;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.leasedocposition_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.leasedocposition_leaseDocPosition.intValue());
			}
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
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
		com.hps.july.persistence.AbonBillpos2docposKey key = new com.hps.july.persistence.AbonBillpos2docposKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(1);
			key.leasedocposition_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findAbonBillpos2docposByLeasedocposition
	 */
	public com.hps.july.persistence.AbonBillpos2docpos findAbonBillpos2docposByLeasedocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.AbonBillpos2docpos result = null;
		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.leasedocposition, T1.billpos FROM informix.abonbillpos2docpos  T1 WHERE T1.leasedocposition = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocPosition);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.AbonBillpos2docpos)tmpFinder.nextElement();
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
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonBillpos2docpos findByPrimaryKey(com.hps.july.persistence.AbonBillpos2docposKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.AbonBillpos2docpos) home.activateBean(key);
	}
	/**
	 * findAbonBillpos2docposesByBillpos
	 */
	public EJSFinder findAbonBillpos2docposesByBillpos(com.hps.july.persistence.AbonentBillPosKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.leasedocposition, T1.billpos FROM informix.abonbillpos2docpos  T1 WHERE T1.billpos = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.billpos);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
