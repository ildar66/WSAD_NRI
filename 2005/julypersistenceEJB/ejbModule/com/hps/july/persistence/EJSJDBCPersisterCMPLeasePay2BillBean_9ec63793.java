package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeasePay2BillBean_9ec63793
 */
public class EJSJDBCPersisterCMPLeasePay2BillBean_9ec63793 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeasePay2BillBean {
	private static final String _createString = "INSERT INTO leasepay2bill (leasemutualact, leasecontract, record_status, flagworkpie, summusd) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasepay2bill  WHERE leasemutualact = ? AND leasecontract = ?";
	private static final String _storeString = "UPDATE leasepay2bill  SET record_status = ?, flagworkpie = ?, summusd = ? WHERE leasemutualact = ? AND leasecontract = ?";
	private static final String _loadString = "SELECT T1.leasemutualact, T1.record_status, T1.flagworkpie, T1.summusd, T1.leasecontract FROM leasepay2bill  T1 WHERE T1.leasemutualact = ? AND T1.leasecontract = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"record_status", "flagworkpie", "summusd"};
	private static final boolean[] _predicateMaps = {true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeasePay2BillBean_9ec63793
	 */
	public EJSJDBCPersisterCMPLeasePay2BillBean_9ec63793() throws java.rmi.RemoteException {
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
		LeasePay2BillBean b = (LeasePay2BillBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[3];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.leasemutualact);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworkpie));
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.sumusd == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.sumusd);
			}
			cacheData[2] = b.sumusd;
			pstmt.setInt(2, b.leasecontract);
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
		LeasePay2BillBean b = (LeasePay2BillBean) eb;
		com.hps.july.persistence.LeasePay2BillKey _primaryKey = (com.hps.july.persistence.LeasePay2BillKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.leasemutualact = _primaryKey.leasemutualact;
		b.leasecontract = _primaryKey.leasecontract;
		b.recordstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(3));
		b.flagworkpie = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.sumusd = resultSet.getBigDecimal(4);
		Object[] cacheData = new Object[3];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getBigDecimal(4);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeasePay2BillBean b = (LeasePay2BillBean) eb;
		com.hps.july.persistence.LeasePay2BillKey _primaryKey = (com.hps.july.persistence.LeasePay2BillKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leasemutualact);
			pstmt.setInt(2, _primaryKey.leasecontract);
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
		LeasePay2BillBean b = (LeasePay2BillBean) eb;
		com.hps.july.persistence.LeasePay2BillKey _primaryKey = new com.hps.july.persistence.LeasePay2BillKey();
		_primaryKey.leasemutualact = b.leasemutualact;
		_primaryKey.leasecontract = b.leasecontract;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeasePay2BillBean b = (LeasePay2BillBean) eb;
		com.hps.july.persistence.LeasePay2BillKey _primaryKey = new com.hps.july.persistence.LeasePay2BillKey();
		_primaryKey.leasemutualact = b.leasemutualact;
		_primaryKey.leasecontract = b.leasecontract;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(4, _primaryKey.leasemutualact);
			pstmt.setInt(5, _primaryKey.leasecontract);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworkpie));
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.sumusd == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.sumusd);
			}
			int inputPos = 5;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
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
		LeasePay2BillBean b = (LeasePay2BillBean) eb;
		com.hps.july.persistence.LeasePay2BillKey _primaryKey = new com.hps.july.persistence.LeasePay2BillKey();
		_primaryKey.leasemutualact = b.leasemutualact;
		_primaryKey.leasecontract = b.leasecontract;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.leasemutualact);
			pstmt.setInt(2, _primaryKey.leasecontract);
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
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
		com.hps.july.persistence.LeasePay2BillKey key = new com.hps.july.persistence.LeasePay2BillKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leasemutualact = resultSet.getInt(1);
			key.leasecontract = resultSet.getInt(5);
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
	 * findByAct
	 */
	public EJSFinder findByAct(java.lang.Integer argAct) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.leasemutualact, T1.record_status, T1.flagworkpie, T1.summusd, T1.leasecontract FROM leasepay2bill  T1 WHERE leasemutualact = ?");
			pstmt.setObject(1, argAct);
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
	public com.hps.july.persistence.LeasePay2Bill findByPrimaryKey(com.hps.july.persistence.LeasePay2BillKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeasePay2Bill) home.activateBean(key);
	}
	/**
	 * findByFlagWorkPIE
	 */
	public EJSFinder findByFlagWorkPIE(java.lang.String argFlagWorkPIE) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.leasemutualact, T1.record_status, T1.flagworkpie, T1.summusd, T1.leasecontract FROM leasepay2bill  T1 WHERE flagworkpie = ?");
			if (argFlagWorkPIE == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argFlagWorkPIE);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
