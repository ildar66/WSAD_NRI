package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseDNOPBean_93b75ce3
 */
public class EJSJDBCPersisterCMPLeaseDNOPBean_93b75ce3 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseDNOPBean {
	private static final String _createString = "INSERT INTO leasednop (leasepayment, leasecharge, chargerurrate, chargerursum, payrursum, byhandchrgraterur, chargesum, source, usedinact, act) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasednop  WHERE leasepayment = ? AND leasecharge = ?";
	private static final String _storeString = "UPDATE leasednop  SET chargerurrate = ?, chargerursum = ?, payrursum = ?, byhandchrgraterur = ?, chargesum = ?, source = ?, usedinact = ?, act = ? WHERE leasepayment = ? AND leasecharge = ?";
	private static final String _loadString = "SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE T1.leasepayment = ? AND T1.leasecharge = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"chargerurrate", "chargerursum", "payrursum", "byhandchrgraterur", "chargesum", "source", "usedinact", "act"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseDNOPBean_93b75ce3
	 */
	public EJSJDBCPersisterCMPLeaseDNOPBean_93b75ce3() throws java.rmi.RemoteException {
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
		LeaseDNOPBean b = (LeaseDNOPBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[8];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.chargerurrate == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.chargerurrate);
			}
			cacheData[0] = b.chargerurrate;
			if (b.chargerursum == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.chargerursum);
			}
			cacheData[1] = b.chargerursum;
			if (b.payrursum == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.payrursum);
			}
			cacheData[2] = b.payrursum;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhandchangeraterur);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
			if (b.chargesum == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.chargesum);
			}
			cacheData[4] = b.chargesum;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.source);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
			if (b.usedinact == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.usedinact.intValue());
			}
			cacheData[6] = b.usedinact;
			if (b.act_leaseDocument == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.act_leaseDocument.intValue());
			}
			cacheData[7] = b.act_leaseDocument;
			if (b.leasePayment_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.leasePayment_leaseDocPosition.intValue());
			}
			if (b.leaseCharge_leaseDocPosition == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.leaseCharge_leaseDocPosition.intValue());
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
		LeaseDNOPBean b = (LeaseDNOPBean) eb;
		com.hps.july.persistence.LeaseDNOPKey _primaryKey = (com.hps.july.persistence.LeaseDNOPKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leasePayment_leaseDocPosition = _primaryKey.leasePayment_leaseDocPosition;
		b.leaseCharge_leaseDocPosition = _primaryKey.leaseCharge_leaseDocPosition;
		b.chargerurrate = resultSet.getBigDecimal(1);
		b.chargerursum = resultSet.getBigDecimal(2);
		b.payrursum = resultSet.getBigDecimal(3);
		b.byhandchangeraterur = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		b.chargesum = resultSet.getBigDecimal(5);
		b.source = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		tempint = resultSet.getInt(7);
		b.usedinact = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.act_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.leasePayment_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.leaseCharge_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[8];
		cacheData[0] = resultSet.getBigDecimal(1);
		cacheData[1] = resultSet.getBigDecimal(2);
		cacheData[2] = resultSet.getBigDecimal(3);
		cacheData[3] = resultSet.getString(4);
		cacheData[4] = resultSet.getBigDecimal(5);
		cacheData[5] = resultSet.getString(6);
		tempint = resultSet.getInt(7);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[7] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseDNOPBean b = (LeaseDNOPBean) eb;
		com.hps.july.persistence.LeaseDNOPKey _primaryKey = (com.hps.july.persistence.LeaseDNOPKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.leasePayment_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.leasePayment_leaseDocPosition.intValue());
			}
			if (_primaryKey.leaseCharge_leaseDocPosition == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.leaseCharge_leaseDocPosition.intValue());
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
		LeaseDNOPBean b = (LeaseDNOPBean) eb;
		com.hps.july.persistence.LeaseDNOPKey _primaryKey = new com.hps.july.persistence.LeaseDNOPKey();
		_primaryKey.leasePayment_leaseDocPosition = b.leasePayment_leaseDocPosition;
		_primaryKey.leaseCharge_leaseDocPosition = b.leaseCharge_leaseDocPosition;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseDNOPBean b = (LeaseDNOPBean) eb;
		com.hps.july.persistence.LeaseDNOPKey _primaryKey = new com.hps.july.persistence.LeaseDNOPKey();
		_primaryKey.leasePayment_leaseDocPosition = b.leasePayment_leaseDocPosition;
		_primaryKey.leaseCharge_leaseDocPosition = b.leaseCharge_leaseDocPosition;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.leasePayment_leaseDocPosition == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, _primaryKey.leasePayment_leaseDocPosition.intValue());
			}
			if (_primaryKey.leaseCharge_leaseDocPosition == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, _primaryKey.leaseCharge_leaseDocPosition.intValue());
			}
			if (b.chargerurrate == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.chargerurrate);
			}
			if (b.chargerursum == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.chargerursum);
			}
			if (b.payrursum == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.payrursum);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhandchangeraterur);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.chargesum == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.chargesum);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.source);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.usedinact == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.usedinact.intValue());
			}
			if (b.act_leaseDocument == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.act_leaseDocument.intValue());
			}
			if (b.leasePayment_leaseDocPosition == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.leasePayment_leaseDocPosition.intValue());
			}
			if (b.leaseCharge_leaseDocPosition == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.leaseCharge_leaseDocPosition.intValue());
			}
			int inputPos = 10;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
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
		LeaseDNOPBean b = (LeaseDNOPBean) eb;
		com.hps.july.persistence.LeaseDNOPKey _primaryKey = new com.hps.july.persistence.LeaseDNOPKey();
		_primaryKey.leasePayment_leaseDocPosition = b.leasePayment_leaseDocPosition;
		_primaryKey.leaseCharge_leaseDocPosition = b.leaseCharge_leaseDocPosition;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.leasePayment_leaseDocPosition == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.leasePayment_leaseDocPosition.intValue());
			}
			if (_primaryKey.leaseCharge_leaseDocPosition == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.leaseCharge_leaseDocPosition.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
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
		com.hps.july.persistence.LeaseDNOPKey key = new com.hps.july.persistence.LeaseDNOPKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(9);
			key.leasePayment_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(10);
			key.leaseCharge_leaseDocPosition = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findByLeaseChargeSource
	 */
	public EJSFinder findByLeaseChargeSource(java.lang.Integer argLeaseCharge, java.lang.String argSource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE leasecharge = ? AND source = ?");
			pstmt.setObject(1, argLeaseCharge);
			if (argSource == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argSource);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseDNOPByLeaseCharge
	 */
	public EJSFinder findLeaseDNOPByLeaseCharge(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE T1.leasecharge = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocPosition);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByActAndHand
	 */
	public EJSFinder findByActAndHand(java.lang.Integer argAct, java.lang.String argHand) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE act = ? AND byhandchrgraterur = ?");
			pstmt.setObject(1, argAct);
			if (argHand == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argHand);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByActAndSource
	 */
	public EJSFinder findByActAndSource(java.lang.Integer argAct, java.lang.String argSource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE act = ? AND source = ?");
			pstmt.setObject(1, argAct);
			if (argSource == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argSource);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseDNOPPayByLeasePayment
	 */
	public EJSFinder findLeaseDNOPPayByLeasePayment(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE T1.leasepayment = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocPosition);
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
	public com.hps.july.persistence.LeaseDNOP findByPrimaryKey(com.hps.july.persistence.LeaseDNOPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseDNOP) home.activateBean(key);
	}
	/**
	 * findByLeasePaymentSource
	 */
	public EJSFinder findByLeasePaymentSource(java.lang.Integer argLeasePayment, java.lang.String argSource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE leasepayment = ? AND source = ?");
			pstmt.setObject(1, argLeasePayment);
			if (argSource == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argSource);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseDNOPsByAct
	 */
	public EJSFinder findLeaseDNOPsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE T1.act = ?");
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
	 * findByLeaseChargeOrderByLeasePayment
	 */
	public EJSFinder findByLeaseChargeOrderByLeasePayment(java.lang.Integer leaseCharge) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.chargerurrate, T1.chargerursum, T1.payrursum, T1.byhandchrgraterur, T1.chargesum, T1.source, T1.usedinact, T1.act, T1.leasepayment, T1.leasecharge FROM leasednop  T1 WHERE leasecharge = ? ORDER BY leasepayment ASC");
			pstmt.setObject(1, leaseCharge);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
