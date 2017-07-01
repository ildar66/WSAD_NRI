package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEDocPosNriBean_b724c6bf
 */
public class EJSJDBCPersisterCMPPIEDocPosNriBean_b724c6bf extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEDocPosNriBean {
	private static final String _createString = "INSERT INTO pie_docposnri (idrecdocpos, price, partynum, oldstoragecard, countpolicy, serialnumplat, storagecard, idresnri, qty, partynumplat, idrecdoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_docposnri  WHERE idrecdocpos = ?";
	private static final String _storeString = "UPDATE pie_docposnri  SET price = ?, partynum = ?, oldstoragecard = ?, countpolicy = ?, serialnumplat = ?, storagecard = ?, idresnri = ?, qty = ?, partynumplat = ?, idrecdoc = ? WHERE idrecdocpos = ?";
	private static final String _loadString = "SELECT T1.idrecdocpos, T1.price, T1.partynum, T1.oldstoragecard, T1.countpolicy, T1.serialnumplat, T1.storagecard, T1.idresnri, T1.qty, T1.partynumplat, T1.idrecdoc FROM pie_docposnri  T1 WHERE T1.idrecdocpos = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"price", "partynum", "oldstoragecard", "countpolicy", "serialnumplat", "storagecard", "idresnri", "qty", "partynumplat", "idrecdoc"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEDocPosNriBean_b724c6bf
	 */
	public EJSJDBCPersisterCMPPIEDocPosNriBean_b724c6bf() throws java.rmi.RemoteException {
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
		PIEDocPosNriBean b = (PIEDocPosNriBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[10];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idrecdocpos);
			if (b.price == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.price);
			}
			cacheData[0] = b.price;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.partynum);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.oldstoragecard == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.oldstoragecard.intValue());
			}
			cacheData[2] = b.oldstoragecard;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.countpolicy);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serialnumplat);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[4] = objectTemp;
			if (b.storagecard == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.storagecard.intValue());
			}
			cacheData[5] = b.storagecard;
			pstmt.setInt(8, b.idresnri);
			cacheData[6] = new Integer(b.idresnri);
			if (b.qty == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.qty);
			}
			cacheData[7] = b.qty;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.partynumplat);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[8] = objectTemp;
			if (b.piedocnri_idrecdoc == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.piedocnri_idrecdoc.intValue());
			}
			cacheData[9] = b.piedocnri_idrecdoc;
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
		PIEDocPosNriBean b = (PIEDocPosNriBean) eb;
		com.hps.july.persistence.PIEDocPosNriKey _primaryKey = (com.hps.july.persistence.PIEDocPosNriKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idrecdocpos = _primaryKey.idrecdocpos;
		b.price = resultSet.getBigDecimal(2);
		b.partynum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(4);
		b.oldstoragecard = resultSet.wasNull() ? null : new Integer(tempint);
		b.countpolicy = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.serialnumplat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		tempint = resultSet.getInt(7);
		b.storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		b.idresnri = resultSet.getInt(8);
		b.qty = resultSet.getBigDecimal(9);
		b.partynumplat = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		tempint = resultSet.getInt(11);
		b.piedocnri_idrecdoc = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[10];
		cacheData[0] = resultSet.getBigDecimal(2);
		cacheData[1] = resultSet.getString(3);
		tempint = resultSet.getInt(4);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[3] = resultSet.getString(5);
		cacheData[4] = resultSet.getString(6);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[7] = resultSet.getBigDecimal(9);
		cacheData[8] = resultSet.getString(10);
		tempint = resultSet.getInt(11);
		cacheData[9] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEDocPosNriBean b = (PIEDocPosNriBean) eb;
		com.hps.july.persistence.PIEDocPosNriKey _primaryKey = (com.hps.july.persistence.PIEDocPosNriKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idrecdocpos);
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
		PIEDocPosNriBean b = (PIEDocPosNriBean) eb;
		com.hps.july.persistence.PIEDocPosNriKey _primaryKey = new com.hps.july.persistence.PIEDocPosNriKey();
		_primaryKey.idrecdocpos = b.idrecdocpos;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEDocPosNriBean b = (PIEDocPosNriBean) eb;
		com.hps.july.persistence.PIEDocPosNriKey _primaryKey = new com.hps.july.persistence.PIEDocPosNriKey();
		_primaryKey.idrecdocpos = b.idrecdocpos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(11, _primaryKey.idrecdocpos);
			if (b.price == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.price);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.partynum);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.oldstoragecard == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.oldstoragecard.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.countpolicy);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.serialnumplat);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.storagecard == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.storagecard.intValue());
			}
			pstmt.setInt(7, b.idresnri);
			if (b.qty == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.qty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.partynumplat);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.piedocnri_idrecdoc == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.piedocnri_idrecdoc.intValue());
			}
			int inputPos = 11;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
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
		PIEDocPosNriBean b = (PIEDocPosNriBean) eb;
		com.hps.july.persistence.PIEDocPosNriKey _primaryKey = new com.hps.july.persistence.PIEDocPosNriKey();
		_primaryKey.idrecdocpos = b.idrecdocpos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idrecdocpos);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
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
		com.hps.july.persistence.PIEDocPosNriKey key = new com.hps.july.persistence.PIEDocPosNriKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idrecdocpos = resultSet.getInt(1);
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
	public com.hps.july.persistence.PIEDocPosNri findByPrimaryKey(com.hps.july.persistence.PIEDocPosNriKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEDocPosNri) home.activateBean(key);
	}
	/**
	 * findPIEDocPosNrisByPiedocnri
	 */
	public EJSFinder findPIEDocPosNrisByPiedocnri(com.hps.july.persistence.PIEDocNriKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idrecdocpos, T1.price, T1.partynum, T1.oldstoragecard, T1.countpolicy, T1.serialnumplat, T1.storagecard, T1.idresnri, T1.qty, T1.partynumplat, T1.idrecdoc FROM pie_docposnri  T1 WHERE T1.idrecdoc = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idrecdoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
