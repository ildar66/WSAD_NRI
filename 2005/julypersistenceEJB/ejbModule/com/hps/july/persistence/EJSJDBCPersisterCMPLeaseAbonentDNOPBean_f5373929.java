package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseAbonentDNOPBean_f5373929
 */
public class EJSJDBCPersisterCMPLeaseAbonentDNOPBean_f5373929 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseAbonentDNOPBean {
	private static final String _createString = "INSERT INTO leaseabonentdnop (idabonentdnop, flagworknri, sumlinkusd, recordstatus, leasebill, paypos) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leaseabonentdnop  WHERE idabonentdnop = ?";
	private static final String _storeString = "UPDATE leaseabonentdnop  SET flagworknri = ?, sumlinkusd = ?, recordstatus = ?, leasebill = ?, paypos = ? WHERE idabonentdnop = ?";
	private static final String _loadString = "SELECT T1.flagworknri, T1.sumlinkusd, T1.recordstatus, T1.idabonentdnop, T1.leasebill, T1.paypos FROM leaseabonentdnop  T1 WHERE T1.idabonentdnop = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"flagworknri", "sumlinkusd", "recordstatus", "leasebill", "paypos"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseAbonentDNOPBean_f5373929
	 */
	public EJSJDBCPersisterCMPLeaseAbonentDNOPBean_f5373929() throws java.rmi.RemoteException {
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
		LeaseAbonentDNOPBean b = (LeaseAbonentDNOPBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[5];
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworknri));
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			if (b.sumlinkusd == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.sumlinkusd);
			}
			cacheData[1] = b.sumlinkusd;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			pstmt.setInt(1, b.idabonentdnop);
			if (b.abonentbill_leasebill == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.abonentbill_leasebill.intValue());
			}
			cacheData[3] = b.abonentbill_leasebill;
			if (b.abonentpayment_paypos == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.abonentpayment_paypos.intValue());
			}
			cacheData[4] = b.abonentpayment_paypos;
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
		LeaseAbonentDNOPBean b = (LeaseAbonentDNOPBean) eb;
		com.hps.july.persistence.LeaseAbonentDNOPKey _primaryKey = (com.hps.july.persistence.LeaseAbonentDNOPKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idabonentdnop = _primaryKey.idabonentdnop;
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(1));
		b.flagworknri = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.sumlinkusd = resultSet.getBigDecimal(2);
		b.recordstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(5);
		b.abonentbill_leasebill = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.abonentpayment_paypos = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[5];
		cacheData[0] = resultSet.getString(1);
		cacheData[1] = resultSet.getBigDecimal(2);
		cacheData[2] = resultSet.getString(3);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseAbonentDNOPBean b = (LeaseAbonentDNOPBean) eb;
		com.hps.july.persistence.LeaseAbonentDNOPKey _primaryKey = (com.hps.july.persistence.LeaseAbonentDNOPKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idabonentdnop);
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
		LeaseAbonentDNOPBean b = (LeaseAbonentDNOPBean) eb;
		com.hps.july.persistence.LeaseAbonentDNOPKey _primaryKey = new com.hps.july.persistence.LeaseAbonentDNOPKey();
		_primaryKey.idabonentdnop = b.idabonentdnop;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseAbonentDNOPBean b = (LeaseAbonentDNOPBean) eb;
		com.hps.july.persistence.LeaseAbonentDNOPKey _primaryKey = new com.hps.july.persistence.LeaseAbonentDNOPKey();
		_primaryKey.idabonentdnop = b.idabonentdnop;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(6, _primaryKey.idabonentdnop);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworknri));
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.sumlinkusd == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.sumlinkusd);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.abonentbill_leasebill == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.abonentbill_leasebill.intValue());
			}
			if (b.abonentpayment_paypos == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.abonentpayment_paypos.intValue());
			}
			int inputPos = 6;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
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
		LeaseAbonentDNOPBean b = (LeaseAbonentDNOPBean) eb;
		com.hps.july.persistence.LeaseAbonentDNOPKey _primaryKey = new com.hps.july.persistence.LeaseAbonentDNOPKey();
		_primaryKey.idabonentdnop = b.idabonentdnop;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idabonentdnop);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
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
		com.hps.july.persistence.LeaseAbonentDNOPKey key = new com.hps.july.persistence.LeaseAbonentDNOPKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idabonentdnop = resultSet.getInt(4);
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
	 * findByPayPos
	 */
	public EJSFinder findByPayPos(java.lang.Integer argPayPos) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.flagworknri, T1.sumlinkusd, T1.recordstatus, T1.idabonentdnop, T1.leasebill, T1.paypos FROM leaseabonentdnop  T1 WHERE paypos = ?");
			pstmt.setObject(1, argPayPos);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPayPosLeaseBill
	 */
	public EJSFinder findByPayPosLeaseBill(java.lang.Integer argPayPos, java.lang.Integer argLeaseBill) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.flagworknri, T1.sumlinkusd, T1.recordstatus, T1.idabonentdnop, T1.leasebill, T1.paypos FROM leaseabonentdnop  T1 WHERE paypos = ? AND leasebill = ?");
			pstmt.setObject(1, argPayPos);
			pstmt.setObject(2, argLeaseBill);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByFlagWorkNRI
	 */
	public EJSFinder findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.flagworknri, T1.sumlinkusd, T1.recordstatus, T1.idabonentdnop, T1.leasebill, T1.paypos FROM leaseabonentdnop  T1 WHERE flagworknri = ?");
			if (argFlagWorkNRI == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argFlagWorkNRI);
			}
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
	public com.hps.july.persistence.LeaseAbonentDNOP findByPrimaryKey(com.hps.july.persistence.LeaseAbonentDNOPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseAbonentDNOP) home.activateBean(key);
	}
	/**
	 * findLeaseAbonentDNOPsByAbonentbill
	 */
	public EJSFinder findLeaseAbonentDNOPsByAbonentbill(com.hps.july.persistence.AbonentBillKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.flagworknri, T1.sumlinkusd, T1.recordstatus, T1.idabonentdnop, T1.leasebill, T1.paypos FROM leaseabonentdnop  T1 WHERE T1.leasebill = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leasebill);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseAbonentDNOPsByAbonentpayment
	 */
	public EJSFinder findLeaseAbonentDNOPsByAbonentpayment(com.hps.july.persistence.AbonentPaymentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.flagworknri, T1.sumlinkusd, T1.recordstatus, T1.idabonentdnop, T1.leasebill, T1.paypos FROM leaseabonentdnop  T1 WHERE T1.paypos = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.paypos);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
